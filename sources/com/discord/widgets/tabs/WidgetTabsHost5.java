package com.discord.widgets.tabs;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.tabs.WidgetTabsHost$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetTabsHost.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetTabsHost5 extends Lambda implements Function0<TabsHostViewModel> {
    public static final WidgetTabsHost5 INSTANCE = new WidgetTabsHost5();

    public WidgetTabsHost5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final TabsHostViewModel invoke() {
        return new TabsHostViewModel(null, null, null, null, 15, null);
    }
}
