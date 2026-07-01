package com.discord.widgets.settings.account;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import b.a.k.b;
import b.d.b.a.a;
import b.i.a.f.e.o.f;
import com.airbnb.lottie.LottieAnimationView;
import com.discord.R$layout;
import com.discord.api.connectedaccounts.ConnectedAccount;
import com.discord.app.AppActivity;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsAccountBinding;
import com.discord.models.user.MeUser;
import com.discord.stores.StoreMFA$MFAActivationState;
import com.discord.stores.StoreMFA$State;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.user.UserUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.views.CheckedSetting;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Builder;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.google.android.material.button.MaterialButton;
import d0.t.n;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import kotlinx.coroutines.CoroutineScope;
import rx.Observable;

/* JADX INFO: compiled from: WidgetSettingsAccount.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsAccount extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsAccount.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsAccountBinding;", 0)};
    public static final WidgetSettingsAccount$Companion Companion = new WidgetSettingsAccount$Companion(null);
    private static final String EXTRA_HINT_DATA_MANAGEMENT = "com.discord.extra.HINT_DATA_MANAGEMENT";
    private static final String EXTRA_REDIRECT = "extra_redirect";
    private static final int MFA_DISABLED_VIEW_INDEX = 1;
    private static final int MFA_ENABLED_VIEW_INDEX = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    public WidgetSettingsAccount() {
        super(R$layout.widget_settings_account);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsAccount$binding$2.INSTANCE, null, 2, null);
    }

    public static final /* synthetic */ void access$configureUI(WidgetSettingsAccount widgetSettingsAccount, WidgetSettingsAccount$Model widgetSettingsAccount$Model) {
        widgetSettingsAccount.configureUI(widgetSettingsAccount$Model);
    }

    public static final /* synthetic */ WidgetSettingsAccountBinding access$getBinding$p(WidgetSettingsAccount widgetSettingsAccount) {
        return widgetSettingsAccount.getBinding();
    }

    public static final /* synthetic */ void access$showOwnsGuildModal(WidgetSettingsAccount widgetSettingsAccount) {
        widgetSettingsAccount.showOwnsGuildModal();
    }

    public static final /* synthetic */ void access$showRemove2FAModal(WidgetSettingsAccount widgetSettingsAccount) {
        widgetSettingsAccount.showRemove2FAModal();
    }

    private final void configureAccountVerificationBanner(MeUser user) {
        RelativeLayout relativeLayout = getBinding().C;
        m.checkNotNullExpressionValue(relativeLayout, "binding.settingsAccountVerification");
        relativeLayout.setVisibility(user.isVerified() ^ true ? 0 : 8);
        if (user.getEmail() == null) {
            TextView textView = getBinding().E;
            m.checkNotNullExpressionValue(textView, "binding.settingsAccountVerificationTitle");
            textView.setText(getString(2131886321));
            MaterialButton materialButton = getBinding().D;
            m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountVerificationButton");
            materialButton.setText(getString(2131886323));
        } else {
            TextView textView2 = getBinding().E;
            m.checkNotNullExpressionValue(textView2, "binding.settingsAccountVerificationTitle");
            textView2.setText(getString(2131897074));
            MaterialButton materialButton2 = getBinding().D;
            m.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountVerificationButton");
            materialButton2.setText(getString(2131897059));
        }
        getBinding().D.setOnClickListener(WidgetSettingsAccount$configureAccountVerificationBanner$1.INSTANCE);
    }

    private final void configureMFA(boolean enabled, boolean pending) {
        TextView textView = getBinding().l;
        m.checkNotNullExpressionValue(textView, "binding.settingsAccountMfaEnabledHeader");
        textView.setVisibility(enabled ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().m;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!enabled ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().n;
        m.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        TextView textView2 = getBinding().o;
        m.checkNotNullExpressionValue(textView2, "binding.settingsAccountMfaSalesPitch");
        textView2.setVisibility((!enabled ? 1 : 0) != 0 ? 0 : 8);
        MaterialButton materialButton = getBinding().j;
        m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility((!enabled ? 1 : 0) == 0 ? 8 : 0);
        MaterialButton materialButton2 = getBinding().j;
        m.checkNotNullExpressionValue(materialButton2, "binding.settingsAccountMfaEnable");
        materialButton2.setEnabled(!pending);
        TextView textView3 = getBinding().F;
        m.checkNotNullExpressionValue(textView3, "binding.settingsAccountViewBackupCodes");
        textView3.setEnabled(!pending);
        TextView textView4 = getBinding().w;
        m.checkNotNullExpressionValue(textView4, "binding.settingsAccountRemoveTwoFa");
        textView4.setEnabled(!pending);
        LinearLayout linearLayout = getBinding().i;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountMfaDisabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout, !pending, 0.0f, 2, null);
        LinearLayout linearLayout2 = getBinding().k;
        m.checkNotNullExpressionValue(linearLayout2, "binding.settingsAccountMfaEnabledContainer");
        ViewExtensions.setEnabledAlpha$default(linearLayout2, !pending, 0.0f, 2, null);
    }

    private final void configureUI(WidgetSettingsAccount$Model model) {
        String name;
        MeUser meUser = model.getMeUser();
        StoreMFA$State pendingMFAState = model.getPendingMFAState();
        ConnectedAccount contactSyncConnection = model.getContactSyncConnection();
        configureAccountVerificationBanner(meUser);
        LinearLayout linearLayout = getBinding().p;
        m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountNameContainer");
        linearLayout.setVisibility(contactSyncConnection != null ? 0 : 8);
        TextView textView = getBinding().q;
        m.checkNotNullExpressionValue(textView, "binding.settingsAccountNameText");
        if (contactSyncConnection == null || (name = contactSyncConnection.getName()) == null) {
            name = "";
        }
        textView.setText(name);
        TextView textView2 = getBinding().B;
        m.checkNotNullExpressionValue(textView2, "binding.settingsAccountTagText");
        UserUtils userUtils = UserUtils.INSTANCE;
        textView2.setText(UserUtils.getUserNameWithDiscriminator$default(userUtils, meUser, null, null, 3, null));
        TextView textView3 = getBinding().f;
        m.checkNotNullExpressionValue(textView3, "binding.settingsAccountEmailText");
        textView3.setText(meUser.getEmail());
        TextView textView4 = getBinding().f2592s;
        m.checkNotNullExpressionValue(textView4, "binding.settingsAccountPhoneText");
        textView4.setText(meUser.getPhoneNumber());
        getBinding().d.setOnClickListener(new WidgetSettingsAccount$configureUI$1(this));
        getBinding().A.setOnClickListener(WidgetSettingsAccount$configureUI$2.INSTANCE);
        getBinding().p.setOnClickListener(WidgetSettingsAccount$configureUI$3.INSTANCE);
        getBinding().e.setOnClickListener(new WidgetSettingsAccount$configureUI$4(meUser));
        getBinding().r.setOnClickListener(WidgetSettingsAccount$configureUI$5.INSTANCE);
        TextView textView5 = getBinding().l;
        m.checkNotNullExpressionValue(textView5, "binding.settingsAccountMfaEnabledHeader");
        textView5.setVisibility(meUser.getMfaEnabled() ? 0 : 8);
        AppViewFlipper appViewFlipper = getBinding().m;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.settingsAccountMfaFlipper");
        appViewFlipper.setDisplayedChild(!meUser.getMfaEnabled() ? 1 : 0);
        LottieAnimationView lottieAnimationView = getBinding().n;
        m.checkNotNullExpressionValue(lottieAnimationView, "binding.settingsAccountMfaLottie");
        lottieAnimationView.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        TextView textView6 = getBinding().o;
        m.checkNotNullExpressionValue(textView6, "binding.settingsAccountMfaSalesPitch");
        textView6.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        MaterialButton materialButton = getBinding().j;
        m.checkNotNullExpressionValue(materialButton, "binding.settingsAccountMfaEnable");
        materialButton.setVisibility(meUser.getMfaEnabled() ^ true ? 0 : 8);
        if (pendingMFAState.getActivationState() != StoreMFA$MFAActivationState.NONE) {
            configureMFA(pendingMFAState.getActivationState() == StoreMFA$MFAActivationState.PENDING_ENABLED, true);
        } else {
            configureMFA(meUser.getMfaEnabled(), false);
        }
        getBinding().j.setOnClickListener(WidgetSettingsAccount$configureUI$6.INSTANCE);
        getBinding().F.setOnClickListener(WidgetSettingsAccount$configureUI$7.INSTANCE);
        getBinding().w.setOnClickListener(new WidgetSettingsAccount$configureUI$8(this));
        getBinding().G.setOnClickListener(WidgetSettingsAccount$configureUI$9.INSTANCE);
        getBinding().u.setOnClickListener(new WidgetSettingsAccount$configureUI$10(this, model));
        getBinding().t.setOnClickListener(new WidgetSettingsAccount$configureUI$11(this, model));
        String sMSBackupDisabledMessage = getSMSBackupDisabledMessage(meUser);
        if (sMSBackupDisabledMessage != null || pendingMFAState.isTogglingSMSBackup()) {
            CheckedSetting.d(getBinding().f2594y, null, 1);
            TextView textView7 = getBinding().f2595z;
            m.checkNotNullExpressionValue(textView7, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView7, false, 0.0f, 2, null);
        } else {
            TextView textView8 = getBinding().f2595z;
            m.checkNotNullExpressionValue(textView8, "binding.settingsAccountSmsPhone");
            ViewExtensions.setEnabledAlpha$default(textView8, true, 0.0f, 2, null);
            getBinding().f2594y.e(new WidgetSettingsAccount$configureUI$12(this, meUser));
        }
        TextView textView9 = getBinding().f2595z;
        m.checkNotNullExpressionValue(textView9, "binding.settingsAccountSmsPhone");
        ViewExtensions.setTextAndVisibilityBy(textView9, meUser.getPhoneNumber() != null ? b.h(a.I(getBinding().f2595z, "binding.settingsAccountSmsPhone", "binding.settingsAccountSmsPhone.context"), 2131892987, new Object[]{meUser.getPhoneNumber()}, null, 4) : null);
        CheckedSetting checkedSetting = getBinding().f2594y;
        m.checkNotNullExpressionValue(checkedSetting, "binding.settingsAccountSmsBackup");
        checkedSetting.setChecked(userUtils.isMfaSMSEnabled(meUser));
        CheckedSetting checkedSetting2 = getBinding().f2594y;
        if (sMSBackupDisabledMessage == null) {
            sMSBackupDisabledMessage = getString(2131892988);
            m.checkNotNullExpressionValue(sMSBackupDisabledMessage, "getString(R.string.mfa_sms_auth_sales_pitch)");
        }
        CheckedSetting.i(checkedSetting2, sMSBackupDisabledMessage, false, 2);
        if (getMostRecentIntent().getSerializableExtra(EXTRA_REDIRECT) == WidgetSettingsAccount$Redirect.SMS_BACKUP) {
            getMostRecentIntent().removeExtra(EXTRA_REDIRECT);
            WidgetEnableSMSBackupDialog$Companion widgetEnableSMSBackupDialog$Companion = WidgetEnableSMSBackupDialog.Companion;
            FragmentManager parentFragmentManager = getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            widgetEnableSMSBackupDialog$Companion.show(parentFragmentManager, true);
        }
        for (TextView textView10 : n.listOf((Object[]) new TextView[]{getBinding().g, getBinding().c, getBinding().h})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView10, "header");
            accessibilityUtils.setViewIsHeading(textView10);
        }
    }

    private final WidgetSettingsAccountBinding getBinding() {
        return (WidgetSettingsAccountBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getSMSBackupDisabledMessage(MeUser user) {
        UserUtils userUtils = UserUtils.INSTANCE;
        if (userUtils.isPartner(user) || userUtils.isStaff(user)) {
            return getString(2131892992);
        }
        if (user.getEmail() == null) {
            return getString(2131892991);
        }
        return null;
    }

    public static final void launch(Context context) {
        WidgetSettingsAccount$Companion.launch$default(Companion, context, false, null, 6, null);
    }

    public static final void launch(Context context, boolean z2) {
        WidgetSettingsAccount$Companion.launch$default(Companion, context, z2, null, 4, null);
    }

    public static final void launch(Context context, boolean z2, WidgetSettingsAccount$Redirect widgetSettingsAccount$Redirect) {
        Companion.launch(context, z2, widgetSettingsAccount$Redirect);
    }

    private final void showOwnsGuildModal() {
        WidgetNoticeDialog$Builder positiveButton$default = WidgetNoticeDialog$Builder.setPositiveButton$default(new WidgetNoticeDialog$Builder(requireContext()).setTitle(2131888373).setMessage(2131888374), 2131893499, (Function1) null, 2, (Object) null);
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        positiveButton$default.show(parentFragmentManager);
    }

    private final void showRemove2FAModal() {
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        AppActivity appActivity = getAppActivity();
        if (appActivity != null) {
            String string = requireContext().getString(2131896538);
            m.checkNotNullExpressionValue(string, "requireContext().getString(R.string.two_fa_remove)");
            String string2 = requireContext().getString(2131896927);
            m.checkNotNullExpressionValue(string2, "requireContext().getStri…ngs_mfa_enable_code_body)");
            String string3 = requireContext().getString(2131896489);
            m.checkNotNullExpressionValue(string3, "requireContext().getStri….string.two_fa_auth_code)");
            WidgetNoticeDialog$Companion.showInputModal$default(widgetNoticeDialog$Companion, appActivity, string, string2, string3, new WidgetSettingsAccount$showRemove2FAModal$1(this), null, null, null, null, false, 992, null);
        }
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4008) {
            GoogleSmartLockManager.Companion.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131896933);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        setRetainInstance(true);
        if (getMostRecentIntent().getBooleanExtra(EXTRA_HINT_DATA_MANAGEMENT, false)) {
            LinearLayout linearLayout = getBinding().v;
            m.checkNotNullExpressionValue(linearLayout, "binding.settingsAccountPrivateDataWrap");
            CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(linearLayout);
            if (coroutineScope != null) {
                f.H0(coroutineScope, null, null, new WidgetSettingsAccount$onViewBound$1(this, null), 3, null);
            }
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<WidgetSettingsAccount$Model> observableR = WidgetSettingsAccount$Model.Companion.get().r();
        m.checkNotNullExpressionValue(observableR, "Model\n        .get()\n   …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(ObservableExtensionsKt.computationLatest(observableR), this, null, 2, null), WidgetSettingsAccount.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsAccount$onViewBoundOrOnResume$1(this), 62, (Object) null);
    }
}
