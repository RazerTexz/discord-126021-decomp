package com.discord.widgets.chat.list.adapter;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.utilities.mg_recycler.MGRecyclerAdapter;
import com.discord.widgets.channels.list.WidgetCollapsedUsersListAdapter;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatListAdapterItemSpotifyListenTogether.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatListAdapterItemSpotifyListenTogether$userAdapter$2 extends AbstractC12240o implements Function0<WidgetCollapsedUsersListAdapter> {
    public final /* synthetic */ WidgetChatListAdapterItemSpotifyListenTogether this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatListAdapterItemSpotifyListenTogether$userAdapter$2(WidgetChatListAdapterItemSpotifyListenTogether widgetChatListAdapterItemSpotifyListenTogether) {
        super(0);
        this.this$0 = widgetChatListAdapterItemSpotifyListenTogether;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final WidgetCollapsedUsersListAdapter invoke() {
        MGRecyclerAdapter.Companion companion = MGRecyclerAdapter.INSTANCE;
        RecyclerView recyclerView = this.this$0.binding.f16279f;
        C12238m.checkNotNullExpressionValue(recyclerView, "binding.itemListenTogetherRecycler");
        return (WidgetCollapsedUsersListAdapter) companion.configure(new WidgetCollapsedUsersListAdapter(recyclerView));
    }
}
