package com.discord.stores;

import com.discord.models.domain.ModelGuildIntegration;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildIntegrations.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildIntegrations$requestGuildIntegrations$1 extends o implements Function1<List<? extends ModelGuildIntegration>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreGuildIntegrations this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildIntegrations$requestGuildIntegrations$1(StoreGuildIntegrations storeGuildIntegrations, long j) {
        super(1);
        this.this$0 = storeGuildIntegrations;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelGuildIntegration> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ModelGuildIntegration> list) {
        m.checkNotNullParameter(list, "integrations");
        StoreGuildIntegrations.access$getDispatcher$p(this.this$0).schedule(new StoreGuildIntegrations$requestGuildIntegrations$1$1(this, list));
    }
}
