package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubEmailFlow$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubEmailFlow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubEmailFlow7 extends Lambda implements Function0<WidgetHubEmailViewModel> {
    public static final WidgetHubEmailFlow7 INSTANCE = new WidgetHubEmailFlow7();

    public WidgetHubEmailFlow7() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubEmailViewModel invoke() {
        return new WidgetHubEmailViewModel(null, false, 3, 0 == true ? 1 : 0);
    }
}
