package p007b.p225i.p226a.p341g.p345d;

import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.C10817R;
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

/* JADX INFO: renamed from: b.i.a.g.d.g */
/* JADX INFO: compiled from: MonthAdapter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4396g extends BaseAdapter {

    /* JADX INFO: renamed from: j */
    public static final int f11606j = C4401l.m6076i().getMaximum(4);

    /* JADX INFO: renamed from: k */
    public final Month f11607k;

    /* JADX INFO: renamed from: l */
    public final DateSelector<?> f11608l;

    /* JADX INFO: renamed from: m */
    public Collection<Long> f11609m;

    /* JADX INFO: renamed from: n */
    public C4391b f11610n;

    /* JADX INFO: renamed from: o */
    public final CalendarConstraints f11611o;

    public C4396g(Month month, DateSelector<?> dateSelector, CalendarConstraints calendarConstraints) {
        this.f11607k = month;
        this.f11608l = dateSelector;
        this.f11611o = calendarConstraints;
        this.f11609m = dateSelector.getSelectedDays();
    }

    /* JADX INFO: renamed from: a */
    public int m6062a(int i) {
        return m6063b() + (i - 1);
    }

    /* JADX INFO: renamed from: b */
    public int m6063b() {
        return this.f11607k.m9135j();
    }

    @Override // android.widget.Adapter
    @Nullable
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public Long getItem(int i) {
        if (i < this.f11607k.m9135j() || i > m6065d()) {
            return null;
        }
        Month month = this.f11607k;
        return Long.valueOf(month.m9136k((i - month.m9135j()) + 1));
    }

    /* JADX INFO: renamed from: d */
    public int m6065d() {
        return (this.f11607k.m9135j() + this.f11607k.f20988n) - 1;
    }

    /* JADX INFO: renamed from: e */
    public final void m6066e(@Nullable TextView textView, long j) {
        C4390a c4390a;
        if (textView == null) {
            return;
        }
        boolean z2 = false;
        if (this.f11611o.getDateValidator().isValid(j)) {
            textView.setEnabled(true);
            Iterator<Long> it = this.f11608l.getSelectedDays().iterator();
            while (it.hasNext()) {
                if (C4401l.m6068a(j) == C4401l.m6068a(it.next().longValue())) {
                    z2 = true;
                    break;
                }
            }
            if (z2) {
                c4390a = this.f11610n.f11585b;
            } else {
                c4390a = C4401l.m6075h().getTimeInMillis() == j ? this.f11610n.f11586c : this.f11610n.f11584a;
            }
        } else {
            textView.setEnabled(false);
            c4390a = this.f11610n.f11590g;
        }
        c4390a.m6059b(textView);
    }

    /* JADX INFO: renamed from: f */
    public final void m6067f(MaterialCalendarGridView materialCalendarGridView, long j) {
        if (Month.m9132h(j).equals(this.f11607k)) {
            Calendar calendarM6071d = C4401l.m6071d(this.f11607k.f20984j);
            calendarM6071d.setTimeInMillis(j);
            m6066e((TextView) materialCalendarGridView.getChildAt(materialCalendarGridView.getAdapter().m6062a(calendarM6071d.get(5)) - materialCalendarGridView.getFirstVisiblePosition()), j);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return m6063b() + this.f11607k.f20988n;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i / this.f11607k.f20987m;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x00d5  */
    @Override // android.widget.Adapter
    @NonNull
    public View getView(int i, @Nullable View view, @NonNull ViewGroup viewGroup) {
        CharSequence charSequence;
        CharSequence charSequence2;
        Context context = viewGroup.getContext();
        if (this.f11610n == null) {
            this.f11610n = new C4391b(context);
        }
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(C10817R.layout.mtrl_calendar_day, viewGroup, false);
        }
        int iM6063b = i - m6063b();
        if (iM6063b >= 0) {
            Month month = this.f11607k;
            if (iM6063b >= month.f20988n) {
                textView.setVisibility(8);
                textView.setEnabled(false);
            } else {
                int i2 = iM6063b + 1;
                textView.setTag(month);
                textView.setText(String.format(textView.getResources().getConfiguration().locale, "%d", Integer.valueOf(i2)));
                long jM9136k = this.f11607k.m9136k(i2);
                if (this.f11607k.f20986l == Month.m9133i().f20986l) {
                    Locale locale = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence2 = C4401l.m6070c("MMMEd", locale).format(new Date(jM9136k));
                    } else {
                        AtomicReference<C4400k> atomicReference = C4401l.f11617a;
                        DateFormat dateInstance = DateFormat.getDateInstance(0, locale);
                        dateInstance.setTimeZone(C4401l.m6074g());
                        charSequence2 = dateInstance.format(new Date(jM9136k));
                    }
                    textView.setContentDescription(charSequence2);
                } else {
                    Locale locale2 = Locale.getDefault();
                    if (Build.VERSION.SDK_INT >= 24) {
                        charSequence = C4401l.m6070c("yMMMEd", locale2).format(new Date(jM9136k));
                    } else {
                        AtomicReference<C4400k> atomicReference2 = C4401l.f11617a;
                        DateFormat dateInstance2 = DateFormat.getDateInstance(0, locale2);
                        dateInstance2.setTimeZone(C4401l.m6074g());
                        charSequence = dateInstance2.format(new Date(jM9136k));
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
            m6066e(textView, item.longValue());
        }
        return textView;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return true;
    }
}
