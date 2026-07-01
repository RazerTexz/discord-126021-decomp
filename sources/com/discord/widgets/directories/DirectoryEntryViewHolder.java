package com.discord.widgets.directories;

import android.view.View;
import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.databinding.DirectoryEntryListItemBinding;
import com.discord.utilities.guilds.GuildUtils;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.directories.ServerDiscoveryItem;
import com.discord.widgets.directories.DirectoryChannelItem;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryEntryViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryEntryListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public DirectoryEntryViewHolder(DirectoryEntryListItemBinding directoryEntryListItemBinding) {
        Intrinsics3.checkNotNullParameter(directoryEntryListItemBinding, "viewBinding");
        ServerDiscoveryItem serverDiscoveryItem = directoryEntryListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(serverDiscoveryItem, "viewBinding.root");
        super(serverDiscoveryItem);
        this.viewBinding = directoryEntryListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, final DirectoryChannelItemClickInterface listener) {
        final DirectoryEntryData directoryEntryData;
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        if (!(item instanceof DirectoryChannelItem.DirectoryItem)) {
            item = null;
        }
        DirectoryChannelItem.DirectoryItem directoryItem = (DirectoryChannelItem.DirectoryItem) item;
        if (directoryItem == null || (directoryEntryData = directoryItem.getDirectoryEntryData()) == null) {
            return;
        }
        final DirectoryEntryGuild entry = directoryEntryData.getEntry();
        ServerDiscoveryItem serverDiscoveryItem = this.viewBinding.f2096b;
        serverDiscoveryItem.setTitle(entry.getGuild().getName());
        serverDiscoveryItem.setDescription(entry.getDescription());
        Integer approximateMemberCount = entry.getGuild().getApproximateMemberCount();
        serverDiscoveryItem.setMembers(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
        Integer approximatePresenceCount = entry.getGuild().getApproximatePresenceCount();
        serverDiscoveryItem.setOnline(approximatePresenceCount != null ? approximatePresenceCount.intValue() : 0);
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(entry.getGuild().getId()), entry.getGuild().getIcon(), null, false, null, 28, null);
        String strComputeShortName = GuildUtils.computeShortName(entry.getGuild().getName());
        Intrinsics3.checkNotNullParameter(strComputeShortName, "fallbackText");
        serverDiscoveryItem.binding.f.a(forGuild$default, strComputeShortName);
        if (directoryEntryData.getHasJoinedGuild()) {
            serverDiscoveryItem.setJoinButtonOnClickListener(null);
            serverDiscoveryItem.setJoinedButtonOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    listener.onGoToGuildClicked(entry.getGuild().getId());
                }
            });
        } else {
            serverDiscoveryItem.setJoinButtonOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.DirectoryEntryViewHolder$bind$$inlined$apply$lambda$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    listener.onEntryClicked(entry.getGuild().getId(), entry.getDirectoryChannelId());
                }
            });
            serverDiscoveryItem.setJoinedButtonOnClickListener(null);
        }
        serverDiscoveryItem.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.discord.widgets.directories.DirectoryEntryViewHolder$bind$$inlined$apply$lambda$3
            @Override // android.view.View.OnLongClickListener
            public final boolean onLongClick(View view) {
                DirectoryChannelItemClickInterface directoryChannelItemClickInterface = listener;
                DirectoryEntryGuild directoryEntryGuild = entry;
                directoryChannelItemClickInterface.onOverflowClicked(directoryEntryGuild, directoryEntryGuild.getDirectoryChannelId(), directoryEntryData.getHasEditPermissions());
                return true;
            }
        });
        serverDiscoveryItem.setJoinedGuild(directoryEntryData.getHasJoinedGuild());
    }

    public final DirectoryEntryListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
