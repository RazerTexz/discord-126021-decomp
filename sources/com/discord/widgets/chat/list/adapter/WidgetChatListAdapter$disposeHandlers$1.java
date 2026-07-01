package com.discord.widgets.chat.list.adapter;

import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$disposeHandlers$1 extends o implements Function2<List<? extends ChatListEntry>, List<? extends ChatListEntry>, Unit> {
    public static final WidgetChatListAdapter$disposeHandlers$1 INSTANCE = new WidgetChatListAdapter$disposeHandlers$1();

    public WidgetChatListAdapter$disposeHandlers$1() {
        super(2);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
        invoke2(list, list2);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(List<? extends ChatListEntry> list, List<? extends ChatListEntry> list2) {
        m.checkNotNullParameter(list, "<anonymous parameter 0>");
        m.checkNotNullParameter(list2, "<anonymous parameter 1>");
    }
}
