package com.discord.widgets.settings;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.o;
import b.a.i.WidgetSettingsPrivacyDefaultsBinding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsPrivacyBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelUserConsents2;
import com.discord.models.domain.ModelUserConsents3;
import com.discord.models.domain.ModelUserSettings;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.restapi.RestAPIParams;
import com.discord.restapi.utils.RetryWithDelay;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.stores.StoreUserSettings;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.WidgetSettingsPrivacy;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.t.Sets5;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import j0.k.Func1;
import j0.l.e.ScalarSynchronousObservable;
import j0.p.Schedulers2;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;
import rx.functions.Func3;
import rx.functions.Func7;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsPrivacy.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private AlertDialog dialog;

    /* JADX INFO: renamed from: explicitContentRadios$delegate, reason: from kotlin metadata */
    private final Lazy explicitContentRadios;

    /* JADX INFO: renamed from: friendSourceRadios$delegate, reason: from kotlin metadata */
    private final Lazy friendSourceRadios;
    private RadioManager radioManagerExplicit;
    private final StoreUserSettings userSettings;

    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context) {
            Intrinsics3.checkNotNullParameter(context, "context");
            AppScreen2.e(context, WidgetSettingsPrivacy.class, null, 4);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final /* data */ class LocalState {
        private final ConnectedAccount contactSyncConnection;
        private final Experiment contactSyncExperiment;
        private final boolean defaultRestrictedGuilds;
        private final int explicitContentFilter;
        private final ModelUserSettings.FriendSourceFlags friendSourceFlags;
        private final MeUser me;
        private final int userDiscoveryFlags;

        public LocalState(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            this.me = meUser;
            this.explicitContentFilter = i;
            this.defaultRestrictedGuilds = z2;
            this.friendSourceFlags = friendSourceFlags;
            this.contactSyncConnection = connectedAccount;
            this.contactSyncExperiment = experiment;
            this.userDiscoveryFlags = i2;
        }

        public static /* synthetic */ LocalState copy$default(LocalState localState, MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount connectedAccount, Experiment experiment, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                meUser = localState.me;
            }
            if ((i3 & 2) != 0) {
                i = localState.explicitContentFilter;
            }
            int i4 = i;
            if ((i3 & 4) != 0) {
                z2 = localState.defaultRestrictedGuilds;
            }
            boolean z3 = z2;
            if ((i3 & 8) != 0) {
                friendSourceFlags = localState.friendSourceFlags;
            }
            ModelUserSettings.FriendSourceFlags friendSourceFlags2 = friendSourceFlags;
            if ((i3 & 16) != 0) {
                connectedAccount = localState.contactSyncConnection;
            }
            ConnectedAccount connectedAccount2 = connectedAccount;
            if ((i3 & 32) != 0) {
                experiment = localState.contactSyncExperiment;
            }
            Experiment experiment2 = experiment;
            if ((i3 & 64) != 0) {
                i2 = localState.userDiscoveryFlags;
            }
            return localState.copy(meUser, i4, z3, friendSourceFlags2, connectedAccount2, experiment2, i2);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final Experiment getContactSyncExperiment() {
            return this.contactSyncExperiment;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        public final LocalState copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings.FriendSourceFlags friendSourceFlags, ConnectedAccount contactSyncConnection, Experiment contactSyncExperiment, int userDiscoveryFlags) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            return new LocalState(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, contactSyncConnection, contactSyncExperiment, userDiscoveryFlags);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof LocalState)) {
                return false;
            }
            LocalState localState = (LocalState) other;
            return Intrinsics3.areEqual(this.me, localState.me) && this.explicitContentFilter == localState.explicitContentFilter && this.defaultRestrictedGuilds == localState.defaultRestrictedGuilds && Intrinsics3.areEqual(this.friendSourceFlags, localState.friendSourceFlags) && Intrinsics3.areEqual(this.contactSyncConnection, localState.contactSyncConnection) && Intrinsics3.areEqual(this.contactSyncExperiment, localState.contactSyncExperiment) && this.userDiscoveryFlags == localState.userDiscoveryFlags;
        }

        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final Experiment getContactSyncExperiment() {
            return this.contactSyncExperiment;
        }

        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v12 */
        /* JADX WARN: Type inference failed for: r2v13 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (((meUser != null ? meUser.hashCode() : 0) * 31) + this.explicitContentFilter) * 31;
            boolean z2 = this.defaultRestrictedGuilds;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            ModelUserSettings.FriendSourceFlags friendSourceFlags = this.friendSourceFlags;
            int iHashCode2 = (i + (friendSourceFlags != null ? friendSourceFlags.hashCode() : 0)) * 31;
            ConnectedAccount connectedAccount = this.contactSyncConnection;
            int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
            Experiment experiment = this.contactSyncExperiment;
            return ((iHashCode3 + (experiment != null ? experiment.hashCode() : 0)) * 31) + this.userDiscoveryFlags;
        }

        public String toString() {
            StringBuilder sbU = outline.U("LocalState(me=");
            sbU.append(this.me);
            sbU.append(", explicitContentFilter=");
            sbU.append(this.explicitContentFilter);
            sbU.append(", defaultRestrictedGuilds=");
            sbU.append(this.defaultRestrictedGuilds);
            sbU.append(", friendSourceFlags=");
            sbU.append(this.friendSourceFlags);
            sbU.append(", contactSyncConnection=");
            sbU.append(this.contactSyncConnection);
            sbU.append(", contactSyncExperiment=");
            sbU.append(this.contactSyncExperiment);
            sbU.append(", userDiscoveryFlags=");
            return outline.B(sbU, this.userDiscoveryFlags, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ModelUserConsents2 consents;
        private final ConnectedAccount contactSyncConnection;
        private final boolean defaultRestrictedGuilds;
        private final int explicitContentFilter;
        private final ModelUserSettings.FriendSourceFlags friendSourceFlags;
        private final RestAPI.HarvestState harvestState;
        private final MeUser me;
        private final boolean showContactSync;
        private final int userDiscoveryFlags;

        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable observableObserveMe$default = StoreUser.observeMe$default(companion.getUsers(), false, 1, null);
                Observable<Integer> observableObserveExplicitContentFilter = companion.getUserSettings().observeExplicitContentFilter();
                Observable<Boolean> observableObserveIsDefaultGuildsRestricted = companion.getUserSettings().observeIsDefaultGuildsRestricted();
                Observable<ModelUserSettings.FriendSourceFlags> observableObserveFriendSourceFlags = companion.getUserSettings().observeFriendSourceFlags();
                Observable<R> observableG = companion.getUserConnections().observeConnectedAccounts().G(new Func1<StoreUserConnections.State, ConnectedAccount>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$1
                    @Override // j0.k.Func1
                    public final ConnectedAccount call(StoreUserConnections.State state) {
                        ConnectedAccount connectedAccountPrevious;
                        Intrinsics3.checkNotNullExpressionValue(state, "accounts");
                        ListIterator<ConnectedAccount> listIterator = state.listIterator(state.size());
                        while (listIterator.hasPrevious()) {
                            connectedAccountPrevious = listIterator.previous();
                            if (Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts")) {
                                return connectedAccountPrevious;
                            }
                        }
                        connectedAccountPrevious = null;
                        return connectedAccountPrevious;
                    }
                });
                Observable<Experiment> observableObserveUserExperiment = companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true);
                Observable<Integer> observableObserveFriendDiscoveryFlags = companion.getUserSettings().observeFriendDiscoveryFlags();
                final WidgetSettingsPrivacy$Model$Companion$get$2 widgetSettingsPrivacy$Model$Companion$get$2 = WidgetSettingsPrivacy$Model$Companion$get$2.INSTANCE;
                Object obj = widgetSettingsPrivacy$Model$Companion$get$2;
                if (widgetSettingsPrivacy$Model$Companion$get$2 != null) {
                    obj = new Func7() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$sam$rx_functions_Func7$0
                        @Override // rx.functions.Func7
                        public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                            return widgetSettingsPrivacy$Model$Companion$get$2.invoke(obj2, obj3, obj4, obj5, obj6, obj7, obj8);
                        }
                    };
                }
                Observable observableY = Observable.e(observableObserveMe$default, observableObserveExplicitContentFilter, observableObserveIsDefaultGuildsRestricted, observableObserveFriendSourceFlags, observableG, observableObserveUserExperiment, observableObserveFriendDiscoveryFlags, (Func7) obj).Y(new Func1<LocalState, Observable<? extends Model>>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3
                    @Override // j0.k.Func1
                    public final Observable<? extends WidgetSettingsPrivacy.Model> call(WidgetSettingsPrivacy.LocalState localState) {
                        ScalarSynchronousObservable scalarSynchronousObservable = new ScalarSynchronousObservable(localState);
                        StoreStream.Companion companion2 = StoreStream.INSTANCE;
                        return Observable.i(scalarSynchronousObservable, companion2.getUserSettings().observeConsents(), Observable.I(new ScalarSynchronousObservable(null), StoreUser.observeMe$default(companion2.getUsers(), false, 1, null).y(new Func1<MeUser, Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3.1
                            @Override // j0.k.Func1
                            public final Boolean call(MeUser meUser) {
                                return Boolean.valueOf(meUser.isVerified());
                            }
                        }).A(new Func1<MeUser, Observable<? extends RestAPI.HarvestState>>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3.2
                            @Override // j0.k.Func1
                            public final Observable<? extends RestAPI.HarvestState> call(MeUser meUser) {
                                RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
                                Observable<RestAPI.HarvestState> observableJ = RestAPI.INSTANCE.getApi().getHarvestStatusGuarded().J(Schedulers2.c());
                                Intrinsics3.checkNotNullExpressionValue(observableJ, "RestAPI\n                …bserveOn(Schedulers.io())");
                                return RetryWithDelay.restRetry$default(retryWithDelay, observableJ, 0L, null, null, 7, null).q(500L, TimeUnit.MILLISECONDS).M(new Func1<Throwable, RestAPI.HarvestState>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.Model.Companion.get.3.2.1
                                    @Override // j0.k.Func1
                                    public final RestAPI.HarvestState call(Throwable th) {
                                        return new RestAPI.HarvestState.NeverRequested();
                                    }
                                });
                            }
                        })), new Func3<WidgetSettingsPrivacy.LocalState, ModelUserConsents2, RestAPI.HarvestState, WidgetSettingsPrivacy.Model>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3.3
                            @Override // rx.functions.Func3
                            public final WidgetSettingsPrivacy.Model call(WidgetSettingsPrivacy.LocalState localState2, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
                                ConnectedAccount contactSyncConnection = localState2.getContactSyncConnection();
                                Experiment contactSyncExperiment = localState2.getContactSyncExperiment();
                                boolean z2 = contactSyncExperiment != null && contactSyncExperiment.getBucket() == 1;
                                MeUser me2 = localState2.getMe();
                                int explicitContentFilter = localState2.getExplicitContentFilter();
                                boolean defaultRestrictedGuilds = localState2.getDefaultRestrictedGuilds();
                                ModelUserSettings.FriendSourceFlags friendSourceFlags = localState2.getFriendSourceFlags();
                                int userDiscoveryFlags = localState2.getUserDiscoveryFlags();
                                Intrinsics3.checkNotNullExpressionValue(modelUserConsents2, "consent");
                                return new WidgetSettingsPrivacy.Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, z2, modelUserConsents2, harvestState);
                            }
                        });
                    }
                });
                Intrinsics3.checkNotNullExpressionValue(observableY, "Observable\n          .co…            }\n          }");
                Observable<Model> observableR = ObservableExtensionsKt.computationLatest(observableY).r();
                Intrinsics3.checkNotNullExpressionValue(observableR, "Observable\n          .co…  .distinctUntilChanged()");
                return observableR;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, ModelUserConsents2 modelUserConsents2, RestAPI.HarvestState harvestState) {
            Intrinsics3.checkNotNullParameter(meUser, "me");
            Intrinsics3.checkNotNullParameter(modelUserConsents2, "consents");
            this.me = meUser;
            this.explicitContentFilter = i;
            this.defaultRestrictedGuilds = z2;
            this.friendSourceFlags = friendSourceFlags;
            this.userDiscoveryFlags = i2;
            this.contactSyncConnection = connectedAccount;
            this.showContactSync = z3;
            this.consents = modelUserConsents2;
            this.harvestState = harvestState;
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMe() {
            return this.me;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        /* JADX INFO: renamed from: component5, reason: from getter */
        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        /* JADX INFO: renamed from: component6, reason: from getter */
        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        /* JADX INFO: renamed from: component7, reason: from getter */
        public final boolean getShowContactSync() {
            return this.showContactSync;
        }

        /* JADX INFO: renamed from: component8, reason: from getter */
        public final ModelUserConsents2 getConsents() {
            return this.consents;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final RestAPI.HarvestState getHarvestState() {
            return this.harvestState;
        }

        public final Model copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings.FriendSourceFlags friendSourceFlags, int userDiscoveryFlags, ConnectedAccount contactSyncConnection, boolean showContactSync, ModelUserConsents2 consents, RestAPI.HarvestState harvestState) {
            Intrinsics3.checkNotNullParameter(me2, "me");
            Intrinsics3.checkNotNullParameter(consents, "consents");
            return new Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, showContactSync, consents, harvestState);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return Intrinsics3.areEqual(this.me, model.me) && this.explicitContentFilter == model.explicitContentFilter && this.defaultRestrictedGuilds == model.defaultRestrictedGuilds && Intrinsics3.areEqual(this.friendSourceFlags, model.friendSourceFlags) && this.userDiscoveryFlags == model.userDiscoveryFlags && Intrinsics3.areEqual(this.contactSyncConnection, model.contactSyncConnection) && this.showContactSync == model.showContactSync && Intrinsics3.areEqual(this.consents, model.consents) && Intrinsics3.areEqual(this.harvestState, model.harvestState);
        }

        public final ModelUserConsents2 getConsents() {
            return this.consents;
        }

        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final boolean getDefaultRestrictedGuilds() {
            return this.defaultRestrictedGuilds;
        }

        public final int getExplicitContentFilter() {
            return this.explicitContentFilter;
        }

        public final ModelUserSettings.FriendSourceFlags getFriendSourceFlags() {
            return this.friendSourceFlags;
        }

        public final RestAPI.HarvestState getHarvestState() {
            return this.harvestState;
        }

        public final MeUser getMe() {
            return this.me;
        }

        public final boolean getShowContactSync() {
            return this.showContactSync;
        }

        public final int getUserDiscoveryFlags() {
            return this.userDiscoveryFlags;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v18 */
        /* JADX WARN: Type inference failed for: r2v19 */
        /* JADX WARN: Type inference failed for: r2v2, types: [int] */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [int] */
        /* JADX WARN: Type inference failed for: r3v2 */
        public int hashCode() {
            MeUser meUser = this.me;
            int iHashCode = (((meUser != null ? meUser.hashCode() : 0) * 31) + this.explicitContentFilter) * 31;
            boolean z2 = this.defaultRestrictedGuilds;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode + r2) * 31;
            ModelUserSettings.FriendSourceFlags friendSourceFlags = this.friendSourceFlags;
            int iHashCode2 = (((i + (friendSourceFlags != null ? friendSourceFlags.hashCode() : 0)) * 31) + this.userDiscoveryFlags) * 31;
            ConnectedAccount connectedAccount = this.contactSyncConnection;
            int iHashCode3 = (iHashCode2 + (connectedAccount != null ? connectedAccount.hashCode() : 0)) * 31;
            boolean z3 = this.showContactSync;
            int i2 = (iHashCode3 + (z3 ? 1 : z3)) * 31;
            ModelUserConsents2 modelUserConsents2 = this.consents;
            int iHashCode4 = (i2 + (modelUserConsents2 != null ? modelUserConsents2.hashCode() : 0)) * 31;
            RestAPI.HarvestState harvestState = this.harvestState;
            return iHashCode4 + (harvestState != null ? harvestState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbU = outline.U("Model(me=");
            sbU.append(this.me);
            sbU.append(", explicitContentFilter=");
            sbU.append(this.explicitContentFilter);
            sbU.append(", defaultRestrictedGuilds=");
            sbU.append(this.defaultRestrictedGuilds);
            sbU.append(", friendSourceFlags=");
            sbU.append(this.friendSourceFlags);
            sbU.append(", userDiscoveryFlags=");
            sbU.append(this.userDiscoveryFlags);
            sbU.append(", contactSyncConnection=");
            sbU.append(this.contactSyncConnection);
            sbU.append(", showContactSync=");
            sbU.append(this.showContactSync);
            sbU.append(", consents=");
            sbU.append(this.consents);
            sbU.append(", harvestState=");
            sbU.append(this.harvestState);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class C03271 extends Lambda implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
            public static final class C03281 extends Lambda implements Function1<View, Unit> {
                public static final C03281 INSTANCE = new C03281();

                public C03281() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    Intrinsics3.checkNotNullParameter(view, "it");
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, AppHelpDesk.a.a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public C03271() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetSettingsPrivacy.this.getContext(), R.color.link)), false, null, C03281.INSTANCE, 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.a;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.a("onClick", new C03271());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass1<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class C03291 extends Lambda implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03291(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                Intrinsics3.checkNotNullParameter(alertDialog, "dialog");
                Intrinsics3.checkNotNullParameter(textView, "dialogHeader");
                Intrinsics3.checkNotNullParameter(textView2, "dialogBody");
                Intrinsics3.checkNotNullParameter(textView3, "dialogCancel");
                Intrinsics3.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(R.string.usage_statistics_disable_modal_title);
                textView2.setText(R.string.usage_statistics_disable_modal_body);
                textView3.setText(R.string.usage_statistics_disable_modal_cancel);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.1.1.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f2639z;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                        checkedSetting.setChecked(true);
                        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().f2639z;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
                        checkedSetting2.setEnabled(true);
                    }
                });
                textView4.setText(R.string.usage_statistics_disable_modal_confirm);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.1.1.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        C03291 c03291 = C03291.this;
                        WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                        Boolean bool = c03291.$consented;
                        Intrinsics3.checkNotNullExpressionValue(bool, "consented");
                        boolean zBooleanValue = bool.booleanValue();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f2639z;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                        widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting);
                    }
                });
            }
        }

        public AnonymousClass1(Context context) {
            this.$context = context;
        }

        @Override // rx.functions.Action1
        public final void call(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f2639z;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setEnabled(false);
            Intrinsics3.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.this.confirmConsent(this.$context, new C03291(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().f2639z;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
            widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass2<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends Lambda implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                Intrinsics3.checkNotNullParameter(alertDialog, "dialog");
                Intrinsics3.checkNotNullParameter(textView, "dialogHeader");
                Intrinsics3.checkNotNullParameter(textView2, "dialogBody");
                Intrinsics3.checkNotNullParameter(textView3, "dialogCancel");
                Intrinsics3.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(R.string.personalization_disable_modal_title);
                textView2.setText(R.string.personalization_disable_modal_body);
                textView3.setText(R.string.personalization_disable_modal_cancel);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.2.1.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().v;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                        checkedSetting.setChecked(true);
                        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().v;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
                        checkedSetting2.setEnabled(true);
                    }
                });
                textView4.setText(R.string.personalization_disable_modal_confirm);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.2.1.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                        Boolean bool = anonymousClass1.$consented;
                        Intrinsics3.checkNotNullExpressionValue(bool, "consented");
                        boolean zBooleanValue = bool.booleanValue();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().v;
                        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                        widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting);
                    }
                });
            }
        }

        public AnonymousClass2(Context context) {
            this.$context = context;
        }

        @Override // rx.functions.Action1
        public final void call(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().v;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
            checkedSetting.setEnabled(false);
            Intrinsics3.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.this.confirmConsent(this.$context, new AnonymousClass1(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().v;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ModelUserConsents3, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ModelUserConsents3 modelUserConsents3) {
            invoke2(modelUserConsents3);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ModelUserConsents3 modelUserConsents3) {
            Intrinsics3.checkNotNullParameter(modelUserConsents3, "requestedHarvest");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(R.string.data_privacy_controls_request_data_success_title).setMessage(R.string.data_privacy_controls_request_data_success_body), R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
            WidgetSettingsPrivacy.this.configureRequestDataButton(true, new RestAPI.HarvestState.LastRequested(modelUserConsents3));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<String, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Context context) {
            super(1);
            this.$context = context;
        }

        public static /* synthetic */ void invoke$default(AnonymousClass2 anonymousClass2, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            anonymousClass2.invoke2(str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetNoticeDialog.Builder title = new WidgetNoticeDialog.Builder(this.$context).setTitle(R.string.data_privacy_controls_request_data_failure_title);
            CharSequence charSequenceB = str;
            if (str == null) {
                charSequenceB = FormatUtils.b(this.$context, R.string.data_privacy_controls_request_data_failure_body, new Object[0], (4 & 4) != 0 ? FormatUtils.b.j : null);
            }
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(title.setMessage(charSequenceB), R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass2 $handleRequestError$2;
        public final /* synthetic */ AnonymousClass1 $handleRequestSuccess$1;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Error, Unit> {
            public AnonymousClass1() {
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
                AnonymousClass2 anonymousClass2 = AnonymousClass3.this.$handleRequestError$2;
                Error.Response response = error.getResponse();
                Intrinsics3.checkNotNullExpressionValue(response, "it.response");
                anonymousClass2.invoke2(response.getMessage());
                error.setShowErrorToasts(false);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass2 extends Lambda implements Function1<ModelUserConsents3, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ModelUserConsents3 modelUserConsents3) {
                invoke2(modelUserConsents3);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ModelUserConsents3 modelUserConsents3) {
                if (modelUserConsents3 != null) {
                    AnonymousClass3.this.$handleRequestSuccess$1.invoke2(modelUserConsents3);
                } else {
                    AnonymousClass2.invoke$default(AnonymousClass3.this.$handleRequestError$2, null, 1, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(Context context, AnonymousClass2 anonymousClass2, AnonymousClass1 anonymousClass1) {
            super(0);
            this.$context = context;
            this.$handleRequestError$2 = anonymousClass2;
            this.$handleRequestSuccess$1 = anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().requestHarvest(), false)), WidgetSettingsPrivacy.this.getBinding().g, 100L), (Class<?>) WidgetSettingsPrivacy.this.getClass(), (58 & 2) != 0 ? null : this.$context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ AnonymousClass3 $requestHarvest$3;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                AnonymousClass4.this.$requestHarvest$3.invoke2();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(Context context, AnonymousClass3 anonymousClass3) {
            super(0);
            this.$context = context;
            this.$requestHarvest$3 = anonymousClass3;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(R.string.data_privacy_controls_request_data_download).setMessage(R.string.data_privacy_controls_request_data_modal_note).setPositiveButton(R.string.okay, new AnonymousClass1()), R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                Intrinsics3.checkNotNullParameter(view, "it");
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                UriHandler.handle$default(uriHandler, context, AppHelpDesk.a.a(360004066391L, null), false, false, null, 28, null);
            }
        }

        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<Model, Unit> {
        public AnonymousClass1(WidgetSettingsPrivacy widgetSettingsPrivacy) {
            super(1, widgetSettingsPrivacy, WidgetSettingsPrivacy.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            Intrinsics3.checkNotNullParameter(model, "p1");
            ((WidgetSettingsPrivacy) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Boolean, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.a;
        }

        public final void invoke(boolean z2) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f2638y;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyScreenreaderDetection");
            checkedSetting.setChecked(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$toggleConsent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Void, Unit> {
        public final /* synthetic */ CheckedSetting $toggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CheckedSetting checkedSetting) {
            super(1);
            this.$toggle = checkedSetting;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            this.$toggle.setEnabled(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<Set<? extends Long>, Unit> {
        public final /* synthetic */ boolean $defaultGuildsRestricted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(boolean z2) {
            super(1);
            this.$defaultGuildsRestricted = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            StoreStream.INSTANCE.getUserSettings().setDefaultGuildsRestricted(WidgetSettingsPrivacy.this.getAppActivity(), this.$defaultGuildsRestricted, set);
        }
    }

    public WidgetSettingsPrivacy() {
        super(R.layout.widget_settings_privacy);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsPrivacy$binding$2.INSTANCE, null, 2, null);
        this.explicitContentRadios = LazyJVM.lazy(new WidgetSettingsPrivacy$explicitContentRadios$2(this));
        this.friendSourceRadios = LazyJVM.lazy(new WidgetSettingsPrivacy$friendSourceRadios$2(this));
        this.userSettings = StoreStream.INSTANCE.getUserSettings();
    }

    private final void configureContactSyncOptions(final Model model) {
        LinearLayout linearLayout = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyContactSync");
        linearLayout.setVisibility(model.getShowContactSync() ? 0 : 8);
        if (model.getShowContactSync()) {
            TextView textView = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.contactSyncSettingInfo");
            FormatUtils.m(textView, R.string.contact_sync_info_settings_2, new Object[0], new AnonymousClass1());
            TextView textView2 = getBinding().d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.contactSyncSettingInfo");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            CheckedSetting checkedSetting = getBinding().c;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
            checkedSetting.setChecked(contactSyncConnection != null && contactSyncConnection.getFriendSync());
            CheckedSetting checkedSetting2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            checkedSetting2.setChecked((model.getUserDiscoveryFlags() & 2) == 2);
            CheckedSetting checkedSetting3 = getBinding().f2635b;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            checkedSetting3.setChecked((model.getUserDiscoveryFlags() & 4) == 4);
            getBinding().c.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.this.getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEnabled");
                    boolean z2 = !checkedSetting4.isChecked();
                    if (model.getContactSyncConnection() == null) {
                        if (z2) {
                            AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location(Traits.Location.Page.USER_SETTINGS, null, null, null, null, 30, null));
                            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, MapsJVM.mapOf(Tuples.to("location_page", Traits.Location.Page.USER_SETTINGS)), 1, null);
                            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetSettingsPrivacy.this.requireContext(), null, false, false, false, 30, null);
                            return;
                        }
                        return;
                    }
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    CheckedSetting checkedSetting5 = WidgetSettingsPrivacy.this.getBinding().e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingPhone");
                    boolean zIsChecked = checkedSetting5.isChecked();
                    CheckedSetting checkedSetting6 = WidgetSettingsPrivacy.this.getBinding().f2635b;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.contactSyncSettingEmail");
                    analyticsTracker.contactSyncToggled(z2, zIsChecked, checkedSetting6.isChecked());
                    WidgetSettingsPrivacy.this.toggleContactSync(model.getContactSyncConnection(), z2);
                }
            });
            getBinding().e.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.this.getBinding().e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingPhone");
                    boolean z2 = !checkedSetting4.isChecked();
                    CheckedSetting checkedSetting5 = WidgetSettingsPrivacy.this.getBinding().f2635b;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingEmail");
                    boolean zIsChecked = checkedSetting5.isChecked();
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    CheckedSetting checkedSetting6 = WidgetSettingsPrivacy.this.getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.contactSyncSettingEnabled");
                    boolean zIsChecked2 = checkedSetting6.isChecked();
                    CheckedSetting checkedSetting7 = WidgetSettingsPrivacy.this.getBinding().f2635b;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.contactSyncSettingEmail");
                    analyticsTracker.contactSyncToggled(zIsChecked2, z2, checkedSetting7.isChecked());
                    WidgetSettingsPrivacy.this.updateFriendDiscoveryFlags(z2, zIsChecked);
                }
            });
            getBinding().f2635b.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.this.getBinding().f2635b;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEmail");
                    boolean z2 = !checkedSetting4.isChecked();
                    CheckedSetting checkedSetting5 = WidgetSettingsPrivacy.this.getBinding().e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingPhone");
                    boolean zIsChecked = checkedSetting5.isChecked();
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    CheckedSetting checkedSetting6 = WidgetSettingsPrivacy.this.getBinding().c;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting6, "binding.contactSyncSettingEnabled");
                    boolean zIsChecked2 = checkedSetting6.isChecked();
                    CheckedSetting checkedSetting7 = WidgetSettingsPrivacy.this.getBinding().e;
                    Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.contactSyncSettingPhone");
                    analyticsTracker.contactSyncToggled(zIsChecked2, checkedSetting7.isChecked(), z2);
                    WidgetSettingsPrivacy.this.updateFriendDiscoveryFlags(zIsChecked, z2);
                }
            });
            CheckedSetting checkedSetting4 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingStaffOnly");
            checkedSetting4.setVisibility(UserUtils.INSTANCE.isStaff(model.getMe()) ? 0 : 8);
            CheckedSetting checkedSetting5 = getBinding().f;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingStaffOnly");
            checkedSetting5.setChecked(true);
            getBinding().f.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    if (UserUtils.INSTANCE.isStaff(model.getMe())) {
                        WidgetSettingsPrivacy.this.deleteContactSync();
                    }
                }
            });
        }
    }

    private final void configureDefaultGuildsRestricted(final Model model) {
        CheckedSetting checkedSetting = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyDefaultRestrictedGuilds");
        checkedSetting.setChecked(!model.getDefaultRestrictedGuilds());
        getBinding().m.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureDefaultGuildsRestricted.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsPrivacy.this.showDefaultGuildsRestrictedExistingServers(!model.getDefaultRestrictedGuilds());
            }
        });
    }

    private final void configureExplicitContentRadio(Model model, CheckedSetting radio, final int explicitContentFilter) {
        RadioManager radioManager;
        radio.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureExplicitContentRadio.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserSettings().setExplicitContentFilter(WidgetSettingsPrivacy.this.getAppActivity(), explicitContentFilter);
            }
        });
        if (this.radioManagerExplicit == null || model.getExplicitContentFilter() != explicitContentFilter || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.a(radio);
    }

    private final void configureFriendSourceRadio(Model model) {
        getFriendSourceRadios().get(0).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureFriendSourceRadio.1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                widgetSettingsPrivacy.updateFriendSourceFlags(0, bool.booleanValue());
            }
        });
        getFriendSourceRadios().get(1).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureFriendSourceRadio.2
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                widgetSettingsPrivacy.updateFriendSourceFlags(1, bool.booleanValue());
            }
        });
        getFriendSourceRadios().get(2).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureFriendSourceRadio.3
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                widgetSettingsPrivacy.updateFriendSourceFlags(2, bool.booleanValue());
            }
        });
        ModelUserSettings.FriendSourceFlags friendSourceFlags = model.getFriendSourceFlags();
        boolean zIsAll = friendSourceFlags != null ? friendSourceFlags.isAll() : false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        checkedSetting.setChecked(zIsAll);
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        CheckedSetting checkedSetting3 = checkedSetting2;
        ModelUserSettings.FriendSourceFlags friendSourceFlags2 = model.getFriendSourceFlags();
        checkedSetting3.setChecked((friendSourceFlags2 != null ? friendSourceFlags2.isMutualFriends() : false) || zIsAll);
        CheckedSetting checkedSetting4 = getFriendSourceRadios().get(2);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "friendSourceRadios[2]");
        CheckedSetting checkedSetting5 = checkedSetting4;
        ModelUserSettings.FriendSourceFlags friendSourceFlags3 = model.getFriendSourceFlags();
        checkedSetting5.setChecked((friendSourceFlags3 != null ? friendSourceFlags3.isMutualGuilds() : false) || zIsAll);
    }

    private final void configurePrivacyControls(Model model) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            LinearLayout linearLayout = getBinding().k;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyControls");
            linearLayout.setVisibility(0);
            CheckedSetting checkedSetting = getBinding().f2639z;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setChecked(model.getConsents().getUsageStatistics().getConsented());
            getBinding().f2639z.setOnCheckedListener(new AnonymousClass1(context));
            CheckedSetting checkedSetting2 = getBinding().v;
            Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            checkedSetting2.setChecked(model.getConsents().getPersonalization().getConsented());
            getBinding().v.setOnCheckedListener(new AnonymousClass2(context));
        }
    }

    private final void configureRequestDataButton(final boolean isMeVerified, final RestAPI.HarvestState harvestState) {
        getBinding().w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureRequestDataButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestAPI.HarvestState harvestState2;
                Context context = WidgetSettingsPrivacy.this.getContext();
                if (context != null) {
                    Intrinsics3.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                    if (!isMeVerified || (harvestState2 = harvestState) == null) {
                        AppToast.i(WidgetSettingsPrivacy.this, R.string.data_privacy_controls_request_data_tooltip, 0, 4);
                    } else {
                        WidgetSettingsPrivacy.this.onRequestDataClick(context, harvestState2);
                    }
                }
            }
        });
    }

    private final void configureUI(Model model) {
        configureDefaultGuildsRestricted(model);
        configureFriendSourceRadio(model);
        configureContactSyncOptions(model);
        CheckedSetting checkedSetting = getExplicitContentRadios().get(0);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "explicitContentRadios[0]");
        configureExplicitContentRadio(model, checkedSetting, 0);
        CheckedSetting checkedSetting2 = getExplicitContentRadios().get(1);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "explicitContentRadios[1]");
        configureExplicitContentRadio(model, checkedSetting2, 1);
        CheckedSetting checkedSetting3 = getExplicitContentRadios().get(2);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "explicitContentRadios[2]");
        configureExplicitContentRadio(model, checkedSetting3, 2);
        configurePrivacyControls(model);
        configureRequestDataButton(model.getMe().isVerified(), model.getHarvestState());
    }

    private final void confirmConsent(Context context, Function5<? super AlertDialog, ? super TextView, ? super TextView, ? super TextView, ? super TextView, Unit> function5) {
        ViewDialogConfirmationBinding viewDialogConfirmationBindingA = ViewDialogConfirmationBinding.a(getLayoutInflater().inflate(R.layout.view_dialog_confirmation, (ViewGroup) null, false));
        Intrinsics3.checkNotNullExpressionValue(viewDialogConfirmationBindingA, "ViewDialogConfirmationBi…outInflater, null, false)");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(viewDialogConfirmationBindingA.a).setCancelable(false).create();
        Intrinsics3.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(this…(false)\n        .create()");
        TextView textView = viewDialogConfirmationBindingA.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        TextView textView2 = viewDialogConfirmationBindingA.e;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        MaterialButton materialButton = viewDialogConfirmationBindingA.f2185b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
        MaterialButton materialButton2 = viewDialogConfirmationBindingA.c;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
        function5.invoke(alertDialogCreate, textView, textView2, materialButton, materialButton2);
        alertDialogCreate.show();
    }

    private final void deleteContactSync() {
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getContactSync().clearDismissStates();
        companion.getUserConnections().deleteUserConnection("contacts", "@me");
    }

    private final WidgetSettingsPrivacyBinding getBinding() {
        return (WidgetSettingsPrivacyBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final List<CheckedSetting> getExplicitContentRadios() {
        return (List) this.explicitContentRadios.getValue();
    }

    private final List<CheckedSetting> getFriendSourceRadios() {
        return (List) this.friendSourceRadios.getValue();
    }

    public static final void launch(Context context) {
        INSTANCE.launch(context);
    }

    private final void onRequestDataClick(Context context, RestAPI.HarvestState harvestState) {
        AnonymousClass4 anonymousClass4 = new AnonymousClass4(context, new AnonymousClass3(context, new AnonymousClass2(context), new AnonymousClass1(context)));
        if (harvestState instanceof RestAPI.HarvestState.NeverRequested) {
            anonymousClass4.invoke2();
            return;
        }
        if (harvestState instanceof RestAPI.HarvestState.LastRequested) {
            ModelUserConsents3 data = ((RestAPI.HarvestState.LastRequested) harvestState).getData();
            if (ModelUserConsents3.canRequest$default(data, 0L, 1, null)) {
                anonymousClass4.invoke2();
            } else {
                showNextAvailableRequestAlert(data.nextAvailableRequestInMillis());
            }
        }
    }

    private final void showDefaultGuildsRestrictedExistingServers(final boolean defaultGuildsRestricted) {
        View viewInflate = getLayoutInflater().inflate(R.layout.widget_settings_privacy_defaults, (ViewGroup) null, false);
        int i = R.id.settings_privacy_defaults_existing_no;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(R.id.settings_privacy_defaults_existing_no);
        if (materialButton != null) {
            i = R.id.settings_privacy_defaults_existing_yes;
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(R.id.settings_privacy_defaults_existing_yes);
            if (materialButton2 != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                Intrinsics3.checkNotNullExpressionValue(new WidgetSettingsPrivacyDefaultsBinding(linearLayout, materialButton, materialButton2), "WidgetSettingsPrivacyDef…outInflater, null, false)");
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.this$0.updateDefaultGuildsRestricted(defaultGuildsRestricted, false);
                    }
                });
                materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$showDefaultGuildsRestrictedExistingServers$$inlined$apply$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        this.this$0.updateDefaultGuildsRestricted(defaultGuildsRestricted, true);
                    }
                });
                AlertDialog alertDialog = this.dialog;
                if (alertDialog != null) {
                    alertDialog.dismiss();
                }
                Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.root");
                AlertDialog alertDialogCreate = new AlertDialog.Builder(linearLayout.getContext()).setView(linearLayout).create();
                this.dialog = alertDialogCreate;
                if (alertDialogCreate != null) {
                    alertDialogCreate.show();
                    return;
                }
                return;
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    private final void showNextAvailableRequestAlert(long nextAvailableRequestMillis) {
        Context context = getContext();
        if (context != null) {
            Intrinsics3.checkNotNullExpressionValue(context, "context ?: return");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(context).setTitle(R.string.data_privacy_rate_limit_title).setMessage(FormatUtils.b(context, R.string.data_download_requested_status_note, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, nextAvailableRequestMillis, context, 0, 4, null)}, (4 & 4) != 0 ? FormatUtils.b.j : null)), R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    private final void toggleConsent(final boolean consented, String consentType, final CheckedSetting toggle) {
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().setConsent(consented, consentType), this, null, 2, null), getBinding().g, 100L).k(o.a.g(getContext(), new AnonymousClass1(toggle), new Action1<Error>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.toggleConsent.2
            @Override // rx.functions.Action1
            public final void call(Error error) {
                toggle.setEnabled(true);
                toggle.setChecked(true ^ consented);
            }
        }));
    }

    private final void toggleContactSync(ConnectedAccount contactsAccount, boolean syncFriends) {
        if (contactsAccount == null) {
            return;
        }
        StoreStream.Companion companion = StoreStream.INSTANCE;
        companion.getUserConnections().updateUserConnection(contactsAccount, syncFriends, contactsAccount.getShowActivity(), contactsAccount.getVisibility() == 1);
        if (syncFriends) {
            companion.getContactSync().backgroundUploadContacts();
        }
    }

    private final void updateDefaultGuildsRestricted(boolean defaultGuildsRestricted, boolean applyToExistingGuilds) {
        Observable scalarSynchronousObservable;
        if (applyToExistingGuilds) {
            scalarSynchronousObservable = !defaultGuildsRestricted ? new ScalarSynchronousObservable(Sets5.emptySet()) : StoreStream.INSTANCE.getGuilds().observeGuilds().G(new Func1<Map<Long, ? extends Guild>, Set<? extends Long>>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.updateDefaultGuildsRestricted.1
                @Override // j0.k.Func1
                public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
                    return call2((Map<Long, Guild>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Set<Long> call2(Map<Long, Guild> map) {
                    return map.keySet();
                }
            });
        } else {
            scalarSynchronousObservable = new ScalarSynchronousObservable(null);
        }
        Observable observableZ = scalarSynchronousObservable.Z(1);
        Intrinsics3.checkNotNullExpressionValue(observableZ, "when {\n      !applyToExi… }\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableZ), this, null, 2, null), (Class<?>) WidgetSettingsPrivacy.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(defaultGuildsRestricted));
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    private final void updateFriendDiscoveryFlags(boolean allowPhone, boolean allowEmail) {
        int i = allowPhone ? 2 : 0;
        if (allowEmail) {
            i |= 4;
        }
        StoreStream.INSTANCE.getUserSettings().setFriendDiscoveryFlags(getAppActivity(), i);
    }

    private final void updateFriendSourceFlags(int index, boolean checked) {
        boolean z2 = false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        boolean zIsChecked = checkedSetting.isChecked();
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        boolean zIsChecked2 = checkedSetting2.isChecked();
        CheckedSetting checkedSetting3 = getFriendSourceRadios().get(2);
        Intrinsics3.checkNotNullExpressionValue(checkedSetting3, "friendSourceRadios[2]");
        boolean zIsChecked3 = checkedSetting3.isChecked();
        if ((zIsChecked && zIsChecked2 && zIsChecked3) || (index == 0 && checked)) {
            z2 = true;
        }
        StoreStream.INSTANCE.getUserSettings().setFriendSourceFlags(getAppActivity(), Boolean.valueOf(z2), Boolean.valueOf(zIsChecked3), Boolean.valueOf(zIsChecked2));
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        AlertDialog alertDialog = this.dialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    @Override // com.discord.app.AppFragment
    @SuppressLint({"SetTextI18n"})
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.privacy_and_safety);
        this.radioManagerExplicit = new RadioManager(getExplicitContentRadios());
        CheckedSetting checkedSetting = getBinding().v;
        CheckedSetting checkedSetting2 = getBinding().v;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        AppHelpDesk appHelpDesk = AppHelpDesk.a;
        checkedSetting.h(FormatUtils.d(checkedSetting2, R.string.data_privacy_controls_personalization_note_learn_more, new Object[]{appHelpDesk.a(360004109911L, null)}, (4 & 4) != 0 ? FormatUtils.c.j : null), true);
        CheckedSetting checkedSetting3 = getBinding().f2638y;
        CheckedSetting checkedSetting4 = getBinding().f2638y;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting4, "binding.settingsPrivacyScreenreaderDetection");
        checkedSetting3.h(FormatUtils.d(checkedSetting4, R.string.data_privacy_controls_allow_accessibility_detection_note, new Object[]{appHelpDesk.a(360035966492L, null)}, (4 & 4) != 0 ? FormatUtils.c.j : null), true);
        final CheckedSetting checkedSetting5 = getBinding().f2638y;
        checkedSetting5.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1
            @Override // rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettings = this.userSettings;
                Intrinsics3.checkNotNullExpressionValue(bool, "checked");
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(storeUserSettings.setIsAccessibilityDetectionAllowed(bool.booleanValue()), false, 1, null), (Class<?>) checkedSetting5.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), WidgetSettingsPrivacy$onViewBound$1$1$1.INSTANCE);
            }
        });
        getBinding().i.setButtonVisibility(false);
        CheckedSetting checkedSetting6 = getBinding().i;
        CheckedSetting checkedSetting7 = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting7, "binding.settingsPrivacyBasicService");
        checkedSetting6.h(FormatUtils.d(checkedSetting7, R.string.data_privacy_controls_basic_service_note, new Object[0], AnonymousClass2.INSTANCE), true);
        getBinding().i.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsAccount.Companion.launch$default(companion, context, true, null, 4, null);
            }
        });
        final String strA = appHelpDesk.a(360004027692L, null);
        TextView textView = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.requestDataLink");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        TextView textView2 = getBinding().h;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.requestDataLink");
        sb.append(FormatUtils.d(textView2, R.string.notice_whats_this, new Object[0], (4 & 4) != 0 ? FormatUtils.c.j : null));
        sb.append("](");
        sb.append(strA);
        sb.append(')');
        textView.setText(FormatUtils.g(sb.toString(), new Object[0], (2 & 2) != 0 ? FormatUtils.e.j : null));
        getBinding().h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, outline.x(view2, "it", "it.context"), strA, false, false, null, 28, null);
            }
        });
        CheckedSetting checkedSetting8 = getBinding().f2639z;
        CheckedSetting checkedSetting9 = getBinding().f2639z;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting9, "binding.settingsPrivacyStatistics");
        checkedSetting8.h(FormatUtils.d(checkedSetting9, R.string.data_privacy_controls_usage_statistics_note, new Object[]{appHelpDesk.a(360004109911L, null)}, (4 & 4) != 0 ? FormatUtils.c.j : null), true);
        for (TextView textView3 : Collections2.listOf((Object[]) new TextView[]{getBinding().f2637x, getBinding().n, getBinding().u, getBinding().l})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView3, "header");
            accessibilityUtils.setViewIsHeading(textView3);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetSettingsPrivacy.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(this.userSettings.observeIsAccessibilityDetectionAllowed(), this, null, 2, null), (Class<?>) WidgetSettingsPrivacy.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }
}
