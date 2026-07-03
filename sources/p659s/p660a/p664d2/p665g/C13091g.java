package p659s.p660a.p664d2.p665g;

import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p659s.p660a.p661a.C13035r;

/* JADX INFO: renamed from: s.a.d2.g.g */
/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C13091g extends AbstractC12240o implements Function2<Integer, CoroutineContext.Element, Integer> {
    public final /* synthetic */ C13089e $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C13091g(C13089e c13089e) {
        super(2);
        this.$this_checkContext = c13089e;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    @Override // kotlin.jvm.functions.Function2
    public Integer invoke(Integer num, CoroutineContext.Element element) {
        int iIntValue = num.intValue();
        CoroutineContext.Element element2 = element;
        CoroutineContext.Key<?> key = element2.getKey();
        CoroutineContext.Element element3 = this.$this_checkContext.collectContext.get(key);
        if (key == Job.INSTANCE) {
            Job job = (Job) element3;
            Job job2 = (Job) element2;
            while (true) {
                if (job2 != null) {
                    if (job2 == job || !(job2 instanceof C13035r)) {
                        break;
                    }
                    job2 = (Job) ((C13035r) job2).f27715l.get(Job.INSTANCE);
                } else {
                    job2 = null;
                    break;
                }
            }
            if (job2 != job) {
                StringBuilder sb = new StringBuilder();
                sb.append("Flow invariant is violated:\n\t\tEmission from another coroutine is detected.\n");
                sb.append("\t\tChild of ");
                sb.append(job2);
                sb.append(", expected child of ");
                sb.append(job);
                throw new IllegalStateException(C1643a.m823K(sb, ".\n", "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n", "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
            if (job != null) {
                iIntValue++;
            }
        } else if (element2 != element3) {
            iIntValue = Integer.MIN_VALUE;
        } else {
            iIntValue++;
        }
        return Integer.valueOf(iIntValue);
    }
}
