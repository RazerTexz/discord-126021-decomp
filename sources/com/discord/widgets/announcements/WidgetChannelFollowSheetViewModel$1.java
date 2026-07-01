package com.discord.widgets.announcements;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelFollowSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheetViewModel$1 extends o implements Function1<WidgetChannelFollowSheetViewModel$ViewState$Loaded, Unit> {
    public final /* synthetic */ WidgetChannelFollowSheetViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheetViewModel$1(WidgetChannelFollowSheetViewModel widgetChannelFollowSheetViewModel) {
        super(1);
        this.this$0 = widgetChannelFollowSheetViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        invoke2(widgetChannelFollowSheetViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetChannelFollowSheetViewModel$ViewState$Loaded, "viewState");
        WidgetChannelFollowSheetViewModel.access$updateViewState(this.this$0, widgetChannelFollowSheetViewModel$ViewState$Loaded);
    }
}
