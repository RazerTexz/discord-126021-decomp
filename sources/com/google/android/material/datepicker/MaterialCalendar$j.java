package com.google.android.material.datepicker;

import android.view.View;
import android.view.View$OnClickListener;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$j implements View$OnClickListener {
    public final /* synthetic */ MonthsPagerAdapter j;
    public final /* synthetic */ MaterialCalendar k;

    public MaterialCalendar$j(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter) {
        this.k = materialCalendar;
        this.j = monthsPagerAdapter;
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        int iFindLastVisibleItemPosition = this.k.getLayoutManager().findLastVisibleItemPosition() - 1;
        if (iFindLastVisibleItemPosition >= 0) {
            this.k.setCurrentMonth(this.j.a(iFindLastVisibleItemPosition));
        }
    }
}
