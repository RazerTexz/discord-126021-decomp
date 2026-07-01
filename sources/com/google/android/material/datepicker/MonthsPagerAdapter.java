package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView$Adapter;
import androidx.recyclerview.widget.RecyclerView$LayoutParams;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import b.i.a.g.d.g;
import b.i.a.g.d.h;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MonthsPagerAdapter extends RecyclerView$Adapter<MonthsPagerAdapter$ViewHolder> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CalendarConstraints f3036b;
    public final DateSelector<?> c;
    public final MaterialCalendar$l d;
    public final int e;

    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar$l materialCalendar$l) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.f(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.f(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int dayHeight = MaterialCalendar.getDayHeight(context) * g.j;
        int dayHeight2 = MaterialDatePicker.isFullscreen(context) ? MaterialCalendar.getDayHeight(context) : 0;
        this.a = context;
        this.e = dayHeight + dayHeight2;
        this.f3036b = calendarConstraints;
        this.c = dateSelector;
        this.d = materialCalendar$l;
        setHasStableIds(true);
    }

    @NonNull
    public Month a(int i) {
        return this.f3036b.getStart().m(i);
    }

    public int b(@NonNull Month month) {
        return this.f3036b.getStart().o(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public int getItemCount() {
        return this.f3036b.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public long getItemId(int i) {
        return this.f3036b.getStart().m(i).j.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    public void onBindViewHolder(@NonNull RecyclerView$ViewHolder recyclerView$ViewHolder, int i) {
        MonthsPagerAdapter$ViewHolder monthsPagerAdapter$ViewHolder = (MonthsPagerAdapter$ViewHolder) recyclerView$ViewHolder;
        Month monthM = this.f3036b.getStart().m(i);
        monthsPagerAdapter$ViewHolder.monthTitle.setText(monthM.l(monthsPagerAdapter$ViewHolder.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) monthsPagerAdapter$ViewHolder.monthGrid.findViewById(R$id.month_grid);
        if (materialCalendarGridView.a() == null || !monthM.equals(materialCalendarGridView.a().k)) {
            g gVar = new g(monthM, this.c, this.f3036b);
            materialCalendarGridView.setNumColumns(monthM.m);
            materialCalendarGridView.setAdapter((ListAdapter) gVar);
        } else {
            materialCalendarGridView.invalidate();
            g gVarA = materialCalendarGridView.a();
            Iterator<Long> it = gVarA.m.iterator();
            while (it.hasNext()) {
                gVarA.f(materialCalendarGridView, it.next().longValue());
            }
            DateSelector<?> dateSelector = gVarA.l;
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    gVarA.f(materialCalendarGridView, it2.next().longValue());
                }
                gVarA.m = gVarA.l.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new h(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView$Adapter
    @NonNull
    public RecyclerView$ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R$layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new MonthsPagerAdapter$ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView$LayoutParams(-1, this.e));
        return new MonthsPagerAdapter$ViewHolder(linearLayout, true);
    }
}
