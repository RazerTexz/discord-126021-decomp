package d0.e0.p.d.m0.c.h1;

import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.g.ClassId;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.g.Name;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.b, reason: use source file name */
/* JADX INFO: compiled from: ClassDescriptorFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ClassDescriptorFactory {
    ClassDescriptor createClass(ClassId classId);

    Collection<ClassDescriptor> getAllContributedClassesIfPossible(FqName fqName);

    boolean shouldCreateClass(FqName fqName, Name name);
}
