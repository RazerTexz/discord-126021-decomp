package com.discord.widgets.chat.list;

import com.discord.stores.StoreStream;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList$scrollTo$onCompleted$1 extends AbstractC12240o implements Function0<Unit> {
    public static final WidgetChatList$scrollTo$onCompleted$1 INSTANCE = new WidgetChatList$scrollTo$onCompleted$1();

    public WidgetChatList$scrollTo$onCompleted$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.f27425a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.INSTANCE.getMessagesLoader().clearScrollTo();
    }
}
