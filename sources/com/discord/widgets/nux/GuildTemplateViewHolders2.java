package com.discord.widgets.nux;

import androidx.recyclerview.widget.RecyclerView;
import com.discord.databinding.NuxGuildTemplateTextViewHolderBinding;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.nux.GuildTemplateTextViewHolder, reason: use source file name */
/* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateViewHolders2 extends RecyclerView.ViewHolder {
    private final NuxGuildTemplateTextViewHolderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateViewHolders2(NuxGuildTemplateTextViewHolderBinding nuxGuildTemplateTextViewHolderBinding) {
        super(nuxGuildTemplateTextViewHolderBinding.a);
        Intrinsics3.checkNotNullParameter(nuxGuildTemplateTextViewHolderBinding, "binding");
        this.binding = nuxGuildTemplateTextViewHolderBinding;
    }

    public final NuxGuildTemplateTextViewHolderBinding getBinding() {
        return this.binding;
    }
}
