package com.discord.widgets.stickers;

import android.content.Context;
import androidx.annotation.MainThread;
import androidx.fragment.app.Fragment;
import com.discord.api.channel.Channel;
import com.discord.api.guild.GuildFeature;
import com.discord.api.sticker.Sticker;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreChannelsSelected;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.guilds.join.GuildJoinHelperKt;
import java.util.Map;
import java.util.concurrent.Callable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p007b.p008a.p018d.AbstractC0859d0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;
import retrofit2.HttpException;

/* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class GuildStickerSheetViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final RestAPI restAPI;
    private final Sticker sticker;
    private final StoreUser storeUser;

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$1 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101191 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C101191() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "storeState");
            GuildStickerSheetViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
        public static abstract class GuildStickerGuildInfo {

            /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
            public static final /* data */ class Known extends GuildStickerGuildInfo {
                private final Integer approximateOnline;
                private final Guild guild;
                private final boolean isPublic;
                private final boolean isUserInGuild;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public Known(Guild guild, boolean z2, boolean z3, Integer num) {
                    super(null);
                    C12238m.checkNotNullParameter(guild, "guild");
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
                    C12238m.checkNotNullParameter(guild, "guild");
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
                    return C12238m.areEqual(this.guild, known.guild) && getIsPublic() == known.getIsPublic() && getIsUserInGuild() == known.getIsUserInGuild() && C12238m.areEqual(this.approximateOnline, known.approximateOnline);
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

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isPublic, reason: from getter */
                public boolean getIsPublic() {
                    return this.isPublic;
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isUserInGuild, reason: from getter */
                public boolean getIsUserInGuild() {
                    return this.isUserInGuild;
                }

                public String toString() {
                    StringBuilder sbM833U = C1643a.m833U("Known(guild=");
                    sbM833U.append(this.guild);
                    sbM833U.append(", isPublic=");
                    sbM833U.append(getIsPublic());
                    sbM833U.append(", isUserInGuild=");
                    sbM833U.append(getIsUserInGuild());
                    sbM833U.append(", approximateOnline=");
                    return C1643a.m818F(sbM833U, this.approximateOnline, ")");
                }
            }

            /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
            public static final class Unknown extends GuildStickerGuildInfo {
                public static final Unknown INSTANCE = new Unknown();
                private static final boolean isPublic = false;
                private static final boolean isUserInGuild = false;

                private Unknown() {
                    super(null);
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isPublic */
                public boolean getIsPublic() {
                    return isPublic;
                }

                @Override // com.discord.widgets.stickers.GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo
                /* JADX INFO: renamed from: isUserInGuild */
                public boolean getIsUserInGuild() {
                    return isUserInGuild;
                }
            }

            private GuildStickerGuildInfo() {
            }

            /* JADX INFO: renamed from: isPublic */
            public abstract boolean getIsPublic();

            /* JADX INFO: renamed from: isUserInGuild */
            public abstract boolean getIsUserInGuild();

            public /* synthetic */ GuildStickerGuildInfo(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        private Companion() {
        }

        private final Observable<GuildStickerGuildInfo> getGuildForGuildSticker(final RestAPI restAPI, final Sticker sticker, final StoreGuilds storeGuilds) {
            Observable<GuildStickerGuildInfo> observableM11082A = Observable.m11060D(new Callable<Guild>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$1
                /* JADX WARN: Can't rename method to resolve collision */
                @Override // java.util.concurrent.Callable
                public final Guild call() {
                    return storeGuilds.getGuilds().get(sticker.getGuildId());
                }
            }).m11082A(new InterfaceC12589b<Guild, Observable<? extends GuildStickerGuildInfo>>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo> call(final Guild guild) {
                    if (guild != null) {
                        return guild.getFeatures().contains(GuildFeature.DISCOVERABLE) ? restAPI.getStickerGuild(sticker.getId()).m11083G(new InterfaceC12589b<com.discord.api.guild.Guild, Guild>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Guild call(com.discord.api.guild.Guild guild2) {
                                C12238m.checkNotNullExpressionValue(guild2, "it");
                                return new Guild(guild2);
                            }
                        }).m11083G(new InterfaceC12589b<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2.2
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild2) {
                                C12238m.checkNotNullExpressionValue(guild2, "responseGuild");
                                return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild2, true, true, Integer.valueOf(guild2.getApproximatePresenceCount()));
                            }
                        }).m11087M(new InterfaceC12589b<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2.3
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
                                return ((th instanceof HttpException) && ((HttpException) th).m11055a() == 404) ? new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, false, true, null) : GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
                            }
                        }) : new C12721k(new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild, false, true, null));
                    }
                    return restAPI.getStickerGuild(sticker.getId()).m11083G(new InterfaceC12589b<com.discord.api.guild.Guild, Guild>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2.4
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final Guild call(com.discord.api.guild.Guild guild2) {
                            C12238m.checkNotNullExpressionValue(guild2, "it");
                            return new Guild(guild2);
                        }
                    }).m11083G(new InterfaceC12589b<Guild, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2.5
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Guild guild2) {
                            C12238m.checkNotNullExpressionValue(guild2, "responseGuild");
                            return new GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Known(guild2, true, false, Integer.valueOf(guild2.getApproximatePresenceCount()));
                        }
                    }).m11087M(new InterfaceC12589b<Throwable, GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$getGuildForGuildSticker$2.6
                        @Override // p637j0.p641k.InterfaceC12589b
                        public final GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo call(Throwable th) {
                            return GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo.Unknown.INSTANCE;
                        }
                    });
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11082A, "Observable.fromCallable …      }\n        }\n      }");
            return observableM11082A;
        }

        private final Observable<StoreState> observeStoreState(RestAPI restAPI, Sticker sticker, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds) {
            Observable<StoreState> observableM11073h = Observable.m11073h(getGuildForGuildSticker(restAPI, sticker, storeGuilds), StoreUser.observeMe$default(storeUser, false, 1, null), storeChannelsSelected.observeSelectedChannel(), storeGuilds.observeGuilds(), new Func4<GuildStickerGuildInfo, MeUser, Channel, Map<Long, ? extends Guild>, StoreState>() { // from class: com.discord.widgets.stickers.GuildStickerSheetViewModel$Companion$observeStoreState$1
                @Override // p658rx.functions.Func4
                public /* bridge */ /* synthetic */ GuildStickerSheetViewModel.StoreState call(GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, ? extends Guild> map) {
                    return call2(guildStickerGuildInfo, meUser, channel, (Map<Long, Guild>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final GuildStickerSheetViewModel.StoreState call2(GuildStickerSheetViewModel.Companion.GuildStickerGuildInfo guildStickerGuildInfo, MeUser meUser, Channel channel, Map<Long, Guild> map) {
                    C12238m.checkNotNullExpressionValue(meUser, "meUser");
                    Long lValueOf = channel != null ? Long.valueOf(channel.getGuildId()) : null;
                    C12238m.checkNotNullExpressionValue(map, "userGuilds");
                    C12238m.checkNotNullExpressionValue(guildStickerGuildInfo, "guildStickerGuildInfo");
                    return new GuildStickerSheetViewModel.StoreState(meUser, lValueOf, map, guildStickerGuildInfo);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…erGuildInfo\n      )\n    }");
            return observableM11073h;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final /* data */ class StoreState {
        private final Long currentGuildId;
        private final Companion.GuildStickerGuildInfo guildStickerGuildInfo;
        private final MeUser meUser;
        private final Map<Long, Guild> userGuilds;

        public StoreState(MeUser meUser, Long l, Map<Long, Guild> map, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(map, "userGuilds");
            C12238m.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
            this.meUser = meUser;
            this.currentGuildId = l;
            this.userGuilds = map;
            this.guildStickerGuildInfo = guildStickerGuildInfo;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ StoreState copy$default(StoreState storeState, MeUser meUser, Long l, Map map, Companion.GuildStickerGuildInfo guildStickerGuildInfo, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = storeState.meUser;
            }
            if ((i & 2) != 0) {
                l = storeState.currentGuildId;
            }
            if ((i & 4) != 0) {
                map = storeState.userGuilds;
            }
            if ((i & 8) != 0) {
                guildStickerGuildInfo = storeState.guildStickerGuildInfo;
            }
            return storeState.copy(meUser, l, map, guildStickerGuildInfo);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final Long getCurrentGuildId() {
            return this.currentGuildId;
        }

        public final Map<Long, Guild> component3() {
            return this.userGuilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
            return this.guildStickerGuildInfo;
        }

        public final StoreState copy(MeUser meUser, Long currentGuildId, Map<Long, Guild> userGuilds, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(userGuilds, "userGuilds");
            C12238m.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
            return new StoreState(meUser, currentGuildId, userGuilds, guildStickerGuildInfo);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return C12238m.areEqual(this.meUser, storeState.meUser) && C12238m.areEqual(this.currentGuildId, storeState.currentGuildId) && C12238m.areEqual(this.userGuilds, storeState.userGuilds) && C12238m.areEqual(this.guildStickerGuildInfo, storeState.guildStickerGuildInfo);
        }

        public final Long getCurrentGuildId() {
            return this.currentGuildId;
        }

        public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
            return this.guildStickerGuildInfo;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final Map<Long, Guild> getUserGuilds() {
            return this.userGuilds;
        }

        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            Long l = this.currentGuildId;
            int iHashCode2 = (iHashCode + (l != null ? l.hashCode() : 0)) * 31;
            Map<Long, Guild> map = this.userGuilds;
            int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
            Companion.GuildStickerGuildInfo guildStickerGuildInfo = this.guildStickerGuildInfo;
            return iHashCode3 + (guildStickerGuildInfo != null ? guildStickerGuildInfo.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("StoreState(meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", currentGuildId=");
            sbM833U.append(this.currentGuildId);
            sbM833U.append(", userGuilds=");
            sbM833U.append(this.userGuilds);
            sbM833U.append(", guildStickerGuildInfo=");
            sbM833U.append(this.guildStickerGuildInfo);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
        public static final class Dismiss extends ViewState {
            public static final Dismiss INSTANCE = new Dismiss();

            private Dismiss() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final Companion.GuildStickerGuildInfo guildStickerGuildInfo;
            private final boolean isCurrentGuild;
            private final boolean isUserPremium;
            private final Sticker sticker;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(Sticker sticker, boolean z2, boolean z3, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
                super(null);
                C12238m.checkNotNullParameter(sticker, "sticker");
                C12238m.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
                this.sticker = sticker;
                this.isUserPremium = z2;
                this.isCurrentGuild = z3;
                this.guildStickerGuildInfo = guildStickerGuildInfo;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, Sticker sticker, boolean z2, boolean z3, Companion.GuildStickerGuildInfo guildStickerGuildInfo, int i, Object obj) {
                if ((i & 1) != 0) {
                    sticker = loaded.sticker;
                }
                if ((i & 2) != 0) {
                    z2 = loaded.isUserPremium;
                }
                if ((i & 4) != 0) {
                    z3 = loaded.isCurrentGuild;
                }
                if ((i & 8) != 0) {
                    guildStickerGuildInfo = loaded.guildStickerGuildInfo;
                }
                return loaded.copy(sticker, z2, z3, guildStickerGuildInfo);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final Sticker getSticker() {
                return this.sticker;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getIsUserPremium() {
                return this.isUserPremium;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final boolean getIsCurrentGuild() {
                return this.isCurrentGuild;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
                return this.guildStickerGuildInfo;
            }

            public final Loaded copy(Sticker sticker, boolean isUserPremium, boolean isCurrentGuild, Companion.GuildStickerGuildInfo guildStickerGuildInfo) {
                C12238m.checkNotNullParameter(sticker, "sticker");
                C12238m.checkNotNullParameter(guildStickerGuildInfo, "guildStickerGuildInfo");
                return new Loaded(sticker, isUserPremium, isCurrentGuild, guildStickerGuildInfo);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return C12238m.areEqual(this.sticker, loaded.sticker) && this.isUserPremium == loaded.isUserPremium && this.isCurrentGuild == loaded.isCurrentGuild && C12238m.areEqual(this.guildStickerGuildInfo, loaded.guildStickerGuildInfo);
            }

            public final Companion.GuildStickerGuildInfo getGuildStickerGuildInfo() {
                return this.guildStickerGuildInfo;
            }

            public final Sticker getSticker() {
                return this.sticker;
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
                Sticker sticker = this.sticker;
                int iHashCode = (sticker != null ? sticker.hashCode() : 0) * 31;
                boolean z2 = this.isUserPremium;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                boolean z3 = this.isCurrentGuild;
                int i2 = (i + (z3 ? 1 : z3)) * 31;
                Companion.GuildStickerGuildInfo guildStickerGuildInfo = this.guildStickerGuildInfo;
                return i2 + (guildStickerGuildInfo != null ? guildStickerGuildInfo.hashCode() : 0);
            }

            public final boolean isCurrentGuild() {
                return this.isCurrentGuild;
            }

            public final boolean isUserPremium() {
                return this.isUserPremium;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(sticker=");
                sbM833U.append(this.sticker);
                sbM833U.append(", isUserPremium=");
                sbM833U.append(this.isUserPremium);
                sbM833U.append(", isCurrentGuild=");
                sbM833U.append(this.isCurrentGuild);
                sbM833U.append(", guildStickerGuildInfo=");
                sbM833U.append(this.guildStickerGuildInfo);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
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

    /* JADX INFO: renamed from: com.discord.widgets.stickers.GuildStickerSheetViewModel$joinGuild$1 */
    /* JADX INFO: compiled from: GuildStickerSheetViewModel.kt */
    public static final class C101261 extends AbstractC12240o implements Function1<com.discord.api.guild.Guild, Unit> {
        public C101261() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(com.discord.api.guild.Guild guild) {
            invoke2(guild);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(com.discord.api.guild.Guild guild) {
            C12238m.checkNotNullParameter(guild, "it");
            GuildStickerSheetViewModel.this.updateViewState(ViewState.Dismiss.INSTANCE);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI;
        StoreUser users = (i & 4) != 0 ? StoreStream.INSTANCE.getUsers() : storeUser;
        StoreChannelsSelected channelsSelected = (i & 8) != 0 ? StoreStream.INSTANCE.getChannelsSelected() : storeChannelsSelected;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.INSTANCE.getGuilds() : storeGuilds;
        this(sticker, api, users, channelsSelected, guilds, (i & 32) != 0 ? INSTANCE.observeStoreState(api, sticker, users, channelsSelected, guilds) : observable);
    }

    @MainThread
    private final void handleStoreState(StoreState storeState) {
        updateViewState(new ViewState.Loaded(this.sticker, UserUtils.INSTANCE.getCanUsePremiumStickers(storeState.getMeUser()), C12238m.areEqual(storeState.getCurrentGuildId(), this.sticker.getGuildId()), storeState.getGuildStickerGuildInfo()));
    }

    public final void joinGuild(Guild guild, Fragment fragment) {
        C12238m.checkNotNullParameter(guild, "guild");
        C12238m.checkNotNullParameter(fragment, "fragment");
        Context contextRequireContext = fragment.requireContext();
        C12238m.checkNotNullExpressionValue(contextRequireContext, "fragment.requireContext()");
        GuildJoinHelperKt.joinGuild(contextRequireContext, guild.getId(), false, (944 & 8) != 0 ? null : null, (944 & 16) != 0 ? null : null, (944 & 32) != 0 ? null : null, GuildStickerSheetViewModel.class, (944 & 128) != 0 ? null : null, (944 & 256) != 0 ? null : null, (944 & 512) != 0 ? null : null, new C101261());
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildStickerSheetViewModel(Sticker sticker, RestAPI restAPI, StoreUser storeUser, StoreChannelsSelected storeChannelsSelected, StoreGuilds storeGuilds, Observable<StoreState> observable) {
        super(ViewState.Loading.INSTANCE);
        C12238m.checkNotNullParameter(sticker, "sticker");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeChannelsSelected, "storeChannelsSelected");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        C12238m.checkNotNullParameter(observable, "storeStateObservable");
        this.sticker = sticker;
        this.restAPI = restAPI;
        this.storeUser = storeUser;
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) GuildStickerSheetViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C101191());
    }
}
