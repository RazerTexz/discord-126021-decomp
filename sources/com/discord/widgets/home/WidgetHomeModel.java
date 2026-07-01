package com.discord.widgets.home;

import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.NsfwAllowance;
import com.discord.models.domain.ModelUserRelationship;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreThreadsActive;
import com.discord.stores.StoreUser;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.rx.ObservableWithLeadingEdgeThrottle;
import com.discord.widgets.chat.list.CreateThreadsFeatureFlag;
import d0.Tuples;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Tuples2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.functions.Func2;
import rx.functions.Func8;

/* JADX INFO: compiled from: WidgetHomeModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetHomeModel {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Channel channel;
    private final long channelId;
    private final Presence dmPresence;
    private final boolean isCallConnected;
    private final boolean isFriend;
    private final NsfwAllowance nsfwAllowed;
    private final Channel parentChannel;
    private final StoreChannelsSelected.ResolvedSelectedChannel selectedChannel;
    private final Channel selectedVoiceChannel;
    private final int threadCount;
    private final boolean threadExperimentEnabled;
    private final int unreadCount;

    /* JADX INFO: compiled from: WidgetHomeModel.kt */
    public static final class Companion {
        private Companion() {
        }

        public final Observable<WidgetHomeModel> get() {
            StoreStream.Companion companion = StoreStream.INSTANCE;
            Observable observableY = Observable.j(companion.getGuildSelected().observeSelectedGuildId(), companion.getChannelsSelected().observeResolvedSelectedChannel(), new Func2<Long, StoreChannelsSelected.ResolvedSelectedChannel, Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>>() { // from class: com.discord.widgets.home.WidgetHomeModel$Companion$get$1
                @Override // rx.functions.Func2
                public final Tuples2<Long, StoreChannelsSelected.ResolvedSelectedChannel> call(Long l, StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel) {
                    return Tuples.to(l, resolvedSelectedChannel);
                }
            }).Y(new Func1<Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>, Observable<? extends WidgetHomeModel>>() { // from class: com.discord.widgets.home.WidgetHomeModel$Companion$get$2
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends WidgetHomeModel> call(Tuples2<? extends Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> tuples2) {
                    return call2((Tuples2<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel>) tuples2);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends WidgetHomeModel> call2(Tuples2<Long, ? extends StoreChannelsSelected.ResolvedSelectedChannel> tuples2) {
                    Long lValueOf;
                    long id2;
                    Long lComponent1 = tuples2.component1();
                    final StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannelComponent2 = tuples2.component2();
                    final Channel maybeChannel = resolvedSelectedChannelComponent2.getMaybeChannel();
                    StoreStream.Companion companion2 = StoreStream.INSTANCE;
                    Observable observableObserveMe$default = StoreUser.observeMe$default(companion2.getUsers(), false, 1, null);
                    Observable<Map<Long, Presence>> observableObserveAllPresences = companion2.getPresences().observeAllPresences();
                    Observable<Channel> observableObserveSelectedChannel = companion2.getVoiceChannelSelected().observeSelectedChannel();
                    Observable<Integer> observableObserveTotalMentions = companion2.getMentions().observeTotalMentions();
                    Observable<Map<Long, Integer>> observableObserve = companion2.getUserRelationships().observe();
                    StoreThreadsActive threadsActive = companion2.getThreadsActive();
                    Intrinsics3.checkNotNullExpressionValue(lComponent1, "selectedGuildId");
                    long jLongValue = lComponent1.longValue();
                    if (maybeChannel == null || !ChannelUtils.H(maybeChannel)) {
                        if (maybeChannel != null) {
                            id2 = maybeChannel.getId();
                        } else {
                            lValueOf = null;
                        }
                        return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new Func8<MeUser, Map<Long, ? extends Presence>, Channel, Integer, Map<Long, ? extends Integer>, Map<Long, ? extends Channel>, Channel, Boolean, WidgetHomeModel>() { // from class: com.discord.widgets.home.WidgetHomeModel$Companion$get$2.1
                            @Override // rx.functions.Func8
                            public /* bridge */ /* synthetic */ WidgetHomeModel call(MeUser meUser, Map<Long, ? extends Presence> map, Channel channel, Integer num, Map<Long, ? extends Integer> map2, Map<Long, ? extends Channel> map3, Channel channel2, Boolean bool) {
                                return call2(meUser, (Map<Long, Presence>) map, channel, num, (Map<Long, Integer>) map2, (Map<Long, Channel>) map3, channel2, bool);
                            }

                            /* JADX WARN: Code duplicated, block: B:20:0x0038  */
                            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                            public final WidgetHomeModel call2(MeUser meUser, Map<Long, Presence> map, Channel channel, Integer num, Map<Long, Integer> map2, Map<Long, Channel> map3, Channel channel2, Boolean bool) {
                                boolean z2;
                                User userA;
                                User userA2;
                                Channel channel3 = maybeChannel;
                                if (channel3 != null && ChannelUtils.B(channel3)) {
                                    Long lValueOf2 = channel != null ? Long.valueOf(channel.getId()) : null;
                                    Channel channel4 = maybeChannel;
                                    if (Intrinsics3.areEqual(lValueOf2, channel4 != null ? Long.valueOf(channel4.getId()) : null)) {
                                        z2 = true;
                                    } else {
                                        z2 = false;
                                    }
                                } else {
                                    z2 = false;
                                }
                                StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = resolvedSelectedChannelComponent2;
                                Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "selectedChannel");
                                Channel channel5 = maybeChannel;
                                Presence presence = (channel5 == null || (userA2 = ChannelUtils.a(channel5)) == null) ? null : (Presence) outline.f(userA2, map);
                                Intrinsics3.checkNotNullExpressionValue(num, "unreadCount");
                                int iIntValue = num.intValue();
                                Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
                                Channel channel6 = maybeChannel;
                                boolean zIsType = ModelUserRelationship.isType(map2.get((channel6 == null || (userA = ChannelUtils.a(channel6)) == null) ? null : Long.valueOf(userA.getId())), 1);
                                NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
                                int size = map3.size();
                                Intrinsics3.checkNotNullExpressionValue(bool, "threadExperimentEnabled");
                                return new WidgetHomeModel(resolvedSelectedChannel, channel, channel2, presence, iIntValue, zIsType, z2, nsfwAllowance, size, bool.booleanValue());
                            }
                        }, 350L, TimeUnit.MILLISECONDS);
                    }
                    id2 = maybeChannel.getParentId();
                    lValueOf = Long.valueOf(id2);
                    return ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveMe$default, observableObserveAllPresences, observableObserveSelectedChannel, observableObserveTotalMentions, observableObserve, threadsActive.observeActiveThreadsForChannel(jLongValue, lValueOf), WidgetHomeModel.INSTANCE.getParentChannelObservable(maybeChannel), new CreateThreadsFeatureFlag(null, null, 3, null).observeEnabled(lComponent1.longValue()), new Func8<MeUser, Map<Long, ? extends Presence>, Channel, Integer, Map<Long, ? extends Integer>, Map<Long, ? extends Channel>, Channel, Boolean, WidgetHomeModel>() { // from class: com.discord.widgets.home.WidgetHomeModel$Companion$get$2.1
                        @Override // rx.functions.Func8
                        public /* bridge */ /* synthetic */ WidgetHomeModel call(MeUser meUser, Map<Long, ? extends Presence> map, Channel channel, Integer num, Map<Long, ? extends Integer> map2, Map<Long, ? extends Channel> map3, Channel channel2, Boolean bool) {
                            return call2(meUser, (Map<Long, Presence>) map, channel, num, (Map<Long, Integer>) map2, (Map<Long, Channel>) map3, channel2, bool);
                        }

                        /* JADX WARN: Code duplicated, block: B:20:0x0038  */
                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final WidgetHomeModel call2(MeUser meUser, Map<Long, Presence> map, Channel channel, Integer num, Map<Long, Integer> map2, Map<Long, Channel> map3, Channel channel2, Boolean bool) {
                            boolean z2;
                            User userA;
                            User userA2;
                            Channel channel3 = maybeChannel;
                            if (channel3 != null && ChannelUtils.B(channel3)) {
                                Long lValueOf2 = channel != null ? Long.valueOf(channel.getId()) : null;
                                Channel channel4 = maybeChannel;
                                if (Intrinsics3.areEqual(lValueOf2, channel4 != null ? Long.valueOf(channel4.getId()) : null)) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                            } else {
                                z2 = false;
                            }
                            StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = resolvedSelectedChannelComponent2;
                            Intrinsics3.checkNotNullExpressionValue(resolvedSelectedChannel, "selectedChannel");
                            Channel channel5 = maybeChannel;
                            Presence presence = (channel5 == null || (userA2 = ChannelUtils.a(channel5)) == null) ? null : (Presence) outline.f(userA2, map);
                            Intrinsics3.checkNotNullExpressionValue(num, "unreadCount");
                            int iIntValue = num.intValue();
                            Intrinsics3.checkNotNullExpressionValue(map2, "userRelationships");
                            Channel channel6 = maybeChannel;
                            boolean zIsType = ModelUserRelationship.isType(map2.get((channel6 == null || (userA = ChannelUtils.a(channel6)) == null) ? null : Long.valueOf(userA.getId())), 1);
                            NsfwAllowance nsfwAllowance = meUser != null ? meUser.getNsfwAllowance() : null;
                            int size = map3.size();
                            Intrinsics3.checkNotNullExpressionValue(bool, "threadExperimentEnabled");
                            return new WidgetHomeModel(resolvedSelectedChannel, channel, channel2, presence, iIntValue, zIsType, z2, nsfwAllowance, size, bool.booleanValue());
                        }
                    }, 350L, TimeUnit.MILLISECONDS);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "Observable.combineLatest…            )\n          }");
            Observable<WidgetHomeModel> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "Observable.combineLatest…  .distinctUntilChanged()");
            return observableR;
        }

        public final Observable<Boolean> getInitialized() {
            Observable<Boolean> observableQ = StoreStream.INSTANCE.isInitializedObservable().q(150L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableQ, "StoreStream\n          .i…0, TimeUnit.MILLISECONDS)");
            return observableQ;
        }

        public final Observable<Channel> getParentChannelObservable(Channel channel) {
            if (channel == null || ChannelUtils.H(channel)) {
                if ((channel != null ? Long.valueOf(channel.getParentId()) : null) != null) {
                    return StoreStream.INSTANCE.getChannels().observeChannel(channel.getParentId());
                }
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            return scalarSynchronousObservable;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public WidgetHomeModel(StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel, Channel channel, Channel channel2, Presence presence, int i, boolean z2, boolean z3, NsfwAllowance nsfwAllowance, int i2, boolean z4) {
        Intrinsics3.checkNotNullParameter(resolvedSelectedChannel, "selectedChannel");
        this.selectedChannel = resolvedSelectedChannel;
        this.selectedVoiceChannel = channel;
        this.parentChannel = channel2;
        this.dmPresence = presence;
        this.unreadCount = i;
        this.isFriend = z2;
        this.isCallConnected = z3;
        this.nsfwAllowed = nsfwAllowance;
        this.threadCount = i2;
        this.threadExperimentEnabled = z4;
        this.channel = resolvedSelectedChannel.getMaybeChannel();
        Channel maybeChannel = resolvedSelectedChannel.getMaybeChannel();
        this.channelId = maybeChannel != null ? maybeChannel.getId() : 0L;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreChannelsSelected.ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsFriend() {
        return this.isFriend;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final boolean getIsCallConnected() {
        return this.isCallConnected;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    /* JADX INFO: renamed from: component9, reason: from getter */
    public final int getThreadCount() {
        return this.threadCount;
    }

    public final WidgetHomeModel copy(StoreChannelsSelected.ResolvedSelectedChannel selectedChannel, Channel selectedVoiceChannel, Channel parentChannel, Presence dmPresence, int unreadCount, boolean isFriend, boolean isCallConnected, NsfwAllowance nsfwAllowed, int threadCount, boolean threadExperimentEnabled) {
        Intrinsics3.checkNotNullParameter(selectedChannel, "selectedChannel");
        return new WidgetHomeModel(selectedChannel, selectedVoiceChannel, parentChannel, dmPresence, unreadCount, isFriend, isCallConnected, nsfwAllowed, threadCount, threadExperimentEnabled);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetHomeModel)) {
            return false;
        }
        WidgetHomeModel widgetHomeModel = (WidgetHomeModel) other;
        return Intrinsics3.areEqual(this.selectedChannel, widgetHomeModel.selectedChannel) && Intrinsics3.areEqual(this.selectedVoiceChannel, widgetHomeModel.selectedVoiceChannel) && Intrinsics3.areEqual(this.parentChannel, widgetHomeModel.parentChannel) && Intrinsics3.areEqual(this.dmPresence, widgetHomeModel.dmPresence) && this.unreadCount == widgetHomeModel.unreadCount && this.isFriend == widgetHomeModel.isFriend && this.isCallConnected == widgetHomeModel.isCallConnected && Intrinsics3.areEqual(this.nsfwAllowed, widgetHomeModel.nsfwAllowed) && this.threadCount == widgetHomeModel.threadCount && this.threadExperimentEnabled == widgetHomeModel.threadExperimentEnabled;
    }

    public final Channel getChannel() {
        return this.channel;
    }

    public final long getChannelId() {
        return this.channelId;
    }

    public final Presence getDmPresence() {
        return this.dmPresence;
    }

    public final NsfwAllowance getNsfwAllowed() {
        return this.nsfwAllowed;
    }

    public final Channel getParentChannel() {
        return this.parentChannel;
    }

    public final StoreChannelsSelected.ResolvedSelectedChannel getSelectedChannel() {
        return this.selectedChannel;
    }

    public final Channel getSelectedVoiceChannel() {
        return this.selectedVoiceChannel;
    }

    public final int getThreadCount() {
        return this.threadCount;
    }

    public final boolean getThreadExperimentEnabled() {
        return this.threadExperimentEnabled;
    }

    public final int getUnreadCount() {
        return this.unreadCount;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r0v20, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        StoreChannelsSelected.ResolvedSelectedChannel resolvedSelectedChannel = this.selectedChannel;
        int iHashCode = (resolvedSelectedChannel != null ? resolvedSelectedChannel.hashCode() : 0) * 31;
        Channel channel = this.selectedVoiceChannel;
        int iHashCode2 = (iHashCode + (channel != null ? channel.hashCode() : 0)) * 31;
        Channel channel2 = this.parentChannel;
        int iHashCode3 = (iHashCode2 + (channel2 != null ? channel2.hashCode() : 0)) * 31;
        Presence presence = this.dmPresence;
        int iHashCode4 = (((iHashCode3 + (presence != null ? presence.hashCode() : 0)) * 31) + this.unreadCount) * 31;
        boolean z2 = this.isFriend;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.isCallConnected;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        NsfwAllowance nsfwAllowance = this.nsfwAllowed;
        int iHashCode5 = (((i2 + (nsfwAllowance != null ? nsfwAllowance.hashCode() : 0)) * 31) + this.threadCount) * 31;
        boolean z4 = this.threadExperimentEnabled;
        return iHashCode5 + (z4 ? 1 : z4);
    }

    public final boolean isCallConnected() {
        return this.isCallConnected;
    }

    public final boolean isChannelNsfw() {
        Channel channel = this.channel;
        return channel != null && channel.getNsfw();
    }

    public final boolean isFriend() {
        return this.isFriend;
    }

    public final boolean isNsfwUnConsented() {
        return (this.channel == null || StoreStream.INSTANCE.getGuildsNsfw().isGuildNsfwGateAgreed(this.channel.getGuildId())) ? false : true;
    }

    public String toString() {
        StringBuilder sbU = outline.U("WidgetHomeModel(selectedChannel=");
        sbU.append(this.selectedChannel);
        sbU.append(", selectedVoiceChannel=");
        sbU.append(this.selectedVoiceChannel);
        sbU.append(", parentChannel=");
        sbU.append(this.parentChannel);
        sbU.append(", dmPresence=");
        sbU.append(this.dmPresence);
        sbU.append(", unreadCount=");
        sbU.append(this.unreadCount);
        sbU.append(", isFriend=");
        sbU.append(this.isFriend);
        sbU.append(", isCallConnected=");
        sbU.append(this.isCallConnected);
        sbU.append(", nsfwAllowed=");
        sbU.append(this.nsfwAllowed);
        sbU.append(", threadCount=");
        sbU.append(this.threadCount);
        sbU.append(", threadExperimentEnabled=");
        return outline.O(sbU, this.threadExperimentEnabled, ")");
    }
}
