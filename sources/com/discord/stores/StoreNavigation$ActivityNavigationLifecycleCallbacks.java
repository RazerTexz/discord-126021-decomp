package com.discord.stores;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import com.discord.app.AppActivity;
import com.discord.models.authentication.AuthState;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableCombineLatestOverloadsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.tabs.NavigationTab;
import d0.t.n;
import d0.z.d.m;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import rx.Observable;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation$ActivityNavigationLifecycleCallbacks extends ActivityLifecycleCallbacks {
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> ageGateNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> authNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> callNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> clientInitializedNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> clientOutdatedNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> guildTemplateCodeNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> inviteCodeNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> noticeHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> nuxStateNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> oAuthStateHandler;
    private final StoreStream stream;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> tosNavHandler;
    private final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> verificationNavHandler;

    public StoreNavigation$ActivityNavigationLifecycleCallbacks(StoreStream storeStream) {
        m.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.clientInitializedNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$clientInitializedNavHandler$1.INSTANCE;
        this.clientOutdatedNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$clientOutdatedNavHandler$1.INSTANCE;
        this.authNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$authNavHandler$1.INSTANCE;
        this.tosNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$tosNavHandler$1.INSTANCE;
        this.ageGateNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$ageGateNavHandler$1.INSTANCE;
        this.verificationNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$verificationNavHandler$1.INSTANCE;
        this.callNavHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$callNavHandler$1.INSTANCE;
        this.inviteCodeNavHandler = new StoreNavigation$ActivityNavigationLifecycleCallbacks$inviteCodeNavHandler$1(this);
        this.guildTemplateCodeNavHandler = new StoreNavigation$ActivityNavigationLifecycleCallbacks$guildTemplateCodeNavHandler$1(this);
        this.nuxStateNavHandler = new StoreNavigation$ActivityNavigationLifecycleCallbacks$nuxStateNavHandler$1(this);
        this.oAuthStateHandler = new StoreNavigation$ActivityNavigationLifecycleCallbacks$oAuthStateHandler$1(this);
        this.noticeHandler = StoreNavigation$ActivityNavigationLifecycleCallbacks$noticeHandler$1.INSTANCE;
    }

    public static final /* synthetic */ StoreStream access$getStream$p(StoreNavigation$ActivityNavigationLifecycleCallbacks storeNavigation$ActivityNavigationLifecycleCallbacks) {
        return storeNavigation$ActivityNavigationLifecycleCallbacks.stream;
    }

    public static final /* synthetic */ void access$handleGlobalNavigationData(StoreNavigation$ActivityNavigationLifecycleCallbacks storeNavigation$ActivityNavigationLifecycleCallbacks, AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        storeNavigation$ActivityNavigationLifecycleCallbacks.handleGlobalNavigationData(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation);
    }

    private final Observable<StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation> getGlobalNavigationData() {
        Observable<StoreNux$NuxState> nuxState = this.stream.getNux().getNuxState();
        Observable<Boolean> observableIsInitializedObservable = StoreStream.Companion.isInitializedObservable();
        Observable<AuthState> observableM8getAuthState$app_productionGoogleRelease = this.stream.getAuthentication().m8getAuthState$app_productionGoogleRelease();
        Observable<Boolean> observableObserveInitializedForAuthedUser = this.stream.getChannelsSelected().observeInitializedForAuthedUser();
        Observable<Boolean> observableObserveHasIncoming = this.stream.getCallsIncoming().observeHasIncoming();
        Observable<RequiredAction> observableObserveUserRequiredAction = this.stream.getUserRequiredAction().observeUserRequiredAction();
        Observable<Boolean> clientOutdated = this.stream.getClientVersion().getClientOutdated();
        Observable<StoreInviteSettings$InviteCode> inviteCode = this.stream.getGuildInvite().getInviteCode();
        Observable<String> observableObserveDynamicLinkGuildTemplateCode = this.stream.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
        Observable<StoreNotices$Notice> notices = this.stream.getNotices().getNotices();
        Observable<StoreNavigation$AgeGate> shouldShowAgeGate = this.stream.getAuthentication().getShouldShowAgeGate();
        Observable<Uri> oAuthUriObservable = this.stream.getAuthentication().getOAuthUriObservable();
        Observable<NavigationTab> observableObserveSelectedTab = this.stream.getTabsNavigation().observeSelectedTab();
        Observable<R> observableG = this.stream.getUsers().observeMe(true).G(StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1.INSTANCE);
        m.checkNotNullExpressionValue(observableG, "stream\n              .us….hasPhone\n              }");
        Observable<StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation> observableR = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(ObservableCombineLatestOverloadsKt.combineLatest(nuxState, observableIsInitializedObservable, observableM8getAuthState$app_productionGoogleRelease, observableObserveInitializedForAuthedUser, observableObserveHasIncoming, observableObserveUserRequiredAction, clientOutdated, inviteCode, observableObserveDynamicLinkGuildTemplateCode, notices, shouldShowAgeGate, oAuthUriObservable, observableObserveSelectedTab, observableG, StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2.INSTANCE), 500L, TimeUnit.MILLISECONDS)).r();
        m.checkNotNullExpressionValue(observableR, "combineLatest(\n         …  .distinctUntilChanged()");
        return observableR;
    }

    private final void handleGlobalNavigationData(AppActivity appActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation) {
        Iterator it = n.listOf((Object[]) new Function2[]{this.clientInitializedNavHandler, this.clientOutdatedNavHandler, this.authNavHandler, this.tosNavHandler, this.ageGateNavHandler, this.verificationNavHandler, this.callNavHandler, this.inviteCodeNavHandler, this.guildTemplateCodeNavHandler, this.nuxStateNavHandler, this.oAuthStateHandler, this.noticeHandler}).iterator();
        while (it.hasNext() && !((Boolean) ((Function2) it.next()).invoke(appActivity, storeNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation)).booleanValue()) {
        }
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getAgeGateNavHandler() {
        return this.ageGateNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getAuthNavHandler() {
        return this.authNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getCallNavHandler() {
        return this.callNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getClientInitializedNavHandler() {
        return this.clientInitializedNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getClientOutdatedNavHandler() {
        return this.clientOutdatedNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getGuildTemplateCodeNavHandler() {
        return this.guildTemplateCodeNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getInviteCodeNavHandler() {
        return this.inviteCodeNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getNoticeHandler() {
        return this.noticeHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getNuxStateNavHandler() {
        return this.nuxStateNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getOAuthStateHandler() {
        return this.oAuthStateHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getTosNavHandler() {
        return this.tosNavHandler;
    }

    public final Function2<AppActivity, StoreNavigation$ActivityNavigationLifecycleCallbacks$ModelGlobalNavigation, Boolean> getVerificationNavHandler() {
        return this.verificationNavHandler;
    }

    /* JADX WARN: Code duplicated, block: B:9:0x0031  */
    @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
    public void onActivityCreatedOrResumed(AppActivity activity) {
        boolean z2;
        m.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
        super.onActivityCreatedOrResumed(activity);
        if (activity.isTaskRoot() || !activity.getIntent().hasCategory("android.intent.category.LAUNCHER")) {
            z2 = false;
        } else {
            Intent intent = activity.getIntent();
            m.checkNotNullExpressionValue(intent, "activity.intent");
            if (m.areEqual(intent.getAction(), "android.intent.action.MAIN")) {
                z2 = true;
            } else {
                z2 = false;
            }
        }
        if (z2) {
            activity.finish();
        } else {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getGlobalNavigationData(), activity, null, 2, null), StoreNavigation$ActivityNavigationLifecycleCallbacks.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1(this, activity), 62, (Object) null);
        }
    }
}
