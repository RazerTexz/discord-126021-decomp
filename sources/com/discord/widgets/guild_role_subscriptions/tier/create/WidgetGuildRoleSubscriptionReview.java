package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierItemDecoration;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.p579g0.C12103t;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionReview extends AppFragment {
    public static final String ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE = "ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE";
    private GuildRoleSubscriptionTierAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;

    /* JADX INFO: renamed from: guildId$delegate, reason: from kotlin metadata */
    private final Lazy guildId;

    /* JADX INFO: renamed from: planSetupViewModel$delegate, reason: from kotlin metadata */
    private final Lazy planSetupViewModel;

    /* JADX INFO: renamed from: reviewViewModel$delegate, reason: from kotlin metadata */
    private final Lazy reviewViewModel;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionReview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
    public static final class C84961 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84961() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.this.updateTier(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
    public static final class C84972 extends AbstractC12240o implements Function1<GuildRoleSubscriptionReviewViewModel.ViewState, Unit> {
        public C84972() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
    public static final class C84983 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public C84983() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.this.updatePlanDetails(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionReview() {
        super(C5419R.layout.widget_guild_role_subscription_tier_review);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionReview$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildRoleSubscriptionReview$guildId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8491x34f01039(this), new C0863f0(WidgetGuildRoleSubscriptionReview$viewModel$2.INSTANCE));
        WidgetGuildRoleSubscriptionReview$reviewViewModel$2 widgetGuildRoleSubscriptionReview$reviewViewModel$2 = new WidgetGuildRoleSubscriptionReview$reviewViewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.reviewViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionReviewViewModel.class), new C8495x384a615b(c0865g0), new C0869i0(widgetGuildRoleSubscriptionReview$reviewViewModel$2));
        this.planSetupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new C8493x34f0103b(this), new C0863f0(new WidgetGuildRoleSubscriptionReview$planSetupViewModel$2(this)));
    }

    private final void configureUI(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        guildRoleSubscriptionTierAdapter.setItems(viewState.getItems());
    }

    private final WidgetGuildRoleSubscriptionTierReviewBinding getBinding() {
        return (WidgetGuildRoleSubscriptionTierReviewBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final long getGuildId() {
        return ((Number) this.guildId.getValue()).longValue();
    }

    private final GuildRoleSubscriptionPlanSetupViewModel getPlanSetupViewModel() {
        return (GuildRoleSubscriptionPlanSetupViewModel) this.planSetupViewModel.getValue();
    }

    private final GuildRoleSubscriptionReviewViewModel getReviewViewModel() {
        return (GuildRoleSubscriptionReviewViewModel) this.reviewViewModel.getValue();
    }

    private final GuildRoleSubscriptionTierViewModel getViewModel() {
        return (GuildRoleSubscriptionTierViewModel) this.viewModel.getValue();
    }

    private final boolean isPlanReviewMode() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            return arguments.getBoolean(ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, false);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupRecyclerView() {
        this.adapter = new GuildRoleSubscriptionTierAdapter(this, null, 2, 0 == true ? 1 : 0);
        GuildRoleSubscriptionTierItemDecoration guildRoleSubscriptionTierItemDecoration = new GuildRoleSubscriptionTierItemDecoration(DimenUtils.dpToPixels(8), getResources().getDimensionPixelSize(C5419R.dimen.guild_role_subscription_setup_default_padding));
        RecyclerView recyclerView = getBinding().f16973b;
        C12238m.checkNotNullExpressionValue(recyclerView, "this");
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView, guildRoleSubscriptionTierAdapter, 0, false, 12, null));
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter2 = this.adapter;
        if (guildRoleSubscriptionTierAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionTierAdapter2);
        recyclerView.addItemDecoration(guildRoleSubscriptionTierItemDecoration);
    }

    private final void updatePlanDetails(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        String planDescription = viewState.getPlanDescription();
        if (planDescription == null || C12103t.isBlank(planDescription)) {
            return;
        }
        String coverImage = viewState.getCoverImage();
        if (coverImage == null || C12103t.isBlank(coverImage)) {
            return;
        }
        getReviewViewModel().updatePlanDetails(viewState.getPlanDescription(), viewState.getCoverImage());
    }

    private final void updateTier(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String name = viewState.getGuildRoleSubscriptionTier().getName();
        if ((name == null || C12103t.isBlank(name)) || viewState.getGuildRoleSubscriptionTier().getMemberColor() == null || viewState.getGuildRoleSubscriptionTier().getPriceTier() == null) {
            return;
        }
        getReviewViewModel().updateTier(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionReview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84961());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getReviewViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionReview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84972());
        if (isPlanReviewMode()) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getPlanSetupViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionReview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84983());
        }
    }
}
