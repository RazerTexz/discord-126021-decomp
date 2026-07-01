package com.discord.utilities.frecency;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.time.ClockFactory;
import d0.t.n;
import d0.t.u;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: FrecencyTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FrecencyTracker<T> {
    private final int maxSamples;
    private final int minScoreThreshold;
    private final HashMap<T, List<Long>> history = new HashMap<>();
    private transient boolean dirty = true;
    private transient List<? extends T> sortedKeys = n.emptyList();

    public FrecencyTracker(int i, int i2) {
        this.minScoreThreshold = i;
        this.maxSamples = i2;
    }

    public static final /* synthetic */ HashMap access$getHistory$p(FrecencyTracker frecencyTracker) {
        return frecencyTracker.history;
    }

    private final void computeScores(long currentTime) {
        HashMap map = new HashMap(this.history.size());
        Iterator<Map$Entry<T, List<Long>>> it = this.history.entrySet().iterator();
        while (it.hasNext()) {
            Map$Entry<T, List<Long>> next = it.next();
            T key = next.getKey();
            int iComputeScore = computeScore(next.getValue(), currentTime);
            if (iComputeScore > this.minScoreThreshold) {
                map.put(key, Integer.valueOf(iComputeScore));
            } else {
                it.remove();
            }
        }
        Set setKeySet = map.keySet();
        m.checkNotNullExpressionValue(setKeySet, "scores.keys");
        this.sortedKeys = u.sortedWith(setKeySet, new FrecencyTracker$computeScores$1(this, map));
        this.dirty = false;
    }

    public static /* synthetic */ Collection getSortedKeys$default(FrecencyTracker frecencyTracker, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getSortedKeys");
        }
        if ((i & 1) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        return frecencyTracker.getSortedKeys(j);
    }

    public static /* synthetic */ void track$default(FrecencyTracker frecencyTracker, Object obj, long j, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: track");
        }
        if ((i & 2) != 0) {
            j = ClockFactory.get().currentTimeMillis();
        }
        frecencyTracker.track(obj, j);
    }

    public abstract int computeScore(List<Long> list, long j);

    public final int getMaxSamples() {
        return this.maxSamples;
    }

    public final int getMinScoreThreshold() {
        return this.minScoreThreshold;
    }

    public final synchronized Collection<T> getSortedKeys(long now) {
        if (this.dirty) {
            computeScores(now);
        }
        return this.sortedKeys;
    }

    public final synchronized void removeEntry(T key) {
        this.history.remove(key);
        this.dirty = true;
    }

    public final synchronized void track(T key, long now) {
        List<Long> listEmptyList = this.history.get(key);
        if (listEmptyList == null) {
            listEmptyList = n.emptyList();
        }
        this.history.put(key, u.takeLast(u.plus((Collection<? extends Long>) listEmptyList, Long.valueOf(now)), this.maxSamples));
        this.dirty = true;
    }
}
