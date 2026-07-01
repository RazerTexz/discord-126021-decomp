package com.discord.utilities.images;

import d0.z.d.m;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$ImageNotFoundException extends Exception {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGImagesBitmap$ImageNotFoundException(String str) {
        super("404 image not found: " + str);
        m.checkNotNullParameter(str, "imageUri");
    }
}
