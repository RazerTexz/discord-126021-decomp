package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.models.domain.ModelInvite$Settings;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInviteSettingsViewModel$ViewState {
    private final List<Channel> invitableChannels;
    private final ModelInvite$Settings inviteSettings;
    private final Channel targetChannel;

    public GuildInviteSettingsViewModel$ViewState(List<Channel> list, ModelInvite$Settings modelInvite$Settings, Channel channel) {
        m.checkNotNullParameter(list, "invitableChannels");
        m.checkNotNullParameter(modelInvite$Settings, "inviteSettings");
        this.invitableChannels = list;
        this.inviteSettings = modelInvite$Settings;
        this.targetChannel = channel;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildInviteSettingsViewModel$ViewState copy$default(GuildInviteSettingsViewModel$ViewState guildInviteSettingsViewModel$ViewState, List list, ModelInvite$Settings modelInvite$Settings, Channel channel, int i, Object obj) {
        if ((i & 1) != 0) {
            list = guildInviteSettingsViewModel$ViewState.invitableChannels;
        }
        if ((i & 2) != 0) {
            modelInvite$Settings = guildInviteSettingsViewModel$ViewState.inviteSettings;
        }
        if ((i & 4) != 0) {
            channel = guildInviteSettingsViewModel$ViewState.targetChannel;
        }
        return guildInviteSettingsViewModel$ViewState.copy(list, modelInvite$Settings, channel);
    }

    public final List<Channel> component1() {
        return this.invitableChannels;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    public final GuildInviteSettingsViewModel$ViewState copy(List<Channel> invitableChannels, ModelInvite$Settings inviteSettings, Channel targetChannel) {
        m.checkNotNullParameter(invitableChannels, "invitableChannels");
        m.checkNotNullParameter(inviteSettings, "inviteSettings");
        return new GuildInviteSettingsViewModel$ViewState(invitableChannels, inviteSettings, targetChannel);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInviteSettingsViewModel$ViewState)) {
            return false;
        }
        GuildInviteSettingsViewModel$ViewState guildInviteSettingsViewModel$ViewState = (GuildInviteSettingsViewModel$ViewState) other;
        return m.areEqual(this.invitableChannels, guildInviteSettingsViewModel$ViewState.invitableChannels) && m.areEqual(this.inviteSettings, guildInviteSettingsViewModel$ViewState.inviteSettings) && m.areEqual(this.targetChannel, guildInviteSettingsViewModel$ViewState.targetChannel);
    }

    public final List<Channel> getInvitableChannels() {
        return this.invitableChannels;
    }

    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public final Channel getTargetChannel() {
        return this.targetChannel;
    }

    public int hashCode() {
        List<Channel> list = this.invitableChannels;
        int iHashCode = (list != null ? list.hashCode() : 0) * 31;
        ModelInvite$Settings modelInvite$Settings = this.inviteSettings;
        int iHashCode2 = (iHashCode + (modelInvite$Settings != null ? modelInvite$Settings.hashCode() : 0)) * 31;
        Channel channel = this.targetChannel;
        return iHashCode2 + (channel != null ? channel.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("ViewState(invitableChannels=");
        sbU.append(this.invitableChannels);
        sbU.append(", inviteSettings=");
        sbU.append(this.inviteSettings);
        sbU.append(", targetChannel=");
        sbU.append(this.targetChannel);
        sbU.append(")");
        return sbU.toString();
    }
}
