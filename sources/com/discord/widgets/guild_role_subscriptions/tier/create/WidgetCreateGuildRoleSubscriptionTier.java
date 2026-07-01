package com.discord.widgets.guild_role_subscriptions.tier.create;

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
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import com.discord.views.steps.StepsView$b$a;
import com.discord.views.steps.StepsView$d;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
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

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetCreateGuildRoleSubscriptionTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0)};
    public static final WidgetCreateGuildRoleSubscriptionTier$Companion Companion = new WidgetCreateGuildRoleSubscriptionTier$Companion(null);
    private static final String INTENT_EXTRA_GROUP_LISTING_ID = "INTENT_EXTRA_GROUP_LISTING_ID";
    private static final String INTENT_EXTRA_GUILD_ID = "INTENT_EXTRA_GUILD_ID";

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: createTierViewModel$delegate, reason: from kotlin metadata */
    private final Lazy createTierViewModel;

    /* JADX INFO: renamed from: groupListingId$delegate, reason: from kotlin metadata */
    private final Lazy groupListingId;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    public WidgetCreateGuildRoleSubscriptionTier() {
        super(R$layout.widget_create_guild_role_subscription_tier);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreateGuildRoleSubscriptionTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = g.lazy(new WidgetCreateGuildRoleSubscriptionTier$guildId$2(this));
        this.groupListingId = g.lazy(new WidgetCreateGuildRoleSubscriptionTier$groupListingId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetCreateGuildRoleSubscriptionTier$appActivityViewModels$$inlined$activityViewModels$1(this), new f0(WidgetCreateGuildRoleSubscriptionTier$viewModel$2.INSTANCE));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(CreateGuildRoleSubscriptionTierViewModel.class), new WidgetCreateGuildRoleSubscriptionTier$appActivityViewModels$$inlined$activityViewModels$3(this), new f0(new WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2(this)));
    }

    public static final /* synthetic */ void access$configureUI(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, CreateGuildRoleSubscriptionTierViewModel$ViewState createGuildRoleSubscriptionTierViewModel$ViewState) {
        widgetCreateGuildRoleSubscriptionTier.configureUI(createGuildRoleSubscriptionTierViewModel$ViewState);
    }

    public static final /* synthetic */ CreateGuildRoleSubscriptionTierViewModel access$getCreateTierViewModel$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getCreateTierViewModel();
    }

    public static final /* synthetic */ long access$getGroupListingId$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getGroupListingId();
    }

    public static final /* synthetic */ long access$getGuildId$p(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier) {
        return widgetCreateGuildRoleSubscriptionTier.getGuildId();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, CreateGuildRoleSubscriptionTierViewModel$Event createGuildRoleSubscriptionTierViewModel$Event) {
        widgetCreateGuildRoleSubscriptionTier.handleEvent(createGuildRoleSubscriptionTierViewModel$Event);
    }

    public static final /* synthetic */ void access$updateCreateTierViewModel(WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier, GuildRoleSubscriptionTierViewModel$ViewState guildRoleSubscriptionTierViewModel$ViewState) {
        widgetCreateGuildRoleSubscriptionTier.updateCreateTierViewModel(guildRoleSubscriptionTierViewModel$ViewState);
    }

    private final void configureUI(CreateGuildRoleSubscriptionTierViewModel$ViewState viewState) {
        int currentStep = viewState.getCurrentStep();
        if (currentStep < 0) {
            requireActivity().finish();
            return;
        }
        getBinding().f2359b.b(currentStep);
        getBinding().f2359b.setIsNextButtonEnabled(viewState.getCanProceed());
        getBinding().f2359b.setIsDoneButtonEnabled(!viewState.isSubmitting());
        getBinding().f2359b.setIsLoading(viewState.isSubmitting());
    }

    private final WidgetCreateGuildRoleSubscriptionTierBinding getBinding() {
        return (WidgetCreateGuildRoleSubscriptionTierBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final CreateGuildRoleSubscriptionTierViewModel getCreateTierViewModel() {
        return (CreateGuildRoleSubscriptionTierViewModel) this.createTierViewModel.getValue();
    }

    private final long getGroupListingId() {
        return ((Number) this.groupListingId.getValue()).longValue();
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(CreateGuildRoleSubscriptionTierViewModel$Event event) {
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel$Event$SubmitSuccess) {
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
                return;
            }
            return;
        }
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure) {
            ((CreateGuildRoleSubscriptionTierViewModel$Event$SubmitFailure) event).getError().showToasts(requireContext());
        } else if (event instanceof CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate) {
            getViewModel().setFullServerGating(((CreateGuildRoleSubscriptionTierViewModel$Event$ServerGatingUpdate) event).isFullServerGating());
        }
    }

    public static final void launch(Context context, long j, long j2) {
        Companion.launch(context, j, j2);
    }

    private final void updateCreateTierViewModel(GuildRoleSubscriptionTierViewModel$ViewState viewState) {
        getCreateTierViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = n.listOf((Object[]) new StepsView$b$a[]{new StepsView$b$a(WidgetGuildRoleSubscriptionTierDetails.class, 2131890445, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView$b$a(WidgetGuildRoleSubscriptionTierBenefits.class, 2131890445, 0, 0, BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), o.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$2(this), null, null, false, false, false, 460), new StepsView$b$a(WidgetGuildRoleSubscriptionTierBenefits.class, 2131890445, 0, 0, BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), o.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$3(this), null, null, false, false, false, 460), new StepsView$b$a(WidgetGuildRoleSubscriptionTierDesign.class, 2131890445, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$4(this), null, null, false, false, false, 476), new StepsView$b$a(WidgetGuildRoleSubscriptionReview.class, 0, 0, 2131890520, BundleKt.bundleOf(o.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId()))), null, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$5(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f2359b;
        StepsView$d stepsView$d = new StepsView$d(this, listListOf);
        WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 widgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 = new WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1(this, listListOf);
        int i = StepsView.j;
        stepsView.a(stepsView$d, widgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1, b.a.y.p0.a.j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$2(this), 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel$ViewState> observableR = getViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$1(this), 62, (Object) null);
        Observable<CreateGuildRoleSubscriptionTierViewModel$ViewState> observableR2 = getCreateTierViewModel().observeViewState().r();
        m.checkNotNullExpressionValue(observableR2, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$2(this), 62, (Object) null);
        Observable<CreateGuildRoleSubscriptionTierViewModel$Event> observableR3 = getCreateTierViewModel().observeEvents().r();
        m.checkNotNullExpressionValue(observableR3, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR3, this, null, 2, null), WidgetCreateGuildRoleSubscriptionTier.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3(this), 62, (Object) null);
    }
}
