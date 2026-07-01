package com.google.android.material.chip;

import android.view.View;
import android.view.ViewGroup$OnHierarchyChangeListener;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes3.dex */
public class ChipGroup$PassThroughHierarchyChangeListener implements ViewGroup$OnHierarchyChangeListener {
    public ViewGroup$OnHierarchyChangeListener j;
    public final /* synthetic */ ChipGroup k;

    public ChipGroup$PassThroughHierarchyChangeListener(ChipGroup chipGroup, ChipGroup$a chipGroup$a) {
        this.k = chipGroup;
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewAdded(View view, View view2) {
        if (view == this.k && (view2 instanceof Chip)) {
            if (view2.getId() == -1) {
                view2.setId(ViewCompat.generateViewId());
            }
            Chip chip = (Chip) view2;
            if (chip.isChecked()) {
                ((ChipGroup) view).check(chip.getId());
            }
            chip.setOnCheckedChangeListenerInternal(ChipGroup.access$1000(this.k));
        }
        ViewGroup$OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener = this.j;
        if (viewGroup$OnHierarchyChangeListener != null) {
            viewGroup$OnHierarchyChangeListener.onChildViewAdded(view, view2);
        }
    }

    @Override // android.view.ViewGroup$OnHierarchyChangeListener
    public void onChildViewRemoved(View view, View view2) {
        if (view == this.k && (view2 instanceof Chip)) {
            ((Chip) view2).setOnCheckedChangeListenerInternal(null);
        }
        ViewGroup$OnHierarchyChangeListener viewGroup$OnHierarchyChangeListener = this.j;
        if (viewGroup$OnHierarchyChangeListener != null) {
            viewGroup$OnHierarchyChangeListener.onChildViewRemoved(view, view2);
        }
    }
}
