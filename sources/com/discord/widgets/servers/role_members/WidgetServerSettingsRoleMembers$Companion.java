package com.discord.widgets.servers.role_members;

import androidx.core.os.BundleKt;
import com.discord.widgets.servers.WidgetServerSettingsChannels;
import d0.o;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsRoleMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsRoleMembers$Companion {
    private WidgetServerSettingsRoleMembers$Companion() {
    }

    public final WidgetServerSettingsRoleMembers newInstance(long guildRoleId, long guildId) {
        WidgetServerSettingsRoleMembers widgetServerSettingsRoleMembers = new WidgetServerSettingsRoleMembers();
        widgetServerSettingsRoleMembers.setArguments(BundleKt.bundleOf(o.to("INTENT_EXTRA_GUILD_ROLE_ID", Long.valueOf(guildRoleId)), o.to(WidgetServerSettingsChannels.INTENT_EXTRA_GUILD_ID, Long.valueOf(guildId))));
        return widgetServerSettingsRoleMembers;
    }

    public /* synthetic */ WidgetServerSettingsRoleMembers$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
