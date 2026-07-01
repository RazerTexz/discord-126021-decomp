package i0;

import java.io.IOException;
import okhttp3.Request;
import retrofit2.Response;

/* JADX INFO: renamed from: i0.d, reason: use source file name */
/* JADX INFO: compiled from: Call.java */
/* JADX INFO: loaded from: classes3.dex */
public interface Call3<T> extends Cloneable {
    void C(Callback3<T> callback3);

    Call3<T> L();

    Request c();

    void cancel();

    boolean d();

    Response<T> execute() throws IOException;
}
