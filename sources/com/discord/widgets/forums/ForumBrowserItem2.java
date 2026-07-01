package com.discord.widgets.forums;

import com.discord.widgets.forums.ForumBrowserItem;
import d0.z.d.Lambda;
import java.util.Comparator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.forums.ForumBrowserItem$Companion$postItemComparatorByMostRecent$2, reason: use source file name */
/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserItem2 extends Lambda implements Function0<Comparator<ForumBrowserItem.PostItem>> {
    public static final ForumBrowserItem2 INSTANCE = new ForumBrowserItem2();

    public ForumBrowserItem2() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public final Comparator<ForumBrowserItem.PostItem> invoke() {
        return new Comparator<ForumBrowserItem.PostItem>() { // from class: com.discord.widgets.forums.ForumBrowserItem$Companion$postItemComparatorByMostRecent$2.1
            @Override // java.util.Comparator
            public final int compare(ForumBrowserItem.PostItem postItem, ForumBrowserItem.PostItem postItem2) {
                Long mostRecentMessageTimestamp = postItem.getPost().getMostRecentMessageTimestamp();
                Long mostRecentMessageTimestamp2 = postItem2.getPost().getMostRecentMessageTimestamp();
                if (mostRecentMessageTimestamp == null || mostRecentMessageTimestamp2 == null) {
                    if (mostRecentMessageTimestamp != null || mostRecentMessageTimestamp2 == null) {
                        return (mostRecentMessageTimestamp == null || mostRecentMessageTimestamp2 != null) ? 0 : -1;
                    }
                } else if (mostRecentMessageTimestamp2.longValue() <= mostRecentMessageTimestamp.longValue()) {
                    return -1;
                }
                return 1;
            }
        };
    }
}
