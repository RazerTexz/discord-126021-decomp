package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b.a.a.a.GuildBoostActivatedDialog;
import b.a.a.b.PremiumActivatedDialog;
import b.a.a.b.PremiumAndGuildBoostActivatedDialog;
import b.a.a.b.UpgradeGuildBoostDialog;
import b.a.a.b.UpgradePremiumYearlyDialog;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.app.AppFragment;
import com.discord.databinding.WidgetChoosePlanBinding;
import com.discord.stores.StoreGooglePlayPurchases;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlayBillingManager;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.dimmer.DimmerView;
import com.discord.utilities.error.Error;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.widgets.settings.premium.ChoosePlanViewModel;
import d0.z.d.AdaptedFunctionReference;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.io.Serializable;
import java.util.Objects;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetChoosePlan.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChoosePlanBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String RESULT_EXTRA_LOCATION_TRAIT = "result_extra_location_trait";
    public static final String RESULT_EXTRA_OLD_SKU_NAME = "result_extra_current_sku_name";
    public static final String RESULT_VIEW_TYPE = "result_view_type";
    private WidgetChoosePlanAdapter adapter;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private LinearLayoutManager planLayoutManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final class Companion {
        private Companion() {
        }

        public final void launch(Context context, ActivityResultLauncher<Intent> launcher, ViewType viewType, String oldSkuName, Traits.Location locationTrait, Traits.Subscription subscriptionTrait) {
            Intrinsics3.checkNotNullParameter(context, "context");
            Intrinsics3.checkNotNullParameter(viewType, "viewType");
            Intrinsics3.checkNotNullParameter(locationTrait, "locationTrait");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME, oldSkuName);
            intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_LOCATION_TRAIT, locationTrait);
            intent.putExtra(WidgetChoosePlan.RESULT_VIEW_TYPE, viewType);
            AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionTrait, null, null, 12, null);
            if (launcher != null) {
                AppScreen2.g.f(context, launcher, WidgetChoosePlan.class, intent);
            } else {
                AppScreen2.d(context, WidgetChoosePlan.class, intent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            Intrinsics3.checkNotNullParameter(fragment, "fragment");
            Intrinsics3.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.settings.premium.WidgetChoosePlan$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    Intrinsics3.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        callback.invoke();
                    }
                }
            });
            Intrinsics3.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
            return activityResultLauncherRegisterForActivityResult;
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public enum ViewType {
        BUY_PREMIUM_TIER_2,
        BUY_PREMIUM_TIER_1,
        BUY_PREMIUM_GUILD,
        SWITCH_PLANS
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            GooglePlaySku.Type.values();
            int[] iArr = new int[5];
            $EnumSwitchMapping$0 = iArr;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1.ordinal()] = 1;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2.ordinal()] = 2;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD.ordinal()] = 3;
            iArr[GooglePlaySku.Type.PREMIUM_TIER_2_AND_PREMIUM_GUILD.ordinal()] = 4;
            iArr[GooglePlaySku.Type.PREMIUM_GUILD.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final /* synthetic */ class AnonymousClass1 extends FunctionReferenceImpl implements Function1<ChoosePlanViewModel.Event, Unit> {
        public AnonymousClass1(WidgetChoosePlan widgetChoosePlan) {
            super(1, widgetChoosePlan, WidgetChoosePlan.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChoosePlanViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetChoosePlan) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final /* synthetic */ class AnonymousClass2 extends AdaptedFunctionReference implements Function1<ChoosePlanViewModel.ViewState, Unit> {
        public AnonymousClass2(WidgetChoosePlan widgetChoosePlan) {
            super(1, widgetChoosePlan, WidgetChoosePlan.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$ViewState;)Lkotlin/Unit;", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChoosePlanViewModel.ViewState viewState) {
            Intrinsics3.checkNotNullParameter(viewState, "p1");
            ((WidgetChoosePlan) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final class AnonymousClass2 extends Lambda implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
        public final /* synthetic */ Traits.Location $locationTrait;

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass1(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChoosePlan.this.getViewModel().buy(this.$sku, this.$oldSkuName, AnonymousClass2.this.$locationTrait, "premium_upsell");
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$2, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class C03382 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public C03382(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Traits.Location location = new Traits.Location("Premium Upsell Modal", "Premium Upsell Modal", null, null, null, 28, null);
                AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, location, Traits.Subscription.INSTANCE.withGatewayPlanId(this.$sku.getUpgrade().getSkuName()), null, null, 12, null);
                WidgetChoosePlan.this.getViewModel().buy(this.$sku.getUpgrade(), this.$oldSkuName, location, "premium_upsell");
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$3, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass3(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChoosePlan.this.getViewModel().buy(this.$sku, this.$oldSkuName, AnonymousClass2.this.$locationTrait, "yearly_upsell");
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass4(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                Traits.Location location = new Traits.Location("Yearly Upsell Modal", "Yearly Upsell Modal", null, null, null, 28, null);
                AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, location, Traits.Subscription.INSTANCE.withGatewayPlanId(this.$sku.getUpgrade().getSkuName()), null, null, 12, null);
                WidgetChoosePlan.this.getViewModel().buy(this.$sku.getUpgrade(), this.$oldSkuName, location, "yearly_upsell");
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$5, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
            public AnonymousClass5() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.upgradePremiumYearlyClosed(AnonymousClass2.this.$locationTrait);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(Traits.Location location) {
            super(3);
            this.$locationTrait = location;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
            invoke2(googlePlaySku, str, skuDetails);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
            Intrinsics3.checkNotNullParameter(googlePlaySku, "sku");
            if (googlePlaySku.getUpgrade() != null && skuDetails != null && googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_GUILD) {
                AnalyticsTracker.INSTANCE.paymentFlowStep(this.$locationTrait, (48 & 2) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(googlePlaySku.getSkuName()), "premium_upsell", "plan_select", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
                UpgradeGuildBoostDialog.Companion bVar = UpgradeGuildBoostDialog.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChoosePlan.this.getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(googlePlaySku, str);
                C03382 c03382 = new C03382(googlePlaySku, str);
                String strB = skuDetails.b();
                Intrinsics3.checkNotNullExpressionValue(strB, "upgradeSkuDetails.price");
                boolean zAreEqual = Intrinsics3.areEqual(googlePlaySku.getSkuName(), str);
                Objects.requireNonNull(bVar);
                Intrinsics3.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                Intrinsics3.checkNotNullParameter(anonymousClass1, "onContinueClickListener");
                Intrinsics3.checkNotNullParameter(c03382, "onUpgradeClickListener");
                Intrinsics3.checkNotNullParameter(strB, "upgradePrice");
                UpgradeGuildBoostDialog upgradeGuildBoostDialog = new UpgradeGuildBoostDialog();
                upgradeGuildBoostDialog.onContinueClickListener = anonymousClass1;
                upgradeGuildBoostDialog.onUpgradeClickListener = c03382;
                upgradeGuildBoostDialog.upgradePrice = strB;
                upgradeGuildBoostDialog.hasBoostPlan = zAreEqual;
                upgradeGuildBoostDialog.show(parentFragmentManager, UpgradeGuildBoostDialog.class.getSimpleName());
                return;
            }
            if (googlePlaySku.getUpgrade() == null || skuDetails == null) {
                WidgetChoosePlan.this.getViewModel().buy(googlePlaySku, str, this.$locationTrait, "plan_select");
                return;
            }
            AnalyticsTracker.INSTANCE.paymentFlowStep(this.$locationTrait, (48 & 2) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(googlePlaySku.getSkuName()), "yearly_upsell", "plan_select", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
            UpgradePremiumYearlyDialog.Companion bVar2 = UpgradePremiumYearlyDialog.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetChoosePlan.this.getParentFragmentManager();
            Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(googlePlaySku, str);
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(googlePlaySku, str);
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            String strB2 = skuDetails.b();
            Intrinsics3.checkNotNullExpressionValue(strB2, "upgradeSkuDetails.price");
            boolean zAreEqual2 = Intrinsics3.areEqual(googlePlaySku.getSkuName(), str);
            boolean z2 = googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
            Objects.requireNonNull(bVar2);
            Intrinsics3.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            Intrinsics3.checkNotNullParameter(anonymousClass3, "onMonthlyClickListener");
            Intrinsics3.checkNotNullParameter(anonymousClass4, "onYearlyClickListener");
            Intrinsics3.checkNotNullParameter(anonymousClass5, "onDismissCallback");
            Intrinsics3.checkNotNullParameter(strB2, "upgradePrice");
            UpgradePremiumYearlyDialog upgradePremiumYearlyDialog = new UpgradePremiumYearlyDialog();
            upgradePremiumYearlyDialog.onMonthlyClickListener = anonymousClass3;
            upgradePremiumYearlyDialog.onYearlyClickListener = anonymousClass4;
            upgradePremiumYearlyDialog.onDismissCallback = anonymousClass5;
            upgradePremiumYearlyDialog.upgradePrice = strB2;
            upgradePremiumYearlyDialog.hasMonthlyPlan = zAreEqual2;
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_IS_TIER_1", z2);
            upgradePremiumYearlyDialog.setArguments(bundle);
            upgradePremiumYearlyDialog.show(parentFragmentManager2, UpgradePremiumYearlyDialog.class.getSimpleName());
        }
    }

    public WidgetChoosePlan() {
        super(R.layout.widget_choose_plan);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetChoosePlan3.INSTANCE, null, 2, null);
        WidgetChoosePlan5 widgetChoosePlan5 = new WidgetChoosePlan5(this);
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(ChoosePlanViewModel.class), new WidgetChoosePlan$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetChoosePlan5));
    }

    private final Unit configureUI(ChoosePlanViewModel.ViewState viewState) {
        if (viewState instanceof ChoosePlanViewModel.ViewState.Loading) {
            return null;
        }
        if (!(viewState instanceof ChoosePlanViewModel.ViewState.Loaded)) {
            throw new NoWhenBranchMatchedException();
        }
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        ChoosePlanViewModel.ViewState.Loaded loaded = (ChoosePlanViewModel.ViewState.Loaded) viewState;
        widgetChoosePlanAdapter.setData(loaded.getItems());
        LinearLayout linearLayout = getBinding().f2349b;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.choosePlanEmptyContainer");
        linearLayout.setVisibility(loaded.isEmpty() ? 0 : 8);
        if (Intrinsics3.areEqual(loaded.getPurchasesQueryState(), StoreGooglePlayPurchases.QueryState.InProgress.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().e, true, false, 2, null);
            return Unit.a;
        }
        DimmerView.setDimmed$default(getBinding().e, false, false, 2, null);
        return Unit.a;
    }

    private final WidgetChoosePlanBinding getBinding() {
        return (WidgetChoosePlanBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChoosePlanViewModel getViewModel() {
        return (ChoosePlanViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ChoosePlanViewModel.Event event) {
        if (event instanceof ChoosePlanViewModel.Event.ErrorSkuPurchase) {
            AppToast.i(this, ((ChoosePlanViewModel.Event.ErrorSkuPurchase) event).getMessage(), 0, 4);
            return;
        }
        if (event instanceof ChoosePlanViewModel.Event.StartSkuPurchase) {
            GooglePlayBillingManager.INSTANCE.launchBillingFlow(requireAppActivity(), ((ChoosePlanViewModel.Event.StartSkuPurchase) event).getBillingParams());
            return;
        }
        if (event instanceof ChoosePlanViewModel.Event.CompleteSkuPurchase) {
            ChoosePlanViewModel.Event.CompleteSkuPurchase completeSkuPurchase = (ChoosePlanViewModel.Event.CompleteSkuPurchase) event;
            GooglePlaySku googlePlaySkuFromSkuName = GooglePlaySku.INSTANCE.fromSkuName(completeSkuPurchase.getSkuName());
            if (googlePlaySkuFromSkuName != null) {
                WidgetChoosePlan4 widgetChoosePlan4 = new WidgetChoosePlan4(this);
                int iOrdinal = googlePlaySkuFromSkuName.getType().ordinal();
                if (iOrdinal == 0) {
                    PremiumActivatedDialog.Companion aVar = PremiumActivatedDialog.INSTANCE;
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    aVar.a(parentFragmentManager, widgetChoosePlan4, false);
                    return;
                }
                if (iOrdinal == 1) {
                    PremiumActivatedDialog.Companion aVar2 = PremiumActivatedDialog.INSTANCE;
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    aVar2.a(parentFragmentManager2, widgetChoosePlan4, true);
                    return;
                }
                if (iOrdinal != 2 && iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return;
                    }
                    GuildBoostActivatedDialog.Companion aVar3 = GuildBoostActivatedDialog.INSTANCE;
                    FragmentManager parentFragmentManager3 = getParentFragmentManager();
                    Intrinsics3.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                    aVar3.a(parentFragmentManager3, requireContext(), null, googlePlaySkuFromSkuName.getPremiumSubscriptionCount(), false, widgetChoosePlan4);
                    return;
                }
                PremiumAndGuildBoostActivatedDialog.Companion aVar4 = PremiumAndGuildBoostActivatedDialog.INSTANCE;
                FragmentManager parentFragmentManager4 = getParentFragmentManager();
                Intrinsics3.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
                String planName = completeSkuPurchase.getPlanName();
                Objects.requireNonNull(aVar4);
                Intrinsics3.checkNotNullParameter(parentFragmentManager4, "fragmentManager");
                Intrinsics3.checkNotNullParameter(widgetChoosePlan4, "onDismiss");
                Intrinsics3.checkNotNullParameter(planName, "planName");
                PremiumAndGuildBoostActivatedDialog premiumAndGuildBoostActivatedDialog = new PremiumAndGuildBoostActivatedDialog();
                premiumAndGuildBoostActivatedDialog.onDismiss = widgetChoosePlan4;
                Bundle bundle = new Bundle();
                bundle.putString("extra_plan_text", planName);
                premiumAndGuildBoostActivatedDialog.setArguments(bundle);
                premiumAndGuildBoostActivatedDialog.show(parentFragmentManager4, PremiumAndGuildBoostActivatedDialog.class.getSimpleName());
            }
        }
    }

    private final void setUpRecycler() {
        RecyclerView recyclerView = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.choosePlanRecycler");
        this.planLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        RecyclerView recyclerView2 = getBinding().d;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "it");
        this.adapter = (WidgetChoosePlanAdapter) companion.configure(new WidgetChoosePlanAdapter(recyclerView2));
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(RESULT_EXTRA_LOCATION_TRAIT);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.utilities.analytics.Traits.Location");
        Traits.Location location = (Traits.Location) serializableExtra;
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChoosePlanAdapter.setOnClickPlan(new AnonymousClass2(location));
        RecyclerView recyclerView3 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView3, "binding.choosePlanRecycler");
        LinearLayoutManager linearLayoutManager = this.planLayoutManager;
        if (linearLayoutManager == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("planLayoutManager");
        }
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().d;
        Intrinsics3.checkNotNullExpressionValue(recyclerView4, "binding.choosePlanRecycler");
        WidgetChoosePlanAdapter widgetChoosePlanAdapter2 = this.adapter;
        if (widgetChoosePlanAdapter2 == null) {
            Intrinsics3.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetChoosePlanAdapter2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpRecycler();
        LinkifiedTextView linkifiedTextView = getBinding().c;
        Intrinsics3.checkNotNullExpressionValue(linkifiedTextView, "binding.choosePlanEmptyDescription");
        FormatUtils.m(linkifiedTextView, R.string.premium_no_plans_body, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChoosePlan.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChoosePlan.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }
}
