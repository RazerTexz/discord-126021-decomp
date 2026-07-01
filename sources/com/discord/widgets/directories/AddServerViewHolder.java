package com.discord.widgets.directories;

import android.view.View;
import android.widget.TextView;
import com.discord.databinding.DirectoryAddServerListItemBinding;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: WidgetDirectoryEntryViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class AddServerViewHolder extends DirectoryChannelViewHolder {
    private final DirectoryAddServerListItemBinding viewBinding;

    /* JADX WARN: Illegal instructions before constructor call */
    public AddServerViewHolder(DirectoryAddServerListItemBinding directoryAddServerListItemBinding) {
        Intrinsics3.checkNotNullParameter(directoryAddServerListItemBinding, "viewBinding");
        TextView textView = directoryAddServerListItemBinding.a;
        Intrinsics3.checkNotNullExpressionValue(textView, "viewBinding.root");
        super(textView);
        this.viewBinding = directoryAddServerListItemBinding;
    }

    @Override // com.discord.widgets.directories.DirectoryChannelViewHolder
    public void bind(DirectoryChannelItem item, final DirectoryChannelItemClickInterface listener) {
        Intrinsics3.checkNotNullParameter(item, "item");
        Intrinsics3.checkNotNullParameter(listener, "listener");
        this.viewBinding.f2095b.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.directories.AddServerViewHolder.bind.1
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
