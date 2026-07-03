package com.facebook.imagepipeline.decoder;

import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: loaded from: classes.dex */
public class DecodeException extends RuntimeException {
    private final C1919e mEncodedImage;

    public DecodeException(String str, C1919e c1919e) {
        super(str);
        this.mEncodedImage = c1919e;
    }

    /* JADX INFO: renamed from: a */
    public C1919e m8696a() {
        return this.mEncodedImage;
    }
}
