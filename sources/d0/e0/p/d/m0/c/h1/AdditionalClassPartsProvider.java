package d0.e0.p.d.m0.c.h1;

import com.discord.models.domain.ModelAuditLogEntry;
import d0.e0.p.d.m0.c.ClassConstructorDescriptor;
import d0.e0.p.d.m0.c.ClassDescriptor;
import d0.e0.p.d.m0.c.SimpleFunctionDescriptor;
import d0.e0.p.d.m0.g.Name;
import d0.e0.p.d.m0.n.KotlinType;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.Collection;

/* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.a, reason: use source file name */
/* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface AdditionalClassPartsProvider {

    /* JADX INFO: renamed from: d0.e0.p.d.m0.c.h1.a$a */
    /* JADX INFO: compiled from: AdditionalClassPartsProvider.kt */
    public static final class a implements AdditionalClassPartsProvider {
        public static final a a = new a();

        @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
        public Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
        public Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
        public Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }

        @Override // d0.e0.p.d.m0.c.h1.AdditionalClassPartsProvider
        public Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor) {
            Intrinsics3.checkNotNullParameter(classDescriptor, "classDescriptor");
            return Collections2.emptyList();
        }
    }

    Collection<ClassConstructorDescriptor> getConstructors(ClassDescriptor classDescriptor);

    Collection<SimpleFunctionDescriptor> getFunctions(Name name, ClassDescriptor classDescriptor);

    Collection<Name> getFunctionsNames(ClassDescriptor classDescriptor);

    Collection<KotlinType> getSupertypes(ClassDescriptor classDescriptor);
}
