#include <jni.h>
#include <time.h>

// from android samples
/* return current time in milliseconds */
typedef double jdouble;

jdouble Java_com_ges_dateandtime_Home_currentTime(JNIEnv * env, jobject this){

    struct timespec res;
    clock_gettime(CLOCK_REALTIME, &res);
    return 1000.0 * res.tv_sec + (double) res.tv_nsec / 1e6;

}
