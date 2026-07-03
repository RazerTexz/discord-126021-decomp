package p007b.p225i.p226a.p341g.p346e;

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
import com.google.android.material.C10817R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.ripple.RippleUtils;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.util.ArrayList;

/* JADX INFO: renamed from: b.i.a.g.e.i */
/* JADX INFO: compiled from: FloatingActionButtonImplLollipop.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C4411i extends C4408f {

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

    public C4411i(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        super(floatingActionButton, shadowViewDelegate);
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: d */
    public float mo6088d() {
        return this.f11664F.getElevation();
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: e */
    public void mo6089e(@NonNull Rect rect) {
        if (this.f11665G.isCompatPaddingEnabled()) {
            super.mo6089e(rect);
        } else if (m6104t()) {
            rect.set(0, 0, 0, 0);
        } else {
            int sizeDimension = (this.f11681r - this.f11664F.getSizeDimension()) / 2;
            rect.set(sizeDimension, sizeDimension, sizeDimension, sizeDimension);
        }
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: f */
    public void mo6090f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        Drawable layerDrawable;
        a aVar = new a((ShapeAppearanceModel) Preconditions.checkNotNull(this.f11671h));
        this.f11672i = aVar;
        aVar.setTintList(colorStateList);
        if (mode != null) {
            this.f11672i.setTintMode(mode);
        }
        this.f11672i.initializeElevationOverlay(this.f11664F.getContext());
        if (i > 0) {
            Context context = this.f11664F.getContext();
            C4405c c4405c = new C4405c((ShapeAppearanceModel) Preconditions.checkNotNull(this.f11671h));
            int color = ContextCompat.getColor(context, C10817R.color.design_fab_stroke_top_outer_color);
            int color2 = ContextCompat.getColor(context, C10817R.color.design_fab_stroke_top_inner_color);
            int color3 = ContextCompat.getColor(context, C10817R.color.design_fab_stroke_end_inner_color);
            int color4 = ContextCompat.getColor(context, C10817R.color.design_fab_stroke_end_outer_color);
            c4405c.f11636i = color;
            c4405c.f11637j = color2;
            c4405c.f11638k = color3;
            c4405c.f11639l = color4;
            float f = i;
            if (c4405c.f11635h != f) {
                c4405c.f11635h = f;
                c4405c.f11629b.setStrokeWidth(f * 1.3333f);
                c4405c.f11641n = true;
                c4405c.invalidateSelf();
            }
            c4405c.m6084b(colorStateList);
            this.f11674k = c4405c;
            layerDrawable = new LayerDrawable(new Drawable[]{(Drawable) Preconditions.checkNotNull(this.f11674k), (Drawable) Preconditions.checkNotNull(this.f11672i)});
        } else {
            this.f11674k = null;
            layerDrawable = this.f11672i;
        }
        RippleDrawable rippleDrawable = new RippleDrawable(RippleUtils.sanitizeRippleDrawableColor(colorStateList2), layerDrawable, null);
        this.f11673j = rippleDrawable;
        this.f11675l = rippleDrawable;
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: i */
    public void mo6093i() {
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: j */
    public void mo6094j() {
        m6106v();
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: k */
    public void mo6095k(int[] iArr) {
        if (Build.VERSION.SDK_INT == 21) {
            if (!this.f11664F.isEnabled()) {
                this.f11664F.setElevation(0.0f);
                this.f11664F.setTranslationZ(0.0f);
                return;
            }
            this.f11664F.setElevation(this.f11678o);
            if (this.f11664F.isPressed()) {
                this.f11664F.setTranslationZ(this.f11680q);
            } else if (this.f11664F.isFocused() || this.f11664F.isHovered()) {
                this.f11664F.setTranslationZ(this.f11679p);
            } else {
                this.f11664F.setTranslationZ(0.0f);
            }
        }
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: l */
    public void mo6096l(float f, float f2, float f3) {
        int i = Build.VERSION.SDK_INT;
        if (i == 21) {
            this.f11664F.refreshDrawableState();
        } else {
            StateListAnimator stateListAnimator = new StateListAnimator();
            stateListAnimator.addState(C4408f.f11653b, m6111x(f, f3));
            stateListAnimator.addState(C4408f.f11654c, m6111x(f, f2));
            stateListAnimator.addState(C4408f.f11655d, m6111x(f, f2));
            stateListAnimator.addState(C4408f.f11656e, m6111x(f, f2));
            AnimatorSet animatorSet = new AnimatorSet();
            ArrayList arrayList = new ArrayList();
            arrayList.add(ObjectAnimator.ofFloat(this.f11664F, Key.ELEVATION, f).setDuration(0L));
            if (i >= 22 && i <= 24) {
                FloatingActionButton floatingActionButton = this.f11664F;
                arrayList.add(ObjectAnimator.ofFloat(floatingActionButton, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, floatingActionButton.getTranslationZ()).setDuration(100L));
            }
            arrayList.add(ObjectAnimator.ofFloat(this.f11664F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, 0.0f).setDuration(100L));
            animatorSet.playSequentially((Animator[]) arrayList.toArray(new Animator[0]));
            animatorSet.setInterpolator(C4408f.f11652a);
            stateListAnimator.addState(C4408f.f11657f, animatorSet);
            stateListAnimator.addState(C4408f.f11658g, m6111x(0.0f, 0.0f));
            this.f11664F.setStateListAnimator(stateListAnimator);
        }
        if (mo6102r()) {
            m6106v();
        }
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: p */
    public void mo6100p(@Nullable ColorStateList colorStateList) {
        Drawable drawable = this.f11673j;
        if (drawable instanceof RippleDrawable) {
            ((RippleDrawable) drawable).setColor(RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        } else if (drawable != null) {
            DrawableCompat.setTintList(drawable, RippleUtils.sanitizeRippleDrawableColor(colorStateList));
        }
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: r */
    public boolean mo6102r() {
        return this.f11665G.isCompatPaddingEnabled() || !m6104t();
    }

    @Override // p007b.p225i.p226a.p341g.p346e.C4408f
    /* JADX INFO: renamed from: u */
    public void mo6105u() {
    }

    @NonNull
    /* JADX INFO: renamed from: x */
    public final Animator m6111x(float f, float f2) {
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ObjectAnimator.ofFloat(this.f11664F, Key.ELEVATION, f).setDuration(0L)).with(ObjectAnimator.ofFloat(this.f11664F, (Property<FloatingActionButton, Float>) View.TRANSLATION_Z, f2).setDuration(100L));
        animatorSet.setInterpolator(C4408f.f11652a);
        return animatorSet;
    }
}
