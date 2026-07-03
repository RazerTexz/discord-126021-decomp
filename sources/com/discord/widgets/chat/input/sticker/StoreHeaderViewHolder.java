package com.discord.widgets.chat.input.sticker;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.discord.C5419R;
import com.discord.databinding.StickerStoreHeaderItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import com.discord.utilities.mg_recycler.MGRecyclerViewHolder;
import com.discord.utilities.resources.StringResourceUtilsKt;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.chat.input.expression.WidgetExpressionPickerAdapter;
import com.google.android.material.chip.Chip;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: StickerAdapterViewHolders.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class StoreHeaderViewHolder extends MGRecyclerViewHolder<WidgetStickerAdapter, MGRecyclerDataPayload> implements WidgetExpressionPickerAdapter.StickyHeaderViewHolder {
    private final StickerStoreHeaderItemBinding binding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StoreHeaderViewHolder(WidgetStickerAdapter widgetStickerAdapter) {
        super(C5419R.layout.sticker_store_header_item, widgetStickerAdapter);
        C12238m.checkNotNullParameter(widgetStickerAdapter, "adapter");
        View view = this.itemView;
        int i = C5419R.id.sticker_store_header_item_animated;
        FrameLayout frameLayout = (FrameLayout) view.findViewById(C5419R.id.sticker_store_header_item_animated);
        if (frameLayout != null) {
            i = C5419R.id.sticker_store_header_item_container;
            RelativeLayout relativeLayout = (RelativeLayout) view.findViewById(C5419R.id.sticker_store_header_item_container);
            if (relativeLayout != null) {
                i = C5419R.id.sticker_store_header_item_description;
                TextView textView = (TextView) view.findViewById(C5419R.id.sticker_store_header_item_description);
                if (textView != null) {
                    i = C5419R.id.sticker_store_header_item_new;
                    Chip chip = (Chip) view.findViewById(C5419R.id.sticker_store_header_item_new);
                    if (chip != null) {
                        i = C5419R.id.sticker_store_header_item_premium;
                        FrameLayout frameLayout2 = (FrameLayout) view.findViewById(C5419R.id.sticker_store_header_item_premium);
                        if (frameLayout2 != null) {
                            i = C5419R.id.sticker_store_header_item_subtitle;
                            TextView textView2 = (TextView) view.findViewById(C5419R.id.sticker_store_header_item_subtitle);
                            if (textView2 != null) {
                                i = C5419R.id.sticker_store_header_item_title;
                                TextView textView3 = (TextView) view.findViewById(C5419R.id.sticker_store_header_item_title);
                                if (textView3 != null) {
                                    StickerStoreHeaderItemBinding stickerStoreHeaderItemBinding = new StickerStoreHeaderItemBinding((LinearLayout) view, frameLayout, relativeLayout, textView, chip, frameLayout2, textView2, textView3);
                                    C12238m.checkNotNullExpressionValue(stickerStoreHeaderItemBinding, "StickerStoreHeaderItemBinding.bind(itemView)");
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
    public void onConfigure(int position, final MGRecyclerDataPayload data) {
        C12238m.checkNotNullParameter(data, "data");
        super.onConfigure(position, data);
        if (data instanceof StoreHeaderItem) {
            TextView textView = this.binding.f15287g;
            C12238m.checkNotNullExpressionValue(textView, "binding.stickerStoreHeaderItemTitle");
            StoreHeaderItem storeHeaderItem = (StoreHeaderItem) data;
            textView.setText(storeHeaderItem.getPack().getName());
            CharSequence i18nPluralString = StringResourceUtilsKt.getI18nPluralString(C1643a.m885x(this.itemView, "itemView", "itemView.context"), C5419R.plurals.sticker_pack_sticker_count_numStickers, storeHeaderItem.getPack().getStickers().size(), Integer.valueOf(storeHeaderItem.getPack().getStickers().size()));
            TextView textView2 = this.binding.f15286f;
            C12238m.checkNotNullExpressionValue(textView2, "binding.stickerStoreHeaderItemSubtitle");
            textView2.setText(i18nPluralString);
            FrameLayout frameLayout = this.binding.f15282b;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.stickerStoreHeaderItemAnimated");
            frameLayout.setVisibility(storeHeaderItem.getPack().isAnimatedPack() ? 0 : 8);
            FrameLayout frameLayout2 = this.binding.f15285e;
            C12238m.checkNotNullExpressionValue(frameLayout2, "binding.stickerStoreHeaderItemPremium");
            frameLayout2.setVisibility(storeHeaderItem.getPack().isPremiumPack() ? 0 : 8);
            if (((WidgetStickerAdapter) this.adapter).getShowStickerPackDescriptions()) {
                TextView textView3 = this.binding.f15284d;
                C12238m.checkNotNullExpressionValue(textView3, "binding.stickerStoreHeaderItemDescription");
                ViewExtensions.setTextAndVisibilityBy(textView3, storeHeaderItem.getPack().getDescription());
            } else {
                TextView textView4 = this.binding.f15284d;
                C12238m.checkNotNullExpressionValue(textView4, "binding.stickerStoreHeaderItemDescription");
                textView4.setVisibility(8);
            }
            if (storeHeaderItem.getPack().isAnimatedPack() || storeHeaderItem.getPack().isPremiumPack() || storeHeaderItem.getPack().isLimitedPack()) {
                this.binding.f15283c.setOnClickListener(new View.OnClickListener() { // from class: com.discord.widgets.chat.input.sticker.StoreHeaderViewHolder.onConfigure.1
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        Function1<StoreHeaderItem, Unit> onStickerHeaderItemsClicked = StoreHeaderViewHolder.access$getAdapter$p(StoreHeaderViewHolder.this).getOnStickerHeaderItemsClicked();
                        if (onStickerHeaderItemsClicked != 0) {
                        }
                    }
                });
            }
        }
    }
}
