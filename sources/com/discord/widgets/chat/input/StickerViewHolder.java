package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.databinding.StickerAutocompleteItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.sticker.StickerView;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder extends MGRecyclerViewHolder<WidgetChatInputAutocompleteStickerAdapter, AutocompleteStickerItem> {
    private final StickerAutocompleteItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewHolder(WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter) {
        super(R$layout.sticker_autocomplete_item, widgetChatInputAutocompleteStickerAdapter);
        m.checkNotNullParameter(widgetChatInputAutocompleteStickerAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R$id.sticker_autocomplete_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R$id.sticker_autocomplete_sticker)));
        }
        StickerAutocompleteItemBinding stickerAutocompleteItemBinding = new StickerAutocompleteItemBinding((FrameLayout) view, stickerView);
        m.checkNotNullExpressionValue(stickerAutocompleteItemBinding, "StickerAutocompleteItemBinding.bind(itemView)");
        this.binding = stickerAutocompleteItemBinding;
    }

    public static final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter access$getAdapter$p(StickerViewHolder stickerViewHolder) {
        return (WidgetChatInputAutocompleteStickerAdapter) stickerViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, AutocompleteStickerItem autocompleteStickerItem) {
        onConfigure2(i, autocompleteStickerItem);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, AutocompleteStickerItem data) {
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerView.e(this.binding.f2147b, data.getSticker(), null, 2);
        this.binding.f2147b.b();
        this.binding.a.setOnClickListener(new StickerViewHolder$onConfigure$1(this, data));
    }
}
