package com.discord.stores;

import androidx.annotation.VisibleForTesting;
import d0.d0.f;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: StoreGuildSubscriptions.kt */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class StoreGuildSubscriptions$RangeComputer {
    private static final int DEFAULT_CHUNK_SIZE = 100;
    public static final StoreGuildSubscriptions$RangeComputer INSTANCE = new StoreGuildSubscriptions$RangeComputer();

    private StoreGuildSubscriptions$RangeComputer() {
    }

    public static /* synthetic */ List computeRanges$default(StoreGuildSubscriptions$RangeComputer storeGuildSubscriptions$RangeComputer, IntRange intRange, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 100;
        }
        return storeGuildSubscriptions$RangeComputer.computeRanges(intRange, i);
    }

    public final List<IntRange> computeRanges(IntRange range, int chunkSize) {
        m.checkNotNullParameter(range, "range");
        ArrayList arrayList = new ArrayList(3);
        int iInvoke = StoreGuildSubscriptions$RangeComputer$computeRanges$1.INSTANCE.invoke(range.getFirst(), chunkSize);
        if (iInvoke > 0) {
            arrayList.add(f.until(0, chunkSize));
        }
        IntProgression intProgressionStep = f.step(f.until(iInvoke, range.getLast()), chunkSize);
        int first = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if (step < 0 ? first >= last : first <= last) {
            while (true) {
                arrayList.add(f.until(first, first + chunkSize));
                if (first == last) {
                    break;
                }
                first += step;
            }
        }
        return arrayList;
    }
}
