package com.discord.stores;

import android.content.Context;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildVerificationLevel;
import com.discord.api.guildmember.GuildMember;
import com.discord.api.guildmember.GuildMembersChunk;
import com.discord.api.guildscheduledevent.ApiGuildScheduledEventUser;
import com.discord.api.role.GuildRole;
import com.discord.api.thread.AugmentedThreadMember;
import com.discord.api.thread.ThreadListMember;
import com.discord.api.thread.ThreadMemberListUpdate;
import com.discord.api.thread.ThreadMembersUpdate;
import com.discord.api.utcdatetime.UtcDateTime;
import com.discord.app.AppComponent;
import com.discord.models.domain.ModelPayload;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.collections.CollectionExtensionsKt;
import com.discord.utilities.collections.SnowflakePartitionMap;
import com.discord.utilities.error.Error;
import com.discord.utilities.guildmember.GuildMemberUtilsKt;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.guilds.RoleUtils;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.persister.Persister;
import com.discord.utilities.rest.RestAPI;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.C0879o;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12145m;
import p507d0.p580t.C12148n0;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds extends StoreV2 {
    private static final int HUGE_GUILD_SIZE = 2000;
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildMember>> guildMembers;
    private final Map<Long, Map<Long, com.discord.models.member.GuildMember>> guildMembersComputed;
    private Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> guildMembersComputedSnapshot;
    private final Map<Long, Map<Long, GuildRole>> guildRoles;
    private final Persister<Map<Long, Map<Long, GuildRole>>> guildRolesCache;
    private Map<Long, ? extends Map<Long, GuildRole>> guildRolesSnapshot;
    private final Map<Long, Guild> guilds;
    private final Persister<Map<Long, Guild>> guildsCache;
    private final Map<Long, Long> guildsJoinedAt;
    private final Persister<Map<Long, Long>> guildsJoinedAtCache;
    private Map<Long, Long> guildsJoinedAtSnapshot;
    private Map<Long, Guild> guildsSnapshot;
    private final Set<Long> guildsUnavailable;
    private Set<Long> guildsUnavailableSnapshot;
    private final ObservationDeck observationDeck;
    private final StoreUser userStore;
    private static final Map<Long, com.discord.models.member.GuildMember> emptyComputedMap = new HashMap();
    private static final Map<Long, GuildRole> emptyRoles = new HashMap();
    private static final StoreGuilds$Companion$GuildsUpdate$1 GuildsUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreGuilds$Companion$GuildsUpdate$1
    };
    private static final StoreGuilds$Companion$ComputedMembersUpdate$1 ComputedMembersUpdate = new ObservationDeck.UpdateSource() { // from class: com.discord.stores.StoreGuilds$Companion$ComputedMembersUpdate$1
    };

    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class Actions {
        public static final Actions INSTANCE = new Actions();

        private Actions() {
        }

        public static final void requestMembers(AppComponent fragment, Observable<String> partialUserNameTokenEmitted, final boolean autocomplete) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(partialUserNameTokenEmitted, "partialUserNameTokenEmitted");
            Observable observableM11099Y = partialUserNameTokenEmitted.m11110p(1000L, TimeUnit.MILLISECONDS).m11083G(new InterfaceC12589b<String, String>() { // from class: com.discord.stores.StoreGuilds$Actions$requestMembers$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final String call(String str) {
                    if (autocomplete) {
                        if (!(str == null || str.length() == 0) && str.charAt(0) == '@') {
                            String strSubstring = str.substring(1);
                            C12238m.checkNotNullExpressionValue(strSubstring, "(this as java.lang.String).substring(startIndex)");
                            return strSubstring;
                        }
                    }
                    if (!autocomplete) {
                        if (!(str == null || str.length() == 0)) {
                            return str;
                        }
                    }
                    return null;
                }
            }).m11118y(new InterfaceC12589b<String, Boolean>() { // from class: com.discord.stores.StoreGuilds$Actions$requestMembers$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Boolean call(String str) {
                    boolean z2 = false;
                    if (str != null) {
                        int length = str.length() - 1;
                        int i = 0;
                        boolean z3 = false;
                        while (i <= length) {
                            boolean z4 = C12238m.compare(str.charAt(!z3 ? i : length), 32) <= 0;
                            if (z3) {
                                if (!z4) {
                                    break;
                                }
                                length--;
                            } else if (z4) {
                                i++;
                            } else {
                                z3 = true;
                            }
                        }
                        if (str.subSequence(i, length + 1).toString().length() > 0) {
                            z2 = true;
                        }
                    }
                    return Boolean.valueOf(z2);
                }
            }).m11112r().m11099Y(new InterfaceC12589b<String, Observable<? extends Long>>() { // from class: com.discord.stores.StoreGuilds$Actions$requestMembers$3
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends Long> call(final String str) {
                    return StoreStream.INSTANCE.getGuildSelected().observeSelectedGuildId().m11115u(new Action1<Long>() { // from class: com.discord.stores.StoreGuilds$Actions$requestMembers$3.1
                        @Override // p658rx.functions.Action1
                        public final void call(Long l) {
                            StoreGatewayConnection gatewaySocket = StoreStream.INSTANCE.getGatewaySocket();
                            C12238m.checkNotNullExpressionValue(l, "selectedGuildId");
                            StoreGatewayConnection.requestGuildMembers$default(gatewaySocket, l.longValue(), str, null, null, 12, null);
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11099Y, "partialUserNameTokenEmit…            }\n          }");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11099Y), fragment, null, 2, null), (117 & 1) != 0 ? null : null, "requestGuildMembers", (Function1<? super Subscription, Unit>) ((117 & 4) != 0 ? null : null), StoreGuilds$Actions$requestMembers$4.INSTANCE, (Function1<? super Error, Unit>) ((117 & 16) != 0 ? null : null), (Function0<Unit>) ((117 & 32) != 0 ? ObservableExtensionsKt.C68813.INSTANCE : null), (Function0<Unit>) ((117 & 64) != 0 ? ObservableExtensionsKt.C68824.INSTANCE : null));
        }

        public static final void requestRoleMembers(long guildId, long roleId, AppComponent appComponent, RestAPI restApi, StoreGatewayConnection storeGatewayConnection) {
            C12238m.checkNotNullParameter(appComponent, "appComponent");
            C12238m.checkNotNullParameter(restApi, "restApi");
            C12238m.checkNotNullParameter(storeGatewayConnection, "storeGatewayConnection");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(restApi.getGuildRoleMemberIds(guildId, roleId)), appComponent, null, 2, null), (Class<?>) INSTANCE.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new StoreGuilds$Actions$requestRoleMembers$1(storeGatewayConnection, guildId));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$handleGuildMemberCommunicationEnabled$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C60951 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60951(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuilds.this.handleGuildMemberCommunicationEnabledInternal(this.$guildId, this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C60972 extends AbstractC12240o implements Function1<List<? extends com.discord.models.member.GuildMember>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$initClearCommunicationDisabledObserver$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuilds.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $members;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$members = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                List<com.discord.models.member.GuildMember> list = this.$members;
                C12238m.checkNotNullExpressionValue(list, "members");
                for (com.discord.models.member.GuildMember guildMember : list) {
                    StoreGuilds.this.handleGuildMemberCommunicationEnabledInternal(guildMember.getGuildId(), guildMember.getUserId());
                }
            }
        }

        public C60972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends com.discord.models.member.GuildMember> list) {
            invoke2((List<com.discord.models.member.GuildMember>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<com.discord.models.member.GuildMember> list) {
            StoreGuilds.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$observeComputed$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C60991 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>> {
        public C60991() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> invoke() {
            return StoreGuilds.this.getMembers();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$observeComputedMember$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C61011 extends AbstractC12240o implements Function0<com.discord.models.member.GuildMember> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $userId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C61011(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$userId = j2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final com.discord.models.member.GuildMember invoke() {
            return StoreGuilds.this.getMember(this.$guildId, this.$userId);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$observeGuilds$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C61071 extends AbstractC12240o implements Function0<Map<Long, ? extends Guild>> {
        public C61071() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Guild> invoke() {
            return StoreGuilds.this.getGuilds();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$observeJoinedAt$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C61081 extends AbstractC12240o implements Function0<Map<Long, ? extends Long>> {
        public C61081() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Long> invoke() {
            return StoreGuilds.this.getGuildsJoinedAt();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$observeRoles$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C61101 extends AbstractC12240o implements Function0<Map<Long, ? extends Map<Long, ? extends GuildRole>>> {
        public C61101() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke() {
            return StoreGuilds.this.getRoles();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuilds$observeUnavailableGuilds$1 */
    /* JADX INFO: compiled from: StoreGuilds.kt */
    public static final class C61131 extends AbstractC12240o implements Function0<Set<? extends Long>> {
        public C61131() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Set<? extends Long> invoke() {
            return StoreGuilds.this.getUnavailableGuilds();
        }
    }

    public /* synthetic */ StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(storeUser, dispatcher, (i & 4) != 0 ? ObservationDeckProvider.get() : observationDeck);
    }

    private final long getMeId() {
        return this.userStore.getMe().getId();
    }

    @StoreThread
    private final void handleGuild(com.discord.api.guild.Guild guild, boolean remove) {
        long id2 = guild.getId();
        if (remove) {
            if (this.guilds.containsKey(Long.valueOf(id2))) {
                this.guilds.remove(Long.valueOf(id2));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Guild guild2 = this.guilds.get(Long.valueOf(id2));
        if (guild2 == null) {
            guild2 = new Guild(null, null, null, null, null, 0, 0L, null, 0L, null, null, null, false, 0, 0, null, null, null, 0, null, null, 0, 0, 0, null, null, null, null, null, null, null, 0, false, null, -1, 3, null);
        }
        Guild guildMerge = guild2.merge(guild);
        if (!C12238m.areEqual(guildMerge, this.guilds.get(Long.valueOf(id2)))) {
            this.guilds.put(Long.valueOf(id2), guildMerge);
            markChanged(GuildsUpdate);
        }
    }

    public static /* synthetic */ void handleGuildMember$default(StoreGuilds storeGuilds, GuildMember guildMember, long j, boolean z2, int i, Object obj) {
        if ((i & 4) != 0) {
            z2 = false;
        }
        storeGuilds.handleGuildMember(guildMember, j, z2);
    }

    @StoreThread
    private final void handleGuildMemberCommunicationEnabledInternal(long guildId, long userId) {
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        GuildMember guildMember = map != null ? map.get(Long.valueOf(userId)) : null;
        if ((guildMember != null ? guildMember.getCommunicationDisabledUntil() : null) == null) {
            return;
        }
        GuildMember guildMemberM7915a = GuildMember.m7915a(guildMember, 0L, null, null, null, null, null, false, null, null, null, null, null, null, 4095);
        handleGuildMember$default(this, guildMemberM7915a, guildId, false, 4, null);
        if (userId == getMeId()) {
            StoreStream.INSTANCE.getPermissions().handleGuildMemberAdd(guildMemberM7915a);
        }
    }

    @StoreThread
    private final void handleGuildMembers(long guildId, long removedGuildMemberUserId, Collection<GuildMember> members, boolean remove) {
        if (!remove) {
            if (members != null) {
                Iterator<T> it = members.iterator();
                while (it.hasNext()) {
                    handleGuildMember$default(this, (GuildMember) it.next(), guildId, false, 4, null);
                }
                return;
            }
            return;
        }
        if (removedGuildMemberUserId <= 0) {
            if (this.guildMembers.remove(Long.valueOf(guildId)) != null) {
                markChanged(GuildsUpdate);
            }
            if (this.guildMembersComputed.remove(Long.valueOf(guildId)) != null) {
                markChanged(ComputedMembersUpdate);
                return;
            }
            return;
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        if ((map != null ? map.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(GuildsUpdate);
        }
        Map<Long, com.discord.models.member.GuildMember> map2 = this.guildMembersComputed.get(Long.valueOf(guildId));
        if ((map2 != null ? map2.remove(Long.valueOf(removedGuildMemberUserId)) : null) != null) {
            markChanged(ComputedMembersUpdate);
        }
    }

    @StoreThread
    private final void handleGuildMembersMap(long guildId, Map<Long, GuildMember> members) {
        handleGuildMembers(guildId, 0L, members != null ? members.values() : null, false);
    }

    @StoreThread
    private final void handleGuildRoles(long guildId, long deletedRoleId, List<GuildRole> roles, boolean remove) {
        if (remove) {
            if (deletedRoleId > 0) {
                Map<Long, GuildRole> map = this.guildRoles.get(Long.valueOf(guildId));
                if ((map != null ? map.remove(Long.valueOf(deletedRoleId)) : null) != null) {
                    markChanged(GuildsUpdate);
                    return;
                }
                return;
            }
            if (this.guildRoles.containsKey(Long.valueOf(guildId))) {
                this.guildRoles.remove(Long.valueOf(guildId));
                markChanged(GuildsUpdate);
                return;
            }
            return;
        }
        Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
        Long lValueOf = Long.valueOf(guildId);
        Map<Long, GuildRole> map3 = map2.get(lValueOf);
        if (map3 == null) {
            map3 = new HashMap<>();
            map2.put(lValueOf, map3);
        }
        Map<Long, GuildRole> map4 = map3;
        if (roles != null) {
            for (GuildRole guildRole : roles) {
                if (!C12238m.areEqual(map4.get(Long.valueOf(guildRole.getId())), guildRole)) {
                    map4.put(Long.valueOf(guildRole.getId()), guildRole);
                    markChanged(GuildsUpdate);
                }
            }
        }
    }

    @StoreThread
    private final void handleGuildUnavailable(long guildId, boolean unavailable, boolean remove) {
        if (remove) {
            if (!unavailable || this.guildsUnavailable.contains(Long.valueOf(guildId))) {
                return;
            }
            this.guildsUnavailable.add(Long.valueOf(guildId));
            markChanged(GuildsUpdate);
            return;
        }
        if (unavailable || !this.guildsUnavailable.contains(Long.valueOf(guildId))) {
            return;
        }
        this.guildsUnavailable.remove(Long.valueOf(guildId));
        markChanged(GuildsUpdate);
    }

    @StoreThread
    private final void handleHasRoleAndJoinedAt(long guildId, Map<Long, GuildMember> members) {
        GuildMember guildMember;
        Long l;
        MeUser me2 = this.userStore.getMe();
        if (members == null || (guildMember = members.get(Long.valueOf(me2.getId()))) == null) {
            return;
        }
        UtcDateTime joinedAt = guildMember.getJoinedAt();
        long dateTimeMillis = joinedAt != null ? joinedAt.getDateTimeMillis() : 0L;
        if (this.guildsJoinedAt.containsKey(Long.valueOf(guildId)) && (l = this.guildsJoinedAt.get(Long.valueOf(guildId))) != null && l.longValue() == dateTimeMillis) {
            return;
        }
        this.guildsJoinedAt.put(Long.valueOf(guildId), Long.valueOf(dateTimeMillis));
        markChanged(GuildsUpdate);
    }

    private final void initClearCommunicationDisabledObserver(Context ctx) {
        Observable observableM11112r = Observable.m11076j(observeCommunicationDisabledGuildMembers(), Observable.m11061E(0L, 10L, TimeUnit.SECONDS), new Func2<List<? extends com.discord.models.member.GuildMember>, Long, List<? extends com.discord.models.member.GuildMember>>() { // from class: com.discord.stores.StoreGuilds.initClearCommunicationDisabledObserver.1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(List<? extends com.discord.models.member.GuildMember> list, Long l) {
                return call2((List<com.discord.models.member.GuildMember>) list, l);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<com.discord.models.member.GuildMember> call2(List<com.discord.models.member.GuildMember> list, Long l) {
                ArrayList arrayListM840a0 = C1643a.m840a0(list, "members");
                for (Object obj : list) {
                    if (!((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                        arrayListM840a0.add(obj);
                    }
                }
                return arrayListM840a0;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.computationLatest(observableM11112r), (Class<?>) StoreGuilds.class, (58 & 2) != 0 ? null : ctx, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60972());
    }

    public final Guild getGuild(long guildId) {
        return this.guildsSnapshot.get(Long.valueOf(guildId));
    }

    @StoreThread
    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getGuildMembersComputedInternal$app_productionGoogleRelease() {
        return this.guildMembersComputed;
    }

    @StoreThread
    public final Map<Long, Map<Long, GuildRole>> getGuildRolesInternal$app_productionGoogleRelease() {
        return this.guildRoles;
    }

    public final Map<Long, Guild> getGuilds() {
        return this.guildsSnapshot;
    }

    @StoreThread
    public final Map<Long, Guild> getGuildsInternal$app_productionGoogleRelease() {
        return this.guilds;
    }

    public final Map<Long, Long> getGuildsJoinedAt() {
        return this.guildsJoinedAtSnapshot;
    }

    @StoreThread
    public final Map<Long, Long> getGuildsJoinedAtInternal$app_productionGoogleRelease() {
        return this.guildsJoinedAt;
    }

    public final com.discord.models.member.GuildMember getMember(long guildId, long userId) {
        Map<Long, com.discord.models.member.GuildMember> map = this.guildMembersComputedSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(userId));
        }
        return null;
    }

    public final Map<Long, Map<Long, com.discord.models.member.GuildMember>> getMembers() {
        return this.guildMembersComputedSnapshot;
    }

    public final Map<Long, Map<Long, GuildRole>> getRoles() {
        return this.guildRolesSnapshot;
    }

    public final Set<Long> getUnavailableGuilds() {
        return this.guildsUnavailableSnapshot;
    }

    @StoreThread
    public final Set<Long> getUnavailableGuildsInternal$app_productionGoogleRelease() {
        return this.guildsUnavailable;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        Map<Long, GuildMember> mapEmptyMap;
        C12238m.checkNotNullParameter(payload, "payload");
        this.guilds.clear();
        this.guildMembers.clear();
        this.guildMembersComputed.clear();
        this.guildRoles.clear();
        this.guildsUnavailable.clear();
        for (com.discord.api.guild.Guild guild : payload.getGuilds()) {
            long id2 = guild.getId();
            if (guild.getUnavailable()) {
                this.guildsUnavailable.add(Long.valueOf(id2));
            } else {
                handleGuildRoles(id2, 0L, guild.m7842G(), false);
                C12238m.checkNotNullExpressionValue(guild, "guild");
                handleGuild(guild, false);
                List<GuildMember> listM7875v = guild.m7875v();
                if (listM7875v == null || (mapEmptyMap = GuildUtilsKt.asMap(listM7875v)) == null) {
                    mapEmptyMap = C12136h0.emptyMap();
                }
                handleGuildMembersMap(id2, mapEmptyMap);
                handleHasRoleAndJoinedAt(id2, mapEmptyMap);
            }
        }
        markChanged(GuildsUpdate, ComputedMembersUpdate);
    }

    @StoreThread
    public final void handleGuildAdd(com.discord.api.guild.Guild guild) {
        Map<Long, GuildMember> mapEmptyMap;
        C12238m.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), false);
        if (guild.getUnavailable()) {
            return;
        }
        handleGuildRoles(guild.getId(), 0L, guild.m7842G(), false);
        handleGuild(guild, false);
        List<GuildMember> listM7875v = guild.m7875v();
        if (listM7875v == null || (mapEmptyMap = GuildUtilsKt.asMap(listM7875v)) == null) {
            mapEmptyMap = C12136h0.emptyMap();
        }
        handleGuildMembersMap(guild.getId(), mapEmptyMap);
        handleHasRoleAndJoinedAt(guild.getId(), mapEmptyMap);
    }

    @StoreThread
    public final void handleGuildMember(GuildMember member, long guildId, boolean isFullGuildMember) {
        GuildMember guildMemberM7915a = member;
        C12238m.checkNotNullParameter(guildMemberM7915a, "member");
        long id2 = member.getUser().getId();
        if (!this.guildMembers.containsKey(Long.valueOf(guildId))) {
            this.guildMembers.put(Long.valueOf(guildId), new HashMap());
        }
        if (!this.guildMembersComputed.containsKey(Long.valueOf(guildId))) {
            this.guildMembersComputed.put(Long.valueOf(guildId), new HashMap());
        }
        Map<Long, GuildMember> map = this.guildMembers.get(Long.valueOf(guildId));
        C12238m.checkNotNull(map);
        GuildMember guildMember = map.get(Long.valueOf(id2));
        if (!isFullGuildMember && guildMember != null) {
            guildMemberM7915a = GuildMember.m7915a(member, 0L, null, null, null, null, null, false, null, null, null, guildMember.getBio(), guildMember.getBanner(), null, 5119);
        }
        GuildMember guildMember2 = guildMemberM7915a;
        if (!C12238m.areEqual(guildMember2, guildMember)) {
            Map<Long, GuildMember> map2 = this.guildMembers.get(Long.valueOf(guildId));
            C12238m.checkNotNull(map2);
            map2.put(Long.valueOf(id2), guildMember2);
        }
        com.discord.models.member.GuildMember guildMemberFrom = com.discord.models.member.GuildMember.INSTANCE.from(guildMember2, guildId, (8 & 4) != 0 ? null : this.guildRoles.get(Long.valueOf(guildId)), (8 & 8) != 0 ? null : null);
        Map<Long, com.discord.models.member.GuildMember> map3 = this.guildMembersComputed.get(Long.valueOf(guildId));
        C12238m.checkNotNull(map3);
        if (!C12238m.areEqual(guildMemberFrom, map3.get(Long.valueOf(id2)))) {
            Map<Long, com.discord.models.member.GuildMember> map4 = this.guildMembersComputed.get(Long.valueOf(guildId));
            C12238m.checkNotNull(map4);
            map4.put(Long.valueOf(id2), guildMemberFrom);
            markChanged(ComputedMembersUpdate);
        }
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        C12238m.checkNotNullParameter(member, "member");
        handleGuildMember$default(this, member, member.getGuildId(), false, 4, null);
    }

    public final void handleGuildMemberCommunicationEnabled(long guildId, long userId) {
        this.dispatcher.schedule(new C60951(guildId, userId));
    }

    @StoreThread
    public final void handleGuildMemberRemove(long guildId, long userId) {
        handleGuildMembers(guildId, userId, null, true);
    }

    @StoreThread
    public final void handleGuildMembersChunk(GuildMembersChunk chunk) {
        C12238m.checkNotNullParameter(chunk, "chunk");
        handleGuildMembers(chunk.getGuildId(), 0L, chunk.m7932b(), false);
    }

    @StoreThread
    public final void handleGuildRemove(com.discord.api.guild.Guild guild) {
        C12238m.checkNotNullParameter(guild, "guild");
        handleGuildUnavailable(guild.getId(), guild.getUnavailable(), true);
        handleGuild(guild, true);
        handleGuildRoles(guild.getId(), 0L, null, true);
        handleGuildMembers(guild.getId(), 0L, null, true);
    }

    @StoreThread
    public final void handleGuildRoleCreateOrUpdate(long guildId, GuildRole role) {
        C12238m.checkNotNullParameter(role, "role");
        handleGuildRoles(guildId, 0L, C12145m.listOf(role), false);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @StoreThread
    public final void handleGuildRoleRemove(long roleId, long guildId) {
        handleGuildRoles(guildId, roleId, null, true);
        handleGuildMembersMap(guildId, this.guildMembers.get(Long.valueOf(guildId)));
        handleHasRoleAndJoinedAt(guildId, this.guildMembers.get(Long.valueOf(guildId)));
    }

    @StoreThread
    public final void handleGuildScheduledEventUsersFetch(List<ApiGuildScheduledEventUser> apiGuildScheduledEventUsers, long guildId) {
        C12238m.checkNotNullParameter(apiGuildScheduledEventUsers, "apiGuildScheduledEventUsers");
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = apiGuildScheduledEventUsers.iterator();
        while (it.hasNext()) {
            GuildMember guildMemberM7967a = ((ApiGuildScheduledEventUser) it.next()).m7967a(guildId);
            if (guildMemberM7967a != null) {
                arrayList.add(guildMemberM7967a);
            }
        }
        handleGuildMembers(guildId, 0L, arrayList, false);
    }

    @StoreThread
    public final void handleThreadMemberListUpdate(ThreadMemberListUpdate threadMemberListUpdate) {
        ArrayList arrayList;
        C12238m.checkNotNullParameter(threadMemberListUpdate, "threadMemberListUpdate");
        long jM8265a = threadMemberListUpdate.getGuildId();
        List<ThreadListMember> listM8266b = threadMemberListUpdate.m8266b();
        if (listM8266b != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listM8266b.iterator();
            while (it.hasNext()) {
                GuildMember guildMemberM8253a = ((ThreadListMember) it.next()).getMember();
                if (guildMemberM8253a != null) {
                    arrayList2.add(guildMemberM8253a);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jM8265a, 0L, arrayList, false);
    }

    @StoreThread
    public final void handleThreadMembersUpdate(ThreadMembersUpdate threadMembersUpdate) {
        ArrayList arrayList;
        C12238m.checkNotNullParameter(threadMembersUpdate, "threadMembersUpdate");
        long jM8276b = threadMembersUpdate.getGuildId();
        List<AugmentedThreadMember> listM8275a = threadMembersUpdate.m8275a();
        if (listM8275a != null) {
            ArrayList arrayList2 = new ArrayList();
            Iterator<T> it = listM8275a.iterator();
            while (it.hasNext()) {
                GuildMember member = ((AugmentedThreadMember) it.next()).getMember();
                if (member != null) {
                    arrayList2.add(member);
                }
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        handleGuildMembers(jM8276b, 0L, arrayList, false);
    }

    @Override // com.discord.stores.Store
    public void init(Context context) {
        C12238m.checkNotNullParameter(context, "context");
        this.guilds.putAll(CollectionExtensionsKt.filterNonNullValues(this.guildsCache.get()));
        Map<Long, Map<Long, GuildRole>> map = this.guildRolesCache.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<Map.Entry<Long, Map<Long, GuildRole>>> it = map.entrySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Map.Entry<Long, Map<Long, GuildRole>> next = it.next();
            if (next.getKey() != null) {
                linkedHashMap.put(next.getKey(), next.getValue());
            }
        }
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            this.guildRoles.put(Long.valueOf(((Number) entry.getKey()).longValue()), C12136h0.toMutableMap((Map) entry.getValue()));
        }
        this.guildsJoinedAt.putAll(this.guildsJoinedAtCache.get());
        markChanged(GuildsUpdate, ComputedMembersUpdate);
        initClearCommunicationDisabledObserver(context);
    }

    public final Observable<List<com.discord.models.member.GuildMember>> observeCommunicationDisabledGuildMembers() {
        Observable<List<com.discord.models.member.GuildMember>> observableM11112r = Observable.m11076j(observeGuildIds(), observeComputed(), new Func2<Set<? extends Long>, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, List<? extends com.discord.models.member.GuildMember>>() { // from class: com.discord.stores.StoreGuilds.observeCommunicationDisabledGuildMembers.1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ List<? extends com.discord.models.member.GuildMember> call(Set<? extends Long> set, Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
                return call2((Set<Long>) set, (Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final List<com.discord.models.member.GuildMember> call2(Set<Long> set, Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
                ArrayList arrayList;
                Collection<com.discord.models.member.GuildMember> collectionValues;
                C12238m.checkNotNullExpressionValue(set, "guildIds");
                ArrayList arrayList2 = new ArrayList();
                Iterator<T> it = set.iterator();
                while (it.hasNext()) {
                    Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(((Number) it.next()).longValue()));
                    if (map2 == null || (collectionValues = map2.values()) == null) {
                        arrayList = null;
                    } else {
                        arrayList = new ArrayList();
                        for (Object obj : collectionValues) {
                            if (((com.discord.models.member.GuildMember) obj).isCommunicationDisabled()) {
                                arrayList.add(obj);
                            }
                        }
                    }
                    if (arrayList != null) {
                        arrayList2.add(arrayList);
                    }
                }
                return C12149o.flatten(arrayList2);
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Observable.combineLatest…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Map<Long, com.discord.models.member.GuildMember>>> observeComputed() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new C60991(), 14, null);
    }

    public final Observable<com.discord.models.member.GuildMember> observeComputedMember(long guildId, long userId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{ComputedMembersUpdate}, false, null, null, new C61011(guildId, userId), 14, null);
    }

    public final Observable<Guild> observeFromChannelId(long channelId) {
        Observable observableM11099Y = StoreStream.INSTANCE.getChannels().observeChannel(channelId).m11099Y(new InterfaceC12589b<Channel, Observable<? extends Guild>>() { // from class: com.discord.stores.StoreGuilds.observeFromChannelId.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final Observable<? extends Guild> call(Channel channel) {
                return channel != null ? StoreGuilds.this.observeGuild(channel.getGuildId()) : new C12721k(null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11099Y, "StoreStream\n        .get…ll)\n          }\n        }");
        return observableM11099Y;
    }

    public final Observable<Guild> observeGuild(final long guildId) {
        Observable<Guild> observableM11112r = observeGuilds().m11083G(new InterfaceC12589b<Map<Long, ? extends Guild>, Guild>() { // from class: com.discord.stores.StoreGuilds.observeGuild.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Guild call(Map<Long, ? extends Guild> map) {
                return call2((Map<Long, Guild>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Guild call2(Map<Long, Guild> map) {
                return map.get(Long.valueOf(guildId));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> observeGuildIds() {
        Observable<Set<Long>> observableM11112r = observeGuilds().m11099Y(new InterfaceC12589b<Map<Long, ? extends Guild>, Observable<? extends Set<? extends Long>>>() { // from class: com.discord.stores.StoreGuilds.observeGuildIds.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends Set<? extends Long>> call(Map<Long, ? extends Guild> map) {
                return call2((Map<Long, Guild>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends Set<Long>> call2(Map<Long, Guild> map) {
                return new C12721k(map.keySet());
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeGuilds()\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<com.discord.models.member.GuildMember> observeGuildMember(final long guildId, final long userId) {
        return observeComputed().m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, com.discord.models.member.GuildMember>() { // from class: com.discord.stores.StoreGuilds.observeGuildMember.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ com.discord.models.member.GuildMember call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
                return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final com.discord.models.member.GuildMember call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
                Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(guildId));
                if (map2 != null) {
                    return map2.get(Long.valueOf(userId));
                }
                return null;
            }
        }).m11112r();
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeGuildMembers(final long guildId) {
        return observeComputed().m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>>() { // from class: com.discord.stores.StoreGuilds.observeGuildMembers.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
                return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
                Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(guildId));
                return map2 != null ? map2 : C12136h0.emptyMap();
            }
        }).m11112r();
    }

    public final Observable<Map<Long, Guild>> observeGuilds() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61071(), 14, null);
    }

    public final Observable<Map<Long, Long>> observeJoinedAt() {
        Observable<Map<Long, Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61081(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, Map<Long, GuildRole>>> observeRoles() {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61101(), 14, null);
    }

    public final Observable<List<GuildRole>> observeSortedRoles(long guildId) {
        Observable<List<GuildRole>> observableM11112r = observeRoles(guildId).m11099Y(new InterfaceC12589b<Map<Long, ? extends GuildRole>, Observable<? extends List<? extends GuildRole>>>() { // from class: com.discord.stores.StoreGuilds.observeSortedRoles.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Observable<? extends List<? extends GuildRole>> call(Map<Long, ? extends GuildRole> map) {
                return call2((Map<Long, GuildRole>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Observable<? extends List<GuildRole>> call2(Map<Long, GuildRole> map) {
                return new C12721k(C12163u.sortedWith(map.values(), RoleUtils.getROLE_COMPARATOR()));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeRoles(guildId)\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Set<Long>> observeUnavailableGuilds() {
        Observable<Set<Long>> observableM11112r = ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{GuildsUpdate}, false, null, null, new C61131(), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observationDeck\n        …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<GuildVerificationLevel> observeVerificationLevel(long guildId) {
        Observable<GuildVerificationLevel> observableM11112r = observeGuild(guildId).m11083G(new InterfaceC12589b<Guild, GuildVerificationLevel>() { // from class: com.discord.stores.StoreGuilds.observeVerificationLevel.1
            @Override // p637j0.p641k.InterfaceC12589b
            public final GuildVerificationLevel call(Guild guild) {
                GuildVerificationLevel verificationLevel;
                return (guild == null || (verificationLevel = guild.getVerificationLevel()) == null) ? GuildVerificationLevel.NONE : verificationLevel;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeGuild(guildId)\n  …  .distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap;
        super.snapshotData();
        DefaultConstructorMarker defaultConstructorMarker = null;
        int i = 0;
        if (getUpdateSources().contains(GuildsUpdate)) {
            HashMap map = new HashMap(this.guildsJoinedAt);
            this.guildsJoinedAtSnapshot = map;
            Persister.set$default(this.guildsJoinedAtCache, map, false, 2, null);
            this.guildsSnapshot = new HashMap(this.guilds);
            Persister.set$default(this.guildsCache, C12136h0.minus((Map) this.guilds, (Iterable) StoreStream.INSTANCE.getLurking().getLurkingGuildIdsSync()), false, 2, null);
            this.guildsUnavailableSnapshot = new HashSet(this.guildsUnavailable);
            Map<Long, Map<Long, GuildRole>> map2 = this.guildRoles;
            LinkedHashMap linkedHashMap = new LinkedHashMap(C12134g0.mapCapacity(map2.size()));
            Iterator<T> it = map2.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                linkedHashMap.put(entry.getKey(), new HashMap((Map) entry.getValue()));
            }
            this.guildRolesSnapshot = linkedHashMap;
            Persister.set$default(this.guildRolesCache, linkedHashMap, false, 2, null);
        }
        if (getUpdateSources().contains(ComputedMembersUpdate)) {
            HashMap map3 = new HashMap();
            for (Map.Entry<Long, Map<Long, com.discord.models.member.GuildMember>> entry2 : this.guildMembersComputed.entrySet()) {
                Map<Long, com.discord.models.member.GuildMember> value = entry2.getValue();
                if (value.size() < 2000) {
                    map3.put(entry2.getKey(), new HashMap(value));
                } else {
                    if (value instanceof SnowflakePartitionMap.CopiablePartitionMap) {
                        copiablePartitionMap = (SnowflakePartitionMap.CopiablePartitionMap) value;
                    } else {
                        SnowflakePartitionMap.CopiablePartitionMap copiablePartitionMap2 = new SnowflakePartitionMap.CopiablePartitionMap(i, 1, defaultConstructorMarker);
                        copiablePartitionMap2.putAll(value);
                        entry2.setValue(copiablePartitionMap2);
                        copiablePartitionMap = copiablePartitionMap2;
                    }
                    map3.put(entry2.getKey(), copiablePartitionMap.fastCopy());
                }
            }
            this.guildMembersComputedSnapshot = map3;
        }
    }

    public StoreGuilds(StoreUser storeUser, Dispatcher dispatcher, ObservationDeck observationDeck) {
        C12238m.checkNotNullParameter(storeUser, "userStore");
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        this.userStore = storeUser;
        this.dispatcher = dispatcher;
        this.observationDeck = observationDeck;
        this.guildsSnapshot = C12136h0.emptyMap();
        this.guildMembersComputedSnapshot = C12136h0.emptyMap();
        this.guildRolesSnapshot = C12136h0.emptyMap();
        this.guildsUnavailableSnapshot = C12148n0.emptySet();
        this.guildsJoinedAtSnapshot = C12136h0.emptyMap();
        this.guilds = new HashMap();
        this.guildMembersComputed = new HashMap();
        this.guildMembers = new HashMap();
        this.guildRoles = new HashMap();
        this.guildsUnavailable = new HashSet();
        this.guildsJoinedAt = new HashMap();
        this.guildsCache = new Persister<>("STORE_GUILDS_V34", new HashMap());
        this.guildRolesCache = new Persister<>("STORE_GUILD_ROLES_V7", new HashMap());
        this.guildsJoinedAtCache = new Persister<>("STORE_GUILD_JOINED_AT_V6", new HashMap());
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(final long guildId) {
        Observable<Map<Long, com.discord.models.member.GuildMember>> observableM11112r = observeComputed().m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>>, Map<Long, ? extends com.discord.models.member.GuildMember>>() { // from class: com.discord.stores.StoreGuilds.observeComputed.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends com.discord.models.member.GuildMember> call(Map<Long, ? extends Map<Long, ? extends com.discord.models.member.GuildMember>> map) {
                return call2((Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, com.discord.models.member.GuildMember> call2(Map<Long, ? extends Map<Long, com.discord.models.member.GuildMember>> map) {
                Map<Long, com.discord.models.member.GuildMember> map2 = map.get(Long.valueOf(guildId));
                return map2 != null ? map2 : StoreGuilds.emptyComputedMap;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeComputed()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(final long guildId) {
        Observable<Map<Long, GuildRole>> observableM11112r = observeRoles().m11083G(new InterfaceC12589b<Map<Long, ? extends Map<Long, ? extends GuildRole>>, Map<Long, ? extends GuildRole>>() { // from class: com.discord.stores.StoreGuilds.observeRoles.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends GuildRole> call(Map<Long, ? extends Map<Long, ? extends GuildRole>> map) {
                return call2((Map<Long, ? extends Map<Long, GuildRole>>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, GuildRole> call2(Map<Long, ? extends Map<Long, GuildRole>> map) {
                Map<Long, GuildRole> map2 = map.get(Long.valueOf(guildId));
                return map2 != null ? map2 : StoreGuilds.emptyRoles;
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeRoles()\n        .…  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Long> observeJoinedAt(final long guildId) {
        Observable<Long> observableM11112r = observeJoinedAt().m11083G(new InterfaceC12589b<Map<Long, ? extends Long>, Long>() { // from class: com.discord.stores.StoreGuilds.observeJoinedAt.2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Long call(Map<Long, ? extends Long> map) {
                return call2((Map<Long, Long>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Long call2(Map<Long, Long> map) {
                return Long.valueOf(GuildMemberUtilsKt.getJoinedAtOrNow(map.get(Long.valueOf(guildId))));
            }
        }).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "observeJoinedAt()\n      …  .distinctUntilChanged()");
        return observableM11112r;
    }

    public final Observable<Map<Long, com.discord.models.member.GuildMember>> observeComputed(long guildId, Collection<Long> userIds) {
        C12238m.checkNotNullParameter(userIds, "userIds");
        Observable observableM11108k = observeComputed(guildId).m11108k(C0879o.m175a(userIds));
        C12238m.checkNotNullExpressionValue(observableM11108k, "observeComputed(guildId)…mpose(filterMap(userIds))");
        return observableM11108k;
    }

    public final Observable<Map<Long, GuildRole>> observeRoles(long guildId, Collection<Long> roleIds) {
        C12238m.checkNotNullParameter(roleIds, "roleIds");
        Observable observableM11108k = observeRoles(guildId).m11108k(C0879o.m175a(roleIds));
        C12238m.checkNotNullExpressionValue(observableM11108k, "observeRoles(guildId)\n  …mpose(filterMap(roleIds))");
        return observableM11108k;
    }
}
