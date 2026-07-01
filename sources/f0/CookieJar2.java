package f0;

import java.util.List;

/* JADX INFO: renamed from: f0.p, reason: use source file name */
/* JADX INFO: compiled from: CookieJar.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface CookieJar2 {
    public static final CookieJar2 a = new CookieJar();

    void a(HttpUrl httpUrl, List<Cookie> list);

    List<Cookie> b(HttpUrl httpUrl);
}
