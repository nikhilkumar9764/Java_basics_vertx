package com.example.jsontesting;

import io.vertx.core.json.JsonObject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JSON_object_test {

    @Test
    void json_object_mapped()
   {
       var obj1 = new JsonObject();
       obj1.put("loves_vertex",true);
       obj1.put("name","Mohan");
       obj1.put("id",13);
       final String s1 = obj1.encode();
       System.out.println(obj1);
       assertEquals("{\"loves_vertex\":true,\"name\":\"Mohan\",\"id\":13}",s1);

       JsonObject j1 = new JsonObject(s1);
       assertEquals(j1,obj1);
       assertEquals(13,j1.getInteger("id"));
       assertEquals("Mohan",j1.getString("name"));
   }
}
