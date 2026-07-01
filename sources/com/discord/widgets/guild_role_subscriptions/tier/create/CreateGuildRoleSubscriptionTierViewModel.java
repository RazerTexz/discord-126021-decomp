package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.stores.StoreGuildRoleSubscriptions;
import com.discord.stores.StoreGuilds;
import com.discord.stores.StoreStream;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.guild_role_subscriptions.GuildRoleSubscriptionUtils;
import com.discord.widgets.guild_role_subscriptions.tier.model.GuildRoleSubscriptionTier;
import d0.g0.t;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: CreateGuildRoleSubscriptionTierViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class CreateGuildRoleSubscriptionTierViewModel extends d0<CreateGuildRoleSubscriptionTierViewModel$ViewState> {
    private static final int CHANNEL_BENEFITS_STEP = 1;
    public static final CreateGuildRoleSubscriptionTierViewModel$Companion Companion = new CreateGuildRoleSubscriptionTierViewModel$Companion(null);
    private static final int DESIGN_STEP = 3;
    private static final int DETAILS_STEP = 0;
    private static final int INTANGIBLE_BENEFITS_STEP = 2;
    private final PublishSubject<CreateGuildRoleSubscriptionTierViewModel$Event> eventSubject;
    private final long groupListingId;
    private final long guildId;
    private Boolean isFullServerGating;
    private final RestAPI restApi;
    private final StoreGuildRoleSubscriptions storeGuildRoleSubscriptions;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ CreateGuildRoleSubscriptionTierViewModel(long j, long j2, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        RestAPI api = (i & 4) != 0 ? RestAPI.Companion.getApi() : restAPI;
        StoreGuildRoleSubscriptions guildRoleSubscriptions = (i & 8) != 0 ? StoreStream.Companion.getGuildRoleSubscriptions() : storeGuildRoleSubscriptions;
        StoreGuilds guilds = (i & 16) != 0 ? StoreStream.Companion.getGuilds() : storeGuilds;
        ObservationDeck observationDeck2 = (i & 32) != 0 ? ObservationDeckProvider.get() : observationDeck;
        this(j, j2, api, guildRoleSubscriptions, guilds, observationDeck2, (i & 64) != 0 ? CreateGuildRoleSubscriptionTierViewModel$Companion.access$observeStoreState(Companion, j, observationDeck2, guildRoleSubscriptions, guilds) : observable);
    }

    public static final /* synthetic */ void access$emitEvent(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel, CreateGuildRoleSubscriptionTierViewModel$Event createGuildRoleSubscriptionTierViewModel$Event) {
        createGuildRoleSubscriptionTierViewModel.emitEvent(createGuildRoleSubscriptionTierViewModel$Event);
    }

    public static final /* synthetic */ void access$handleStoreState(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel, CreateGuildRoleSubscriptionTierViewModel$StoreState createGuildRoleSubscriptionTierViewModel$StoreState) {
        createGuildRoleSubscriptionTierViewModel.handleStoreState(createGuildRoleSubscriptionTierViewModel$StoreState);
    }

    public static final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel$ViewState access$requireViewState(CreateGuildRoleSubscriptionTierViewModel createGuildRoleSubscriptionTierViewModel) {
        return createGuildRoleSubscriptionTierViewModel.requireViewState();
    }

    private final boolean computeCanProceedToNextStep(CreateGuildRoleSubscriptionTierViewModel$ViewState viewState) {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = viewState.getGuildRoleSubscriptionTier();
        int currentStep = viewState.getCurrentStep();
        if (currentStep == 0) {
            String name = guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getName() : null;
            if (name == null || t.isBlank(name)) {
                return false;
            }
            if ((guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getPriceTier() : null) == null) {
                return false;
            }
            String description = guildRoleSubscriptionTier.getDescription();
            if (description == null || t.isBlank(description)) {
                return false;
            }
            String image = guildRoleSubscriptionTier.getImage();
            if (image == null || t.isBlank(image)) {
                return false;
            }
        } else if (currentStep != 1 && currentStep != 2) {
            if (currentStep != 3) {
                return false;
            }
            if ((guildRoleSubscriptionTier != null ? guildRoleSubscriptionTier.getMemberColor() : null) == null) {
                return false;
            }
        }
        return true;
    }

    @MainThread
    private final void emitEvent(CreateGuildRoleSubscriptionTierViewModel$Event event) {
        this.eventSubject.k.onNext(event);
    }

    private final void handleStoreState(CreateGuildRoleSubscriptionTierViewModel$StoreState storeState) {
        if (storeState.getGuildRoleSubscriptionGroupListing() != null) {
            Boolean fullServerGatingOverwrite = storeState.getFullServerGatingOverwrite();
            boolean zBooleanValue = fullServerGatingOverwrite != null ? fullServerGatingOverwrite.booleanValue() : storeState.getGuildRoleSubscriptionGroupListing().getFullServerGate();
            this.isFullServerGating = Boolean.valueOf(zBooleanValue);
            emitEvent(new CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate(zBooleanValue));
        }
    }

    public final void goToNextStep() {
        CreateGuildRoleSubscriptionTierViewModel$ViewState createGuildRoleSubscriptionTierViewModel$ViewStateRequireViewState = requireViewState();
        updateViewState2(CreateGuildRoleSubscriptionTierViewModel$ViewState.copy$default(createGuildRoleSubscriptionTierViewModel$ViewStateRequireViewState, createGuildRoleSubscriptionTierViewModel$ViewStateRequireViewState.getCurrentStep() + 1, false, false, null, 14, null));
    }

    public final void goToPreviousStep() {
        CreateGuildRoleSubscriptionTierViewModel$ViewState createGuildRoleSubscriptionTierViewModel$ViewStateRequireViewState = requireViewState();
        updateViewState2(CreateGuildRoleSubscriptionTierViewModel$ViewState.copy$default(createGuildRoleSubscriptionTierViewModel$ViewStateRequireViewState, createGuildRoleSubscriptionTierViewModel$ViewStateRequireViewState.getCurrentStep() - 1, false, false, null, 14, null));
    }

    public final Observable<CreateGuildRoleSubscriptionTierViewModel$Event> observeEvents() {
        PublishSubject<CreateGuildRoleSubscriptionTierViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void onTierUpdated(GuildRoleSubscriptionTier guildRoleSubscriptionTier) {
        m.checkNotNullParameter(guildRoleSubscriptionTier, "guildRoleSubscriptionTier");
        updateViewState2(CreateGuildRoleSubscriptionTierViewModel$ViewState.copy$default(requireViewState(), 0, false, false, guildRoleSubscriptionTier, 7, null));
    }

    public final void submit() {
        GuildRoleSubscriptionTier guildRoleSubscriptionTier = requireViewState().getGuildRoleSubscriptionTier();
        if (guildRoleSubscriptionTier != null) {
            String name = guildRoleSubscriptionTier.getName();
            if ((name == null || t.isBlank(name)) || guildRoleSubscriptionTier.getPriceTier() == null || guildRoleSubscriptionTier.getMemberColor() == null) {
                return;
            }
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(GuildRoleSubscriptionUtils.INSTANCE.createGuildRoleSubscriptionTierListing(this.restApi, this.storeGuildRoleSubscriptions, this.guildId, this.groupListingId, guildRoleSubscriptionTier.getName(), guildRoleSubscriptionTier.getDescription(), guildRoleSubscriptionTier.getPriceTier().intValue(), guildRoleSubscriptionTier.getImage(), ColorCompat.INSTANCE.removeAlphaComponent(guildRoleSubscriptionTier.getMemberColor().intValue()), guildRoleSubscriptionTier.getMemberIcon(), guildRoleSubscriptionTier.canAccessAllChannelsOrDefault(this.isFullServerGating), guildRoleSubscriptionTier.getChannelBenefits(), guildRoleSubscriptionTier.getIntangibleBenefits()), this, null, 2, null), CreateGuildRoleSubscriptionTierViewModel.class, (Context) null, (Function1) null, new CreateGuildRoleSubscriptionTierViewModel$submit$2(this), (Function0) null, (Function0) null, new CreateGuildRoleSubscriptionTierViewModel$submit$1(this), 54, (Object) null);
        }
    }

    @Override // b.a.d.d0
    public /* bridge */ /* synthetic */ void updateViewState(CreateGuildRoleSubscriptionTierViewModel$ViewState createGuildRoleSubscriptionTierViewModel$ViewState) {
        updateViewState2(createGuildRoleSubscriptionTierViewModel$ViewState);
    }

    /* JADX INFO: renamed from: updateViewState, reason: avoid collision after fix types in other method */
    public void updateViewState2(CreateGuildRoleSubscriptionTierViewModel$ViewState viewState) {
        m.checkNotNullParameter(viewState, "viewState");
        super.updateViewState(CreateGuildRoleSubscriptionTierViewModel$ViewState.copy$default(viewState, 0, computeCanProceedToNextStep(viewState), false, null, 13, null));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CreateGuildRoleSubscriptionTierViewModel(long j, long j2, RestAPI restAPI, StoreGuildRoleSubscriptions storeGuildRoleSubscriptions, StoreGuilds storeGuilds, ObservationDeck observationDeck, Observable<CreateGuildRoleSubscriptionTierViewModel$StoreState> observable) {
        super(new CreateGuildRoleSubscriptionTierViewModel$ViewState(0, false, false, null, 15, null));
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(storeGuildRoleSubscriptions, "storeGuildRoleSubscriptions");
        m.checkNotNullParameter(storeGuilds, "storeGuilds");
        m.checkNotNullParameter(observationDeck, "observationDeck");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.groupListingId = j2;
        this.restApi = restAPI;
        this.storeGuildRoleSubscriptions = storeGuildRoleSubscriptions;
        this.eventSubject = PublishSubject.k0();
        Observable<CreateGuildRoleSubscriptionTierViewModel$StoreState> observableR = observable.r();
        m.checkNotNullExpressionValue(observableR, "storeStateObservable\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), CreateGuildRoleSubscriptionTierViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new CreateGuildRoleSubscriptionTierViewModel$1(this), 62, (Object) null);
    }
}
