package com.discord.stores;

import com.discord.api.channel.Channel;
import d0.z.d.o;
import java.util.Map;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: StoreChannels.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreChannels$observeGuildAndPrivateChannels$1 extends o implements Function0<Map<Long, ? extends Channel>> {
    public final /* synthetic */ StoreChannels this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreChannels$observeGuildAndPrivateChannels$1(StoreChannels storeChannels) {
        super(0);
        this.this$0 = storeChannels;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Map<Long, ? extends Channel> invoke() {
        return invoke2();
    }

    @Override // kotlin.jvm.functions.Function0
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Map<Long, ? extends Channel> invoke2() {
        return StoreChannels.access$getChannelsByIdSnapshot$p(this.this$0);
    }
}
