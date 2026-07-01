package com.discord.widgets.chat.input.expression;

import com.discord.widgets.chat.input.gifpicker.GifCategoryItem;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetExpressionTray$setUpGifPicker$1 extends k implements Function1<GifCategoryItem, Unit> {
    public WidgetExpressionTray$setUpGifPicker$1(ExpressionTrayViewModel expressionTrayViewModel) {
        super(1, expressionTrayViewModel, ExpressionTrayViewModel.class, "selectGifCategory", "selectGifCategory(Lcom/discord/widgets/chat/input/gifpicker/GifCategoryItem;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(GifCategoryItem gifCategoryItem) {
        invoke2(gifCategoryItem);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(GifCategoryItem gifCategoryItem) {
        m.checkNotNullParameter(gifCategoryItem, "p1");
        ((ExpressionTrayViewModel) this.receiver).selectGifCategory(gifCategoryItem);
    }
}
