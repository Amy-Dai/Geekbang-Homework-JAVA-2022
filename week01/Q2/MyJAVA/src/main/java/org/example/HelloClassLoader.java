package org.example;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        HelloClassLoader definedClassLoader = new HelloClassLoader();
        try {
            Class<?> definedClass = Class.forName("Hello", true, definedClassLoader);
            Object definedObj = definedClass.newInstance();
            Method definedMethod = definedClass.getMethod("hello");
            definedMethod.invoke(definedObj);
        } catch (ClassNotFoundException e) {
        } catch (InvocationTargetException e) {
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (NoSuchMethodException e) {
        }
        /*try {
            definedClassLoader.findClass("Hello").newInstance();
        } catch (InstantiationException e) {
        } catch (IllegalAccessException e) {
        } catch (ClassNotFoundException e) {
        }*/
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] helloBytes = decode();

        return defineClass(name, helloBytes, 0, helloBytes.length);
    }

    private byte[] decode() {
        byte[] allBytes = new byte[0];
        try {
            allBytes = Files.readAllBytes(Paths.get("./Hello.xlass"));
            for(int i = 0; i < allBytes.length; i++) {
                allBytes[i] = (byte)(255 - allBytes[i]);
            }
        } catch (IOException e) {
        }
        return allBytes;
    }
}
