package com.discord.widgets.chat.input.autocomplete.adapter;

import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.databinding.WidgetChatInputSlashLoadingItemBinding;
import d0.z.d.m;

/* JADX INFO: compiled from: ApplicationCommandLoadingViewHolder.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class ApplicationCommandLoadingViewHolder extends RecyclerView$ViewHolder {
    private final WidgetChatInputSlashLoadingItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ApplicationCommandLoadingViewHolder(WidgetChatInputSlashLoadingItemBinding widgetChatInputSlashLoadingItemBinding) {
        super(widgetChatInputSlashLoadingItemBinding.a);
        m.checkNotNullParameter(widgetChatInputSlashLoadingItemBinding, "binding");
        this.binding = widgetChatInputSlashLoadingItemBinding;
    }
}
