package com.discord.widgets.user.search;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.WidgetChannelSearchItemHeaderBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerAdapterSimple;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.user.search.WidgetGlobalSearchAdapter;
import com.discord.widgets.user.search.WidgetGlobalSearchModel;
import d0.z.d.Intrinsics3;
import java.util.Objects;
import kotlin.Unit;
import kotlin.jvm.functions.Function4;

/* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WidgetGlobalSearchAdapter extends MGRecyclerAdapterSimple<WidgetGlobalSearchModel.ItemDataPayload> {
    private Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel.ItemDataPayload, ? super Boolean, Unit> onSelectedListener;

    /* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class ChannelViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ChannelViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemChannel) data);
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class GuildViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public GuildViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemGuild) data);
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class HeaderViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> {
        private final WidgetChannelSearchItemHeaderBinding binding;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public HeaderViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(R.layout.widget_channel_search_item_header, widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "rootView");
            TextView textView = (TextView) view;
            WidgetChannelSearchItemHeaderBinding widgetChannelSearchItemHeaderBinding = new WidgetChannelSearchItemHeaderBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(widgetChannelSearchItemHeaderBinding, "WidgetChannelSearchItemH…derBinding.bind(itemView)");
            this.binding = widgetChannelSearchItemHeaderBinding;
        }

        public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(HeaderViewHolder headerViewHolder) {
            return (WidgetGlobalSearchAdapter) headerViewHolder.adapter;
        }

        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(final int position, final WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.binding.f2266b.setText(((WidgetGlobalSearchModel.ItemHeader) data).getName());
            this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$HeaderViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> onSelectedListener = WidgetGlobalSearchAdapter.HeaderViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener();
                    Intrinsics3.checkNotNullExpressionValue(view, "view");
                    onSelectedListener.invoke(view, Integer.valueOf(position), data, Boolean.FALSE);
                }
            });
            TextView textView = this.binding.a;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.root");
            ViewExtensions.setOnLongClickListenerConsumeClick(textView, new WidgetGlobalSearchAdapter3(this, position, data));
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
    public static abstract class SearchViewHolder extends MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> {
        private final ViewGlobalSearchItem viewGlobalSearchItem;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SearchViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(R.layout.widget_channel_search_item, widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
            View view = this.itemView;
            Objects.requireNonNull(view, "null cannot be cast to non-null type com.discord.widgets.user.search.ViewGlobalSearchItem");
            ViewGlobalSearchItem viewGlobalSearchItem = (ViewGlobalSearchItem) view;
            viewGlobalSearchItem.setSelected(true);
            this.viewGlobalSearchItem = viewGlobalSearchItem;
        }

        public static final /* synthetic */ WidgetGlobalSearchAdapter access$getAdapter$p(SearchViewHolder searchViewHolder) {
            return (WidgetGlobalSearchAdapter) searchViewHolder.adapter;
        }

        public final ViewGlobalSearchItem getViewGlobalSearchItem() {
            return this.viewGlobalSearchItem;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(final int position, final WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            this.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.user.search.WidgetGlobalSearchAdapter$SearchViewHolder$onConfigure$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> onSelectedListener = WidgetGlobalSearchAdapter.SearchViewHolder.access$getAdapter$p(this.this$0).getOnSelectedListener();
                    Intrinsics3.checkNotNullExpressionValue(view, "view");
                    onSelectedListener.invoke(view, Integer.valueOf(position), data, Boolean.FALSE);
                }
            });
            View view = this.itemView;
            Intrinsics3.checkNotNullExpressionValue(view, "itemView");
            ViewExtensions.setOnLongClickListenerConsumeClick(view, new WidgetGlobalSearchAdapter5(this, position, data));
        }
    }

    /* JADX INFO: compiled from: WidgetGlobalSearchAdapter.kt */
    public static final class UserViewHolder extends SearchViewHolder {
        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public UserViewHolder(WidgetGlobalSearchAdapter widgetGlobalSearchAdapter) {
            super(widgetGlobalSearchAdapter);
            Intrinsics3.checkNotNullParameter(widgetGlobalSearchAdapter, "adapter");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.discord.widgets.user.search.WidgetGlobalSearchAdapter.SearchViewHolder, com.discord.utilities.mg_recycler.MGRecyclerViewHolder
        public void onConfigure(int position, WidgetGlobalSearchModel.ItemDataPayload data) {
            Intrinsics3.checkNotNullParameter(data, "data");
            super.onConfigure(position, data);
            getViewGlobalSearchItem().onConfigure((WidgetGlobalSearchModel.ItemUser) data);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGlobalSearchAdapter(RecyclerView recyclerView) {
        super(recyclerView, false, 2, null);
        Intrinsics3.checkNotNullParameter(recyclerView, "recycler");
        this.onSelectedListener = WidgetGlobalSearchAdapter6.INSTANCE;
    }

    public final Function4<View, Integer, WidgetGlobalSearchModel.ItemDataPayload, Boolean, Unit> getOnSelectedListener() {
        return this.onSelectedListener;
    }

    public final void setOnSelectedListener(Function4<? super View, ? super Integer, ? super WidgetGlobalSearchModel.ItemDataPayload, ? super Boolean, Unit> function4) {
        Intrinsics3.checkNotNullParameter(function4, "<set-?>");
        this.onSelectedListener = function4;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public MGRecyclerViewHolder<WidgetGlobalSearchAdapter, WidgetGlobalSearchModel.ItemDataPayload> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        if (viewType == -1) {
            return new HeaderViewHolder(this);
        }
        if (viewType == 0) {
            return new ChannelViewHolder(this);
        }
        if (viewType == 1) {
            return new UserViewHolder(this);
        }
        if (viewType == 2) {
            return new GuildViewHolder(this);
        }
        throw invalidViewTypeException(viewType);
    }
}
