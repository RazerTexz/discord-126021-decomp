package com.discord.widgets.nux;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.NuxGuildTemplateTextViewHolderBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: GuildTemplateViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class GuildTemplateTextViewHolder extends RecyclerView$ViewHolder {
    private final NuxGuildTemplateTextViewHolderBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GuildTemplateTextViewHolder(NuxGuildTemplateTextViewHolderBinding nuxGuildTemplateTextViewHolderBinding) {
        super(nuxGuildTemplateTextViewHolderBinding.a);
        m.checkNotNullParameter(nuxGuildTemplateTextViewHolderBinding, "binding");
        this.binding = nuxGuildTemplateTextViewHolderBinding;
    }

    public final NuxGuildTemplateTextViewHolderBinding getBinding() {
        return this.binding;
    }
}
