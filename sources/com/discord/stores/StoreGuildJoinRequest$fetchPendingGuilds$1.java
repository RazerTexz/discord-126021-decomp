package com.discord.stores;

import android.content.Context;
import com.discord.models.guild.Guild;
import com.discord.utilities.rest.RestAPI;
import com.discord.utilities.rx.ObservableExtensionsKt;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreGuildJoinRequest.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreGuildJoinRequest$fetchPendingGuilds$1 extends o implements Function0<Unit> {
    public final /* synthetic */ StoreGuildJoinRequest this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreGuildJoinRequest$fetchPendingGuilds$1(StoreGuildJoinRequest storeGuildJoinRequest) {
        super(0);
        this.this$0 = storeGuildJoinRequest;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Map<Long, Guild> guilds = StoreGuildJoinRequest.access$getGuildsStore$p(this.this$0).getGuilds();
        Set setKeySet = StoreGuildJoinRequest.access$getGuildJoinRequests$p(this.this$0).keySet();
        m.checkNotNullExpressionValue(setKeySet, "guildJoinRequests.keys");
        ArrayList arrayList = new ArrayList();
        Iterator it = setKeySet.iterator();
        while (true) {
            boolean z2 = false;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Long l = (Long) next;
            m.checkNotNullExpressionValue(l, "it");
            if (!guilds.containsKey(l) && !StoreGuildJoinRequest.access$getPendingGuilds$p(this.this$0).containsKey(l)) {
                z2 = true;
            }
            if (z2) {
                arrayList.add(next);
            }
        }
        if (!arrayList.isEmpty()) {
            ObservableExtensionsKt.appSubscribe$default(ObservableExtensionsKt.restSubscribeOn$default(RestAPI.Companion.getApi().getUserJoinRequestGuilds(), false, 1, null), this.this$0.getClass(), (Context) null, (Function1) null, (Function1) null, (Function0) null, (Function0) null, new StoreGuildJoinRequest$fetchPendingGuilds$1$1(this), 62, (Object) null);
        }
    }
}
