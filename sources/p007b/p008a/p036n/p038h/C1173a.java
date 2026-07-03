package p007b.p008a.p036n.p038h;

import android.R;
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
import com.discord.overlay.C5570R;
import com.discord.overlay.views.OverlayBubbleWrap;
import kotlin.reflect.KProperty;
import p007b.p008a.p036n.InterfaceC1171f;
import p007b.p008a.p036n.p037g.C1172a;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.n.h.a */
/* JADX INFO: compiled from: OverlayTrashWrap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C1173a extends FrameLayout implements InterfaceC1171f {

    /* JADX INFO: renamed from: j */
    public final C1172a f1561j;

    /* JADX INFO: renamed from: k */
    public WindowManager.LayoutParams f1562k;

    /* JADX INFO: renamed from: l */
    public final Animator f1563l;

    /* JADX INFO: renamed from: m */
    public final Animator f1564m;

    /* JADX INFO: renamed from: n */
    public final Rect f1565n;

    /* JADX INFO: renamed from: o */
    public final int[] f1566o;

    /* JADX INFO: renamed from: p */
    public OverlayBubbleWrap f1567p;

    /* JADX INFO: renamed from: b.a.n.h.a$a */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
            C1173a.this.setVisibility(0);
        }
    }

    /* JADX INFO: renamed from: b.a.n.h.a$b */
    /* JADX INFO: compiled from: Animator.kt */
    public static final class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
            C1173a.this.setVisibility(4);
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            C12238m.checkNotNullParameter(animator, "animator");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1173a(Context context) {
        super(context);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5570R.e.trash_wrap, this);
        int i = C5570R.d.trash_wrap_icon;
        ImageView imageView = (ImageView) findViewById(i);
        if (imageView != null) {
            i = C5570R.d.trash_wrap_target_container;
            FrameLayout frameLayout = (FrameLayout) findViewById(i);
            if (frameLayout != null) {
                i = C5570R.d.trash_wrap_target_zone;
                FrameLayout frameLayout2 = (FrameLayout) findViewById(i);
                if (frameLayout2 != null) {
                    C1172a c1172a = new C1172a(this, imageView, frameLayout, frameLayout2);
                    C12238m.checkNotNullExpressionValue(c1172a, "TrashWrapBinding.inflate…ater.from(context), this)");
                    this.f1561j = c1172a;
                    WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams(-2, -2, Build.VERSION.SDK_INT <= 25 ? 2007 : 2038, 16777768, -3);
                    layoutParams.width = -1;
                    layoutParams.gravity = 81;
                    C12238m.checkNotNullParameter(layoutParams, "$this$addFlag");
                    layoutParams.flags = 16 | layoutParams.flags;
                    this.f1562k = layoutParams;
                    setBackgroundResource(C5570R.c.trash_bg);
                    setVisibility(4);
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), C5570R.a.fade_in);
                    animatorLoadAnimator.setTarget(this);
                    Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), C5570R.a.slide_in_bottom);
                    animatorLoadAnimator2.setTarget(frameLayout2);
                    animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
                    animatorSet.addListener(new a());
                    this.f1563l = animatorSet;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    Animator animatorLoadAnimator3 = AnimatorInflater.loadAnimator(getContext(), C5570R.a.fade_out);
                    animatorLoadAnimator3.setTarget(this);
                    Animator animatorLoadAnimator4 = AnimatorInflater.loadAnimator(getContext(), C5570R.a.slide_out_bottom);
                    animatorLoadAnimator4.setTarget(frameLayout2);
                    animatorSet2.playTogether(animatorLoadAnimator3, animatorLoadAnimator4);
                    animatorSet2.addListener(new b());
                    this.f1564m = animatorSet2;
                    this.f1565n = new Rect();
                    this.f1566o = new int[]{0, 0};
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // p007b.p008a.p036n.InterfaceC1171f
    /* JADX INFO: renamed from: a */
    public void mo227a(OverlayBubbleWrap overlayBubbleWrap) {
        if (overlayBubbleWrap != null) {
            FrameLayout frameLayout = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetContainer");
            frameLayout.setActivated(true);
            int iMax = Math.max(overlayBubbleWrap.getWidth(), overlayBubbleWrap.getHeight());
            FrameLayout frameLayout2 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetContainer");
            float fMax = Math.max(iMax, frameLayout2.getWidth());
            FrameLayout frameLayout3 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout3, "binding.trashWrapTargetContainer");
            float width = (fMax / frameLayout3.getWidth()) + 0.5f;
            FrameLayout frameLayout4 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout4, "binding.trashWrapTargetContainer");
            float scaleX = frameLayout4.getScaleX();
            FrameLayout frameLayout5 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout5, "binding.trashWrapTargetContainer");
            float scaleY = frameLayout5.getScaleY();
            FrameLayout frameLayout6 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout6, "binding.trashWrapTargetContainer");
            float pivotX = frameLayout6.getPivotX();
            FrameLayout frameLayout7 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout7, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation = new ScaleAnimation(scaleX, width, scaleY, width, pivotX, frameLayout7.getPivotY());
            scaleAnimation.setDuration(200L);
            scaleAnimation.setInterpolator(getContext(), R.interpolator.overshoot);
            scaleAnimation.setFillAfter(true);
            this.f1561j.f1559c.startAnimation(scaleAnimation);
        } else {
            FrameLayout frameLayout8 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout8, "binding.trashWrapTargetContainer");
            frameLayout8.setActivated(false);
            setActivated(false);
            FrameLayout frameLayout9 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout9, "binding.trashWrapTargetContainer");
            float scaleX2 = frameLayout9.getScaleX();
            FrameLayout frameLayout10 = this.f1561j.f1559c;
            C12238m.checkNotNullExpressionValue(frameLayout10, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(scaleX2, 1.0f, frameLayout10.getScaleY(), 1.0f);
            scaleAnimation2.setDuration(200L);
            scaleAnimation2.setInterpolator(getContext(), R.interpolator.anticipate);
            scaleAnimation2.setFillAfter(true);
            this.f1561j.f1559c.startAnimation(scaleAnimation2);
        }
        if (!C12238m.areEqual(overlayBubbleWrap, this.f1567p)) {
            if (overlayBubbleWrap != null) {
                ImageView imageView = this.f1561j.f1558b;
                C12238m.checkNotNullExpressionValue(imageView, "binding.trashWrapIcon");
                overlayBubbleWrap.mo390b(imageView);
            }
            performHapticFeedback(Build.VERSION.SDK_INT >= 23 ? 6 : 0);
            OverlayBubbleWrap overlayBubbleWrap2 = this.f1567p;
            if (overlayBubbleWrap2 != null) {
                KProperty[] kPropertyArr = OverlayBubbleWrap.f18620j;
                overlayBubbleWrap2.mo389a(false);
            }
            this.f1567p = overlayBubbleWrap;
        }
    }

    @Override // p007b.p008a.p036n.InterfaceC1171f
    /* JADX INFO: renamed from: b */
    public void mo228b(OverlayBubbleWrap overlayBubbleWrap) {
        C12238m.checkNotNullParameter(overlayBubbleWrap, "bubble");
        C12238m.checkNotNullParameter(overlayBubbleWrap, "bubble");
    }

    public final WindowManager.LayoutParams getWindowLayoutParams() {
        return this.f1562k;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z2, int i, int i2, int i3, int i4) {
        super.onLayout(z2, i, i2, i3, i4);
        if (z2) {
            this.f1561j.f1560d.getLocationOnScreen(this.f1566o);
            int[] iArr = this.f1566o;
            int i5 = iArr[0];
            int i6 = iArr[1];
            Rect rect = this.f1565n;
            FrameLayout frameLayout = this.f1561j.f1560d;
            C12238m.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetZone");
            int width = frameLayout.getWidth() + i5;
            FrameLayout frameLayout2 = this.f1561j.f1560d;
            C12238m.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetZone");
            rect.set(i5, i6, width, frameLayout2.getHeight() + i6);
        }
    }

    public final void setWindowLayoutParams(WindowManager.LayoutParams layoutParams) {
        C12238m.checkNotNullParameter(layoutParams, "<set-?>");
        this.f1562k = layoutParams;
    }
}
