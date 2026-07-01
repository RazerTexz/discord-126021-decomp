package com.discord.widgets.announcements;

import androidx.fragment.app.FragmentManager;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChannelFollowSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelFollowSheet$onResume$2 extends o implements Function1<WidgetChannelFollowSheetViewModel$Event, Unit> {
    public final /* synthetic */ WidgetChannelFollowSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelFollowSheet$onResume$2(WidgetChannelFollowSheet widgetChannelFollowSheet) {
        super(1);
        this.this$0 = widgetChannelFollowSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChannelFollowSheetViewModel$Event widgetChannelFollowSheetViewModel$Event) {
        invoke2(widgetChannelFollowSheetViewModel$Event);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChannelFollowSheetViewModel$Event widgetChannelFollowSheetViewModel$Event) {
        m.checkNotNullParameter(widgetChannelFollowSheetViewModel$Event, "it");
        this.this$0.dismiss();
        WidgetChannelFollowSuccessDialog$Companion widgetChannelFollowSuccessDialog$Companion = WidgetChannelFollowSuccessDialog.Companion;
        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        widgetChannelFollowSuccessDialog$Companion.show(parentFragmentManager);
    }
}
