package p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0;

import java.util.List;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11709h;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11710i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.InterfaceC11734n;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.g */
/* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC11862g extends InterfaceC11450m, InterfaceC11474y {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.g$a */
    /* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
    public enum a {
        COMPATIBLE,
        NEEDS_WRAPPER,
        INCOMPATIBLE;

        /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
        public static a[] valuesCustom() {
            a[] aVarArrValuesCustom = values();
            a[] aVarArr = new a[aVarArrValuesCustom.length];
            System.arraycopy(aVarArrValuesCustom, 0, aVarArr, 0, aVarArrValuesCustom.length);
            return aVarArr;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.e0.g$b */
    /* JADX INFO: compiled from: DeserializedMemberDescriptor.kt */
    public static final class b {
        public static List<C11709h> getVersionRequirements(InterfaceC11862g interfaceC11862g) {
            C12238m.checkNotNullParameter(interfaceC11862g, "this");
            return C11709h.f24062a.create(interfaceC11862g.getProto(), interfaceC11862g.getNameResolver(), interfaceC11862g.getVersionRequirementTable());
        }
    }

    InterfaceC11861f getContainerSource();

    InterfaceC11704c getNameResolver();

    InterfaceC11734n getProto();

    C11708g getTypeTable();

    C11710i getVersionRequirementTable();

    List<C11709h> getVersionRequirements();
}
