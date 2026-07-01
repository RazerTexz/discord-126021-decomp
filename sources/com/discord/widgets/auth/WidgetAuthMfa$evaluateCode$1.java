package com.discord.widgets.auth;

import com.discord.models.domain.auth.ModelLoginResult;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthMfa.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthMfa$evaluateCode$1 extends o implements Function1<ModelLoginResult, Unit> {
    public static final WidgetAuthMfa$evaluateCode$1 INSTANCE = new WidgetAuthMfa$evaluateCode$1();

    public WidgetAuthMfa$evaluateCode$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelLoginResult modelLoginResult) {
        invoke2(modelLoginResult);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelLoginResult modelLoginResult) {
        AnalyticsTracker.INSTANCE.loginAttempt(true);
    }
}
