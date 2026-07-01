package com.google.android.material.datepicker;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView$ViewHolder;
import com.google.android.material.R$id;

/* JADX INFO: loaded from: classes3.dex */
public class MonthsPagerAdapter$ViewHolder extends RecyclerView$ViewHolder {
    public final MaterialCalendarGridView monthGrid;
    public final TextView monthTitle;

    public MonthsPagerAdapter$ViewHolder(@NonNull LinearLayout linearLayout, boolean z2) {
        super(linearLayout);
        TextView textView = (TextView) linearLayout.findViewById(R$id.month_title);
        this.monthTitle = textView;
        ViewCompat.setAccessibilityHeading(textView, true);
        this.monthGrid = (MaterialCalendarGridView) linearLayout.findViewById(R$id.month_grid);
        if (z2) {
            return;
        }
        textView.setVisibility(8);
    }
}
