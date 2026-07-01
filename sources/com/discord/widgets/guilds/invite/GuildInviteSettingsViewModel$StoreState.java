package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;
import d0.z.d.m;
import java.util.Map;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInviteSettingsViewModel$StoreState {
    private final Map<Long, Channel> invitableChannels;
    private final ModelInvite$Settings inviteSettings;

    public GuildInviteSettingsViewModel$StoreState(ModelInvite$Settings modelInvite$Settings, Map<Long, Channel> map) {
        m.checkNotNullParameter(modelInvite$Settings, "inviteSettings");
        m.checkNotNullParameter(map, "invitableChannels");
        this.inviteSettings = modelInvite$Settings;
        this.invitableChannels = map;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildInviteSettingsViewModel$StoreState copy$default(GuildInviteSettingsViewModel$StoreState guildInviteSettingsViewModel$StoreState, ModelInvite$Settings modelInvite$Settings, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite$Settings = guildInviteSettingsViewModel$StoreState.inviteSettings;
        }
        if ((i & 2) != 0) {
            map = guildInviteSettingsViewModel$StoreState.invitableChannels;
        }
        return guildInviteSettingsViewModel$StoreState.copy(modelInvite$Settings, map);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public final Map<Long, Channel> component2() {
        return this.invitableChannels;
    }

    public final GuildInviteSettingsViewModel$StoreState copy(ModelInvite$Settings inviteSettings, Map<Long, Channel> invitableChannels) {
        m.checkNotNullParameter(inviteSettings, "inviteSettings");
        m.checkNotNullParameter(invitableChannels, "invitableChannels");
        return new GuildInviteSettingsViewModel$StoreState(inviteSettings, invitableChannels);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInviteSettingsViewModel$StoreState)) {
            return false;
        }
        GuildInviteSettingsViewModel$StoreState guildInviteSettingsViewModel$StoreState = (GuildInviteSettingsViewModel$StoreState) other;
        return m.areEqual(this.inviteSettings, guildInviteSettingsViewModel$StoreState.inviteSettings) && m.areEqual(this.invitableChannels, guildInviteSettingsViewModel$StoreState.invitableChannels);
    }

    public final Map<Long, Channel> getInvitableChannels() {
        return this.invitableChannels;
    }

    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public int hashCode() {
        ModelInvite$Settings modelInvite$Settings = this.inviteSettings;
        int iHashCode = (modelInvite$Settings != null ? modelInvite$Settings.hashCode() : 0) * 31;
        Map<Long, Channel> map = this.invitableChannels;
        return iHashCode + (map != null ? map.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(inviteSettings=");
        sbU.append(this.inviteSettings);
        sbU.append(", invitableChannels=");
        return a.M(sbU, this.invitableChannels, ")");
    }
}
