//
// Created by yangyu on 2019-03-10.
//

#include<jni.h>
#include<stdio.h>
#include "com_example_myapplication_JNITest.h"

JNIEXPORT jstring JNICALL Java_com_example_myapplication_JNITest_get(JNIEnv *env,jclass jclass){
return (*env)->NewStringUTF(env,"This is my first NDK Application");
}