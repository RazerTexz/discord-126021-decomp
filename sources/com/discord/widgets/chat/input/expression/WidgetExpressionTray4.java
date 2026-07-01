package com.discord.widgets.chat.input.expression;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.WidgetExpressionTray$expressionTrayViewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetExpressionTray.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetExpressionTray4 extends Lambda implements Function0<ExpressionTrayViewModel> {
    public static final WidgetExpressionTray4 INSTANCE = new WidgetExpressionTray4();

    public WidgetExpressionTray4() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ExpressionTrayViewModel invoke() {
        return new ExpressionTrayViewModel(null, null, null, null, null, null, null, null, 255, null);
    }
}
