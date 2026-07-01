package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.k.FormatUtils;
import b.d.b.a.outline;
import com.discord.R;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.sticker.StickerAdapterItems2;
import d0.z.d.Intrinsics3;
import java.util.Objects;

/* JADX INFO: renamed from: com.discord.widgets.chat.input.sticker.OwnedHeaderViewHolder, reason: use source file name */
/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StickerAdapterViewHolders extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {
    private final ExpressionPickerHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StickerAdapterViewHolders(WidgetStickerAdapter widgetStickerAdapter) {
        super(R.layout.expression_picker_header_item, widgetStickerAdapter);
        Intrinsics3.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
        Intrinsics3.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
        this.binding = expressionPickerHeaderItemBinding;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
    public void bind(int position, MGRecyclerDataPayload data) {
        Intrinsics3.checkNotNullParameter(data, "data");
        onConfigure(position, data);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
    public View getItemView() {
        View view = this.itemView;
        Intrinsics3.checkNotNullExpressionValue(view, "itemView");
        return view;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, MGRecyclerDataPayload data) {
        StickerAdapterItems2 headerType;
        Intrinsics3.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof StickerAdapterItems)) {
            data = null;
        }
        StickerAdapterItems stickerAdapterItems = (StickerAdapterItems) data;
        if (stickerAdapterItems == null || (headerType = stickerAdapterItems.getHeaderType()) == null) {
            return;
        }
        if (headerType instanceof StickerAdapterItems2.PackItem) {
            TextView textView = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView, "binding.headerItemText");
            StickerAdapterItems2.PackItem packItem = (StickerAdapterItems2.PackItem) headerType;
            textView.setText(packItem.getPack().getName());
            TextView textView2 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView2, "binding.headerItemText");
            textView2.setContentDescription(FormatUtils.b(outline.x(this.itemView, "itemView", "itemView.context"), R.string.sticker_category_a11y_label, new Object[]{packItem.getPack().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null));
            return;
        }
        if (headerType instanceof StickerAdapterItems2.Recent) {
            this.binding.f2105b.setText(R.string.sticker_picker_categories_recent);
            TextView textView3 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView3, "binding.headerItemText");
            Context contextI = outline.I(this.binding.f2105b, "binding.headerItemText", "binding.headerItemText.context");
            TextView textView4 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView4, "binding.headerItemText");
            textView3.setContentDescription(FormatUtils.b(contextI, R.string.sticker_category_a11y_label, new Object[]{textView4.getText()}, (4 & 4) != 0 ? FormatUtils.b.j : null));
            return;
        }
        if (headerType instanceof StickerAdapterItems2.GuildItem) {
            TextView textView5 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView5, "binding.headerItemText");
            StickerAdapterItems2.GuildItem guildItem = (StickerAdapterItems2.GuildItem) headerType;
            textView5.setText(guildItem.getGuild().getName());
            TextView textView6 = this.binding.f2105b;
            Intrinsics3.checkNotNullExpressionValue(textView6, "binding.headerItemText");
            textView6.setContentDescription(FormatUtils.b(outline.I(this.binding.f2105b, "binding.headerItemText", "binding.headerItemText.context"), R.string.sticker_category_a11y_label, new Object[]{guildItem.getGuild().getName()}, (4 & 4) != 0 ? FormatUtils.b.j : null));
        }
    }
}
