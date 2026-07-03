package com.discord.widgets.voice.fullscreen;

import android.view.ViewStub;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$eventPromptOverlay$2 extends AbstractC12240o implements Function0<ViewStub> {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$eventPromptOverlay$2(WidgetCallFullscreen widgetCallFullscreen) {
        super(0);
        this.this$0 = widgetCallFullscreen;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final ViewStub invoke() {
        ViewStub viewStub = this.this$0.getBinding().f15775r;
        C12238m.checkNotNullExpressionValue(viewStub, "binding.eventPromptOverlayStub");
        return viewStub;
    }
}
