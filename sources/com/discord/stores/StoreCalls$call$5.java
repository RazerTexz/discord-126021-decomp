package com.discord.stores;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.api.voice.state.VoiceState;
import com.discord.models.user.User;
import d0.z.d.o;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: StoreCalls.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreCalls$call$5 extends o implements Function1<Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>>, Unit> {
    public final /* synthetic */ StoreCalls$call$1 $doCall$1;
    public final /* synthetic */ StoreCalls$call$2 $doCallIfCallable$2;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreCalls$call$5(StoreCalls$call$2 storeCalls$call$2, StoreCalls$call$1 storeCalls$call$1) {
        super(1);
        this.$doCallIfCallable$2 = storeCalls$call$2;
        this.$doCall$1 = storeCalls$call$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Channel, ? extends Map<Long, ? extends VoiceState>> pair) {
        invoke2((Pair<Channel, ? extends Map<Long, VoiceState>>) pair);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Pair<Channel, ? extends Map<Long, VoiceState>> pair) {
        Channel channelComponent1 = pair.component1();
        Map<Long, VoiceState> mapComponent2 = pair.component2();
        User userA = channelComponent1 != null ? ChannelUtils.a(channelComponent1) : null;
        if (userA != null) {
            this.$doCallIfCallable$2.invoke(userA.getId());
        } else if (channelComponent1 != null) {
            this.$doCall$1.invoke(mapComponent2.isEmpty());
        }
    }
}
