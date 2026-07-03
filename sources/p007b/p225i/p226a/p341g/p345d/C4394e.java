package p007b.p225i.p226a.p341g.p345d;

import android.annotation.SuppressLint;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C10817R;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: renamed from: b.i.a.g.d.e */
/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4394e extends BaseAdapter {

    /* JADX INFO: renamed from: j */
    public static final int f11602j;

    /* JADX INFO: renamed from: k */
    @NonNull
    public final Calendar f11603k;

    /* JADX INFO: renamed from: l */
    public final int f11604l;

    /* JADX INFO: renamed from: m */
    public final int f11605m;

    static {
        f11602j = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public C4394e() {
        Calendar calendarM6076i = C4401l.m6076i();
        this.f11603k = calendarM6076i;
        this.f11604l = calendarM6076i.getMaximum(7);
        this.f11605m = calendarM6076i.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.f11604l;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i) {
        int i2 = this.f11604l;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.f11605m;
        if (i3 > i2) {
            i3 -= i2;
        }
        return Integer.valueOf(i3);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    @Nullable
    @SuppressLint({"WrongConstant"})
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C10817R.layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.f11603k;
        int i2 = i + this.f11605m;
        int i3 = this.f11604l;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.f11603k.getDisplayName(7, f11602j, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(C10817R.string.mtrl_picker_day_of_week_column_header), this.f11603k.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
