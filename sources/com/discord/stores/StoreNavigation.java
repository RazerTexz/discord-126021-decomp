package com.discord.stores;

import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import androidx.appcompat.widget.ActivityChooserModel;
import androidx.fragment.app.FragmentActivity;
import b.d.b.a.outline;
import com.discord.app.AppActivity;
import com.discord.models.authentication.AuthState;
import com.discord.models.requiredaction.RequiredAction;
import com.discord.models.user.MeUser;
import com.discord.panels.PanelState;
import com.discord.stores.StoreInviteSettings;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreNux;
import com.discord.stores.StoreStream;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ActivityLifecycleCallbacks;
import com.discord.utilities.rx.ObservableCombineLatestOverloads2;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.widgets.home.PanelLayout;
import com.discord.widgets.tabs.NavigationTab;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import j0.k.Func1;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.objectweb.asm.Opcodes;
import rx.Observable;
import rx.Subscription;
import rx.subjects.BehaviorSubject;
import rx.subjects.SerializedSubject;

/* JADX INFO: compiled from: StoreNavigation.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreNavigation {
    private final BehaviorSubject<PanelState> leftPanelStateSubject;
    private final SerializedSubject<PanelAction, PanelAction> navigationPanelActionSubject;
    private final BehaviorSubject<PanelState> rightPanelStateSubject;
    private final StoreStream stream;

    /* JADX INFO: compiled from: StoreNavigation.kt */
    public static final class ActivityNavigationLifecycleCallbacks extends ActivityLifecycleCallbacks {
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> ageGateNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> authNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> callNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> clientInitializedNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> clientOutdatedNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> guildTemplateCodeNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> inviteCodeNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> noticeHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> nuxStateNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> oAuthStateHandler;
        private final StoreStream stream;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> tosNavHandler;
        private final Function2<AppActivity, ModelGlobalNavigation, Boolean> verificationNavHandler;

        /* JADX INFO: compiled from: StoreNavigation.kt */
        public static final /* data */ class ModelGlobalNavigation {
            private final AuthState authState;
            private final boolean clientOutdated;
            private final String guildTemplateCode;
            private final boolean incomingCall;
            private final boolean initialized;
            private final StoreInviteSettings.InviteCode inviteCode;
            private final boolean isInitializedForAuthedUser;
            private final NavigationTab navigationTab;
            private final StoreNotices.Notice notice;
            private final StoreNux.NuxState nuxState;
            private final Uri oAuthUri;
            private final AgeGate shouldShowAgeGate;
            private final boolean userHasPhone;
            private final RequiredAction userRequiredAction;

            public ModelGlobalNavigation(StoreNux.NuxState nuxState, boolean z2, AuthState authState, boolean z3, boolean z4, RequiredAction requiredAction, boolean z5, StoreInviteSettings.InviteCode inviteCode, String str, StoreNotices.Notice notice, AgeGate ageGate, Uri uri, NavigationTab navigationTab, boolean z6) {
                Intrinsics3.checkNotNullParameter(nuxState, "nuxState");
                Intrinsics3.checkNotNullParameter(requiredAction, "userRequiredAction");
                Intrinsics3.checkNotNullParameter(uri, "oAuthUri");
                Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
                this.nuxState = nuxState;
                this.initialized = z2;
                this.authState = authState;
                this.isInitializedForAuthedUser = z3;
                this.incomingCall = z4;
                this.userRequiredAction = requiredAction;
                this.clientOutdated = z5;
                this.inviteCode = inviteCode;
                this.guildTemplateCode = str;
                this.notice = notice;
                this.shouldShowAgeGate = ageGate;
                this.oAuthUri = uri;
                this.navigationTab = navigationTab;
                this.userHasPhone = z6;
            }

            /* JADX INFO: renamed from: component1, reason: from getter */
            public final StoreNux.NuxState getNuxState() {
                return this.nuxState;
            }

            /* JADX INFO: renamed from: component10, reason: from getter */
            public final StoreNotices.Notice getNotice() {
                return this.notice;
            }

            /* JADX INFO: renamed from: component11, reason: from getter */
            public final AgeGate getShouldShowAgeGate() {
                return this.shouldShowAgeGate;
            }

            /* JADX INFO: renamed from: component12, reason: from getter */
            public final Uri getOAuthUri() {
                return this.oAuthUri;
            }

            /* JADX INFO: renamed from: component13, reason: from getter */
            public final NavigationTab getNavigationTab() {
                return this.navigationTab;
            }

            /* JADX INFO: renamed from: component14, reason: from getter */
            public final boolean getUserHasPhone() {
                return this.userHasPhone;
            }

            /* JADX INFO: renamed from: component2, reason: from getter */
            public final boolean getInitialized() {
                return this.initialized;
            }

            /* JADX INFO: renamed from: component3, reason: from getter */
            public final AuthState getAuthState() {
                return this.authState;
            }

            /* JADX INFO: renamed from: component4, reason: from getter */
            public final boolean getIsInitializedForAuthedUser() {
                return this.isInitializedForAuthedUser;
            }

            /* JADX INFO: renamed from: component5, reason: from getter */
            public final boolean getIncomingCall() {
                return this.incomingCall;
            }

            /* JADX INFO: renamed from: component6, reason: from getter */
            public final RequiredAction getUserRequiredAction() {
                return this.userRequiredAction;
            }

            /* JADX INFO: renamed from: component7, reason: from getter */
            public final boolean getClientOutdated() {
                return this.clientOutdated;
            }

            /* JADX INFO: renamed from: component8, reason: from getter */
            public final StoreInviteSettings.InviteCode getInviteCode() {
                return this.inviteCode;
            }

            /* JADX INFO: renamed from: component9, reason: from getter */
            public final String getGuildTemplateCode() {
                return this.guildTemplateCode;
            }

            public final ModelGlobalNavigation copy(StoreNux.NuxState nuxState, boolean initialized, AuthState authState, boolean isInitializedForAuthedUser, boolean incomingCall, RequiredAction userRequiredAction, boolean clientOutdated, StoreInviteSettings.InviteCode inviteCode, String guildTemplateCode, StoreNotices.Notice notice, AgeGate shouldShowAgeGate, Uri oAuthUri, NavigationTab navigationTab, boolean userHasPhone) {
                Intrinsics3.checkNotNullParameter(nuxState, "nuxState");
                Intrinsics3.checkNotNullParameter(userRequiredAction, "userRequiredAction");
                Intrinsics3.checkNotNullParameter(oAuthUri, "oAuthUri");
                Intrinsics3.checkNotNullParameter(navigationTab, "navigationTab");
                return new ModelGlobalNavigation(nuxState, initialized, authState, isInitializedForAuthedUser, incomingCall, userRequiredAction, clientOutdated, inviteCode, guildTemplateCode, notice, shouldShowAgeGate, oAuthUri, navigationTab, userHasPhone);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof ModelGlobalNavigation)) {
                    return false;
                }
                ModelGlobalNavigation modelGlobalNavigation = (ModelGlobalNavigation) other;
                return Intrinsics3.areEqual(this.nuxState, modelGlobalNavigation.nuxState) && this.initialized == modelGlobalNavigation.initialized && Intrinsics3.areEqual(this.authState, modelGlobalNavigation.authState) && this.isInitializedForAuthedUser == modelGlobalNavigation.isInitializedForAuthedUser && this.incomingCall == modelGlobalNavigation.incomingCall && Intrinsics3.areEqual(this.userRequiredAction, modelGlobalNavigation.userRequiredAction) && this.clientOutdated == modelGlobalNavigation.clientOutdated && Intrinsics3.areEqual(this.inviteCode, modelGlobalNavigation.inviteCode) && Intrinsics3.areEqual(this.guildTemplateCode, modelGlobalNavigation.guildTemplateCode) && Intrinsics3.areEqual(this.notice, modelGlobalNavigation.notice) && Intrinsics3.areEqual(this.shouldShowAgeGate, modelGlobalNavigation.shouldShowAgeGate) && Intrinsics3.areEqual(this.oAuthUri, modelGlobalNavigation.oAuthUri) && Intrinsics3.areEqual(this.navigationTab, modelGlobalNavigation.navigationTab) && this.userHasPhone == modelGlobalNavigation.userHasPhone;
            }

            public final AuthState getAuthState() {
                return this.authState;
            }

            public final boolean getClientOutdated() {
                return this.clientOutdated;
            }

            public final String getGuildTemplateCode() {
                return this.guildTemplateCode;
            }

            public final boolean getIncomingCall() {
                return this.incomingCall;
            }

            public final boolean getInitialized() {
                return this.initialized;
            }

            public final StoreInviteSettings.InviteCode getInviteCode() {
                return this.inviteCode;
            }

            public final NavigationTab getNavigationTab() {
                return this.navigationTab;
            }

            public final StoreNotices.Notice getNotice() {
                return this.notice;
            }

            public final StoreNux.NuxState getNuxState() {
                return this.nuxState;
            }

            public final Uri getOAuthUri() {
                return this.oAuthUri;
            }

            public final AgeGate getShouldShowAgeGate() {
                return this.shouldShowAgeGate;
            }

            public final boolean getUserHasPhone() {
                return this.userHasPhone;
            }

            public final RequiredAction getUserRequiredAction() {
                return this.userRequiredAction;
            }

            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v28, types: [int] */
            /* JADX WARN: Type inference failed for: r0v4, types: [int] */
            /* JADX WARN: Type inference failed for: r2v1, types: [int] */
            /* JADX WARN: Type inference failed for: r2v13, types: [int] */
            /* JADX WARN: Type inference failed for: r2v35 */
            /* JADX WARN: Type inference failed for: r2v37 */
            /* JADX WARN: Type inference failed for: r2v38 */
            /* JADX WARN: Type inference failed for: r2v40 */
            /* JADX WARN: Type inference failed for: r2v41 */
            /* JADX WARN: Type inference failed for: r2v42 */
            /* JADX WARN: Type inference failed for: r2v43 */
            /* JADX WARN: Type inference failed for: r2v44 */
            /* JADX WARN: Type inference failed for: r2v6, types: [int] */
            /* JADX WARN: Type inference failed for: r2v8, types: [int] */
            /* JADX WARN: Type inference failed for: r3v0 */
            /* JADX WARN: Type inference failed for: r3v1, types: [int] */
            /* JADX WARN: Type inference failed for: r3v2 */
            public int hashCode() {
                StoreNux.NuxState nuxState = this.nuxState;
                int iHashCode = (nuxState != null ? nuxState.hashCode() : 0) * 31;
                boolean z2 = this.initialized;
                ?? r2 = z2;
                if (z2) {
                    r2 = 1;
                }
                int i = (iHashCode + r2) * 31;
                AuthState authState = this.authState;
                int iHashCode2 = (i + (authState != null ? authState.hashCode() : 0)) * 31;
                boolean z3 = this.isInitializedForAuthedUser;
                ?? r3 = z3;
                if (z3) {
                    r3 = 1;
                }
                int i2 = (iHashCode2 + r3) * 31;
                boolean z4 = this.incomingCall;
                ?? r4 = z4;
                if (z4) {
                    r4 = 1;
                }
                int i3 = (i2 + r4) * 31;
                RequiredAction requiredAction = this.userRequiredAction;
                int iHashCode3 = (i3 + (requiredAction != null ? requiredAction.hashCode() : 0)) * 31;
                boolean z5 = this.clientOutdated;
                ?? r5 = z5;
                if (z5) {
                    r5 = 1;
                }
                int i4 = (iHashCode3 + r5) * 31;
                StoreInviteSettings.InviteCode inviteCode = this.inviteCode;
                int iHashCode4 = (i4 + (inviteCode != null ? inviteCode.hashCode() : 0)) * 31;
                String str = this.guildTemplateCode;
                int iHashCode5 = (iHashCode4 + (str != null ? str.hashCode() : 0)) * 31;
                StoreNotices.Notice notice = this.notice;
                int iHashCode6 = (iHashCode5 + (notice != null ? notice.hashCode() : 0)) * 31;
                AgeGate ageGate = this.shouldShowAgeGate;
                int iHashCode7 = (iHashCode6 + (ageGate != null ? ageGate.hashCode() : 0)) * 31;
                Uri uri = this.oAuthUri;
                int iHashCode8 = (iHashCode7 + (uri != null ? uri.hashCode() : 0)) * 31;
                NavigationTab navigationTab = this.navigationTab;
                int iHashCode9 = (iHashCode8 + (navigationTab != null ? navigationTab.hashCode() : 0)) * 31;
                boolean z6 = this.userHasPhone;
                return iHashCode9 + (z6 ? 1 : z6);
            }

            public final boolean isInitializedForAuthedUser() {
                return this.isInitializedForAuthedUser;
            }

            public String toString() {
                StringBuilder sbU = outline.U("ModelGlobalNavigation(nuxState=");
                sbU.append(this.nuxState);
                sbU.append(", initialized=");
                sbU.append(this.initialized);
                sbU.append(", authState=");
                sbU.append(this.authState);
                sbU.append(", isInitializedForAuthedUser=");
                sbU.append(this.isInitializedForAuthedUser);
                sbU.append(", incomingCall=");
                sbU.append(this.incomingCall);
                sbU.append(", userRequiredAction=");
                sbU.append(this.userRequiredAction);
                sbU.append(", clientOutdated=");
                sbU.append(this.clientOutdated);
                sbU.append(", inviteCode=");
                sbU.append(this.inviteCode);
                sbU.append(", guildTemplateCode=");
                sbU.append(this.guildTemplateCode);
                sbU.append(", notice=");
                sbU.append(this.notice);
                sbU.append(", shouldShowAgeGate=");
                sbU.append(this.shouldShowAgeGate);
                sbU.append(", oAuthUri=");
                sbU.append(this.oAuthUri);
                sbU.append(", navigationTab=");
                sbU.append(this.navigationTab);
                sbU.append(", userHasPhone=");
                return outline.O(sbU, this.userHasPhone, ")");
            }
        }

        public ActivityNavigationLifecycleCallbacks(StoreStream storeStream) {
            Intrinsics3.checkNotNullParameter(storeStream, "stream");
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

        private final Observable<ModelGlobalNavigation> getGlobalNavigationData() {
            Observable<StoreNux.NuxState> nuxState = this.stream.getNux().getNuxState();
            Observable<Boolean> observableIsInitializedObservable = StoreStream.INSTANCE.isInitializedObservable();
            Observable<AuthState> observableM8getAuthState$app_productionGoogleRelease = this.stream.getAuthentication().m8getAuthState$app_productionGoogleRelease();
            Observable<Boolean> observableObserveInitializedForAuthedUser = this.stream.getChannelsSelected().observeInitializedForAuthedUser();
            Observable<Boolean> observableObserveHasIncoming = this.stream.getCallsIncoming().observeHasIncoming();
            Observable<RequiredAction> observableObserveUserRequiredAction = this.stream.getUserRequiredAction().observeUserRequiredAction();
            Observable<Boolean> clientOutdated = this.stream.getClientVersion().getClientOutdated();
            Observable<StoreInviteSettings.InviteCode> inviteCode = this.stream.getGuildInvite().getInviteCode();
            Observable<String> observableObserveDynamicLinkGuildTemplateCode = this.stream.getGuildTemplates().observeDynamicLinkGuildTemplateCode();
            Observable<StoreNotices.Notice> notices = this.stream.getNotices().getNotices();
            Observable<AgeGate> shouldShowAgeGate = this.stream.getAuthentication().getShouldShowAgeGate();
            Observable<Uri> oAuthUriObservable = this.stream.getAuthentication().getOAuthUriObservable();
            Observable<NavigationTab> observableObserveSelectedTab = this.stream.getTabsNavigation().observeSelectedTab();
            Observable<R> observableG = this.stream.getUsers().observeMe(true).G(new Func1<MeUser, Boolean>() { // from class: com.discord.stores.StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$1
                @Override // j0.k.Func1
                public final Boolean call(MeUser meUser) {
                    UserUtils userUtils = UserUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(meUser, "me");
                    return Boolean.valueOf(userUtils.getHasPhone(meUser));
                }
            });
            Intrinsics3.checkNotNullExpressionValue(observableG, "stream\n              .us….hasPhone\n              }");
            Observable<ModelGlobalNavigation> observableR = ObservableExtensionsKt.computationLatest(ObservableExtensionsKt.leadingEdgeThrottle(ObservableCombineLatestOverloads2.combineLatest(nuxState, observableIsInitializedObservable, observableM8getAuthState$app_productionGoogleRelease, observableObserveInitializedForAuthedUser, observableObserveHasIncoming, observableObserveUserRequiredAction, clientOutdated, inviteCode, observableObserveDynamicLinkGuildTemplateCode, notices, shouldShowAgeGate, oAuthUriObservable, observableObserveSelectedTab, observableG, StoreNavigation$ActivityNavigationLifecycleCallbacks$getGlobalNavigationData$2.INSTANCE), 500L, TimeUnit.MILLISECONDS)).r();
            Intrinsics3.checkNotNullExpressionValue(observableR, "combineLatest(\n         …  .distinctUntilChanged()");
            return observableR;
        }

        private final void handleGlobalNavigationData(AppActivity appActivity, ModelGlobalNavigation modelGlobalNavigation) {
            Iterator it = Collections2.listOf((Object[]) new Function2[]{this.clientInitializedNavHandler, this.clientOutdatedNavHandler, this.authNavHandler, this.tosNavHandler, this.ageGateNavHandler, this.verificationNavHandler, this.callNavHandler, this.inviteCodeNavHandler, this.guildTemplateCodeNavHandler, this.nuxStateNavHandler, this.oAuthStateHandler, this.noticeHandler}).iterator();
            while (it.hasNext() && !((Boolean) ((Function2) it.next()).invoke(appActivity, modelGlobalNavigation)).booleanValue()) {
            }
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getAgeGateNavHandler() {
            return this.ageGateNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getAuthNavHandler() {
            return this.authNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getCallNavHandler() {
            return this.callNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getClientInitializedNavHandler() {
            return this.clientInitializedNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getClientOutdatedNavHandler() {
            return this.clientOutdatedNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getGuildTemplateCodeNavHandler() {
            return this.guildTemplateCodeNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getInviteCodeNavHandler() {
            return this.inviteCodeNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getNoticeHandler() {
            return this.noticeHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getNuxStateNavHandler() {
            return this.nuxStateNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getOAuthStateHandler() {
            return this.oAuthStateHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getTosNavHandler() {
            return this.tosNavHandler;
        }

        public final Function2<AppActivity, ModelGlobalNavigation, Boolean> getVerificationNavHandler() {
            return this.verificationNavHandler;
        }

        /* JADX WARN: Code duplicated, block: B:9:0x0031  */
        @Override // com.discord.utilities.rx.ActivityLifecycleCallbacks
        public void onActivityCreatedOrResumed(AppActivity activity) {
            boolean z2;
            Intrinsics3.checkNotNullParameter(activity, ActivityChooserModel.ATTRIBUTE_ACTIVITY);
            super.onActivityCreatedOrResumed(activity);
            if (activity.isTaskRoot() || !activity.getIntent().hasCategory("android.intent.category.LAUNCHER")) {
                z2 = false;
            } else {
                Intent intent = activity.getIntent();
                Intrinsics3.checkNotNullExpressionValue(intent, "activity.intent");
                if (Intrinsics3.areEqual(intent.getAction(), "android.intent.action.MAIN")) {
                    z2 = true;
                } else {
                    z2 = false;
                }
            }
            if (z2) {
                activity.finish();
            } else {
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getGlobalNavigationData(), activity, null, 2, null), (Class<?>) ActivityNavigationLifecycleCallbacks.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new StoreNavigation$ActivityNavigationLifecycleCallbacks$onActivityCreatedOrResumed$1(this, activity));
            }
        }
    }

    /* JADX INFO: compiled from: StoreNavigation.kt */
    public enum AgeGate {
        REGISTER_AGE_GATE,
        NSFW_CHANNEL_AGE_GATE
    }

    /* JADX INFO: compiled from: StoreNavigation.kt */
    public enum PanelAction {
        NOOP,
        OPEN,
        CLOSE,
        UNLOCK_LEFT
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            PanelAction.values();
            int[] iArr = new int[4];
            $EnumSwitchMapping$0 = iArr;
            iArr[PanelAction.OPEN.ordinal()] = 1;
            iArr[PanelAction.CLOSE.ordinal()] = 2;
        }
    }

    public StoreNavigation(StoreStream storeStream) {
        Intrinsics3.checkNotNullParameter(storeStream, "stream");
        this.stream = storeStream;
        this.navigationPanelActionSubject = new SerializedSubject<>(BehaviorSubject.l0(PanelAction.NOOP));
        PanelState.a aVar = PanelState.a.a;
        this.leftPanelStateSubject = BehaviorSubject.l0(aVar);
        this.rightPanelStateSubject = BehaviorSubject.l0(aVar);
    }

    public static /* synthetic */ void setNavigationPanelAction$default(StoreNavigation storeNavigation, PanelAction panelAction, PanelLayout panelLayout, int i, Object obj) {
        if ((i & 2) != 0) {
            panelLayout = null;
        }
        storeNavigation.setNavigationPanelAction(panelAction, panelLayout);
    }

    public final Observable<PanelAction> getNavigationPanelAction() {
        Observable<PanelAction> observableR = ObservableExtensionsKt.computationLatest(this.navigationPanelActionSubject).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "navigationPanelActionSub…  .distinctUntilChanged()");
        return observableR;
    }

    @Store3
    public final void handleHomeTabSelected(PanelAction panelAction) {
        Intrinsics3.checkNotNullParameter(panelAction, "panelAction");
        setNavigationPanelAction$default(this, panelAction, null, 2, null);
    }

    public final void init(Application application) {
        Intrinsics3.checkNotNullParameter(application, "application");
        application.registerActivityLifecycleCallbacks(new ActivityNavigationLifecycleCallbacks(this.stream));
    }

    public final void launchNotice(String noticeName, Function1<? super FragmentActivity, Boolean> showAction) {
        Intrinsics3.checkNotNullParameter(noticeName, "noticeName");
        Intrinsics3.checkNotNullParameter(showAction, "showAction");
        StoreNotices.Notice notice = new StoreNotices.Notice(noticeName, null, 0L, 0, false, null, 0L, false, 0L, new StoreNavigation$launchNotice$notice$1(noticeName, showAction), Opcodes.I2F, null);
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getNotices().markInAppSeen();
        companion.getNotices().requestToShow(notice);
    }

    public final Observable<PanelState> observeLeftPanelState() {
        Observable<PanelState> observableR = this.leftPanelStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "leftPanelStateSubject.distinctUntilChanged()");
        return observableR;
    }

    public final Observable<PanelState> observeRightPanelState() {
        Observable<PanelState> observableR = this.rightPanelStateSubject.r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "rightPanelStateSubject.distinctUntilChanged()");
        return observableR;
    }

    public final void setLeftPanelState(PanelState panelState) {
        Intrinsics3.checkNotNullParameter(panelState, "panelState");
        this.leftPanelStateSubject.onNext(panelState);
    }

    public final void setNavigationPanelAction(PanelAction panelAction) {
        setNavigationPanelAction$default(this, panelAction, null, 2, null);
    }

    public final void setNavigationPanelAction(PanelAction actionType, PanelLayout panelLayout) {
        Intrinsics3.checkNotNullParameter(actionType, "actionType");
        if (panelLayout == null) {
            this.navigationPanelActionSubject.k.onNext(actionType);
            return;
        }
        int iOrdinal = actionType.ordinal();
        if (iOrdinal == 1) {
            panelLayout.openStartPanel();
        } else if (iOrdinal == 2) {
            panelLayout.closePanels();
        }
        SerializedSubject<PanelAction, PanelAction> serializedSubject = this.navigationPanelActionSubject;
        serializedSubject.k.onNext(PanelAction.NOOP);
    }

    public final void setRightPanelState(PanelState panelState) {
        Intrinsics3.checkNotNullParameter(panelState, "panelState");
        this.rightPanelStateSubject.onNext(panelState);
    }
}
