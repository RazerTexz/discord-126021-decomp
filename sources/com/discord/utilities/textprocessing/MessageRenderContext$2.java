package com.discord.utilities.textprocessing;

import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: MessageRenderContext.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MessageRenderContext$2 extends o implements Function1<String, Unit> {
    public static final MessageRenderContext$2 INSTANCE = new MessageRenderContext$2();

    public MessageRenderContext$2() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(String str) {
        invoke2(str);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(String str) {
        m.checkNotNullParameter(str, "it");
    }
}
