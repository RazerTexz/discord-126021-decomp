package com.discord.utilities.frecency;

import androidx.exifinterface.media.ExifInterface;
import com.discord.utilities.time.ClockFactory;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12163u;
import p507d0.p582u.C12169a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: FrecencyTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class FrecencyTracker<T> {
    private final int maxSamples;
    private final int minScoreThreshold;
    private final HashMap<T, List<Long>> history = new HashMap<>();
    private transient boolean dirty = true;
    private transient List<? extends T> sortedKeys = C12147n.emptyList();

    public FrecencyTracker(int i, int i2) {
        this.minScoreThreshold = i;
        this.maxSamples = i2;
    }

    private final void computeScores(long currentTime) {
        final HashMap map = new HashMap(this.history.size());
        Iterator<Map.Entry<T, List<Long>>> it = this.history.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<T, List<Long>> next = it.next();
            T key = next.getKey();
            int iComputeScore = computeScore(next.getValue(), currentTime);
            if (iComputeScore > this.minScoreThreshold) {
                map.put(key, Integer.valueOf(iComputeScore));
            } else {
                it.remove();
            }
        }
        Set setKeySet = map.keySet();
        C12238m.checkNotNullExpressionValue(setKeySet, "scores.keys");
        this.sortedKeys = C12163u.sortedWith(setKeySet, new Comparator<T>() { // from class: com.discord.utilities.frecency.FrecencyTracker.computeScores.1
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                int iCompareValues;
                Integer num = (Integer) map.get(t);
                Integer num2 = (Integer) map.get(t2);
                if (!C12238m.areEqual(num, num2)) {
                    iCompareValues = C12169a.compareValues(num, num2);
                } else {
                    List list = (List) FrecencyTracker.this.history.get(t);
                    Long l = list != null ? (Long) C12163u.last(list) : null;
                    List list2 = (List) FrecencyTracker.this.history.get(t2);
                    iCompareValues = C12169a.compareValues(l, list2 != null ? (Long) C12163u.last(list2) : null);
                }
                return iCompareValues * (-1);
            }
        });
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
            listEmptyList = C12147n.emptyList();
        }
        this.history.put(key, C12163u.takeLast(C12163u.plus((Collection<? extends Long>) listEmptyList, Long.valueOf(now)), this.maxSamples));
        this.dirty = true;
    }
}
