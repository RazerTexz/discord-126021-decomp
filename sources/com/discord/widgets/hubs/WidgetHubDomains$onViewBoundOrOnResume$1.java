package com.discord.widgets.hubs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains$onViewBoundOrOnResume$1 extends o implements Function1<DomainsState, Unit> {
    public final /* synthetic */ WidgetHubDomains this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDomains$onViewBoundOrOnResume$1(WidgetHubDomains widgetHubDomains) {
        super(1);
        this.this$0 = widgetHubDomains;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DomainsState domainsState) {
        invoke2(domainsState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DomainsState domainsState) {
        WidgetHubDomains widgetHubDomains = this.this$0;
        m.checkNotNullExpressionValue(domainsState, "viewState");
        WidgetHubDomains.access$updateView(widgetHubDomains, domainsState);
    }
}
