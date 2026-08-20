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
import com.android.billingclient.api.SkuDetails;
import com.discord.C5419R;
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
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.view.text.LinkifiedTextView;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
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
import p007b.p008a.p009a.p010a.C0793c;
import p007b.p008a.p009a.p012b.C0809a;
import p007b.p008a.p009a.p012b.C0810b;
import p007b.p008a.p009a.p012b.C0814f;
import p007b.p008a.p009a.p012b.C0815g;
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12215a;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Subscription;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan extends AppFragment {
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetChoosePlan.class, "binding", "getBinding()Lcom/discord/databinding/WidgetChoosePlanBinding;", 0)};

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
            C12238m.checkNotNullParameter(context, "context");
            C12238m.checkNotNullParameter(viewType, "viewType");
            C12238m.checkNotNullParameter(locationTrait, "locationTrait");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            Intent intent = new Intent();
            intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_OLD_SKU_NAME, oldSkuName);
            intent.putExtra(WidgetChoosePlan.RESULT_EXTRA_LOCATION_TRAIT, locationTrait);
            intent.putExtra(WidgetChoosePlan.RESULT_VIEW_TYPE, viewType);
            AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, locationTrait, subscriptionTrait, null, null, 12, null);
            if (launcher != null) {
                C0870j.f524g.m160f(context, launcher, WidgetChoosePlan.class, intent);
            } else {
                C0870j.m156d(context, WidgetChoosePlan.class, intent);
            }
        }

        public final ActivityResultLauncher<Intent> registerForResult(AppFragment fragment, final Function0<Unit> callback) {
            C12238m.checkNotNullParameter(fragment, "fragment");
            C12238m.checkNotNullParameter(callback, "callback");
            ActivityResultLauncher<Intent> activityResultLauncherRegisterForActivityResult = fragment.registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() { // from class: com.discord.widgets.settings.premium.WidgetChoosePlan$Companion$registerForResult$1
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(ActivityResult activityResult) {
                    C12238m.checkNotNullExpressionValue(activityResult, "activityResult");
                    if (activityResult.getResultCode() == -1) {
                        callback.invoke();
                    }
                }
            });
            C12238m.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "fragment.registerForActi…k()\n          }\n        }");
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final /* synthetic */ class C98911 extends C12236k implements Function1<ChoosePlanViewModel.Event, Unit> {
        public C98911(WidgetChoosePlan widgetChoosePlan) {
            super(1, widgetChoosePlan, WidgetChoosePlan.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChoosePlanViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetChoosePlan) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final /* synthetic */ class C98922 extends C12215a implements Function1<ChoosePlanViewModel.ViewState, Unit> {
        public C98922(WidgetChoosePlan widgetChoosePlan) {
            super(1, widgetChoosePlan, WidgetChoosePlan.class, "configureUI", "configureUI(Lcom/discord/widgets/settings/premium/ChoosePlanViewModel$ViewState;)Lkotlin/Unit;", 8);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ChoosePlanViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ChoosePlanViewModel.ViewState viewState) {
            C12238m.checkNotNullParameter(viewState, "p1");
            ((WidgetChoosePlan) this.receiver).configureUI(viewState);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2 */
    /* JADX INFO: compiled from: WidgetChoosePlan.kt */
    public static final class C98932 extends AbstractC12240o implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
        public final /* synthetic */ Traits.Location $locationTrait;

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass1 extends AbstractC12240o implements Function0<Unit> {
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
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChoosePlan.this.getViewModel().buy(this.$sku, this.$oldSkuName, C98932.this.$locationTrait, "premium_upsell");
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$2, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass2 extends AbstractC12240o implements Function0<Unit> {
            public final /* synthetic */ String $oldSkuName;
            public final /* synthetic */ GooglePlaySku $sku;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public AnonymousClass2(GooglePlaySku googlePlaySku, String str) {
                super(0);
                this.$sku = googlePlaySku;
                this.$oldSkuName = str;
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
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
        public static final class AnonymousClass3 extends AbstractC12240o implements Function0<Unit> {
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
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                WidgetChoosePlan.this.getViewModel().buy(this.$sku, this.$oldSkuName, C98932.this.$locationTrait, "yearly_upsell");
            }
        }

        /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlan$setUpRecycler$2$4, reason: invalid class name */
        /* JADX INFO: compiled from: WidgetChoosePlan.kt */
        public static final class AnonymousClass4 extends AbstractC12240o implements Function0<Unit> {
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
                return Unit.f27425a;
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
        public static final class AnonymousClass5 extends AbstractC12240o implements Function0<Unit> {
            public AnonymousClass5() {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.f27425a;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                AnalyticsTracker.INSTANCE.upgradePremiumYearlyClosed(C98932.this.$locationTrait);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C98932(Traits.Location location) {
            super(3);
            this.$locationTrait = location;
        }

        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
            invoke2(googlePlaySku, str, skuDetails);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
            C12238m.checkNotNullParameter(googlePlaySku, "sku");
            if (googlePlaySku.getUpgrade() != null && skuDetails != null && googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_GUILD) {
                AnalyticsTracker.INSTANCE.paymentFlowStep(this.$locationTrait, (48 & 2) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(googlePlaySku.getSkuName()), "premium_upsell", "plan_select", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
                C0809a.Companion bVar = C0809a.INSTANCE;
                FragmentManager parentFragmentManager = WidgetChoosePlan.this.getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(googlePlaySku, str);
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(googlePlaySku, str);
                String strM7501b = skuDetails.m7501b();
                C12238m.checkNotNullExpressionValue(strM7501b, "upgradeSkuDetails.price");
                boolean zAreEqual = C12238m.areEqual(googlePlaySku.getSkuName(), str);
                Objects.requireNonNull(bVar);
                C12238m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
                C12238m.checkNotNullParameter(anonymousClass1, "onContinueClickListener");
                C12238m.checkNotNullParameter(anonymousClass2, "onUpgradeClickListener");
                C12238m.checkNotNullParameter(strM7501b, "upgradePrice");
                C0809a c0809a = new C0809a();
                c0809a.onContinueClickListener = anonymousClass1;
                c0809a.onUpgradeClickListener = anonymousClass2;
                c0809a.upgradePrice = strM7501b;
                c0809a.hasBoostPlan = zAreEqual;
                c0809a.show(parentFragmentManager, C0809a.class.getSimpleName());
                return;
            }
            if (googlePlaySku.getUpgrade() == null || skuDetails == null) {
                WidgetChoosePlan.this.getViewModel().buy(googlePlaySku, str, this.$locationTrait, "plan_select");
                return;
            }
            AnalyticsTracker.INSTANCE.paymentFlowStep(this.$locationTrait, (48 & 2) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(googlePlaySku.getSkuName()), "yearly_upsell", "plan_select", (48 & 16) != 0 ? null : null, (48 & 32) != 0 ? null : null);
            C0810b.Companion bVar2 = C0810b.INSTANCE;
            FragmentManager parentFragmentManager2 = WidgetChoosePlan.this.getParentFragmentManager();
            C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
            AnonymousClass3 anonymousClass3 = new AnonymousClass3(googlePlaySku, str);
            AnonymousClass4 anonymousClass4 = new AnonymousClass4(googlePlaySku, str);
            AnonymousClass5 anonymousClass5 = new AnonymousClass5();
            String strM7501b2 = skuDetails.m7501b();
            C12238m.checkNotNullExpressionValue(strM7501b2, "upgradeSkuDetails.price");
            boolean zAreEqual2 = C12238m.areEqual(googlePlaySku.getSkuName(), str);
            boolean z2 = googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku.Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
            Objects.requireNonNull(bVar2);
            C12238m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
            C12238m.checkNotNullParameter(anonymousClass3, "onMonthlyClickListener");
            C12238m.checkNotNullParameter(anonymousClass4, "onYearlyClickListener");
            C12238m.checkNotNullParameter(anonymousClass5, "onDismissCallback");
            C12238m.checkNotNullParameter(strM7501b2, "upgradePrice");
            C0810b c0810b = new C0810b();
            c0810b.onMonthlyClickListener = anonymousClass3;
            c0810b.onYearlyClickListener = anonymousClass4;
            c0810b.onDismissCallback = anonymousClass5;
            c0810b.upgradePrice = strM7501b2;
            c0810b.hasMonthlyPlan = zAreEqual2;
            Bundle bundle = new Bundle();
            bundle.putBoolean("ARG_IS_TIER_1", z2);
            c0810b.setArguments(bundle);
            c0810b.show(parentFragmentManager2, C0810b.class.getSimpleName());
        }
    }

    public WidgetChoosePlan() {
        super(C5419R.layout.widget_choose_plan);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetChoosePlan$binding$2.INSTANCE, null, 2, null);
        WidgetChoosePlan$viewModel$2 widgetChoosePlan$viewModel$2 = new WidgetChoosePlan$viewModel$2(this);
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(ChoosePlanViewModel.class), new WidgetChoosePlan$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetChoosePlan$viewModel$2));
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
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        ChoosePlanViewModel.ViewState.Loaded loaded = (ChoosePlanViewModel.ViewState.Loaded) viewState;
        widgetChoosePlanAdapter.setData(loaded.getItems());
        LinearLayout linearLayout = getBinding().f16384b;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.choosePlanEmptyContainer");
        linearLayout.setVisibility(loaded.isEmpty() ? 0 : 8);
        if (C12238m.areEqual(loaded.getPurchasesQueryState(), StoreGooglePlayPurchases.QueryState.InProgress.INSTANCE)) {
            DimmerView.setDimmed$default(getBinding().f16387e, true, false, 2, null);
            return Unit.f27425a;
        }
        DimmerView.setDimmed$default(getBinding().f16387e, false, false, 2, null);
        return Unit.f27425a;
    }

    private final WidgetChoosePlanBinding getBinding() {
        return (WidgetChoosePlanBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final ChoosePlanViewModel getViewModel() {
        return (ChoosePlanViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(ChoosePlanViewModel.Event event) {
        if (event instanceof ChoosePlanViewModel.Event.ErrorSkuPurchase) {
            C0876m.m171i(this, ((ChoosePlanViewModel.Event.ErrorSkuPurchase) event).getMessage(), 0, 4);
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
                WidgetChoosePlan$handleEvent$onDismiss$1 widgetChoosePlan$handleEvent$onDismiss$1 = new WidgetChoosePlan$handleEvent$onDismiss$1(this);
                int iOrdinal = googlePlaySkuFromSkuName.getType().ordinal();
                if (iOrdinal == 0) {
                    C0814f.Companion aVar = C0814f.INSTANCE;
                    FragmentManager parentFragmentManager = getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
                    aVar.m121a(parentFragmentManager, widgetChoosePlan$handleEvent$onDismiss$1, false);
                    return;
                }
                if (iOrdinal == 1) {
                    C0814f.Companion aVar2 = C0814f.INSTANCE;
                    FragmentManager parentFragmentManager2 = getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
                    aVar2.m121a(parentFragmentManager2, widgetChoosePlan$handleEvent$onDismiss$1, true);
                    return;
                }
                if (iOrdinal != 2 && iOrdinal != 3) {
                    if (iOrdinal != 4) {
                        return;
                    }
                    C0793c.Companion aVar3 = C0793c.INSTANCE;
                    FragmentManager parentFragmentManager3 = getParentFragmentManager();
                    C12238m.checkNotNullExpressionValue(parentFragmentManager3, "parentFragmentManager");
                    aVar3.m101a(parentFragmentManager3, requireContext(), null, googlePlaySkuFromSkuName.getPremiumSubscriptionCount(), false, widgetChoosePlan$handleEvent$onDismiss$1);
                    return;
                }
                C0815g.Companion aVar4 = C0815g.INSTANCE;
                FragmentManager parentFragmentManager4 = getParentFragmentManager();
                C12238m.checkNotNullExpressionValue(parentFragmentManager4, "parentFragmentManager");
                String planName = completeSkuPurchase.getPlanName();
                Objects.requireNonNull(aVar4);
                C12238m.checkNotNullParameter(parentFragmentManager4, "fragmentManager");
                C12238m.checkNotNullParameter(widgetChoosePlan$handleEvent$onDismiss$1, "onDismiss");
                C12238m.checkNotNullParameter(planName, "planName");
                C0815g c0815g = new C0815g();
                c0815g.onDismiss = widgetChoosePlan$handleEvent$onDismiss$1;
                Bundle bundle = new Bundle();
                bundle.putString("extra_plan_text", planName);
                c0815g.setArguments(bundle);
                c0815g.show(parentFragmentManager4, C0815g.class.getSimpleName());
            }
        }
    }

    private final void setUpRecycler() {
        RecyclerView recyclerView = getBinding().f16386d;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.choosePlanRecycler");
        this.planLayoutManager = new LinearLayoutManager(recyclerView.getContext(), 1, false);
        RecyclerView recyclerView2 = getBinding().f16386d;
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        C12238m.checkNotNullExpressionValue(recyclerView2, "it");
        this.adapter = (WidgetChoosePlanAdapter) companion.configure(new WidgetChoosePlanAdapter(recyclerView2));
        Serializable serializableExtra = getMostRecentIntent().getSerializableExtra(RESULT_EXTRA_LOCATION_TRAIT);
        Objects.requireNonNull(serializableExtra, "null cannot be cast to non-null type com.discord.utilities.analytics.Traits.Location");
        Traits.Location location = (Traits.Location) serializableExtra;
        WidgetChoosePlanAdapter widgetChoosePlanAdapter = this.adapter;
        if (widgetChoosePlanAdapter == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        widgetChoosePlanAdapter.setOnClickPlan(new C98932(location));
        RecyclerView recyclerView3 = getBinding().f16386d;
        C12238m.checkNotNullExpressionValue(recyclerView3, "binding.choosePlanRecycler");
        LinearLayoutManager linearLayoutManager = this.planLayoutManager;
        if (linearLayoutManager == null) {
            C12238m.throwUninitializedPropertyAccessException("planLayoutManager");
        }
        recyclerView3.setLayoutManager(linearLayoutManager);
        RecyclerView recyclerView4 = getBinding().f16386d;
        C12238m.checkNotNullExpressionValue(recyclerView4, "binding.choosePlanRecycler");
        WidgetChoosePlanAdapter widgetChoosePlanAdapter2 = this.adapter;
        if (widgetChoosePlanAdapter2 == null) {
            C12238m.throwUninitializedPropertyAccessException("adapter");
        }
        recyclerView4.setAdapter(widgetChoosePlanAdapter2);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setUpRecycler();
        LinkifiedTextView linkifiedTextView = getBinding().f16385c;
        C12238m.checkNotNullExpressionValue(linkifiedTextView, "binding.choosePlanEmptyDescription");
        C1107b.m221m(linkifiedTextView, C5419R.string.premium_no_plans_body, new Object[]{C0862f.f507a.m149a(360055386693L, null)}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeEvents(), this, null, 2, null), (Class<?>) WidgetChoosePlan.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98911(this));
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().observeViewState(), this, null, 2, null), (Class<?>) WidgetChoosePlan.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C98922(this));
    }
}
