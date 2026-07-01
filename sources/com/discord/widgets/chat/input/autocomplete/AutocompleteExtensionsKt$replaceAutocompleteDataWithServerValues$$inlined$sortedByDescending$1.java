package com.discord.widgets.chat.input.autocomplete;

import androidx.exifinterface.media.ExifInterface;
import d0.u.a;
import java.util.Comparator;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AutocompleteExtensionsKt$replaceAutocompleteDataWithServerValues$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        return a.compareValues(Integer.valueOf(((IntRange) t2).getFirst()), Integer.valueOf(((IntRange) t).getFirst()));
    }
}
