package com.discord.widgets.channels.memberlist;

import com.discord.utilities.lazy.memberlist.MemberListRow$Member;
import java.util.Comparator;

/* JADX INFO: compiled from: ThreadMemberListItemGenerator.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1<T> implements Comparator<MemberListRow$Member> {
    public static final ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1 INSTANCE = new ThreadMemberListItemGeneratorKt$ALPHABETICAL_COMPARATOR$1();

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(MemberListRow$Member memberListRow$Member, MemberListRow$Member memberListRow$Member2) {
        return memberListRow$Member.getName().compareTo(memberListRow$Member2.getName());
    }

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(MemberListRow$Member memberListRow$Member, MemberListRow$Member memberListRow$Member2) {
        return compare2(memberListRow$Member, memberListRow$Member2);
    }
}
