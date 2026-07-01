package com.facebook.imagepipeline.decoder;

import b.f.j.j.e;

/* JADX INFO: loaded from: classes.dex */
public class DecodeException extends RuntimeException {
    private final e mEncodedImage;

    public DecodeException(String str, e eVar) {
        super(str);
        this.mEncodedImage = eVar;
    }

    public e a() {
        return this.mEncodedImage;
    }
}
