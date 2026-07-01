package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$3 extends o implements Function1<Channel, Boolean> {
    public static final StoreCalls$call$3 INSTANCE = new StoreCalls$call$3();

    public StoreCalls$call$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Boolean invoke(Channel channel) {
        return Boolean.valueOf(invoke2(channel));
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final boolean invoke2(Channel channel) {
        return channel != null;
    }
}
