package com.discord.stores;

import com.discord.api.guild.Guild;
import com.discord.models.domain.ModelPayload;
import d0.z.d.m;
import d0.z.d.o;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildSelected.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildSelected$handleConnectionOpen$1 extends o implements Function1<Long, Boolean> {
    public final /* synthetic */ ModelPayload $payload;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildSelected$handleConnectionOpen$1(ModelPayload modelPayload) {
        super(1);
        this.$payload = modelPayload;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Long l) {
        return Boolean.valueOf(invoke(l.longValue()));
    }

    public final boolean invoke(long j) {
        boolean z2;
        if (j != 0) {
            List<Guild> guilds = this.$payload.getGuilds();
            m.checkNotNullExpressionValue(guilds, "payload.guilds");
            if ((guilds instanceof Collection) && guilds.isEmpty()) {
                z2 = false;
            } else {
                Iterator<T> it = guilds.iterator();
                while (it.hasNext()) {
                    if (j == ((Guild) it.next()).getId()) {
                        z2 = true;
                    }
                }
                z2 = false;
            }
            if (!z2) {
                return true;
            }
        }
        return false;
    }
}
