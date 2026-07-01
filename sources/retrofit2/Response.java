package retrofit2;

import okhttp3.ResponseBody;

/* JADX INFO: loaded from: classes3.dex */
public final class Response<T> {
    public final okhttp3.Response a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final T f3824b;
    public final ResponseBody c;

    public Response(okhttp3.Response response, T t, ResponseBody responseBody) {
        this.a = response;
        this.f3824b = t;
        this.c = responseBody;
    }

    public static <T> Response<T> b(T t, okhttp3.Response response) {
        if (response.b()) {
            return new Response<>(response, t, null);
        }
        throw new IllegalArgumentException("rawResponse must be successful response");
    }

    public boolean a() {
        return this.a.b();
    }

    public String toString() {
        return this.a.toString();
    }
}
