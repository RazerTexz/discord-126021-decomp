package com.discord.widgets.chat.list.adapter;

import b.i.a.f.e.o.f;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import d0.z.d.m;
import d0.z.d.o;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;

/* JADX INFO: compiled from: WidgetChatListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapter$setHandlers$1 extends o implements Function2<List<? extends ChatListEntry>, List<? extends ChatListEntry>, Unit> {
    public final /* synthetic */ WidgetChatListAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapter$setHandlers$1(WidgetChatListAdapter widgetChatListAdapter) {
        super(2);
        this.this$0 = widgetChatListAdapter;
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
        Job jobAccess$getLastUpdateJob$p = WidgetChatListAdapter.access$getLastUpdateJob$p(this.this$0);
        if (jobAccess$getLastUpdateJob$p != null) {
            f.t(jobAccess$getLastUpdateJob$p, null, 1, null);
        }
        WidgetChatListAdapter widgetChatListAdapter = this.this$0;
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(widgetChatListAdapter.getRecycler());
        WidgetChatListAdapter.access$setLastUpdateJob$p(widgetChatListAdapter, coroutineScope != null ? f.H0(coroutineScope, null, null, new WidgetChatListAdapter$setHandlers$1$1(this, null), 3, null) : null);
        this.this$0.getRecycler().setOnTouchListener(WidgetChatListAdapter.access$getHandlerOfTouches$p(this.this$0));
        this.this$0.getRecycler().removeOnScrollListener(WidgetChatListAdapter.access$getHandlerOfScrolls$p(this.this$0));
        this.this$0.getRecycler().addOnScrollListener(WidgetChatListAdapter.access$getHandlerOfScrolls$p(this.this$0));
    }
}
