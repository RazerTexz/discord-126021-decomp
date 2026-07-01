package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.os.Bundle2;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppScreen2;
import b.a.d.AppViewModelDelegates2;
import b.a.y.p0.StepsView2;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.tier.create.CreateGuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import d0.LazyJVM;
import d0.Tuples;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;
import rx.functions.Func0;

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetCreateGuildRoleSubscriptionTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId, long groupListingId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetCreateGuildRoleSubscriptionTier.INTENT_EXTRA_GROUP_LISTING_ID, groupListingId);
            AppScreen2.d(context, WidgetCreateGuildRoleSubscriptionTier.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
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
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "viewState");
            widgetCreateGuildRoleSubscriptionTier.updateCreateTierViewModel(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<CreateGuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(viewState, "it");
            widgetCreateGuildRoleSubscriptionTier.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<CreateGuildRoleSubscriptionTierViewModel.Event, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            Intrinsics3.checkNotNullExpressionValue(event, "it");
            widgetCreateGuildRoleSubscriptionTier.handleEvent(event);
        }
    }

    public WidgetCreateGuildRoleSubscriptionTier() {
        super(R.layout.widget_create_guild_role_subscription_tier);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetCreateGuildRoleSubscriptionTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetCreateGuildRoleSubscriptionTier$guildId$2(this));
        this.groupListingId = LazyJVM.lazy(new WidgetCreateGuildRoleSubscriptionTier$groupListingId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetCreateGuildRoleSubscriptionTier$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(WidgetCreateGuildRoleSubscriptionTier$viewModel$2.INSTANCE));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(CreateGuildRoleSubscriptionTierViewModel.class), new WidgetCreateGuildRoleSubscriptionTier$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(new WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2(this)));
    }

    private final void configureUI(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
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

    private final void handleEvent(CreateGuildRoleSubscriptionTierViewModel.Event event) {
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.SubmitSuccess) {
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.SubmitFailure) {
            ((CreateGuildRoleSubscriptionTierViewModel.Event.SubmitFailure) event).getError().showToasts(requireContext());
        } else if (event instanceof CreateGuildRoleSubscriptionTierViewModel.Event.ServerGatingUpdate) {
            getViewModel().setFullServerGating(((CreateGuildRoleSubscriptionTierViewModel.Event.ServerGatingUpdate) event).isFullServerGating());
        }
    }

    public static final void launch(Context context, long j, long j2) {
        INSTANCE.launch(context, j, j2);
    }

    private final void updateCreateTierViewModel(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
        getCreateTierViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetGuildRoleSubscriptionTierDetails.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$2(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$3(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierDesign.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$4(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, R.string.guild_role_subscription_plan_finish, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId()))), null, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$5(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f2359b;
        StepsView.d dVar = new StepsView.d(this, listListOf);
        WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 widgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1 = new WidgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1(this, listListOf);
        int i = StepsView.j;
        stepsView.a(dVar, widgetCreateGuildRoleSubscriptionTier$onViewBound$$inlined$apply$lambda$1, StepsView2.j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier.onViewBound.2
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetCreateGuildRoleSubscriptionTier.this.getCreateTierViewModel().goToPreviousStep();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR = getViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetCreateGuildRoleSubscriptionTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        Observable<CreateGuildRoleSubscriptionTierViewModel.ViewState> observableR2 = getCreateTierViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), (Class<?>) WidgetCreateGuildRoleSubscriptionTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        Observable<CreateGuildRoleSubscriptionTierViewModel.Event> observableR3 = getCreateTierViewModel().observeEvents().r();
        Intrinsics3.checkNotNullExpressionValue(observableR3, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR3, this, null, 2, null), (Class<?>) WidgetCreateGuildRoleSubscriptionTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
    }
}
