package com.discord.utilities.lazy.requester;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.n;
import d0.z.d.m;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: GuildMemberRequestManager.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildMemberRequestManager {
    private final Function2<Long, Long, Boolean> guildMemberExists;
    private final HashMap<Long, GuildMemberRequestManager$GuildMemberRequestState> guildRequestStates;
    private final Function2<Long, List<Long>, Unit> onFlush;

    /* JADX WARN: Multi-variable type inference failed */
    public GuildMemberRequestManager(Function2<? super Long, ? super Long, Boolean> function2, Function2<? super Long, ? super List<Long>, Unit> function3) {
        m.checkNotNullParameter(function2, "guildMemberExists");
        m.checkNotNullParameter(function3, "onFlush");
        this.guildMemberExists = function2;
        this.onFlush = function3;
        this.guildRequestStates = new HashMap<>();
    }

    public static final /* synthetic */ Function2 access$getGuildMemberExists$p(GuildMemberRequestManager guildMemberRequestManager) {
        return guildMemberRequestManager.guildMemberExists;
    }

    public static final /* synthetic */ Function2 access$getOnFlush$p(GuildMemberRequestManager guildMemberRequestManager) {
        return guildMemberRequestManager.onFlush;
    }

    private final GuildMemberRequestManager$GuildMemberRequestState getGuildRequestState(long guildId) {
        GuildMemberRequestManager$GuildMemberRequestState guildMemberRequestManager$GuildMemberRequestState = this.guildRequestStates.get(Long.valueOf(guildId));
        if (guildMemberRequestManager$GuildMemberRequestState != null) {
            return guildMemberRequestManager$GuildMemberRequestState;
        }
        GuildMemberRequestManager$GuildMemberRequestState guildMemberRequestManager$GuildMemberRequestState2 = new GuildMemberRequestManager$GuildMemberRequestState(this, guildId, new GuildMemberRequestManager$getGuildRequestState$1(this, guildId));
        this.guildRequestStates.put(Long.valueOf(guildId), guildMemberRequestManager$GuildMemberRequestState2);
        return guildMemberRequestManager$GuildMemberRequestState2;
    }

    public final void acknowledge(long guildId, long userId) {
        getGuildRequestState(guildId).acknowledge(userId);
    }

    public final void flush() {
        Iterator<GuildMemberRequestManager$GuildMemberRequestState> it = this.guildRequestStates.values().iterator();
        while (it.hasNext()) {
            it.next().flushRequests();
        }
    }

    public final void queueRequest(long guildId, long userId) {
        getGuildRequestState(guildId).request(userId);
    }

    public final void requestUnacknowledged() {
        Collection<GuildMemberRequestManager$GuildMemberRequestState> collectionValues = this.guildRequestStates.values();
        m.checkNotNullExpressionValue(collectionValues, "guildRequestStates.values");
        int i = 0;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator<T> it = collectionValues.iterator();
            while (it.hasNext()) {
                if (((GuildMemberRequestManager$GuildMemberRequestState) it.next()).requestUnacknowledged() && (i = i + 1) < 0) {
                    n.throwCountOverflow();
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
