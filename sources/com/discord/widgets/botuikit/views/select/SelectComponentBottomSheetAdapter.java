package com.discord.widgets.botuikit.views.select;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.discord.R;
import com.discord.api.botuikit.SelectComponent2;
import com.discord.databinding.WidgetSelectComponentBottomSheetItemBinding;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.material.checkbox.MaterialCheckBox;
import com.google.android.material.textview.MaterialTextView;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: SelectComponentBottomSheetAdapter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SelectComponentBottomSheetAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<SelectComponentBottomSheetAdapter2> data;
    private boolean emojiAnimationsEnabled;
    private boolean hasDescriptions;
    private boolean hasIcons;
    private boolean isMaxSelected;
    private boolean isMultiSelect;
    private final Function2<SelectComponent2, Boolean, Unit> onItemSelected;

    /* JADX WARN: Multi-variable type inference failed */
    public SelectComponentBottomSheetAdapter(Function2<? super SelectComponent2, ? super Boolean, Unit> function2) {
        Intrinsics3.checkNotNullParameter(function2, "onItemSelected");
        this.onItemSelected = function2;
        setHasStableIds(true);
        this.data = Collections2.emptyList();
        this.emojiAnimationsEnabled = true;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.data.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int position) {
        return position;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Intrinsics3.checkNotNullParameter(holder, "holder");
        ((SelectComponentBottomSheetAdapter3) holder).bind(this.data.get(position), this.isMultiSelect, this.hasIcons, this.hasDescriptions, position == this.data.size() - 1, this.isMaxSelected, this.emojiAnimationsEnabled);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics3.checkNotNullParameter(parent, "parent");
        View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.widget_select_component_bottom_sheet_item, parent, false);
        int i = R.id.select_component_sheet_item_description;
        MaterialTextView materialTextView = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_description);
        if (materialTextView != null) {
            i = R.id.select_component_sheet_item_divider;
            View viewFindViewById = viewInflate.findViewById(R.id.select_component_sheet_item_divider);
            if (viewFindViewById != null) {
                i = R.id.select_component_sheet_item_divider_icon;
                View viewFindViewById2 = viewInflate.findViewById(R.id.select_component_sheet_item_divider_icon);
                if (viewFindViewById2 != null) {
                    i = R.id.select_component_sheet_item_icon;
                    SimpleDraweeView simpleDraweeView = (SimpleDraweeView) viewInflate.findViewById(R.id.select_component_sheet_item_icon);
                    if (simpleDraweeView != null) {
                        i = R.id.select_component_sheet_item_selected;
                        MaterialCheckBox materialCheckBox = (MaterialCheckBox) viewInflate.findViewById(R.id.select_component_sheet_item_selected);
                        if (materialCheckBox != null) {
                            i = R.id.select_component_sheet_item_title;
                            MaterialTextView materialTextView2 = (MaterialTextView) viewInflate.findViewById(R.id.select_component_sheet_item_title);
                            if (materialTextView2 != null) {
                                WidgetSelectComponentBottomSheetItemBinding widgetSelectComponentBottomSheetItemBinding = new WidgetSelectComponentBottomSheetItemBinding((ConstraintLayout) viewInflate, materialTextView, viewFindViewById, viewFindViewById2, simpleDraweeView, materialCheckBox, materialTextView2);
                                Intrinsics3.checkNotNullExpressionValue(widgetSelectComponentBottomSheetItemBinding, "WidgetSelectComponentBot…          false\n        )");
                                return new SelectComponentBottomSheetAdapter3(widgetSelectComponentBottomSheetItemBinding, this.onItemSelected);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(viewInflate.getResources().getResourceName(i)));
    }

    public final void setItems(List<SelectComponentBottomSheetAdapter2> items, int maxSelections, boolean emojiAnimationsEnabled) {
        boolean z2;
        boolean z3;
        int i;
        Intrinsics3.checkNotNullParameter(items, "items");
        this.data = items;
        boolean z4 = items instanceof Collection;
        if (!z4 || !items.isEmpty()) {
            Iterator<T> it = items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = false;
                    break;
                } else {
                    if (((SelectComponentBottomSheetAdapter2) it.next()).getSelectItem().getEmoji() != null) {
                        z2 = true;
                        break;
                    }
                }
            }
        } else {
            z2 = false;
            break;
        }
        this.hasIcons = z2;
        if (!z4 || !items.isEmpty()) {
            Iterator<T> it2 = items.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    z3 = false;
                    break;
                } else {
                    if (((SelectComponentBottomSheetAdapter2) it2.next()).getSelectItem().getDescription() != null) {
                        z3 = true;
                        break;
                    }
                }
            }
        } else {
            z3 = false;
            break;
        }
        this.hasDescriptions = z3;
        this.isMultiSelect = maxSelections > 1;
        if (z4 && items.isEmpty()) {
            i = 0;
        } else {
            Iterator<T> it3 = items.iterator();
            i = 0;
            while (it3.hasNext()) {
                if (((SelectComponentBottomSheetAdapter2) it3.next()).getSelected() && (i = i + 1) < 0) {
                    Collections2.throwCountOverflow();
                }
            }
        }
        this.isMaxSelected = i == maxSelections;
        this.emojiAnimationsEnabled = emojiAnimationsEnabled;
        notifyDataSetChanged();
    }
}
