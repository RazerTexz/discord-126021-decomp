package com.discord.widgets.directories;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class DirectoryChannelViewHolder extends RecyclerView$ViewHolder {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DirectoryChannelViewHolder(View view) {
        super(view);
        m.checkNotNullParameter(view, "view");
    }

    public abstract void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener);
}
