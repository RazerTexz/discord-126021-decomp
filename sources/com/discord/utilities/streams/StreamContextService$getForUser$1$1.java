package com.discord.utilities.streams;

import androidx.core.app.NotificationCompat;
import com.discord.models.member.GuildMember;
import j0.k.b;
import java.util.Map;

/* JADX INFO: compiled from: StreamContextService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StreamContextService$getForUser$1$1<T, R> implements b<Map<Long, ? extends GuildMember>, GuildMember> {
    public final /* synthetic */ StreamContextService$getForUser$1 this$0;

    public StreamContextService$getForUser$1$1(StreamContextService$getForUser$1 streamContextService$getForUser$1) {
        this.this$0 = streamContextService$getForUser$1;
    }

    @Override // j0.k.b
    public /* bridge */ /* synthetic */ GuildMember call(Map<Long, ? extends GuildMember> map) {
        return call2((Map<Long, GuildMember>) map);
    }

    /* JADX INFO: renamed from: call, reason: avoid collision after fix types in other method */
    public final GuildMember call2(Map<Long, GuildMember> map) {
        return map.get(Long.valueOf(this.this$0.$userId));
    }
}
