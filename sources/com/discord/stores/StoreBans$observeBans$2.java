package com.discord.stores;

import com.discord.models.domain.ModelBan;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreBans$observeBans$2 extends o implements Function0<Map<Long, ? extends ModelBan>> {
    public final /* synthetic */ long $guildId;
    public final /* synthetic */ StoreBans this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreBans$observeBans$2(StoreBans storeBans, long j) {
        super(0);
        this.this$0 = storeBans;
        this.$guildId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends ModelBan> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends ModelBan> invoke2() {
        return (Map) StoreBans.access$getBannedUsersSnapshot$p(this.this$0).get(Long.valueOf(this.$guildId));
    }
}
