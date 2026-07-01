package com.discord.widgets.guildcommunicationdisabled.start;

import b.d.b.a.a;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildCommunicationDisabledBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildCommunicationDisabledBottomSheetViewModel$StoreState {
    private final Guild guild;
    private final GuildMember guildMember;

    public GuildCommunicationDisabledBottomSheetViewModel$StoreState(Guild guild, GuildMember guildMember) {
        this.guild = guild;
        this.guildMember = guildMember;
    }

    public static /* synthetic */ GuildCommunicationDisabledBottomSheetViewModel$StoreState copy$default(GuildCommunicationDisabledBottomSheetViewModel$StoreState guildCommunicationDisabledBottomSheetViewModel$StoreState, Guild guild, GuildMember guildMember, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = guildCommunicationDisabledBottomSheetViewModel$StoreState.guild;
        }
        if ((i & 2) != 0) {
            guildMember = guildCommunicationDisabledBottomSheetViewModel$StoreState.guildMember;
        }
        return guildCommunicationDisabledBottomSheetViewModel$StoreState.copy(guild, guildMember);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public final GuildCommunicationDisabledBottomSheetViewModel$StoreState copy(Guild guild, GuildMember guildMember) {
        return new GuildCommunicationDisabledBottomSheetViewModel$StoreState(guild, guildMember);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildCommunicationDisabledBottomSheetViewModel$StoreState)) {
            return false;
        }
        GuildCommunicationDisabledBottomSheetViewModel$StoreState guildCommunicationDisabledBottomSheetViewModel$StoreState = (GuildCommunicationDisabledBottomSheetViewModel$StoreState) other;
        return m.areEqual(this.guild, guildCommunicationDisabledBottomSheetViewModel$StoreState.guild) && m.areEqual(this.guildMember, guildCommunicationDisabledBottomSheetViewModel$StoreState.guildMember);
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final GuildMember getGuildMember() {
        return this.guildMember;
    }

    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        GuildMember guildMember = this.guildMember;
        return iHashCode + (guildMember != null ? guildMember.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(guild=");
        sbU.append(this.guild);
        sbU.append(", guildMember=");
        sbU.append(this.guildMember);
        sbU.append(")");
        return sbU.toString();
    }
}
