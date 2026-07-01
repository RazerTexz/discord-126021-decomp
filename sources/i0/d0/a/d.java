package i0.d0.a;

import retrofit2.Response;

/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d<T> {
    public final Response<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Throwable f3735b;

    public d(Response<T> response, Throwable th) {
        this.a = response;
        this.f3735b = th;
    }

    public String toString() {
        if (this.f3735b != null) {
            StringBuilder sbU = b.d.b.a.a.U("Result{isError=true, error=\"");
            sbU.append(this.f3735b);
            sbU.append("\"}");
            return sbU.toString();
        }
        StringBuilder sbU2 = b.d.b.a.a.U("Result{isError=false, response=");
        sbU2.append(this.a);
        sbU2.append('}');
        return sbU2.toString();
    }
}
