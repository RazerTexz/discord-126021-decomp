package com.discord.widgets.hubs;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetRadioSelectorBottomSheet.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetRadioSelectorBottomSheet$adapter$2$1$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetRadioSelectorBottomSheet$adapter$2$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetRadioSelectorBottomSheet$adapter$2$1$1(WidgetRadioSelectorBottomSheet$adapter$2$1 widgetRadioSelectorBottomSheet$adapter$2$1) {
        super(1);
        this.this$0 = widgetRadioSelectorBottomSheet$adapter$2$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        Function1<Integer, Unit> onSelected = this.this$0.this$0.this$0.getOnSelected();
        if (onSelected != null) {
            onSelected.invoke(Integer.valueOf(i));
        }
        this.this$0.this$0.this$0.dismiss();
    }
}
