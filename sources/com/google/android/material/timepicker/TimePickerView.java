package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.core.view.ViewCompat;
import b.i.a.g.k.TimePickerView2;
import b.i.a.g.k.TimePickerView3;
import b.i.a.g.k.TimePickerView4;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;

/* JADX INFO: loaded from: classes3.dex */
public class TimePickerView extends ConstraintLayout {
    public final Chip j;
    public final Chip k;
    public final ClockHandView l;
    public final ClockFaceView m;
    public final MaterialButtonToggleGroup n;
    public final View.OnClickListener o;
    public c p;
    public d q;
    public b r;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d dVar = TimePickerView.this.q;
            if (dVar != null) {
                dVar.b(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        }
    }

    public interface b {
    }

    public interface c {
    }

    public interface d {
        void b(int i);
    }

    public TimePickerView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        a aVar = new a();
        this.o = aVar;
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.m = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.n = materialButtonToggleGroup;
        materialButtonToggleGroup.addOnButtonCheckedListener(new TimePickerView2(this));
        Chip chip = (Chip) findViewById(R.id.material_minute_tv);
        this.j = chip;
        Chip chip2 = (Chip) findViewById(R.id.material_hour_tv);
        this.k = chip2;
        this.l = (ClockHandView) findViewById(R.id.material_clock_hand);
        TimePickerView4 timePickerView4 = new TimePickerView4(this, new GestureDetector(getContext(), new TimePickerView3(this)));
        chip.setOnTouchListener(timePickerView4);
        chip2.setOnTouchListener(timePickerView4);
        int i = R.id.selection_type;
        chip.setTag(i, 12);
        chip2.setTag(i, 10);
        chip.setOnClickListener(aVar);
        chip2.setOnClickListener(aVar);
    }

    public final void a() {
        if (this.n.getVisibility() == 0) {
            ConstraintSet constraintSet = new ConstraintSet();
            constraintSet.clone(this);
            constraintSet.clear(R.id.material_clock_display, ViewCompat.getLayoutDirection(this) == 0 ? 2 : 1);
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
