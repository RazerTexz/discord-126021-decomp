package com.discord.widgets.search.suggestions;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.search.query.FilterType;
import com.discord.utilities.search.query.node.QueryNode;
import com.discord.utilities.search.query.node.answer.HasAnswerOption;
import com.discord.utilities.search.suggestion.entries.ChannelSuggestion;
import com.discord.utilities.search.suggestion.entries.UserSuggestion;
import d0.z.d.m;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetSearchSuggestionsAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetSearchSuggestionsAdapter extends MGRecyclerAdapterSimple<MGRecyclerDataPayload> {
    public static final WidgetSearchSuggestionsAdapter$Companion Companion = new WidgetSearchSuggestionsAdapter$Companion(null);
    private static final int TYPE_FILTER = 2;
    private static final int TYPE_HAS = 5;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_HISTORY_HEADER = 1;
    private static final int TYPE_IN_CHANNEL = 4;
    private static final int TYPE_RECENT_QUERY = 6;
    private static final int TYPE_USER = 3;
    private Function1<? super ChannelSuggestion, Unit> onChannelClicked;
    private Function0<Unit> onClearHistoryClicked;
    private Function1<? super FilterType, Unit> onFilterClicked;
    private Function1<? super HasAnswerOption, Unit> onHasClicked;
    private Function1<? super List<? extends QueryNode>, Unit> onRecentQueryClicked;
    private Function1<? super UserSuggestion, Unit> onUserClicked;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetSearchSuggestionsAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        m.checkNotNullParameter(recyclerView, "recycler");
        this.onFilterClicked = WidgetSearchSuggestionsAdapter$onFilterClicked$1.INSTANCE;
        this.onUserClicked = WidgetSearchSuggestionsAdapter$onUserClicked$1.INSTANCE;
        this.onChannelClicked = WidgetSearchSuggestionsAdapter$onChannelClicked$1.INSTANCE;
        this.onHasClicked = WidgetSearchSuggestionsAdapter$onHasClicked$1.INSTANCE;
        this.onRecentQueryClicked = WidgetSearchSuggestionsAdapter$onRecentQueryClicked$1.INSTANCE;
        this.onClearHistoryClicked = WidgetSearchSuggestionsAdapter$onClearHistoryClicked$1.INSTANCE;
    }

    public final Function1<ChannelSuggestion, Unit> getOnChannelClicked() {
        return this.onChannelClicked;
    }

    public final Function0<Unit> getOnClearHistoryClicked() {
        return this.onClearHistoryClicked;
    }

    public final Function1<FilterType, Unit> getOnFilterClicked() {
        return this.onFilterClicked;
    }

    public final Function1<HasAnswerOption, Unit> getOnHasClicked() {
        return this.onHasClicked;
    }

    public final Function1<List<? extends QueryNode>, Unit> getOnRecentQueryClicked() {
        return this.onRecentQueryClicked;
    }

    public final Function1<UserSuggestion, Unit> getOnUserClicked() {
        return this.onUserClicked;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setOnChannelClicked(Function1<? super ChannelSuggestion, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onChannelClicked = function1;
    }

    public final void setOnClearHistoryClicked(Function0<Unit> function0) {
        m.checkNotNullParameter(function0, "<set-?>");
        this.onClearHistoryClicked = function0;
    }

    public final void setOnFilterClicked(Function1<? super FilterType, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onFilterClicked = function1;
    }

    public final void setOnHasClicked(Function1<? super HasAnswerOption, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onHasClicked = function1;
    }

    public final void setOnRecentQueryClicked(Function1<? super List<? extends QueryNode>, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onRecentQueryClicked = function1;
    }

    public final void setOnUserClicked(Function1<? super UserSuggestion, Unit> function1) {
        m.checkNotNullParameter(function1, "<set-?>");
        this.onUserClicked = function1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public MGRecyclerViewHolder<?, MGRecyclerDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        switch (viewType) {
            case 0:
                return new WidgetSearchSuggestionsAdapter$HeaderViewHolder(this);
            case 1:
                return new WidgetSearchSuggestionsAdapter$HistoryHeaderViewHolder(this);
            case 2:
                return new WidgetSearchSuggestionsAdapter$FilterViewHolder(this);
            case 3:
                return new WidgetSearchSuggestionsAdapter$UserViewHolder(this);
            case 4:
                return new WidgetSearchSuggestionsAdapter$InChannelViewHolder(this);
            case 5:
                return new WidgetSearchSuggestionsAdapter$HasViewHolder(this);
            case 6:
                return new WidgetSearchSuggestionsAdapter$RecentQueryViewHolder(this);
            default:
                throw invalidViewTypeException(viewType);
        }
    }
}
