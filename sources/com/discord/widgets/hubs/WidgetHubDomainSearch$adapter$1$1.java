package com.discord.widgets.hubs;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDomainSearch.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDomainSearch$adapter$1$1 extends k implements Function1<DomainGuildInfo, Unit> {
    public WidgetHubDomainSearch$adapter$1$1(WidgetHubDomainSearch widgetHubDomainSearch) {
        super(1, widgetHubDomainSearch, WidgetHubDomainSearch.class, "onServerClickListener", "onServerClickListener(Lcom/discord/widgets/hubs/DomainGuildInfo;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(DomainGuildInfo domainGuildInfo) {
        invoke2(domainGuildInfo);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(DomainGuildInfo domainGuildInfo) {
        m.checkNotNullParameter(domainGuildInfo, "p1");
        ((WidgetHubDomainSearch) this.receiver).onServerClickListener(domainGuildInfo);
    }
}
