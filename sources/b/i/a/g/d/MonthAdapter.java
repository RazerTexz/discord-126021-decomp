package b.i.a.g.d;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateSelector;
import com.google.android.material.datepicker.MaterialCalendarGridView;
import com.google.android.material.datepicker.Month;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: b.i.a.g.d.g, reason: use source file name */
/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class MonthAdapter extends BaseAdapter {
    public static final int j = UtcDates.i().getMaximum(4);
    public final Month k;
    public final DateSelector<?> l;
    public Collection<Long> m;
    public CalendarStyle n;
    public final CalendarConstraints o;

    public MonthAdapter(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.k = month;
        this.l = dateSelector;
        this.o = calendarConstraints;
        this.m = dateSelector.getSelectedDays();
    }

    public int a(int i) {
        return b() + (i - 1);
    }

    public int b() {
        return this.k.j();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < this.k.j() || i > d()) {
            return null;
        }
        Month month = this.k;
        return Long.valueOf(month.k((i - month.j()) + 1));
    }

    public int d() {
        return (this.k.j() + this.k.n) - 1;
    }

    public final void e(@Nullable TextView textView, long j2) {
        CalendarItemStyle calendarItemStyle;
        if (textView == null) {
            return;
        }
        boolean z2 = false;
        if (this.o.getDateValidator().isValid(j2)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.l.getSelectedDays().iterator();
            while (it.hasNext()) {
                if (UtcDates.a(j2) == UtcDates.a(it.next().longValue())) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                calendarItemStyle = this.n.f1609b;
            } else {
                calendarItemStyle = UtcDates.h().getTimeInMillis() == j2 ? this.n.c : this.n.a;
            }
        } else {
            textView.setEnabled(false);
            calendarItemStyle = this.n.g;
        }
        calendarItemStyle.b(textView);
    }

    public final void f(MaterialCalendarGridView materialCalendarGridView, long j2) {
        if (Month.h(j2).equals(this.k)) {
            Calendar calendarD = UtcDates.d(this.k.j);
            calendarD.setTimeInMillis(j2);
            e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().a(calendarD.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j2);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return b() + this.k.n;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.k.m;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00d5  */
    @Override // android.widget.Adapter
    @NonNull
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Context context = viewGroup.getContext();
        if (this.n == null) {
            this.n = new CalendarStyle(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iB = i - b();
        if (iB >= 0) {
            Month month = this.k;
            if (iB >= month.n) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i2 = iB + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
                long jK = this.k.k(i2);
                if (this.k.l == Month.i().l) {
                    Locale locale = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence2 = UtcDates.c("MMMEd", locale).format(new Date(jK));
                    } else {
                        AtomicReference<TimeSource> atomicReference = UtcDates.a;
                        DateFormat dateInstance = DateFormat.getDateInstance(0, locale);
                        dateInstance.setTimeZone(UtcDates.g());
                        charSequence2 = dateInstance.format(new Date(jK));
                    }
                    textView.setContentDescription(charSequence2);
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence = UtcDates.c("yMMMEd", locale2).format(new Date(jK));
                    } else {
                        AtomicReference<TimeSource> atomicReference2 = UtcDates.a;
                        DateFormat dateInstance2 = DateFormat.getDateInstance(0, locale2);
                        dateInstance2.setTimeZone(UtcDates.g());
                        charSequence = dateInstance2.format(new Date(jK));
                    }
                    textView.setContentDescription(charSequence);
                }
                textView.setVisibility(0);
                textView.setEnabled(true);
            }
        } else {
            textView.setVisibility(8);
            textView.setEnabled(false);
        }
        Long item = getItem(i);
        if (item != null) {
            e(textView, item.longValue());
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
