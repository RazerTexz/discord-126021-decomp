package com.discord.widgets.bugreports;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.bugreport.Feature;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class BugReportViewModel$showFeatureAreas$$inlined$sortedBy$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Feature feature = (Feature) t;
        Feature feature2 = (Feature) t2;
        return a.compareValues(feature.getSquad() + feature.getName(), feature2.getSquad() + feature2.getName());
    }
}
