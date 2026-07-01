package b.i.a.g.k;

import com.google.android.material.R$id;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.button.MaterialButtonToggleGroup$OnButtonCheckedListener;
import com.google.android.material.timepicker.TimePickerView;
import com.google.android.material.timepicker.TimePickerView$c;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class k implements MaterialButtonToggleGroup$OnButtonCheckedListener {
    public final /* synthetic */ TimePickerView a;

    public k(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup$OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        int i2 = i == R$id.material_clock_period_pm_button ? 1 : 0;
        TimePickerView$c timePickerView$c = this.a.p;
        if (timePickerView$c == null || !z2) {
            return;
        }
        ((f) timePickerView$c).n.d(i2);
    }
}
