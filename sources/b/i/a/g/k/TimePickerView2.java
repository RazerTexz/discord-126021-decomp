package b.i.a.g.k;

import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: renamed from: b.i.a.g.k.k, reason: use source file name */
/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimePickerView2 implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ TimePickerView a;

    public TimePickerView2(TimePickerView timePickerView) {
        this.a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        int i2 = i == R.id.material_clock_period_pm_button ? 1 : 0;
        TimePickerView.c cVar = this.a.p;
        if (cVar == null || !z2) {
            return;
        }
        ((TimePickerClockPresenter) cVar).n.d(i2);
    }
}
