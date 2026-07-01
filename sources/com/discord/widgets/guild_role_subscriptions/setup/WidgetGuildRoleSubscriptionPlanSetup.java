package com.discord.widgets.guild_role_subscriptions.setup;

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
import com.discord.databinding.WidgetGuildSubscriptionPlanSetupBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanDetailsViewModel;
import com.discord.widgets.guild_role_subscriptions.setup.GuildRoleSubscriptionPlanSetupViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
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

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetGuildRoleSubscriptionPlanSetup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
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

    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, long guildId) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            AppScreen2.d(context, WidgetGuildRoleSubscriptionPlanSetup.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public AnonymousClass1() {
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
            WidgetGuildRoleSubscriptionPlanSetup.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<GuildRoleSubscriptionPlanSetupViewModel.Event, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionPlanSetup.this.handleEvents(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public AnonymousClass3() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionPlanSetup.this.getSetupViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public AnonymousClass4() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionPlanSetup.this.getSetupViewModel().onSubscriptionPlanUpdated(viewState.getCoverImage(), viewState.getDescription(), viewState.isFullServerGate());
            WidgetGuildRoleSubscriptionPlanSetup.this.getCreateTierViewModel().setFullServerGating(viewState.isFullServerGate());
        }
    }

    public WidgetGuildRoleSubscriptionPlanSetup() {
        super(R.layout.widget_guild_subscription_plan_setup);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanSetup$binding$2.INSTANCE, null, 2, null);
        this.guildId = LazyJVM.lazy(new WidgetGuildRoleSubscriptionPlanSetup$guildId$2(this));
        this.setupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$1(this), new AppViewModelDelegates2(new WidgetGuildRoleSubscriptionPlanSetup$setupViewModel$2(this)));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$3(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2.INSTANCE));
        this.subscriptionPlanDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new WidgetGuildRoleSubscriptionPlanSetup$appActivityViewModels$$inlined$activityViewModels$5(this), new AppViewModelDelegates2(WidgetGuildRoleSubscriptionPlanSetup$subscriptionPlanDetailsViewModel$2.INSTANCE));
    }

    private final void configureUI(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
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

    private final void handleEvents(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
        if (!(event instanceof GuildRoleSubscriptionPlanSetupViewModel.Event.SubmitSuccess)) {
            if (event instanceof GuildRoleSubscriptionPlanSetupViewModel.Event.SubmitFailure) {
                ((GuildRoleSubscriptionPlanSetupViewModel.Event.SubmitFailure) event).getError().showToasts(requireContext());
            }
        } else {
            WidgetServerSettingsGuildRoleSubscriptionTierList.INSTANCE.launch(requireContext(), getGuildId());
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
            }
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = Collections2.listOf((Object[]) new StepsView.b.a[]{new StepsView.b.a(WidgetGuildRoleSubscriptionPlanFormat.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionPlanDetails.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$2(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionTierDetails.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$3(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$4(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierBenefits.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$5(this), null, null, false, false, false, 460), new StepsView.b.a(WidgetGuildRoleSubscriptionTierDesign.class, R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$6(this), null, null, false, false, false, 476), new StepsView.b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, R.string.guild_role_subscription_plan_finish, Bundle2.bundleOf(Tuples.to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), Tuples.to(WidgetGuildRoleSubscriptionReview.ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, Boolean.TRUE)), null, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$7(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f2454b;
        StepsView.d dVar = new StepsView.d(this, listListOf);
        WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 widgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1 = new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1(this, listListOf);
        int i = StepsView.j;
        stepsView.a(dVar, widgetGuildRoleSubscriptionPlanSetup$onViewBound$$inlined$apply$lambda$1, StepsView2.j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup.onViewBound.2
            @Override // rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetGuildRoleSubscriptionPlanSetup.this.getSetupViewModel().goToPreviousStep();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2());
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableR = getCreateTierViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR, this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass3());
        Observable<GuildRoleSubscriptionPlanDetailsViewModel.ViewState> observableR2 = getSubscriptionPlanDetailsViewModel().observeViewState().r();
        Intrinsics3.checkNotNullExpressionValue(observableR2, "subscriptionPlanDetailsV…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableR2, this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass4());
    }
}
