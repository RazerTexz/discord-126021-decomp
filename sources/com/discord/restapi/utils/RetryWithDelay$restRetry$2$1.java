package com.discord.restapi.utils;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RetryWithDelay.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class RetryWithDelay$restRetry$2$1 extends k implements Function1<Throwable, Boolean> {
    public static final RetryWithDelay$restRetry$2$1 INSTANCE = new RetryWithDelay$restRetry$2$1();

    public RetryWithDelay$restRetry$2$1() {
        super(1, null, "isNetworkError", "invoke(Ljava/lang/Throwable;)Z", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Throwable th) {
        return Boolean.valueOf(invoke2(th));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Throwable th) {
        m.checkNotNullParameter(th, "p1");
        return RetryWithDelay$restRetry$1.INSTANCE.invoke2(th);
    }
}
