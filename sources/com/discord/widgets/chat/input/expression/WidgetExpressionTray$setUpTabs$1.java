package com.discord.widgets.chat.input.expression;

import android.widget.TextView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray$setUpTabs$1 extends o implements Function1<Integer, Unit> {
    public final /* synthetic */ WidgetExpressionTray this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetExpressionTray$setUpTabs$1(WidgetExpressionTray widgetExpressionTray) {
        super(1);
        this.this$0 = widgetExpressionTray;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
        invoke(num.intValue());
        return Unit.a;
    }

    public final void invoke(int i) {
        ExpressionTrayTab expressionTrayTab = ExpressionTrayTab.values()[i];
        TextView textView = WidgetExpressionTray.access$getBinding$p(this.this$0).j;
        m.checkNotNullExpressionValue(textView, "binding.expressionTraySearchButton");
        textView.setText("");
        if (WidgetExpressionTray.access$getStickerPickerInitialized$p(this.this$0) && WidgetExpressionTray.access$getStickerPickerFragment$p(this.this$0).isVisible()) {
            WidgetExpressionTray.access$getStickerPickerFragment$p(this.this$0).clearSearchInput();
        }
        WidgetExpressionTray.access$getExpressionTrayViewModel$p(this.this$0).selectTab(expressionTrayTab);
        WidgetExpressionTray.access$trackExpressionPickerTabClicked(this.this$0, expressionTrayTab);
    }
}
