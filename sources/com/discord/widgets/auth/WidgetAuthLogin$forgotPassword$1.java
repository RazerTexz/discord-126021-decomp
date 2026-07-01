package com.discord.widgets.auth;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$forgotPassword$1 extends o implements Function1<Void, Unit> {
    public final /* synthetic */ String $login;
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$forgotPassword$1(WidgetAuthLogin widgetAuthLogin, String str) {
        super(1);
        this.this$0 = widgetAuthLogin;
        this.$login = str;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
        invoke2(r1);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Void r2) {
        WidgetAuthLogin.access$showEmailSentToast(this.this$0, this.$login);
    }
}
