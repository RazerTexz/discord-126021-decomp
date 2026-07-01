package com.discord.widgets.hubs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDomains$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDomains.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDomains9 extends Lambda implements Function0<WidgetHubDomainsViewModel> {
    public static final WidgetHubDomains9 INSTANCE = new WidgetHubDomains9();

    public WidgetHubDomains9() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetHubDomainsViewModel invoke() {
        return new WidgetHubDomainsViewModel(null, false, 3, 0 == true ? 1 : 0);
    }
}
