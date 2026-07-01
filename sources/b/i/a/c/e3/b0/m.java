package b.i.a.c.e3.b0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: ContentMetadataMutations.java */
/* JADX INFO: loaded from: classes3.dex */
public class m {
    public final Map<String, Object> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<String> f935b = new ArrayList();

    public static m a(m mVar, long j) {
        Long lValueOf = Long.valueOf(j);
        Map<String, Object> map = mVar.a;
        Objects.requireNonNull(lValueOf);
        map.put("exo_len", lValueOf);
        mVar.f935b.remove("exo_len");
        return mVar;
    }
}
