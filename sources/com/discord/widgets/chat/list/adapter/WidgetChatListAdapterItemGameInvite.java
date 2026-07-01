package com.discord.widgets.chat.list.adapter;

import android.content.Context;
import android.view.View;
import androidx.cardview.widget.CardView;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.WidgetChatListAdapterItemGameInviteBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.analytics.Traits$Payment$Type;
import com.discord.utilities.rx.ObservableExtensionsKt;
import com.discord.widgets.chat.list.ViewEmbedGameInvite;
import com.discord.widgets.chat.list.ViewEmbedGameInvite$Model;
import com.discord.widgets.chat.list.entries.ChatListEntry;
import com.discord.widgets.chat.list.entries.GameInviteEntry;
import d0.z.d.m;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import rx.Observable;
import rx.Subscription;

/* JADX INFO: compiled from: WidgetChatListAdapterItemGameInvite.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemGameInvite extends WidgetChatListItem {
    private final WidgetChatListAdapterItemGameInviteBinding binding;
    private Subscription subscription;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemGameInvite(WidgetChatListAdapter widgetChatListAdapter) {
        super(R$layout.widget_chat_list_adapter_item_game_invite, widgetChatListAdapter);
        m.checkNotNullParameter(widgetChatListAdapter, "adapter");
        View view = this.itemView;
        ViewEmbedGameInvite viewEmbedGameInvite = (ViewEmbedGameInvite) view.findViewById(R$id.item_game_invite);
        if (viewEmbedGameInvite == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.item_game_invite)));
        }
        WidgetChatListAdapterItemGameInviteBinding widgetChatListAdapterItemGameInviteBinding = new WidgetChatListAdapterItemGameInviteBinding((CardView) view, viewEmbedGameInvite);
        m.checkNotNullExpressionValue(widgetChatListAdapterItemGameInviteBinding, "WidgetChatListAdapterIte…iteBinding.bind(itemView)");
        this.binding = widgetChatListAdapterItemGameInviteBinding;
    }

    public static final /* synthetic */ WidgetChatListAdapter access$getAdapter$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return (WidgetChatListAdapter) widgetChatListAdapterItemGameInvite.adapter;
    }

    public static final /* synthetic */ WidgetChatListAdapterItemGameInviteBinding access$getBinding$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return widgetChatListAdapterItemGameInvite.binding;
    }

    public static final /* synthetic */ Subscription access$getSubscription$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite) {
        return widgetChatListAdapterItemGameInvite.subscription;
    }

    public static final /* synthetic */ void access$setSubscription$p(WidgetChatListAdapterItemGameInvite widgetChatListAdapterItemGameInvite, Subscription subscription) {
        widgetChatListAdapterItemGameInvite.subscription = subscription;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public Subscription getSubscription() {
        return this.subscription;
    }

    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, ChatListEntry chatListEntry) {
        onConfigure(i, chatListEntry);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.discord.widgets.chat.list.adapter.WidgetChatListItem
    public void onConfigure(int position, ChatListEntry data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        GameInviteEntry gameInviteEntry = (GameInviteEntry) data;
        this.binding.f2319b.setOnActionButtonClick(new WidgetChatListAdapterItemGameInvite$onConfigure$1(this, gameInviteEntry));
        Observable observableUi = ObservableExtensionsKt.ui(ViewEmbedGameInvite$Model.Companion.get(gameInviteEntry));
        WidgetChatListAdapterItemGameInvite$onConfigure$2 widgetChatListAdapterItemGameInvite$onConfigure$2 = new WidgetChatListAdapterItemGameInvite$onConfigure$2(this);
        String simpleName = WidgetChatListAdapterItemGameInvite.class.getSimpleName();
        m.checkNotNullExpressionValue(simpleName, "javaClass.simpleName");
        ObservableExtensionsKt.appSubscribe$default(observableUi, (Context) null, simpleName, new WidgetChatListAdapterItemGameInvite$onConfigure$3(this), widgetChatListAdapterItemGameInvite$onConfigure$2, (Function1) null, (Function0) null, (Function0) null, 113, (Object) null);
    }
}
