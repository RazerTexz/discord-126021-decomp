package com.discord.widgets.directories;

import android.view.View;
import android.view.View$OnLongClickListener;
import com.discord.api.directory.DirectoryEntryGuild;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryEntryViewHolder$bind$$inlined$apply$lambda$3 implements View$OnLongClickListener {
    public final /* synthetic */ DirectoryEntryGuild $data$inlined;
    public final /* synthetic */ DirectoryEntryData $entryData$inlined;
    public final /* synthetic */ DirectoryChannelItemClickInterface $listener$inlined;

    public DirectoryEntryViewHolder$bind$$inlined$apply$lambda$3(DirectoryEntryGuild directoryEntryGuild, DirectoryEntryData directoryEntryData, DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        this.$data$inlined = directoryEntryGuild;
        this.$entryData$inlined = directoryEntryData;
        this.$listener$inlined = directoryChannelItemClickInterface;
    }

    @Override // android.view.View$OnLongClickListener
    public final boolean onLongClick(View view) {
        DirectoryChannelItemClickInterface directoryChannelItemClickInterface = this.$listener$inlined;
        DirectoryEntryGuild directoryEntryGuild = this.$data$inlined;
        directoryChannelItemClickInterface.onOverflowClicked(directoryEntryGuild, directoryEntryGuild.getDirectoryChannelId(), this.$entryData$inlined.getHasEditPermissions());
        return true;
    }
}
