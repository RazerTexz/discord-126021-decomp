package com.discord.widgets.channels;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.a.k.b;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.app.AppComponent;
import com.discord.databinding.ViewGuildRoleSubscriptionChannelItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.recycler.DiffCreator;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetChannelPickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetchannelPickerAdapter extends RecyclerView$Adapter<ChannelPickerViewHolder> {
    public static final WidgetchannelPickerAdapter$Companion Companion = new WidgetchannelPickerAdapter$Companion(null);
    private static final int VIEW_TYPE_CHANNEL_ITEM = 1;
    private static final int VIEW_TYPE_CREATE_CHANNEL = 0;
    private final DiffCreator<List<ChannelPickerAdapterItem>, ChannelPickerViewHolder> diffCreator;
    private List<? extends ChannelPickerAdapterItem> items;
    private final WidgetchannelPickerAdapter$OnItemClickListener listener;

    public /* synthetic */ WidgetchannelPickerAdapter(WidgetchannelPickerAdapter$OnItemClickListener widgetchannelPickerAdapter$OnItemClickListener, AppComponent appComponent, DiffCreator diffCreator, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(widgetchannelPickerAdapter$OnItemClickListener, appComponent, (i & 4) != 0 ? new DiffCreator(appComponent) : diffCreator);
    }

    public static final /* synthetic */ List access$getItems$p(WidgetchannelPickerAdapter widgetchannelPickerAdapter) {
        return widgetchannelPickerAdapter.items;
    }

    public static final /* synthetic */ void access$setItems$p(WidgetchannelPickerAdapter widgetchannelPickerAdapter, List list) {
        widgetchannelPickerAdapter.items = list;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.items.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        ChannelPickerAdapterItem channelPickerAdapterItem = this.items.get(position);
        if (channelPickerAdapterItem instanceof ChannelPickerAdapterItem$CreateChannelItem) {
            return 0;
        }
        if (channelPickerAdapterItem instanceof ChannelPickerAdapterItem$ChannelItem) {
            return 1;
        }
        throw new NoWhenBranchMatchedException();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        onBindViewHolder((ChannelPickerViewHolder) recyclerView$ViewHolder, i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public /* bridge */ /* synthetic */ RecyclerView$ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return onCreateViewHolder(viewGroup, i);
    }

    public final void setItems(List<? extends ChannelPickerAdapterItem> newItems) {
        m.checkNotNullParameter(newItems, "newItems");
        this.diffCreator.dispatchDiffUpdatesAsync(this, new WidgetchannelPickerAdapter$setItems$1(this), this.items, newItems);
    }

    public WidgetchannelPickerAdapter(WidgetchannelPickerAdapter$OnItemClickListener widgetchannelPickerAdapter$OnItemClickListener, AppComponent appComponent, DiffCreator<List<ChannelPickerAdapterItem>, ChannelPickerViewHolder> diffCreator) {
        m.checkNotNullParameter(widgetchannelPickerAdapter$OnItemClickListener, "listener");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(diffCreator, "diffCreator");
        this.listener = widgetchannelPickerAdapter$OnItemClickListener;
        this.diffCreator = diffCreator;
        this.items = n.emptyList();
    }

    public void onBindViewHolder(ChannelPickerViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (holder instanceof ChannelPickerViewHolder$ChannelItemViewHolder) {
            ((ChannelPickerViewHolder$ChannelItemViewHolder) holder).configure(this.items.get(position));
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public ChannelPickerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.view_guild_role_subscription_channel_item, parent, false);
        int i = R$id.channel_item_name;
        TextView textView = (TextView) viewInflate.findViewById(R$id.channel_item_name);
        if (textView != null) {
            i = R$id.channel_item_selected;
            ImageView imageView = (ImageView) viewInflate.findViewById(R$id.channel_item_selected);
            if (imageView != null) {
                i = R$id.channel_item_type_icon;
                ImageView imageView2 = (ImageView) viewInflate.findViewById(R$id.channel_item_type_icon);
                if (imageView2 != null) {
                    ViewGuildRoleSubscriptionChannelItemBinding viewGuildRoleSubscriptionChannelItemBinding = new ViewGuildRoleSubscriptionChannelItemBinding((LinearLayout) viewInflate, textView, imageView, imageView2);
                    m.checkNotNullExpressionValue(viewGuildRoleSubscriptionChannelItemBinding, "ViewGuildRoleSubscriptio…rent,\n        false\n    )");
                    if (viewType == 0) {
                        return new ChannelPickerViewHolder$CreateChannelViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new WidgetchannelPickerAdapter$onCreateViewHolder$1(this.listener));
                    }
                    if (viewType == 1) {
                        return new ChannelPickerViewHolder$ChannelItemViewHolder(viewGuildRoleSubscriptionChannelItemBinding, new WidgetchannelPickerAdapter$onCreateViewHolder$2(this.listener));
                    }
                    Context context = parent.getContext();
                    m.checkNotNullExpressionValue(context, "parent.context");
                    throw new IllegalArgumentException(b.h(context, 2131886424, new Object[]{Integer.valueOf(viewType)}, null, 4).toString());
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }
}
