package p630i0.p631d0.p632a;

import p007b.p100d.p104b.p105a.C1643a;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d0.a.d */
/* JADX INFO: compiled from: Result.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C12508d<T> {

    /* JADX INFO: renamed from: a */
    public final Response<T> f26501a;

    /* JADX INFO: renamed from: b */
    public final Throwable f26502b;

    public C12508d(Response<T> response, Throwable th) {
        this.f26501a = response;
        this.f26502b = th;
    }

    public String toString() {
        if (this.f26502b != null) {
            StringBuilder sbM833U = C1643a.m833U("Result{isError=true, error=\"");
            sbM833U.append(this.f26502b);
            sbM833U.append("\"}");
            return sbM833U.toString();
        }
        StringBuilder sbM833U2 = C1643a.m833U("Result{isError=false, response=");
        sbM833U2.append(this.f26501a);
        sbM833U2.append('}');
        return sbM833U2.toString();
    }
}
