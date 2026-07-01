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
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import b.i.a.f.e.o.f;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R;
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
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.ViewCoroutineScope;
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
import d0.Result3;
import d0.t.Collections2;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
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
import rx.Observable;
import rx.Subscription;
import rx.functions.Func5;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBinding;", 0)};

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
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra(WidgetSettingsAccount.EXTRA_HINT_DATA_MANAGEMENT, hintDataManagement);
            intent.putExtra(WidgetSettingsAccount.EXTRA_REDIRECT, redirect);
            if (redirect != null) {
                intent.addFlags(268435456);
                intent.addFlags(67108864);
            }
            AppScreen2.d(context, WidgetSettingsAccount.class, intent);
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
                Observable<Model> observableG = Observable.g(StoreUser.observeMe$default(companion.getUsers(), false, 1, null), companion.getMFA().observeState(), companion.getGuilds().observeGuilds(), companion.getUserConnections().observeConnectedAccounts(), companion.getExperiments().observeUserExperiment("2021-04_contact_sync_android_main", true), new Func5<MeUser, StoreMFA.State, Map<Long, ? extends Guild>, StoreUserConnections.State, Experiment, Model>() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount$Model$Companion$get$1
                    @Override // rx.functions.Func5
                    public /* bridge */ /* synthetic */ WidgetSettingsAccount.Model call(MeUser meUser, StoreMFA.State state, Map<Long, ? extends Guild> map, StoreUserConnections.State state2, Experiment experiment) {
                        return call2(meUser, state, (Map<Long, Guild>) map, state2, experiment);
                    }

                    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
                    public final WidgetSettingsAccount.Model call2(MeUser meUser, StoreMFA.State state, Map<Long, Guild> map, StoreUserConnections.State state2, Experiment experiment) {
                        ConnectedAccount connectedAccount;
                        ConnectedAccount connectedAccountPrevious;
                        Intrinsics3.checkNotNullExpressionValue(state2, "connectedAccounts");
                        ListIterator<ConnectedAccount> listIterator = state2.listIterator(state2.size());
                        do {
                            connectedAccount = null;
                            if (!listIterator.hasPrevious()) {
                                connectedAccountPrevious = null;
                                break;
                            }
                            connectedAccountPrevious = listIterator.previous();
                        } while (!Intrinsics3.areEqual(connectedAccountPrevious.getType(), "contacts"));
                        ConnectedAccount connectedAccount2 = connectedAccountPrevious;
                        boolean z2 = true;
                        if (experiment != null && experiment.getBucket() == 1) {
                            connectedAccount = connectedAccount2;
                        }
                        Intrinsics3.checkNotNullExpressionValue(meUser, "meUser");
                        Intrinsics3.checkNotNullExpressionValue(state, "pendingMFAState");
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
                Intrinsics3.checkNotNullExpressionValue(observableG, "Observable.combineLatest…            )\n          }");
                return observableG;
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }
        }

        public Model(MeUser meUser, StoreMFA.State state, boolean z2, ConnectedAccount connectedAccount) {
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(state, "pendingMFAState");
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
            Intrinsics3.checkNotNullParameter(meUser, "meUser");
            Intrinsics3.checkNotNullParameter(pendingMFAState, "pendingMFAState");
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
            return Intrinsics3.areEqual(this.meUser, model.meUser) && Intrinsics3.areEqual(this.pendingMFAState, model.pendingMFAState) && this.ownsAnyGuilds == model.ownsAnyGuilds && Intrinsics3.areEqual(this.contactSyncConnection, model.contactSyncConnection);
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
            StringBuilder sbU = outline.U("Model(meUser=");
            sbU.append(this.meUser);
            sbU.append(", pendingMFAState=");
            sbU.append(this.pendingMFAState);
            sbU.append(", ownsAnyGuilds=");
            sbU.append(this.ownsAnyGuilds);
            sbU.append(", contactSyncConnection=");
            sbU.append(this.contactSyncConnection);
            sbU.append(")");
            return sbU.toString();
        }
    }

    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public enum Redirect {
        SMS_BACKUP
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    @DebugMetadata(c = "com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBound$1", f = "WidgetSettingsAccount.kt", l = {65}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public AnonymousClass1(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return WidgetSettingsAccount.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (f.P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            NestedScrollView nestedScrollView = WidgetSettingsAccount.this.getBinding().f2593x;
            LinearLayout linearLayout = WidgetSettingsAccount.this.getBinding().v;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            nestedScrollView.smoothScrollTo(0, linearLayout.getBottom());
            TextView textView = WidgetSettingsAccount.this.getBinding().u;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAccountPrivateDataDisable");
            ViewExtensions.hintWithRipple$default(textView, 0L, 1, null);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Model, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Model model) {
            invoke2(model);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Model model) {
            WidgetSettingsAccount widgetSettingsAccount = WidgetSettingsAccount.this;
            Intrinsics3.checkNotNullExpressionValue(model, "it");
            widgetSettingsAccount.configureUI(model);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$showRemove2FAModal$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
    public static final class AnonymousClass1 extends Lambda implements Function2<Context, String, Unit> {

        /* JADX INFO: renamed from: com.discord.widgets.settings.account.WidgetSettingsAccount$showRemove2FAModal$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetSettingsAccount.kt */
        public static final class C03341 extends Lambda implements Function1<DisableMfaResponse, Unit> {
            public C03341() {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DisableMfaResponse disableMfaResponse) {
                invoke2(disableMfaResponse);
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DisableMfaResponse disableMfaResponse) {
                Intrinsics3.checkNotNullParameter(disableMfaResponse, "it");
                AppToast.h(WidgetSettingsAccount.this.requireContext(), WidgetSettingsAccount.this.requireContext().getString(R.string.user_settings_mfa_removed), 0, null, 12);
                StoreStream.Companion companion = StoreStream.INSTANCE;
                companion.getAuthentication().setAuthed(disableMfaResponse.getToken());
                companion.getMFA().updatePendingMFAState(StoreMFA.MFAActivationState.PENDING_DISABLED);
            }
        }

        public AnonymousClass1() {
            super(2);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Context context, String str) {
            invoke2(context, str);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Context context, String str) {
            Intrinsics3.checkNotNullParameter(context, "<anonymous parameter 0>");
            Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_CODE);
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.restSubscribeOn$default(ObservableExtensionsKt.withDimmer$default(ObservableExtensionsKt.ui$default(RestAPI.INSTANCE.getApi().disableMFA(new DisableMfaRequestBody(str)), WidgetSettingsAccount.this, null, 2, null), WidgetSettingsAccount.this.getBinding().f2591b, 0L, 2, null), false, 1, null), (Class<?>) WidgetSettingsAccount.class, (58 & 2) != 0 ? null : WidgetSettingsAccount.this.requireContext(), (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new C03341());
        }
    }

    public WidgetSettingsAccount() {
        super(R.layout.widget_settings_account);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsAccount3.INSTANCE, null, 2, null);
    }

    private final void configureAccountVerificationBanner(MeUser user) {
        RelativeLayout relativeLayout = getBinding().C;
        Intrinsics3.checkNotNullExpressionValue(relativeLayout, "binding.settingsAccountVerification");
        relativeLayout.setVisibility(user.isVerified() ^ true ? 0 : 8);
        if (user.getEmail() == null) {
            TextView textView = getBinding().E;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAccountVerificationTitle");
            textView.setText(getString(R.string.add_email_banner_title));
            MaterialButton materialButton = getBinding().D;
            Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.settingsAccountVerificationButton");
            materialButton.setText(getString(R.string.add_email_short));
        } else {
            TextView textView2 = getBinding().E;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsAccountVerificationTitle");
            textView2.setText(getString(R.string.verify_your_email));
            MaterialButton materialButton2 = getBinding().D;
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountVerificationButton");
            materialButton2.setText(getString(R.string.verify));
        }
        getBinding().D.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureAccountVerificationBanner.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserEmailVerify.INSTANCE.launch(outline.x(view, "v", "v.context"), WidgetUserAccountVerifyBase.Mode.UNFORCED);
            }
        });
    }

    private final void configureMFA(boolean enabled, boolean pending) {
        TextView textView = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAccountMfaEnabledHeader");
        textView.setVisibility(enabled ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!enabled ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        TextView textView2 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsAccountMfaSalesPitch");
        textView2.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        MaterialButton materialButton = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility((!enabled ? 1 : 0) == 0 ? 8 : 0);
        MaterialButton materialButton2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountMfaEnable");
        materialButton2.setEnabled(!pending);
        TextView textView3 = getBinding().F;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.settingsAccountViewBackupCodes");
        textView3.setEnabled(!pending);
        TextView textView4 = getBinding().w;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.settingsAccountRemoveTwoFa");
        textView4.setEnabled(!pending);
        LinearLayout linearLayout = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountMfaDisabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout, !pending, 0.0f, 2, null);
        LinearLayout linearLayout2 = getBinding().k;
        Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.settingsAccountMfaEnabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout2, !pending, 0.0f, 2, null);
    }

    private final void configureUI(final Model model) {
        String name;
        final MeUser meUser = model.getMeUser();
        StoreMFA.State pendingMFAState = model.getPendingMFAState();
        ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
        configureAccountVerificationBanner(meUser);
        LinearLayout linearLayout = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountNameContainer");
        linearLayout.setVisibility(contactSyncConnection != null ? 0 : 8);
        TextView textView = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.settingsAccountNameText");
        if (contactSyncConnection == null || (name = contactSyncConnection.getName()) == null) {
            name = "";
        }
        textView.setText(name);
        TextView textView2 = getBinding().B;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.settingsAccountTagText");
        UserUtils userUtils = UserUtils.INSTANCE;
        textView2.setText(UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null));
        TextView textView3 = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.settingsAccountEmailText");
        textView3.setText(meUser.getEmail());
        TextView textView4 = getBinding().f2592s;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.settingsAccountPhoneText");
        textView4.setText(meUser.getPhoneNumber());
        getBinding().d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountChangePassword.Companion companion = WidgetSettingsAccountChangePassword.INSTANCE;
                TextView textView5 = WidgetSettingsAccount.this.getBinding().d;
                Intrinsics3.checkNotNullExpressionValue(textView5, "binding.settingsAccountChangePassword");
                Context context = textView5.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "binding.settingsAccountChangePassword.context");
                companion.launch(context);
            }
        });
        getBinding().A.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountUsernameEdit.Companion companion = WidgetSettingsAccountUsernameEdit.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().p.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountContactsNameEdit.Companion companion = WidgetSettingsAccountContactsNameEdit.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.4
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                boolean zIsVerified = meUser.isVerified();
                Experiment userExperiment = StoreStream.INSTANCE.getExperiments().getUserExperiment("2022-01_email_change_confirmation", zIsVerified);
                boolean z2 = userExperiment != null && userExperiment.getBucket() == 1 && zIsVerified;
                WidgetSettingsAccountEmailEdit.Companion companion = WidgetSettingsAccountEmailEdit.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context, z2);
            }
        });
        getBinding().r.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetUserPhoneManage.INSTANCE.launch(outline.x(view, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.UNFORCED, WidgetUserPhoneManage.Companion.Source.USER_SETTINGS_UPDATE);
            }
        });
        TextView textView5 = getBinding().l;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.settingsAccountMfaEnabledHeader");
        textView5.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().m;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!meUser.getMfaEnabled() ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        TextView textView6 = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.settingsAccountMfaSalesPitch");
        textView6.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        if (pendingMFAState.getActivationState() != StoreMFA.MFAActivationState.NONE) {
            configureMFA(pendingMFAState.getActivationState() == StoreMFA.MFAActivationState.PENDING_ENABLED, true);
        } else {
            configureMFA(meUser.getMfaEnabled(), false);
        }
        getBinding().j.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetEnableMFASteps.Companion companion = WidgetEnableMFASteps.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().F.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccountBackupCodes.Companion companion = WidgetSettingsAccountBackupCodes.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "it");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                companion.launch(context);
            }
        });
        getBinding().w.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsAccount.this.showRemove2FAModal();
            }
        });
        getBinding().G.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsBlockedUsers.Companion companion = WidgetSettingsBlockedUsers.INSTANCE;
                Intrinsics3.checkNotNullExpressionValue(view, "view");
                Context context = view.getContext();
                Intrinsics3.checkNotNullExpressionValue(context, "view.context");
                companion.launch(context);
            }
        });
        getBinding().u.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getOwnsAnyGuilds()) {
                    WidgetSettingsAccount.this.showOwnsGuildModal();
                    return;
                }
                WidgetDisableDeleteAccountDialog.Companion companion = WidgetDisableDeleteAccountDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog.Mode.DISABLE);
            }
        });
        getBinding().t.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                if (model.getOwnsAnyGuilds()) {
                    WidgetSettingsAccount.this.showOwnsGuildModal();
                    return;
                }
                WidgetDisableDeleteAccountDialog.Companion companion = WidgetDisableDeleteAccountDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                companion.show(parentFragmentManager, WidgetDisableDeleteAccountDialog.Mode.DELETE);
            }
        });
        String sMSBackupDisabledMessage = getSMSBackupDisabledMessage(meUser);
        if (sMSBackupDisabledMessage != null || pendingMFAState.isTogglingSMSBackup()) {
            CheckedSetting.d(getBinding().f2594y, null, 1);
            TextView textView7 = getBinding().f2595z;
            Intrinsics3.checkNotNullExpressionValue(textView7, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView7, false, 0.0f, 2, null);
        } else {
            TextView textView8 = getBinding().f2595z;
            Intrinsics3.checkNotNullExpressionValue(textView8, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView8, true, 0.0f, 2, null);
            getBinding().f2594y.e(new View.OnClickListener() { // from class: com.discord.widgets.settings.account.WidgetSettingsAccount.configureUI.12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UserUtils userUtils2 = UserUtils.INSTANCE;
                    if (userUtils2.isMfaSMSEnabled(meUser)) {
                        WidgetEnableSMSBackupDialog.Companion companion = WidgetEnableSMSBackupDialog.INSTANCE;
                        FragmentManager parentFragmentManager = WidgetSettingsAccount.this.getParentFragmentManager();
                        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                        companion.show(parentFragmentManager, false);
                        return;
                    }
                    if (userUtils2.isMfaSMSEnabled(meUser) || !userUtils2.getHasPhone(meUser)) {
                        WidgetUserPhoneManage.INSTANCE.launch(outline.x(view, "it", "it.context"), WidgetUserAccountVerifyBase.Mode.NO_HISTORY_FROM_USER_SETTINGS, WidgetUserPhoneManage.Companion.Source.MFA_PHONE_UPDATE);
                        return;
                    }
                    WidgetEnableSMSBackupDialog.Companion companion2 = WidgetEnableSMSBackupDialog.INSTANCE;
                    FragmentManager parentFragmentManager2 = WidgetSettingsAccount.this.getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    companion2.show(parentFragmentManager2, true);
                }
            });
        }
        TextView textView9 = getBinding().f2595z;
        Intrinsics3.checkNotNullExpressionValue(textView9, "binding.settingsAccountSmsPhone");
        ViewExtensions.setTextAndVisibilityBy(textView9, meUser.getPhoneNumber() != null ? FormatUtils.b(outline.I(getBinding().f2595z, "binding.settingsAccountSmsPhone", "binding.settingsAccountSmsPhone.context"), R.string.mfa_sms_auth_current_phone, new Object[]{meUser.getPhoneNumber()}, (4 & 4) != 0 ? FormatUtils.b.j : null) : null);
        CheckedSetting checkedSetting = getBinding().f2594y;
        Intrinsics3.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccountSmsBackup");
        checkedSetting.setChecked(userUtils.isMfaSMSEnabled(meUser));
        CheckedSetting checkedSetting2 = getBinding().f2594y;
        if (sMSBackupDisabledMessage == null) {
            sMSBackupDisabledMessage = getString(R.string.mfa_sms_auth_sales_pitch);
            Intrinsics3.checkNotNullExpressionValue(sMSBackupDisabledMessage, "getString(R.string.mfa_sms_auth_sales_pitch)");
        }
        CheckedSetting.i(checkedSetting2, sMSBackupDisabledMessage, false, 2);
        if (getMostRecentIntent().getSerializableExtra(EXTRA_REDIRECT) == Redirect.SMS_BACKUP) {
            getMostRecentIntent().removeExtra(EXTRA_REDIRECT);
            WidgetEnableSMSBackupDialog.Companion companion = WidgetEnableSMSBackupDialog.INSTANCE;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            companion.show(parentFragmentManager, true);
        }
        for (TextView textView10 : Collections2.listOf((Object[]) new TextView[]{getBinding().g, getBinding().c, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView10, "header");
            accessibilityUtils.setViewIsHeading(textView10);
        }
    }

    private final WidgetSettingsAccountBinding getBinding() {
        return (WidgetSettingsAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSMSBackupDisabledMessage(MeUser user) {
        UserUtils userUtils = UserUtils.INSTANCE;
        if (userUtils.isPartner(user) || userUtils.isStaff(user)) {
            return getString(R.string.mfa_sms_disabled_partner);
        }
        if (user.getEmail() == null) {
            return getString(R.string.mfa_sms_disabled_no_email);
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
        WidgetNoticeDialog.Builder positiveButton$default = WidgetNoticeDialog.Builder.setPositiveButton$default(new WidgetNoticeDialog.Builder(requireContext()).setTitle(R.string.delete_account_transfer_ownership).setMessage(R.string.delete_account_transfer_ownership_body), R.string.okay, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton$default.show(parentFragmentManager);
    }

    private final void showRemove2FAModal() {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String string = requireContext().getString(R.string.two_fa_remove);
            Intrinsics3.checkNotNullExpressionValue(string, "requireContext().getString(R.string.two_fa_remove)");
            String string2 = requireContext().getString(R.string.user_settings_mfa_enable_code_body);
            Intrinsics3.checkNotNullExpressionValue(string2, "requireContext().getStri…ngs_mfa_enable_code_body)");
            String string3 = requireContext().getString(R.string.two_fa_auth_code);
            Intrinsics3.checkNotNullExpressionValue(string3, "requireContext().getStri….string.two_fa_auth_code)");
            companion.showInputModal(appActivity, string, string2, string3, new AnonymousClass1(), (640 & 32) != 0 ? null : null, (640 & 64) != 0 ? null : null, (640 & 128) != 0 ? StoreNotices.InputDialog.Type.PASSWORD : null, (640 & 256) != 0 ? null : null, (640 & 512) != 0 ? false : false);
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
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.user_settings_my_account);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        if (getMostRecentIntent().getBooleanExtra(EXTRA_HINT_DATA_MANAGEMENT, false)) {
            LinearLayout linearLayout = getBinding().v;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(linearLayout);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new AnonymousClass1(null), 3, null);
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<Model> observableR = Model.INSTANCE.get().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "Model\n        .get()\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), (Class<?>) WidgetSettingsAccount.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
    }
}
