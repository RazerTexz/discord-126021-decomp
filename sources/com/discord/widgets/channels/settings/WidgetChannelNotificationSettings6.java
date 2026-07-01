package com.discord.widgets.channels.settings;

import com.discord.stores.StoreStream;
import com.discord.stores.StoreUserGuildSettings;
import com.discord.widgets.channels.settings.WidgetChannelNotificationSettings;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.settings.WidgetChannelNotificationSettings$configureUI$onUnmute$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelNotificationSettings.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelNotificationSettings6 extends Lambda implements Function0<Unit> {
    public final /* synthetic */ WidgetChannelNotificationSettings.Model $this_configureUI;
    public final /* synthetic */ WidgetChannelNotificationSettings this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelNotificationSettings6(WidgetChannelNotificationSettings widgetChannelNotificationSettings, WidgetChannelNotificationSettings.Model model) {
        super(0);
        this.this$0 = widgetChannelNotificationSettings;
        this.$this_configureUI = model;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreUserGuildSettings.setChannelMuted$default(StoreStream.INSTANCE.getUserGuildSettings(), this.this$0.requireContext(), this.$this_configureUI.getChannel().getId(), false, null, 8, null);
    }
}
