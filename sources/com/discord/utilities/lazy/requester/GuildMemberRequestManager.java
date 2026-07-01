package com.discord.utilities.lazy.requester;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildMemberRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberRequestManager {
    private final Function2<Long, Long, Boolean> guildMemberExists;
    private final HashMap<Long, GuildMemberRequestState> guildRequestStates;
    private final Function2<Long, List<Long>, Unit> onFlush;

    /* JADX INFO: compiled from: GuildMemberRequestManager.kt */
    public final class GuildMemberRequestState {
        private final long guildId;
        private final Function1<Long, Boolean> guildMemberExists;
        private final HashSet<Long> pendingRequests;
        private final HashSet<Long> sentRequests;
        public final /* synthetic */ GuildMemberRequestManager this$0;
        private final HashSet<Long> unacknowledgedRequests;

        /* JADX WARN: Multi-variable type inference failed */
        public GuildMemberRequestState(GuildMemberRequestManager guildMemberRequestManager, long j, Function1<? super Long, Boolean> function1) {
            Intrinsics3.checkNotNullParameter(function1, "guildMemberExists");
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
                Intrinsics3.checkNotNullExpressionValue(l, "userId");
                if (!function1.invoke(l).booleanValue()) {
                    this.unacknowledgedRequests.add(l);
                    this.sentRequests.add(l);
                    hashSet.add(l);
                }
            }
            if (!hashSet.isEmpty()) {
                this.this$0.onFlush.invoke(Long.valueOf(this.guildId), _Collections.toList(hashSet));
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
            Intrinsics3.checkNotNullExpressionValue(it, "unacknowledgedRequests.iterator()");
            while (it.hasNext()) {
                Long next = it.next();
                Intrinsics3.checkNotNullExpressionValue(next, "iter.next()");
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

    /* JADX INFO: renamed from: com.discord.utilities.lazy.requester.GuildMemberRequestManager$getGuildRequestState$1, reason: invalid class name */
    /* JADX INFO: compiled from: GuildMemberRequestManager.kt */
    public static final class AnonymousClass1 extends Lambda implements Function1<Long, Boolean> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
            super(1);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
            return Boolean.valueOf(invoke(l.longValue()));
        }

        public final boolean invoke(long j) {
            return ((Boolean) GuildMemberRequestManager.this.guildMemberExists.invoke(Long.valueOf(this.$guildId), Long.valueOf(j))).booleanValue();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberRequestManager(Function2<? super Long, ? super Long, Boolean> function2, Function2<? super Long, ? super List<Long>, Unit> function3) {
        Intrinsics3.checkNotNullParameter(function2, "guildMemberExists");
        Intrinsics3.checkNotNullParameter(function3, "onFlush");
        this.guildMemberExists = function2;
        this.onFlush = function3;
        this.guildRequestStates = new HashMap<>();
    }

    private final GuildMemberRequestState getGuildRequestState(long guildId) {
        GuildMemberRequestState guildMemberRequestState = this.guildRequestStates.get(Long.valueOf(guildId));
        if (guildMemberRequestState != null) {
            return guildMemberRequestState;
        }
        GuildMemberRequestState guildMemberRequestState2 = new GuildMemberRequestState(this, guildId, new AnonymousClass1(guildId));
        this.guildRequestStates.put(Long.valueOf(guildId), guildMemberRequestState2);
        return guildMemberRequestState2;
    }

    public final void acknowledge(long guildId, long userId) {
        getGuildRequestState(guildId).acknowledge(userId);
    }

    public final void flush() {
        Iterator<GuildMemberRequestState> it = this.guildRequestStates.values().iterator();
        while (it.hasNext()) {
            it.next().flushRequests();
        }
    }

    public final void queueRequest(long guildId, long userId) {
        getGuildRequestState(guildId).request(userId);
    }

    public final void requestUnacknowledged() {
        Collection<GuildMemberRequestState> collectionValues = this.guildRequestStates.values();
        Intrinsics3.checkNotNullExpressionValue(collectionValues, "guildRequestStates.values");
        int i = 0;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((GuildMemberRequestState) it.next()).requestUnacknowledged() && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        if (i > 0) {
            flush();
        }
    }

    public final void reset() {
        this.guildRequestStates.clear();
    }
}
