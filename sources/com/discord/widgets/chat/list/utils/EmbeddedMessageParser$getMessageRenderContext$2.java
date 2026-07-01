package com.discord.widgets.chat.list.utils;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: EmbeddedMessageParser.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class EmbeddedMessageParser$getMessageRenderContext$2 extends o implements Function1<String, Unit> {
    public final /* synthetic */ EmbeddedMessageParser$ParserData $parserData;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmbeddedMessageParser$getMessageRenderContext$2(EmbeddedMessageParser$ParserData embeddedMessageParser$ParserData) {
        super(1);
        this.$parserData = embeddedMessageParser$ParserData;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "url");
        this.$parserData.getAdapter().getEventHandler().onUrlLongClicked(str);
    }
}
