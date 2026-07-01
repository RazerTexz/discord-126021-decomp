package com.linecorp.apng.decoder;

import android.graphics.Bitmap;
import com.discord.models.domain.ModelAuditLogEntry;
import com.linecorp.apng.decoder.Apng;
import java.io.InputStream;

/* JADX INFO: compiled from: ApngDecoderJni.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ApngDecoderJni {
    public static final ApngDecoderJni INSTANCE = new ApngDecoderJni();

    static {
        System.loadLibrary("apng-drawable");
    }

    public static final native int copy(int id2, Apng.DecodeResult result);

    public static final native int decode(InputStream inputStream, Apng.DecodeResult result);

    public static final native void draw(int id2, int index, Bitmap bitmap);

    public static final native boolean isApng(InputStream inputStream);

    public static final native int recycle(int id2);
}
