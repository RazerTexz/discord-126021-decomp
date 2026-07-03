package p007b.p225i.p226a.p341g.p346e;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.Property;
import android.view.View;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.animation.AnimatorSetCompat;
import com.google.android.material.animation.ImageMatrixProperty;
import com.google.android.material.animation.MatrixEvaluator;
import com.google.android.material.animation.MotionSpec;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.internal.StateListAnimator;
import com.google.android.material.shadow.ShadowViewDelegate;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import com.google.android.material.shape.Shapeable;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: b.i.a.g.e.f */
/* JADX INFO: compiled from: FloatingActionButtonImpl.java */
/* JADX INFO: loaded from: classes3.dex */
public class C4408f {

    /* JADX INFO: renamed from: a */
    public static final TimeInterpolator f11652a = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;

    /* JADX INFO: renamed from: b */
    public static final int[] f11653b = {R.attr.state_pressed, R.attr.state_enabled};

    /* JADX INFO: renamed from: c */
    public static final int[] f11654c = {R.attr.state_hovered, R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: d */
    public static final int[] f11655d = {R.attr.state_focused, R.attr.state_enabled};

    /* JADX INFO: renamed from: e */
    public static final int[] f11656e = {R.attr.state_hovered, R.attr.state_enabled};

    /* JADX INFO: renamed from: f */
    public static final int[] f11657f = {R.attr.state_enabled};

    /* JADX INFO: renamed from: g */
    public static final int[] f11658g = new int[0];

    /* JADX INFO: renamed from: A */
    public int f11659A;

    /* JADX INFO: renamed from: C */
    public ArrayList<Animator.AnimatorListener> f11661C;

    /* JADX INFO: renamed from: D */
    public ArrayList<Animator.AnimatorListener> f11662D;

    /* JADX INFO: renamed from: E */
    public ArrayList<e> f11663E;

    /* JADX INFO: renamed from: F */
    public final FloatingActionButton f11664F;

    /* JADX INFO: renamed from: G */
    public final ShadowViewDelegate f11665G;

    /* JADX INFO: renamed from: L */
    @Nullable
    public ViewTreeObserver.OnPreDrawListener f11670L;

    /* JADX INFO: renamed from: h */
    @Nullable
    public ShapeAppearanceModel f11671h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public MaterialShapeDrawable f11672i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public Drawable f11673j;

    /* JADX INFO: renamed from: k */
    @Nullable
    public C4405c f11674k;

    /* JADX INFO: renamed from: l */
    @Nullable
    public Drawable f11675l;

    /* JADX INFO: renamed from: m */
    public boolean f11676m;

    /* JADX INFO: renamed from: o */
    public float f11678o;

    /* JADX INFO: renamed from: p */
    public float f11679p;

    /* JADX INFO: renamed from: q */
    public float f11680q;

    /* JADX INFO: renamed from: r */
    public int f11681r;

    /* JADX INFO: renamed from: s */
    @NonNull
    public final StateListAnimator f11682s;

    /* JADX INFO: renamed from: t */
    @Nullable
    public MotionSpec f11683t;

    /* JADX INFO: renamed from: u */
    @Nullable
    public MotionSpec f11684u;

    /* JADX INFO: renamed from: v */
    @Nullable
    public Animator f11685v;

    /* JADX INFO: renamed from: w */
    @Nullable
    public MotionSpec f11686w;

    /* JADX INFO: renamed from: x */
    @Nullable
    public MotionSpec f11687x;

    /* JADX INFO: renamed from: y */
    public float f11688y;

    /* JADX INFO: renamed from: n */
    public boolean f11677n = true;

    /* JADX INFO: renamed from: z */
    public float f11689z = 1.0f;

    /* JADX INFO: renamed from: B */
    public int f11660B = 0;

    /* JADX INFO: renamed from: H */
    public final Rect f11666H = new Rect();

    /* JADX INFO: renamed from: I */
    public final RectF f11667I = new RectF();

    /* JADX INFO: renamed from: J */
    public final RectF f11668J = new RectF();

    /* JADX INFO: renamed from: K */
    public final Matrix f11669K = new Matrix();

    /* JADX INFO: renamed from: b.i.a.g.e.f$b */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class b extends h {
        public b(C4408f c4408f) {
            super(null);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.C4408f.h
        /* JADX INFO: renamed from: a */
        public float mo6108a() {
            return 0.0f;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$c */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class c extends h {
        public c() {
            super(null);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.C4408f.h
        /* JADX INFO: renamed from: a */
        public float mo6108a() {
            C4408f c4408f = C4408f.this;
            return c4408f.f11678o + c4408f.f11679p;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$d */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class d extends h {
        public d() {
            super(null);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.C4408f.h
        /* JADX INFO: renamed from: a */
        public float mo6108a() {
            C4408f c4408f = C4408f.this;
            return c4408f.f11678o + c4408f.f11680q;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$e */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public interface e {
        /* JADX INFO: renamed from: a */
        void mo6109a();

        /* JADX INFO: renamed from: b */
        void mo6110b();
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$f */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public interface f {
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$g */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class g extends h {
        public g() {
            super(null);
        }

        @Override // p007b.p225i.p226a.p341g.p346e.C4408f.h
        /* JADX INFO: renamed from: a */
        public float mo6108a() {
            return C4408f.this.f11678o;
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$h */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public abstract class h extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a */
        public boolean f11694a;

        /* JADX INFO: renamed from: b */
        public float f11695b;

        /* JADX INFO: renamed from: c */
        public float f11696c;

        public h(C4406d c4406d) {
        }

        /* JADX INFO: renamed from: a */
        public abstract float mo6108a();

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C4408f.this.m6107w((int) this.f11696c);
            this.f11694a = false;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(@NonNull ValueAnimator valueAnimator) {
            if (!this.f11694a) {
                MaterialShapeDrawable materialShapeDrawable = C4408f.this.f11672i;
                this.f11695b = materialShapeDrawable == null ? 0.0f : materialShapeDrawable.getElevation();
                this.f11696c = mo6108a();
                this.f11694a = true;
            }
            C4408f c4408f = C4408f.this;
            float f = this.f11695b;
            c4408f.m6107w((int) ((valueAnimator.getAnimatedFraction() * (this.f11696c - f)) + f));
        }
    }

    public C4408f(FloatingActionButton floatingActionButton, ShadowViewDelegate shadowViewDelegate) {
        this.f11664F = floatingActionButton;
        this.f11665G = shadowViewDelegate;
        StateListAnimator stateListAnimator = new StateListAnimator();
        this.f11682s = stateListAnimator;
        stateListAnimator.addState(f11653b, m6087c(new d()));
        stateListAnimator.addState(f11654c, m6087c(new c()));
        stateListAnimator.addState(f11655d, m6087c(new c()));
        stateListAnimator.addState(f11656e, m6087c(new c()));
        stateListAnimator.addState(f11657f, m6087c(new g()));
        stateListAnimator.addState(f11658g, m6087c(new b(this)));
        this.f11688y = floatingActionButton.getRotation();
    }

    /* JADX INFO: renamed from: a */
    public final void m6085a(float f2, @NonNull Matrix matrix) {
        matrix.reset();
        Drawable drawable = this.f11664F.getDrawable();
        if (drawable == null || this.f11659A == 0) {
            return;
        }
        RectF rectF = this.f11667I;
        RectF rectF2 = this.f11668J;
        rectF.set(0.0f, 0.0f, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
        int i = this.f11659A;
        rectF2.set(0.0f, 0.0f, i, i);
        matrix.setRectToRect(rectF, rectF2, Matrix.ScaleToFit.CENTER);
        int i2 = this.f11659A;
        matrix.postScale(f2, f2, i2 / 2.0f, i2 / 2.0f);
    }

    @NonNull
    /* JADX INFO: renamed from: b */
    public final AnimatorSet m6086b(@NonNull MotionSpec motionSpec, float f2, float f3, float f4) {
        ArrayList arrayList = new ArrayList();
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(this.f11664F, (Property<FloatingActionButton, Float>) View.ALPHA, f2);
        motionSpec.getTiming("opacity").apply(objectAnimatorOfFloat);
        arrayList.add(objectAnimatorOfFloat);
        ObjectAnimator objectAnimatorOfFloat2 = ObjectAnimator.ofFloat(this.f11664F, (Property<FloatingActionButton, Float>) View.SCALE_X, f3);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat2);
        int i = Build.VERSION.SDK_INT;
        if (i == 26) {
            objectAnimatorOfFloat2.setEvaluator(new C4409g(this));
        }
        arrayList.add(objectAnimatorOfFloat2);
        ObjectAnimator objectAnimatorOfFloat3 = ObjectAnimator.ofFloat(this.f11664F, (Property<FloatingActionButton, Float>) View.SCALE_Y, f3);
        motionSpec.getTiming("scale").apply(objectAnimatorOfFloat3);
        if (i == 26) {
            objectAnimatorOfFloat3.setEvaluator(new C4409g(this));
        }
        arrayList.add(objectAnimatorOfFloat3);
        m6085a(f4, this.f11669K);
        ObjectAnimator objectAnimatorOfObject = ObjectAnimator.ofObject(this.f11664F, new ImageMatrixProperty(), new a(), new Matrix(this.f11669K));
        motionSpec.getTiming("iconScale").apply(objectAnimatorOfObject);
        arrayList.add(objectAnimatorOfObject);
        AnimatorSet animatorSet = new AnimatorSet();
        AnimatorSetCompat.playTogether(animatorSet, arrayList);
        return animatorSet;
    }

    @NonNull
    /* JADX INFO: renamed from: c */
    public final ValueAnimator m6087c(@NonNull h hVar) {
        ValueAnimator valueAnimator = new ValueAnimator();
        valueAnimator.setInterpolator(f11652a);
        valueAnimator.setDuration(100L);
        valueAnimator.addListener(hVar);
        valueAnimator.addUpdateListener(hVar);
        valueAnimator.setFloatValues(0.0f, 1.0f);
        return valueAnimator;
    }

    /* JADX INFO: renamed from: d */
    public float mo6088d() {
        throw null;
    }

    /* JADX INFO: renamed from: e */
    public void mo6089e(@NonNull Rect rect) {
        int sizeDimension = this.f11676m ? (this.f11681r - this.f11664F.getSizeDimension()) / 2 : 0;
        float fMo6088d = this.f11677n ? mo6088d() + this.f11680q : 0.0f;
        int iMax = Math.max(sizeDimension, (int) Math.ceil(fMo6088d));
        int iMax2 = Math.max(sizeDimension, (int) Math.ceil(fMo6088d * 1.5f));
        rect.set(iMax, iMax2, iMax, iMax2);
    }

    /* JADX INFO: renamed from: f */
    public void mo6090f(ColorStateList colorStateList, @Nullable PorterDuff.Mode mode, ColorStateList colorStateList2, int i) {
        throw null;
    }

    /* JADX INFO: renamed from: g */
    public boolean m6091g() {
        if (this.f11664F.getVisibility() == 0) {
            return this.f11660B == 1;
        }
        return this.f11660B != 2;
    }

    /* JADX INFO: renamed from: h */
    public boolean m6092h() {
        if (this.f11664F.getVisibility() != 0) {
            return this.f11660B == 2;
        }
        return this.f11660B != 1;
    }

    /* JADX INFO: renamed from: i */
    public void mo6093i() {
        throw null;
    }

    /* JADX INFO: renamed from: j */
    public void mo6094j() {
        throw null;
    }

    /* JADX INFO: renamed from: k */
    public void mo6095k(int[] iArr) {
        throw null;
    }

    /* JADX INFO: renamed from: l */
    public void mo6096l(float f2, float f3, float f4) {
        throw null;
    }

    /* JADX INFO: renamed from: m */
    public void m6097m() {
        ArrayList<e> arrayList = this.f11663E;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo6110b();
            }
        }
    }

    /* JADX INFO: renamed from: n */
    public void m6098n() {
        ArrayList<e> arrayList = this.f11663E;
        if (arrayList != null) {
            Iterator<e> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().mo6109a();
            }
        }
    }

    /* JADX INFO: renamed from: o */
    public final void m6099o(float f2) {
        this.f11689z = f2;
        Matrix matrix = this.f11669K;
        m6085a(f2, matrix);
        this.f11664F.setImageMatrix(matrix);
    }

    /* JADX INFO: renamed from: p */
    public void mo6100p(@Nullable ColorStateList colorStateList) {
        throw null;
    }

    /* JADX INFO: renamed from: q */
    public final void m6101q(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
        this.f11671h = shapeAppearanceModel;
        MaterialShapeDrawable materialShapeDrawable = this.f11672i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setShapeAppearanceModel(shapeAppearanceModel);
        }
        Object obj = this.f11673j;
        if (obj instanceof Shapeable) {
            ((Shapeable) obj).setShapeAppearanceModel(shapeAppearanceModel);
        }
        C4405c c4405c = this.f11674k;
        if (c4405c != null) {
            c4405c.f11642o = shapeAppearanceModel;
            c4405c.invalidateSelf();
        }
    }

    /* JADX INFO: renamed from: r */
    public boolean mo6102r() {
        throw null;
    }

    /* JADX INFO: renamed from: s */
    public final boolean m6103s() {
        return ViewCompat.isLaidOut(this.f11664F) && !this.f11664F.isInEditMode();
    }

    /* JADX INFO: renamed from: t */
    public final boolean m6104t() {
        return !this.f11676m || this.f11664F.getSizeDimension() >= this.f11681r;
    }

    /* JADX INFO: renamed from: u */
    public void mo6105u() {
        throw null;
    }

    /* JADX INFO: renamed from: v */
    public final void m6106v() {
        Rect rect = this.f11666H;
        mo6089e(rect);
        Preconditions.checkNotNull(this.f11675l, "Didn't initialize content background");
        if (mo6102r()) {
            this.f11665G.setBackgroundDrawable(new InsetDrawable(this.f11675l, rect.left, rect.top, rect.right, rect.bottom));
        } else {
            this.f11665G.setBackgroundDrawable(this.f11675l);
        }
        this.f11665G.setShadowPadding(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX INFO: renamed from: w */
    public void m6107w(float f2) {
        MaterialShapeDrawable materialShapeDrawable = this.f11672i;
        if (materialShapeDrawable != null) {
            materialShapeDrawable.setElevation(f2);
        }
    }

    /* JADX INFO: renamed from: b.i.a.g.e.f$a */
    /* JADX INFO: compiled from: FloatingActionButtonImpl.java */
    public class a extends MatrixEvaluator {
        public a() {
        }

        @Override // com.google.android.material.animation.MatrixEvaluator, android.animation.TypeEvaluator
        public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            C4408f.this.f11689z = f;
            return super.evaluate(f, matrix, matrix2);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.android.material.animation.MatrixEvaluator
        public Matrix evaluate(float f, @NonNull Matrix matrix, @NonNull Matrix matrix2) {
            C4408f.this.f11689z = f;
            return super.evaluate(f, matrix, matrix2);
        }
    }
}
