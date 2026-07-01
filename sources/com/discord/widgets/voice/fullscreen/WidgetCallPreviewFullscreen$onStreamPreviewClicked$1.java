package com.discord.widgets.voice.fullscreen;

import com.discord.utilities.streams.StreamContext;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallPreviewFullscreen$onStreamPreviewClicked$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StreamContext $streamContext;
    public final /* synthetic */ WidgetCallPreviewFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallPreviewFullscreen$onStreamPreviewClicked$1(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen, StreamContext streamContext) {
        super(0);
        this.this$0 = widgetCallPreviewFullscreen;
        this.$streamContext = streamContext;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetCallPreviewFullscreen.access$getViewModel$p(this.this$0).onStreamPreviewClicked(this.$streamContext.getStream().getEncodedStreamKey());
    }
}
