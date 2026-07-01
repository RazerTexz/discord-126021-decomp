package com.discord.widgets.guilds.invite;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetGuildInviteShareCompact.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetGuildInviteShareCompact$PrivateChannelAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItem> {
    private Function1<? super InviteSuggestionItem, Unit> onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildInviteShareCompact$PrivateChannelAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClick = WidgetGuildInviteShareCompact$PrivateChannelAdapter$onClick$1.INSTANCE;
    }

    public final Function1<InviteSuggestionItem, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClick(Function1<? super InviteSuggestionItem, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new WidgetGuildInviteShareCompact$PrivateChannelAdapter$Item(this);
    }
}
