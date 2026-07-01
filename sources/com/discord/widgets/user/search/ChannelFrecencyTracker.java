package com.discord.widgets.user.search;

import com.discord.utilities.frecency.FrecencyTracker;
import d0.z.d.Intrinsics3;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ChannelFrecencyTracker.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ChannelFrecencyTracker extends FrecencyTracker<Long> {
    private final long oldestAllowedDeltaMs;

    public ChannelFrecencyTracker() {
        super(35, 10);
        this.oldestAllowedDeltaMs = TimeUnit.MILLISECONDS.convert(7L, TimeUnit.DAYS);
    }

    @Override // com.discord.utilities.frecency.FrecencyTracker
    public int computeScore(List<Long> list, long j) {
        Intrinsics3.checkNotNullParameter(list, "$this$computeScore");
        Iterator<T> it = list.iterator();
        int iPow = 0;
        while (it.hasNext()) {
            long jLongValue = j - ((Number) it.next()).longValue();
            long j2 = this.oldestAllowedDeltaMs;
            iPow += jLongValue < j2 ? 100 - ((int) Math.pow(0.1d, jLongValue / j2)) : 0;
        }
        return iPow;
    }
}
