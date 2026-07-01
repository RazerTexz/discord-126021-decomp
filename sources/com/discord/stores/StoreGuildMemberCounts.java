package com.discord.stores;

import b.d.b.a.a;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck$UpdateSource;
import com.discord.stores.updates.ObservationDeckProvider;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberCounts extends StoreV2 {
    private final HashMap<Long, Integer> guildMemberCounts = new HashMap<>();
    private Map<Long, Integer> guildMemberCountsSnapshot = h0.emptyMap();

    public static final /* synthetic */ Map access$getGuildMemberCountsSnapshot$p(StoreGuildMemberCounts storeGuildMemberCounts) {
        return storeGuildMemberCounts.guildMemberCountsSnapshot;
    }

    public static final /* synthetic */ void access$setGuildMemberCountsSnapshot$p(StoreGuildMemberCounts storeGuildMemberCounts, Map map) {
        storeGuildMemberCounts.guildMemberCountsSnapshot = map;
    }

    public final int getApproximateMemberCount(long guildId) {
        Integer num = this.guildMemberCountsSnapshot.get(Long.valueOf(guildId));
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    @StoreThread
    public final void handleConnectionOpen(ModelPayload payload) {
        m.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        if (guilds != null) {
            for (Guild guild : guilds) {
                this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
            }
        }
        markChanged();
    }

    @StoreThread
    public final void handleGuildCreate(Guild guild) {
        m.checkNotNullParameter(guild, "guild");
        this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
        markChanged();
    }

    @StoreThread
    public final void handleGuildDelete(long guildId) {
        this.guildMemberCounts.remove(Long.valueOf(guildId));
        markChanged();
    }

    @StoreThread
    public final void handleGuildMemberAdd(GuildMember member) {
        m.checkNotNullParameter(member, "member");
        Integer num = this.guildMemberCounts.get(Long.valueOf(member.getGuildId()));
        if (num != null) {
            this.guildMemberCounts.put(Long.valueOf(member.getGuildId()), Integer.valueOf(num.intValue() + 1));
            markChanged();
        }
    }

    @StoreThread
    public final void handleGuildMemberRemove(long guildId) {
        Integer num = this.guildMemberCounts.get(Long.valueOf(guildId));
        if (num != null) {
            this.guildMemberCounts.put(Long.valueOf(guildId), Integer.valueOf(num.intValue() - 1));
            markChanged();
        }
    }

    public final Observable<Integer> observeApproximateMemberCount(long guildId) {
        Observable<Integer> observableR = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck$UpdateSource[]{this}, false, null, null, new StoreGuildMemberCounts$observeApproximateMemberCount$1(this, guildId), 14, null).r();
        m.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        try {
            this.guildMemberCountsSnapshot = new HashMap(this.guildMemberCounts);
        } catch (OutOfMemoryError e) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = a.U("OOM in StoreGuildMemberCounts. size: ");
            sbU.append(this.guildMemberCounts.size());
            appLog.recordBreadcrumb(sbU.toString(), "StoreGuildMemberCounts");
            throw e;
        }
    }
}
