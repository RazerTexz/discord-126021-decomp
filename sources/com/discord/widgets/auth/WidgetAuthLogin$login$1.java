package com.discord.widgets.auth;

import android.content.Context;
import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$login$1 extends o implements Function1<ModelLoginResult, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $id;
    public final /* synthetic */ String $password;
    public final /* synthetic */ WidgetAuthLogin this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLogin$login$1(WidgetAuthLogin widgetAuthLogin, String str, String str2, Context context) {
        super(1);
        this.this$0 = widgetAuthLogin;
        this.$id = str;
        this.$password = str2;
        this.$context = context;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
        invoke2(modelLoginResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelLoginResult modelLoginResult) {
        m.checkNotNullParameter(modelLoginResult, "it");
        WidgetAuthLogin.access$onLoginSuccess(this.this$0, this.$id, this.$password);
        if (!modelLoginResult.getMfa()) {
            AnalyticsTracker.INSTANCE.loginAttempt(true);
            return;
        }
        WidgetAuthMfa$Companion widgetAuthMfa$Companion = WidgetAuthMfa.Companion;
        Context context = this.$context;
        String ticket = modelLoginResult.getTicket();
        m.checkNotNull(ticket);
        widgetAuthMfa$Companion.start(context, ticket);
    }
}
