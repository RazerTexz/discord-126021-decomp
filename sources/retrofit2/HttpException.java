package retrofit2;

import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class HttpException extends RuntimeException {
    private final int code;
    public final transient Response<?> j;
    private final String message;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HttpException(Response<?> response) {
        super("HTTP " + response.a.code + " " + response.a.message);
        Objects.requireNonNull(response, "response == null");
        okhttp3.Response response2 = response.a;
        this.code = response2.code;
        this.message = response2.message;
        this.j = response;
    }

    public int a() {
        return this.code;
    }
}
