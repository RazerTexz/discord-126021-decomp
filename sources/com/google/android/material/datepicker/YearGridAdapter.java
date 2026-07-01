package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.g.d.CalendarItemStyle;
import b.i.a.g.d.CalendarStyle;
import b.i.a.g.d.UtcDates;
import b.i.a.g.d.YearGridAdapter2;
import com.google.android.material.R;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class YearGridAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final MaterialCalendar<?> a;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final TextView textView;

        public ViewHolder(TextView textView) {
            super(textView);
            this.textView = textView;
        }
    }

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.a = materialCalendar;
    }

    public int a(int i) {
        return i - this.a.getCalendarConstraints().getStart().l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.a.getCalendarConstraints().getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        int i2 = this.a.getCalendarConstraints().getStart().l + i;
        String string = viewHolder2.textView.getContext().getString(R.string.mtrl_picker_navigate_to_year_description);
        viewHolder2.textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        viewHolder2.textView.setContentDescription(String.format(string, Integer.valueOf(i2)));
        CalendarStyle calendarStyle = this.a.getCalendarStyle();
        Calendar calendarH = UtcDates.h();
        CalendarItemStyle calendarItemStyle = calendarH.get(1) == i2 ? calendarStyle.f : calendarStyle.d;
        Iterator<Long> it = this.a.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarH.setTimeInMillis(it.next().longValue());
            if (calendarH.get(1) == i2) {
                calendarItemStyle = calendarStyle.e;
            }
        }
        calendarItemStyle.b(viewHolder2.textView);
        viewHolder2.textView.setOnClickListener(new YearGridAdapter2(this, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_year, viewGroup, false));
    }
}
