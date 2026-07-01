package com.discord.utilities.message;

import java.util.Comparator;

/* JADX INFO: compiled from: MessageUtils.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageUtils$SORT_BY_IDS_COMPARATOR$1<T> implements Comparator<Long> {
    public static final MessageUtils$SORT_BY_IDS_COMPARATOR$1 INSTANCE = new MessageUtils$SORT_BY_IDS_COMPARATOR$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(Long l, Long l2) {
        return compare2(l, l2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(Long l, Long l2) {
        return MessageUtils.compareMessages(l, l2);
    }
}
