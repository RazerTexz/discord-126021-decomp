package b.i.a.g.k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: renamed from: b.i.a.g.k.m, reason: use source file name */
/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimePickerView4 implements View.OnTouchListener {
    public final /* synthetic */ GestureDetector j;

    public TimePickerView4(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.j = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.j.onTouchEvent(motionEvent);
        }
        return false;
    }
}
