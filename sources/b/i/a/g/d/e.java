package b.i.a.g.d;

import android.annotation.SuppressLint;
import android.os.Build$VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: DaysOfWeekAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class e extends BaseAdapter {
    public static final int j;

    @NonNull
    public final Calendar k;
    public final int l;
    public final int m;

    static {
        j = Build$VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar calendarI = l.i();
        this.k = calendarI;
        this.l = calendarI.getMaximum(7);
        this.m = calendarI.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return this.l;
    }

    @Override // android.widget.Adapter
    @Nullable
    public Object getItem(int i) {
        int i2 = this.l;
        if (i >= i2) {
            return null;
        }
        int i3 = i + this.m;
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
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_day_of_week, viewGroup, false);
        }
        Calendar calendar = this.k;
        int i2 = i + this.m;
        int i3 = this.l;
        if (i2 > i3) {
            i2 -= i3;
        }
        calendar.set(7, i2);
        textView.setText(this.k.getDisplayName(7, j, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(R$string.mtrl_picker_day_of_week_column_header), this.k.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }
}
