package com.google.android.material.datepicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView$OnScrollListener;
import com.google.android.material.button.MaterialButton;

/* JADX INFO: loaded from: classes3.dex */
public class MaterialCalendar$g extends RecyclerView$OnScrollListener {
    public final /* synthetic */ MonthsPagerAdapter a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f3035b;
    public final /* synthetic */ MaterialCalendar c;

    public MaterialCalendar$g(MaterialCalendar materialCalendar, MonthsPagerAdapter monthsPagerAdapter, MaterialButton materialButton) {
        this.c = materialCalendar;
        this.a = monthsPagerAdapter;
        this.f3035b = materialButton;
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.f3035b.getText());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView$OnScrollListener
    public void onScrolled(@NonNull RecyclerView recyclerView, int i, int i2) {
        int iFindFirstVisibleItemPosition = i < 0 ? this.c.getLayoutManager().findFirstVisibleItemPosition() : this.c.getLayoutManager().findLastVisibleItemPosition();
        MaterialCalendar.access$602(this.c, this.a.a(iFindFirstVisibleItemPosition));
        MaterialButton materialButton = this.f3035b;
        MonthsPagerAdapter monthsPagerAdapter = this.a;
        materialButton.setText(monthsPagerAdapter.f3036b.getStart().m(iFindFirstVisibleItemPosition).l(monthsPagerAdapter.a));
    }
}
