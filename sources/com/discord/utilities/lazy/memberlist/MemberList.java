package com.discord.utilities.lazy.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import java.util.SortedMap;

/* JADX INFO: compiled from: MemberList.kt */
/* JADX INFO: loaded from: classes2.dex */
public interface MemberList {
    SortedMap<Integer, String> getGroupIndices();

    int getInitialSize();

    String getListId();

    SparseMutableList<MemberListRow> getRows();

    int getSize();
}
