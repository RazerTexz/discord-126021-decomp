package com.discord.widgets.guilds.invite;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: InviteSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class InviteSuggestionsAdapter extends MGRecyclerAdapterSimple<InviteSuggestionItemV2> {
    private Function1<? super InviteSuggestionItemV2, Unit> onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InviteSuggestionsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClick = InviteSuggestionsAdapter$onClick$1.INSTANCE;
    }

    public final Function1<InviteSuggestionItemV2, Unit> getOnClick() {
        return this.onClick;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClick(Function1<? super InviteSuggestionItemV2, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onClick = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<InviteSuggestionsAdapter, InviteSuggestionItemV2> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        if (viewType == 1) {
            return new InviteSuggestionsAdapter$EmptySearchResultsViewHolder(this);
        }
        if (viewType == 2 || viewType == 3) {
            return new InviteSuggestionsAdapter$InviteSuggestionViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
