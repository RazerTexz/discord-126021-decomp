package com.discord.widgets.directories;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import com.discord.databinding.DirectoryEntryListItemBinding;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.views.directories.ServerDiscoveryItem;
import com.discord.widgets.directories.DirectoryChannelItem;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;

/* JADX INFO: compiled from: WidgetDirectoryChannelAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetDirectoryChannelAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final DirectoryChannelItemClickInterface clickListener;
    private List<? extends DirectoryChannelItem> directoryChannelItems;

    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            DirectoryChannelItem.ViewType.values();
            int[] iArr = new int[3];
            $EnumSwitchMapping$0 = iArr;
            iArr[DirectoryChannelItem.ViewType.Item.ordinal()] = 1;
            iArr[DirectoryChannelItem.ViewType.AddServer.ordinal()] = 2;
            iArr[DirectoryChannelItem.ViewType.SectionHeader.ordinal()] = 3;
        }
    }

    public WidgetDirectoryChannelAdapter(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        Intrinsics3.checkNotNullParameter(directoryChannelItemClickInterface, "clickListener");
        this.clickListener = directoryChannelItemClickInterface;
        this.directoryChannelItems = Collections2.emptyList();
    }

    public final DirectoryChannelItemClickInterface getClickListener() {
        return this.clickListener;
    }

    public final List<DirectoryChannelItem> getDirectoryChannelItems() {
        return this.directoryChannelItems;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.directoryChannelItems.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return this.directoryChannelItems.get(position).getViewType().ordinal();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        if (!(holder instanceof DirectoryChannelViewHolder)) {
            holder = null;
        }
        DirectoryChannelViewHolder directoryChannelViewHolder = (DirectoryChannelViewHolder) holder;
        if (directoryChannelViewHolder != null) {
            directoryChannelViewHolder.bind(this.directoryChannelItems.get(position), this.clickListener);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        int iOrdinal = DirectoryChannelItem.ViewType.INSTANCE.findType(viewType).ordinal();
        if (iOrdinal == 0) {
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_entry_list_item, parent, false);
            Objects.requireNonNull(viewInflate, "rootView");
            ServerDiscoveryItem serverDiscoveryItem = (ServerDiscoveryItem) viewInflate;
            DirectoryEntryListItemBinding directoryEntryListItemBinding = new DirectoryEntryListItemBinding(serverDiscoveryItem, serverDiscoveryItem);
            Intrinsics3.checkNotNullExpressionValue(directoryEntryListItemBinding, "DirectoryEntryListItemBi…          false\n        )");
            return new DirectoryEntryViewHolder(directoryEntryListItemBinding);
        }
        if (iOrdinal == 1) {
            View viewInflate2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_add_server_list_item, parent, false);
            Objects.requireNonNull(viewInflate2, "rootView");
            TextView textView = (TextView) viewInflate2;
            DirectoryAddServerListItemBinding directoryAddServerListItemBinding = new DirectoryAddServerListItemBinding(textView, textView);
            Intrinsics3.checkNotNullExpressionValue(directoryAddServerListItemBinding, "DirectoryAddServerListIt…          false\n        )");
            return new AddServerViewHolder(directoryAddServerListItemBinding);
        }
        if (iOrdinal != 2) {
            throw new NoWhenBranchMatchedException();
        }
        View viewInflate3 = LayoutInflater.from(parent.getContext()).inflate(R.layout.directory_section_header_list_item, parent, false);
        Objects.requireNonNull(viewInflate3, "rootView");
        TextView textView2 = (TextView) viewInflate3;
        DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding = new DirectorySectionHeaderListItemBinding(textView2, textView2);
        Intrinsics3.checkNotNullExpressionValue(directorySectionHeaderListItemBinding, "DirectorySectionHeaderLi…          false\n        )");
        return new SectionHeaderViewHolder(directorySectionHeaderListItemBinding);
    }

    public final void setDirectoryChannelItems(List<? extends DirectoryChannelItem> list) {
        Intrinsics3.checkNotNullParameter(list, "value");
        this.directoryChannelItems = list;
        notifyDataSetChanged();
    }
}
