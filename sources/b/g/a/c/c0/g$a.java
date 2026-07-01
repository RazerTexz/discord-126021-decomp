package b.g.a.c.c0;

import java.io.Serializable;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: AnnotatedField.java */
/* JADX INFO: loaded from: classes3.dex */
public final class g$a implements Serializable {
    private static final long serialVersionUID = 1;
    public Class<?> clazz;
    public String name;

    public g$a(Field field) {
        this.clazz = field.getDeclaringClass();
        this.name = field.getName();
    }
}
