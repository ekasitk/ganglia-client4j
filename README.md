Introduction
------------

Ganglia-client4j is a java API to get the current cluster metrics from Ganglia monitoring system. If accessing the metrics from remote host, set trusted_host in gmetad.conf.

Example
-------
```java
import org.ganglia.client4j.*;

public class TestSimpleGangliaClient {
   public static void main(String[] args) throws Exception {
      String GANGLIA_GMETAD_HOST = "192.168.100.100";

      System.out.println("Testing non-interactive port");
      ClusterStatus clusterStatus = SimpleGangliaClient.getClusterStatus(GANGLIA_GMETAD_HOST);
      System.out.println(clusterStatus);

      System.out.println("Load Average: ");
      for (HostStatus hostStatus : clusterStatus.getAllHostStatuses()) {
         System.out.println("    " + hostStatus.getName() + " " + hostStatus.getMetric("load_one"));
      }
   
   }
}
```

