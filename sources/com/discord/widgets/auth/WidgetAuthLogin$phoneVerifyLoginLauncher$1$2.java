package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$phoneVerifyLoginLauncher$1$2 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ WidgetAuthLogin$phoneVerifyLoginLauncher$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$phoneVerifyLoginLauncher$1$2(WidgetAuthLogin$phoneVerifyLoginLauncher$1 widgetAuthLogin$phoneVerifyLoginLauncher$1) {
        super(1);
        this.this$0 = widgetAuthLogin$phoneVerifyLoginLauncher$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r4) {
        WidgetAuthLogin.login$default(this.this$0.this$0, null, false, 3, null);
    }
}
