package org.ganglia.client4j.example;

import org.ganglia.client4j.*;

public class TestSimpleGangliaClient {
   public static void main(String[] args) throws Exception {
      String GANGLIA_GMETAD_HOST = "localhost";
      String CLUSTER_NAME = "spark-paas-dev";

      System.out.println("Testing non-interactive port:");
      ClusterStatus clusterStatus = SimpleGangliaClient.getClusterStatus(GANGLIA_GMETAD_HOST);
      System.out.println(clusterStatus);
   
      System.out.println("Testing interactive port:");
      clusterStatus = SimpleGangliaClient.getClusterStatus(GANGLIA_GMETAD_HOST,CLUSTER_NAME);
      System.out.println(clusterStatus);

      System.out.println("Host List: ");
      for (String hostname : clusterStatus.getAllHostNames()) {
         System.out.println("    " + hostname);
      }

      System.out.println("Load Average: ");
      for (HostStatus hostStatus : clusterStatus.getAllHostStatuses()) {
         System.out.println("    " + hostStatus.getName() + " " + hostStatus.getMetric("load_one"));
      }

   }
}
