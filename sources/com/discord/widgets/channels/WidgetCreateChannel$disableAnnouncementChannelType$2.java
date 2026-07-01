package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCreateChannel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateChannel$disableAnnouncementChannelType$2 extends Lambda implements Function0<Boolean> {
    public final /* synthetic */ WidgetCreateChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCreateChannel$disableAnnouncementChannelType$2(WidgetCreateChannel widgetCreateChannel) {
        super(0);
        this.this$0 = widgetCreateChannel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Boolean invoke() {
        return Boolean.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2() {
        return this.this$0.getMostRecentIntent().getBooleanExtra("INTENT_DISABLE_ANNOUNCEMENT_CHANNEL_TYPE", false);
    }
}
