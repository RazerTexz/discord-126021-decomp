package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.discord.widgets.chat.input.sticker.HeaderType;
import java.util.Objects;
import p007b.p008a.p027k.C1107b;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OwnedHeaderViewHolder extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {
    private final ExpressionPickerHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OwnedHeaderViewHolder(WidgetStickerAdapter widgetStickerAdapter) {
        super(C5419R.layout.expression_picker_header_item, widgetStickerAdapter);
        C12238m.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
        C12238m.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
        this.binding = expressionPickerHeaderItemBinding;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
    public void bind(int position, MGRecyclerDataPayload data) {
        C12238m.checkNotNullParameter(data, "data");
        onConfigure(position, data);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter.StickyHeaderViewHolder
    public View getItemView() {
        View view = this.itemView;
        C12238m.checkNotNullExpressionValue(view, "itemView");
        return view;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public void onConfigure(int position, MGRecyclerDataPayload data) {
        HeaderType headerType;
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof HeaderItem)) {
            data = null;
        }
        HeaderItem headerItem = (HeaderItem) data;
        if (headerItem == null || (headerType = headerItem.getHeaderType()) == null) {
            return;
        }
        if (headerType instanceof HeaderType.PackItem) {
            TextView textView = this.binding.f15066b;
            C12238m.checkNotNullExpressionValue(textView, "binding.headerItemText");
            HeaderType.PackItem packItem = (HeaderType.PackItem) headerType;
            textView.setText(packItem.getPack().getName());
            TextView textView2 = this.binding.f15066b;
            C12238m.checkNotNullExpressionValue(textView2, "binding.headerItemText");
            textView2.setContentDescription(C1107b.m216h(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.string.sticker_category_a11y_label, new Object[]{packItem.getPack().getName()}, null, 4));
            return;
        }
        if (headerType instanceof HeaderType.Recent) {
            this.binding.f15066b.setText(C5419R.string.sticker_picker_categories_recent);
            TextView textView3 = this.binding.f15066b;
            C12238m.checkNotNullExpressionValue(textView3, "binding.headerItemText");
            Context contextM821I = C1643a.m821I(this.binding.f15066b, "binding.headerItemText", "binding.headerItemText.context");
            TextView textView4 = this.binding.f15066b;
            C12238m.checkNotNullExpressionValue(textView4, "binding.headerItemText");
            textView3.setContentDescription(C1107b.m216h(contextM821I, C5419R.string.sticker_category_a11y_label, new Object[]{textView4.getText()}, null, 4));
            return;
        }
        if (headerType instanceof HeaderType.GuildItem) {
            TextView textView5 = this.binding.f15066b;
            C12238m.checkNotNullExpressionValue(textView5, "binding.headerItemText");
            HeaderType.GuildItem guildItem = (HeaderType.GuildItem) headerType;
            textView5.setText(guildItem.getGuild().getName());
            TextView textView6 = this.binding.f15066b;
            C12238m.checkNotNullExpressionValue(textView6, "binding.headerItemText");
            textView6.setContentDescription(C1107b.m216h(C1643a.m821I(this.binding.f15066b, "binding.headerItemText", "binding.headerItemText.context"), C5419R.string.sticker_category_a11y_label, new Object[]{guildItem.getGuild().getName()}, null, 4));
        }
    }
}
