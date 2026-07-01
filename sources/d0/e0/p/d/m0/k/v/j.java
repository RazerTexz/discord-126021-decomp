package d0.e0.p.d.m0.k.v;

import b.d.b.a.outline;
import d0.Tuples;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.c.findClassInModule;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.k.DescriptorUtils;
import d0.e0.p.d.m0.n.ErrorUtils;
import d0.e0.p.d.m0.n.KotlinType;
import d0.e0.p.d.m0.n.KotlinType4;
import d0.z.d.Intrinsics3;
import kotlin.Tuples2;

/* JADX INFO: compiled from: constantValues.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class j extends g<Tuples2<? extends ClassId, ? extends Name>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ClassId f3473b;
    public final Name c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public j(ClassId classId, Name name) {
        super(Tuples.to(classId, name));
        Intrinsics3.checkNotNullParameter(classId, "enumClassId");
        Intrinsics3.checkNotNullParameter(name, "enumEntryName");
        this.f3473b = classId;
        this.c = name;
    }

    public final Name getEnumEntryName() {
        return this.c;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public KotlinType getType(ModuleDescriptor2 moduleDescriptor2) {
        Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
        ClassDescriptor classDescriptorFindClassAcrossModuleDependencies = findClassInModule.findClassAcrossModuleDependencies(moduleDescriptor2, this.f3473b);
        KotlinType4 defaultType = null;
        if (classDescriptorFindClassAcrossModuleDependencies != null) {
            if (!DescriptorUtils.isEnumClass(classDescriptorFindClassAcrossModuleDependencies)) {
                classDescriptorFindClassAcrossModuleDependencies = null;
            }
            if (classDescriptorFindClassAcrossModuleDependencies != null) {
                defaultType = classDescriptorFindClassAcrossModuleDependencies.getDefaultType();
            }
        }
        if (defaultType != null) {
            return defaultType;
        }
        StringBuilder sbU = outline.U("Containing class for error-class based enum entry ");
        sbU.append(this.f3473b);
        sbU.append('.');
        sbU.append(this.c);
        KotlinType4 kotlinType4CreateErrorType = ErrorUtils.createErrorType(sbU.toString());
        Intrinsics3.checkNotNullExpressionValue(kotlinType4CreateErrorType, "createErrorType(\"Containing class for error-class based enum entry $enumClassId.$enumEntryName\")");
        return kotlinType4CreateErrorType;
    }

    @Override // d0.e0.p.d.m0.k.v.g
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f3473b.getShortClassName());
        sb.append('.');
        sb.append(this.c);
        return sb.toString();
    }
}
