package com.facebook.imagepipeline.memory;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class BasePool$PoolSizeViolationException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    public BasePool$PoolSizeViolationException(int i, int i2, int i3, int i4) {
        StringBuilder sbW = a.W("Pool hard cap violation? Hard cap = ", i, " Used size = ", i2, " Free size = ");
        sbW.append(i3);
        sbW.append(" Request size = ");
        sbW.append(i4);
        super(sbW.toString());
    }
}
