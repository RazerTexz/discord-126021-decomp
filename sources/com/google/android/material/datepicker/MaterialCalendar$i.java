package com.google.android.material.datepicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$i implements View$OnClickListener {
    public final /* synthetic */ MonthsPagerAdapter j;
    public final /* synthetic */ MaterialCalendar k;

    public MaterialCalendar$i(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.k = materialCalendar;
        this.j = monthsPagerAdapter;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        int iFindFirstVisibleItemPosition = this.k.getLayoutManager().findFirstVisibleItemPosition() + 1;
        if (iFindFirstVisibleItemPosition < MaterialCalendar.access$000(this.k).getAdapter().getPageSize()) {
            this.k.setCurrentMonth(this.j.a(iFindFirstVisibleItemPosition));
        }
    }
}
