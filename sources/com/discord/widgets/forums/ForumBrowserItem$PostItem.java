package com.discord.widgets.forums;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ForumBrowserItem$PostItem extends ForumBrowserItem {
    private final PostData post;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumBrowserItem$PostItem(PostData postData) {
        super(String.valueOf(postData.getChannel().getId()), 1, null);
        m.checkNotNullParameter(postData, "post");
        this.post = postData;
    }

    public static /* synthetic */ ForumBrowserItem$PostItem copy$default(ForumBrowserItem$PostItem forumBrowserItem$PostItem, PostData postData, int i, Object obj) {
        if ((i & 1) != 0) {
            postData = forumBrowserItem$PostItem.post;
        }
        return forumBrowserItem$PostItem.copy(postData);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final PostData getPost() {
        return this.post;
    }

    public final ForumBrowserItem$PostItem copy(PostData post) {
        m.checkNotNullParameter(post, "post");
        return new ForumBrowserItem$PostItem(post);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof ForumBrowserItem$PostItem) && m.areEqual(this.post, ((ForumBrowserItem$PostItem) other).post);
        }
        return true;
    }

    public final PostData getPost() {
        return this.post;
    }

    public int hashCode() {
        PostData postData = this.post;
        if (postData != null) {
            return postData.hashCode();
        }
        return 0;
    }

    public String toString() {
        StringBuilder sbU = a.U("PostItem(post=");
        sbU.append(this.post);
        sbU.append(")");
        return sbU.toString();
    }
}
