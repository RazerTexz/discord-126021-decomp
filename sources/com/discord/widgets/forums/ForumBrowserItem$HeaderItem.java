package com.discord.widgets.forums;

import b.d.b.a.a;

/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ForumBrowserItem$HeaderItem extends ForumBrowserItem {
    private final int stringResId;

    public ForumBrowserItem$HeaderItem(int i) {
        super(String.valueOf(i), 0, null);
        this.stringResId = i;
    }

    public static /* synthetic */ ForumBrowserItem$HeaderItem copy$default(ForumBrowserItem$HeaderItem forumBrowserItem$HeaderItem, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = forumBrowserItem$HeaderItem.stringResId;
        }
        return forumBrowserItem$HeaderItem.copy(i);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getStringResId() {
        return this.stringResId;
    }

    public final ForumBrowserItem$HeaderItem copy(int stringResId) {
        return new ForumBrowserItem$HeaderItem(stringResId);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumBrowserItem$HeaderItem) && this.stringResId == ((ForumBrowserItem$HeaderItem) other).stringResId;
        }
        return true;
    }

    public final int getStringResId() {
        return this.stringResId;
    }

    public int hashCode() {
        return this.stringResId;
    }

    public String toString() {
        return a.B(a.U("HeaderItem(stringResId="), this.stringResId, ")");
    }
}
