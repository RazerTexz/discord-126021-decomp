package b.i.a.g.e;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.StateListAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build$VERSION;
import android.util.Property;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.constraintlayout.motion.widget.Key;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.util.Preconditions;
import com.google.android.material.R$color;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class i extends f {
    public i(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @Override // b.i.a.g.e.f
    public float d() {
        return this.F.getElevation();
    }

    @Override // b.i.a.g.e.f
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

    @Override // b.i.a.g.e.f
    public void f(ColorStateList colorStateList, @Nullable PorterDuff$Mode porterDuff$Mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        i$a i_a = new i$a((ShapeAppearanceModel) Preconditions.checkNotNull(this.h));
        this.i = i_a;
        i_a.setTintList(colorStateList);
        if (porterDuff$Mode != null) {
            this.i.setTintMode(porterDuff$Mode);
        }
        this.i.initializeElevationOverlay(this.F.getContext());
        if (i > 0) {
            Context context = this.F.getContext();
            c cVar = new c((ShapeAppearanceModel) Preconditions.checkNotNull(this.h));
            int color = ContextCompat.getColor(context, R$color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, R$color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, R$color.design_fab_stroke_end_outer_color);
            cVar.i = color;
            cVar.j = color2;
            cVar.k = color3;
            cVar.l = color4;
            float f = i;
            if (cVar.h != f) {
                cVar.h = f;
                cVar.f1612b.setStrokeWidth(f * 1.3333f);
                cVar.n = true;
                cVar.invalidateSelf();
            }
            cVar.b(colorStateList);
            this.k = cVar;
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.k), (Drawable) Preconditions.checkNotNull(this.i)});
        } else {
            this.k = null;
            layerDrawable = this.i;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), layerDrawable, null);
        this.j = rippleDrawable;
        this.l = rippleDrawable;
    }

    @Override // b.i.a.g.e.f
    public void i() {
    }

    @Override // b.i.a.g.e.f
    public void j() {
        v();
    }

    @Override // b.i.a.g.e.f
    public void k(int[] iArr) {
        if (Build$VERSION.SDK_INT == 21) {
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

    @Override // b.i.a.g.e.f
    public void l(float f, float f2, float f3) {
        int i = Build$VERSION.SDK_INT;
        if (i == 21) {
            this.F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(f.f1615b, x(f, f3));
            stateListAnimator.addState(f.c, x(f, f2));
            stateListAnimator.addState(f.d, x(f, f2));
            stateListAnimator.addState(f.e, x(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.F, Key.ELEVATION, f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(f.a);
            stateListAnimator.addState(f.f, animatorSet);
            stateListAnimator.addState(f.g, x(0.0f, 0.0f));
            this.F.setStateListAnimator(stateListAnimator);
        }
        if (r()) {
            v();
        }
    }

    @Override // b.i.a.g.e.f
    public void p(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    @Override // b.i.a.g.e.f
    public boolean r() {
        return this.G.isCompatPaddingEnabled() || !t();
    }

    @Override // b.i.a.g.e.f
    public void u() {
    }

    @NonNull
    public final Animator x(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.F, Key.ELEVATION, f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(f.a);
        return animatorSet;
    }
}
