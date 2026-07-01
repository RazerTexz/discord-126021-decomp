package com.discord.widgets.chat.list.model;

import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.k;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModel$Companion$getThreadDraft$2 extends k implements Function2 {
    public static final WidgetChatListModel$Companion$getThreadDraft$2 INSTANCE = new WidgetChatListModel$Companion$getThreadDraft$2();

    public WidgetChatListModel$Companion$getThreadDraft$2() {
        super(2, Pair.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke((Void) obj, (ArrayList<ChatListEntry>) obj2);
    }

    public final Pair invoke(Void r2, ArrayList<ChatListEntry> arrayList) {
        return new Pair(r2, arrayList);
    }
}
