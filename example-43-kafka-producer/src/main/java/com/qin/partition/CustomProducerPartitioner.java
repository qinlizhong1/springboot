package com.qin.partition;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;
import org.apache.kafka.common.PartitionInfo;

import java.util.List;
import java.util.Map;
import java.util.Random;

//自定义分区器:固定发送给分区2
public class CustomProducerPartitioner implements Partitioner {
    @Override
    public int partition(String topic, Object key, byte[] keyBytes, Object value,
                         byte[] valueBytes, Cluster cluster) {
        List<PartitionInfo> partitions = cluster.partitionsForTopic(topic);

        /*
        int numPartitions = partitions.size();
        if (key == null) {
            Random rand = new Random();
            return rand.nextInt(numPartitions);
        }
        return Math.abs(key.hashCode() % numPartitions);
        */
        return 2;

    }

    @Override
    public void close() {

    }

    @Override
    public void configure(Map<String, ?> configs) {

    }
}
