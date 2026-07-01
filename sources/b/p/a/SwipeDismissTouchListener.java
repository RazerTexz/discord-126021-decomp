package b.p.a;

import android.R;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import androidx.annotation.RequiresApi;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: b.p.a.l, reason: use source file name */
/* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SwipeDismissTouchListener implements View.OnTouchListener {
    public final int j;
    public final int k;
    public final long l;
    public int m;
    public float n;
    public float o;
    public boolean p;
    public int q;
    public VelocityTracker r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public float f1974s;
    public final View t;
    public final a u;

    /* JADX INFO: renamed from: b.p.a.l$a */
    /* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
    public interface a {
        void a(View view, boolean z2);

        boolean b();

        void onDismiss(View view);
    }

    /* JADX INFO: renamed from: b.p.a.l$b */
    /* JADX INFO: compiled from: SwipeDismissTouchListener.kt */
    public static final class b extends AnimatorListenerAdapter {
        public b(MotionEvent motionEvent, View view) {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animation");
            SwipeDismissTouchListener swipeDismissTouchListener = SwipeDismissTouchListener.this;
            ViewGroup.LayoutParams layoutParams = swipeDismissTouchListener.t.getLayoutParams();
            int height = swipeDismissTouchListener.t.getHeight();
            ValueAnimator duration = ValueAnimator.ofInt(height, 1).setDuration(swipeDismissTouchListener.l);
            duration.addListener(new SwipeDismissTouchListener2(swipeDismissTouchListener, layoutParams, height));
            duration.addUpdateListener(new SwipeDismissTouchListener3(swipeDismissTouchListener, layoutParams));
            duration.start();
        }
    }

    public SwipeDismissTouchListener(View view, a aVar) {
        Intrinsics3.checkNotNullParameter(view, "mView");
        Intrinsics3.checkNotNullParameter(aVar, "mCallbacks");
        this.t = view;
        this.u = aVar;
        this.m = 1;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Intrinsics3.checkNotNullExpressionValue(viewConfiguration, "vc");
        this.j = viewConfiguration.getScaledTouchSlop();
        this.k = viewConfiguration.getScaledMinimumFlingVelocity() * 16;
        Context context = view.getContext();
        Intrinsics3.checkNotNullExpressionValue(context, "mView.context");
        this.l = context.getResources().getInteger(R.integer.config_shortAnimTime);
    }

    @Override // android.view.View.OnTouchListener
    @RequiresApi(api = 12)
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z2;
        Intrinsics3.checkNotNullParameter(view, "view");
        Intrinsics3.checkNotNullParameter(motionEvent, "motionEvent");
        motionEvent.offsetLocation(this.f1974s, 0.0f);
        if (this.m < 2) {
            this.m = this.t.getWidth();
        }
        int actionMasked = motionEvent.getActionMasked();
        boolean z3 = true;
        if (actionMasked == 0) {
            this.n = motionEvent.getRawX();
            this.o = motionEvent.getRawY();
            if (this.u.b()) {
                VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
                this.r = velocityTrackerObtain;
                Intrinsics3.checkNotNull(velocityTrackerObtain);
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.u.a(view, true);
            return false;
        }
        if (actionMasked == 1) {
            VelocityTracker velocityTracker = this.r;
            if (velocityTracker != null) {
                float rawX = motionEvent.getRawX() - this.n;
                velocityTracker.addMovement(motionEvent);
                velocityTracker.computeCurrentVelocity(1000);
                float xVelocity = velocityTracker.getXVelocity();
                float fAbs = Math.abs(xVelocity);
                float fAbs2 = Math.abs(velocityTracker.getYVelocity());
                if (Math.abs(rawX) > this.m / 2 && this.p) {
                    z2 = rawX > ((float) 0);
                } else if (this.k > fAbs || fAbs2 >= fAbs || !this.p) {
                    z2 = false;
                    z3 = false;
                } else {
                    float f = 0;
                    boolean z4 = ((xVelocity > f ? 1 : (xVelocity == f ? 0 : -1)) < 0) == ((rawX > f ? 1 : (rawX == f ? 0 : -1)) < 0);
                    z2 = velocityTracker.getXVelocity() > f;
                    z3 = z4;
                }
                if (z3) {
                    this.t.animate().translationX(z2 ? this.m : -this.m).alpha(0.0f).setDuration(this.l).setListener(new b(motionEvent, view));
                } else if (this.p) {
                    this.t.animate().translationX(0.0f).alpha(1.0f).setDuration(this.l).setListener(null);
                    this.u.a(view, false);
                }
                velocityTracker.recycle();
                this.r = null;
                this.f1974s = 0.0f;
                this.n = 0.0f;
                this.o = 0.0f;
                this.p = false;
            }
        } else if (actionMasked == 2) {
            VelocityTracker velocityTracker2 = this.r;
            if (velocityTracker2 != null) {
                velocityTracker2.addMovement(motionEvent);
                float rawX2 = motionEvent.getRawX() - this.n;
                float rawY = motionEvent.getRawY() - this.o;
                if (Math.abs(rawX2) > this.j && Math.abs(rawY) < Math.abs(rawX2) / 2) {
                    this.p = true;
                    this.q = rawX2 > ((float) 0) ? this.j : -this.j;
                    this.t.getParent().requestDisallowInterceptTouchEvent(true);
                    MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
                    Intrinsics3.checkNotNullExpressionValue(motionEventObtain, "cancelEvent");
                    motionEventObtain.setAction((motionEvent.getActionIndex() << 8) | 3);
                    this.t.onTouchEvent(motionEventObtain);
                    motionEventObtain.recycle();
                }
                if (this.p) {
                    this.f1974s = rawX2;
                    this.t.setTranslationX(rawX2 - this.q);
                    this.t.setAlpha(Math.max(0.0f, Math.min(1.0f, 1.0f - ((Math.abs(rawX2) * 2.0f) / this.m))));
                    return true;
                }
            }
        } else {
            if (actionMasked != 3) {
                view.performClick();
                return false;
            }
            VelocityTracker velocityTracker3 = this.r;
            if (velocityTracker3 != null) {
                this.t.animate().translationX(0.0f).alpha(1.0f).setDuration(this.l).setListener(null);
                velocityTracker3.recycle();
                this.r = null;
                this.f1974s = 0.0f;
                this.n = 0.0f;
                this.o = 0.0f;
                this.p = false;
            }
        }
        return false;
    }
}
