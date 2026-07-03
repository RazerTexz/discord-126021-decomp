package okhttp3;

import java.io.IOException;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {

    /* JADX INFO: renamed from: a */
    public static final /* synthetic */ int f27513a = 0;

    /* JADX INFO: compiled from: Interceptor.kt */
    public interface Chain {
        /* JADX INFO: renamed from: a */
        Response mo10228a(Request request) throws IOException;

        /* JADX INFO: renamed from: c */
        Request mo10230c();
    }

    Response intercept(Chain chain) throws IOException;
}
