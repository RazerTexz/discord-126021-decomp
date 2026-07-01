package com.discord.widgets.channels;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.FunctionReferenceImpl;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.channels.WidgetChannelTopic$getRenderedTopicForTopic$renderContext$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelTopic.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChannelTopic4 extends FunctionReferenceImpl implements Function1<SpoilerNode<?>, Unit> {
    public WidgetChannelTopic4(WidgetChannelTopicViewModel widgetChannelTopicViewModel) {
        super(1, widgetChannelTopicViewModel, WidgetChannelTopicViewModel.class, "handleOnIndexClicked", "handleOnIndexClicked(Lcom/discord/utilities/textprocessing/node/SpoilerNode;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        Intrinsics3.checkNotNullParameter(spoilerNode, "p1");
        ((WidgetChannelTopicViewModel) this.receiver).handleOnIndexClicked(spoilerNode);
    }
}
