package com.discord.widgets.auth;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetAuthLanding$onViewBoundOrOnResume$1 extends k implements Function1<WidgetAuthLandingViewModel$Event, Unit> {
    public WidgetAuthLanding$onViewBoundOrOnResume$1(WidgetAuthLanding widgetAuthLanding) {
        super(1, widgetAuthLanding, WidgetAuthLanding.class, "handleEvent", "handleEvent(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel$Event widgetAuthLandingViewModel$Event) {
        invoke2(widgetAuthLandingViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetAuthLandingViewModel$Event widgetAuthLandingViewModel$Event) {
        m.checkNotNullParameter(widgetAuthLandingViewModel$Event, "p1");
        WidgetAuthLanding.access$handleEvent((WidgetAuthLanding) this.receiver, widgetAuthLandingViewModel$Event);
    }
}
