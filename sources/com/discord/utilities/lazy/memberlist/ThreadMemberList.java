package com.discord.utilities.lazy.memberlist;

import com.discord.utilities.collections.SparseMutableList;
import d0.z.d.Intrinsics3;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ThreadMemberList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadMemberList implements MemberList {
    private SortedMap<Integer, String> groupIndices;
    private final int initialSize;
    private final String listId;
    private SparseMutableList<MemberListRow> rows;

    public ThreadMemberList(String str, int i) {
        Intrinsics3.checkNotNullParameter(str, "listId");
        this.listId = str;
        this.initialSize = i;
        this.rows = new SparseMutableList<>(getInitialSize(), 100);
        this.groupIndices = new TreeMap();
    }

    public final void add(MemberListRow row) {
        this.rows.add(row);
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public SortedMap<Integer, String> getGroupIndices() {
        return this.groupIndices;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public int getInitialSize() {
        return this.initialSize;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public String getListId() {
        return this.listId;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public SparseMutableList<MemberListRow> getRows() {
        return this.rows;
    }

    @Override // com.discord.utilities.lazy.memberlist.MemberList
    public int getSize() {
        return this.rows.size();
    }

    public /* synthetic */ ThreadMemberList(String str, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? 0 : i);
    }
}
