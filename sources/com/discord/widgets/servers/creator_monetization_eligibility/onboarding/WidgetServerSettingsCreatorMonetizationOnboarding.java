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
import com.discord.C5419R;
import com.discord.api.creatormonetization.CreatorMonetizationEligibilityRequirements;
import com.discord.api.creatormonetization.CreatorMonetizationEnableRequest;
import com.discord.api.guild.GuildFeature;
import com.discord.app.AppFragment;
import com.discord.app.AppViewFlipper;
import com.discord.app.LoggingConfig;
import com.discord.databinding.C5473x4f85106c;
import com.discord.databinding.C5474x305cfbd8;
import com.discord.databinding.WidgetServerSettingsCreatorMonetizationOnboardingBinding;
import com.discord.i18n.Hook;
import com.discord.i18n.RenderContext;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.color.ColorCompatKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.resources.DurationUnit;
import com.discord.utilities.resources.DurationUtilsKt;
import com.discord.utilities.resources.MillisecondsFormatter;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.textprocessing.FontColorSpan;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import com.discord.utilities.view.extensions.ScrollViewExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.utilities.views.viewstub.LazyViewStubDelegate;
import com.discord.views.LoadingButton;
import com.discord.widgets.servers.creator_monetization_eligibility.EligibilityChecklistView;
import com.discord.widgets.servers.creator_monetization_eligibility.onboarding.ServerSettingsCreatorMonetizationOnboardingViewModel;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsEmptyGuildRoleSubscriptions;
import com.google.android.material.button.MaterialButton;
import java.util.List;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsCreatorMonetizationOnboarding extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetServerSettingsCreatorMonetizationOnboarding.class, "binding", "getBinding()Lcom/discord/databinding/WidgetServerSettingsCreatorMonetizationOnboardingBinding;", 0)};

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
            return MillisecondsFormatter.INSTANCE.formatDurationInMillis(context, time);
        }

        public static /* synthetic */ CharSequence formatRejectionCooldown$default(Companion companion, Context context, CreatorMonetizationEligibilityRequirements.Rejection rejection, Clock clock, int i, Object obj) {
            if ((i & 2) != 0) {
                clock = ClockFactory.get();
            }
            return companion.formatRejectionCooldown(context, rejection, clock);
        }

        public final void launch(Context context, long guildId) {
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("com.discord.intent.extra.EXTRA_GUILD_ID", guildId);
            C0870j.m156d(context, WidgetServerSettingsCreatorMonetizationOnboarding.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94304 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C94304() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$4$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function1<Hook, Unit> {
            public AnonymousClass1() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Hook hook) {
                C12238m.checkNotNullParameter(hook, "$receiver");
                hook.styles.add(new FontColorSpan(ColorCompatKt.getColor(WidgetServerSettingsCreatorMonetizationOnboarding.this, C5419R.color.status_red_500)));
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
            renderContext.m8422a("doesNotHook", new AnonymousClass1());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94341 extends AbstractC12240o implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState, Unit> {
        public C94341() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
            WidgetServerSettingsCreatorMonetizationOnboarding widgetServerSettingsCreatorMonetizationOnboarding = WidgetServerSettingsCreatorMonetizationOnboarding.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetServerSettingsCreatorMonetizationOnboarding.configureUI(viewState);
            WidgetServerSettingsCreatorMonetizationOnboarding.this.getAppLogger().m8372b();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94352 extends AbstractC12240o implements Function1<ServerSettingsCreatorMonetizationOnboardingViewModel.Event, Unit> {
        public C94352() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ServerSettingsCreatorMonetizationOnboardingViewModel.Event event) throws Throwable {
            C12238m.checkNotNullParameter(event, "it");
            WidgetServerSettingsCreatorMonetizationOnboarding.this.handleEvent(event);
        }
    }

    public WidgetServerSettingsCreatorMonetizationOnboarding() {
        super(C5419R.layout.widget_server_settings_creator_monetization_onboarding);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetServerSettingsCreatorMonetizationOnboarding$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetServerSettingsCreatorMonetizationOnboarding$guildId$2(this));
        WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2 = new WidgetServerSettingsCreatorMonetizationOnboarding$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ServerSettingsCreatorMonetizationOnboardingViewModel.class), new C9424x8b88e847(c0865g0), new C0869i0(widgetServerSettingsCreatorMonetizationOnboarding$viewModel$2));
        this.createRequestBinding = C12083g.lazy(new C9431x4350d5de(this));
        this.acceptTermsBinding = C12083g.lazy(new C9422xff1a9372(this));
        LazyViewStubDelegate.Companion companion = LazyViewStubDelegate.INSTANCE;
        this.createRequestOnlyGuildOwnerNotice = companion.lazyViewStub(new C9432x5ac632a7(this));
        this.acceptTermsOnlyGuildOwnerNotice = companion.lazyViewStub(new C9423x1fb02593(this));
    }

    private final void configureAcceptTermsState(final ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms viewState) {
        getAcceptTermsOnlyGuildOwnerNotice().setVisible(!viewState.isGuildOwner());
        CheckBox checkBox = getAcceptTermsBinding().f17594c;
        checkBox.setChecked(viewState.getHasAcceptedTerms());
        checkBox.setEnabled(!viewState.isSubmitting() && viewState.isGuildOwner());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureAcceptTermsState$$inlined$apply$lambda$1
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                this.this$0.getViewModel().setHasAcceptedTerms(z2);
                if (z2) {
                    ScrollView scrollView = this.this$0.getAcceptTermsBinding().f17595d;
                    C12238m.checkNotNullExpressionValue(scrollView, "acceptTermsBinding.acceptTermsScrollView");
                    ScrollViewExtensionsKt.flashScrollBars(scrollView);
                }
            }
        });
        LoadingButton loadingButton = getAcceptTermsBinding().f17593b;
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
        LoadingButton loadingButton = getCreateRequestBinding().f17604c;
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
        MaterialButton materialButton = getCreateRequestBinding().f17603b;
        C12238m.checkNotNullExpressionValue(materialButton, "createRequestBinding.applicationPendingButton");
        materialButton.setVisibility(viewState.isApplicationPending() ? 0 : 8);
        TextView textView = getCreateRequestBinding().f17609h;
        CreatorMonetizationEligibilityRequirements.Rejection rejectionM7775j = viewState.getRequirements().getRejection();
        if (rejectionM7775j != null) {
            Companion companion = INSTANCE;
            Context context = textView.getContext();
            C12238m.checkNotNullExpressionValue(context, "context");
            rejectionCooldown$default = Companion.formatRejectionCooldown$default(companion, context, rejectionM7775j, null, 2, null);
        } else {
            rejectionCooldown$default = null;
        }
        if (rejectionCooldown$default != null) {
            CreatorMonetizationEnableRequest creatorMonetizationEnableRequestM7771f = viewState.getRequirements().getLatestRequest();
            z2 = (creatorMonetizationEnableRequestM7771f != null ? creatorMonetizationEnableRequestM7771f.getState() : null) == CreatorMonetizationEnableRequest.State.REJECTED;
        }
        textView.setVisibility(z2 ? 0 : 8);
        if (rejectionCooldown$default != null) {
            C1107b.m221m(textView, C5419R.string.guild_role_subscription_settings_enable_request_rejected, new Object[0], new C9428x2d7e4c81(rejectionCooldown$default));
        }
        LinkifiedTextView linkifiedTextView = getCreateRequestBinding().f17610i;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "createRequestBinding.requirementsDescription");
        C1107b.m221m(linkifiedTextView, C5419R.string.guild_role_subscription_settings_enable_requirements_description, new Object[0], C94293.INSTANCE);
        ImageView imageView = getCreateRequestBinding().f17606e;
        C12238m.checkNotNullExpressionValue(imageView, "createRequestBinding.eli…yChecklistHeaderIndicator");
        imageView.setActivated(viewState.getRequirements().getSufficient());
        if (viewState.getRequirements().getSufficient()) {
            TextView textView2 = getCreateRequestBinding().f17607f;
            C12238m.checkNotNullExpressionValue(textView2, "createRequestBinding.eligibilityChecklistTitle");
            C1107b.m221m(textView2, C5419R.string.guild_role_subscription_settings_eligible_message, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
        } else {
            TextView textView3 = getCreateRequestBinding().f17607f;
            C12238m.checkNotNullExpressionValue(textView3, "createRequestBinding.eligibilityChecklistTitle");
            C1107b.m221m(textView3, C5419R.string.guild_role_subscription_settings_not_eligible_message, new Object[0], new C94304());
        }
        getCreateRequestBinding().f17605d.bind(toChecklistRequirements(viewState.getRequirements()));
    }

    private final void configureUI(ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState viewState) {
        Unit unit;
        if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Loading) {
            AppViewFlipper appViewFlipper = getBinding().f17601e;
            C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.viewFlipper");
            appViewFlipper.setDisplayedChild(0);
            unit = Unit.f27425a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) {
            AppViewFlipper appViewFlipper2 = getBinding().f17601e;
            C12238m.checkNotNullExpressionValue(appViewFlipper2, "binding.viewFlipper");
            appViewFlipper2.setDisplayedChild(1);
            TextView textView = getBinding().f17598b;
            C12238m.checkNotNullExpressionValue(textView, "binding.errorNoticeText");
            textView.setText(((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.Error) viewState).getError().getDisplayString(requireContext()));
            unit = Unit.f27425a;
        } else if (viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) {
            AppViewFlipper appViewFlipper3 = getBinding().f17601e;
            C12238m.checkNotNullExpressionValue(appViewFlipper3, "binding.viewFlipper");
            appViewFlipper3.setDisplayedChild(2);
            configureCreateRequestState((ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.CreateRequest) viewState);
            unit = Unit.f27425a;
        } else {
            if (!(viewState instanceof ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms)) {
                throw new NoWhenBranchMatchedException();
            }
            ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms acceptTerms = (ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState.AcceptTerms) viewState;
            if (acceptTerms.getGuild().hasFeature(GuildFeature.CREATOR_MONETIZABLE)) {
                WidgetServerSettingsEmptyGuildRoleSubscriptions.INSTANCE.launch(requireContext(), getGuildId());
                requireActivity().finish();
                unit = Unit.f27425a;
            } else {
                AppViewFlipper appViewFlipper4 = getBinding().f17601e;
                C12238m.checkNotNullExpressionValue(appViewFlipper4, "binding.viewFlipper");
                appViewFlipper4.setDisplayedChild(3);
                configureAcceptTermsState(acceptTerms);
                unit = Unit.f27425a;
            }
        }
        KotlinExtensionsKt.getExhaustive(unit);
    }

    private final CharSequence formatDurationFromDays(int minimumAgeInDays) {
        return (minimumAgeInDays <= 0 || minimumAgeInDays % 7 != 0) ? DurationUtilsKt.formatDuration(requireContext(), DurationUnit.DAYS, minimumAgeInDays) : DurationUtilsKt.formatDuration(requireContext(), DurationUnit.WEEKS, minimumAgeInDays / 7);
    }

    private final C5473x4f85106c getAcceptTermsBinding() {
        return (C5473x4f85106c) this.acceptTermsBinding.getValue();
    }

    private final LazyViewStubDelegate getAcceptTermsOnlyGuildOwnerNotice() {
        return (LazyViewStubDelegate) this.acceptTermsOnlyGuildOwnerNotice.getValue();
    }

    private final WidgetServerSettingsCreatorMonetizationOnboardingBinding getBinding() {
        return (WidgetServerSettingsCreatorMonetizationOnboardingBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final C5474x305cfbd8 getCreateRequestBinding() {
        return (C5474x305cfbd8) this.createRequestBinding.getValue();
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
            Error.handle(((ServerSettingsCreatorMonetizationOnboardingViewModel.Event.ShowErrorToast) event).getError(), WidgetServerSettingsCreatorMonetizationOnboarding.class.getSimpleName(), null, m95e());
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    private final List<EligibilityChecklistView.Requirement> toChecklistRequirements(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
        EligibilityChecklistView.Requirement[] requirementArr = new EligibilityChecklistView.Requirement[6];
        String string = creatorMonetizationEligibilityRequirements.getSize() ? getString(C5419R.string.f14692x95c3e2c2) : getString(C5419R.string.f14693xc54a792e);
        C12238m.checkNotNullExpressionValue(string, "when {\n                s…eligible)\n              }");
        requirementArr[0] = new EligibilityChecklistView.Requirement(string, C1107b.m213e(this, C5419R.string.f14691x26fcaf31, new Object[0], new C94361(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getSize());
        String string2 = creatorMonetizationEligibilityRequirements.getAge() ? getString(C5419R.string.f14686xe742c01c) : getString(C5419R.string.f14687x57071988);
        C12238m.checkNotNullExpressionValue(string2, "when {\n                a…eligible)\n              }");
        requirementArr[1] = new EligibilityChecklistView.Requirement(string2, C1107b.m213e(this, C5419R.string.f14685xe15d9b97, new Object[0], new C94372(creatorMonetizationEligibilityRequirements)), creatorMonetizationEligibilityRequirements.getAge());
        String string3 = creatorMonetizationEligibilityRequirements.getSafeEnvironment() ? getString(C5419R.string.f14701x95059463) : getString(C5419R.string.f14702x328724f);
        C12238m.checkNotNullExpressionValue(string3, "when {\n                s…        )\n              }");
        requirementArr[2] = new EligibilityChecklistView.Requirement(string3, C1107b.m213e(this, C5419R.string.f14700xa4da8df0, new Object[0], C94383.INSTANCE), creatorMonetizationEligibilityRequirements.getSafeEnvironment());
        String string4 = creatorMonetizationEligibilityRequirements.getEngagementHealthy() ? getString(C5419R.string.f14689xa26c16fd) : getString(C5419R.string.f14690x1df817e9);
        C12238m.checkNotNullExpressionValue(string4, "when {\n                e…        )\n              }");
        String string5 = getString(C5419R.string.f14688x1112cd16);
        C12238m.checkNotNullExpressionValue(string5, "getString(R.string.guild…ommunicators_description)");
        requirementArr[3] = new EligibilityChecklistView.Requirement(string4, string5, creatorMonetizationEligibilityRequirements.getEngagementHealthy());
        String string6 = creatorMonetizationEligibilityRequirements.getRetentionHealthy() ? getString(C5419R.string.f14698x8b46b51d) : getString(C5419R.string.f14699xbe16a609);
        C12238m.checkNotNullExpressionValue(string6, "when {\n                r…eligible)\n              }");
        String string7 = getString(C5419R.string.f14697x89d9faf6);
        C12238m.checkNotNullExpressionValue(string7, "getString(R.string.guild…nt_retention_description)");
        requirementArr[4] = new EligibilityChecklistView.Requirement(string6, string7, creatorMonetizationEligibilityRequirements.getRetentionHealthy());
        String string8 = creatorMonetizationEligibilityRequirements.m7774i().isEmpty() ? getString(C5419R.string.f14695xfcdc6141) : getString(C5419R.string.f14696xd6f1a02d);
        C12238m.checkNotNullExpressionValue(string8, "when {\n                n…        )\n              }");
        String string9 = getString(C5419R.string.f14694x82652c52);
        C12238m.checkNotNullExpressionValue(string9, "getString(R.string.guild…nsfw_content_description)");
        requirementArr[5] = new EligibilityChecklistView.Requirement(string8, string9, creatorMonetizationEligibilityRequirements.m7774i().isEmpty());
        return C12147n.listOf((Object[]) requirementArr);
    }

    @Override // com.discord.app.AppFragment, com.discord.app.AppLogger.InterfaceC5455a
    public LoggingConfig getLoggingConfig() {
        return (LoggingConfig) getViewModel().withViewState(new C9433x9aac34d0(this));
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarDisplayHomeAsUpEnabled(true);
        setActionBarTitle(C5419R.string.guild_settings_role_subscriptions_title);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<ServerSettingsCreatorMonetizationOnboardingViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetServerSettingsCreatorMonetizationOnboarding.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94341());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().listenForEvents(), this, null, 2, null), (Class<?>) WidgetServerSettingsCreatorMonetizationOnboarding.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C94352());
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$configureCreateRequestState$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94293 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C94293 INSTANCE = new C94293();

        public C94293() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("faqUrl", "https://support.discord.com/hc/en-us/articles/5371495812631");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$2 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94372 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C94372(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumAge", WidgetServerSettingsCreatorMonetizationOnboarding.this.formatDurationFromDays(this.$this_toChecklistRequirements.getMinimumAgeInDays()).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$3 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94383 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C94383 INSTANCE = new C94383();

        public C94383() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("communityGuidelinesUrl", "https://support.discord.com/hc/en-us/articles/360035969312");
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.servers.creator_monetization_eligibility.onboarding.WidgetServerSettingsCreatorMonetizationOnboarding$toChecklistRequirements$1 */
    /* JADX INFO: compiled from: WidgetServerSettingsCreatorMonetizationOnboarding.kt */
    public static final class C94361 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ CreatorMonetizationEligibilityRequirements $this_toChecklistRequirements;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C94361(CreatorMonetizationEligibilityRequirements creatorMonetizationEligibilityRequirements) {
            super(1);
            this.$this_toChecklistRequirements = creatorMonetizationEligibilityRequirements;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("minimumSize", StringResourceUtilsKt.getI18nPluralString(WidgetServerSettingsCreatorMonetizationOnboarding.this.requireContext(), C5419R.plurals.guild_role_subscription_settings_eligibility_requirement_members_description_minimumSize, this.$this_toChecklistRequirements.getMinimumSize(), Integer.valueOf(this.$this_toChecklistRequirements.getMinimumSize())).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }
}
