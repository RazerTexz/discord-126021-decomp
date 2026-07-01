package com.discord.stores;

import com.discord.models.guild.Guild;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuildSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSelected$observeSelectedGuild$1 extends o implements Function0<Guild> {
    public final /* synthetic */ StoreGuildSelected this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildSelected$observeSelectedGuild$1(StoreGuildSelected storeGuildSelected) {
        super(0);
        this.this$0 = storeGuildSelected;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Guild invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final Guild invoke() {
        return StoreGuildSelected.access$getGuildStore$p(this.this$0).getGuilds().get(Long.valueOf(this.this$0.getSelectedGuildId()));
    }
}
