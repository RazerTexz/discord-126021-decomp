package com.discord.stores;

import com.discord.utilities.frecency.FrecencyTracker;
import d0.z.d.o;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommandFrecency.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommandFrecency$onCommandUsed$1 extends o implements Function0<Unit> {
    public final /* synthetic */ String $commandId;
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreApplicationCommandFrecency this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommandFrecency$onCommandUsed$1(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Long l, String str) {
        super(0);
        this.this$0 = storeApplicationCommandFrecency;
        this.$guildId = l;
        this.$commandId = str;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        FrecencyTracker.track$default(StoreApplicationCommandFrecency.access$getFrecency$p(this.this$0), StoreApplicationCommandFrecency.access$getKey(this.this$0, this.$guildId, this.$commandId), 0L, 2, null);
        StoreApplicationCommandFrecency.access$getFrecencyCache$p(this.this$0).set(StoreApplicationCommandFrecency.access$getFrecency$p(this.this$0), true);
        Map mapAccess$getTopCommandIds$p = StoreApplicationCommandFrecency.access$getTopCommandIds$p(this.this$0);
        Long l = this.$guildId;
        mapAccess$getTopCommandIds$p.put(Long.valueOf(l != null ? l.longValue() : 0L), StoreApplicationCommandFrecency.access$getAllTopCommandIds(this.this$0, this.$guildId));
        StoreApplicationCommandFrecency storeApplicationCommandFrecency = this.this$0;
        storeApplicationCommandFrecency.markChanged(storeApplicationCommandFrecency);
    }
}
