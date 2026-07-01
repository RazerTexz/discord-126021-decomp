package com.discord.widgets.settings.premium;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import b.a.d.AppHelpDesk;
import b.a.d.AppScreen2;
import b.a.d.AppToast;
import b.a.d.AppViewModelDelegates3;
import b.a.d.AppViewModelDelegates5;
import b.a.i.ViewPremiumSettingsTier1Binding;
import b.a.i.ViewPremiumSettingsTier2Binding;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R;
import com.discord.api.premium.SubscriptionInterval;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsPremiumBinding;
import com.discord.i18n.RenderContext;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.billing.ModelInvoicePreview3;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku2;
import com.discord.utilities.billing.PremiumUtils2;
import com.discord.utilities.error.Error;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate3;
import com.discord.views.ActiveSubscriptionView;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.google.android.material.button.MaterialButton;
import d0.Tuples;
import d0.t.Collections2;
import d0.t.MapsJVM;
import d0.t.SetsJVM;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import d0.z.d.Reflection2;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.KProperty;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetSettingsPremium.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSettingsPremium extends AppFragment {
    private static final String ANALYTICS_LOCATION_SECTION = "analytics_location_section";
    private static final String INTENT_SCROLL_TO_SECTION = "intent_section";
    public static final int SECTION_NITRO = 1;
    public static final int SECTION_NITRO_CLASSIC = 0;
    private static final int VIEW_INDEX_CONTENT = 0;
    private static final int VIEW_INDEX_ERROR = 2;
    private static final int VIEW_INDEX_LOADING = 1;

    /* JADX INFO: renamed from: binding$delegate, reason: from kotlin metadata */
    private final FragmentViewBindingDelegate binding;
    private final LocaleManager localeManager;

    /* JADX INFO: renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {outline.d0(WidgetSettingsPremium.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPremiumBinding;", 0)};

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class Companion {

        /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
        public static final /* data */ class SubscriptionViewCallbacks {
            private final Function0<Unit> cancelCallback;
            private final Function0<Unit> manageBillingCallback;
            private final Function0<Unit> manageGuildBoostCallback;
            private final Function0<Unit> managePlanCallback;
            private final Function0<Unit> restoreCallback;

            public SubscriptionViewCallbacks(Function0<Unit> function0, Function0<Unit> function1, Function0<Unit> function2, Function0<Unit> function3, Function0<Unit> function4) {
                this.restoreCallback = function0;
                this.managePlanCallback = function1;
                this.cancelCallback = function2;
                this.manageGuildBoostCallback = function3;
                this.manageBillingCallback = function4;
            }

            /* JADX WARN: Multi-variable type inference failed */
            public static /* synthetic */ SubscriptionViewCallbacks copy$default(SubscriptionViewCallbacks subscriptionViewCallbacks, Function0 function0, Function0 function1, Function0 function2, Function0 function3, Function0 function4, int i, Object obj) {
                if ((i & 1) != 0) {
                    function0 = subscriptionViewCallbacks.restoreCallback;
                }
                if ((i & 2) != 0) {
                    function1 = subscriptionViewCallbacks.managePlanCallback;
                }
                Function0 function5 = function1;
                if ((i & 4) != 0) {
                    function2 = subscriptionViewCallbacks.cancelCallback;
                }
                Function0 function6 = function2;
                if ((i & 8) != 0) {
                    function3 = subscriptionViewCallbacks.manageGuildBoostCallback;
                }
                Function0 function7 = function3;
                if ((i & 16) != 0) {
                    function4 = subscriptionViewCallbacks.manageBillingCallback;
                }
                return subscriptionViewCallbacks.copy(function0, function5, function6, function7, function4);
            }

            public final Function0<Unit> component1() {
                return this.restoreCallback;
            }

            public final Function0<Unit> component2() {
                return this.managePlanCallback;
            }

            public final Function0<Unit> component3() {
                return this.cancelCallback;
            }

            public final Function0<Unit> component4() {
                return this.manageGuildBoostCallback;
            }

            public final Function0<Unit> component5() {
                return this.manageBillingCallback;
            }

            public final SubscriptionViewCallbacks copy(Function0<Unit> restoreCallback, Function0<Unit> managePlanCallback, Function0<Unit> cancelCallback, Function0<Unit> manageGuildBoostCallback, Function0<Unit> manageBillingCallback) {
                return new SubscriptionViewCallbacks(restoreCallback, managePlanCallback, cancelCallback, manageGuildBoostCallback, manageBillingCallback);
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof SubscriptionViewCallbacks)) {
                    return false;
                }
                SubscriptionViewCallbacks subscriptionViewCallbacks = (SubscriptionViewCallbacks) other;
                return Intrinsics3.areEqual(this.restoreCallback, subscriptionViewCallbacks.restoreCallback) && Intrinsics3.areEqual(this.managePlanCallback, subscriptionViewCallbacks.managePlanCallback) && Intrinsics3.areEqual(this.cancelCallback, subscriptionViewCallbacks.cancelCallback) && Intrinsics3.areEqual(this.manageGuildBoostCallback, subscriptionViewCallbacks.manageGuildBoostCallback) && Intrinsics3.areEqual(this.manageBillingCallback, subscriptionViewCallbacks.manageBillingCallback);
            }

            public final Function0<Unit> getCancelCallback() {
                return this.cancelCallback;
            }

            public final Function0<Unit> getManageBillingCallback() {
                return this.manageBillingCallback;
            }

            public final Function0<Unit> getManageGuildBoostCallback() {
                return this.manageGuildBoostCallback;
            }

            public final Function0<Unit> getManagePlanCallback() {
                return this.managePlanCallback;
            }

            public final Function0<Unit> getRestoreCallback() {
                return this.restoreCallback;
            }

            public int hashCode() {
                Function0<Unit> function0 = this.restoreCallback;
                int iHashCode = (function0 != null ? function0.hashCode() : 0) * 31;
                Function0<Unit> function1 = this.managePlanCallback;
                int iHashCode2 = (iHashCode + (function1 != null ? function1.hashCode() : 0)) * 31;
                Function0<Unit> function2 = this.cancelCallback;
                int iHashCode3 = (iHashCode2 + (function2 != null ? function2.hashCode() : 0)) * 31;
                Function0<Unit> function3 = this.manageGuildBoostCallback;
                int iHashCode4 = (iHashCode3 + (function3 != null ? function3.hashCode() : 0)) * 31;
                Function0<Unit> function4 = this.manageBillingCallback;
                return iHashCode4 + (function4 != null ? function4.hashCode() : 0);
            }

            public String toString() {
                StringBuilder sbU = outline.U("SubscriptionViewCallbacks(restoreCallback=");
                sbU.append(this.restoreCallback);
                sbU.append(", managePlanCallback=");
                sbU.append(this.managePlanCallback);
                sbU.append(", cancelCallback=");
                sbU.append(this.cancelCallback);
                sbU.append(", manageGuildBoostCallback=");
                sbU.append(this.manageGuildBoostCallback);
                sbU.append(", manageBillingCallback=");
                sbU.append(this.manageBillingCallback);
                sbU.append(")");
                return sbU.toString();
            }
        }

        private Companion() {
        }

        public static /* synthetic */ void launch$default(Companion companion, Context context, Integer num, String str, int i, Object obj) {
            if ((i & 2) != 0) {
                num = null;
            }
            if ((i & 4) != 0) {
                str = null;
            }
            companion.launch(context, num, str);
        }

        public final void launch(Context context, Integer scrollToSection, String locationSection) {
            Intrinsics3.checkNotNullParameter(context, "context");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            StoreStream.INSTANCE.getAnalytics().onUserSettingsPaneViewed("Discord Nitro", locationSection);
            AppScreen2.d(context, WidgetSettingsPremium.class, new Intent().putExtra(WidgetSettingsPremium.INTENT_SCROLL_TO_SECTION, scrollToSection).putExtra(WidgetSettingsPremium.ANALYTICS_LOCATION_SECTION, locationSection));
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;

        static {
            SubscriptionInterval.values();
            int[] iArr = new int[2];
            $EnumSwitchMapping$0 = iArr;
            iArr[SubscriptionInterval.YEARLY.ordinal()] = 1;
            iArr[SubscriptionInterval.MONTHLY.ordinal()] = 2;
            SubscriptionPlanType.values();
            int[] iArr2 = new int[17];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[SubscriptionPlanType.PREMIUM_MONTH_LEGACY.ordinal()] = 1;
            iArr2[SubscriptionPlanType.PREMIUM_YEAR_LEGACY.ordinal()] = 2;
            ModelSubscription.Status.values();
            int[] iArr3 = new int[6];
            $EnumSwitchMapping$2 = iArr3;
            ModelSubscription.Status status = ModelSubscription.Status.PAST_DUE;
            iArr3[status.ordinal()] = 1;
            ModelSubscription.Status status2 = ModelSubscription.Status.ACCOUNT_HOLD;
            iArr3[status2.ordinal()] = 2;
            ModelSubscription.Status.values();
            int[] iArr4 = new int[6];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[status.ordinal()] = 1;
            iArr4[status2.ordinal()] = 2;
            ModelSubscription.Status.values();
            int[] iArr5 = new int[6];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[ModelSubscription.Status.ACTIVE.ordinal()] = 1;
            iArr5[ModelSubscription.Status.CANCELED.ordinal()] = 2;
            iArr5[status.ordinal()] = 3;
            iArr5[status2.ordinal()] = 4;
            SubscriptionPlanType.values();
            int[] iArr6 = new int[17];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[SubscriptionPlanType.PREMIUM_MONTH_TIER_1.ordinal()] = 1;
            iArr6[SubscriptionPlanType.PREMIUM_YEAR_TIER_1.ordinal()] = 2;
            iArr6[SubscriptionPlanType.PREMIUM_MONTH_TIER_2.ordinal()] = 3;
            iArr6[SubscriptionPlanType.PREMIUM_3_MONTH_TIER_2.ordinal()] = 4;
            iArr6[SubscriptionPlanType.PREMIUM_6_MONTH_TIER_2.ordinal()] = 5;
            iArr6[SubscriptionPlanType.PREMIUM_YEAR_TIER_2.ordinal()] = 6;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public AnonymousClass1() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGuildBoost.INSTANCE.launch(WidgetSettingsPremium.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChoosePlan.INSTANCE.launch(WidgetSettingsPremium.this.requireContext(), (34 & 2) != 0 ? null : null, WidgetChoosePlan.ViewType.SWITCH_PLANS, (34 & 8) != 0 ? null : this.$skuName, new Traits.Location(Traits.Location.Page.USER_SETTINGS, WidgetSettingsPremium.this.getAnalyticsLocationSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), (34 & 32) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass4(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass5 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass6 extends Lambda implements Function0<Unit> {
        public AnonymousClass6() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGuildBoost.INSTANCE.launch(WidgetSettingsPremium.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass3 extends Lambda implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass3(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass4 extends Lambda implements Function0<Unit> {
        public AnonymousClass4() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.this.showDesktopManageAlert();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
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
            WidgetSettingsPremium widgetSettingsPremium = WidgetSettingsPremium.this;
            widgetSettingsPremium.showCancelConfirmationAlert(widgetSettingsPremium.getViewModel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBoundOrOnResume$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<SettingsPremiumViewModel.ViewState, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsPremiumViewModel.ViewState viewState) {
            if (viewState instanceof SettingsPremiumViewModel.ViewState.Loaded) {
                WidgetSettingsPremium.this.showContent((SettingsPremiumViewModel.ViewState.Loaded) viewState);
            } else if (viewState instanceof SettingsPremiumViewModel.ViewState.Loading) {
                WidgetSettingsPremium.this.showLoadingUI();
            } else if (viewState instanceof SettingsPremiumViewModel.ViewState.Failure) {
                WidgetSettingsPremium.this.showFailureUI();
            }
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBoundOrOnResume$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final /* synthetic */ class AnonymousClass2 extends FunctionReferenceImpl implements Function1<SettingsPremiumViewModel.Event, Unit> {
        public AnonymousClass2(WidgetSettingsPremium widgetSettingsPremium) {
            super(1, widgetSettingsPremium, WidgetSettingsPremium.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel.Event event) {
            invoke2(event);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsPremiumViewModel.Event event) {
            Intrinsics3.checkNotNullParameter(event, "p1");
            ((WidgetSettingsPremium) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showCancelConfirmationAlert$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<View, Unit> {
        public final /* synthetic */ SettingsPremiumViewModel $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(SettingsPremiumViewModel settingsPremiumViewModel) {
            super(1);
            this.$viewModel = settingsPremiumViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            Intrinsics3.checkNotNullParameter(view, "it");
            this.$viewModel.cancelSubscription();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showContent$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Unit> {
        public final /* synthetic */ Integer $scrollTargetSection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(Integer num) {
            super(1);
            this.$scrollTargetSection = num;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetSettingsPremium.this.scrollToSection(this.$scrollTargetSection);
        }
    }

    public WidgetSettingsPremium() {
        super(R.layout.widget_settings_premium);
        this.binding = FragmentViewBindingDelegate3.viewBinding$default(this, WidgetSettingsPremium2.INSTANCE, null, 2, null);
        WidgetSettingsPremium8 widgetSettingsPremium8 = WidgetSettingsPremium8.INSTANCE;
        AppViewModelDelegates3 appViewModelDelegates3 = new AppViewModelDelegates3(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, Reflection2.getOrCreateKotlinClass(SettingsPremiumViewModel.class), new WidgetSettingsPremium$appViewModels$$inlined$viewModels$1(appViewModelDelegates3), new AppViewModelDelegates5(widgetSettingsPremium8));
        this.localeManager = new LocaleManager();
    }

    private final void configureAccountCredit(List<ModelEntitlement> entitlements, ModelSubscription currentSubscription) {
        int i = 0;
        int i2 = 0;
        for (ModelEntitlement modelEntitlement : entitlements) {
            if (modelEntitlement.getParentId() != null) {
                SubscriptionPlan subscriptionPlan = modelEntitlement.getSubscriptionPlan();
                Long lValueOf = subscriptionPlan != null ? Long.valueOf(subscriptionPlan.getId()) : null;
                long planId = SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId();
                if (lValueOf != null && lValueOf.longValue() == planId) {
                    i++;
                } else {
                    long planId2 = SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId();
                    if (lValueOf != null && lValueOf.longValue() == planId2) {
                        i2++;
                    }
                }
            }
        }
        LinearLayout linearLayout = getBinding().g;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsCreditContainer");
        linearLayout.setVisibility(i > 0 || i2 > 0 ? 0 : 8);
        View view = getBinding().f2633b.d;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.accountCredits.creditNitroDivider");
        view.setVisibility(i > 0 && i2 > 0 ? 0 : 8);
        getBinding().f2633b.c.a(SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId(), i, currentSubscription);
        getBinding().f2633b.f110b.a(SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId(), i2, currentSubscription);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x017c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0193  */
    /* JADX WARN: Code duplicated, block: B:107:0x0197  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    private final void configureActiveSubscriptionView(SettingsPremiumViewModel.ViewState.Loaded model) {
        ModelInvoicePreview3 modelInvoicePreview3;
        int size;
        boolean z2;
        Function0<Unit> managePlanCallback;
        ModelSubscription.Status status;
        ModelSubscription.Status status2;
        ModelSubscription.Status status3;
        ModelSubscription.Status status4;
        List<ModelInvoicePreview3> invoiceItems;
        Object next;
        long subscriptionPlanId;
        Long guildBoostPlanId;
        Object next2;
        boolean z3;
        Function0<Unit> restoreCallback;
        Function0<Unit> function0;
        boolean z4;
        boolean z5;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations2;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations3;
        ModelSubscription.SubscriptionRenewalMutations renewalMutations4;
        boolean z6;
        String paymentGatewayPlanId;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview currentInvoicePreview = model.getCurrentInvoicePreview();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        boolean z7 = false;
        boolean z8 = (premiumSubscription == null || premiumSubscription.isNonePlan()) ? false : true;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        GooglePlaySku googlePlaySkuFromSkuName = (premiumSubscription == null || (paymentGatewayPlanId = premiumSubscription.getPaymentGatewayPlanId()) == null) ? null : GooglePlaySku.INSTANCE.fromSkuName(paymentGatewayPlanId);
        LinearLayout linearLayout = getBinding().q;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsSubscriptionContainer");
        linearLayout.setVisibility(model.getHasAnyGuildBoosts() || z8 ? 0 : 8);
        ActiveSubscriptionView activeSubscriptionView = getBinding().f;
        Intrinsics3.checkNotNullExpressionValue(activeSubscriptionView, "binding.premiumSettingsActiveSubscription");
        activeSubscriptionView.setVisibility(z8 && currentInvoicePreview != null ? 0 : 8);
        if (z8 && currentInvoicePreview != null) {
            Intrinsics3.checkNotNull(premiumSubscription);
            Iterator<T> it = currentInvoicePreview.getInvoiceItems().iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                ModelInvoicePreview3 modelInvoicePreview4 = (ModelInvoicePreview3) next2;
                if (modelInvoicePreview4.getSubscriptionPlanId() != premiumSubscription.getPremiumBasePlanId()) {
                    long subscriptionPlanId2 = modelInvoicePreview4.getSubscriptionPlanId();
                    ModelSubscription.SubscriptionRenewalMutations renewalMutations5 = premiumSubscription.getRenewalMutations();
                    if (renewalMutations5 == null || subscriptionPlanId2 != renewalMutations5.getPremiumBasePlanId()) {
                        z6 = false;
                    } else {
                        z6 = true;
                    }
                } else {
                    z6 = true;
                }
            } while (!z6);
            ModelInvoicePreview3 modelInvoicePreview5 = (ModelInvoicePreview3) next2;
            int premiumSubscriptionCount = (googlePlaySkuFromSkuName == null || !GooglePlaySku2.isBundledSku(googlePlaySkuFromSkuName)) ? 0 : googlePlaySkuFromSkuName.getPremiumSubscriptionCount();
            CharSequence priceText = getPriceText(premiumSubscription, skuDetails, modelInvoicePreview5);
            if (premiumSubscription.getStatus().isAccountHold()) {
                z3 = false;
            } else {
                if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) == GooglePlaySku.Type.PREMIUM_GUILD) {
                    z3 = false;
                } else {
                    if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) != GooglePlaySku.Type.PREMIUM_TIER_1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
            }
            Companion.SubscriptionViewCallbacks premiumSubscriptionViewCallbacks = getPremiumSubscriptionViewCallbacks(premiumSubscription, z3, model.getPurchases());
            if (premiumSubscription.getStatus().isAccountHold()) {
                restoreCallback = premiumSubscriptionViewCallbacks.getManageBillingCallback();
            } else {
                if (premiumSubscription.getRenewalMutations() != null) {
                    function0 = null;
                } else {
                    restoreCallback = premiumSubscription.getStatus().isCanceled() ? premiumSubscriptionViewCallbacks.getRestoreCallback() : premiumSubscriptionViewCallbacks.getManagePlanCallback();
                }
                if (zIsGoogleSubscription && (((renewalMutations = premiumSubscription.getRenewalMutations()) != null && renewalMutations.getPremiumBasePlanId() == SubscriptionPlanType.NONE_MONTH.getPlanId()) || (((renewalMutations2 = premiumSubscription.getRenewalMutations()) != null && renewalMutations2.getPremiumBasePlanId() == SubscriptionPlanType.NONE_YEAR.getPlanId()) || (((renewalMutations3 = premiumSubscription.getRenewalMutations()) != null && renewalMutations3.getPremiumBasePlanId() == SubscriptionPlanType.NONE_3_MONTH.getPlanId()) || ((renewalMutations4 = premiumSubscription.getRenewalMutations()) != null && renewalMutations4.getPremiumBasePlanId() == SubscriptionPlanType.NONE_6_MONTH.getPlanId()))))) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                ActiveSubscriptionView activeSubscriptionView2 = getBinding().f;
                ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeB = ActiveSubscriptionView.b(premiumSubscription);
                ModelSubscription.Status status5 = premiumSubscription.getStatus();
                if (premiumSubscription.getTrialId() != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                activeSubscriptionView2.a(activeSubscriptionTypeB, status5, z5, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), z4);
            }
            function0 = restoreCallback;
            if (zIsGoogleSubscription) {
                z4 = false;
            } else {
                z4 = true;
            }
            ActiveSubscriptionView activeSubscriptionView3 = getBinding().f;
            ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeB2 = ActiveSubscriptionView.b(premiumSubscription);
            ModelSubscription.Status status6 = premiumSubscription.getStatus();
            if (premiumSubscription.getTrialId() != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            activeSubscriptionView3.a(activeSubscriptionTypeB2, status6, z5, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), z4);
        }
        ModelInvoicePreview currentInvoicePreview2 = model.getCurrentInvoicePreview();
        if (currentInvoicePreview2 == null || (invoiceItems = currentInvoicePreview2.getInvoiceItems()) == null) {
            modelInvoicePreview3 = null;
        } else {
            Iterator<T> it2 = invoiceItems.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    subscriptionPlanId = ((ModelInvoicePreview3) next).getSubscriptionPlanId();
                    guildBoostPlanId = premiumSubscription != null ? premiumSubscription.getGuildBoostPlanId() : null;
                }
            } while (!(guildBoostPlanId != null && subscriptionPlanId == guildBoostPlanId.longValue()));
            modelInvoicePreview3 = (ModelInvoicePreview3) next;
        }
        ActiveSubscriptionView activeSubscriptionView4 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(activeSubscriptionView4, "binding.premiumSettingsActiveGuildSubscription");
        activeSubscriptionView4.setVisibility(model.getHasAnyGuildBoosts() && modelInvoicePreview3 != null ? 0 : 8);
        if (!model.getHasAnyGuildBoosts() || modelInvoicePreview3 == null) {
            return;
        }
        Map<Long, ModelGuildBoostSlot> guildSubscriptions = model.getGuildSubscriptions();
        if (googlePlaySkuFromSkuName == null || !zIsGoogleSubscription) {
            size = guildSubscriptions.values().size() - (premiumSubscription != null ? PremiumUtils.INSTANCE.getGuildBoostCountFromSubscription(premiumSubscription) : 0);
        } else {
            size = googlePlaySkuFromSkuName.getPremiumSubscriptionCount();
        }
        int i = size;
        CharSequence priceText2 = getPriceText(premiumSubscription, skuDetails, modelInvoicePreview3);
        boolean z9 = zIsGoogleSubscription && (premiumSubscription != null ? ActiveSubscriptionView.b(premiumSubscription) : null) == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD;
        ActiveSubscriptionView activeSubscriptionView5 = getBinding().e;
        Intrinsics3.checkNotNullExpressionValue(activeSubscriptionView5, "binding.premiumSettingsActiveGuildSubscription");
        activeSubscriptionView5.setVisibility(!zIsGoogleSubscription || z9 ? 0 : 8);
        Companion.SubscriptionViewCallbacks guildBoostViewCallbacks = getGuildBoostViewCallbacks(z9, premiumSubscription != null ? premiumSubscription.getPaymentGatewayPlanId() : null);
        Collection<ModelGuildBoostSlot> collectionValues = guildSubscriptions.values();
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it3 = collectionValues.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    z2 = false;
                    break;
                } else if (((ModelGuildBoostSlot) it3.next()).getCanceled()) {
                    z2 = true;
                    break;
                }
            }
        } else {
            z2 = false;
            break;
        }
        if (zIsGoogleSubscription) {
            if ((premiumSubscription == null || (status4 = premiumSubscription.getStatus()) == null) ? false : status4.isCanceled()) {
                z7 = true;
            }
        }
        if (z7) {
            managePlanCallback = guildBoostViewCallbacks.getRestoreCallback();
        } else {
            managePlanCallback = (premiumSubscription == null || (status = premiumSubscription.getStatus()) == null || !status.isAccountHold()) ? guildBoostViewCallbacks.getManagePlanCallback() : guildBoostViewCallbacks.getManageBillingCallback();
        }
        Function0<Unit> function1 = managePlanCallback;
        ActiveSubscriptionView activeSubscriptionView6 = getBinding().e;
        ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionType = ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD;
        if (z2 || z7) {
            status2 = ModelSubscription.Status.CANCELED;
        } else {
            status2 = (premiumSubscription == null || (status3 = premiumSubscription.getStatus()) == null || !status3.isAccountHold()) ? ModelSubscription.Status.ACTIVE : ModelSubscription.Status.ACCOUNT_HOLD;
        }
        ModelSubscription.Status status7 = status2;
        boolean zIsBusy = model.isBusy();
        Function0<Unit> manageGuildBoostCallback = guildBoostViewCallbacks.getManageGuildBoostCallback();
        Function0<Unit> cancelCallback = guildBoostViewCallbacks.getCancelCallback();
        int i2 = ActiveSubscriptionView.j;
        activeSubscriptionView6.a(activeSubscriptionType, status7, false, priceText2, zIsBusy, i, function1, manageGuildBoostCallback, cancelCallback, false);
    }

    private final void configureButtonText(Map<String, ? extends SkuDetails> skuDetails) {
        MaterialButton materialButton = getBinding().t.f76b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.premiumTier1.premiumSettingsPremiumClassic");
        materialButton.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName()) : null));
        MaterialButton materialButton2 = getBinding().u.f84b;
        Intrinsics3.checkNotNullExpressionValue(materialButton2, "binding.premiumTier2.premiumSettingsPremium");
        materialButton2.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configureButtonText$default(WidgetSettingsPremium widgetSettingsPremium, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        widgetSettingsPremium.configureButtonText(map);
    }

    private final void configureButtons(final ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails) {
        configureButtonText(skuDetails);
        if (premiumSubscription == null || !premiumSubscription.isAppleSubscription()) {
            for (final MaterialButton materialButton : Collections2.listOf((Object[]) new MaterialButton[]{getBinding().t.f76b, getBinding().u.f84b})) {
                Intrinsics3.checkNotNullExpressionValue(materialButton, "button");
                materialButton.setEnabled(premiumSubscription == null);
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetChoosePlan.Companion companion = WidgetChoosePlan.INSTANCE;
                        Context contextRequireContext = this.requireContext();
                        WidgetChoosePlan.ViewType viewType = Intrinsics3.areEqual(materialButton, this.getBinding().t.f76b) ? WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_1 : WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_2;
                        ModelSubscription modelSubscription = premiumSubscription;
                        companion.launch(contextRequireContext, (34 & 2) != 0 ? null : null, viewType, (34 & 8) != 0 ? null : modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null, new Traits.Location(Traits.Location.Page.USER_SETTINGS, this.getAnalyticsLocationSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), (34 & 32) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(Intrinsics3.areEqual(materialButton, this.getBinding().t.f76b) ? GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName() : GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()));
                    }
                });
            }
            return;
        }
        for (MaterialButton materialButton2 : Collections2.listOf((Object[]) new MaterialButton[]{getBinding().t.f76b, getBinding().u.f84b})) {
            Intrinsics3.checkNotNullExpressionValue(materialButton2, "button");
            ViewExtensions.setEnabledAlpha$default(materialButton2, true, 0.0f, 2, null);
            materialButton2.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PremiumUtils.INSTANCE.openAppleBilling(this.this$0.requireContext());
                }
            });
        }
    }

    private final void configureGrandfatheredHeader(ModelSubscription premiumSubscription) {
        CharSequence charSequenceE = null;
        SubscriptionPlanType planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        if (planType != null) {
            int iOrdinal = planType.ordinal();
            if (iOrdinal == 4) {
                charSequenceE = FormatUtils.e(this, R.string.premium_grandfathered_monthly, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtils2.getGRANDFATHERED_MONTHLY_END_DATE())}, (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else if (iOrdinal == 5) {
                charSequenceE = FormatUtils.e(this, R.string.premium_grandfathered_yearly, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtils2.getGRANDFATHERED_YEARLY_END_DATE())}, (4 & 4) != 0 ? FormatUtils.a.j : null);
            }
        }
        TextView textView = getBinding().i;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsGrandfathered");
        ViewExtensions.setTextAndVisibilityBy(textView, charSequenceE);
    }

    private final void configureLegalese(SettingsPremiumViewModel.ViewState.Loaded model) {
        int i;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        if (premiumSubscription == null || !premiumSubscription.getPlanType().isPremiumSubscription()) {
            TextView textView = getBinding().j;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsLegalese");
            textView.setVisibility(8);
            return;
        }
        int iOrdinal = premiumSubscription.getPlanType().getInterval().ordinal();
        if (iOrdinal == 0) {
            i = R.string.billing_payment_premium_terms_legalese_monthly;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = R.string.billing_payment_premium_terms_legalese_yearly;
        }
        Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
        if (googleSubscriptionRenewalPrice == null) {
            googleSubscriptionRenewalPrice = PremiumUtils2.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
        }
        TextView textView2 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumSettingsLegalese");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.premiumSettingsLegalese");
        FormatUtils.m(textView3, i, new Object[]{FormatUtils.e(this, R.string.terms_of_service_url, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.paid_services_terms_url, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.privacy_policy_url, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), googleSubscriptionRenewalPrice}, (4 & 4) != 0 ? FormatUtils.g.j : null);
        TextView textView4 = getBinding().j;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.premiumSettingsLegalese");
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:87:0x0173  */
    private final void configurePaymentInfo(SettingsPremiumViewModel.ViewState.Loaded model) {
        String strRenderUtcDate$default;
        CharSequence charSequenceE;
        int pastDueGracePeriodDays;
        int iOrdinal;
        final ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        final boolean zIsAppleSubscription = premiumSubscription != null ? premiumSubscription.isAppleSubscription() : false;
        final boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        ModelSubscription.Status status = premiumSubscription != null ? premiumSubscription.getStatus() : null;
        boolean z2 = status != null && ((iOrdinal = status.ordinal()) == 2 || iOrdinal == 5);
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        Object objE = "";
        if (premiumSubscription != null) {
            TimeUtils timeUtils = TimeUtils.INSTANCE;
            String currentPeriodStart = z2 ? premiumSubscription.getCurrentPeriodStart() : premiumSubscription.getCurrentPeriodEnd();
            Context contextRequireContext = requireContext();
            int iOrdinal2 = premiumSubscription.getStatus().ordinal();
            if (iOrdinal2 != 2) {
                pastDueGracePeriodDays = iOrdinal2 != 5 ? 0 : 30;
            } else {
                pastDueGracePeriodDays = model.getPastDueGracePeriodDays();
            }
            strRenderUtcDate$default = TimeUtils.renderUtcDate$default(timeUtils, currentPeriodStart, contextRequireContext, (String) null, (java.text.DateFormat) null, pastDueGracePeriodDays, 12, (Object) null);
            if (strRenderUtcDate$default == null) {
                strRenderUtcDate$default = "";
            }
        } else {
            strRenderUtcDate$default = "";
        }
        LinearLayout linearLayout = getBinding().c.f;
        Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.payment.premiumSettingsPaymentContainer");
        linearLayout.setVisibility(premiumSubscription != null ? 0 : 8);
        View view = getBinding().c.c;
        Intrinsics3.checkNotNullExpressionValue(view, "binding.payment.premiumSettingsBillingDivider");
        view.setVisibility(zIsAppleSubscription ? 0 : 8);
        if (premiumSubscription != null) {
            ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeB = ActiveSubscriptionView.b(premiumSubscription);
            SkuDetails skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId());
            String strA = skuDetails2 != null ? skuDetails2.a() : null;
            if (zIsGoogleSubscription && strA != null) {
                objE = strA;
            } else if (activeSubscriptionTypeB == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM) {
                objE = FormatUtils.e(this, R.string.premium_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else if (activeSubscriptionTypeB == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_CLASSIC) {
                objE = FormatUtils.e(this, R.string.premium_tier_1, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else if (activeSubscriptionTypeB == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD) {
                objE = FormatUtils.e(this, R.string.premium_guild_subscription_title, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            }
        }
        if (zIsAppleSubscription) {
            charSequenceE = FormatUtils.e(this, R.string.billing_managed_by_apple, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
        } else if (premiumSubscription == null) {
            charSequenceE = null;
        } else {
            int iOrdinal3 = premiumSubscription.getStatus().ordinal();
            if (iOrdinal3 == 1) {
                Object[] objArr = new Object[2];
                objArr[0] = strRenderUtcDate$default;
                Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
                if (googleSubscriptionRenewalPrice == null) {
                    googleSubscriptionRenewalPrice = PremiumUtils2.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
                }
                objArr[1] = googleSubscriptionRenewalPrice;
                charSequenceE = FormatUtils.e(this, R.string.premium_settings_renewal_info, objArr, (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else if (iOrdinal3 == 2) {
                charSequenceE = FormatUtils.e(this, R.string.premium_settings_past_due_info, new Object[]{objE, strRenderUtcDate$default}, (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else if (iOrdinal3 == 3) {
                charSequenceE = FormatUtils.e(this, R.string.premium_settings_cancelled_info, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? FormatUtils.a.j : null);
            } else if (iOrdinal3 != 5) {
                charSequenceE = null;
            } else {
                charSequenceE = FormatUtils.e(this, R.string.premium_settings_account_hold_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, premiumSubscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null)}, (4 & 4) != 0 ? FormatUtils.a.j : null);
            }
        }
        TextView textView = getBinding().c.d;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.payment.premiumSettingsBillingInformation");
        textView.setVisibility(charSequenceE != null ? 0 : 8);
        if (charSequenceE != null) {
            TextView textView2 = getBinding().c.d;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.payment.premiumSettingsBillingInformation");
            textView2.setText(charSequenceE);
        }
        MaterialButton materialButton = getBinding().c.f195b;
        Intrinsics3.checkNotNullExpressionValue(materialButton, "binding.payment.activeSubscriptionsBottomButton");
        ViewExtensions.setTextAndVisibilityBy(materialButton, zIsAppleSubscription ? FormatUtils.e(this, R.string.billing_manage_subscription, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null) : null);
        getBinding().c.f195b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configurePaymentInfo.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (zIsAppleSubscription) {
                    PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                    Intrinsics3.checkNotNullExpressionValue(view2, "it");
                    Context context = view2.getContext();
                    Intrinsics3.checkNotNullExpressionValue(context, "it.context");
                    premiumUtils.openAppleBilling(context);
                }
            }
        });
        TextView textView3 = getBinding().c.e;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.payment.premiumSettingsGooglePlayManage");
        textView3.setVisibility(zIsGoogleSubscription ? 0 : 8);
        getBinding().c.e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configurePaymentInfo.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (zIsGoogleSubscription) {
                    PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                    Context contextX = outline.x(view2, "it", "it.context");
                    ModelSubscription modelSubscription = premiumSubscription;
                    premiumUtils.openGooglePlayBilling(contextX, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null);
                }
            }
        });
    }

    private final void configurePriceChangeNotice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        SkuDetails skuDetails = skuDetailsMap != null ? skuDetailsMap.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null;
        String strOptString = skuDetails != null ? skuDetails.f2006b.optString("price_currency_code") : null;
        Map mapMapOf = MapsJVM.mapOf(Tuples.to("PLN", Integer.valueOf(R.string.country_name_pl)));
        Objects.requireNonNull(mapMapOf, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        boolean z2 = mapMapOf.containsKey(strOptString) && (subscription == null || subscription.isGoogleSubscription());
        CardView cardView = getBinding().k.f79b;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.premiumSettingsPriceChangeNotice.card");
        cardView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            int i = subscription == null ? R.string.localized_pricing_mobile_price_change_notice_no_sub : R.string.localized_pricing_mobile_price_change_notice_has_sub;
            TextView textView = getBinding().k.c;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsPriceChangeNotice.textview");
            Object[] objArr = new Object[3];
            Integer num = (Integer) mapMapOf.get(strOptString);
            objArr[0] = num != null ? FormatUtils.e(this, num.intValue(), new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null) : null;
            objArr[1] = skuDetails != null ? skuDetails.b() : null;
            objArr[2] = AppHelpDesk.a.a(4407269525911L, null);
            textView.setText(FormatUtils.e(this, i, objArr, (4 & 4) != 0 ? FormatUtils.a.j : null));
            getBinding().k.c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configurePriceChangeNotice.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UriHandler.handle$default(UriHandler.INSTANCE, outline.I(WidgetSettingsPremium.this.getBinding().k.c, "binding.premiumSettingsPriceChangeNotice.textview", "binding.premiumSettingsP…geNotice.textview.context"), AppHelpDesk.a.a(4407269525911L, null), false, false, null, 28, null);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:73:0x010a A[LOOP:1: B:69:0x00f3->B:73:0x010a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x010e A[EDGE_INSN: B:88:0x010e->B:75:0x010e BREAK  A[LOOP:1: B:69:0x00f3->B:73:0x010a], SYNTHETIC] */
    private final void configureStatusNotice(final ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        boolean z2;
        CharSequence charSequenceE;
        SubscriptionPlanType[] subscriptionPlanTypeArrValues;
        int i;
        SubscriptionPlanType subscriptionPlanType;
        CharSequence planString;
        SubscriptionPlanType subscriptionPlanType2;
        CharSequence planString2;
        String paymentGatewayPlanId;
        ModelSubscription.Status status;
        boolean z3 = (subscription != null ? subscription.getRenewalMutations() : null) != null;
        boolean zIsAccountHold = (subscription == null || (status = subscription.getStatus()) == null) ? false : status.isAccountHold();
        if (z3 || zIsAccountHold) {
            if ((subscription != null ? subscription.getStatus() : null) != ModelSubscription.Status.CANCELED) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        CardView cardView = getBinding().o;
        Intrinsics3.checkNotNullExpressionValue(cardView, "binding.premiumSettingsStatusNoticeContainer");
        cardView.setVisibility(z2 ? 0 : 8);
        if (!z2 || subscription == null) {
            return;
        }
        boolean zIsGoogleSubscription = subscription.isGoogleSubscription();
        if (z3) {
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getCurrentPeriodEnd(), requireContext(), (String) null, (java.text.DateFormat) null, 0, 28, (Object) null);
            ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
            SkuDetails skuDetails = (renewalMutations == null || (paymentGatewayPlanId = renewalMutations.getPaymentGatewayPlanId()) == null || skuDetailsMap == null) ? null : skuDetailsMap.get(paymentGatewayPlanId);
            SubscriptionPlanType[] subscriptionPlanTypeArrValues2 = SubscriptionPlanType.values();
            int i2 = 0;
            while (true) {
                if (i2 >= 17) {
                    subscriptionPlanType2 = null;
                    break;
                }
                subscriptionPlanType2 = subscriptionPlanTypeArrValues2[i2];
                long planId = subscriptionPlanType2.getPlanId();
                ModelSubscription.SubscriptionRenewalMutations renewalMutations2 = subscription.getRenewalMutations();
                if (renewalMutations2 != null && planId == renewalMutations2.getPremiumBasePlanId()) {
                    break;
                } else {
                    i2++;
                }
            }
            if (!zIsGoogleSubscription || skuDetails == null) {
                planString2 = getPlanString(subscriptionPlanType2);
            } else {
                planString2 = skuDetails.a();
                Intrinsics3.checkNotNullExpressionValue(planString2, "skuDetails.description");
            }
            charSequenceE = FormatUtils.e(this, R.string.premium_pending_plan_change_notice, new Object[]{planString2, strRenderUtcDate$default}, (4 & 4) != 0 ? FormatUtils.a.j : null);
        } else if (zIsAccountHold) {
            String paymentGatewayPlanId2 = subscription.getPaymentGatewayPlanId();
            if (paymentGatewayPlanId2 == null) {
                subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
                i = 0;
                while (true) {
                    if (i < 17) {
                        subscriptionPlanType = null;
                        break;
                    }
                    subscriptionPlanType = subscriptionPlanTypeArrValues[i];
                    if (subscription.hasAnyOfPlans(SetsJVM.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
                        break;
                    } else {
                        i++;
                    }
                }
                planString = getPlanString(subscriptionPlanType);
            } else {
                SkuDetails skuDetails2 = skuDetailsMap != null ? skuDetailsMap.get(paymentGatewayPlanId2) : null;
                if (skuDetails2 == null || (planString = skuDetails2.a()) == null) {
                    subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
                    i = 0;
                    while (true) {
                        if (i < 17) {
                            subscriptionPlanType = null;
                            break;
                        }
                        subscriptionPlanType = subscriptionPlanTypeArrValues[i];
                        if (subscription.hasAnyOfPlans(SetsJVM.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
                            break;
                            break;
                        }
                        i++;
                    }
                    planString = getPlanString(subscriptionPlanType);
                }
            }
            charSequenceE = FormatUtils.e(this, R.string.premium_settings_account_hold_notice_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null), planString}, (4 & 4) != 0 ? FormatUtils.a.j : null);
        } else {
            charSequenceE = "";
        }
        TextView textView = getBinding().p;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumSettingsStatusNoticeTv");
        textView.setText(charSequenceE);
        Button button = getBinding().n;
        Intrinsics3.checkNotNullExpressionValue(button, "binding.premiumSettingsStatusNoticeButton");
        button.setVisibility(zIsAccountHold ? 0 : 8);
        if (zIsAccountHold) {
            Button button2 = getBinding().n;
            Intrinsics3.checkNotNullExpressionValue(button2, "binding.premiumSettingsStatusNoticeButton");
            FormatUtils.m(button2, R.string.premium_settings_account_hold_notice_change_payment_method_button, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
            getBinding().n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configureStatusNotice.1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), subscription.getPaymentGatewayPlanId());
                }
            });
        }
    }

    private final String getAnalyticsLocationSection() {
        String string;
        Bundle extras = getMostRecentIntent().getExtras();
        return (extras == null || (string = extras.getString(ANALYTICS_LOCATION_SECTION)) == null) ? "Discord Nitro" : string;
    }

    private final WidgetSettingsPremiumBinding getBinding() {
        return (WidgetSettingsPremiumBinding) this.binding.getValue((Fragment) this, $$delegatedProperties[0]);
    }

    private final String getGoogleSubscriptionRenewalPrice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetails) {
        if (!subscription.isGoogleSubscription()) {
            return null;
        }
        SkuDetails skuDetails2 = skuDetails.get(subscription.getPaymentGatewayPlanId());
        ModelSubscription.SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        SkuDetails skuDetails3 = skuDetails.get(renewalMutations != null ? renewalMutations.getPaymentGatewayPlanId() : null);
        if (subscription.getRenewalMutations() != null && skuDetails3 != null) {
            return skuDetails3.b();
        }
        if (subscription.getRenewalMutations() != null || skuDetails2 == null) {
            return null;
        }
        return skuDetails2.b();
    }

    private final Companion.SubscriptionViewCallbacks getGuildBoostViewCallbacks(boolean isGoogleGuildBoost, String skuName) {
        if (!isGoogleGuildBoost) {
            return new Companion.SubscriptionViewCallbacks(null, null, null, new AnonymousClass6(), null);
        }
        return new Companion.SubscriptionViewCallbacks(new AnonymousClass2(skuName), new AnonymousClass3(skuName), new AnonymousClass4(skuName), new AnonymousClass1(), new AnonymousClass5(skuName));
    }

    private final CharSequence getPlanString(SubscriptionPlanType planType) {
        if (planType != null) {
            switch (planType.ordinal()) {
                case 6:
                    return FormatUtils.e(this, R.string.premium_plan_month_tier_1, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                case 7:
                    return FormatUtils.e(this, R.string.premium_plan_year_tier_1, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                case 8:
                    return FormatUtils.e(this, R.string.premium_plan_month_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                case 9:
                    return FormatUtils.e(this, R.string.premium_plan_3_month_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                case 10:
                    return FormatUtils.e(this, R.string.premium_plan_6_month_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
                case 11:
                    return FormatUtils.e(this, R.string.premium_plan_year_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
            }
        }
        return "";
    }

    private final Companion.SubscriptionViewCallbacks getPremiumSubscriptionViewCallbacks(ModelSubscription premiumSubscription, boolean canManageGuildBoosts, List<? extends Purchase> purchases) {
        if (!premiumSubscription.isGoogleSubscription()) {
            return premiumSubscription.isAppleSubscription() ? new Companion.SubscriptionViewCallbacks(null, null, null, null, null) : new Companion.SubscriptionViewCallbacks(null, new AnonymousClass4(), new AnonymousClass5(), null, null);
        }
        WidgetSettingsPremium5 widgetSettingsPremium5 = canManageGuildBoosts ? new WidgetSettingsPremium5(this) : null;
        boolean z2 = true;
        if (!(purchases instanceof Collection) || !purchases.isEmpty()) {
            Iterator<T> it = purchases.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
            } while (!(!((Purchase) it.next()).c()));
        } else {
            z2 = false;
            break;
        }
        return new Companion.SubscriptionViewCallbacks(new AnonymousClass1(premiumSubscription), z2 ? new WidgetSettingsPremium6(this) : new WidgetSettingsPremium7(this, premiumSubscription), new AnonymousClass2(premiumSubscription), widgetSettingsPremium5, new AnonymousClass3(premiumSubscription));
    }

    private final CharSequence getPriceText(SkuDetails skuDetails) {
        return skuDetails != null ? FormatUtils.e(this, R.string.premium_settings_starting_at_per_month, new Object[]{skuDetails.b()}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(this, R.string.stream_premium_upsell_cta, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null);
    }

    private final SettingsPremiumViewModel getViewModel() {
        return (SettingsPremiumViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsPremiumViewModel.Event event) {
        if (event instanceof SettingsPremiumViewModel.Event.ErrorToast) {
            AppToast.i(this, ((SettingsPremiumViewModel.Event.ErrorToast) event).getErrorStringResId(), 0, 4);
        }
    }

    private final void scrollToSection(Integer section) {
        int top;
        if (section != null && section.intValue() == 0) {
            ViewPremiumSettingsTier1Binding viewPremiumSettingsTier1Binding = getBinding().t;
            Intrinsics3.checkNotNullExpressionValue(viewPremiumSettingsTier1Binding, "binding.premiumTier1");
            LinearLayout linearLayout = viewPremiumSettingsTier1Binding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout, "binding.premiumTier1.root");
            int top2 = linearLayout.getTop();
            ScrollView scrollView = getBinding().m;
            Intrinsics3.checkNotNullExpressionValue(scrollView, "binding.premiumSettingsScrollview");
            top = scrollView.getHeight() + top2;
        } else if (section != null && section.intValue() == 1) {
            ViewPremiumSettingsTier2Binding viewPremiumSettingsTier2Binding = getBinding().u;
            Intrinsics3.checkNotNullExpressionValue(viewPremiumSettingsTier2Binding, "binding.premiumTier2");
            LinearLayout linearLayout2 = viewPremiumSettingsTier2Binding.a;
            Intrinsics3.checkNotNullExpressionValue(linearLayout2, "binding.premiumTier2.root");
            top = linearLayout2.getTop();
        } else {
            top = 0;
        }
        getBinding().m.scrollTo(0, top);
    }

    private final void scrollToTop() {
        getBinding().m.scrollTo(0, 0);
    }

    private final void showCancelConfirmationAlert(SettingsPremiumViewModel viewModel) {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.e(this, R.string.premium_cancel_confirm_header, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.premium_cancel_confirm_body, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.premium_cancel_confirm_button, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.nevermind, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), MapsJVM.mapOf(Tuples.to(Integer.valueOf(R.id.notice_ok), new AnonymousClass1(viewModel))), null, null, null, Integer.valueOf(R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    private final void showContent(SettingsPremiumViewModel.ViewState.Loaded model) {
        SubscriptionPlanType planType;
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(0);
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Boolean boolValueOf = (premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : Boolean.valueOf(planType.isPremiumSubscription());
        ModelSubscription premiumSubscription2 = model.getPremiumSubscription();
        Boolean boolValueOf2 = premiumSubscription2 != null ? Boolean.valueOf(premiumSubscription2.isNonePlan()) : null;
        Boolean bool = Boolean.FALSE;
        if (Intrinsics3.areEqual(boolValueOf, bool) && Intrinsics3.areEqual(boolValueOf2, bool)) {
            StringBuilder sbU = outline.U("Attempting to open WidgetSettingsPremium with non-Premium ");
            StringBuilder sbU2 = outline.U("and non-Guild Boost subscription: ");
            sbU2.append(model.getPremiumSubscription().getId());
            sbU.append(sbU2.toString());
            String string = sbU.toString();
            Intrinsics3.checkNotNullExpressionValue(string, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.e$default(AppLog.g, string, null, null, 6, null);
            FragmentActivity fragmentActivityE = e();
            if (fragmentActivityE != null) {
                fragmentActivityE.finish();
                return;
            }
            return;
        }
        configureActiveSubscriptionView(model);
        configureGrandfatheredHeader(model.getPremiumSubscription());
        configureLegalese(model);
        configureButtons(model.getPremiumSubscription(), model.getSkuDetails());
        configureAccountCredit(model.getEntitlements(), model.getPremiumSubscription());
        configurePaymentInfo(model);
        configureStatusNotice(model.getPremiumSubscription(), model.getSkuDetails());
        configurePriceChangeNotice(model.getPremiumSubscription(), model.getSkuDetails());
        Bundle extras = getMostRecentIntent().getExtras();
        Integer numValueOf = extras != null ? Integer.valueOf(extras.getInt(INTENT_SCROLL_TO_SECTION, -1)) : null;
        if (numValueOf != null && numValueOf.intValue() == -1) {
            return;
        }
        try {
            Observable<Long> observableD0 = Observable.d0(300L, TimeUnit.MILLISECONDS);
            Intrinsics3.checkNotNullExpressionValue(observableD0, "Observable\n            .…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1(numValueOf));
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Error Scrolling to section", e, null, 4, null);
        }
        getMostRecentIntent().removeExtra(INTENT_SCROLL_TO_SECTION);
    }

    private final void showDesktopManageAlert() {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        Intrinsics3.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, FormatUtils.e(this, R.string.billing_manage_subscription, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.premium_manage_via_desktop, new Object[]{AppHelpDesk.a.a(360055386693L, null)}, (4 & 4) != 0 ? FormatUtils.a.j : null), FormatUtils.e(this, R.string.premium_guild_subscription_header_subscribe_tooltip_close, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(2);
        getBinding().l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.showFailureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsPremium.this.getViewModel().onRetryClicked();
            }
        });
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        Intrinsics3.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        scrollToTop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        Intrinsics3.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(R.string.user_settings);
        setActionBarTitle(R.string.premium_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().d.e;
        Intrinsics3.checkNotNullExpressionValue(textView, "binding.premiumPerks.uploadSizePerk");
        textView.setText(FormatUtils.d(view, R.string.premium_perks_upload_size, new Object[0], new AnonymousClass1()));
        TextView textView2 = getBinding().t.d;
        Intrinsics3.checkNotNullExpressionValue(textView2, "binding.premiumTier1.tier1UploadSizePerk");
        textView2.setText(FormatUtils.d(view, R.string.premium_perks_upload_size, new Object[0], new AnonymousClass2()));
        TextView textView3 = getBinding().d.f239b;
        Intrinsics3.checkNotNullExpressionValue(textView3, "binding.premiumPerks.guildSubscriptionPerk");
        textView3.setText(FormatUtils.d(view, R.string.premium_perks_tier_2_guild_subscription, new Object[0], AnonymousClass3.INSTANCE));
        TextView textView4 = getBinding().t.c;
        Intrinsics3.checkNotNullExpressionValue(textView4, "binding.premiumTier1.tier1GuildSubscriptionPerk");
        textView4.setText(FormatUtils.d(view, R.string.premium_perks_tier_1_guild_subscription, new Object[0], AnonymousClass4.INSTANCE));
        NumberFormat numberFormat = NumberFormat.getInstance(this.localeManager.getPrimaryLocale(requireContext()));
        TextView textView5 = getBinding().d.c;
        Intrinsics3.checkNotNullExpressionValue(textView5, "binding.premiumPerks.maxGuildsPerk");
        textView5.setText(FormatUtils.d(view, R.string.premium_perks_tier_2_max_guilds, new Object[0], new AnonymousClass5(numberFormat)));
        TextView textView6 = getBinding().d.d;
        Intrinsics3.checkNotNullExpressionValue(textView6, "binding.premiumPerks.maxMessageLengthPerk");
        textView6.setText(FormatUtils.e(this, R.string.premium_chat_perks_max_message_length, new Object[0], new AnonymousClass6(numberFormat)));
        configureButtonText$default(this, null, 1, null);
        for (TextView textView7 : Collections2.listOf((Object[]) new TextView[]{getBinding().r, getBinding().h, getBinding().c.g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            Intrinsics3.checkNotNullExpressionValue(textView7, "header");
            accessibilityUtils.setViewIsHeading(textView7);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsPremiumViewModel.ViewState> observableR = getViewModel().observeViewState().q(200L, TimeUnit.MILLISECONDS).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), (Class<?>) WidgetSettingsPremium.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass1());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().getEventSubject(), this, null, 2, null), (Class<?>) WidgetSettingsPremium.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.AnonymousClass1.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.AnonymousClass2.INSTANCE : null), new AnonymousClass2(this));
    }

    private final CharSequence getPriceText(ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails, ModelInvoicePreview3 invoiceItem) {
        SubscriptionPlanType planType;
        SkuDetails skuDetails2;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        if (invoiceItem == null || (planType = SubscriptionPlanType.INSTANCE.from(invoiceItem.getSubscriptionPlanId())) == null) {
            planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        }
        boolean zIsMonthlyInterval = planType != null ? planType.isMonthlyInterval() : false;
        int intervalCount = planType != null ? planType.getIntervalCount() : 1;
        int i = R.string.billing_price_per_multi_months;
        if (!zIsMonthlyInterval) {
            i = R.string.billing_price_per_year;
        } else if (intervalCount != 3 && intervalCount != 6) {
            i = R.string.billing_price_per_month;
        }
        String strB = (premiumSubscription == null || (skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId())) == null) ? null : skuDetails2.b();
        if (zIsGoogleSubscription && strB != null) {
            return intervalCount == 1 ? FormatUtils.e(this, i, new Object[]{strB}, (4 & 4) != 0 ? FormatUtils.a.j : null) : FormatUtils.e(this, i, new Object[]{strB, Integer.valueOf(intervalCount)}, (4 & 4) != 0 ? FormatUtils.a.j : null);
        }
        if (intervalCount == 1) {
            Object[] objArr = new Object[1];
            objArr[0] = PremiumUtils2.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
            return FormatUtils.e(this, i, objArr, (4 & 4) != 0 ? FormatUtils.a.j : null);
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = PremiumUtils2.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
        objArr2[1] = Integer.valueOf(intervalCount);
        return FormatUtils.e(this, i, objArr2, (4 & 4) != 0 ? FormatUtils.a.j : null);
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$1, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass1() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("maxUploadStandard", FormatUtils.e(WidgetSettingsPremium.this, R.string.file_upload_limit_standard, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null).toString());
            renderContext.args.put("maxUploadPremium", FormatUtils.e(WidgetSettingsPremium.this, R.string.file_upload_limit_premium_tier_2, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$2, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass2 extends Lambda implements Function1<RenderContext, Unit> {
        public AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("maxUploadStandard", FormatUtils.e(WidgetSettingsPremium.this, R.string.file_upload_limit_standard, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null).toString());
            renderContext.args.put("maxUploadPremium", FormatUtils.e(WidgetSettingsPremium.this, R.string.file_upload_limit_premium_tier_1, new Object[0], (4 & 4) != 0 ? FormatUtils.a.j : null).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$4, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass4 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass4 INSTANCE = new AnonymousClass4();

        public AnonymousClass4() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
            Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
            map.put("discountPercentage", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$5, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass5 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ NumberFormat $numberFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass5(NumberFormat numberFormat) {
            super(1);
            this.$numberFormat = numberFormat;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$numberFormat.format((Object) 100);
            Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(Prem…_NON_PREMIUM_GUILD_COUNT)");
            map.put("nonPremiumMaxGuilds", str);
            Map<String, String> map2 = renderContext.args;
            String str2 = this.$numberFormat.format((Object) 200);
            Intrinsics3.checkNotNullExpressionValue(str2, "numberFormat.format(Prem….MAX_PREMIUM_GUILD_COUNT)");
            map2.put("premiumMaxGuilds", str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$3, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass3 extends Lambda implements Function1<RenderContext, Unit> {
        public static final AnonymousClass3 INSTANCE = new AnonymousClass3();

        public AnonymousClass3() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("numBoosts", String.valueOf(2));
            Map<String, String> map = renderContext.args;
            String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
            Intrinsics3.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
            map.put("discountPercentage", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$6, reason: invalid class name */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class AnonymousClass6 extends Lambda implements Function1<RenderContext, Unit> {
        public final /* synthetic */ NumberFormat $numberFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass6(NumberFormat numberFormat) {
            super(1);
            this.$numberFormat = numberFormat;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            Intrinsics3.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$numberFormat.format((Object) 2000);
            Intrinsics3.checkNotNullExpressionValue(str, "numberFormat.format(Send…_MESSAGE_CHARACTER_COUNT)");
            map.put("nonPremiumMaxMessageLength", str);
            Map<String, String> map2 = renderContext.args;
            String str2 = this.$numberFormat.format(Integer.valueOf(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM));
            Intrinsics3.checkNotNullExpressionValue(str2, "numberFormat.format(Send…_CHARACTER_COUNT_PREMIUM)");
            map2.put("premiumMaxMessageLength", str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.a;
        }
    }
}
