package org.ganglia.client4j.example;

import org.ganglia.client4j.*;

public class TestSimpleGangliaClient {
   public static void main(String[] args) throws Exception {
      String GANGLIA_GMETAD_HOST = "localhost";
      String CLUSTER_NAME = "spark-paas-dev";

      ClusterStatus clusterStatus = SimpleGangliaClient.getClusterStatus(GANGLIA_GMETAD_HOST,CLUSTER_NAME);
      System.out.println(clusterStatus);

   }
}
