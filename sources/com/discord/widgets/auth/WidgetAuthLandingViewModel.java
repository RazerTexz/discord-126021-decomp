package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
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
import p658rx.functions.Action0;
import p658rx.functions.Func4;
import p658rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel extends AbstractC0859d0<ViewState> {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final PublishSubject<Event> eventSubject;
    private final GoogleSmartLockManager googleSmartLockManager;
    private StoreState mostRecentStoreState;
    private boolean smartLockCredentialRequestDisabled;
    private final StoreInstantInvites storeInstantInvites;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$1 */
    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static final class C71791 extends AbstractC12240o implements Function1<StoreState, Unit> {
        public C71791() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(StoreState storeState) {
            invoke2(storeState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(StoreState storeState) {
            C12238m.checkNotNullParameter(storeState, "it");
            WidgetAuthLandingViewModel.this.handleStoreState(storeState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLandingViewModel$2 */
    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static final class C71802 extends AbstractC12240o implements Function1<GoogleSmartLockManager.SmartLockCredentials, Unit> {
        public C71802() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
            invoke2(smartLockCredentials);
            return Unit.f27425a;
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GoogleSmartLockManager.SmartLockCredentials smartLockCredentials) {
            C12238m.checkNotNullParameter(smartLockCredentials, "it");
            WidgetAuthLandingViewModel.this.eventSubject.f27650k.onNext((T) new Event.SmartLockLogin(smartLockCredentials));
        }
    }

    /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
    public static final class Companion {
        private Companion() {
        }

        private final Observable<StoreState> observeStoreState(StoreInviteSettings storeInviteSettings, final StoreGuildTemplates storeGuildTemplates, StoreAuthentication storeAuthentication) {
            Observable<StoreState> observableM11073h = Observable.m11073h(storeInviteSettings.getInviteCode(), storeInviteSettings.getInvite(), storeGuildTemplates.observeDynamicLinkGuildTemplateCode().m11099Y(new InterfaceC12589b<String, Observable<? extends StoreGuildTemplates.GuildTemplateState>>() { // from class: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1
                @Override // p637j0.p641k.InterfaceC12589b
                public final Observable<? extends StoreGuildTemplates.GuildTemplateState> call(final String str) {
                    return str != null ? storeGuildTemplates.observeGuildTemplate(str).m11116v(new Action0() { // from class: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$1.1
                        @Override // p658rx.functions.Action0
                        public final void call() {
                            storeGuildTemplates.maybeInitTemplateState(str);
                        }
                    }) : new C12721k(StoreGuildTemplates.GuildTemplateState.None.INSTANCE);
                }
            }), storeAuthentication.getAgeGateError(), new Func4<StoreInviteSettings.InviteCode, ModelInvite, StoreGuildTemplates.GuildTemplateState, String, StoreState>() { // from class: com.discord.widgets.auth.WidgetAuthLandingViewModel$Companion$observeStoreState$2
                @Override // p658rx.functions.Func4
                public final WidgetAuthLandingViewModel.StoreState call(StoreInviteSettings.InviteCode inviteCode, ModelInvite modelInvite, StoreGuildTemplates.GuildTemplateState guildTemplateState, String str) {
                    C12238m.checkNotNullExpressionValue(guildTemplateState, "guildTemplate");
                    return new WidgetAuthLandingViewModel.StoreState(inviteCode, modelInvite, guildTemplateState, str);
                }
            });
            C12238m.checkNotNullExpressionValue(observableM11073h, "Observable.combineLatest…eError,\n        )\n      }");
            return observableM11073h;
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
                C12238m.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
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
                C12238m.checkNotNullParameter(smartLockCredentials, "smartLockCredentials");
                return new SmartLockLogin(smartLockCredentials);
            }

            public boolean equals(Object other) {
                if (this != other) {
                    return (other instanceof SmartLockLogin) && C12238m.areEqual(this.smartLockCredentials, ((SmartLockLogin) other).smartLockCredentials);
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
                StringBuilder sbM833U = C1643a.m833U("SmartLockLogin(smartLockCredentials=");
                sbM833U.append(this.smartLockCredentials);
                sbM833U.append(")");
                return sbM833U.toString();
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
            C12238m.checkNotNullParameter(guildTemplateState, "guildTemplateState");
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
            C12238m.checkNotNullParameter(guildTemplateState, "guildTemplateState");
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
            return C12238m.areEqual(this.inviteCode, storeState.inviteCode) && C12238m.areEqual(this.invite, storeState.invite) && C12238m.areEqual(this.guildTemplateState, storeState.guildTemplateState) && C12238m.areEqual(this.ageGateError, storeState.ageGateError);
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
            StringBuilder sbM833U = C1643a.m833U("StoreState(inviteCode=");
            sbM833U.append(this.inviteCode);
            sbM833U.append(", invite=");
            sbM833U.append(this.invite);
            sbM833U.append(", guildTemplateState=");
            sbM833U.append(this.guildTemplateState);
            sbM833U.append(", ageGateError=");
            return C1643a.m822J(sbM833U, this.ageGateError, ")");
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
                    return (other instanceof Empty) && C12238m.areEqual(getAgeGateError(), ((Empty) other).getAgeGateError());
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
                StringBuilder sbM833U = C1643a.m833U("Empty(ageGateError=");
                sbM833U.append(getAgeGateError());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
        public static final /* data */ class GuildTemplate extends ViewState {
            private final String ageGateError;
            private final ModelGuildTemplate guildTemplate;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public GuildTemplate(ModelGuildTemplate modelGuildTemplate, String str) {
                super(str, null);
                C12238m.checkNotNullParameter(modelGuildTemplate, "guildTemplate");
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
                C12238m.checkNotNullParameter(guildTemplate, "guildTemplate");
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
                return C12238m.areEqual(this.guildTemplate, guildTemplate.guildTemplate) && C12238m.areEqual(getAgeGateError(), guildTemplate.getAgeGateError());
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
                StringBuilder sbM833U = C1643a.m833U("GuildTemplate(guildTemplate=");
                sbM833U.append(this.guildTemplate);
                sbM833U.append(", ageGateError=");
                sbM833U.append(getAgeGateError());
                sbM833U.append(")");
                return sbM833U.toString();
            }
        }

        /* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
        public static final /* data */ class Invite extends ViewState {
            private final String ageGateError;
            private final ModelInvite invite;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Invite(ModelInvite modelInvite, String str) {
                super(str, null);
                C12238m.checkNotNullParameter(modelInvite, "invite");
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
                C12238m.checkNotNullParameter(invite, "invite");
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
                return C12238m.areEqual(this.invite, invite.invite) && C12238m.areEqual(getAgeGateError(), invite.getAgeGateError());
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
                StringBuilder sbM833U = C1643a.m833U("Invite(invite=");
                sbM833U.append(this.invite);
                sbM833U.append(", ageGateError=");
                sbM833U.append(getAgeGateError());
                sbM833U.append(")");
                return sbM833U.toString();
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
        C12238m.checkNotNullParameter(storeState, "storeState");
        StoreInviteSettings.InviteCode inviteCode = storeState.getInviteCode();
        StoreState storeState2 = this.mostRecentStoreState;
        if ((!C12238m.areEqual(storeState2 != null ? storeState2.getInviteCode() : null, inviteCode)) && inviteCode != null) {
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
        C12238m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setSmartLockCredentialRequestDisabled(boolean z2) {
        this.smartLockCredentialRequestDisabled = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable<StoreState> observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager) {
        super(new ViewState.Empty(null));
        C12238m.checkNotNullParameter(context, "context");
        C12238m.checkNotNullParameter(storeAuthentication, "storeAuthentication");
        C12238m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        C12238m.checkNotNullParameter(observable, "storeObservable");
        C12238m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        C12238m.checkNotNullParameter(googleSmartLockManager, "googleSmartLockManager");
        this.storeInstantInvites = storeInstantInvites;
        this.googleSmartLockManager = googleSmartLockManager;
        this.eventSubject = PublishSubject.m11133k0();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), (Class<?>) WidgetAuthLandingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71791());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(googleSmartLockManager.getSmartLockRepo().getSmartLockLoginObservable(), this, null, 2, null), (Class<?>) WidgetAuthLandingViewModel.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71802());
        storeAuthentication.requestConsentRequired();
        storeAnalytics.appLandingViewed();
    }
}
