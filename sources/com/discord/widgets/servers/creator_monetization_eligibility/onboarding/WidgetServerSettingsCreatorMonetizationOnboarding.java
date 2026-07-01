package com.discord.widgets.servers.creator_monetization_eligibility.onboarding;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppLogger2;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingAcceptTermsBinding;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingCreateRequestBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.KotlinExtensions;
import com.discord.utilities.color.ColorCompat2;
import com.discord.utilities.error.Error;
import com.discord.utilities.resources.DurationUtils2;
import com.discord.utilities.resources.DurationUtils3;
import com.discord.utilities.resources.DurationUtils4;
import com.discord.utilities.resources.StringResourceUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ScrollViewExtensions;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.google.android.material.button.MaterialButton;
import d0.LazyJVM;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetServerSettingsCreatorMonetizationOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class Companion {
        private Companion() {
        }

        private final CharSequence formatRejectionCooldown(Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock) {
            long time = rejection.getCanReapplyAt().getTime() - clock.currentTimeMillis();
            if (time <= 0) {
                return null;
            }
            return DurationUtils4.INSTANCE.formatDurationInMillis(context, time);
        }

        public static /* synthetic */ CharSequence formatRejectionCooldown$default(Companion companion, Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock, int i, Object obj) {
            if ((i & 2) != 0) {
                clock = ClockFactory.get();
            }
            return companion.formatRejectionCooldown(context, rejection, clock);
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetServerSettingsCreatorMonetizationOnboarding.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
        public static final class AnonymousClass1 extends Lambda implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                Intrinsics3.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new FontColorSpan(ColorCompat2.getColor(WidgetServerSettingsCreatorMonetizationOnboarding.this, R.color.status_red_500)));
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
            renderContext.a("doesNotHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding = WidgetServerSettingsCreatorMonetizationOnboarding.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsCreatorMonetizationOnboarding.configureUI(viewState);
            WidgetServerSettingsCreatorMonetizationOnboarding.this.getAppLogger().b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetServerSettingsCreatorMonetizationOnboarding.this.handleEvent(event);
        }
    }

    public WidgetServerSettingsCreatorMonetizationOnboarding() {
        super(R.layout.widget_server_settings_creator_monetization_onboarding);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetServerSettingsCreatorMonetizationOnboarding$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$guildId$2(this));
        WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 = new WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ServerSettingsCreatorMonetizationOnboardingViewModel.class), new WidgetServerSettingsCreatorMonetizationOnboarding$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2));
        this.createRequestBinding = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$createRequestBinding$2(this));
        this.acceptTermsBinding = LazyJVM.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsBinding$2(this));
        LazyViewStubDelegate.Companion companion = LazyViewStubDelegate.INSTANCE;
        this.createRequestOnlyGuildOwnerNotice = companion.lazyViewStub(new WidgetServerSettingsCreatorMonetizationOnboarding$createRequestOnlyGuildOwnerNotice$2(this));
        this.acceptTermsOnlyGuildOwnerNotice = companion.lazyViewStub(new WidgetServerSettingsCreatorMonetizationOnboarding$acceptTermsOnlyGuildOwnerNotice$2(this));
    }

    private final void configureAcceptTermsState(final ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms viewState) {
        getAcceptTermsOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        CheckBox checkBox = getAcceptTermsBinding().c;
        checkBox.setChecked(viewState.getHasAcceptedTerms());
        checkBox.setEnabled(!viewState.isSubmitting() && viewState.isGuildOwner());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.this$0.getViewModel().setHasAcceptedTerms(z2);
                if (z2) {
                    ScrollView scrollView = this.this$0.getAcceptTermsBinding().d;
                    Intrinsics3.checkNotNullExpressionValue(scrollView, "acceptTermsBinding.acceptTermsScrollView");
                    ScrollViewExtensions.flashScrollBars(scrollView);
                }
            }
        });
        LoadingButton loadingButton = getAcceptTermsBinding().f2557b;
        loadingButton.setEnabled(viewState.getHasAcceptedTerms() && viewState.isGuildOwner());
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().submitTermsAcceptance();
            }
        });
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009d  */
    private final void configureCreateRequestState(final ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest viewState) {
        CharSequence rejectionCooldown$default;
        boolean z2;
        LoadingButton loadingButton = getCreateRequestBinding().c;
        loadingButton.setEnabled(viewState.getRequirements().getCanApply() && viewState.isGuildOwner());
        loadingButton.setVisibility(viewState.isApplicationPending() ^ true ? 0 : 8);
        loadingButton.setIsLoading(viewState.isSubmitting());
        loadingButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$$inlined$apply$lambda$1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.this$0.getViewModel().createRequestToEnableMonetization();
            }
        });
        getCreateRequestOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        MaterialButton materialButton = getCreateRequestBinding().f2559b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "createRequestBinding.applicationPendingButton");
        materialButton.setVisibility(viewState.isApplicationPending() ? 0 : 8);
        TextView textView = getCreateRequestBinding().h;
        CreatorMonetizationEligibilityRequirements.Rejection rejectionJ = viewState.getRequirements().getRejection();
        if (rejectionJ != null) {
            Companion companion = INSTANCE;
            Context context = textView.getContext();
            Intrinsics3.checkNotNullExpressionValue(context, "context");
            rejectionCooldown$default = Companion.formatRejectionCooldown$default(companion, context, rejectionJ, null, 2, null);
        } else {
            rejectionCooldown$default = null;
        }
        if (rejectionCooldown$default != null) {
            CreatorMonetizationEnableRequest creatorMonetizationEnableRequestF = viewState.getRequirements().getLatestRequest();
            z2 = (creatorMonetizationEnableRequestF != null ? creatorMonetizationEnableRequestF.getState() : null) == CreatorMonetizationEnableRequest.State.REJECTED;
        }
        textView.setVisibility(z2 ? 0 : 8);
        if (rejectionCooldown$default != null) {
            FormatUtils.m(textView, R.string.guild_role_subscription_settings_enable_request_rejected, new Object[0], new WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$2$1(rejectionCooldown$default));
        }
        LinkifiedTextView linkifiedTextView = getCreateRequestBinding().i;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "createRequestBinding.requirementsDescription");
        FormatUtils.m(linkifiedTextView, R.string.guild_role_subscription_settings_enable_requirements_description, new Object[0], AnonymousClass3.INSTANCE);
        ImageView imageView = getCreateRequestBinding().e;
        Intrinsics3.checkNotNullExpressionValue(imageView, "createRequestBinding.eli…yChecklistHeaderIndicator");
        imageView.setActivated(viewState.getRequirements().getSufficient());
        if (viewState.getRequirements().getSufficient()) {
            TextView textView2 = getCreateRequestBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView2, "createRequestBinding.eligibilityChecklistTitle");
            FormatUtils.m(textView2, R.string.guild_role_subscription_settings_eligible_message, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
        } else {
            TextView textView3 = getCreateRequestBinding().f;
            Intrinsics3.checkNotNullExpressionValue(textView3, "createRequestBinding.eligibilityChecklistTitle");
            FormatUtils.m(textView3, R.string.guild_role_subscription_settings_not_eligible_message, new Object[0], new AnonymousClass4());
        }
        getCreateRequestBinding().d.bind(toChecklistRequirements(viewState.getRequirements()));
    }

    private final void configureUI(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.viewFlipper");
            appViewFlipper.setDisplayedChild(0);
            unit = Unit.a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) {
            AppViewFlipper appViewFlipper2 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper2, "binding.viewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().f2558b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.errorNoticeText");
            textView.setText(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) viewState).getError().getDisplayString(requireContext()));
            unit = Unit.a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            AppViewFlipper appViewFlipper3 = getBinding().e;
            Intrinsics3.checkNotNullExpressionValue(appViewFlipper3, "binding.viewFlipper");
            appViewFlipper3.setDisplayedChild(2);
            configureCreateRequestState((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) viewState);
            unit = Unit.a;
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms)) {
                throw new NoWhenBranchMatchedException();
            }
            ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) viewState;
            if (acceptTerms.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
                requireActivity().finish();
                unit = Unit.a;
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().e;
                Intrinsics3.checkNotNullExpressionValue(appViewFlipper4, "binding.viewFlipper");
                appViewFlipper4.setDisplayedChild(3);
                configureAcceptTermsState(acceptTerms);
                unit = Unit.a;
            }
        }
        KotlinExtensions.getExhaustive(unit);
    }

    private final CharSequence formatDurationFromDays(int minimumAgeInDays) {
        return (minimumAgeInDays <= 0 || minimumAgeInDays % 7 != 0) ? DurationUtils3.formatDuration(requireContext(), DurationUtils2.DAYS, minimumAgeInDays) : DurationUtils3.formatDuration(requireContext(), DurationUtils2.WEEKS, minimumAgeInDays / 7);
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

    private final void handleEvent(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
        if (event instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) {
            Error.handle(((ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) event).getError(), WidgetServerSettingsCreatorMonetizationOnboarding.class.getSimpleName(), null, e());
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    private final List<EligibilityChecklistView.Requirement> toChecklistRequirements(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        EligibilityChecklistView.Requirement[] requirementArr = new EligibilityChecklistView.Requirement[6];
        String string = creatorMonetizationEligibilityRequirements.getSize() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_members_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string, "when {\n                s…eligible)\n              }");
        requirementArr[0] = new EligibilityChecklistView.Requirement(string, FormatUtils.e(this, R.string.guild_role_subscription_settings_eligibility_requirement_members_description, new Object[0], new AnonymousClass1(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getSize());
        String string2 = creatorMonetizationEligibilityRequirements.getAge() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_age_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_age_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string2, "when {\n                a…eligible)\n              }");
        requirementArr[1] = new EligibilityChecklistView.Requirement(string2, FormatUtils.e(this, R.string.guild_role_subscription_settings_eligibility_requirement_age_description, new Object[0], new AnonymousClass2(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getAge());
        String string3 = creatorMonetizationEligibilityRequirements.getSafeEnvironment() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_violations_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string3, "when {\n                s…        )\n              }");
        requirementArr[2] = new EligibilityChecklistView.Requirement(string3, FormatUtils.e(this, R.string.guild_role_subscription_settings_eligibility_requirement_violations_description, new Object[0], AnonymousClass3.INSTANCE), creatorMonetizationEligibilityRequirements.getSafeEnvironment());
        String string4 = creatorMonetizationEligibilityRequirements.getEngagementHealthy() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_communicators_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_communicators_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string4, "when {\n                e…        )\n              }");
        String string5 = getString(R.string.guild_role_subscription_settings_eligibility_requirement_communicators_description);
        Intrinsics3.checkNotNullExpressionValue(string5, "getString(R.string.guild…ommunicators_description)");
        requirementArr[3] = new EligibilityChecklistView.Requirement(string4, string5, creatorMonetizationEligibilityRequirements.getEngagementHealthy());
        String string6 = creatorMonetizationEligibilityRequirements.getRetentionHealthy() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_retention_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_retention_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string6, "when {\n                r…eligible)\n              }");
        String string7 = getString(R.string.guild_role_subscription_settings_eligibility_requirement_retention_description);
        Intrinsics3.checkNotNullExpressionValue(string7, "getString(R.string.guild…nt_retention_description)");
        requirementArr[4] = new EligibilityChecklistView.Requirement(string6, string7, creatorMonetizationEligibilityRequirements.getRetentionHealthy());
        String string8 = creatorMonetizationEligibilityRequirements.i().isEmpty() ? getString(R.string.guild_role_subscription_settings_eligibility_requirement_nsfw_content_eligible) : getString(R.string.guild_role_subscription_settings_eligibility_requirement_nsfw_content_not_eligible);
        Intrinsics3.checkNotNullExpressionValue(string8, "when {\n                n…        )\n              }");
        String string9 = getString(R.string.guild_role_subscription_settings_eligibility_requirement_nsfw_content_description);
        Intrinsics3.checkNotNullExpressionValue(string9, "getString(R.string.guild…nsfw_content_description)");
        requirementArr[5] = new EligibilityChecklistView.Requirement(string8, string9, creatorMonetizationEligibilityRequirements.i().isEmpty());
        return Collections2.listOf((Object[]) requirementArr);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.a
    public AppLogger2 getLoggingConfig() {
        return (AppLogger2) getViewModel().withViewState(new WidgetServerSettingsCreatorMonetizationOnboarding$loggingConfig$1(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(R.string.guild_settings_role_subscriptions_title);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetServerSettingsCreatorMonetizationOnboarding.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsCreatorMonetizationOnboarding.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("faqUrl", "https://support.discord.com/hc/en-us/articles/5371495812631");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumAge", WidgetServerSettingsCreatorMonetizationOnboarding.this.formatDurationFromDays(this.$this_toChecklistRequirements.getMinimumAgeInDays()).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("communityGuidelinesUrl", "https://support.discord.com/hc/en-us/articles/360035969312");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumSize", StringResourceUtils.getI18nPluralString(WidgetServerSettingsCreatorMonetizationOnboarding.this.requireContext(), R.plurals.guild_role_subscription_settings_eligibility_requirement_members_description_minimumSize, this.$this_toChecklistRequirements.getMinimumSize(), Integer.valueOf(this.$this_toChecklistRequirements.getMinimumSize())).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
