package com.discord.widgets.directories;

import android.view.View;
import android.widget.TextView;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddServerViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryAddServerListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public AddServerViewHolder(DirectoryAddServerListItemBinding directoryAddServerListItemBinding) {
        C12238m.checkNotNullParameter(directoryAddServerListItemBinding, "viewBinding");
        TextView textView = directoryAddServerListItemBinding.f15040a;
        C12238m.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directoryAddServerListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, final DirectoryChannelItemClickInterface listener) {
        C12238m.checkNotNullParameter(item, "item");
        C12238m.checkNotNullParameter(listener, "listener");
        this.viewBinding.f15041b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.AddServerViewHolder.bind.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                listener.onAddServerClicked();
            }
        });
    }

    public final DirectoryAddServerListItemBinding getViewBinding() {
        return this.viewBinding;
    }
}
