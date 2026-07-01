package b.i.d;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public final enum c$b extends c {
    public c$b(String str, int i) {
        super(str, i, null);
    }

    @Override // b.i.d.d
    public String f(Field field) {
        return c.h(field.getName());
    }
}
