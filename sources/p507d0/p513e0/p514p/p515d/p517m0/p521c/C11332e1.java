package p507d0.p513e0.p514p.p515d.p517m0.p521c;

import androidx.core.os.EnvironmentCompat;
import java.util.Map;
import p507d0.p580t.C12134g0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1 */
/* JADX INFO: compiled from: Visibilities.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11332e1 {

    /* JADX INFO: renamed from: a */
    public static final C11332e1 f22694a = new C11332e1();

    /* JADX INFO: renamed from: b */
    public static final Map<AbstractC11335f1, Integer> f22695b;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$a */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class a extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final a f22696c = new a();

        public a() {
            super("inherited", false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$b */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class b extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final b f22697c = new b();

        public b() {
            super("internal", false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$c */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class c extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final c f22698c = new c();

        public c() {
            super("invisible_fake", false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$d */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class d extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final d f22699c = new d();

        public d() {
            super("local", false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$e */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class e extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final e f22700c = new e();

        public e() {
            super("private", false);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$f */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class f extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final f f22701c = new f();

        public f() {
            super("private_to_this", false);
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.AbstractC11335f1
        public String getInternalDisplayName() {
            return "private/*private to this*/";
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$g */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class g extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final g f22702c = new g();

        public g() {
            super("protected", true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$h */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class h extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final h f22703c = new h();

        public h() {
            super("public", true);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.e1$i */
    /* JADX INFO: compiled from: Visibilities.kt */
    public static final class i extends AbstractC11335f1 {

        /* JADX INFO: renamed from: c */
        public static final i f22704c = new i();

        public i() {
            super(EnvironmentCompat.MEDIA_UNKNOWN, false);
        }
    }

    static {
        Map mapCreateMapBuilder = C12134g0.createMapBuilder();
        mapCreateMapBuilder.put(f.f22701c, 0);
        mapCreateMapBuilder.put(e.f22700c, 0);
        mapCreateMapBuilder.put(b.f22697c, 1);
        mapCreateMapBuilder.put(g.f22702c, 1);
        mapCreateMapBuilder.put(h.f22703c, 2);
        f22695b = C12134g0.build(mapCreateMapBuilder);
    }

    public final Integer compareLocal$compiler_common(AbstractC11335f1 abstractC11335f1, AbstractC11335f1 abstractC11335f2) {
        C12238m.checkNotNullParameter(abstractC11335f1, "first");
        C12238m.checkNotNullParameter(abstractC11335f2, "second");
        if (abstractC11335f1 == abstractC11335f2) {
            return 0;
        }
        Map<AbstractC11335f1, Integer> map = f22695b;
        Integer num = map.get(abstractC11335f1);
        Integer num2 = map.get(abstractC11335f2);
        if (num == null || num2 == null || C12238m.areEqual(num, num2)) {
            return null;
        }
        return Integer.valueOf(num.intValue() - num2.intValue());
    }

    public final boolean isPrivate(AbstractC11335f1 abstractC11335f1) {
        C12238m.checkNotNullParameter(abstractC11335f1, "visibility");
        return abstractC11335f1 == e.f22700c || abstractC11335f1 == f.f22701c;
    }
}
