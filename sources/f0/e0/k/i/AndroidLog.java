package f0.e0.k.i;

import d0.t.Maps6;
import d0.z.d.Intrinsics3;
import f0.OkHttpClient;
import f0.e0.f.TaskRunner;
import f0.e0.j.Http2;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;

/* JADX INFO: renamed from: f0.e0.k.i.c, reason: use source file name */
/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class AndroidLog {
    public static final CopyOnWriteArraySet<Logger> a = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f3652b;
    public static final AndroidLog c = null;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = OkHttpClient.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = Http2.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = TaskRunner.class.getName();
        Intrinsics3.checkExpressionValueIsNotNull(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        f3652b = Maps6.toMap(linkedHashMap);
    }
}
