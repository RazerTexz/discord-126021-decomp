package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.d.j;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.GoogleSmartLockManager$SmartLockCredentials;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.auth.RegistrationFlowRepo$Companion;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import d0.z.d.a0;
import d0.z.d.m;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetAuthLanding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLandingBinding;", 0)};
    public static final WidgetAuthLanding$Companion Companion = new WidgetAuthLanding$Companion(null);
    private static final int VIEW_INDEX_HAS_INVITE = 1;
    private static final int VIEW_INDEX_NO_INVITE = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetAuthLanding() {
        super(R$layout.widget_auth_landing);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthLanding$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthLanding$binding$2.INSTANCE, null, 2, null);
        WidgetAuthLanding$viewModel$2 widgetAuthLanding$viewModel$2 = new WidgetAuthLanding$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(WidgetAuthLandingViewModel.class), new WidgetAuthLanding$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetAuthLanding$viewModel$2));
    }

    public static final /* synthetic */ void access$configureUI(WidgetAuthLanding widgetAuthLanding, WidgetAuthLandingViewModel$ViewState widgetAuthLandingViewModel$ViewState) {
        widgetAuthLanding.configureUI(widgetAuthLandingViewModel$ViewState);
    }

    public static final /* synthetic */ void access$handleEvent(WidgetAuthLanding widgetAuthLanding, WidgetAuthLandingViewModel$Event widgetAuthLandingViewModel$Event) {
        widgetAuthLanding.handleEvent(widgetAuthLandingViewModel$Event);
    }

    public static final /* synthetic */ void access$onRegisterPressed(WidgetAuthLanding widgetAuthLanding, Context context) {
        widgetAuthLanding.onRegisterPressed(context);
    }

    private final void configureRegisterButton(String ageGateError) {
        if (ageGateError == null) {
            getBinding().d.setOnClickListener(new WidgetAuthLanding$configureRegisterButton$2(this));
            return;
        }
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        HomeConfig homeConfig = (HomeConfig) serializableExtra;
        if (homeConfig != null && homeConfig.getAgeGated()) {
            WidgetAuthAgeGated.Companion.start(requireContext(), ageGateError);
        }
        getBinding().d.setOnClickListener(new WidgetAuthLanding$configureRegisterButton$1(ageGateError));
    }

    private final void configureUI(WidgetAuthLandingViewModel$ViewState viewState) {
        if (viewState instanceof WidgetAuthLandingViewModel$ViewState$Empty) {
            WidgetAuthLandingBinding binding = getBinding();
            m.checkNotNullExpressionValue(binding, "binding");
            binding.a.setBackgroundColor(ColorCompat.getThemedColor(getContext(), 2130968911));
            AppViewFlipper appViewFlipper = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.authLandingSwitchFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.authLandingSwitchFlipper");
            appViewFlipper2.setDisplayedChild(1);
            if (viewState instanceof WidgetAuthLandingViewModel$ViewState$Invite) {
                getBinding().f2231b.configureInvite(((WidgetAuthLandingViewModel$ViewState$Invite) viewState).getInvite());
            } else if (viewState instanceof WidgetAuthLandingViewModel$ViewState$GuildTemplate) {
                getBinding().f2231b.configureGuildTemplate(((WidgetAuthLandingViewModel$ViewState$GuildTemplate) viewState).getGuildTemplate());
            }
        }
        configureRegisterButton(viewState.getAgeGateError());
    }

    private final WidgetAuthLandingBinding getBinding() {
        return (WidgetAuthLandingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetAuthLandingViewModel getViewModel() {
        return (WidgetAuthLandingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(WidgetAuthLandingViewModel$Event event) {
        if (event instanceof WidgetAuthLandingViewModel$Event$SmartLockLogin) {
            GoogleSmartLockManager$SmartLockCredentials smartLockCredentials = ((WidgetAuthLandingViewModel$Event$SmartLockLogin) event).getSmartLockCredentials();
            getViewModel().getGoogleSmartLockManager().getSmartLockRepo().setAttemptToSignInWithSmartLock(false);
            loginWithSmartLock(smartLockCredentials.getId(), smartLockCredentials.getPassword());
        }
    }

    private final void loginWithSmartLock(String id2, String password) {
        Bundle bundle = new Bundle();
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID, id2);
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD, password);
        j.d(requireContext(), WidgetAuthLogin.class, new Intent().putExtras(bundle));
    }

    private final void onRegisterPressed(Context context) {
        RegistrationFlowRepo$Companion registrationFlowRepo$Companion = RegistrationFlowRepo.Companion;
        registrationFlowRepo$Companion.getINSTANCE().setRegistering(true);
        registrationFlowRepo$Companion.getINSTANCE().clear();
        j.e(context, WidgetAuthRegisterIdentity.class, null, 4);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4009) {
            GoogleSmartLockManager.Companion.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthLanding$onViewBound$1(this), 62, (Object) null);
        getBinding().c.setOnClickListener(WidgetAuthLanding$onViewBound$2.INSTANCE);
        getBinding().d.setOnClickListener(new WidgetAuthLanding$onViewBound$3(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), WidgetAuthLanding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetAuthLanding$onViewBoundOrOnResume$1(this), 62, (Object) null);
        GrowthTeamFeatures.INSTANCE.imbalancedAndroidSplashNoop();
    }
}
