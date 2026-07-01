package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreThreadsActive.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreThreadsActive$observeAllActiveForumThreadsById$1 extends o implements Function0<Map<Long, ? extends Channel>> {
    public final /* synthetic */ StoreThreadsActive this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreThreadsActive$observeAllActiveForumThreadsById$1(StoreThreadsActive storeThreadsActive) {
        super(0);
        this.this$0 = storeThreadsActive;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Channel> invoke2() {
        return StoreThreadsActive.access$getForumThreadsByIdSnapshot$p(this.this$0);
    }
}
