package androidx.view;

import androidx.exifinterface.media.ExifInterface;
import b.i.a.f.e.o.f;
import d0.l;
import d0.w.h.c;
import d0.w.i.a.e;
import d0.w.i.a.k;
import d0.z.d.m;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.objectweb.asm.Opcodes;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: PausingDispatcher.kt */
/* JADX INFO: loaded from: classes.dex */
@e(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", l = {Opcodes.IF_ICMPGE}, m = "invokeSuspend")
public final class PausingDispatcherKt$whenStateAtLeast$2<T> extends k implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    public final /* synthetic */ Function2 $block;
    public final /* synthetic */ Lifecycle$State $minState;
    public final /* synthetic */ Lifecycle $this_whenStateAtLeast;
    private /* synthetic */ Object L$0;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle$State lifecycle$State, Function2 function2, Continuation continuation) {
        super(2, continuation);
        this.$this_whenStateAtLeast = lifecycle;
        this.$minState = lifecycle$State;
        this.$block = function2;
    }

    @Override // d0.w.i.a.a
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        m.checkNotNullParameter(continuation, "completion");
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.$this_whenStateAtLeast, this.$minState, this.$block, continuation);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Object obj) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(coroutineScope, (Continuation) obj)).invokeSuspend(Unit.a);
    }

    @Override // d0.w.i.a.a
    public final Object invokeSuspend(Object obj) throws Throwable {
        LifecycleController lifecycleController;
        Object coroutine_suspended = c.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i != 0) {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            lifecycleController = (LifecycleController) this.L$0;
            try {
                l.throwOnFailure(obj);
                lifecycleController.finish();
                return obj;
            } catch (Throwable th) {
                th = th;
                lifecycleController.finish();
                throw th;
            }
        }
        l.throwOnFailure(obj);
        Job job = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.h);
        if (job == null) {
            throw new IllegalStateException("when[State] methods should have a parent job".toString());
        }
        PausingDispatcher pausingDispatcher = new PausingDispatcher();
        LifecycleController lifecycleController2 = new LifecycleController(this.$this_whenStateAtLeast, this.$minState, pausingDispatcher.dispatchQueue, job);
        try {
            Function2 function2 = this.$block;
            this.L$0 = lifecycleController2;
            this.label = 1;
            obj = f.C1(pausingDispatcher, function2, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
            lifecycleController = lifecycleController2;
            lifecycleController.finish();
            return obj;
        } catch (Throwable th2) {
            th = th2;
            lifecycleController = lifecycleController2;
            lifecycleController.finish();
            throw th;
        }
    }
}
