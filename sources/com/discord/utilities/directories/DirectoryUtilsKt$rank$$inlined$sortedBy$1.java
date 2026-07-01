package com.discord.utilities.directories;

import androidx.exifinterface.media.ExifInterface;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.DirectoryEntryData;
import d0.u.a;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtilsKt$rank$$inlined$sortedBy$1<T> implements Comparator {
    public final /* synthetic */ Integer $idealSize$inlined;

    public DirectoryUtilsKt$rank$$inlined$sortedBy$1(Integer num) {
        this.$idealSize$inlined = num;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.Comparator
    public final int compare(T t, T t2) {
        DirectoryEntryData directoryEntryData = (DirectoryEntryData) t;
        Integer num = this.$idealSize$inlined;
        int iIntValue = num != null ? num.intValue() : DirectoryEntryCategory.Companion.findByKey(directoryEntryData.getEntry().getPrimaryCategoryId(), false).getIdealSize();
        Integer approximateMemberCount = directoryEntryData.getEntry().getGuild().getApproximateMemberCount();
        int iIntValue2 = approximateMemberCount != null ? approximateMemberCount.intValue() : 0;
        Integer numValueOf = Integer.valueOf(iIntValue2 >= iIntValue ? (iIntValue2 - iIntValue) / (200 - iIntValue2) : (iIntValue - iIntValue2) / (iIntValue - 5));
        DirectoryEntryData directoryEntryData2 = (DirectoryEntryData) t2;
        Integer num2 = this.$idealSize$inlined;
        int iIntValue3 = num2 != null ? num2.intValue() : DirectoryEntryCategory.Companion.findByKey(directoryEntryData2.getEntry().getPrimaryCategoryId(), false).getIdealSize();
        Integer approximateMemberCount2 = directoryEntryData2.getEntry().getGuild().getApproximateMemberCount();
        int iIntValue4 = approximateMemberCount2 != null ? approximateMemberCount2.intValue() : 0;
        return a.compareValues(numValueOf, Integer.valueOf(iIntValue4 >= iIntValue3 ? (iIntValue4 - iIntValue3) / (200 - iIntValue4) : (iIntValue3 - iIntValue4) / (iIntValue3 - 5)));
    }
}
