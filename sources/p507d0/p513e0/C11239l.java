package p507d0.p513e0;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KType;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.C12111j;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.l */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11239l implements TypeVariable<GenericDeclaration>, Type {

    /* JADX INFO: renamed from: j */
    public final InterfaceC11235h f22312j;

    public C11239l(InterfaceC11235h interfaceC11235h) {
        C12238m.checkNotNullParameter(interfaceC11235h, "typeParameter");
        this.f22312j = interfaceC11235h;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (C12238m.areEqual(getName(), typeVariable.getName()) && C12238m.areEqual(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List<KType> upperBounds = this.f22312j.getUpperBounds();
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(C11241n.m9328a((KType) it.next(), true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        StringBuilder sbM833U = C1643a.m833U("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        sbM833U.append(this.f22312j);
        throw new C12111j(C1643a.m883w("An operation is not implemented: ", sbM833U.toString()));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.f22312j.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
