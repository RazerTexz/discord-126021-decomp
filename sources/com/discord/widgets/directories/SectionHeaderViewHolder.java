package com.discord.widgets.directories;

import android.widget.TextView;
import b.a.k.b;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SectionHeaderViewHolder extends DirectoryChannelViewHolder {
    private final DirectorySectionHeaderListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public SectionHeaderViewHolder(DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding) {
        m.checkNotNullParameter(directorySectionHeaderListItemBinding, "viewBinding");
        TextView textView = directorySectionHeaderListItemBinding.a;
        m.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directorySectionHeaderListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        m.checkNotNullParameter(item, "item");
        m.checkNotNullParameter(listener, "listener");
        int textRes = ((DirectoryChannelItem$SectionHeader) item).getTextRes();
        TextView textView = this.viewBinding.f2097b;
        m.checkNotNullExpressionValue(textView, "viewBinding.directorySectionText");
        b.n(textView, textRes, new Object[0], null, 4);
    }

    public final DirectorySectionHeaderListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
