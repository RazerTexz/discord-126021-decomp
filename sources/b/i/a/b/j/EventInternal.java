package b.i.a.b.j;

import androidx.annotation.Nullable;
import b.i.a.b.j.AutoValue_EventInternal;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.b.j.f, reason: use source file name */
/* JADX INFO: compiled from: EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class EventInternal {

    /* JADX INFO: renamed from: b.i.a.b.j.f$a */
    /* JADX INFO: compiled from: EventInternal.java */
    @AutoValue.Builder
    public static abstract class a {
        public final a a(String str, String str2) {
            c().put(str, str2);
            return this;
        }

        public abstract EventInternal b();

        public abstract Map<String, String> c();
    }

    public final String a(String str) {
        String str2 = b().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> b();

    @Nullable
    public abstract Integer c();

    public abstract EncodedPayload d();

    public abstract long e();

    public final int f(String str) {
        String str2 = b().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }

    public abstract String g();

    public abstract long h();

    public a i() {
        AutoValue_EventInternal.b bVar = new AutoValue_EventInternal.b();
        bVar.f(g());
        bVar.f762b = c();
        bVar.d(d());
        bVar.e(e());
        bVar.g(h());
        bVar.f = new HashMap(b());
        return bVar;
    }
}
