package b.g.a.c.e0.h;

import b.g.a.c.JavaType;
import b.g.a.c.e0.PolymorphicTypeValidator;
import b.g.a.c.h0.TypeFactory;

/* JADX INFO: renamed from: b.g.a.c.e0.h.h, reason: use source file name */
/* JADX INFO: compiled from: MinimalClassNameIdResolver.java */
/* JADX INFO: loaded from: classes3.dex */
public class MinimalClassNameIdResolver extends ClassNameIdResolver {
    public final String c;

    public MinimalClassNameIdResolver(JavaType javaType, TypeFactory typeFactory, PolymorphicTypeValidator polymorphicTypeValidator) {
        super(javaType, typeFactory, polymorphicTypeValidator);
        String name = javaType._class.getName();
        int iLastIndexOf = name.lastIndexOf(46);
        if (iLastIndexOf < 0) {
            this.c = ".";
        } else {
            this.c = name.substring(0, iLastIndexOf + 1);
            name.substring(0, iLastIndexOf);
        }
    }

    @Override // b.g.a.c.e0.h.ClassNameIdResolver, b.g.a.c.e0.TypeIdResolver
    public String a(Object obj) {
        String name = obj.getClass().getName();
        return name.startsWith(this.c) ? name.substring(this.c.length() - 1) : name;
    }
}
