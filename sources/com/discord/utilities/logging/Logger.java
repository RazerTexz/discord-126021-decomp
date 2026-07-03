package com.discord.utilities.logging;

import android.util.Log;
import java.util.Map;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: Logger.kt */
/* JADX INFO: loaded from: classes2.dex */
public class Logger {
    private final String defaultTag;

    public Logger(String str) {
        C12238m.checkNotNullParameter(str, "defaultTag");
        this.defaultTag = str;
    }

    public static /* synthetic */ void d$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.mo8362d(str, th);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(Logger logger, String str, Throwable th, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        if ((i & 4) != 0) {
            map = null;
        }
        logger.mo8364e(str, th, map);
    }

    public static /* synthetic */ void i$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.mo8367i(str, th);
    }

    public static /* synthetic */ void v$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.mo8368v(str, th);
    }

    public static /* synthetic */ void w$default(Logger logger, String str, Throwable th, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
        }
        if ((i & 2) != 0) {
            th = null;
        }
        logger.mo8370w(str, th);
    }

    /* JADX INFO: renamed from: d */
    public void mo8362d(String message, Throwable throwable) {
        C12238m.checkNotNullParameter(message, "message");
        mo8361d(this.defaultTag, message, throwable);
    }

    /* JADX INFO: renamed from: e */
    public void mo8364e(String message, Throwable throwable, Map<String, String> metadata) {
        C12238m.checkNotNullParameter(message, "message");
        mo8363e(this.defaultTag, message, throwable, metadata);
    }

    public final String getDefaultTag() {
        return this.defaultTag;
    }

    /* JADX INFO: renamed from: i */
    public final void m8516i(String str) {
        i$default(this, str, null, 2, null);
    }

    /* JADX INFO: renamed from: i */
    public void mo8367i(String message, Throwable throwable) {
        C12238m.checkNotNullParameter(message, "message");
        mo8366i(this.defaultTag, message, throwable);
    }

    public void recordBreadcrumb(String message, String category) {
        C12238m.checkNotNullParameter(message, "message");
        C12238m.checkNotNullParameter(category, "category");
    }

    /* JADX INFO: renamed from: v */
    public void mo8368v(String message, Throwable throwable) {
        C12238m.checkNotNullParameter(message, "message");
        m8517v(this.defaultTag, message, throwable);
    }

    /* JADX INFO: renamed from: w */
    public void mo8370w(String message, Throwable throwable) {
        C12238m.checkNotNullParameter(message, "message");
        mo8369w(this.defaultTag, message, throwable);
    }

    /* JADX INFO: renamed from: d */
    public void mo8361d(String tag, String message, Throwable throwable) {
        C12238m.checkNotNullParameter(tag, "tag");
        C12238m.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.d(tag, message, throwable);
        } else {
            Log.d(tag, message);
        }
    }

    /* JADX INFO: renamed from: e */
    public void mo8363e(String tag, String message, Throwable throwable, Map<String, String> metadata) {
        C12238m.checkNotNullParameter(tag, "tag");
        C12238m.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.e(tag, message, throwable);
        } else {
            Log.e(tag, message);
        }
    }

    /* JADX INFO: renamed from: i */
    public void mo8366i(String tag, String message, Throwable throwable) {
        C12238m.checkNotNullParameter(tag, "tag");
        C12238m.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.i(tag, message, throwable);
        } else {
            Log.i(tag, message);
        }
    }

    /* JADX INFO: renamed from: v */
    public void m8517v(String tag, String message, Throwable throwable) {
        C12238m.checkNotNullParameter(tag, "tag");
        C12238m.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.v(tag, message, throwable);
        } else {
            Log.v(tag, message);
        }
    }

    /* JADX INFO: renamed from: w */
    public void mo8369w(String tag, String message, Throwable throwable) {
        C12238m.checkNotNullParameter(tag, "tag");
        C12238m.checkNotNullParameter(message, "message");
        if (throwable != null) {
            Log.w(tag, message, throwable);
        } else {
            Log.w(tag, message);
        }
    }

    public static /* synthetic */ void d$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.mo8361d(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: d");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void e$default(Logger logger, String str, String str2, Throwable th, Map map, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            if ((i & 8) != 0) {
                map = null;
            }
            logger.mo8363e(str, str2, th, map);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: e");
    }

    public static /* synthetic */ void i$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.mo8366i(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: i");
    }

    public static /* synthetic */ void v$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.m8517v(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: v");
    }

    public static /* synthetic */ void w$default(Logger logger, String str, String str2, Throwable th, int i, Object obj) {
        if (obj == null) {
            if ((i & 4) != 0) {
                th = null;
            }
            logger.mo8369w(str, str2, th);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: w");
    }
}
