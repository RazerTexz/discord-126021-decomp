package com.discord.widgets.chat.list.adapter;

import com.discord.stores.StoreStream;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.UploadProgressEntry;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChatListAdapterItemUploadProgress.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1 extends o implements Function0<Unit> {
    public final /* synthetic */ ChatListEntry $data;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemUploadProgress$onConfigure$cancel$1(ChatListEntry chatListEntry) {
        super(0);
        this.$data = chatListEntry;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ Unit invoke() {
        invoke2();
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        StoreStream.Companion.getMessages().cancelMessageSend(((UploadProgressEntry) this.$data).getChannelId(), ((UploadProgressEntry) this.$data).getMessageNonce());
    }
}
