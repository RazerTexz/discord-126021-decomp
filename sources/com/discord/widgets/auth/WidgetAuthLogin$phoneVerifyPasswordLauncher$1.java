package com.discord.widgets.auth;

import com.discord.widgets.auth.WidgetAuthPhoneVerify;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$phoneVerifyPasswordLauncher$1 extends AbstractC12240o implements Function1<WidgetAuthPhoneVerify.Result, Unit> {
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$phoneVerifyPasswordLauncher$1(WidgetAuthLogin widgetAuthLogin) {
        super(1);
        this.this$0 = widgetAuthLogin;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthPhoneVerify.Result result) {
        invoke2(result);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthPhoneVerify.Result result) {
        C12238m.checkNotNullParameter(result, "result");
        if (result instanceof WidgetAuthPhoneVerify.Result.Token) {
            WidgetAuthResetPassword.INSTANCE.start(this.this$0.requireContext(), ((WidgetAuthPhoneVerify.Result.Token) result).getToken());
        }
    }
}
