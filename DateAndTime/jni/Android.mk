LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_LDLIBS := -llog

LOCAL_MODULE    := DateAndTime
LOCAL_SRC_FILES := CurrentTime.c

include $(BUILD_SHARED_LIBRARY)  