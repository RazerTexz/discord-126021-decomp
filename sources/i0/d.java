package i0;

import java.io.IOException;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes3.dex */
public interface d<T> extends Cloneable {
    void C(f<T> fVar);

    d<T> L();

    Request c();

    void cancel();

    boolean d();

    Response<T> execute() throws IOException;
}
