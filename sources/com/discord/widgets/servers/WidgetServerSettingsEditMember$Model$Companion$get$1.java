package com.discord.widgets.servers;

import androidx.core.app.NotificationCompat;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.permissions.ManageUserContext;
import com.discord.utilities.permissions.ManageUserContext$Companion;
import d0.t.o;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map$Entry;
import rx.functions.Func6;

/* JADX INFO: compiled from: WidgetServerSettingsEditMember.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsEditMember$Model$Companion$get$1<T1, T2, T3, T4, T5, T6, R> implements Func6<MeUser, User, Map<Long, ? extends GuildMember>, Guild, Map<Long, ? extends GuildRole>, Long, WidgetServerSettingsEditMember$Model> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ long $userId;

    public WidgetServerSettingsEditMember$Model$Companion$get$1(long j, long j2) {
        this.$guildId = j;
        this.$userId = j2;
    }

    @Override // rx.functions.Func6
    public /* bridge */ /* synthetic */ WidgetServerSettingsEditMember$Model call(MeUser meUser, User user, Map<Long, ? extends GuildMember> map, Guild guild, Map<Long, ? extends GuildRole> map2, Long l) {
        return call2(meUser, user, (Map<Long, GuildMember>) map, guild, (Map<Long, GuildRole>) map2, l);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final WidgetServerSettingsEditMember$Model call2(MeUser meUser, User user, Map<Long, GuildMember> map, Guild guild, Map<Long, GuildRole> map2, Long l) {
        m.checkNotNullExpressionValue(map2, "guildRoles");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map$Entry<Long, GuildRole>> it = map2.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map$Entry<Long, GuildRole> next = it.next();
            if (next.getKey().longValue() != this.$guildId) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        GuildMember guildMember = map.get(Long.valueOf(meUser.getId()));
        GuildMember guildMember2 = map.get(Long.valueOf(this.$userId));
        if (guild == null || user == null || l == null || guildMember == null || guildMember2 == null) {
            return null;
        }
        ManageUserContext$Companion manageUserContext$Companion = ManageUserContext.Companion;
        m.checkNotNullExpressionValue(meUser, "meUser");
        ManageUserContext manageUserContextFrom = manageUserContext$Companion.from(guild, meUser, user, guildMember.getRoles(), guildMember2.getRoles(), l, linkedHashMap);
        HashSet hashSet = new HashSet(guildMember2.getRoles());
        GuildRole highestRole = RoleUtils.getHighestRole(linkedHashMap, guildMember);
        ArrayList<GuildRole> arrayList = new ArrayList(linkedHashMap.values());
        Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(arrayList, 10));
        for (GuildRole guildRole : arrayList) {
            arrayList2.add(new WidgetServerSettingsEditMemberRolesAdapter$RoleItem(guildRole, hashSet.contains(Long.valueOf(guildRole.getId())), highestRole, meUser.getId() == guild.getOwnerId(), manageUserContextFrom.getCanManageRoles()));
        }
        return new WidgetServerSettingsEditMember$Model(meUser.getId(), guild, guildMember2, hashSet, user, arrayList2, manageUserContextFrom.canManage(), manageUserContextFrom.getCanKick(), manageUserContextFrom.getCanBan(), manageUserContextFrom.getCanChangeNickname(), meUser.getId() != this.$userId && meUser.getId() == guild.getOwnerId(), manageUserContextFrom.getCanDisableCommunication());
    }
}
