package com.discord.widgets.user;

import b.d.b.a.a;
import com.discord.api.user.UserProfile;
import com.discord.api.user.UserProfile$GuildReference;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.utilities.user.UserProfileUtilsKt;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: WidgetUserMutualGuilds.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class WidgetUserMutualGuilds$Model {
    public static final WidgetUserMutualGuilds$Model$Companion Companion = new WidgetUserMutualGuilds$Model$Companion(null);
    private final Map<Long, Map<Long, GuildMember>> guildMembers;
    private final Map<Long, Guild> guilds;
    private final List<WidgetUserMutualGuilds$Model$Item> list;
    private final int numMutualGuilds;
    private final UserProfile profile;
    private final User user;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetUserMutualGuilds$Model(UserProfile userProfile, Map<Long, Guild> map, User user, Map<Long, ? extends Map<Long, GuildMember>> map2) {
        GuildMember guildMember;
        m.checkNotNullParameter(userProfile, "profile");
        m.checkNotNullParameter(map, "guilds");
        m.checkNotNullParameter(map2, "guildMembers");
        this.profile = userProfile;
        this.guilds = map;
        this.user = user;
        this.guildMembers = map2;
        this.list = new ArrayList(userProfile.d().size());
        for (Guild guild : map.values()) {
            UserProfile$GuildReference userProfile$GuildReference = (UserProfile$GuildReference) a.e(guild, UserProfileUtilsKt.getMutualGuildsById(this.profile));
            if (userProfile$GuildReference != null) {
                List<WidgetUserMutualGuilds$Model$Item> list = this.list;
                User user2 = this.user;
                String nick = userProfile$GuildReference.getNick();
                Map map3 = (Map) a.e(guild, this.guildMembers);
                if (map3 != null) {
                    User user3 = this.user;
                    guildMember = (GuildMember) map3.get(user3 != null ? Long.valueOf(user3.getId()) : null);
                } else {
                    guildMember = null;
                }
                list.add(new WidgetUserMutualGuilds$Model$Item(1, guild, nick, user2, guildMember));
            }
        }
        this.numMutualGuilds = this.list.size();
        if (this.list.isEmpty()) {
            this.list.add(new WidgetUserMutualGuilds$Model$Item(0, null, null, null, null));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetUserMutualGuilds$Model copy$default(WidgetUserMutualGuilds$Model widgetUserMutualGuilds$Model, UserProfile userProfile, Map map, User user, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            userProfile = widgetUserMutualGuilds$Model.profile;
        }
        if ((i & 2) != 0) {
            map = widgetUserMutualGuilds$Model.guilds;
        }
        if ((i & 4) != 0) {
            user = widgetUserMutualGuilds$Model.user;
        }
        if ((i & 8) != 0) {
            map2 = widgetUserMutualGuilds$Model.guildMembers;
        }
        return widgetUserMutualGuilds$Model.copy(userProfile, map, user, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final UserProfile getProfile() {
        return this.profile;
    }

    public final Map<Long, Guild> component2() {
        return this.guilds;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final Map<Long, Map<Long, GuildMember>> component4() {
        return this.guildMembers;
    }

    public final WidgetUserMutualGuilds$Model copy(UserProfile profile, Map<Long, Guild> guilds, User user, Map<Long, ? extends Map<Long, GuildMember>> guildMembers) {
        m.checkNotNullParameter(profile, "profile");
        m.checkNotNullParameter(guilds, "guilds");
        m.checkNotNullParameter(guildMembers, "guildMembers");
        return new WidgetUserMutualGuilds$Model(profile, guilds, user, guildMembers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetUserMutualGuilds$Model)) {
            return false;
        }
        WidgetUserMutualGuilds$Model widgetUserMutualGuilds$Model = (WidgetUserMutualGuilds$Model) other;
        return m.areEqual(this.profile, widgetUserMutualGuilds$Model.profile) && m.areEqual(this.guilds, widgetUserMutualGuilds$Model.guilds) && m.areEqual(this.user, widgetUserMutualGuilds$Model.user) && m.areEqual(this.guildMembers, widgetUserMutualGuilds$Model.guildMembers);
    }

    public final Map<Long, Map<Long, GuildMember>> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guilds;
    }

    public final List<WidgetUserMutualGuilds$Model$Item> getList() {
        return this.list;
    }

    public final int getNumMutualGuilds() {
        return this.numMutualGuilds;
    }

    public final UserProfile getProfile() {
        return this.profile;
    }

    public final User getUser() {
        return this.user;
    }

    public int hashCode() {
        UserProfile userProfile = this.profile;
        int iHashCode = (userProfile != null ? userProfile.hashCode() : 0) * 31;
        Map<Long, Guild> map = this.guilds;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        User user = this.user;
        int iHashCode3 = (iHashCode2 + (user != null ? user.hashCode() : 0)) * 31;
        Map<Long, Map<Long, GuildMember>> map2 = this.guildMembers;
        return iHashCode3 + (map2 != null ? map2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("Model(profile=");
        sbU.append(this.profile);
        sbU.append(", guilds=");
        sbU.append(this.guilds);
        sbU.append(", user=");
        sbU.append(this.user);
        sbU.append(", guildMembers=");
        return a.M(sbU, this.guildMembers, ")");
    }
}
