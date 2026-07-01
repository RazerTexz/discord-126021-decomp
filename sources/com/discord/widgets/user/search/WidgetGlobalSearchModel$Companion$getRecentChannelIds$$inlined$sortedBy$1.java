package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import d0.u.a;
import java.util.Comparator;
import java.util.Map$Entry;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchModel$Companion$getRecentChannelIds$$inlined$sortedBy$1<T> implements Comparator {
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues((Long) ((Map$Entry) t).getValue(), (Long) ((Map$Entry) t2).getValue());
    }
}
