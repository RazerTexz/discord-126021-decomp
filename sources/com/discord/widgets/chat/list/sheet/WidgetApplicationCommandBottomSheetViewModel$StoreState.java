package com.discord.widgets.chat.list.sheet;

import b.d.b.a.a;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.models.commands.Application;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreApplicationInteractions$State;
import d0.z.d.m;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetApplicationCommandBottomSheetViewModel$StoreState {
    private final Application application;
    private final Map<Long, Channel> channels;
    private final Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> commandValues;
    private final Map<Long, GuildMember> guildMembers;
    private final Map<Long, GuildRole> guildRoles;
    private final StoreApplicationInteractions$State interactionState;
    private final GuildMember interactionUser;
    private final Set<Long> mentionedUsers;
    private final User user;
    private final Map<Long, User> users;

    /* JADX WARN: Multi-variable type inference failed */
    public WidgetApplicationCommandBottomSheetViewModel$StoreState(User user, GuildMember guildMember, StoreApplicationInteractions$State storeApplicationInteractions$State, Application application, Set<Long> set, Map<Long, GuildMember> map, Map<Long, GuildRole> map2, Map<Long, ? extends User> map3, Map<Long, Channel> map4, Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> map5) {
        m.checkNotNullParameter(set, "mentionedUsers");
        m.checkNotNullParameter(map3, "users");
        m.checkNotNullParameter(map4, "channels");
        m.checkNotNullParameter(map5, "commandValues");
        this.user = user;
        this.interactionUser = guildMember;
        this.interactionState = storeApplicationInteractions$State;
        this.application = application;
        this.mentionedUsers = set;
        this.guildMembers = map;
        this.guildRoles = map2;
        this.users = map3;
        this.channels = map4;
        this.commandValues = map5;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$StoreState copy$default(WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState, User user, GuildMember guildMember, StoreApplicationInteractions$State storeApplicationInteractions$State, Application application, Set set, Map map, Map map2, Map map3, Map map4, Map map5, int i, Object obj) {
        return widgetApplicationCommandBottomSheetViewModel$StoreState.copy((i & 1) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.user : user, (i & 2) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.interactionUser : guildMember, (i & 4) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.interactionState : storeApplicationInteractions$State, (i & 8) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.application : application, (i & 16) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.mentionedUsers : set, (i & 32) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.guildMembers : map, (i & 64) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.guildRoles : map2, (i & 128) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.users : map3, (i & 256) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.channels : map4, (i & 512) != 0 ? widgetApplicationCommandBottomSheetViewModel$StoreState.commandValues : map5);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final User getUser() {
        return this.user;
    }

    public final Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> component10() {
        return this.commandValues;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final GuildMember getInteractionUser() {
        return this.interactionUser;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final StoreApplicationInteractions$State getInteractionState() {
        return this.interactionState;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Application getApplication() {
        return this.application;
    }

    public final Set<Long> component5() {
        return this.mentionedUsers;
    }

    public final Map<Long, GuildMember> component6() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> component7() {
        return this.guildRoles;
    }

    public final Map<Long, User> component8() {
        return this.users;
    }

    public final Map<Long, Channel> component9() {
        return this.channels;
    }

    public final WidgetApplicationCommandBottomSheetViewModel$StoreState copy(User user, GuildMember interactionUser, StoreApplicationInteractions$State interactionState, Application application, Set<Long> mentionedUsers, Map<Long, GuildMember> guildMembers, Map<Long, GuildRole> guildRoles, Map<Long, ? extends User> users, Map<Long, Channel> channels, Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> commandValues) {
        m.checkNotNullParameter(mentionedUsers, "mentionedUsers");
        m.checkNotNullParameter(users, "users");
        m.checkNotNullParameter(channels, "channels");
        m.checkNotNullParameter(commandValues, "commandValues");
        return new WidgetApplicationCommandBottomSheetViewModel$StoreState(user, interactionUser, interactionState, application, mentionedUsers, guildMembers, guildRoles, users, channels, commandValues);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetApplicationCommandBottomSheetViewModel$StoreState)) {
            return false;
        }
        WidgetApplicationCommandBottomSheetViewModel$StoreState widgetApplicationCommandBottomSheetViewModel$StoreState = (WidgetApplicationCommandBottomSheetViewModel$StoreState) other;
        return m.areEqual(this.user, widgetApplicationCommandBottomSheetViewModel$StoreState.user) && m.areEqual(this.interactionUser, widgetApplicationCommandBottomSheetViewModel$StoreState.interactionUser) && m.areEqual(this.interactionState, widgetApplicationCommandBottomSheetViewModel$StoreState.interactionState) && m.areEqual(this.application, widgetApplicationCommandBottomSheetViewModel$StoreState.application) && m.areEqual(this.mentionedUsers, widgetApplicationCommandBottomSheetViewModel$StoreState.mentionedUsers) && m.areEqual(this.guildMembers, widgetApplicationCommandBottomSheetViewModel$StoreState.guildMembers) && m.areEqual(this.guildRoles, widgetApplicationCommandBottomSheetViewModel$StoreState.guildRoles) && m.areEqual(this.users, widgetApplicationCommandBottomSheetViewModel$StoreState.users) && m.areEqual(this.channels, widgetApplicationCommandBottomSheetViewModel$StoreState.channels) && m.areEqual(this.commandValues, widgetApplicationCommandBottomSheetViewModel$StoreState.commandValues);
    }

    public final Application getApplication() {
        return this.application;
    }

    public final Map<Long, Channel> getChannels() {
        return this.channels;
    }

    public final Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> getCommandValues() {
        return this.commandValues;
    }

    public final Map<Long, GuildMember> getGuildMembers() {
        return this.guildMembers;
    }

    public final Map<Long, GuildRole> getGuildRoles() {
        return this.guildRoles;
    }

    public final StoreApplicationInteractions$State getInteractionState() {
        return this.interactionState;
    }

    public final GuildMember getInteractionUser() {
        return this.interactionUser;
    }

    public final Set<Long> getMentionedUsers() {
        return this.mentionedUsers;
    }

    public final User getUser() {
        return this.user;
    }

    public final Map<Long, User> getUsers() {
        return this.users;
    }

    public int hashCode() {
        User user = this.user;
        int iHashCode = (user != null ? user.hashCode() : 0) * 31;
        GuildMember guildMember = this.interactionUser;
        int iHashCode2 = (iHashCode + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
        StoreApplicationInteractions$State storeApplicationInteractions$State = this.interactionState;
        int iHashCode3 = (iHashCode2 + (storeApplicationInteractions$State != null ? storeApplicationInteractions$State.hashCode() : 0)) * 31;
        Application application = this.application;
        int iHashCode4 = (iHashCode3 + (application != null ? application.hashCode() : 0)) * 31;
        Set<Long> set = this.mentionedUsers;
        int iHashCode5 = (iHashCode4 + (set != null ? set.hashCode() : 0)) * 31;
        Map<Long, GuildMember> map = this.guildMembers;
        int iHashCode6 = (iHashCode5 + (map != null ? map.hashCode() : 0)) * 31;
        Map<Long, GuildRole> map2 = this.guildRoles;
        int iHashCode7 = (iHashCode6 + (map2 != null ? map2.hashCode() : 0)) * 31;
        Map<Long, User> map3 = this.users;
        int iHashCode8 = (iHashCode7 + (map3 != null ? map3.hashCode() : 0)) * 31;
        Map<Long, Channel> map4 = this.channels;
        int iHashCode9 = (iHashCode8 + (map4 != null ? map4.hashCode() : 0)) * 31;
        Map<String, WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam> map5 = this.commandValues;
        return iHashCode9 + (map5 != null ? map5.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("StoreState(user=");
        sbU.append(this.user);
        sbU.append(", interactionUser=");
        sbU.append(this.interactionUser);
        sbU.append(", interactionState=");
        sbU.append(this.interactionState);
        sbU.append(", application=");
        sbU.append(this.application);
        sbU.append(", mentionedUsers=");
        sbU.append(this.mentionedUsers);
        sbU.append(", guildMembers=");
        sbU.append(this.guildMembers);
        sbU.append(", guildRoles=");
        sbU.append(this.guildRoles);
        sbU.append(", users=");
        sbU.append(this.users);
        sbU.append(", channels=");
        sbU.append(this.channels);
        sbU.append(", commandValues=");
        return a.M(sbU, this.commandValues, ")");
    }

    public /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$StoreState(User user, GuildMember guildMember, StoreApplicationInteractions$State storeApplicationInteractions$State, Application application, Set set, Map map, Map map2, Map map3, Map map4, Map map5, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(user, (i & 2) != 0 ? null : guildMember, storeApplicationInteractions$State, application, set, map, map2, map3, map4, map5);
    }
}
