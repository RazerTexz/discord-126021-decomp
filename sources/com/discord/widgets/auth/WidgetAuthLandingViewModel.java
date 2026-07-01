package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.AppViewModel;
import b.d.b.a.outline;
import com.discord.models.domain.ModelGuildTemplate;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreGuildTemplates;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreStream;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.auth.WidgetAuthLandingViewModel;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action0;
import rx.functions.Func4;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel extends AppViewModel<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GoogleSmartLockManager googleSmartLockManager;
    private StoreState mostRecentStoreState;
    private boolean smartLockCredentialRequestDisabled;
    private final StoreInstantInvites storeInstantInvites;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
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
            Intrinsics3.checkNotNullParameter(storeState, "it");
            WidgetAuthLandingViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GoogleSmartLockManager.SmartLockCredentials, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
            invoke2(smartLockCredentials);
            return Unit.a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
            Intrinsics3.checkNotNullParameter(smartLockCredentials, "it");
            WidgetAuthLandingViewModel.this.eventSubject.k.onNext((T) new Event.SmartLockLogin(smartLockCredentials));
        }
    }

    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreInviteSettings storeInviteSettings, final StoreGuildTemplates storeGuildTemplates, StoreAuthentication storeAuthentication) {
            Observable<StoreState> observableH = Observable.h(storeInviteSettings.getInviteCode(), storeInviteSettings.getInvite(), storeGuildTemplates.observeDynamicLinkGuildTemplateCode().Y(new Func1<String, Observable<? extends StoreGuildTemplates.GuildTemplateState>>() { // from class: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1
                @Override // j0.k.Func1
                public final Observable<? extends StoreGuildTemplates.GuildTemplateState> call(final String str) {
                    return str != null ? storeGuildTemplates.observeGuildTemplate(str).v(new Action0() { // from class: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1.1
                        @Override // rx.functions.Action0
                        public final void call() {
                            storeGuildTemplates.maybeInitTemplateState(str);
                        }
                    }) : new ScalarSynchronousObservable(StoreGuildTemplates.GuildTemplateState.None.INSTANCE);
                }
            }), storeAuthentication.getAgeGateError(), new Func4<StoreInviteSettings.InviteCode, ModelInvite, StoreGuildTemplates.GuildTemplateState, String, StoreState>() { // from class: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$2
                @Override // rx.functions.Func4
                public final WidgetAuthLandingViewModel.StoreState call(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
                    Intrinsics3.checkNotNullExpressionValue(guildTemplateState, "guildTemplate");
                    return new WidgetAuthLandingViewModel.StoreState(inviteCode, modelInvite, guildTemplateState, str);
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableH, "Observable.combineLatest…eError,\n        )\n      }");
            return observableH;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static abstract class Event {

        /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
        public static final /* data */ class SmartLockLogin extends Event {
            private final GoogleSmartLockManager.SmartLockCredentials smartLockCredentials;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public SmartLockLogin(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
                super(null);
                Intrinsics3.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
                this.smartLockCredentials = smartLockCredentials;
            }

            public static /* synthetic */ SmartLockLogin copy$default(SmartLockLogin smartLockLogin, GoogleSmartLockManager.SmartLockCredentials smartLockCredentials, int i, Object obj) {
                if ((i & 1) != 0) {
                    smartLockCredentials = smartLockLogin.smartLockCredentials;
                }
                return smartLockLogin.copy(smartLockCredentials);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
                return this.smartLockCredentials;
            }

            public final SmartLockLogin copy(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
                Intrinsics3.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
                return new SmartLockLogin(smartLockCredentials);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SmartLockLogin) && Intrinsics3.areEqual(this.smartLockCredentials, ((SmartLockLogin) other).smartLockCredentials);
                }
                return true;
            }

            public final GoogleSmartLockManager.SmartLockCredentials getSmartLockCredentials() {
                return this.smartLockCredentials;
            }

            public int hashCode() {
                GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = this.smartLockCredentials;
                if (smartLockCredentials != null) {
                    return smartLockCredentials.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("SmartLockLogin(smartLockCredentials=");
                sbU.append(this.smartLockCredentials);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Event() {
        }

        public /* synthetic */ Event(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static final /* data */ class StoreState {
        private final String ageGateError;
        private final StoreGuildTemplates.GuildTemplateState guildTemplateState;
        private final ModelInvite invite;
        private final StoreInviteSettings.InviteCode inviteCode;

        public StoreState(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
            Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplateState");
            this.inviteCode = inviteCode;
            this.invite = modelInvite;
            this.guildTemplateState = guildTemplateState;
            this.ageGateError = str;
        }

        public static /* synthetic */ StoreState copy$default(StoreState storeState, StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                inviteCode = storeState.inviteCode;
            }
            if ((i & 2) != 0) {
                modelInvite = storeState.invite;
            }
            if ((i & 4) != 0) {
                guildTemplateState = storeState.guildTemplateState;
            }
            if ((i & 8) != 0) {
                str = storeState.ageGateError;
            }
            return storeState.copy(inviteCode, modelInvite, guildTemplateState, str);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final ModelInvite getInvite() {
            return this.invite;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final StoreGuildTemplates.GuildTemplateState getGuildTemplateState() {
            return this.guildTemplateState;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final String getAgeGateError() {
            return this.ageGateError;
        }

        public final StoreState copy(StoreInviteSettings.InviteCode inviteCode, ModelInvite invite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String ageGateError) {
            Intrinsics3.checkNotNullParameter(guildTemplateState, "guildTemplateState");
            return new StoreState(inviteCode, invite, guildTemplateState, ageGateError);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StoreState)) {
                return false;
            }
            StoreState storeState = (StoreState) other;
            return Intrinsics3.areEqual(this.inviteCode, storeState.inviteCode) && Intrinsics3.areEqual(this.invite, storeState.invite) && Intrinsics3.areEqual(this.guildTemplateState, storeState.guildTemplateState) && Intrinsics3.areEqual(this.ageGateError, storeState.ageGateError);
        }

        public final String getAgeGateError() {
            return this.ageGateError;
        }

        public final StoreGuildTemplates.GuildTemplateState getGuildTemplateState() {
            return this.guildTemplateState;
        }

        public final ModelInvite getInvite() {
            return this.invite;
        }

        public final StoreInviteSettings.InviteCode getInviteCode() {
            return this.inviteCode;
        }

        public int hashCode() {
            StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
            int iHashCode = (inviteCode != null ? inviteCode.hashCode() : 0) * 31;
            ModelInvite modelInvite = this.invite;
            int iHashCode2 = (iHashCode + (modelInvite != null ? modelInvite.hashCode() : 0)) * 31;
            StoreGuildTemplates.GuildTemplateState guildTemplateState = this.guildTemplateState;
            int iHashCode3 = (iHashCode2 + (guildTemplateState != null ? guildTemplateState.hashCode() : 0)) * 31;
            String str = this.ageGateError;
            return iHashCode3 + (str != null ? str.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("StoreState(inviteCode=");
            sbU.append(this.inviteCode);
            sbU.append(", invite=");
            sbU.append(this.invite);
            sbU.append(", guildTemplateState=");
            sbU.append(this.guildTemplateState);
            sbU.append(", ageGateError=");
            return outline.J(sbU, this.ageGateError, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static abstract class ViewState {
        private final String ageGateError;

        /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
        public static final /* data */ class Empty extends ViewState {
            private final String ageGateError;

            public Empty(String str) {
                super(str, null);
                this.ageGateError = str;
            }

            public static /* synthetic */ Empty copy$default(Empty empty, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    str = empty.getAgeGateError();
                }
                return empty.copy(str);
            }

            public final String component1() {
                return getAgeGateError();
            }

            public final Empty copy(String ageGateError) {
                return new Empty(ageGateError);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof Empty) && Intrinsics3.areEqual(getAgeGateError(), ((Empty) other).getAgeGateError());
                }
                return true;
            }

            @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel.ViewState
            public String getAgeGateError() {
                return this.ageGateError;
            }

            public int hashCode() {
                String ageGateError = getAgeGateError();
                if (ageGateError != null) {
                    return ageGateError.hashCode();
                }
                return 0;
            }

            public String toString() {
                StringBuilder sbU = outline.U("Empty(ageGateError=");
                sbU.append(getAgeGateError());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
        public static final /* data */ class GuildTemplate extends ViewState {
            private final String ageGateError;
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildTemplate(ModelGuildTemplate modelGuildTemplate, String str) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
                this.guildTemplate = modelGuildTemplate;
                this.ageGateError = str;
            }

            public static /* synthetic */ GuildTemplate copy$default(GuildTemplate guildTemplate, ModelGuildTemplate modelGuildTemplate, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelGuildTemplate = guildTemplate.guildTemplate;
                }
                if ((i & 2) != 0) {
                    str = guildTemplate.getAgeGateError();
                }
                return guildTemplate.copy(modelGuildTemplate, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public final String component2() {
                return getAgeGateError();
            }

            public final GuildTemplate copy(ModelGuildTemplate guildTemplate, String ageGateError) {
                Intrinsics3.checkNotNullParameter(guildTemplate, "guildTemplate");
                return new GuildTemplate(guildTemplate, ageGateError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof GuildTemplate)) {
                    return false;
                }
                GuildTemplate guildTemplate = (GuildTemplate) other;
                return Intrinsics3.areEqual(this.guildTemplate, guildTemplate.guildTemplate) && Intrinsics3.areEqual(getAgeGateError(), guildTemplate.getAgeGateError());
            }

            @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel.ViewState
            public String getAgeGateError() {
                return this.ageGateError;
            }

            public final ModelGuildTemplate getGuildTemplate() {
                return this.guildTemplate;
            }

            public int hashCode() {
                ModelGuildTemplate modelGuildTemplate = this.guildTemplate;
                int iHashCode = (modelGuildTemplate != null ? modelGuildTemplate.hashCode() : 0) * 31;
                String ageGateError = getAgeGateError();
                return iHashCode + (ageGateError != null ? ageGateError.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("GuildTemplate(guildTemplate=");
                sbU.append(this.guildTemplate);
                sbU.append(", ageGateError=");
                sbU.append(getAgeGateError());
                sbU.append(")");
                return sbU.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
        public static final /* data */ class Invite extends ViewState {
            private final String ageGateError;
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invite(ModelInvite modelInvite, String str) {
                super(str, null);
                Intrinsics3.checkNotNullParameter(modelInvite, "invite");
                this.invite = modelInvite;
                this.ageGateError = str;
            }

            public static /* synthetic */ Invite copy$default(Invite invite, ModelInvite modelInvite, String str, int i, Object obj) {
                if ((i & 1) != 0) {
                    modelInvite = invite.invite;
                }
                if ((i & 2) != 0) {
                    str = invite.getAgeGateError();
                }
                return invite.copy(modelInvite, str);
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final ModelInvite getInvite() {
                return this.invite;
            }

            public final String component2() {
                return getAgeGateError();
            }

            public final Invite copy(ModelInvite invite, String ageGateError) {
                Intrinsics3.checkNotNullParameter(invite, "invite");
                return new Invite(invite, ageGateError);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Invite)) {
                    return false;
                }
                Invite invite = (Invite) other;
                return Intrinsics3.areEqual(this.invite, invite.invite) && Intrinsics3.areEqual(getAgeGateError(), invite.getAgeGateError());
            }

            @Override // com.discord.widgets.auth.WidgetAuthLandingViewModel.ViewState
            public String getAgeGateError() {
                return this.ageGateError;
            }

            public final ModelInvite getInvite() {
                return this.invite;
            }

            public int hashCode() {
                ModelInvite modelInvite = this.invite;
                int iHashCode = (modelInvite != null ? modelInvite.hashCode() : 0) * 31;
                String ageGateError = getAgeGateError();
                return iHashCode + (ageGateError != null ? ageGateError.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("Invite(invite=");
                sbU.append(this.invite);
                sbU.append(", ageGateError=");
                sbU.append(getAgeGateError());
                sbU.append(")");
                return sbU.toString();
            }
        }

        private ViewState(String str) {
            this.ageGateError = str;
        }

        public String getAgeGateError() {
            return this.ageGateError;
        }

        public /* synthetic */ ViewState(String str, DefaultConstructorMarker defaultConstructorMarker) {
            this(str);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreAuthentication authentication = (i & 2) != 0 ? StoreStream.INSTANCE.getAuthentication() : storeAuthentication;
        StoreAnalytics analytics = (i & 4) != 0 ? StoreStream.INSTANCE.getAnalytics() : storeAnalytics;
        if ((i & 8) != 0) {
            Companion companion = INSTANCE;
            StoreStream.Companion companion2 = StoreStream.INSTANCE;
            observable = companion.observeStoreState(companion2.getInviteSettings(), companion2.getGuildTemplates(), companion2.getAuthentication());
        }
        this(context, authentication, analytics, observable, (i & 16) != 0 ? StoreStream.INSTANCE.getInstantInvites() : storeInstantInvites, (i & 32) != 0 ? new GoogleSmartLockManager(context, null, 2, null) : googleSmartLockManager);
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        return this.googleSmartLockManager;
    }

    public final boolean getSmartLockCredentialRequestDisabled() {
        return this.smartLockCredentialRequestDisabled;
    }

    @MainThread
    public final void handleStoreState(StoreState storeState) {
        Intrinsics3.checkNotNullParameter(storeState, "storeState");
        StoreInviteSettings.InviteCode inviteCode = storeState.getInviteCode();
        StoreState storeState2 = this.mostRecentStoreState;
        if ((!Intrinsics3.areEqual(storeState2 != null ? storeState2.getInviteCode() : null, inviteCode)) && inviteCode != null) {
            this.storeInstantInvites.fetchInviteIfNotLoaded(inviteCode.getInviteCode(), (24 & 2) != 0 ? null : null, (24 & 4) != 0 ? null : null, (24 & 8) != 0 ? null : null, (24 & 16) != 0 ? null : null);
        }
        ModelInvite invite = storeState.getInvite();
        StoreGuildTemplates.GuildTemplateState guildTemplateState = storeState.getGuildTemplateState();
        String ageGateError = storeState.getAgeGateError();
        if (invite != null) {
            updateViewState(new ViewState.Invite(invite, ageGateError));
        } else if (guildTemplateState instanceof StoreGuildTemplates.GuildTemplateState.Resolved) {
            updateViewState(new ViewState.GuildTemplate(((StoreGuildTemplates.GuildTemplateState.Resolved) guildTemplateState).getGuildTemplate(), ageGateError));
        } else {
            updateViewState(new ViewState.Empty(ageGateError));
        }
        this.mostRecentStoreState = storeState;
    }

    public final Observable<Event> observeEvents() {
        PublishSubject<Event> publishSubject = this.eventSubject;
        Intrinsics3.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setSmartLockCredentialRequestDisabled(boolean z2) {
        this.smartLockCredentialRequestDisabled = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable<StoreState> observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager) {
        super(new ViewState.Empty(null));
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(storeAuthentication, "storeAuthentication");
        Intrinsics3.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        Intrinsics3.checkNotNullParameter(observable, "storeObservable");
        Intrinsics3.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        Intrinsics3.checkNotNullParameter(googleSmartLockManager, "googleSmartLockManager");
        this.storeInstantInvites = storeInstantInvites;
        this.googleSmartLockManager = googleSmartLockManager;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetAuthLandingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(googleSmartLockManager.getSmartLockRepo().getSmartLockLoginObservable(), this, null, 2, null), (Class<?>) WidgetAuthLandingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        storeAuthentication.requestConsentRequired();
        storeAnalytics.appLandingViewed();
    }
}
