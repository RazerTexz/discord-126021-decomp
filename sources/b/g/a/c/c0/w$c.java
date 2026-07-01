package b.g.a.c.c0;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: DefaultAccessorNamingStrategy.java */
/* JADX INFO: loaded from: classes3.dex */
public class w$c extends w {
    public final Set<String> f;

    public w$c(b.g.a.c.z.l<?> lVar, c cVar) {
        super(lVar, cVar, null, "get", "is", null);
        this.f = new HashSet();
        Class<?> cls = cVar.l;
        RuntimeException runtimeException = b.g.a.c.d0.a.f697b;
        if (runtimeException != null) {
            throw runtimeException;
        }
        b.g.a.c.d0.a aVar = b.g.a.c.d0.a.a;
        Objects.requireNonNull(aVar);
        try {
            Object[] objArr = (Object[]) aVar.c.invoke(cls, new Object[0]);
            int length = objArr.length;
            String[] strArr = new String[length];
            for (int i = 0; i < objArr.length; i++) {
                try {
                    strArr[i] = (String) aVar.d.invoke(objArr[i], new Object[0]);
                } catch (Exception e) {
                    throw new IllegalArgumentException(String.format("Failed to access name of field #%d (of %d) of Record type %s", Integer.valueOf(i), Integer.valueOf(objArr.length), b.g.a.c.i0.d.u(cls)), e);
                }
            }
            for (int i2 = 0; i2 < length; i2++) {
                this.f.add(strArr[i2]);
            }
        } catch (Exception unused) {
            StringBuilder sbU = b.d.b.a.a.U("Failed to access RecordComponents of type ");
            sbU.append(b.g.a.c.i0.d.u(cls));
            throw new IllegalArgumentException(sbU.toString());
        }
    }

    @Override // b.g.a.c.c0.w, b.g.a.c.c0.a
    public String c(j jVar, String str) {
        return this.f.contains(str) ? str : super.c(jVar, str);
    }
}
