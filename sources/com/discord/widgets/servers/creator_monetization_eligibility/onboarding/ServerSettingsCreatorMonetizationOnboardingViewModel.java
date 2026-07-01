package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import b.a.d.d0;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest$State;
import com.discord.models.guild.Guild;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: ServerSettingsCreatorMonetizationOnboardingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ServerSettingsCreatorMonetizationOnboardingViewModel extends d0<ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState> {
    public static final ServerSettingsCreatorMonetizationOnboardingViewModel$Companion Companion = new ServerSettingsCreatorMonetizationOnboardingViewModel$Companion(null);
    private final PublishSubject<ServerSettingsCreatorMonetizationOnboardingViewModel$Event> eventSubject;
    private final long guildId;
    private final BehaviorSubject<ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState> requirementsSubject;
    private final RestAPI restApi;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel(long j, RestAPI restAPI, BehaviorSubject behaviorSubject, Observable observable, int i, DefaultConstructorMarker defaultConstructorMarker) {
        BehaviorSubject behaviorSubject2;
        Observable observableAccess$observeStores;
        RestAPI api = (i & 2) != 0 ? RestAPI.Companion.getApi() : restAPI;
        if ((i & 4) != 0) {
            BehaviorSubject behaviorSubjectK0 = BehaviorSubject.k0();
            m.checkNotNullExpressionValue(behaviorSubjectK0, "BehaviorSubject.create()");
            behaviorSubject2 = behaviorSubjectK0;
        } else {
            behaviorSubject2 = behaviorSubject;
        }
        if ((i & 8) != 0) {
            ServerSettingsCreatorMonetizationOnboardingViewModel$Companion serverSettingsCreatorMonetizationOnboardingViewModel$Companion = Companion;
            ObservationDeck observationDeck = ObservationDeckProvider.get();
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observableAccess$observeStores = ServerSettingsCreatorMonetizationOnboardingViewModel$Companion.access$observeStores(serverSettingsCreatorMonetizationOnboardingViewModel$Companion, observationDeck, storeStream$Companion.getGuilds(), storeStream$Companion.getUsers(), j);
        } else {
            observableAccess$observeStores = observable;
        }
        this(j, api, behaviorSubject2, observableAccess$observeStores);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        return serverSettingsCreatorMonetizationOnboardingViewModel.eventSubject;
    }

    public static final /* synthetic */ BehaviorSubject access$getRequirementsSubject$p(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        return serverSettingsCreatorMonetizationOnboardingViewModel.requirementsSubject;
    }

    public static final /* synthetic */ void access$handleStoreState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel, ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState) {
        serverSettingsCreatorMonetizationOnboardingViewModel.handleStoreState(serverSettingsCreatorMonetizationOnboardingViewModel$StoreState, serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState);
    }

    public static final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState access$requireViewState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel) {
        return serverSettingsCreatorMonetizationOnboardingViewModel.requireViewState();
    }

    public static final /* synthetic */ void access$updateViewState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        serverSettingsCreatorMonetizationOnboardingViewModel.updateViewState(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState);
    }

    public static final /* synthetic */ void access$updateWithViewState(ServerSettingsCreatorMonetizationOnboardingViewModel serverSettingsCreatorMonetizationOnboardingViewModel, Function1 function1) {
        serverSettingsCreatorMonetizationOnboardingViewModel.updateWithViewState(function1);
    }

    private final <T> Observable<T> dispatchErrorsToUI(Observable<T> observable) {
        return observable.t(new ServerSettingsCreatorMonetizationOnboardingViewModel$dispatchErrorsToUI$1(this));
    }

    private final void handleStoreState(ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState storeState, ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState requirementsState) {
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms;
        if (storeState.getGuild() == null || (requirementsState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loading)) {
            updateViewState(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$Loading.INSTANCE);
            return;
        }
        if (requirementsState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error) {
            updateViewState(new ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$Error(((ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Error) requirementsState).getError()));
            return;
        }
        boolean z2 = requirementsState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded;
        if (z2) {
            ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded = (ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded) requirementsState;
            CreatorMonetizationEnableRequest latestRequest = serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded.getRequirements().getLatestRequest();
            if ((latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest$State.APPROVED) {
                ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateRequireViewState = requireViewState();
                if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateRequireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) {
                    serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms = ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.copy$default((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateRequireViewState, storeState.getGuild(), false, null, false, false, 30, null);
                } else {
                    Guild guild = storeState.getGuild();
                    boolean zIsGuildOwner = storeState.isGuildOwner();
                    CreatorMonetizationEnableRequest latestRequest2 = serverSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded.getRequirements().getLatestRequest();
                    if (latestRequest2 == null) {
                        throw new IllegalArgumentException("Required value was null.".toString());
                    }
                    serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms = new ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms(guild, zIsGuildOwner, latestRequest2, false, false, 24, null);
                }
                updateViewState(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms);
                return;
            }
        }
        if (z2) {
            updateViewState(new ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest(((ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loaded) requirementsState).getRequirements(), storeState.isGuildOwner(), false, 4, null));
        }
    }

    private final void refreshRequirements() {
        if (this.requirementsSubject.n0() instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loading) {
            return;
        }
        this.requirementsSubject.onNext(ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState$Loading.INSTANCE);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.getCreatorMonetizationEligibilityRequirements(this.guildId), false, 1, null), this, null, 2, null), ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, new ServerSettingsCreatorMonetizationOnboardingViewModel$refreshRequirements$1(this), (Function0) null, (Function0) null, new ServerSettingsCreatorMonetizationOnboardingViewModel$refreshRequirements$2(this), 54, (Object) null);
    }

    private final /* synthetic */ <T extends ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState> void updateWithViewState(Function1<? super T, ? extends T> transform) {
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState = access$requireViewState(this);
        m.reifiedOperationMarker(3, ExifInterface.GPS_DIRECTION_TRUE);
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
            access$updateViewState(this, transform.invoke(serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState));
        }
    }

    public final void createRequestToEnableMonetization() {
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState = access$requireViewState(this);
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) {
            Observable observableDispatchErrorsToUI = dispatchErrorsToUI(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.createCreatorMonetizationEnableRequest(this.guildId), false, 1, null), this, null, 2, null));
            m.checkNotNullExpressionValue(observableDispatchErrorsToUI, "restApi.createCreatorMon…    .dispatchErrorsToUI()");
            ObservableExtensionsKt.appSubscribe$default(observableDispatchErrorsToUI, ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, new ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$$inlined$updateWithViewState$lambda$1(this), (Function0) null, (Function0) null, new ServerSettingsCreatorMonetizationOnboardingViewModel$createRequestToEnableMonetization$$inlined$updateWithViewState$lambda$2(this), 54, (Object) null);
            access$updateViewState(this, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest.copy$default((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState, null, false, true, 3, null));
        }
    }

    public final Observable<ServerSettingsCreatorMonetizationOnboardingViewModel$Event> listenForEvents() {
        PublishSubject<ServerSettingsCreatorMonetizationOnboardingViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setHasAcceptedTerms(boolean hasAccepted) {
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState = access$requireViewState(this);
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) {
            access$updateViewState(this, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.copy$default((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState, null, false, null, hasAccepted, false, 23, null));
        }
    }

    public final void submitTermsAcceptance() {
        ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState = access$requireViewState(this);
        if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) {
            ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) serverSettingsCreatorMonetizationOnboardingViewModel$ViewStateAccess$requireViewState;
            Observable observableDispatchErrorsToUI = dispatchErrorsToUI(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.restSubscribeOn$default(this.restApi.acceptCreatorMonetizationTerms(this.guildId, serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.getLatestRequest().getId()), false, 1, null), this, null, 2, null));
            m.checkNotNullExpressionValue(observableDispatchErrorsToUI, "restApi.acceptCreatorMon…    .dispatchErrorsToUI()");
            ObservableExtensionsKt.appSubscribe$default(observableDispatchErrorsToUI, ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, new ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$$inlined$updateWithViewState$lambda$1(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms, this), (Function0) null, (Function0) null, ServerSettingsCreatorMonetizationOnboardingViewModel$submitTermsAcceptance$1$2.INSTANCE, 54, (Object) null);
            access$updateViewState(this, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.copy$default(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms, null, false, null, false, true, 15, null));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ServerSettingsCreatorMonetizationOnboardingViewModel(long j, RestAPI restAPI, BehaviorSubject<ServerSettingsCreatorMonetizationOnboardingViewModel$RequirementsState> behaviorSubject, Observable<ServerSettingsCreatorMonetizationOnboardingViewModel$StoreState> observable) {
        super(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$Loading.INSTANCE);
        m.checkNotNullParameter(restAPI, "restApi");
        m.checkNotNullParameter(behaviorSubject, "requirementsSubject");
        m.checkNotNullParameter(observable, "storeStateObservable");
        this.guildId = j;
        this.restApi = restAPI;
        this.requirementsSubject = behaviorSubject;
        this.eventSubject = PublishSubject.k0();
        Observable observableJ = Observable.j(ObservableExtensionsKt.computationLatest(observable).r(), behaviorSubject, ServerSettingsCreatorMonetizationOnboardingViewModel$1.INSTANCE);
        m.checkNotNullExpressionValue(observableJ, "Observable.combineLatest…reState to requirements }");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableJ, this, null, 2, null), ServerSettingsCreatorMonetizationOnboardingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new ServerSettingsCreatorMonetizationOnboardingViewModel$2(this), 62, (Object) null);
        refreshRequirements();
    }
}
