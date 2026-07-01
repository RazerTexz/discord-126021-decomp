package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;
import b.i.a.g.d.MonthAdapter;
import b.i.a.g.d.MonthsPagerAdapter2;
import com.google.android.material.R;
import com.google.android.material.datepicker.MaterialCalendar;
import java.util.Iterator;

/* JADX INFO: loaded from: classes3.dex */
public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    public final Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    public final CalendarConstraints f3036b;
    public final DateSelector<?> c;
    public final MaterialCalendar.l d;
    public final int e;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(@NonNull LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(R.id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R.id.month_grid);
            if (z2) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.l lVar) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int dayHeight = MaterialCalendar.getDayHeight(context) * MonthAdapter.j;
        int dayHeight2 = MaterialDatePicker.isFullscreen(context) ? MaterialCalendar.getDayHeight(context) : 0;
        this.a = context;
        this.e = dayHeight + dayHeight2;
        this.f3036b = calendarConstraints;
        this.c = dateSelector;
        this.d = lVar;
        setHasStableIds(true);
    }

    @NonNull
    public Month a(int i) {
        return this.f3036b.getStart().m(i);
    }

    public int b(@NonNull Month month) {
        return this.f3036b.getStart().o(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.f3036b.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.f3036b.getStart().m(i).j.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Month monthM = this.f3036b.getStart().m(i);
        viewHolder2.monthTitle.setText(monthM.l(viewHolder2.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.monthGrid.findViewById(R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthM.equals(materialCalendarGridView.getAdapter().k)) {
            MonthAdapter monthAdapter = new MonthAdapter(monthM, this.c, this.f3036b);
            materialCalendarGridView.setNumColumns(monthM.m);
            materialCalendarGridView.setAdapter((ListAdapter) monthAdapter);
        } else {
            materialCalendarGridView.invalidate();
            MonthAdapter adapter = materialCalendarGridView.getAdapter();
            Iterator<Long> it = adapter.m.iterator();
            while (it.hasNext()) {
                adapter.f(materialCalendarGridView, it.next().longValue());
            }
            DateSelector<?> dateSelector = adapter.l;
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    adapter.f(materialCalendarGridView, it2.next().longValue());
                }
                adapter.m = adapter.l.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new MonthsPagerAdapter2(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.e));
        return new ViewHolder(linearLayout, true);
    }
}
