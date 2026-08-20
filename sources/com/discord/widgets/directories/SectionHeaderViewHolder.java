package com.discord.widgets.directories;

import android.widget.TextView;
import com.discord.databinding.DirectorySectionHeaderListItemBinding;
import p007b.p008a.p027k.C1107b;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SectionHeaderViewHolder extends DirectoryChannelViewHolder {
    private final DirectorySectionHeaderListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public SectionHeaderViewHolder(DirectorySectionHeaderListItemBinding directorySectionHeaderListItemBinding) {
        C12238m.checkNotNullParameter(directorySectionHeaderListItemBinding, "viewBinding");
        TextView textView = directorySectionHeaderListItemBinding.f15044a;
        C12238m.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directorySectionHeaderListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, DirectoryChannelItemClickInterface listener) {
        C12238m.checkNotNullParameter(item, "item");
        C12238m.checkNotNullParameter(listener, "listener");
        int textRes = ((DirectoryChannelItem.SectionHeader) item).getTextRes();
        TextView textView = this.viewBinding.f15045b;
        C12238m.checkNotNullExpressionValue(textView, "viewBinding.directorySectionText");
        C1107b.m221m(textView, textRes, new Object[0], (4 & 4) != 0 ? C1107b.g.f1495j : null);
    }

    public final DirectorySectionHeaderListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
