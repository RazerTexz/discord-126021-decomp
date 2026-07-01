package com.discord.widgets.channels.permissions;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsAddMemberSheet$channelId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberSheet3 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetChannelSettingsAddMemberSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsAddMemberSheet3(WidgetChannelSettingsAddMemberSheet widgetChannelSettingsAddMemberSheet) {
        super(0);
        this.this$0 = widgetChannelSettingsAddMemberSheet;
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
