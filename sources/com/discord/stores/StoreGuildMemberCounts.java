package com.discord.stores;

import b.d.b.a.outline;
import com.discord.api.guild.Guild;
import com.discord.api.guildmember.GuildMember;
import com.discord.app.AppLog;
import com.discord.models.domain.ModelPayload;
import com.discord.stores.updates.ObservationDeck;
import com.discord.stores.updates.ObservationDeck4;
import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function0;
import rx.Observable;

/* JADX INFO: compiled from: StoreGuildMemberCounts.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildMemberCounts extends StoreV2 {
    private final HashMap<Long, Integer> guildMemberCounts = new HashMap<>();
    private Map<Long, Integer> guildMemberCountsSnapshot = Maps6.emptyMap();

    /* JADX INFO: renamed from: com.discord.stores.StoreGuildMemberCounts$observeApproximateMemberCount$1, reason: invalid class name */
    /* JADX INFO: compiled from: StoreGuildMemberCounts.kt */
    public static final class AnonymousClass1 extends Lambda implements Function0<Integer> {
        public final /* synthetic */ long $guildId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(long j) {
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

    @Store3
    public final void handleConnectionOpen(ModelPayload payload) {
        Intrinsics3.checkNotNullParameter(payload, "payload");
        List<Guild> guilds = payload.getGuilds();
        if (guilds != null) {
            for (Guild guild : guilds) {
                this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
            }
        }
        markChanged();
    }

    @Store3
    public final void handleGuildCreate(Guild guild) {
        Intrinsics3.checkNotNullParameter(guild, "guild");
        this.guildMemberCounts.put(Long.valueOf(guild.getId()), Integer.valueOf(guild.getMemberCount()));
        markChanged();
    }

    @Store3
    public final void handleGuildDelete(long guildId) {
        this.guildMemberCounts.remove(Long.valueOf(guildId));
        markChanged();
    }

    @Store3
    public final void handleGuildMemberAdd(GuildMember member) {
        Intrinsics3.checkNotNullParameter(member, "member");
        Integer num = this.guildMemberCounts.get(Long.valueOf(member.getGuildId()));
        if (num != null) {
            this.guildMemberCounts.put(Long.valueOf(member.getGuildId()), Integer.valueOf(num.intValue() + 1));
            markChanged();
        }
    }

    @Store3
    public final void handleGuildMemberRemove(long guildId) {
        Integer num = this.guildMemberCounts.get(Long.valueOf(guildId));
        if (num != null) {
            this.guildMemberCounts.put(Long.valueOf(guildId), Integer.valueOf(num.intValue() - 1));
            markChanged();
        }
    }

    public final Observable<Integer> observeApproximateMemberCount(long guildId) {
        Observable<Integer> observableR = ObservationDeck.connectRx$default(ObservationDeck4.get(), new ObservationDeck.UpdateSource[]{this}, false, null, null, new AnonymousClass1(guildId), 14, null).r();
        Intrinsics3.checkNotNullExpressionValue(observableR, "ObservationDeckProvider.… }.distinctUntilChanged()");
        return observableR;
    }

    @Override // com.discord.stores.StoreV2
    @Store3
    public void snapshotData() {
        super.snapshotData();
        try {
            this.guildMemberCountsSnapshot = new HashMap(this.guildMemberCounts);
        } catch (OutOfMemoryError e) {
            AppLog appLog = AppLog.g;
            StringBuilder sbU = outline.U("OOM in StoreGuildMemberCounts. size: ");
            sbU.append(this.guildMemberCounts.size());
            appLog.recordBreadcrumb(sbU.toString(), "StoreGuildMemberCounts");
            throw e;
        }
    }
}
