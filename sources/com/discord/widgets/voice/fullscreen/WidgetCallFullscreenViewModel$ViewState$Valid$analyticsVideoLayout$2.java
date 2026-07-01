package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$ViewState$Valid$analyticsVideoLayout$2 extends o implements Function0<String> {
    public final /* synthetic */ WidgetCallFullscreenViewModel$ViewState$Valid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$ViewState$Valid$analyticsVideoLayout$2(WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid) {
        super(0);
        this.this$0 = widgetCallFullscreenViewModel$ViewState$Valid;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ String invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final String invoke2() {
        if (this.this$0.getDisplayMode() == WidgetCallFullscreenViewModel$DisplayMode.GRID) {
            return this.this$0.getFocusedParticipantKey() != null ? "focus" : "grid";
        }
        return null;
    }
}
