package com.discord.widgets.voice.fullscreen;

import d0.z.d.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetCallPreviewFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class WidgetCallPreviewFullscreen$configureUI$3 extends k implements Function1<Boolean, Unit> {
    public WidgetCallPreviewFullscreen$configureUI$3(WidgetCallPreviewFullscreen widgetCallPreviewFullscreen) {
        super(1, widgetCallPreviewFullscreen, WidgetCallPreviewFullscreen.class, "onNsfwToggle", "onNsfwToggle(Z)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
        invoke(bool.booleanValue());
        return Unit.a;
    }

    public final void invoke(boolean z2) {
        WidgetCallPreviewFullscreen.access$onNsfwToggle((WidgetCallPreviewFullscreen) this.receiver, z2);
    }
}
