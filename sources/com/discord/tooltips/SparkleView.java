package com.discord.tooltips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.FrameLayout$LayoutParams;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.a.i.q1;
import b.a.v.c;
import b.a.v.d;
import com.discord.R$id;
import com.discord.R$layout;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparkleView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final q1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int sparkleAnimationResId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy sparkleDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SparkleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(R$layout.sparkle_view, this);
        ImageView imageView = (ImageView) findViewById(R$id.sparkle_view_image);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(R$id.sparkle_view_image)));
        }
        q1 q1Var = new q1(this, imageView);
        m.checkNotNullExpressionValue(q1Var, "SparkleViewBinding.infla…ater.from(context), this)");
        this.binding = q1Var;
        this.sparkleAnimationResId = 2131232530;
        this.sparkleDrawable = g.lazy(new c(this));
        setLayoutParams(new FrameLayout$LayoutParams(-2, -2));
        imageView.setImageDrawable(getSparkleDrawable());
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.registerAnimationCallback(new d(this));
        }
        AnimatedVectorDrawableCompat sparkleDrawable2 = getSparkleDrawable();
        if (sparkleDrawable2 != null) {
            sparkleDrawable2.start();
        }
    }

    public static final /* synthetic */ AnimatedVectorDrawableCompat a(SparkleView sparkleView) {
        return sparkleView.getSparkleDrawable();
    }

    private final AnimatedVectorDrawableCompat getSparkleDrawable() {
        return (AnimatedVectorDrawableCompat) this.sparkleDrawable.getValue();
    }

    public final void b() {
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.stop();
        }
    }
}
