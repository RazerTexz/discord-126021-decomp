package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.member.GuildMember;
import com.discord.models.user.MeUser;
import com.discord.models.user.User;
import com.discord.stores.StoreSearch;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.p501rx.ObservableWithLeadingEdgeThrottle;
import com.discord.utilities.search.validation.SearchData;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function4;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func4;
import p658rx.subjects.BehaviorSubject;
import p658rx.subjects.Subject;

/* JADX INFO: compiled from: StoreSearchData.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreSearchData {
    private final ObservationDeck observationDeck;
    private final Subject<SearchData, SearchData> searchDataSubject;
    private final StoreChannels storeChannels;
    private final StoreGuilds storeGuilds;
    private final StoreUser storeUser;
    private Subscription subscription;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            StoreSearch.SearchTarget.Type.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[StoreSearch.SearchTarget.Type.GUILD.ordinal()] = 1;
            iArr[StoreSearch.SearchTarget.Type.CHANNEL.ordinal()] = 2;
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchData$getChannelSearchData$1 */
    /* JADX INFO: compiled from: StoreSearchData.kt */
    public static final class C63831 extends AbstractC12240o implements Function0<SearchData> {
        public final /* synthetic */ long $channelId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C63831(long j) {
            super(0);
            this.$channelId = j;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final SearchData invoke() {
            Channel channel = StoreSearchData.this.storeChannels.getChannel(this.$channelId);
            MeUser meSnapshot = StoreSearchData.this.storeUser.getMeSnapshot();
            Map<Long, GuildMember> mapEmptyMap = StoreSearchData.this.storeGuilds.getMembers().get(channel != null ? Long.valueOf(channel.getGuildId()) : null);
            if (mapEmptyMap == null) {
                mapEmptyMap = C12136h0.emptyMap();
            }
            return new SearchData.Builder().buildForChannel(channel, meSnapshot, mapEmptyMap);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchData$getGuildSearchData$2 */
    /* JADX INFO: compiled from: StoreSearchData.kt */
    public static final /* synthetic */ class C63852 extends C12236k implements Function4<Map<Long, ? extends GuildMember>, Map<Long, ? extends User>, Map<Long, ? extends Channel>, Map<Long, ? extends Long>, SearchData> {
        public C63852(SearchData.Builder builder) {
            super(4, builder, SearchData.Builder.class, "buildForGuild", "buildForGuild(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)Lcom/discord/utilities/search/validation/SearchData;", 0);
        }

        @Override // kotlin.jvm.functions.Function4
        public /* bridge */ /* synthetic */ SearchData invoke(Map<Long, ? extends GuildMember> map, Map<Long, ? extends User> map2, Map<Long, ? extends Channel> map3, Map<Long, ? extends Long> map4) {
            return invoke2((Map<Long, GuildMember>) map, map2, (Map<Long, Channel>) map3, (Map<Long, Long>) map4);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final SearchData invoke2(Map<Long, GuildMember> map, Map<Long, ? extends User> map2, Map<Long, Channel> map3, Map<Long, Long> map4) {
            C12238m.checkNotNullParameter(map, "p1");
            C12238m.checkNotNullParameter(map2, "p2");
            C12238m.checkNotNullParameter(map3, "p3");
            C12238m.checkNotNullParameter(map4, "p4");
            return ((SearchData.Builder) this.receiver).buildForGuild(map, map2, map3, map4);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchData$init$1 */
    /* JADX INFO: compiled from: StoreSearchData.kt */
    public static final /* synthetic */ class C63861 extends C12236k implements Function1<Subscription, Unit> {
        public C63861(StoreSearchData storeSearchData) {
            super(1, storeSearchData, StoreSearchData.class, "handleSubscription", "handleSubscription(Lrx/Subscription;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Subscription subscription) {
            invoke2(subscription);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Subscription subscription) {
            ((StoreSearchData) this.receiver).handleSubscription(subscription);
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreSearchData$init$2 */
    /* JADX INFO: compiled from: StoreSearchData.kt */
    public static final /* synthetic */ class C63872 extends C12236k implements Function1<SearchData, Unit> {
        public C63872(StoreSearchData storeSearchData) {
            super(1, storeSearchData, StoreSearchData.class, "handleNewData", "handleNewData(Lcom/discord/utilities/search/validation/SearchData;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SearchData searchData) {
            invoke2(searchData);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SearchData searchData) {
            C12238m.checkNotNullParameter(searchData, "p1");
            ((StoreSearchData) this.receiver).handleNewData(searchData);
        }
    }

    public StoreSearchData(ObservationDeck observationDeck, StoreChannels storeChannels, StoreUser storeUser, StoreGuilds storeGuilds) {
        C12238m.checkNotNullParameter(observationDeck, "observationDeck");
        C12238m.checkNotNullParameter(storeChannels, "storeChannels");
        C12238m.checkNotNullParameter(storeUser, "storeUser");
        C12238m.checkNotNullParameter(storeGuilds, "storeGuilds");
        this.observationDeck = observationDeck;
        this.storeChannels = storeChannels;
        this.storeUser = storeUser;
        this.storeGuilds = storeGuilds;
        BehaviorSubject behaviorSubjectM11130l0 = BehaviorSubject.m11130l0(new SearchData(null, null, null, null, null, 31, null));
        C12238m.checkNotNullExpressionValue(behaviorSubjectM11130l0, "BehaviorSubject.create(SearchData())");
        this.searchDataSubject = behaviorSubjectM11130l0;
    }

    private final Observable<SearchData> getChannelSearchData(long channelId) {
        return ObservationDeck.connectRx$default(this.observationDeck, new ObservationDeck.UpdateSource[]{this.storeChannels, this.storeUser, this.storeGuilds}, false, null, null, new C63831(channelId), 14, null);
    }

    private final Observable<SearchData> getGuildSearchData(long guildId) {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        Observable<Map<Long, GuildMember>> observableObserveComputed = companion.getGuilds().observeComputed(guildId);
        Observable<Map<Long, User>> observableObserveAllUsers = companion.getUsers().observeAllUsers();
        Observable observableM11083G = StoreChannels.observeChannelsForGuild$default(companion.getChannels(), guildId, null, 2, null).m11083G(new InterfaceC12589b<Map<Long, ? extends Channel>, Map<Long, ? extends Channel>>() { // from class: com.discord.stores.StoreSearchData.getGuildSearchData.1
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> call(Map<Long, ? extends Channel> map) {
                return call2((Map<Long, Channel>) map);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Map<Long, Channel> call2(Map<Long, Channel> map) {
                C12238m.checkNotNullExpressionValue(map, "guildChannels");
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                for (Map.Entry<Long, Channel> entry : map.entrySet()) {
                    if (ChannelUtils.m7698v(entry.getValue())) {
                        linkedHashMap.put(entry.getKey(), entry.getValue());
                    }
                }
                return linkedHashMap;
            }
        });
        Observable<Map<Long, Long>> observableObserveChannelPermissionsForGuild = companion.getPermissions().observeChannelPermissionsForGuild(guildId);
        final C63852 c63852 = new C63852(new SearchData.Builder());
        Observable<SearchData> observableCombineLatest = ObservableWithLeadingEdgeThrottle.combineLatest(observableObserveComputed, observableObserveAllUsers, observableM11083G, observableObserveChannelPermissionsForGuild, new Func4() { // from class: com.discord.stores.StoreSearchData$sam$rx_functions_Func4$0
            @Override // p658rx.functions.Func4
            public final /* synthetic */ Object call(Object obj, Object obj2, Object obj3, Object obj4) {
                return c63852.invoke(obj, obj2, obj3, obj4);
            }
        }, 3L, TimeUnit.SECONDS);
        C12238m.checkNotNullExpressionValue(observableCombineLatest, "ObservableWithLeadingEdg…3, TimeUnit.SECONDS\n    )");
        return observableCombineLatest;
    }

    private final void handleNewData(SearchData searchData) {
        this.searchDataSubject.onNext(searchData);
    }

    private final synchronized void handleSubscription(Subscription subscription) {
        Subscription subscription2 = this.subscription;
        if (subscription2 != null) {
            subscription2.unsubscribe();
        }
        this.subscription = subscription;
    }

    public final void clear() {
        handleSubscription(null);
        handleNewData(new SearchData(null, null, null, null, null, 31, null));
    }

    public final Observable<SearchData> get() {
        return this.searchDataSubject;
    }

    public final void init(StoreSearch.SearchTarget searchTarget) {
        Observable<SearchData> guildSearchData;
        C12238m.checkNotNullParameter(searchTarget, "searchTarget");
        int iOrdinal = searchTarget.getType().ordinal();
        if (iOrdinal == 0) {
            guildSearchData = getGuildSearchData(searchTarget.getId());
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            guildSearchData = getChannelSearchData(searchTarget.getId());
        }
        Observable observableM11112r = ObservableExtensionsKt.computationBuffered(guildSearchData).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "searchDataObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(observableM11112r, (Class<?>) StoreSearchData.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : new C63861(this)), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C63872(this));
    }
}
