package com.discord.stores;

import d0.z.d.o;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreApplicationCommandFrecency.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreApplicationCommandFrecency$observeTopCommandIds$1 extends o implements Function0<List<? extends String>> {
    public final /* synthetic */ Long $guildId;
    public final /* synthetic */ StoreApplicationCommandFrecency this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreApplicationCommandFrecency$observeTopCommandIds$1(StoreApplicationCommandFrecency storeApplicationCommandFrecency, Long l) {
        super(0);
        this.this$0 = storeApplicationCommandFrecency;
        this.$guildId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ List<? extends String> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<? extends String> invoke2() {
        return this.this$0.getTopCommandIds(this.$guildId);
    }
}
