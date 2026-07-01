package com.discord.widgets.chat.list;

import com.discord.stores.StoreStream;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList$scrollTo$onCompleted$1 extends o implements Function0<Unit> {
    public static final WidgetChatList$scrollTo$onCompleted$1 INSTANCE = new WidgetChatList$scrollTo$onCompleted$1();

    public WidgetChatList$scrollTo$onCompleted$1() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getMessagesLoader().clearScrollTo();
    }
}
