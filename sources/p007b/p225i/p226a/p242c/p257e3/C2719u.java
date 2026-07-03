package p007b.p225i.p226a.p242c.p257e3;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: renamed from: b.i.a.c.e3.u */
/* JADX INFO: compiled from: HttpDataSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2719u {

    /* JADX INFO: renamed from: a */
    public final Map<String, String> f6626a = new HashMap();

    /* JADX INFO: renamed from: b */
    @Nullable
    public Map<String, String> f6627b;

    /* JADX INFO: renamed from: a */
    public synchronized Map<String, String> m2874a() {
        if (this.f6627b == null) {
            this.f6627b = Collections.unmodifiableMap(new HashMap(this.f6626a));
        }
        return this.f6627b;
    }
}
