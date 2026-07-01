package com.discord.widgets.voice.fullscreen;

import com.discord.databinding.WidgetCallFullscreenBinding;
import d0.z.d.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$binding$3 extends k implements Function1<WidgetCallFullscreenBinding, Unit> {
    public WidgetCallFullscreen$binding$3(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetCallFullscreenBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        invoke2(widgetCallFullscreenBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        m.checkNotNullParameter(widgetCallFullscreenBinding, "p1");
        WidgetCallFullscreen.access$onViewBindingDestroy((WidgetCallFullscreen) this.receiver, widgetCallFullscreenBinding);
    }
}
