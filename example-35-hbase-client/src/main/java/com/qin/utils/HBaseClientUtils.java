package com.qin.utils;

import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.*;
import org.apache.hadoop.hbase.util.Bytes;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
@Component
public class HBaseClientUtils {
    private static Logger logger = LoggerFactory.getLogger(HBaseClientUtils.class);

    //静态变量（成员）它是属于类的，而非属于实例对象的属性；而Spring容器管理的都是实例对象，包括它的@Autowired依赖注入的均是容器内的对象实例，
    // 所以对于static成员是不能直接使用@Autowired注入的。
    private static Admin hbaseAdmin;

    @Autowired
    public void setHbaseAdmin(Admin admin){
        HBaseClientUtils.hbaseAdmin = admin;
    }

    private HBaseClientUtils(){

    }

    /**
     * 判断表是否存在
     *
     * @param tableName 表名
     * @return true/false
     */
    public static boolean isExists(String tableName) {
        boolean tableExists = false;
        try {
            TableName table = TableName.valueOf(tableName);
            tableExists = hbaseAdmin.tableExists(table);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tableExists;
    }

    /**
     * 获取table
     * @param tableName 表名
     * @return Table
     */
    private static Table getTable(String tableName) {
        try {
            return hbaseAdmin.getConnection().getTable(TableName.valueOf(tableName));
        }catch (Exception e){
            e.printStackTrace();
            return  null;
        }
    }

    /**
     * 查询所有表名
     */
    public static List<String> getAllTableNames(){
        List<String> resultList = new ArrayList<>();
        try {
            TableName[] tableNames = hbaseAdmin.listTableNames();
            for(TableName tableName : tableNames){
                resultList.add(tableName.getNameAsString());
            }
            logger.info("查询库中所有表的表名成功");
        }catch (IOException e) {
            logger.error("获取所有表的表名失败",e);
        }

        return resultList;
    }

    /**
     * 创建hbase表和列簇
     * @param tableName   表名
     * @param columnFamily  列簇
     * @return  true：创建成功；false:创建出错
     */
    public static boolean createSingleTable (String tableName, String... columnFamily){
        try{
            //创建表，先查看表是否存在，然后在删除重新创建
            if(hbaseAdmin != null){
                return createTable(tableName, Arrays.asList(columnFamily));
            }else{
                logger.error("hbaseAdmin变量没有初始化成功");
                return false;
            }
        }catch (Exception e){
            logger.debug(MessageFormat.format("创建表失败：{0},错误信息是：{1}",tableName, e.getMessage()));
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 同时创建多张数据表
     * @param tableMap  数据表 map<表名,列簇集合>
     * @return true：创建成功；false:创建出错
     */
    public static boolean createManyTable(Map<String,List<String>> tableMap){
        try{
            if(hbaseAdmin != null){
                for (Map.Entry<String,List<String>> confEntry : tableMap.entrySet()) {
                    createTable(confEntry.getKey(), confEntry.getValue());
                }
            }
        }catch (Exception e){
            logger.error(MessageFormat.format("创建多个表出现错误：{0}", e.getMessage()));
            e.printStackTrace();
            return false;
        }

        return true;
    }


    /**
     * 创建表
     * @param tableName 表名
     * @param columnFamily 列簇
     * @return true/false
     */
    public static boolean createTable(String tableName, List<String> columnFamily) throws IOException {
        if (!isExists(tableName)) {
            //添加列簇信息至列簇描述符，
            List<ColumnFamilyDescriptor> familyDescriptors =new ArrayList<>(columnFamily.size());
            for(String column : columnFamily){
                familyDescriptors.add(ColumnFamilyDescriptorBuilder.newBuilder(Bytes.toBytes(column)).build());
            }

            //表描述符
            TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(TableName.valueOf(tableName))
                    .setColumnFamilies(familyDescriptors).build();

            //创建表
            hbaseAdmin.createTable(tableDescriptor);

            logger.info(MessageFormat.format("创建表成功：表名：{0}，列簇：{1}", tableName));
            return true;
        } else {
            logger.info(tableName + "is exists!!!");
            return false;
        }
    }

    /**
     * 删除表
     * @param tableName 表名
     */
    public  static boolean  deleteTable(String tableName){
        try{
            TableName table = TableName.valueOf(tableName);
            if(hbaseAdmin.tableExists(table)){
                //禁止使用表,然后删除表
                hbaseAdmin.disableTable(table);
                hbaseAdmin.deleteTable(table);
            }
            logger.info(MessageFormat.format("删除表成功:{0}",tableName));
            return true;
        }catch (Exception e){
            e.printStackTrace();
            logger.debug(MessageFormat.format("删除表失败：{0}，错误信息是：{1}",tableName, e.getMessage()));
            return false;
        }
    }



    /**
     * 插入or更新记录（单行单列族-单列单值)
     * @param tableName          表名
     * @param row           行号  唯一
     * @param columnFamily  列簇名称
     * @param column       列名
     * @param value       列的值
     */
        public static boolean insertSingleColumnRecords(String tableName,String row,String columnFamily,
                                                 String column,String value){
        try{
            //1、获取表对应的Table对象
            Table table = getTable(tableName);
            //2、将行、列簇、列、对应要插入的值放入Put对象中
            Put put = new Put(Bytes.toBytes(row));
            put.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(column),Bytes.toBytes(value));
            //3、调用table的put方法将数据插入
            table.put(put);
            logger.info(MessageFormat.format("添加单行单列族-单列单值数据成功：表名：{0}，列名：{1}，列值：{2}",
                    tableName,column,value));
            return true;
        }catch (Exception e){
            logger.debug(MessageFormat.format("添加单行单列族-单列单值数据失败：表名：{0}，错误信息是：{1}",
                    tableName,e.getMessage()));
            e.printStackTrace();
            return false;
        }
    }

    /**
     * 插入or 更新记录（单行单列族-多列多值)
     * @param tableName          表名
     * @param row           行号  唯一
     * @param columnFamily  列簇名称
     * @param columns       多个列
     * @param values        对应多个列的值
     */
    public static boolean insertMultiColumnRecords(String tableName,String row,String columnFamily,
                                            List<String> columns, List<String> values){
        try{
            Table table = getTable(tableName);
            Put put = new Put(Bytes.toBytes(row));
            for(int i = 0; i < columns.size(); i++){
                put.addColumn(Bytes.toBytes(columnFamily),Bytes.toBytes(columns.get(i)),Bytes.toBytes(values.get(i)));
                table.put(put);
            }
            logger.info(MessageFormat.format("添加单行单列族-多列多值数据成功：表名：{0}",tableName));
            return  true;
        }catch (Exception e){
            e.printStackTrace();
            logger.debug(MessageFormat.format("添加单行单列族-多列多值数据失败：表名：{0}；错误信息是：{1}",
                    tableName,e.getMessage()));
            return false;
        }
    }






    /**
     * 关闭流
     */
    private static void close(Admin hbaseAdmin, ResultScanner rs, Table table){
        if(hbaseAdmin != null){
            try {
                hbaseAdmin.close();
            } catch (IOException e) {
                logger.error("关闭Admin失败", e);
            }
        }
        if(rs != null){
            rs.close();
        }
        if(table != null){
            try {
                table.close();
            } catch (IOException e) {
                logger.error("关闭Table失败",e);
            }
        }
    }

}
