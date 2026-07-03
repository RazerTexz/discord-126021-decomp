package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11814f;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p */
/* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11655p {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$a */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface a {
        void visit(C11716e c11716e, Object obj);

        a visitAnnotation(C11716e c11716e, C11712a c11712a);

        b visitArray(C11716e c11716e);

        void visitClassLiteral(C11716e c11716e, C11814f c11814f);

        void visitEnd();

        void visitEnum(C11716e c11716e, C11712a c11712a, C11716e c11716e2);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$b */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface b {
        void visit(Object obj);

        void visitClassLiteral(C11814f c11814f);

        void visitEnd();

        void visitEnum(C11712a c11712a, C11716e c11716e);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$c */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface c {
        a visitAnnotation(C11712a c11712a, InterfaceC11467u0 interfaceC11467u0);

        void visitEnd();
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$d */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface d {
        c visitField(C11716e c11716e, String str, Object obj);

        e visitMethod(C11716e c11716e, String str);
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.p$e */
    /* JADX INFO: compiled from: KotlinJvmBinaryClass.kt */
    public interface e extends c {
        a visitParameterAnnotation(int i, C11712a c11712a, InterfaceC11467u0 interfaceC11467u0);
    }

    C11636a getClassHeader();

    C11712a getClassId();

    String getLocation();

    void loadClassAnnotations(c cVar, byte[] bArr);

    void visitMembers(d dVar, byte[] bArr);
}
