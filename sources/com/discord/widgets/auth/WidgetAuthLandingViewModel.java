package com.discord.widgets.auth;

import android.content.Context;
import androidx.annotation.MainThread;
import b.a.d.d0;
import com.discord.models.domain.ModelInvite;
import com.discord.stores.StoreAnalytics;
import com.discord.stores.StoreAuthentication;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState$Resolved;
import com.discord.stores.StoreInstantInvites;
import com.discord.stores.StoreInviteSettings$InviteCode;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreStream$Companion;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import rx.Observable;
import rx.subjects.PublishSubject;

/* JADX INFO: compiled from: WidgetAuthLandingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLandingViewModel extends d0<WidgetAuthLandingViewModel$ViewState> {
    public static final WidgetAuthLandingViewModel$Companion Companion = new WidgetAuthLandingViewModel$Companion(null);
    private final PublishSubject<WidgetAuthLandingViewModel$Event> eventSubject;
    private final GoogleSmartLockManager googleSmartLockManager;
    private WidgetAuthLandingViewModel$StoreState mostRecentStoreState;
    private boolean smartLockCredentialRequestDisabled;
    private final StoreInstantInvites storeInstantInvites;

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        StoreAuthentication authentication = (i & 2) != 0 ? StoreStream.Companion.getAuthentication() : storeAuthentication;
        StoreAnalytics analytics = (i & 4) != 0 ? StoreStream.Companion.getAnalytics() : storeAnalytics;
        if ((i & 8) != 0) {
            WidgetAuthLandingViewModel$Companion widgetAuthLandingViewModel$Companion = Companion;
            StoreStream$Companion storeStream$Companion = StoreStream.Companion;
            observable = WidgetAuthLandingViewModel$Companion.access$observeStoreState(widgetAuthLandingViewModel$Companion, storeStream$Companion.getInviteSettings(), storeStream$Companion.getGuildTemplates(), storeStream$Companion.getAuthentication());
        }
        this(context, authentication, analytics, observable, (i & 16) != 0 ? StoreStream.Companion.getInstantInvites() : storeInstantInvites, (i & 32) != 0 ? new GoogleSmartLockManager(context, null, 2, null) : googleSmartLockManager);
    }

    public static final /* synthetic */ PublishSubject access$getEventSubject$p(WidgetAuthLandingViewModel widgetAuthLandingViewModel) {
        return widgetAuthLandingViewModel.eventSubject;
    }

    public final GoogleSmartLockManager getGoogleSmartLockManager() {
        return this.googleSmartLockManager;
    }

    public final boolean getSmartLockCredentialRequestDisabled() {
        return this.smartLockCredentialRequestDisabled;
    }

    @MainThread
    public final void handleStoreState(WidgetAuthLandingViewModel$StoreState storeState) {
        m.checkNotNullParameter(storeState, "storeState");
        StoreInviteSettings$InviteCode inviteCode = storeState.getInviteCode();
        WidgetAuthLandingViewModel$StoreState widgetAuthLandingViewModel$StoreState = this.mostRecentStoreState;
        if ((!m.areEqual(widgetAuthLandingViewModel$StoreState != null ? widgetAuthLandingViewModel$StoreState.getInviteCode() : null, inviteCode)) && inviteCode != null) {
            StoreInstantInvites.fetchInviteIfNotLoaded$default(this.storeInstantInvites, inviteCode.getInviteCode(), null, null, null, null, 30, null);
        }
        ModelInvite invite = storeState.getInvite();
        StoreGuildTemplates$GuildTemplateState guildTemplateState = storeState.getGuildTemplateState();
        String ageGateError = storeState.getAgeGateError();
        if (invite != null) {
            updateViewState(new WidgetAuthLandingViewModel$ViewState$Invite(invite, ageGateError));
        } else if (guildTemplateState instanceof StoreGuildTemplates$GuildTemplateState$Resolved) {
            updateViewState(new WidgetAuthLandingViewModel$ViewState$GuildTemplate(((StoreGuildTemplates$GuildTemplateState$Resolved) guildTemplateState).getGuildTemplate(), ageGateError));
        } else {
            updateViewState(new WidgetAuthLandingViewModel$ViewState$Empty(ageGateError));
        }
        this.mostRecentStoreState = storeState;
    }

    public final Observable<WidgetAuthLandingViewModel$Event> observeEvents() {
        PublishSubject<WidgetAuthLandingViewModel$Event> publishSubject = this.eventSubject;
        m.checkNotNullExpressionValue(publishSubject, "eventSubject");
        return publishSubject;
    }

    public final void setSmartLockCredentialRequestDisabled(boolean z2) {
        this.smartLockCredentialRequestDisabled = z2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetAuthLandingViewModel(Context context, StoreAuthentication storeAuthentication, StoreAnalytics storeAnalytics, Observable<WidgetAuthLandingViewModel$StoreState> observable, StoreInstantInvites storeInstantInvites, GoogleSmartLockManager googleSmartLockManager) {
        super(new WidgetAuthLandingViewModel$ViewState$Empty(null));
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(storeAuthentication, "storeAuthentication");
        m.checkNotNullParameter(storeAnalytics, "storeAnalytics");
        m.checkNotNullParameter(observable, "storeObservable");
        m.checkNotNullParameter(storeInstantInvites, "storeInstantInvites");
        m.checkNotNullParameter(googleSmartLockManager, "googleSmartLockManager");
        this.storeInstantInvites = storeInstantInvites;
        this.googleSmartLockManager = googleSmartLockManager;
        this.eventSubject = PublishSubject.k0();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observable, this, null, 2, null), WidgetAuthLandingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthLandingViewModel$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(googleSmartLockManager.getSmartLockRepo().getSmartLockLoginObservable(), this, null, 2, null), WidgetAuthLandingViewModel.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthLandingViewModel$2(this), 62, (Object) null);
        storeAuthentication.requestConsentRequired();
        storeAnalytics.appLandingViewed();
    }
}
