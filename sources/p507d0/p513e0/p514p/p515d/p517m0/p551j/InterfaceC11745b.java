package p507d0.p513e0.p514p.p515d.p517m0.p551j;

import java.util.ArrayList;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11714c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.C11787e;
import p507d0.p580t.C12161s;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.j.b */
/* JADX INFO: compiled from: ClassifierNamePolicy.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11745b {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$a */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class a implements InterfaceC11745b {

        /* JADX INFO: renamed from: a */
        public static final a f24222a = new a();

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11745b
        public String renderClassifier(InterfaceC11352h interfaceC11352h, AbstractC11746c abstractC11746c) {
            C12238m.checkNotNullParameter(interfaceC11352h, "classifier");
            C12238m.checkNotNullParameter(abstractC11746c, "renderer");
            if (interfaceC11352h instanceof InterfaceC11477z0) {
                C11716e name = ((InterfaceC11477z0) interfaceC11352h).getName();
                C12238m.checkNotNullExpressionValue(name, "classifier.name");
                return abstractC11746c.renderName(name, false);
            }
            C11714c fqName = C11787e.getFqName(interfaceC11352h);
            C12238m.checkNotNullExpressionValue(fqName, "getFqName(classifier)");
            return abstractC11746c.renderFqName(fqName);
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$b */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class b implements InterfaceC11745b {

        /* JADX INFO: renamed from: a */
        public static final b f24223a = new b();

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [d0.e0.p.d.m0.c.h, java.lang.Object] */
        /* JADX WARN: Type inference failed for: r2v1, types: [d0.e0.p.d.m0.c.m] */
        /* JADX WARN: Type inference failed for: r2v2, types: [d0.e0.p.d.m0.c.m] */
        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11745b
        public String renderClassifier(InterfaceC11352h interfaceC11352h, AbstractC11746c abstractC11746c) {
            C12238m.checkNotNullParameter(interfaceC11352h, "classifier");
            C12238m.checkNotNullParameter(abstractC11746c, "renderer");
            if (interfaceC11352h instanceof InterfaceC11477z0) {
                C11716e name = ((InterfaceC11477z0) interfaceC11352h).getName();
                C12238m.checkNotNullExpressionValue(name, "classifier.name");
                return abstractC11746c.renderName(name, false);
            }
            ArrayList arrayList = new ArrayList();
            do {
                arrayList.add(interfaceC11352h.getName());
                interfaceC11352h = interfaceC11352h.getContainingDeclaration();
            } while (interfaceC11352h instanceof InterfaceC11330e);
            return C11760q.renderFqName(C12161s.asReversedMutable(arrayList));
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.j.b$c */
    /* JADX INFO: compiled from: ClassifierNamePolicy.kt */
    public static final class c implements InterfaceC11745b {

        /* JADX INFO: renamed from: a */
        public static final c f24224a = new c();

        /* JADX INFO: renamed from: a */
        public final String m9869a(InterfaceC11352h interfaceC11352h) {
            String strRender;
            C11716e name = interfaceC11352h.getName();
            C12238m.checkNotNullExpressionValue(name, "descriptor.name");
            String strRender2 = C11760q.render(name);
            if (interfaceC11352h instanceof InterfaceC11477z0) {
                return strRender2;
            }
            InterfaceC11450m containingDeclaration = interfaceC11352h.getContainingDeclaration();
            C12238m.checkNotNullExpressionValue(containingDeclaration, "descriptor.containingDeclaration");
            if (containingDeclaration instanceof InterfaceC11330e) {
                strRender = m9869a((InterfaceC11352h) containingDeclaration);
            } else if (containingDeclaration instanceof InterfaceC11331e0) {
                C11714c unsafe = ((InterfaceC11331e0) containingDeclaration).getFqName().toUnsafe();
                C12238m.checkNotNullExpressionValue(unsafe, "descriptor.fqName.toUnsafe()");
                strRender = C11760q.render(unsafe);
            } else {
                strRender = null;
            }
            if (strRender == null || C12238m.areEqual(strRender, "")) {
                return strRender2;
            }
            return ((Object) strRender) + '.' + strRender2;
        }

        @Override // p507d0.p513e0.p514p.p515d.p517m0.p551j.InterfaceC11745b
        public String renderClassifier(InterfaceC11352h interfaceC11352h, AbstractC11746c abstractC11746c) {
            C12238m.checkNotNullParameter(interfaceC11352h, "classifier");
            C12238m.checkNotNullParameter(abstractC11746c, "renderer");
            return m9869a(interfaceC11352h);
        }
    }

    String renderClassifier(InterfaceC11352h interfaceC11352h, AbstractC11746c abstractC11746c);
}
