package com.discord.utilities.recycler;

import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.discord.utilities.time.Clock;
import com.discord.utilities.time.ClockFactory;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: SpeedOnScrollListener.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SpeedOnScrollListener extends RecyclerView$OnScrollListener {
    public static final SpeedOnScrollListener$Companion Companion = new SpeedOnScrollListener$Companion(null);
    private static final long INIT_TIMESTAMP = -1;
    private final Clock clock;
    private final long maxScrolledPxPerMs;
    private final int orientation;
    private final Function1<Boolean, Unit> thresholdCallback;
    private long timeStamp;

    public SpeedOnScrollListener() {
        this(0L, null, 0, null, 15, null);
    }

    public /* synthetic */ SpeedOnScrollListener(long j, Function1 function1, int i, Clock clock, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? 1L : j, (i2 & 2) != 0 ? SpeedOnScrollListener$1.INSTANCE : function1, (i2 & 4) != 0 ? 1 : i, (i2 & 8) != 0 ? ClockFactory.get() : clock);
    }

    public final Clock getClock() {
        return this.clock;
    }

    public final long getMaxScrolledPxPerMs() {
        return this.maxScrolledPxPerMs;
    }

    public final int getOrientation() {
        return this.orientation;
    }

    public final Function1<Boolean, Unit> getThresholdCallback() {
        return this.thresholdCallback;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        if (newState == 0) {
            this.thresholdCallback.invoke(Boolean.valueOf(0 < this.maxScrolledPxPerMs));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        m.checkNotNullParameter(recyclerView, "recyclerView");
        long jCurrentTimeMillis = this.clock.currentTimeMillis();
        long j = this.timeStamp;
        if (j == -1) {
            this.timeStamp = jCurrentTimeMillis;
            return;
        }
        if (this.orientation == 1) {
            dx = dy;
        }
        float fAbs = Math.abs(dx / (jCurrentTimeMillis - j));
        this.timeStamp = jCurrentTimeMillis;
        this.thresholdCallback.invoke(Boolean.valueOf(fAbs <= ((float) this.maxScrolledPxPerMs)));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SpeedOnScrollListener(long j, Function1<? super Boolean, Unit> function1, int i, Clock clock) {
        m.checkNotNullParameter(function1, "thresholdCallback");
        m.checkNotNullParameter(clock, "clock");
        this.maxScrolledPxPerMs = j;
        this.thresholdCallback = function1;
        this.orientation = i;
        this.clock = clock;
        this.timeStamp = -1L;
    }
}
