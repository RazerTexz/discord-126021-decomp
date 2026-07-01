package com.discord.widgets.chat.list.adapter;

import com.discord.utilities.textprocessing.node.SpoilerNode;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemAutoModBlocked.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$3 extends o implements Function1<SpoilerNode<?>, Unit> {
    public static final WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$3 INSTANCE = new WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$3();

    public WidgetChatListAdapterItemAutoModBlocked$getMessageRenderContext$3() {
        super(1);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(SpoilerNode<?> spoilerNode) {
        invoke2(spoilerNode);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(SpoilerNode<?> spoilerNode) {
        m.checkNotNullParameter(spoilerNode, "it");
    }
}
