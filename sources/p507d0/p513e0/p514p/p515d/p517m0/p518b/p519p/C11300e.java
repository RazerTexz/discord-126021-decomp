package p507d0.p513e0.p514p.p515d.p517m0.p518b.p519p;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import p507d0.p513e0.p514p.p515d.p517m0.p518b.C11287g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.C11464t;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.EnumC11476z;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11321b;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11326c1;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11450m;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11459q0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11467u0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11477z0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p522g1.InterfaceC11344g;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11384l0;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11913c0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.AbstractC11934j0;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.C11914c1;
import p507d0.p513e0.p514p.p515d.p517m0.p567n.EnumC11935j1;
import p507d0.p513e0.p514p.p515d.p517m0.p573o.C12028j;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p580t.C12168z;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.e */
/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11300e extends C11374g0 {

    /* JADX INFO: renamed from: M */
    public static final a f22609M = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.b.p.e$a */
    /* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11300e create(C11297b c11297b, boolean z2) {
            String lowerCase;
            C12238m.checkNotNullParameter(c11297b, "functionClass");
            List<InterfaceC11477z0> declaredTypeParameters = c11297b.getDeclaredTypeParameters();
            C11300e c11300e = new C11300e(c11297b, null, InterfaceC11321b.a.DECLARATION, z2, null);
            InterfaceC11459q0 thisAsReceiverParameter = c11297b.getThisAsReceiverParameter();
            List<? extends InterfaceC11477z0> listEmptyList = C12147n.emptyList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : declaredTypeParameters) {
                if (!(((InterfaceC11477z0) obj).getVariance() == EnumC11935j1.IN_VARIANCE)) {
                    break;
                }
                arrayList.add(obj);
            }
            Iterable<C12168z> iterableWithIndex = C12163u.withIndex(arrayList);
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(iterableWithIndex, 10));
            for (C12168z c12168z : iterableWithIndex) {
                int index = c12168z.getIndex();
                InterfaceC11477z0 interfaceC11477z0 = (InterfaceC11477z0) c12168z.getValue();
                String strAsString = interfaceC11477z0.getName().asString();
                C12238m.checkNotNullExpressionValue(strAsString, "typeParameter.name.asString()");
                if (C12238m.areEqual(strAsString, ExifInterface.GPS_DIRECTION_TRUE)) {
                    lowerCase = "instance";
                } else if (C12238m.areEqual(strAsString, ExifInterface.LONGITUDE_EAST)) {
                    lowerCase = "receiver";
                } else {
                    lowerCase = strAsString.toLowerCase();
                    C12238m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
                }
                InterfaceC11344g empty = InterfaceC11344g.f22735f.getEMPTY();
                C11716e c11716eIdentifier = C11716e.identifier(lowerCase);
                C12238m.checkNotNullExpressionValue(c11716eIdentifier, "identifier(name)");
                AbstractC11934j0 defaultType = interfaceC11477z0.getDefaultType();
                C12238m.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
                InterfaceC11467u0 interfaceC11467u0 = InterfaceC11467u0.f23099a;
                C12238m.checkNotNullExpressionValue(interfaceC11467u0, "NO_SOURCE");
                ArrayList arrayList3 = arrayList2;
                arrayList3.add(new C11384l0(c11300e, null, index, empty, c11716eIdentifier, defaultType, false, false, false, null, interfaceC11467u0));
                arrayList2 = arrayList3;
            }
            c11300e.initialize((InterfaceC11459q0) null, thisAsReceiverParameter, listEmptyList, (List<InterfaceC11326c1>) arrayList2, (AbstractC11913c0) ((InterfaceC11477z0) C12163u.last((List) declaredTypeParameters)).getDefaultType(), EnumC11476z.ABSTRACT, C11464t.f23087e);
            c11300e.setHasSynthesizedParameterNames(true);
            return c11300e;
        }
    }

    public C11300e(InterfaceC11450m interfaceC11450m, C11300e c11300e, InterfaceC11321b.a aVar, boolean z2) {
        super(interfaceC11450m, c11300e, InterfaceC11344g.f22735f.getEMPTY(), C12028j.f24936g, aVar, InterfaceC11467u0.f23099a);
        setOperator(true);
        setSuspend(z2);
        setHasStableParameterNames(false);
    }

    public /* synthetic */ C11300e(InterfaceC11450m interfaceC11450m, C11300e c11300e, InterfaceC11321b.a aVar, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        this(interfaceC11450m, c11300e, aVar, z2);
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.C11374g0, p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: b */
    public AbstractC11391q mo9373b(InterfaceC11450m interfaceC11450m, InterfaceC11472x interfaceC11472x, InterfaceC11321b.a aVar, C11716e c11716e, InterfaceC11344g interfaceC11344g, InterfaceC11467u0 interfaceC11467u0) {
        C12238m.checkNotNullParameter(interfaceC11450m, "newOwner");
        C12238m.checkNotNullParameter(aVar, "kind");
        C12238m.checkNotNullParameter(interfaceC11344g, "annotations");
        C12238m.checkNotNullParameter(interfaceC11467u0, "source");
        return new C11300e(interfaceC11450m, (C11300e) interfaceC11472x, aVar, isSuspend());
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q
    /* JADX INFO: renamed from: c */
    public InterfaceC11472x mo9374c(AbstractC11391q.c cVar) {
        boolean z2;
        C11716e c11716e;
        C12238m.checkNotNullParameter(cVar, "configuration");
        C11300e c11300e = (C11300e) super.mo9374c(cVar);
        if (c11300e == null) {
            return null;
        }
        List<InterfaceC11326c1> valueParameters = c11300e.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters, "substituted.valueParameters");
        boolean z3 = true;
        if (!(valueParameters instanceof Collection) || !valueParameters.isEmpty()) {
            Iterator<T> it = valueParameters.iterator();
            while (true) {
                if (!it.hasNext()) {
                    z2 = true;
                    break;
                }
                AbstractC11913c0 type = ((InterfaceC11326c1) it.next()).getType();
                C12238m.checkNotNullExpressionValue(type, "it.type");
                if (C11287g.extractParameterNameFromFunctionTypeArgument(type) != null) {
                    z2 = false;
                    break;
                }
            }
        } else {
            z2 = true;
            break;
        }
        if (z2) {
            return c11300e;
        }
        List<InterfaceC11326c1> valueParameters2 = c11300e.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters2, "substituted.valueParameters");
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(valueParameters2, 10));
        Iterator<T> it2 = valueParameters2.iterator();
        while (it2.hasNext()) {
            AbstractC11913c0 type2 = ((InterfaceC11326c1) it2.next()).getType();
            C12238m.checkNotNullExpressionValue(type2, "it.type");
            arrayList.add(C11287g.extractParameterNameFromFunctionTypeArgument(type2));
        }
        int size = c11300e.getValueParameters().size() - arrayList.size();
        List<InterfaceC11326c1> valueParameters3 = c11300e.getValueParameters();
        C12238m.checkNotNullExpressionValue(valueParameters3, "valueParameters");
        ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(valueParameters3, 10));
        for (InterfaceC11326c1 interfaceC11326c1 : valueParameters3) {
            C11716e name = interfaceC11326c1.getName();
            C12238m.checkNotNullExpressionValue(name, "it.name");
            int index = interfaceC11326c1.getIndex();
            int i = index - size;
            if (i >= 0 && (c11716e = (C11716e) arrayList.get(i)) != null) {
                name = c11716e;
            }
            arrayList2.add(interfaceC11326c1.copy(c11300e, name, index));
        }
        AbstractC11391q.c cVarM9425d = c11300e.m9425d(C11914c1.f24745a);
        if (arrayList.isEmpty()) {
            z3 = false;
        } else {
            Iterator it3 = arrayList.iterator();
            while (it3.hasNext()) {
                if (((C11716e) it3.next()) == null) {
                }
            }
            z3 = false;
        }
        AbstractC11391q.c original = cVarM9425d.setHasSynthesizedParameterNames(z3).setValueParameters((List<InterfaceC11326c1>) arrayList2).setOriginal((InterfaceC11321b) c11300e.getOriginal());
        C12238m.checkNotNullExpressionValue(original, "newCopyBuilder(TypeSubstitutor.EMPTY)\n                .setHasSynthesizedParameterNames(parameterNames.any { it == null })\n                .setValueParameters(newValueParameters)\n                .setOriginal(original)");
        InterfaceC11472x interfaceC11472xMo9374c = super.mo9374c(original);
        C12238m.checkNotNull(interfaceC11472xMo9374c);
        return interfaceC11472xMo9374c;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11474y
    public boolean isExternal() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isInline() {
        return false;
    }

    @Override // p507d0.p513e0.p514p.p515d.p517m0.p521c.p524i1.AbstractC11391q, p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11472x
    public boolean isTailrec() {
        return false;
    }
}
