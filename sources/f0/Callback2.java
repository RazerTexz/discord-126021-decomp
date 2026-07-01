package f0;

import java.io.IOException;
import okhttp3.Response;

/* JADX INFO: renamed from: f0.f, reason: use source file name */
/* JADX INFO: compiled from: Callback.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Callback2 {
    void a(Call2 call2, Response response) throws IOException;

    void b(Call2 call2, IOException iOException);
}
