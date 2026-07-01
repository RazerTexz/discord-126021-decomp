package d0.e0.p.d.l0;

import d0.z.d.m;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$f$a extends e$f implements c {
    public final Object f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$f$a(Field field, Object obj) {
        super(field, false, null);
        m.checkNotNullParameter(field, "field");
        this.f = obj;
    }

    @Override // d0.e0.p.d.l0.e$f, d0.e0.p.d.l0.d
    public Object call(Object[] objArr) {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        return mo80getMember().get(this.f);
    }
}
