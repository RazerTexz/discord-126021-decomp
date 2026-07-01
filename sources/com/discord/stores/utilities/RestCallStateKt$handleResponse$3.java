package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$handleResponse$3<T> extends o implements Function1<Success<? extends T>, Unit> {
    public static final RestCallStateKt$handleResponse$3 INSTANCE = new RestCallStateKt$handleResponse$3();

    public RestCallStateKt$handleResponse$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((Success) obj);
        return Unit.a;
    }

    public final void invoke(Success<? extends T> success) {
        m.checkNotNullParameter(success, "it");
    }
}
