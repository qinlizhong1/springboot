package com.qin.csv;

import cn.hutool.core.text.csv.*;
import com.qin.entity.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

//此处为了方便，所有逻辑均放在controller这层，这是不规范的，这里只是为了简流程，将重点聚焦于CSV文件读写本身的问题上
@RestController
public class CSVFileController {
    @RequestMapping("t1")
    public String test1(@RequestParam("file") String file){

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "张一", "男"));
        studentList.add(new Student(2, "李二", "女"));
        studentList.add(new Student(3, "王三", "男"));


        CsvWriter csvWriter =  CsvUtil.getWriter(file, Charset.forName("UTF-8"));
        //写入注释
        csvWriter.writeComment("这是我写入的第一个csv文件");
        csvWriter.writeLine();
        //将对象集合写入
        csvWriter.writeBeans(studentList);
        csvWriter.close();

        return "ok";
    }

    //自定义标题
    @RequestMapping("t2")
    public String test2(@RequestParam("file") String file){

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student(1, "张一", "男"));
        studentList.add(new Student(2, "李二", "女"));
        studentList.add(new Student(3, "王三", "男"));


        CsvWriter csvWriter =  CsvUtil.getWriter(file, Charset.forName("UTF-8"));
        //写入注释
        csvWriter.writeComment("这是我写入的第一个csv文件");
        csvWriter.writeLine();
        //将对象集合写入
        csvWriter.writeBeans(studentList);
        csvWriter.close();

        return "ok";
    }

    //读取CSV文件，读取test2生成的test2.csv文件
    @RequestMapping("t4")
    public String test4(@RequestParam("file") String file){

        //构建 CsvReader 对象
        CsvReader csvReader = CsvUtil.getReader();

        //进行读取
        CsvData csvData = csvReader.read(new File(file), Charset.forName("UTF-8"));
        //进行处理
        //获取相应的内容
        int rowCount = csvData.getRowCount();
        System.out.println("总共读取了:" + rowCount + "条数据");
        List<CsvRow> csvDataRows = csvData.getRows();
        for (CsvRow csvRow : csvDataRows){
            //标题行和正文行的每一行数据的不同列存放在List中，如CSV的一行数据   1,张一,男  对应 [1, 张一, 男]
            List<String> rawList = csvRow.getRawList();
            System.out.println(rawList);
        }

        return "ok";
    }
}
