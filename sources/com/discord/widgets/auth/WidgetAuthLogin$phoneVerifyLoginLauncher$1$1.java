package com.discord.widgets.auth;

import com.discord.utilities.error.Error;
import d0.z.d.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLogin$phoneVerifyLoginLauncher$1$1 extends a implements Function1<Error, Unit> {
    public WidgetAuthLogin$phoneVerifyLoginLauncher$1$1(WidgetAuthLogin widgetAuthLogin) {
        super(1, widgetAuthLogin, WidgetAuthLogin.class, "handleError", "handleError(Lcom/discord/utilities/error/Error;Ljava/lang/String;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Error error) {
        invoke2(error);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Error error) {
        m.checkNotNullParameter(error, "p1");
        WidgetAuthLogin.handleError$default((WidgetAuthLogin) this.receiver, error, null, 2, null);
    }
}
