package b.p.a;

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
import android.os.Build$VERSION;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.DisplayCutout;
import android.view.MotionEvent;
import android.view.View;
import android.view.View$OnClickListener;
import android.view.ViewGroup$LayoutParams;
import android.view.ViewGroup$MarginLayoutParams;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.animation.Animation;
import android.view.animation.Animation$AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout$LayoutParams;
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
import androidx.core.app.NotificationCompat$MessagingStyle$Message;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.TextViewCompat;
import com.tapadoo.alerter.R$a;
import com.tapadoo.alerter.R$b;
import com.tapadoo.alerter.R$c;
import com.tapadoo.alerter.R$d;
import com.tapadoo.alerter.R$e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import kotlin.Lazy;

/* JADX INFO: compiled from: Alert.kt */
/* JADX INFO: loaded from: classes3.dex */
@SuppressLint({"ViewConstructor"})
public final class b extends FrameLayout implements View$OnClickListener, Animation$AnimationListener, l$a {
    public Uri A;
    public int B;
    public final Lazy C;
    public final Lazy D;
    public HashMap E;
    public k j;
    public j k;
    public Animation l;
    public Animation m;
    public long n;
    public boolean o;
    public boolean p;
    public boolean q;
    public boolean r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1969s;
    public boolean t;
    public Runnable u;
    public boolean v;
    public ArrayList<Button> w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Typeface f1970x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f1971y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f1972z;

