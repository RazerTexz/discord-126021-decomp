package com.discord.widgets.voice.fullscreen;

import com.discord.databinding.WidgetCallFullscreenBinding;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12236k;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallFullscreen$binding$3 extends C12236k implements Function1<WidgetCallFullscreenBinding, Unit> {
    public WidgetCallFullscreen$binding$3(WidgetCallFullscreen widgetCallFullscreen) {
        super(1, widgetCallFullscreen, WidgetCallFullscreen.class, "onViewBindingDestroy", "onViewBindingDestroy(Lcom/discord/databinding/WidgetCallFullscreenBinding;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        invoke2(widgetCallFullscreenBinding);
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetCallFullscreenBinding widgetCallFullscreenBinding) {
        C12238m.checkNotNullParameter(widgetCallFullscreenBinding, "p1");
        ((WidgetCallFullscreen) this.receiver).onViewBindingDestroy(widgetCallFullscreenBinding);
    }
}
