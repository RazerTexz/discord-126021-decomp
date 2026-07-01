package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View$OnClickListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import b.i.a.g.k.k;
import b.i.a.g.k.l;
import b.i.a.g.k.m;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes3.dex */
public class TimePickerView extends ConstraintLayout {
    public final Chip j;
    public final Chip k;
    public final ClockHandView l;
    public final ClockFaceView m;
    public final MaterialButtonToggleGroup n;
    public final View$OnClickListener o;
    public TimePickerView$c p;
    public TimePickerView$d q;
    public TimePickerView$b r;

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        TimePickerView$a timePickerView$a = new TimePickerView$a(this);
        this.o = timePickerView$a;
        LayoutInflater.from(context).inflate(R$layout.material_timepicker, this);
        this.m = (ClockFaceView) findViewById(R$id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R$id.material_clock_period_toggle);
        this.n = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new k(this));
        Chip chip = (Chip) findViewById(R$id.material_minute_tv);
        this.j = chip;
        Chip chip2 = (Chip) findViewById(R$id.material_hour_tv);
        this.k = chip2;
        this.l = (ClockHandView) findViewById(R$id.material_clock_hand);
        m mVar = new m(this, new GestureDetector(getContext(), new l(this)));
        chip.setOnTouchListener(mVar);
        chip2.setOnTouchListener(mVar);
        int i = R$id.selection_type;
        chip.setTag(i, 12);
        chip2.setTag(i, 10);
        chip.setOnClickListener(timePickerView$a);
        chip2.setOnClickListener(timePickerView$a);
    }

    public final void a() {
        if (this.n.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(R$id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
            constraintSet.applyTo(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        a();
    }

    @Override // android.view.View
    public void onVisibilityChanged(@NonNull View view, int i) {
        super.onVisibilityChanged(view, i);
        if (view == this && i == 0) {
            a();
        }
    }
}
