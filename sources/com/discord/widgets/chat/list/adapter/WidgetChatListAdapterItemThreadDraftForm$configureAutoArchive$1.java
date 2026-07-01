package com.discord.widgets.chat.list.adapter;

import com.discord.i18n.RenderContext;
import com.discord.stores.StoreThreadDraft$ThreadDraftState;
import com.discord.widgets.chat.list.entries.ThreadDraftFormEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetChatListAdapterItemThreadDraftForm.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1 extends o implements Function1<RenderContext, Unit> {
    public final /* synthetic */ ThreadDraftFormEntry $data;
    public final /* synthetic */ StoreThreadDraft$ThreadDraftState $draftState;
    public final /* synthetic */ WidgetChatListAdapterItemThreadDraftForm this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1(WidgetChatListAdapterItemThreadDraftForm widgetChatListAdapterItemThreadDraftForm, StoreThreadDraft$ThreadDraftState storeThreadDraft$ThreadDraftState, ThreadDraftFormEntry threadDraftFormEntry) {
        super(1);
        this.this$0 = widgetChatListAdapterItemThreadDraftForm;
        this.$draftState = storeThreadDraft$ThreadDraftState;
        this.$data = threadDraftFormEntry;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(RenderContext renderContext) {
        invoke2(renderContext);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(RenderContext renderContext) {
        m.checkNotNullParameter(renderContext, "$receiver");
        renderContext.a("durationHook", new WidgetChatListAdapterItemThreadDraftForm$configureAutoArchive$1$1(this));
    }
}
