package p007b.p225i.p226a.p341g.p352k;

import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: renamed from: b.i.a.g.k.k */
/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4456k implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ TimePickerView f11891a;

    public C4456k(TimePickerView timePickerView) {
        this.f11891a = timePickerView;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        int i2 = i == C10817R.id.material_clock_period_pm_button ? 1 : 0;
        TimePickerView.InterfaceC11030c interfaceC11030c = this.f11891a.f21233p;
        if (interfaceC11030c == null || !z2) {
            return;
        }
        ((C4451f) interfaceC11030c).f11869n.m9163d(i2);
    }
}
