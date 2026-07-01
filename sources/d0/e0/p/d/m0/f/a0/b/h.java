package d0.e0.p.d.m0.f.a0.b;

import d0.e0.p.d.m0.f.a0.a$b;
import d0.e0.p.d.m0.f.a0.a$c;
import d0.e0.p.d.m0.f.a0.a$d;
import d0.e0.p.d.m0.f.a0.a$e;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.f.z.b$b;
import d0.e0.p.d.m0.i.g$f;
import d0.t.o;
import d0.z.d.m;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;

/* JADX INFO: compiled from: JvmProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class h {
    public static final h a = new h();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final d0.e0.p.d.m0.i.e f3390b;

    static {
        d0.e0.p.d.m0.i.e eVarNewInstance = d0.e0.p.d.m0.i.e.newInstance();
        d0.e0.p.d.m0.f.a0.a.registerAllExtensions(eVarNewInstance);
        m.checkNotNullExpressionValue(eVarNewInstance, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        f3390b = eVarNewInstance;
    }

    public static /* synthetic */ e$a getJvmFieldSignature$default(h hVar, n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return hVar.getJvmFieldSignature(nVar, cVar, gVar, z2);
    }

    public static final boolean isMovedFromInterfaceCompanion(n nVar) {
        m.checkNotNullParameter(nVar, "proto");
        b$b is_moved_from_interface_companion = d.a.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = nVar.getExtension(d0.e0.p.d.m0.f.a0.a.e);
        m.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        m.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    public static final Pair<g, d0.e0.p.d.m0.f.c> readClassDataFrom(String[] strArr, String[] strArr2) {
        m.checkNotNullParameter(strArr, "data");
        m.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = a.decodeBytes(strArr);
        m.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readClassDataFrom(bArrDecodeBytes, strArr2);
    }

    public static final Pair<g, d0.e0.p.d.m0.f.i> readFunctionDataFrom(String[] strArr, String[] strArr2) throws IOException {
        m.checkNotNullParameter(strArr, "data");
        m.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(a.decodeBytes(strArr));
        a$e delimitedFrom = a$e.parseDelimitedFrom(byteArrayInputStream, f3390b);
        m.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Pair<>(new g(delimitedFrom, strArr2), d0.e0.p.d.m0.f.i.parseFrom(byteArrayInputStream, f3390b));
    }

    public static final Pair<g, l> readPackageDataFrom(String[] strArr, String[] strArr2) {
        m.checkNotNullParameter(strArr, "data");
        m.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = a.decodeBytes(strArr);
        m.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(bArrDecodeBytes, strArr2);
    }

    public final String a(q qVar, d0.e0.p.d.m0.f.z.c cVar) {
        if (!qVar.hasClassName()) {
            return null;
        }
        b bVar = b.a;
        return b.mapClass(cVar.getQualifiedClassName(qVar.getClassName()));
    }

    public final d0.e0.p.d.m0.i.e getEXTENSION_REGISTRY() {
        return f3390b;
    }

    public final e$b getJvmConstructorSignature(d0.e0.p.d.m0.f.d dVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar) {
        String strJoinToString$default;
        m.checkNotNullParameter(dVar, "proto");
        m.checkNotNullParameter(cVar, "nameResolver");
        m.checkNotNullParameter(gVar, "typeTable");
        g$f<d0.e0.p.d.m0.f.d, a$c> g_f = d0.e0.p.d.m0.f.a0.a.a;
        m.checkNotNullExpressionValue(g_f, "constructorSignature");
        a$c a_c = (a$c) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(dVar, g_f);
        String string = (a_c == null || !a_c.hasName()) ? "<init>" : cVar.getString(a_c.getName());
        if (a_c == null || !a_c.hasDesc()) {
            List<u> valueParameterList = dVar.getValueParameterList();
            m.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(valueParameterList, 10));
            for (u uVar : valueParameterList) {
                m.checkNotNullExpressionValue(uVar, "it");
                String strA = a(d0.e0.p.d.m0.f.z.f.type(uVar, gVar), cVar);
                if (strA == null) {
                    return null;
                }
                arrayList.add(strA);
            }
            strJoinToString$default = d0.t.u.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strJoinToString$default = cVar.getString(a_c.getDesc());
        }
        return new e$b(string, strJoinToString$default);
    }

    public final e$a getJvmFieldSignature(n nVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar, boolean z2) {
        String strA;
        m.checkNotNullParameter(nVar, "proto");
        m.checkNotNullParameter(cVar, "nameResolver");
        m.checkNotNullParameter(gVar, "typeTable");
        g$f<n, a$d> g_f = d0.e0.p.d.m0.f.a0.a.d;
        m.checkNotNullExpressionValue(g_f, "propertySignature");
        a$d a_d = (a$d) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(nVar, g_f);
        if (a_d == null) {
            return null;
        }
        a$b field = a_d.hasField() ? a_d.getField() : null;
        if (field == null && z2) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? nVar.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strA = a(d0.e0.p.d.m0.f.z.f.returnType(nVar, gVar), cVar);
            if (strA == null) {
                return null;
            }
        } else {
            strA = cVar.getString(field.getDesc());
        }
        return new e$a(cVar.getString(name), strA);
    }

    public final e$b getJvmMethodSignature(d0.e0.p.d.m0.f.i iVar, d0.e0.p.d.m0.f.z.c cVar, d0.e0.p.d.m0.f.z.g gVar) {
        String strStringPlus;
        m.checkNotNullParameter(iVar, "proto");
        m.checkNotNullParameter(cVar, "nameResolver");
        m.checkNotNullParameter(gVar, "typeTable");
        g$f<d0.e0.p.d.m0.f.i, a$c> g_f = d0.e0.p.d.m0.f.a0.a.f3384b;
        m.checkNotNullExpressionValue(g_f, "methodSignature");
        a$c a_c = (a$c) d0.e0.p.d.m0.f.z.e.getExtensionOrNull(iVar, g_f);
        int name = (a_c == null || !a_c.hasName()) ? iVar.getName() : a_c.getName();
        if (a_c == null || !a_c.hasDesc()) {
            List listListOfNotNull = d0.t.n.listOfNotNull(d0.e0.p.d.m0.f.z.f.receiverType(iVar, gVar));
            List<u> valueParameterList = iVar.getValueParameterList();
            m.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(o.collectionSizeOrDefault(valueParameterList, 10));
            for (u uVar : valueParameterList) {
                m.checkNotNullExpressionValue(uVar, "it");
                arrayList.add(d0.e0.p.d.m0.f.z.f.type(uVar, gVar));
            }
            List listPlus = d0.t.u.plus((Collection) listListOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(o.collectionSizeOrDefault(listPlus, 10));
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                String strA = a((q) it.next(), cVar);
                if (strA == null) {
                    return null;
                }
                arrayList2.add(strA);
            }
            String strA2 = a(d0.e0.p.d.m0.f.z.f.returnType(iVar, gVar), cVar);
            if (strA2 == null) {
                return null;
            }
            strStringPlus = m.stringPlus(d0.t.u.joinToString$default(arrayList2, "", "(", ")", 0, null, null, 56, null), strA2);
        } else {
            strStringPlus = cVar.getString(a_c.getDesc());
        }
        return new e$b(cVar.getString(name), strStringPlus);
    }

    public static final Pair<g, d0.e0.p.d.m0.f.c> readClassDataFrom(byte[] bArr, String[] strArr) throws IOException {
        m.checkNotNullParameter(bArr, "bytes");
        m.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        a$e delimitedFrom = a$e.parseDelimitedFrom(byteArrayInputStream, f3390b);
        m.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Pair<>(new g(delimitedFrom, strArr), d0.e0.p.d.m0.f.c.parseFrom(byteArrayInputStream, f3390b));
    }

    public static final Pair<g, l> readPackageDataFrom(byte[] bArr, String[] strArr) throws IOException {
        m.checkNotNullParameter(bArr, "bytes");
        m.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        a$e delimitedFrom = a$e.parseDelimitedFrom(byteArrayInputStream, f3390b);
        m.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Pair<>(new g(delimitedFrom, strArr), l.parseFrom(byteArrayInputStream, f3390b));
    }
}
