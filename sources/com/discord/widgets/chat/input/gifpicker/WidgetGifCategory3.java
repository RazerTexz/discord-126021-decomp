package com.discord.widgets.chat.input.gifpicker;

import com.discord.widgets.chat.input.expression.ExpressionTrayViewModel;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.gifpicker.WidgetGifCategory$expressionTrayViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGifCategory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGifCategory3 extends Lambda implements Function0<ExpressionTrayViewModel> {
    public static final WidgetGifCategory3 INSTANCE = new WidgetGifCategory3();

    public WidgetGifCategory3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ExpressionTrayViewModel invoke() {
        return new ExpressionTrayViewModel(null, null, null, null, null, null, null, null, 255, null);
    }
}
