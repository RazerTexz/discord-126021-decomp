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
import com.discord.C5419R;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppFragment;
import com.discord.databinding.ViewDialogConfirmationBinding;
import com.discord.databinding.WidgetSettingsPrivacyBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.Consents;
import com.discord.models.domain.Harvest;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.spans.ClickableSpan;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.CheckedSetting;
import com.discord.views.RadioManager;
import com.discord.widgets.contact_sync.ContactSyncFlowAnalytics;
import com.discord.widgets.contact_sync.WidgetContactSync;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.google.android.material.button.MaterialButton;
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
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p018d.C0879o;
import p007b.p008a.p025i.C0926b6;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p637j0.p641k.InterfaceC12589b;
import p637j0.p642l.p647e.C12721k;
import p637j0.p653p.C12781a;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Action1;
import p658rx.functions.Func3;
import p658rx.functions.Func7;

/* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPrivacy extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsPrivacy.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPrivacyBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C0870j.m157e(context, WidgetSettingsPrivacy.class, null, 4);
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
            C12238m.checkNotNullParameter(meUser, "me");
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
            C12238m.checkNotNullParameter(me2, "me");
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
            return C12238m.areEqual(this.me, localState.me) && this.explicitContentFilter == localState.explicitContentFilter && this.defaultRestrictedGuilds == localState.defaultRestrictedGuilds && C12238m.areEqual(this.friendSourceFlags, localState.friendSourceFlags) && C12238m.areEqual(this.contactSyncConnection, localState.contactSyncConnection) && C12238m.areEqual(this.contactSyncExperiment, localState.contactSyncExperiment) && this.userDiscoveryFlags == localState.userDiscoveryFlags;
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
            StringBuilder sbM833U = C1643a.m833U("LocalState(me=");
            sbM833U.append(this.me);
            sbM833U.append(", explicitContentFilter=");
            sbM833U.append(this.explicitContentFilter);
            sbM833U.append(", defaultRestrictedGuilds=");
            sbM833U.append(this.defaultRestrictedGuilds);
            sbM833U.append(", friendSourceFlags=");
            sbM833U.append(this.friendSourceFlags);
            sbM833U.append(", contactSyncConnection=");
            sbM833U.append(this.contactSyncConnection);
            sbM833U.append(", contactSyncExperiment=");
            sbM833U.append(this.contactSyncExperiment);
            sbM833U.append(", userDiscoveryFlags=");
            return C1643a.m814B(sbM833U, this.userDiscoveryFlags, ")");
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final Consents consents;
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
                Observable<R> observableM11083G = companion.getUserConnections().observeConnectedAccounts().m11083G(new InterfaceC12589b<StoreUserConnections.State, ConnectedAccount>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$1
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final ConnectedAccount call(StoreUserConnections.State state) {
                        ConnectedAccount connectedAccountPrevious;
                        C12238m.checkNotNullExpressionValue(state, "accounts");
                        ListIterator<ConnectedAccount> listIterator = state.listIterator(state.size());
                        while (listIterator.hasPrevious()) {
                            connectedAccountPrevious = listIterator.previous();
                            if (C12238m.areEqual(connectedAccountPrevious.getType(), "contacts")) {
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
                        @Override // p658rx.functions.Func7
                        public final /* synthetic */ Object call(Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
                            return widgetSettingsPrivacy$Model$Companion$get$2.invoke(obj2, obj3, obj4, obj5, obj6, obj7, obj8);
                        }
                    };
                }
                Observable observableM11099Y = Observable.m11069e(observableObserveMe$default, observableObserveExplicitContentFilter, observableObserveIsDefaultGuildsRestricted, observableObserveFriendSourceFlags, observableM11083G, observableObserveUserExperiment, observableObserveFriendDiscoveryFlags, (Func7) obj).m11099Y(new InterfaceC12589b<LocalState, Observable<? extends Model>>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3
                    @Override // p637j0.p641k.InterfaceC12589b
                    public final Observable<? extends WidgetSettingsPrivacy.Model> call(WidgetSettingsPrivacy.LocalState localState) {
                        C12721k c12721k = new C12721k(localState);
                        StoreStream.Companion companion2 = StoreStream.INSTANCE;
                        return Observable.m11075i(c12721k, companion2.getUserSettings().observeConsents(), Observable.m11064I(new C12721k(null), StoreUser.observeMe$default(companion2.getUsers(), false, 1, null).m11118y(new InterfaceC12589b<MeUser, Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3.1
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Boolean call(MeUser meUser) {
                                return Boolean.valueOf(meUser.isVerified());
                            }
                        }).m11082A(new InterfaceC12589b<MeUser, Observable<? extends RestAPI.HarvestState>>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3.2
                            @Override // p637j0.p641k.InterfaceC12589b
                            public final Observable<? extends RestAPI.HarvestState> call(MeUser meUser) {
                                RetryWithDelay retryWithDelay = RetryWithDelay.INSTANCE;
                                Observable<RestAPI.HarvestState> observableM11084J = RestAPI.INSTANCE.getApi().getHarvestStatusGuarded().m11084J(C12781a.m10875c());
                                C12238m.checkNotNullExpressionValue(observableM11084J, "RestAPI\n                …bserveOn(Schedulers.io())");
                                return RetryWithDelay.restRetry$default(retryWithDelay, observableM11084J, 0L, null, null, 7, null).m11111q(500L, TimeUnit.MILLISECONDS).m11087M(new InterfaceC12589b<Throwable, RestAPI.HarvestState>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.Model.Companion.get.3.2.1
                                    @Override // p637j0.p641k.InterfaceC12589b
                                    public final RestAPI.HarvestState call(Throwable th) {
                                        return new RestAPI.HarvestState.NeverRequested();
                                    }
                                });
                            }
                        })), new Func3<WidgetSettingsPrivacy.LocalState, Consents, RestAPI.HarvestState, WidgetSettingsPrivacy.Model>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$Model$Companion$get$3.3
                            @Override // p658rx.functions.Func3
                            public final WidgetSettingsPrivacy.Model call(WidgetSettingsPrivacy.LocalState localState2, Consents consents, RestAPI.HarvestState harvestState) {
                                ConnectedAccount contactSyncConnection = localState2.getContactSyncConnection();
                                Experiment contactSyncExperiment = localState2.getContactSyncExperiment();
                                boolean z2 = contactSyncExperiment != null && contactSyncExperiment.getBucket() == 1;
                                MeUser me2 = localState2.getMe();
                                int explicitContentFilter = localState2.getExplicitContentFilter();
                                boolean defaultRestrictedGuilds = localState2.getDefaultRestrictedGuilds();
                                ModelUserSettings.FriendSourceFlags friendSourceFlags = localState2.getFriendSourceFlags();
                                int userDiscoveryFlags = localState2.getUserDiscoveryFlags();
                                C12238m.checkNotNullExpressionValue(consents, "consent");
                                return new WidgetSettingsPrivacy.Model(me2, explicitContentFilter, defaultRestrictedGuilds, friendSourceFlags, userDiscoveryFlags, contactSyncConnection, z2, consents, harvestState);
                            }
                        });
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11099Y, "Observable\n          .co…            }\n          }");
                Observable<Model> observableM11112r = ObservableExtensionsKt.computationLatest(observableM11099Y).m11112r();
                C12238m.checkNotNullExpressionValue(observableM11112r, "Observable\n          .co…  .distinctUntilChanged()");
                return observableM11112r;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, int i, boolean z2, ModelUserSettings.FriendSourceFlags friendSourceFlags, int i2, ConnectedAccount connectedAccount, boolean z3, Consents consents, RestAPI.HarvestState harvestState) {
            C12238m.checkNotNullParameter(meUser, "me");
            C12238m.checkNotNullParameter(consents, "consents");
            this.me = meUser;
            this.explicitContentFilter = i;
            this.defaultRestrictedGuilds = z2;
            this.friendSourceFlags = friendSourceFlags;
            this.userDiscoveryFlags = i2;
            this.contactSyncConnection = connectedAccount;
            this.showContactSync = z3;
            this.consents = consents;
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
        public final Consents getConsents() {
            return this.consents;
        }

        /* JADX INFO: renamed from: component9, reason: from getter */
        public final RestAPI.HarvestState getHarvestState() {
            return this.harvestState;
        }

        public final Model copy(MeUser me2, int explicitContentFilter, boolean defaultRestrictedGuilds, ModelUserSettings.FriendSourceFlags friendSourceFlags, int userDiscoveryFlags, ConnectedAccount contactSyncConnection, boolean showContactSync, Consents consents, RestAPI.HarvestState harvestState) {
            C12238m.checkNotNullParameter(me2, "me");
            C12238m.checkNotNullParameter(consents, "consents");
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
            return C12238m.areEqual(this.me, model.me) && this.explicitContentFilter == model.explicitContentFilter && this.defaultRestrictedGuilds == model.defaultRestrictedGuilds && C12238m.areEqual(this.friendSourceFlags, model.friendSourceFlags) && this.userDiscoveryFlags == model.userDiscoveryFlags && C12238m.areEqual(this.contactSyncConnection, model.contactSyncConnection) && this.showContactSync == model.showContactSync && C12238m.areEqual(this.consents, model.consents) && C12238m.areEqual(this.harvestState, model.harvestState);
        }

        public final Consents getConsents() {
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
            Consents consents = this.consents;
            int iHashCode4 = (i2 + (consents != null ? consents.hashCode() : 0)) * 31;
            RestAPI.HarvestState harvestState = this.harvestState;
            return iHashCode4 + (harvestState != null ? harvestState.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(me=");
            sbM833U.append(this.me);
            sbM833U.append(", explicitContentFilter=");
            sbM833U.append(this.explicitContentFilter);
            sbM833U.append(", defaultRestrictedGuilds=");
            sbM833U.append(this.defaultRestrictedGuilds);
            sbM833U.append(", friendSourceFlags=");
            sbM833U.append(this.friendSourceFlags);
            sbM833U.append(", userDiscoveryFlags=");
            sbM833U.append(this.userDiscoveryFlags);
            sbM833U.append(", contactSyncConnection=");
            sbM833U.append(this.contactSyncConnection);
            sbM833U.append(", showContactSync=");
            sbM833U.append(this.showContactSync);
            sbM833U.append(", consents=");
            sbM833U.append(this.consents);
            sbM833U.append(", harvestState=");
            sbM833U.append(this.harvestState);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96611 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C96611() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {

            /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configureContactSyncOptions$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
            public static final class C132901 extends AbstractC12240o implements Function1<View, Unit> {
                public static final C132901 INSTANCE = new C132901();

                public C132901() {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.f27425a;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View view) {
                    C12238m.checkNotNullParameter(view, "it");
                    UriHandler uriHandler = UriHandler.INSTANCE;
                    Context context = view.getContext();
                    C12238m.checkNotNullExpressionValue(context, "it.context");
                    UriHandler.handle$default(uriHandler, context, C0862f.f507a.m149a(360061878534L, null), false, false, null, 28, null);
                }
            }

            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new ClickableSpan(Integer.valueOf(ColorCompat.getColor(WidgetSettingsPrivacy.this.getContext(), C5419R.color.link)), false, null, C132901.INSTANCE, 4, null));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Hook hook) {
                invoke2(hook);
                return Unit.f27425a;
            }
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8422a("onClick", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96711<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                C12238m.checkNotNullParameter(alertDialog, "dialog");
                C12238m.checkNotNullParameter(textView, "dialogHeader");
                C12238m.checkNotNullParameter(textView2, "dialogBody");
                C12238m.checkNotNullParameter(textView3, "dialogCancel");
                C12238m.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(C5419R.string.usage_statistics_disable_modal_title);
                textView2.setText(C5419R.string.usage_statistics_disable_modal_body);
                textView3.setText(C5419R.string.usage_statistics_disable_modal_cancel);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.1.1.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18075z;
                        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                        checkedSetting.setChecked(true);
                        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().f18075z;
                        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
                        checkedSetting2.setEnabled(true);
                    }
                });
                textView4.setText(C5419R.string.usage_statistics_disable_modal_confirm);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.1.1.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                        Boolean bool = anonymousClass1.$consented;
                        C12238m.checkNotNullExpressionValue(bool, "consented");
                        boolean zBooleanValue = bool.booleanValue();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18075z;
                        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
                        widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting);
                    }
                });
            }
        }

        public C96711(Context context) {
            this.$context = context;
        }

        @Override // p658rx.functions.Action1
        public final void call(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18075z;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setEnabled(false);
            C12238m.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.this.confirmConsent(this.$context, new AnonymousClass1(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().f18075z;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyStatistics");
            widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.USAGE_STATS, checkedSetting2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96722<T> implements Action1<Boolean> {
        public final /* synthetic */ Context $context;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$configurePrivacyControls$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function5<AlertDialog, TextView, TextView, TextView, TextView, Unit> {
            public final /* synthetic */ Boolean $consented;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(Boolean bool) {
                super(5);
                this.$consented = bool;
            }

            @Override // kotlin.jvm.functions.Function5
            public /* bridge */ /* synthetic */ Unit invoke(AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                invoke2(alertDialog, textView, textView2, textView3, textView4);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(final AlertDialog alertDialog, TextView textView, TextView textView2, TextView textView3, TextView textView4) {
                C12238m.checkNotNullParameter(alertDialog, "dialog");
                C12238m.checkNotNullParameter(textView, "dialogHeader");
                C12238m.checkNotNullParameter(textView2, "dialogBody");
                C12238m.checkNotNullParameter(textView3, "dialogCancel");
                C12238m.checkNotNullParameter(textView4, "dialogConfirm");
                textView.setText(C5419R.string.personalization_disable_modal_title);
                textView2.setText(C5419R.string.personalization_disable_modal_body);
                textView3.setText(C5419R.string.personalization_disable_modal_cancel);
                textView3.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.2.1.1
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18071v;
                        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                        checkedSetting.setChecked(true);
                        CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().f18071v;
                        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
                        checkedSetting2.setEnabled(true);
                    }
                });
                textView4.setText(C5419R.string.personalization_disable_modal_confirm);
                textView4.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configurePrivacyControls.2.1.2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        alertDialog.dismiss();
                        AnonymousClass1 anonymousClass1 = AnonymousClass1.this;
                        WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                        Boolean bool = anonymousClass1.$consented;
                        C12238m.checkNotNullExpressionValue(bool, "consented");
                        boolean zBooleanValue = bool.booleanValue();
                        CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18071v;
                        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
                        widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting);
                    }
                });
            }
        }

        public C96722(Context context) {
            this.$context = context;
        }

        @Override // p658rx.functions.Action1
        public final void call(Boolean bool) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18071v;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyPersonalization");
            checkedSetting.setEnabled(false);
            C12238m.checkNotNullExpressionValue(bool, "consented");
            if (!bool.booleanValue()) {
                WidgetSettingsPrivacy.this.confirmConsent(this.$context, new AnonymousClass1(bool));
                return;
            }
            WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
            boolean zBooleanValue = bool.booleanValue();
            CheckedSetting checkedSetting2 = WidgetSettingsPrivacy.this.getBinding().f18071v;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            widgetSettingsPrivacy.toggleConsent(zBooleanValue, RestAPIParams.Consents.Type.PERSONALIZATION, checkedSetting2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$1 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96741 extends AbstractC12240o implements Function1<Harvest, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96741(Context context) {
            super(1);
            this.$context = context;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Harvest harvest) {
            invoke2(harvest);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Harvest harvest) {
            C12238m.checkNotNullParameter(harvest, "requestedHarvest");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(C5419R.string.data_privacy_controls_request_data_success_title).setMessage(C5419R.string.data_privacy_controls_request_data_success_body), C5419R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
            WidgetSettingsPrivacy.this.configureRequestDataButton(true, new RestAPI.HarvestState.LastRequested(harvest));
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$2 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96752 extends AbstractC12240o implements Function1<String, Unit> {
        public final /* synthetic */ Context $context;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96752(Context context) {
            super(1);
            this.$context = context;
        }

        public static /* synthetic */ void invoke$default(C96752 c96752, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            c96752.invoke2(str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(String str) {
            invoke2(str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(String str) {
            WidgetNoticeDialog.Builder title = new WidgetNoticeDialog.Builder(this.$context).setTitle(C5419R.string.data_privacy_controls_request_data_failure_title);
            CharSequence charSequenceM216h = str;
            if (str == null) {
                charSequenceM216h = C1107b.m216h(this.$context, C5419R.string.data_privacy_controls_request_data_failure_body, new Object[0], null, 4);
            }
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(title.setMessage(charSequenceM216h), C5419R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96763 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C96752 $handleRequestError$2;
        public final /* synthetic */ C96741 $handleRequestSuccess$1;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Error, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Error error) {
                invoke2(error);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Error error) {
                C12238m.checkNotNullParameter(error, "it");
                C96752 c96752 = C96763.this.$handleRequestError$2;
                Error.Response response = error.getResponse();
                C12238m.checkNotNullExpressionValue(response, "it.response");
                c96752.invoke2(response.getMessage());
                error.setShowErrorToasts(false);
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$3$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function1<Harvest, Unit> {
            public AnonymousClass2() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Harvest harvest) {
                invoke2(harvest);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Harvest harvest) {
                if (harvest != null) {
                    C96763.this.$handleRequestSuccess$1.invoke2(harvest);
                } else {
                    C96752.invoke$default(C96763.this.$handleRequestError$2, null, 1, null);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96763(Context context, C96752 c96752, C96741 c96741) {
            super(0);
            this.$context = context;
            this.$handleRequestError$2 = c96752;
            this.$handleRequestSuccess$1 = c96741;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.m8518ui(ObservableExtensionsKt.restSubscribeOn(RestAPI.INSTANCE.getApi().requestHarvest(), false)), WidgetSettingsPrivacy.this.getBinding().f18056g, 100L), (Class<?>) WidgetSettingsPrivacy.this.getClass(), (58 & 2) != 0 ? null : this.$context, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : new AnonymousClass1()), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass2());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96774 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ Context $context;
        public final /* synthetic */ C96763 $requestHarvest$3;

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onRequestDataClick$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                C96774.this.$requestHarvest$3.invoke2();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96774(Context context, C96763 c96763) {
            super(0);
            this.$context = context;
            this.$requestHarvest$3 = c96763;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetNoticeDialog.Builder negativeButton$default = WidgetNoticeDialog.Builder.setNegativeButton$default(new WidgetNoticeDialog.Builder(this.$context).setTitle(C5419R.string.data_privacy_controls_request_data_download).setMessage(C5419R.string.data_privacy_controls_request_data_modal_note).setPositiveButton(C5419R.string.okay, new AnonymousClass1()), C5419R.string.cancel, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = WidgetSettingsPrivacy.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            negativeButton$default.show(parentFragmentManager);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96782 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C96782 INSTANCE = new C96782();

        /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<View, Unit> {
            public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(View view) {
                invoke2(view);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(View view) {
                C12238m.checkNotNullParameter(view, "it");
                UriHandler uriHandler = UriHandler.INSTANCE;
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                UriHandler.handle$default(uriHandler, context, C0862f.f507a.m149a(360004066391L, null), false, false, null, 28, null);
            }
        }

        public C96782() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.m8423b("onClick", AnonymousClass1.INSTANCE);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final /* synthetic */ class C96811 extends C12236k implements Function1<Model, Unit> {
        public C96811(WidgetSettingsPrivacy widgetSettingsPrivacy) {
            super(1, widgetSettingsPrivacy, WidgetSettingsPrivacy.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/WidgetSettingsPrivacy$Model;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            C12238m.checkNotNullParameter(model, "p1");
            ((WidgetSettingsPrivacy) this.receiver).configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96822 extends AbstractC12240o implements Function1<Boolean, Unit> {
        public C96822() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.f27425a;
        }

        public final void invoke(boolean z2) {
            CheckedSetting checkedSetting = WidgetSettingsPrivacy.this.getBinding().f18074y;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyScreenreaderDetection");
            checkedSetting.setChecked(z2);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$toggleConsent$1 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96851 extends AbstractC12240o implements Function1<Void, Unit> {
        public final /* synthetic */ CheckedSetting $toggle;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96851(CheckedSetting checkedSetting) {
            super(1);
            this.$toggle = checkedSetting;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Void r1) {
            invoke2(r1);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Void r2) {
            this.$toggle.setEnabled(true);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.WidgetSettingsPrivacy$updateDefaultGuildsRestricted$2 */
    /* JADX INFO: compiled from: WidgetSettingsPrivacy.kt */
    public static final class C96882 extends AbstractC12240o implements Function1<Set<? extends Long>, Unit> {
        public final /* synthetic */ boolean $defaultGuildsRestricted;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C96882(boolean z2) {
            super(1);
            this.$defaultGuildsRestricted = z2;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
            invoke2((Set<Long>) set);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Set<Long> set) {
            StoreStream.INSTANCE.getUserSettings().setDefaultGuildsRestricted(WidgetSettingsPrivacy.this.getAppActivity(), this.$defaultGuildsRestricted, set);
        }
    }

    public WidgetSettingsPrivacy() {
        super(C5419R.layout.widget_settings_privacy);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsPrivacy$binding$2.INSTANCE, null, 2, null);
        this.explicitContentRadios = C12083g.lazy(new WidgetSettingsPrivacy$explicitContentRadios$2(this));
        this.friendSourceRadios = C12083g.lazy(new WidgetSettingsPrivacy$friendSourceRadios$2(this));
        this.userSettings = StoreStream.INSTANCE.getUserSettings();
    }

    private final void configureContactSyncOptions(final Model model) {
        LinearLayout linearLayout = getBinding().f18059j;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyContactSync");
        linearLayout.setVisibility(model.getShowContactSync() ? 0 : 8);
        if (model.getShowContactSync()) {
            TextView textView = getBinding().f18053d;
            C12238m.checkNotNullExpressionValue(textView, "binding.contactSyncSettingInfo");
            C1107b.m221m(textView, C5419R.string.contact_sync_info_settings_2, new Object[0], new C96611());
            TextView textView2 = getBinding().f18053d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.contactSyncSettingInfo");
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            CheckedSetting checkedSetting = getBinding().f18052c;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.contactSyncSettingEnabled");
            ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
            checkedSetting.setChecked(contactSyncConnection != null && contactSyncConnection.getFriendSync());
            CheckedSetting checkedSetting2 = getBinding().f18054e;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.contactSyncSettingPhone");
            checkedSetting2.setChecked((model.getUserDiscoveryFlags() & 2) == 2);
            CheckedSetting checkedSetting3 = getBinding().f18051b;
            C12238m.checkNotNullExpressionValue(checkedSetting3, "binding.contactSyncSettingEmail");
            checkedSetting3.setChecked((model.getUserDiscoveryFlags() & 4) == 4);
            getBinding().f18052c.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.this.getBinding().f18052c;
                    C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEnabled");
                    boolean z2 = !checkedSetting4.isChecked();
                    if (model.getContactSyncConnection() == null) {
                        if (z2) {
                            AnalyticsTracker.INSTANCE.openModal("Contact Sync", new Traits.Location(Traits.Location.Page.USER_SETTINGS, null, null, null, null, 30, null));
                            ContactSyncFlowAnalytics.Companion.trackStart$default(ContactSyncFlowAnalytics.INSTANCE, false, C12134g0.mapOf(C12116o.m10073to("location_page", Traits.Location.Page.USER_SETTINGS)), 1, null);
                            WidgetContactSync.Companion.launch$default(WidgetContactSync.INSTANCE, WidgetSettingsPrivacy.this.requireContext(), null, false, false, false, 30, null);
                            return;
                        }
                        return;
                    }
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    CheckedSetting checkedSetting5 = WidgetSettingsPrivacy.this.getBinding().f18054e;
                    C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingPhone");
                    boolean zIsChecked = checkedSetting5.isChecked();
                    CheckedSetting checkedSetting6 = WidgetSettingsPrivacy.this.getBinding().f18051b;
                    C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.contactSyncSettingEmail");
                    analyticsTracker.contactSyncToggled(z2, zIsChecked, checkedSetting6.isChecked());
                    WidgetSettingsPrivacy.this.toggleContactSync(model.getContactSyncConnection(), z2);
                }
            });
            getBinding().f18054e.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.this.getBinding().f18054e;
                    C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingPhone");
                    boolean z2 = !checkedSetting4.isChecked();
                    CheckedSetting checkedSetting5 = WidgetSettingsPrivacy.this.getBinding().f18051b;
                    C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingEmail");
                    boolean zIsChecked = checkedSetting5.isChecked();
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    CheckedSetting checkedSetting6 = WidgetSettingsPrivacy.this.getBinding().f18052c;
                    C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.contactSyncSettingEnabled");
                    boolean zIsChecked2 = checkedSetting6.isChecked();
                    CheckedSetting checkedSetting7 = WidgetSettingsPrivacy.this.getBinding().f18051b;
                    C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.contactSyncSettingEmail");
                    analyticsTracker.contactSyncToggled(zIsChecked2, z2, checkedSetting7.isChecked());
                    WidgetSettingsPrivacy.this.updateFriendDiscoveryFlags(z2, zIsChecked);
                }
            });
            getBinding().f18051b.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    CheckedSetting checkedSetting4 = WidgetSettingsPrivacy.this.getBinding().f18051b;
                    C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingEmail");
                    boolean z2 = !checkedSetting4.isChecked();
                    CheckedSetting checkedSetting5 = WidgetSettingsPrivacy.this.getBinding().f18054e;
                    C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingPhone");
                    boolean zIsChecked = checkedSetting5.isChecked();
                    AnalyticsTracker analyticsTracker = AnalyticsTracker.INSTANCE;
                    CheckedSetting checkedSetting6 = WidgetSettingsPrivacy.this.getBinding().f18052c;
                    C12238m.checkNotNullExpressionValue(checkedSetting6, "binding.contactSyncSettingEnabled");
                    boolean zIsChecked2 = checkedSetting6.isChecked();
                    CheckedSetting checkedSetting7 = WidgetSettingsPrivacy.this.getBinding().f18054e;
                    C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.contactSyncSettingPhone");
                    analyticsTracker.contactSyncToggled(zIsChecked2, checkedSetting7.isChecked(), z2);
                    WidgetSettingsPrivacy.this.updateFriendDiscoveryFlags(zIsChecked, z2);
                }
            });
            CheckedSetting checkedSetting4 = getBinding().f18055f;
            C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.contactSyncSettingStaffOnly");
            checkedSetting4.setVisibility(UserUtils.INSTANCE.isStaff(model.getMe()) ? 0 : 8);
            CheckedSetting checkedSetting5 = getBinding().f18055f;
            C12238m.checkNotNullExpressionValue(checkedSetting5, "binding.contactSyncSettingStaffOnly");
            checkedSetting5.setChecked(true);
            getBinding().f18055f.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureContactSyncOptions.5
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
        CheckedSetting checkedSetting = getBinding().f18062m;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyDefaultRestrictedGuilds");
        checkedSetting.setChecked(!model.getDefaultRestrictedGuilds());
        getBinding().f18062m.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureDefaultGuildsRestricted.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsPrivacy.this.showDefaultGuildsRestrictedExistingServers(!model.getDefaultRestrictedGuilds());
            }
        });
    }

    private final void configureExplicitContentRadio(Model model, CheckedSetting radio, final int explicitContentFilter) {
        RadioManager radioManager;
        radio.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureExplicitContentRadio.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StoreStream.INSTANCE.getUserSettings().setExplicitContentFilter(WidgetSettingsPrivacy.this.getAppActivity(), explicitContentFilter);
            }
        });
        if (this.radioManagerExplicit == null || model.getExplicitContentFilter() != explicitContentFilter || (radioManager = this.radioManagerExplicit) == null) {
            return;
        }
        radioManager.m8550a(radio);
    }

    private final void configureFriendSourceRadio(Model model) {
        getFriendSourceRadios().get(0).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureFriendSourceRadio.1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                C12238m.checkNotNullExpressionValue(bool, "checked");
                widgetSettingsPrivacy.updateFriendSourceFlags(0, bool.booleanValue());
            }
        });
        getFriendSourceRadios().get(1).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureFriendSourceRadio.2
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                C12238m.checkNotNullExpressionValue(bool, "checked");
                widgetSettingsPrivacy.updateFriendSourceFlags(1, bool.booleanValue());
            }
        });
        getFriendSourceRadios().get(2).setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureFriendSourceRadio.3
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                WidgetSettingsPrivacy widgetSettingsPrivacy = WidgetSettingsPrivacy.this;
                C12238m.checkNotNullExpressionValue(bool, "checked");
                widgetSettingsPrivacy.updateFriendSourceFlags(2, bool.booleanValue());
            }
        });
        ModelUserSettings.FriendSourceFlags friendSourceFlags = model.getFriendSourceFlags();
        boolean zIsAll = friendSourceFlags != null ? friendSourceFlags.isAll() : false;
        CheckedSetting checkedSetting = getFriendSourceRadios().get(0);
        C12238m.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        checkedSetting.setChecked(zIsAll);
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        C12238m.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        CheckedSetting checkedSetting3 = checkedSetting2;
        ModelUserSettings.FriendSourceFlags friendSourceFlags2 = model.getFriendSourceFlags();
        checkedSetting3.setChecked((friendSourceFlags2 != null ? friendSourceFlags2.isMutualFriends() : false) || zIsAll);
        CheckedSetting checkedSetting4 = getFriendSourceRadios().get(2);
        C12238m.checkNotNullExpressionValue(checkedSetting4, "friendSourceRadios[2]");
        CheckedSetting checkedSetting5 = checkedSetting4;
        ModelUserSettings.FriendSourceFlags friendSourceFlags3 = model.getFriendSourceFlags();
        checkedSetting5.setChecked((friendSourceFlags3 != null ? friendSourceFlags3.isMutualGuilds() : false) || zIsAll);
    }

    private final void configurePrivacyControls(Model model) {
        Context context = getContext();
        if (context != null) {
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            LinearLayout linearLayout = getBinding().f18060k;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsPrivacyControls");
            linearLayout.setVisibility(0);
            CheckedSetting checkedSetting = getBinding().f18075z;
            C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsPrivacyStatistics");
            checkedSetting.setChecked(model.getConsents().getUsageStatistics().getConsented());
            getBinding().f18075z.setOnCheckedListener(new C96711(context));
            CheckedSetting checkedSetting2 = getBinding().f18071v;
            C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
            checkedSetting2.setChecked(model.getConsents().getPersonalization().getConsented());
            getBinding().f18071v.setOnCheckedListener(new C96722(context));
        }
    }

    private final void configureRequestDataButton(final boolean isMeVerified, final RestAPI.HarvestState harvestState) {
        getBinding().f18072w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.configureRequestDataButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                RestAPI.HarvestState harvestState2;
                Context context = WidgetSettingsPrivacy.this.getContext();
                if (context != null) {
                    C12238m.checkNotNullExpressionValue(context, "context ?: return@setOnClickListener");
                    if (!isMeVerified || (harvestState2 = harvestState) == null) {
                        C0876m.m171i(WidgetSettingsPrivacy.this, C5419R.string.data_privacy_controls_request_data_tooltip, 0, 4);
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
        C12238m.checkNotNullExpressionValue(checkedSetting, "explicitContentRadios[0]");
        configureExplicitContentRadio(model, checkedSetting, 0);
        CheckedSetting checkedSetting2 = getExplicitContentRadios().get(1);
        C12238m.checkNotNullExpressionValue(checkedSetting2, "explicitContentRadios[1]");
        configureExplicitContentRadio(model, checkedSetting2, 1);
        CheckedSetting checkedSetting3 = getExplicitContentRadios().get(2);
        C12238m.checkNotNullExpressionValue(checkedSetting3, "explicitContentRadios[2]");
        configureExplicitContentRadio(model, checkedSetting3, 2);
        configurePrivacyControls(model);
        configureRequestDataButton(model.getMe().isVerified(), model.getHarvestState());
    }

    private final void confirmConsent(Context context, Function5<? super AlertDialog, ? super TextView, ? super TextView, ? super TextView, ? super TextView, Unit> function5) {
        ViewDialogConfirmationBinding viewDialogConfirmationBindingM8393a = ViewDialogConfirmationBinding.m8393a(getLayoutInflater().inflate(C5419R.layout.view_dialog_confirmation, (ViewGroup) null, false));
        C12238m.checkNotNullExpressionValue(viewDialogConfirmationBindingM8393a, "ViewDialogConfirmationBi…outInflater, null, false)");
        AlertDialog alertDialogCreate = new AlertDialog.Builder(context).setView(viewDialogConfirmationBindingM8393a.f15420a).setCancelable(false).create();
        C12238m.checkNotNullExpressionValue(alertDialogCreate, "AlertDialog.Builder(this…(false)\n        .create()");
        TextView textView = viewDialogConfirmationBindingM8393a.f15423d;
        C12238m.checkNotNullExpressionValue(textView, "binding.viewDialogConfirmationHeader");
        TextView textView2 = viewDialogConfirmationBindingM8393a.f15424e;
        C12238m.checkNotNullExpressionValue(textView2, "binding.viewDialogConfirmationText");
        MaterialButton materialButton = viewDialogConfirmationBindingM8393a.f15421b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.viewDialogConfirmationCancel");
        MaterialButton materialButton2 = viewDialogConfirmationBindingM8393a.f15422c;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.viewDialogConfirmationConfirm");
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
        C96774 c96774 = new C96774(context, new C96763(context, new C96752(context), new C96741(context)));
        if (harvestState instanceof RestAPI.HarvestState.NeverRequested) {
            c96774.invoke2();
            return;
        }
        if (harvestState instanceof RestAPI.HarvestState.LastRequested) {
            Harvest data = ((RestAPI.HarvestState.LastRequested) harvestState).getData();
            if (Harvest.canRequest$default(data, 0L, 1, null)) {
                c96774.invoke2();
            } else {
                showNextAvailableRequestAlert(data.nextAvailableRequestInMillis());
            }
        }
    }

    private final void showDefaultGuildsRestrictedExistingServers(final boolean defaultGuildsRestricted) {
        View viewInflate = getLayoutInflater().inflate(C5419R.layout.widget_settings_privacy_defaults, (ViewGroup) null, false);
        int i = C5419R.id.settings_privacy_defaults_existing_no;
        MaterialButton materialButton = (MaterialButton) viewInflate.findViewById(C5419R.id.settings_privacy_defaults_existing_no);
        if (materialButton != null) {
            i = C5419R.id.settings_privacy_defaults_existing_yes;
            MaterialButton materialButton2 = (MaterialButton) viewInflate.findViewById(C5419R.id.settings_privacy_defaults_existing_yes);
            if (materialButton2 != null) {
                LinearLayout linearLayout = (LinearLayout) viewInflate;
                C12238m.checkNotNullExpressionValue(new C0926b6(linearLayout, materialButton, materialButton2), "WidgetSettingsPrivacyDef…outInflater, null, false)");
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
                C12238m.checkNotNullExpressionValue(linearLayout, "binding.root");
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
            C12238m.checkNotNullExpressionValue(context, "context ?: return");
            WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(context).setTitle(C5419R.string.data_privacy_rate_limit_title).setMessage(C1107b.m216h(context, C5419R.string.data_download_requested_status_note, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, nextAvailableRequestMillis, context, 0, 4, null)}, null, 4)), C5419R.string.okay, (Function1) null, 2, (Object) null);
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            positiveButton$default.show(parentFragmentManager);
        }
    }

    private final void toggleConsent(final boolean consented, String consentType, final CheckedSetting toggle) {
        ObservableExtensionsKt.withDimmer(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().setConsent(consented, consentType), this, null, 2, null), getBinding().f18056g, 100L).m11108k(C0879o.f566a.m184g(getContext(), new C96851(toggle), new Action1<Error>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.toggleConsent.2
            @Override // p658rx.functions.Action1
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
        Observable c12721k;
        if (applyToExistingGuilds) {
            c12721k = !defaultGuildsRestricted ? new C12721k(C12148n0.emptySet()) : StoreStream.INSTANCE.getGuilds().observeGuilds().m11083G(new InterfaceC12589b<Map<Long, ? extends Guild>, Set<? extends Long>>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.updateDefaultGuildsRestricted.1
                @Override // p637j0.p641k.InterfaceC12589b
                public /* bridge */ /* synthetic */ Set<? extends Long> call(Map<Long, ? extends Guild> map) {
                    return call2((Map<Long, Guild>) map);
                }

                /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                public final Set<Long> call2(Map<Long, Guild> map) {
                    return map.keySet();
                }
            });
        } else {
            c12721k = new C12721k(null);
        }
        Observable observableM11100Z = c12721k.m11100Z(1);
        C12238m.checkNotNullExpressionValue(observableM11100Z, "when {\n      !applyToExi… }\n    }\n        .take(1)");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11100Z), this, null, 2, null), (Class<?>) WidgetSettingsPrivacy.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96882(defaultGuildsRestricted));
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
        C12238m.checkNotNullExpressionValue(checkedSetting, "friendSourceRadios[0]");
        boolean zIsChecked = checkedSetting.isChecked();
        CheckedSetting checkedSetting2 = getFriendSourceRadios().get(1);
        C12238m.checkNotNullExpressionValue(checkedSetting2, "friendSourceRadios[1]");
        boolean zIsChecked2 = checkedSetting2.isChecked();
        CheckedSetting checkedSetting3 = getFriendSourceRadios().get(2);
        C12238m.checkNotNullExpressionValue(checkedSetting3, "friendSourceRadios[2]");
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.privacy_and_safety);
        this.radioManagerExplicit = new RadioManager(getExplicitContentRadios());
        CheckedSetting checkedSetting = getBinding().f18071v;
        CheckedSetting checkedSetting2 = getBinding().f18071v;
        C12238m.checkNotNullExpressionValue(checkedSetting2, "binding.settingsPrivacyPersonalization");
        C0862f c0862f = C0862f.f507a;
        checkedSetting.m8530h(C1107b.m212d(checkedSetting2, C5419R.string.data_privacy_controls_personalization_note_learn_more, new Object[]{c0862f.m149a(360004109911L, null)}, (4 & 4) != 0 ? C1107b.c.f1492j : null), true);
        CheckedSetting checkedSetting3 = getBinding().f18074y;
        CheckedSetting checkedSetting4 = getBinding().f18074y;
        C12238m.checkNotNullExpressionValue(checkedSetting4, "binding.settingsPrivacyScreenreaderDetection");
        checkedSetting3.m8530h(C1107b.m212d(checkedSetting4, C5419R.string.data_privacy_controls_allow_accessibility_detection_note, new Object[]{c0862f.m149a(360035966492L, null)}, (4 & 4) != 0 ? C1107b.c.f1492j : null), true);
        final CheckedSetting checkedSetting5 = getBinding().f18074y;
        checkedSetting5.setOnCheckedListener(new Action1<Boolean>() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy$onViewBound$$inlined$apply$lambda$1
            @Override // p658rx.functions.Action1
            public final void call(Boolean bool) {
                StoreUserSettings storeUserSettings = this.userSettings;
                C12238m.checkNotNullExpressionValue(bool, "checked");
                ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(storeUserSettings.setIsAccessibilityDetectionAllowed(bool.booleanValue()), false, 1, null), (Class<?>) checkedSetting5.getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), WidgetSettingsPrivacy$onViewBound$1$1$1.INSTANCE);
            }
        });
        getBinding().f18058i.setButtonVisibility(false);
        CheckedSetting checkedSetting6 = getBinding().f18058i;
        CheckedSetting checkedSetting7 = getBinding().f18058i;
        C12238m.checkNotNullExpressionValue(checkedSetting7, "binding.settingsPrivacyBasicService");
        checkedSetting6.m8530h(C1107b.m212d(checkedSetting7, C5419R.string.data_privacy_controls_basic_service_note, new Object[0], C96782.INSTANCE), true);
        getBinding().f18058i.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetSettingsAccount.Companion companion = WidgetSettingsAccount.INSTANCE;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                WidgetSettingsAccount.Companion.launch$default(companion, context, true, null, 4, null);
            }
        });
        final String strM149a = c0862f.m149a(360004027692L, null);
        TextView textView = getBinding().f18057h;
        C12238m.checkNotNullExpressionValue(textView, "binding.requestDataLink");
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        TextView textView2 = getBinding().f18057h;
        C12238m.checkNotNullExpressionValue(textView2, "binding.requestDataLink");
        sb.append(C1107b.m212d(textView2, C5419R.string.notice_whats_this, new Object[0], (4 & 4) != 0 ? C1107b.c.f1492j : null));
        sb.append("](");
        sb.append(strM149a);
        sb.append(')');
        textView.setText(C1107b.m215g(sb.toString(), new Object[0], (2 & 2) != 0 ? C1107b.e.f1494j : null));
        getBinding().f18057h.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.WidgetSettingsPrivacy.onViewBound.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m885x(view2, "it", "it.context"), strM149a, false, false, null, 28, null);
            }
        });
        CheckedSetting checkedSetting8 = getBinding().f18075z;
        CheckedSetting checkedSetting9 = getBinding().f18075z;
        C12238m.checkNotNullExpressionValue(checkedSetting9, "binding.settingsPrivacyStatistics");
        checkedSetting8.m8530h(C1107b.m212d(checkedSetting9, C5419R.string.data_privacy_controls_usage_statistics_note, new Object[]{c0862f.m149a(360004109911L, null)}, (4 & 4) != 0 ? C1107b.c.f1492j : null), true);
        for (TextView textView3 : C12147n.listOf((Object[]) new TextView[]{getBinding().f18073x, getBinding().f18063n, getBinding().f18070u, getBinding().f18061l})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView3, "header");
            accessibilityUtils.setViewIsHeading(textView3);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(Model.INSTANCE.get(), this, null, 2, null), (Class<?>) WidgetSettingsPrivacy.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96811(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(this.userSettings.observeIsAccessibilityDetectionAllowed(), this, null, 2, null), (Class<?>) WidgetSettingsPrivacy.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C96822());
    }
}
