package com.discord.widgets.channels.permissions;

import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$guildId$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions4 extends Lambda implements Function0<Long> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions4(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(0);
        this.this$0 = widgetChannelSettingsEditPermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Long invoke() {
        return Long.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final long invoke2() {
        return this.this$0.getMostRecentIntent().getLongExtra(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, -1L);
    }
}
