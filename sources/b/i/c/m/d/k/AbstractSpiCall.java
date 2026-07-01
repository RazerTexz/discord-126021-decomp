package b.i.c.m.d.k;

import b.i.c.m.d.n.HttpRequest;
import b.i.c.m.d.n.HttpRequestFactory;
import java.util.Collections;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.c.m.d.k.a, reason: use source file name */
/* JADX INFO: compiled from: AbstractSpiCall.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractSpiCall {
    public static final Pattern a = Pattern.compile("http(s?)://[^\\/]+", 2);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f1676b;
    public final HttpRequestFactory c;
    public final int d;
    public final String e;

    public AbstractSpiCall(String str, String str2, HttpRequestFactory httpRequestFactory, int i) {
        if (str2 == null) {
            throw new IllegalArgumentException("url must not be null.");
        }
        if (httpRequestFactory == null) {
            throw new IllegalArgumentException("requestFactory must not be null.");
        }
        this.e = str;
        this.f1676b = CommonUtils.t(str) ? str2 : a.matcher(str2).replaceFirst(str);
        this.c = httpRequestFactory;
        this.d = i;
    }

    public HttpRequest b() {
        return c(Collections.emptyMap());
    }

    public HttpRequest c(Map<String, String> map) {
        HttpRequestFactory httpRequestFactory = this.c;
        int i = this.d;
        String str = this.f1676b;
        Objects.requireNonNull(httpRequestFactory);
        HttpRequest httpRequest = new HttpRequest(i, str, map);
        httpRequest.e.put("User-Agent", "Crashlytics Android SDK/17.3.0");
        httpRequest.e.put("X-CRASHLYTICS-DEVELOPER-TOKEN", "470fa2b4ae81cd56ecbcda9735803434cec591fa");
        return httpRequest;
    }
}
