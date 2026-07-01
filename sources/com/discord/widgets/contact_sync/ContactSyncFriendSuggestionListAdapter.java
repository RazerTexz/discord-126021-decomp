package com.discord.widgets.contact_sync;

import android.content.Context;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ContactSyncFriendSuggestionListAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ContactSyncFriendSuggestionListAdapter extends MGRecyclerAdapterSimple<WidgetContactSyncViewModel$Item> {
    private Function2<? super Long, ? super Boolean, Unit> onClickFriendSuggestion;
    private final int spacing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ContactSyncFriendSuggestionListAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onClickFriendSuggestion = ContactSyncFriendSuggestionListAdapter$onClickFriendSuggestion$1.INSTANCE;
        Context context = recyclerView.getContext();
        m.checkNotNullExpressionValue(context, "recycler.context");
        this.spacing = context.getResources().getDimensionPixelSize(2131165745);
    }

    public static final /* synthetic */ int access$getSpacing$p(ContactSyncFriendSuggestionListAdapter contactSyncFriendSuggestionListAdapter) {
        return contactSyncFriendSuggestionListAdapter.spacing;
    }

    public final Function2<Long, Boolean, Unit> getOnClickFriendSuggestion() {
        return this.onClickFriendSuggestion;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnClickFriendSuggestion(Function2<? super Long, ? super Boolean, Unit> function2) {
        m.checkNotNullParameter(function2, "<set-?>");
        this.onClickFriendSuggestion = function2;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, WidgetContactSyncViewModel$Item> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        return new ContactSyncFriendSuggestionListAdapter$ItemFriendSuggestion(this);
    }
}
