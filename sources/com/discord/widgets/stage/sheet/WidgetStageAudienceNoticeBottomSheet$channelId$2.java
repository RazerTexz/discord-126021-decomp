package com.discord.widgets.stage.sheet;

import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetStageAudienceNoticeBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageAudienceNoticeBottomSheet$channelId$2 extends AbstractC12240o implements Function0<Long> {
    public final /* synthetic */ WidgetStageAudienceNoticeBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetStageAudienceNoticeBottomSheet$channelId$2(WidgetStageAudienceNoticeBottomSheet widgetStageAudienceNoticeBottomSheet) {
        super(0);
        this.this$0 = widgetStageAudienceNoticeBottomSheet;
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
