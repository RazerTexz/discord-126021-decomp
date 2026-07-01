package com.discord.widgets.voice.fullscreen;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallPreviewFullscreen$configureUI$4 extends k implements Function0<Unit> {
    public WidgetCallPreviewFullscreen$configureUI$4(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(0, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onDenyNsfw", "onDenyNsfw()V", 0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetCallPreviewFullscreen.access$onDenyNsfw((WidgetCallPreviewFullscreen) this.receiver);
    }
}
