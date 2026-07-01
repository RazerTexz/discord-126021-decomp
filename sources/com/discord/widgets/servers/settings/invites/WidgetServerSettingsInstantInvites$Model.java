package com.discord.widgets.servers.settings.invites;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: WidgetServerSettingsInstantInvites.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsInstantInvites$Model {
    public static final WidgetServerSettingsInstantInvites$Model$Companion Companion = new WidgetServerSettingsInstantInvites$Model$Companion(null);
    private final Guild guild;
    private final List<WidgetServerSettingsInstantInvites$Model$InviteItem> inviteItems;

    public WidgetServerSettingsInstantInvites$Model(Guild guild, List<WidgetServerSettingsInstantInvites$Model$InviteItem> list) {
        m.checkNotNullParameter(guild, "guild");
        this.guild = guild;
        this.inviteItems = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsInstantInvites$Model copy$default(WidgetServerSettingsInstantInvites$Model widgetServerSettingsInstantInvites$Model, Guild guild, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsInstantInvites$Model.guild;
        }
        if ((i & 2) != 0) {
            list = widgetServerSettingsInstantInvites$Model.inviteItems;
        }
        return widgetServerSettingsInstantInvites$Model.copy(guild, list);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final List<WidgetServerSettingsInstantInvites$Model$InviteItem> component2() {
        return this.inviteItems;
    }

    public final WidgetServerSettingsInstantInvites$Model copy(Guild guild, List<WidgetServerSettingsInstantInvites$Model$InviteItem> inviteItems) {
        m.checkNotNullParameter(guild, "guild");
        return new WidgetServerSettingsInstantInvites$Model(guild, inviteItems);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsInstantInvites$Model)) {
            return false;
        }
        WidgetServerSettingsInstantInvites$Model widgetServerSettingsInstantInvites$Model = (WidgetServerSettingsInstantInvites$Model) other;
        return m.areEqual(this.guild, widgetServerSettingsInstantInvites$Model.guild) && m.areEqual(this.inviteItems, widgetServerSettingsInstantInvites$Model.inviteItems);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final List<WidgetServerSettingsInstantInvites$Model$InviteItem> getInviteItems() {
        return this.inviteItems;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        List<WidgetServerSettingsInstantInvites$Model$InviteItem> list = this.inviteItems;
        return iHashCode + (list != null ? list.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(guild=");
        sbU.append(this.guild);
        sbU.append(", inviteItems=");
        return a.L(sbU, this.inviteItems, ")");
    }
}
