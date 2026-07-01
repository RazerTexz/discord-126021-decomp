package b.i.a.g.k;

import android.view.GestureDetector$SimpleOnGestureListener;
import android.view.MotionEvent;
import com.google.android.material.timepicker.MaterialTimePicker;
import com.google.android.material.timepicker.MaterialTimePicker$a;
import com.google.android.material.timepicker.TimePickerView;
import com.google.android.material.timepicker.TimePickerView$b;

/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class l extends GestureDetector$SimpleOnGestureListener {
    public final /* synthetic */ TimePickerView j;

    public l(TimePickerView timePickerView) {
        this.j = timePickerView;
    }

    @Override // android.view.GestureDetector$SimpleOnGestureListener, android.view.GestureDetector$OnDoubleTapListener
    public boolean onDoubleTap(MotionEvent motionEvent) {
        boolean zOnDoubleTap = super.onDoubleTap(motionEvent);
        TimePickerView$b timePickerView$b = this.j.r;
        if (timePickerView$b != null) {
            MaterialTimePicker$a materialTimePicker$a = (MaterialTimePicker$a) timePickerView$b;
            MaterialTimePicker.access$402(materialTimePicker$a.a, 1);
            MaterialTimePicker materialTimePicker = materialTimePicker$a.a;
            MaterialTimePicker.access$600(materialTimePicker, MaterialTimePicker.access$500(materialTimePicker));
            i iVarAccess$700 = MaterialTimePicker.access$700(materialTimePicker$a.a);
            iVarAccess$700.n.setChecked(iVarAccess$700.k.o == 12);
            iVarAccess$700.o.setChecked(iVarAccess$700.k.o == 10);
        }
        return zOnDoubleTap;
    }
}
