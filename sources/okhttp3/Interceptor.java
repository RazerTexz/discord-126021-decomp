package okhttp3;

import java.io.IOException;

/* JADX INFO: compiled from: Interceptor.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface Interceptor {
    public static final /* synthetic */ int a = 0;

    Response intercept(Interceptor$Chain chain) throws IOException;
}
