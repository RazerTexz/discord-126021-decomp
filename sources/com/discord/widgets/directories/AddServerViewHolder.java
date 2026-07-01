package com.discord.widgets.directories;

import android.widget.TextView;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddServerViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryAddServerListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public AddServerViewHolder(DirectoryAddServerListItemBinding directoryAddServerListItemBinding) {
        m.checkNotNullParameter(directoryAddServerListItemBinding, "viewBinding");
        TextView textView = directoryAddServerListItemBinding.a;
        m.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directoryAddServerListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(listener, "listener");
        this.viewBinding.f2095b.setOnClickListener(new AddServerViewHolder$bind$1(listener));
    }

    public final DirectoryAddServerListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
