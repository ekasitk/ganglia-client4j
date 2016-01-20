package org.ganglia.client4j;

import java.util.*;
import org.ganglia.client4j.internal.*;

public class HostStatus {
   private String name;
   private String IP;
   private long timestamp;

   private Map<String,String> metricMap;

   public HostStatus(HOST host) {
      name = host.getNAME();
      IP = host.getIP();
      timestamp = Long.parseLong(host.getREPORTED());
      metricMap = new HashMap<String,String>();
      List<METRIC> metrics = host.getMETRIC(); 
      if (metrics != null) {
         for (METRIC metric : metrics) {
            metricMap.put(metric.getNAME(),metric.getVAL());
         }
      }
   }

   public String getName() {
      return name;
   } 

   public String getIP() {
      return IP;
   }

   public String getMetric(String name) {
      return metricMap.get(name);
   }

   public String toString() {
      StringBuffer buf = new StringBuffer();
      buf.append("Host : " + name + ", " + IP + ", timestamp = " + timestamp + "\n");
      for (String key : metricMap.keySet()) {
         buf.append("   " + key + " = " + metricMap.get(key) + "\n");
      }
      return buf.toString();
   }
}

