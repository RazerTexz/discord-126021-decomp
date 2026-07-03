package p007b.p225i.p226a.p341g.p352k;

import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.timepicker.TimePickerView;

/* JADX INFO: renamed from: b.i.a.g.k.m */
/* JADX INFO: compiled from: TimePickerView.java */
/* JADX INFO: loaded from: classes3.dex */
public class ViewOnTouchListenerC4458m implements View.OnTouchListener {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ GestureDetector f11893j;

    public ViewOnTouchListenerC4458m(TimePickerView timePickerView, GestureDetector gestureDetector) {
        this.f11893j = gestureDetector;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (((Checkable) view).isChecked()) {
            return this.f11893j.onTouchEvent(motionEvent);
        }
        return false;
    }
}
