package com.google.android.material.timepicker;

import android.R;
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
import com.google.android.material.C10817R;
import com.google.android.material.resources.MaterialResources;
import java.util.Arrays;
import p007b.p225i.p226a.p341g.p352k.C4448c;
import p007b.p225i.p226a.p341g.p352k.C4450e;
import p007b.p225i.p226a.p341g.p352k.ViewTreeObserverOnPreDrawListenerC4447b;

/* JADX INFO: loaded from: classes3.dex */
public class ClockFaceView extends C4450e implements ClockHandView.OnRotateListener {

    /* JADX INFO: renamed from: m */
    public final ClockHandView f21186m;

    /* JADX INFO: renamed from: n */
    public final Rect f21187n;

    /* JADX INFO: renamed from: o */
    public final RectF f21188o;

    /* JADX INFO: renamed from: p */
    public final SparseArray<TextView> f21189p;

    /* JADX INFO: renamed from: q */
    public final AccessibilityDelegateCompat f21190q;

    /* JADX INFO: renamed from: r */
    public final int[] f21191r;

    /* JADX INFO: renamed from: s */
    public final float[] f21192s;

    /* JADX INFO: renamed from: t */
    public final int f21193t;

    /* JADX INFO: renamed from: u */
    public String[] f21194u;

    /* JADX INFO: renamed from: v */
    public float f21195v;

    /* JADX INFO: renamed from: w */
    public final ColorStateList f21196w;

    /* JADX WARN: Illegal instructions before constructor call */
    public ClockFaceView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        int i = C10817R.attr.materialClockStyle;
        super(context, attributeSet, i);
        this.f21187n = new Rect();
        this.f21188o = new RectF();
        this.f21189p = new SparseArray<>();
        this.f21192s = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10817R.styleable.ClockFaceView, i, C10817R.style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList colorStateList = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.ClockFaceView_clockNumberTextColor);
        this.f21196w = colorStateList;
        LayoutInflater.from(context).inflate(C10817R.layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(C10817R.id.material_clock_hand);
        this.f21186m = clockHandView;
        this.f21193t = resources.getDimensionPixelSize(C10817R.dimen.material_clock_hand_padding);
        int colorForState = colorStateList.getColorForState(new int[]{R.attr.state_selected}, colorStateList.getDefaultColor());
        this.f21191r = new int[]{colorForState, colorForState, colorStateList.getDefaultColor()};
        clockHandView.f21205q.add(this);
        int defaultColor = AppCompatResources.getColorStateList(context, C10817R.color.material_timepicker_clockface).getDefaultColor();
        ColorStateList colorStateList2 = MaterialResources.getColorStateList(context, typedArrayObtainStyledAttributes, C10817R.styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(colorStateList2 != null ? colorStateList2.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserverOnPreDrawListenerC4447b(this));
        setFocusable(true);
        typedArrayObtainStyledAttributes.recycle();
        this.f21190q = new C4448c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        m9156c(strArr, 0);
    }

    /* JADX INFO: renamed from: b */
    public final void m9155b() {
        RectF rectF = this.f21186m.f21209u;
        for (int i = 0; i < this.f21189p.size(); i++) {
            TextView textView = this.f21189p.get(i);
            if (textView != null) {
                textView.getDrawingRect(this.f21187n);
                this.f21187n.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, this.f21187n);
                this.f21188o.set(this.f21187n);
                textView.getPaint().setShader(!RectF.intersects(rectF, this.f21188o) ? null : new RadialGradient(rectF.centerX() - this.f21188o.left, rectF.centerY() - this.f21188o.top, 0.5f * rectF.width(), this.f21191r, this.f21192s, Shader.TileMode.CLAMP));
                textView.invalidate();
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public void m9156c(String[] strArr, @StringRes int i) {
        this.f21194u = strArr;
        LayoutInflater layoutInflaterFrom = LayoutInflater.from(getContext());
        int size = this.f21189p.size();
        for (int i2 = 0; i2 < Math.max(this.f21194u.length, size); i2++) {
            TextView textView = this.f21189p.get(i2);
            if (i2 >= this.f21194u.length) {
                removeView(textView);
                this.f21189p.remove(i2);
            } else {
                if (textView == null) {
                    textView = (TextView) layoutInflaterFrom.inflate(C10817R.layout.material_clockface_textview, (ViewGroup) this, false);
                    this.f21189p.put(i2, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.f21194u[i2]);
                textView.setTag(C10817R.id.material_value_index, Integer.valueOf(i2));
                ViewCompat.setAccessibilityDelegate(textView, this.f21190q);
                textView.setTextColor(this.f21196w);
                if (i != 0) {
                    textView.setContentDescription(getResources().getString(i, this.f21194u[i2]));
                }
            }
        }
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        AccessibilityNodeInfoCompat.wrap(accessibilityNodeInfo).setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(1, this.f21194u.length, false, 1));
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        m9155b();
    }

    @Override // com.google.android.material.timepicker.ClockHandView.OnRotateListener
    public void onRotate(float f, boolean z2) {
        if (Math.abs(this.f21195v - f) > 0.001f) {
            this.f21195v = f;
            m9155b();
        }
    }
}
