package com.discord.restapi;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import i0.h;
import okhttp3.RequestBody;

/* JADX INFO: compiled from: PayloadJSON.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PayloadJSON$ConverterFactory$RequestBodyConverter<T> implements h<PayloadJSON<T>, RequestBody> {
    private final h<T, RequestBody> gsonRequestBodyConverter;

    public PayloadJSON$ConverterFactory$RequestBodyConverter(h<T, RequestBody> hVar) {
        m.checkNotNullParameter(hVar, "gsonRequestBodyConverter");
        this.gsonRequestBodyConverter = hVar;
    }

    @Override // i0.h
    public /* bridge */ /* synthetic */ RequestBody convert(Object obj) {
        return convert((PayloadJSON) obj);
    }

    public RequestBody convert(PayloadJSON<T> value) {
        m.checkNotNullParameter(value, "value");
        return this.gsonRequestBodyConverter.convert((T) PayloadJSON.access$getData$p(value));
    }
}
