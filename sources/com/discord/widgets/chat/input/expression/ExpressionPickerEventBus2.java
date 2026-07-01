package com.discord.widgets.chat.input.expression;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.expression.ExpressionPickerEventBus$Companion$INSTANCE$2, reason: use source file name */
/* JADX INFO: compiled from: ExpressionPickerEventBus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ExpressionPickerEventBus2 extends Lambda implements Function0<ExpressionPickerEventBus> {
    public static final ExpressionPickerEventBus2 INSTANCE = new ExpressionPickerEventBus2();

    public ExpressionPickerEventBus2() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ExpressionPickerEventBus invoke() {
        return new ExpressionPickerEventBus();
    }
}
