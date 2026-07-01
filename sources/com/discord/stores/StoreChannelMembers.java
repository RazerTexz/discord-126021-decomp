package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.role.GuildRole;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.domain.ModelGuildMemberListUpdate$Group;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Delete;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Insert;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Invalidate;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item$GroupItem;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Item$MemberItem;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Sync;
import com.discord.models.domain.ModelGuildMemberListUpdate$Operation$Update;
import com.discord.models.guild.Guild;
import com.discord.models.presence.Presence;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.lazy.memberlist.MemberListRow$RoleHeader;
import com.discord.utilities.lazy.memberlist.MemberListRow$StatusHeader;
import com.discord.utilities.lazy.memberlist.MemberListRow$StatusHeader$Type;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.t.g0;
import d0.t.h0;
import d0.t.o;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.IntRange;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers extends StoreV2 {
    public static final StoreChannelMembers$Companion Companion = new StoreChannelMembers$Companion(null);
    private final Dispatcher dispatcher;
    private final Function1<Long, Channel> getChannel;
    private final Function1<Long, Integer> getGuildMemberCount;
    private final Function1<Long, Presence> getPresence;
    private final Function1<Long, Boolean> isUserStreaming;
    private final PublishSubject<Unit> markChangedTrigger;
    private final Map<Long, Map<String, ChannelMemberList>> memberLists;
    private Map<Long, ? extends Map<String, ChannelMemberList>> memberListsSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;

    /* JADX WARN: Multi-variable type inference failed */
    public StoreChannelMembers(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreUser storeUser, Function1<? super Long, Channel> function1, Function1<? super Long, Integer> function2, Function1<? super Long, Presence> function3, Function1<? super Long, Boolean> function4) {
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(dispatcher, "dispatcher");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(storeUser, "storeUser");
        m.checkNotNullParameter(function1, "getChannel");
        m.checkNotNullParameter(function2, "getGuildMemberCount");
        m.checkNotNullParameter(function3, "getPresence");
        m.checkNotNullParameter(function4, "isUserStreaming");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.getChannel = function1;
        this.getGuildMemberCount = function2;
        this.getPresence = function3;
        this.isUserStreaming = function4;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = h0.emptyMap();
        PublishSubject<Unit> publishSubjectK0 = PublishSubject.k0();
        this.markChangedTrigger = publishSubjectK0;
        m.checkNotNullExpressionValue(publishSubjectK0, "markChangedTrigger");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.leadingEdgeThrottle(publishSubjectK0, 1L, TimeUnit.SECONDS), StoreChannelMembers.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreChannelMembers$1(this), 62, (Object) null);
    }

    public static final /* synthetic */ Dispatcher access$getDispatcher$p(StoreChannelMembers storeChannelMembers) {
        return storeChannelMembers.dispatcher;
    }

    public static final /* synthetic */ MemberListRow access$makeGroup(StoreChannelMembers storeChannelMembers, long j, ModelGuildMemberListUpdate$Group modelGuildMemberListUpdate$Group) {
        return storeChannelMembers.makeGroup(j, modelGuildMemberListUpdate$Group);
    }

    public static final /* synthetic */ MemberListRow access$makeRowMember(StoreChannelMembers storeChannelMembers, long j, long j2, boolean z2) {
        return storeChannelMembers.makeRowMember(j, j2, z2);
    }

    @StoreThread
    private final boolean allowOwnerIndicator(long guildId) {
        Collection<GuildRole> collectionValues;
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        boolean z2 = false;
        if (map != null && (collectionValues = map.values()) != null && !collectionValues.isEmpty()) {
            for (GuildRole guildRole : collectionValues) {
                if (guildRole.getHoist() && PermissionUtils.can(8L, Long.valueOf(guildRole.getPermissions()))) {
                    z2 = true;
                    break;
                }
            }
        }
        return !z2;
    }

    @StoreThread
    private final ChannelMemberList getMemberList(long guildId, String memberListId) {
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(memberListId);
        }
        return null;
    }

    @StoreThread
    private final void handleDelete(String memberListId, ModelGuildMemberListUpdate$Operation$Delete deleteOperation, long guildId) {
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.delete(deleteOperation.getIndex());
        }
    }

    @StoreThread
    private final void handleInsert(String memberListId, ModelGuildMemberListUpdate$Operation$Insert insertOperation, long guildId) {
        int index = insertOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.insert(index, makeRow(guildId, insertOperation.getItem()));
        }
    }

    @StoreThread
    private final void handleInvalidate(String memberListId, ModelGuildMemberListUpdate$Operation$Invalidate operation, long guildId) {
        IntRange range = operation.getRange();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.invalidate(range);
        }
    }

    @StoreThread
    private final void handleSync(String memberListId, ModelGuildMemberListUpdate$Operation$Sync syncOperation, long guildId) {
        MemberListRow memberListRowMakeGroup;
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map == null) {
            map = new HashMap<>();
            this.memberLists.put(Long.valueOf(guildId), map);
        }
        ChannelMemberList channelMemberList = map.get(memberListId);
        if (channelMemberList == null) {
            AppLog appLog = AppLog.g;
            channelMemberList = new ChannelMemberList(memberListId, 0, appLog, 2, null);
            map.put(memberListId, channelMemberList);
            appLog.recordBreadcrumb(channelMemberList.getListId() + " INSTANTIATE", "ChannelMemberList");
        }
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        List<ModelGuildMemberListUpdate$Operation$Item> items = syncOperation.getItems();
        ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(items, 10));
        for (ModelGuildMemberListUpdate$Operation$Item modelGuildMemberListUpdate$Operation$Item : items) {
            if (modelGuildMemberListUpdate$Operation$Item instanceof ModelGuildMemberListUpdate$Operation$Item$MemberItem) {
                memberListRowMakeGroup = makeRowMember(guildId, ((ModelGuildMemberListUpdate$Operation$Item$MemberItem) modelGuildMemberListUpdate$Operation$Item).getMember().getUser().getId(), zAllowOwnerIndicator);
            } else {
                if (!(modelGuildMemberListUpdate$Operation$Item instanceof ModelGuildMemberListUpdate$Operation$Item$GroupItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                memberListRowMakeGroup = makeGroup(guildId, ((ModelGuildMemberListUpdate$Operation$Item$GroupItem) modelGuildMemberListUpdate$Operation$Item).getGroup());
            }
            arrayList.add(memberListRowMakeGroup);
        }
        channelMemberList.sync(((Number) u.first(syncOperation.getRange())).intValue(), arrayList);
    }

    private final void handleUpdate(String memberListId, ModelGuildMemberListUpdate$Operation$Update updateOperation, long guildId) {
        int index = updateOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.update(index, makeRow(guildId, updateOperation.getItem()));
        }
    }

    @StoreThread
    private final MemberListRow makeGroup(long guildId, ModelGuildMemberListUpdate$Group group) {
        String name;
        GuildRole guildRole;
        String id2 = group.getId();
        int iOrdinal = group.getType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return new MemberListRow$StatusHeader(id2, MemberListRow$StatusHeader$Type.OFFLINE, group.getCount());
            }
            if (iOrdinal == 2) {
                return new MemberListRow$StatusHeader(id2, MemberListRow$StatusHeader$Type.ONLINE, group.getCount());
            }
            throw new NoWhenBranchMatchedException();
        }
        long j = Long.parseLong(id2);
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (map == null || (guildRole = map.get(Long.valueOf(j))) == null || (name = guildRole.getName()) == null) {
            name = "";
        }
        return new MemberListRow$RoleHeader(j, name, group.getCount());
    }

    @StoreThread
    private final MemberListRow makeRow(long guildId, ModelGuildMemberListUpdate$Operation$Item item) {
        if (item instanceof ModelGuildMemberListUpdate$Operation$Item$MemberItem) {
            return makeRowMember(guildId, ((ModelGuildMemberListUpdate$Operation$Item$MemberItem) item).getMember().getUser().getId(), allowOwnerIndicator(guildId));
        }
        if (item instanceof ModelGuildMemberListUpdate$Operation$Item$GroupItem) {
            return makeGroup(guildId, ((ModelGuildMemberListUpdate$Operation$Item$GroupItem) item).getGroup());
        }
        throw new NoWhenBranchMatchedException();
    }

    @StoreThread
    private final MemberListRow makeRowMember(long guildId, long userId, boolean allowOwnerIndicator) {
        Guild guild;
        return Companion.makeRowMember(userId, this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId)), this.storeUser.getUsersInternal$app_productionGoogleRelease(), this.getPresence.invoke(Long.valueOf(userId)), this.isUserStreaming.invoke(Long.valueOf(userId)).booleanValue(), allowOwnerIndicator && (guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) != null && guild.getOwnerId() == userId);
    }

    private final void throttleMarkChanged() {
        PublishSubject<Unit> publishSubject = this.markChangedTrigger;
        publishSubject.k.onNext(Unit.a);
    }

    public final ChannelMemberList getChannelMemberList(long guildId, long channelId) {
        String strComputeMemberListId = StoreChannelMembers$MemberListIdCalculator.INSTANCE.computeMemberListId(this.getChannel, channelId, this.storeGuilds);
        Map<String, ChannelMemberList> mapEmptyMap = this.memberListsSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = h0.emptyMap();
        }
        ChannelMemberList channelMemberList = mapEmptyMap.get(strComputeMemberListId);
        return channelMemberList != null ? channelMemberList : new ChannelMemberList(strComputeMemberListId, this.getGuildMemberCount.invoke(Long.valueOf(guildId)).intValue(), AppLog.g);
    }

    @StoreThread
    public final void handleGuildMemberListUpdate(ModelGuildMemberListUpdate update) {
        m.checkNotNullParameter(update, "update");
        long guildId = update.getGuildId();
        String id2 = update.getId();
        StoreChannelMembers$MemberListUpdateLogger.INSTANCE.logUpdate(update);
        try {
            for (ModelGuildMemberListUpdate$Operation modelGuildMemberListUpdate$Operation : update.getOperations()) {
                if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Sync) {
                    handleSync(id2, (ModelGuildMemberListUpdate$Operation$Sync) modelGuildMemberListUpdate$Operation, guildId);
                } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Update) {
                    handleUpdate(id2, (ModelGuildMemberListUpdate$Operation$Update) modelGuildMemberListUpdate$Operation, guildId);
                } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Insert) {
                    handleInsert(id2, (ModelGuildMemberListUpdate$Operation$Insert) modelGuildMemberListUpdate$Operation, guildId);
                } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Delete) {
                    handleDelete(id2, (ModelGuildMemberListUpdate$Operation$Delete) modelGuildMemberListUpdate$Operation, guildId);
                } else if (modelGuildMemberListUpdate$Operation instanceof ModelGuildMemberListUpdate$Operation$Invalidate) {
                    handleInvalidate(id2, (ModelGuildMemberListUpdate$Operation$Invalidate) modelGuildMemberListUpdate$Operation, guildId);
                }
            }
            ChannelMemberList memberList = getMemberList(update.getGuildId(), id2);
            if (memberList != null) {
                memberList.setGroups(update.getGroups(), new StoreChannelMembers$handleGuildMemberListUpdate$2(this, guildId));
            }
        } catch (Exception e) {
            StoreChannelMembers$MemberListUpdateLogger.INSTANCE.dumpLogs(guildId, id2, e);
        }
        throttleMarkChanged();
    }

    @StoreThread
    public final void handleGuildRemove(long guildId) {
        if (this.memberLists.remove(Long.valueOf(guildId)) != null) {
            throttleMarkChanged();
        }
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate(long guildId) {
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map != null) {
            Iterator<Map$Entry<String, ChannelMemberList>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().rebuildMembers(new StoreChannelMembers$handleGuildRoleCreateOrUpdate$$inlined$forEach$lambda$1(this, guildId, zAllowOwnerIndicator));
            }
        }
        throttleMarkChanged();
    }

    public final Observable<ChannelMemberList> observeChannelMemberList(long guildId, long channelId) {
        Observable<ChannelMemberList> observableR = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreChannelMembers$observeChannelMemberList$1(this, guildId, channelId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Map<String, ChannelMemberList>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry map$Entry = (Map$Entry) it.next();
            Object key = map$Entry.getKey();
            Map map2 = (Map) map$Entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(g0.mapCapacity(map2.size()));
            for (Map$Entry map$Entry2 : map2.entrySet()) {
                linkedHashMap2.put(map$Entry2.getKey(), new ChannelMemberList((ChannelMemberList) map$Entry2.getValue()));
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.memberListsSnapshot = linkedHashMap;
    }
}
