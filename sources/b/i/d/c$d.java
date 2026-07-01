package b.i.d;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public final enum c$d extends c {
    public c$d(String str, int i) {
        super(str, i, null);
    }

    @Override // b.i.d.d
    public String f(Field field) {
        return c.g(field.getName(), "_").toLowerCase(Locale.ENGLISH);
    }
}
