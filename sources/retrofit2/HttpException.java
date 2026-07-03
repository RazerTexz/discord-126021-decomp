package retrofit2;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class HttpException extends RuntimeException {
    private final int code;

    /* JADX INFO: renamed from: j */
    public final transient Response<?> f27630j;
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(Response<?> response) {
        super("HTTP " + response.f27631a.code + " " + response.f27631a.message);
        Objects.requireNonNull(response, "response == null");
        okhttp3.Response response2 = response.f27631a;
        this.code = response2.code;
        this.message = response2.message;
        this.f27630j = response;
    }

    /* JADX INFO: renamed from: a */
    public int m11055a() {
        return this.code;
    }
}
