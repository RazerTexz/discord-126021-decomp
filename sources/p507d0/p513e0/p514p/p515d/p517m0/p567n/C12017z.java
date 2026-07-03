package p507d0.p513e0.p514p.p515d.p517m0.p567n;

import java.util.List;
import java.util.Objects;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11352h;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.n.z */
/* JADX INFO: compiled from: TypeSubstitution.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12017z extends AbstractC12018z0 {

    /* JADX INFO: renamed from: b */
    public final InterfaceC11477z0[] f24896b;

    /* JADX INFO: renamed from: c */
    public final InterfaceC12012w0[] f24897c;

    /* JADX INFO: renamed from: d */
    public final boolean f24898d;

    public /* synthetic */ C12017z(InterfaceC11477z0[] interfaceC11477z0Arr, InterfaceC12012w0[] interfaceC12012w0Arr, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC11477z0Arr, interfaceC12012w0Arr, (i & 4) != 0 ? false : z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean approximateContravariantCapturedTypes() {
        return this.f24898d;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public InterfaceC12012w0 get(AbstractC11913c0 abstractC11913c0) {
        C12238m.checkNotNullParameter(abstractC11913c0, "key");
        InterfaceC11352h declarationDescriptor = abstractC11913c0.getConstructor().getDeclarationDescriptor();
        InterfaceC11477z0 interfaceC11477z0 = declarationDescriptor instanceof InterfaceC11477z0 ? (InterfaceC11477z0) declarationDescriptor : null;
        if (interfaceC11477z0 == null) {
            return null;
        }
        int index = interfaceC11477z0.getIndex();
        InterfaceC11477z0[] interfaceC11477z0Arr = this.f24896b;
        if (index >= interfaceC11477z0Arr.length || !C12238m.areEqual(interfaceC11477z0Arr[index].getTypeConstructor(), interfaceC11477z0.getTypeConstructor())) {
            return null;
        }
        return this.f24897c[index];
    }

    public final InterfaceC12012w0[] getArguments() {
        return this.f24897c;
    }

    public final InterfaceC11477z0[] getParameters() {
        return this.f24896b;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC12018z0
    public boolean isEmpty() {
        return this.f24897c.length == 0;
    }

    public C12017z(InterfaceC11477z0[] interfaceC11477z0Arr, InterfaceC12012w0[] interfaceC12012w0Arr, boolean z2) {
        C12238m.checkNotNullParameter(interfaceC11477z0Arr, "parameters");
        C12238m.checkNotNullParameter(interfaceC12012w0Arr, "arguments");
        this.f24896b = interfaceC11477z0Arr;
        this.f24897c = interfaceC12012w0Arr;
        this.f24898d = z2;
        int length = interfaceC11477z0Arr.length;
        int length2 = interfaceC12012w0Arr.length;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public C12017z(List<? extends InterfaceC11477z0> list, List<? extends InterfaceC12012w0> list2) {
        C12238m.checkNotNullParameter(list, "parameters");
        C12238m.checkNotNullParameter(list2, "argumentsList");
        Object[] array = list.toArray(new InterfaceC11477z0[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        InterfaceC11477z0[] interfaceC11477z0Arr = (InterfaceC11477z0[]) array;
        Object[] array2 = list2.toArray(new InterfaceC12012w0[0]);
        Objects.requireNonNull(array2, "null cannot be cast to non-null type kotlin.Array<T>");
        this(interfaceC11477z0Arr, (InterfaceC12012w0[]) array2, false, 4, null);
    }
}
