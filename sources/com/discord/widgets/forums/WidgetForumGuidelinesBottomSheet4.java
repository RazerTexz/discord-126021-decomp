package com.discord.widgets.forums;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.forums.WidgetForumGuidelinesBottomSheet$channelId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetForumGuidelinesBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetForumGuidelinesBottomSheet4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetForumGuidelinesBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetForumGuidelinesBottomSheet4(WidgetForumGuidelinesBottomSheet widgetForumGuidelinesBottomSheet) {
        super(0);
        this.this$0 = widgetForumGuidelinesBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.requireArguments().getLong("com.discord.intent.extra.EXTRA_CHANNEL_ID");
    }
}