    /* JADX WARN: Illegal instructions before constructor call */
    public b(Context context, int i, AttributeSet attributeSet, int i2, int i3) {
        int i4 = i3 & 4;
        i2 = (i3 & 8) != 0 ? 0 : i2;
        d0.z.d.m.checkNotNullParameter(context, "context");
        super(context, null, i2);
        Animation animationLoadAnimation = AnimationUtils.loadAnimation(context, R$a.alerter_slide_in_from_top);
        d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…lerter_slide_in_from_top)");
        this.l = animationLoadAnimation;
        Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(context, R$a.alerter_slide_out_to_top);
        d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…alerter_slide_out_to_top)");
        this.m = animationLoadAnimation2;
        this.n = 3000L;
        this.o = true;
        this.p = true;
        this.f1969s = true;
        this.t = true;
        this.v = true;
        this.w = new ArrayList<>();
        this.f1972z = true;
        this.B = 48;
        this.C = d0.g.lazy(new c(this));
        this.D = d0.g.lazy(new d(this));
        FrameLayout.inflate(context, R$e.alerter_alert_view, this);
        int i5 = R$d.vAlertContentContainer;
        ViewStub viewStub = (ViewStub) findViewById(i5);
        d0.z.d.m.checkNotNullExpressionValue(viewStub, "vAlertContentContainer");
        viewStub.setLayoutResource(i);
        ((ViewStub) findViewById(i5)).inflate();
        setHapticFeedbackEnabled(true);
        ViewCompat.setTranslationZ(this, Integer.MAX_VALUE);
        ((LinearLayout) c(R$d.llAlertBackground)).setOnClickListener(this);
    }

    private final int getNavigationBarHeight() {
        return ((Number) this.D.getValue()).intValue();
    }

    @Override // b.p.a.l$a
    public void a(View view, boolean z2) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        if (z2) {
            removeCallbacks(this.u);
        } else {
            if (this.q) {
                return;
            }
            f fVar = new f(this);
            this.u = fVar;
            postDelayed(fVar, this.n);
        }
    }

    @Override // b.p.a.l$a
    public boolean b() {
        return this.v;
    }

    public View c(int i) {
        if (this.E == null) {
            this.E = new HashMap();
        }
        View view = (View) this.E.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View viewFindViewById = findViewById(i);
        this.E.put(Integer.valueOf(i), viewFindViewById);
        return viewFindViewById;
    }

    public final void d() {
        try {
            this.m.setAnimationListener(new b$a(this));
            startAnimation(this.m);
        } catch (Exception e) {
            Log.e(b.class.getSimpleName(), Log.getStackTraceString(e));
        }
    }

    public final Typeface getButtonTypeFace() {
        return this.f1970x;
    }

    public final int getContentGravity() {
        LinearLayout linearLayout = (LinearLayout) c(R$d.llAlertBackground);
        ViewGroup$LayoutParams layoutParams = linearLayout != null ? linearLayout.getLayoutParams() : null;
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        return ((FrameLayout$LayoutParams) layoutParams).gravity;
    }

    public final long getDuration$alerter_release() {
        return this.n;
    }

    public final Animation getEnterAnimation$alerter_release() {
        return this.l;
    }

    public final Animation getExitAnimation$alerter_release() {
        return this.m;
    }

    public final View getLayoutContainer() {
        return (View) this.C.getValue();
    }

    public final int getLayoutGravity() {
        return this.B;
    }

    public final j getOnHideListener$alerter_release() {
        return this.k;
    }

    public final TextView getText() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvText);
        d0.z.d.m.checkNotNullExpressionValue(appCompatTextView, "tvText");
        return appCompatTextView;
    }

    public final TextView getTitle() {
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvTitle);
        d0.z.d.m.checkNotNullExpressionValue(appCompatTextView, "tvTitle");
        return appCompatTextView;
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationEnd(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
        k kVar = this.j;
        if (kVar != null) {
            kVar.a();
        }
        if (this.q) {
            return;
        }
        f fVar = new f(this);
        this.u = fVar;
        postDelayed(fVar, this.n);
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationRepeat(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "animation");
    }

    @Override // android.view.animation.Animation$AnimationListener
    public void onAnimationStart(Animation animation) {
        AppCompatImageView appCompatImageView;
        d0.z.d.m.checkNotNullParameter(animation, "animation");
        if (isInEditMode()) {
            return;
        }
        setVisibility(0);
        if (this.f1972z) {
            performHapticFeedback(1);
        }
        if (this.A != null) {
            RingtoneManager.getRingtone(getContext(), this.A).play();
        }
        if (this.r) {
            AppCompatImageView appCompatImageView2 = (AppCompatImageView) c(R$d.ivIcon);
            if (appCompatImageView2 != null) {
                appCompatImageView2.setVisibility(4);
            }
            AppCompatImageView appCompatImageView3 = (AppCompatImageView) c(R$d.ivRightIcon);
            if (appCompatImageView3 != null) {
                appCompatImageView3.setVisibility(4);
            }
            ProgressBar progressBar = (ProgressBar) c(R$d.pbProgress);
            if (progressBar != null) {
                progressBar.setVisibility(0);
                return;
            }
            return;
        }
        if (this.o) {
            int i = R$d.ivIcon;
            AppCompatImageView appCompatImageView4 = (AppCompatImageView) c(i);
            if (appCompatImageView4 != null) {
                appCompatImageView4.setVisibility(0);
            }
            if (this.p && (appCompatImageView = (AppCompatImageView) c(i)) != null) {
                appCompatImageView.startAnimation(AnimationUtils.loadAnimation(getContext(), R$a.alerter_pulse));
            }
        } else {
            FrameLayout frameLayout = (FrameLayout) c(R$d.flIconContainer);
            if (frameLayout != null) {
                frameLayout.setVisibility(8);
            }
        }
        FrameLayout frameLayout2 = (FrameLayout) c(R$d.flRightIconContainer);
        if (frameLayout2 != null) {
            frameLayout2.setVisibility(8);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Drawable drawable;
        super.onAttachedToWindow();
        LinearLayout linearLayout = (LinearLayout) c(R$d.llAlertBackground);
        if (Build$VERSION.SDK_INT >= 23) {
            if (this.f1969s) {
                Context context = linearLayout.getContext();
                d0.z.d.m.checkNotNullExpressionValue(context, "context");
                d0.z.d.m.checkNotNullParameter(context, "$this$getRippleDrawable");
                TypedValue typedValue = new TypedValue();
                context.getTheme().resolveAttribute(R$b.selectableItemBackground, typedValue, true);
                drawable = ContextCompat.getDrawable(context, typedValue.resourceId);
            } else {
                drawable = null;
            }
            linearLayout.setForeground(drawable);
        }
        ViewGroup$LayoutParams layoutParams = linearLayout.getLayoutParams();
        Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        int i = this.B;
        ((FrameLayout$LayoutParams) layoutParams).gravity = i;
        if (i != 48) {
            linearLayout.setPadding(linearLayout.getPaddingLeft(), b.i.a.f.e.o.f.j0(this, R$c.alerter_padding_default), linearLayout.getPaddingRight(), b.i.a.f.e.o.f.j0(this, R$c.alerter_alert_padding));
        }
        ViewGroup$LayoutParams layoutParams2 = getLayoutParams();
        Objects.requireNonNull(layoutParams2, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        ViewGroup$MarginLayoutParams viewGroup$MarginLayoutParams = (ViewGroup$MarginLayoutParams) layoutParams2;
        if (this.B != 48) {
            viewGroup$MarginLayoutParams.bottomMargin = getNavigationBarHeight();
        }
        this.l.setAnimationListener(this);
        setAnimation(this.l);
        for (Button button : this.w) {
            Typeface typeface = this.f1970x;
            if (typeface != null) {
                button.setTypeface(typeface);
            }
            ((LinearLayout) c(R$d.llButtonContainer)).addView(button);
        }
    }

    @Override // android.view.View$OnClickListener
    public void onClick(View view) {
        d0.z.d.m.checkNotNullParameter(view, "v");
        if (this.v) {
            d();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.l.setAnimationListener(null);
    }

    @Override // b.p.a.l$a
    public void onDismiss(View view) {
        d0.z.d.m.checkNotNullParameter(view, "view");
        FrameLayout frameLayout = (FrameLayout) c(R$d.flClickShield);
        if (frameLayout != null) {
            frameLayout.removeView((LinearLayout) c(R$d.llAlertBackground));
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        Window window;
        View decorView;
        WindowInsets rootWindowInsets;
        DisplayCutout displayCutout;
        if (!this.f1971y) {
            this.f1971y = true;
            ViewGroup$LayoutParams layoutParams = getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup$MarginLayoutParams) layoutParams).topMargin = b.i.a.f.e.o.f.j0(this, R$c.alerter_alert_negative_margin_top);
            if (Build$VERSION.SDK_INT >= 28) {
                LinearLayout linearLayout = (LinearLayout) c(R$d.llAlertBackground);
                int paddingLeft = linearLayout.getPaddingLeft();
                int paddingTop = linearLayout.getPaddingTop();
                d0.z.d.m.checkNotNullParameter(this, "$this$notchHeight");
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
        d0.z.d.m.checkNotNullParameter(motionEvent, "event");
        performClick();
        return super.onTouchEvent(motionEvent);
    }

    public final void setAlertBackgroundColor(@ColorInt int i) {
        ((LinearLayout) c(R$d.llAlertBackground)).setBackgroundColor(i);
    }

    public final void setAlertBackgroundDrawable(Drawable drawable) {
        d0.z.d.m.checkNotNullParameter(drawable, "drawable");
        ViewCompat.setBackground((LinearLayout) c(R$d.llAlertBackground), drawable);
    }

    public final void setAlertBackgroundResource(@DrawableRes int i) {
        ((LinearLayout) c(R$d.llAlertBackground)).setBackgroundResource(i);
    }

    public final void setButtonTypeFace(Typeface typeface) {
        this.f1970x = typeface;
    }

    public final void setContentGravity(int i) {
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvTitle);
        ViewGroup$LayoutParams layoutParams = appCompatTextView != null ? appCompatTextView.getLayoutParams() : null;
        if (!(layoutParams instanceof LinearLayout$LayoutParams)) {
            layoutParams = null;
        }
        LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams) layoutParams;
        if (linearLayout$LayoutParams != null) {
            linearLayout$LayoutParams.gravity = i;
        }
        int i2 = R$d.tvText;
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) c(i2);
        ViewGroup$LayoutParams layoutParams2 = appCompatTextView2 != null ? appCompatTextView2.getLayoutParams() : null;
        LinearLayout$LayoutParams linearLayout$LayoutParams2 = (LinearLayout$LayoutParams) (layoutParams2 instanceof LinearLayout$LayoutParams ? layoutParams2 : null);
        if (linearLayout$LayoutParams2 != null) {
            linearLayout$LayoutParams2.gravity = i;
        }
        AppCompatTextView appCompatTextView3 = (AppCompatTextView) c(i2);
        if (appCompatTextView3 != null) {
            appCompatTextView3.setLayoutParams(linearLayout$LayoutParams2);
        }
    }

    public final void setDismissible(boolean z2) {
        this.v = z2;
    }

    public final void setDuration$alerter_release(long j) {
        this.n = j;
    }

    public final void setEnableInfiniteDuration(boolean z2) {
        this.q = z2;
    }

    public final void setEnableProgress(boolean z2) {
        this.r = z2;
    }

    public final void setEnterAnimation$alerter_release(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "<set-?>");
        this.l = animation;
    }

    public final void setExitAnimation$alerter_release(Animation animation) {
        d0.z.d.m.checkNotNullParameter(animation, "<set-?>");
        this.m = animation;
    }

    public final void setIcon(@DrawableRes int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public final void setIconColorFilter(@ColorInt int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(i);
        }
    }

    public final void setIconPixelSize(@Px int i) {
        int i2 = R$d.ivIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(i2);
        d0.z.d.m.checkNotNullExpressionValue(appCompatImageView, "ivIcon");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) c(i2);
        d0.z.d.m.checkNotNullExpressionValue(appCompatImageView2, "ivIcon");
        ViewGroup$LayoutParams layoutParams = appCompatImageView2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        setMinimumWidth(i);
        setMinimumHeight(i);
        appCompatImageView.setLayoutParams(layoutParams);
    }

    public final void setIconSize(@DimenRes int i) {
        setIconPixelSize(b.i.a.f.e.o.f.j0(this, i));
    }

    public final void setLayoutGravity(int i) {
        if (i != 48) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(getContext(), R$a.alerter_slide_in_from_bottom);
            d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation, "AnimationUtils.loadAnima…ter_slide_in_from_bottom)");
            this.l = animationLoadAnimation;
            Animation animationLoadAnimation2 = AnimationUtils.loadAnimation(getContext(), R$a.alerter_slide_out_to_bottom);
            d0.z.d.m.checkNotNullExpressionValue(animationLoadAnimation2, "AnimationUtils.loadAnima…rter_slide_out_to_bottom)");
            this.m = animationLoadAnimation2;
        }
        this.B = i;
    }

    @Override // android.view.View
    public void setOnClickListener(View$OnClickListener view$OnClickListener) {
        ((LinearLayout) c(R$d.llAlertBackground)).setOnClickListener(view$OnClickListener);
    }

    public final void setOnHideListener$alerter_release(j jVar) {
        this.k = jVar;
    }

    public final void setOnShowListener(k kVar) {
        d0.z.d.m.checkNotNullParameter(kVar, "listener");
        this.j = kVar;
    }

    public final void setProgressColorInt(@ColorInt int i) {
        Drawable progressDrawable;
        ProgressBar progressBar = (ProgressBar) c(R$d.pbProgress);
        if (progressBar == null || (progressDrawable = progressBar.getProgressDrawable()) == null) {
            return;
        }
        progressDrawable.setColorFilter(new LightingColorFilter(ViewCompat.MEASURED_STATE_MASK, i));
    }

    public final void setProgressColorRes(@ColorRes int i) {
        Drawable progressDrawable;
        ProgressBar progressBar = (ProgressBar) c(R$d.pbProgress);
        if (progressBar == null || (progressDrawable = progressBar.getProgressDrawable()) == null) {
            return;
        }
        progressDrawable.setColorFilter(new LightingColorFilter(ViewCompat.MEASURED_STATE_MASK, ContextCompat.getColor(getContext(), i)));
    }

    public final void setRightIcon(@DrawableRes int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(AppCompatResources.getDrawable(getContext(), i));
        }
    }

    public final void setRightIconColorFilter(@ColorInt int i) {
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(i);
        }
    }

    public final void setRightIconPixelSize(@Px int i) {
        int i2 = R$d.ivRightIcon;
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(i2);
        d0.z.d.m.checkNotNullExpressionValue(appCompatImageView, "ivRightIcon");
        AppCompatImageView appCompatImageView2 = (AppCompatImageView) c(i2);
        d0.z.d.m.checkNotNullExpressionValue(appCompatImageView2, "ivRightIcon");
        ViewGroup$LayoutParams layoutParams = appCompatImageView2.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i;
        setMinimumWidth(i);
        setMinimumHeight(i);
        appCompatImageView.setLayoutParams(layoutParams);
    }

    public final void setRightIconPosition(int i) {
        if (i == 48 || i == 17 || i == 16 || i == 80) {
            int i2 = R$d.flRightIconContainer;
            FrameLayout frameLayout = (FrameLayout) c(i2);
            d0.z.d.m.checkNotNullExpressionValue(frameLayout, "flRightIconContainer");
            FrameLayout frameLayout2 = (FrameLayout) c(i2);
            d0.z.d.m.checkNotNullExpressionValue(frameLayout2, "flRightIconContainer");
            ViewGroup$LayoutParams layoutParams = frameLayout2.getLayoutParams();
            Objects.requireNonNull(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
            LinearLayout$LayoutParams linearLayout$LayoutParams = (LinearLayout$LayoutParams) layoutParams;
            linearLayout$LayoutParams.gravity = i;
            frameLayout.setLayoutParams(linearLayout$LayoutParams);
        }
    }

    public final void setRightIconSize(@DimenRes int i) {
        Context context = getContext();
        d0.z.d.m.checkNotNullExpressionValue(context, "context");
        setRightIconPixelSize(context.getResources().getDimensionPixelSize(i));
    }

    public final void setSound(Uri uri) {
        this.A = uri;
    }

    public final void setText(@StringRes int i) {
        String string = getContext().getString(i);
        d0.z.d.m.checkNotNullExpressionValue(string, "context.getString(textId)");
        setText(string);
    }

    public final void setTextAppearance(@StyleRes int i) {
        if (Build$VERSION.SDK_INT < 23) {
            TextViewCompat.setTextAppearance((AppCompatTextView) c(R$d.tvText), i);
            return;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvText);
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public final void setTextTypeface(Typeface typeface) {
        d0.z.d.m.checkNotNullParameter(typeface, "typeface");
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvText);
        if (appCompatTextView != null) {
            appCompatTextView.setTypeface(typeface);
        }
    }

    public final void setTitle(@StringRes int i) {
        String string = getContext().getString(i);
        d0.z.d.m.checkNotNullExpressionValue(string, "context.getString(titleId)");
        setTitle(string);
    }

    public final void setTitleAppearance(@StyleRes int i) {
        if (Build$VERSION.SDK_INT < 23) {
            TextViewCompat.setTextAppearance((AppCompatTextView) c(R$d.tvTitle), i);
            return;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvTitle);
        if (appCompatTextView != null) {
            appCompatTextView.setTextAppearance(i);
        }
    }

    public final void setTitleTypeface(Typeface typeface) {
        d0.z.d.m.checkNotNullParameter(typeface, "typeface");
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(R$d.tvTitle);
        if (appCompatTextView != null) {
            appCompatTextView.setTypeface(typeface);
        }
    }

    public final void setVibrationEnabled(boolean z2) {
        this.f1972z = z2;
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            d0.z.d.m.checkNotNullExpressionValue(childAt, "getChildAt(i)");
            childAt.setVisibility(i);
        }
    }

    public final void setIcon(Bitmap bitmap) {
        d0.z.d.m.checkNotNullParameter(bitmap, "bitmap");
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageBitmap(bitmap);
        }
    }

    public final void setIconColorFilter(ColorFilter colorFilter) {
        d0.z.d.m.checkNotNullParameter(colorFilter, "colorFilter");
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(colorFilter);
        }
    }

    public final void setRightIcon(Bitmap bitmap) {
        d0.z.d.m.checkNotNullParameter(bitmap, "bitmap");
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageBitmap(bitmap);
        }
    }

    public final void setRightIconColorFilter(ColorFilter colorFilter) {
        d0.z.d.m.checkNotNullParameter(colorFilter, "colorFilter");
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setColorFilter(colorFilter);
        }
    }

    public final void setText(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, NotificationCompat$MessagingStyle$Message.KEY_TEXT);
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        int i = R$d.tvText;
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(i);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(0);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) c(i);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(charSequence);
        }
    }

    public final void setTitle(CharSequence charSequence) {
        d0.z.d.m.checkNotNullParameter(charSequence, "title");
        if (TextUtils.isEmpty(charSequence)) {
            return;
        }
        int i = R$d.tvTitle;
        AppCompatTextView appCompatTextView = (AppCompatTextView) c(i);
        if (appCompatTextView != null) {
            appCompatTextView.setVisibility(0);
        }
        AppCompatTextView appCompatTextView2 = (AppCompatTextView) c(i);
        if (appCompatTextView2 != null) {
            appCompatTextView2.setText(charSequence);
        }
    }

    public final void setIcon(Drawable drawable) {
        d0.z.d.m.checkNotNullParameter(drawable, "drawable");
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(drawable);
        }
    }

    public final void setRightIcon(Drawable drawable) {
        d0.z.d.m.checkNotNullParameter(drawable, "drawable");
        AppCompatImageView appCompatImageView = (AppCompatImageView) c(R$d.ivRightIcon);
        if (appCompatImageView != null) {
            appCompatImageView.setImageDrawable(drawable);
        }
    }
}
