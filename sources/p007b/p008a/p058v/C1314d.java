package p007b.p008a.p058v;

import android.graphics.drawable.Drawable;
import androidx.vectordrawable.graphics.drawable.Animatable2Compat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import com.discord.tooltips.SparkleView;
import com.discord.utilities.views.ViewCoroutineScopeKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;
import p507d0.C12113l;
import p507d0.p584w.p585h.C12183c;
import p507d0.p584w.p586i.p587a.AbstractC12194k;
import p507d0.p584w.p586i.p587a.InterfaceC12188e;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: b.a.v.d */
/* JADX INFO: compiled from: SparkleView.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class C1314d extends Animatable2Compat.AnimationCallback {

    /* JADX INFO: renamed from: a */
    public final /* synthetic */ SparkleView f2002a;

    /* JADX INFO: renamed from: b.a.v.d$a */
    /* JADX INFO: compiled from: SparkleView.kt */
    @InterfaceC12188e(m10084c = "com.discord.tooltips.SparkleView$startAnimation$1$onAnimationEnd$1", m10085f = "SparkleView.kt", m10086l = {61}, m10087m = "invokeSuspend")
    public static final class a extends AbstractC12194k implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int label;

        public a(Continuation continuation) {
            super(2, continuation);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C12238m.checkNotNullParameter(continuation, "completion");
            return C1314d.this.new a(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            Continuation<? super Unit> continuation2 = continuation;
            C12238m.checkNotNullParameter(continuation2, "completion");
            return C1314d.this.new a(continuation2).invokeSuspend(Unit.f27425a);
        }

        @Override // p507d0.p584w.p586i.p587a.AbstractC12184a
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = C12183c.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                C12113l.throwOnFailure(obj);
                this.label = 1;
                if (C3404f.m4234P(500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C12113l.throwOnFailure(obj);
            }
            AnimatedVectorDrawableCompat sparkleDrawable = C1314d.this.f2002a.getSparkleDrawable();
            if (sparkleDrawable != null) {
                sparkleDrawable.start();
            }
            return Unit.f27425a;
        }
    }

    public C1314d(SparkleView sparkleView) {
        this.f2002a = sparkleView;
    }

    @Override // androidx.vectordrawable.graphics.drawable.Animatable2Compat.AnimationCallback
    public void onAnimationEnd(Drawable drawable) {
        C12238m.checkNotNullParameter(drawable, "drawable");
        CoroutineScope coroutineScope = ViewCoroutineScopeKt.getCoroutineScope(this.f2002a);
        if (coroutineScope != null) {
            C3404f.m4211H0(coroutineScope, null, null, new a(null), 3, null);
        }
    }
}
