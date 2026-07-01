package com.discord.widgets.directories;

import android.view.View;
import android.view.View$OnClickListener;
import com.discord.api.directory.DirectoryEntryGuild;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2 implements View$OnClickListener {
    public final /* synthetic */ DirectoryEntryGuild $data$inlined;
    public final /* synthetic */ DirectoryEntryData $entryData$inlined;
    public final /* synthetic */ DirectoryChannelItemClickInterface $listener$inlined;

    public DirectoryEntryViewHolder$bind$$inlined$apply$lambda$2(DirectoryEntryGuild directoryEntryGuild, DirectoryEntryData directoryEntryData, DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        this.$data$inlined = directoryEntryGuild;
        this.$entryData$inlined = directoryEntryData;
        this.$listener$inlined = directoryChannelItemClickInterface;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$listener$inlined.onGoToGuildClicked(this.$data$inlined.getGuild().getId());
    }
}
