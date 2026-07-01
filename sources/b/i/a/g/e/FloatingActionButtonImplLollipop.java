package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.i.a.g.e.i, reason: use source file name */
/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class FloatingActionButtonImplLollipop extends FloatingActionButtonImpl3 {

    /* JADX INFO: renamed from: b.i.a.g.e.i$a */
    /* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
    public static class a extends MaterialShapeDrawable {
        public a(ShapeAppearanceModel shapeAppearanceModel) {
            super(shapeAppearanceModel);
        }

        @Override // com.google.android.material.shape.MaterialShapeDrawable, android.graphics.drawable.Drawable
        public boolean isStateful() {
            return true;
        }
    }

    public FloatingActionButtonImplLollipop(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public float d() {
        return this.F.getElevation();
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void e(@NonNull Rect rect) {
        if (this.G.isCompatPaddingEnabled()) {
            super.e(rect);
        } else if (t()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.r - this.F.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        a aVar = new a((ShapeAppearanceModel) Preconditions.checkNotNull(this.h));
        this.i = aVar;
        aVar.setTintList(colorStateList);
        if (mode != null) {
            this.i.setTintMode(mode);
        }
        this.i.initializeElevationOverlay(this.F.getContext());
        if (i > 0) {
            Context context = this.F.getContext();
            BorderDrawable borderDrawable = new BorderDrawable((ShapeAppearanceModel) Preconditions.checkNotNull(this.h));
            int color = ContextCompat.getColor(context, R.color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, R.color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, R.color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, R.color.design_fab_stroke_end_outer_color);
            borderDrawable.i = color;
            borderDrawable.j = color2;
            borderDrawable.k = color3;
            borderDrawable.l = color4;
            float f = i;
            if (borderDrawable.h != f) {
                borderDrawable.h = f;
                borderDrawable.f1612b.setStrokeWidth(f * 1.3333f);
                borderDrawable.n = true;
                borderDrawable.invalidateSelf();
            }
            borderDrawable.b(colorStateList);
            this.k = borderDrawable;
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.k), (Drawable) Preconditions.checkNotNull(this.i)});
        } else {
            this.k = null;
            layerDrawable = this.i;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), layerDrawable, null);
        this.j = rippleDrawable;
        this.l = rippleDrawable;
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void i() {
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void j() {
        v();
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void k(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.F.isEnabled()) {
                this.F.setElevation(0.0f);
                this.F.setTranslationZ(0.0f);
                return;
            }
            this.F.setElevation(this.o);
            if (this.F.isPressed()) {
                this.F.setTranslationZ(this.q);
            } else if (this.F.isFocused() || this.F.isHovered()) {
                this.F.setTranslationZ(this.p);
            } else {
                this.F.setTranslationZ(0.0f);
            }
        }
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void l(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(FloatingActionButtonImpl3.f1615b, x(f, f3));
            stateListAnimator.addState(FloatingActionButtonImpl3.c, x(f, f2));
            stateListAnimator.addState(FloatingActionButtonImpl3.d, x(f, f2));
            stateListAnimator.addState(FloatingActionButtonImpl3.e, x(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.F, Key.ELEVATION, f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(FloatingActionButtonImpl3.a);
            stateListAnimator.addState(FloatingActionButtonImpl3.f, animatorSet);
            stateListAnimator.addState(FloatingActionButtonImpl3.g, x(0.0f, 0.0f));
            this.F.setStateListAnimator(stateListAnimator);
        }
        if (r()) {
            v();
        }
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void p(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public boolean r() {
        return this.G.isCompatPaddingEnabled() || !t();
    }

    @Override // b.i.a.g.e.FloatingActionButtonImpl3
    public void u() {
    }

    @NonNull
    public final Animator x(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.F, Key.ELEVATION, f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(FloatingActionButtonImpl3.a);
        return animatorSet;
    }
}
