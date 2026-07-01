package okhttp3;

import java.io.IOException;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {
    public static final /* synthetic */ int a = 0;

    /* JADX INFO: compiled from: Interceptor.kt */
    public interface Chain {
        Response a(Request request) throws IOException;

        Request c();
    }

    Response intercept(Chain chain) throws IOException;
}
