package com.discord.widgets.voice.fullscreen;

import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreenViewModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreenViewModel$moveMeToAudience$1 extends o implements Function0<Unit> {
    public final /* synthetic */ WidgetCallFullscreenViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreenViewModel$moveMeToAudience$1(WidgetCallFullscreenViewModel widgetCallFullscreenViewModel) {
        super(0);
        this.this$0 = widgetCallFullscreenViewModel;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        WidgetCallFullscreenViewModel$ViewState widgetCallFullscreenViewModel$ViewStateAccess$getViewState$p = WidgetCallFullscreenViewModel.access$getViewState$p(this.this$0);
        if (!(widgetCallFullscreenViewModel$ViewStateAccess$getViewState$p instanceof WidgetCallFullscreenViewModel$ViewState$Valid)) {
            widgetCallFullscreenViewModel$ViewStateAccess$getViewState$p = null;
        }
        WidgetCallFullscreenViewModel$ViewState$Valid widgetCallFullscreenViewModel$ViewState$Valid = (WidgetCallFullscreenViewModel$ViewState$Valid) widgetCallFullscreenViewModel$ViewStateAccess$getViewState$p;
        if (widgetCallFullscreenViewModel$ViewState$Valid != null) {
            this.this$0.updateViewState2((WidgetCallFullscreenViewModel$ViewState) WidgetCallFullscreenViewModel$ViewState$Valid.m69copyJ3xfKWQ$default(widgetCallFullscreenViewModel$ViewState$Valid, null, null, null, null, false, false, false, false, null, null, null, null, false, null, null, null, false, false, false, 0.0f, 0, false, null, false, false, 0, false, null, null, null, 0, 0, false, false, null, -16777217, 7, null));
        }
    }
}
