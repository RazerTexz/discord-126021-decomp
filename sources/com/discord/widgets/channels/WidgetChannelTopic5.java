package com.discord.widgets.channels;

import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$viewModel$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelTopic5 extends Lambda implements Function0<WidgetChannelTopicViewModel> {
    public static final WidgetChannelTopic5 INSTANCE = new WidgetChannelTopic5();

    public WidgetChannelTopic5() {
        super(0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetChannelTopicViewModel invoke() {
        return new WidgetChannelTopicViewModel(null, null, 3, null);
    }
}
