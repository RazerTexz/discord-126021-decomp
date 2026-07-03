package com.discord.tooltips;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.C5419R;
import kotlin.Lazy;
import p007b.p008a.p025i.C1032q1;
import p007b.p008a.p058v.C1313c;
import p007b.p008a.p058v.C1314d;
import p507d0.C12083g;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparkleView extends FrameLayout {

    /* JADX INFO: renamed from: j, reason: from kotlin metadata */
    public final C1032q1 binding;

    /* JADX INFO: renamed from: k, reason: from kotlin metadata */
    public int sparkleAnimationResId;

    /* JADX INFO: renamed from: l, reason: from kotlin metadata */
    public final Lazy sparkleDrawable;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SparkleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        C12238m.checkNotNullParameter(context, "context");
        LayoutInflater.from(getContext()).inflate(C5419R.layout.sparkle_view, this);
        ImageView imageView = (ImageView) findViewById(C5419R.id.sparkle_view_image);
        if (imageView == null) {
            throw new NullPointerException("Missing required view with ID: ".concat(getResources().getResourceName(C5419R.id.sparkle_view_image)));
        }
        C1032q1 c1032q1 = new C1032q1(this, imageView);
        C12238m.checkNotNullExpressionValue(c1032q1, "SparkleViewBinding.infla…ater.from(context), this)");
        this.binding = c1032q1;
        this.sparkleAnimationResId = C5419R.drawable.sparkle_animated_vector;
        this.sparkleDrawable = C12083g.lazy(new C1313c(this));
        setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        imageView.setImageDrawable(getSparkleDrawable());
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.registerAnimationCallback(new C1314d(this));
        }
        AnimatedVectorDrawableCompat sparkleDrawable2 = getSparkleDrawable();
        if (sparkleDrawable2 != null) {
            sparkleDrawable2.start();
        }
    }

    private final AnimatedVectorDrawableCompat getSparkleDrawable() {
        return (AnimatedVectorDrawableCompat) this.sparkleDrawable.getValue();
    }

    /* JADX INFO: renamed from: b */
    public final void m8511b() {
        AnimatedVectorDrawableCompat sparkleDrawable = getSparkleDrawable();
        if (sparkleDrawable != null) {
            sparkleDrawable.stop();
        }
    }
}
