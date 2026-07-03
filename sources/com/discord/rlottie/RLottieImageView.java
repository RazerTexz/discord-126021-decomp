package com.discord.rlottie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.rlottie.RLottieDrawable;
import kotlin.TypeCastException;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: RLottieImageView.kt */
/* JADX INFO: loaded from: classes.dex */
public class RLottieImageView extends AppCompatImageView {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public RLottieDrawable drawable;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public boolean attachedToWindow;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public boolean playing;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RLottieImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkParameterIsNotNull(context, "context");
        RLottieDrawable.PlaybackMode playbackMode = RLottieDrawable.PlaybackMode.FREEZE;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    /* JADX INFO: renamed from: a */
    public final Display m8448a(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = context.getDisplay();
            if (display == null) {
                C12238m.throwNpe();
            }
            C12238m.checkExpressionValueIsNotNull(display, "display!!");
            return display;
        }
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        C12238m.checkExpressionValueIsNotNull(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return defaultDisplay;
    }

    /* JADX INFO: renamed from: b */
    public final void m8449b() {
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable == null) {
            return;
        }
        this.playing = true;
        if (!this.attachedToWindow || rLottieDrawable == null) {
            return;
        }
        rLottieDrawable.start();
    }

    /* JADX INFO: renamed from: c */
    public final void m8450c(int resId, int w, int h) {
        RLottieDrawable.PlaybackMode playbackMode = RLottieDrawable.PlaybackMode.LOOP;
        C12238m.checkParameterIsNotNull(playbackMode, "playbackMode");
        Context context = getContext();
        C12238m.checkExpressionValueIsNotNull(context, "context");
        String strValueOf = String.valueOf(resId);
        Context context2 = getContext();
        C12238m.checkExpressionValueIsNotNull(context2, "context");
        RLottieDrawable rLottieDrawable = new RLottieDrawable(context, resId, strValueOf, w, h, m8448a(context2).getRefreshRate(), false, (int[]) null);
        this.drawable = rLottieDrawable;
        rLottieDrawable.m8447f(playbackMode);
        RLottieDrawable rLottieDrawable2 = this.drawable;
        if (rLottieDrawable2 != null) {
            rLottieDrawable2.m8446e(true);
        }
        setImageDrawable(this.drawable);
    }

    @Override // android.widget.ImageView, android.view.View
    public void onAttachedToWindow() {
        RLottieDrawable rLottieDrawable;
        super.onAttachedToWindow();
        this.attachedToWindow = true;
        if (!this.playing || (rLottieDrawable = this.drawable) == null) {
            return;
        }
        rLottieDrawable.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.attachedToWindow = false;
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            rLottieDrawable.f18711P = false;
        }
    }

    public final void setPlaybackMode(RLottieDrawable.PlaybackMode playbackMode) {
        C12238m.checkParameterIsNotNull(playbackMode, "playbackMode");
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            rLottieDrawable.m8447f(playbackMode);
        }
    }

    public final void setProgress(float progress) {
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            if (progress < 0.0f) {
                progress = 0.0f;
            } else if (progress > 1.0f) {
                progress = 1.0f;
            }
            rLottieDrawable.f18704I = (int) (rLottieDrawable.f18722r[0] * progress);
            rLottieDrawable.f18730z = false;
            rLottieDrawable.f18702G = false;
            if (!rLottieDrawable.m8445d()) {
                rLottieDrawable.f18703H = true;
            }
            rLottieDrawable.invalidateSelf();
        }
    }
}
