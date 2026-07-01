package f0;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: f0.e, reason: use source file name */
/* JADX INFO: compiled from: Call.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Call2 extends Cloneable {

    /* JADX INFO: renamed from: f0.e$a */
    /* JADX INFO: compiled from: Call.kt */
    public interface a {
        Call2 b(Request request);
    }

    Request c();

    void cancel();

    boolean d();

    void e(Callback2 callback2);

    Response execute() throws IOException;
}
