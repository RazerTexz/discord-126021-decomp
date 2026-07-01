package com.discord.widgets.servers.guildboost;

import androidx.core.app.NotificationCompat;
import com.discord.models.domain.ModelAppliedGuildBoost;
import com.discord.restapi.RestAPIParams$GuildBoosting;
import d0.t.m;
import j0.k.b;
import java.util.List;
import rx.Observable;

/* JADX INFO: compiled from: GuildBoostTransferInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostTransferInProgressViewModel$transferGuildBoost$1<T, R> implements b<Void, Observable<? extends List<? extends ModelAppliedGuildBoost>>> {
    public final /* synthetic */ GuildBoostTransferInProgressViewModel this$0;

    public GuildBoostTransferInProgressViewModel$transferGuildBoost$1(GuildBoostTransferInProgressViewModel guildBoostTransferInProgressViewModel) {
        this.this$0 = guildBoostTransferInProgressViewModel;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ Observable<? extends List<? extends ModelAppliedGuildBoost>> call(Void r1) {
        return call2(r1);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final Observable<? extends List<ModelAppliedGuildBoost>> call2(Void r6) {
        return this.this$0.getRestAPI().subscribeToGuild(this.this$0.getTargetGuildId(), new RestAPIParams$GuildBoosting(m.listOf(Long.valueOf(this.this$0.getSlotId()))));
    }
}
