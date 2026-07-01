package com.discord.widgets.forums;

import java.util.Comparator;

/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserItem$Companion$postItemComparatorByMostRecent$2$1<T> implements Comparator<ForumBrowserItem$PostItem> {
    public static final ForumBrowserItem$Companion$postItemComparatorByMostRecent$2$1 INSTANCE = new ForumBrowserItem$Companion$postItemComparatorByMostRecent$2$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(ForumBrowserItem$PostItem forumBrowserItem$PostItem, ForumBrowserItem$PostItem forumBrowserItem$PostItem2) {
        return compare2(forumBrowserItem$PostItem, forumBrowserItem$PostItem2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(ForumBrowserItem$PostItem forumBrowserItem$PostItem, ForumBrowserItem$PostItem forumBrowserItem$PostItem2) {
        Long mostRecentMessageTimestamp = forumBrowserItem$PostItem.getPost().getMostRecentMessageTimestamp();
        Long mostRecentMessageTimestamp2 = forumBrowserItem$PostItem2.getPost().getMostRecentMessageTimestamp();
        if (mostRecentMessageTimestamp == null || mostRecentMessageTimestamp2 == null) {
            if (mostRecentMessageTimestamp != null || mostRecentMessageTimestamp2 == null) {
                return (mostRecentMessageTimestamp == null || mostRecentMessageTimestamp2 != null) ? 0 : -1;
            }
        } else if (mostRecentMessageTimestamp2.longValue() <= mostRecentMessageTimestamp.longValue()) {
            return -1;
        }
        return 1;
    }
}
