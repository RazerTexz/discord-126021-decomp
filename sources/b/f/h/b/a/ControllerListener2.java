package b.f.h.b.a;

import java.util.Map;

/* JADX INFO: renamed from: b.f.h.b.a.b, reason: use source file name */
/* JADX INFO: compiled from: ControllerListener2.java */
/* JADX INFO: loaded from: classes.dex */
public interface ControllerListener2<INFO> {

    /* JADX INFO: renamed from: b.f.h.b.a.b$a */
    /* JADX INFO: compiled from: ControllerListener2.java */
    public static class a {
        public Map<String, Object> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Map<String, Object> f538b;
        public Map<String, Object> c;
        public Map<String, Object> d;
        public Object e;
    }

    void a(String str, Object obj, a aVar);

    void b(String str, Throwable th, a aVar);

    void c(String str, a aVar);

    void d(String str, INFO info, a aVar);
}
