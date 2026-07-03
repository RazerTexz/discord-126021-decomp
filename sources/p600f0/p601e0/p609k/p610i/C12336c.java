package p600f0.p601e0.p609k.p610i;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Logger;
import p507d0.p580t.C12136h0;
import p507d0.p592z.p594d.C12238m;
import p600f0.C12380x;
import p600f0.p601e0.p604f.C12280d;
import p600f0.p601e0.p608j.C12310d;

/* JADX INFO: renamed from: f0.e0.k.i.c */
/* JADX INFO: compiled from: AndroidLog.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12336c {

    /* JADX INFO: renamed from: a */
    public static final CopyOnWriteArraySet<Logger> f25788a = new CopyOnWriteArraySet<>();

    /* JADX INFO: renamed from: b */
    public static final Map<String, String> f25789b;

    /* JADX INFO: renamed from: c */
    public static final C12336c f25790c = null;

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r1 = C12380x.class.getPackage();
        String name = r1 != null ? r1.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = C12380x.class.getName();
        C12238m.checkExpressionValueIsNotNull(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = C12310d.class.getName();
        C12238m.checkExpressionValueIsNotNull(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = C12280d.class.getName();
        C12238m.checkExpressionValueIsNotNull(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        f25789b = C12136h0.toMap(linkedHashMap);
    }
}
