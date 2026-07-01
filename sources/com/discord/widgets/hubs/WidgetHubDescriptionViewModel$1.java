package com.discord.widgets.hubs;

import d0.z.d.a;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescriptionViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetHubDescriptionViewModel$1 extends a implements Function1<HubDescriptionState, Unit> {
    public WidgetHubDescriptionViewModel$1(WidgetHubDescriptionViewModel widgetHubDescriptionViewModel) {
        super(1, widgetHubDescriptionViewModel, WidgetHubDescriptionViewModel.class, "handleStoreUpdate", "handleStoreUpdate(Lcom/discord/widgets/hubs/HubDescriptionState;)Lkotlin/Unit;", 8);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(HubDescriptionState hubDescriptionState) {
        invoke2(hubDescriptionState);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(HubDescriptionState hubDescriptionState) {
        m.checkNotNullParameter(hubDescriptionState, "p1");
        WidgetHubDescriptionViewModel.access$handleStoreUpdate((WidgetHubDescriptionViewModel) this.receiver, hubDescriptionState);
    }
}
