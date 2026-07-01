package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildInviteSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInviteSettingsViewModel$Event$InviteCreationSuccess extends GuildInviteSettingsViewModel$Event {
    private final GuildInvite invite;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildInviteSettingsViewModel$Event$InviteCreationSuccess(GuildInvite guildInvite) {
        super(null);
        m.checkNotNullParameter(guildInvite, "invite");
        this.invite = guildInvite;
    }

    public static /* synthetic */ GuildInviteSettingsViewModel$Event$InviteCreationSuccess copy$default(GuildInviteSettingsViewModel$Event$InviteCreationSuccess guildInviteSettingsViewModel$Event$InviteCreationSuccess, GuildInvite guildInvite, int i, Object obj) {
        if ((i & 1) != 0) {
            guildInvite = guildInviteSettingsViewModel$Event$InviteCreationSuccess.invite;
        }
        return guildInviteSettingsViewModel$Event$InviteCreationSuccess.copy(guildInvite);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final GuildInvite getInvite() {
        return this.invite;
    }

    public final GuildInviteSettingsViewModel$Event$InviteCreationSuccess copy(GuildInvite invite) {
        m.checkNotNullParameter(invite, "invite");
        return new GuildInviteSettingsViewModel$Event$InviteCreationSuccess(invite);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof GuildInviteSettingsViewModel$Event$InviteCreationSuccess) && m.areEqual(this.invite, ((GuildInviteSettingsViewModel$Event$InviteCreationSuccess) other).invite);
        }
        return true;
    }

    public final GuildInvite getInvite() {
        return this.invite;
    }

    public int hashCode() {
        GuildInvite guildInvite = this.invite;
        if (guildInvite != null) {
            return guildInvite.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("InviteCreationSuccess(invite=");
        sbU.append(this.invite);
        sbU.append(")");
        return sbU.toString();
    }
}
