package com.discord.widgets.channels.threads;

import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetThreadDraftArchiveSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadDraftArchiveSheet$bindSubscriptions$1 extends k implements Function1<WidgetThreadDraftArchiveSheet$Model, Unit> {
    public WidgetThreadDraftArchiveSheet$bindSubscriptions$1(WidgetThreadDraftArchiveSheet widgetThreadDraftArchiveSheet) {
        super(1, widgetThreadDraftArchiveSheet, WidgetThreadDraftArchiveSheet.class, "configureUI", "configureUI(Lcom/discord/widgets/channels/threads/WidgetThreadDraftArchiveSheet$Model;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetThreadDraftArchiveSheet$Model widgetThreadDraftArchiveSheet$Model) {
        invoke2(widgetThreadDraftArchiveSheet$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetThreadDraftArchiveSheet$Model widgetThreadDraftArchiveSheet$Model) {
        m.checkNotNullParameter(widgetThreadDraftArchiveSheet$Model, "p1");
        WidgetThreadDraftArchiveSheet.access$configureUI((WidgetThreadDraftArchiveSheet) this.receiver, widgetThreadDraftArchiveSheet$Model);
    }
}
