package p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b;

import java.util.Collection;
import java.util.Set;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.protobuf.InvalidProtocolBufferException;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11330e;
import p507d0.p513e0.p514p.p515d.p517m0.p521c.InterfaceC11331e0;
import p507d0.p513e0.p514p.p515d.p517m0.p531e.p541b.p542b0.C11636a;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11678c;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.C11687l;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11673f;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11674g;
import p507d0.p513e0.p514p.p515d.p517m0.p543f.p544a0.p545b.C11675h;
import p507d0.p513e0.p514p.p515d.p517m0.p548g.C11716e;
import p507d0.p513e0.p514p.p515d.p517m0.p552k.p553a0.InterfaceC11770i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11870f;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11874j;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.C11882r;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.C11864i;
import p507d0.p513e0.p514p.p515d.p517m0.p562l.p563b.p565e0.EnumC11860e;
import p507d0.p580t.C12146m0;
import p507d0.p580t.C12147n;
import p507d0.p580t.C12148n0;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.f */
/* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C11645f {

    /* JADX INFO: renamed from: a */
    public static final a f23603a = new a(null);

    /* JADX INFO: renamed from: b */
    public static final Set<C11636a.a> f23604b = C12146m0.setOf(C11636a.a.CLASS);

    /* JADX INFO: renamed from: c */
    public static final Set<C11636a.a> f23605c = C12148n0.setOf((Object[]) new C11636a.a[]{C11636a.a.FILE_FACADE, C11636a.a.MULTIFILE_CLASS_PART});

    /* JADX INFO: renamed from: d */
    public static final C11673f f23606d = new C11673f(1, 1, 2);

    /* JADX INFO: renamed from: e */
    public static final C11673f f23607e = new C11673f(1, 1, 11);

    /* JADX INFO: renamed from: f */
    public static final C11673f f23608f = new C11673f(1, 1, 13);

    /* JADX INFO: renamed from: g */
    public C11874j f23609g;

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.f$a */
    /* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final C11673f getKOTLIN_1_3_RC_METADATA_VERSION$descriptors_jvm() {
            return C11645f.f23608f;
        }

        public final Set<C11636a.a> getKOTLIN_CLASS$descriptors_jvm() {
            return C11645f.f23604b;
        }
    }

    /* JADX INFO: renamed from: d0.e0.p.d.m0.e.b.f$b */
    /* JADX INFO: compiled from: DeserializedDescriptorResolver.kt */
    public static final class b extends AbstractC12240o implements Function0<Collection<? extends C11716e>> {

        /* JADX INFO: renamed from: j */
        public static final b f23610j = new b();

        public b() {
            super(0);
        }

        @Override // kotlin.jvm.functions.Function0
        public final Collection<? extends C11716e> invoke() {
            return C12147n.emptyList();
        }
    }

    public static final boolean access$getSkipMetadataVersionCheck(C11645f c11645f) {
        return c11645f.getComponents().getConfiguration().getSkipMetadataVersionCheck();
    }

    /* JADX INFO: renamed from: a */
    public final EnumC11860e m9545a(InterfaceC11655p interfaceC11655p) {
        EnumC11860e enumC11860e = EnumC11860e.STABLE;
        if (getComponents().getConfiguration().getAllowUnstableDependencies()) {
            return enumC11860e;
        }
        if (interfaceC11655p.getClassHeader().isUnstableFirBinary()) {
            return EnumC11860e.FIR_UNSTABLE;
        }
        return interfaceC11655p.getClassHeader().isUnstableJvmIrBinary() ? EnumC11860e.IR_UNSTABLE : enumC11860e;
    }

    /* JADX INFO: renamed from: b */
    public final C11882r<C11673f> m9546b(InterfaceC11655p interfaceC11655p) {
        if (getComponents().getConfiguration().getSkipMetadataVersionCheck() || interfaceC11655p.getClassHeader().getMetadataVersion().isCompatible()) {
            return null;
        }
        return new C11882r<>(interfaceC11655p.getClassHeader().getMetadataVersion(), C11673f.f23711f, interfaceC11655p.getLocation(), interfaceC11655p.getClassId());
    }

    /* JADX INFO: renamed from: c */
    public final boolean m9547c(InterfaceC11655p interfaceC11655p) {
        if (!getComponents().getConfiguration().getReportErrorsOnPreReleaseDependencies() || (!interfaceC11655p.getClassHeader().isPreRelease() && !C12238m.areEqual(interfaceC11655p.getClassHeader().getMetadataVersion(), f23606d))) {
            if (!(!getComponents().getConfiguration().getSkipPrereleaseCheck() && interfaceC11655p.getClassHeader().isPreRelease() && C12238m.areEqual(interfaceC11655p.getClassHeader().getMetadataVersion(), f23607e))) {
                return false;
            }
        }
        return true;
    }

    public final InterfaceC11770i createKotlinPackagePartScope(InterfaceC11331e0 interfaceC11331e0, InterfaceC11655p interfaceC11655p) {
        String[] strings;
        Pair<C11674g, C11687l> packageDataFrom;
        C12238m.checkNotNullParameter(interfaceC11331e0, "descriptor");
        C12238m.checkNotNullParameter(interfaceC11655p, "kotlinClass");
        String[] strArrM9548d = m9548d(interfaceC11655p, f23605c);
        if (strArrM9548d == null || (strings = interfaceC11655p.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                C11675h c11675h = C11675h.f23720a;
                packageDataFrom = C11675h.readPackageDataFrom(strArrM9548d, strings);
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalStateException(C12238m.stringPlus("Could not read data from ", interfaceC11655p.getLocation()), e);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || interfaceC11655p.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            packageDataFrom = null;
        }
        if (packageDataFrom == null) {
            return null;
        }
        C11674g c11674gComponent1 = packageDataFrom.component1();
        C11687l c11687lComponent2 = packageDataFrom.component2();
        return new C11864i(interfaceC11331e0, c11687lComponent2, c11674gComponent1, interfaceC11655p.getClassHeader().getMetadataVersion(), new C11649j(interfaceC11655p, c11687lComponent2, c11674gComponent1, m9546b(interfaceC11655p), m9547c(interfaceC11655p), m9545a(interfaceC11655p)), getComponents(), b.f23610j);
    }

    /* JADX INFO: renamed from: d */
    public final String[] m9548d(InterfaceC11655p interfaceC11655p, Set<? extends C11636a.a> set) {
        C11636a classHeader = interfaceC11655p.getClassHeader();
        String[] data = classHeader.getData();
        if (data == null) {
            data = classHeader.getIncompatibleData();
        }
        if (data != null && set.contains(classHeader.getKind())) {
            return data;
        }
        return null;
    }

    public final C11874j getComponents() {
        C11874j c11874j = this.f23609g;
        if (c11874j != null) {
            return c11874j;
        }
        C12238m.throwUninitializedPropertyAccessException("components");
        throw null;
    }

    public final C11870f readClassData$descriptors_jvm(InterfaceC11655p interfaceC11655p) {
        String[] strings;
        Pair<C11674g, C11678c> classDataFrom;
        C12238m.checkNotNullParameter(interfaceC11655p, "kotlinClass");
        String[] strArrM9548d = m9548d(interfaceC11655p, f23603a.getKOTLIN_CLASS$descriptors_jvm());
        if (strArrM9548d == null || (strings = interfaceC11655p.getClassHeader().getStrings()) == null) {
            return null;
        }
        try {
            try {
                C11675h c11675h = C11675h.f23720a;
                classDataFrom = C11675h.readClassDataFrom(strArrM9548d, strings);
            } catch (InvalidProtocolBufferException e) {
                throw new IllegalStateException(C12238m.stringPlus("Could not read data from ", interfaceC11655p.getLocation()), e);
            }
        } catch (Throwable th) {
            if (access$getSkipMetadataVersionCheck(this) || interfaceC11655p.getClassHeader().getMetadataVersion().isCompatible()) {
                throw th;
            }
            classDataFrom = null;
        }
        if (classDataFrom == null) {
            return null;
        }
        return new C11870f(classDataFrom.component1(), classDataFrom.component2(), interfaceC11655p.getClassHeader().getMetadataVersion(), new C11657r(interfaceC11655p, m9546b(interfaceC11655p), m9547c(interfaceC11655p), m9545a(interfaceC11655p)));
    }

    public final InterfaceC11330e resolveClass(InterfaceC11655p interfaceC11655p) {
        C12238m.checkNotNullParameter(interfaceC11655p, "kotlinClass");
        C11870f classData$descriptors_jvm = readClassData$descriptors_jvm(interfaceC11655p);
        if (classData$descriptors_jvm == null) {
            return null;
        }
        return getComponents().getClassDeserializer().deserializeClass(interfaceC11655p.getClassId(), classData$descriptors_jvm);
    }

    public final void setComponents(C11874j c11874j) {
        C12238m.checkNotNullParameter(c11874j, "<set-?>");
        this.f23609g = c11874j;
    }

    public final void setComponents(C11644e c11644e) {
        C12238m.checkNotNullParameter(c11644e, "components");
        setComponents(c11644e.getComponents());
    }
}
