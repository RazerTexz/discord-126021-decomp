package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import b.i.a.g.k.ClockFaceView2;
import b.i.a.g.k.ClockFaceView3;
import b.i.a.g.k.RadialViewGroup;
import com.google.android.material.R;
import com.google.android.material.resources.MaterialResources;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Arrays;

/* JADX INFO: loaded from: classes3.dex */
public class ClockFaceView extends RadialViewGroup implements ClockHandView.OnRotateListener {
    public final ClockHandView m;
    public final Rect n;
    public final RectF o;
    public final SparseArray<TextView> p;
    public final AccessibilityDelegateCompat q;
    public final int[] r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final float[] f3073s;
    public final int t;
    public String[] u;
    public float v;
    public final ColorStateList w;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i = R.attr.materialClockStyle;
        super(context, attributeSet, i);
        this.n = new Rect();
        this.o = new RectF();
        this.p = new SparseArray<>();
        this.f3073s = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ClockFaceView, i, R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockNumberTextColor);
        this.w = colorStateList;
        LayoutInflater.from(context).inflate(R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R.id.material_clock_hand);
        this.m = clockHandView;
        this.t = resources.getDimensionPixelSize(R.dimen.material_clock_hand_padding);
        int colorForState = colorStateList.getColorForState(new int[]{android.R.attr.state_selected}, colorStateList.getDefaultColor());
        this.r = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.q.add(this);
        int defaultColor = AppCompatResources.getColorStateList(context, R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ClockFaceView2(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.q = new ClockFaceView3(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        c(strArr, 0);
    }

    public final void b() {
        RectF rectF = this.m.u;
        for (int i = 0; i < this.p.size(); i++) {
            TextView textView = this.p.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.n);
                this.n.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.n);
                this.o.set(this.n);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.o) ? null : new RadialGradient(rectF.centerX() - this.o.left, rectF.centerY() - this.o.top, 0.5f * rectF.width(), this.r, this.f3073s, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }

    public void c(String[] strArr, @StringRes int i) {
        this.u = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.p.size();
        for (int i2 = 0; i2 < Math.max(this.u.length, size); i2++) {
            TextView textView = this.p.get(i2);
            if (i2 >= this.u.length) {
                removeView(textView);
                this.p.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.p.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.u[i2]);
                textView.setTag(R.id.material_value_index, Integer.valueOf(i2));
                ViewCompat.setAccessibilityDelegate(textView, this.q);
                textView.setTextColor(this.w);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.u[i2]));
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.u.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        b();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z2) {
        if (Math.abs(this.v - f) > 0.001f) {
            this.v = f;
            b();
        }
    }
}
