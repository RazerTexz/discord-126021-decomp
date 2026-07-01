package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.widgets.channels.threads.WidgetThreadDraftArchiveSheet;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1$1 extends o implements Function1<View, Unit> {
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1$1(WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1 widgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1) {
        super(1);
        this.this$0 = widgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(View view) {
        invoke2(view);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view) {
        m.checkNotNullParameter(view, "it");
        WidgetThreadDraftArchiveSheet.Companion.show(WidgetChatListAdapterItemThreadDraftForm.access$getAdapter$p(this.this$0.this$0.this$0).getFragmentManager(), this.this$0.this$0.$data.getGuildId());
    }
}
