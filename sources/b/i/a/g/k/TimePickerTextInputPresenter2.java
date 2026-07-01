package b.i.a.g.k;

import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: renamed from: b.i.a.g.k.j, reason: use source file name */
/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimePickerTextInputPresenter2 implements MaterialButtonToggleGroup.OnButtonCheckedListener {
    public final /* synthetic */ TimePickerTextInputPresenter a;

    public TimePickerTextInputPresenter2(TimePickerTextInputPresenter timePickerTextInputPresenter) {
        this.a = timePickerTextInputPresenter;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        this.a.k.d(i == R.id.material_clock_period_pm_button ? 1 : 0);
    }
}
