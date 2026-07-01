package com.discord.stores.utilities;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$handleResponse$2<T> extends o implements Function1<Failure<? extends T>, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestCallStateKt$handleResponse$2(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke((Failure) obj);
        return Unit.a;
    }

    public final void invoke(Failure<? extends T> failure) {
        m.checkNotNullParameter(failure, "failure");
        new Handler(Looper.getMainLooper()).post(new RestCallStateKt$handleResponse$2$1(this, failure));
    }
}
