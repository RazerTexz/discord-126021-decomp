package com.discord.widgets.status;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.status.WidgetThreadStatus$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetThreadStatus.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetThreadStatus3 extends Lambda implements Function0<WidgetThreadStatusViewModel> {
    public static final WidgetThreadStatus3 INSTANCE = new WidgetThreadStatus3();

    public WidgetThreadStatus3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetThreadStatusViewModel invoke() {
        return new WidgetThreadStatusViewModel(null, 1, null);
    }
}
