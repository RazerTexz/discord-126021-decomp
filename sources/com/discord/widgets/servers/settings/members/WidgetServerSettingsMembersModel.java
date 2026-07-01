package com.discord.widgets.servers.settings.members;

import b.d.b.a.outline;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.permissions.PermissionsContexts3;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel;
import d0.g0.StringNumberConversions;
import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsMembersModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int MEMBER_LIST_ITEM_TYPE = 1;
    private final boolean canKick;
    private final boolean canManageMembers;
    private final Guild guild;
    private final MeUser meUser;
    private final List<MemberItem> memberItems;
    private final GuildRole myHighestRole;
    private final Map<Long, GuildRole> roles;

    /* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Comparator<MemberItem> sortMembersComparator() {
            return new Comparator<MemberItem>() { // from class: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1
                @Override // java.util.Comparator
                public final int compare(WidgetServerSettingsMembersModel.MemberItem memberItem, WidgetServerSettingsMembersModel.MemberItem memberItem2) {
                    Intrinsics3.checkNotNullParameter(memberItem, "member1");
                    Intrinsics3.checkNotNullParameter(memberItem2, "member2");
                    int iCompareTo = StringsJVM.compareTo(memberItem.getUserDisplayName(), memberItem2.getUserDisplayName(), true);
                    return iCompareTo != 0 ? iCompareTo : (memberItem.getUser().getId() > memberItem2.getUser().getId() ? 1 : (memberItem.getUser().getId() == memberItem2.getUser().getId() ? 0 : -1));
                }
            };
        }

        private final Map<Long, GuildRole> sortRoles(Map<Long, GuildRole> guildRoles) {
            LinkedHashMap linkedHashMap = new LinkedHashMap(guildRoles.size());
            ArrayList arrayList = new ArrayList(guildRoles.values());
            Collections.sort(arrayList, RoleUtils.getROLE_COMPARATOR());
            for (Object obj : arrayList) {
                linkedHashMap.put(Long.valueOf(((GuildRole) obj).getId()), obj);
            }
            return linkedHashMap;
        }

        public final Observable<WidgetServerSettingsMembersModel> get(final long guildId, final Observable<String> filterPublisher, final Observable<Long> roleFilterPublisher) {
            Intrinsics3.checkNotNullParameter(filterPublisher, "filterPublisher");
            Intrinsics3.checkNotNullParameter(roleFilterPublisher, "roleFilterPublisher");
            Observable<R> observableY = StoreStream.INSTANCE.getGuilds().observeComputed(guildId).Y(new Func1<Map<Long, ? extends GuildMember>, Observable<? extends WidgetServerSettingsMembersModel>>() { // from class: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$get$1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends WidgetServerSettingsMembersModel> call(Map<Long, ? extends GuildMember> map) {
                    return call2((Map<Long, GuildMember>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends WidgetServerSettingsMembersModel> call2(final Map<Long, GuildMember> map) {
                    StoreStream.Companion companion = StoreStream.INSTANCE;
                    return Observable.e(companion.getGuilds().observeGuild(guildId), companion.getPermissions().observePermissionsForGuild(guildId), StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getUsers().observeUsers(map.keySet()), companion.getGuilds().observeRoles(guildId), filterPublisher.p(300L, TimeUnit.MILLISECONDS), roleFilterPublisher, new Func7<Guild, Long, MeUser, Map<Long, ? extends User>, Map<Long, ? extends GuildRole>, String, Long, WidgetServerSettingsMembersModel>() { // from class: com.discord.widgets.servers.settings.members.WidgetServerSettingsMembersModel$Companion$get$1.1
                        @Override // rx.functions.Func7
                        public /* bridge */ /* synthetic */ WidgetServerSettingsMembersModel call(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map2, Map<Long, ? extends GuildRole> map3, String str, Long l2) {
                            return call2(guild, l, meUser, map2, (Map<Long, GuildRole>) map3, str, l2);
                        }

                        /* JADX WARN: Code duplicated, block: B:37:0x0108  */
                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetServerSettingsMembersModel call2(Guild guild, Long l, MeUser meUser, Map<Long, ? extends User> map2, Map<Long, GuildRole> map3, String str, Long l2) {
                            TreeSet treeSet;
                            String nick;
                            AnonymousClass1<T1, T2, T3, T4, T5, T6, T7, R> anonymousClass1 = this;
                            GuildMember guildMember = (GuildMember) map.get(Long.valueOf(meUser.getId()));
                            if (guild == null || l == null || guildMember == null) {
                                return null;
                            }
                            TreeSet treeSet2 = new TreeSet(WidgetServerSettingsMembersModel.INSTANCE.sortMembersComparator());
                            for (User user : map2.values()) {
                                GuildMember guildMember2 = (GuildMember) outline.f(user, map);
                                if (guildMember2 != null) {
                                    long id2 = guild.getId();
                                    if ((l2 != 0 && l2.longValue() == id2) || guildMember2.getRoles().contains(l2)) {
                                        long id3 = user.getId();
                                        Intrinsics3.checkNotNullExpressionValue(str, "filter");
                                        Long longOrNull = StringNumberConversions.toLongOrNull(str);
                                        if ((longOrNull != null && id3 == longOrNull.longValue()) || Strings4.contains((CharSequence) user.getUsername(), (CharSequence) str, true) || ((nick = guildMember2.getNick()) != null && Strings4.contains((CharSequence) nick, (CharSequence) str, true))) {
                                            PermissionsContexts3.Companion companion2 = PermissionsContexts3.INSTANCE;
                                            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                                            List<Long> roles = guildMember.getRoles();
                                            List<Long> roles2 = guildMember2.getRoles();
                                            Intrinsics3.checkNotNullExpressionValue(map3, "roles");
                                            treeSet = treeSet2;
                                            PermissionsContexts3 permissionsContexts3From = companion2.from(guild, meUser, user, roles, roles2, l, map3);
                                            String nickOrUsername = GuildMember.INSTANCE.getNickOrUsername(guildMember2, user);
                                            List<Long> roles3 = guildMember2.getRoles();
                                            ArrayList arrayList = new ArrayList();
                                            Iterator<T> it = roles3.iterator();
                                            while (it.hasNext()) {
                                                GuildRole guildRole = map3.get(Long.valueOf(((Number) it.next()).longValue()));
                                                if (guildRole != null) {
                                                    arrayList.add(guildRole);
                                                }
                                            }
                                            treeSet.add(new WidgetServerSettingsMembersModel.MemberItem(user, nickOrUsername, arrayList, permissionsContexts3From.canManage(), guildMember2));
                                        } else {
                                            treeSet = treeSet2;
                                        }
                                    } else {
                                        treeSet = treeSet2;
                                    }
                                } else {
                                    treeSet = treeSet2;
                                }
                                anonymousClass1 = this;
                                treeSet2 = treeSet;
                            }
                            WidgetServerSettingsMembersModel.Companion companion3 = WidgetServerSettingsMembersModel.INSTANCE;
                            Intrinsics3.checkNotNullExpressionValue(map3, "roles");
                            Map mapSortRoles = companion3.sortRoles(map3);
                            ArrayList arrayList2 = new ArrayList(treeSet2);
                            GuildRole highestRole = RoleUtils.getHighestRole(map3, guildMember);
                            Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                            return new WidgetServerSettingsMembersModel(guild, mapSortRoles, arrayList2, highestRole, meUser, guild.isOwner(meUser.getId()) || PermissionUtils.canAndIsElevated(2L, l, meUser.getMfaEnabled(), guild.getMfaLevel()), PermissionUtils.canManageGuildMembers(guild.isOwner(meUser.getId()), meUser.getMfaEnabled(), guild.getMfaLevel(), l));
                        }
                    });
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "StoreStream\n            …          }\n            }");
            Observable<WidgetServerSettingsMembersModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "StoreStream\n            …  .distinctUntilChanged()");
            return observableR;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
    public static final /* data */ class MemberItem implements MGRecyclerDataPayload {
        private final GuildMember guildMember;
        private final boolean isManagable;
        private final String key;
        private final List<GuildRole> roles;
        private final int type;
        private final User user;
        private final String userDisplayName;

        public MemberItem(User user, String str, List<GuildRole> list, boolean z2, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(str, "userDisplayName");
            Intrinsics3.checkNotNullParameter(list, "roles");
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            this.user = user;
            this.userDisplayName = str;
            this.roles = list;
            this.isManagable = z2;
            this.guildMember = guildMember;
            this.key = String.valueOf(user.getId());
            this.type = 1;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ MemberItem copy$default(MemberItem memberItem, User user, String str, List list, boolean z2, GuildMember guildMember, int i, Object obj) {
            if ((i & 1) != 0) {
                user = memberItem.user;
            }
            if ((i & 2) != 0) {
                str = memberItem.userDisplayName;
            }
            String str2 = str;
            if ((i & 4) != 0) {
                list = memberItem.roles;
            }
            List list2 = list;
            if ((i & 8) != 0) {
                z2 = memberItem.isManagable;
            }
            boolean z3 = z2;
            if ((i & 16) != 0) {
                guildMember = memberItem.guildMember;
            }
            return memberItem.copy(user, str2, list2, z3, guildMember);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getUserDisplayName() {
            return this.userDisplayName;
        }

        public final List<GuildRole> component3() {
            return this.roles;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final boolean getIsManagable() {
            return this.isManagable;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        public final MemberItem copy(User user, String userDisplayName, List<GuildRole> roles, boolean isManagable, GuildMember guildMember) {
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userDisplayName, "userDisplayName");
            Intrinsics3.checkNotNullParameter(roles, "roles");
            Intrinsics3.checkNotNullParameter(guildMember, "guildMember");
            return new MemberItem(user, userDisplayName, roles, isManagable, guildMember);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof MemberItem)) {
                return false;
            }
            MemberItem memberItem = (MemberItem) other;
            return Intrinsics3.areEqual(this.user, memberItem.user) && Intrinsics3.areEqual(this.userDisplayName, memberItem.userDisplayName) && Intrinsics3.areEqual(this.roles, memberItem.roles) && this.isManagable == memberItem.isManagable && Intrinsics3.areEqual(this.guildMember, memberItem.guildMember);
        }

        public final GuildMember getGuildMember() {
            return this.guildMember;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
        public String getKey() {
            return this.key;
        }

        public final List<GuildRole> getRoles() {
            return this.roles;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
        public int getType() {
            return this.type;
        }

        public final User getUser() {
            return this.user;
        }

        public final String getUserDisplayName() {
            return this.userDisplayName;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v7, types: [int] */
        /* JADX WARN: Type inference failed for: r2v9 */
        public int hashCode() {
            User user = this.user;
            int iHashCode = (user != null ? user.hashCode() : 0) * 31;
            String str = this.userDisplayName;
            int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
            List<GuildRole> list = this.roles;
            int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
            boolean z2 = this.isManagable;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode3 + r2) * 31;
            GuildMember guildMember = this.guildMember;
            return i + (guildMember != null ? guildMember.hashCode() : 0);
        }

        public final boolean isManagable() {
            return this.isManagable;
        }

        public String toString() {
            StringBuilder sbU = outline.U("MemberItem(user=");
            sbU.append(this.user);
            sbU.append(", userDisplayName=");
            sbU.append(this.userDisplayName);
            sbU.append(", roles=");
            sbU.append(this.roles);
            sbU.append(", isManagable=");
            sbU.append(this.isManagable);
            sbU.append(", guildMember=");
            sbU.append(this.guildMember);
            sbU.append(")");
            return sbU.toString();
        }
    }

    public WidgetServerSettingsMembersModel(Guild guild, Map<Long, GuildRole> map, List<MemberItem> list, GuildRole guildRole, MeUser meUser, boolean z2, boolean z3) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(map, "roles");
        Intrinsics3.checkNotNullParameter(list, "memberItems");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        this.guild = guild;
        this.roles = map;
        this.memberItems = list;
        this.myHighestRole = guildRole;
        this.meUser = meUser;
        this.canKick = z2;
        this.canManageMembers = z3;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ WidgetServerSettingsMembersModel copy$default(WidgetServerSettingsMembersModel widgetServerSettingsMembersModel, Guild guild, Map map, List list, GuildRole guildRole, MeUser meUser, boolean z2, boolean z3, int i, Object obj) {
        if ((i & 1) != 0) {
            guild = widgetServerSettingsMembersModel.guild;
        }
        if ((i & 2) != 0) {
            map = widgetServerSettingsMembersModel.roles;
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            list = widgetServerSettingsMembersModel.memberItems;
        }
        List list2 = list;
        if ((i & 8) != 0) {
            guildRole = widgetServerSettingsMembersModel.myHighestRole;
        }
        GuildRole guildRole2 = guildRole;
        if ((i & 16) != 0) {
            meUser = widgetServerSettingsMembersModel.meUser;
        }
        MeUser meUser2 = meUser;
        if ((i & 32) != 0) {
            z2 = widgetServerSettingsMembersModel.canKick;
        }
        boolean z4 = z2;
        if ((i & 64) != 0) {
            z3 = widgetServerSettingsMembersModel.canManageMembers;
        }
        return widgetServerSettingsMembersModel.copy(guild, map2, list2, guildRole2, meUser2, z4, z3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final Guild getGuild() {
        return this.guild;
    }

    public final Map<Long, GuildRole> component2() {
        return this.roles;
    }

    public final List<MemberItem> component3() {
        return this.memberItems;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final GuildRole getMyHighestRole() {
        return this.myHighestRole;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final MeUser getMeUser() {
        return this.meUser;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getCanKick() {
        return this.canKick;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getCanManageMembers() {
        return this.canManageMembers;
    }

    public final WidgetServerSettingsMembersModel copy(Guild guild, Map<Long, GuildRole> roles, List<MemberItem> memberItems, GuildRole myHighestRole, MeUser meUser, boolean canKick, boolean canManageMembers) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(roles, "roles");
        Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
        Intrinsics3.checkNotNullParameter(meUser, "meUser");
        return new WidgetServerSettingsMembersModel(guild, roles, memberItems, myHighestRole, meUser, canKick, canManageMembers);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetServerSettingsMembersModel)) {
            return false;
        }
        WidgetServerSettingsMembersModel widgetServerSettingsMembersModel = (WidgetServerSettingsMembersModel) other;
        return Intrinsics3.areEqual(this.guild, widgetServerSettingsMembersModel.guild) && Intrinsics3.areEqual(this.roles, widgetServerSettingsMembersModel.roles) && Intrinsics3.areEqual(this.memberItems, widgetServerSettingsMembersModel.memberItems) && Intrinsics3.areEqual(this.myHighestRole, widgetServerSettingsMembersModel.myHighestRole) && Intrinsics3.areEqual(this.meUser, widgetServerSettingsMembersModel.meUser) && this.canKick == widgetServerSettingsMembersModel.canKick && this.canManageMembers == widgetServerSettingsMembersModel.canManageMembers;
    }

    public final boolean getCanKick() {
        return this.canKick;
    }

    public final boolean getCanManageMembers() {
        return this.canManageMembers;
    }

    public final Guild getGuild() {
        return this.guild;
    }

    public final MeUser getMeUser() {
        return this.meUser;
    }

    public final List<MemberItem> getMemberItems() {
        return this.memberItems;
    }

    public final GuildRole getMyHighestRole() {
        return this.myHighestRole;
    }

    public final Map<Long, GuildRole> getRoles() {
        return this.roles;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r1v7 */
    /* JADX WARN: Type inference failed for: r2v10 */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    public int hashCode() {
        Guild guild = this.guild;
        int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
        Map<Long, GuildRole> map = this.roles;
        int iHashCode2 = (iHashCode + (map != null ? map.hashCode() : 0)) * 31;
        List<MemberItem> list = this.memberItems;
        int iHashCode3 = (iHashCode2 + (list != null ? list.hashCode() : 0)) * 31;
        GuildRole guildRole = this.myHighestRole;
        int iHashCode4 = (iHashCode3 + (guildRole != null ? guildRole.hashCode() : 0)) * 31;
        MeUser meUser = this.meUser;
        int iHashCode5 = (iHashCode4 + (meUser != null ? meUser.hashCode() : 0)) * 31;
        boolean z2 = this.canKick;
        ?? r1 = z2;
        if (z2) {
            r1 = 1;
        }
        int i = (iHashCode5 + r1) * 31;
        boolean z3 = this.canManageMembers;
        return i + (z3 ? 1 : z3);
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetServerSettingsMembersModel(guild=");
        sbU.append(this.guild);
        sbU.append(", roles=");
        sbU.append(this.roles);
        sbU.append(", memberItems=");
        sbU.append(this.memberItems);
        sbU.append(", myHighestRole=");
        sbU.append(this.myHighestRole);
        sbU.append(", meUser=");
        sbU.append(this.meUser);
        sbU.append(", canKick=");
        sbU.append(this.canKick);
        sbU.append(", canManageMembers=");
        return outline.O(sbU, this.canManageMembers, ")");
    }
}
