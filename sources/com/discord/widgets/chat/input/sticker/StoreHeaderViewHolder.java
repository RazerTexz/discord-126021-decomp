package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import b.d.b.a.a;
import com.discord.R$id;
import com.discord.R$layout;
import com.discord.R$plurals;
import com.discord.databinding.StickerStoreHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter$StickyHeaderViewHolder;
import com.google.android.material.chip.Chip;
import d0.z.d.m;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreHeaderViewHolder extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter$StickyHeaderViewHolder {
    private final StickerStoreHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreHeaderViewHolder(WidgetStickerAdapter widgetStickerAdapter) {
        super(R$layout.sticker_store_header_item, widgetStickerAdapter);
        m.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        int i = R$id.sticker_store_header_item_animated;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(R$id.sticker_store_header_item_animated);
        if (frameLayout != null) {
            i = R$id.sticker_store_header_item_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(R$id.sticker_store_header_item_container);
            if (relativeLayout != null) {
                i = R$id.sticker_store_header_item_description;
                TextView textView = (TextView) view.findViewById(R$id.sticker_store_header_item_description);
                if (textView != null) {
                    i = R$id.sticker_store_header_item_new;
                    Chip chip = (Chip) view.findViewById(R$id.sticker_store_header_item_new);
                    if (chip != null) {
                        i = R$id.sticker_store_header_item_premium;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(R$id.sticker_store_header_item_premium);
                        if (frameLayout2 != null) {
                            i = R$id.sticker_store_header_item_subtitle;
                            TextView textView2 = (TextView) view.findViewById(R$id.sticker_store_header_item_subtitle);
                            if (textView2 != null) {
                                i = R$id.sticker_store_header_item_title;
                                TextView textView3 = (TextView) view.findViewById(R$id.sticker_store_header_item_title);
                                if (textView3 != null) {
                                    StickerStoreHeaderItemBinding stickerStoreHeaderItemBinding = new StickerStoreHeaderItemBinding((LinearLayout) view, frameLayout, relativeLayout, textView, chip, frameLayout2, textView2, textView3);
                                    m.checkNotNullExpressionValue(stickerStoreHeaderItemBinding, "StickerStoreHeaderItemBinding.bind(itemView)");
                                    this.binding = stickerStoreHeaderItemBinding;
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(view.getResources().getResourceName(i)));
    }

    public static final /* synthetic */ WidgetStickerAdapter access$getAdapter$p(StoreHeaderViewHolder storeHeaderViewHolder) {
        return (WidgetStickerAdapter) storeHeaderViewHolder.adapter;
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
        m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof StoreHeaderItem) {
            TextView textView = this.binding.g;
            m.checkNotNullExpressionValue(textView, "binding.stickerStoreHeaderItemTitle");
            StoreHeaderItem storeHeaderItem = (StoreHeaderItem) data;
            textView.setText(storeHeaderItem.getPack().getName());
            CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(a.x(this.itemView, "itemView", "itemView.context"), R$plurals.sticker_pack_sticker_count_numStickers, storeHeaderItem.getPack().getStickers().size(), Integer.valueOf(storeHeaderItem.getPack().getStickers().size()));
            TextView textView2 = this.binding.f;
            m.checkNotNullExpressionValue(textView2, "binding.stickerStoreHeaderItemSubtitle");
            textView2.setText(i18nPluralString);
            FrameLayout frameLayout = this.binding.f2155b;
            m.checkNotNullExpressionValue(frameLayout, "binding.stickerStoreHeaderItemAnimated");
            frameLayout.setVisibility(storeHeaderItem.getPack().isAnimatedPack() ? 0 : 8);
            FrameLayout frameLayout2 = this.binding.e;
            m.checkNotNullExpressionValue(frameLayout2, "binding.stickerStoreHeaderItemPremium");
            frameLayout2.setVisibility(storeHeaderItem.getPack().isPremiumPack() ? 0 : 8);
            if (((WidgetStickerAdapter) this.adapter).getShowStickerPackDescriptions()) {
                TextView textView3 = this.binding.d;
                m.checkNotNullExpressionValue(textView3, "binding.stickerStoreHeaderItemDescription");
                ViewExtensions.setTextAndVisibilityBy(textView3, storeHeaderItem.getPack().getDescription());
            } else {
                TextView textView4 = this.binding.d;
                m.checkNotNullExpressionValue(textView4, "binding.stickerStoreHeaderItemDescription");
                textView4.setVisibility(8);
            }
            if (storeHeaderItem.getPack().isAnimatedPack() || storeHeaderItem.getPack().isPremiumPack() || storeHeaderItem.getPack().isLimitedPack()) {
                this.binding.c.setOnClickListener(new StoreHeaderViewHolder$onConfigure$1(this, data));
            }
        }
    }
}
