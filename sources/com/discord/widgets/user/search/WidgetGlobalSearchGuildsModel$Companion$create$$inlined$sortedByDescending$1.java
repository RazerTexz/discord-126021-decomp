package com.discord.widgets.user.search;

import androidx.exifinterface.media.ExifInterface;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchGuildsModel$Companion$create$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Integer.valueOf(((WidgetGlobalSearchGuildsModel$Item) t2).getMentionCount()), Integer.valueOf(((WidgetGlobalSearchGuildsModel$Item) t).getMentionCount()));
    }
}
