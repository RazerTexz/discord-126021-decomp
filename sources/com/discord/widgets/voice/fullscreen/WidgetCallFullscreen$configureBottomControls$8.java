package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$configureBottomControls$8 extends o implements Function2<Float, Boolean, Unit> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$configureBottomControls$8(WidgetCallFullscreen widgetCallFullscreen) {
        super(2);
        this.this$0 = widgetCallFullscreen;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(Float f, Boolean bool) {
        invoke(f.floatValue(), bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(float f, boolean z2) {
        WidgetCallFullscreen.access$getViewModel$p(this.this$0).onStreamPerceptualVolumeChanged(f, z2);
    }
}
