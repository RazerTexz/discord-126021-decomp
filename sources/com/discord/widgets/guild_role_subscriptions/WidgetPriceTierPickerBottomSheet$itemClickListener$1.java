package com.discord.widgets.guild_role_subscriptions;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.C12116o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet$itemClickListener$1 extends AbstractC12240o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetPriceTierPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPriceTierPickerBottomSheet$itemClickListener$1(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        super(1);
        this.this$0 = widgetPriceTierPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.f27425a;
    }

    public final void invoke(int i) {
        String string = this.this$0.getArgumentsOrDefault().getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = this.this$0;
        C12238m.checkNotNullExpressionValue(string, "requestCode");
        FragmentKt.setFragmentResult(widgetPriceTierPickerBottomSheet, string, BundleKt.bundleOf(C12116o.m10073to("RESULT_EXTRA_PRICE_TIER", Integer.valueOf(i))));
        this.this$0.dismiss();
    }
}
