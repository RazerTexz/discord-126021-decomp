package d0.e0;

import b.d.b.a.outline;
import d0.Standard2;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import kotlin.reflect.KType;

/* JADX INFO: renamed from: d0.e0.l, reason: use source file name */
/* JADX INFO: compiled from: TypesJVM.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class TypesJVM3 implements TypeVariable<GenericDeclaration>, Type {
    public final KTypeParameter j;

    public TypesJVM3(KTypeParameter kTypeParameter) {
        Intrinsics3.checkNotNullParameter(kTypeParameter, "typeParameter");
        this.j = kTypeParameter;
    }

    public boolean equals(Object obj) {
        if (obj instanceof TypeVariable) {
            TypeVariable typeVariable = (TypeVariable) obj;
            if (Intrinsics3.areEqual(getName(), typeVariable.getName()) && Intrinsics3.areEqual(getGenericDeclaration(), typeVariable.getGenericDeclaration())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        List<KType> upperBounds = this.j.getUpperBounds();
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(upperBounds, 10));
        Iterator<T> it = upperBounds.iterator();
        while (it.hasNext()) {
            arrayList.add(TypesJVM5.a((KType) it.next(), true));
        }
        Object[] array = arrayList.toArray(new Type[0]);
        Objects.requireNonNull(array, "null cannot be cast to non-null type kotlin.Array<T>");
        return (Type[]) array;
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        StringBuilder sbU = outline.U("getGenericDeclaration() is not yet supported for type variables created from KType: ");
        sbU.append(this.j);
        throw new Standard2(outline.w("An operation is not implemented: ", sbU.toString()));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.j.getName();
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
