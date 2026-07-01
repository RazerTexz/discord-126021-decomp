package com.discord.widgets.servers.settings.members;

import androidx.core.app.NotificationCompat;
import b.d.b.a.a;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.ManageUserContext;
import com.discord.utilities.permissions.ManageUserContext$Companion;
import com.discord.utilities.permissions.PermissionUtils;
import d0.g0.s;
import d0.g0.w;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel$Companion$get$1$1<T1, T2, T3, T4, T5, T6, T7, R> implements Func7<Guild, Long, MeUser, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, String, Long, WidgetServerSettingsMembersModel> {
    public final /* synthetic */ Map $members;

    public WidgetServerSettingsMembersModel$Companion$get$1$1(Map map) {
        this.$members = map;
    }

    @Override // rx.functions.Func7
    public /* bridge */ /* synthetic */ WidgetServerSettingsMembersModel call(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map, Map<Long, ? extends GuildRole> map2, String str, Long l2) {
        return call2(guild, l, meUser, map, (Map<Long, GuildRole>) map2, str, l2);
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0108  */
    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsMembersModel call2(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map, Map<Long, GuildRole> map2, String str, Long l2) {
        TreeSet treeSet;
        String nick;
        WidgetServerSettingsMembersModel$Companion$get$1$1<T1, T2, T3, T4, T5, T6, T7, R> widgetServerSettingsMembersModel$Companion$get$1$1 = this;
        GuildMember guildMember = (GuildMember) widgetServerSettingsMembersModel$Companion$get$1$1.$members.get(Long.valueOf(meUser.getId()));
        if (guild == null || l == null || guildMember == null) {
            return null;
        }
        TreeSet treeSet2 = new TreeSet(WidgetServerSettingsMembersModel$Companion.access$sortMembersComparator(WidgetServerSettingsMembersModel.Companion));
        for (User user : map.values()) {
            GuildMember guildMember2 = (GuildMember) a.f(user, widgetServerSettingsMembersModel$Companion$get$1$1.$members);
            if (guildMember2 != null) {
                long id2 = guild.getId();
                if ((l2 != 0 && l2.longValue() == id2) || guildMember2.getRoles().contains(l2)) {
                    long id3 = user.getId();
                    m.checkNotNullExpressionValue(str, "filter");
                    Long longOrNull = s.toLongOrNull(str);
                    if ((longOrNull != null && id3 == longOrNull.longValue()) || w.contains((CharSequence) user.getUsername(), (CharSequence) str, true) || ((nick = guildMember2.getNick()) != null && w.contains((CharSequence) nick, (CharSequence) str, true))) {
                        ManageUserContext$Companion manageUserContext$Companion = ManageUserContext.Companion;
                        m.checkNotNullExpressionValue(meUser, "me");
                        List<Long> roles = guildMember.getRoles();
                        List<Long> roles2 = guildMember2.getRoles();
                        m.checkNotNullExpressionValue(map2, "roles");
                        treeSet = treeSet2;
                        ManageUserContext manageUserContextFrom = manageUserContext$Companion.from(guild, meUser, user, roles, roles2, l, map2);
                        String nickOrUsername = GuildMember.Companion.getNickOrUsername(guildMember2, user);
                        List<Long> roles3 = guildMember2.getRoles();
                        ArrayList arrayList = new ArrayList();
                        Iterator<T> it = roles3.iterator();
                        while (it.hasNext()) {
                            GuildRole guildRole = map2.get(Long.valueOf(((Number) it.next()).longValue()));
                            if (guildRole != null) {
                                arrayList.add(guildRole);
                            }
                        }
                        treeSet.add(new WidgetServerSettingsMembersModel$MemberItem(user, nickOrUsername, arrayList, manageUserContextFrom.canManage(), guildMember2));
                    } else {
                        treeSet = treeSet2;
                    }
                } else {
                    treeSet = treeSet2;
                }
            } else {
                treeSet = treeSet2;
            }
            widgetServerSettingsMembersModel$Companion$get$1$1 = this;
            treeSet2 = treeSet;
        }
        WidgetServerSettingsMembersModel$Companion widgetServerSettingsMembersModel$Companion = WidgetServerSettingsMembersModel.Companion;
        m.checkNotNullExpressionValue(map2, "roles");
        Map mapAccess$sortRoles = WidgetServerSettingsMembersModel$Companion.access$sortRoles(widgetServerSettingsMembersModel$Companion, map2);
        ArrayList arrayList2 = new ArrayList(treeSet2);
        GuildRole highestRole = RoleUtils.getHighestRole(map2, guildMember);
        m.checkNotNullExpressionValue(meUser, "me");
        return new WidgetServerSettingsMembersModel(guild, mapAccess$sortRoles, arrayList2, highestRole, meUser, guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(2L, l, meUser.getMfaEnabled(), guild.getMfaLevel()), PermissionUtils.canManageGuildMembers(guild.isOwner(meUser.getId()), meUser.getMfaEnabled(), guild.getMfaLevel(), l));
    }
}
