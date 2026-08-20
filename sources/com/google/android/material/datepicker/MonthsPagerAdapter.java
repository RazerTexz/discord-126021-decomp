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
import com.google.android.material.C10817R;
import java.util.Iterator;
import p007b.p225i.p226a.p341g.p345d.C4396g;
import p007b.p225i.p226a.p341g.p345d.C4397h;

/* JADX INFO: loaded from: classes3.dex */
public class MonthsPagerAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* JADX INFO: renamed from: a */
    public final Context f20991a;

    /* JADX INFO: renamed from: b */
    @NonNull
    public final CalendarConstraints f20992b;

    /* JADX INFO: renamed from: c */
    public final DateSelector<?> f20993c;

    /* JADX INFO: renamed from: d */
    public final MaterialCalendar.InterfaceC10896l f20994d;

    /* JADX INFO: renamed from: e */
    public final int f20995e;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public final MaterialCalendarGridView monthGrid;
        public final TextView monthTitle;

        public ViewHolder(@NonNull LinearLayout linearLayout, boolean z2) {
            super(linearLayout);
            TextView textView = (TextView) linearLayout.findViewById(C10817R.id.month_title);
            this.monthTitle = textView;
            ViewCompat.setAccessibilityHeading(textView, true);
            this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(C10817R.id.month_grid);
            if (z2) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    public MonthsPagerAdapter(@NonNull Context context, DateSelector<?> dateSelector, @NonNull CalendarConstraints calendarConstraints, MaterialCalendar.InterfaceC10896l interfaceC10896l) {
        Month start = calendarConstraints.getStart();
        Month end = calendarConstraints.getEnd();
        Month openAt = calendarConstraints.getOpenAt();
        if (start.compareTo(openAt) > 0) {
            throw new IllegalArgumentException("firstPage cannot be after currentPage");
        }
        if (openAt.compareTo(end) > 0) {
            throw new IllegalArgumentException("currentPage cannot be after lastPage");
        }
        int dayHeight = MaterialCalendar.getDayHeight(context) * C4396g.f11606j;
        int dayHeight2 = MaterialDatePicker.isFullscreen(context) ? MaterialCalendar.getDayHeight(context) : 0;
        this.f20991a = context;
        this.f20995e = dayHeight + dayHeight2;
        this.f20992b = calendarConstraints;
        this.f20993c = dateSelector;
        this.f20994d = interfaceC10896l;
        setHasStableIds(true);
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public Month m9140a(int i) {
        return this.f20992b.getStart().m9138m(i);
    }

    /* JADX INFO: renamed from: b */
    public int m9141b(@NonNull Month month) {
        return this.f20992b.getStart().m9139o(month);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: getItemCount */
    public int getPageSize() {
        return this.f20992b.getMonthSpan();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int i) {
        return this.f20992b.getStart().m9138m(i).f20984j.getTimeInMillis();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ViewHolder viewHolder2 = (ViewHolder) viewHolder;
        Month monthM9138m = this.f20992b.getStart().m9138m(i);
        viewHolder2.monthTitle.setText(monthM9138m.m9137l(viewHolder2.itemView.getContext()));
        MaterialCalendarGridView materialCalendarGridView = (MaterialCalendarGridView) viewHolder2.monthGrid.findViewById(C10817R.id.month_grid);
        if (materialCalendarGridView.getAdapter() == null || !monthM9138m.equals(materialCalendarGridView.getAdapter().f11607k)) {
            C4396g c4396g = new C4396g(monthM9138m, this.f20993c, this.f20992b);
            materialCalendarGridView.setNumColumns(monthM9138m.f20987m);
            materialCalendarGridView.setAdapter((ListAdapter) c4396g);
        } else {
            materialCalendarGridView.invalidate();
            C4396g adapter = materialCalendarGridView.getAdapter();
            Iterator<Long> it = adapter.f11609m.iterator();
            while (it.hasNext()) {
                adapter.m6067f(materialCalendarGridView, it.next().longValue());
            }
            DateSelector<?> dateSelector = adapter.f11608l;
            if (dateSelector != null) {
                Iterator<Long> it2 = dateSelector.getSelectedDays().iterator();
                while (it2.hasNext()) {
                    adapter.m6067f(materialCalendarGridView, it2.next().longValue());
                }
                adapter.f11609m = adapter.f11608l.getSelectedDays();
            }
        }
        materialCalendarGridView.setOnItemClickListener(new C4397h(this, materialCalendarGridView));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(viewGroup.getContext()).inflate(C10817R.layout.mtrl_calendar_month_labeled, viewGroup, false);
        if (!MaterialDatePicker.isFullscreen(viewGroup.getContext())) {
            return new ViewHolder(linearLayout, false);
        }
        linearLayout.setLayoutParams(new RecyclerView.LayoutParams(-1, this.f20995e));
        return new ViewHolder(linearLayout, true);
    }
}
