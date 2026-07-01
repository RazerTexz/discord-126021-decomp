package com.discord.widgets.voice.fullscreen;

import com.discord.utilities.streams.StreamContext;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureMenu$1$1 extends o implements Function1<StreamContext, Unit> {
    public final /* synthetic */ WidgetCallFullscreen$configureMenu$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureMenu$1$1(WidgetCallFullscreen$configureMenu$1 widgetCallFullscreen$configureMenu$1) {
        super(1);
        this.this$0 = widgetCallFullscreen$configureMenu$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(StreamContext streamContext) {
        invoke2(streamContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(StreamContext streamContext) {
        m.checkNotNullParameter(streamContext, "streamContext");
        WidgetCallFullscreen.access$getViewModel$p(this.this$0.this$0).targetAndFocusStream(streamContext.getStream().getEncodedStreamKey());
    }
}
