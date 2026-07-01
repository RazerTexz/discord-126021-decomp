package com.google.android.material.chip;

import android.widget.CompoundButton;
import android.widget.CompoundButton$OnCheckedChangeListener;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: classes3.dex */
public class ChipGroup$CheckedStateTracker implements CompoundButton$OnCheckedChangeListener {
    public final /* synthetic */ ChipGroup a;

    public ChipGroup$CheckedStateTracker(ChipGroup chipGroup, ChipGroup$a chipGroup$a) {
        this.a = chipGroup;
    }

    @Override // android.widget.CompoundButton$OnCheckedChangeListener
    public void onCheckedChanged(@NonNull CompoundButton compoundButton, boolean z2) {
        if (ChipGroup.access$300(this.a)) {
            return;
        }
        if (this.a.getCheckedChipIds().isEmpty() && ChipGroup.access$400(this.a)) {
            ChipGroup.access$500(this.a, compoundButton.getId(), true);
            ChipGroup.access$600(this.a, compoundButton.getId(), false);
            return;
        }
        int id2 = compoundButton.getId();
        if (!z2) {
            if (ChipGroup.access$700(this.a) == id2) {
                ChipGroup.access$900(this.a, -1);
            }
        } else {
            if (ChipGroup.access$700(this.a) != -1 && ChipGroup.access$700(this.a) != id2 && ChipGroup.access$800(this.a)) {
                ChipGroup chipGroup = this.a;
                ChipGroup.access$500(chipGroup, ChipGroup.access$700(chipGroup), false);
            }
            ChipGroup.access$900(this.a, id2);
        }
    }
}
