package com.discord.widgets.chat.list;

import com.discord.stores.StoreStream;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.WidgetChatList$scrollTo$onCompleted$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList6 extends Lambda implements Function0<Unit> {
    public static final WidgetChatList6 INSTANCE = new WidgetChatList6();

    public WidgetChatList6() {
        super(0);
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.INSTANCE.getMessagesLoader().clearScrollTo();
    }
}
