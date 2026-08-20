package com.discord.widgets.guild_role_subscriptions.tier.create;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.discord.C5419R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetCreateGuildRoleSubscriptionTierBinding;
import com.discord.utilities.error.Error;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.steps.StepsView;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.GuildRoleSubscriptionTierBenefitListType;
import com.discord.widgets.guild_role_subscriptions.tier.create.benefits.WidgetGuildRoleSubscriptionTierBenefits;
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

/* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetCreateGuildRoleSubscriptionTier extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetCreateGuildRoleSubscriptionTier.class, "binding", "getBinding()Lcom/discord/databinding/WidgetCreateGuildRoleSubscriptionTierBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.putExtra("INTENT_EXTRA_GUILD_ID", guildId);
            intent.putExtra(WidgetCreateGuildRoleSubscriptionTier.INTENT_EXTRA_GROUP_LISTING_ID, groupListingId);
            C0870j.m156d(context, WidgetCreateGuildRoleSubscriptionTier.class, intent);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class C84881 extends AbstractC12240o implements Function1<GuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84881() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            C12238m.checkNotNullExpressionValue(viewState, "viewState");
            widgetCreateGuildRoleSubscriptionTier.updateCreateTierViewModel(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class C84892 extends AbstractC12240o implements Function1<CreateGuildRoleSubscriptionTierViewModel.ViewState, Unit> {
        public C84892() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            C12238m.checkNotNullExpressionValue(viewState, "it");
            widgetCreateGuildRoleSubscriptionTier.configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier$onViewBoundOrOnResume$3 */
    /* JADX INFO: compiled from: WidgetCreateGuildRoleSubscriptionTier.kt */
    public static final class C84903 extends AbstractC12240o implements Function1<CreateGuildRoleSubscriptionTierViewModel.Event, Unit> {
        public C84903() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(CreateGuildRoleSubscriptionTierViewModel.Event event) {
            WidgetCreateGuildRoleSubscriptionTier widgetCreateGuildRoleSubscriptionTier = WidgetCreateGuildRoleSubscriptionTier.this;
            C12238m.checkNotNullExpressionValue(event, "it");
            widgetCreateGuildRoleSubscriptionTier.handleEvent(event);
        }
    }

    public WidgetCreateGuildRoleSubscriptionTier() {
        super(C5419R.layout.widget_create_guild_role_subscription_tier);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetCreateGuildRoleSubscriptionTier$binding$2.INSTANCE, null, 2, null);
        this.guildId = C12083g.lazy(new WidgetCreateGuildRoleSubscriptionTier$guildId$2(this));
        this.groupListingId = C12083g.lazy(new WidgetCreateGuildRoleSubscriptionTier$groupListingId$2(this));
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(GuildRoleSubscriptionTierViewModel.class), new C8482x761ac5a7(this), new C0863f0(WidgetCreateGuildRoleSubscriptionTier$viewModel$2.INSTANCE));
        this.createTierViewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(CreateGuildRoleSubscriptionTierViewModel.class), new C8484x761ac5a9(this), new C0863f0(new WidgetCreateGuildRoleSubscriptionTier$createTierViewModel$2(this)));
    }

    private final void configureUI(CreateGuildRoleSubscriptionTierViewModel.ViewState viewState) {
        int currentStep = viewState.getCurrentStep();
        if (currentStep < 0) {
            requireActivity().finish();
            return;
        }
        getBinding().f16440b.m8610b(currentStep);
        getBinding().f16440b.setIsNextButtonEnabled(viewState.getCanProceed());
        getBinding().f16440b.setIsDoneButtonEnabled(!viewState.isSubmitting());
        getBinding().f16440b.setIsLoading(viewState.isSubmitting());
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
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
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
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        List listListOf = C12147n.listOf((Object[]) new StepsView.AbstractC7123b.a[]{new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierDetails.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$1(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierBenefits.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), C12116o.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.CHANNEL)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$2(this), null, null, false, false, false, 460), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierBenefits.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId())), C12116o.m10073to(WidgetGuildRoleSubscriptionTierBenefits.INTENT_EXTRA_BENEFIT_LIST_TYPE, GuildRoleSubscriptionTierBenefitListType.INTANGIBLE)), new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$3(this), null, null, false, false, false, 460), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionTierDesign.class, C5419R.string.guild_role_subscription_create_tier_continue, 0, 0, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$4(this), null, null, false, false, false, 476), new StepsView.AbstractC7123b.a(WidgetGuildRoleSubscriptionReview.class, 0, 0, C5419R.string.guild_role_subscription_plan_finish, BundleKt.bundleOf(C12116o.m10073to("com.discord.intent.extra.EXTRA_GUILD_ID", Long.valueOf(getGuildId()))), null, null, new WidgetCreateGuildRoleSubscriptionTier$onViewBound$steps$5(this), false, false, false, 358)});
        StepsView stepsView = getBinding().f16440b;
        StepsView.C7125d c7125d = new StepsView.C7125d(this, listListOf);
        C8486x4ace8fa1 c8486x4ace8fa1 = new C8486x4ace8fa1(this, listListOf);
        int i = StepsView.f19295j;
        stepsView.m8609a(c7125d, c8486x4ace8fa1, C1369a.f2064j);
        stepsView.setStepProgressIndicatorVisible(true);
        AppFragment.setOnBackPressed$default(this, new Func0<Boolean>() { // from class: com.discord.widgets.guild_role_subscriptions.tier.create.WidgetCreateGuildRoleSubscriptionTier.onViewBound.2
            @Override // p658rx.functions.Func0, java.util.concurrent.Callable
            public final Boolean call() {
                WidgetCreateGuildRoleSubscriptionTier.this.getCreateTierViewModel().goToPreviousStep();
                return Boolean.TRUE;
            }
        }, 0, 2, null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<GuildRoleSubscriptionTierViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel.observeViewSta…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetCreateGuildRoleSubscriptionTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84881());
        Observable<CreateGuildRoleSubscriptionTierViewModel.ViewState> observableM11112r2 = getCreateTierViewModel().observeViewState().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r2, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r2, this, null, 2, null), (Class<?>) WidgetCreateGuildRoleSubscriptionTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84892());
        Observable<CreateGuildRoleSubscriptionTierViewModel.Event> observableM11112r3 = getCreateTierViewModel().observeEvents().m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r3, "createTierViewModel\n    …  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.bindToComponentLifecycle$default(observableM11112r3, this, null, 2, null), (Class<?>) WidgetCreateGuildRoleSubscriptionTier.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C84903());
    }
}
