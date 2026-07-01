package b.i.a.g.e;

import android.R$attr;
import android.animation.Animator;
import android.animation.Animator$AnimatorListener;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.Matrix$ScaleToFit;
import android.graphics.PorterDuff$Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build$VERSION;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver$OnPreDrawListener;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class f {
    public static final TimeInterpolator a = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f1615b = {R$attr.state_pressed, R$attr.state_enabled};
    public static final int[] c = {R$attr.state_hovered, R$attr.state_focused, R$attr.state_enabled};
    public static final int[] d = {R$attr.state_focused, R$attr.state_enabled};
    public static final int[] e = {R$attr.state_hovered, R$attr.state_enabled};
    public static final int[] f = {R$attr.state_enabled};
    public static final int[] g = new int[0];
    public int A;
    public ArrayList<Animator$AnimatorListener> C;
    public ArrayList<Animator$AnimatorListener> D;
    public ArrayList<f$e> E;
    public final FloatingActionButton F;
    public final ShadowViewDelegate G;

    @Nullable
    public ViewTreeObserver$OnPreDrawListener L;

    @Nullable
    public ShapeAppearanceModel h;

    @Nullable
    public MaterialShapeDrawable i;

    @Nullable
    public Drawable j;

    @Nullable
    public c k;

    @Nullable
    public Drawable l;
    public boolean m;
    public float o;
    public float p;
    public float q;
    public int r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    @NonNull
    public final StateListAnimator f1616s;

    @Nullable
    public MotionSpec t;

    @Nullable
    public MotionSpec u;

    @Nullable
    public Animator v;

    @Nullable
    public MotionSpec w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    @Nullable
    public MotionSpec f1617x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f1618y;
    public boolean n = true;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f1619z = 1.0f;
    public int B = 0;
    public final Rect H = new Rect();
    public final RectF I = new RectF();
    public final RectF J = new RectF();
    public final Matrix K = new Matrix();

    public f(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.F = floatingActionButton;
        this.G = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f1616s = stateListAnimator;
        stateListAnimator.addState(f1615b, c(new f$d(this)));
        stateListAnimator.addState(c, c(new f$c(this)));
        stateListAnimator.addState(d, c(new f$c(this)));
        stateListAnimator.addState(e, c(new f$c(this)));
        stateListAnimator.addState(f, c(new f$g(this)));
        stateListAnimator.addState(g, c(new f$b(this)));
        this.f1618y = floatingActionButton.getRotation();
    }

    public final void a(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.F.getDrawable();
        if (drawable == null || this.A == 0) {
            return;
        }
        RectF rectF = this.I;
        RectF rectF2 = this.J;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i = this.A;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix$ScaleToFit.CENTER);
        int i2 = this.A;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    @NonNull
    public final AnimatorSet b(@NonNull MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        motionSpec.getTiming("opacity").apply(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat2);
        int i = Build$VERSION.SDK_INT;
        if (i == 26) {
            objectAnimatorOfFloat2.setEvaluator(new g(this));
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.F, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat3);
        if (i == 26) {
            objectAnimatorOfFloat3.setEvaluator(new g(this));
        }
        arrayList.add(objectAnimatorOfFloat3);
        a(f4, this.K);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.F, new ImageMatrixProperty(), new f$a(this), new Matrix(this.K));
        motionSpec.getTiming("iconScale").apply(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    public final ValueAnimator c(@NonNull f$h f_h) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(f_h);
        valueAnimator.addUpdateListener(f_h);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    public float d() {
        throw null;
    }

    public void e(@NonNull Rect rect) {
        int sizeDimension = this.m ? (this.r - this.F.getSizeDimension()) / 2 : 0;
        float fD = this.n ? d() + this.q : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fD));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fD * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    public void f(ColorStateList colorStateList, @Nullable PorterDuff$Mode porterDuff$Mode, ColorStateList colorStateList2, int i) {
        throw null;
    }

    public boolean g() {
        if (this.F.getVisibility() == 0) {
            return this.B == 1;
        }
        return this.B != 2;
    }

    public boolean h() {
        if (this.F.getVisibility() != 0) {
            return this.B == 2;
        }
        return this.B != 1;
    }

    public void i() {
        throw null;
    }

    public void j() {
        throw null;
    }

    public void k(int[] iArr) {
        throw null;
    }

    public void l(float f2, float f3, float f4) {
        throw null;
    }

    public void m() {
        ArrayList<f$e> arrayList = this.E;
        if (arrayList != null) {
            Iterator<f$e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().b();
            }
        }
    }

    public void n() {
        ArrayList<f$e> arrayList = this.E;
        if (arrayList != null) {
            Iterator<f$e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().a();
            }
        }
    }

    public final void o(float f2) {
        this.f1619z = f2;
        Matrix matrix = this.K;
        a(f2, matrix);
        this.F.setImageMatrix(matrix);
    }

    public void p(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    public final void q(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.h = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.j;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        c cVar = this.k;
        if (cVar != null) {
            cVar.o = shapeAppearanceModel;
            cVar.invalidateSelf();
        }
    }

    public boolean r() {
        throw null;
    }

    public final boolean s() {
        return ViewCompat.isLaidOut(this.F) && !this.F.isInEditMode();
    }

    public final boolean t() {
        return !this.m || this.F.getSizeDimension() >= this.r;
    }

    public void u() {
        throw null;
    }

    public final void v() {
        Rect rect = this.H;
        e(rect);
        Preconditions.checkNotNull(this.l, "Didn't initialize content background");
        if (r()) {
            this.G.setBackgroundDrawable(new InsetDrawable(this.l, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.G.setBackgroundDrawable(this.l);
        }
        this.G.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    public void w(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f2);
        }
    }
}
