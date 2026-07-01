package b.i.a.b.j;

import com.google.auto.value.AutoValue$Builder;
import java.util.Map;

/* JADX INFO: compiled from: EventInternal.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue$Builder
public abstract class f$a {
    public final f$a a(String str, String str2) {
        c().put(str, str2);
        return this;
    }

    public abstract f b();

    public abstract Map<String, String> c();
}
