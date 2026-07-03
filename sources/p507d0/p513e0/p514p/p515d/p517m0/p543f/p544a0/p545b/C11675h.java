package p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11679d;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11684i;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11689n;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11692q;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11696u;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.C11667a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.AbstractC11672e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11703b;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11706e;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11707f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.C11708g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p547z.InterfaceC11704c;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.AbstractC11727g;
import p507d0.p513e0.p514p.p515d.p517m0.p550i.C11725e;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12149o;
import p507d0.p580t.C12163u;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.h */
/* JADX INFO: compiled from: JvmProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11675h {

    /* JADX INFO: renamed from: a */
    public static final C11675h f23720a = new C11675h();

    /* JADX INFO: renamed from: b */
    public static final C11725e f23721b;

    static {
        C11725e c11725eNewInstance = C11725e.newInstance();
        C11667a.registerAllExtensions(c11725eNewInstance);
        C12238m.checkNotNullExpressionValue(c11725eNewInstance, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        f23721b = c11725eNewInstance;
    }

    public static /* synthetic */ AbstractC11672e.a getJvmFieldSignature$default(C11675h c11675h, C11689n c11689n, InterfaceC11704c interfaceC11704c, C11708g c11708g, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return c11675h.getJvmFieldSignature(c11689n, interfaceC11704c, c11708g, z2);
    }

    public static final boolean isMovedFromInterfaceCompanion(C11689n c11689n) {
        C12238m.checkNotNullParameter(c11689n, "proto");
        C11703b.b is_moved_from_interface_companion = C11671d.f23704a.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = c11689n.getExtension(C11667a.f23655e);
        C12238m.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        C12238m.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    public static final Pair<C11674g, C11678c> readClassDataFrom(String[] strArr, String[] strArr2) {
        C12238m.checkNotNullParameter(strArr, "data");
        C12238m.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = C11668a.decodeBytes(strArr);
        C12238m.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readClassDataFrom(bArrDecodeBytes, strArr2);
    }

    public static final Pair<C11674g, C11684i> readFunctionDataFrom(String[] strArr, String[] strArr2) throws IOException {
        C12238m.checkNotNullParameter(strArr, "data");
        C12238m.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(C11668a.decodeBytes(strArr));
        C11667a.e delimitedFrom = C11667a.e.parseDelimitedFrom(byteArrayInputStream, f23721b);
        C12238m.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Pair<>(new C11674g(delimitedFrom, strArr2), C11684i.parseFrom(byteArrayInputStream, f23721b));
    }

    public static final Pair<C11674g, C11687l> readPackageDataFrom(String[] strArr, String[] strArr2) {
        C12238m.checkNotNullParameter(strArr, "data");
        C12238m.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = C11668a.decodeBytes(strArr);
        C12238m.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(bArrDecodeBytes, strArr2);
    }

    /* JADX INFO: renamed from: a */
    public final String m9586a(C11692q c11692q, InterfaceC11704c interfaceC11704c) {
        if (!c11692q.hasClassName()) {
            return null;
        }
        C11669b c11669b = C11669b.f23700a;
        return C11669b.mapClass(interfaceC11704c.getQualifiedClassName(c11692q.getClassName()));
    }

    public final C11725e getEXTENSION_REGISTRY() {
        return f23721b;
    }

    public final AbstractC11672e.b getJvmConstructorSignature(C11679d c11679d, InterfaceC11704c interfaceC11704c, C11708g c11708g) {
        String strJoinToString$default;
        C12238m.checkNotNullParameter(c11679d, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        AbstractC11727g.f<C11679d, C11667a.c> fVar = C11667a.f23651a;
        C12238m.checkNotNullExpressionValue(fVar, "constructorSignature");
        C11667a.c cVar = (C11667a.c) C11706e.getExtensionOrNull(c11679d, fVar);
        String string = (cVar == null || !cVar.hasName()) ? "<init>" : interfaceC11704c.getString(cVar.getName());
        if (cVar == null || !cVar.hasDesc()) {
            List<C11696u> valueParameterList = c11679d.getValueParameterList();
            C12238m.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(valueParameterList, 10));
            for (C11696u c11696u : valueParameterList) {
                C12238m.checkNotNullExpressionValue(c11696u, "it");
                String strM9586a = m9586a(C11707f.type(c11696u, c11708g), interfaceC11704c);
                if (strM9586a == null) {
                    return null;
                }
                arrayList.add(strM9586a);
            }
            strJoinToString$default = C12163u.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strJoinToString$default = interfaceC11704c.getString(cVar.getDesc());
        }
        return new AbstractC11672e.b(string, strJoinToString$default);
    }

    public final AbstractC11672e.a getJvmFieldSignature(C11689n c11689n, InterfaceC11704c interfaceC11704c, C11708g c11708g, boolean z2) {
        String strM9586a;
        C12238m.checkNotNullParameter(c11689n, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        AbstractC11727g.f<C11689n, C11667a.d> fVar = C11667a.f23654d;
        C12238m.checkNotNullExpressionValue(fVar, "propertySignature");
        C11667a.d dVar = (C11667a.d) C11706e.getExtensionOrNull(c11689n, fVar);
        if (dVar == null) {
            return null;
        }
        C11667a.b field = dVar.hasField() ? dVar.getField() : null;
        if (field == null && z2) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? c11689n.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strM9586a = m9586a(C11707f.returnType(c11689n, c11708g), interfaceC11704c);
            if (strM9586a == null) {
                return null;
            }
        } else {
            strM9586a = interfaceC11704c.getString(field.getDesc());
        }
        return new AbstractC11672e.a(interfaceC11704c.getString(name), strM9586a);
    }

    public final AbstractC11672e.b getJvmMethodSignature(C11684i c11684i, InterfaceC11704c interfaceC11704c, C11708g c11708g) {
        String strStringPlus;
        C12238m.checkNotNullParameter(c11684i, "proto");
        C12238m.checkNotNullParameter(interfaceC11704c, "nameResolver");
        C12238m.checkNotNullParameter(c11708g, "typeTable");
        AbstractC11727g.f<C11684i, C11667a.c> fVar = C11667a.f23652b;
        C12238m.checkNotNullExpressionValue(fVar, "methodSignature");
        C11667a.c cVar = (C11667a.c) C11706e.getExtensionOrNull(c11684i, fVar);
        int name = (cVar == null || !cVar.hasName()) ? c11684i.getName() : cVar.getName();
        if (cVar == null || !cVar.hasDesc()) {
            List listListOfNotNull = C12147n.listOfNotNull(C11707f.receiverType(c11684i, c11708g));
            List<C11696u> valueParameterList = c11684i.getValueParameterList();
            C12238m.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(valueParameterList, 10));
            for (C11696u c11696u : valueParameterList) {
                C12238m.checkNotNullExpressionValue(c11696u, "it");
                arrayList.add(C11707f.type(c11696u, c11708g));
            }
            List listPlus = C12163u.plus((Collection) listListOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(C12149o.collectionSizeOrDefault(listPlus, 10));
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                String strM9586a = m9586a((C11692q) it.next(), interfaceC11704c);
                if (strM9586a == null) {
                    return null;
                }
                arrayList2.add(strM9586a);
            }
            String strM9586a2 = m9586a(C11707f.returnType(c11684i, c11708g), interfaceC11704c);
            if (strM9586a2 == null) {
                return null;
            }
            strStringPlus = C12238m.stringPlus(C12163u.joinToString$default(arrayList2, "", "(", ")", 0, null, null, 56, null), strM9586a2);
        } else {
            strStringPlus = interfaceC11704c.getString(cVar.getDesc());
        }
        return new AbstractC11672e.b(interfaceC11704c.getString(name), strStringPlus);
    }

    public static final Pair<C11674g, C11678c> readClassDataFrom(byte[] bArr, String[] strArr) throws IOException {
        C12238m.checkNotNullParameter(bArr, "bytes");
        C12238m.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        C11667a.e delimitedFrom = C11667a.e.parseDelimitedFrom(byteArrayInputStream, f23721b);
        C12238m.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Pair<>(new C11674g(delimitedFrom, strArr), C11678c.parseFrom(byteArrayInputStream, f23721b));
    }

    public static final Pair<C11674g, C11687l> readPackageDataFrom(byte[] bArr, String[] strArr) throws IOException {
        C12238m.checkNotNullParameter(bArr, "bytes");
        C12238m.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        C11667a.e delimitedFrom = C11667a.e.parseDelimitedFrom(byteArrayInputStream, f23721b);
        C12238m.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Pair<>(new C11674g(delimitedFrom, strArr), C11687l.parseFrom(byteArrayInputStream, f23721b));
    }
}
