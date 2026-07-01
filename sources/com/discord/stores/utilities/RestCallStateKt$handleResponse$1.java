package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$handleResponse$1 extends o implements Function1<Loading, Unit> {
    public static final RestCallStateKt$handleResponse$1 INSTANCE = new RestCallStateKt$handleResponse$1();

    public RestCallStateKt$handleResponse$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Loading loading) {
        invoke2(loading);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Loading loading) {
        m.checkNotNullParameter(loading, "it");
    }
}
