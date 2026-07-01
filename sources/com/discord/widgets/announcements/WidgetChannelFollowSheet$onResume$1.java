package com.discord.widgets.announcements;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelFollowSheet$onResume$1 extends k implements Function1<WidgetChannelFollowSheetViewModel$ViewState$Loaded, Unit> {
    public WidgetChannelFollowSheet$onResume$1(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        super(1, widgetChannelFollowSheet, WidgetChannelFollowSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/announcements/WidgetChannelFollowSheetViewModel$ViewState$Loaded;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        invoke2(widgetChannelFollowSheetViewModel$ViewState$Loaded);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelFollowSheetViewModel$ViewState$Loaded widgetChannelFollowSheetViewModel$ViewState$Loaded) {
        m.checkNotNullParameter(widgetChannelFollowSheetViewModel$ViewState$Loaded, "p1");
        WidgetChannelFollowSheet.access$configureUI((WidgetChannelFollowSheet) this.receiver, widgetChannelFollowSheetViewModel$ViewState$Loaded);
    }
}
