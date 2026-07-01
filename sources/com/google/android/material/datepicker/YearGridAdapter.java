package com.google.android.material.datepicker;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.i.a.g.d.a;
import b.i.a.g.d.b;
import b.i.a.g.d.l;
import b.i.a.g.d.m;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Locale;

/* JADX INFO: loaded from: classes3.dex */
public class YearGridAdapter extends RecyclerView$Adapter<YearGridAdapter$ViewHolder> {
    public final MaterialCalendar<?> a;

    public YearGridAdapter(MaterialCalendar<?> materialCalendar) {
        this.a = materialCalendar;
    }

    public int a(int i) {
        return i - this.a.getCalendarConstraints().getStart().l;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.a.getCalendarConstraints().getYearSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        YearGridAdapter$ViewHolder yearGridAdapter$ViewHolder = (YearGridAdapter$ViewHolder) recyclerView$ViewHolder;
        int i2 = this.a.getCalendarConstraints().getStart().l + i;
        String string = yearGridAdapter$ViewHolder.textView.getContext().getString(R$string.mtrl_picker_navigate_to_year_description);
        yearGridAdapter$ViewHolder.textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i2)));
        yearGridAdapter$ViewHolder.textView.setContentDescription(String.format(string, Integer.valueOf(i2)));
        b calendarStyle = this.a.getCalendarStyle();
        Calendar calendarH = l.h();
        a aVar = calendarH.get(1) == i2 ? calendarStyle.f : calendarStyle.d;
        Iterator<Long> it = this.a.getDateSelector().getSelectedDays().iterator();
        while (it.hasNext()) {
            calendarH.setTimeInMillis(it.next().longValue());
            if (calendarH.get(1) == i2) {
                aVar = calendarStyle.e;
            }
        }
        aVar.b(yearGridAdapter$ViewHolder.textView);
        yearGridAdapter$ViewHolder.textView.setOnClickListener(new m(this, i2));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    @NonNull
    public RecyclerView$ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new YearGridAdapter$ViewHolder((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_year, viewGroup, false));
    }
}
