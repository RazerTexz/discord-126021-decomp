package com.discord.utilities.lazy.requester;

import d0.t.u;
import d0.z.d.m;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildMemberRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberRequestManager$GuildMemberRequestState {
    private final long guildId;
    private final Function1<Long, Boolean> guildMemberExists;
    private final HashSet<Long> pendingRequests;
    private final HashSet<Long> sentRequests;
    public final /* synthetic */ GuildMemberRequestManager this$0;
    private final HashSet<Long> unacknowledgedRequests;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberRequestManager$GuildMemberRequestState(GuildMemberRequestManager guildMemberRequestManager, long j, Function1<? super Long, Boolean> function1) {
        m.checkNotNullParameter(function1, "guildMemberExists");
        this.this$0 = guildMemberRequestManager;
        this.guildId = j;
        this.guildMemberExists = function1;
        this.pendingRequests = new HashSet<>();
        this.sentRequests = new HashSet<>();
        this.unacknowledgedRequests = new HashSet<>();
    }

    public final void acknowledge(long userId) {
        this.unacknowledgedRequests.remove(Long.valueOf(userId));
        this.pendingRequests.remove(Long.valueOf(userId));
    }

    public final void flushRequests() {
        HashSet hashSet = new HashSet();
        for (Long l : this.pendingRequests) {
            Function1<Long, Boolean> function1 = this.guildMemberExists;
            m.checkNotNullExpressionValue(l, "userId");
            if (!function1.invoke(l).booleanValue()) {
                this.unacknowledgedRequests.add(l);
                this.sentRequests.add(l);
                hashSet.add(l);
            }
        }
        if (!hashSet.isEmpty()) {
            GuildMemberRequestManager.access$getOnFlush$p(this.this$0).invoke(Long.valueOf(this.guildId), u.toList(hashSet));
        }
        this.pendingRequests.clear();
    }

    public final HashSet<Long> getPendingRequests() {
        return this.pendingRequests;
    }

    public final HashSet<Long> getSentRequests() {
        return this.sentRequests;
    }

    public final HashSet<Long> getUnacknowledgedRequests() {
        return this.unacknowledgedRequests;
    }

    public final boolean request(long userId) {
        if (this.sentRequests.contains(Long.valueOf(userId)) || this.pendingRequests.contains(Long.valueOf(userId)) || this.guildMemberExists.invoke(Long.valueOf(userId)).booleanValue()) {
            return false;
        }
        this.pendingRequests.add(Long.valueOf(userId));
        return true;
    }

    public final boolean requestUnacknowledged() {
        if (this.unacknowledgedRequests.isEmpty()) {
            return false;
        }
        Iterator<Long> it = this.unacknowledgedRequests.iterator();
        m.checkNotNullExpressionValue(it, "unacknowledgedRequests.iterator()");
        while (it.hasNext()) {
            Long next = it.next();
            m.checkNotNullExpressionValue(next, "iter.next()");
            long jLongValue = next.longValue();
            if (this.guildMemberExists.invoke(Long.valueOf(jLongValue)).booleanValue()) {
                it.remove();
            } else {
                this.pendingRequests.add(Long.valueOf(jLongValue));
            }
        }
        return !this.pendingRequests.isEmpty();
    }
}
