package com.discord.widgets.guild_role_subscriptions.setup;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetGuildSubscriptionPlanSetupBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.tier.create.GuildRoleSubscriptionTierViewModel;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionReview;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDesign;
import com.discord.widgets.guild_role_subscriptions.tier.create.WidgetGuildRoleSubscriptionTierDetails;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
import com.discord.widgets.servers.guild_role_subscription.WidgetServerSettingsGuildRoleSubscriptionTierList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import p007b.p008a.p018d.C0863f0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p062y.p069p0.C1369a;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12083g;
import p507d0.C12116o;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;
import p658rx.functions.Func0;

/* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildRoleSubscriptionPlanSetup extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetGuildRoleSubscriptionPlanSetup.class, "binding", "getBinding()Lcom/discord/databinding/WidgetGuildSubscriptionPlanSetupBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            C0870j.m156d(context, WidgetGuildRoleSubscriptionPlanSetup.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class C84701 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanSetupViewModel.ViewState, Unit> {
        public C84701() {
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
            WidgetGuildRoleSubscriptionPlanSetup.this.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class C84712 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanSetupViewModel.Event, Unit> {
        public C84712() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanSetupViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "it");
            WidgetGuildRoleSubscriptionPlanSetup.this.handleEvents(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class C84723 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84723() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionPlanSetup.this.getSetupViewModel().onTierUpdated(viewState.getGuildRoleSubscriptionTier());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup$onViewBoundOrOnResume$4 */
    /* JADX INFO: compiled from: WidgetGuildRoleSubscriptionPlanSetup.kt */
    public static final class C84734 extends AbstractC12240o implements Function1<GuildRoleSubscriptionPlanDetailsViewModel.ViewState, Unit> {
        public C84734() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionPlanDetailsViewModel.ViewState viewState) {
            WidgetGuildRoleSubscriptionPlanSetup.this.getSetupViewModel().onSubscriptionPlanUpdated(viewState.getCoverImage(), viewState.getDescription(), viewState.isFullServerGate());
            WidgetGuildRoleSubscriptionPlanSetup.this.getCreateTierViewModel().setFullServerGating(viewState.isFullServerGate());
        }
    }

    public WidgetGuildRoleSubscriptionPlanSetup() {
        super(C5419R.layout.widget_guild_subscription_plan_setup);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetGuildRoleSubscriptionPlanSetup$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetGuildRoleSubscriptionPlanSetup$guildId$2(this));
        this.setupViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanSetupViewModel.class), new C8462x7a5837b1(this), new C0863f0(new WidgetGuildRoleSubscriptionPlanSetup$setupViewModel$2(this)));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8464x7a5837b3(this), new C0863f0(WidgetGuildRoleSubscriptionPlanSetup$createTierViewModel$2.INSTANCE));
        this.subscriptionPlanDetailsViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionPlanDetailsViewModel.class), new C8466x7a5837b5(this), new C0863f0(C8474x77ee71a8.INSTANCE));
    }

    private final void configureUI(GuildRoleSubscriptionPlanSetupViewModel.ViewState viewState) {
        StepsView stepsView = getBinding().f17072b;
        stepsView.setIsNextButtonEnabled(viewState.getCanProceedToNextStep());
        stepsView.setIsDoneButtonEnabled(!viewState.isSubmitting());
        stepsView.setIsLoading(viewState.isSubmitting());
        stepsView.m8610b(viewState.getCurrentStep());
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
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
            }
        }
    }

    public static final void launch(Context context, long j) {
        INSTANCE.launch(context, j);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = C12147n.listOf((Object[]) new StepsView.AbstractC7123b.a[]{new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionPlanFormat.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionPlanDetails.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$2(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierDetails.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$3(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierBenefits.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), C12116o.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$4(this), null, null, false, false, false, 460), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierBenefits.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), C12116o.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$5(this), null, null, false, false, false, 460), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierDesign.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$6(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, C5419R.string.guild_role_subscription_plan_finish, BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), C12116o.m10073to(WidgetGuildRoleSubscriptionReview.ARG_IS_SUBSCRIPTION_GROUP_PLAN_REVIEW_MODE, Boolean.TRUE)), null, null, new WidgetGuildRoleSubscriptionPlanSetup$onViewBound$steps$7(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f17072b;
        StepsView.C7125d c7125d = new StepsView.C7125d(this, listListOf);
        C8468x52b555ab c8468x52b555ab = new C8468x52b555ab(this, listListOf);
        int i = StepsView.f19295j;
        stepsView.m8609a(c7125d, c8468x52b555ab, C1369a.f2064j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guild_role_subscriptions.setup.WidgetGuildRoleSubscriptionPlanSetup.onViewBound.2
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetGuildRoleSubscriptionPlanSetup.this.getSetupViewModel().goToPreviousStep();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84701());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(getSetupViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84712());
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableM11112r = getCreateTierViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84723());
        Observable<GuildRoleSubscriptionPlanDetailsViewModel.ViewState> observableM11112r2 = getSubscriptionPlanDetailsViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r2, "subscriptionPlanDetailsV…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r2, this, null, 2, null), (Class<?>) WidgetGuildRoleSubscriptionPlanSetup.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84734());
    }
}
