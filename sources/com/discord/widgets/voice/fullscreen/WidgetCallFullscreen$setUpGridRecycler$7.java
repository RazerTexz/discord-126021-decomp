package com.discord.widgets.voice.fullscreen;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetCallFullscreen.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetCallFullscreen$setUpGridRecycler$7 implements RecyclerView$OnChildAttachStateChangeListener {
    public final /* synthetic */ WidgetCallFullscreen this$0;

    public WidgetCallFullscreen$setUpGridRecycler$7(WidgetCallFullscreen widgetCallFullscreen) {
        this.this$0 = widgetCallFullscreen;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener
    public void onChildViewAttachedToWindow(View view) {
        m.checkNotNullParameter(view, "view");
        WidgetCallFullscreen.access$setHasVideoCallGridChildrenChanged$p(this.this$0, true);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnChildAttachStateChangeListener
    public void onChildViewDetachedFromWindow(View view) {
        m.checkNotNullParameter(view, "view");
        WidgetCallFullscreen.access$setHasVideoCallGridChildrenChanged$p(this.this$0, true);
    }
}
