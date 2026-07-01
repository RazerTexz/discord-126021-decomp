package d0.e0.p.d.m0.b.p;

import androidx.exifinterface.media.ExifInterface;
import d0.e0.p.d.m0.c.c1;
import d0.e0.p.d.m0.c.g1.g;
import d0.e0.p.d.m0.c.i1.l0;
import d0.e0.p.d.m0.c.q0;
import d0.e0.p.d.m0.c.t;
import d0.e0.p.d.m0.c.u0;
import d0.e0.p.d.m0.c.z0;
import d0.e0.p.d.m0.n.c0;
import d0.e0.p.d.m0.n.j0;
import d0.e0.p.d.m0.n.j1;
import d0.t.n;
import d0.t.o;
import d0.t.u;
import d0.t.z;
import d0.z.d.m;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FunctionInvokeDescriptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class e$a {
    public e$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final e create(b bVar, boolean z2) {
        String lowerCase;
        m.checkNotNullParameter(bVar, "functionClass");
        List<z0> declaredTypeParameters = bVar.getDeclaredTypeParameters();
        e eVar = new e(bVar, null, d0.e0.p.d.m0.c.b$a.DECLARATION, z2, null);
        q0 thisAsReceiverParameter = bVar.getThisAsReceiverParameter();
        List<? extends z0> listEmptyList = n.emptyList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : declaredTypeParameters) {
            if (!(((z0) obj).getVariance() == j1.IN_VARIANCE)) {
                break;
            }
            arrayList.add(obj);
        }
        Iterable<z> iterableWithIndex = u.withIndex(arrayList);
        ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(iterableWithIndex, 10));
        for (z zVar : iterableWithIndex) {
            int index = zVar.getIndex();
            z0 z0Var = (z0) zVar.getValue();
            String strAsString = z0Var.getName().asString();
            m.checkNotNullExpressionValue(strAsString, "typeParameter.name.asString()");
            if (m.areEqual(strAsString, ExifInterface.GPS_DIRECTION_TRUE)) {
                lowerCase = "instance";
            } else if (m.areEqual(strAsString, ExifInterface.LONGITUDE_EAST)) {
                lowerCase = "receiver";
            } else {
                lowerCase = strAsString.toLowerCase();
                m.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            }
            g empty = g.f.getEMPTY();
            d0.e0.p.d.m0.g.e eVarIdentifier = d0.e0.p.d.m0.g.e.identifier(lowerCase);
            m.checkNotNullExpressionValue(eVarIdentifier, "identifier(name)");
            j0 defaultType = z0Var.getDefaultType();
            m.checkNotNullExpressionValue(defaultType, "typeParameter.defaultType");
            u0 u0Var = u0.a;
            m.checkNotNullExpressionValue(u0Var, "NO_SOURCE");
            ArrayList arrayList3 = arrayList2;
            arrayList3.add(new l0(eVar, null, index, empty, eVarIdentifier, defaultType, false, false, false, null, u0Var));
            arrayList2 = arrayList3;
        }
        eVar.initialize((q0) null, thisAsReceiverParameter, listEmptyList, (List<c1>) arrayList2, (c0) ((z0) u.last((List) declaredTypeParameters)).getDefaultType(), d0.e0.p.d.m0.c.z.ABSTRACT, t.e);
        eVar.setHasSynthesizedParameterNames(true);
        return eVar;
    }
}
