package com.discord.widgets.settings.premium;

import com.discord.utilities.analytics.AnalyticsTracker;
import com.discord.utilities.analytics.Traits$Location;
import com.discord.utilities.analytics.Traits$Subscription;
import com.discord.utilities.billing.GooglePlaySku;
import d0.z.d.o;
import java.security.NoSuchAlgorithmException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChoosePlan.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlan$setUpRecycler$2$2 extends o implements Function0<Unit> {
    public final /* synthetic */ String $oldSkuName;
    public final /* synthetic */ GooglePlaySku $sku;
    public final /* synthetic */ WidgetChoosePlan$setUpRecycler$2 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChoosePlan$setUpRecycler$2$2(WidgetChoosePlan$setUpRecycler$2 widgetChoosePlan$setUpRecycler$2, GooglePlaySku googlePlaySku, String str) {
        super(0);
        this.this$0 = widgetChoosePlan$setUpRecycler$2;
        this.$sku = googlePlaySku;
        this.$oldSkuName = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() throws NoSuchAlgorithmException {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() throws NoSuchAlgorithmException {
        Traits$Location traits$Location = new Traits$Location("Premium Upsell Modal", "Premium Upsell Modal", null, null, null, 28, null);
        AnalyticsTracker.paymentFlowStarted$default(AnalyticsTracker.INSTANCE, traits$Location, Traits$Subscription.Companion.withGatewayPlanId(this.$sku.getUpgrade().getSkuName()), null, null, 12, null);
        WidgetChoosePlan.access$getViewModel$p(this.this$0.this$0).buy(this.$sku.getUpgrade(), this.$oldSkuName, traits$Location, "premium_upsell");
    }
}
