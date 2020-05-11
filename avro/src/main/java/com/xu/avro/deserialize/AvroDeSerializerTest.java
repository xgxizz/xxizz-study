package com.xu.avro.deserialize;

import com.xu.avro.User;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.IOException;

//反序列化
public class AvroDeSerializerTest {
    
    public static void main(String[] args) throws IOException {
        
        DatumReader<User> userDatumReader = new SpecificDatumReader<User>(User.class);
        DataFileReader<User> dataFileReader = new DataFileReader<User>(new File("users.avro"), userDatumReader);
        User user = null;
        while (dataFileReader.hasNext()) {
            user = dataFileReader.next(user);
            System.out.println(user);
        }
    }

    /**
     程序运行结果为：
     {"name": "Tom", "favorite_number": 7, "favorite_color": null}
     {"name": "Jack", "favorite_number": 15, "favorite_color": "red"}
     {"name": "Harry", "favorite_number": 1, "favorite_color": "green"}
     */
}