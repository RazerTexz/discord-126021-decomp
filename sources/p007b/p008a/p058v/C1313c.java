package p007b.p008a.p058v;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.tooltips.SparkleView;
import kotlin.jvm.functions.Function0;
import p507d0.p592z.p594d.AbstractC12240o;

/* JADX INFO: renamed from: b.a.v.c */
/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1313c extends AbstractC12240o implements Function0<AnimatedVectorDrawableCompat> {
    public final /* synthetic */ SparkleView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1313c(SparkleView sparkleView) {
        super(0);
        this.this$0 = sparkleView;
    }

    @Override // kotlin.jvm.functions.Function0
    public AnimatedVectorDrawableCompat invoke() {
        return AnimatedVectorDrawableCompat.create(this.this$0.getContext(), this.this$0.sparkleAnimationResId);
    }
}
