package com.google.android.material.button;

import java.util.Comparator;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup$a implements Comparator<MaterialButton> {
    public final /* synthetic */ MaterialButtonToggleGroup j;

    public MaterialButtonToggleGroup$a(MaterialButtonToggleGroup materialButtonToggleGroup) {
        this.j = materialButtonToggleGroup;
    }

    @Override // java.util.Comparator
    public int compare(MaterialButton materialButton, MaterialButton materialButton2) {
        MaterialButton materialButton3 = materialButton;
        MaterialButton materialButton4 = materialButton2;
        int iCompareTo = Boolean.valueOf(materialButton3.isChecked()).compareTo(Boolean.valueOf(materialButton4.isChecked()));
        if (iCompareTo != 0) {
            return iCompareTo;
        }
        int iCompareTo2 = Boolean.valueOf(materialButton3.isPressed()).compareTo(Boolean.valueOf(materialButton4.isPressed()));
        return iCompareTo2 != 0 ? iCompareTo2 : Integer.valueOf(this.j.indexOfChild(materialButton3)).compareTo(Integer.valueOf(this.j.indexOfChild(materialButton4)));
    }
}
