package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.g0;
import b.a.d.i0;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements$Rejection;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest$State;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate$Companion;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView$Requirement;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.google.android.material.button.MaterialButton;
import d0.g;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetServerSettingsCreatorMonetizationOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0)};
    public static final WidgetServerSettingsCreatorMonetizationOnboarding$Companion Companion = new WidgetServerSettingsCreatorMonetizationOnboarding$Companion(null);
    private static final int VIEW_FLIPPER_ACCEPT_TERMS_STATE = 3;
    private static final int VIEW_FLIPPER_CREATE_REQUEST_STATE = 2;
    private static final int VIEW_FLIPPER_ERROR_STATE = 1;
    private static final int VIEW_FLIPPER_LOADING_STATE = 0;

    /* JADX INFO: renamed from: acceptTermsBinding$delegate, reason: from kotlin metadata */
    private final Lazy acceptTermsBinding;

    /* JADX INFO: renamed from: acceptTermsOnlyGuildOwnerNotice$delegate, reason: from kotlin metadata */
    private final Lazy acceptTermsOnlyGuildOwnerNotice;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: createRequestBinding$delegate, reason: from kotlin metadata */
    private final Lazy createRequestBinding;

    /* JADX INFO: renamed from: createRequestOnlyGuildOwnerNotice$delegate, reason: from kotlin metadata */
    private final Lazy createRequestOnlyGuildOwnerNotice;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetServerSettingsCreatorMonetizationOnboarding() {
        super(R$layout.widget_server_settings_creator_monetization_onboarding);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCreatorMonetizationOnboarding$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$guildId$2(this));
        WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 = new WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2(this);
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(ServerSettingsCreatorMonetizationOnboardingViewModel.class), new WidgetServerSettingsCreatorMonetizationOnboarding$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2));
        this.createRequestBinding = g.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$createRequestBinding$2(this));
        this.acceptTermsBinding = g.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsBinding$2(this));
        LazyViewStubDelegate$Companion lazyViewStubDelegate$Companion = LazyViewStubDelegate.Companion;
        this.createRequestOnlyGuildOwnerNotice = lazyViewStubDelegate$Companion.lazyViewStub(new WidgetServerSettingsCreatorMonetizationOnboarding$createRequestOnlyGuildOwnerNotice$2(this));
        this.acceptTermsOnlyGuildOwnerNotice = lazyViewStubDelegate$Companion.lazyViewStub(new WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2(this));
    }

    public static final /* synthetic */ void access$configureUI(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState serverSettingsCreatorMonetizationOnboardingViewModel$ViewState) {
        widgetServerSettingsCreatorMonetizationOnboarding.configureUI(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState);
    }

    public static final /* synthetic */ CharSequence access$formatDurationFromDays(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, int i) {
        return widgetServerSettingsCreatorMonetizationOnboarding.formatDurationFromDays(i);
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding access$getAcceptTermsBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getAcceptTermsBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingBinding access$getBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getBinding();
    }

    public static final /* synthetic */ WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding access$getCreateRequestBinding$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getCreateRequestBinding();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getGuildId();
    }

    public static final /* synthetic */ ServerSettingsCreatorMonetizationOnboardingViewModel access$getViewModel$p(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding) {
        return widgetServerSettingsCreatorMonetizationOnboarding.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding, ServerSettingsCreatorMonetizationOnboardingViewModel$Event serverSettingsCreatorMonetizationOnboardingViewModel$Event) {
        widgetServerSettingsCreatorMonetizationOnboarding.handleEvent(serverSettingsCreatorMonetizationOnboardingViewModel$Event);
    }

    private final void configureAcceptTermsState(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms viewState) {
        getAcceptTermsOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        CheckBox checkBox = getAcceptTermsBinding().c;
        checkBox.setChecked(viewState.getHasAcceptedTerms());
        checkBox.setEnabled(!viewState.isSubmitting() && viewState.isGuildOwner());
        checkBox.setOnCheckedChangeListener(new WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1(this, viewState));
        LoadingButton loadingButton = getAcceptTermsBinding().f2557b;
        loadingButton.setEnabled(viewState.getHasAcceptedTerms() && viewState.isGuildOwner());
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$2(this, viewState));
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009d  */
    private final void configureCreateRequestState(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest viewState) {
        CharSequence rejectionCooldown$default;
        boolean z2;
        LoadingButton loadingButton = getCreateRequestBinding().c;
        loadingButton.setEnabled(viewState.getRequirements().getCanApply() && viewState.isGuildOwner());
        loadingButton.setVisibility(viewState.isApplicationPending() ^ true ? 0 : 8);
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$$inlined$apply$lambda$1(this, viewState));
        getCreateRequestOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        MaterialButton materialButton = getCreateRequestBinding().f2559b;
        m.checkNotNullExpressionValue(materialButton, "createRequestBinding.applicationPendingButton");
        materialButton.setVisibility(viewState.isApplicationPending() ? 0 : 8);
        TextView textView = getCreateRequestBinding().h;
        CreatorMonetizationEligibilityRequirements$Rejection rejection = viewState.getRequirements().getRejection();
        if (rejection != null) {
            WidgetServerSettingsCreatorMonetizationOnboarding$Companion widgetServerSettingsCreatorMonetizationOnboarding$Companion = Companion;
            Context context = textView.getContext();
            m.checkNotNullExpressionValue(context, "context");
            rejectionCooldown$default = WidgetServerSettingsCreatorMonetizationOnboarding$Companion.formatRejectionCooldown$default(widgetServerSettingsCreatorMonetizationOnboarding$Companion, context, rejection, null, 2, null);
        } else {
            rejectionCooldown$default = null;
        }
        if (rejectionCooldown$default != null) {
            CreatorMonetizationEnableRequest latestRequest = viewState.getRequirements().getLatestRequest();
            z2 = (latestRequest != null ? latestRequest.getState() : null) == CreatorMonetizationEnableRequest$State.REJECTED;
        }
        textView.setVisibility(z2 ? 0 : 8);
        if (rejectionCooldown$default != null) {
            b.m(textView, 2131890576, new Object[0], new WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$2$1(rejectionCooldown$default));
        }
        LinkifiedTextView linkifiedTextView = getCreateRequestBinding().i;
        m.checkNotNullExpressionValue(linkifiedTextView, "createRequestBinding.requirementsDescription");
        b.m(linkifiedTextView, 2131890578, new Object[0], WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$3.INSTANCE);
        ImageView imageView = getCreateRequestBinding().e;
        m.checkNotNullExpressionValue(imageView, "createRequestBinding.eli…yChecklistHeaderIndicator");
        imageView.setActivated(viewState.getRequirements().getSufficient());
        if (viewState.getRequirements().getSufficient()) {
            TextView textView2 = getCreateRequestBinding().f;
            m.checkNotNullExpressionValue(textView2, "createRequestBinding.eligibilityChecklistTitle");
            b.n(textView2, 2131890571, new Object[0], null, 4);
        } else {
            TextView textView3 = getCreateRequestBinding().f;
            m.checkNotNullExpressionValue(textView3, "createRequestBinding.eligibilityChecklistTitle");
            b.m(textView3, 2131890580, new Object[0], new WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4(this));
        }
        getCreateRequestBinding().d.bind(toChecklistRequirements(viewState.getRequirements()));
    }

    private final void configureUI(ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState viewState) {
        Unit unit;
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$Loading) {
            AppViewFlipper appViewFlipper = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper, "binding.viewFlipper");
            appViewFlipper.setDisplayedChild(0);
            unit = Unit.a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$Error) {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper2, "binding.viewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().f2558b;
            m.checkNotNullExpressionValue(textView, "binding.errorNoticeText");
            textView.setText(((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$Error) viewState).getError().getDisplayString(requireContext()));
            unit = Unit.a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) {
            AppViewFlipper appViewFlipper3 = getBinding().e;
            m.checkNotNullExpressionValue(appViewFlipper3, "binding.viewFlipper");
            appViewFlipper3.setDisplayedChild(2);
            configureCreateRequestState((ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$CreateRequest) viewState);
            unit = Unit.a;
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms)) {
                throw new NoWhenBranchMatchedException();
            }
            ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms) viewState;
            if (serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.Companion.launch(requireContext(), getGuildId());
                requireActivity().finish();
                unit = Unit.a;
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().e;
                m.checkNotNullExpressionValue(appViewFlipper4, "binding.viewFlipper");
                appViewFlipper4.setDisplayedChild(3);
                configureAcceptTermsState(serverSettingsCreatorMonetizationOnboardingViewModel$ViewState$AcceptTerms);
                unit = Unit.a;
            }
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final CharSequence formatDurationFromDays(int minimumAgeInDays) {
        return (minimumAgeInDays <= 0 || minimumAgeInDays % 7 != 0) ? DurationUtilsKt.formatDuration(requireContext(), DurationUnit.DAYS, minimumAgeInDays) : DurationUtilsKt.formatDuration(requireContext(), DurationUnit.WEEKS, minimumAgeInDays / 7);
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding getAcceptTermsBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding) this.acceptTermsBinding.getValue();
    }

    private final LazyViewStubDelegate getAcceptTermsOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.acceptTermsOnlyGuildOwnerNotice.getValue();
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingBinding getBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding getCreateRequestBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding) this.createRequestBinding.getValue();
    }

    private final LazyViewStubDelegate getCreateRequestOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.createRequestOnlyGuildOwnerNotice.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final ServerSettingsCreatorMonetizationOnboardingViewModel getViewModel() {
        return (ServerSettingsCreatorMonetizationOnboardingViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ServerSettingsCreatorMonetizationOnboardingViewModel$Event event) throws Throwable {
        if (event instanceof ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast) {
            Error.handle(((ServerSettingsCreatorMonetizationOnboardingViewModel$Event$ShowErrorToast) event).getError(), WidgetServerSettingsCreatorMonetizationOnboarding.class.getSimpleName(), null, getActivity());
        }
    }

    public static final void launch(Context context, long j) {
        Companion.launch(context, j);
    }

    private final List<EligibilityChecklistView$Requirement> toChecklistRequirements(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        EligibilityChecklistView$Requirement[] eligibilityChecklistView$RequirementArr = new EligibilityChecklistView$Requirement[6];
        String string = creatorMonetizationEligibilityRequirements.getSize() ? getString(2131890560) : getString(2131890561);
        m.checkNotNullExpressionValue(string, "when {\n                s…eligible)\n              }");
        eligibilityChecklistView$RequirementArr[0] = new EligibilityChecklistView$Requirement(string, b.e(this, 2131890559, new Object[0], new WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1(this, creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getSize());
        String string2 = creatorMonetizationEligibilityRequirements.getAge() ? getString(2131890554) : getString(2131890555);
        m.checkNotNullExpressionValue(string2, "when {\n                a…eligible)\n              }");
        eligibilityChecklistView$RequirementArr[1] = new EligibilityChecklistView$Requirement(string2, b.e(this, 2131890553, new Object[0], new WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$2(this, creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getAge());
        String string3 = creatorMonetizationEligibilityRequirements.getSafeEnvironment() ? getString(2131890569) : getString(2131890570);
        m.checkNotNullExpressionValue(string3, "when {\n                s…        )\n              }");
        eligibilityChecklistView$RequirementArr[2] = new EligibilityChecklistView$Requirement(string3, b.e(this, 2131890568, new Object[0], WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3.INSTANCE), creatorMonetizationEligibilityRequirements.getSafeEnvironment());
        String string4 = creatorMonetizationEligibilityRequirements.getEngagementHealthy() ? getString(2131890557) : getString(2131890558);
        m.checkNotNullExpressionValue(string4, "when {\n                e…        )\n              }");
        String string5 = getString(2131890556);
        m.checkNotNullExpressionValue(string5, "getString(R.string.guild…ommunicators_description)");
        eligibilityChecklistView$RequirementArr[3] = new EligibilityChecklistView$Requirement(string4, string5, creatorMonetizationEligibilityRequirements.getEngagementHealthy());
        String string6 = creatorMonetizationEligibilityRequirements.getRetentionHealthy() ? getString(2131890566) : getString(2131890567);
        m.checkNotNullExpressionValue(string6, "when {\n                r…eligible)\n              }");
        String string7 = getString(2131890565);
        m.checkNotNullExpressionValue(string7, "getString(R.string.guild…nt_retention_description)");
        eligibilityChecklistView$RequirementArr[4] = new EligibilityChecklistView$Requirement(string6, string7, creatorMonetizationEligibilityRequirements.getRetentionHealthy());
        String string8 = creatorMonetizationEligibilityRequirements.i().isEmpty() ? getString(2131890563) : getString(2131890564);
        m.checkNotNullExpressionValue(string8, "when {\n                n…        )\n              }");
        String string9 = getString(2131890562);
        m.checkNotNullExpressionValue(string9, "getString(R.string.guild…nsfw_content_description)");
        eligibilityChecklistView$RequirementArr[5] = new EligibilityChecklistView$Requirement(string8, string9, creatorMonetizationEligibilityRequirements.i().isEmpty());
        return n.listOf((Object[]) eligibilityChecklistView$RequirementArr);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger$a
    public LoggingConfig getLoggingConfig() {
        return (LoggingConfig) getViewModel().withViewState(new WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(2131891423);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsCreatorMonetizationOnboardingViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetServerSettingsCreatorMonetizationOnboarding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), WidgetServerSettingsCreatorMonetizationOnboarding.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }
}
