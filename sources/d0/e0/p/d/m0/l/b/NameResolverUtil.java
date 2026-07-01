package d0.e0.p.d.m0.l.b;

import d0.e0.p.d.m0.f.z.NameResolver;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.w, reason: use source file name */
/* JADX INFO: compiled from: NameResolverUtil.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class NameResolverUtil {
    public static final ClassId getClassId(NameResolver nameResolver, int i) {
        Intrinsics3.checkNotNullParameter(nameResolver, "<this>");
        ClassId classIdFromString = ClassId.fromString(nameResolver.getQualifiedClassName(i), nameResolver.isLocalClassName(i));
        Intrinsics3.checkNotNullExpressionValue(classIdFromString, "fromString(getQualifiedClassName(index), isLocalClassName(index))");
        return classIdFromString;
    }

    public static final Name getName(NameResolver nameResolver, int i) {
        Intrinsics3.checkNotNullParameter(nameResolver, "<this>");
        Name nameGuessByFirstCharacter = Name.guessByFirstCharacter(nameResolver.getString(i));
        Intrinsics3.checkNotNullExpressionValue(nameGuessByFirstCharacter, "guessByFirstCharacter(getString(index))");
        return nameGuessByFirstCharacter;
    }
}
