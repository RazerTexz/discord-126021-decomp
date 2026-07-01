package com.discord.widgets.guild_role_subscriptions.tier.create;

import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.stores.StoreChannels;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapterItem;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierListItemGenerator;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildRoleSubscriptionReviewViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private Integer guildChannelCount;
    private GuildRoleSubscriptionTier guildRoleSubscriptionTier;
    private Boolean isFullServerGating;
    private String planCoverImage;
    private String planDescription;

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
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
            GuildRoleSubscriptionReviewViewModel guildRoleSubscriptionReviewViewModel = GuildRoleSubscriptionReviewViewModel.this;
            Intrinsics3.checkNotNullExpressionValue(storeState, "storeState");
            guildRoleSubscriptionReviewViewModel.handleStoreState(storeState);
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(long guildId, ObservationDeck observationDeck, StoreChannels storeChannels) {
            return ObservationDeck.connectRx$default(observationDeck, new ObservationDeck.UpdateSource[]{storeChannels}, false, null, null, new GuildRoleSubscriptionReviewViewModel2(storeChannels, guildId), 14, null);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
    public static final /* data */ class StoreState {
        private final int guildChannelCount;

        public StoreState(int i) {
            this.guildChannelCount = i;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, int i, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                i = storeState.guildChannelCount;
            }
            return storeState.copy(i);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final int getGuildChannelCount() {
            return this.guildChannelCount;
        }

        public final StoreState copy(int guildChannelCount) {
            return new StoreState(guildChannelCount);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof StoreState) && this.guildChannelCount == ((StoreState) other).guildChannelCount;
            }
            return true;
        }

        public final int getGuildChannelCount() {
            return this.guildChannelCount;
        }

        public int hashCode() {
            return this.guildChannelCount;
        }

        public String toString() {
            return outline.B(outline.U("StoreState(guildChannelCount="), this.guildChannelCount, ")");
        }
    }

    /* JADX INFO: compiled from: GuildRoleSubscriptionReviewViewModel.kt */
    public static final /* data */ class ViewState {
        private final List<GuildRoleSubscriptionTierAdapterItem> items;

        /* JADX WARN: Multi-variable type inference failed */
        public ViewState(List<? extends GuildRoleSubscriptionTierAdapterItem> list) {
            Intrinsics3.checkNotNullParameter(list, "items");
            this.items = list;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ViewState copy$default(ViewState viewState, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = viewState.items;
            }
            return viewState.copy(list);
        }

        public final List<GuildRoleSubscriptionTierAdapterItem> component1() {
            return this.items;
        }

        public final ViewState copy(List<? extends GuildRoleSubscriptionTierAdapterItem> items) {
            Intrinsics3.checkNotNullParameter(items, "items");
            return new ViewState(items);
        }

        public boolean equals(Object other) {
            if (this != other) {
                return (other instanceof ViewState) && Intrinsics3.areEqual(this.items, ((ViewState) other).items);
            }
            return true;
        }

        public final List<GuildRoleSubscriptionTierAdapterItem> getItems() {
            return this.items;
        }

        public int hashCode() {
            List<GuildRoleSubscriptionTierAdapterItem> list = this.items;
            if (list != null) {
                return list.hashCode();
            }
            return 0;
        }

        public String toString() {
            return outline.L(outline.U("ViewState(items="), this.items, ")");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ GuildRoleSubscriptionReviewViewModel(long j, StoreChannels storeChannels, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreChannels channels = (i & 2) != 0 ? StoreStream.INSTANCE.getChannels() : storeChannels;
        ObservationDeck observationDeck2 = (i & 4) != 0 ? ObservationDeck4.get() : observationDeck;
        this(j, channels, observationDeck2, (i & 8) != 0 ? INSTANCE.observeStoreState(j, observationDeck2, channels) : observable);
    }

    private final void handleStoreState(StoreState storeState) {
        this.guildChannelCount = Integer.valueOf(storeState.getGuildChannelCount());
        updateList();
    }

    private final void updateList() {
        updateViewState(new ViewState(GuildRoleSubscriptionTierListItemGenerator.generateGuildRoleSubscriptionReviewListItems(this.guildRoleSubscriptionTier, this.isFullServerGating, this.guildChannelCount, this.planDescription, this.planCoverImage)));
    }

    public final void updatePlanDetails(String description, String coverImage) {
        Intrinsics3.checkNotNullParameter(description, ModelAuditLogEntry.CHANGE_KEY_DESCRIPTION);
        Intrinsics3.checkNotNullParameter(coverImage, "coverImage");
        this.planDescription = description;
        this.planCoverImage = coverImage;
        updateList();
    }

    public final void updateTier(GuildRoleSubscriptionTier guildRoleSubscriptionTier, Boolean isFullServerGating) {
        Intrinsics3.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        this.guildRoleSubscriptionTier = guildRoleSubscriptionTier;
        this.isFullServerGating = isFullServerGating;
        updateList();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildRoleSubscriptionReviewViewModel(long j, StoreChannels storeChannels, ObservationDeck observationDeck, Observable<StoreState> observable) {
        super(null, 1, null);
        Intrinsics3.checkNotNullParameter(storeChannels, "storeChannels");
        Intrinsics3.checkNotNullParameter(observationDeck, "observationDeck");
        Intrinsics3.checkNotNullParameter(observable, "storeStateObservable");
        Observable<StoreState> observableR = observable.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) GuildRoleSubscriptionReviewViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
