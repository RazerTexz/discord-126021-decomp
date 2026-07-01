package com.discord.widgets.directories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.R$layout;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import com.discord.databinding.DirectoryEntryListItemBinding;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.directories.ServerDiscoveryItem;
import d0.t.n;
import d0.z.d.m;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: WidgetDirectoryChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannelAdapter extends RecyclerView$Adapter<RecyclerView$ViewHolder> {
    private final DirectoryChannelItemClickInterface clickListener;
    private List<? extends DirectoryChannelItem> directoryChannelItems;

    public WidgetDirectoryChannelAdapter(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        m.checkNotNullParameter(directoryChannelItemClickInterface, "clickListener");
        this.clickListener = directoryChannelItemClickInterface;
        this.directoryChannelItems = n.emptyList();
    }

    public final DirectoryChannelItemClickInterface getClickListener() {
        return this.clickListener;
    }

    public final List<DirectoryChannelItem> getDirectoryChannelItems() {
        return this.directoryChannelItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.directoryChannelItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemViewType(int position) {
        return this.directoryChannelItems.get(position).getViewType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(RecyclerView$ViewHolder holder, int position) {
        m.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof DirectoryChannelViewHolder)) {
            holder = null;
        }
        DirectoryChannelViewHolder directoryChannelViewHolder = (DirectoryChannelViewHolder) holder;
        if (directoryChannelViewHolder != null) {
            directoryChannelViewHolder.bind(this.directoryChannelItems.get(position), this.clickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public RecyclerView$ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        m.checkNotNullParameter(parent, "parent");
        int iOrdinal = DirectoryChannelItem$ViewType.Companion.findType(viewType).ordinal();
        if (iOrdinal == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.directory_entry_list_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ServerDiscoveryItem serverDiscoveryItem = (ServerDiscoveryItem) viewInflate;
            DirectoryEntryListItemBinding directoryEntryListItemBinding = new DirectoryEntryListItemBinding(serverDiscoveryItem, serverDiscoveryItem);
            m.checkNotNullExpressionValue(directoryEntryListItemBinding, "DirectoryEntryListItemBi…          false\n        )");
            return new DirectoryEntryViewHolder(directoryEntryListItemBinding);
        }
        if (iOrdinal == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R$layout.directory_add_server_list_item, parent, false);
            Objects.requireNonNull(viewInflate2, "rootView");
            TextView textView = (TextView) viewInflate2;
            DirectoryAddServerListItemBinding directoryAddServerListItemBinding = new DirectoryAddServerListItemBinding(textView, textView);
            m.checkNotNullExpressionValue(directoryAddServerListItemBinding, "DirectoryAddServerListIt…          false\n        )");
            return new AddServerViewHolder(directoryAddServerListItemBinding);
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R$layout.directory_section_header_list_item, parent, false);
        Objects.requireNonNull(viewInflate3, "rootView");
        TextView textView2 = (TextView) viewInflate3;
        DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding = new DirectorySectionHeaderListItemBinding(textView2, textView2);
        m.checkNotNullExpressionValue(directorySectionHeaderListItemBinding, "DirectorySectionHeaderLi…          false\n        )");
        return new SectionHeaderViewHolder(directorySectionHeaderListItemBinding);
    }

    public final void setDirectoryChannelItems(List<? extends DirectoryChannelItem> list) {
        m.checkNotNullParameter(list, "value");
        this.directoryChannelItems = list;
        notifyDataSetChanged();
    }
}
