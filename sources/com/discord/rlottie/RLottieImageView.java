package com.discord.rlottie;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import androidx.appcompat.widget.AppCompatImageView;
import com.discord.rlottie.RLottieDrawable;
import d0.z.d.Intrinsics3;
import kotlin.TypeCastException;

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
        Intrinsics3.checkParameterIsNotNull(context, "context");
        RLottieDrawable.PlaybackMode playbackMode = RLottieDrawable.PlaybackMode.FREEZE;
    }

    @SuppressLint({"AnnotateVersionCheck"})
    public final Display a(Context context) {
        if (Build.VERSION.SDK_INT >= 30) {
            Display display = context.getDisplay();
            if (display == null) {
                Intrinsics3.throwNpe();
            }
            Intrinsics3.checkExpressionValueIsNotNull(display, "display!!");
            return display;
        }
        Object systemService = context.getSystemService("window");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
        }
        Display defaultDisplay = ((WindowManager) systemService).getDefaultDisplay();
        Intrinsics3.checkExpressionValueIsNotNull(defaultDisplay, "(getSystemService(Contex…owManager).defaultDisplay");
        return defaultDisplay;
    }

    public final void b() {
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

    public final void c(int resId, int w, int h) {
        RLottieDrawable.PlaybackMode playbackMode = RLottieDrawable.PlaybackMode.LOOP;
        Intrinsics3.checkParameterIsNotNull(playbackMode, "playbackMode");
        Context context = getContext();
        Intrinsics3.checkExpressionValueIsNotNull(context, "context");
        String strValueOf = String.valueOf(resId);
        Context context2 = getContext();
        Intrinsics3.checkExpressionValueIsNotNull(context2, "context");
        RLottieDrawable rLottieDrawable = new RLottieDrawable(context, resId, strValueOf, w, h, a(context2).getRefreshRate(), false, (int[]) null);
        this.drawable = rLottieDrawable;
        rLottieDrawable.f(playbackMode);
        RLottieDrawable rLottieDrawable2 = this.drawable;
        if (rLottieDrawable2 != null) {
            rLottieDrawable2.e(true);
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
            rLottieDrawable.P = false;
        }
    }

    public final void setPlaybackMode(RLottieDrawable.PlaybackMode playbackMode) {
        Intrinsics3.checkParameterIsNotNull(playbackMode, "playbackMode");
        RLottieDrawable rLottieDrawable = this.drawable;
        if (rLottieDrawable != null) {
            rLottieDrawable.f(playbackMode);
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
            rLottieDrawable.I = (int) (rLottieDrawable.r[0] * progress);
            rLottieDrawable.f2769z = false;
            rLottieDrawable.G = false;
            if (!rLottieDrawable.d()) {
                rLottieDrawable.H = true;
            }
            rLottieDrawable.invalidateSelf();
        }
    }
}
