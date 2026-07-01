package com.discord.widgets.emoji;

import android.content.Context;
import androidx.fragment.app.Fragment;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.models.domain.emoji.ModelEmojiUnicode;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreEmoji;
import com.discord.stores.StoreEmojiCustom;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreMediaFavorites;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.node.EmojiNode;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.emoji.EmojiSheetViewModel;
import com.discord.widgets.guilds.join.GuildJoinHelper;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import retrofit2.HttpException;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;

/* JADX INFO: compiled from: EmojiSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmojiSheetViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final EmojiNode.EmojiIdAndType emojiIdAndType;
    private final RestAPI restAPI;
    private final StoreAnalytics storeAnalytics;
    private final StoreChannelsSelected storeChannelsSelected;
    private final StoreEmoji storeEmoji;
    private final StoreEmojiCustom storeEmojiCustom;
    private final StoreGuilds storeGuilds;
    private final StoreMediaFavorites storeMediaFavorites;
    private final StoreUser storeUsers;

    /* JADX INFO: renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
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
            EmojiSheetViewModel emojiSheetViewModel = EmojiSheetViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "it");
            emojiSheetViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
        public static abstract class CustomEmojGuildInfo {

            /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
            public static final /* data */ class Known extends CustomEmojGuildInfo {
                private final Integer approximateOnline;
                private final Guild guild;
                private final boolean isPublic;
                private final boolean isUserInGuild;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Known(Guild guild, boolean z2, boolean z3, Integer num) {
                    super(null);
                    Intrinsics3.checkNotNullParameter(guild, "guild");
                    this.guild = guild;
                    this.isPublic = z2;
                    this.isUserInGuild = z3;
                    this.approximateOnline = num;
                }

                public static /* synthetic */ Known copy$default(Known known, Guild guild, boolean z2, boolean z3, Integer num, int i, Object obj) {
                    if ((i & 1) != 0) {
                        guild = known.guild;
                    }
                    if ((i & 2) != 0) {
                        z2 = known.getIsPublic();
                    }
                    if ((i & 4) != 0) {
                        z3 = known.getIsUserInGuild();
                    }
                    if ((i & 8) != 0) {
                        num = known.approximateOnline;
                    }
                    return known.copy(guild, z2, z3, num);
                }

                /* JADX INFO: renamed from: component1, reason: from getter */
                public final Guild getGuild() {
                    return this.guild;
                }

                public final boolean component2() {
                    return getIsPublic();
                }

                public final boolean component3() {
                    return getIsUserInGuild();
                }

                /* JADX INFO: renamed from: component4, reason: from getter */
                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Known copy(Guild guild, boolean isPublic, boolean isUserInGuild, Integer approximateOnline) {
                    Intrinsics3.checkNotNullParameter(guild, "guild");
                    return new Known(guild, isPublic, isUserInGuild, approximateOnline);
                }

                public boolean equals(Object other) {
                    if (this == other) {
                        return true;
                    }
                    if (!(other instanceof Known)) {
                        return false;
                    }
                    Known known = (Known) other;
                    return Intrinsics3.areEqual(this.guild, known.guild) && getIsPublic() == known.getIsPublic() && getIsUserInGuild() == known.getIsUserInGuild() && Intrinsics3.areEqual(this.approximateOnline, known.approximateOnline);
                }

                public final Integer getApproximateOnline() {
                    return this.approximateOnline;
                }

                public final Guild getGuild() {
                    return this.guild;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Type inference failed for: r0v4, types: [int] */
                /* JADX WARN: Type inference failed for: r2v1, types: [int] */
                /* JADX WARN: Type inference failed for: r2v4 */
                /* JADX WARN: Type inference failed for: r2v5 */
                /* JADX WARN: Type inference failed for: r3v0 */
                /* JADX WARN: Type inference failed for: r3v1, types: [int] */
                /* JADX WARN: Type inference failed for: r3v2 */
                public int hashCode() {
                    Guild guild = this.guild;
                    int iHashCode = (guild != null ? guild.hashCode() : 0) * 31;
                    boolean isPublic = getIsPublic();
                    ?? r2 = isPublic;
                    if (isPublic) {
                        r2 = 1;
                    }
                    int i = (iHashCode + r2) * 31;
                    boolean isUserInGuild = getIsUserInGuild();
                    int i2 = (i + (isUserInGuild ? 1 : isUserInGuild)) * 31;
                    Integer num = this.approximateOnline;
                    return i2 + (num != null ? num.hashCode() : 0);
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* JADX INFO: renamed from: isPublic, reason: from getter */
                public boolean getIsPublic() {
                    return this.isPublic;
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* JADX INFO: renamed from: isUserInGuild, reason: from getter */
                public boolean getIsUserInGuild() {
                    return this.isUserInGuild;
                }

                public String toString() {
                    StringBuilder sbU = outline.U("Known(guild=");
                    sbU.append(this.guild);
                    sbU.append(", isPublic=");
                    sbU.append(getIsPublic());
                    sbU.append(", isUserInGuild=");
                    sbU.append(getIsUserInGuild());
                    sbU.append(", approximateOnline=");
                    return outline.F(sbU, this.approximateOnline, ")");
                }
            }

            /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
            public static final class Unknown extends CustomEmojGuildInfo {
                public static final Unknown INSTANCE = new Unknown();
                private static final boolean isPublic = false;
                private static final boolean isUserInGuild = false;

                private Unknown() {
                    super(null);
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* JADX INFO: renamed from: isPublic */
                public boolean getIsPublic() {
                    return isPublic;
                }

                @Override // com.discord.widgets.emoji.EmojiSheetViewModel.Companion.CustomEmojGuildInfo
                /* JADX INFO: renamed from: isUserInGuild */
                public boolean getIsUserInGuild() {
                    return isUserInGuild;
                }
            }

            private CustomEmojGuildInfo() {
            }

            /* JADX INFO: renamed from: isPublic */
            public abstract boolean getIsPublic();

            /* JADX INFO: renamed from: isUserInGuild */
            public abstract boolean getIsUserInGuild();

            public /* synthetic */ CustomEmojGuildInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        private final Observable<CustomEmojGuildInfo> getGuildForCustomEmoji(final RestAPI restAPI, EmojiNode.EmojiIdAndType emojiIdAndType, final StoreGuilds storeGuilds, final StoreEmojiCustom storeEmojiCustom) {
            if (!(emojiIdAndType instanceof EmojiNode.EmojiIdAndType.Custom)) {
                emojiIdAndType = null;
            }
            final EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emojiIdAndType;
            if (custom != null) {
                Observable<CustomEmojGuildInfo> observableA = Observable.D(new Callable<Guild>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // java.util.concurrent.Callable
                    public final Guild call() {
                        Object next;
                        Map.Entry entry;
                        Iterator<T> it = storeEmojiCustom.getAllGuildEmoji().entrySet().iterator();
                        do {
                            if (!it.hasNext()) {
                                next = null;
                                break;
                            }
                            next = it.next();
                            entry = (Map.Entry) next;
                            ((Number) entry.getKey()).longValue();
                        } while (!((Map) entry.getValue()).keySet().contains(Long.valueOf(custom.getId())));
                        Map.Entry entry2 = (Map.Entry) next;
                        if (entry2 == null) {
                            return null;
                        }
                        long jLongValue = ((Number) entry2.getKey()).longValue();
                        return storeGuilds.getGuilds().get(Long.valueOf(jLongValue));
                    }
                }).A(new Func1<Guild, Observable<? extends CustomEmojGuildInfo>>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2
                    @Override // j0.k.Func1
                    public final Observable<? extends EmojiSheetViewModel.Companion.CustomEmojGuildInfo> call(final Guild guild) {
                        if (guild != null) {
                            return guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? restAPI.getEmojiGuild(custom.getId()).G(new Func1<com.discord.api.guild.Guild, Guild>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2.1
                                @Override // j0.k.Func1
                                public final Guild call(com.discord.api.guild.Guild guild2) {
                                    Intrinsics3.checkNotNullExpressionValue(guild2, "it");
                                    return new Guild(guild2);
                                }
                            }).G(new Func1<Guild, EmojiSheetViewModel.Companion.CustomEmojGuildInfo>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2.2
                                @Override // j0.k.Func1
                                public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Guild guild2) {
                                    Intrinsics3.checkNotNullExpressionValue(guild2, "responseGuild");
                                    return new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild2, true, true, Integer.valueOf(guild2.getApproximatePresenceCount()));
                                }
                            }).M(new Func1<Throwable, EmojiSheetViewModel.Companion.CustomEmojGuildInfo>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2.3
                                @Override // j0.k.Func1
                                public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Throwable th) {
                                    return ((th instanceof HttpException) && ((HttpException) th).a() == 404) ? new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, false, true, null) : EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Unknown.INSTANCE;
                                }
                            }) : new ScalarSynchronousObservable(new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild, false, true, null));
                        }
                        return restAPI.getEmojiGuild(custom.getId()).G(new Func1<com.discord.api.guild.Guild, Guild>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2.4
                            @Override // j0.k.Func1
                            public final Guild call(com.discord.api.guild.Guild guild2) {
                                Intrinsics3.checkNotNullExpressionValue(guild2, "it");
                                return new Guild(guild2);
                            }
                        }).G(new Func1<Guild, EmojiSheetViewModel.Companion.CustomEmojGuildInfo>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2.5
                            @Override // j0.k.Func1
                            public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Guild guild2) {
                                Intrinsics3.checkNotNullExpressionValue(guild2, "responseGuild");
                                return new EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Known(guild2, true, false, Integer.valueOf(guild2.getApproximatePresenceCount()));
                            }
                        }).M(new Func1<Throwable, EmojiSheetViewModel.Companion.CustomEmojGuildInfo>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$getGuildForCustomEmoji$2.6
                            @Override // j0.k.Func1
                            public final EmojiSheetViewModel.Companion.CustomEmojGuildInfo call(Throwable th) {
                                return EmojiSheetViewModel.Companion.CustomEmojGuildInfo.Unknown.INSTANCE;
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableA, "Observable.fromCallable …      }\n        }\n      }");
                return observableA;
            }
            ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(null);
            Intrinsics3.checkNotNullExpressionValue(scalarSynchronousObservable, "Observable.just(null)");
            return scalarSynchronousObservable;
        }

        private final Observable<StoreState> observeStoreState(RestAPI restAPI, final EmojiNode.EmojiIdAndType emojiIdAndType, StoreUser storeUsers, StoreGuilds storeGuilds, StoreEmojiCustom storeEmojiCustom, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites) {
            Observable<StoreState> observableG = Observable.g(getGuildForCustomEmoji(restAPI, emojiIdAndType, storeGuilds, storeEmojiCustom), StoreUser.observeMe$default(storeUsers, false, 1, null), storeGuilds.observeGuilds(), storeChannelsSelected.observeSelectedChannel(), storeMediaFavorites.observeFavorites(StoreMediaFavorites.Favorite.INSTANCE.getEmojiTypes()), new Func5<CustomEmojGuildInfo, MeUser, Map<Long, ? extends Guild>, Channel, Set<? extends StoreMediaFavorites.Favorite>, StoreState>() { // from class: com.discord.widgets.emoji.EmojiSheetViewModel$Companion$observeStoreState$1
                @Override // rx.functions.Func5
                public /* bridge */ /* synthetic */ EmojiSheetViewModel.StoreState call(EmojiSheetViewModel.Companion.CustomEmojGuildInfo customEmojGuildInfo, MeUser meUser, Map<Long, ? extends Guild> map, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set) {
                    return call2(customEmojGuildInfo, meUser, (Map<Long, Guild>) map, channel, set);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final EmojiSheetViewModel.StoreState call2(EmojiSheetViewModel.Companion.CustomEmojGuildInfo customEmojGuildInfo, MeUser meUser, Map<Long, Guild> map, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set) {
                    Intrinsics3.checkNotNullParameter(meUser, "meUser");
                    Intrinsics3.checkNotNullParameter(map, "guilds");
                    Intrinsics3.checkNotNullParameter(set, "favorites");
                    return new EmojiSheetViewModel.StoreState(customEmojGuildInfo, emojiIdAndType, UserUtils.INSTANCE.isPremium(meUser), map.keySet(), channel, set);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…es,\n          )\n        }");
            return observableG;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Channel currentChannel;
        private final Companion.CustomEmojGuildInfo customEmojiGuildInfo;
        private final EmojiNode.EmojiIdAndType emoji;
        private final Set<StoreMediaFavorites.Favorite> favorites;
        private final Set<Long> joinedGuildIds;
        private final boolean meUserIsPremium;

        /* JADX WARN: Multi-variable type inference failed */
        public StoreState(Companion.CustomEmojGuildInfo customEmojGuildInfo, EmojiNode.EmojiIdAndType emojiIdAndType, boolean z2, Set<Long> set, Channel channel, Set<? extends StoreMediaFavorites.Favorite> set2) {
            Intrinsics3.checkNotNullParameter(emojiIdAndType, "emoji");
            Intrinsics3.checkNotNullParameter(set, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(set2, "favorites");
            this.customEmojiGuildInfo = customEmojGuildInfo;
            this.emoji = emojiIdAndType;
            this.meUserIsPremium = z2;
            this.joinedGuildIds = set;
            this.currentChannel = channel;
            this.favorites = set2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, Companion.CustomEmojGuildInfo customEmojGuildInfo, EmojiNode.EmojiIdAndType emojiIdAndType, boolean z2, Set set, Channel channel, Set set2, int i, Object obj) {
            if ((i & 1) != 0) {
                customEmojGuildInfo = storeState.customEmojiGuildInfo;
            }
            if ((i & 2) != 0) {
                emojiIdAndType = storeState.emoji;
            }
            EmojiNode.EmojiIdAndType emojiIdAndType2 = emojiIdAndType;
            if ((i & 4) != 0) {
                z2 = storeState.meUserIsPremium;
            }
            boolean z3 = z2;
            if ((i & 8) != 0) {
                set = storeState.joinedGuildIds;
            }
            Set set3 = set;
            if ((i & 16) != 0) {
                channel = storeState.currentChannel;
            }
            Channel channel2 = channel;
            if ((i & 32) != 0) {
                set2 = storeState.favorites;
            }
            return storeState.copy(customEmojGuildInfo, emojiIdAndType2, z3, set3, channel2, set2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final Companion.CustomEmojGuildInfo getCustomEmojiGuildInfo() {
            return this.customEmojiGuildInfo;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final EmojiNode.EmojiIdAndType getEmoji() {
            return this.emoji;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getMeUserIsPremium() {
            return this.meUserIsPremium;
        }

        public final Set<Long> component4() {
            return this.joinedGuildIds;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final Channel getCurrentChannel() {
            return this.currentChannel;
        }

        public final Set<StoreMediaFavorites.Favorite> component6() {
            return this.favorites;
        }

        public final StoreState copy(Companion.CustomEmojGuildInfo customEmojiGuildInfo, EmojiNode.EmojiIdAndType emoji, boolean meUserIsPremium, Set<Long> joinedGuildIds, Channel currentChannel, Set<? extends StoreMediaFavorites.Favorite> favorites) {
            Intrinsics3.checkNotNullParameter(emoji, "emoji");
            Intrinsics3.checkNotNullParameter(joinedGuildIds, "joinedGuildIds");
            Intrinsics3.checkNotNullParameter(favorites, "favorites");
            return new StoreState(customEmojiGuildInfo, emoji, meUserIsPremium, joinedGuildIds, currentChannel, favorites);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.customEmojiGuildInfo, storeState.customEmojiGuildInfo) && Intrinsics3.areEqual(this.emoji, storeState.emoji) && this.meUserIsPremium == storeState.meUserIsPremium && Intrinsics3.areEqual(this.joinedGuildIds, storeState.joinedGuildIds) && Intrinsics3.areEqual(this.currentChannel, storeState.currentChannel) && Intrinsics3.areEqual(this.favorites, storeState.favorites);
        }

        public final Channel getCurrentChannel() {
            return this.currentChannel;
        }

        public final Companion.CustomEmojGuildInfo getCustomEmojiGuildInfo() {
            return this.customEmojiGuildInfo;
        }

        public final EmojiNode.EmojiIdAndType getEmoji() {
            return this.emoji;
        }

        public final Set<StoreMediaFavorites.Favorite> getFavorites() {
            return this.favorites;
        }

        public final Set<Long> getJoinedGuildIds() {
            return this.joinedGuildIds;
        }

        public final boolean getMeUserIsPremium() {
            return this.meUserIsPremium;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v14 */
        /* JADX WARN: Type inference failed for: r2v16 */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        public int hashCode() {
            Companion.CustomEmojGuildInfo customEmojGuildInfo = this.customEmojiGuildInfo;
            int iHashCode = (customEmojGuildInfo != null ? customEmojGuildInfo.hashCode() : 0) * 31;
            EmojiNode.EmojiIdAndType emojiIdAndType = this.emoji;
            int iHashCode2 = (iHashCode + (emojiIdAndType != null ? emojiIdAndType.hashCode() : 0)) * 31;
            boolean z2 = this.meUserIsPremium;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            Set<Long> set = this.joinedGuildIds;
            int iHashCode3 = (i + (set != null ? set.hashCode() : 0)) * 31;
            Channel channel = this.currentChannel;
            int iHashCode4 = (iHashCode3 + (channel != null ? channel.hashCode() : 0)) * 31;
            Set<StoreMediaFavorites.Favorite> set2 = this.favorites;
            return iHashCode4 + (set2 != null ? set2.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(customEmojiGuildInfo=");
            sbU.append(this.customEmojiGuildInfo);
            sbU.append(", emoji=");
            sbU.append(this.emoji);
            sbU.append(", meUserIsPremium=");
            sbU.append(this.meUserIsPremium);
            sbU.append(", joinedGuildIds=");
            sbU.append(this.joinedGuildIds);
            sbU.append(", currentChannel=");
            sbU.append(this.currentChannel);
            sbU.append(", favorites=");
            return outline.N(sbU, this.favorites, ")");
        }
    }

    /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
        public static final class Dismiss extends ViewState {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
        public static final /* data */ class EmojiCustom extends ViewState {
            private final boolean canFavorite;
            private final EmojiNode.EmojiIdAndType.Custom emojiCustom;
            private final Companion.CustomEmojGuildInfo emojiGuildInfo;
            private final boolean isCurrentGuild;
            private final boolean isFavorite;
            private final boolean isUserPremium;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiCustom(EmojiNode.EmojiIdAndType.Custom custom, Companion.CustomEmojGuildInfo customEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5) {
                super(null);
                Intrinsics3.checkNotNullParameter(custom, "emojiCustom");
                Intrinsics3.checkNotNullParameter(customEmojGuildInfo, "emojiGuildInfo");
                this.emojiCustom = custom;
                this.emojiGuildInfo = customEmojGuildInfo;
                this.isUserPremium = z2;
                this.isCurrentGuild = z3;
                this.canFavorite = z4;
                this.isFavorite = z5;
            }

            public static /* synthetic */ EmojiCustom copy$default(EmojiCustom emojiCustom, EmojiNode.EmojiIdAndType.Custom custom, Companion.CustomEmojGuildInfo customEmojGuildInfo, boolean z2, boolean z3, boolean z4, boolean z5, int i, Object obj) {
                if ((i & 1) != 0) {
                    custom = emojiCustom.emojiCustom;
                }
                if ((i & 2) != 0) {
                    customEmojGuildInfo = emojiCustom.emojiGuildInfo;
                }
                Companion.CustomEmojGuildInfo customEmojGuildInfo2 = customEmojGuildInfo;
                if ((i & 4) != 0) {
                    z2 = emojiCustom.isUserPremium;
                }
                boolean z6 = z2;
                if ((i & 8) != 0) {
                    z3 = emojiCustom.isCurrentGuild;
                }
                boolean z7 = z3;
                if ((i & 16) != 0) {
                    z4 = emojiCustom.canFavorite;
                }
                boolean z8 = z4;
                if ((i & 32) != 0) {
                    z5 = emojiCustom.isFavorite;
                }
                return emojiCustom.copy(custom, customEmojGuildInfo2, z6, z7, z8, z5);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final EmojiNode.EmojiIdAndType.Custom getEmojiCustom() {
                return this.emojiCustom;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final Companion.CustomEmojGuildInfo getEmojiGuildInfo() {
                return this.emojiGuildInfo;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsCurrentGuild() {
                return this.isCurrentGuild;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final boolean getIsFavorite() {
                return this.isFavorite;
            }

            public final EmojiCustom copy(EmojiNode.EmojiIdAndType.Custom emojiCustom, Companion.CustomEmojGuildInfo emojiGuildInfo, boolean isUserPremium, boolean isCurrentGuild, boolean canFavorite, boolean isFavorite) {
                Intrinsics3.checkNotNullParameter(emojiCustom, "emojiCustom");
                Intrinsics3.checkNotNullParameter(emojiGuildInfo, "emojiGuildInfo");
                return new EmojiCustom(emojiCustom, emojiGuildInfo, isUserPremium, isCurrentGuild, canFavorite, isFavorite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiCustom)) {
                    return false;
                }
                EmojiCustom emojiCustom = (EmojiCustom) other;
                return Intrinsics3.areEqual(this.emojiCustom, emojiCustom.emojiCustom) && Intrinsics3.areEqual(this.emojiGuildInfo, emojiCustom.emojiGuildInfo) && this.isUserPremium == emojiCustom.isUserPremium && this.isCurrentGuild == emojiCustom.isCurrentGuild && this.canFavorite == emojiCustom.canFavorite && this.isFavorite == emojiCustom.isFavorite;
            }

            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            public final EmojiNode.EmojiIdAndType.Custom getEmojiCustom() {
                return this.emojiCustom;
            }

            public final Companion.CustomEmojGuildInfo getEmojiGuildInfo() {
                return this.emojiGuildInfo;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v10, types: [int] */
            /* JADX WARN: Type inference failed for: r0v12, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r0v8, types: [int] */
            /* JADX WARN: Type inference failed for: r1v10 */
            /* JADX WARN: Type inference failed for: r1v11 */
            /* JADX WARN: Type inference failed for: r1v13 */
            /* JADX WARN: Type inference failed for: r1v14 */
            /* JADX WARN: Type inference failed for: r1v15 */
            /* JADX WARN: Type inference failed for: r1v3, types: [int] */
            /* JADX WARN: Type inference failed for: r1v5, types: [int] */
            /* JADX WARN: Type inference failed for: r1v7, types: [int] */
            /* JADX WARN: Type inference failed for: r1v9 */
            /* JADX WARN: Type inference failed for: r2v1 */
            /* JADX WARN: Type inference failed for: r2v2, types: [int] */
            /* JADX WARN: Type inference failed for: r2v3 */
            public int hashCode() {
                EmojiNode.EmojiIdAndType.Custom custom = this.emojiCustom;
                int iHashCode = (custom != null ? custom.hashCode() : 0) * 31;
                Companion.CustomEmojGuildInfo customEmojGuildInfo = this.emojiGuildInfo;
                int iHashCode2 = (iHashCode + (customEmojGuildInfo != null ? customEmojGuildInfo.hashCode() : 0)) * 31;
                boolean z2 = this.isUserPremium;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode2 + r1) * 31;
                boolean z3 = this.isCurrentGuild;
                ?? r2 = z3;
                if (z3) {
                    r2 = 1;
                }
                int i2 = (i + r2) * 31;
                boolean z4 = this.canFavorite;
                ?? r3 = z4;
                if (z4) {
                    r3 = 1;
                }
                int i3 = (i2 + r3) * 31;
                boolean z5 = this.isFavorite;
                return i3 + (z5 ? 1 : z5);
            }

            public final boolean isCurrentGuild() {
                return this.isCurrentGuild;
            }

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiCustom(emojiCustom=");
                sbU.append(this.emojiCustom);
                sbU.append(", emojiGuildInfo=");
                sbU.append(this.emojiGuildInfo);
                sbU.append(", isUserPremium=");
                sbU.append(this.isUserPremium);
                sbU.append(", isCurrentGuild=");
                sbU.append(this.isCurrentGuild);
                sbU.append(", canFavorite=");
                sbU.append(this.canFavorite);
                sbU.append(", isFavorite=");
                return outline.O(sbU, this.isFavorite, ")");
            }
        }

        /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
        public static final /* data */ class EmojiUnicode extends ViewState {
            private final boolean canFavorite;
            private final ModelEmojiUnicode emojiUnicode;
            private final boolean isFavorite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public EmojiUnicode(ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3) {
                super(null);
                Intrinsics3.checkNotNullParameter(modelEmojiUnicode, "emojiUnicode");
                this.emojiUnicode = modelEmojiUnicode;
                this.canFavorite = z2;
                this.isFavorite = z3;
            }

            public static /* synthetic */ EmojiUnicode copy$default(EmojiUnicode emojiUnicode, ModelEmojiUnicode modelEmojiUnicode, boolean z2, boolean z3, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelEmojiUnicode = emojiUnicode.emojiUnicode;
                }
                if ((i & 2) != 0) {
                    z2 = emojiUnicode.canFavorite;
                }
                if ((i & 4) != 0) {
                    z3 = emojiUnicode.isFavorite;
                }
                return emojiUnicode.copy(modelEmojiUnicode, z2, z3);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelEmojiUnicode getEmojiUnicode() {
                return this.emojiUnicode;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsFavorite() {
                return this.isFavorite;
            }

            public final EmojiUnicode copy(ModelEmojiUnicode emojiUnicode, boolean canFavorite, boolean isFavorite) {
                Intrinsics3.checkNotNullParameter(emojiUnicode, "emojiUnicode");
                return new EmojiUnicode(emojiUnicode, canFavorite, isFavorite);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof EmojiUnicode)) {
                    return false;
                }
                EmojiUnicode emojiUnicode = (EmojiUnicode) other;
                return Intrinsics3.areEqual(this.emojiUnicode, emojiUnicode.emojiUnicode) && this.canFavorite == emojiUnicode.canFavorite && this.isFavorite == emojiUnicode.isFavorite;
            }

            public final boolean getCanFavorite() {
                return this.canFavorite;
            }

            public final ModelEmojiUnicode getEmojiUnicode() {
                return this.emojiUnicode;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r0v6, types: [int] */
            /* JADX WARN: Type inference failed for: r1v1, types: [int] */
            /* JADX WARN: Type inference failed for: r1v3 */
            /* JADX WARN: Type inference failed for: r1v4 */
            /* JADX WARN: Type inference failed for: r2v0 */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v2 */
            public int hashCode() {
                ModelEmojiUnicode modelEmojiUnicode = this.emojiUnicode;
                int iHashCode = (modelEmojiUnicode != null ? modelEmojiUnicode.hashCode() : 0) * 31;
                boolean z2 = this.canFavorite;
                ?? r1 = z2;
                if (z2) {
                    r1 = 1;
                }
                int i = (iHashCode + r1) * 31;
                boolean z3 = this.isFavorite;
                return i + (z3 ? 1 : z3);
            }

            public final boolean isFavorite() {
                return this.isFavorite;
            }

            public String toString() {
                StringBuilder sbU = outline.U("EmojiUnicode(emojiUnicode=");
                sbU.append(this.emojiUnicode);
                sbU.append(", canFavorite=");
                sbU.append(this.canFavorite);
                sbU.append(", isFavorite=");
                return outline.O(sbU, this.isFavorite, ")");
            }
        }

        /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
        public static final class Invalid extends ViewState {
            public static final Invalid INSTANCE = new Invalid();

            private Invalid() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
        public static final class Loading extends ViewState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private ViewState() {
        }

        public /* synthetic */ ViewState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.emoji.EmojiSheetViewModel$joinGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: EmojiSheetViewModel.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<com.discord.api.guild.Guild, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            Intrinsics3.checkNotNullParameter(guild, "it");
            EmojiSheetViewModel.this.updateViewState(ViewState.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ EmojiSheetViewModel(EmojiNode.EmojiIdAndType emojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreEmoji emojis = (i & 4) != 0 ? StoreStream.INSTANCE.getEmojis() : storeEmoji;
        StoreEmojiCustom customEmojis = (i & 8) != 0 ? StoreStream.INSTANCE.getCustomEmojis() : storeEmojiCustom;
        StoreAnalytics analytics = (i & 16) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        StoreUser users = (i & 32) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreGuilds guilds = (i & 64) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        StoreChannelsSelected channelsSelected = (i & 128) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreMediaFavorites mediaFavorites = (i & 256) != 0 ? StoreStream.INSTANCE.getMediaFavorites() : storeMediaFavorites;
        this(emojiIdAndType, api, emojis, customEmojis, analytics, users, guilds, channelsSelected, mediaFavorites, (i & 512) != 0 ? INSTANCE.observeStoreState(api, emojiIdAndType, users, guilds, customEmojis, channelsSelected, mediaFavorites) : observable);
    }

    private final void customPopoutAnalytics(StoreState storeState) {
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emoji;
        Companion.CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        Intrinsics3.checkNotNull(customEmojiGuildInfo);
        boolean z2 = !customEmojiGuildInfo.getIsPublic();
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        boolean meUserIsPremium = storeState.getMeUserIsPremium();
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openCustomEmojiPopout(currentChannel, custom.getId(), meUserIsPremium, isUserInGuild, z2);
        }
    }

    private final void handleStoreState(StoreState storeState) {
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        if (emoji instanceof EmojiNode.EmojiIdAndType.Unicode) {
            standardPopoutAnalytics(storeState);
            handleStoreStateUnicode(storeState);
        } else if (emoji instanceof EmojiNode.EmojiIdAndType.Custom) {
            customPopoutAnalytics(storeState);
            handleStoreStateCustom(storeState);
        }
    }

    private final void handleStoreStateCustom(StoreState storeState) {
        boolean z2;
        Guild guild;
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Custom");
        EmojiNode.EmojiIdAndType.Custom custom = (EmojiNode.EmojiIdAndType.Custom) emoji;
        Companion.CustomEmojGuildInfo customEmojiGuildInfo = storeState.getCustomEmojiGuildInfo();
        Intrinsics3.checkNotNull(customEmojiGuildInfo);
        boolean zContains = storeState.getFavorites().contains(new StoreMediaFavorites.Favorite.FavCustomEmoji(custom));
        boolean isUserInGuild = customEmojiGuildInfo.getIsUserInGuild();
        Channel currentChannel = storeState.getCurrentChannel();
        boolean z3 = false;
        if (currentChannel != null) {
            long guildId = currentChannel.getGuildId();
            Companion.CustomEmojGuildInfo.Known known = (Companion.CustomEmojGuildInfo.Known) (!(customEmojiGuildInfo instanceof Companion.CustomEmojGuildInfo.Known) ? null : customEmojiGuildInfo);
            if (known != null && (guild = known.getGuild()) != null && guild.getId() == guildId) {
                z3 = true;
            }
            z2 = z3;
        } else {
            z2 = false;
        }
        updateViewState(new ViewState.EmojiCustom(custom, customEmojiGuildInfo, storeState.getMeUserIsPremium(), z2, isUserInGuild, zContains));
    }

    private final void handleStoreStateUnicode(StoreState storeState) {
        ViewState emojiUnicode;
        EmojiNode.EmojiIdAndType emoji = storeState.getEmoji();
        Objects.requireNonNull(emoji, "null cannot be cast to non-null type com.discord.utilities.textprocessing.node.EmojiNode.EmojiIdAndType.Unicode");
        ModelEmojiUnicode modelEmojiUnicode = this.storeEmoji.getUnicodeEmojisNamesMap().get(((EmojiNode.EmojiIdAndType.Unicode) emoji).getName());
        if (modelEmojiUnicode != null) {
            emojiUnicode = new ViewState.EmojiUnicode(modelEmojiUnicode, true, storeState.getFavorites().contains(new StoreMediaFavorites.Favorite.FavUnicodeEmoji(modelEmojiUnicode)));
        } else {
            emojiUnicode = ViewState.Invalid.INSTANCE;
        }
        updateViewState(emojiUnicode);
    }

    private final void standardPopoutAnalytics(StoreState storeState) {
        Channel currentChannel = storeState.getCurrentChannel();
        if (currentChannel != null) {
            this.storeAnalytics.openUnicodeEmojiPopout(currentChannel);
        }
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        Intrinsics3.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        Intrinsics3.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelper.joinGuild(contextRequireContext, guild.getId(), false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : null, (944 & 32) != 0 ? null : null, EmojiSheetViewModel.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, new AnonymousClass1());
    }

    public final void setFavorite(boolean favorite) {
        Object favUnicodeEmoji;
        ViewState viewState = getViewState();
        if (viewState != null) {
            if (viewState instanceof ViewState.EmojiCustom) {
                favUnicodeEmoji = new StoreMediaFavorites.Favorite.FavCustomEmoji(((ViewState.EmojiCustom) viewState).getEmojiCustom());
            } else if (!(viewState instanceof ViewState.EmojiUnicode)) {
                return;
            } else {
                favUnicodeEmoji = new StoreMediaFavorites.Favorite.FavUnicodeEmoji(((ViewState.EmojiUnicode) viewState).getEmojiUnicode());
            }
            Object exhaustive = KotlinExtensions.getExhaustive(favUnicodeEmoji);
            if (favorite) {
                this.storeMediaFavorites.addFavorite((StoreMediaFavorites.Favorite) exhaustive);
            } else {
                this.storeMediaFavorites.removeFavorite((StoreMediaFavorites.Favorite) exhaustive);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmojiSheetViewModel(EmojiNode.EmojiIdAndType emojiIdAndType, RestAPI restAPI, StoreEmoji storeEmoji, StoreEmojiCustom storeEmojiCustom, StoreAnalytics storeAnalytics, StoreUser storeUser, StoreGuilds storeGuilds, StoreChannelsSelected storeChannelsSelected, StoreMediaFavorites storeMediaFavorites, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        Intrinsics3.checkNotNullParameter(emojiIdAndType, "emojiIdAndType");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        Intrinsics3.checkNotNullParameter(storeEmoji, "storeEmoji");
        Intrinsics3.checkNotNullParameter(storeEmojiCustom, "storeEmojiCustom");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(storeUser, "storeUsers");
        Intrinsics3.checkNotNullParameter(storeGuilds, "storeGuilds");
        Intrinsics3.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        Intrinsics3.checkNotNullParameter(storeMediaFavorites, "storeMediaFavorites");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        this.emojiIdAndType = emojiIdAndType;
        this.restAPI = restAPI;
        this.storeEmoji = storeEmoji;
        this.storeEmojiCustom = storeEmojiCustom;
        this.storeAnalytics = storeAnalytics;
        this.storeUsers = storeUser;
        this.storeGuilds = storeGuilds;
        this.storeChannelsSelected = storeChannelsSelected;
        this.storeMediaFavorites = storeMediaFavorites;
        Observable observableR = ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableR, (Class<?>) EmojiSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
