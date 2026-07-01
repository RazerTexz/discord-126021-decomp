package f0;

import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: Call.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface e extends Cloneable {
    Request c();

    void cancel();

    boolean d();

    void e(f fVar);

    Response execute() throws IOException;
}
