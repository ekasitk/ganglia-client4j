package org.ganglia.client4j;

import java.util.*;

import org.ganglia.client4j.internal.*;

public class ClusterStatus {
   private String name;
   private Map<String, HostStatus> hostStatusMap;

   public ClusterStatus(CLUSTER cluster) {
      name = cluster.getNAME();
      hostStatusMap = new HashMap<String,HostStatus>();
      List<Object> objects = cluster.getHOSTOrHOSTSOrMETRICS();
      if (objects != null) {
         for (Object object : objects) {
            if (object instanceof HOST) {
               HOST host = (HOST) object;
               HostStatus hostStatus = hostStatusMap.get(host.getNAME());
               if (hostStatus == null) {
                   hostStatus = new HostStatus((HOST) object);
               }
               hostStatusMap.put(host.getNAME(),hostStatus);
            }
         }
      }
   }

   public String getName() {
      return name;
   } 

   public HostStatus getHostStatus(String name) {
      return hostStatusMap.get(name);
   }

   public Collection<HostStatus> getAllHostStatuses() {
      return hostStatusMap.values();
   } 

   public Set<String> getAllHostNames() {
      return hostStatusMap.keySet();
   }

   public String toString() {
      StringBuffer buf = new StringBuffer();
      buf.append("Cluster : " + name + "\n");
      for (HostStatus hostStatus : hostStatusMap.values()) {
         buf.append(hostStatus.toString()); 
      }
      return buf.toString();
   }
}
