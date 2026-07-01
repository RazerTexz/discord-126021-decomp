package com.discord.widgets.guild_role_subscriptions;

import androidx.core.os.BundleKt;
import androidx.fragment.app.FragmentKt;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetPriceTierPickerBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetPriceTierPickerBottomSheet$itemClickListener$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetPriceTierPickerBottomSheet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetPriceTierPickerBottomSheet$itemClickListener$1(WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet) {
        super(1);
        this.this$0 = widgetPriceTierPickerBottomSheet;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        String string = WidgetPriceTierPickerBottomSheet.access$getArgumentsOrDefault$p(this.this$0).getString("INTENT_EXTRA_REQUEST_CODE", "");
        WidgetPriceTierPickerBottomSheet widgetPriceTierPickerBottomSheet = this.this$0;
        m.checkNotNullExpressionValue(string, "requestCode");
        FragmentKt.setFragmentResult(widgetPriceTierPickerBottomSheet, string, BundleKt.bundleOf(d0.o.to("RESULT_EXTRA_PRICE_TIER", Integer.valueOf(i))));
        this.this$0.dismiss();
    }
}
