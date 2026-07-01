package d0.e0.p.d.m0.l.b.d0;

import d0.e0.p.d.m0.b.BuiltInsPackageFragment;
import d0.e0.p.d.m0.c.ModuleDescriptor2;
import d0.e0.p.d.m0.f.m;
import d0.e0.p.d.m0.f.y.BuiltInsBinaryVersion;
import d0.e0.p.d.m0.g.FqName;
import d0.e0.p.d.m0.l.b.DeserializedPackageFragmentImpl;
import d0.e0.p.d.m0.m.StorageManager;
import d0.y.Closeable;
import d0.z.d.Intrinsics3;
import java.io.IOException;
import java.io.InputStream;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.c, reason: use source file name */
/* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class BuiltInsPackageFragmentImpl extends DeserializedPackageFragmentImpl implements BuiltInsPackageFragment {
    public static final a v = new a(null);

    /* JADX INFO: renamed from: d0.e0.p.d.m0.l.b.d0.c$a */
    /* JADX INFO: compiled from: BuiltInsPackageFragmentImpl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final BuiltInsPackageFragmentImpl create(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, InputStream inputStream, boolean z2) throws IOException {
            Intrinsics3.checkNotNullParameter(fqName, "fqName");
            Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics3.checkNotNullParameter(moduleDescriptor2, "module");
            Intrinsics3.checkNotNullParameter(inputStream, "inputStream");
            try {
                BuiltInsBinaryVersion from = BuiltInsBinaryVersion.f.readFrom(inputStream);
                if (from == null) {
                    Intrinsics3.throwUninitializedPropertyAccessException("version");
                    throw null;
                }
                if (from.isCompatible()) {
                    m from2 = m.parseFrom(inputStream, BuiltInSerializerProtocol.m.getExtensionRegistry());
                    Closeable.closeFinally(inputStream, null);
                    Intrinsics3.checkNotNullExpressionValue(from2, "proto");
                    return new BuiltInsPackageFragmentImpl(fqName, storageManager, moduleDescriptor2, from2, from, z2, null);
                }
                throw new UnsupportedOperationException("Kotlin built-in definition format version is not supported: expected " + BuiltInsBinaryVersion.g + ", actual " + from + ". Please update Kotlin");
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    Closeable.closeFinally(inputStream, th);
                    throw th2;
                }
            }
        }
    }

    public BuiltInsPackageFragmentImpl(FqName fqName, StorageManager storageManager, ModuleDescriptor2 moduleDescriptor2, m mVar, BuiltInsBinaryVersion builtInsBinaryVersion, boolean z2, DefaultConstructorMarker defaultConstructorMarker) {
        super(fqName, storageManager, moduleDescriptor2, mVar, builtInsBinaryVersion, null);
    }
}
