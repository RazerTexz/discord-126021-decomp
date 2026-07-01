package com.discord.tooltips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.a.i.SparkleViewBinding;
import b.a.v.SparkleView2;
import b.a.v.SparkleView3;
import d0.LazyJVM;
import d0.z.d.Intrinsics3;
import kotlin.Lazy;

/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparkleView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final SparkleViewBinding binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int sparkleAnimationResId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy sparkleDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SparkleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics3.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(com.discord.R.layout.sparkle_view, this);
        ImageView imageView = (ImageView) findViewById(com.discord.R.id.sparkle_view_image);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(com.discord.R.id.sparkle_view_image)));
        }
        SparkleViewBinding sparkleViewBinding = new SparkleViewBinding(this, imageView);
        Intrinsics3.checkNotNullExpressionValue(sparkleViewBinding, "SparkleViewBinding.infla…ater.from(context), this)");
        this.binding = sparkleViewBinding;
        this.sparkleAnimationResId = com.discord.R.drawable.sparkle_animated_vector;
        this.sparkleDrawable = LazyJVM.lazy(new SparkleView2(this));
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        imageView.setImageDrawable(getSparkleDrawable());
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.registerAnimationCallback(new SparkleView3(this));
        }
        AnimatedVectorDrawableCompat sparkleDrawable2 = getSparkleDrawable();
        if (sparkleDrawable2 != null) {
            sparkleDrawable2.start();
        }
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
