package com.discord.widgets.hubs;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$onViewBoundOrOnResume$1 extends o implements Function1<HubDescriptionState, Unit> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$onViewBoundOrOnResume$1(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubDescriptionState hubDescriptionState) {
        invoke2(hubDescriptionState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubDescriptionState hubDescriptionState) {
        m.checkNotNullParameter(hubDescriptionState, "viewState");
        WidgetHubDescription.access$configureUI(this.this$0, hubDescriptionState);
    }
}
