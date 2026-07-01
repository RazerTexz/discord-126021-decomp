package com.discord.widgets.stage.sheet;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.stage.sheet.WidgetStageModeratorJoinBottomSheet$channelId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetStageModeratorJoinBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageModeratorJoinBottomSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetStageModeratorJoinBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageModeratorJoinBottomSheet3(WidgetStageModeratorJoinBottomSheet widgetStageModeratorJoinBottomSheet) {
        super(0);
        this.this$0 = widgetStageModeratorJoinBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getArgumentsOrDefault().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
