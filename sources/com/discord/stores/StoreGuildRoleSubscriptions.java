package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionFreeTrialIntervalTypes;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierFreeTrial;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionTierListing;
import com.discord.api.guildrolesubscription.SubscriptionTrialInterval;
import com.discord.api.premium.PriceTierType;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionsFeatureFlag;
import d0.d0._Ranges;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t.Maps6;
import d0.t.MapsJVM;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Tuples2;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func2;

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
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.freeTrials, ((Loaded) other).freeTrials);
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
                return outline.M(outline.U("Loaded(freeTrials="), this.freeTrials, ")");
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
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupListing, ((Loaded) other).guildRoleSubscriptionGroupListing);
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
                StringBuilder sbU = outline.U("Loaded(guildRoleSubscriptionGroupListing=");
                sbU.append(this.guildRoleSubscriptionGroupListing);
                sbU.append(")");
                return sbU.toString();
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
                Intrinsics3.checkNotNullParameter(list, "priceTiers");
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
                Intrinsics3.checkNotNullParameter(priceTiers, "priceTiers");
                return new Loaded(priceTiers);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Loaded) && Intrinsics3.areEqual(this.priceTiers, ((Loaded) other).priceTiers);
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
                return outline.L(outline.U("Loaded(priceTiers="), this.priceTiers, ")");
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions.this.handleGuildRoleSubscriptionGroupFetch(anonymousClass2.$guildId, this.$guildRoleSubscriptionGroupListing);
                AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions.this.handleGuildRoleSubscriptionFreeTrialListFetch(anonymousClass3.$guildId, this.$guildRoleSubscriptionTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            invoke2((Tuples2<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<GuildRoleSubscriptionGroupListing, ? extends List<GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $error;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$error = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups;
                Long lValueOf = Long.valueOf(AnonymousClass3.this.$guildId);
                Error.Response response = this.$error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "error.response");
                map.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "error");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), GuildRoleSubscriptionGroupState.Loading.INSTANCE);
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
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
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                long j = anonymousClass2.$guildId;
                List list = this.$guildRoleSubscriptionGroupListings;
                Intrinsics3.checkNotNullExpressionValue(list, "guildRoleSubscriptionGroupListings");
                storeGuildRoleSubscriptions.handleGuildRoleSubscriptionGroupFetch(j, (GuildRoleSubscriptionGroupListing) _Collections.getOrNull(list, 0));
                AnonymousClass2 anonymousClass3 = AnonymousClass2.this;
                StoreGuildRoleSubscriptions.this.handleGuildRoleSubscriptionFreeTrialListFetch(anonymousClass3.$guildId, this.$guildRoleSubscriptionFreeTrials);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            invoke2((Tuples2<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>>) tuples2);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Tuples2<? extends List<GuildRoleSubscriptionGroupListing>, ? extends List<GuildRoleSubscriptionTierFreeTrial>> tuples2) {
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(tuples2.component1(), tuples2.component2()));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {
        public final /* synthetic */ long $guildId;

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Map map = StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups;
                Long lValueOf = Long.valueOf(AnonymousClass3.this.$guildId);
                Error.Response response = this.$it.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                map.put(lValueOf, new GuildRoleSubscriptionGroupState.Failed(response.getMessage()));
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.priceTierState = PriceTierState.Loading.INSTANCE;
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<List<? extends Integer>, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ List $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(List list) {
                super(0);
                this.$it = list;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions.this.priceTierState = new PriceTierState.Loaded(this.$it);
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(List<? extends Integer> list) {
            invoke2((List<Integer>) list);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(List<Integer> list) {
            Intrinsics3.checkNotNullParameter(list, "it");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(list));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<Error, Unit> {

        /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$fetchPriceTiersIfNonExisting$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ Error $it;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Error error) {
                super(0);
                this.$it = error;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                StoreGuildRoleSubscriptions storeGuildRoleSubscriptions = StoreGuildRoleSubscriptions.this;
                Error.Response response = this.$it.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                storeGuildRoleSubscriptions.priceTierState = new PriceTierState.Failed(response.getMessage());
                StoreGuildRoleSubscriptions.this.markChanged();
            }
        }

        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Error error) {
            invoke2(error);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Error error) {
            Intrinsics3.checkNotNullParameter(error, "it");
            StoreGuildRoleSubscriptions.this.dispatcher.schedule(new AnonymousClass1(error));
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionFreeTrialListFetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ List $guildRoleSubscriptionFreeTrialList;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(List list, long j) {
            super(0);
            this.$guildRoleSubscriptionFreeTrialList = list;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            List list = this.$guildRoleSubscriptionFreeTrialList;
            if (list == null) {
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionFreeTrials.remove(Long.valueOf(this.$guildId));
                StoreGuildRoleSubscriptions.this.markChanged();
                return;
            }
            LinkedHashMap linkedHashMap = new LinkedHashMap(_Ranges.coerceAtLeast(MapsJVM.mapCapacity(Iterables2.collectionSizeOrDefault(list, 10)), 16));
            for (Object obj : list) {
                linkedHashMap.put(Long.valueOf(((GuildRoleSubscriptionTierFreeTrial) obj).getId()), obj);
            }
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionFreeTrials.put(Long.valueOf(this.$guildId), Maps6.toMutableMap(linkedHashMap));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupFetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, long j) {
            super(0);
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            if (this.$guildRoleSubscriptionGroupListing == null) {
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.remove(Long.valueOf(this.$guildId));
            } else {
                StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(GuildRoleSubscriptionGroupListing.a(this.$guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, null, false, Opcodes.ATHROW)));
                List<Long> listI = this.$guildRoleSubscriptionGroupListing.i();
                if (listI == null || listI.isEmpty()) {
                    StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.remove(Long.valueOf(this.$guildId));
                } else {
                    Map linkedHashMap = (Map) StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.get(Long.valueOf(this.$guildId));
                    if (linkedHashMap == null) {
                        linkedHashMap = new LinkedHashMap();
                    }
                    List<GuildRoleSubscriptionTierListing> listH = this.$guildRoleSubscriptionGroupListing.h();
                    if (listH != null) {
                        for (GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing : listH) {
                            linkedHashMap.put(Long.valueOf(guildRoleSubscriptionTierListing.getId()), guildRoleSubscriptionTierListing);
                        }
                    }
                    StoreGuildRoleSubscriptions.this.guildRoleSubscriptionTiers.put(Long.valueOf(this.$guildId), linkedHashMap);
                }
            }
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionGroupUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionGroupListing $guildRoleSubscriptionGroupListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionGroupListing = guildRoleSubscriptionGroupListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            StoreGuildRoleSubscriptions.this.guildRoleSubscriptionGroups.put(Long.valueOf(this.$guildId), new GuildRoleSubscriptionGroupState.Loaded(this.$guildRoleSubscriptionGroupListing));
            StoreGuildRoleSubscriptions.this.markChanged();
        }
    }

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingDelete$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionTierListingId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierListingUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ GuildRoleSubscriptionTierListing $guildRoleSubscriptionTierListing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierListing = guildRoleSubscriptionTierListing;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildRoleSubscriptions$handleGuildRoleSubscriptionTierTrialUpdate$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildRoleSubscriptions.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ long $guildId;
        public final /* synthetic */ long $guildRoleSubscriptionGroupListingId;
        public final /* synthetic */ GuildRoleSubscriptionTierFreeTrial $guildRoleSubscriptionTierFreeTrial;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial, long j2) {
            super(0);
            this.$guildId = j;
            this.$guildRoleSubscriptionTierFreeTrial = guildRoleSubscriptionTierFreeTrial;
            this.$guildRoleSubscriptionGroupListingId = j2;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
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
        this.dispatcher.schedule(new AnonymousClass1(guildRoleSubscriptionFreeTrialList, guildId));
    }

    private final void handleGuildRoleSubscriptionGroupFetch(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        this.dispatcher.schedule(new AnonymousClass1(guildRoleSubscriptionGroupListing, guildId));
    }

    public final void fetchGuildRoleSubscriptionGroup(long guildId, long guildRoleSubscriptionGroupId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
        Observable observableJ0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.j0(this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), new Func2<GuildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial>, Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Tuples2<? extends GuildRoleSubscriptionGroupListing, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<? extends GuildRoleSubscriptionTierFreeTrial> list) {
                return call2(guildRoleSubscriptionGroupListing, (List<GuildRoleSubscriptionTierFreeTrial>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<GuildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial>> call2(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing, List<GuildRoleSubscriptionTierFreeTrial> list) {
                return new Tuples2<>(guildRoleSubscriptionGroupListing, list);
            }
        }) : this.restAPI.getGuildRoleSubscriptionGroupListing(guildId, guildRoleSubscriptionGroupId).G(new Func1<GuildRoleSubscriptionGroupListing, Tuples2>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroup$observable$2
            @Override // j0.k.Func1
            public final Tuples2 call(GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
                return new Tuples2(guildRoleSubscriptionGroupListing, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ0, "observable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observableJ0, false, 1, null), (Class<?>) StoreGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(guildId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(guildId));
    }

    public final void fetchGuildRoleSubscriptionGroupsForGuild(long guildId) {
        if (this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId)) instanceof GuildRoleSubscriptionGroupState.Loading) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1(guildId));
        Observable observableJ0 = GuildRoleSubscriptionsFeatureFlag.INSTANCE.getINSTANCE().isGuildEligibleForGuildRoleSubscriptionTrials(guildId) ? Observable.j0(this.restAPI.getGuildRoleSubscriptionGroupListings(guildId), this.restAPI.getGuildRoleSubscriptionFreeTrials(guildId), new Func2<List<? extends GuildRoleSubscriptionGroupListing>, List<? extends GuildRoleSubscriptionTierFreeTrial>, Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>>>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$1
            @Override // rx.functions.Func2
            public /* bridge */ /* synthetic */ Tuples2<? extends List<? extends GuildRoleSubscriptionGroupListing>, ? extends List<? extends GuildRoleSubscriptionTierFreeTrial>> call(List<? extends GuildRoleSubscriptionGroupListing> list, List<? extends GuildRoleSubscriptionTierFreeTrial> list2) {
                return call2((List<GuildRoleSubscriptionGroupListing>) list, (List<GuildRoleSubscriptionTierFreeTrial>) list2);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2<List<GuildRoleSubscriptionGroupListing>, List<GuildRoleSubscriptionTierFreeTrial>> call2(List<GuildRoleSubscriptionGroupListing> list, List<GuildRoleSubscriptionTierFreeTrial> list2) {
                return new Tuples2<>(list, list2);
            }
        }) : this.restAPI.getGuildRoleSubscriptionGroupListings(guildId).G(new Func1<List<? extends GuildRoleSubscriptionGroupListing>, Tuples2>() { // from class: com.discord.stores.StoreGuildRoleSubscriptions$fetchGuildRoleSubscriptionGroupsForGuild$observable$2
            @Override // j0.k.Func1
            public /* bridge */ /* synthetic */ Tuples2 call(List<? extends GuildRoleSubscriptionGroupListing> list) {
                return call2((List<GuildRoleSubscriptionGroupListing>) list);
            }

            /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
            public final Tuples2 call2(List<GuildRoleSubscriptionGroupListing> list) {
                return new Tuples2(list, null);
            }
        });
        Intrinsics3.checkNotNullExpressionValue(observableJ0, "observable");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(observableJ0, false, 1, null), (Class<?>) StoreGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3(guildId)), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(guildId));
    }

    public final void fetchPriceTiersIfNonExisting() {
        PriceTierState priceTierState = this.priceTierState;
        if ((priceTierState instanceof PriceTierState.Loading) || (priceTierState instanceof PriceTierState.Loaded)) {
            return;
        }
        this.dispatcher.schedule(new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(this.restAPI.getPriceTiers(PriceTierType.GUILD_ROLE_SUBSCRIPTIONS.getApiValue()), false, 1, null), (Class<?>) StoreGuildRoleSubscriptions.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass3()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    public final List<Integer> getGuildRoleSubscriptionFreeTrialActiveUserLimitOptions() {
        return Collections2.listOf((Object[]) new Integer[]{null, 10, 25, 50, 100});
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
        return Collections2.listOf((Object[]) new SubscriptionTrialInterval[]{new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 1), new SubscriptionTrialInterval(guildRoleSubscriptionFreeTrialIntervalTypes, 7)});
    }

    public final Map<Long, GuildRoleSubscriptionTierFreeTrial> getGuildRoleSubscriptionFreeTrials(long guildId) {
        return this.guildRoleSubscriptionFreeTrialsSnapshot.get(Long.valueOf(guildId));
    }

    public final GuildRoleSubscriptionGroupState getGuildRoleSubscriptionState(long guildId) {
        List listEmptyList;
        List<Long> listI;
        GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupsSnapshot.get(Long.valueOf(guildId));
        if (guildRoleSubscriptionGroupState == null) {
            return null;
        }
        if (!(guildRoleSubscriptionGroupState instanceof GuildRoleSubscriptionGroupState.Loaded)) {
            return guildRoleSubscriptionGroupState;
        }
        GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((GuildRoleSubscriptionGroupState.Loaded) guildRoleSubscriptionGroupState).getGuildRoleSubscriptionGroupListing();
        if (guildRoleSubscriptionGroupListing == null || (listI = guildRoleSubscriptionGroupListing.i()) == null) {
            listEmptyList = Collections2.emptyList();
        } else {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = listI.iterator();
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
        return new GuildRoleSubscriptionGroupState.Loaded(guildRoleSubscriptionGroupListing != null ? GuildRoleSubscriptionGroupListing.a(guildRoleSubscriptionGroupListing, 0L, 0L, 0L, null, null, null, listEmptyList, false, Opcodes.ATHROW) : null);
    }

    /* JADX INFO: renamed from: getPriceTiersState, reason: from getter */
    public final PriceTierState getPriceTierStateSnapshot() {
        return this.priceTierStateSnapshot;
    }

    public final void handleGuildRoleSubscriptionGroupUpdate(long guildId, GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionGroupListing, "guildRoleSubscriptionGroupListing");
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionGroupListing));
    }

    public final void handleGuildRoleSubscriptionTierListingCreate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        handleGuildRoleSubscriptionTierListingUpdate(guildId, guildRoleSubscriptionTierListing);
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingDelete(long guildId, long guildRoleSubscriptionGroupListingId, long guildRoleSubscriptionTierListingId) {
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionTierListingId));
        fetchGuildRoleSubscriptionGroup(guildId, guildRoleSubscriptionGroupListingId);
    }

    public final void handleGuildRoleSubscriptionTierListingUpdate(long guildId, GuildRoleSubscriptionTierListing guildRoleSubscriptionTierListing) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierListing, "guildRoleSubscriptionTierListing");
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionTierListing));
    }

    public final void handleGuildRoleSubscriptionTierTrialUpdate(long guildId, long guildRoleSubscriptionGroupListingId, GuildRoleSubscriptionTierFreeTrial guildRoleSubscriptionTierFreeTrial) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTierFreeTrial, "guildRoleSubscriptionTierFreeTrial");
        this.dispatcher.schedule(new AnonymousClass1(guildId, guildRoleSubscriptionTierFreeTrial, guildRoleSubscriptionGroupListingId));
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        this.priceTierStateSnapshot = this.priceTierState;
        this.guildRoleSubscriptionGroupsSnapshot = new HashMap(this.guildRoleSubscriptionGroups);
        this.guildRoleSubscriptionTiersSnapshot = new HashMap(this.guildRoleSubscriptionTiers);
        this.guildRoleSubscriptionFreeTrialsSnapshot = new HashMap(this.guildRoleSubscriptionFreeTrials);
    }

    public StoreGuildRoleSubscriptions(Dispatcher dispatcher, RestAPI restAPI) {
        Intrinsics3.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics3.checkNotNullParameter(restAPI, "restAPI");
        this.dispatcher = dispatcher;
        this.restAPI = restAPI;
        PriceTierState.Uninitialized uninitialized = PriceTierState.Uninitialized.INSTANCE;
        this.priceTierState = uninitialized;
        this.priceTierStateSnapshot = uninitialized;
        this.guildRoleSubscriptionGroups = new LinkedHashMap();
        this.guildRoleSubscriptionGroupsSnapshot = Maps6.emptyMap();
        this.guildRoleSubscriptionTiers = new LinkedHashMap();
        this.guildRoleSubscriptionTiersSnapshot = Maps6.emptyMap();
        this.guildRoleSubscriptionFreeTrials = new LinkedHashMap();
        this.guildRoleSubscriptionFreeTrialsSnapshot = Maps6.emptyMap();
    }
}
