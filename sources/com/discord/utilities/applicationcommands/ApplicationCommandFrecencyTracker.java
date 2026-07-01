package com.discord.utilities.applicationcommands;

import com.discord.utilities.frecency.FrecencyTracker;
import d0.z.d.m;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommandFrecencyTracker.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandFrecencyTracker extends FrecencyTracker<String> {
    public ApplicationCommandFrecencyTracker() {
        this(0, 0, 3, null);
    }

    public ApplicationCommandFrecencyTracker(int i, int i2) {
        super(i2, i);
    }

    private final int getDaysDiff(long earlierTime, long laterTime) {
        return (int) ((laterTime - earlierTime) / 86400000);
    }

    private final int getDaysWeight(int daysDiff) {
        if (daysDiff <= 3) {
            return 100;
        }
        if (daysDiff <= 15) {
            return 70;
        }
        if (daysDiff <= 30) {
            return 50;
        }
        if (daysDiff <= 45) {
            return 30;
        }
        return daysDiff <= 80 ? 10 : 0;
    }

    @Override // com.discord.utilities.frecency.FrecencyTracker
    public int computeScore(List<Long> list, long j) {
        m.checkNotNullParameter(list, "$this$computeScore");
        Iterator<T> it = list.iterator();
        int daysWeight = 0;
        while (it.hasNext()) {
            daysWeight += getDaysWeight(getDaysDiff(((Number) it.next()).longValue(), j));
        }
        return daysWeight;
    }

    public /* synthetic */ ApplicationCommandFrecencyTracker(int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? 10 : i, (i3 & 2) != 0 ? 70 : i2);
    }
}
