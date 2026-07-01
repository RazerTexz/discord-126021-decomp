package b.g.a.c.c0;

import b.g.a.c.JavaType;
import b.g.a.c.h0.TypeBindings;
import b.g.a.c.h0.TypeFactory;
import java.lang.reflect.Type;

/* JADX INFO: renamed from: b.g.a.c.c0.e0, reason: use source file name */
/* JADX INFO: compiled from: TypeResolutionContext.java */
/* JADX INFO: loaded from: classes3.dex */
public interface TypeResolutionContext {

    /* JADX INFO: renamed from: b.g.a.c.c0.e0$a */
    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class a implements TypeResolutionContext {
        public final TypeFactory j;
        public final TypeBindings k;

        public a(TypeFactory typeFactory, TypeBindings typeBindings) {
            this.j = typeFactory;
            this.k = typeBindings;
        }

        @Override // b.g.a.c.c0.TypeResolutionContext
        public JavaType a(Type type) {
            return this.j.b(null, type, this.k);
        }
    }

    /* JADX INFO: renamed from: b.g.a.c.c0.e0$b */
    /* JADX INFO: compiled from: TypeResolutionContext.java */
    public static class b implements TypeResolutionContext {
        public final TypeFactory j;

        public b(TypeFactory typeFactory) {
            this.j = typeFactory;
        }

        @Override // b.g.a.c.c0.TypeResolutionContext
        public JavaType a(Type type) {
            return this.j.b(null, type, TypeFactory.l);
        }
    }

    JavaType a(Type type);
}
