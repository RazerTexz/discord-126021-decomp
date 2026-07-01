package com.google.android.material.button;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialButtonToggleGroup$c implements MaterialButton$OnCheckedChangeListener {
    public final /* synthetic */ MaterialButtonToggleGroup a;

    public MaterialButtonToggleGroup$c(MaterialButtonToggleGroup materialButtonToggleGroup, MaterialButtonToggleGroup$a materialButtonToggleGroup$a) {
        this.a = materialButtonToggleGroup;
    }

    @Override // com.google.android.material.button.MaterialButton$OnCheckedChangeListener
    public void onCheckedChanged(@NonNull MaterialButton materialButton, boolean z2) {
        if (MaterialButtonToggleGroup.access$300(this.a)) {
            return;
        }
        if (MaterialButtonToggleGroup.access$400(this.a)) {
            MaterialButtonToggleGroup.access$502(this.a, z2 ? materialButton.getId() : -1);
        }
        if (MaterialButtonToggleGroup.access$600(this.a, materialButton.getId(), z2)) {
            MaterialButtonToggleGroup.access$700(this.a, materialButton.getId(), materialButton.isChecked());
        }
        this.a.invalidate();
    }
}
