package p007b.p225i.p226a.p341g.p352k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: renamed from: b.i.a.g.k.l */
/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4457l extends GestureDetector.SimpleOnGestureListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ TimePickerView f11892j;

    public C4457l(TimePickerView timePickerView) {
        this.f11892j = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.InterfaceC11029b interfaceC11029b = this.f11892j.f21235r;
        if (interfaceC11029b != null) {
            MaterialTimePicker.C11023a c11023a = (MaterialTimePicker.C11023a) interfaceC11029b;
            MaterialTimePicker.this.inputMode = 1;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.updateInputMode(materialTimePicker.modeButton);
            C4454i c4454i = MaterialTimePicker.this.timePickerTextInputPresenter;
            c4454i.f11881n.setChecked(c4454i.f11878k.f21225o == 12);
            c4454i.f11882o.setChecked(c4454i.f11878k.f21225o == 10);
        }
        return zOnDoubleTap;
    }
}
