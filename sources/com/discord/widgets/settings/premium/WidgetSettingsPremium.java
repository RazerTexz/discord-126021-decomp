package com.discord.widgets.settings.premium;

import android.content.Context;
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
import b.a.d.f;
import b.a.d.g0;
import b.a.d.i0;
import b.a.i.a3;
import b.a.i.b3;
import b.a.k.b;
import b.d.b.a.a;
import com.android.billingclient.api.Purchase;
import com.android.billingclient.api.SkuDetails;
import com.discord.R$layout;
import com.discord.api.premium.SubscriptionPlan;
import com.discord.app.AppFragment;
import com.discord.app.AppLog;
import com.discord.app.AppViewFlipper;
import com.discord.databinding.WidgetSettingsPremiumBinding;
import com.discord.models.domain.ModelEntitlement;
import com.discord.models.domain.ModelGuildBoostSlot;
import com.discord.models.domain.ModelSubscription;
import com.discord.models.domain.ModelSubscription$Status;
import com.discord.models.domain.ModelSubscription$SubscriptionRenewalMutations;
import com.discord.models.domain.billing.ModelInvoiceItem;
import com.discord.models.domain.billing.ModelInvoicePreview;
import com.discord.models.domain.premium.SubscriptionPlanType;
import com.discord.utilities.accessibility.AccessibilityUtils;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku$Type;
import com.discord.utilities.billing.GooglePlaySkuKt;
import com.discord.utilities.billing.PremiumUtilsKt;
import com.discord.utilities.locale.LocaleManager;
import com.discord.utilities.logging.Logger;
import com.discord.utilities.premium.PremiumUtils;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.utilities.time.TimeUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegate;
import com.discord.utilities.viewbinding.FragmentViewBindingDelegateKt;
import com.discord.views.ActiveSubscriptionView;
import com.discord.views.ActiveSubscriptionView$ActiveSubscriptionType;
import com.discord.widgets.notice.WidgetNoticeDialog;
import com.discord.widgets.notice.WidgetNoticeDialog$Companion;
import com.google.android.material.button.MaterialButton;
import d0.o;
import d0.t.m0;
import d0.t.n;
import d0.z.d.a0;
import d0.z.d.m;
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
import kotlin.reflect.KProperty;
import rx.Observable;

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
    public static final /* synthetic */ KProperty[] $$delegatedProperties = {a.d0(WidgetSettingsPremium.class, "binding", "getBinding()Lcom/discord/databinding/WidgetSettingsPremiumBinding;", 0)};
    public static final WidgetSettingsPremium$Companion Companion = new WidgetSettingsPremium$Companion(null);

    public WidgetSettingsPremium() {
        super(R$layout.widget_settings_premium);
        this.binding = FragmentViewBindingDelegateKt.viewBinding$default(this, WidgetSettingsPremium$binding$2.INSTANCE, null, 2, null);
        WidgetSettingsPremium$viewModel$2 widgetSettingsPremium$viewModel$2 = WidgetSettingsPremium$viewModel$2.INSTANCE;
        g0 g0Var = new g0(this);
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(this, a0.getOrCreateKotlinClass(SettingsPremiumViewModel.class), new WidgetSettingsPremium$appViewModels$$inlined$viewModels$1(g0Var), new i0(widgetSettingsPremium$viewModel$2));
        this.localeManager = new LocaleManager();
    }

    public static final /* synthetic */ String access$getAnalyticsLocationSection$p(WidgetSettingsPremium widgetSettingsPremium) {
        return widgetSettingsPremium.getAnalyticsLocationSection();
    }

    public static final /* synthetic */ WidgetSettingsPremiumBinding access$getBinding$p(WidgetSettingsPremium widgetSettingsPremium) {
        return widgetSettingsPremium.getBinding();
    }

    public static final /* synthetic */ SettingsPremiumViewModel access$getViewModel$p(WidgetSettingsPremium widgetSettingsPremium) {
        return widgetSettingsPremium.getViewModel();
    }

    public static final /* synthetic */ void access$handleEvent(WidgetSettingsPremium widgetSettingsPremium, SettingsPremiumViewModel$Event settingsPremiumViewModel$Event) {
        widgetSettingsPremium.handleEvent(settingsPremiumViewModel$Event);
    }

    public static final /* synthetic */ void access$scrollToSection(WidgetSettingsPremium widgetSettingsPremium, Integer num) {
        widgetSettingsPremium.scrollToSection(num);
    }

    public static final /* synthetic */ void access$showCancelConfirmationAlert(WidgetSettingsPremium widgetSettingsPremium, SettingsPremiumViewModel settingsPremiumViewModel) {
        widgetSettingsPremium.showCancelConfirmationAlert(settingsPremiumViewModel);
    }

    public static final /* synthetic */ void access$showContent(WidgetSettingsPremium widgetSettingsPremium, SettingsPremiumViewModel$ViewState$Loaded settingsPremiumViewModel$ViewState$Loaded) {
        widgetSettingsPremium.showContent(settingsPremiumViewModel$ViewState$Loaded);
    }

    public static final /* synthetic */ void access$showDesktopManageAlert(WidgetSettingsPremium widgetSettingsPremium) {
        widgetSettingsPremium.showDesktopManageAlert();
    }

    public static final /* synthetic */ void access$showFailureUI(WidgetSettingsPremium widgetSettingsPremium) {
        widgetSettingsPremium.showFailureUI();
    }

    public static final /* synthetic */ void access$showLoadingUI(WidgetSettingsPremium widgetSettingsPremium) {
        widgetSettingsPremium.showLoadingUI();
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
        m.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsCreditContainer");
        linearLayout.setVisibility(i > 0 || i2 > 0 ? 0 : 8);
        View view = getBinding().f2633b.d;
        m.checkNotNullExpressionValue(view, "binding.accountCredits.creditNitroDivider");
        view.setVisibility(i > 0 && i2 > 0 ? 0 : 8);
        getBinding().f2633b.c.a(SubscriptionPlanType.PREMIUM_MONTH_TIER_1.getPlanId(), i, currentSubscription);
        getBinding().f2633b.f110b.a(SubscriptionPlanType.PREMIUM_MONTH_TIER_2.getPlanId(), i2, currentSubscription);
    }

    /* JADX WARN: Code duplicated, block: B:103:0x017c  */
    /* JADX WARN: Code duplicated, block: B:106:0x0193  */
    /* JADX WARN: Code duplicated, block: B:107:0x0197  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    private final void configureActiveSubscriptionView(SettingsPremiumViewModel$ViewState$Loaded model) {
        ModelInvoiceItem modelInvoiceItem;
        int size;
        boolean z2;
        Function0<Unit> managePlanCallback;
        ModelSubscription$Status status;
        ModelSubscription$Status modelSubscription$Status;
        ModelSubscription$Status status2;
        ModelSubscription$Status status3;
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
        ModelSubscription$SubscriptionRenewalMutations renewalMutations;
        ModelSubscription$SubscriptionRenewalMutations renewalMutations2;
        ModelSubscription$SubscriptionRenewalMutations renewalMutations3;
        ModelSubscription$SubscriptionRenewalMutations renewalMutations4;
        boolean z6;
        String paymentGatewayPlanId;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview currentInvoicePreview = model.getCurrentInvoicePreview();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        boolean z7 = false;
        boolean z8 = (premiumSubscription == null || premiumSubscription.isNonePlan()) ? false : true;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        GooglePlaySku googlePlaySkuFromSkuName = (premiumSubscription == null || (paymentGatewayPlanId = premiumSubscription.getPaymentGatewayPlanId()) == null) ? null : GooglePlaySku.Companion.fromSkuName(paymentGatewayPlanId);
        LinearLayout linearLayout = getBinding().q;
        m.checkNotNullExpressionValue(linearLayout, "binding.premiumSettingsSubscriptionContainer");
        linearLayout.setVisibility(model.getHasAnyGuildBoosts() || z8 ? 0 : 8);
        ActiveSubscriptionView activeSubscriptionView = getBinding().f;
        m.checkNotNullExpressionValue(activeSubscriptionView, "binding.premiumSettingsActiveSubscription");
        activeSubscriptionView.setVisibility(z8 && currentInvoicePreview != null ? 0 : 8);
        if (z8 && currentInvoicePreview != null) {
            m.checkNotNull(premiumSubscription);
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
                    ModelSubscription$SubscriptionRenewalMutations renewalMutations5 = premiumSubscription.getRenewalMutations();
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
                if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) == GooglePlaySku$Type.PREMIUM_GUILD) {
                    z3 = false;
                } else {
                    if ((googlePlaySkuFromSkuName != null ? googlePlaySkuFromSkuName.getType() : null) != GooglePlaySku$Type.PREMIUM_TIER_1) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                }
            }
            WidgetSettingsPremium$Companion$SubscriptionViewCallbacks premiumSubscriptionViewCallbacks = getPremiumSubscriptionViewCallbacks(premiumSubscription, z3, model.getPurchases());
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
                ActiveSubscriptionView$ActiveSubscriptionType activeSubscriptionView$ActiveSubscriptionTypeB = ActiveSubscriptionView.b(premiumSubscription);
                ModelSubscription$Status status4 = premiumSubscription.getStatus();
                if (premiumSubscription.getTrialId() != null) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                activeSubscriptionView2.a(activeSubscriptionView$ActiveSubscriptionTypeB, status4, z5, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), z4);
            }
            function0 = restoreCallback;
            if (zIsGoogleSubscription) {
                z4 = false;
            } else {
                z4 = true;
            }
            ActiveSubscriptionView activeSubscriptionView3 = getBinding().f;
            ActiveSubscriptionView$ActiveSubscriptionType activeSubscriptionView$ActiveSubscriptionTypeB2 = ActiveSubscriptionView.b(premiumSubscription);
            ModelSubscription$Status status5 = premiumSubscription.getStatus();
            if (premiumSubscription.getTrialId() != null) {
                z5 = true;
            } else {
                z5 = false;
            }
            activeSubscriptionView3.a(activeSubscriptionView$ActiveSubscriptionTypeB2, status5, z5, priceText, model.isBusy(), premiumSubscriptionCount, function0, premiumSubscriptionViewCallbacks.getManageGuildBoostCallback(), premiumSubscriptionViewCallbacks.getCancelCallback(), z4);
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
        ActiveSubscriptionView activeSubscriptionView4 = getBinding().e;
        m.checkNotNullExpressionValue(activeSubscriptionView4, "binding.premiumSettingsActiveGuildSubscription");
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
        boolean z9 = zIsGoogleSubscription && (premiumSubscription != null ? ActiveSubscriptionView.b(premiumSubscription) : null) == ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_GUILD;
        ActiveSubscriptionView activeSubscriptionView5 = getBinding().e;
        m.checkNotNullExpressionValue(activeSubscriptionView5, "binding.premiumSettingsActiveGuildSubscription");
        activeSubscriptionView5.setVisibility(!zIsGoogleSubscription || z9 ? 0 : 8);
        WidgetSettingsPremium$Companion$SubscriptionViewCallbacks guildBoostViewCallbacks = getGuildBoostViewCallbacks(z9, premiumSubscription != null ? premiumSubscription.getPaymentGatewayPlanId() : null);
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
            if ((premiumSubscription == null || (status3 = premiumSubscription.getStatus()) == null) ? false : status3.isCanceled()) {
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
        ActiveSubscriptionView$ActiveSubscriptionType activeSubscriptionView$ActiveSubscriptionType = ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_GUILD;
        if (z2 || z7) {
            modelSubscription$Status = ModelSubscription$Status.CANCELED;
        } else {
            modelSubscription$Status = (premiumSubscription == null || (status2 = premiumSubscription.getStatus()) == null || !status2.isAccountHold()) ? ModelSubscription$Status.ACTIVE : ModelSubscription$Status.ACCOUNT_HOLD;
        }
        ModelSubscription$Status modelSubscription$Status2 = modelSubscription$Status;
        boolean zIsBusy = model.isBusy();
        Function0<Unit> manageGuildBoostCallback = guildBoostViewCallbacks.getManageGuildBoostCallback();
        Function0<Unit> cancelCallback = guildBoostViewCallbacks.getCancelCallback();
        int i2 = ActiveSubscriptionView.j;
        activeSubscriptionView6.a(activeSubscriptionView$ActiveSubscriptionType, modelSubscription$Status2, false, priceText2, zIsBusy, i, function1, manageGuildBoostCallback, cancelCallback, false);
    }

    private final void configureButtonText(Map<String, ? extends SkuDetails> skuDetails) {
        MaterialButton materialButton = getBinding().t.f76b;
        m.checkNotNullExpressionValue(materialButton, "binding.premiumTier1.premiumSettingsPremiumClassic");
        materialButton.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_1_MONTHLY.getSkuName()) : null));
        MaterialButton materialButton2 = getBinding().u.f84b;
        m.checkNotNullExpressionValue(materialButton2, "binding.premiumTier2.premiumSettingsPremium");
        materialButton2.setText(getPriceText(skuDetails != null ? skuDetails.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void configureButtonText$default(WidgetSettingsPremium widgetSettingsPremium, Map map, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        widgetSettingsPremium.configureButtonText(map);
    }

    private final void configureButtons(ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails) {
        configureButtonText(skuDetails);
        if (premiumSubscription == null || !premiumSubscription.isAppleSubscription()) {
            for (MaterialButton materialButton : n.listOf((Object[]) new MaterialButton[]{getBinding().t.f76b, getBinding().u.f84b})) {
                m.checkNotNullExpressionValue(materialButton, "button");
                materialButton.setEnabled(premiumSubscription == null);
                materialButton.setOnClickListener(new WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$2(materialButton, this, premiumSubscription));
            }
            return;
        }
        for (MaterialButton materialButton2 : n.listOf((Object[]) new MaterialButton[]{getBinding().t.f76b, getBinding().u.f84b})) {
            m.checkNotNullExpressionValue(materialButton2, "button");
            ViewExtensions.setEnabledAlpha$default(materialButton2, true, 0.0f, 2, null);
            materialButton2.setOnClickListener(new WidgetSettingsPremium$configureButtons$$inlined$forEach$lambda$1(this));
        }
    }

    private final void configureGrandfatheredHeader(ModelSubscription premiumSubscription) {
        CharSequence charSequenceK = null;
        SubscriptionPlanType planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        if (planType != null) {
            int iOrdinal = planType.ordinal();
            if (iOrdinal == 4) {
                charSequenceK = b.k(this, 2131893999, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtilsKt.getGRANDFATHERED_MONTHLY_END_DATE())}, null, 4);
            } else if (iOrdinal == 5) {
                charSequenceK = b.k(this, 2131894000, new Object[]{DateFormat.getMediumDateFormat(requireContext()).format(PremiumUtilsKt.getGRANDFATHERED_YEARLY_END_DATE())}, null, 4);
            }
        }
        TextView textView = getBinding().i;
        m.checkNotNullExpressionValue(textView, "binding.premiumSettingsGrandfathered");
        ViewExtensions.setTextAndVisibilityBy(textView, charSequenceK);
    }

    private final void configureLegalese(SettingsPremiumViewModel$ViewState$Loaded model) {
        int i;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        if (premiumSubscription == null || !premiumSubscription.getPlanType().isPremiumSubscription()) {
            TextView textView = getBinding().j;
            m.checkNotNullExpressionValue(textView, "binding.premiumSettingsLegalese");
            textView.setVisibility(8);
            return;
        }
        int iOrdinal = premiumSubscription.getPlanType().getInterval().ordinal();
        if (iOrdinal == 0) {
            i = 2131887118;
        } else {
            if (iOrdinal != 1) {
                throw new NoWhenBranchMatchedException();
            }
            i = 2131887120;
        }
        Object googleSubscriptionRenewalPrice = getGoogleSubscriptionRenewalPrice(premiumSubscription, skuDetails);
        if (googleSubscriptionRenewalPrice == null) {
            googleSubscriptionRenewalPrice = PremiumUtilsKt.getFormattedPriceUsd(renewalInvoicePreview != null ? renewalInvoicePreview.getTotal() : 0, requireContext());
        }
        TextView textView2 = getBinding().j;
        m.checkNotNullExpressionValue(textView2, "binding.premiumSettingsLegalese");
        textView2.setVisibility(0);
        TextView textView3 = getBinding().j;
        m.checkNotNullExpressionValue(textView3, "binding.premiumSettingsLegalese");
        b.n(textView3, i, new Object[]{b.k(this, 2131896289, new Object[0], null, 4), b.k(this, 2131893615, new Object[0], null, 4), b.k(this, 2131894539, new Object[0], null, 4), googleSubscriptionRenewalPrice}, null, 4);
        TextView textView4 = getBinding().j;
        m.checkNotNullExpressionValue(textView4, "binding.premiumSettingsLegalese");
        textView4.setMovementMethod(LinkMovementMethod.getInstance());
    }

    /* JADX WARN: Code duplicated, block: B:36:0x0079  */
    /* JADX WARN: Code duplicated, block: B:87:0x0173  */
    private final void configurePaymentInfo(SettingsPremiumViewModel$ViewState$Loaded model) {
        String strRenderUtcDate$default;
        CharSequence charSequenceK;
        int pastDueGracePeriodDays;
        int iOrdinal;
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        ModelInvoicePreview renewalInvoicePreview = model.getRenewalInvoicePreview();
        boolean zIsAppleSubscription = premiumSubscription != null ? premiumSubscription.isAppleSubscription() : false;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        ModelSubscription$Status status = premiumSubscription != null ? premiumSubscription.getStatus() : null;
        boolean z2 = status != null && ((iOrdinal = status.ordinal()) == 2 || iOrdinal == 5);
        Map<String, SkuDetails> skuDetails = model.getSkuDetails();
        Object objK = "";
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
        m.checkNotNullExpressionValue(linearLayout, "binding.payment.premiumSettingsPaymentContainer");
        linearLayout.setVisibility(premiumSubscription != null ? 0 : 8);
        View view = getBinding().c.c;
        m.checkNotNullExpressionValue(view, "binding.payment.premiumSettingsBillingDivider");
        view.setVisibility(zIsAppleSubscription ? 0 : 8);
        if (premiumSubscription != null) {
            ActiveSubscriptionView$ActiveSubscriptionType activeSubscriptionView$ActiveSubscriptionTypeB = ActiveSubscriptionView.b(premiumSubscription);
            SkuDetails skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId());
            String strA = skuDetails2 != null ? skuDetails2.a() : null;
            if (zIsGoogleSubscription && strA != null) {
                objK = strA;
            } else if (activeSubscriptionView$ActiveSubscriptionTypeB == ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM) {
                objK = b.k(this, 2131894444, new Object[0], null, 4);
            } else if (activeSubscriptionView$ActiveSubscriptionTypeB == ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_CLASSIC) {
                objK = b.k(this, 2131894441, new Object[0], null, 4);
            } else if (activeSubscriptionView$ActiveSubscriptionTypeB == ActiveSubscriptionView$ActiveSubscriptionType.PREMIUM_GUILD) {
                objK = b.k(this, 2131894154, new Object[0], null, 4);
            }
        }
        if (zIsAppleSubscription) {
            charSequenceK = b.k(this, 2131887104, new Object[0], null, 4);
        } else if (premiumSubscription == null) {
            charSequenceK = null;
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
                charSequenceK = b.k(this, 2131894350, objArr, null, 4);
            } else if (iOrdinal3 == 2) {
                charSequenceK = b.k(this, 2131894345, new Object[]{objK, strRenderUtcDate$default}, null, 4);
            } else if (iOrdinal3 == 3) {
                charSequenceK = b.k(this, 2131894341, new Object[]{strRenderUtcDate$default}, null, 4);
            } else if (iOrdinal3 != 5) {
                charSequenceK = null;
            } else {
                charSequenceK = b.k(this, 2131894335, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, premiumSubscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null)}, null, 4);
            }
        }
        TextView textView = getBinding().c.d;
        m.checkNotNullExpressionValue(textView, "binding.payment.premiumSettingsBillingInformation");
        textView.setVisibility(charSequenceK != null ? 0 : 8);
        if (charSequenceK != null) {
            TextView textView2 = getBinding().c.d;
            m.checkNotNullExpressionValue(textView2, "binding.payment.premiumSettingsBillingInformation");
            textView2.setText(charSequenceK);
        }
        MaterialButton materialButton = getBinding().c.f195b;
        m.checkNotNullExpressionValue(materialButton, "binding.payment.activeSubscriptionsBottomButton");
        ViewExtensions.setTextAndVisibilityBy(materialButton, zIsAppleSubscription ? b.k(this, 2131887103, new Object[0], null, 4) : null);
        getBinding().c.f195b.setOnClickListener(new WidgetSettingsPremium$configurePaymentInfo$1(zIsAppleSubscription));
        TextView textView3 = getBinding().c.e;
        m.checkNotNullExpressionValue(textView3, "binding.payment.premiumSettingsGooglePlayManage");
        textView3.setVisibility(zIsGoogleSubscription ? 0 : 8);
        getBinding().c.e.setOnClickListener(new WidgetSettingsPremium$configurePaymentInfo$2(zIsGoogleSubscription, premiumSubscription));
    }

    private final void configurePriceChangeNotice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        SkuDetails skuDetails = skuDetailsMap != null ? skuDetailsMap.get(GooglePlaySku.PREMIUM_TIER_2_MONTHLY.getSkuName()) : null;
        String strOptString = skuDetails != null ? skuDetails.f2006b.optString("price_currency_code") : null;
        Map mapMapOf = d0.t.g0.mapOf(o.to("PLN", 2131888127));
        Objects.requireNonNull(mapMapOf, "null cannot be cast to non-null type kotlin.collections.Map<K, *>");
        boolean z2 = mapMapOf.containsKey(strOptString) && (subscription == null || subscription.isGoogleSubscription());
        CardView cardView = getBinding().k.f79b;
        m.checkNotNullExpressionValue(cardView, "binding.premiumSettingsPriceChangeNotice.card");
        cardView.setVisibility(z2 ? 0 : 8);
        if (z2) {
            int i = subscription == null ? 2131892639 : 2131892637;
            TextView textView = getBinding().k.c;
            m.checkNotNullExpressionValue(textView, "binding.premiumSettingsPriceChangeNotice.textview");
            Object[] objArr = new Object[3];
            Integer num = (Integer) mapMapOf.get(strOptString);
            objArr[0] = num != null ? b.k(this, num.intValue(), new Object[0], null, 4) : null;
            objArr[1] = skuDetails != null ? skuDetails.b() : null;
            objArr[2] = f.a.a(4407269525911L, null);
            textView.setText(b.k(this, i, objArr, null, 4));
            getBinding().k.c.setOnClickListener(new WidgetSettingsPremium$configurePriceChangeNotice$2(this));
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0036  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:73:0x010a A[LOOP:1: B:69:0x00f3->B:73:0x010a, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:87:0x010d A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:88:0x010e A[EDGE_INSN: B:88:0x010e->B:75:0x010e BREAK  A[LOOP:1: B:69:0x00f3->B:73:0x010a], SYNTHETIC] */
    private final void configureStatusNotice(ModelSubscription subscription, Map<String, ? extends SkuDetails> skuDetailsMap) {
        boolean z2;
        CharSequence charSequenceK;
        SubscriptionPlanType[] subscriptionPlanTypeArrValues;
        int i;
        SubscriptionPlanType subscriptionPlanType;
        CharSequence planString;
        SubscriptionPlanType subscriptionPlanType2;
        CharSequence planString2;
        String paymentGatewayPlanId;
        ModelSubscription$Status status;
        boolean z3 = (subscription != null ? subscription.getRenewalMutations() : null) != null;
        boolean zIsAccountHold = (subscription == null || (status = subscription.getStatus()) == null) ? false : status.isAccountHold();
        if (z3 || zIsAccountHold) {
            if ((subscription != null ? subscription.getStatus() : null) != ModelSubscription$Status.CANCELED) {
                z2 = true;
            } else {
                z2 = false;
            }
        } else {
            z2 = false;
        }
        CardView cardView = getBinding().o;
        m.checkNotNullExpressionValue(cardView, "binding.premiumSettingsStatusNoticeContainer");
        cardView.setVisibility(z2 ? 0 : 8);
        if (!z2 || subscription == null) {
            return;
        }
        boolean zIsGoogleSubscription = subscription.isGoogleSubscription();
        if (z3) {
            String strRenderUtcDate$default = TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getCurrentPeriodEnd(), requireContext(), (String) null, (java.text.DateFormat) null, 0, 28, (Object) null);
            ModelSubscription$SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
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
                ModelSubscription$SubscriptionRenewalMutations renewalMutations2 = subscription.getRenewalMutations();
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
                m.checkNotNullExpressionValue(planString2, "skuDetails.description");
            }
            charSequenceK = b.k(this, 2131894280, new Object[]{planString2, strRenderUtcDate$default}, null, 4);
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
                    if (subscription.hasAnyOfPlans(m0.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
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
                        if (subscription.hasAnyOfPlans(m0.setOf(Long.valueOf(subscriptionPlanType.getPlanId())))) {
                            break;
                            break;
                        }
                        i++;
                    }
                    planString = getPlanString(subscriptionPlanType);
                }
            }
            charSequenceK = b.k(this, 2131894339, new Object[]{TimeUtils.renderUtcDate$default(TimeUtils.INSTANCE, subscription.getAccountHoldEstimatedExpirationTimestamp(), requireContext(), 0, 4, null), planString}, null, 4);
        } else {
            charSequenceK = "";
        }
        TextView textView = getBinding().p;
        m.checkNotNullExpressionValue(textView, "binding.premiumSettingsStatusNoticeTv");
        textView.setText(charSequenceK);
        Button button = getBinding().n;
        m.checkNotNullExpressionValue(button, "binding.premiumSettingsStatusNoticeButton");
        button.setVisibility(zIsAccountHold ? 0 : 8);
        if (zIsAccountHold) {
            Button button2 = getBinding().n;
            m.checkNotNullExpressionValue(button2, "binding.premiumSettingsStatusNoticeButton");
            b.n(button2, 2131894338, new Object[0], null, 4);
            getBinding().n.setOnClickListener(new WidgetSettingsPremium$configureStatusNotice$1(this, subscription));
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
        ModelSubscription$SubscriptionRenewalMutations renewalMutations = subscription.getRenewalMutations();
        SkuDetails skuDetails3 = skuDetails.get(renewalMutations != null ? renewalMutations.getPaymentGatewayPlanId() : null);
        if (subscription.getRenewalMutations() != null && skuDetails3 != null) {
            return skuDetails3.b();
        }
        if (subscription.getRenewalMutations() != null || skuDetails2 == null) {
            return null;
        }
        return skuDetails2.b();
    }

    private final WidgetSettingsPremium$Companion$SubscriptionViewCallbacks getGuildBoostViewCallbacks(boolean isGoogleGuildBoost, String skuName) {
        if (!isGoogleGuildBoost) {
            return new WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(null, null, null, new WidgetSettingsPremium$getGuildBoostViewCallbacks$6(this), null);
        }
        return new WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(new WidgetSettingsPremium$getGuildBoostViewCallbacks$2(this, skuName), new WidgetSettingsPremium$getGuildBoostViewCallbacks$3(this, skuName), new WidgetSettingsPremium$getGuildBoostViewCallbacks$4(this, skuName), new WidgetSettingsPremium$getGuildBoostViewCallbacks$1(this), new WidgetSettingsPremium$getGuildBoostViewCallbacks$5(this, skuName));
    }

    private final CharSequence getPlanString(SubscriptionPlanType planType) {
        if (planType != null) {
            switch (planType.ordinal()) {
                case 6:
                    return b.k(this, 2131894296, new Object[0], null, 4);
                case 7:
                    return b.k(this, 2131894306, new Object[0], null, 4);
                case 8:
                    return b.k(this, 2131894297, new Object[0], null, 4);
                case 9:
                    return b.k(this, 2131894292, new Object[0], null, 4);
                case 10:
                    return b.k(this, 2131894293, new Object[0], null, 4);
                case 11:
                    return b.k(this, 2131894307, new Object[0], null, 4);
            }
        }
        return "";
    }

    private final WidgetSettingsPremium$Companion$SubscriptionViewCallbacks getPremiumSubscriptionViewCallbacks(ModelSubscription premiumSubscription, boolean canManageGuildBoosts, List<? extends Purchase> purchases) {
        if (!premiumSubscription.isGoogleSubscription()) {
            return premiumSubscription.isAppleSubscription() ? new WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(null, null, null, null, null) : new WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(null, new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$4(this), new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$5(this), null, null);
        }
        WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$manageBundledGuildBoostCallback$1 widgetSettingsPremium$getPremiumSubscriptionViewCallbacks$manageBundledGuildBoostCallback$1 = canManageGuildBoosts ? new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$manageBundledGuildBoostCallback$1(this) : null;
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
        return new WidgetSettingsPremium$Companion$SubscriptionViewCallbacks(new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$1(this, premiumSubscription), z2 ? new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$2(this) : new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$managePlanCallback$3(this, premiumSubscription), new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$2(this, premiumSubscription), widgetSettingsPremium$getPremiumSubscriptionViewCallbacks$manageBundledGuildBoostCallback$1, new WidgetSettingsPremium$getPremiumSubscriptionViewCallbacks$3(this, premiumSubscription));
    }

    private final CharSequence getPriceText(SkuDetails skuDetails) {
        return skuDetails != null ? b.k(this, 2131894352, new Object[]{skuDetails.b()}, null, 4) : b.k(this, 2131896034, new Object[0], null, 4);
    }

    private final SettingsPremiumViewModel getViewModel() {
        return (SettingsPremiumViewModel) this.viewModel.getValue();
    }

    private final void handleEvent(SettingsPremiumViewModel$Event event) {
        if (event instanceof SettingsPremiumViewModel$Event$ErrorToast) {
            b.a.d.m.i(this, ((SettingsPremiumViewModel$Event$ErrorToast) event).getErrorStringResId(), 0, 4);
        }
    }

    private final void scrollToSection(Integer section) {
        int top;
        if (section != null && section.intValue() == 0) {
            a3 a3Var = getBinding().t;
            m.checkNotNullExpressionValue(a3Var, "binding.premiumTier1");
            LinearLayout linearLayout = a3Var.a;
            m.checkNotNullExpressionValue(linearLayout, "binding.premiumTier1.root");
            int top2 = linearLayout.getTop();
            ScrollView scrollView = getBinding().m;
            m.checkNotNullExpressionValue(scrollView, "binding.premiumSettingsScrollview");
            top = scrollView.getHeight() + top2;
        } else if (section != null && section.intValue() == 1) {
            b3 b3Var = getBinding().u;
            m.checkNotNullExpressionValue(b3Var, "binding.premiumTier2");
            LinearLayout linearLayout2 = b3Var.a;
            m.checkNotNullExpressionValue(linearLayout2, "binding.premiumTier2.root");
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
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, b.k(this, 2131893954, new Object[0], null, 4), b.k(this, 2131893946, new Object[]{f.a.a(360055386693L, null)}, null, 4), b.k(this, 2131893953, new Object[0], null, 4), b.k(this, 2131893181, new Object[0], null, 4), d0.t.g0.mapOf(o.to(2131364555, new WidgetSettingsPremium$showCancelConfirmationAlert$1(viewModel))), null, null, null, 2130969885, null, null, 0, null, 15808, null);
    }

    private final void showContent(SettingsPremiumViewModel$ViewState$Loaded model) {
        SubscriptionPlanType planType;
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(0);
        ModelSubscription premiumSubscription = model.getPremiumSubscription();
        Boolean boolValueOf = (premiumSubscription == null || (planType = premiumSubscription.getPlanType()) == null) ? null : Boolean.valueOf(planType.isPremiumSubscription());
        ModelSubscription premiumSubscription2 = model.getPremiumSubscription();
        Boolean boolValueOf2 = premiumSubscription2 != null ? Boolean.valueOf(premiumSubscription2.isNonePlan()) : null;
        Boolean bool = Boolean.FALSE;
        if (m.areEqual(boolValueOf, bool) && m.areEqual(boolValueOf2, bool)) {
            StringBuilder sbU = a.U("Attempting to open WidgetSettingsPremium with non-Premium ");
            StringBuilder sbU2 = a.U("and non-Guild Boost subscription: ");
            sbU2.append(model.getPremiumSubscription().getId());
            sbU.append(sbU2.toString());
            String string = sbU.toString();
            m.checkNotNullExpressionValue(string, "StringBuilder()\n        …}\")\n          .toString()");
            Logger.e$default(AppLog.g, string, null, null, 6, null);
            FragmentActivity activity = getActivity();
            if (activity != null) {
                activity.finish();
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
            m.checkNotNullExpressionValue(observableD0, "Observable\n            .…0, TimeUnit.MILLISECONDS)");
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableD0, this, null, 2, null), getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsPremium$showContent$1(this, numValueOf), 62, (Object) null);
        } catch (Exception e) {
            Logger.e$default(AppLog.g, "Error Scrolling to section", e, null, 4, null);
        }
        getMostRecentIntent().removeExtra(INTENT_SCROLL_TO_SECTION);
    }

    private final void showDesktopManageAlert() {
        WidgetNoticeDialog$Companion widgetNoticeDialog$Companion = WidgetNoticeDialog.Companion;
        FragmentManager parentFragmentManager = getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
        WidgetNoticeDialog$Companion.show$default(widgetNoticeDialog$Companion, parentFragmentManager, b.k(this, 2131887103, new Object[0], null, 4), b.k(this, 2131894216, new Object[]{f.a.a(360055386693L, null)}, null, 4), b.k(this, 2131894111, new Object[0], null, 4), null, null, null, null, null, null, null, null, 0, null, 16368, null);
    }

    private final void showFailureUI() {
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(2);
        getBinding().l.setOnClickListener(new WidgetSettingsPremium$showFailureUI$1(this));
    }

    private final void showLoadingUI() {
        AppViewFlipper appViewFlipper = getBinding().f2634s;
        m.checkNotNullExpressionValue(appViewFlipper, "binding.premiumSettingsViewFlipper");
        appViewFlipper.setDisplayedChild(1);
        scrollToTop();
    }

    @Override // com.discord.app.AppFragment
    public void onViewBound(View view) {
        m.checkNotNullParameter(view, "view");
        super.onViewBound(view);
        setActionBarSubtitle(2131896797);
        setActionBarTitle(2131894450);
        AppFragment.setActionBarDisplayHomeAsUpEnabled$default(this, false, 1, null);
        TextView textView = getBinding().d.e;
        m.checkNotNullExpressionValue(textView, "binding.premiumPerks.uploadSizePerk");
        textView.setText(b.d(view, 2131894291, new Object[0], new WidgetSettingsPremium$onViewBound$1(this)));
        TextView textView2 = getBinding().t.d;
        m.checkNotNullExpressionValue(textView2, "binding.premiumTier1.tier1UploadSizePerk");
        textView2.setText(b.d(view, 2131894291, new Object[0], new WidgetSettingsPremium$onViewBound$2(this)));
        TextView textView3 = getBinding().d.f239b;
        m.checkNotNullExpressionValue(textView3, "binding.premiumPerks.guildSubscriptionPerk");
        textView3.setText(b.d(view, 2131894286, new Object[0], WidgetSettingsPremium$onViewBound$3.INSTANCE));
        TextView textView4 = getBinding().t.c;
        m.checkNotNullExpressionValue(textView4, "binding.premiumTier1.tier1GuildSubscriptionPerk");
        textView4.setText(b.d(view, 2131894282, new Object[0], WidgetSettingsPremium$onViewBound$4.INSTANCE));
        NumberFormat numberFormat = NumberFormat.getInstance(this.localeManager.getPrimaryLocale(requireContext()));
        TextView textView5 = getBinding().d.c;
        m.checkNotNullExpressionValue(textView5, "binding.premiumPerks.maxGuildsPerk");
        textView5.setText(b.d(view, 2131894287, new Object[0], new WidgetSettingsPremium$onViewBound$5(numberFormat)));
        TextView textView6 = getBinding().d.d;
        m.checkNotNullExpressionValue(textView6, "binding.premiumPerks.maxMessageLengthPerk");
        textView6.setText(b.e(this, 2131893979, new Object[0], new WidgetSettingsPremium$onViewBound$6(numberFormat)));
        configureButtonText$default(this, null, 1, null);
        for (TextView textView7 : n.listOf((Object[]) new TextView[]{getBinding().r, getBinding().h, getBinding().c.g})) {
            AccessibilityUtils accessibilityUtils = AccessibilityUtils.INSTANCE;
            m.checkNotNullExpressionValue(textView7, "header");
            accessibilityUtils.setViewIsHeading(textView7);
        }
    }

    @Override // com.discord.app.AppFragment
    public void onViewBoundOrOnResume() {
        super.onViewBoundOrOnResume();
        Observable<SettingsPremiumViewModel$ViewState> observableR = getViewModel().observeViewState().q(200L, TimeUnit.MILLISECONDS).r();
        m.checkNotNullExpressionValue(observableR, "viewModel\n        .obser…  .distinctUntilChanged()");
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(observableR, this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsPremium$onViewBoundOrOnResume$1(this), 62, (Object) null);
        ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.ui$default(getViewModel().getEventSubject(), this, null, 2, null), WidgetSettingsPremium.class, (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new WidgetSettingsPremium$onViewBoundOrOnResume$2(this), 62, (Object) null);
    }

    private final CharSequence getPriceText(ModelSubscription premiumSubscription, Map<String, ? extends SkuDetails> skuDetails, ModelInvoiceItem invoiceItem) {
        SubscriptionPlanType planType;
        SkuDetails skuDetails2;
        boolean zIsGoogleSubscription = premiumSubscription != null ? premiumSubscription.isGoogleSubscription() : false;
        if (invoiceItem == null || (planType = SubscriptionPlanType.Companion.from(invoiceItem.getSubscriptionPlanId())) == null) {
            planType = premiumSubscription != null ? premiumSubscription.getPlanType() : null;
        }
        boolean zIsMonthlyInterval = planType != null ? planType.isMonthlyInterval() : false;
        int intervalCount = planType != null ? planType.getIntervalCount() : 1;
        int i = 2131887148;
        if (!zIsMonthlyInterval) {
            i = 2131887150;
        } else if (intervalCount != 3 && intervalCount != 6) {
            i = 2131887143;
        }
        String strB = (premiumSubscription == null || (skuDetails2 = skuDetails.get(premiumSubscription.getPaymentGatewayPlanId())) == null) ? null : skuDetails2.b();
        if (zIsGoogleSubscription && strB != null) {
            return intervalCount == 1 ? b.k(this, i, new Object[]{strB}, null, 4) : b.k(this, i, new Object[]{strB, Integer.valueOf(intervalCount)}, null, 4);
        }
        if (intervalCount == 1) {
            Object[] objArr = new Object[1];
            objArr[0] = PremiumUtilsKt.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
            return b.k(this, i, objArr, null, 4);
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = PremiumUtilsKt.getFormattedPriceUsd(invoiceItem != null ? invoiceItem.getAmount() : 0, requireContext());
        objArr2[1] = Integer.valueOf(intervalCount);
        return b.k(this, i, objArr2, null, 4);
    }
}
