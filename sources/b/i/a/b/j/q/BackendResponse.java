package b.i.a.b.j.q;

import com.google.auto.value.AutoValue;

/* JADX INFO: renamed from: b.i.a.b.j.q.g, reason: use source file name */
/* JADX INFO: compiled from: BackendResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class BackendResponse {

    /* JADX INFO: renamed from: b.i.a.b.j.q.g$a */
    /* JADX INFO: compiled from: BackendResponse.java */
    public enum a {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR
    }

    public static BackendResponse a() {
        return new AutoValue_BackendResponse(a.FATAL_ERROR, -1L);
    }

    public abstract long b();

    public abstract a c();
}
