//
// Created by yangyu on 2019-03-18.
//
#include <jni.h>
#include <string>
#include <stdlib.h>

#include "hongbao.h"   //引入hongbao.h头文件

//HongBao.java中native方法的实现体
jint add(JNIEnv *env, jclass clazz, jint x, jint y) {
    return x + y;
}

//HongBao.java中的参数映射表
static JNINativeMethod gMethods_HongBao[] = {
        {"add", "(II)I", (void *) add},
};
//注册 HongBao 中的native方法
int registerNatives_HongBao(JNIEnv *engv) {
    jclass clazz;
    clazz = engv->FindClass("com/example/myapplication/HongBao");
    if (clazz == NULL) {
        return JNI_FALSE;
    }
    if (engv->RegisterNatives(clazz, gMethods_HongBao,sizeof(gMethods_HongBao) / sizeof(gMethods_HongBao[0])) < 0) {
        return JNI_FALSE;
    }
    return JNI_TRUE;
}
