package com.discord.widgets.channels;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelTopic$getRenderedTopicForTopic$renderContext$2 extends C12236k implements Function1<SpoilerNode<?>, Unit> {
    public WidgetChannelTopic$getRenderedTopicForTopic$renderContext$2(WidgetChannelTopicViewModel widgetChannelTopicViewModel) {
        super(1, widgetChannelTopicViewModel, WidgetChannelTopicViewModel.class, "handleOnIndexClicked", "handleOnIndexClicked(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        C12238m.checkNotNullParameter(spoilerNode, "p1");
        ((WidgetChannelTopicViewModel) this.receiver).handleOnIndexClicked(spoilerNode);
    }
}
