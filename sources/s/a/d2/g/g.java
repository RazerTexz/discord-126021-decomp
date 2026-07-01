package s.a.d2.g;

import d0.z.d.o;
import kotlin.coroutines.CoroutineContext$Element;
import kotlin.coroutines.CoroutineContext$Key;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.Job;
import s.a.a.r;

/* JADX INFO: compiled from: SafeCollector.common.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class g extends o implements Function2<Integer, CoroutineContext$Element, Integer> {
    public final /* synthetic */ e $this_checkContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(e eVar) {
        super(2);
        this.$this_checkContext = eVar;
    }

    /* JADX WARN: Code duplicated, block: B:16:0x0031  */
    @Override // kotlin.jvm.functions.Function2
    public Integer invoke(Integer num, CoroutineContext$Element coroutineContext$Element) {
        int iIntValue = num.intValue();
        CoroutineContext$Element coroutineContext$Element2 = coroutineContext$Element;
        CoroutineContext$Key<?> key = coroutineContext$Element2.getKey();
        CoroutineContext$Element coroutineContext$Element3 = this.$this_checkContext.collectContext.get(key);
        if (key == Job.h) {
            Job job = (Job) coroutineContext$Element3;
            Job job2 = (Job) coroutineContext$Element2;
            while (true) {
                if (job2 != null) {
                    if (job2 == job || !(job2 instanceof r)) {
                        break;
                    }
                    job2 = (Job) ((r) job2).l.get(Job.h);
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
                throw new IllegalStateException(b.d.b.a.a.K(sb, ".\n", "\t\tFlowCollector is not thread-safe and concurrent emissions are prohibited.\n", "\t\tTo mitigate this restriction please use 'channelFlow' builder instead of 'flow'").toString());
            }
            if (job != null) {
                iIntValue++;
            }
        } else if (coroutineContext$Element2 != coroutineContext$Element3) {
            iIntValue = Integer.MIN_VALUE;
        } else {
            iIntValue++;
        }
        return Integer.valueOf(iIntValue);
    }
}
