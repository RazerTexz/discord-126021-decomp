package b.g.a.c.c0;

import b.g.a.a.JsonInclude;
import b.g.a.c.AnnotationIntrospector;
import b.g.a.c.PropertyMetadata;
import b.g.a.c.PropertyName;

/* JADX INFO: renamed from: b.g.a.c.c0.s, reason: use source file name */
/* JADX INFO: compiled from: BeanPropertyDefinition.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class BeanPropertyDefinition {
    public static final JsonInclude.b j;

    static {
        JsonInclude.b bVar = JsonInclude.b.j;
        j = JsonInclude.b.j;
    }

    public boolean f() {
        Annotated annotatedK = k();
        if (annotatedK == null && (annotatedK = s()) == null) {
            annotatedK = l();
        }
        return annotatedK != null;
    }

    public abstract JsonInclude.b g();

    public AnnotationIntrospector.a h() {
        return null;
    }

    public Class<?>[] i() {
        return null;
    }

    public AnnotatedMember j() {
        AnnotatedMethod annotatedMethodN = n();
        return annotatedMethodN == null ? l() : annotatedMethodN;
    }

    public abstract AnnotatedParameter k();

    public abstract AnnotatedField l();

    public abstract PropertyName m();

    public abstract AnnotatedMethod n();

    public abstract PropertyMetadata o();

    public abstract String p();

    public abstract AnnotatedMember q();

    public abstract Class<?> r();

    public abstract AnnotatedMethod s();

    public abstract PropertyName t();

    public abstract boolean u();

    public boolean v() {
        return false;
    }
}
