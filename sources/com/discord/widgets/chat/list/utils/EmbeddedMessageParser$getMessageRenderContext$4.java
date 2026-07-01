package com.discord.widgets.chat.list.utils;

import com.discord.utilities.channel.ChannelSelector;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmbeddedMessageParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmbeddedMessageParser$getMessageRenderContext$4 extends o implements Function1<Long, Unit> {
    public final /* synthetic */ EmbeddedMessageParser$ParserData $parserData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddedMessageParser$getMessageRenderContext$4(EmbeddedMessageParser$ParserData embeddedMessageParser$ParserData) {
        super(1);
        this.$parserData = embeddedMessageParser$ParserData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Long l) {
        invoke(l.longValue());
        return Unit.a;
    }

    public final void invoke(long j) {
        ChannelSelector.Companion.getInstance().findAndSet(this.$parserData.getContext(), j);
    }
}
