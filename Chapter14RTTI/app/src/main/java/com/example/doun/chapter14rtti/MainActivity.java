package com.example.doun.chapter14rtti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public final static String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //practice14.1 见toys包
        //用Class.newInstance()来创建的类，必须带有默认的构造器

        //practice14.2 见toys包
        //可正常显示新加的Interface

        //practice14.3
//        Rhomboid rhomboid = new Rhomboid();
//        Log.d(TAG, rhomboid.toString());
//        Shape shape = rhomboid;
//        Log.d(TAG, shape.toString());
//        Rhomboid rhomboid1 = (Rhomboid) shape;
//        Log.d(TAG, rhomboid1.toString());
//        //Triangle triangle = (Triangle)shape;// java.lang.ClassCastException:
//                                            // com.example.doun.chapter14rtti.Rhomboid cannot be cast to com.example.doun.chapter14rtti.Triangle
//        //Log.d(TAG, triangle.toString());

        //practice14.4
//        Rhomboid rhomboid = new Rhomboid();
//        Log.d(TAG, rhomboid.toString());
//        Shape shape = rhomboid;
//        Log.d(TAG, shape.toString());
//        if (shape instanceof Rhomboid){
//            Rhomboid rhomboid1 = (Rhomboid) shape;
//            Log.d(TAG, rhomboid1.toString());
//        }
//        if (shape instanceof Triangle) {
//            Triangle triangle = (Triangle) shape;
//            Log.d(TAG, triangle.toString());
//        }


        //practice14.5
//        List<Shape> shapeList = Arrays.asList(new Circle(), new Rhomboid(), new Square(), new Triangle());
//        for (Shape shape : shapeList){
//            rotate(shape);
//        }

        //practice14.6 见Shapes

        //practice14.7
//        String args[] = new String[]{"com.example.doun.chapter14rtti.Gum",
//                "com.example.doun.chapter14rtti.Candy",
//                "com.example.doun.chapter14rtti.Gum",
//                "com.example.doun.chapter14rtti.Cookie"};
//        SweetShopFunc(args);

        //practice14.8 14.9
//        clan(new Circle());
//        clan(new String());
        clan(this);



    }

    public static void printInfo(Class cc) {
        System.out.println("Class name: " + cc.getName() + " is interface? [" + cc.isInterface() + "]");
        System.out.println("Simple name: " + cc.getSimpleName());
        System.out.println("Canonical name : " + cc.getCanonicalName());
        printFields(cc);
    }
    public static void printFields(Class cc) {
        Field fields[] = cc.getDeclaredFields();
        for (Field f:fields){
            System.out.println("Field: " + f.getName());
        }
    }
    public static void clan(Object o) {
        Class c = o.getClass();
        while (c != null){
            printInfo(c);
            for(Class face : c.getInterfaces())
                printInfo(face);
            Class up = c.getSuperclass();
            c = up;
            if (c!=null)
                System.out.println("-----------------superclass:"+c.getSimpleName());
        }
    }

    public static void SweetShopFunc(String[] args) {
        for (String str:args)
            try {
                Class.forName(str);
            } catch(ClassNotFoundException e) {
                System.out.println("Couldn't find "+str);
            }
    }

    void rotate(Shape shape){
        if (shape instanceof Circle) {
            return;
        }else {
            shape.rotate();
        }
    }
}