package com.discord.stores;

import androidx.exifinterface.media.ExifInterface;
import com.discord.api.directory.DirectoryEntryGuild;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreDirectories$fetchDirectoriesForChannel$1$$special$$inlined$sortedByDescending$1<T> implements Comparator {
    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        Integer approximateMemberCount = ((DirectoryEntryGuild) t2).getGuild().getApproximateMemberCount();
        Integer numValueOf = Integer.valueOf(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
        Integer approximateMemberCount2 = ((DirectoryEntryGuild) t).getGuild().getApproximateMemberCount();
        return a.compareValues(numValueOf, Integer.valueOf(approximateMemberCount2 != null ? approximateMemberCount2.intValue() : 0));
    }
}
