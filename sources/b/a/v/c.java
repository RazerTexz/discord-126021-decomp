package b.a.v;

import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.tooltips.SparkleView;
import d0.z.d.o;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends o implements Function0<AnimatedVectorDrawableCompat> {
    public final /* synthetic */ SparkleView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(SparkleView sparkleView) {
        super(0);
        this.this$0 = sparkleView;
    }

    @Override // kotlin.jvm.functions.Function0
    public AnimatedVectorDrawableCompat invoke() {
        return AnimatedVectorDrawableCompat.create(this.this$0.getContext(), this.this$0.sparkleAnimationResId);
    }
}
