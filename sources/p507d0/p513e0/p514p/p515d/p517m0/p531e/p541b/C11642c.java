package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import com.discord.models.domain.ModelAuditLogEntry;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11328d0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11470w;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11325c0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.C11341d;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11340c;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p532a.p533g0.C11498a;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11815g;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.AbstractC11819k;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11807a;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11814f;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11816h;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11818j;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p557v.C11826r;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11855e;
import p507d0.p513e0.p514p.p515d.p517m0.p566m.InterfaceC11905o;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p576p.C12033a;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c */
/* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11642c extends AbstractC11633a<InterfaceC11340c, AbstractC11815g<?>> {

    /* JADX INFO: renamed from: c */
    public final InterfaceC11325c0 f23585c;

    /* JADX INFO: renamed from: d */
    public final C11328d0 f23586d;

    /* JADX INFO: renamed from: e */
    public final C11855e f23587e;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a */
    /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
    public static final class a implements InterfaceC11655p.a {

        /* JADX INFO: renamed from: a */
        public final HashMap<C11716e, AbstractC11815g<?>> f23588a = new HashMap<>();

        /* JADX INFO: renamed from: b */
        public final /* synthetic */ InterfaceC11330e f23589b;

        /* JADX INFO: renamed from: c */
        public final /* synthetic */ C11642c f23590c;

        /* JADX INFO: renamed from: d */
        public final /* synthetic */ List<InterfaceC11340c> f23591d;

        /* JADX INFO: renamed from: e */
        public final /* synthetic */ InterfaceC11467u0 f23592e;

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class C13315a implements InterfaceC11655p.a {

            /* JADX INFO: renamed from: a */
            public final /* synthetic */ InterfaceC11655p.a f23593a;

            /* JADX INFO: renamed from: b */
            public final /* synthetic */ InterfaceC11655p.a f23594b;

            /* JADX INFO: renamed from: c */
            public final /* synthetic */ a f23595c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ C11716e f23596d;

            /* JADX INFO: renamed from: e */
            public final /* synthetic */ ArrayList<InterfaceC11340c> f23597e;

            public C13315a(InterfaceC11655p.a aVar, a aVar2, C11716e c11716e, ArrayList<InterfaceC11340c> arrayList) {
                this.f23594b = aVar;
                this.f23595c = aVar2;
                this.f23596d = c11716e;
                this.f23597e = arrayList;
                this.f23593a = aVar;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
            public void visit(C11716e c11716e, Object obj) {
                this.f23593a.visit(c11716e, obj);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
            public InterfaceC11655p.a visitAnnotation(C11716e c11716e, C11712a c11712a) {
                C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkNotNullParameter(c11712a, "classId");
                return this.f23593a.visitAnnotation(c11716e, c11712a);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
            public InterfaceC11655p.b visitArray(C11716e c11716e) {
                C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
                return this.f23593a.visitArray(c11716e);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
            public void visitClassLiteral(C11716e c11716e, C11814f c11814f) {
                C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkNotNullParameter(c11814f, "value");
                this.f23593a.visitClassLiteral(c11716e, c11814f);
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
            public void visitEnd() {
                this.f23594b.visitEnd();
                this.f23595c.f23588a.put(this.f23596d, new C11807a((InterfaceC11340c) C12163u.single((List) this.f23597e)));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
            public void visitEnum(C11716e c11716e, C11712a c11712a, C11716e c11716e2) {
                C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
                C12238m.checkNotNullParameter(c11712a, "enumClassId");
                C12238m.checkNotNullParameter(c11716e2, "enumEntryName");
                this.f23593a.visitEnum(c11716e, c11712a, c11716e2);
            }
        }

        /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.c$a$b */
        /* JADX INFO: compiled from: BinaryClassAnnotationAndConstantLoaderImpl.kt */
        public static final class b implements InterfaceC11655p.b {

            /* JADX INFO: renamed from: a */
            public final ArrayList<AbstractC11815g<?>> f23598a = new ArrayList<>();

            /* JADX INFO: renamed from: c */
            public final /* synthetic */ C11716e f23600c;

            /* JADX INFO: renamed from: d */
            public final /* synthetic */ InterfaceC11330e f23601d;

            public b(C11716e c11716e, InterfaceC11330e interfaceC11330e) {
                this.f23600c = c11716e;
                this.f23601d = interfaceC11330e;
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
            public void visit(Object obj) {
                this.f23598a.add(a.this.m9544a(this.f23600c, obj));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
            public void visitClassLiteral(C11814f c11814f) {
                C12238m.checkNotNullParameter(c11814f, "value");
                this.f23598a.add(new C11826r(c11814f));
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
            public void visitEnd() {
                InterfaceC11326c1 annotationParameterByName = C11498a.getAnnotationParameterByName(this.f23600c, this.f23601d);
                if (annotationParameterByName != null) {
                    HashMap map = a.this.f23588a;
                    C11716e c11716e = this.f23600c;
                    C11816h c11816h = C11816h.f24439a;
                    List<? extends AbstractC11815g<?>> listCompact = C12033a.compact(this.f23598a);
                    AbstractC11913c0 type = annotationParameterByName.getType();
                    C12238m.checkNotNullExpressionValue(type, "parameter.type");
                    map.put(c11716e, c11816h.createArrayValue(listCompact, type));
                }
            }

            @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.b
            public void visitEnum(C11712a c11712a, C11716e c11716e) {
                C12238m.checkNotNullParameter(c11712a, "enumClassId");
                C12238m.checkNotNullParameter(c11716e, "enumEntryName");
                this.f23598a.add(new C11818j(c11712a, c11716e));
            }
        }

        public a(InterfaceC11330e interfaceC11330e, C11642c c11642c, List<InterfaceC11340c> list, InterfaceC11467u0 interfaceC11467u0) {
            this.f23589b = interfaceC11330e;
            this.f23590c = c11642c;
            this.f23591d = list;
            this.f23592e = interfaceC11467u0;
        }

        /* JADX INFO: renamed from: a */
        public final AbstractC11815g<?> m9544a(C11716e c11716e, Object obj) {
            AbstractC11815g<?> abstractC11815gCreateConstantValue = C11816h.f24439a.createConstantValue(obj);
            return abstractC11815gCreateConstantValue == null ? AbstractC11819k.f24442b.create(C12238m.stringPlus("Unsupported annotation argument: ", c11716e)) : abstractC11815gCreateConstantValue;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visit(C11716e c11716e, Object obj) {
            if (c11716e != null) {
                this.f23588a.put(c11716e, m9544a(c11716e, obj));
            }
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public InterfaceC11655p.a visitAnnotation(C11716e c11716e, C11712a c11712a) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(c11712a, "classId");
            ArrayList arrayList = new ArrayList();
            C11642c c11642c = this.f23590c;
            InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
            C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
            InterfaceC11655p.a aVarMo9535h = c11642c.mo9535h(c11712a, interfaceC11467u0, arrayList);
            C12238m.checkNotNull(aVarMo9535h);
            return new C13315a(aVarMo9535h, this, c11716e, arrayList);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public InterfaceC11655p.b visitArray(C11716e c11716e) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            return new b(c11716e, this.f23589b);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitClassLiteral(C11716e c11716e, C11814f c11814f) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(c11814f, "value");
            this.f23588a.put(c11716e, new C11826r(c11814f));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitEnd() {
            this.f23591d.add(new C11341d(this.f23589b.getDefaultType(), this.f23588a, this.f23592e));
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.InterfaceC11655p.a
        public void visitEnum(C11716e c11716e, C11712a c11712a, C11716e c11716e2) {
            C12238m.checkNotNullParameter(c11716e, ModelAuditLogEntry.CHANGE_KEY_NAME);
            C12238m.checkNotNullParameter(c11712a, "enumClassId");
            C12238m.checkNotNullParameter(c11716e2, "enumEntryName");
            this.f23588a.put(c11716e, new C11818j(c11712a, c11716e2));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C11642c(InterfaceC11325c0 interfaceC11325c0, C11328d0 c11328d0, InterfaceC11905o interfaceC11905o, InterfaceC11653n interfaceC11653n) {
        super(interfaceC11905o, interfaceC11653n);
        C12238m.checkNotNullParameter(interfaceC11325c0, "module");
        C12238m.checkNotNullParameter(c11328d0, "notFoundClasses");
        C12238m.checkNotNullParameter(interfaceC11905o, "storageManager");
        C12238m.checkNotNullParameter(interfaceC11653n, "kotlinClassFinder");
        this.f23585c = interfaceC11325c0;
        this.f23586d = c11328d0;
        this.f23587e = new C11855e(interfaceC11325c0, c11328d0);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.AbstractC11633a
    /* JADX INFO: renamed from: h */
    public InterfaceC11655p.a mo9535h(C11712a c11712a, InterfaceC11467u0 interfaceC11467u0, List<InterfaceC11340c> list) {
        C12238m.checkNotNullParameter(c11712a, "annotationClassId");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        C12238m.checkNotNullParameter(list, "result");
        return new a(C11470w.findNonGenericClassAcrossDependencies(this.f23585c, c11712a, this.f23586d), this, list, interfaceC11467u0);
    }
}
