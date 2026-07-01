package b.i.a.g.k;

import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.g.k.f, reason: use source file name */
/* JADX INFO: compiled from: TimePickerClockPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class TimePickerClockPresenter implements ClockHandView.OnRotateListener, TimePickerView.d, TimePickerView.c, ClockHandView.OnActionUpListener, TimePickerPresenter {
    public static final String[] j = {"12", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11"};
    public static final String[] k = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};
    public static final String[] l = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};
    public TimePickerView m;
    public TimeModel n;
    public float o;
    public float p;
    public boolean q = false;

    public TimePickerClockPresenter(TimePickerView timePickerView, TimeModel timeModel) {
        this.m = timePickerView;
        this.n = timeModel;
        if (timeModel.l == 0) {
            timePickerView.n.setVisibility(0);
        }
        this.m.l.q.add(this);
        TimePickerView timePickerView2 = this.m;
        timePickerView2.q = this;
        timePickerView2.p = this;
        timePickerView2.l.f3076y = this;
        g(j, "%d");
        g(k, "%d");
        g(l, "%02d");
        a();
    }

    @Override // b.i.a.g.k.TimePickerPresenter
    public void a() {
        this.p = d() * this.n.b();
        TimeModel timeModel = this.n;
        this.o = timeModel.n * 6;
        e(timeModel.o, false);
        f();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.d
    public void b(int i) {
        e(i, true);
    }

    @Override // b.i.a.g.k.TimePickerPresenter
    public void c() {
        this.m.setVisibility(8);
    }

    public final int d() {
        return this.n.l == 1 ? 15 : 30;
    }

    public void e(int i, boolean z2) {
        String[] strArr;
        boolean z3 = i == 12;
        TimePickerView timePickerView = this.m;
        timePickerView.l.l = z3;
        TimeModel timeModel = this.n;
        timeModel.o = i;
        if (z3) {
            strArr = l;
        } else {
            strArr = timeModel.l == 1 ? k : j;
        }
        timePickerView.m.c(strArr, z3 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.m.l.b(z3 ? this.o : this.p, z2);
        TimePickerView timePickerView2 = this.m;
        timePickerView2.j.setChecked(i == 12);
        timePickerView2.k.setChecked(i == 10);
        ViewCompat.setAccessibilityDelegate(this.m.k, new ClickActionDelegate(this.m.getContext(), R.string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(this.m.j, new ClickActionDelegate(this.m.getContext(), R.string.material_minute_selection));
    }

    public final void f() {
        TimePickerView timePickerView = this.m;
        TimeModel timeModel = this.n;
        int i = timeModel.p;
        int iB = timeModel.b();
        int i2 = this.n.n;
        timePickerView.n.check(i == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i2));
        String str2 = String.format(locale, "%02d", Integer.valueOf(iB));
        timePickerView.j.setText(str);
        timePickerView.k.setText(str2);
    }

    public final void g(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = TimeModel.a(this.m.getResources(), strArr[i], str);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f, boolean z2) {
        this.q = true;
        TimeModel timeModel = this.n;
        int i = timeModel.n;
        int i2 = timeModel.m;
        if (timeModel.o == 10) {
            this.m.l.b(this.p, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.m.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                e(12, true);
            }
        } else {
            int iRound = Math.round(f);
            if (!z2) {
                TimeModel timeModel2 = this.n;
                Objects.requireNonNull(timeModel2);
                timeModel2.n = (((iRound + 15) / 30) * 5) % 60;
                this.o = this.n.n * 6;
            }
            this.m.l.b(this.o, z2);
        }
        this.q = false;
        f();
        TimeModel timeModel3 = this.n;
        if (timeModel3.n == i && timeModel3.m == i2) {
            return;
        }
        this.m.performHapticFeedback(4);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z2) {
        if (this.q) {
            return;
        }
        TimeModel timeModel = this.n;
        int i = timeModel.m;
        int i2 = timeModel.n;
        int iRound = Math.round(f);
        TimeModel timeModel2 = this.n;
        if (timeModel2.o == 12) {
            int i3 = ((iRound + 3) / 6) % 60;
            timeModel2.n = i3;
            this.o = (float) Math.floor(i3 * 6);
        } else {
            this.n.c((iRound + (d() / 2)) / d());
            this.p = d() * this.n.b();
        }
        if (z2) {
            return;
        }
        f();
        TimeModel timeModel3 = this.n;
        if (timeModel3.n == i2 && timeModel3.m == i) {
            return;
        }
        this.m.performHapticFeedback(4);
    }

    @Override // b.i.a.g.k.TimePickerPresenter
    public void show() {
        this.m.setVisibility(0);
    }
}
