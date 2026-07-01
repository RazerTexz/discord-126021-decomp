package b.g.a.c.i0;

import b.g.a.c.JavaType;
import b.g.a.c.h0.TypeFactory;

/* JADX INFO: renamed from: b.g.a.c.i0.e, reason: use source file name */
/* JADX INFO: compiled from: Converter.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Converter<IN, OUT> {

    /* JADX INFO: renamed from: b.g.a.c.i0.e$a */
    /* JADX INFO: compiled from: Converter.java */
    public static abstract class a implements Converter<Object, Object> {
    }

    JavaType a(TypeFactory typeFactory);

    OUT convert(IN in);
}
