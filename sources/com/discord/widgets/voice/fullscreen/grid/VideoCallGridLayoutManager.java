package com.discord.widgets.voice.fullscreen.grid;

import android.content.Context;
import androidx.recyclerview.widget.RecyclerView$State;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: VideoCallGridLayoutManager.kt */
/* JADX INFO: loaded from: classes.dex */
public final class VideoCallGridLayoutManager extends ResizingGridLayoutManager {
    private final Function2<VideoCallGridLayoutManager, RecyclerView$State, Unit> onLayoutCompletedEvent;
    private final Function0<Integer> recyclerviewSizeProvider;
    private final int spanCount;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public VideoCallGridLayoutManager(Function0<Integer> function0, int i, Function2<? super VideoCallGridLayoutManager, ? super RecyclerView$State, Unit> function2, int i2, Context context) {
        super(context, i, i2);
        m.checkNotNullParameter(function0, "recyclerviewSizeProvider");
        m.checkNotNullParameter(context, "context");
        this.recyclerviewSizeProvider = function0;
        this.spanCount = i;
        this.onLayoutCompletedEvent = function2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public void calculateExtraLayoutSpace(RecyclerView$State state, int[] extraLayoutSpace) {
        m.checkNotNullParameter(state, "state");
        m.checkNotNullParameter(extraLayoutSpace, "extraLayoutSpace");
        int iIntValue = this.recyclerviewSizeProvider.invoke().intValue();
        if (iIntValue <= 0) {
            super.calculateExtraLayoutSpace(state, extraLayoutSpace);
            return;
        }
        int i = iIntValue * 3;
        extraLayoutSpace[0] = i;
        extraLayoutSpace[1] = i;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager
    public int getSpanCount() {
        return this.spanCount;
    }

    @Override // androidx.recyclerview.widget.GridLayoutManager, androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView$LayoutManager
    public void onLayoutCompleted(RecyclerView$State state) {
        super.onLayoutCompleted(state);
        Function2<VideoCallGridLayoutManager, RecyclerView$State, Unit> function2 = this.onLayoutCompletedEvent;
        if (function2 != null) {
            function2.invoke(this, state);
        }
    }
}
