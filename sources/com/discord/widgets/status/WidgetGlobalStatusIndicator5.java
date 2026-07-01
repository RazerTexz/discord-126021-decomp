package com.discord.widgets.status;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetGlobalStatusIndicator$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetGlobalStatusIndicator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGlobalStatusIndicator5 extends Lambda implements Function0<WidgetGlobalStatusIndicatorViewModel> {
    public static final WidgetGlobalStatusIndicator5 INSTANCE = new WidgetGlobalStatusIndicator5();

    public WidgetGlobalStatusIndicator5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetGlobalStatusIndicatorViewModel invoke() {
        return new WidgetGlobalStatusIndicatorViewModel(null, 1, 0 == true ? 1 : 0);
    }
}
