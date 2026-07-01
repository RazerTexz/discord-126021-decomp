package com.discord.widgets.chat.list.adapter;

import android.view.View;
import android.view.View$OnClickListener;
import androidx.fragment.app.ViewKt;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGuildScheduledEventInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$5 implements View$OnClickListener {
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite$Model $model;
    public final /* synthetic */ WidgetChatListAdapterItemGuildScheduledEventInvite this$0;

    public WidgetChatListAdapterItemGuildScheduledEventInvite$configureUI$5(WidgetChatListAdapterItemGuildScheduledEventInvite widgetChatListAdapterItemGuildScheduledEventInvite, WidgetChatListAdapterItemGuildScheduledEventInvite$Model widgetChatListAdapterItemGuildScheduledEventInvite$Model) {
        this.this$0 = widgetChatListAdapterItemGuildScheduledEventInvite;
        this.$model = widgetChatListAdapterItemGuildScheduledEventInvite$Model;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(this.this$0).onShareButtonClick(this.$model.getGuildScheduledEvent(), new WeakReference<>(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(this.this$0).getContext()), new WeakReference<>(ViewKt.findFragment(WidgetChatListAdapterItemGuildScheduledEventInvite.access$getAdapter$p(this.this$0).getRecycler())));
    }
}
