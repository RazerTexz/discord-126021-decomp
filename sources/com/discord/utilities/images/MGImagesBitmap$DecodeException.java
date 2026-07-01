package com.discord.utilities.images;

import d0.z.d.m;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$DecodeException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGImagesBitmap$DecodeException(String str) {
        super("Unable to decode image: " + str + '.');
        m.checkNotNullParameter(str, "imageUri");
    }
}
