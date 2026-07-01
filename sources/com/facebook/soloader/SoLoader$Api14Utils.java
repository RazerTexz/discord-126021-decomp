package com.facebook.soloader;

import android.annotation.TargetApi;
import b.d.b.a.a;
import b.f.m.d;
import dalvik.system.BaseDexClassLoader;

/* JADX INFO: loaded from: classes3.dex */
@d
@TargetApi(14)
public class SoLoader$Api14Utils {
    private SoLoader$Api14Utils() {
    }

    public static String a() {
        ClassLoader classLoader = SoLoader.class.getClassLoader();
        if (classLoader == null || (classLoader instanceof BaseDexClassLoader)) {
            try {
                return (String) BaseDexClassLoader.class.getMethod("getLdLibraryPath", new Class[0]).invoke((BaseDexClassLoader) classLoader, new Object[0]);
            } catch (Exception e) {
                throw new RuntimeException("Cannot call getLdLibraryPath", e);
            }
        }
        StringBuilder sbU = a.U("ClassLoader ");
        sbU.append(classLoader.getClass().getName());
        sbU.append(" should be of type BaseDexClassLoader");
        throw new IllegalStateException(sbU.toString());
    }
}
