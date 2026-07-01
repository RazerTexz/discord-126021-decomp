package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.PropertyValuesHolder;
import android.text.TextUtils;
import android.view.ViewGroup$LayoutParams;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import b.i.a.g.e.a;
import b.i.a.g.e.b;
import com.google.android.material.R$animator;
import com.google.android.material.animation.MotionSpec;

/* JADX INFO: loaded from: classes3.dex */
public class ExtendedFloatingActionButton$h extends b {
    public final ExtendedFloatingActionButton$k g;
    public final boolean h;
    public final /* synthetic */ ExtendedFloatingActionButton i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ExtendedFloatingActionButton$h(ExtendedFloatingActionButton extendedFloatingActionButton, a aVar, ExtendedFloatingActionButton$k extendedFloatingActionButton$k, boolean z2) {
        super(extendedFloatingActionButton, aVar);
        this.i = extendedFloatingActionButton;
        this.g = extendedFloatingActionButton$k;
        this.h = z2;
    }

    @Override // b.i.a.g.e.j
    public int b() {
        return this.h ? R$animator.mtrl_extended_fab_change_size_expand_motion_spec : R$animator.mtrl_extended_fab_change_size_collapse_motion_spec;
    }

    @Override // b.i.a.g.e.j
    public void c() {
        ExtendedFloatingActionButton.access$702(this.i, this.h);
        ViewGroup$LayoutParams layoutParams = this.i.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = this.g.a().width;
        layoutParams.height = this.g.a().height;
        ViewCompat.setPaddingRelative(this.i, this.g.getPaddingStart(), this.i.getPaddingTop(), this.g.getPaddingEnd(), this.i.getPaddingBottom());
        this.i.requestLayout();
    }

    @Override // b.i.a.g.e.j
    public boolean d() {
        return this.h == ExtendedFloatingActionButton.access$700(this.i) || this.i.getIcon() == null || TextUtils.isEmpty(this.i.getText());
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    public void e() {
        super.e();
        ExtendedFloatingActionButton.access$802(this.i, false);
        this.i.setHorizontallyScrolling(false);
        ViewGroup$LayoutParams layoutParams = this.i.getLayoutParams();
        if (layoutParams == null) {
            return;
        }
        layoutParams.width = this.g.a().width;
        layoutParams.height = this.g.a().height;
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    @NonNull
    public AnimatorSet f() {
        MotionSpec motionSpecI = i();
        if (motionSpecI.hasPropertyValues("width")) {
            PropertyValuesHolder[] propertyValues = motionSpecI.getPropertyValues("width");
            propertyValues[0].setFloatValues(this.i.getWidth(), this.g.getWidth());
            motionSpecI.setPropertyValues("width", propertyValues);
        }
        if (motionSpecI.hasPropertyValues("height")) {
            PropertyValuesHolder[] propertyValues2 = motionSpecI.getPropertyValues("height");
            propertyValues2[0].setFloatValues(this.i.getHeight(), this.g.getHeight());
            motionSpecI.setPropertyValues("height", propertyValues2);
        }
        if (motionSpecI.hasPropertyValues("paddingStart")) {
            PropertyValuesHolder[] propertyValues3 = motionSpecI.getPropertyValues("paddingStart");
            propertyValues3[0].setFloatValues(ViewCompat.getPaddingStart(this.i), this.g.getPaddingStart());
            motionSpecI.setPropertyValues("paddingStart", propertyValues3);
        }
        if (motionSpecI.hasPropertyValues("paddingEnd")) {
            PropertyValuesHolder[] propertyValues4 = motionSpecI.getPropertyValues("paddingEnd");
            propertyValues4[0].setFloatValues(ViewCompat.getPaddingEnd(this.i), this.g.getPaddingEnd());
            motionSpecI.setPropertyValues("paddingEnd", propertyValues4);
        }
        if (motionSpecI.hasPropertyValues("labelOpacity")) {
            PropertyValuesHolder[] propertyValues5 = motionSpecI.getPropertyValues("labelOpacity");
            boolean z2 = this.h;
            propertyValues5[0].setFloatValues(z2 ? 0.0f : 1.0f, z2 ? 1.0f : 0.0f);
            motionSpecI.setPropertyValues("labelOpacity", propertyValues5);
        }
        return h(motionSpecI);
    }

    @Override // b.i.a.g.e.j
    public void g(@Nullable ExtendedFloatingActionButton$OnChangedCallback extendedFloatingActionButton$OnChangedCallback) {
        if (extendedFloatingActionButton$OnChangedCallback == null) {
            return;
        }
        if (this.h) {
            extendedFloatingActionButton$OnChangedCallback.onExtended(this.i);
        } else {
            extendedFloatingActionButton$OnChangedCallback.onShrunken(this.i);
        }
    }

    @Override // b.i.a.g.e.b, b.i.a.g.e.j
    public void onAnimationStart(Animator animator) {
        a aVar = this.d;
        Animator animator2 = aVar.a;
        if (animator2 != null) {
            animator2.cancel();
        }
        aVar.a = animator;
        ExtendedFloatingActionButton.access$702(this.i, this.h);
        ExtendedFloatingActionButton.access$802(this.i, true);
        this.i.setHorizontallyScrolling(true);
    }
}
