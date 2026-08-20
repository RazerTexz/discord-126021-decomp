package com.discord.widgets.channels.permissions;

import androidx.annotation.MainThread;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.user.User;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StorePermissions;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p578f0.C12078q;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$1 */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    public static final class C75651 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C75651() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel = WidgetStageChannelModeratorPermissionsViewModel.this;
            C12238m.checkNotNullExpressionValue(storeState, "storeState");
            widgetStageChannelModeratorPermissionsViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long channelId, StoreGuilds guildStore, StoreChannels channelStore, StoreUser userStore, StorePermissions permissionStore) {
            return ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{guildStore, channelStore, userStore, permissionStore}, false, null, null, new C7566xb23e47b(channelStore, channelId, guildStore, userStore, permissionStore), 14, null);
        }

        public static /* synthetic */ Observable observeStores$default(Companion companion, long j, StoreGuilds storeGuilds, StoreChannels storeChannels, StoreUser storeUser, StorePermissions storePermissions, int i, Object obj) {
            if ((i & 2) != 0) {
                storeGuilds = StoreStream.INSTANCE.getGuilds();
            }
            StoreGuilds storeGuilds2 = storeGuilds;
            if ((i & 4) != 0) {
                storeChannels = StoreStream.INSTANCE.getChannels();
            }
            StoreChannels storeChannels2 = storeChannels;
            if ((i & 8) != 0) {
                storeUser = StoreStream.INSTANCE.getUsers();
            }
            StoreUser storeUser2 = storeUser;
            if ((i & 16) != 0) {
                storePermissions = StoreStream.INSTANCE.getPermissions();
            }
            return companion.observeStores(j, storeGuilds2, storeChannels2, storeUser2, storePermissions);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    public static abstract class StoreState {

        /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        public static final class Invalid extends StoreState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        public static final /* data */ class Valid extends StoreState {
            private final boolean canEditModerators;
            private final List<PermissionOverwrite> channelPermissionOverwrites;
            private final Guild guild;
            private final Map<Long, GuildMember> guildMembers;
            private final User guildOwnerUser;
            private final Map<Long, GuildRole> guildRoles;
            private final Map<Long, User> usersWithOverwrites;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Valid(Guild guild, List<PermissionOverwrite> list, Map<Long, GuildRole> map, Map<Long, ? extends User> map2, Map<Long, GuildMember> map3, User user, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(list, "channelPermissionOverwrites");
                C12238m.checkNotNullParameter(map, "guildRoles");
                C12238m.checkNotNullParameter(map2, "usersWithOverwrites");
                C12238m.checkNotNullParameter(map3, "guildMembers");
                this.guild = guild;
                this.channelPermissionOverwrites = list;
                this.guildRoles = map;
                this.usersWithOverwrites = map2;
                this.guildMembers = map3;
                this.guildOwnerUser = user;
                this.canEditModerators = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, Guild guild, List list, Map map, Map map2, Map map3, User user, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    guild = valid.guild;
                }
                if ((i & 2) != 0) {
                    list = valid.channelPermissionOverwrites;
                }
                List list2 = list;
                if ((i & 4) != 0) {
                    map = valid.guildRoles;
                }
                Map map4 = map;
                if ((i & 8) != 0) {
                    map2 = valid.usersWithOverwrites;
                }
                Map map5 = map2;
                if ((i & 16) != 0) {
                    map3 = valid.guildMembers;
                }
                Map map6 = map3;
                if ((i & 32) != 0) {
                    user = valid.guildOwnerUser;
                }
                User user2 = user;
                if ((i & 64) != 0) {
                    z2 = valid.canEditModerators;
                }
                return valid.copy(guild, list2, map4, map5, map6, user2, z2);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Guild getGuild() {
                return this.guild;
            }

            public final List<PermissionOverwrite> component2() {
                return this.channelPermissionOverwrites;
            }

            public final Map<Long, GuildRole> component3() {
                return this.guildRoles;
            }

            public final Map<Long, User> component4() {
                return this.usersWithOverwrites;
            }

            public final Map<Long, GuildMember> component5() {
                return this.guildMembers;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final User getGuildOwnerUser() {
                return this.guildOwnerUser;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final Valid copy(Guild guild, List<PermissionOverwrite> channelPermissionOverwrites, Map<Long, GuildRole> guildRoles, Map<Long, ? extends User> usersWithOverwrites, Map<Long, GuildMember> guildMembers, User guildOwnerUser, boolean canEditModerators) {
                C12238m.checkNotNullParameter(guild, "guild");
                C12238m.checkNotNullParameter(channelPermissionOverwrites, "channelPermissionOverwrites");
                C12238m.checkNotNullParameter(guildRoles, "guildRoles");
                C12238m.checkNotNullParameter(usersWithOverwrites, "usersWithOverwrites");
                C12238m.checkNotNullParameter(guildMembers, "guildMembers");
                return new Valid(guild, channelPermissionOverwrites, guildRoles, usersWithOverwrites, guildMembers, guildOwnerUser, canEditModerators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.guild, valid.guild) && C12238m.areEqual(this.channelPermissionOverwrites, valid.channelPermissionOverwrites) && C12238m.areEqual(this.guildRoles, valid.guildRoles) && C12238m.areEqual(this.usersWithOverwrites, valid.usersWithOverwrites) && C12238m.areEqual(this.guildMembers, valid.guildMembers) && C12238m.areEqual(this.guildOwnerUser, valid.guildOwnerUser) && this.canEditModerators == valid.canEditModerators;
            }

            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final List<PermissionOverwrite> getChannelPermissionOverwrites() {
                return this.channelPermissionOverwrites;
            }

            public final Guild getGuild() {
                return this.guild;
            }

            public final Map<Long, GuildMember> getGuildMembers() {
                return this.guildMembers;
            }

            public final User getGuildOwnerUser() {
                return this.guildOwnerUser;
            }

            public final Map<Long, GuildRole> getGuildRoles() {
                return this.guildRoles;
            }

            public final Map<Long, User> getUsersWithOverwrites() {
                return this.usersWithOverwrites;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v14, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                Guild guild = this.guild;
                int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                List<PermissionOverwrite> list = this.channelPermissionOverwrites;
                int iHashCode2 = (iHashCode + (list != null ? list.hashCode() : 0)) * 31;
                Map<Long, GuildRole> map = this.guildRoles;
                int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
                Map<Long, User> map2 = this.usersWithOverwrites;
                int iHashCode4 = (iHashCode3 + (map2 != null ? map2.hashCode() : 0)) * 31;
                Map<Long, GuildMember> map3 = this.guildMembers;
                int iHashCode5 = (iHashCode4 + (map3 != null ? map3.hashCode() : 0)) * 31;
                User user = this.guildOwnerUser;
                int iHashCode6 = (iHashCode5 + (user != null ? user.hashCode() : 0)) * 31;
                boolean z2 = this.canEditModerators;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode6 + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(guild=");
                sbM833U.append(this.guild);
                sbM833U.append(", channelPermissionOverwrites=");
                sbM833U.append(this.channelPermissionOverwrites);
                sbM833U.append(", guildRoles=");
                sbM833U.append(this.guildRoles);
                sbM833U.append(", usersWithOverwrites=");
                sbM833U.append(this.usersWithOverwrites);
                sbM833U.append(", guildMembers=");
                sbM833U.append(this.guildMembers);
                sbM833U.append(", guildOwnerUser=");
                sbM833U.append(this.guildOwnerUser);
                sbM833U.append(", canEditModerators=");
                return C1643a.m827O(sbM833U, this.canEditModerators, ")");
            }
        }

        private StoreState() {
        }

        public /* synthetic */ StoreState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
        public static final /* data */ class Valid extends ViewState {
            private final boolean canEditModerators;
            private final List<PermissionOwnerListView.Item> memberItems;
            private final List<PermissionOwnerListView.Item> roleItems;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Valid(List<PermissionOwnerListView.Item> list, List<PermissionOwnerListView.Item> list2, boolean z2) {
                super(null);
                C12238m.checkNotNullParameter(list, "roleItems");
                C12238m.checkNotNullParameter(list2, "memberItems");
                this.roleItems = list;
                this.memberItems = list2;
                this.canEditModerators = z2;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Valid copy$default(Valid valid, List list, List list2, boolean z2, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = valid.roleItems;
                }
                if ((i & 2) != 0) {
                    list2 = valid.memberItems;
                }
                if ((i & 4) != 0) {
                    z2 = valid.canEditModerators;
                }
                return valid.copy(list, list2, z2);
            }

            public final List<PermissionOwnerListView.Item> component1() {
                return this.roleItems;
            }

            public final List<PermissionOwnerListView.Item> component2() {
                return this.memberItems;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final Valid copy(List<PermissionOwnerListView.Item> roleItems, List<PermissionOwnerListView.Item> memberItems, boolean canEditModerators) {
                C12238m.checkNotNullParameter(roleItems, "roleItems");
                C12238m.checkNotNullParameter(memberItems, "memberItems");
                return new Valid(roleItems, memberItems, canEditModerators);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Valid)) {
                    return false;
                }
                Valid valid = (Valid) other;
                return C12238m.areEqual(this.roleItems, valid.roleItems) && C12238m.areEqual(this.memberItems, valid.memberItems) && this.canEditModerators == valid.canEditModerators;
            }

            public final boolean getCanEditModerators() {
                return this.canEditModerators;
            }

            public final List<PermissionOwnerListView.Item> getMemberItems() {
                return this.memberItems;
            }

            public final List<PermissionOwnerListView.Item> getRoleItems() {
                return this.roleItems;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r1v6 */
            public int hashCode() {
                List<PermissionOwnerListView.Item> list = this.roleItems;
                int iHashCode = (list != null ? list.hashCode() : 0) * 31;
                List<PermissionOwnerListView.Item> list2 = this.memberItems;
                int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
                boolean z2 = this.canEditModerators;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                return iHashCode2 + r1;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Valid(roleItems=");
                sbM833U.append(this.roleItems);
                sbM833U.append(", memberItems=");
                sbM833U.append(this.memberItems);
                sbM833U.append(", canEditModerators=");
                return C1643a.m827O(sbM833U, this.canEditModerators, ")");
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetStageChannelModeratorPermissionsViewModel(long j) {
        super(null, 1, null);
        Observable observableM11112r = Companion.observeStores$default(INSTANCE, j, null, null, null, null, 30, null).m11098X(C12781a.m10873a()).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeStores(channelId)…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetStageChannelModeratorPermissionsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C75651());
    }

    private final PermissionOwnerListView.RemoveStatus getMemberRemoveStatus(StoreState.Valid storeState, boolean isOwner) {
        if (storeState.getCanEditModerators()) {
            return isOwner ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.IS_GUILD_OWNER) : PermissionOwnerListView.RemoveStatus.CanRemove.INSTANCE;
        }
        return new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.HAS_NO_PERMISSION);
    }

    private final PermissionOwnerListView.RemoveStatus getRoleRemoveStatus(StoreState.Valid storeState, GuildRole role) {
        if (!storeState.getCanEditModerators()) {
            return new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.HAS_NO_PERMISSION);
        }
        if (PermissionUtils.INSTANCE.canRole(20971536L, role, null)) {
            return new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.IS_NOT_OVERRIDE);
        }
        return (role.getPermissions() & 8) == 8 ? new PermissionOwnerListView.RemoveStatus.CannotRemove(PermissionOwnerListView.RemoveStatus.CannotRemove.Reason.IS_ADMINISTRATOR) : PermissionOwnerListView.RemoveStatus.CanRemove.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:54:0x0187  */
    @MainThread
    private final void handleStoreState(StoreState storeState) {
        List listEmptyList;
        if (!(storeState instanceof StoreState.Valid)) {
            updateViewState(ViewState.Invalid.INSTANCE);
            return;
        }
        StoreState.Valid valid = (StoreState.Valid) storeState;
        List<PermissionOverwrite> channelPermissionOverwrites = valid.getChannelPermissionOverwrites();
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = channelPermissionOverwrites.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((PermissionOverwrite) next).getType() == PermissionOverwrite.Type.ROLE) {
                arrayList.add(next);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((PermissionOverwrite) obj).m8131e()), obj);
        }
        Collection<GuildRole> collectionValues = valid.getGuildRoles().values();
        ArrayList<GuildRole> arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues) {
            GuildRole guildRole = (GuildRole) obj2;
            if ((guildRole.getPermissions() & 8) == 8 || PermissionUtils.INSTANCE.canRole(20971536L, guildRole, (PermissionOverwrite) linkedHashMap.get(Long.valueOf(guildRole.getId())))) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(C12149o.collectionSizeOrDefault(arrayList2, 10));
        for (GuildRole guildRole2 : arrayList2) {
            arrayList3.add(new PermissionOwnerListView.Item(new PermissionOwner.Role(guildRole2), getRoleRemoveStatus(valid, guildRole2)));
        }
        Set set = C12078q.toSet(C12078q.map(C12078q.filter(C12078q.filter(C12078q.filter(C12163u.asSequence(valid.getChannelPermissionOverwrites()), C7567x81232336.INSTANCE), C7568x81232337.INSTANCE), new C7569x81232338(storeState)), C7570x81232339.INSTANCE));
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = set.iterator();
        while (true) {
            PermissionOwnerListView.Item item = null;
            if (!it2.hasNext()) {
                break;
            }
            long jLongValue = ((Number) it2.next()).longValue();
            User user = valid.getUsersWithOverwrites().get(Long.valueOf(jLongValue));
            if (user != null) {
                GuildMember guildMember = valid.getGuildMembers().get(Long.valueOf(jLongValue));
                item = new PermissionOwnerListView.Item(new PermissionOwner.Member(user, guildMember != null ? guildMember.getNick() : null, false), getMemberRemoveStatus(valid, false));
            }
            if (item != null) {
                arrayList4.add(item);
            }
        }
        User guildOwnerUser = valid.getGuildOwnerUser();
        if (guildOwnerUser == null) {
            listEmptyList = C12147n.emptyList();
        } else {
            GuildMember guildMember2 = (GuildMember) C1643a.m849f(guildOwnerUser, valid.getGuildMembers());
            listEmptyList = C12145m.listOf(new PermissionOwnerListView.Item(new PermissionOwner.Member(guildOwnerUser, guildMember2 != null ? guildMember2.getNick() : null, true), getMemberRemoveStatus(valid, true)));
            if (listEmptyList == null) {
                listEmptyList = C12147n.emptyList();
            }
        }
        updateViewState(new ViewState.Valid(arrayList3, C12163u.plus((Collection) arrayList4, (Iterable) listEmptyList), valid.getCanEditModerators()));
    }
}
