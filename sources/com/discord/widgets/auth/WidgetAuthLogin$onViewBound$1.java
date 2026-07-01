package com.discord.widgets.auth;

import com.discord.models.domain.ModelInvite;
import com.discord.utilities.analytics.AnalyticsTracker;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLogin.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLogin$onViewBound$1 extends o implements Function1<ModelInvite, Unit> {
    public static final WidgetAuthLogin$onViewBound$1 INSTANCE = new WidgetAuthLogin$onViewBound$1();

    public WidgetAuthLogin$onViewBound$1() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ModelInvite modelInvite) {
        invoke2(modelInvite);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ModelInvite modelInvite) {
        AnalyticsTracker.INSTANCE.loginViewed(modelInvite);
    }
}
