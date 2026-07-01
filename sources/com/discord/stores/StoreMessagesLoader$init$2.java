package com.discord.stores;

import d0.z.d.k;
import d0.z.d.m;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreMessagesLoader.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class StoreMessagesLoader$init$2 extends k implements Function1<Set<? extends Long>, Unit> {
    public StoreMessagesLoader$init$2(StoreMessagesLoader storeMessagesLoader) {
        super(1, storeMessagesLoader, StoreMessagesLoader.class, "handleChatDetached", "handleChatDetached(Ljava/util/Set;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Set<? extends Long> set) {
        invoke2((Set<Long>) set);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Set<Long> set) {
        m.checkNotNullParameter(set, "p1");
        StoreMessagesLoader.access$handleChatDetached((StoreMessagesLoader) this.receiver, set);
    }
}
