package com.discord.utilities.lazy.memberlist;

import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MemberListRow.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class MemberListRow {
    private final String rowId;

    private MemberListRow(String str) {
        this.rowId = str;
    }

    public String getRowId() {
        return this.rowId;
    }

    public /* synthetic */ MemberListRow(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }
}
