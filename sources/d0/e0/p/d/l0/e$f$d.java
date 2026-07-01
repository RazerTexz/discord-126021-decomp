package d0.e0.p.d.l0;

import d0.t.k;
import d0.z.d.m;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$f$d extends e$f {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$f$d(Field field) {
        super(field, true, null);
        m.checkNotNullParameter(field, "field");
    }

    @Override // d0.e0.p.d.l0.e
    public void checkArguments(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        super.checkArguments(objArr);
        a(k.firstOrNull(objArr));
    }
}
