package org.example;

import static spark.Spark.*;
/*
PARA CORRER HAY QUE ABRIR 3 CMD DE LOGSERVICE

set PORT=4568
set PORT=4569
set PORT=4570


para cada cmd:


mvn exec:java
mvn exec:java
mvn exec:java


LUEGO ABRIR UN CMD EN LOGROUNDROBIN

mvn exec:java



 */
public class Logservice {
    public static void main(String[] args) {
        port(getPort());
        get("/logservice", (req, res) -> {
            String val = req.queryParams("value");
            return logMessage(val);
        });
    }

    private static String logMessage(String val){
        //implement connection to mongo
        return """
               {
               "m1":"mensaj1",
               "m2":"mensaj2",
               "m3":"mensaj3"
               }
               """;
    }

    private static int getPort(){
        if(System.getenv("PORT") != null ){
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4568;
    }
}