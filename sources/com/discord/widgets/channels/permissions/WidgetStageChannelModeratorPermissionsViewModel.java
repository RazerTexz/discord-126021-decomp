package com.discord.widgets.channels.permissions;

import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
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
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.channels.permissions.PermissionOwner;
import com.discord.widgets.channels.permissions.PermissionOwnerListView;
import d0.d0._Ranges;
import d0.f0._Sequences2;
import d0.t.Collections2;
import d0.t.CollectionsJVM;
import d0.t.Iterables2;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.p.Schedulers2;
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
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetStageChannelModeratorPermissionsViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetStageChannelModeratorPermissionsViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<StoreState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            WidgetStageChannelModeratorPermissionsViewModel widgetStageChannelModeratorPermissionsViewModel = WidgetStageChannelModeratorPermissionsViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            widgetStageChannelModeratorPermissionsViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: WidgetStageChannelModeratorPermissionsViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStores(long channelId, StoreGuilds guildStore, StoreChannels channelStore, StoreUser userStore, StorePermissions permissionStore) {
            return ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{guildStore, channelStore, userStore, permissionStore}, false, null, null, new WidgetStageChannelModeratorPermissionsViewModel2(channelStore, channelId, guildStore, userStore, permissionStore), 14, null);
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
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(list, "channelPermissionOverwrites");
                Intrinsics3.checkNotNullParameter(map, "guildRoles");
                Intrinsics3.checkNotNullParameter(map2, "usersWithOverwrites");
                Intrinsics3.checkNotNullParameter(map3, "guildMembers");
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
                Intrinsics3.checkNotNullParameter(guild, "guild");
                Intrinsics3.checkNotNullParameter(channelPermissionOverwrites, "channelPermissionOverwrites");
                Intrinsics3.checkNotNullParameter(guildRoles, "guildRoles");
                Intrinsics3.checkNotNullParameter(usersWithOverwrites, "usersWithOverwrites");
                Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
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
                return Intrinsics3.areEqual(this.guild, valid.guild) && Intrinsics3.areEqual(this.channelPermissionOverwrites, valid.channelPermissionOverwrites) && Intrinsics3.areEqual(this.guildRoles, valid.guildRoles) && Intrinsics3.areEqual(this.usersWithOverwrites, valid.usersWithOverwrites) && Intrinsics3.areEqual(this.guildMembers, valid.guildMembers) && Intrinsics3.areEqual(this.guildOwnerUser, valid.guildOwnerUser) && this.canEditModerators == valid.canEditModerators;
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
                StringBuilder sbU = outline.U("Valid(guild=");
                sbU.append(this.guild);
                sbU.append(", channelPermissionOverwrites=");
                sbU.append(this.channelPermissionOverwrites);
                sbU.append(", guildRoles=");
                sbU.append(this.guildRoles);
                sbU.append(", usersWithOverwrites=");
                sbU.append(this.usersWithOverwrites);
                sbU.append(", guildMembers=");
                sbU.append(this.guildMembers);
                sbU.append(", guildOwnerUser=");
                sbU.append(this.guildOwnerUser);
                sbU.append(", canEditModerators=");
                return outline.O(sbU, this.canEditModerators, ")");
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
                Intrinsics3.checkNotNullParameter(list, "roleItems");
                Intrinsics3.checkNotNullParameter(list2, "memberItems");
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
                Intrinsics3.checkNotNullParameter(roleItems, "roleItems");
                Intrinsics3.checkNotNullParameter(memberItems, "memberItems");
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
                return Intrinsics3.areEqual(this.roleItems, valid.roleItems) && Intrinsics3.areEqual(this.memberItems, valid.memberItems) && this.canEditModerators == valid.canEditModerators;
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
                StringBuilder sbU = outline.U("Valid(roleItems=");
                sbU.append(this.roleItems);
                sbU.append(", memberItems=");
                sbU.append(this.memberItems);
                sbU.append(", canEditModerators=");
                return outline.O(sbU, this.canEditModerators, ")");
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
        Observable observableR = Companion.observeStores$default(INSTANCE, j, null, null, null, null, 30, null).X(Schedulers2.a()).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "observeStores(channelId)…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), (Class<?>) WidgetStageChannelModeratorPermissionsViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
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
        LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(arrayList, 10)), 16));
        for (Object obj : arrayList) {
            linkedHashMap.put(Long.valueOf(((PermissionOverwrite) obj).e()), obj);
        }
        Collection<GuildRole> collectionValues = valid.getGuildRoles().values();
        ArrayList<GuildRole> arrayList2 = new ArrayList();
        for (Object obj2 : collectionValues) {
            GuildRole guildRole = (GuildRole) obj2;
            if ((guildRole.getPermissions() & 8) == 8 || PermissionUtils.INSTANCE.canRole(20971536L, guildRole, (PermissionOverwrite) linkedHashMap.get(Long.valueOf(guildRole.getId())))) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = new ArrayList(Iterables2.collectionSizeOrDefault(arrayList2, 10));
        for (GuildRole guildRole2 : arrayList2) {
            arrayList3.add(new PermissionOwnerListView.Item(new PermissionOwner.Role(guildRole2), getRoleRemoveStatus(valid, guildRole2)));
        }
        Set set = _Sequences2.toSet(_Sequences2.map(_Sequences2.filter(_Sequences2.filter(_Sequences2.filter(_Collections.asSequence(valid.getChannelPermissionOverwrites()), WidgetStageChannelModeratorPermissionsViewModel3.INSTANCE), WidgetStageChannelModeratorPermissionsViewModel4.INSTANCE), new WidgetStageChannelModeratorPermissionsViewModel5(storeState)), WidgetStageChannelModeratorPermissionsViewModel6.INSTANCE));
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
            listEmptyList = Collections2.emptyList();
        } else {
            GuildMember guildMember2 = (GuildMember) outline.f(guildOwnerUser, valid.getGuildMembers());
            listEmptyList = CollectionsJVM.listOf(new PermissionOwnerListView.Item(new PermissionOwner.Member(guildOwnerUser, guildMember2 != null ? guildMember2.getNick() : null, true), getMemberRemoveStatus(valid, true)));
            if (listEmptyList == null) {
                listEmptyList = Collections2.emptyList();
            }
        }
        updateViewState(new ViewState.Valid(arrayList3, _Collections.plus((Collection) arrayList4, (Iterable) listEmptyList), valid.getCanEditModerators()));
    }
}
