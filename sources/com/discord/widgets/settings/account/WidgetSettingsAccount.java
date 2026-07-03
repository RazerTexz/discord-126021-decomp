package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.C5419R;
import com.discord.api.auth.mfa.DisableMfaRequestBody;
import com.discord.api.auth.mfa.DisableMfaResponse;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsAccountBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.models.experiments.domain.Experiment;
import com.discord.models.guild.Guild;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMFA;
import com.discord.stores.StoreNotices;
import com.discord.stores.StoreStream;
import com.discord.stores.StoreUser;
import com.discord.stores.StoreUserConnections;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.account.WidgetDisableDeleteAccountDialog;
import com.discord.widgets.settings.account.WidgetEnableSMSBackupDialog;
import com.discord.widgets.settings.account.WidgetSettingsAccount;
import com.discord.widgets.settings.account.WidgetSettingsAccountBackupCodes;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import com.discord.widgets.settings.account.WidgetSettingsAccountContactsNameEdit;
import com.discord.widgets.settings.account.WidgetSettingsAccountEmailEdit;
import com.discord.widgets.settings.account.WidgetSettingsAccountUsernameEdit;
import com.discord.widgets.settings.account.WidgetSettingsBlockedUsers;
import com.discord.widgets.settings.account.mfa.WidgetEnableMFASteps;
import com.discord.widgets.user.account.WidgetUserAccountVerifyBase;
import com.discord.widgets.user.email.WidgetUserEmailVerify;
import com.discord.widgets.user.phone.WidgetUserPhoneManage;
import com.google.android.material.button.MaterialButton;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p580t.C12147n;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func5;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String EXTRA_HINT_DATA_MANAGEMENT = "com.discord.extra.HINT_DATA_MANAGEMENT";
    private static final String EXTRA_REDIRECT = "extra_redirect";
    private static final int MFA_DISABLED_VIEW_INDEX = 1;
    private static final int MFA_ENABLED_VIEW_INDEX = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public static final class Companion {
        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, boolean z2, Redirect redirect, int i, Object obj) {
            if ((i & 2) != 0) {
                z2 = false;
            }
            if ((i & 4) != 0) {
                redirect = null;
            }
            companion.launch(context, z2, redirect);
        }

        public final void launch(Context context) {
            launch$default(this, context, false, null, 6, null);
        }

        public final void launch(Context context, boolean z2) {
            launch$default(this, context, z2, null, 4, null);
        }

        public final void launch(Context context, boolean hintDataManagement, Redirect redirect) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccount.EXTRA_HINT_DATA_MANAGEMENT, hintDataManagement);
            intent.putExtra(WidgetSettingsAccount.EXTRA_REDIRECT, redirect);
            if (redirect != null) {
                intent.addFlags(268435456);
                intent.addFlags(67108864);
            }
            C0870j.m156d(context, WidgetSettingsAccount.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public static final /* data */ class Model {

        /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
        public static final Companion INSTANCE = new Companion(null);
        private final ConnectedAccount contactSyncConnection;
        private final MeUser meUser;
        private final boolean ownsAnyGuilds;
        private final StoreMFA.State pendingMFAState;

        /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
        public static final class Companion {
            private Companion() {
            }

            public final Observable<Model> get() {
                StoreStream.Companion companion = StoreStream.INSTANCE;
                Observable<Model> observableM11072g = Observable.m11072g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getMFA().observeState(), companion.getGuilds().observeGuilds(), companion.getUserConnections().observeConnectedAccounts(), companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true), new Func5<MeUser, StoreMFA.State, Map<Long, ? extends Guild>, StoreUserConnections.State, Experiment, Model>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount$Model$Companion$get$1
                    @Override // p658rx.functions.Func5
                    public /* bridge */ /* synthetic */ WidgetSettingsAccount.Model call(MeUser meUser, StoreMFA.State state, Map<Long, ? extends Guild> map, StoreUserConnections.State state2, Experiment experiment) {
                        return call2(meUser, state, (Map<Long, Guild>) map, state2, experiment);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetSettingsAccount.Model call2(MeUser meUser, StoreMFA.State state, Map<Long, Guild> map, StoreUserConnections.State state2, Experiment experiment) {
                        ConnectedAccount connectedAccount;
                        ConnectedAccount connectedAccountPrevious;
                        C12238m.checkNotNullExpressionValue(state2, "connectedAccounts");
                        ListIterator<ConnectedAccount> listIterator = state2.listIterator(state2.size());
                        do {
                            connectedAccount = null;
                            if (!listIterator.hasPrevious()) {
                                connectedAccountPrevious = null;
                                break;
                            }
                            connectedAccountPrevious = listIterator.previous();
                        } while (!C12238m.areEqual(connectedAccountPrevious.getType(), "contacts"));
                        ConnectedAccount connectedAccount2 = connectedAccountPrevious;
                        boolean z2 = true;
                        if (experiment != null && experiment.getBucket() == 1) {
                            connectedAccount = connectedAccount2;
                        }
                        C12238m.checkNotNullExpressionValue(meUser, "meUser");
                        C12238m.checkNotNullExpressionValue(state, "pendingMFAState");
                        Collection<Guild> collectionValues = map.values();
                        if ((collectionValues instanceof Collection) && collectionValues.isEmpty()) {
                            z2 = false;
                        } else {
                            Iterator<T> it = collectionValues.iterator();
                            while (it.hasNext()) {
                                if (((Guild) it.next()).getOwnerId() == meUser.getId()) {
                                }
                            }
                            z2 = false;
                        }
                        return new WidgetSettingsAccount.Model(meUser, state, z2, connectedAccount);
                    }
                });
                C12238m.checkNotNullExpressionValue(observableM11072g, "Observable.combineLatest…            )\n          }");
                return observableM11072g;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, StoreMFA.State state, boolean z2, ConnectedAccount connectedAccount) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(state, "pendingMFAState");
            this.meUser = meUser;
            this.pendingMFAState = state;
            this.ownsAnyGuilds = z2;
            this.contactSyncConnection = connectedAccount;
        }

        public static /* synthetic */ Model copy$default(Model model, MeUser meUser, StoreMFA.State state, boolean z2, ConnectedAccount connectedAccount, int i, Object obj) {
            if ((i & 1) != 0) {
                meUser = model.meUser;
            }
            if ((i & 2) != 0) {
                state = model.pendingMFAState;
            }
            if ((i & 4) != 0) {
                z2 = model.ownsAnyGuilds;
            }
            if ((i & 8) != 0) {
                connectedAccount = model.contactSyncConnection;
            }
            return model.copy(meUser, state, z2, connectedAccount);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final MeUser getMeUser() {
            return this.meUser;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final StoreMFA.State getPendingMFAState() {
            return this.pendingMFAState;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final boolean getOwnsAnyGuilds() {
            return this.ownsAnyGuilds;
        }

        /* JADX INFO: renamed from: component4, reason: from getter */
        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final Model copy(MeUser meUser, StoreMFA.State pendingMFAState, boolean ownsAnyGuilds, ConnectedAccount contactSyncConnection) {
            C12238m.checkNotNullParameter(meUser, "meUser");
            C12238m.checkNotNullParameter(pendingMFAState, "pendingMFAState");
            return new Model(meUser, pendingMFAState, ownsAnyGuilds, contactSyncConnection);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Model)) {
                return false;
            }
            Model model = (Model) other;
            return C12238m.areEqual(this.meUser, model.meUser) && C12238m.areEqual(this.pendingMFAState, model.pendingMFAState) && this.ownsAnyGuilds == model.ownsAnyGuilds && C12238m.areEqual(this.contactSyncConnection, model.contactSyncConnection);
        }

        public final ConnectedAccount getContactSyncConnection() {
            return this.contactSyncConnection;
        }

        public final MeUser getMeUser() {
            return this.meUser;
        }

        public final boolean getOwnsAnyGuilds() {
            return this.ownsAnyGuilds;
        }

        public final StoreMFA.State getPendingMFAState() {
            return this.pendingMFAState;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4, types: [int] */
        /* JADX WARN: Type inference failed for: r2v6 */
        /* JADX WARN: Type inference failed for: r2v8 */
        public int hashCode() {
            MeUser meUser = this.meUser;
            int iHashCode = (meUser != null ? meUser.hashCode() : 0) * 31;
            StoreMFA.State state = this.pendingMFAState;
            int iHashCode2 = (iHashCode + (state != null ? state.hashCode() : 0)) * 31;
            boolean z2 = this.ownsAnyGuilds;
            ?? r2 = z2;
            if (z2) {
                r2 = 1;
            }
            int i = (iHashCode2 + r2) * 31;
            ConnectedAccount connectedAccount = this.contactSyncConnection;
            return i + (connectedAccount != null ? connectedAccount.hashCode() : 0);
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("Model(meUser=");
            sbM833U.append(this.meUser);
            sbM833U.append(", pendingMFAState=");
            sbM833U.append(this.pendingMFAState);
            sbM833U.append(", ownsAnyGuilds=");
            sbM833U.append(this.ownsAnyGuilds);
            sbM833U.append(", contactSyncConnection=");
            sbM833U.append(this.contactSyncConnection);
            sbM833U.append(")");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public enum Redirect {
        SMS_BACKUP
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    @InterfaceC12188e(m10084c = "com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1", m10085f = "WidgetSettingsAccount.kt", m10086l = {65}, m10087m = "invokeSuspend")
    public static final class C97301 extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public C97301(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return WidgetSettingsAccount.this.new C97301(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C97301) create(coroutineScope, continuation)).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            NestedScrollView nestedScrollView = WidgetSettingsAccount.this.getBinding().f17815x;
            LinearLayout linearLayout = WidgetSettingsAccount.this.getBinding().f17813v;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            nestedScrollView.smoothScrollTo(0, linearLayout.getBottom());
            TextView textView = WidgetSettingsAccount.this.getBinding().f17812u;
            C12238m.checkNotNullExpressionValue(textView, "binding.settingsAccountPrivateDataDisable");
            ViewExtensions.hintWithRipple$default(textView, 0L, 1, null);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public static final class C97311 extends AbstractC12240o implements Function1<Model, Unit> {
        public C97311() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSettingsAccount widgetSettingsAccount = WidgetSettingsAccount.this;
            C12238m.checkNotNullExpressionValue(model, "it");
            widgetSettingsAccount.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$showRemove2FAModal$1 */
    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public static final class C97321 extends AbstractC12240o implements Function2<Context, String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$showRemove2FAModal$1$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<DisableMfaResponse, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DisableMfaResponse disableMfaResponse) {
                invoke2(disableMfaResponse);
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DisableMfaResponse disableMfaResponse) {
                C12238m.checkNotNullParameter(disableMfaResponse, "it");
                C0876m.m170h(WidgetSettingsAccount.this.requireContext(), WidgetSettingsAccount.this.requireContext().getString(C5419R.string.user_settings_mfa_removed), 0, null, 12);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getAuthentication().setAuthed(disableMfaResponse.getToken());
                companion.getMFA().updatePendingMFAState(StoreMFA.MFAActivationState.PENDING_DISABLED);
            }
        }

        public C97321() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
            invoke2(context, str);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str) {
            C12238m.checkNotNullParameter(context, "<anonymous parameter 0>");
            C12238m.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().disableMFA(new DisableMfaRequestBody(str)), WidgetSettingsAccount.this, null, 2, null), WidgetSettingsAccount.this.getBinding().f17793b, 0L, 2, null), false, 1, null), (Class<?>) WidgetSettingsAccount.class, (58 & 2) != 0 ? null : WidgetSettingsAccount.this.requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new AnonymousClass1());
        }
    }

    public WidgetSettingsAccount() {
        super(C5419R.layout.widget_settings_account);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccount$binding$2.INSTANCE, null, 2, null);
    }

    private final void configureAccountVerificationBanner(MeUser user) {
        RelativeLayout relativeLayout = getBinding().f17787C;
        C12238m.checkNotNullExpressionValue(relativeLayout, "binding.settingsAccountVerification");
        relativeLayout.setVisibility(user.isVerified() ^ true ? 0 : 8);
        if (user.getEmail() == null) {
            TextView textView = getBinding().f17789E;
            C12238m.checkNotNullExpressionValue(textView, "binding.settingsAccountVerificationTitle");
            textView.setText(getString(C5419R.string.add_email_banner_title));
            MaterialButton materialButton = getBinding().f17788D;
            C12238m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountVerificationButton");
            materialButton.setText(getString(C5419R.string.add_email_short));
        } else {
            TextView textView2 = getBinding().f17789E;
            C12238m.checkNotNullExpressionValue(textView2, "binding.settingsAccountVerificationTitle");
            textView2.setText(getString(C5419R.string.verify_your_email));
            MaterialButton materialButton2 = getBinding().f17788D;
            C12238m.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountVerificationButton");
            materialButton2.setText(getString(C5419R.string.verify));
        }
        getBinding().f17788D.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureAccountVerificationBanner.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserEmailVerify.INSTANCE.launch(C1643a.m885x(view, "v", "v.context"), WidgetUserAccountVerifyBase.Mode.UNFORCED);
            }
        });
    }

    private final void configureMFA(boolean enabled, boolean pending) {
        TextView textView = getBinding().f17803l;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsAccountMfaEnabledHeader");
        textView.setVisibility(enabled ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().f17804m;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!enabled ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().f17805n;
        C12238m.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        TextView textView2 = getBinding().f17806o;
        C12238m.checkNotNullExpressionValue(textView2, "binding.settingsAccountMfaSalesPitch");
        textView2.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        MaterialButton materialButton = getBinding().f17801j;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility((!enabled ? 1 : 0) == 0 ? 8 : 0);
        MaterialButton materialButton2 = getBinding().f17801j;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountMfaEnable");
        materialButton2.setEnabled(!pending);
        TextView textView3 = getBinding().f17790F;
        C12238m.checkNotNullExpressionValue(textView3, "binding.settingsAccountViewBackupCodes");
        textView3.setEnabled(!pending);
        TextView textView4 = getBinding().f17814w;
        C12238m.checkNotNullExpressionValue(textView4, "binding.settingsAccountRemoveTwoFa");
        textView4.setEnabled(!pending);
        LinearLayout linearLayout = getBinding().f17800i;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountMfaDisabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout, !pending, 0.0f, 2, null);
        LinearLayout linearLayout2 = getBinding().f17802k;
        C12238m.checkNotNullExpressionValue(linearLayout2, "binding.settingsAccountMfaEnabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout2, !pending, 0.0f, 2, null);
    }

    private final void configureUI(final Model model) {
        String name;
        final MeUser meUser = model.getMeUser();
        StoreMFA.State pendingMFAState = model.getPendingMFAState();
        ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
        configureAccountVerificationBanner(meUser);
        LinearLayout linearLayout = getBinding().f17807p;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountNameContainer");
        linearLayout.setVisibility(contactSyncConnection != null ? 0 : 8);
        TextView textView = getBinding().f17808q;
        C12238m.checkNotNullExpressionValue(textView, "binding.settingsAccountNameText");
        if (contactSyncConnection == null || (name = contactSyncConnection.getName()) == null) {
            name = "";
        }
        textView.setText(name);
        TextView textView2 = getBinding().f17786B;
        C12238m.checkNotNullExpressionValue(textView2, "binding.settingsAccountTagText");
        UserUtils userUtils = UserUtils.INSTANCE;
        textView2.setText(UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null));
        TextView textView3 = getBinding().f17797f;
        C12238m.checkNotNullExpressionValue(textView3, "binding.settingsAccountEmailText");
        textView3.setText(meUser.getEmail());
        TextView textView4 = getBinding().f17810s;
        C12238m.checkNotNullExpressionValue(textView4, "binding.settingsAccountPhoneText");
        textView4.setText(meUser.getPhoneNumber());
        getBinding().f17795d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountChangePassword.Companion companion = WidgetSettingsAccountChangePassword.INSTANCE;
                TextView textView5 = WidgetSettingsAccount.this.getBinding().f17795d;
                C12238m.checkNotNullExpressionValue(textView5, "binding.settingsAccountChangePassword");
                Context context = textView5.getContext();
                C12238m.checkNotNullExpressionValue(context, "binding.settingsAccountChangePassword.context");
                companion.launch(context);
            }
        });
        getBinding().f17785A.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountUsernameEdit.Companion companion = WidgetSettingsAccountUsernameEdit.INSTANCE;
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().f17807p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountContactsNameEdit.Companion companion = WidgetSettingsAccountContactsNameEdit.INSTANCE;
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().f17796e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean zIsVerified = meUser.isVerified();
                Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2022-01_email_change_confirmation", zIsVerified);
                boolean z2 = userExperiment != null && userExperiment.getBucket() == 1 && zIsVerified;
                WidgetSettingsAccountEmailEdit.Companion companion = WidgetSettingsAccountEmailEdit.INSTANCE;
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context, z2);
            }
        });
        getBinding().f17809r.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserPhoneManage.INSTANCE.launch(C1643a.m885x(view, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.USER_SETTINGS_UPDATE);
            }
        });
        TextView textView5 = getBinding().f17803l;
        C12238m.checkNotNullExpressionValue(textView5, "binding.settingsAccountMfaEnabledHeader");
        textView5.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().f17804m;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!meUser.getMfaEnabled() ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().f17805n;
        C12238m.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        TextView textView6 = getBinding().f17806o;
        C12238m.checkNotNullExpressionValue(textView6, "binding.settingsAccountMfaSalesPitch");
        textView6.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().f17801j;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        if (pendingMFAState.getActivationState() != StoreMFA.MFAActivationState.NONE) {
            configureMFA(pendingMFAState.getActivationState() == StoreMFA.MFAActivationState.PENDING_ENABLED, true);
        } else {
            configureMFA(meUser.getMfaEnabled(), false);
        }
        getBinding().f17801j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEnableMFASteps.Companion companion = WidgetEnableMFASteps.INSTANCE;
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().f17790F.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountBackupCodes.Companion companion = WidgetSettingsAccountBackupCodes.INSTANCE;
                C12238m.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().f17814w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccount.this.showRemove2FAModal();
            }
        });
        getBinding().f17791G.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsBlockedUsers.Companion companion = WidgetSettingsBlockedUsers.INSTANCE;
                C12238m.checkNotNullExpressionValue(view, "view");
                Context context = view.getContext();
                C12238m.checkNotNullExpressionValue(context, "view.context");
                companion.launch(context);
            }
        });
        getBinding().f17812u.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getOwnsAnyGuilds()) {
                    WidgetSettingsAccount.this.showOwnsGuildModal();
                    return;
                }
                WidgetDisableDeleteAccountDialog.Companion companion = WidgetDisableDeleteAccountDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog.Mode.DISABLE);
            }
        });
        getBinding().f17811t.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getOwnsAnyGuilds()) {
                    WidgetSettingsAccount.this.showOwnsGuildModal();
                    return;
                }
                WidgetDisableDeleteAccountDialog.Companion companion = WidgetDisableDeleteAccountDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog.Mode.DELETE);
            }
        });
        String sMSBackupDisabledMessage = getSMSBackupDisabledMessage(meUser);
        if (sMSBackupDisabledMessage != null || pendingMFAState.isTogglingSMSBackup()) {
            CheckedSetting.m8523d(getBinding().f17816y, null, 1);
            TextView textView7 = getBinding().f17817z;
            C12238m.checkNotNullExpressionValue(textView7, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView7, false, 0.0f, 2, null);
        } else {
            TextView textView8 = getBinding().f17817z;
            C12238m.checkNotNullExpressionValue(textView8, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView8, true, 0.0f, 2, null);
            getBinding().f17816y.m8527e(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserUtils userUtils2 = UserUtils.INSTANCE;
                    if (userUtils2.isMfaSMSEnabled(meUser)) {
                        WidgetEnableSMSBackupDialog.Companion companion = WidgetEnableSMSBackupDialog.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, false);
                        return;
                    }
                    if (userUtils2.isMfaSMSEnabled(meUser) || !userUtils2.getHasPhone(meUser)) {
                        WidgetUserPhoneManage.INSTANCE.launch(C1643a.m885x(view, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS, WidgetUserPhoneManage.Companion.Source.MFA_PHONE_UPDATE);
                        return;
                    }
                    WidgetEnableSMSBackupDialog.Companion companion2 = WidgetEnableSMSBackupDialog.INSTANCE;
                    FragmentManager parentFragmentManager2 = WidgetSettingsAccount.this.getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    companion2.show(parentFragmentManager2, true);
                }
            });
        }
        TextView textView9 = getBinding().f17817z;
        C12238m.checkNotNullExpressionValue(textView9, "binding.settingsAccountSmsPhone");
        ViewExtensions.setTextAndVisibilityBy(textView9, meUser.getPhoneNumber() != null ? C1107b.m216h(C1643a.m821I(getBinding().f17817z, "binding.settingsAccountSmsPhone", "binding.settingsAccountSmsPhone.context"), C5419R.string.mfa_sms_auth_current_phone, new Object[]{meUser.getPhoneNumber()}, null, 4) : null);
        CheckedSetting checkedSetting = getBinding().f17816y;
        C12238m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccountSmsBackup");
        checkedSetting.setChecked(userUtils.isMfaSMSEnabled(meUser));
        CheckedSetting checkedSetting2 = getBinding().f17816y;
        if (sMSBackupDisabledMessage == null) {
            sMSBackupDisabledMessage = getString(C5419R.string.mfa_sms_auth_sales_pitch);
            C12238m.checkNotNullExpressionValue(sMSBackupDisabledMessage, "getString(R.string.mfa_sms_auth_sales_pitch)");
        }
        CheckedSetting.m8524i(checkedSetting2, sMSBackupDisabledMessage, false, 2);
        if (getMostRecentIntent().getSerializableExtra(EXTRA_REDIRECT) == Redirect.SMS_BACKUP) {
            getMostRecentIntent().removeExtra(EXTRA_REDIRECT);
            WidgetEnableSMSBackupDialog.Companion companion = WidgetEnableSMSBackupDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, true);
        }
        for (TextView textView10 : C12147n.listOf((Object[]) new TextView[]{getBinding().f17798g, getBinding().f17794c, getBinding().f17799h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView10, "header");
            accessibilityUtils.setViewIsHeading(textView10);
        }
    }

    private final WidgetSettingsAccountBinding getBinding() {
        return (WidgetSettingsAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSMSBackupDisabledMessage(MeUser user) {
        UserUtils userUtils = UserUtils.INSTANCE;
        if (userUtils.isPartner(user) || userUtils.isStaff(user)) {
            return getString(C5419R.string.mfa_sms_disabled_partner);
        }
        if (user.getEmail() == null) {
            return getString(C5419R.string.mfa_sms_disabled_no_email);
        }
        return null;
    }

    public static final void launch(Context context) {
        Companion.launch$default(INSTANCE, context, false, null, 6, null);
    }

    public static final void launch(Context context, boolean z2) {
        Companion.launch$default(INSTANCE, context, z2, null, 4, null);
    }

    public static final void launch(Context context, boolean z2, Redirect redirect) {
        INSTANCE.launch(context, z2, redirect);
    }

    private final void showOwnsGuildModal() {
        WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(C5419R.string.delete_account_transfer_ownership).setMessage(C5419R.string.delete_account_transfer_ownership_body), C5419R.string.okay, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton$default.show(parentFragmentManager);
    }

    private final void showRemove2FAModal() {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String string = requireContext().getString(C5419R.string.two_fa_remove);
            C12238m.checkNotNullExpressionValue(string, "requireContext().getString(R.string.two_fa_remove)");
            String string2 = requireContext().getString(C5419R.string.user_settings_mfa_enable_code_body);
            C12238m.checkNotNullExpressionValue(string2, "requireContext().getStri…ngs_mfa_enable_code_body)");
            String string3 = requireContext().getString(C5419R.string.two_fa_auth_code);
            C12238m.checkNotNullExpressionValue(string3, "requireContext().getStri….string.two_fa_auth_code)");
            companion.showInputModal(appActivity, string, string2, string3, new C97321(), (640 & 32) != 0 ? null : null, (640 & 64) != 0 ? null : null, (640 & 128) != 0 ? StoreNotices.InputDialog.Type.PASSWORD : null, (640 & 256) != 0 ? null : null, (640 & 512) != 0 ? false : false);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4008) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.user_settings_my_account);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        if (getMostRecentIntent().getBooleanExtra(EXTRA_HINT_DATA_MANAGEMENT, false)) {
            LinearLayout linearLayout = getBinding().f17813v;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(linearLayout);
            if (coroutineScope != null) {
                C3404f.m4211H0(coroutineScope, null, null, new C97301(null), 3, null);
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableM11112r = Model.INSTANCE.get().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "Model\n        .get()\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableM11112r), this, null, 2, null), (Class<?>) WidgetSettingsAccount.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C97311());
    }
}
