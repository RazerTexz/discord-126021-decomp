package com.discord.stores;

import com.discord.models.domain.ModelBan;
import d0.z.d.o;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreBans$observeBans$1$1 extends o implements Function0<Unit> {
    public final /* synthetic */ List $bans;
    public final /* synthetic */ StoreBans$observeBans$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreBans$observeBans$1$1(StoreBans$observeBans$1 storeBans$observeBans$1, List list) {
        super(0);
        this.this$0 = storeBans$observeBans$1;
        this.$bans = list;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        HashMap mapAccess$getBannedUsers$p = StoreBans.access$getBannedUsers$p(this.this$0.this$0);
        Long lValueOf = Long.valueOf(this.this$0.$guildId);
        Object map = mapAccess$getBannedUsers$p.get(lValueOf);
        if (map == null) {
            map = new HashMap();
            mapAccess$getBannedUsers$p.put(lValueOf, map);
        }
        HashMap map2 = (HashMap) map;
        for (ModelBan modelBan : this.$bans) {
            map2.put(Long.valueOf(modelBan.getUser().getId()), modelBan);
        }
        this.this$0.this$0.markChanged();
    }
}
