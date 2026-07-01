package i0;

import java.io.IOException;
import okhttp3.Response;

/* JADX INFO: compiled from: OkHttpCall.java */
/* JADX INFO: loaded from: classes3.dex */
public class p$a implements f0.f {
    public final /* synthetic */ f a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ p f3744b;

    public p$a(p pVar, f fVar) {
        this.f3744b = pVar;
        this.a = fVar;
    }

    @Override // f0.f
    public void a(f0.e eVar, Response response) {
        try {
            try {
                this.a.b(this.f3744b, this.f3744b.g(response));
            } catch (Throwable th) {
                c0.o(th);
                th.printStackTrace();
            }
        } catch (Throwable th2) {
            c0.o(th2);
            try {
                this.a.a(this.f3744b, th2);
            } catch (Throwable th3) {
                c0.o(th3);
                th3.printStackTrace();
            }
        }
    }

    @Override // f0.f
    public void b(f0.e eVar, IOException iOException) {
        try {
            this.a.a(this.f3744b, iOException);
        } catch (Throwable th) {
            c0.o(th);
            th.printStackTrace();
        }
    }
}
