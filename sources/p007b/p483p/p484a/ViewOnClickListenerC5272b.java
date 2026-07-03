package p007b.p483p.p484a;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.Px;
import androidx.annotation.StringRes;
import androidx.annotation.StyleRes;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.tapadoo.alerter.C11198R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Lazy;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p007b.p483p.p484a.ViewOnTouchListenerC5282l;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.p.a.b */
/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class ViewOnClickListenerC5272b extends FrameLayout implements View.OnClickListener, Animation.AnimationListener, ViewOnTouchListenerC5282l.a {

    /* JADX INFO: renamed from: A */
    public Uri f14339A;

    /* JADX INFO: renamed from: B */
    public int f14340B;

    /* JADX INFO: renamed from: C */
    public final Lazy f14341C;

    /* JADX INFO: renamed from: D */
    public final Lazy f14342D;

    /* JADX INFO: renamed from: E */
    public HashMap f14343E;

    /* JADX INFO: renamed from: j */
    public InterfaceC5281k f14344j;

    /* JADX INFO: renamed from: k */
    public InterfaceC5280j f14345k;

    /* JADX INFO: renamed from: l */
    public Animation f14346l;

    /* JADX INFO: renamed from: m */
    public Animation f14347m;

    /* JADX INFO: renamed from: n */
    public long f14348n;

    /* JADX INFO: renamed from: o */
    public boolean f14349o;

    /* JADX INFO: renamed from: p */
    public boolean f14350p;

    /* JADX INFO: renamed from: q */
    public boolean f14351q;

    /* JADX INFO: renamed from: r */
    public boolean f14352r;

    /* JADX INFO: renamed from: s */
    public boolean f14353s;

    /* JADX INFO: renamed from: t */
    public boolean f14354t;

    /* JADX INFO: renamed from: u */
    public Runnable f14355u;

    /* JADX INFO: renamed from: v */
    public boolean f14356v;

    /* JADX INFO: renamed from: w */
    public ArrayList<Button> f14357w;

    /* JADX INFO: renamed from: x */
    public Typeface f14358x;

    /* JADX INFO: renamed from: y */
    public boolean f14359y;

    /* JADX INFO: renamed from: z */
    public boolean f14360z;

    /* JADX INFO: renamed from: b.p.a.b$a */
    /* JADX INFO: compiled from: Alert.kt */
    public static final class a implements Animation.AnimationListener {
        public a() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            C12238m.checkNotNullParameter(animation, "animation");
            ViewOnClickListenerC5272b viewOnClickListenerC5272b = ViewOnClickListenerC5272b.this;
            viewOnClickListenerC5272b.clearAnimation();
            viewOnClickListenerC5272b.setVisibility(8);
            viewOnClickListenerC5272b.postDelayed(new RunnableC5275e(viewOnClickListenerC5272b), 100);
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
            C12238m.checkNotNullParameter(animation, "animation");
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
            C12238m.checkNotNullParameter(animation, "animation");
            ViewOnClickListenerC5272b viewOnClickListenerC5272b = ViewOnClickListenerC5272b.this;
            int i = C11198R.d.llAlertBackground;
            LinearLayout linearLayout = (LinearLayout) viewOnClickListenerC5272b.m7465c(i);
            if (linearLayout != null) {
                linearLayout.setOnClickListener(null);
            }
            LinearLayout linearLayout2 = (LinearLayout) ViewOnClickListenerC5272b.this.m7465c(i);
            if (linearLayout2 != null) {
                linearLayout2.setClickable(false);
            }
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public ViewOnClickListenerC5272b(Context context, int i, AttributeSet attributeSet, int i2, int i3) {
        int i4 = i3 & 4;
        i2 = (i3 & 8) != 0 ? 0 : i2;
        C12238m.checkNotNullParameter(context, "context");
        super(context, null, i2);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, C11198R.a.alerter_slide_in_from_top);
        C12238m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…lerter_slide_in_from_top)");
        this.f14346l = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, C11198R.a.alerter_slide_out_to_top);
        C12238m.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…alerter_slide_out_to_top)");
        this.f14347m = animationLoadAnimation2;
        this.f14348n = 3000L;
        this.f14349o = true;
        this.f14350p = true;
        this.f14353s = true;
        this.f14354t = true;
        this.f14356v = true;
        this.f14357w = new ArrayList<>();
        this.f14360z = true;
        this.f14340B = 48;
        this.f14341C = C12083g.lazy(new C5273c(this));
        this.f14342D = C12083g.lazy(new C5274d(this));
        FrameLayout.inflate(context, C11198R.e.alerter_alert_view, this);
        int i5 = C11198R.d.vAlertContentContainer;
        ViewStub viewStub = (ViewStub) findViewById(i5);
        C12238m.checkNotNullExpressionValue(viewStub, "vAlertContentContainer");
        viewStub.setLayoutResource(i);
        ((ViewStub) findViewById(i5)).inflate();
        setHapticFeedbackEnabled(true);
        ViewCompat.setTranslationZ(this, Integer.MAX_VALUE);
        ((LinearLayout) m7465c(C11198R.d.llAlertBackground)).setOnClickListener(this);
    }

    private final int getNavigationBarHeight() {
        return ((Number) this.f14342D.getValue()).intValue();
    }

    @Override // p007b.p483p.p484a.ViewOnTouchListenerC5282l.a
    /* JADX INFO: renamed from: a */
    public void mo7463a(View view, boolean z2) {
        C12238m.checkNotNullParameter(view, "view");
        if (z2) {
            removeCallbacks(this.f14355u);
        } else {
            if (this.f14351q) {
                return;
            }
            RunnableC5276f runnableC5276f = new RunnableC5276f(this);
            this.f14355u = runnableC5276f;
            postDelayed(runnableC5276f, this.f14348n);
        }
    }

    @Override // p007b.p483p.p484a.ViewOnTouchListenerC5282l.a
    /* JADX INFO: renamed from: b */
    public boolean mo7464b() {
        return this.f14356v;
    }

    /* JADX INFO: renamed from: c */
    public View m7465c(int i) {
        if (this.f14343E == null) {
            this.f14343E = new HashMap();
        }
        View view = (View) this.f14343E.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.f14343E.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    /* JADX INFO: renamed from: d */
    public final void m7466d() {
        try {
            this.f14347m.setAnimationListener(new a());
            startAnimation(this.f14347m);
        } catch (Exception e) {
            Log.e(ViewOnClickListenerC5272b.class.getSimpleName(), Log.getStackTraceString(e));
        }
    }

    public final Typeface getButtonTypeFace() {
        return this.f14358x;
    }

    public final int getContentGravity() {
        LinearLayout linearLayout = (LinearLayout) m7465c(C11198R.d.llAlertBackground);
        ViewGroup.LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        return ((FrameLayout.LayoutParams) layoutParams).gravity;
    }

    public final long getDuration$alerter_release() {
        return this.f14348n;
    }

    public final Animation getEnterAnimation$alerter_release() {
        return this.f14346l;
    }

    public final Animation getExitAnimation$alerter_release() {
        return this.f14347m;
    }

    public final View getLayoutContainer() {
        return (View) this.f14341C.getValue();
    }

    public final int getLayoutGravity() {
        return this.f14340B;
    }

    public final InterfaceC5280j getOnHideListener$alerter_release() {
        return this.f14345k;
    }

    public final TextView getText() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvText);
        C12238m.checkNotNullExpressionValue(appCompatTextView, "tvText");
        return appCompatTextView;
    }

    public final TextView getTitle() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvTitle);
        C12238m.checkNotNullExpressionValue(appCompatTextView, "tvTitle");
        return appCompatTextView;
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationEnd(Animation animation) {
        C12238m.checkNotNullParameter(animation, "animation");
        InterfaceC5281k interfaceC5281k = this.f14344j;
        if (interfaceC5281k != null) {
            interfaceC5281k.m7467a();
        }
        if (this.f14351q) {
            return;
        }
        RunnableC5276f runnableC5276f = new RunnableC5276f(this);
        this.f14355u = runnableC5276f;
        postDelayed(runnableC5276f, this.f14348n);
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationRepeat(Animation animation) {
        C12238m.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation.AnimationListener
    public void onAnimationStart(Animation animation) {
        AppCompatImageView appCompatImageView;
        C12238m.checkNotNullParameter(animation, "animation");
        if (isInEditMode()) {
            return;
        }
        setVisibility(0);
        if (this.f14360z) {
            performHapticFeedback(1);
        }
        if (this.f14339A != null) {
            RingtoneManager.getRingtone(getContext(), this.f14339A).play();
        }
        if (this.f14352r) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) m7465c(C11198R.d.ivIcon);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(4);
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) m7465c(C11198R.d.ivRightIcon);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setVisibility(4);
            }
            ProgressBar progressBar = (ProgressBar) m7465c(C11198R.d.pbProgress);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        if (this.f14349o) {
            int i = C11198R.d.ivIcon;
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) m7465c(i);
            if (appCompatImageView4 != null) {
                appCompatImageView4.setVisibility(0);
            }
            if (this.f14350p && (appCompatImageView = (AppCompatImageView) m7465c(i)) != null) {
                appCompatImageView.startAnimation(AnimationUtils.loadAnimation(getContext(), C11198R.a.alerter_pulse));
            }
        } else {
            FrameLayout frameLayout = (FrameLayout) m7465c(C11198R.d.flIconContainer);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        FrameLayout frameLayout2 = (FrameLayout) m7465c(C11198R.d.flRightIconContainer);
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Drawable drawable;
        super.onAttachedToWindow();
        LinearLayout linearLayout = (LinearLayout) m7465c(C11198R.d.llAlertBackground);
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.f14353s) {
                Context context = linearLayout.getContext();
                C12238m.checkNotNullExpressionValue(context, "context");
                C12238m.checkNotNullParameter(context, "$this$getRippleDrawable");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(C11198R.b.selectableItemBackground, typedValue, true);
                drawable = ContextCompat.getDrawable(context, typedValue.resourceId);
            } else {
                drawable = null;
            }
            linearLayout.setForeground(drawable);
        }
        ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int i = this.f14340B;
        ((FrameLayout.LayoutParams) layoutParams).gravity = i;
        if (i != 48) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), C3404f.m4304j0(this, C11198R.c.alerter_padding_default), linearLayout.getPaddingRight(), C3404f.m4304j0(this, C11198R.c.alerter_alert_padding));
        }
        ViewGroup.LayoutParams layoutParams2 = getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams2;
        if (this.f14340B != 48) {
            marginLayoutParams.bottomMargin = getNavigationBarHeight();
        }
        this.f14346l.setAnimationListener(this);
        setAnimation(this.f14346l);
        for (Button button : this.f14357w) {
            Typeface typeface = this.f14358x;
            if (typeface != null) {
                button.setTypeface(typeface);
            }
            ((LinearLayout) m7465c(C11198R.d.llButtonContainer)).addView(button);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        C12238m.checkNotNullParameter(view, "v");
        if (this.f14356v) {
            m7466d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f14346l.setAnimationListener(null);
    }

    @Override // p007b.p483p.p484a.ViewOnTouchListenerC5282l.a
    public void onDismiss(View view) {
        C12238m.checkNotNullParameter(view, "view");
        FrameLayout frameLayout = (FrameLayout) m7465c(C11198R.d.flClickShield);
        if (frameLayout != null) {
            frameLayout.removeView((LinearLayout) m7465c(C11198R.d.llAlertBackground));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        if (!this.f14359y) {
            this.f14359y = true;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams) layoutParams).topMargin = C3404f.m4304j0(this, C11198R.c.alerter_alert_negative_margin_top);
            if (Build.VERSION.SDK_INT >= 28) {
                LinearLayout linearLayout = (LinearLayout) m7465c(C11198R.d.llAlertBackground);
                int paddingLeft = linearLayout.getPaddingLeft();
                int paddingTop = linearLayout.getPaddingTop();
                C12238m.checkNotNullParameter(this, "$this$notchHeight");
                Context context = getContext();
                if (!(context instanceof Activity)) {
                    context = null;
                }
                Activity activity = (Activity) context;
                linearLayout.setPadding(paddingLeft, (((activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null || (rootWindowInsets = decorView.getRootWindowInsets()) == null || (displayCutout = rootWindowInsets.getDisplayCutout()) == null) ? 0 : displayCutout.getSafeInsetTop()) / 2) + paddingTop, linearLayout.getPaddingRight(), linearLayout.getPaddingBottom());
            }
        }
        super.onMeasure(i, i2);
    }

    @Override // android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        C12238m.checkNotNullParameter(motionEvent, "event");
        performClick();
        return super.onTouchEvent(motionEvent);
    }

    public final void setAlertBackgroundColor(@ColorInt int i) {
        ((LinearLayout) m7465c(C11198R.d.llAlertBackground)).setBackgroundColor(i);
    }

    public final void setAlertBackgroundDrawable(Drawable drawable) {
        C12238m.checkNotNullParameter(drawable, "drawable");
        ViewCompat.setBackground((LinearLayout) m7465c(C11198R.d.llAlertBackground), drawable);
    }

    public final void setAlertBackgroundResource(@DrawableRes int i) {
        ((LinearLayout) m7465c(C11198R.d.llAlertBackground)).setBackgroundResource(i);
    }

    public final void setButtonTypeFace(Typeface typeface) {
        this.f14358x = typeface;
    }

    public final void setContentGravity(int i) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvTitle);
        ViewGroup.LayoutParams layoutParams = appCompatTextView != null ? appCompatTextView.getLayoutParams() : null;
        if (!(layoutParams instanceof LinearLayout.LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
        if (layoutParams2 != null) {
            layoutParams2.gravity = i;
        }
        int i2 = C11198R.d.tvText;
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) m7465c(i2);
        ViewGroup.LayoutParams layoutParams3 = appCompatTextView2 != null ? appCompatTextView2.getLayoutParams() : null;
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) (layoutParams3 instanceof LinearLayout.LayoutParams ? layoutParams3 : null);
        if (layoutParams4 != null) {
            layoutParams4.gravity = i;
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) m7465c(i2);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setLayoutParams(layoutParams4);
        }
    }

    public final void setDismissible(boolean z2) {
        this.f14356v = z2;
    }

    public final void setDuration$alerter_release(long j) {
        this.f14348n = j;
    }

    public final void setEnableInfiniteDuration(boolean z2) {
        this.f14351q = z2;
    }

    public final void setEnableProgress(boolean z2) {
        this.f14352r = z2;
    }

    public final void setEnterAnimation$alerter_release(Animation animation) {
        C12238m.checkNotNullParameter(animation, "<set-?>");
        this.f14346l = animation;
    }

    public final void setExitAnimation$alerter_release(Animation animation) {
        C12238m.checkNotNullParameter(animation, "<set-?>");
        this.f14347m = animation;
    }

    public final void setIcon(@DrawableRes int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public final void setIconColorFilter(@ColorInt int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(i);
        }
    }

    public final void setIconPixelSize(@Px int i) {
        int i2 = C11198R.d.ivIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(i2);
        C12238m.checkNotNullExpressionValue(appCompatImageView, "ivIcon");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) m7465c(i2);
        C12238m.checkNotNullExpressionValue(appCompatImageView2, "ivIcon");
        ViewGroup.LayoutParams layoutParams = appCompatImageView2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        setMinimumWidth(i);
        setMinimumHeight(i);
        appCompatImageView.setLayoutParams(layoutParams);
    }

    public final void setIconSize(@DimenRes int i) {
        setIconPixelSize(C3404f.m4304j0(this, i));
    }

    public final void setLayoutGravity(int i) {
        if (i != 48) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), C11198R.a.alerter_slide_in_from_bottom);
            C12238m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…ter_slide_in_from_bottom)");
            this.f14346l = animationLoadAnimation;
            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), C11198R.a.alerter_slide_out_to_bottom);
            C12238m.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…rter_slide_out_to_bottom)");
            this.f14347m = animationLoadAnimation2;
        }
        this.f14340B = i;
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        ((LinearLayout) m7465c(C11198R.d.llAlertBackground)).setOnClickListener(onClickListener);
    }

    public final void setOnHideListener$alerter_release(InterfaceC5280j interfaceC5280j) {
        this.f14345k = interfaceC5280j;
    }

    public final void setOnShowListener(InterfaceC5281k interfaceC5281k) {
        C12238m.checkNotNullParameter(interfaceC5281k, "listener");
        this.f14344j = interfaceC5281k;
    }

    public final void setProgressColorInt(@ColorInt int i) {
        Drawable progressDrawable;
        ProgressBar progressBar = (ProgressBar) m7465c(C11198R.d.pbProgress);
        if (progressBar == null || (progressDrawable = progressBar.getProgressDrawable()) == null) {
            return;
        }
        progressDrawable.setColorFilter(new LightingColorFilter(ViewCompat.MEASURED_STATE_MASK, i));
    }

    public final void setProgressColorRes(@ColorRes int i) {
        Drawable progressDrawable;
        ProgressBar progressBar = (ProgressBar) m7465c(C11198R.d.pbProgress);
        if (progressBar == null || (progressDrawable = progressBar.getProgressDrawable()) == null) {
            return;
        }
        progressDrawable.setColorFilter(new LightingColorFilter(ViewCompat.MEASURED_STATE_MASK, ContextCompat.getColor(getContext(), i)));
    }

    public final void setRightIcon(@DrawableRes int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public final void setRightIconColorFilter(@ColorInt int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(i);
        }
    }

    public final void setRightIconPixelSize(@Px int i) {
        int i2 = C11198R.d.ivRightIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(i2);
        C12238m.checkNotNullExpressionValue(appCompatImageView, "ivRightIcon");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) m7465c(i2);
        C12238m.checkNotNullExpressionValue(appCompatImageView2, "ivRightIcon");
        ViewGroup.LayoutParams layoutParams = appCompatImageView2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        setMinimumWidth(i);
        setMinimumHeight(i);
        appCompatImageView.setLayoutParams(layoutParams);
    }

    public final void setRightIconPosition(int i) {
        if (i == 48 || i == 17 || i == 16 || i == 80) {
            int i2 = C11198R.d.flRightIconContainer;
            FrameLayout frameLayout = (FrameLayout) m7465c(i2);
            C12238m.checkNotNullExpressionValue(frameLayout, "flRightIconContainer");
            FrameLayout frameLayout2 = (FrameLayout) m7465c(i2);
            C12238m.checkNotNullExpressionValue(frameLayout2, "flRightIconContainer");
            ViewGroup.LayoutParams layoutParams = frameLayout2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
            layoutParams2.gravity = i;
            frameLayout.setLayoutParams(layoutParams2);
        }
    }

    public final void setRightIconSize(@DimenRes int i) {
        Context context = getContext();
        C12238m.checkNotNullExpressionValue(context, "context");
        setRightIconPixelSize(context.getResources().getDimensionPixelSize(i));
    }

    public final void setSound(Uri uri) {
        this.f14339A = uri;
    }

    public final void setText(@StringRes int i) {
        String string = getContext().getString(i);
        C12238m.checkNotNullExpressionValue(string, "context.getString(textId)");
        setText(string);
    }

    public final void setTextAppearance(@StyleRes int i) {
        if (Build.VERSION.SDK_INT < 23) {
            TextViewCompat.setTextAppearance((AppCompatTextView) m7465c(C11198R.d.tvText), i);
            return;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvText);
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public final void setTextTypeface(Typeface typeface) {
        C12238m.checkNotNullParameter(typeface, "typeface");
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvText);
        if (appCompatTextView != null) {
            appCompatTextView.setTypeface(typeface);
        }
    }

    public final void setTitle(@StringRes int i) {
        String string = getContext().getString(i);
        C12238m.checkNotNullExpressionValue(string, "context.getString(titleId)");
        setTitle(string);
    }

    public final void setTitleAppearance(@StyleRes int i) {
        if (Build.VERSION.SDK_INT < 23) {
            TextViewCompat.setTextAppearance((AppCompatTextView) m7465c(C11198R.d.tvTitle), i);
            return;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvTitle);
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public final void setTitleTypeface(Typeface typeface) {
        C12238m.checkNotNullParameter(typeface, "typeface");
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(C11198R.d.tvTitle);
        if (appCompatTextView != null) {
            appCompatTextView.setTypeface(typeface);
        }
    }

    public final void setVibrationEnabled(boolean z2) {
        this.f14360z = z2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            C12238m.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            childAt.setVisibility(i);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        C12238m.checkNotNullParameter(bitmap, "bitmap");
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageBitmap(bitmap);
        }
    }

    public final void setIconColorFilter(ColorFilter colorFilter) {
        C12238m.checkNotNullParameter(colorFilter, "colorFilter");
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(colorFilter);
        }
    }

    public final void setRightIcon(Bitmap bitmap) {
        C12238m.checkNotNullParameter(bitmap, "bitmap");
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageBitmap(bitmap);
        }
    }

    public final void setRightIconColorFilter(ColorFilter colorFilter) {
        C12238m.checkNotNullParameter(colorFilter, "colorFilter");
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(colorFilter);
        }
    }

    public final void setText(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, NotificationCompat.MessagingStyle.Message.KEY_TEXT);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        int i = C11198R.d.tvText;
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(i);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(0);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) m7465c(i);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(charSequence);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        C12238m.checkNotNullParameter(charSequence, "title");
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        int i = C11198R.d.tvTitle;
        AppCompatTextView appCompatTextView = (AppCompatTextView) m7465c(i);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(0);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) m7465c(i);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(charSequence);
        }
    }

    public final void setIcon(Drawable drawable) {
        C12238m.checkNotNullParameter(drawable, "drawable");
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(drawable);
        }
    }

    public final void setRightIcon(Drawable drawable) {
        C12238m.checkNotNullParameter(drawable, "drawable");
        AppCompatImageView appCompatImageView = (AppCompatImageView) m7465c(C11198R.d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(drawable);
        }
    }
}
