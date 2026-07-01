package com.discord.widgets.user.profile;

import androidx.annotation.MainThread;
import androidx.annotation.VisibleForTesting;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.user.UserProfile;
import com.discord.models.member.GuildMember;
import com.discord.models.presence.Presence;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.nullserializable.NullSerializable;
import com.discord.stores.StoreAccessibility;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreExperiments;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserPresence;
import com.discord.stores.StoreUserProfile;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.streams.StreamContext;
import com.discord.utilities.streams.StreamContextService;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.user.presence.ModelRichPresence;
import com.discord.widgets.user.profile.UserProfileHeaderViewModel;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.t.Collections2;
import d0.t.Maps6;
import d0.t.Sets5;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.a.EmptyObservableHolder;
import j0.l.e.ScalarSynchronousObservable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func8;

/* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class UserProfileHeaderViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final long ME = -1;
    private final long userId;

    /* JADX INFO: renamed from: com.discord.widgets.user.profile.UserProfileHeaderViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
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
            Intrinsics3.checkNotNullParameter(storeState, "storeState");
            UserProfileHeaderViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<Map<Long, GuildMember>> observeComputedMembers(Long channelId, Long guildId, final Collection<Long> users, StoreChannels storeChannels, final StoreGuilds storeGuilds) {
            if (channelId != null && channelId.longValue() > 0) {
                Observable observableY = storeChannels.observeChannel(channelId.longValue()).Y(new Func1<Channel, Observable<? extends Map<Long, ? extends GuildMember>>>() { // from class: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeComputedMembers$1
                    @Override // j0.k.Func1
                    public final Observable<? extends Map<Long, GuildMember>> call(Channel channel) {
                        Observable<Map<Long, GuildMember>> observableObserveComputed;
                        return (channel == null || (observableObserveComputed = storeGuilds.observeComputed(channel.getGuildId(), users)) == null) ? new ScalarSynchronousObservable(Maps6.emptyMap()) : observableObserveComputed;
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "storeChannels\n          …emptyMap())\n            }");
                return observableY;
            }
            if (guildId != null && guildId.longValue() > 0) {
                return storeGuilds.observeComputed(guildId.longValue(), users);
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(Maps6.emptyMap());
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(emptyMap())");
            return scalarSynchronousObservable;
        }

        public static /* synthetic */ Observable observeStoreState$default(Companion companion, long j, Long l, Long l2, StoreUser storeUser, StoreChannels storeChannels, StoreGuilds storeGuilds, StoreUserPresence storeUserPresence, StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, StoreUserSettings storeUserSettings, StreamContextService streamContextService, StoreAccessibility storeAccessibility, int i, Object obj) {
            return companion.observeStoreState(j, l, l2, (i & 8) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 16) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels, (i & 32) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds, (i & 64) != 0 ? StoreStream.INSTANCE.getPresences() : storeUserPresence, (i & 128) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile, (i & 256) != 0 ? StoreStream.INSTANCE.getExperiments() : storeExperiments, (i & 512) != 0 ? StoreStream.INSTANCE.getUserSettings() : storeUserSettings, (i & 1024) != 0 ? new StreamContextService(null, null, null, null, null, null, null, null, 255, null) : streamContextService, (i & 2048) != 0 ? StoreStream.INSTANCE.getAccessibility() : storeAccessibility);
        }

        @VisibleForTesting
        public final Observable<StoreState> observeStoreState(final long userId, final Long channelId, final Long guildId, final StoreUser storeUser, final StoreChannels storeChannels, final StoreGuilds storeGuilds, final StoreUserPresence storeUserPresence, final StoreUserProfile storeUserProfile, StoreExperiments storeExperiments, final StoreUserSettings storeUserSettings, final StreamContextService streamContextService, final StoreAccessibility storeAccessibility) {
            Intrinsics3.checkNotNullParameter(storeUser, "storeUser");
            Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
            Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
            Intrinsics3.checkNotNullParameter(storeUserPresence, "storeUserPresence");
            Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
            Intrinsics3.checkNotNullParameter(storeExperiments, "storeExperiments");
            Intrinsics3.checkNotNullParameter(storeUserSettings, "storeUserSettings");
            Intrinsics3.checkNotNullParameter(streamContextService, "streamContextService");
            Intrinsics3.checkNotNullParameter(storeAccessibility, "storeAccessibility");
            Observable<StoreState> observableY = StoreUser.observeMe$default(storeUser, false, 1, null).Y(new Func1<MeUser, Observable<? extends Tuples2<? extends MeUser, ? extends User>>>() { // from class: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends Tuples2<MeUser, User>> call(final MeUser meUser) {
                    long j = userId;
                    return j == -1 ? new ScalarSynchronousObservable(new Tuples2(meUser, meUser)) : storeUser.observeUser(j).G(new Func1<User, Tuples2<? extends MeUser, ? extends User>>() { // from class: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$1.1
                        @Override // j0.k.Func1
                        public final Tuples2<MeUser, User> call(User user) {
                            return new Tuples2<>(meUser, user);
                        }
                    });
                }
            }).Y(new Func1<Tuples2<? extends MeUser, ? extends User>, Observable<? extends StoreState>>() { // from class: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$2
                /* JADX WARN: Code duplicated, block: B:11:0x0028  */
                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Observable<? extends UserProfileHeaderViewModel.StoreState> call2(Tuples2<MeUser, ? extends User> tuples2) {
                    Observable<Channel> scalarSynchronousObservable;
                    final MeUser meUserComponent1 = tuples2.component1();
                    final User userComponent2 = tuples2.component2();
                    if (userComponent2 == null) {
                        return EmptyObservableHolder.k;
                    }
                    Long l = channelId;
                    if (l != null) {
                        l.longValue();
                        scalarSynchronousObservable = storeChannels.observeChannel(channelId.longValue());
                        if (scalarSynchronousObservable == null) {
                            scalarSynchronousObservable = new ScalarSynchronousObservable<>(null);
                        }
                    } else {
                        scalarSynchronousObservable = new ScalarSynchronousObservable<>(null);
                    }
                    return Observable.d(UserProfileHeaderViewModel.INSTANCE.observeComputedMembers(channelId, guildId, Sets5.setOf((Object[]) new Long[]{Long.valueOf(meUserComponent1.getId()), Long.valueOf(userComponent2.getId())}), storeChannels, storeGuilds), storeGuilds.observeComputed(), ModelRichPresence.INSTANCE.get(userComponent2.getId(), storeUserPresence), streamContextService.getForUser(userComponent2.getId(), true), storeUserProfile.observeUserProfile(userComponent2.getId()), StoreUserSettings.observeIsAnimatedEmojisEnabled$default(storeUserSettings, false, 1, null), storeAccessibility.observeReducedMotionEnabled(), scalarSynchronousObservable, new Func8<Map<Long, ? extends GuildMember>, Map<Long, ? extends Map<Long, ? extends GuildMember>>, ModelRichPresence, StreamContext, UserProfile, Boolean, Boolean, Channel, UserProfileHeaderViewModel.StoreState>() { // from class: com.discord.widgets.user.profile.UserProfileHeaderViewModel$Companion$observeStoreState$2.1
                        @Override // rx.functions.Func8
                        public /* bridge */ /* synthetic */ UserProfileHeaderViewModel.StoreState call(Map<Long, ? extends GuildMember> map, Map<Long, ? extends Map<Long, ? extends GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
                            return call2((Map<Long, GuildMember>) map, (Map<Long, ? extends Map<Long, GuildMember>>) map2, modelRichPresence, streamContext, userProfile, bool, bool2, channel);
                        }

                        /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                        public final UserProfileHeaderViewModel.StoreState call2(Map<Long, GuildMember> map, Map<Long, ? extends Map<Long, GuildMember>> map2, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, Boolean bool, Boolean bool2, Channel channel) {
                            MeUser meUser = meUserComponent1;
                            Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                            User user = userComponent2;
                            Intrinsics3.checkNotNullExpressionValue(map, "userIdToGuildMembersMap");
                            Collection<? extends Map<Long, GuildMember>> collectionValues = map2.values();
                            Intrinsics3.checkNotNullExpressionValue(userProfile, "userProfile");
                            Intrinsics3.checkNotNullExpressionValue(bool, "allowAnimatedEmojis");
                            boolean zBooleanValue = bool.booleanValue();
                            Intrinsics3.checkNotNullExpressionValue(bool2, "reducedMotionEnabled");
                            return new UserProfileHeaderViewModel.StoreState(meUser, user, map, collectionValues, modelRichPresence, streamContext, userProfile, zBooleanValue, bool2.booleanValue(), channel);
                        }
                    });
                }

                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Observable<? extends UserProfileHeaderViewModel.StoreState> call(Tuples2<? extends MeUser, ? extends User> tuples2) {
                    return call2((Tuples2<MeUser, ? extends User>) tuples2);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableY, "storeUser.observeMe()\n  …            }\n          }");
            return observableY;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
    public static final /* data */ class StoreState {
        private final boolean allowAnimatedEmojis;
        private final Channel channel;
        private final Collection<Map<Long, GuildMember>> guildMembers;
        private final MeUser me;
        private final boolean reducedMotionEnabled;
        private final ModelRichPresence richPresence;
        private final StreamContext streamContext;
        private final User user;
        private final Map<Long, GuildMember> userIdToGuildMemberMap;
        private final UserProfile userProfile;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(MeUser meUser, User user, Map<Long, GuildMember> map, Collection<? extends Map<Long, GuildMember>> collection, ModelRichPresence modelRichPresence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, Channel channel) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(map, "userIdToGuildMemberMap");
            Intrinsics3.checkNotNullParameter(collection, "guildMembers");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            this.me = meUser;
            this.user = user;
            this.userIdToGuildMemberMap = map;
            this.guildMembers = collection;
            this.richPresence = modelRichPresence;
            this.streamContext = streamContext;
            this.userProfile = userProfile;
            this.allowAnimatedEmojis = z2;
            this.reducedMotionEnabled = z3;
            this.channel = channel;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component10, reason: from getter */
        public final Channel getChannel() {
            return this.channel;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final User getUser() {
            return this.user;
        }

        public final Map<Long, GuildMember> component3() {
            return this.userIdToGuildMemberMap;
        }

        public final Collection<Map<Long, GuildMember>> component4() {
            return this.guildMembers;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        public final StoreState copy(MeUser me2, User user, Map<Long, GuildMember> userIdToGuildMemberMap, Collection<? extends Map<Long, GuildMember>> guildMembers, ModelRichPresence richPresence, StreamContext streamContext, UserProfile userProfile, boolean allowAnimatedEmojis, boolean reducedMotionEnabled, Channel channel) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(user, "user");
            Intrinsics3.checkNotNullParameter(userIdToGuildMemberMap, "userIdToGuildMemberMap");
            Intrinsics3.checkNotNullParameter(guildMembers, "guildMembers");
            Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
            return new StoreState(me2, user, userIdToGuildMemberMap, guildMembers, richPresence, streamContext, userProfile, allowAnimatedEmojis, reducedMotionEnabled, channel);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.me, storeState.me) && Intrinsics3.areEqual(this.user, storeState.user) && Intrinsics3.areEqual(this.userIdToGuildMemberMap, storeState.userIdToGuildMemberMap) && Intrinsics3.areEqual(this.guildMembers, storeState.guildMembers) && Intrinsics3.areEqual(this.richPresence, storeState.richPresence) && Intrinsics3.areEqual(this.streamContext, storeState.streamContext) && Intrinsics3.areEqual(this.userProfile, storeState.userProfile) && this.allowAnimatedEmojis == storeState.allowAnimatedEmojis && this.reducedMotionEnabled == storeState.reducedMotionEnabled && Intrinsics3.areEqual(this.channel, storeState.channel);
        }

        public final boolean getAllowAnimatedEmojis() {
            return this.allowAnimatedEmojis;
        }

        public final Channel getChannel() {
            return this.channel;
        }

        public final Collection<Map<Long, GuildMember>> getGuildMembers() {
            return this.guildMembers;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getReducedMotionEnabled() {
            return this.reducedMotionEnabled;
        }

        public final ModelRichPresence getRichPresence() {
            return this.richPresence;
        }

        public final StreamContext getStreamContext() {
            return this.streamContext;
        }

        public final User getUser() {
            return this.user;
        }

        public final Map<Long, GuildMember> getUserIdToGuildMemberMap() {
            return this.userIdToGuildMemberMap;
        }

        public final UserProfile getUserProfile() {
            return this.userProfile;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v16, types: [int] */
        /* JADX WARN: Type inference failed for: r2v19, types: [int] */
        /* JADX WARN: Type inference failed for: r2v22 */
        /* JADX WARN: Type inference failed for: r2v29 */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            User user = this.user;
            int iHashCode2 = (iHashCode + (user != null ? user.hashCode() : 0)) * 31;
            Map<Long, GuildMember> map = this.userIdToGuildMemberMap;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Collection<Map<Long, GuildMember>> collection = this.guildMembers;
            int iHashCode4 = (iHashCode3 + (collection != null ? collection.hashCode() : 0)) * 31;
            ModelRichPresence modelRichPresence = this.richPresence;
            int iHashCode5 = (iHashCode4 + (modelRichPresence != null ? modelRichPresence.hashCode() : 0)) * 31;
            StreamContext streamContext = this.streamContext;
            int iHashCode6 = (iHashCode5 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
            UserProfile userProfile = this.userProfile;
            int iHashCode7 = (iHashCode6 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
            boolean z2 = this.allowAnimatedEmojis;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode7 + r2) * 31;
            boolean z3 = this.reducedMotionEnabled;
            int i2 = (i + (z3 ? 1 : z3)) * 31;
            Channel channel = this.channel;
            return i2 + (channel != null ? channel.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(me=");
            sbU.append(this.me);
            sbU.append(", user=");
            sbU.append(this.user);
            sbU.append(", userIdToGuildMemberMap=");
            sbU.append(this.userIdToGuildMemberMap);
            sbU.append(", guildMembers=");
            sbU.append(this.guildMembers);
            sbU.append(", richPresence=");
            sbU.append(this.richPresence);
            sbU.append(", streamContext=");
            sbU.append(this.streamContext);
            sbU.append(", userProfile=");
            sbU.append(this.userProfile);
            sbU.append(", allowAnimatedEmojis=");
            sbU.append(this.allowAnimatedEmojis);
            sbU.append(", reducedMotionEnabled=");
            sbU.append(this.reducedMotionEnabled);
            sbU.append(", channel=");
            sbU.append(this.channel);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
        public static final class Uninitialized extends ViewState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX INFO: compiled from: UserProfileHeaderViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final boolean allowAnimatedEmojis;
            private final boolean allowAnimationInReducedMotion;

            /* JADX INFO: renamed from: avatarColorId$delegate, reason: from kotlin metadata */
            private final Lazy avatarColorId;
            private final String banner;
            private final String bannerColorHex;
            private final boolean editable;
            private final GuildMember guildMember;

            /* JADX INFO: renamed from: guildMemberColorId$delegate, reason: from kotlin metadata */
            private final Lazy guildMemberColorId;
            private final List<GuildMember> guildMembersForAka;
            private final boolean hasGuildMemberAvatar;
            private final boolean hasNickname;
            private final boolean isMe;
            private final boolean isMeUserPremium;
            private final boolean isMeUserVerified;
            private final boolean isProfileLoaded;
            private final Presence presence;
            private final boolean reducedMotionEnabled;
            private final boolean shouldAnimateBanner;
            private final boolean shouldShowGIFTag;
            private final boolean showAkas;
            private final boolean showMediumAvatar;
            private final boolean showPresence;
            private final boolean showSmallAvatar;
            private final StreamContext streamContext;
            private final User user;
            private final UserProfile userProfile;

            public /* synthetic */ Loaded(User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(user, str, str2, (i & 8) != 0 ? null : guildMember, (i & 16) != 0 ? Collections2.emptyList() : list, (i & 32) != 0 ? null : presence, (i & 64) != 0 ? null : streamContext, (i & 128) != 0 ? StoreUserProfile.INSTANCE.getEMPTY_PROFILE() : userProfile, z2, z3, (i & 1024) != 0 ? false : z4, z5, (i & 4096) != 0 ? false : z6, (i & 8192) != 0 ? false : z7, (i & 16384) != 0 ? false : z8, (i & 32768) != 0 ? false : z9);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, User user, String str, String str2, GuildMember guildMember, List list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9, int i, Object obj) {
                return loaded.copy((i & 1) != 0 ? loaded.user : user, (i & 2) != 0 ? loaded.banner : str, (i & 4) != 0 ? loaded.bannerColorHex : str2, (i & 8) != 0 ? loaded.guildMember : guildMember, (i & 16) != 0 ? loaded.guildMembersForAka : list, (i & 32) != 0 ? loaded.presence : presence, (i & 64) != 0 ? loaded.streamContext : streamContext, (i & 128) != 0 ? loaded.userProfile : userProfile, (i & 256) != 0 ? loaded.isMeUserPremium : z2, (i & 512) != 0 ? loaded.isMeUserVerified : z3, (i & 1024) != 0 ? loaded.allowAnimatedEmojis : z4, (i & 2048) != 0 ? loaded.showPresence : z5, (i & 4096) != 0 ? loaded.editable : z6, (i & 8192) != 0 ? loaded.reducedMotionEnabled : z7, (i & 16384) != 0 ? loaded.allowAnimationInReducedMotion : z8, (i & 32768) != 0 ? loaded.isMe : z9);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final User getUser() {
                return this.user;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final boolean getIsMeUserVerified() {
                return this.isMeUserVerified;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final boolean getShowPresence() {
                return this.showPresence;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final boolean getEditable() {
                return this.editable;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final boolean getReducedMotionEnabled() {
                return this.reducedMotionEnabled;
            }

            /* JADX INFO: renamed from: component15, reason: from getter */
            public final boolean getAllowAnimationInReducedMotion() {
                return this.allowAnimationInReducedMotion;
            }

            /* JADX INFO: renamed from: component16, reason: from getter */
            public final boolean getIsMe() {
                return this.isMe;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final String getBanner() {
                return this.banner;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final String getBannerColorHex() {
                return this.bannerColorHex;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final List<GuildMember> component5() {
                return this.guildMembersForAka;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final Presence getPresence() {
                return this.presence;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final boolean getIsMeUserPremium() {
                return this.isMeUserPremium;
            }

            public final Loaded copy(User user, String banner, String bannerColorHex, GuildMember guildMember, List<GuildMember> guildMembersForAka, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean isMeUserPremium, boolean isMeUserVerified, boolean allowAnimatedEmojis, boolean showPresence, boolean editable, boolean reducedMotionEnabled, boolean allowAnimationInReducedMotion, boolean isMe) {
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(guildMembersForAka, "guildMembersForAka");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                return new Loaded(user, banner, bannerColorHex, guildMember, guildMembersForAka, presence, streamContext, userProfile, isMeUserPremium, isMeUserVerified, allowAnimatedEmojis, showPresence, editable, reducedMotionEnabled, allowAnimationInReducedMotion, isMe);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.user, loaded.user) && Intrinsics3.areEqual(this.banner, loaded.banner) && Intrinsics3.areEqual(this.bannerColorHex, loaded.bannerColorHex) && Intrinsics3.areEqual(this.guildMember, loaded.guildMember) && Intrinsics3.areEqual(this.guildMembersForAka, loaded.guildMembersForAka) && Intrinsics3.areEqual(this.presence, loaded.presence) && Intrinsics3.areEqual(this.streamContext, loaded.streamContext) && Intrinsics3.areEqual(this.userProfile, loaded.userProfile) && this.isMeUserPremium == loaded.isMeUserPremium && this.isMeUserVerified == loaded.isMeUserVerified && this.allowAnimatedEmojis == loaded.allowAnimatedEmojis && this.showPresence == loaded.showPresence && this.editable == loaded.editable && this.reducedMotionEnabled == loaded.reducedMotionEnabled && this.allowAnimationInReducedMotion == loaded.allowAnimationInReducedMotion && this.isMe == loaded.isMe;
            }

            public final boolean getAllowAnimatedEmojis() {
                return this.allowAnimatedEmojis;
            }

            public final boolean getAllowAnimationInReducedMotion() {
                return this.allowAnimationInReducedMotion;
            }

            public final String getAvatarColorId() {
                return (String) this.avatarColorId.getValue();
            }

            public final String getBanner() {
                return this.banner;
            }

            public final String getBannerColorHex() {
                return this.bannerColorHex;
            }

            public final boolean getEditable() {
                return this.editable;
            }

            public final GuildMember getGuildMember() {
                return this.guildMember;
            }

            public final String getGuildMemberColorId() {
                return (String) this.guildMemberColorId.getValue();
            }

            public final List<GuildMember> getGuildMembersForAka() {
                return this.guildMembersForAka;
            }

            public final boolean getHasGuildMemberAvatar() {
                return this.hasGuildMemberAvatar;
            }

            public final boolean getHasNickname() {
                return this.hasNickname;
            }

            public final Presence getPresence() {
                return this.presence;
            }

            public final boolean getReducedMotionEnabled() {
                return this.reducedMotionEnabled;
            }

            public final boolean getShouldAnimateBanner() {
                return this.shouldAnimateBanner;
            }

            public final boolean getShouldShowGIFTag() {
                return this.shouldShowGIFTag;
            }

            public final boolean getShowAkas() {
                return this.showAkas;
            }

            public final boolean getShowMediumAvatar() {
                return this.showMediumAvatar;
            }

            public final boolean getShowPresence() {
                return this.showPresence;
            }

            public final boolean getShowSmallAvatar() {
                return this.showSmallAvatar;
            }

            public final StreamContext getStreamContext() {
                return this.streamContext;
            }

            public final User getUser() {
                return this.user;
            }

            public final UserProfile getUserProfile() {
                return this.userProfile;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v18, types: [int] */
            /* JADX WARN: Type inference failed for: r0v20, types: [int] */
            /* JADX WARN: Type inference failed for: r0v22, types: [int] */
            /* JADX WARN: Type inference failed for: r0v24, types: [int] */
            /* JADX WARN: Type inference failed for: r0v26, types: [int] */
            /* JADX WARN: Type inference failed for: r0v28, types: [int] */
            /* JADX WARN: Type inference failed for: r0v30, types: [int] */
            /* JADX WARN: Type inference failed for: r0v32, types: [int] */
            /* JADX WARN: Type inference failed for: r1v11, types: [int] */
            /* JADX WARN: Type inference failed for: r1v13, types: [int] */
            /* JADX WARN: Type inference failed for: r1v15, types: [int] */
            /* JADX WARN: Type inference failed for: r1v17 */
            /* JADX WARN: Type inference failed for: r1v18 */
            /* JADX WARN: Type inference failed for: r1v19 */
            /* JADX WARN: Type inference failed for: r1v20 */
            /* JADX WARN: Type inference failed for: r1v21 */
            /* JADX WARN: Type inference failed for: r1v22 */
            /* JADX WARN: Type inference failed for: r1v23 */
            /* JADX WARN: Type inference failed for: r1v25 */
            /* JADX WARN: Type inference failed for: r1v26 */
            /* JADX WARN: Type inference failed for: r1v27 */
            /* JADX WARN: Type inference failed for: r1v28 */
            /* JADX WARN: Type inference failed for: r1v29 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v30 */
            /* JADX WARN: Type inference failed for: r1v31 */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v9, types: [int] */
            /* JADX WARN: Type inference failed for: r2v19 */
            /* JADX WARN: Type inference failed for: r2v20, types: [int] */
            /* JADX WARN: Type inference failed for: r2v21 */
            public int hashCode() {
                User user = this.user;
                int iHashCode = (user != null ? user.hashCode() : 0) * 31;
                String str = this.banner;
                int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
                String str2 = this.bannerColorHex;
                int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
                GuildMember guildMember = this.guildMember;
                int iHashCode4 = (iHashCode3 + (guildMember != null ? guildMember.hashCode() : 0)) * 31;
                List<GuildMember> list = this.guildMembersForAka;
                int iHashCode5 = (iHashCode4 + (list != null ? list.hashCode() : 0)) * 31;
                Presence presence = this.presence;
                int iHashCode6 = (iHashCode5 + (presence != null ? presence.hashCode() : 0)) * 31;
                StreamContext streamContext = this.streamContext;
                int iHashCode7 = (iHashCode6 + (streamContext != null ? streamContext.hashCode() : 0)) * 31;
                UserProfile userProfile = this.userProfile;
                int iHashCode8 = (iHashCode7 + (userProfile != null ? userProfile.hashCode() : 0)) * 31;
                boolean z2 = this.isMeUserPremium;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode8 + r1) * 31;
                boolean z3 = this.isMeUserVerified;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.allowAnimatedEmojis;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.showPresence;
                ?? r4 = z5;
                if (z5) {
                    r4 = 1;
                }
                int i4 = (i3 + r4) * 31;
                boolean z6 = this.editable;
                ?? r5 = z6;
                if (z6) {
                    r5 = 1;
                }
                int i5 = (i4 + r5) * 31;
                boolean z7 = this.reducedMotionEnabled;
                ?? r6 = z7;
                if (z7) {
                    r6 = 1;
                }
                int i6 = (i5 + r6) * 31;
                boolean z8 = this.allowAnimationInReducedMotion;
                ?? r7 = z8;
                if (z8) {
                    r7 = 1;
                }
                int i7 = (i6 + r7) * 31;
                boolean z9 = this.isMe;
                return i7 + (z9 ? 1 : z9);
            }

            public final boolean isMe() {
                return this.isMe;
            }

            public final boolean isMeUserPremium() {
                return this.isMeUserPremium;
            }

            public final boolean isMeUserVerified() {
                return this.isMeUserVerified;
            }

            /* JADX INFO: renamed from: isProfileLoaded, reason: from getter */
            public final boolean getIsProfileLoaded() {
                return this.isProfileLoaded;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(user=");
                sbU.append(this.user);
                sbU.append(", banner=");
                sbU.append(this.banner);
                sbU.append(", bannerColorHex=");
                sbU.append(this.bannerColorHex);
                sbU.append(", guildMember=");
                sbU.append(this.guildMember);
                sbU.append(", guildMembersForAka=");
                sbU.append(this.guildMembersForAka);
                sbU.append(", presence=");
                sbU.append(this.presence);
                sbU.append(", streamContext=");
                sbU.append(this.streamContext);
                sbU.append(", userProfile=");
                sbU.append(this.userProfile);
                sbU.append(", isMeUserPremium=");
                sbU.append(this.isMeUserPremium);
                sbU.append(", isMeUserVerified=");
                sbU.append(this.isMeUserVerified);
                sbU.append(", allowAnimatedEmojis=");
                sbU.append(this.allowAnimatedEmojis);
                sbU.append(", showPresence=");
                sbU.append(this.showPresence);
                sbU.append(", editable=");
                sbU.append(this.editable);
                sbU.append(", reducedMotionEnabled=");
                sbU.append(this.reducedMotionEnabled);
                sbU.append(", allowAnimationInReducedMotion=");
                sbU.append(this.allowAnimationInReducedMotion);
                sbU.append(", isMe=");
                return outline.O(sbU, this.isMe, ")");
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(User user, String str, String str2, GuildMember guildMember, List<GuildMember> list, Presence presence, StreamContext streamContext, UserProfile userProfile, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) {
                String nick;
                super(null);
                Intrinsics3.checkNotNullParameter(user, "user");
                Intrinsics3.checkNotNullParameter(list, "guildMembersForAka");
                Intrinsics3.checkNotNullParameter(userProfile, "userProfile");
                this.user = user;
                this.banner = str;
                this.bannerColorHex = str2;
                this.guildMember = guildMember;
                this.guildMembersForAka = list;
                this.presence = presence;
                this.streamContext = streamContext;
                this.userProfile = userProfile;
                this.isMeUserPremium = z2;
                this.isMeUserVerified = z3;
                this.allowAnimatedEmojis = z4;
                this.showPresence = z5;
                this.editable = z6;
                this.reducedMotionEnabled = z7;
                this.allowAnimationInReducedMotion = z8;
                this.isMe = z9;
                boolean z10 = false;
                boolean z11 = guildMember != null && guildMember.hasAvatar();
                this.hasGuildMemberAvatar = z11;
                boolean z12 = !StringsJVM.isBlank((guildMember == null || (nick = guildMember.getNick()) == null) ? "" : nick);
                this.hasNickname = z12;
                this.showMediumAvatar = z11 && !z12;
                this.showSmallAvatar = z11 && z12;
                this.shouldAnimateBanner = !z7 || z8;
                this.shouldShowGIFTag = z7 && !z8 && str != null && StringsJVM.startsWith$default(str, "a_", false, 2, null);
                this.isProfileLoaded = !Intrinsics3.areEqual(userProfile, StoreUserProfile.INSTANCE.getEMPTY_PROFILE());
                this.avatarColorId = LazyJVM.lazy(new UserProfileHeaderViewModel5(this));
                this.guildMemberColorId = LazyJVM.lazy(new UserProfileHeaderViewModel6(this));
                if ((!list.isEmpty()) && !z9) {
                    z10 = true;
                }
                this.showAkas = z10;
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ UserProfileHeaderViewModel(long j, Long l, Long l2, Observable observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile, int i, DefaultConstructorMarker defaultConstructorMarker) {
        Long l3 = (i & 2) != 0 ? null : l;
        Long l4 = (i & 4) == 0 ? l2 : null;
        this(j, l3, l4, (i & 8) != 0 ? Companion.observeStoreState$default(INSTANCE, j, l3, l4, null, null, null, null, null, null, null, null, null, 4088, null) : observable, (i & 16) != 0 ? false : z2, (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser, (i & 64) != 0 ? StoreStream.INSTANCE.getUserProfile() : storeUserProfile);
    }

    private final void handleStoreState(StoreState storeState) {
        List listEmptyList;
        long id2 = storeState.getUser().getId();
        GuildMember guildMember = storeState.getUserIdToGuildMemberMap().get(Long.valueOf(id2));
        NullSerializable<String> nullSerializableB = storeState.getUserProfile().getUser().b();
        if (!(nullSerializableB instanceof NullSerializable.b)) {
            nullSerializableB = null;
        }
        NullSerializable.b bVar = (NullSerializable.b) nullSerializableB;
        String str = bVar != null ? (String) bVar.a() : null;
        Channel channel = storeState.getChannel();
        boolean z2 = channel != null && ChannelUtils.B(channel);
        ViewState viewState = getViewState();
        User user = storeState.getUser();
        NullSerializable<String> nullSerializableC = storeState.getUserProfile().getUser().c();
        String strA = nullSerializableC != null ? nullSerializableC.a() : null;
        if (z2) {
            Collection<Map<Long, GuildMember>> guildMembers = storeState.getGuildMembers();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = guildMembers.iterator();
            while (it.hasNext()) {
                GuildMember guildMember2 = (GuildMember) ((Map) it.next()).get(Long.valueOf(id2));
                if (guildMember2 != null) {
                    arrayList.add(guildMember2);
                }
            }
            listEmptyList = _Collections.toList(arrayList);
        } else {
            listEmptyList = Collections2.emptyList();
        }
        ModelRichPresence richPresence = storeState.getRichPresence();
        updateViewState(new ViewState.Loaded(user, str, strA, guildMember, listEmptyList, richPresence != null ? richPresence.getPresence() : null, storeState.getStreamContext(), storeState.getUserProfile(), UserUtils.INSTANCE.isPremium(storeState.getMe()), storeState.getMe().isVerified(), storeState.getAllowAnimatedEmojis(), true, false, storeState.getReducedMotionEnabled(), viewState instanceof ViewState.Loaded ? ((ViewState.Loaded) viewState).getAllowAnimationInReducedMotion() : false, id2 == storeState.getMe().getId(), 4096, null));
    }

    @MainThread
    public final void toggleAllowAnimationInReducedMotion() {
        ViewState viewState = getViewState();
        if (!(viewState instanceof ViewState.Loaded)) {
            viewState = null;
        }
        ViewState.Loaded loaded = (ViewState.Loaded) viewState;
        if (loaded == null || !loaded.getReducedMotionEnabled()) {
            return;
        }
        updateViewState(ViewState.Loaded.copy$default(loaded, null, null, null, null, null, null, null, null, false, false, false, false, false, false, !loaded.getAllowAnimationInReducedMotion(), false, 49151, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UserProfileHeaderViewModel(long j, Long l, Long l2, Observable<StoreState> observable, boolean z2, StoreUser storeUser, StoreUserProfile storeUserProfile) {
        super(ViewState.Uninitialized.INSTANCE);
        long j2 = j;
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeUserProfile, "storeUserProfile");
        this.userId = j2;
        if (z2) {
            storeUserProfile.fetchProfile(j2 == -1 ? storeUser.getMeSnapshot().getId() : j2, (12 & 2) != 0 ? null : l2, (12 & 4) != 0 ? false : false, (12 & 8) != 0 ? null : null);
        }
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) UserProfileHeaderViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
