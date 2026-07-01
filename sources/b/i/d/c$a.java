package b.i.d;

import java.lang.reflect.Field;

/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public final enum c$a extends c {
    public c$a(String str, int i) {
        super(str, i, null);
    }

    @Override // b.i.d.d
    public String f(Field field) {
        return field.getName();
    }
}
