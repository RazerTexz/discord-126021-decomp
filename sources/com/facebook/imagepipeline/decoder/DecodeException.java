package com.facebook.imagepipeline.decoder;

import b.f.j.j.EncodedImage2;

/* JADX INFO: loaded from: classes.dex */
public class DecodeException extends RuntimeException {
    private final EncodedImage2 mEncodedImage;

    public DecodeException(String str, EncodedImage2 encodedImage2) {
        super(str);
        this.mEncodedImage = encodedImage2;
    }

    public EncodedImage2 a() {
        return this.mEncodedImage;
    }
}
