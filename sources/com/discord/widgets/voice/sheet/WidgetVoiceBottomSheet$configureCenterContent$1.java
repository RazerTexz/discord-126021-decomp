package com.discord.widgets.voice.sheet;

import com.discord.utilities.streams.StreamContext;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetVoiceBottomSheet.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetVoiceBottomSheet$configureCenterContent$1 extends k implements Function1<StreamContext, Unit> {
    public WidgetVoiceBottomSheet$configureCenterContent$1(WidgetVoiceBottomSheet widgetVoiceBottomSheet) {
        super(1, widgetVoiceBottomSheet, WidgetVoiceBottomSheet.class, "onStreamPreviewClicked", "onStreamPreviewClicked(Lcom/discord/utilities/streams/StreamContext;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
        invoke2(streamContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamContext streamContext) {
        m.checkNotNullParameter(streamContext, "p1");
        WidgetVoiceBottomSheet.access$onStreamPreviewClicked((WidgetVoiceBottomSheet) this.receiver, streamContext);
    }
}
