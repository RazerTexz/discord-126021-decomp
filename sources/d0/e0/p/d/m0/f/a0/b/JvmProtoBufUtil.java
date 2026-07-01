package d0.e0.p.d.m0.f.a0.b;

import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmMemberSignature;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.f.z.Flags2;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.f.z.TypeTable;
import d0.e0.p.d.m0.f.z.protoTypeTableUtil;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.t.Collections2;
import d0.t.Iterables2;
import d0.t._Collections;
import d0.z.d.Intrinsics3;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Tuples2;

/* JADX INFO: renamed from: d0.e0.p.d.m0.f.a0.b.h, reason: use source file name */
/* JADX INFO: compiled from: JvmProtoBufUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmProtoBufUtil {
    public static final JvmProtoBufUtil a = new JvmProtoBufUtil();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ExtensionRegistryLite f3390b;

    static {
        ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
        JvmProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        Intrinsics3.checkNotNullExpressionValue(extensionRegistryLiteNewInstance, "newInstance().apply(JvmProtoBuf::registerAllExtensions)");
        f3390b = extensionRegistryLiteNewInstance;
    }

    public static /* synthetic */ JvmMemberSignature.a getJvmFieldSignature$default(JvmProtoBufUtil jvmProtoBufUtil, n nVar, NameResolver nameResolver, TypeTable typeTable, boolean z2, int i, Object obj) {
        if ((i & 8) != 0) {
            z2 = true;
        }
        return jvmProtoBufUtil.getJvmFieldSignature(nVar, nameResolver, typeTable, z2);
    }

    public static final boolean isMovedFromInterfaceCompanion(n nVar) {
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        Flags2.b is_moved_from_interface_companion = JvmFlags.a.getIS_MOVED_FROM_INTERFACE_COMPANION();
        Object extension = nVar.getExtension(JvmProtoBuf.e);
        Intrinsics3.checkNotNullExpressionValue(extension, "proto.getExtension(JvmProtoBuf.flags)");
        Boolean bool = is_moved_from_interface_companion.get(((Number) extension).intValue());
        Intrinsics3.checkNotNullExpressionValue(bool, "JvmFlags.IS_MOVED_FROM_INTERFACE_COMPANION.get(proto.getExtension(JvmProtoBuf.flags))");
        return bool.booleanValue();
    }

    public static final Tuples2<JvmNameResolver, d0.e0.p.d.m0.f.c> readClassDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics3.checkNotNullParameter(strArr, "data");
        Intrinsics3.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics3.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readClassDataFrom(bArrDecodeBytes, strArr2);
    }

    public static final Tuples2<JvmNameResolver, d0.e0.p.d.m0.f.i> readFunctionDataFrom(String[] strArr, String[] strArr2) throws IOException {
        Intrinsics3.checkNotNullParameter(strArr, "data");
        Intrinsics3.checkNotNullParameter(strArr2, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(BitEncoding.decodeBytes(strArr));
        JvmProtoBuf.e delimitedFrom = JvmProtoBuf.e.parseDelimitedFrom(byteArrayInputStream, f3390b);
        Intrinsics3.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Tuples2<>(new JvmNameResolver(delimitedFrom, strArr2), d0.e0.p.d.m0.f.i.parseFrom(byteArrayInputStream, f3390b));
    }

    public static final Tuples2<JvmNameResolver, l> readPackageDataFrom(String[] strArr, String[] strArr2) {
        Intrinsics3.checkNotNullParameter(strArr, "data");
        Intrinsics3.checkNotNullParameter(strArr2, "strings");
        byte[] bArrDecodeBytes = BitEncoding.decodeBytes(strArr);
        Intrinsics3.checkNotNullExpressionValue(bArrDecodeBytes, "decodeBytes(data)");
        return readPackageDataFrom(bArrDecodeBytes, strArr2);
    }

    public final String a(q qVar, NameResolver nameResolver) {
        if (!qVar.hasClassName()) {
            return null;
        }
        ClassMapperLite classMapperLite = ClassMapperLite.a;
        return ClassMapperLite.mapClass(nameResolver.getQualifiedClassName(qVar.getClassName()));
    }

    public final ExtensionRegistryLite getEXTENSION_REGISTRY() {
        return f3390b;
    }

    public final JvmMemberSignature.b getJvmConstructorSignature(d0.e0.p.d.m0.f.d dVar, NameResolver nameResolver, TypeTable typeTable) {
        String strJoinToString$default;
        Intrinsics3.checkNotNullParameter(dVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.d, JvmProtoBuf.c> fVar = JvmProtoBuf.a;
        Intrinsics3.checkNotNullExpressionValue(fVar, "constructorSignature");
        JvmProtoBuf.c cVar = (JvmProtoBuf.c) ProtoBufUtil.getExtensionOrNull(dVar, fVar);
        String string = (cVar == null || !cVar.hasName()) ? "<init>" : nameResolver.getString(cVar.getName());
        if (cVar == null || !cVar.hasDesc()) {
            List<u> valueParameterList = dVar.getValueParameterList();
            Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameterList, 10));
            for (u uVar : valueParameterList) {
                Intrinsics3.checkNotNullExpressionValue(uVar, "it");
                String strA = a(protoTypeTableUtil.type(uVar, typeTable), nameResolver);
                if (strA == null) {
                    return null;
                }
                arrayList.add(strA);
            }
            strJoinToString$default = _Collections.joinToString$default(arrayList, "", "(", ")V", 0, null, null, 56, null);
        } else {
            strJoinToString$default = nameResolver.getString(cVar.getDesc());
        }
        return new JvmMemberSignature.b(string, strJoinToString$default);
    }

    public final JvmMemberSignature.a getJvmFieldSignature(n nVar, NameResolver nameResolver, TypeTable typeTable, boolean z2) {
        String strA;
        Intrinsics3.checkNotNullParameter(nVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.f<n, JvmProtoBuf.d> fVar = JvmProtoBuf.d;
        Intrinsics3.checkNotNullExpressionValue(fVar, "propertySignature");
        JvmProtoBuf.d dVar = (JvmProtoBuf.d) ProtoBufUtil.getExtensionOrNull(nVar, fVar);
        if (dVar == null) {
            return null;
        }
        JvmProtoBuf.b field = dVar.hasField() ? dVar.getField() : null;
        if (field == null && z2) {
            return null;
        }
        int name = (field == null || !field.hasName()) ? nVar.getName() : field.getName();
        if (field == null || !field.hasDesc()) {
            strA = a(protoTypeTableUtil.returnType(nVar, typeTable), nameResolver);
            if (strA == null) {
                return null;
            }
        } else {
            strA = nameResolver.getString(field.getDesc());
        }
        return new JvmMemberSignature.a(nameResolver.getString(name), strA);
    }

    public final JvmMemberSignature.b getJvmMethodSignature(d0.e0.p.d.m0.f.i iVar, NameResolver nameResolver, TypeTable typeTable) {
        String strStringPlus;
        Intrinsics3.checkNotNullParameter(iVar, "proto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(typeTable, "typeTable");
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.i, JvmProtoBuf.c> fVar = JvmProtoBuf.f3384b;
        Intrinsics3.checkNotNullExpressionValue(fVar, "methodSignature");
        JvmProtoBuf.c cVar = (JvmProtoBuf.c) ProtoBufUtil.getExtensionOrNull(iVar, fVar);
        int name = (cVar == null || !cVar.hasName()) ? iVar.getName() : cVar.getName();
        if (cVar == null || !cVar.hasDesc()) {
            List listListOfNotNull = Collections2.listOfNotNull(protoTypeTableUtil.receiverType(iVar, typeTable));
            List<u> valueParameterList = iVar.getValueParameterList();
            Intrinsics3.checkNotNullExpressionValue(valueParameterList, "proto.valueParameterList");
            ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(valueParameterList, 10));
            for (u uVar : valueParameterList) {
                Intrinsics3.checkNotNullExpressionValue(uVar, "it");
                arrayList.add(protoTypeTableUtil.type(uVar, typeTable));
            }
            List listPlus = _Collections.plus((Collection) listListOfNotNull, (Iterable) arrayList);
            ArrayList arrayList2 = new ArrayList(Iterables2.collectionSizeOrDefault(listPlus, 10));
            Iterator it = listPlus.iterator();
            while (it.hasNext()) {
                String strA = a((q) it.next(), nameResolver);
                if (strA == null) {
                    return null;
                }
                arrayList2.add(strA);
            }
            String strA2 = a(protoTypeTableUtil.returnType(iVar, typeTable), nameResolver);
            if (strA2 == null) {
                return null;
            }
            strStringPlus = Intrinsics3.stringPlus(_Collections.joinToString$default(arrayList2, "", "(", ")", 0, null, null, 56, null), strA2);
        } else {
            strStringPlus = nameResolver.getString(cVar.getDesc());
        }
        return new JvmMemberSignature.b(nameResolver.getString(name), strStringPlus);
    }

    public static final Tuples2<JvmNameResolver, d0.e0.p.d.m0.f.c> readClassDataFrom(byte[] bArr, String[] strArr) throws IOException {
        Intrinsics3.checkNotNullParameter(bArr, "bytes");
        Intrinsics3.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        JvmProtoBuf.e delimitedFrom = JvmProtoBuf.e.parseDelimitedFrom(byteArrayInputStream, f3390b);
        Intrinsics3.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Tuples2<>(new JvmNameResolver(delimitedFrom, strArr), d0.e0.p.d.m0.f.c.parseFrom(byteArrayInputStream, f3390b));
    }

    public static final Tuples2<JvmNameResolver, l> readPackageDataFrom(byte[] bArr, String[] strArr) throws IOException {
        Intrinsics3.checkNotNullParameter(bArr, "bytes");
        Intrinsics3.checkNotNullParameter(strArr, "strings");
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        JvmProtoBuf.e delimitedFrom = JvmProtoBuf.e.parseDelimitedFrom(byteArrayInputStream, f3390b);
        Intrinsics3.checkNotNullExpressionValue(delimitedFrom, "parseDelimitedFrom(this, EXTENSION_REGISTRY)");
        return new Tuples2<>(new JvmNameResolver(delimitedFrom, strArr), l.parseFrom(byteArrayInputStream, f3390b));
    }
}
