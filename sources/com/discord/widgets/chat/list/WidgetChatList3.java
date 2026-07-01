package com.discord.widgets.chat.list;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.WidgetChatListBinding;
import com.discord.widgets.chat.list.adapter.WidgetChatListAdapter;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.chat.list.WidgetChatList$binding$3, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatList.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatList3 extends Lambda implements Function1<WidgetChatListBinding, Unit> {
    public final /* synthetic */ WidgetChatList this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatList3(WidgetChatList widgetChatList) {
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
        Intrinsics3.checkNotNullParameter(widgetChatListBinding, "binding");
        RecyclerView recyclerView = widgetChatListBinding.f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView, "binding.chatListRecycler");
        recyclerView.setLayoutManager(null);
        RecyclerView recyclerView2 = widgetChatListBinding.f2343b;
        Intrinsics3.checkNotNullExpressionValue(recyclerView2, "binding.chatListRecycler");
        recyclerView2.setAdapter(null);
        WidgetChatListAdapter widgetChatListAdapter = this.this$0.adapter;
        if (widgetChatListAdapter != null) {
            widgetChatListAdapter.dispose();
        }
    }
}
