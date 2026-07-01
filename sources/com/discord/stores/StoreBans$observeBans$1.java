package com.discord.stores;

import com.discord.models.domain.ModelBan;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreBans$observeBans$1 extends o implements Function1<List<? extends ModelBan>, Unit> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreBans this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreBans$observeBans$1(StoreBans storeBans, long j) {
        super(1);
        this.this$0 = storeBans;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ModelBan> list) {
        invoke2(list);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ModelBan> list) {
        m.checkNotNullParameter(list, "bans");
        StoreBans.access$getDispatcher$p(this.this$0).schedule(new StoreBans$observeBans$1$1(this, list));
    }
}
