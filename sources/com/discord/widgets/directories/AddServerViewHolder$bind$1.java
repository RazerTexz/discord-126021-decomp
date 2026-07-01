package com.discord.widgets.directories;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddServerViewHolder$bind$1 implements View$OnClickListener {
    public final /* synthetic */ DirectoryChannelItemClickInterface $listener;

    public AddServerViewHolder$bind$1(DirectoryChannelItemClickInterface directoryChannelItemClickInterface) {
        this.$listener = directoryChannelItemClickInterface;
    }

    @Override // android.view.View$OnClickListener
    public final void onClick(View view) {
        this.$listener.onAddServerClicked();
    }
}
