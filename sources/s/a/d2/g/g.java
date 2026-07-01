package s.a.d2.g;

import b.d.b.a.outline;
import d0.z.d.Lambda;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import s.a.a.Scopes2;

/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends Lambda implements Function2<Integer, CoroutineContext.Element, Integer> {
    public final /* synthetic */ SafeCollector3 $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(SafeCollector3 safeCollector3) {
        super(2);
        this.$this_checkContext = safeCollector3;
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
                    if (job2 == job || !(job2 instanceof Scopes2)) {
                        break;
                    }
                    job2 = (Job) ((Scopes2) job2).l.get(Job.INSTANCE);
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
                throw new IllegalStateException(outline.K(sb, ".\n", "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n", "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
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
