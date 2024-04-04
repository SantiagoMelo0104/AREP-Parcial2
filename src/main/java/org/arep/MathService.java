package org.arep;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static spark.Spark.*;
public class MathService {

    static String[] pr = {"10","20","13","40","60"};

    public static void main(String... args) {

        staticFileLocation("public");
        port(getPort());
        get("hello", (req, res) -> "Hello Docker!");
        get("/list", (req, res) -> {
            String list= req.queryParams("list").toString();
            String value= req.queryParams("value").toString();
            return  linearSeacrh(list,value);
        });
        System.out.print(linearSeacrh(Arrays.toString(pr),"13"));
    }

    private static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }

    public static int linearSeacrh(String lista, String value){
        int respuesta = -1;
        lista=lista.replace("[","").replace("]","");
        List<String> list = new ArrayList<String>(Arrays.asList(lista.split(",")));
        for(int i = 0; i < list.size(); i++){
            if(list.get(i).equals(value)){
                respuesta = Integer.parseInt(String.valueOf(i));
            }
        }
        return respuesta;
    }

//    public static void prueba(){
//        System.out.println(linearSeacrh(pr, "13"));
//    }
//
//    public static void linearPrint(String[] lista, String value){
//        System.out.println( "operation:" + "binarySearch\n" +  "inputlist:" + lista +  "\nvalue:" + value + "\noutput:" + linearSeacrh( lista,value) );
//    }


}
