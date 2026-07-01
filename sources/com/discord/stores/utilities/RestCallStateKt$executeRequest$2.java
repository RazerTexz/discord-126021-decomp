package com.discord.stores.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: RestCallState.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class RestCallStateKt$executeRequest$2 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ Function1 $resultHandler;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RestCallStateKt$executeRequest$2(Function1 function1) {
        super(1);
        this.$resultHandler = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        this.$resultHandler.invoke(new Failure(error));
    }
}
