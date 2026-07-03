package com.discord.stores;

import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.premium.PriceTierType;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p512d0.C11226f;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12136h0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func2;

/* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildRoleSubscriptions extends StoreV2 {
    private final Dispatcher dispatcher;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrials;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierFreeTrial>> guildRoleSubscriptionFreeTrialsSnapshot;
    private final Map<Long, GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroups;
    private Map<Long, ? extends GuildRoleSubscriptionGroupState> guildRoleSubscriptionGroupsSnapshot;
    private final Map<Long, Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiers;
    private Map<Long, ? extends Map<Long, GuildRoleSubscriptionTierListing>> guildRoleSubscriptionTiersSnapshot;
    private PriceTierState priceTierState;
    private PriceTierState priceTierStateSnapshot;
    private final RestAPI restAPI;

    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static abstract class GuildRoleSubscriptionFreeTrialsState {

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Failed extends GuildRoleSubscriptionFreeTrialsState {
            private final String errorMessage;

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final /* data */ class Loaded extends GuildRoleSubscriptionFreeTrialsState {
            private final Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials;

            /* JADX WARN: Multi-variable type inference failed */
            public Loaded() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public /* synthetic */ Loaded(Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : map);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, Map map, int i, Object obj) {
                if ((i & 1) != 0) {
                    map = loaded.freeTrials;
                }
                return loaded.copy(map);
            }

            public final Map<Long, GuildRoleSubscriptionTierFreeTrial> component1() {
                return this.freeTrials;
            }

            public final Loaded copy(Map<Long, GuildRoleSubscriptionTierFreeTrial> freeTrials) {
                return new Loaded(freeTrials);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.freeTrials, ((Loaded) other).freeTrials);
                }
                return true;
            }

            public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getFreeTrials() {
                return this.freeTrials;
            }

            public int hashCode() {
                Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.freeTrials;
                if (map != null) {
                    return map.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m825M(C1643a.m833U("Loaded(freeTrials="), this.freeTrials, ")");
            }

            public Loaded(Map<Long, GuildRoleSubscriptionTierFreeTrial> map) {
                super(null);
                this.freeTrials = map;
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Loading extends GuildRoleSubscriptionFreeTrialsState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Uninitialized extends GuildRoleSubscriptionFreeTrialsState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private GuildRoleSubscriptionFreeTrialsState() {
        }

        public /* synthetic */ GuildRoleSubscriptionFreeTrialsState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static abstract class GuildRoleSubscriptionGroupState {

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Failed extends GuildRoleSubscriptionGroupState {
            private final String errorMessage;

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final /* data */ class Loaded extends GuildRoleSubscriptionGroupState {
            private final GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing;

            public Loaded(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                super(null);
                this.guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            }

            public static /* synthetic */ Loaded copy$default(Loaded loaded, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, int i, Object obj) {
                if ((i & 1) != 0) {
                    guildRoleSubscriptionGroupListing = loaded.guildRoleSubscriptionGroupListing;
                }
                return loaded.copy(guildRoleSubscriptionGroupListing);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public final Loaded copy(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                return new Loaded(guildRoleSubscriptionGroupListing);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.guildRoleSubscriptionGroupListing, ((Loaded) other).guildRoleSubscriptionGroupListing);
                }
                return true;
            }

            public final GuildRoleSubscriptionGroupListing getGuildRoleSubscriptionGroupListing() {
                return this.guildRoleSubscriptionGroupListing;
            }

            public int hashCode() {
                GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = this.guildRoleSubscriptionGroupListing;
                if (guildRoleSubscriptionGroupListing != null) {
                    return guildRoleSubscriptionGroupListing.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbM833U = C1643a.m833U("Loaded(guildRoleSubscriptionGroupListing=");
                sbM833U.append(this.guildRoleSubscriptionGroupListing);
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Loading extends GuildRoleSubscriptionGroupState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        private GuildRoleSubscriptionGroupState() {
        }

        public /* synthetic */ GuildRoleSubscriptionGroupState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static abstract class PriceTierState {

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Failed extends PriceTierState {
            private final String errorMessage;

            /* JADX WARN: Multi-variable type inference failed */
            public Failed() {
                this(null, 1, 0 == true ? 1 : 0);
            }

            public Failed(String str) {
                super(null);
                this.errorMessage = str;
            }

            public final String getErrorMessage() {
                return this.errorMessage;
            }

            public /* synthetic */ Failed(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this((i & 1) != 0 ? null : str);
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final /* data */ class Loaded extends PriceTierState {
            private final List<Integer> priceTiers;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Loaded(List<Integer> list) {
                super(null);
                C12238m.checkNotNullParameter(list, "priceTiers");
                this.priceTiers = list;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.priceTiers;
                }
                return loaded.copy(list);
            }

            public final List<Integer> component1() {
                return this.priceTiers;
            }

            public final Loaded copy(List<Integer> priceTiers) {
                C12238m.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && C12238m.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
                }
                return true;
            }

            public final List<Integer> getPriceTiers() {
                return this.priceTiers;
            }

            public int hashCode() {
                List<Integer> list = this.priceTiers;
                if (list != null) {
                    return list.hashCode();
                }
                return 0;
            }

            public String toString() {
                return C1643a.m824L(C1643a.m833U("Loaded(priceTiers="), this.priceTiers, ")");
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Loading extends PriceTierState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class Uninitialized extends PriceTierState {
            public static final Uninitialized INSTANCE = new Uninitialized();

            private Uninitialized() {
                super(null);
            }
        }

        private PriceTierState() {
        }

        public /* synthetic */ PriceTierState(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60441 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60441(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60452 extends AbstractC12240o implements Function1<Pair<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;
            public final /* synthetic */ List $guildRoleSubscriptionTrials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List list) {
                super(0);
                this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
                this.$guildRoleSubscriptionTrials = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60452 c60452 = C60452.this;
                StoreGuildRoleSubscriptions.this.handleGuildRoleSubscriptionGroupFetch(c60452.$guildId, this.$guildRoleSubscriptionGroupListing);
                C60452 c60453 = C60452.this;
                StoreGuildRoleSubscriptions.this.handleGuildRoleSubscriptionFreeTrialListFetch(c60453.$guildId, this.$guildRoleSubscriptionTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60452(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> pair) {
            invoke2((Pair<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>> pair) {
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(pair.component1(), pair.component2()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60463 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups;
                Long lValueOf = Long.valueOf(C60463.this.$guildId);
                Error.Response response = this.$error.getResponse();
                C12238m.checkNotNullExpressionValue(response, "error.response");
                map.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60463(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "error");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60491 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60491(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60502 extends AbstractC12240o implements Function1<Pair<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $guildRoleSubscriptionFreeTrials;
            public final /* synthetic */ List $guildRoleSubscriptionGroupListings;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list, List list2) {
                super(0);
                this.$guildRoleSubscriptionGroupListings = list;
                this.$guildRoleSubscriptionFreeTrials = list2;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                C60502 c60502 = C60502.this;
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                long j = c60502.$guildId;
                List list = this.$guildRoleSubscriptionGroupListings;
                C12238m.checkNotNullExpressionValue(list, "guildRoleSubscriptionGroupListings");
                storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupFetch(j, (GuildRoleSubscriptionGroupListing) C12163u.getOrNull(list, 0));
                C60502 c60503 = C60502.this;
                StoreGuildRoleSubscriptions.this.handleGuildRoleSubscriptionFreeTrialListFetch(c60503.$guildId, this.$guildRoleSubscriptionFreeTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60502(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> pair) {
            invoke2((Pair<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) pair);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Pair<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>> pair) {
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(pair.component1(), pair.component2()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60513 extends AbstractC12240o implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups;
                Long lValueOf = Long.valueOf(C60513.this.$guildId);
                Error.Response response = this.$it.getResponse();
                C12238m.checkNotNullExpressionValue(response, "it.response");
                map.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60513(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60541 extends AbstractC12240o implements Function0<Unit> {
        public C60541() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.priceTierState = PriceTierState.Loading.INSTANCE;
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60552 extends AbstractC12240o implements Function1<List<? extends Integer>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions.this.priceTierState = new PriceTierState.Loaded(this.$it);
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public C60552() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
            invoke2((List<Integer>) list);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Integer> list) {
            C12238m.checkNotNullParameter(list, "it");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60563 extends AbstractC12240o implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                Error.Response response = this.$it.getResponse();
                C12238m.checkNotNullExpressionValue(response, "it.response");
                storeGuildRoleSubscriptions.priceTierState = new PriceTierState.Failed(response.getMessage());
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public C60563() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            C12238m.checkNotNullParameter(error, "it");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60571 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $guildRoleSubscriptionFreeTrialList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60571(List list, long j) {
            super(0);
            this.$guildRoleSubscriptionFreeTrialList = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$guildRoleSubscriptionFreeTrialList;
            if (list == null) {
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionFreeTrials.remove(Long.valueOf(this.$guildId));
                StoreGuildRoleSubscriptions.this.markChanged();
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(Long.valueOf(((GuildRoleSubscriptionTierFreeTrial) obj).getId()), obj);
            }
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionFreeTrials.put(Long.valueOf(this.$guildId), C12136h0.toMutableMap(linkedHashMap));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60581 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60581(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j) {
            super(0);
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$guildRoleSubscriptionGroupListing == null) {
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.remove(Long.valueOf(this.$guildId));
            } else {
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(GuildRoleSubscriptionGroupListing.m7941a(this.$guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, null, false, Opcodes.ATHROW)));
                List<Long> listM7949i = this.$guildRoleSubscriptionGroupListing.m7949i();
                if (listM7949i == null || listM7949i.isEmpty()) {
                    StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.remove(Long.valueOf(this.$guildId));
                } else {
                    Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.get(Long.valueOf(this.$guildId));
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                    List<GuildRoleSubscriptionTierListing> listM7948h = this.$guildRoleSubscriptionGroupListing.m7948h();
                    if (listM7948h != null) {
                        for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : listM7948h) {
                            linkedHashMap.put(Long.valueOf(guildRoleSubscriptionTierListing.getId()), guildRoleSubscriptionTierListing);
                        }
                    }
                    StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.put(Long.valueOf(this.$guildId), linkedHashMap);
                }
            }
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupUpdate$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60591 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60591(long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingDelete$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60601 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionTierListingId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60601(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map map = (Map) StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.get(Long.valueOf(this.$guildId));
            if (map != null) {
                map.remove(Long.valueOf(this.$guildRoleSubscriptionTierListingId));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60611 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60611(long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.get(Long.valueOf(this.$guildId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionTierListing.getId()), this.$guildRoleSubscriptionTierListing);
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierTrialUpdate$1 */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class C60621 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionGroupListingId;
        public final /* synthetic */ GuildRoleSubscriptionTierFreeTrial $guildRoleSubscriptionTierFreeTrial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60621(long j, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierFreeTrial = guildRoleSubscriptionTierFreeTrial;
            this.$guildRoleSubscriptionGroupListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.this.guildRoleSubscriptionFreeTrials.get(Long.valueOf(this.$guildId));
            if (linkedHashMap == null) {
                linkedHashMap = new LinkedHashMap();
            }
            linkedHashMap.put(Long.valueOf(this.$guildRoleSubscriptionGroupListingId), this.$guildRoleSubscriptionTierFreeTrial);
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionFreeTrials.put(Long.valueOf(this.$guildId), linkedHashMap);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    public /* synthetic */ StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(dispatcher, (i & 2) != 0 ? RestAPI.INSTANCE.getApi() : restAPI);
    }

    private final void handleGuildRoleSubscriptionFreeTrialListFetch(long guildId, List<GuildRoleSubscriptionTierFreeTrial> guildRoleSubscriptionFreeTrialList) {
        this.dispatcher.schedule(new C60571(guildRoleSubscriptionFreeTrialList, guildId));
    }

    private final void handleGuildRoleSubscriptionGroupFetch(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        this.dispatcher.schedule(new C60581(guildRoleSubscriptionGroupListing, guildId));
    }

    public final void fetchGuildRoleSubscriptionGroup(long guildId, long guildRoleSubscriptionGroupId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new C60441(guildId));
        Observable observableM11077j0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.m11077j0(this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), new Func2<GuildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial>, Pair<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Pair<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial> list) {
                return call2(guildRoleSubscriptionGroupListing, (List<GuildRoleSubscriptionTierFreeTrial>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<GuildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial>> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial> list) {
                return new Pair<>(guildRoleSubscriptionGroupListing, list);
            }
        }) : this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId).m11083G(new InterfaceC12589b<GuildRoleSubscriptionGroupListing, Pair>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2
            @Override // p637j0.p641k.InterfaceC12589b
            public final Pair call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                return new Pair(guildRoleSubscriptionGroupListing, null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11077j0, "observable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observableM11077j0, false, 1, null), (Class<?>) StoreGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60463(guildId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60452(guildId));
    }

    public final void fetchGuildRoleSubscriptionGroupsForGuild(long guildId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new C60491(guildId));
        Observable observableM11077j0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.m11077j0(this.restAPI.getGuildRoleSubscriptionGroupListings(guildId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), new Func2<List<? extends GuildRoleSubscriptionGroupListing>, List<? extends GuildRoleSubscriptionTierFreeTrial>, Pair<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1
            @Override // p658rx.functions.Func2
            public /* bridge */ /* synthetic */ Pair<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(List<? extends GuildRoleSubscriptionGroupListing> list, List<? extends GuildRoleSubscriptionTierFreeTrial> list2) {
                return call2((List<GuildRoleSubscriptionGroupListing>) list, (List<GuildRoleSubscriptionTierFreeTrial>) list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair<List<GuildRoleSubscriptionGroupListing>, List<GuildRoleSubscriptionTierFreeTrial>> call2(List<GuildRoleSubscriptionGroupListing> list, List<GuildRoleSubscriptionTierFreeTrial> list2) {
                return new Pair<>(list, list2);
            }
        }) : this.restAPI.getGuildRoleSubscriptionGroupListings(guildId).m11083G(new InterfaceC12589b<List<? extends GuildRoleSubscriptionGroupListing>, Pair>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2
            @Override // p637j0.p641k.InterfaceC12589b
            public /* bridge */ /* synthetic */ Pair call(List<? extends GuildRoleSubscriptionGroupListing> list) {
                return call2((List<GuildRoleSubscriptionGroupListing>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Pair call2(List<GuildRoleSubscriptionGroupListing> list) {
                return new Pair(list, null);
            }
        });
        C12238m.checkNotNullExpressionValue(observableM11077j0, "observable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observableM11077j0, false, 1, null), (Class<?>) StoreGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60513(guildId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60502(guildId));
    }

    public final void fetchPriceTiersIfNonExisting() {
        PriceTierState priceTierState = this.priceTierState;
        if ((priceTierState instanceof PriceTierState.Loading) || (priceTierState instanceof PriceTierState.Loaded)) {
            return;
        }
        this.dispatcher.schedule(new C60541());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPriceTiers(PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.getApiValue()), false, 1, null), (Class<?>) StoreGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new C60563()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C60552());
    }

    public final List<Integer> getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions() {
        return C12147n.listOf((Object[]) new Integer[]{null, 10, 25, 50, 100});
    }

    public final GuildRoleSubscriptionTierFreeTrial getGuildRoleSubscriptionFreeTrialForListing(long guildId, long listingId) {
        Map<Long, GuildRoleSubscriptionTierFreeTrial> map = this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
        if (map != null) {
            return map.get(Long.valueOf(listingId));
        }
        return null;
    }

    public final List<SubscriptionTrialInterval> getGuildRoleSubscriptionFreeTrialIntervalOptions() {
        GuildRoleSubscriptionFreeTrialIntervalTypes guildRoleSubscriptionFreeTrialIntervalTypes = GuildRoleSubscriptionFreeTrialIntervalTypes.DAILY;
        return C12147n.listOf((Object[]) new SubscriptionTrialInterval[]{new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 1), new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 7)});
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getGuildRoleSubscriptionFreeTrials(long guildId) {
        return this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
    }

    public final GuildRoleSubscriptionGroupState getGuildRoleSubscriptionState(long guildId) {
        List listEmptyList;
        List<Long> listM7949i;
        GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId));
        if (guildRoleSubscriptionGroupState == null) {
            return null;
        }
        if (!(guildRoleSubscriptionGroupState instanceof GuildRoleSubscriptionGroupState.Loaded)) {
            return guildRoleSubscriptionGroupState;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionGroupState).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listM7949i = guildRoleSubscriptionGroupListing.m7949i()) == null) {
            listEmptyList = C12147n.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listM7949i.iterator();
            while (it.hasNext()) {
                long jLongValue = ((Number) it.next()).longValue();
                Map<Long, GuildRoleSubscriptionTierListing> map = this.guildRoleSubscriptionTiersSnapshot.get(Long.valueOf(guildId));
                GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing = map != null ? map.get(Long.valueOf(jLongValue)) : null;
                if (guildRoleSubscriptionTierListing != null) {
                    arrayList.add(guildRoleSubscriptionTierListing);
                }
            }
            listEmptyList = arrayList;
        }
        return new GuildRoleSubscriptionGroupState.Loaded(guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionGroupListing.m7941a(guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, listEmptyList, false, Opcodes.ATHROW) : null);
    }

    /* JADX INFO: renamed from: getPriceTiersState, reason: from getter */
    public final PriceTierState getPriceTierStateSnapshot() {
        return this.priceTierStateSnapshot;
    }

    public final void handleGuildRoleSubscriptionGroupUpdate(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        C12238m.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        this.dispatcher.schedule(new C60591(guildId, guildRoleSubscriptionGroupListing));
    }

    public final void handleGuildRoleSubscriptionTierListingCreate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        C12238m.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        handleGuildRoleSubscriptionTierListingUpdate(guildId, guildRoleSubscriptionTierListing);
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingDelete(long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
        this.dispatcher.schedule(new C60601(guildId, guildRoleSubscriptionTierListingId));
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingUpdate(long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        C12238m.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        this.dispatcher.schedule(new C60611(guildId, guildRoleSubscriptionTierListing));
    }

    public final void handleGuildRoleSubscriptionTierTrialUpdate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        C12238m.checkNotNullParameter(guildRoleSubscriptionTierFreeTrial, "guildRoleSubscriptionTierFreeTrial");
        this.dispatcher.schedule(new C60621(guildId, guildRoleSubscriptionTierFreeTrial, guildRoleSubscriptionGroupListingId));
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        this.priceTierStateSnapshot = this.priceTierState;
        this.guildRoleSubscriptionGroupsSnapshot = new HashMap(this.guildRoleSubscriptionGroups);
        this.guildRoleSubscriptionTiersSnapshot = new HashMap(this.guildRoleSubscriptionTiers);
        this.guildRoleSubscriptionFreeTrialsSnapshot = new HashMap(this.guildRoleSubscriptionFreeTrials);
    }

    public StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI) {
        C12238m.checkNotNullParameter(dispatcher, "dispatcher");
        C12238m.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        PriceTierState.Uninitialized uninitialized = PriceTierState.Uninitialized.INSTANCE;
        this.priceTierState = uninitialized;
        this.priceTierStateSnapshot = uninitialized;
        this.guildRoleSubscriptionGroups = new LinkedHashMap();
        this.guildRoleSubscriptionGroupsSnapshot = C12136h0.emptyMap();
        this.guildRoleSubscriptionTiers = new LinkedHashMap();
        this.guildRoleSubscriptionTiersSnapshot = C12136h0.emptyMap();
        this.guildRoleSubscriptionFreeTrials = new LinkedHashMap();
        this.guildRoleSubscriptionFreeTrialsSnapshot = C12136h0.emptyMap();
    }
}
