package b.i.a.f.e.h.j;

import android.os.RemoteException;
import androidx.annotation.Nullable;
import b.i.a.f.e.h.a;
import b.i.a.f.e.h.a.b;
import com.google.android.gms.common.Feature;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class p<A extends a.b, ResultT> {

    @Nullable
    public final Feature[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f1369b;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-base@@17.3.0 */
    public static class a<A extends a.b, ResultT> {
        public b.i.a.f.h.b.j<A, TaskCompletionSource<ResultT>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Feature[] f1370b;

        public a(j0 j0Var) {
        }
    }

    @Deprecated
    public p() {
        this.a = null;
        this.f1369b = false;
    }

    public abstract void c(A a2, TaskCompletionSource<ResultT> taskCompletionSource) throws RemoteException;

    public p(Feature[] featureArr, boolean z2, j0 j0Var) {
        this.a = featureArr;
        this.f1369b = z2;
    }
}
