//
// Created by yangyu on 2019-03-18.
//

#ifndef MYAPPLICATION_NATIVE_LIB_H
#define MYAPPLICATION_NATIVE_LIB_H

#endif //MYAPPLICATION_NATIVE_LIB_H

static jstring stringFromJNI(JNIEnv *env, jobject jobject1);   //so层获取一个字符串

jstring setString(JNIEnv *env, jobject instance,jstring str);//so层获取带参的字符串

static jint add(JNIEnv *env, jclass clazz,jint x,jint y);//HongBao类的native方法
