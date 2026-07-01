package com.discord.utilities.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.widgets.directories.DirectoryEntryData;
import d0.t._Collections;
import d0.u.a;
import d0.z.d.Intrinsics3;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: com.discord.utilities.directories.DirectoryUtilsKt, reason: use source file name */
/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtils2 {
    private static final int MAXIMUM_SIZE = 200;
    public static final int MAX_HOME_CATEGORY_COUNT = 5;
    public static final int MAX_RECOMMENDATION_COUNT = 5;
    private static final int MINIMUM_MEMBER_COUNT = 5;
    private static final int MINIMUM_SIZE = 5;

    public static final boolean hasMinimumMemberCount(DirectoryEntryGuild directoryEntryGuild) {
        Intrinsics3.checkNotNullParameter(directoryEntryGuild, "$this$hasMinimumMemberCount");
        Integer approximateMemberCount = directoryEntryGuild.getGuild().getApproximateMemberCount();
        return (approximateMemberCount != null ? approximateMemberCount.intValue() : 0) >= 5;
    }

    public static final List<DirectoryEntryData> rank(List<DirectoryEntryData> list, final Integer num) {
        Intrinsics3.checkNotNullParameter(list, "$this$rank");
        return _Collections.sortedWith(list, new Comparator() { // from class: com.discord.utilities.directories.DirectoryUtilsKt$rank$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                DirectoryEntryData directoryEntryData = (DirectoryEntryData) t;
                Integer num2 = num;
                int iIntValue = num2 != null ? num2.intValue() : DirectoryEntryCategory.INSTANCE.findByKey(directoryEntryData.getEntry().getPrimaryCategoryId(), false).getIdealSize();
                Integer approximateMemberCount = directoryEntryData.getEntry().getGuild().getApproximateMemberCount();
                int iIntValue2 = approximateMemberCount != null ? approximateMemberCount.intValue() : 0;
                Integer numValueOf = Integer.valueOf(iIntValue2 >= iIntValue ? (iIntValue2 - iIntValue) / (200 - iIntValue2) : (iIntValue - iIntValue2) / (iIntValue - 5));
                DirectoryEntryData directoryEntryData2 = (DirectoryEntryData) t2;
                Integer num3 = num;
                int iIntValue3 = num3 != null ? num3.intValue() : DirectoryEntryCategory.INSTANCE.findByKey(directoryEntryData2.getEntry().getPrimaryCategoryId(), false).getIdealSize();
                Integer approximateMemberCount2 = directoryEntryData2.getEntry().getGuild().getApproximateMemberCount();
                int iIntValue4 = approximateMemberCount2 != null ? approximateMemberCount2.intValue() : 0;
                return a.compareValues(numValueOf, Integer.valueOf(iIntValue4 >= iIntValue3 ? (iIntValue4 - iIntValue3) / (200 - iIntValue4) : (iIntValue3 - iIntValue4) / (iIntValue3 - 5)));
            }
        });
    }

    public static /* synthetic */ List rank$default(List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return rank(list, num);
    }

    public static final List<DirectoryEntryData> sortByAdded(List<DirectoryEntryData> list) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortByAdded");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DirectoryEntryData directoryEntryData = (DirectoryEntryData) obj;
            if (Intrinsics3.areEqual(directoryEntryData.getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE) && hasMinimumMemberCount(directoryEntryData.getEntry())) {
                arrayList.add(obj);
            }
        }
        return _Collections.take(_Collections.sortedWith(arrayList, new Comparator() { // from class: com.discord.utilities.directories.DirectoryUtilsKt$sortByAdded$$inlined$sortedByDescending$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return a.compareValues(((DirectoryEntryData) t2).getEntry().getCreatedAt(), ((DirectoryEntryData) t).getEntry().getCreatedAt());
            }
        }), 5);
    }

    public static final List<DirectoryEntryData> sortByRanking(List<DirectoryEntryData> list, int i) {
        Intrinsics3.checkNotNullParameter(list, "$this$sortByRanking");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (Intrinsics3.areEqual(((DirectoryEntryData) obj).getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        return _Collections.take(rank$default(arrayList, null, 1, null), i);
    }
}
