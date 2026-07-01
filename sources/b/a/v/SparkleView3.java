package b.a.v;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import b.i.a.f.e.o.f;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.views.ViewCoroutineScope;
import d0.Result3;
import d0.w.h.Intrinsics2;
import d0.w.i.a.ContinuationImpl6;
import d0.w.i.a.DebugMetadata;
import d0.z.d.Intrinsics3;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: renamed from: b.a.v.d, reason: use source file name */
/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class SparkleView3 extends Animatable2Compat.AnimationCallback {
    public final /* synthetic */ SparkleView a;

    /* JADX INFO: renamed from: b.a.v.d$a */
    /* JADX INFO: compiled from: SparkleView.kt */
    @DebugMetadata(c = "com.discord.tooltips.SparkleView$startAnimation$1$onAnimationEnd$1", f = "SparkleView.kt", l = {61}, m = "invokeSuspend")
    public static final class a extends ContinuationImpl6 implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            Intrinsics3.checkNotNullParameter(continuation, "completion");
            return SparkleView3.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            Intrinsics3.checkNotNullParameter(continuation2, "completion");
            return SparkleView3.this.new a(continuation2).invokeSuspend(Unit.a);
        }

        @Override // d0.w.i.a.ContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = Intrinsics2.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                Result3.throwOnFailure(obj);
                this.label = 1;
                if (f.P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Result3.throwOnFailure(obj);
            }
            AnimatedVectorDrawableCompat sparkleDrawable = SparkleView3.this.a.getSparkleDrawable();
            if (sparkleDrawable != null) {
                sparkleDrawable.start();
            }
            return Unit.a;
        }
    }

    public SparkleView3(SparkleView sparkleView) {
        this.a = sparkleView;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        Intrinsics3.checkNotNullParameter(drawable, "drawable");
        CoroutineScope coroutineScope = ViewCoroutineScope.getCoroutineScope(this.a);
        if (coroutineScope != null) {
            f.H0(coroutineScope, null, null, new a(null), 3, null);
        }
    }
}
