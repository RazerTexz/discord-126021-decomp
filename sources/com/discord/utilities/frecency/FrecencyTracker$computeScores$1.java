package com.discord.utilities.frecency;

import androidx.exifinterface.media.ExifInterface;
import d0.t.u;
import d0.u.a;
import d0.z.d.m;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: FrecencyTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class FrecencyTracker$computeScores$1<T> implements Comparator<T> {
    public final /* synthetic */ HashMap $scores;
    public final /* synthetic */ FrecencyTracker this$0;

    public FrecencyTracker$computeScores$1(FrecencyTracker frecencyTracker, HashMap map) {
        this.this$0 = frecencyTracker;
        this.$scores = map;
    }

    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        int iCompareValues;
        Integer num = (Integer) this.$scores.get(t);
        Integer num2 = (Integer) this.$scores.get(t2);
        if (!m.areEqual(num, num2)) {
            iCompareValues = a.compareValues(num, num2);
        } else {
            List list = (List) FrecencyTracker.access$getHistory$p(this.this$0).get(t);
            Long l = list != null ? (Long) u.last(list) : null;
            List list2 = (List) FrecencyTracker.access$getHistory$p(this.this$0).get(t2);
            iCompareValues = a.compareValues(l, list2 != null ? (Long) u.last(list2) : null);
        }
        return iCompareValues * (-1);
    }
}
