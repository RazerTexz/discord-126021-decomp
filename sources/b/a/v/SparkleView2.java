package b.a.v;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.tooltips.SparkleView;
import d0.z.d.Lambda;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: b.a.v.c, reason: use source file name */
/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparkleView2 extends Lambda implements Function0<AnimatedVectorDrawableCompat> {
    public final /* synthetic */ SparkleView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SparkleView2(SparkleView sparkleView) {
        super(0);
        this.this$0 = sparkleView;
    }

    @Override // kotlin.jvm.functions.Function0
    public AnimatedVectorDrawableCompat invoke() {
        return AnimatedVectorDrawableCompat.create(this.this$0.getContext(), this.this$0.sparkleAnimationResId);
    }
}
