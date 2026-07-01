package com.facebook.soloader;

import b.c.a.a0.d;
import b.d.b.a.a;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public final class SoLoader$b extends UnsatisfiedLinkError {
    /* JADX WARN: Illegal instructions before constructor call */
    public SoLoader$b(Throwable th, String str) {
        StringBuilder sbU = a.U("APK was built for a different platform. Supported ABIs: ");
        sbU.append(Arrays.toString(d.C0()));
        sbU.append(" error: ");
        sbU.append(str);
        super(sbU.toString());
        initCause(th);
    }
}
