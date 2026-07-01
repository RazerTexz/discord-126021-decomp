package com.discord.widgets.servers.guildboost;

import com.discord.models.domain.ModelAppliedGuildBoost;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: GuildBoostInProgressViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildBoostInProgressViewModel$subscribeToGuildBoost$3 extends o implements Function1<List<? extends ModelAppliedGuildBoost>, Unit> {
    public final /* synthetic */ GuildBoostInProgressViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildBoostInProgressViewModel$subscribeToGuildBoost$3(GuildBoostInProgressViewModel guildBoostInProgressViewModel) {
        super(1);
        this.this$0 = guildBoostInProgressViewModel;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelAppliedGuildBoost> list) {
        invoke2((List<ModelAppliedGuildBoost>) list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<ModelAppliedGuildBoost> list) {
        m.checkNotNullParameter(list, "it");
        GuildBoostInProgressViewModel.access$handleGuildBoostingCompleted(this.this$0);
    }
}
