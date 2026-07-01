package com.discord.widgets.chat.input;

import com.discord.api.channel.Channel;
import com.discord.stores.StoreStream;
import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: ChatInputViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputViewModel$createAndGotoThread$2 extends o implements Function1<Channel, Unit> {
    public final /* synthetic */ ChatInputViewModel$ViewState$Loaded $loadedViewState;
    public final /* synthetic */ Function1 $onThreadCreated;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputViewModel$createAndGotoThread$2(ChatInputViewModel$ViewState$Loaded chatInputViewModel$ViewState$Loaded, Function1 function1) {
        super(1);
        this.$loadedViewState = chatInputViewModel$ViewState$Loaded;
        this.$onThreadCreated = function1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Channel channel) {
        invoke2(channel);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Channel channel) {
        if (channel != null) {
            StoreStream.Companion.getSlowMode().onThreadCreated(this.$loadedViewState.getChannelId());
            Function1 function1 = this.$onThreadCreated;
            if (function1 != null) {
                function1.invoke(channel);
            }
            ChannelSelector.selectChannel$default(ChannelSelector.Companion.getInstance(), channel, null, null, 6, null);
        }
    }
}
