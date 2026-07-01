package d0.e0.p.d.m0.l.b.d0;

import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.m0.f.b;
import d0.e0.p.d.m0.f.g;
import d0.e0.p.d.m0.f.i;
import d0.e0.p.d.m0.f.l;
import d0.e0.p.d.m0.f.n;
import d0.e0.p.d.m0.f.q;
import d0.e0.p.d.m0.f.s;
import d0.e0.p.d.m0.f.u;
import d0.e0.p.d.m0.f.y.BuiltInsProtoBuf;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.i.ExtensionRegistryLite;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.l.SerializerExtensionProtocol;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.a, reason: use source file name */
/* JADX INFO: compiled from: BuiltInSerializerProtocol.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInSerializerProtocol extends SerializerExtensionProtocol {
    public static final BuiltInSerializerProtocol m = new BuiltInSerializerProtocol();

    /* JADX WARN: Illegal instructions before constructor call */
    public BuiltInSerializerProtocol() {
        ExtensionRegistryLite extensionRegistryLiteNewInstance = ExtensionRegistryLite.newInstance();
        BuiltInsProtoBuf.registerAllExtensions(extensionRegistryLiteNewInstance);
        Intrinsics3.checkNotNullExpressionValue(extensionRegistryLiteNewInstance, "newInstance().apply(BuiltInsProtoBuf::registerAllExtensions)");
        GeneratedMessageLite.f<l, Integer> fVar = BuiltInsProtoBuf.a;
        Intrinsics3.checkNotNullExpressionValue(fVar, "packageFqName");
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.d, List<d0.e0.p.d.m0.f.b>> fVar2 = BuiltInsProtoBuf.c;
        Intrinsics3.checkNotNullExpressionValue(fVar2, "constructorAnnotation");
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.c, List<d0.e0.p.d.m0.f.b>> fVar3 = BuiltInsProtoBuf.f3410b;
        Intrinsics3.checkNotNullExpressionValue(fVar3, "classAnnotation");
        GeneratedMessageLite.f<i, List<d0.e0.p.d.m0.f.b>> fVar4 = BuiltInsProtoBuf.d;
        Intrinsics3.checkNotNullExpressionValue(fVar4, "functionAnnotation");
        GeneratedMessageLite.f<n, List<d0.e0.p.d.m0.f.b>> fVar5 = BuiltInsProtoBuf.e;
        Intrinsics3.checkNotNullExpressionValue(fVar5, "propertyAnnotation");
        GeneratedMessageLite.f<n, List<d0.e0.p.d.m0.f.b>> fVar6 = BuiltInsProtoBuf.f;
        Intrinsics3.checkNotNullExpressionValue(fVar6, "propertyGetterAnnotation");
        GeneratedMessageLite.f<n, List<d0.e0.p.d.m0.f.b>> fVar7 = BuiltInsProtoBuf.g;
        Intrinsics3.checkNotNullExpressionValue(fVar7, "propertySetterAnnotation");
        GeneratedMessageLite.f<g, List<d0.e0.p.d.m0.f.b>> fVar8 = BuiltInsProtoBuf.i;
        Intrinsics3.checkNotNullExpressionValue(fVar8, "enumEntryAnnotation");
        GeneratedMessageLite.f<n, b.C0393b.c> fVar9 = BuiltInsProtoBuf.h;
        Intrinsics3.checkNotNullExpressionValue(fVar9, "compileTimeValue");
        GeneratedMessageLite.f<u, List<d0.e0.p.d.m0.f.b>> fVar10 = BuiltInsProtoBuf.j;
        Intrinsics3.checkNotNullExpressionValue(fVar10, "parameterAnnotation");
        GeneratedMessageLite.f<q, List<d0.e0.p.d.m0.f.b>> fVar11 = BuiltInsProtoBuf.k;
        Intrinsics3.checkNotNullExpressionValue(fVar11, "typeAnnotation");
        GeneratedMessageLite.f<s, List<d0.e0.p.d.m0.f.b>> fVar12 = BuiltInsProtoBuf.l;
        Intrinsics3.checkNotNullExpressionValue(fVar12, "typeParameterAnnotation");
        super(extensionRegistryLiteNewInstance, fVar, fVar2, fVar3, fVar4, fVar5, fVar6, fVar7, fVar8, fVar9, fVar10, fVar11, fVar12);
    }

    public final String getBuiltInsFileName(FqName fqName) {
        String strAsString;
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        if (fqName.isRoot()) {
            strAsString = "default-package";
        } else {
            strAsString = fqName.shortName().asString();
            Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.shortName().asString()");
        }
        return Intrinsics3.stringPlus(strAsString, ".kotlin_builtins");
    }

    public final String getBuiltInsFilePath(FqName fqName) {
        Intrinsics3.checkNotNullParameter(fqName, "fqName");
        StringBuilder sb = new StringBuilder();
        String strAsString = fqName.asString();
        Intrinsics3.checkNotNullExpressionValue(strAsString, "fqName.asString()");
        sb.append(StringsJVM.replace$default(strAsString, '.', MentionUtils.SLASH_CHAR, false, 4, (Object) null));
        sb.append(MentionUtils.SLASH_CHAR);
        sb.append(getBuiltInsFileName(fqName));
        return sb.toString();
    }
}
