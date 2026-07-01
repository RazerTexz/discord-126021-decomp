package com.discord.utilities.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.widgets.directories.DirectoryEntryData;
import d0.t.u;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: DirectoryUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryUtilsKt {
    private static final int MAXIMUM_SIZE = 200;
    public static final int MAX_HOME_CATEGORY_COUNT = 5;
    public static final int MAX_RECOMMENDATION_COUNT = 5;
    private static final int MINIMUM_MEMBER_COUNT = 5;
    private static final int MINIMUM_SIZE = 5;

    public static final boolean hasMinimumMemberCount(DirectoryEntryGuild directoryEntryGuild) {
        m.checkNotNullParameter(directoryEntryGuild, "$this$hasMinimumMemberCount");
        Integer approximateMemberCount = directoryEntryGuild.getGuild().getApproximateMemberCount();
        return (approximateMemberCount != null ? approximateMemberCount.intValue() : 0) >= 5;
    }

    public static final List<DirectoryEntryData> rank(List<DirectoryEntryData> list, Integer num) {
        m.checkNotNullParameter(list, "$this$rank");
        return u.sortedWith(list, new DirectoryUtilsKt$rank$$inlined$sortedBy$1(num));
    }

    public static /* synthetic */ List rank$default(List list, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        return rank(list, num);
    }

    public static final List<DirectoryEntryData> sortByAdded(List<DirectoryEntryData> list) {
        m.checkNotNullParameter(list, "$this$sortByAdded");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            DirectoryEntryData directoryEntryData = (DirectoryEntryData) obj;
            if (m.areEqual(directoryEntryData.getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE) && hasMinimumMemberCount(directoryEntryData.getEntry())) {
                arrayList.add(obj);
            }
        }
        return u.take(u.sortedWith(arrayList, new DirectoryUtilsKt$sortByAdded$$inlined$sortedByDescending$1()), 5);
    }

    public static final List<DirectoryEntryData> sortByRanking(List<DirectoryEntryData> list, int i) {
        m.checkNotNullParameter(list, "$this$sortByRanking");
        ArrayList arrayList = new ArrayList();
        for (Object obj : list) {
            if (m.areEqual(((DirectoryEntryData) obj).getEntry().getGuild().getFeaturableInDirectory(), Boolean.TRUE)) {
                arrayList.add(obj);
            }
        }
        return u.take(rank$default(arrayList, null, 1, null), i);
    }
}
