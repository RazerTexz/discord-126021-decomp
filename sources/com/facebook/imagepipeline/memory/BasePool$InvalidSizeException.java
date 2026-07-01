package com.facebook.imagepipeline.memory;

import b.d.b.a.a;

/* JADX INFO: loaded from: classes3.dex */
public class BasePool$InvalidSizeException extends RuntimeException {
    /* JADX WARN: Illegal instructions before constructor call */
    public BasePool$InvalidSizeException(Object obj) {
        StringBuilder sbU = a.U("Invalid size: ");
        sbU.append(obj.toString());
        super(sbU.toString());
    }
}
