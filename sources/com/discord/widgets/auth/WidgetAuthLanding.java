package com.discord.widgets.auth;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetAuthLandingBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.auth.GoogleSmartLockManager;
import com.discord.utilities.auth.RegistrationFlowRepo;
import com.discord.utilities.color.ColorCompat;
import com.discord.utilities.error.Error;
import com.discord.utilities.features.GrowthTeamFeatures;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.home.HomeConfig;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import java.io.Serializable;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetAuthLanding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetAuthLanding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetAuthLanding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetAuthLandingBinding;", 0)};
    private static final int VIEW_INDEX_HAS_INVITE = 1;
    private static final int VIEW_INDEX_NO_INVITE = 0;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LoggingConfig loggingConfig;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetAuthLanding.kt */
    public static final /* synthetic */ class C71751 extends C12236k implements Function1<WidgetAuthLandingViewModel.ViewState, Unit> {
        public C71751(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "configureUI", "configureUI(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$ViewState;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetAuthLanding) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.auth.WidgetAuthLanding$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetAuthLanding.kt */
    public static final /* synthetic */ class C71781 extends C12236k implements Function1<WidgetAuthLandingViewModel.Event, Unit> {
        public C71781(WidgetAuthLanding widgetAuthLanding) {
            super(1, widgetAuthLanding, WidgetAuthLanding.class, "handleEvent", "handleEvent(Lcom/discord/widgets/auth/WidgetAuthLandingViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(WidgetAuthLandingViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(WidgetAuthLandingViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetAuthLanding) this.receiver).handleEvent(event);
        }
    }

    public WidgetAuthLanding() {
        super(C5419R.layout.widget_auth_landing);
        this.loggingConfig = new LoggingConfig(false, null, WidgetAuthLanding$loggingConfig$1.INSTANCE, 3);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetAuthLanding$binding$2.INSTANCE, null, 2, null);
        WidgetAuthLanding$viewModel$2 widgetAuthLanding$viewModel$2 = new WidgetAuthLanding$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(WidgetAuthLandingViewModel.class), new WidgetAuthLanding$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetAuthLanding$viewModel$2));
    }

    private final void configureRegisterButton(final String ageGateError) {
        if (ageGateError == null) {
            getBinding().f15678d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLanding.configureRegisterButton.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    WidgetAuthLanding widgetAuthLanding = WidgetAuthLanding.this;
                    C12238m.checkNotNullExpressionValue(view, "it");
                    Context context = view.getContext();
                    C12238m.checkNotNullExpressionValue(context, "it.context");
                    widgetAuthLanding.onRegisterPressed(context);
                }
            });
            return;
        }
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra("com.discord.intent.extra.EXTRA_HOME_CONFIG");
        if (!(serializableExtra instanceof HomeConfig)) {
            serializableExtra = null;
        }
        HomeConfig homeConfig = (HomeConfig) serializableExtra;
        if (homeConfig != null && homeConfig.getAgeGated()) {
            WidgetAuthAgeGated.INSTANCE.start(requireContext(), ageGateError);
        }
        getBinding().f15678d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLanding.configureRegisterButton.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetAuthAgeGated.INSTANCE.start(C1643a.m885x(view, "it", "it.context"), ageGateError);
            }
        });
    }

    private final void configureUI(WidgetAuthLandingViewModel.ViewState viewState) {
        if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Empty) {
            WidgetAuthLandingBinding binding = getBinding();
            C12238m.checkNotNullExpressionValue(binding, "binding");
            binding.f15675a.setBackgroundColor(ColorCompat.getThemedColor(getContext(), C5419R.attr.colorBackgroundPrimary));
            AppViewFlipper appViewFlipper = getBinding().f15679e;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.authLandingSwitchFlipper");
            appViewFlipper.setDisplayedChild(0);
        } else {
            AppViewFlipper appViewFlipper2 = getBinding().f15679e;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.authLandingSwitchFlipper");
            appViewFlipper2.setDisplayedChild(1);
            if (viewState instanceof WidgetAuthLandingViewModel.ViewState.Invite) {
                getBinding().f15676b.configureInvite(((WidgetAuthLandingViewModel.ViewState.Invite) viewState).getInvite());
            } else if (viewState instanceof WidgetAuthLandingViewModel.ViewState.GuildTemplate) {
                getBinding().f15676b.configureGuildTemplate(((WidgetAuthLandingViewModel.ViewState.GuildTemplate) viewState).getGuildTemplate());
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

    private final void handleEvent(WidgetAuthLandingViewModel.Event event) {
        if (event instanceof WidgetAuthLandingViewModel.Event.SmartLockLogin) {
            GoogleSmartLockManager.SmartLockCredentials smartLockCredentials = ((WidgetAuthLandingViewModel.Event.SmartLockLogin) event).getSmartLockCredentials();
            getViewModel().getGoogleSmartLockManager().getSmartLockRepo().setAttemptToSignInWithSmartLock(false);
            loginWithSmartLock(smartLockCredentials.getId(), smartLockCredentials.getPassword());
        }
    }

    private final void loginWithSmartLock(String id2, String password) {
        Bundle bundle = new Bundle();
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_ID, id2);
        bundle.putString(WidgetAuthLogin.GOOGLE_SMARTLOCK_LOGIN_EXTRA_PASSWORD, password);
        C0870j.m156d(requireContext(), WidgetAuthLogin.class, new Intent().putExtras(bundle));
    }

    private final void onRegisterPressed(Context context) {
        RegistrationFlowRepo.Companion companion = RegistrationFlowRepo.INSTANCE;
        companion.getINSTANCE().setRegistering(true);
        companion.getINSTANCE().clear();
        C0870j.m157e(context, WidgetAuthRegisterIdentity.class, null, 4);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return this.loggingConfig;
    }

    @Override // com.discord.app.AppFragment, androidx.fragment.app.Fragment
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 4009) {
            GoogleSmartLockManager.INSTANCE.handleResult(resultCode, data);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetAuthLanding.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71751(this));
        getBinding().f15677c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLanding.onViewBound.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                C0870j.m157e(context, WidgetAuthLogin.class, null, 4);
            }
        });
        getBinding().f15678d.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.auth.WidgetAuthLanding.onViewBound.3
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                WidgetAuthLanding widgetAuthLanding = WidgetAuthLanding.this;
                C12238m.checkNotNullExpressionValue(view2, "it");
                Context context = view2.getContext();
                C12238m.checkNotNullExpressionValue(context, "it.context");
                widgetAuthLanding.onRegisterPressed(context);
            }
        });
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetAuthLanding.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C71781(this));
        GrowthTeamFeatures.INSTANCE.imbalancedAndroidSplashNoop();
    }
}
