package b.i.b.b;

import java.io.Serializable;
import java.util.Map$Entry;

/* JADX INFO: compiled from: ImmutableMap.java */
/* JADX INFO: loaded from: classes3.dex */
public class q$b implements Serializable {
    private static final long serialVersionUID = 0;
    private final Object[] keys;
    private final Object[] values;

    public q$b(q<?, ?> qVar) {
        this.keys = new Object[qVar.size()];
        this.values = new Object[qVar.size()];
        s0<Map$Entry<?, ?>> s0VarJ = qVar.e().j();
        int i = 0;
        while (s0VarJ.hasNext()) {
            Map$Entry<?, ?> next = s0VarJ.next();
            this.keys[i] = next.getKey();
            this.values[i] = next.getValue();
            i++;
        }
    }

    public Object readResolve() {
        q$a q_a = new q$a(this.keys.length);
        int i = 0;
        while (true) {
            Object[] objArr = this.keys;
            if (i >= objArr.length) {
                return q_a.a();
            }
            q_a.c(objArr[i], this.values[i]);
            i++;
        }
    }
}
