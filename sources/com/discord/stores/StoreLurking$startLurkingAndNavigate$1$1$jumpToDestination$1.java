package com.discord.stores;

import com.discord.stores.StoreLurking;
import com.discord.utilities.channel.ChannelSelector;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: StoreLurking.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1 extends AbstractC12240o implements Function0<Unit> {
    public final /* synthetic */ Long $channelId;
    public final /* synthetic */ StoreLurking.C61551.AnonymousClass1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreLurking$startLurkingAndNavigate$1$1$jumpToDestination$1(StoreLurking.C61551.AnonymousClass1 anonymousClass1, Long l) {
        super(0);
        this.this$0 = anonymousClass1;
        this.$channelId = l;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        Long l;
        Long l2 = this.$channelId;
        if (l2 == null || ((l2 != null && l2.longValue() == 0) || ((l = this.$channelId) != null && l.longValue() == -1))) {
            StoreLurking.this.stream.getGuildSelected().set(StoreLurking.C61551.this.$guildId);
        } else {
            ChannelSelector.selectChannel$default(ChannelSelector.INSTANCE.getInstance(), StoreLurking.C61551.this.$guildId, this.$channelId.longValue(), null, null, 12, null);
        }
    }
}
