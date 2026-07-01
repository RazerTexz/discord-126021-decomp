package com.discord.restapi;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: RestAPIParams.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class RestAPIParams$GetForumPostData {
    private final List<Long> threadIds;

    public RestAPIParams$GetForumPostData(List<Long> list) {
        m.checkNotNullParameter(list, "threadIds");
        this.threadIds = list;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RestAPIParams$GetForumPostData copy$default(RestAPIParams$GetForumPostData restAPIParams$GetForumPostData, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            list = restAPIParams$GetForumPostData.threadIds;
        }
        return restAPIParams$GetForumPostData.copy(list);
    }

    public final List<Long> component1() {
        return this.threadIds;
    }

    public final RestAPIParams$GetForumPostData copy(List<Long> threadIds) {
        m.checkNotNullParameter(threadIds, "threadIds");
        return new RestAPIParams$GetForumPostData(threadIds);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof RestAPIParams$GetForumPostData) && m.areEqual(this.threadIds, ((RestAPIParams$GetForumPostData) other).threadIds);
        }
        return true;
    }

    public final List<Long> getThreadIds() {
        return this.threadIds;
    }

    public int hashCode() {
        List<Long> list = this.threadIds;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.L(a.U("GetForumPostData(threadIds="), this.threadIds, ")");
    }
}
