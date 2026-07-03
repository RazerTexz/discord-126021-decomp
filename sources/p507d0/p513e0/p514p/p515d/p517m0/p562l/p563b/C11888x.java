package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import p507d0.p512d0.C11226f;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11688m;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.AbstractC11702a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11712a;
import p507d0.p580t.C12134g0;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.x */
/* JADX INFO: compiled from: ProtoBasedClassDataFinder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11888x implements InterfaceC11871g {

    /* JADX INFO: renamed from: a */
    public final InterfaceC11704c f24687a;

    /* JADX INFO: renamed from: b */
    public final AbstractC11702a f24688b;

    /* JADX INFO: renamed from: c */
    public final Function1<C11712a, InterfaceC11467u0> f24689c;

    /* JADX INFO: renamed from: d */
    public final Map<C11712a, C11678c> f24690d;

    /* JADX WARN: Multi-variable type inference failed */
    public C11888x(C11688m c11688m, InterfaceC11704c interfaceC11704c, AbstractC11702a abstractC11702a, Function1<? super C11712a, ? extends InterfaceC11467u0> function1) {
        C12238m.checkNotNullParameter(c11688m, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(abstractC11702a, "metadataVersion");
        C12238m.checkNotNullParameter(function1, "classSource");
        this.f24687a = interfaceC11704c;
        this.f24688b = abstractC11702a;
        this.f24689c = function1;
        List<C11678c> class_List = c11688m.getClass_List();
        C12238m.checkNotNullExpressionValue(class_List, "proto.class_List");
        LinkedHashMap linkedHashMap = new LinkedHashMap(C11226f.coerceAtLeast(C12134g0.mapCapacity(C12149o.collectionSizeOrDefault(class_List, 10)), 16));
        for (Object obj : class_List) {
            linkedHashMap.put(C11887w.getClassId(this.f24687a, ((C11678c) obj).getFqName()), obj);
        }
        this.f24690d = linkedHashMap;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.InterfaceC11871g
    public C11870f findClassData(C11712a c11712a) {
        C12238m.checkNotNullParameter(c11712a, "classId");
        C11678c c11678c = this.f24690d.get(c11712a);
        if (c11678c == null) {
            return null;
        }
        return new C11870f(this.f24687a, c11678c, this.f24688b, this.f24689c.invoke(c11712a));
    }

    public final Collection<C11712a> getAllClassIds() {
        return this.f24690d.keySet();
    }
}
