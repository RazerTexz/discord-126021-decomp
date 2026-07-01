package com.discord.widgets.settings.premium;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import b.a.a.b.a;
import b.a.a.b.a$b;
import b.a.a.b.b;
import b.a.a.b.b$b;
import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Subscription;
import com.discord.utilities.billing.GooglePlaySku;
import com.discord.utilities.billing.GooglePlaySku$Type;
import d0.z.d.m;
import d0.z.d.o;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan$setUpRecycler$2 extends o implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
    public final /* synthetic */ Traits$Location $locationTrait;
    public final /* synthetic */ WidgetChoosePlan this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan$setUpRecycler$2(WidgetChoosePlan widgetChoosePlan, Traits$Location traits$Location) {
        super(3);
        this.this$0 = widgetChoosePlan;
        this.$locationTrait = traits$Location;
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) throws NoSuchAlgorithmException {
        invoke2(googlePlaySku, str, skuDetails);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) throws NoSuchAlgorithmException {
        m.checkNotNullParameter(googlePlaySku, "sku");
        if (googlePlaySku.getUpgrade() != null && skuDetails != null && googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_GUILD) {
            AnalyticsTracker.paymentFlowStep$default(AnalyticsTracker.INSTANCE, this.$locationTrait, Traits$Subscription.Companion.withGatewayPlanId(googlePlaySku.getSkuName()), "premium_upsell", "plan_select", null, null, 48, null);
            a$b a_b = a.k;
            FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
            m.checkNotNullExpressionValue(parentFragmentManager, "parentFragmentManager");
            WidgetChoosePlan$setUpRecycler$2$1 widgetChoosePlan$setUpRecycler$2$1 = new WidgetChoosePlan$setUpRecycler$2$1(this, googlePlaySku, str);
            WidgetChoosePlan$setUpRecycler$2$2 widgetChoosePlan$setUpRecycler$2$2 = new WidgetChoosePlan$setUpRecycler$2$2(this, googlePlaySku, str);
            String strB = skuDetails.b();
            m.checkNotNullExpressionValue(strB, "upgradeSkuDetails.price");
            boolean zAreEqual = m.areEqual(googlePlaySku.getSkuName(), str);
            Objects.requireNonNull(a_b);
            m.checkNotNullParameter(parentFragmentManager, "fragmentManager");
            m.checkNotNullParameter(widgetChoosePlan$setUpRecycler$2$1, "onContinueClickListener");
            m.checkNotNullParameter(widgetChoosePlan$setUpRecycler$2$2, "onUpgradeClickListener");
            m.checkNotNullParameter(strB, "upgradePrice");
            a aVar = new a();
            aVar.onContinueClickListener = widgetChoosePlan$setUpRecycler$2$1;
            aVar.onUpgradeClickListener = widgetChoosePlan$setUpRecycler$2$2;
            aVar.upgradePrice = strB;
            aVar.hasBoostPlan = zAreEqual;
            aVar.show(parentFragmentManager, a.class.getSimpleName());
            return;
        }
        if (googlePlaySku.getUpgrade() == null || skuDetails == null) {
            WidgetChoosePlan.access$getViewModel$p(this.this$0).buy(googlePlaySku, str, this.$locationTrait, "plan_select");
            return;
        }
        AnalyticsTracker.paymentFlowStep$default(AnalyticsTracker.INSTANCE, this.$locationTrait, Traits$Subscription.Companion.withGatewayPlanId(googlePlaySku.getSkuName()), "yearly_upsell", "plan_select", null, null, 48, null);
        b$b b_b = b.k;
        FragmentManager parentFragmentManager2 = this.this$0.getParentFragmentManager();
        m.checkNotNullExpressionValue(parentFragmentManager2, "parentFragmentManager");
        WidgetChoosePlan$setUpRecycler$2$3 widgetChoosePlan$setUpRecycler$2$3 = new WidgetChoosePlan$setUpRecycler$2$3(this, googlePlaySku, str);
        WidgetChoosePlan$setUpRecycler$2$4 widgetChoosePlan$setUpRecycler$2$4 = new WidgetChoosePlan$setUpRecycler$2$4(this, googlePlaySku, str);
        WidgetChoosePlan$setUpRecycler$2$5 widgetChoosePlan$setUpRecycler$2$5 = new WidgetChoosePlan$setUpRecycler$2$5(this);
        String strB2 = skuDetails.b();
        m.checkNotNullExpressionValue(strB2, "upgradeSkuDetails.price");
        boolean zAreEqual2 = m.areEqual(googlePlaySku.getSkuName(), str);
        boolean z2 = googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_1 || googlePlaySku.getType() == GooglePlaySku$Type.PREMIUM_TIER_1_AND_PREMIUM_GUILD;
        Objects.requireNonNull(b_b);
        m.checkNotNullParameter(parentFragmentManager2, "fragmentManager");
        m.checkNotNullParameter(widgetChoosePlan$setUpRecycler$2$3, "onMonthlyClickListener");
        m.checkNotNullParameter(widgetChoosePlan$setUpRecycler$2$4, "onYearlyClickListener");
        m.checkNotNullParameter(widgetChoosePlan$setUpRecycler$2$5, "onDismissCallback");
        m.checkNotNullParameter(strB2, "upgradePrice");
        b bVar = new b();
        bVar.onMonthlyClickListener = widgetChoosePlan$setUpRecycler$2$3;
        bVar.onYearlyClickListener = widgetChoosePlan$setUpRecycler$2$4;
        bVar.onDismissCallback = widgetChoosePlan$setUpRecycler$2$5;
        bVar.upgradePrice = strB2;
        bVar.hasMonthlyPlan = zAreEqual2;
        Bundle bundle = new Bundle();
        bundle.putBoolean("ARG_IS_TIER_1", z2);
        bVar.setArguments(bundle);
        bVar.show(parentFragmentManager2, b.class.getSimpleName());
    }
}
