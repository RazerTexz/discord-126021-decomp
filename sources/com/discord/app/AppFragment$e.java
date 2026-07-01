package com.discord.app;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;
import rx.functions.Func0;

/* JADX INFO: compiled from: AppFragment.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AppFragment$e extends o implements Function0<Boolean> {
    public final /* synthetic */ Func0 $onBackAction;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppFragment$e(Func0 func0) {
        super(0);
        this.$onBackAction = func0;
    }

    @Override // kotlin.jvm.functions.Function0
    public Boolean invoke() {
        Object objCall = this.$onBackAction.call();
        m.checkNotNullExpressionValue(objCall, "onBackAction.call()");
        return Boolean.valueOf(((Boolean) objCall).booleanValue());
    }
}
