package b.i.d;

import java.lang.reflect.Field;
import java.util.Locale;

/* JADX INFO: compiled from: FieldNamingPolicy.java */
/* JADX INFO: loaded from: classes3.dex */
public final enum c$e extends c {
    public c$e(String str, int i) {
        super(str, i, null);
    }

    @Override // b.i.d.d
    public String f(Field field) {
        return c.g(field.getName(), "-").toLowerCase(Locale.ENGLISH);
    }
}
