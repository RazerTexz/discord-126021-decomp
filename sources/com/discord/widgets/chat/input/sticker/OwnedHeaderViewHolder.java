package com.discord.widgets.chat.input.sticker;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.R$layout;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder;
import d0.z.d.m;
import java.util.Objects;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class OwnedHeaderViewHolder extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter$StickyHeaderViewHolder {
    private final ExpressionPickerHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OwnedHeaderViewHolder(WidgetStickerAdapter widgetStickerAdapter) {
        super(R$layout.expression_picker_header_item, widgetStickerAdapter);
        m.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        Objects.requireNonNull(view, "rootView");
        TextView textView = (TextView) view;
        ExpressionPickerHeaderItemBinding expressionPickerHeaderItemBinding = new ExpressionPickerHeaderItemBinding(textView, textView);
        m.checkNotNullExpressionValue(expressionPickerHeaderItemBinding, "ExpressionPickerHeaderItemBinding.bind(itemView)");
        this.binding = expressionPickerHeaderItemBinding;
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder
    public void bind(int position, MGRecyclerDataPayload data) {
        m.checkNotNullParameter(data, "data");
        onConfigure2(position, data);
    }

    @Override // com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder
    public View getItemView() {
        View view = this.itemView;
        m.checkNotNullExpressionValue(view, "itemView");
        return view;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerViewHolder
    public /* bridge */ /* synthetic */ void onConfigure(int i, MGRecyclerDataPayload mGRecyclerDataPayload) {
        onConfigure2(i, mGRecyclerDataPayload);
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        HeaderType headerType;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof HeaderItem)) {
            data = null;
        }
        HeaderItem headerItem = (HeaderItem) data;
        if (headerItem == null || (headerType = headerItem.getHeaderType()) == null) {
            return;
        }
        if (headerType instanceof HeaderType$PackItem) {
            TextView textView = this.binding.f2105b;
            m.checkNotNullExpressionValue(textView, "binding.headerItemText");
            HeaderType$PackItem headerType$PackItem = (HeaderType$PackItem) headerType;
            textView.setText(headerType$PackItem.getPack().getName());
            TextView textView2 = this.binding.f2105b;
            m.checkNotNullExpressionValue(textView2, "binding.headerItemText");
            textView2.setContentDescription(b.h(a.x(this.itemView, "itemView", "itemView.context"), 2131895925, new Object[]{headerType$PackItem.getPack().getName()}, null, 4));
            return;
        }
        if (headerType instanceof HeaderType$Recent) {
            this.binding.f2105b.setText(2131895936);
            TextView textView3 = this.binding.f2105b;
            m.checkNotNullExpressionValue(textView3, "binding.headerItemText");
            Context contextI = a.I(this.binding.f2105b, "binding.headerItemText", "binding.headerItemText.context");
            TextView textView4 = this.binding.f2105b;
            m.checkNotNullExpressionValue(textView4, "binding.headerItemText");
            textView3.setContentDescription(b.h(contextI, 2131895925, new Object[]{textView4.getText()}, null, 4));
            return;
        }
        if (headerType instanceof HeaderType$GuildItem) {
            TextView textView5 = this.binding.f2105b;
            m.checkNotNullExpressionValue(textView5, "binding.headerItemText");
            HeaderType$GuildItem headerType$GuildItem = (HeaderType$GuildItem) headerType;
            textView5.setText(headerType$GuildItem.getGuild().getName());
            TextView textView6 = this.binding.f2105b;
            m.checkNotNullExpressionValue(textView6, "binding.headerItemText");
            textView6.setContentDescription(b.h(a.I(this.binding.f2105b, "binding.headerItemText", "binding.headerItemText.context"), 2131895925, new Object[]{headerType$GuildItem.getGuild().getName()}, null, 4));
        }
    }
}
