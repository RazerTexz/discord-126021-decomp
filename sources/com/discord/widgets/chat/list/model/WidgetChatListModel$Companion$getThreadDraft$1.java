package com.discord.widgets.chat.list.model;

import com.discord.models.message.Message;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;
import p507d0.p592z.p594d.C12236k;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModel$Companion$getThreadDraft$1 extends C12236k implements Function2<Message, List<? extends ChatListEntry>, Pair<? extends Message, ? extends List<? extends ChatListEntry>>> {
    public static final WidgetChatListModel$Companion$getThreadDraft$1 INSTANCE = new WidgetChatListModel$Companion$getThreadDraft$1();

    public WidgetChatListModel$Companion$getThreadDraft$1() {
        super(2, Pair.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Pair<Message, List<ChatListEntry>> invoke(Message message, List<? extends ChatListEntry> list) {
        return new Pair<>(message, list);
    }
}
