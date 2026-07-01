package com.discord.widgets.auth;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLanding$onViewBound$1 extends k implements Function1<WidgetAuthLandingViewModel$ViewState, Unit> {
    public WidgetAuthLanding$onViewBound$1(WidgetAuthLanding widgetAuthLanding) {
        super(1, widgetAuthLanding, WidgetAuthLanding.class, "configureUI", "configureUI(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel$ViewState widgetAuthLandingViewModel$ViewState) {
        invoke2(widgetAuthLandingViewModel$ViewState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthLandingViewModel$ViewState widgetAuthLandingViewModel$ViewState) {
        m.checkNotNullParameter(widgetAuthLandingViewModel$ViewState, "p1");
        WidgetAuthLanding.access$configureUI((WidgetAuthLanding) this.receiver, widgetAuthLandingViewModel$ViewState);
    }
}
