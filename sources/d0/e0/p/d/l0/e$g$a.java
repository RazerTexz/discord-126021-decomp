package d0.e0.p.d.l0;

import d0.t.k;
import d0.z.d.m;
import java.lang.reflect.Field;
import kotlin.Unit;

/* JADX INFO: compiled from: CallerImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$g$a extends e$g implements c {
    public final Object g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e$g$a(Field field, boolean z2, Object obj) {
        super(field, z2, false, null);
        m.checkNotNullParameter(field, "field");
        this.g = obj;
    }

    @Override // d0.e0.p.d.l0.e$g, d0.e0.p.d.l0.d
    public Object call(Object[] objArr) throws IllegalAccessException {
        m.checkNotNullParameter(objArr, "args");
        checkArguments(objArr);
        mo80getMember().set(this.g, k.first(objArr));
        return Unit.a;
    }
}
