package b.a.n.h;

import android.R$interpolator;
import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build$VERSION;
import android.view.LayoutInflater;
import android.view.WindowManager$LayoutParams;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import b.a.n.f;
import com.discord.overlay.R$a;
import com.discord.overlay.R$c;
import com.discord.overlay.R$d;
import com.discord.overlay.R$e;
import com.discord.overlay.views.OverlayBubbleWrap;
import d0.z.d.m;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: OverlayTrashWrap.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a extends FrameLayout implements f {
    public final b.a.n.g.a j;
    public WindowManager$LayoutParams k;
    public final Animator l;
    public final Animator m;
    public final Rect n;
    public final int[] o;
    public OverlayBubbleWrap p;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context) {
        super(context);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$e.trash_wrap, this);
        int i = R$d.trash_wrap_icon;
        ImageView imageView = (ImageView) findViewById(i);
        if (imageView != null) {
            i = R$d.trash_wrap_target_container;
            FrameLayout frameLayout = (FrameLayout) findViewById(i);
            if (frameLayout != null) {
                i = R$d.trash_wrap_target_zone;
                FrameLayout frameLayout2 = (FrameLayout) findViewById(i);
                if (frameLayout2 != null) {
                    b.a.n.g.a aVar = new b.a.n.g.a(this, imageView, frameLayout, frameLayout2);
                    m.checkNotNullExpressionValue(aVar, "TrashWrapBinding.inflate…ater.from(context), this)");
                    this.j = aVar;
                    WindowManager$LayoutParams windowManager$LayoutParams = new WindowManager$LayoutParams(-2, -2, Build$VERSION.SDK_INT <= 25 ? 2007 : 2038, 16777768, -3);
                    windowManager$LayoutParams.width = -1;
                    windowManager$LayoutParams.gravity = 81;
                    m.checkNotNullParameter(windowManager$LayoutParams, "$this$addFlag");
                    windowManager$LayoutParams.flags = 16 | windowManager$LayoutParams.flags;
                    this.k = windowManager$LayoutParams;
                    setBackgroundResource(R$c.trash_bg);
                    setVisibility(4);
                    AnimatorSet animatorSet = new AnimatorSet();
                    Animator animatorLoadAnimator = AnimatorInflater.loadAnimator(getContext(), R$a.fade_in);
                    animatorLoadAnimator.setTarget(this);
                    Animator animatorLoadAnimator2 = AnimatorInflater.loadAnimator(getContext(), R$a.slide_in_bottom);
                    animatorLoadAnimator2.setTarget(frameLayout2);
                    animatorSet.playTogether(animatorLoadAnimator, animatorLoadAnimator2);
                    animatorSet.addListener(new a$a(this));
                    this.l = animatorSet;
                    AnimatorSet animatorSet2 = new AnimatorSet();
                    Animator animatorLoadAnimator3 = AnimatorInflater.loadAnimator(getContext(), R$a.fade_out);
                    animatorLoadAnimator3.setTarget(this);
                    Animator animatorLoadAnimator4 = AnimatorInflater.loadAnimator(getContext(), R$a.slide_out_bottom);
                    animatorLoadAnimator4.setTarget(frameLayout2);
                    animatorSet2.playTogether(animatorLoadAnimator3, animatorLoadAnimator4);
                    animatorSet2.addListener(new a$b(this));
                    this.m = animatorSet2;
                    this.n = new Rect();
                    this.o = new int[]{0, 0};
                    return;
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(i)));
    }

    @Override // b.a.n.f
    public void a(OverlayBubbleWrap overlayBubbleWrap) {
        if (overlayBubbleWrap != null) {
            FrameLayout frameLayout = this.j.c;
            m.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetContainer");
            frameLayout.setActivated(true);
            int iMax = Math.max(overlayBubbleWrap.getWidth(), overlayBubbleWrap.getHeight());
            FrameLayout frameLayout2 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetContainer");
            float fMax = Math.max(iMax, frameLayout2.getWidth());
            FrameLayout frameLayout3 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout3, "binding.trashWrapTargetContainer");
            float width = (fMax / frameLayout3.getWidth()) + 0.5f;
            FrameLayout frameLayout4 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout4, "binding.trashWrapTargetContainer");
            float scaleX = frameLayout4.getScaleX();
            FrameLayout frameLayout5 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout5, "binding.trashWrapTargetContainer");
            float scaleY = frameLayout5.getScaleY();
            FrameLayout frameLayout6 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout6, "binding.trashWrapTargetContainer");
            float pivotX = frameLayout6.getPivotX();
            FrameLayout frameLayout7 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout7, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation = new ScaleAnimation(scaleX, width, scaleY, width, pivotX, frameLayout7.getPivotY());
            scaleAnimation.setDuration(200L);
            scaleAnimation.setInterpolator(getContext(), R$interpolator.overshoot);
            scaleAnimation.setFillAfter(true);
            this.j.c.startAnimation(scaleAnimation);
        } else {
            FrameLayout frameLayout8 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout8, "binding.trashWrapTargetContainer");
            frameLayout8.setActivated(false);
            setActivated(false);
            FrameLayout frameLayout9 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout9, "binding.trashWrapTargetContainer");
            float scaleX2 = frameLayout9.getScaleX();
            FrameLayout frameLayout10 = this.j.c;
            m.checkNotNullExpressionValue(frameLayout10, "binding.trashWrapTargetContainer");
            ScaleAnimation scaleAnimation2 = new ScaleAnimation(scaleX2, 1.0f, frameLayout10.getScaleY(), 1.0f);
            scaleAnimation2.setDuration(200L);
            scaleAnimation2.setInterpolator(getContext(), R$interpolator.anticipate);
            scaleAnimation2.setFillAfter(true);
            this.j.c.startAnimation(scaleAnimation2);
        }
        if (!m.areEqual(overlayBubbleWrap, this.p)) {
            if (overlayBubbleWrap != null) {
                ImageView imageView = this.j.f250b;
                m.checkNotNullExpressionValue(imageView, "binding.trashWrapIcon");
                overlayBubbleWrap.b(imageView);
            }
            performHapticFeedback(Build$VERSION.SDK_INT >= 23 ? 6 : 0);
            OverlayBubbleWrap overlayBubbleWrap2 = this.p;
            if (overlayBubbleWrap2 != null) {
                KProperty[] kPropertyArr = OverlayBubbleWrap.j;
                overlayBubbleWrap2.a(false);
            }
            this.p = overlayBubbleWrap;
        }
    }

    @Override // b.a.n.f
    public void b(OverlayBubbleWrap overlayBubbleWrap) {
        m.checkNotNullParameter(overlayBubbleWrap, "bubble");
        m.checkNotNullParameter(overlayBubbleWrap, "bubble");
    }

    public final WindowManager$LayoutParams getWindowLayoutParams() {
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
            m.checkNotNullExpressionValue(frameLayout, "binding.trashWrapTargetZone");
            int width = frameLayout.getWidth() + i5;
            FrameLayout frameLayout2 = this.j.d;
            m.checkNotNullExpressionValue(frameLayout2, "binding.trashWrapTargetZone");
            rect.set(i5, i6, width, frameLayout2.getHeight() + i6);
        }
    }

    public final void setWindowLayoutParams(WindowManager$LayoutParams windowManager$LayoutParams) {
        m.checkNotNullParameter(windowManager$LayoutParams, "<set-?>");
        this.k = windowManager$LayoutParams;
    }
}
