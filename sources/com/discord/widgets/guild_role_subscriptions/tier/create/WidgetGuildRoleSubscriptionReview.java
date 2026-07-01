package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.RecyclerView;
import b.a.d.AppViewModelDelegates2;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildRoleSubscriptionTierReviewBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.error.Error;
import com.discord.utilities.recycler.SelfHealingLinearLayoutManager;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierAdapter;
import com.discord.widgets.guild_role_subscriptions.tier.GuildRoleSubscriptionTierItemDecoration;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionReviewViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import d0.LazyJVM;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.reflect.KProperty;
import rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionReview.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildRoleSubscriptionTierReviewBinding;", 0)};

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.this.updateTier(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionReviewViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionReview.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "it");
            WidgetGuildRoleSubscriptionReview.this.updatePlanDetails(viewState);
        }
    }

    public WidgetGuildRoleSubscriptionReview() {
        super(R.layout.widget_guild_role_subscription_tier_review);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionReview2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionReview3(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionReview$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionReview6.INSTANCE));
        WidgetGuildRoleSubscriptionReview5 widgetGuildRoleSubscriptionReview5 = new WidgetGuildRoleSubscriptionReview5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.reviewViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionReviewViewModel.class), new WidgetGuildRoleSubscriptionReview$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetGuildRoleSubscriptionReview5));
        this.planSetupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new WidgetGuildRoleSubscriptionReview$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetGuildRoleSubscriptionReview4(this)));
    }

    private final void configureUI(GuildRoleSubscriptionReviewViewModel.ViewState viewState) {
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
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
        GuildRoleSubscriptionTierItemDecoration guildRoleSubscriptionTierItemDecoration = new GuildRoleSubscriptionTierItemDecoration(DimenUtils.dpToPixels(8), getResources().getDimensionPixelSize(R.dimen.guild_role_subscription_setup_default_padding));
        RecyclerView recyclerView = getBinding().f2441b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "this");
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter = this.adapter;
        if (guildRoleSubscriptionTierAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setLayoutManager(new SelfHealingLinearLayoutManager(recyclerView, guildRoleSubscriptionTierAdapter, 0, false, 12, null));
        GuildRoleSubscriptionTierAdapter guildRoleSubscriptionTierAdapter2 = this.adapter;
        if (guildRoleSubscriptionTierAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView.setAdapter(guildRoleSubscriptionTierAdapter2);
        recyclerView.addItemDecoration(guildRoleSubscriptionTierItemDecoration);
    }

    private final void updatePlanDetails(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        String planDescription = viewState.getPlanDescription();
        if (planDescription == null || StringsJVM.isBlank(planDescription)) {
            return;
        }
        String coverImage = viewState.getCoverImage();
        if (coverImage == null || StringsJVM.isBlank(coverImage)) {
            return;
        }
        getReviewViewModel().updatePlanDetails(viewState.getPlanDescription(), viewState.getCoverImage());
    }

    private final void updateTier(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        String name = viewState.getGuildRoleSubscriptionTier().getName();
        if ((name == null || StringsJVM.isBlank(name)) || viewState.getGuildRoleSubscriptionTier().getMemberColor() == null || viewState.getGuildRoleSubscriptionTier().getPriceTier() == null) {
            return;
        }
        getReviewViewModel().updateTier(viewState.getGuildRoleSubscriptionTier(), viewState.isFullServerGating());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setupRecyclerView();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionReview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getReviewViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionReview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        if (isPlanReviewMode()) {
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getPlanSetupViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionReview.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        }
    }
}
