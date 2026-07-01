package androidx.work;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class Logger$LogcatLogger extends Logger {
    private int mLoggingLevel;

    public Logger$LogcatLogger(int i) {
        super(i);
        this.mLoggingLevel = i;
    }

    @Override // androidx.work.Logger
    public void debug(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 3) {
            if (thArr == null || thArr.length < 1) {
                Log.d(str, str2);
            } else {
                Log.d(str, str2, thArr[0]);
            }
        }
    }

    @Override // androidx.work.Logger
    public void error(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 6) {
            if (thArr == null || thArr.length < 1) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, thArr[0]);
            }
        }
    }

    @Override // androidx.work.Logger
    public void info(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 4) {
            if (thArr == null || thArr.length < 1) {
                Log.i(str, str2);
            } else {
                Log.i(str, str2, thArr[0]);
            }
        }
    }

    @Override // androidx.work.Logger
    public void verbose(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 2) {
            if (thArr == null || thArr.length < 1) {
                Log.v(str, str2);
            } else {
                Log.v(str, str2, thArr[0]);
            }
        }
    }

    @Override // androidx.work.Logger
    public void warning(String str, String str2, Throwable... thArr) {
        if (this.mLoggingLevel <= 5) {
            if (thArr == null || thArr.length < 1) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, thArr[0]);
            }
        }
    }
}
