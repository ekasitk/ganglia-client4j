package org.ganglia.client4j;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.ganglia.client4j.*;
import org.ganglia.client4j.internal.*;

/*
 * Work only for just one Grid 
 */
public class SimpleGangliaClient {
   
   /* 
    * Get XML status from non-interactive port (Non-HTTP)
    * @param server Hostname (port 8651) of gmetad 
    * @return ClusterStatus of the first cluster of first grid (only)
    */
   public static ClusterStatus getClusterStatus(String hostname) throws Exception {
      return getClusterStatus(hostname,8651);
   }

   /* 
    * Get XML status from non-interactive port (Non-HTTP)
    * @param server Hostname of gmetad 
    * @param port Port of gmetad (usually 8651)
    * @param name Name of the cluster to get status
    * @return ClusterStatus of the first cluster of first grid (only)
    */
   public static ClusterStatus getClusterStatus(String hostname, int port) throws Exception {
      GANGLIAXML gangliaXML = null;
      Socket socket = new Socket(hostname,port);
      JAXBContext jc = JAXBContext.newInstance(GANGLIAXML.class);
      Unmarshaller unmarshaller = jc.createUnmarshaller();
      InputStream is = socket.getInputStream();
      gangliaXML = (GANGLIAXML) unmarshaller.unmarshal(is);
      is.close();

      ClusterStatus clusterStatus = null;
      if (gangliaXML != null) {
         List<Object> objects = gangliaXML.getGRIDOrCLUSTEROrHOST();
         if (objects != null) {
            Object object = objects.get(0); 
            if (object instanceof GRID) {  // expect the first object is GRID
               GRID grid = (GRID) object;
               List<Object> objs = grid.getCLUSTEROrGRIDOrHOSTSOrMETRICS(); 
               if (objs != null) {
                  Object obj = objs.get(0);
                  if (obj instanceof CLUSTER) { // expect the first cluster only
                     CLUSTER cluster = (CLUSTER) obj;
                     clusterStatus = new ClusterStatus(cluster);
                     return clusterStatus;
                  } else {
                     throw new RuntimeException("Expect GANGLIA_XML/GRID/CLUSTER but not found");
                  }
               } 
            } else {
               throw new RuntimeException("Expect GANGLIA_XML/GRID but not found");
            }
         } 
      }

      return clusterStatus;
   }

   /* 
    * Query XML status of cluster from interactive port (via HTTP protocol)
    * @param server Hostname (port 8652) of gmetad to send query to 
    * @param name Name of the cluster to get status
    * @return ClusterStatus of "name" cluster in the first grid (only)
    */
   public static ClusterStatus getClusterStatus(String hostname, String name) throws Exception {
      return getClusterStatus(hostname,8652,name);
   }

   /* 
    * Query XML status of cluster from interactive port (via HTTP protocol)
    * @param server Hostname of gmetad to send query to 
    * @param port HTTP port of gmetad to send query to (usually 8652)
    * @param name Name of the cluster to get status
    * @return ClusterStatus of "name" cluster in the first grid (only)
    */
   public static ClusterStatus getClusterStatus(String hostname, int port, String name) throws Exception {
      URL gmetadUrl = new URL("http://" + hostname + ":" + port + "/" + name);
      HttpURLConnection conn = (HttpURLConnection) gmetadUrl.openConnection();
      conn.setRequestMethod("GET");

      int responseCode = conn.getResponseCode();
      GANGLIAXML gangliaXML = null;
      if (responseCode == HttpURLConnection.HTTP_OK) {
         JAXBContext jc = JAXBContext.newInstance(GANGLIAXML.class);
         Unmarshaller unmarshaller = jc.createUnmarshaller();
         InputStream is = conn.getInputStream();
         gangliaXML = (GANGLIAXML) unmarshaller.unmarshal(is);
         is.close();

      } else {
         BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
         String line;
         StringBuffer message = new StringBuffer();
         while ((line = in.readLine()) != null) {
            message.append(line);
         }
         in.close();
         System.err.println(message.toString());
         throw new RuntimeException("HTTP request fails with response code : " + responseCode);
      }
       
      ClusterStatus clusterStatus = null;
      if (gangliaXML != null) {
         List<Object> objects = gangliaXML.getGRIDOrCLUSTEROrHOST();
         if (objects != null) {
            Object object = objects.get(0); 
            if (object instanceof GRID) {  // expect the first object is GRID
               GRID grid = (GRID) object;
               List<Object> objs = grid.getCLUSTEROrGRIDOrHOSTSOrMETRICS(); 
               if (objs != null) {
                  Object obj = objs.get(0);
                  if (obj instanceof CLUSTER) { 
                     CLUSTER cluster = (CLUSTER) obj;
                     if (cluster.getNAME().equals(name)) {
                        clusterStatus = new ClusterStatus(cluster);
                        return clusterStatus;
                     }
                  } else {
                     throw new RuntimeException("Expect GANGLIA_XML/GRID/CLUSTER but not found");
                  }
               } 
            } else {
               throw new RuntimeException("Expect GANGLIA_XML/GRID but not found");
            }
         } 
      }

      return clusterStatus;
   }

}
