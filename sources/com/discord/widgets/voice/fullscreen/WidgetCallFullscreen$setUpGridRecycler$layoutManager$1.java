package com.discord.widgets.voice.fullscreen;

import androidx.recyclerview.widget.RecyclerView;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$layoutManager$1 extends o implements Function0<Integer> {
    public final /* synthetic */ int $layoutManagerOrientation;
    public final /* synthetic */ WidgetCallFullscreen this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetCallFullscreen$setUpGridRecycler$layoutManager$1(WidgetCallFullscreen widgetCallFullscreen, int i) {
        super(0);
        this.this$0 = widgetCallFullscreen;
        this.$layoutManagerOrientation = i;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Integer invoke() {
        return Integer.valueOf(invoke2());
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final int invoke2() {
        int i = this.$layoutManagerOrientation;
        if (i == 0) {
            RecyclerView recyclerView = WidgetCallFullscreen.access$getBinding$p(this.this$0).p;
            m.checkNotNullExpressionValue(recyclerView, "binding.callVideoRecycler");
            return recyclerView.getWidth();
        }
        if (i != 1) {
            throw new IllegalStateException();
        }
        RecyclerView recyclerView2 = WidgetCallFullscreen.access$getBinding$p(this.this$0).p;
        m.checkNotNullExpressionValue(recyclerView2, "binding.callVideoRecycler");
        return recyclerView2.getHeight();
    }
}
