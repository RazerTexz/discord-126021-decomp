package p007b.p225i.p226a.p341g.p352k;

import android.view.accessibility.AccessibilityManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.material.C10817R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimeModel;
import com.google.android.material.timepicker.TimePickerView;
import java.util.Locale;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.g.k.f */
/* JADX INFO: compiled from: TimePickerClockPresenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4451f implements ClockHandView.OnRotateListener, TimePickerView.InterfaceC11031d, TimePickerView.InterfaceC11030c, ClockHandView.OnActionUpListener, InterfaceC4452g {

    /* JADX INFO: renamed from: j */
    public static final String[] f11865j = {"12", "1", ExifInterface.GPS_MEASUREMENT_2D, ExifInterface.GPS_MEASUREMENT_3D, "4", "5", "6", "7", "8", "9", "10", "11"};

    /* JADX INFO: renamed from: k */
    public static final String[] f11866k = {"00", ExifInterface.GPS_MEASUREMENT_2D, "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* JADX INFO: renamed from: l */
    public static final String[] f11867l = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* JADX INFO: renamed from: m */
    public TimePickerView f11868m;

    /* JADX INFO: renamed from: n */
    public TimeModel f11869n;

    /* JADX INFO: renamed from: o */
    public float f11870o;

    /* JADX INFO: renamed from: p */
    public float f11871p;

    /* JADX INFO: renamed from: q */
    public boolean f11872q = false;

    public C4451f(TimePickerView timePickerView, TimeModel timeModel) {
        this.f11868m = timePickerView;
        this.f11869n = timeModel;
        if (timeModel.f21222l == 0) {
            timePickerView.f21231n.setVisibility(0);
        }
        this.f11868m.f21229l.f21205q.add(this);
        TimePickerView timePickerView2 = this.f11868m;
        timePickerView2.f21234q = this;
        timePickerView2.f21233p = this;
        timePickerView2.f21229l.f21213y = this;
        m6177g(f11865j, "%d");
        m6177g(f11866k, "%d");
        m6177g(f11867l, "%02d");
        mo6171a();
    }

    @Override // p007b.p225i.p226a.p341g.p352k.InterfaceC4452g
    /* JADX INFO: renamed from: a */
    public void mo6171a() {
        this.f11871p = m6174d() * this.f11869n.m9161b();
        TimeModel timeModel = this.f11869n;
        this.f11870o = timeModel.f21224n * 6;
        m6175e(timeModel.f21225o, false);
        m6176f();
    }

    @Override // com.google.android.material.timepicker.TimePickerView.InterfaceC11031d
    /* JADX INFO: renamed from: b */
    public void mo6172b(int i) {
        m6175e(i, true);
    }

    @Override // p007b.p225i.p226a.p341g.p352k.InterfaceC4452g
    /* JADX INFO: renamed from: c */
    public void mo6173c() {
        this.f11868m.setVisibility(8);
    }

    /* JADX INFO: renamed from: d */
    public final int m6174d() {
        return this.f11869n.f21222l == 1 ? 15 : 30;
    }

    /* JADX INFO: renamed from: e */
    public void m6175e(int i, boolean z2) {
        String[] strArr;
        boolean z3 = i == 12;
        TimePickerView timePickerView = this.f11868m;
        timePickerView.f21229l.f21200l = z3;
        TimeModel timeModel = this.f11869n;
        timeModel.f21225o = i;
        if (z3) {
            strArr = f11867l;
        } else {
            strArr = timeModel.f21222l == 1 ? f11866k : f11865j;
        }
        timePickerView.f21230m.m9156c(strArr, z3 ? C10817R.string.material_minute_suffix : C10817R.string.material_hour_suffix);
        this.f11868m.f21229l.m9158b(z3 ? this.f11870o : this.f11871p, z2);
        TimePickerView timePickerView2 = this.f11868m;
        timePickerView2.f21227j.setChecked(i == 12);
        timePickerView2.f21228k.setChecked(i == 10);
        ViewCompat.setAccessibilityDelegate(this.f11868m.f21228k, new C4446a(this.f11868m.getContext(), C10817R.string.material_hour_selection));
        ViewCompat.setAccessibilityDelegate(this.f11868m.f21227j, new C4446a(this.f11868m.getContext(), C10817R.string.material_minute_selection));
    }

    /* JADX INFO: renamed from: f */
    public final void m6176f() {
        TimePickerView timePickerView = this.f11868m;
        TimeModel timeModel = this.f11869n;
        int i = timeModel.f21226p;
        int iM9161b = timeModel.m9161b();
        int i2 = this.f11869n.f21224n;
        timePickerView.f21231n.check(i == 1 ? C10817R.id.material_clock_period_pm_button : C10817R.id.material_clock_period_am_button);
        Locale locale = timePickerView.getResources().getConfiguration().locale;
        String str = String.format(locale, "%02d", Integer.valueOf(i2));
        String str2 = String.format(locale, "%02d", Integer.valueOf(iM9161b));
        timePickerView.f21227j.setText(str);
        timePickerView.f21228k.setText(str2);
    }

    /* JADX INFO: renamed from: g */
    public final void m6177g(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = TimeModel.m9160a(this.f11868m.getResources(), strArr[i], str);
        }
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnActionUpListener
    public void onActionUp(float f, boolean z2) {
        this.f11872q = true;
        TimeModel timeModel = this.f11869n;
        int i = timeModel.f21224n;
        int i2 = timeModel.f21223m;
        if (timeModel.f21225o == 10) {
            this.f11868m.f21229l.m9158b(this.f11871p, false);
            if (!((AccessibilityManager) ContextCompat.getSystemService(this.f11868m.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                m6175e(12, true);
            }
        } else {
            int iRound = Math.round(f);
            if (!z2) {
                TimeModel timeModel2 = this.f11869n;
                Objects.requireNonNull(timeModel2);
                timeModel2.f21224n = (((iRound + 15) / 30) * 5) % 60;
                this.f11870o = this.f11869n.f21224n * 6;
            }
            this.f11868m.f21229l.m9158b(this.f11870o, z2);
        }
        this.f11872q = false;
        m6176f();
        TimeModel timeModel3 = this.f11869n;
        if (timeModel3.f21224n == i && timeModel3.f21223m == i2) {
            return;
        }
        this.f11868m.performHapticFeedback(4);
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z2) {
        if (this.f11872q) {
            return;
        }
        TimeModel timeModel = this.f11869n;
        int i = timeModel.f21223m;
        int i2 = timeModel.f21224n;
        int iRound = Math.round(f);
        TimeModel timeModel2 = this.f11869n;
        if (timeModel2.f21225o == 12) {
            int i3 = ((iRound + 3) / 6) % 60;
            timeModel2.f21224n = i3;
            this.f11870o = (float) Math.floor(i3 * 6);
        } else {
            this.f11869n.m9162c((iRound + (m6174d() / 2)) / m6174d());
            this.f11871p = m6174d() * this.f11869n.m9161b();
        }
        if (z2) {
            return;
        }
        m6176f();
        TimeModel timeModel3 = this.f11869n;
        if (timeModel3.f21224n == i2 && timeModel3.f21223m == i) {
            return;
        }
        this.f11868m.performHapticFeedback(4);
    }

    @Override // p007b.p225i.p226a.p341g.p352k.InterfaceC4452g
    public void show() {
        this.f11868m.setVisibility(0);
    }
}
