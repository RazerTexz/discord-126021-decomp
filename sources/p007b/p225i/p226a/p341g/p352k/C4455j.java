package p007b.p225i.p226a.p341g.p352k;

import com.google.android.material.C10817R;
import com.google.android.material.button.MaterialButtonToggleGroup;

/* JADX INFO: renamed from: b.i.a.g.k.j */
/* JADX INFO: compiled from: TimePickerTextInputPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4455j implements MaterialButtonToggleGroup.OnButtonCheckedListener {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ C4454i f11890a;

    public C4455j(C4454i c4454i) {
        this.f11890a = c4454i;
    }

    @Override // com.google.android.material.button.MaterialButtonToggleGroup.OnButtonCheckedListener
    public void onButtonChecked(MaterialButtonToggleGroup materialButtonToggleGroup, int i, boolean z2) {
        this.f11890a.f11878k.m9163d(i == C10817R.id.material_clock_period_pm_button ? 1 : 0);
    }
}
