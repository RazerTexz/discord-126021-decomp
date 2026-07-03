package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.C5419R;
import com.discord.databinding.StickerAutocompleteItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.sticker.StickerView;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerViewHolder extends MGRecyclerViewHolder<WidgetChatInputAutocompleteStickerAdapter, AutocompleteStickerItem> {
    private final StickerAutocompleteItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerViewHolder(WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter) {
        super(C5419R.layout.sticker_autocomplete_item, widgetChatInputAutocompleteStickerAdapter);
        C12238m.checkNotNullParameter(widgetChatInputAutocompleteStickerAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(C5419R.id.sticker_autocomplete_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(C5419R.id.sticker_autocomplete_sticker)));
        }
        StickerAutocompleteItemBinding stickerAutocompleteItemBinding = new StickerAutocompleteItemBinding((FrameLayout) view, stickerView);
        C12238m.checkNotNullExpressionValue(stickerAutocompleteItemBinding, "StickerAutocompleteItemBinding.bind(itemView)");
        this.binding = stickerAutocompleteItemBinding;
    }

    public static final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter access$getAdapter$p(StickerViewHolder stickerViewHolder) {
        return (WidgetChatInputAutocompleteStickerAdapter) stickerViewHolder.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final AutocompleteStickerItem data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerView.m8613e(this.binding.f15258b, data.getSticker(), null, 2);
        this.binding.f15258b.m8614b();
        this.binding.f15257a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.StickerViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StickerViewHolder.access$getAdapter$p(StickerViewHolder.this).getOnClickSticker().invoke(data.getSticker());
            }
        });
    }
}
