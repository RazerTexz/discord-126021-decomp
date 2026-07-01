package b.i.a.b.j;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class f {
    public final String a(String str) {
        String str2 = b().get(str);
        return str2 == null ? "" : str2;
    }

    public abstract Map<String, String> b();

    @Nullable
    public abstract Integer c();

    public abstract e d();

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

    public f$a i() {
        a$b a_b = new a$b();
        a_b.f(g());
        a_b.f762b = c();
        a_b.d(d());
        a_b.e(e());
        a_b.g(h());
        a_b.f = new HashMap(b());
        return a_b;
    }
}
