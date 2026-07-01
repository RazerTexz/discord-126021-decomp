package com.discord.widgets.chat.input;

import android.view.View;
import android.widget.FrameLayout;
import com.discord.R;
import com.discord.databinding.StickerAutocompleteItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.views.sticker.StickerView;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.StickerViewHolder, reason: use source file name */
/* JADX INFO: compiled from: WidgetChatInputAutocompleteStickerAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChatInputAutocompleteStickerAdapter3 extends MGRecyclerViewHolder<WidgetChatInputAutocompleteStickerAdapter, WidgetChatInputAutocompleteStickerAdapter2> {
    private final StickerAutocompleteItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChatInputAutocompleteStickerAdapter3(WidgetChatInputAutocompleteStickerAdapter widgetChatInputAutocompleteStickerAdapter) {
        super(R.layout.sticker_autocomplete_item, widgetChatInputAutocompleteStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetChatInputAutocompleteStickerAdapter, "adapter");
        View view = this.itemView;
        StickerView stickerView = (StickerView) view.findViewById(R.id.sticker_autocomplete_sticker);
        if (stickerView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(R.id.sticker_autocomplete_sticker)));
        }
        StickerAutocompleteItemBinding stickerAutocompleteItemBinding = new StickerAutocompleteItemBinding((FrameLayout) view, stickerView);
        Intrinsics3.checkNotNullExpressionValue(stickerAutocompleteItemBinding, "StickerAutocompleteItemBinding.bind(itemView)");
        this.binding = stickerAutocompleteItemBinding;
    }

    public static final /* synthetic */ WidgetChatInputAutocompleteStickerAdapter access$getAdapter$p(WidgetChatInputAutocompleteStickerAdapter3 widgetChatInputAutocompleteStickerAdapter3) {
        return (WidgetChatInputAutocompleteStickerAdapter) widgetChatInputAutocompleteStickerAdapter3.adapter;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, final WidgetChatInputAutocompleteStickerAdapter2 data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        StickerView.e(this.binding.f2147b, data.getSticker(), null, 2);
        this.binding.f2147b.b();
        this.binding.a.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.StickerViewHolder.onConfigure.1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                WidgetChatInputAutocompleteStickerAdapter3.access$getAdapter$p(WidgetChatInputAutocompleteStickerAdapter3.this).getOnClickSticker().invoke(data.getSticker());
            }
        });
    }
}
