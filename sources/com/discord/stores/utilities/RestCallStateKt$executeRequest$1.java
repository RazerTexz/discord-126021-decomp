package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$executeRequest$1<T> extends o implements Function1<T, Unit> {
    public final /* synthetic */ Function1 $resultHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestCallStateKt$executeRequest$1(Function1 function1) {
        super(1);
        this.$resultHandler = function1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(T t) {
        this.$resultHandler.invoke(new Success(t));
    }
}
