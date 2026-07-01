package com.discord.widgets.chat.list.adapter;

import android.view.View;
import com.discord.api.activity.Activity;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.z.d.m;
import d0.z.d.o;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite$onConfigure$1 extends o implements Function2<View, ViewEmbedGameInvite$Model, Unit> {
    public final /* synthetic */ GameInviteEntry $item;
    public final /* synthetic */ WidgetChatListAdapterItemGameInvite this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite$onConfigure$1(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite, GameInviteEntry gameInviteEntry) {
        super(2);
        this.this$0 = widgetChatListAdapterItemGameInvite;
        this.$item = gameInviteEntry;
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Unit invoke(View view, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model) {
        invoke2(view, viewEmbedGameInvite$Model);
        return Unit.a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(View view, ViewEmbedGameInvite$Model viewEmbedGameInvite$Model) {
        m.checkNotNullParameter(view, "<anonymous parameter 0>");
        m.checkNotNullParameter(viewEmbedGameInvite$Model, "model");
        Activity activity = viewEmbedGameInvite$Model.getActivity();
        if (activity != null) {
            WidgetChatListAdapterItemGameInvite.access$getAdapter$p(this.this$0).onUserActivityAction(this.$item.getAuthorId(), this.$item.getMessageId(), this.$item.getActivity().getType(), activity, this.$item.getApplication());
        }
    }
}
