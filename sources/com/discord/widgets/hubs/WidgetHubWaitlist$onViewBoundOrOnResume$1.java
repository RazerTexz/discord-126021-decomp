package com.discord.widgets.hubs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubWaitlist.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubWaitlist$onViewBoundOrOnResume$1 extends o implements Function1<HubWaitlistState, Unit> {
    public final /* synthetic */ WidgetHubWaitlist this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubWaitlist$onViewBoundOrOnResume$1(WidgetHubWaitlist widgetHubWaitlist) {
        super(1);
        this.this$0 = widgetHubWaitlist;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubWaitlistState hubWaitlistState) {
        invoke2(hubWaitlistState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubWaitlistState hubWaitlistState) {
        m.checkNotNullParameter(hubWaitlistState, "it");
        WidgetHubWaitlist.access$configureUI(this.this$0, hubWaitlistState);
    }
}
