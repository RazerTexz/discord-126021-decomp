package com.discord.stores;

import com.discord.api.role.GuildRole;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreGuilds.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuilds$observeRoles$1 extends o implements Function0<Map<Long, ? extends Map<Long, ? extends GuildRole>>> {
    public final /* synthetic */ StoreGuilds this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuilds$observeRoles$1(StoreGuilds storeGuilds) {
        super(0);
        this.this$0 = storeGuilds;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Map<Long, ? extends GuildRole>> invoke2() {
        return this.this$0.getRoles();
    }
}
