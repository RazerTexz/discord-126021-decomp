package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeckProvider;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;
import p658rx.Observable;

/* JADX INFO: compiled from: StoreGuildMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberCounts extends StoreV2 {
    private final HashMap<Long, Integer> guildMemberCounts = new HashMap<>();
    private Map<Long, Integer> guildMemberCountsSnapshot = C12136h0.emptyMap();

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberCounts$observeApproximateMemberCount$1 */
    /* JADX INFO: compiled from: StoreGuildMemberCounts.kt */
    public static final class C60321 extends AbstractC12240o implements Function0<Integer> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C60321(long j) {
            super(0);
            this.$guildId = j;
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Integer invoke() {
            return Integer.valueOf(invoke2());
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final int invoke2() {
            Integer num = (Integer) StoreGuildMemberCounts.this.guildMemberCountsSnapshot.get(Long.valueOf(this.$guildId));
            if (num != null) {
                return num.intValue();
            }
            return 0;
        }
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
        C12238m.checkNotNullParameter(payload, "payload");
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
        C12238m.checkNotNullParameter(guild, "guild");
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
        C12238m.checkNotNullParameter(member, "member");
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
        Observable<Integer> observableM11112r = ObservationDeck.connectRx$default(ObservationDeckProvider.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new C60321(guildId), 14, null).m11112r();
        C12238m.checkNotNullExpressionValue(observableM11112r, "ObservationDeckProvider.… }.distinctUntilChanged()");
        return observableM11112r;
    }

    @Override // com.discord.stores.StoreV2
    @StoreThread
    public void snapshotData() {
        super.snapshotData();
        try {
            this.guildMemberCountsSnapshot = new HashMap(this.guildMemberCounts);
        } catch (OutOfMemoryError e) {
            AppLog appLog = AppLog.f14950g;
            StringBuilder sbM833U = C1643a.m833U("OOM in StoreGuildMemberCounts. size: ");
            sbM833U.append(this.guildMemberCounts.size());
            appLog.recordBreadcrumb(sbM833U.toString(), "StoreGuildMemberCounts");
            throw e;
        }
    }
}
