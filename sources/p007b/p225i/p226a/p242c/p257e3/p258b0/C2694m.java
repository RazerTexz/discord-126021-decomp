package p007b.p225i.p226a.p242c.p257e3.p258b0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.e3.b0.m */
/* JADX INFO: compiled from: ContentMetadataMutations.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2694m {

    /* JADX INFO: renamed from: a */
    public final Map<String, Object> f6496a = new HashMap();

    /* JADX INFO: renamed from: b */
    public final List<String> f6497b = new ArrayList();

    /* JADX INFO: renamed from: a */
    public static C2694m m2815a(C2694m c2694m, long j) {
        Long lValueOf = Long.valueOf(j);
        Map<String, Object> map = c2694m.f6496a;
        Objects.requireNonNull(lValueOf);
        map.put("exo_len", lValueOf);
        c2694m.f6497b.remove("exo_len");
        return c2694m;
    }
}
