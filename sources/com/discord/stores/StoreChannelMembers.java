package com.discord.stores;

import com.discord.C5419R;
import com.discord.api.channel.Channel;
import com.discord.api.permission.Permission;
import com.discord.api.permission.PermissionOverwrite;
import com.discord.api.role.GuildRole;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelGuildMemberListUpdate;
import com.discord.models.guild.Guild;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.User;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.PermissionOverwriteUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.icon.IconUtils;
import com.discord.utilities.lazy.memberlist.ChannelMemberList;
import com.discord.utilities.lazy.memberlist.MemberListRow;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.permissions.PermissionUtils;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p642l.p647e.C12723m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: StoreChannelMembers.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannelMembers extends StoreV2 {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelMembers$1 */
    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class C58121 extends AbstractC12240o implements Function1<Unit, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreChannelMembers$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreChannelMembers.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass1() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreChannelMembers.this.markChanged();
            }
        }

        public C58121() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Unit unit) {
            invoke2(unit);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Unit unit) {
            StoreChannelMembers.this.dispatcher.schedule(new AnonymousClass1());
        }
    }

    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class Companion {
        private Companion() {
        }

        public final MemberListRow.Member makeRowMember(long userId, Map<Long, GuildMember> guildMembers, Map<Long, ? extends User> users, Presence presence, boolean isUserStreaming, boolean showOwnerIndicator) {
            C12238m.checkNotNullParameter(users, "users");
            GuildMember guildMember = guildMembers != null ? guildMembers.get(Long.valueOf(userId)) : null;
            User user = users.get(Long.valueOf(userId));
            if (user == null || guildMember == null) {
                return null;
            }
            return new MemberListRow.Member(userId, GuildMember.INSTANCE.getNickOrUsername(guildMember, user), user.getIsBot(), Integer.valueOf(user.getIsSystemUser() ? C5419R.string.system_dm_tag_system : C5419R.string.bot_tag_bot), UserUtils.INSTANCE.isVerifiedBot(user), presence, guildMember.getColor() != -16777216 ? Integer.valueOf(guildMember.getColor()) : null, IconUtils.getForGuildMemberOrUser$default(IconUtils.INSTANCE, user, guildMember, null, false, 12, null), showOwnerIndicator, guildMember.getPremiumSince(), isUserStreaming, user.getFlags() | user.getPublicFlags());
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class MemberListIdCalculator {
        public static final MemberListIdCalculator INSTANCE = new MemberListIdCalculator();

        private MemberListIdCalculator() {
        }

        /* JADX WARN: Code duplicated, block: B:17:0x0079  */
        private final String computeIdFromOverwrites(List<PermissionOverwrite> permissionOverwrites) {
            String strValueOf;
            String strJoinToString$default;
            if (permissionOverwrites != null) {
                ArrayList arrayList = new ArrayList();
                for (PermissionOverwrite permissionOverwrite : permissionOverwrites) {
                    if (PermissionOverwriteUtilsKt.allows(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                        StringBuilder sbM833U = C1643a.m833U("allow:");
                        sbM833U.append(permissionOverwrite.m8131e());
                        arrayList.add(sbM833U.toString());
                    } else if (PermissionOverwriteUtilsKt.denies(permissionOverwrite, Permission.VIEW_CHANNEL)) {
                        StringBuilder sbM833U2 = C1643a.m833U("deny:");
                        sbM833U2.append(permissionOverwrite.m8131e());
                        arrayList.add(sbM833U2.toString());
                    }
                }
                List listSorted = C12163u.sorted(arrayList);
                if (listSorted == null || (strJoinToString$default = C12163u.joinToString$default(listSorted, ",", null, null, 0, null, null, 62, null)) == null) {
                    strValueOf = null;
                } else {
                    strValueOf = String.valueOf(INSTANCE.toUnsignedLong(C12723m.m10822a(strJoinToString$default, 0, strJoinToString$default.length(), 0)));
                }
            } else {
                strValueOf = null;
            }
            return strValueOf != null ? strValueOf : "";
        }

        private final long toUnsignedLong(int i) {
            return ((long) i) & 4294967295L;
        }

        public final String computeMemberListId(Function1<? super Long, Channel> channelsProvider, long channelId, StoreGuilds storeGuilds) {
            C12238m.checkNotNullParameter(channelsProvider, "channelsProvider");
            C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
            Channel channelInvoke = channelsProvider.invoke(Long.valueOf(channelId));
            String memberListId = channelInvoke != null ? channelInvoke.getMemberListId() : null;
            if (channelInvoke != null) {
                if (memberListId != null) {
                    return memberListId;
                }
                Map mapEmptyMap = (Map) C1643a.m843c(channelInvoke, storeGuilds.getRoles());
                if (mapEmptyMap == null) {
                    mapEmptyMap = C12136h0.emptyMap();
                }
                if (!PermissionUtils.canEveryone(Permission.VIEW_CHANNEL, channelInvoke, null, mapEmptyMap)) {
                    return computeIdFromOverwrites(channelInvoke.m7655v());
                }
            }
            return ModelGuildMemberListUpdate.EVERYONE_ID;
        }
    }

    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class MemberListUpdateException extends RuntimeException {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MemberListUpdateException(Exception exc) {
            super(exc);
            C12238m.checkNotNullParameter(exc, "e");
        }
    }

    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class MemberListUpdateLogger {
        private static final String ERROR_TAG = "MemberListUpdateError";
        private static final int MAX_UPDATE_COUNT = 20;
        public static final MemberListUpdateLogger INSTANCE = new MemberListUpdateLogger();
        private static final Map<String, List<String>> opLogs = new HashMap();

        private MemberListUpdateLogger() {
        }

        private final String makeLogKey(long guildId, String memberListId) {
            return guildId + MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR + memberListId;
        }

        public final void dumpLogs(long guildId, String memberListId, Exception exception) {
            C12238m.checkNotNullParameter(memberListId, "memberListId");
            C12238m.checkNotNullParameter(exception, "exception");
            List<String> list = opLogs.get(makeLogKey(guildId, memberListId));
            StringBuilder sb = new StringBuilder();
            sb.append("guildId: ");
            sb.append(guildId);
            sb.append(" -- memberListId: ");
            sb.append(memberListId);
            sb.append(" -- LAST 20 UPDATES:\n");
            sb.append(list != null ? C12163u.joinToString$default(list, "\n", null, null, 0, null, null, 62, null) : null);
            FirebaseCrashlytics.getInstance().log(sb.toString());
            Logger.e$default(AppLog.f14950g, ERROR_TAG, new MemberListUpdateException(exception), null, 4, null);
        }

        public final void logUpdate(ModelGuildMemberListUpdate update) {
            String string;
            C12238m.checkNotNullParameter(update, "update");
            List<ModelGuildMemberListUpdate.Operation> operations = update.getOperations();
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(operations, 10));
            for (ModelGuildMemberListUpdate.Operation operation : operations) {
                if (operation instanceof ModelGuildMemberListUpdate.Operation.Sync) {
                    StringBuilder sbM833U = C1643a.m833U("  SYNC: ");
                    sbM833U.append(((ModelGuildMemberListUpdate.Operation.Sync) operation).getRange());
                    string = sbM833U.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Update) {
                    StringBuilder sbM833U2 = C1643a.m833U("  UPDATE: ");
                    sbM833U2.append(((ModelGuildMemberListUpdate.Operation.Update) operation).getIndex());
                    string = sbM833U2.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Insert) {
                    StringBuilder sbM833U3 = C1643a.m833U("  INSERT: ");
                    sbM833U3.append(((ModelGuildMemberListUpdate.Operation.Insert) operation).getIndex());
                    string = sbM833U3.toString();
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Delete) {
                    StringBuilder sbM833U4 = C1643a.m833U("  DELETE: ");
                    sbM833U4.append(((ModelGuildMemberListUpdate.Operation.Delete) operation).getIndex());
                    string = sbM833U4.toString();
                } else {
                    if (!(operation instanceof ModelGuildMemberListUpdate.Operation.Invalidate)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    StringBuilder sbM833U5 = C1643a.m833U("  INVALIDATE: ");
                    sbM833U5.append(((ModelGuildMemberListUpdate.Operation.Invalidate) operation).getRange());
                    string = sbM833U5.toString();
                }
                arrayList.add(string);
            }
            String strM822J = C1643a.m822J(C1643a.m833U("GROUPS: ["), C12163u.joinToString$default(update.getGroups(), ",", null, null, 0, null, StoreChannelMembers$MemberListUpdateLogger$logUpdate$groupLog$1.INSTANCE, 30, null), "]");
            ArrayList arrayList2 = new ArrayList();
            arrayList2.addAll(arrayList);
            arrayList2.add(strM822J);
            arrayList2.add("-----");
            String strMakeLogKey = makeLogKey(update.getGuildId(), update.getId());
            Map<String, List<String>> map = opLogs;
            List<String> arrayList3 = map.get(strMakeLogKey);
            if (arrayList3 == null) {
                arrayList3 = new ArrayList<>();
            }
            arrayList3.add(C12163u.joinToString$default(arrayList2, "\n", null, null, 0, null, null, 62, null));
            if (arrayList3.size() > 20) {
                arrayList3.remove(0);
            }
            map.put(strMakeLogKey, arrayList3);
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            ModelGuildMemberListUpdate.Group.Type.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[ModelGuildMemberListUpdate.Group.Type.ROLE.ordinal()] = 1;
            iArr[ModelGuildMemberListUpdate.Group.Type.OFFLINE.ordinal()] = 2;
            iArr[ModelGuildMemberListUpdate.Group.Type.ONLINE.ordinal()] = 3;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelMembers$handleGuildMemberListUpdate$2 */
    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class C58132 extends AbstractC12240o implements Function1<ModelGuildMemberListUpdate.Group, MemberListRow> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58132(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public final MemberListRow invoke(ModelGuildMemberListUpdate.Group group) {
            C12238m.checkNotNullParameter(group, "it");
            return StoreChannelMembers.this.makeGroup(this.$guildId, group);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreChannelMembers$observeChannelMemberList$1 */
    /* JADX INFO: compiled from: StoreChannelMembers.kt */
    public static final class C58151 extends AbstractC12240o implements Function0<ChannelMemberList> {
        public final /* synthetic */ long $channelId;
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C58151(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$channelId = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final ChannelMemberList invoke() {
            return StoreChannelMembers.this.getChannelMemberList(this.$guildId, this.$channelId);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public StoreChannelMembers(ObservationDeck observationDeck, Dispatcher dispatcher, StoreGuilds storeGuilds, StoreUser storeUser, Function1<? super Long, Channel> function1, Function1<? super Long, Integer> function2, Function1<? super Long, Presence> function3, Function1<? super Long, Boolean> function4) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(function1, "getChannel");
        C12238m.checkNotNullParameter(function2, "getGuildMemberCount");
        C12238m.checkNotNullParameter(function3, "getPresence");
        C12238m.checkNotNullParameter(function4, "isUserStreaming");
        this.observationDeck = observationDeck;
        this.dispatcher = dispatcher;
        this.storeGuilds = storeGuilds;
        this.storeUser = storeUser;
        this.getChannel = function1;
        this.getGuildMemberCount = function2;
        this.getPresence = function3;
        this.isUserStreaming = function4;
        this.memberLists = new LinkedHashMap();
        this.memberListsSnapshot = C12136h0.emptyMap();
        PublishSubject<Unit> publishSubjectM11133k0 = PublishSubject.m11133k0();
        this.markChangedTrigger = publishSubjectM11133k0;
        C12238m.checkNotNullExpressionValue(publishSubjectM11133k0, "markChangedTrigger");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.leadingEdgeThrottle(publishSubjectM11133k0, 1L, TimeUnit.SECONDS), (Class<?>) StoreChannelMembers.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C58121());
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
    private final void handleDelete(String memberListId, ModelGuildMemberListUpdate.Operation.Delete deleteOperation, long guildId) {
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.delete(deleteOperation.getIndex());
        }
    }

    @StoreThread
    private final void handleInsert(String memberListId, ModelGuildMemberListUpdate.Operation.Insert insertOperation, long guildId) {
        int index = insertOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.insert(index, makeRow(guildId, insertOperation.getItem()));
        }
    }

    @StoreThread
    private final void handleInvalidate(String memberListId, ModelGuildMemberListUpdate.Operation.Invalidate operation, long guildId) {
        IntRange range = operation.getRange();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.invalidate(range);
        }
    }

    @StoreThread
    private final void handleSync(String memberListId, ModelGuildMemberListUpdate.Operation.Sync syncOperation, long guildId) {
        MemberListRow memberListRowMakeGroup;
        Map<String, ChannelMemberList> map = this.memberLists.get(Long.valueOf(guildId));
        if (map == null) {
            map = new HashMap<>();
            this.memberLists.put(Long.valueOf(guildId), map);
        }
        ChannelMemberList channelMemberList = map.get(memberListId);
        if (channelMemberList == null) {
            AppLog appLog = AppLog.f14950g;
            channelMemberList = new ChannelMemberList(memberListId, 0, appLog, 2, null);
            map.put(memberListId, channelMemberList);
            appLog.recordBreadcrumb(channelMemberList.getListId() + " INSTANTIATE", "ChannelMemberList");
        }
        boolean zAllowOwnerIndicator = allowOwnerIndicator(guildId);
        List<ModelGuildMemberListUpdate.Operation.Item> items = syncOperation.getItems();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(items, 10));
        for (ModelGuildMemberListUpdate.Operation.Item item : items) {
            if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
                memberListRowMakeGroup = makeRowMember(guildId, ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember().getUser().getId(), zAllowOwnerIndicator);
            } else {
                if (!(item instanceof ModelGuildMemberListUpdate.Operation.Item.GroupItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                memberListRowMakeGroup = makeGroup(guildId, ((ModelGuildMemberListUpdate.Operation.Item.GroupItem) item).getGroup());
            }
            arrayList.add(memberListRowMakeGroup);
        }
        channelMemberList.sync(((Number) C12163u.first(syncOperation.getRange())).intValue(), arrayList);
    }

    private final void handleUpdate(String memberListId, ModelGuildMemberListUpdate.Operation.Update updateOperation, long guildId) {
        int index = updateOperation.getIndex();
        ChannelMemberList memberList = getMemberList(guildId, memberListId);
        if (memberList != null) {
            memberList.update(index, makeRow(guildId, updateOperation.getItem()));
        }
    }

    @StoreThread
    private final MemberListRow makeGroup(long guildId, ModelGuildMemberListUpdate.Group group) {
        String name;
        GuildRole guildRole;
        String id2 = group.getId();
        int iOrdinal = group.getType().ordinal();
        if (iOrdinal != 0) {
            if (iOrdinal == 1) {
                return new MemberListRow.StatusHeader(id2, MemberListRow.StatusHeader.Type.OFFLINE, group.getCount());
            }
            if (iOrdinal == 2) {
                return new MemberListRow.StatusHeader(id2, MemberListRow.StatusHeader.Type.ONLINE, group.getCount());
            }
            throw new NoWhenBranchMatchedException();
        }
        long j = Long.parseLong(id2);
        Map<Long, GuildRole> map = this.storeGuilds.getGuildRolesInternal$app_productionGoogleRelease().get(Long.valueOf(guildId));
        if (map == null || (guildRole = map.get(Long.valueOf(j))) == null || (name = guildRole.getName()) == null) {
            name = "";
        }
        return new MemberListRow.RoleHeader(j, name, group.getCount());
    }

    @StoreThread
    private final MemberListRow makeRow(long guildId, ModelGuildMemberListUpdate.Operation.Item item) {
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.MemberItem) {
            return makeRowMember(guildId, ((ModelGuildMemberListUpdate.Operation.Item.MemberItem) item).getMember().getUser().getId(), allowOwnerIndicator(guildId));
        }
        if (item instanceof ModelGuildMemberListUpdate.Operation.Item.GroupItem) {
            return makeGroup(guildId, ((ModelGuildMemberListUpdate.Operation.Item.GroupItem) item).getGroup());
        }
        throw new NoWhenBranchMatchedException();
    }

    @StoreThread
    private final MemberListRow makeRowMember(long guildId, long userId, boolean allowOwnerIndicator) {
        Guild guild;
        return INSTANCE.makeRowMember(userId, this.storeGuilds.getGuildMembersComputedInternal$app_productionGoogleRelease().get(Long.valueOf(guildId)), this.storeUser.getUsersInternal$app_productionGoogleRelease(), this.getPresence.invoke(Long.valueOf(userId)), this.isUserStreaming.invoke(Long.valueOf(userId)).booleanValue(), allowOwnerIndicator && (guild = this.storeGuilds.getGuildsInternal$app_productionGoogleRelease().get(Long.valueOf(guildId))) != null && guild.getOwnerId() == userId);
    }

    private final void throttleMarkChanged() {
        PublishSubject<Unit> publishSubject = this.markChangedTrigger;
        publishSubject.f27650k.onNext(Unit.f27425a);
    }

    public final ChannelMemberList getChannelMemberList(long guildId, long channelId) {
        String strComputeMemberListId = MemberListIdCalculator.INSTANCE.computeMemberListId(this.getChannel, channelId, this.storeGuilds);
        Map<String, ChannelMemberList> mapEmptyMap = this.memberListsSnapshot.get(Long.valueOf(guildId));
        if (mapEmptyMap == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        ChannelMemberList channelMemberList = mapEmptyMap.get(strComputeMemberListId);
        return channelMemberList != null ? channelMemberList : new ChannelMemberList(strComputeMemberListId, this.getGuildMemberCount.invoke(Long.valueOf(guildId)).intValue(), AppLog.f14950g);
    }

    @StoreThread
    public final void handleGuildMemberListUpdate(ModelGuildMemberListUpdate update) {
        C12238m.checkNotNullParameter(update, "update");
        long guildId = update.getGuildId();
        String id2 = update.getId();
        MemberListUpdateLogger.INSTANCE.logUpdate(update);
        try {
            for (ModelGuildMemberListUpdate.Operation operation : update.getOperations()) {
                if (operation instanceof ModelGuildMemberListUpdate.Operation.Sync) {
                    handleSync(id2, (ModelGuildMemberListUpdate.Operation.Sync) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Update) {
                    handleUpdate(id2, (ModelGuildMemberListUpdate.Operation.Update) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Insert) {
                    handleInsert(id2, (ModelGuildMemberListUpdate.Operation.Insert) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Delete) {
                    handleDelete(id2, (ModelGuildMemberListUpdate.Operation.Delete) operation, guildId);
                } else if (operation instanceof ModelGuildMemberListUpdate.Operation.Invalidate) {
                    handleInvalidate(id2, (ModelGuildMemberListUpdate.Operation.Invalidate) operation, guildId);
                }
            }
            ChannelMemberList memberList = getMemberList(update.getGuildId(), id2);
            if (memberList != null) {
                memberList.setGroups(update.getGroups(), new C58132(guildId));
            }
        } catch (Exception e) {
            MemberListUpdateLogger.INSTANCE.dumpLogs(guildId, id2, e);
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
            Iterator<Map.Entry<String, ChannelMemberList>> it = map.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().rebuildMembers(new C5814x791bbf43(this, guildId, zAllowOwnerIndicator));
            }
        }
        throttleMarkChanged();
    }

    public final Observable<ChannelMemberList> observeChannelMemberList(long guildId, long channelId) {
        Observable<ChannelMemberList> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this}, false, null, null, new C58151(guildId, channelId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck.connectR…  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    public void snapshotData() {
        super.snapshotData();
        Map<Long, Map<String, ChannelMemberList>> map = this.memberLists;
        LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map.size()));
        Iterator<T> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object key = entry.getKey();
            Map map2 = (Map) entry.getValue();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap(C12134g0.mapCapacity(map2.size()));
            for (Map.Entry entry2 : map2.entrySet()) {
                linkedHashMap2.put(entry2.getKey(), new ChannelMemberList((ChannelMemberList) entry2.getValue()));
            }
            linkedHashMap.put(key, linkedHashMap2);
        }
        this.memberListsSnapshot = linkedHashMap;
    }
}
