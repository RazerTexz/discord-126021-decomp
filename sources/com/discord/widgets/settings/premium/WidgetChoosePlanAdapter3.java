package com.discord.widgets.settings.premium;

import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.billing.GooglePlaySku;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: renamed from: com.discord.widgets.settings.premium.WidgetChoosePlanAdapter$onClickPlan$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter3 extends Lambda implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
    public static final WidgetChoosePlanAdapter3 INSTANCE = new WidgetChoosePlanAdapter3();

    public WidgetChoosePlanAdapter3() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        invoke2(googlePlaySku, str, skuDetails);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        Intrinsics3.checkNotNullParameter(googlePlaySku, "<anonymous parameter 0>");
    }
}
