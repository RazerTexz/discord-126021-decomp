package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreAuthentication.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreAuthentication$init$1 extends o implements Function1<Boolean, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreAuthentication$init$1(Context context) {
        super(1);
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke2(bool);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Boolean bool) {
        Context context = this.$context;
        m.checkNotNullExpressionValue(bool, "isLoggedIn");
        context.sendBroadcast(new Intent(bool.booleanValue() ? "com.discord.broadcast.LOGGED_IN" : "com.discord.broadcast.LOGGED_OUT"));
    }
}
