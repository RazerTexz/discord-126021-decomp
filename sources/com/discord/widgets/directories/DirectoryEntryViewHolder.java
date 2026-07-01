package com.discord.widgets.directories;

import com.discord.api.directory.DirectoryEntryGuild;
import com.discord.databinding.DirectoryEntryListItemBinding;
import com.discord.utilities.guilds.GuildUtilsKt;
import com.discord.utilities.icon.IconUtils;
import com.discord.views.directories.ServerDiscoveryItem;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryEntryViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryEntryListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public DirectoryEntryViewHolder(DirectoryEntryListItemBinding directoryEntryListItemBinding) {
        m.checkNotNullParameter(directoryEntryListItemBinding, "viewBinding");
        ServerDiscoveryItem serverDiscoveryItem = directoryEntryListItemBinding.a;
        m.checkNotNullExpressionValue(serverDiscoveryItem, "viewBinding.root");
        super(serverDiscoveryItem);
        this.viewBinding = directoryEntryListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        DirectoryEntryData directoryEntryData;
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(listener, "listener");
        if (!(item instanceof DirectoryChannelItem$DirectoryItem)) {
            item = null;
        }
        DirectoryChannelItem$DirectoryItem directoryChannelItem$DirectoryItem = (DirectoryChannelItem$DirectoryItem) item;
        if (directoryChannelItem$DirectoryItem == null || (directoryEntryData = directoryChannelItem$DirectoryItem.getDirectoryEntryData()) == null) {
            return;
        }
        DirectoryEntryGuild entry = directoryEntryData.getEntry();
        ServerDiscoveryItem serverDiscoveryItem = this.viewBinding.f2096b;
        serverDiscoveryItem.setTitle(entry.getGuild().getName());
        serverDiscoveryItem.setDescription(entry.getDescription());
        Integer approximateMemberCount = entry.getGuild().getApproximateMemberCount();
        serverDiscoveryItem.setMembers(approximateMemberCount != null ? approximateMemberCount.intValue() : 0);
        Integer approximatePresenceCount = entry.getGuild().getApproximatePresenceCount();
        serverDiscoveryItem.setOnline(approximatePresenceCount != null ? approximatePresenceCount.intValue() : 0);
        String forGuild$default = IconUtils.getForGuild$default(Long.valueOf(entry.getGuild().getId()), entry.getGuild().getIcon(), null, false, null, 28, null);
        String strComputeShortName = GuildUtilsKt.computeShortName(entry.getGuild().getName());
        m.checkNotNullParameter(strComputeShortName, "fallbackText");
        serverDiscoveryItem.binding.f.a(forGuild$default, strComputeShortName);
        if (directoryEntryData.getHasJoinedGuild()) {
            serverDiscoveryItem.setJoinButtonOnClickListener(null);
            serverDiscoveryItem.setJoinedButtonOnClickListener(new DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2(entry, directoryEntryData, listener));
        } else {
            serverDiscoveryItem.setJoinButtonOnClickListener(new DirectoryEntryViewHolder$bind$$inlined$apply$lambda$1(entry, directoryEntryData, listener));
            serverDiscoveryItem.setJoinedButtonOnClickListener(null);
        }
        serverDiscoveryItem.setOnLongClickListener(new DirectoryEntryViewHolder$bind$$inlined$apply$lambda$3(entry, directoryEntryData, listener));
        serverDiscoveryItem.setJoinedGuild(directoryEntryData.getHasJoinedGuild());
    }

    public final DirectoryEntryListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
