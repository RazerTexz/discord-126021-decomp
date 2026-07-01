package com.discord.widgets.guilds.invite;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.stageinstance.StageInstance;
import com.discord.models.domain.ModelInvite$Settings;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import d0.z.d.m;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: GuildInviteShareSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildInviteShareSheetViewModel$StoreState$Valid extends GuildInviteShareSheetViewModel$StoreState {
    private final List<Channel> dms;
    private final Guild guild;
    private final Map<Long, StageInstance> guildStageInstances;
    private final Map<Long, Channel> invitableChannels;
    private final ModelInvite$Settings inviteSettings;
    private final List<InviteSuggestion> inviteSuggestions;
    private final MeUser me;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public GuildInviteShareSheetViewModel$StoreState$Valid(ModelInvite$Settings modelInvite$Settings, Map<Long, Channel> map, MeUser meUser, List<Channel> list, Guild guild, List<? extends InviteSuggestion> list2, Map<Long, StageInstance> map2) {
        super(null);
        m.checkNotNullParameter(modelInvite$Settings, "inviteSettings");
        m.checkNotNullParameter(map, "invitableChannels");
        m.checkNotNullParameter(meUser, "me");
        m.checkNotNullParameter(list, "dms");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(list2, "inviteSuggestions");
        m.checkNotNullParameter(map2, "guildStageInstances");
        this.inviteSettings = modelInvite$Settings;
        this.invitableChannels = map;
        this.me = meUser;
        this.dms = list;
        this.guild = guild;
        this.inviteSuggestions = list2;
        this.guildStageInstances = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GuildInviteShareSheetViewModel$StoreState$Valid copy$default(GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid, ModelInvite$Settings modelInvite$Settings, Map map, MeUser meUser, List list, Guild guild, List list2, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            modelInvite$Settings = guildInviteShareSheetViewModel$StoreState$Valid.inviteSettings;
        }
        if ((i & 2) != 0) {
            map = guildInviteShareSheetViewModel$StoreState$Valid.invitableChannels;
        }
        Map map3 = map;
        if ((i & 4) != 0) {
            meUser = guildInviteShareSheetViewModel$StoreState$Valid.me;
        }
        MeUser meUser2 = meUser;
        if ((i & 8) != 0) {
            list = guildInviteShareSheetViewModel$StoreState$Valid.dms;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            guild = guildInviteShareSheetViewModel$StoreState$Valid.guild;
        }
        Guild guild2 = guild;
        if ((i & 32) != 0) {
            list2 = guildInviteShareSheetViewModel$StoreState$Valid.inviteSuggestions;
        }
        List list4 = list2;
        if ((i & 64) != 0) {
            map2 = guildInviteShareSheetViewModel$StoreState$Valid.guildStageInstances;
        }
        return guildInviteShareSheetViewModel$StoreState$Valid.copy(modelInvite$Settings, map3, meUser2, list3, guild2, list4, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public final Map<Long, Channel> component2() {
        return this.invitableChannels;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final MeUser getMe() {
        return this.me;
    }

    public final List<Channel> component4() {
        return this.dms;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final List<InviteSuggestion> component6() {
        return this.inviteSuggestions;
    }

    public final Map<Long, StageInstance> component7() {
        return this.guildStageInstances;
    }

    public final GuildInviteShareSheetViewModel$StoreState$Valid copy(ModelInvite$Settings inviteSettings, Map<Long, Channel> invitableChannels, MeUser me2, List<Channel> dms, Guild guild, List<? extends InviteSuggestion> inviteSuggestions, Map<Long, StageInstance> guildStageInstances) {
        m.checkNotNullParameter(inviteSettings, "inviteSettings");
        m.checkNotNullParameter(invitableChannels, "invitableChannels");
        m.checkNotNullParameter(me2, "me");
        m.checkNotNullParameter(dms, "dms");
        m.checkNotNullParameter(guild, "guild");
        m.checkNotNullParameter(inviteSuggestions, "inviteSuggestions");
        m.checkNotNullParameter(guildStageInstances, "guildStageInstances");
        return new GuildInviteShareSheetViewModel$StoreState$Valid(inviteSettings, invitableChannels, me2, dms, guild, inviteSuggestions, guildStageInstances);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildInviteShareSheetViewModel$StoreState$Valid)) {
            return false;
        }
        GuildInviteShareSheetViewModel$StoreState$Valid guildInviteShareSheetViewModel$StoreState$Valid = (GuildInviteShareSheetViewModel$StoreState$Valid) other;
        return m.areEqual(this.inviteSettings, guildInviteShareSheetViewModel$StoreState$Valid.inviteSettings) && m.areEqual(this.invitableChannels, guildInviteShareSheetViewModel$StoreState$Valid.invitableChannels) && m.areEqual(this.me, guildInviteShareSheetViewModel$StoreState$Valid.me) && m.areEqual(this.dms, guildInviteShareSheetViewModel$StoreState$Valid.dms) && m.areEqual(this.guild, guildInviteShareSheetViewModel$StoreState$Valid.guild) && m.areEqual(this.inviteSuggestions, guildInviteShareSheetViewModel$StoreState$Valid.inviteSuggestions) && m.areEqual(this.guildStageInstances, guildInviteShareSheetViewModel$StoreState$Valid.guildStageInstances);
    }

    public final List<Channel> getDms() {
        return this.dms;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, StageInstance> getGuildStageInstances() {
        return this.guildStageInstances;
    }

    public final Map<Long, Channel> getInvitableChannels() {
        return this.invitableChannels;
    }

    public final ModelInvite$Settings getInviteSettings() {
        return this.inviteSettings;
    }

    public final List<InviteSuggestion> getInviteSuggestions() {
        return this.inviteSuggestions;
    }

    public final MeUser getMe() {
        return this.me;
    }

    public int hashCode() {
        ModelInvite$Settings modelInvite$Settings = this.inviteSettings;
        int iHashCode = (modelInvite$Settings != null ? modelInvite$Settings.hashCode() : 0) * 31;
        Map<Long, Channel> map = this.invitableChannels;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        MeUser meUser = this.me;
        int iHashCode3 = (iHashCode2 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        List<Channel> list = this.dms;
        int iHashCode4 = (iHashCode3 + (list != null ? list.hashCode() : 0)) * 31;
        Guild guild = this.guild;
        int iHashCode5 = (iHashCode4 + (guild != null ? guild.hashCode() : 0)) * 31;
        List<InviteSuggestion> list2 = this.inviteSuggestions;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        Map<Long, StageInstance> map2 = this.guildStageInstances;
        return iHashCode6 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(inviteSettings=");
        sbU.append(this.inviteSettings);
        sbU.append(", invitableChannels=");
        sbU.append(this.invitableChannels);
        sbU.append(", me=");
        sbU.append(this.me);
        sbU.append(", dms=");
        sbU.append(this.dms);
        sbU.append(", guild=");
        sbU.append(this.guild);
        sbU.append(", inviteSuggestions=");
        sbU.append(this.inviteSuggestions);
        sbU.append(", guildStageInstances=");
        return a.M(sbU, this.guildStageInstances, ")");
    }
}
