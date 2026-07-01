package com.discord.widgets.chat.list.model;

import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.FunctionReferenceImpl;
import java.util.ArrayList;
import kotlin.Tuples2;
import kotlin.jvm.functions.Function2;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.model.WidgetChatListModel$Companion$getThreadDraft$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatListModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetChatListModel6 extends FunctionReferenceImpl implements Function2 {
    public static final WidgetChatListModel6 INSTANCE = new WidgetChatListModel6();

    public WidgetChatListModel6() {
        super(2, Tuples2.class, "<init>", "<init>(Ljava/lang/Object;Ljava/lang/Object;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Tuples2 invoke(Void r2, ArrayList<ChatListEntry> arrayList) {
        return new Tuples2(r2, arrayList);
    }
}
