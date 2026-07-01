package d0.e0.p.d.m0.e.b;

import b.d.b.a.outline;
import com.discord.widgets.chat.input.MentionUtils;
import d0.e0.p.d.m0.c.v0;
import d0.e0.p.d.m0.f.a0.JvmProtoBuf;
import d0.e0.p.d.m0.f.a0.b.JvmMetadataVersion;
import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.f.z.ProtoBufUtil;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.i.GeneratedMessageLite;
import d0.e0.p.d.m0.k.y.JvmClassName;
import d0.e0.p.d.m0.l.b.IncompatibleVersionErrorData;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource;
import d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2;
import d0.g0.Strings4;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.j, reason: use source file name */
/* JADX INFO: compiled from: JvmPackagePartSource.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class JvmPackagePartSource implements DeserializedContainerSource2 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final JvmClassName f3378b;
    public final JvmClassName c;
    public final KotlinJvmBinaryClass d;

    public JvmPackagePartSource(JvmClassName jvmClassName, JvmClassName jvmClassName2, d0.e0.p.d.m0.f.l lVar, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z2, DeserializedContainerSource deserializedContainerSource, KotlinJvmBinaryClass kotlinJvmBinaryClass) {
        Intrinsics3.checkNotNullParameter(jvmClassName, "className");
        Intrinsics3.checkNotNullParameter(lVar, "packageProto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(deserializedContainerSource, "abiStability");
        this.f3378b = jvmClassName;
        this.c = jvmClassName2;
        this.d = kotlinJvmBinaryClass;
        GeneratedMessageLite.f<d0.e0.p.d.m0.f.l, Integer> fVar = JvmProtoBuf.m;
        Intrinsics3.checkNotNullExpressionValue(fVar, "packageModuleName");
        Integer num = (Integer) ProtoBufUtil.getExtensionOrNull(lVar, fVar);
        if (num == null) {
            return;
        }
        nameResolver.getString(num.intValue());
    }

    public final ClassId getClassId() {
        return new ClassId(this.f3378b.getPackageFqName(), getSimpleName());
    }

    @Override // d0.e0.p.d.m0.c.SourceElement
    public v0 getContainingFile() {
        v0 v0Var = v0.a;
        Intrinsics3.checkNotNullExpressionValue(v0Var, "NO_SOURCE_FILE");
        return v0Var;
    }

    public final JvmClassName getFacadeClassName() {
        return this.c;
    }

    public final KotlinJvmBinaryClass getKnownJvmBinaryClass() {
        return this.d;
    }

    @Override // d0.e0.p.d.m0.l.b.e0.DeserializedContainerSource2
    public String getPresentableString() {
        StringBuilder sbU = outline.U("Class '");
        sbU.append(getClassId().asSingleFqName().asString());
        sbU.append('\'');
        return sbU.toString();
    }

    public final Name getSimpleName() {
        String internalName = this.f3378b.getInternalName();
        Intrinsics3.checkNotNullExpressionValue(internalName, "className.internalName");
        Name nameIdentifier = Name.identifier(Strings4.substringAfterLast$default(internalName, MentionUtils.SLASH_CHAR, null, 2, null));
        Intrinsics3.checkNotNullExpressionValue(nameIdentifier, "identifier(className.internalName.substringAfterLast('/'))");
        return nameIdentifier;
    }

    public String toString() {
        return ((Object) JvmPackagePartSource.class.getSimpleName()) + ": " + this.f3378b;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public JvmPackagePartSource(KotlinJvmBinaryClass kotlinJvmBinaryClass, d0.e0.p.d.m0.f.l lVar, NameResolver nameResolver, IncompatibleVersionErrorData<JvmMetadataVersion> incompatibleVersionErrorData, boolean z2, DeserializedContainerSource deserializedContainerSource) {
        Intrinsics3.checkNotNullParameter(kotlinJvmBinaryClass, "kotlinClass");
        Intrinsics3.checkNotNullParameter(lVar, "packageProto");
        Intrinsics3.checkNotNullParameter(nameResolver, "nameResolver");
        Intrinsics3.checkNotNullParameter(deserializedContainerSource, "abiStability");
        JvmClassName jvmClassNameByClassId = JvmClassName.byClassId(kotlinJvmBinaryClass.getClassId());
        Intrinsics3.checkNotNullExpressionValue(jvmClassNameByClassId, "byClassId(kotlinClass.classId)");
        String multifileClassName = kotlinJvmBinaryClass.getClassHeader().getMultifileClassName();
        JvmClassName jvmClassNameByInternalName = null;
        if (multifileClassName != null) {
            if (multifileClassName.length() > 0) {
                jvmClassNameByInternalName = JvmClassName.byInternalName(multifileClassName);
            }
        }
        this(jvmClassNameByClassId, jvmClassNameByInternalName, lVar, nameResolver, incompatibleVersionErrorData, z2, deserializedContainerSource, kotlinJvmBinaryClass);
    }
}
