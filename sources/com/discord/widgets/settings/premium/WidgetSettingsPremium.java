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
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.C5419R;
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
import com.discord.models.domain.billing.ModelInvoiceItem;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.stores.StoreStream;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySkuKt;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.error.Error;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.p501rx.ObservableExtensionsKt;
import com.discord.utilities.premium.BlockRussianPurchasesUtils;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rest.SendUtils;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.uri.UriHandler;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ActiveSubscriptionView;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.settings.guildboost.WidgetSettingsGuildBoost;
import com.discord.widgets.settings.premium.SettingsPremiumViewModel;
import com.discord.widgets.settings.premium.WidgetChoosePlan;
import com.google.android.material.button.MaterialButton;
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
import p007b.p008a.p018d.C0862f;
import p007b.p008a.p018d.C0865g0;
import p007b.p008a.p018d.C0869i0;
import p007b.p008a.p018d.C0870j;
import p007b.p008a.p018d.C0876m;
import p007b.p008a.p025i.C0915a3;
import p007b.p008a.p025i.C0923b3;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12116o;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12147n;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12216a0;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;
import p658rx.Subscription;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {C1643a.m846d0(WidgetSettingsPremium.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPremiumBinding;", 0)};

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
                return C12238m.areEqual(this.restoreCallback, subscriptionViewCallbacks.restoreCallback) && C12238m.areEqual(this.managePlanCallback, subscriptionViewCallbacks.managePlanCallback) && C12238m.areEqual(this.cancelCallback, subscriptionViewCallbacks.cancelCallback) && C12238m.areEqual(this.manageGuildBoostCallback, subscriptionViewCallbacks.manageGuildBoostCallback) && C12238m.areEqual(this.manageBillingCallback, subscriptionViewCallbacks.manageBillingCallback);
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
                StringBuilder sbM833U = C1643a.m833U("SubscriptionViewCallbacks(restoreCallback=");
                sbM833U.append(this.restoreCallback);
                sbM833U.append(", managePlanCallback=");
                sbM833U.append(this.managePlanCallback);
                sbM833U.append(", cancelCallback=");
                sbM833U.append(this.cancelCallback);
                sbM833U.append(", manageGuildBoostCallback=");
                sbM833U.append(this.manageGuildBoostCallback);
                sbM833U.append(", manageBillingCallback=");
                sbM833U.append(this.manageBillingCallback);
                sbM833U.append(")");
                return sbM833U.toString();
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
            C12238m.checkNotNullParameter(context, "context");
            if (BlockRussianPurchasesUtils.INSTANCE.getINSTANCE().showDialog()) {
                return;
            }
            StoreStream.INSTANCE.getAnalytics().onUserSettingsPaneViewed("Discord Nitro", locationSection);
            C0870j.m156d(context, WidgetSettingsPremium.class, new Intent().putExtra(WidgetSettingsPremium.INTENT_SCROLL_TO_SECTION, scrollToSection).putExtra(WidgetSettingsPremium.ANALYTICS_LOCATION_SECTION, locationSection));
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$1 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99271 extends AbstractC12240o implements Function0<Unit> {
        public C99271() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGuildBoost.INSTANCE.launch(WidgetSettingsPremium.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$2 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99282 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99282(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$3 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99293 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99293(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetChoosePlan.INSTANCE.launch(WidgetSettingsPremium.this.requireContext(), (34 & 2) != 0 ? null : null, WidgetChoosePlan.ViewType.SWITCH_PLANS, (34 & 8) != 0 ? null : this.$skuName, new Traits.Location(Traits.Location.Page.USER_SETTINGS, WidgetSettingsPremium.this.getAnalyticsLocationSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), (34 & 32) != 0 ? null : null);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$4 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99304 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99304(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$5 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99315 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ String $skuName;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99315(String str) {
            super(0);
            this.$skuName = str;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$skuName);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getGuildBoostViewCallbacks$6 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99326 extends AbstractC12240o implements Function0<Unit> {
        public C99326() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsGuildBoost.INSTANCE.launch(WidgetSettingsPremium.this.requireContext());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$1 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99331 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99331(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$2 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99342 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99342(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$3 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99353 extends AbstractC12240o implements Function0<Unit> {
        public final /* synthetic */ ModelSubscription $premiumSubscription;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99353(ModelSubscription modelSubscription) {
            super(0);
            this.$premiumSubscription = modelSubscription;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            PremiumUtils.INSTANCE.openGooglePlayBilling(WidgetSettingsPremium.this.requireContext(), this.$premiumSubscription.getPaymentGatewayPlanId());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$4 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99364 extends AbstractC12240o implements Function0<Unit> {
        public C99364() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium.this.showDesktopManageAlert();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$5 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99375 extends AbstractC12240o implements Function0<Unit> {
        public C99375() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Unit invoke() {
            invoke2();
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            WidgetSettingsPremium widgetSettingsPremium = WidgetSettingsPremium.this;
            widgetSettingsPremium.showCancelConfirmationAlert(widgetSettingsPremium.getViewModel());
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBoundOrOnResume$1 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99471 extends AbstractC12240o implements Function1<SettingsPremiumViewModel.ViewState, Unit> {
        public C99471() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel.ViewState viewState) {
            invoke2(viewState);
            return Unit.f27425a;
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

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBoundOrOnResume$2 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final /* synthetic */ class C99482 extends C12236k implements Function1<SettingsPremiumViewModel.Event, Unit> {
        public C99482(WidgetSettingsPremium widgetSettingsPremium) {
            super(1, widgetSettingsPremium, WidgetSettingsPremium.class, "handleEvent", "handleEvent(Lcom/discord/widgets/settings/premium/SettingsPremiumViewModel$Event;)V", 0);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(SettingsPremiumViewModel.Event event) {
            invoke2(event);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(SettingsPremiumViewModel.Event event) {
            C12238m.checkNotNullParameter(event, "p1");
            ((WidgetSettingsPremium) this.receiver).handleEvent(event);
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showCancelConfirmationAlert$1 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99491 extends AbstractC12240o implements Function1<View, Unit> {
        public final /* synthetic */ SettingsPremiumViewModel $viewModel;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99491(SettingsPremiumViewModel settingsPremiumViewModel) {
            super(1);
            this.$viewModel = settingsPremiumViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(View view) {
            invoke2(view);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(View view) {
            C12238m.checkNotNullParameter(view, "it");
            this.$viewModel.cancelSubscription();
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$showContent$1 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99501 extends AbstractC12240o implements Function1<Long, Unit> {
        public final /* synthetic */ Integer $scrollTargetSection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99501(Integer num) {
            super(1);
            this.$scrollTargetSection = num;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Long l) {
            invoke2(l);
            return Unit.f27425a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Long l) {
            WidgetSettingsPremium.this.scrollToSection(this.$scrollTargetSection);
        }
    }

    public WidgetSettingsPremium() {
        super(C5419R.layout.widget_settings_premium);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsPremium$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsPremium$viewModel$2 widgetSettingsPremium$viewModel$2 = WidgetSettingsPremium$viewModel$2.INSTANCE;
        C0865g0 c0865g0 = new C0865g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, C12216a0.getOrCreateKotlinClass(SettingsPremiumViewModel.class), new WidgetSettingsPremium$appViewModels$$inlined$viewModels$1(c0865g0), new C0869i0(widgetSettingsPremium$viewModel$2));
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
        LinearLayout linearLayout = getBinding().f18035g;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsCreditContainer");
        linearLayout.setVisibility(i > 0 || i2 > 0 ? 0 : 8);
        View view = getBinding().f18030b.f833d;
        C12238m.checkNotNullExpressionValue(view, "binding.accountCredits.creditNitroDivider");
        view.setVisibility(i > 0 && i2 > 0 ? 0 : 8);
        getBinding().f18030b.f832c.m8605a(SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId(), i, currentSubscription);
        getBinding().f18030b.f831b.m8605a(SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId(), i2, currentSubscription);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x017c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0193  */
    /* JADX WARN: Code duplicated, block: B:107:0x0197  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    private final void configureActiveSubscriptionView(SettingsPremiumViewModel.ViewState.Loaded model) {
        ModelInvoiceItem modelInvoiceItem;
        int size;
        boolean z2;
        Function0<Unit> managePlanCallback;
        ModelSubscription.Status status;
        ModelSubscription.Status status2;
        ModelSubscription.Status status3;
        ModelSubscription.Status status4;
        List<ModelInvoiceItem> invoiceItems;
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
        LinearLayout linearLayout = getBinding().f18045q;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsSubscriptionContainer");
        linearLayout.setVisibility(model.getHasAnyGuildBoosts() || z8 ? 0 : 8);
        ActiveSubscriptionView activeSubscriptionView = getBinding().f18034f;
        C12238m.checkNotNullExpressionValue(activeSubscriptionView, "binding.premiumSettingsActiveSubscription");
        activeSubscriptionView.setVisibility(z8 && currentInvoicePreview != null ? 0 : 8);
        if (z8 && currentInvoicePreview != null) {
            C12238m.checkNotNull(premiumSubscription);
            Iterator<T> it = currentInvoicePreview.getInvoiceItems().iterator();
            do {
                if (!it.hasNext()) {
                    next2 = null;
                    break;
                }
                next2 = it.next();
                ModelInvoiceItem modelInvoiceItem2 = (ModelInvoiceItem) next2;
                if (modelInvoiceItem2.getSubscriptionPlanId() != premiumSubscription.getPremiumBasePlanId()) {
                    long subscriptionPlanId2 = modelInvoiceItem2.getSubscriptionPlanId();
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
            ModelInvoiceItem modelInvoiceItem3 = (ModelInvoiceItem) next2;
            int premiumSubscriptionCount = (googlePlaySkuFromSkuName == null || !GooglePlaySkuKt.isBundledSku(googlePlaySkuFromSkuName)) ? 0 : googlePlaySkuFromSkuName.getPremiumSubscriptionCount();
            CharSequence priceText = getPriceText(premiumSubscription, skuDetails, modelInvoiceItem3);
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
                ActiveSubscriptionView activeSubscriptionView2 = getBinding().f18034f;
                ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeM8520b = ActiveSubscriptionView.m8520b(premiumSubscription);
                ModelSubscription.Status status5 = premiumSubscription.getStatus();
                if (premiumSubscription.getTrialId() != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                activeSubscriptionView2.m8521a(activeSubscriptionTypeM8520b, status5, z5, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), z4);
            }
            function0 = restoreCallback;
            if (zIsGoogleSubscription) {
                z4 = false;
            } else {
                z4 = true;
            }
            ActiveSubscriptionView activeSubscriptionView3 = getBinding().f18034f;
            ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeM8520b2 = ActiveSubscriptionView.m8520b(premiumSubscription);
            ModelSubscription.Status status6 = premiumSubscription.getStatus();
            if (premiumSubscription.getTrialId() != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            activeSubscriptionView3.m8521a(activeSubscriptionTypeM8520b2, status6, z5, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), z4);
        }
        ModelInvoicePreview currentInvoicePreview2 = model.getCurrentInvoicePreview();
        if (currentInvoicePreview2 == null || (invoiceItems = currentInvoicePreview2.getInvoiceItems()) == null) {
            modelInvoiceItem = null;
        } else {
            Iterator<T> it2 = invoiceItems.iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    subscriptionPlanId = ((ModelInvoiceItem) next).getSubscriptionPlanId();
                    guildBoostPlanId = premiumSubscription != null ? premiumSubscription.getGuildBoostPlanId() : null;
                }
            } while (!(guildBoostPlanId != null && subscriptionPlanId == guildBoostPlanId.longValue()));
            modelInvoiceItem = (ModelInvoiceItem) next;
        }
        ActiveSubscriptionView activeSubscriptionView4 = getBinding().f18033e;
        C12238m.checkNotNullExpressionValue(activeSubscriptionView4, "binding.premiumSettingsActiveGuildSubscription");
        activeSubscriptionView4.setVisibility(model.getHasAnyGuildBoosts() && modelInvoiceItem != null ? 0 : 8);
        if (!model.getHasAnyGuildBoosts() || modelInvoiceItem == null) {
            return;
        }
        Map<Long, ModelGuildBoostSlot> guildSubscriptions = model.getGuildSubscriptions();
        if (googlePlaySkuFromSkuName == null || !zIsGoogleSubscription) {
            size = guildSubscriptions.values().size() - (premiumSubscription != null ? PremiumUtils.INSTANCE.getGuildBoostCountFromSubscription(premiumSubscription) : 0);
        } else {
            size = googlePlaySkuFromSkuName.getPremiumSubscriptionCount();
        }
        int i = size;
        CharSequence priceText2 = getPriceText(premiumSubscription, skuDetails, modelInvoiceItem);
        boolean z9 = zIsGoogleSubscription && (premiumSubscription != null ? ActiveSubscriptionView.m8520b(premiumSubscription) : null) == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD;
        ActiveSubscriptionView activeSubscriptionView5 = getBinding().f18033e;
        C12238m.checkNotNullExpressionValue(activeSubscriptionView5, "binding.premiumSettingsActiveGuildSubscription");
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
        ActiveSubscriptionView activeSubscriptionView6 = getBinding().f18033e;
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
        int i2 = ActiveSubscriptionView.f19003j;
        activeSubscriptionView6.m8521a(activeSubscriptionType, status7, false, priceText2, zIsBusy, i, function1, manageGuildBoostCallback, cancelCallback, false);
    }

    private final void configureButtonText(Map<String, ? extends SkuDetails> skuDetails) {
        MaterialButton materialButton = getBinding().f18048t.f667b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.premiumTier1.premiumSettingsPremiumClassic");
        materialButton.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName()) : null));
        MaterialButton materialButton2 = getBinding().f18049u.f706b;
        C12238m.checkNotNullExpressionValue(materialButton2, "binding.premiumTier2.premiumSettingsPremium");
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
            for (final MaterialButton materialButton : C12147n.listOf((Object[]) new MaterialButton[]{getBinding().f18048t.f667b, getBinding().f18049u.f706b})) {
                C12238m.checkNotNullExpressionValue(materialButton, "button");
                materialButton.setEnabled(premiumSubscription == null);
                materialButton.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        WidgetChoosePlan.Companion companion = WidgetChoosePlan.INSTANCE;
                        Context contextRequireContext = this.requireContext();
                        WidgetChoosePlan.ViewType viewType = C12238m.areEqual(materialButton, this.getBinding().f18048t.f667b) ? WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_1 : WidgetChoosePlan.ViewType.BUY_PREMIUM_TIER_2;
                        ModelSubscription modelSubscription = premiumSubscription;
                        companion.launch(contextRequireContext, (34 & 2) != 0 ? null : null, viewType, (34 & 8) != 0 ? null : modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null, new Traits.Location(Traits.Location.Page.USER_SETTINGS, this.getAnalyticsLocationSection(), Traits.Location.Obj.BUTTON_CTA, Traits.Location.ObjType.BUY, null, 16, null), (34 & 32) != 0 ? null : Traits.Subscription.INSTANCE.withGatewayPlanId(C12238m.areEqual(materialButton, this.getBinding().f18048t.f667b) ? GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName() : GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()));
                    }
                });
            }
            return;
        }
        for (MaterialButton materialButton2 : C12147n.listOf((Object[]) new MaterialButton[]{getBinding().f18048t.f667b, getBinding().f18049u.f706b})) {
            C12238m.checkNotNullExpressionValue(materialButton2, "button");
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
        CharSequence charSequenceM213e = null;
        SubscriptionPlanType planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        if (planType != null) {
            int iOrdinal = planType.ordinal();
            if (iOrdinal == 4) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_grandfathered_monthly, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtilsKt.getGRANDFATHERED_MONTHLY_END_DATE())}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else if (iOrdinal == 5) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_grandfathered_yearly, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtilsKt.getGRANDFATHERED_YEARLY_END_DATE())}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            }
        }
        TextView textView = getBinding().f18037i;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumSettingsGrandfathered");
        ViewExtensions.setTextAndVisibilityBy(textView, charSequenceM213e);
    }

    private final void configureLegalese(SettingsPremiumViewModel.ViewState.Loaded model) {
        int i;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        if (premiumSubscription == null || !premiumSubscription.getPlanType().isPremiumSubscription()) {
            TextView textView = getBinding().f18038j;
            C12238m.checkNotNullExpressionValue(textView, "binding.premiumSettingsLegalese");
            textView.setVisibility(8);
            return;
        }
        int iOrdinal = premiumSubscription.getPlanType().getInterval().ordinal();
        if (iOrdinal == 0) {
            i = C5419R.string.billing_payment_premium_terms_legalese_monthly;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = C5419R.string.billing_payment_premium_terms_legalese_yearly;
        }
        Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
        if (googleSubscriptionRenewalPrice == null) {
            googleSubscriptionRenewalPrice = PremiumUtilsKt.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
        }
        TextView textView2 = getBinding().f18038j;
        C12238m.checkNotNullExpressionValue(textView2, "binding.premiumSettingsLegalese");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().f18038j;
        C12238m.checkNotNullExpressionValue(textView3, "binding.premiumSettingsLegalese");
        C1107b.m221m(textView3, i, new Object[]{C1107b.m213e(this, C5419R.string.terms_of_service_url, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.paid_services_terms_url, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.privacy_policy_url, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), googleSubscriptionRenewalPrice}, (4 & 4) != 0 ? C1107b.g.f1495j : null);
        TextView textView4 = getBinding().f18038j;
        C12238m.checkNotNullExpressionValue(textView4, "binding.premiumSettingsLegalese");
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:87:0x0173  */
    private final void configurePaymentInfo(SettingsPremiumViewModel.ViewState.Loaded model) {
        String strRenderUtcDate$default;
        CharSequence charSequenceM213e;
        int pastDueGracePeriodDays;
        int iOrdinal;
        final ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        final boolean zIsAppleSubscription = premiumSubscription != null ? premiumSubscription.isAppleSubscription() : false;
        final boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        ModelSubscription.Status status = premiumSubscription != null ? premiumSubscription.getStatus() : null;
        boolean z2 = status != null && ((iOrdinal = status.ordinal()) == 2 || iOrdinal == 5);
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        Object objM213e = "";
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
        LinearLayout linearLayout = getBinding().f18031c.f1200f;
        C12238m.checkNotNullExpressionValue(linearLayout, "binding.payment.premiumSettingsPaymentContainer");
        linearLayout.setVisibility(premiumSubscription != null ? 0 : 8);
        View view = getBinding().f18031c.f1197c;
        C12238m.checkNotNullExpressionValue(view, "binding.payment.premiumSettingsBillingDivider");
        view.setVisibility(zIsAppleSubscription ? 0 : 8);
        if (premiumSubscription != null) {
            ActiveSubscriptionView.ActiveSubscriptionType activeSubscriptionTypeM8520b = ActiveSubscriptionView.m8520b(premiumSubscription);
            SkuDetails skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId());
            String strM7500a = skuDetails2 != null ? skuDetails2.m7500a() : null;
            if (zIsGoogleSubscription && strM7500a != null) {
                objM213e = strM7500a;
            } else if (activeSubscriptionTypeM8520b == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM) {
                objM213e = C1107b.m213e(this, C5419R.string.premium_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else if (activeSubscriptionTypeM8520b == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_CLASSIC) {
                objM213e = C1107b.m213e(this, C5419R.string.premium_tier_1, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else if (activeSubscriptionTypeM8520b == ActiveSubscriptionView.ActiveSubscriptionType.PREMIUM_GUILD) {
                objM213e = C1107b.m213e(this, C5419R.string.premium_guild_subscription_title, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            }
        }
        if (zIsAppleSubscription) {
            charSequenceM213e = C1107b.m213e(this, C5419R.string.billing_managed_by_apple, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
        } else if (premiumSubscription == null) {
            charSequenceM213e = null;
        } else {
            int iOrdinal3 = premiumSubscription.getStatus().ordinal();
            if (iOrdinal3 == 1) {
                Object[] objArr = new Object[2];
                objArr[0] = strRenderUtcDate$default;
                Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
                if (googleSubscriptionRenewalPrice == null) {
                    googleSubscriptionRenewalPrice = PremiumUtilsKt.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
                }
                objArr[1] = googleSubscriptionRenewalPrice;
                charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_settings_renewal_info, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else if (iOrdinal3 == 2) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_settings_past_due_info, new Object[]{objM213e, strRenderUtcDate$default}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else if (iOrdinal3 == 3) {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_settings_cancelled_info, new Object[]{strRenderUtcDate$default}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            } else if (iOrdinal3 != 5) {
                charSequenceM213e = null;
            } else {
                charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_settings_account_hold_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, premiumSubscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
            }
        }
        TextView textView = getBinding().f18031c.f1198d;
        C12238m.checkNotNullExpressionValue(textView, "binding.payment.premiumSettingsBillingInformation");
        textView.setVisibility(charSequenceM213e != null ? 0 : 8);
        if (charSequenceM213e != null) {
            TextView textView2 = getBinding().f18031c.f1198d;
            C12238m.checkNotNullExpressionValue(textView2, "binding.payment.premiumSettingsBillingInformation");
            textView2.setText(charSequenceM213e);
        }
        MaterialButton materialButton = getBinding().f18031c.f1196b;
        C12238m.checkNotNullExpressionValue(materialButton, "binding.payment.activeSubscriptionsBottomButton");
        ViewExtensions.setTextAndVisibilityBy(materialButton, zIsAppleSubscription ? C1107b.m213e(this, C5419R.string.billing_manage_subscription, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null) : null);
        getBinding().f18031c.f1196b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configurePaymentInfo.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (zIsAppleSubscription) {
                    PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                    C12238m.checkNotNullExpressionValue(view2, "it");
                    Context context = view2.getContext();
                    C12238m.checkNotNullExpressionValue(context, "it.context");
                    premiumUtils.openAppleBilling(context);
                }
            }
        });
        TextView textView3 = getBinding().f18031c.f1199e;
        C12238m.checkNotNullExpressionValue(textView3, "binding.payment.premiumSettingsGooglePlayManage");
        textView3.setVisibility(zIsGoogleSubscription ? 0 : 8);
        getBinding().f18031c.f1199e.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configurePaymentInfo.2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                if (zIsGoogleSubscription) {
                    PremiumUtils premiumUtils = PremiumUtils.INSTANCE;
                    Context contextM885x = C1643a.m885x(view2, "it", "it.context");
                    ModelSubscription modelSubscription = premiumSubscription;
                    premiumUtils.openGooglePlayBilling(contextM885x, modelSubscription != null ? modelSubscription.getPaymentGatewayPlanId() : null);
                }
            }
        });
    }

    private final void configurePriceChangeNotice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        SkuDetails skuDetails = skuDetailsMap != null ? skuDetailsMap.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null;
        String strOptString = skuDetails != null ? skuDetails.f14567b.optString("price_currency_code") : null;
        Map mapMapOf = C12134g0.mapOf(C12116o.m10073to("PLN", Integer.valueOf(C5419R.string.country_name_pl)));
        Objects.requireNonNull(mapMapOf, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        boolean z2 = mapMapOf.containsKey(strOptString) && (subscription == null || subscription.isGoogleSubscription());
        CardView cardView = getBinding().f18039k.f683b;
        C12238m.checkNotNullExpressionValue(cardView, "binding.premiumSettingsPriceChangeNotice.card");
        cardView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            int i = subscription == null ? C5419R.string.localized_pricing_mobile_price_change_notice_no_sub : C5419R.string.localized_pricing_mobile_price_change_notice_has_sub;
            TextView textView = getBinding().f18039k.f684c;
            C12238m.checkNotNullExpressionValue(textView, "binding.premiumSettingsPriceChangeNotice.textview");
            Object[] objArr = new Object[3];
            Integer num = (Integer) mapMapOf.get(strOptString);
            objArr[0] = num != null ? C1107b.m213e(this, num.intValue(), new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null) : null;
            objArr[1] = skuDetails != null ? skuDetails.m7501b() : null;
            objArr[2] = C0862f.f507a.m149a(4407269525911L, null);
            textView.setText(C1107b.m213e(this, i, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null));
            getBinding().f18039k.f684c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configurePriceChangeNotice.2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    UriHandler.handle$default(UriHandler.INSTANCE, C1643a.m821I(WidgetSettingsPremium.this.getBinding().f18039k.f684c, "binding.premiumSettingsPriceChangeNotice.textview", "binding.premiumSettingsP…geNotice.textview.context"), C0862f.f507a.m149a(4407269525911L, null), false, false, null, 28, null);
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
        CharSequence charSequenceM213e;
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
        CardView cardView = getBinding().f18043o;
        C12238m.checkNotNullExpressionValue(cardView, "binding.premiumSettingsStatusNoticeContainer");
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
                planString2 = skuDetails.m7500a();
                C12238m.checkNotNullExpressionValue(planString2, "skuDetails.description");
            }
            charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_pending_plan_change_notice, new Object[]{planString2, strRenderUtcDate$default}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
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
                    if (subscription.hasAnyOfPlans(C12146m0.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
                        break;
                    } else {
                        i++;
                    }
                }
                planString = getPlanString(subscriptionPlanType);
            } else {
                SkuDetails skuDetails2 = skuDetailsMap != null ? skuDetailsMap.get(paymentGatewayPlanId2) : null;
                if (skuDetails2 == null || (planString = skuDetails2.m7500a()) == null) {
                    subscriptionPlanTypeArrValues = SubscriptionPlanType.values();
                    i = 0;
                    while (true) {
                        if (i < 17) {
                            subscriptionPlanType = null;
                            break;
                        }
                        subscriptionPlanType = subscriptionPlanTypeArrValues[i];
                        if (subscription.hasAnyOfPlans(C12146m0.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
                            break;
                            break;
                        }
                        i++;
                    }
                    planString = getPlanString(subscriptionPlanType);
                }
            }
            charSequenceM213e = C1107b.m213e(this, C5419R.string.premium_settings_account_hold_notice_info, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null), planString}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        } else {
            charSequenceM213e = "";
        }
        TextView textView = getBinding().f18044p;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumSettingsStatusNoticeTv");
        textView.setText(charSequenceM213e);
        Button button = getBinding().f18042n;
        C12238m.checkNotNullExpressionValue(button, "binding.premiumSettingsStatusNoticeButton");
        button.setVisibility(zIsAccountHold ? 0 : 8);
        if (zIsAccountHold) {
            Button button2 = getBinding().f18042n;
            C12238m.checkNotNullExpressionValue(button2, "binding.premiumSettingsStatusNoticeButton");
            C1107b.m221m(button2, C5419R.string.f14796x97f0c195, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
            getBinding().f18042n.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.configureStatusNotice.1
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
            return skuDetails3.m7501b();
        }
        if (subscription.getRenewalMutations() != null || skuDetails2 == null) {
            return null;
        }
        return skuDetails2.m7501b();
    }

    private final Companion.SubscriptionViewCallbacks getGuildBoostViewCallbacks(boolean isGoogleGuildBoost, String skuName) {
        if (!isGoogleGuildBoost) {
            return new Companion.SubscriptionViewCallbacks(null, null, null, new C99326(), null);
        }
        return new Companion.SubscriptionViewCallbacks(new C99282(skuName), new C99293(skuName), new C99304(skuName), new C99271(), new C99315(skuName));
    }

    private final CharSequence getPlanString(SubscriptionPlanType planType) {
        if (planType != null) {
            switch (planType.ordinal()) {
                case 6:
                    return C1107b.m213e(this, C5419R.string.premium_plan_month_tier_1, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                case 7:
                    return C1107b.m213e(this, C5419R.string.premium_plan_year_tier_1, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                case 8:
                    return C1107b.m213e(this, C5419R.string.premium_plan_month_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                case 9:
                    return C1107b.m213e(this, C5419R.string.premium_plan_3_month_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                case 10:
                    return C1107b.m213e(this, C5419R.string.premium_plan_6_month_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
                case 11:
                    return C1107b.m213e(this, C5419R.string.premium_plan_year_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
            }
        }
        return "";
    }

    private final Companion.SubscriptionViewCallbacks getPremiumSubscriptionViewCallbacks(ModelSubscription premiumSubscription, boolean canManageGuildBoosts, List<? extends Purchase> purchases) {
        if (!premiumSubscription.isGoogleSubscription()) {
            return premiumSubscription.isAppleSubscription() ? new Companion.SubscriptionViewCallbacks(null, null, null, null, null) : new Companion.SubscriptionViewCallbacks(null, new C99364(), new C99375(), null, null);
        }
        C9938x659539d2 c9938x659539d2 = canManageGuildBoosts ? new C9938x659539d2(this) : null;
        boolean z2 = true;
        if (!(purchases instanceof Collection) || !purchases.isEmpty()) {
            Iterator<T> it = purchases.iterator();
            do {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                }
            } while (!(!((Purchase) it.next()).m7499c()));
        } else {
            z2 = false;
            break;
        }
        return new Companion.SubscriptionViewCallbacks(new C99331(premiumSubscription), z2 ? new C9939x455ad96e(this) : new C9940x455ad96f(this, premiumSubscription), new C99342(premiumSubscription), c9938x659539d2, new C99353(premiumSubscription));
    }

    private final CharSequence getPriceText(SkuDetails skuDetails) {
        return skuDetails != null ? C1107b.m213e(this, C5419R.string.premium_settings_starting_at_per_month, new Object[]{skuDetails.m7501b()}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(this, C5419R.string.stream_premium_upsell_cta, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null);
    }

    private final SettingsPremiumViewModel getViewModel() {
        return (SettingsPremiumViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsPremiumViewModel.Event event) {
        if (event instanceof SettingsPremiumViewModel.Event.ErrorToast) {
            C0876m.m171i(this, ((SettingsPremiumViewModel.Event.ErrorToast) event).getErrorStringResId(), 0, 4);
        }
    }

    private final void scrollToSection(Integer section) {
        int top;
        if (section != null && section.intValue() == 0) {
            C0915a3 c0915a3 = getBinding().f18048t;
            C12238m.checkNotNullExpressionValue(c0915a3, "binding.premiumTier1");
            LinearLayout linearLayout = c0915a3.f666a;
            C12238m.checkNotNullExpressionValue(linearLayout, "binding.premiumTier1.root");
            int top2 = linearLayout.getTop();
            ScrollView scrollView = getBinding().f18041m;
            C12238m.checkNotNullExpressionValue(scrollView, "binding.premiumSettingsScrollview");
            top = scrollView.getHeight() + top2;
        } else if (section != null && section.intValue() == 1) {
            C0923b3 c0923b3 = getBinding().f18049u;
            C12238m.checkNotNullExpressionValue(c0923b3, "binding.premiumTier2");
            LinearLayout linearLayout2 = c0923b3.f705a;
            C12238m.checkNotNullExpressionValue(linearLayout2, "binding.premiumTier2.root");
            top = linearLayout2.getTop();
        } else {
            top = 0;
        }
        getBinding().f18041m.scrollTo(0, top);
    }

    private final void scrollToTop() {
        getBinding().f18041m.scrollTo(0, 0);
    }

    private final void showCancelConfirmationAlert(SettingsPremiumViewModel viewModel) {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, C1107b.m213e(this, C5419R.string.premium_cancel_confirm_header, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.premium_cancel_confirm_body, new Object[]{C0862f.f507a.m149a(360055386693L, null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.premium_cancel_confirm_button, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.nevermind, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C12134g0.mapOf(C12116o.m10073to(Integer.valueOf(C5419R.id.notice_ok), new C99491(viewModel))), null, null, null, Integer.valueOf(C5419R.attr.notice_theme_positive_red), null, null, 0, null, 15808, null);
    }

    private final void showContent(SettingsPremiumViewModel.ViewState.Loaded model) {
        SubscriptionPlanType planType;
        AppViewFlipper appViewFlipper = getBinding().f18047s;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(0);
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Boolean boolValueOf = (premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : Boolean.valueOf(planType.isPremiumSubscription());
        ModelSubscription premiumSubscription2 = model.getPremiumSubscription();
        Boolean boolValueOf2 = premiumSubscription2 != null ? Boolean.valueOf(premiumSubscription2.isNonePlan()) : null;
        Boolean bool = Boolean.FALSE;
        if (C12238m.areEqual(boolValueOf, bool) && C12238m.areEqual(boolValueOf2, bool)) {
            StringBuilder sbM833U = C1643a.m833U("Attempting to open WidgetSettingsPremium with non-Premium ");
            StringBuilder sbM833U2 = C1643a.m833U("and non-Guild Boost subscription: ");
            sbM833U2.append(model.getPremiumSubscription().getId());
            sbM833U.append(sbM833U2.toString());
            String string = sbM833U.toString();
            C12238m.checkNotNullExpressionValue(string, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.e$default(AppLog.f14950g, string, null, null, 6, null);
            FragmentActivity fragmentActivityM95e = m95e();
            if (fragmentActivityM95e != null) {
                fragmentActivityM95e.finish();
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
            Observable<Long> observableM11068d0 = Observable.m11068d0(300L, TimeUnit.MILLISECONDS);
            C12238m.checkNotNullExpressionValue(observableM11068d0, "Observable\n            .…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11068d0, this, null, 2, null), (Class<?>) getClass(), (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99501(numValueOf));
        } catch (Exception e) {
            Logger.e$default(AppLog.f14950g, "Error Scrolling to section", e, null, 4, null);
        }
        getMostRecentIntent().removeExtra(INTENT_SCROLL_TO_SECTION);
    }

    private final void showDesktopManageAlert() {
        WidgetNoticeDialog.Companion companion = WidgetNoticeDialog.INSTANCE;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        C12238m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog.Companion.show$default(companion, parentFragmentManager, C1107b.m213e(this, C5419R.string.billing_manage_subscription, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.premium_manage_via_desktop, new Object[]{C0862f.f507a.m149a(360055386693L, null)}, (4 & 4) != 0 ? C1107b.a.f1490j : null), C1107b.m213e(this, C5419R.string.premium_guild_subscription_header_subscribe_tooltip_close, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().f18047s;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(2);
        getBinding().f18040l.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.settings.premium.WidgetSettingsPremium.showFailureUI.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetSettingsPremium.this.getViewModel().onRetryClicked();
            }
        });
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().f18047s;
        C12238m.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        scrollToTop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        C12238m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(C5419R.string.user_settings);
        setActionBarTitle(C5419R.string.premium_title);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().f18032d.f1439e;
        C12238m.checkNotNullExpressionValue(textView, "binding.premiumPerks.uploadSizePerk");
        textView.setText(C1107b.m212d(view, C5419R.string.premium_perks_upload_size, new Object[0], new C99411()));
        TextView textView2 = getBinding().f18048t.f669d;
        C12238m.checkNotNullExpressionValue(textView2, "binding.premiumTier1.tier1UploadSizePerk");
        textView2.setText(C1107b.m212d(view, C5419R.string.premium_perks_upload_size, new Object[0], new C99422()));
        TextView textView3 = getBinding().f18032d.f1436b;
        C12238m.checkNotNullExpressionValue(textView3, "binding.premiumPerks.guildSubscriptionPerk");
        textView3.setText(C1107b.m212d(view, C5419R.string.premium_perks_tier_2_guild_subscription, new Object[0], C99433.INSTANCE));
        TextView textView4 = getBinding().f18048t.f668c;
        C12238m.checkNotNullExpressionValue(textView4, "binding.premiumTier1.tier1GuildSubscriptionPerk");
        textView4.setText(C1107b.m212d(view, C5419R.string.premium_perks_tier_1_guild_subscription, new Object[0], C99444.INSTANCE));
        NumberFormat numberFormat = NumberFormat.getInstance(this.localeManager.getPrimaryLocale(requireContext()));
        TextView textView5 = getBinding().f18032d.f1437c;
        C12238m.checkNotNullExpressionValue(textView5, "binding.premiumPerks.maxGuildsPerk");
        textView5.setText(C1107b.m212d(view, C5419R.string.premium_perks_tier_2_max_guilds, new Object[0], new C99455(numberFormat)));
        TextView textView6 = getBinding().f18032d.f1438d;
        C12238m.checkNotNullExpressionValue(textView6, "binding.premiumPerks.maxMessageLengthPerk");
        textView6.setText(C1107b.m213e(this, C5419R.string.premium_chat_perks_max_message_length, new Object[0], new C99466(numberFormat)));
        configureButtonText$default(this, null, 1, null);
        for (TextView textView7 : C12147n.listOf((Object[]) new TextView[]{getBinding().f18046r, getBinding().f18036h, getBinding().f18031c.f1201g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            C12238m.checkNotNullExpressionValue(textView7, "header");
            accessibilityUtils.setViewIsHeading(textView7);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsPremiumViewModel.ViewState> observableM11112r = getViewModel().observeViewState().m11111q(200L, TimeUnit.MILLISECONDS).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(observableM11112r, this, null, 2, null), (Class<?>) WidgetSettingsPremium.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99471());
        ObservableExtensionsKt.appSubscribe(ObservableExtensionsKt.ui$default(getViewModel().getEventSubject(), this, null, 2, null), (Class<?>) WidgetSettingsPremium.class, (58 & 2) != 0 ? null : null, (Function1<? super Subscription, Unit>) ((58 & 4) != 0 ? null : null), (Function1<? super Error, Unit>) ((58 & 8) != 0 ? null : null), (Function0<Unit>) ((58 & 16) != 0 ? ObservableExtensionsKt.C68791.INSTANCE : null), (Function0<Unit>) ((58 & 32) != 0 ? ObservableExtensionsKt.C68802.INSTANCE : null), new C99482(this));
    }

    private final CharSequence getPriceText(ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails, ModelInvoiceItem invoiceItem) {
        SubscriptionPlanType planType;
        SkuDetails skuDetails2;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        if (invoiceItem == null || (planType = SubscriptionPlanType.INSTANCE.from(invoiceItem.getSubscriptionPlanId())) == null) {
            planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        }
        boolean zIsMonthlyInterval = planType != null ? planType.isMonthlyInterval() : false;
        int intervalCount = planType != null ? planType.getIntervalCount() : 1;
        int i = C5419R.string.billing_price_per_multi_months;
        if (!zIsMonthlyInterval) {
            i = C5419R.string.billing_price_per_year;
        } else if (intervalCount != 3 && intervalCount != 6) {
            i = C5419R.string.billing_price_per_month;
        }
        String strM7501b = (premiumSubscription == null || (skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId())) == null) ? null : skuDetails2.m7501b();
        if (zIsGoogleSubscription && strM7501b != null) {
            return intervalCount == 1 ? C1107b.m213e(this, i, new Object[]{strM7501b}, (4 & 4) != 0 ? C1107b.a.f1490j : null) : C1107b.m213e(this, i, new Object[]{strM7501b, Integer.valueOf(intervalCount)}, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        }
        if (intervalCount == 1) {
            Object[] objArr = new Object[1];
            objArr[0] = PremiumUtilsKt.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
            return C1107b.m213e(this, i, objArr, (4 & 4) != 0 ? C1107b.a.f1490j : null);
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = PremiumUtilsKt.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
        objArr2[1] = Integer.valueOf(intervalCount);
        return C1107b.m213e(this, i, objArr2, (4 & 4) != 0 ? C1107b.a.f1490j : null);
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$1 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99411 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C99411() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("maxUploadStandard", C1107b.m213e(WidgetSettingsPremium.this, C5419R.string.file_upload_limit_standard, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null).toString());
            renderContext.args.put("maxUploadPremium", C1107b.m213e(WidgetSettingsPremium.this, C5419R.string.file_upload_limit_premium_tier_2, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$2 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99422 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public C99422() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("maxUploadStandard", C1107b.m213e(WidgetSettingsPremium.this, C5419R.string.file_upload_limit_standard, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null).toString());
            renderContext.args.put("maxUploadPremium", C1107b.m213e(WidgetSettingsPremium.this, C5419R.string.file_upload_limit_premium_tier_1, new Object[0], (4 & 4) != 0 ? C1107b.a.f1490j : null).toString());
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$4 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99444 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C99444 INSTANCE = new C99444();

        public C99444() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
            C12238m.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
            map.put("discountPercentage", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$5 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99455 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ NumberFormat $numberFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99455(NumberFormat numberFormat) {
            super(1);
            this.$numberFormat = numberFormat;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$numberFormat.format((Object) 100);
            C12238m.checkNotNullExpressionValue(str, "numberFormat.format(Prem…_NON_PREMIUM_GUILD_COUNT)");
            map.put("nonPremiumMaxGuilds", str);
            Map<String, String> map2 = renderContext.args;
            String str2 = this.$numberFormat.format((Object) 200);
            C12238m.checkNotNullExpressionValue(str2, "numberFormat.format(Prem….MAX_PREMIUM_GUILD_COUNT)");
            map2.put("premiumMaxGuilds", str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$3 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99433 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public static final C99433 INSTANCE = new C99433();

        public C99433() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            renderContext.args.put("numBoosts", String.valueOf(2));
            Map<String, String> map = renderContext.args;
            String str = NumberFormat.getPercentInstance().format(Float.valueOf(0.3f));
            C12238m.checkNotNullExpressionValue(str, "NumberFormat.getPercentI…_DISCOUNT_PERCENT\n      )");
            map.put("discountPercentage", str);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }

    /* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetSettingsPremium$onViewBound$6 */
    /* JADX INFO: compiled from: WidgetSettingsPremium.kt */
    public static final class C99466 extends AbstractC12240o implements Function1<RenderContext, Unit> {
        public final /* synthetic */ NumberFormat $numberFormat;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C99466(NumberFormat numberFormat) {
            super(1);
            this.$numberFormat = numberFormat;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(RenderContext renderContext) {
            C12238m.checkNotNullParameter(renderContext, "$receiver");
            Map<String, String> map = renderContext.args;
            String str = this.$numberFormat.format((Object) 2000);
            C12238m.checkNotNullExpressionValue(str, "numberFormat.format(Send…_MESSAGE_CHARACTER_COUNT)");
            map.put("nonPremiumMaxMessageLength", str);
            Map<String, String> map2 = renderContext.args;
            String str2 = this.$numberFormat.format(Integer.valueOf(SendUtils.MAX_MESSAGE_CHARACTER_COUNT_PREMIUM));
            C12238m.checkNotNullExpressionValue(str2, "numberFormat.format(Send…_CHARACTER_COUNT_PREMIUM)");
            map2.put("premiumMaxMessageLength", str2);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
            invoke2(renderContext);
            return Unit.f27425a;
        }
    }
}
