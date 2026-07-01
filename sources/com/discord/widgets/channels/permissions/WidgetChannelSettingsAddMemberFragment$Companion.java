package com.discord.widgets.channels.permissions;

import androidx.core.os.BundleKt;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelSettingsAddMemberFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsAddMemberFragment$Companion {
    private WidgetChannelSettingsAddMemberFragment$Companion() {
    }

    public final WidgetChannelSettingsAddMemberFragment create(long channelId, boolean showRolesWithGuildPermission) {
        WidgetChannelSettingsAddMemberFragment widgetChannelSettingsAddMemberFragment = new WidgetChannelSettingsAddMemberFragment();
        widgetChannelSettingsAddMemberFragment.setArguments(BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_CHANNEL_ID", Long.valueOf(channelId)), o.to(WidgetChannelSettingsAddMemberFragment.access$getEXTRA_SHOW_ROLES_WITH_GUILD_PERMISSION$cp(), Boolean.valueOf(showRolesWithGuildPermission))));
        return widgetChannelSettingsAddMemberFragment;
    }

    public /* synthetic */ WidgetChannelSettingsAddMemberFragment$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
