package b.a.n.h;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.n.TrashEventListener;
import b.a.n.g.TrashWrapBinding;
import com.discord.overlay.R;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.Intrinsics3;
import kotlin.reflect.KProperty;

/* JADX INFO: renamed from: b.a.n.h.a, reason: use source file name */
/* JADX INFO: compiled from: OverlayTrashWrap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class OverlayTrashWrap extends FrameLayout implements TrashEventListener {
    public final TrashWrapBinding j;
    public WindowManager.LayoutParams k;
    public final Animator l;
    public final Animator m;
    public final Rect n;
    public final int[] o;
    public OverlayBubbleWrap p;

    /* JADX INFO: renamed from: b.a.n.h.a$a */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
            OverlayTrashWrap.this.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: b.a.n.h.a$b */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
            OverlayTrashWrap.this.setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Intrinsics3.checkNotNullParameter(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OverlayTrashWrap(Context context) {
        super(context);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R.e.trash_wrap, this);
        int i = R.d.trash_wrap_icon;
        ImageView imageView = (ImageView) findViewById(i);
        if (imageView != null) {
            i = R.d.trash_wrap_target_container;
            FrameLayout frameLayout = (FrameLayout) findViewById(i);
            if (frameLayout != null) {
                i = R.d.trash_wrap_target_zone;
                FrameLayout frameLayout2 = (FrameLayout) findViewById(i);
                if (frameLayout2 != null) {
                    TrashWrapBinding trashWrapBinding = new TrashWrapBinding(this, imageView, frameLayout, frameLayout2);
                    Intrinsics3.checkNotNullExpressionValue(trashWrapBinding, "TrashWrapBinding.inflate…ater.from(context), this)");
                    this.j = trashWrapBinding;
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT <= 25 ? 2007 : 2038, 16777768, -3);
                    layoutParams.width = -1;
                    layoutParams.gravity = 81;
                    Intrinsics3.checkNotNullParameter(layoutParams, "$this$addFlag");
                    layoutParams.flags = 16 | layoutParams.flags;
                    this.k = layoutParams;
                    setBackgroundResource(R.c.trash_bg);
                    setVisibility(4);
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), R.a.fade_in);
                    animatorLoadAnimator.setTarget(this);
                    Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), R.a.slide_in_bottom);
                    animatorLoadAnimator2.setTarget(frameLayout2);
                    animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
                    animatorSet.addListener(new a());
                    this.l = animatorSet;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    Animator animatorLoadAnimator3 = AnimatorInflater.loadAnimator(getContext(), R.a.fade_out);
                    animatorLoadAnimator3.setTarget(this);
                    Animator animatorLoadAnimator4 = AnimatorInflater.loadAnimator(getContext(), R.a.slide_out_bottom);
                    animatorLoadAnimator4.setTarget(frameLayout2);
                    animatorSet2.playTogether(animatorLoadAnimator3, animatorLoadAnimator4);
                    animatorSet2.addListener(new b());
                    this.m = animatorSet2;
                    this.n = new Rect();
                    this.o = new int[]{0, 0};
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // b.a.n.TrashEventListener
    public void a(OverlayBubbleWrap overlayBubbleWrap) {
        if (overlayBubbleWrap != null) {
            FrameLayout frameLayout = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetContainer");
            frameLayout.setActivated(true);
            int iMax = Math.max(overlayBubbleWrap.getWidth(), overlayBubbleWrap.getHeight());
            FrameLayout frameLayout2 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetContainer");
            float fMax = Math.max(iMax, frameLayout2.getWidth());
            FrameLayout frameLayout3 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout3, "binding.trashWrapTargetContainer");
            float width = (fMax / frameLayout3.getWidth()) + 0.5f;
            FrameLayout frameLayout4 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout4, "binding.trashWrapTargetContainer");
            float scaleX = frameLayout4.getScaleX();
            FrameLayout frameLayout5 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout5, "binding.trashWrapTargetContainer");
            float scaleY = frameLayout5.getScaleY();
            FrameLayout frameLayout6 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout6, "binding.trashWrapTargetContainer");
            float pivotX = frameLayout6.getPivotX();
            FrameLayout frameLayout7 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout7, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation = new ScaleAnimation(scaleX, width, scaleY, width, pivotX, frameLayout7.getPivotY());
            scaleAnimation.setDuration(200L);
            scaleAnimation.setInterpolator(getContext(), android.R.interpolator.overshoot);
            scaleAnimation.setFillAfter(true);
            this.j.c.startAnimation(scaleAnimation);
        } else {
            FrameLayout frameLayout8 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout8, "binding.trashWrapTargetContainer");
            frameLayout8.setActivated(false);
            setActivated(false);
            FrameLayout frameLayout9 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout9, "binding.trashWrapTargetContainer");
            float scaleX2 = frameLayout9.getScaleX();
            FrameLayout frameLayout10 = this.j.c;
            Intrinsics3.checkNotNullExpressionValue(frameLayout10, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(scaleX2, 1.0f, frameLayout10.getScaleY(), 1.0f);
            scaleAnimation2.setDuration(200L);
            scaleAnimation2.setInterpolator(getContext(), android.R.interpolator.anticipate);
            scaleAnimation2.setFillAfter(true);
            this.j.c.startAnimation(scaleAnimation2);
        }
        if (!Intrinsics3.areEqual(overlayBubbleWrap, this.p)) {
            if (overlayBubbleWrap != null) {
                ImageView imageView = this.j.f250b;
                Intrinsics3.checkNotNullExpressionValue(imageView, "binding.trashWrapIcon");
                overlayBubbleWrap.b(imageView);
            }
            performHapticFeedback(Build.VERSION.SDK_INT >= 23 ? 6 : 0);
            OverlayBubbleWrap overlayBubbleWrap2 = this.p;
            if (overlayBubbleWrap2 != null) {
                KProperty[] kPropertyArr = OverlayBubbleWrap.j;
                overlayBubbleWrap2.a(false);
            }
            this.p = overlayBubbleWrap;
        }
    }

    @Override // b.a.n.TrashEventListener
    public void b(OverlayBubbleWrap overlayBubbleWrap) {
        Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
        Intrinsics3.checkNotNullParameter(overlayBubbleWrap, "bubble");
    }

    public final WindowManager.LayoutParams getWindowLayoutParams() {
        return this.k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2) {
            this.j.d.getLocationOnScreen(this.o);
            int[] iArr = this.o;
            int i5 = iArr[0];
            int i6 = iArr[1];
            Rect rect = this.n;
            FrameLayout frameLayout = this.j.d;
            Intrinsics3.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetZone");
            int width = frameLayout.getWidth() + i5;
            FrameLayout frameLayout2 = this.j.d;
            Intrinsics3.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetZone");
            rect.set(i5, i6, width, frameLayout2.getHeight() + i6);
        }
    }

    public final void setWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
        Intrinsics3.checkNotNullParameter(layoutParams, "<set-?>");
        this.k = layoutParams;
    }
}
