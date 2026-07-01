package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.f0;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildSubscriptionPlanSetupBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import com.discord.views.steps.StepsView$b$a;
import com.discord.views.steps.StepsView$d;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel$ViewState;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
import d0.g;
import d0.o;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
import java.util.List;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Observable;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetGuildRoleSubscriptionPlanSetup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", 0)};
    public static final WidgetGuildRoleSubscriptionPlanSetup$Companion Companion = new WidgetGuildRoleSubscriptionPlanSetup$Companion(null);
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: createTierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy createTierViewModel;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: setupViewModel$delegate, reason: from kotlin metadata */
    private final Lazy setupViewModel;

    /* JADX INFO: renamed from: subscriptionPlanDetailsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy subscriptionPlanDetailsViewModel;

    public WidgetGuildRoleSubscriptionPlanSetup() {
        super(R$layout.widget_guild_subscription_plan_setup);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanSetup$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetGuildRoleSubscriptionPlanSetup$guildId$2(this));
        this.setupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(new WidgetGuildRoleSubscriptionPlanSetup$setupViewModel$2(this)));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2.INSTANCE));
        this.subscriptionPlanDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$5(this), new f0(WidgetGuildRoleSubscriptionPlanSetup$subscriptionPlanDetailsViewModel$2.INSTANCE));
    }

    public static final /* synthetic */ void access$configureUI(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup, GuildRoleSubscriptionPlanSetupViewModel$ViewState guildRoleSubscriptionPlanSetupViewModel$ViewState) {
        widgetGuildRoleSubscriptionPlanSetup.configureUI(guildRoleSubscriptionPlanSetupViewModel$ViewState);
    }

    public static final /* synthetic */ GuildRoleSubscriptionTierViewModel access$getCreateTierViewModel$p(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        return widgetGuildRoleSubscriptionPlanSetup.getCreateTierViewModel();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        return widgetGuildRoleSubscriptionPlanSetup.getGuildId();
    }

    public static final /* synthetic */ GuildRoleSubscriptionPlanSetupViewModel access$getSetupViewModel$p(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup) {
        return widgetGuildRoleSubscriptionPlanSetup.getSetupViewModel();
    }

    public static final /* synthetic */ void access$handleEvents(WidgetGuildRoleSubscriptionPlanSetup widgetGuildRoleSubscriptionPlanSetup, GuildRoleSubscriptionPlanSetupViewModel$Event guildRoleSubscriptionPlanSetupViewModel$Event) {
        widgetGuildRoleSubscriptionPlanSetup.handleEvents(guildRoleSubscriptionPlanSetupViewModel$Event);
    }

    private final void configureUI(GuildRoleSubscriptionPlanSetupViewModel$ViewState viewState) {
        StepsView stepsView = getBinding().f2454b;
        stepsView.setIsNextButtonEnabled(viewState.getCanProceedToNextStep());
        stepsView.setIsDoneButtonEnabled(!viewState.isSubmitting());
        stepsView.setIsLoading(viewState.isSubmitting());
        stepsView.b(viewState.getCurrentStep());
    }

    private final WidgetGuildSubscriptionPlanSetupBinding getBinding() {
        return (WidgetGuildSubscriptionPlanSetupBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final GuildRoleSubscriptionTierViewModel getCreateTierViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.createTierViewModel.getValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanSetupViewModel getSetupViewModel() {
        return (GuildRoleSubscriptionPlanSetupViewModel) this.setupViewModel.getValue();
    }

    private final GuildRoleSubscriptionPlanDetailsViewModel getSubscriptionPlanDetailsViewModel() {
        return (GuildRoleSubscriptionPlanDetailsViewModel) this.subscriptionPlanDetailsViewModel.getValue();
    }

    private final void handleEvents(GuildRoleSubscriptionPlanSetupViewModel$Event event) {
        if (!(event instanceof GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitSuccess)) {
            if (event instanceof GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure) {
                ((GuildRoleSubscriptionPlanSetupViewModel$Event$SubmitFailure) event).getError().showToasts(requireContext());
            }
        } else {
            WidgetServerSettingsGuildRoleSubscriptionTierList.Companion.launch(requireContext(), getGuildId());
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
            }
        }
    }

    public static final void launch(Context context, long j) {
        Companion.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = n.listOf((Object[]) new StepsView$b$a[]{new StepsView$b$a(WidgetGuildRoleSubscriptionPlanFormat.class, 2131890445, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView$b$a(WidgetGuildRoleSubscriptionPlanDetails.class, 2131890445, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$2(this), null, null, false, false, false, 476), new StepsView$b$a(WidgetGuildRoleSubscriptionTierDetails.class, 2131890445, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$3(this), null, null, false, false, false, 476), new StepsView$b$a(WidgetGuildRoleSubscriptionTierBenefits.class, 2131890445, 0, 0, BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), o.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$4(this), null, null, false, false, false, 460), new StepsView$b$a(WidgetGuildRoleSubscriptionTierBenefits.class, 2131890445, 0, 0, BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), o.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$5(this), null, null, false, false, false, 460), new StepsView$b$a(WidgetGuildRoleSubscriptionTierDesign.class, 2131890445, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$6(this), null, null, false, false, false, 476), new StepsView$b$a(WidgetGuildRoleSubscriptionReview.class, 0, 0, 2131890520, BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), o.to(WidgetGuildRoleSubscriptionReview.ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, Boolean.TRUE)), null, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$7(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f2454b;
        StepsView$d stepsView$d = new StepsView$d(this, listListOf);
        WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 widgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 = new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1(this, listListOf);
        int i = StepsView.j;
        stepsView.a(stepsView$d, widgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1, b.a.y.p0.a.j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$2(this), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeViewState(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeEvents(), this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$2(this), 62, (Object) null);
        Observable<GuildRoleSubscriptionTierViewModel$ViewState> observableR = getCreateTierViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$3(this), 62, (Object) null);
        Observable<GuildRoleSubscriptionPlanDetailsViewModel$ViewState> observableR2 = getSubscriptionPlanDetailsViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR2, "subscriptionPlanDetailsV…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetGuildRoleSubscriptionPlanSetup.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$4(this), 62, (Object) null);
    }
}
