package com.discord.widgets.chat.input.emoji;

import android.view.View;
import android.widget.TextView;
import b.a.k.b;
import com.discord.R$layout;
import com.discord.databinding.ExpressionPickerHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.KotlinExtensionsKt;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder;
import d0.z.d.m;
import java.util.Objects;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;

/* JADX INFO: compiled from: WidgetEmojiAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetEmojiAdapter$HeaderViewHolder extends MGRecyclerViewHolder<WidgetEmojiAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter$StickyHeaderViewHolder {
    public static final WidgetEmojiAdapter$HeaderViewHolder$Companion Companion = new WidgetEmojiAdapter$HeaderViewHolder$Companion(null);
    private final ExpressionPickerHeaderItemBinding binding;
    public WidgetEmojiAdapter$HeaderItem boundItem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetEmojiAdapter$HeaderViewHolder(WidgetEmojiAdapter widgetEmojiAdapter) {
        super(R$layout.expression_picker_header_item, widgetEmojiAdapter);
        m.checkNotNullParameter(widgetEmojiAdapter, "adapter");
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

    public final WidgetEmojiAdapter$HeaderItem getBoundItem() {
        WidgetEmojiAdapter$HeaderItem widgetEmojiAdapter$HeaderItem = this.boundItem;
        if (widgetEmojiAdapter$HeaderItem == null) {
            m.throwUninitializedPropertyAccessException("boundItem");
        }
        return widgetEmojiAdapter$HeaderItem;
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

    public final void setBoundItem(WidgetEmojiAdapter$HeaderItem widgetEmojiAdapter$HeaderItem) {
        m.checkNotNullParameter(widgetEmojiAdapter$HeaderItem, "<set-?>");
        this.boundItem = widgetEmojiAdapter$HeaderItem;
    }

    /* JADX INFO: renamed from: onConfigure, reason: avoid collision after fix types in other method */
    public void onConfigure2(int position, MGRecyclerDataPayload data) {
        Unit unit;
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (!(data instanceof WidgetEmojiAdapter$HeaderItem)) {
            data = null;
        }
        WidgetEmojiAdapter$HeaderItem widgetEmojiAdapter$HeaderItem = (WidgetEmojiAdapter$HeaderItem) data;
        if (widgetEmojiAdapter$HeaderItem != null) {
            this.boundItem = widgetEmojiAdapter$HeaderItem;
            if (widgetEmojiAdapter$HeaderItem instanceof WidgetEmojiAdapter$HeaderItem$StandardHeaderItem) {
                TextView textView = this.binding.f2105b;
                m.checkNotNullExpressionValue(textView, "binding.headerItemText");
                b.n(textView, Companion.getCategoryString(((WidgetEmojiAdapter$HeaderItem$StandardHeaderItem) widgetEmojiAdapter$HeaderItem).getEmojiCategory()), new Object[0], null, 4);
                unit = Unit.a;
            } else if (widgetEmojiAdapter$HeaderItem instanceof WidgetEmojiAdapter$HeaderItem$GuildHeaderItem) {
                TextView textView2 = this.binding.f2105b;
                m.checkNotNullExpressionValue(textView2, "binding.headerItemText");
                textView2.setText(((WidgetEmojiAdapter$HeaderItem$GuildHeaderItem) widgetEmojiAdapter$HeaderItem).getText());
                unit = Unit.a;
            } else {
                if (!(widgetEmojiAdapter$HeaderItem instanceof WidgetEmojiAdapter$HeaderItem$StringHeaderItem)) {
                    throw new NoWhenBranchMatchedException();
                }
                TextView textView3 = this.binding.f2105b;
                m.checkNotNullExpressionValue(textView3, "binding.headerItemText");
                b.n(textView3, ((WidgetEmojiAdapter$HeaderItem$StringHeaderItem) widgetEmojiAdapter$HeaderItem).getStringRes(), new Object[0], null, 4);
                unit = Unit.a;
            }
            KotlinExtensionsKt.getExhaustive(unit);
        }
    }
}
