package com.discord.widgets.directories;

import android.widget.TextView;
import b.a.k.FormatUtils;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import com.discord.widgets.directories.DirectoryChannelItem;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SectionHeaderViewHolder extends DirectoryChannelViewHolder {
    private final DirectorySectionHeaderListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public SectionHeaderViewHolder(DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding) {
        Intrinsics3.checkNotNullParameter(directorySectionHeaderListItemBinding, "viewBinding");
        TextView textView = directorySectionHeaderListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directorySectionHeaderListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        int textRes = ((DirectoryChannelItem.SectionHeader) item).getTextRes();
        TextView textView = this.viewBinding.f2097b;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.directorySectionText");
        FormatUtils.m(textView, textRes, new Object[0], (4 & 4) != 0 ? FormatUtils.g.j : null);
    }

    public final DirectorySectionHeaderListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
