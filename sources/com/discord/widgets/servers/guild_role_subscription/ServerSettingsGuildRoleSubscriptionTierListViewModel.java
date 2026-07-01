package com.discord.widgets.servers.guild_role_subscription;

import a0.a.a.b;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.api.guildrolesubscription.GuildRoleSubscriptionGroupListing;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsGuildRoleSubscriptionTierListViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int MAX_TIER_ITEMS = 3;
    private final long guildId;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* JADX INFO: renamed from: com.discord.widgets.servers.guild_role_subscription.ServerSettingsGuildRoleSubscriptionTierListViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
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
            ServerSettingsGuildRoleSubscriptionTierListViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeGuildRoleSubscriptions}, false, null, null, new ServerSettingsGuildRoleSubscriptionTierListViewModel2(storeGuildRoleSubscriptions, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    public static final /* data */ class StoreState {
        private final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState;

        public StoreState(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState) {
            this.guildRoleSubscriptionGroupState = guildRoleSubscriptionGroupState;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState, int i, Object obj) {
            if ((i & 1) != 0) {
                guildRoleSubscriptionGroupState = storeState.guildRoleSubscriptionGroupState;
            }
            return storeState.copy(guildRoleSubscriptionGroupState);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        public final StoreState copy(StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState) {
            return new StoreState(guildRoleSubscriptionGroupState);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && Intrinsics3.areEqual(this.guildRoleSubscriptionGroupState, ((StoreState) other).guildRoleSubscriptionGroupState);
            }
            return true;
        }

        public final StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState getGuildRoleSubscriptionGroupState() {
            return this.guildRoleSubscriptionGroupState;
        }

        public int hashCode() {
            StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = this.guildRoleSubscriptionGroupState;
            if (guildRoleSubscriptionGroupState != null) {
                return guildRoleSubscriptionGroupState.hashCode();
            }
            return 0;
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(guildRoleSubscriptionGroupState=");
            sbU.append(this.guildRoleSubscriptionGroupState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
    public static abstract class ViewState {

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
        public static final class Failed extends ViewState {
            public static final Failed INSTANCE = new Failed();

            private Failed() {
                super(null);
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
        public static final /* data */ class Loaded extends ViewState {
            private final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> adapterItems;
            private final long groupListingId;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public Loaded(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> list, long j) {
                super(null);
                Intrinsics3.checkNotNullParameter(list, "adapterItems");
                this.adapterItems = list;
                this.groupListingId = j;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ Loaded copy$default(Loaded loaded, List list, long j, int i, Object obj) {
                if ((i & 1) != 0) {
                    list = loaded.adapterItems;
                }
                if ((i & 2) != 0) {
                    j = loaded.groupListingId;
                }
                return loaded.copy(list, j);
            }

            public final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> component1() {
                return this.adapterItems;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public final Loaded copy(List<? extends ServerSettingsGuildRoleSubscriptionTierAdapter2> adapterItems, long groupListingId) {
                Intrinsics3.checkNotNullParameter(adapterItems, "adapterItems");
                return new Loaded(adapterItems, groupListingId);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Loaded)) {
                    return false;
                }
                Loaded loaded = (Loaded) other;
                return Intrinsics3.areEqual(this.adapterItems, loaded.adapterItems) && this.groupListingId == loaded.groupListingId;
            }

            public final List<ServerSettingsGuildRoleSubscriptionTierAdapter2> getAdapterItems() {
                return this.adapterItems;
            }

            public final long getGroupListingId() {
                return this.groupListingId;
            }

            public int hashCode() {
                List<ServerSettingsGuildRoleSubscriptionTierAdapter2> list = this.adapterItems;
                return b.a(this.groupListingId) + ((list != null ? list.hashCode() : 0) * 31);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Loaded(adapterItems=");
                sbU.append(this.adapterItems);
                sbU.append(", groupListingId=");
                return outline.C(sbU, this.groupListingId, ")");
            }
        }

        /* JADX INFO: compiled from: ServerSettingsGuildRoleSubscriptionTierListViewModel.kt */
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

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsGuildRoleSubscriptionTierListViewModel(long j, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 2) != 0 ? StoreStream.INSTANCE.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, guildRoleSubscriptions, observationDeck2, (i & 8) != 0 ? INSTANCE.observeStoreState(j, observationDeck2, guildRoleSubscriptions) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState guildRoleSubscriptionGroupState = storeState.getGuildRoleSubscriptionGroupState();
        if ((guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loading) || guildRoleSubscriptionGroupState == null) {
            updateViewState(ViewState.Loading.INSTANCE);
            return;
        }
        if (!(guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded)) {
            if (guildRoleSubscriptionGroupState instanceof StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Failed) {
                updateViewState(ViewState.Failed.INSTANCE);
            }
        } else {
            GuildRoleSubscriptionGroupListing guildRoleSubscriptionGroupListing = ((StoreGuildRoleSubscriptions.GuildRoleSubscriptionGroupState.Loaded) storeState.getGuildRoleSubscriptionGroupState()).getGuildRoleSubscriptionGroupListing();
            if (guildRoleSubscriptionGroupListing == null) {
                updateViewState(ViewState.Failed.INSTANCE);
            } else {
                updateViewState(new ViewState.Loaded(ServerSettingsGuildRoleSubscriptionTierListItemGenerator.generateServerSettingsGuildRoleSubscriptionTierListItems(guildRoleSubscriptionGroupListing.h(), 3), guildRoleSubscriptionGroupListing.getId()));
            }
        }
    }

    private static final Observable<StoreState> observeStoreState(long j, ObservationDeck observationDeck, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions) {
        return INSTANCE.observeStoreState(j, observationDeck, storeGuildRoleSubscriptions);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsGuildRoleSubscriptionTierListViewModel(long j, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        this.guildId = j;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        storeGuildRoleSubscriptions.fetchGuildRoleSubscriptionGroupsForGuild(j);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observable), this, null, 2, null), (Class<?>) ServerSettingsGuildRoleSubscriptionTierListViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
