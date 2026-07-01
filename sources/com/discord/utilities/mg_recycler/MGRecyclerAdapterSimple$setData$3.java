package com.discord.utilities.mg_recycler;

import com.discord.utilities.error.Error;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MGRecyclerAdapterSimple.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGRecyclerAdapterSimple$setData$3 extends o implements Function1<Error, Unit> {
    public final /* synthetic */ MGRecyclerAdapterSimple this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MGRecyclerAdapterSimple$setData$3(MGRecyclerAdapterSimple mGRecyclerAdapterSimple) {
        super(1);
        this.this$0 = mGRecyclerAdapterSimple;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "error");
        MGRecyclerAdapterSimple mGRecyclerAdapterSimple = this.this$0;
        Throwable throwable = error.getThrowable();
        m.checkNotNullExpressionValue(throwable, "error.throwable");
        MGRecyclerAdapterSimple.access$handleError(mGRecyclerAdapterSimple, throwable);
    }
}
