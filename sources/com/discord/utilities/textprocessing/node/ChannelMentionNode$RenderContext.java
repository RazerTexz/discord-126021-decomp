package com.discord.utilities.textprocessing.node;

import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChannelMentionNode.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface ChannelMentionNode$RenderContext extends BasicRenderContext {
    Function1<Long, Unit> getChannelMentionOnClick();

    Map<Long, String> getChannelNames();
}
