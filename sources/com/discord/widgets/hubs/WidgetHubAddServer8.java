package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubAddServer$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubAddServer.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubAddServer8 extends Lambda implements Function0<WidgetHubAddServerViewModel> {
    public static final WidgetHubAddServer8 INSTANCE = new WidgetHubAddServer8();

    public WidgetHubAddServer8() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubAddServerViewModel invoke() {
        return new WidgetHubAddServerViewModel(null, 1, null);
    }
}
