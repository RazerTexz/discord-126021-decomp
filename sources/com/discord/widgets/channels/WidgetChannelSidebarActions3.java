package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelSidebarActions$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSidebarActions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSidebarActions3 extends Lambda implements Function0<WidgetChannelSidebarActionsViewModel> {
    public static final WidgetChannelSidebarActions3 INSTANCE = new WidgetChannelSidebarActions3();

    public WidgetChannelSidebarActions3() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelSidebarActionsViewModel invoke() {
        return new WidgetChannelSidebarActionsViewModel(null, 1, null);
    }
}
