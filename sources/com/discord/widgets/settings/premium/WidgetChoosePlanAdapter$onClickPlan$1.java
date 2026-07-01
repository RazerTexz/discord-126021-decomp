package com.discord.widgets.settings.premium;

import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.billing.GooglePlaySku;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$onClickPlan$1 extends o implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
    public static final WidgetChoosePlanAdapter$onClickPlan$1 INSTANCE = new WidgetChoosePlanAdapter$onClickPlan$1();

    public WidgetChoosePlanAdapter$onClickPlan$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        invoke2(googlePlaySku, str, skuDetails);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        m.checkNotNullParameter(googlePlaySku, "<anonymous parameter 0>");
    }
}
