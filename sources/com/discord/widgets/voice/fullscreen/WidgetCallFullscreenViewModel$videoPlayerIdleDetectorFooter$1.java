package com.discord.widgets.voice.fullscreen;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$videoPlayerIdleDetectorFooter$1 extends AbstractC12240o implements Function1<Boolean, Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$videoPlayerIdleDetectorFooter$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(1);
        this.this$0 = widgetCallFullscreenViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.f27425a;
    }

    public final void invoke(boolean z2) {
        WidgetCallFullscreenViewModel.onIdleStateChanged$default(this.this$0, Boolean.valueOf(z2), null, 2, null);
    }
}
