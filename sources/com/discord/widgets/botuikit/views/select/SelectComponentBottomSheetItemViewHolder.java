package com.discord.widgets.botuikit.views.select;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.discord.api.botuikit.ComponentEmoji;
import com.discord.api.botuikit.SelectItem;
import com.discord.databinding.WidgetSelectComponentBottomSheetItemBinding;
import com.discord.utilities.dimen.DimenUtils;
import com.discord.utilities.view.extensions.ViewExtensions;
import com.discord.widgets.botuikit.views.ComponentViewUtils;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectComponentBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheetItemViewHolder extends RecyclerView$ViewHolder {
    private final WidgetSelectComponentBottomSheetItemBinding binding;
    private final Function2<SelectItem, Boolean, Unit> onItemSelected;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SelectComponentBottomSheetItemViewHolder(WidgetSelectComponentBottomSheetItemBinding widgetSelectComponentBottomSheetItemBinding, Function2<? super SelectItem, ? super Boolean, Unit> function2) {
        super(widgetSelectComponentBottomSheetItemBinding.a);
        m.checkNotNullParameter(widgetSelectComponentBottomSheetItemBinding, "binding");
        m.checkNotNullParameter(function2, "onItemSelected");
        this.binding = widgetSelectComponentBottomSheetItemBinding;
        this.onItemSelected = function2;
    }

    public static final /* synthetic */ Function2 access$getOnItemSelected$p(SelectComponentBottomSheetItemViewHolder selectComponentBottomSheetItemViewHolder) {
        return selectComponentBottomSheetItemViewHolder.onItemSelected;
    }

    public final void bind(SelectComponentBottomSheetItem data, boolean isMultiSelect, boolean hasIcons, boolean hasDescriptions, boolean lastItem, boolean maxSelected, boolean emojiAnimationsEnabled) {
        m.checkNotNullParameter(data, "data");
        boolean z2 = maxSelected && !data.getSelected() && isMultiSelect;
        ConstraintLayout constraintLayout = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout, "binding.root");
        constraintLayout.setEnabled(!z2);
        this.binding.a.setOnClickListener(new SelectComponentBottomSheetItemViewHolder$bind$1(this, data));
        ConstraintLayout constraintLayout2 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout2, "binding.root");
        ViewExtensions.setEnabledAlpha(constraintLayout2, !z2, 0.3f);
        MaterialTextView materialTextView = this.binding.g;
        m.checkNotNullExpressionValue(materialTextView, "binding.selectComponentSheetItemTitle");
        materialTextView.setText(data.getSelectItem().getLabel());
        String description = data.getSelectItem().getDescription();
        MaterialTextView materialTextView2 = this.binding.f2533b;
        m.checkNotNullExpressionValue(materialTextView2, "binding.selectComponentSheetItemDescription");
        ViewExtensions.setTextAndVisibilityBy(materialTextView2, description);
        MaterialCheckBox materialCheckBox = this.binding.f;
        m.checkNotNullExpressionValue(materialCheckBox, "binding.selectComponentSheetItemSelected");
        materialCheckBox.setChecked(data.getSelected());
        MaterialCheckBox materialCheckBox2 = this.binding.f;
        m.checkNotNullExpressionValue(materialCheckBox2, "binding.selectComponentSheetItemSelected");
        materialCheckBox2.setVisibility(isMultiSelect ^ true ? 4 : 0);
        MaterialCheckBox materialCheckBox3 = this.binding.f;
        m.checkNotNullExpressionValue(materialCheckBox3, "binding.selectComponentSheetItemSelected");
        materialCheckBox3.setEnabled(!z2);
        ComponentEmoji emoji = data.getSelectItem().getEmoji();
        ComponentViewUtils componentViewUtils = ComponentViewUtils.INSTANCE;
        SimpleDraweeView simpleDraweeView = this.binding.e;
        m.checkNotNullExpressionValue(simpleDraweeView, "binding.selectComponentSheetItemIcon");
        componentViewUtils.setEmojiOrHide(simpleDraweeView, emoji, emojiAnimationsEnabled);
        int iDpToPixels = DimenUtils.dpToPixels(12);
        int iDpToPixels2 = data.getSelectItem().getDescription() == null ? DimenUtils.dpToPixels(12) : 0;
        int iDpToPixels3 = (hasIcons && data.getSelectItem().getEmoji() == null) ? DimenUtils.dpToPixels(40) : 0;
        this.binding.g.setPadding(iDpToPixels3, iDpToPixels, 0, iDpToPixels2);
        this.binding.f2533b.setPadding(iDpToPixels3, 0, 0, DimenUtils.dpToPixels(12));
        View view = this.binding.d;
        m.checkNotNullExpressionValue(view, "binding.selectComponentSheetItemDividerIcon");
        view.setVisibility(hasIcons && !lastItem ? 0 : 8);
        View view2 = this.binding.c;
        m.checkNotNullExpressionValue(view2, "binding.selectComponentSheetItemDivider");
        view2.setVisibility((hasIcons || lastItem) ? false : true ? 0 : 8);
        int iDpToPixels4 = DimenUtils.dpToPixels(hasDescriptions ? 62 : 46);
        ConstraintLayout constraintLayout3 = this.binding.a;
        m.checkNotNullExpressionValue(constraintLayout3, "binding.root");
        constraintLayout3.setMinHeight(iDpToPixels4);
    }
}
