package b.i.a.g.k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: renamed from: b.i.a.g.k.l, reason: use source file name */
/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimePickerView3 extends GestureDetector.SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView j;

    public TimePickerView3(TimePickerView timePickerView) {
        this.j = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView.b bVar = this.j.r;
        if (bVar != null) {
            MaterialTimePicker.a aVar = (MaterialTimePicker.a) bVar;
            MaterialTimePicker.this.inputMode = 1;
            MaterialTimePicker materialTimePicker = MaterialTimePicker.this;
            materialTimePicker.updateInputMode(materialTimePicker.modeButton);
            TimePickerTextInputPresenter timePickerTextInputPresenter = MaterialTimePicker.this.timePickerTextInputPresenter;
            timePickerTextInputPresenter.n.setChecked(timePickerTextInputPresenter.k.o == 12);
            timePickerTextInputPresenter.o.setChecked(timePickerTextInputPresenter.k.o == 10);
        }
        return zOnDoubleTap;
    }
}
