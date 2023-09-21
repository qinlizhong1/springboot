package com.qin;

import com.qin.utils.HBaseClientUtils;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

//定义测试方法执行顺序
@TestMethodOrder(MethodOrderer.OrderAnnotation. class )
@SpringBootTest
class Example35HbaseClientApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    @Order(1)
    void testCreateSingleTable(){
        boolean res = HBaseClientUtils.createSingleTable("hbaseclient:test1", "cf1", "cf2");

        Assertions.assertEquals(true, res);
    }



    @Test
    @Order(2)
    void testsExists() {
        boolean res = HBaseClientUtils.isExists("hbaseclient:test1");
        Assertions.assertEquals(true, res);
    }




    @Test
    @Order(3)
    void TestInsertSingleColumnRecords(){
        boolean res = HBaseClientUtils.insertSingleColumnRecords("hbaseclient:test1", "row1"
                                    , "cf1", "name", "qin");
        Assertions.assertEquals(true, res);
    }






    @Test
    @Order(7)
    void testsDeleteTable() {
        boolean res = HBaseClientUtils.deleteTable("hbaseclient:test1");
        Assertions.assertEquals(true, res);
    }


}
