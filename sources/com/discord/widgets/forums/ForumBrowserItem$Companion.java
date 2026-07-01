package com.discord.widgets.forums;

import java.util.Comparator;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ForumBrowserItem$Companion {
    private ForumBrowserItem$Companion() {
    }

    public final Comparator<ForumBrowserItem$PostItem> getPostItemComparatorByMostRecent() {
        Lazy lazyAccess$getPostItemComparatorByMostRecent$cp = ForumBrowserItem.access$getPostItemComparatorByMostRecent$cp();
        ForumBrowserItem$Companion forumBrowserItem$Companion = ForumBrowserItem.Companion;
        return (Comparator) lazyAccess$getPostItemComparatorByMostRecent$cp.getValue();
    }

    public /* synthetic */ ForumBrowserItem$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
