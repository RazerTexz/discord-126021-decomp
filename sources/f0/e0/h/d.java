package f0.e0.h;

import g0.v;
import g0.x;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response$a;

/* JADX INFO: compiled from: ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface d {
    void a() throws IOException;

    void b(Request request) throws IOException;

    x c(Response response) throws IOException;

    void cancel();

    Response$a d(boolean z2) throws IOException;

    f0.e0.g.j e();

    void f() throws IOException;

    long g(Response response) throws IOException;

    v h(Request request, long j) throws IOException;
}
