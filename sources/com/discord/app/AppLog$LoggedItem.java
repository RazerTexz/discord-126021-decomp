package com.discord.app;

import b.d.b.a.a;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import java.util.UUID;

/* JADX INFO: compiled from: AppLog.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class AppLog$LoggedItem implements MGRecyclerDataPayload {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final String key;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public final int priority;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final String message;

    /* JADX INFO: renamed from: m, reason: from kotlin metadata */
    public final Throwable throwable;

    public AppLog$LoggedItem(int i, String str, Throwable th) {
        m.checkNotNullParameter(str, "message");
        this.priority = i;
        this.message = str;
        this.throwable = th;
        String string = UUID.randomUUID().toString();
        m.checkNotNullExpressionValue(string, "UUID.randomUUID().toString()");
        this.key = string;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AppLog$LoggedItem)) {
            return false;
        }
        AppLog$LoggedItem appLog$LoggedItem = (AppLog$LoggedItem) other;
        return this.priority == appLog$LoggedItem.priority && m.areEqual(this.message, appLog$LoggedItem.message) && m.areEqual(this.throwable, appLog$LoggedItem.throwable);
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return 0;
    }

    public int hashCode() {
        int i = this.priority * 31;
        String str = this.message;
        int iHashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        Throwable th = this.throwable;
        return iHashCode + (th != null ? th.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("LoggedItem(priority=");
        sbU.append(this.priority);
        sbU.append(", message=");
        sbU.append(this.message);
        sbU.append(", throwable=");
        sbU.append(this.throwable);
        sbU.append(")");
        return sbU.toString();
    }
}
