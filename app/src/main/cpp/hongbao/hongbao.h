//
// Created by yangyu on 2019-03-18.
//

#ifndef MYAPPLICATION_HONGBAO_H
#define MYAPPLICATION_HONGBAO_H

#endif //MYAPPLICATION_HONGBAO_H
#include <jni.h>

//声明注册方法
int registerNatives_HongBao(JNIEnv *engv);
//声明HongBao的本地方法
jint add(JNIEnv *env, jclass clazz,jint x,jint y);//HongBao类的native方法