package d0.e0.p.d.m0.k.z;

import d0.e0.p.d.m0.m.StorageManager;
import d0.z.d.Intrinsics3;

/* JADX INFO: renamed from: d0.e0.p.d.m0.k.z.b, reason: use source file name */
/* JADX INFO: compiled from: SamConversionResolverImpl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class SamConversionResolverImpl implements SamConversionResolver {
    public final Iterable<Object> a;

    public SamConversionResolverImpl(StorageManager storageManager, Iterable<? extends Object> iterable) {
        Intrinsics3.checkNotNullParameter(storageManager, "storageManager");
        Intrinsics3.checkNotNullParameter(iterable, "samWithReceiverResolvers");
        this.a = iterable;
        storageManager.createCacheWithNullableValues();
    }
}
