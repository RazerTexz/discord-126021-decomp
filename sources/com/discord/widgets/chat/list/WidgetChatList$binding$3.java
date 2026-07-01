package com.discord.widgets.chat.list;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatListBinding;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList$binding$3 extends o implements Function1<WidgetChatListBinding, Unit> {
    public final /* synthetic */ WidgetChatList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatList$binding$3(WidgetChatList widgetChatList) {
        super(1);
        this.this$0 = widgetChatList;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(WidgetChatListBinding widgetChatListBinding) {
        invoke2(widgetChatListBinding);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(WidgetChatListBinding widgetChatListBinding) {
        m.checkNotNullParameter(widgetChatListBinding, "binding");
        RecyclerView recyclerView = widgetChatListBinding.f2343b;
        m.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setLayoutManager(null);
        RecyclerView recyclerView2 = widgetChatListBinding.f2343b;
        m.checkNotNullExpressionValue(recyclerView2, "binding.chatListRecycler");
        recyclerView2.setAdapter(null);
        WidgetChatListAdapter widgetChatListAdapterAccess$getAdapter$p = WidgetChatList.access$getAdapter$p(this.this$0);
        if (widgetChatListAdapterAccess$getAdapter$p != null) {
            widgetChatListAdapterAccess$getAdapter$p.dispose();
        }
    }
}
