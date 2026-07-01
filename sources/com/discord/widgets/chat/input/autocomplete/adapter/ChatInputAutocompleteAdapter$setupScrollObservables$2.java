package com.discord.widgets.chat.input.autocomplete.adapter;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$LayoutManager;
import d0.z.d.o;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ChatInputAutocompleteAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ChatInputAutocompleteAdapter$setupScrollObservables$2 extends o implements Function1<Object, Unit> {
    public final /* synthetic */ RecyclerView $recyclerView;
    public final /* synthetic */ ChatInputAutocompleteAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChatInputAutocompleteAdapter$setupScrollObservables$2(ChatInputAutocompleteAdapter chatInputAutocompleteAdapter, RecyclerView recyclerView) {
        super(1);
        this.this$0 = chatInputAutocompleteAdapter;
        this.$recyclerView = recyclerView;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Object obj) {
        invoke2(obj);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(Object obj) {
        Function2 function2Access$getOnScrollPositionListener$p = ChatInputAutocompleteAdapter.access$getOnScrollPositionListener$p(this.this$0);
        if (function2Access$getOnScrollPositionListener$p == null || !(this.$recyclerView.getLayoutManager() instanceof LinearLayoutManager)) {
            return;
        }
        RecyclerView$LayoutManager layoutManager = this.$recyclerView.getLayoutManager();
        Objects.requireNonNull(layoutManager, "null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
        function2Access$getOnScrollPositionListener$p.invoke(Integer.valueOf(linearLayoutManager.findFirstVisibleItemPosition()), Integer.valueOf(linearLayoutManager.findLastVisibleItemPosition()));
    }
}
