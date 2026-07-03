package com.discord.widgets.settings.premium;

import com.android.billingclient.api.SkuDetails;
import com.discord.utilities.billing.GooglePlaySku;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChoosePlanAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChoosePlanAdapter$onClickPlan$1 extends AbstractC12240o implements Function3<GooglePlaySku, String, SkuDetails, Unit> {
    public static final WidgetChoosePlanAdapter$onClickPlan$1 INSTANCE = new WidgetChoosePlanAdapter$onClickPlan$1();

    public WidgetChoosePlanAdapter$onClickPlan$1() {
        super(3);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Unit invoke(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        invoke2(googlePlaySku, str, skuDetails);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GooglePlaySku googlePlaySku, String str, SkuDetails skuDetails) {
        C12238m.checkNotNullParameter(googlePlaySku, "<anonymous parameter 0>");
    }
}
