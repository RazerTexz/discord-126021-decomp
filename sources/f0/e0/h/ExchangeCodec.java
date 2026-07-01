package f0.e0.h;

import f0.e0.g.RealConnection4;
import g0.Sink;
import g0.Source2;
import java.io.IOException;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: renamed from: f0.e0.h.d, reason: use source file name */
/* JADX INFO: compiled from: ExchangeCodec.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface ExchangeCodec {
    void a() throws IOException;

    void b(Request request) throws IOException;

    Source2 c(Response response) throws IOException;

    void cancel();

    Response.a d(boolean z2) throws IOException;

    RealConnection4 e();

    void f() throws IOException;

    long g(Response response) throws IOException;

    Sink h(Request request, long j) throws IOException;
}
