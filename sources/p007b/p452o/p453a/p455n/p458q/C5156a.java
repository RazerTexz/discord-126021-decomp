package p007b.p452o.p453a.p455n.p458q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5119f;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p454m.InterfaceC5116c;

/* JADX INFO: renamed from: b.o.a.n.q.a */
/* JADX INFO: compiled from: Camera1Mapper.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5156a {

    /* JADX INFO: renamed from: a */
    public static C5156a f13956a;

    /* JADX INFO: renamed from: b */
    public static final Map<EnumC5119f, String> f13957b;

    /* JADX INFO: renamed from: c */
    public static final Map<EnumC5126m, String> f13958c;

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC5118e, Integer> f13959d;

    /* JADX INFO: renamed from: e */
    public static final Map<EnumC5121h, String> f13960e;

    static {
        HashMap map = new HashMap();
        f13957b = map;
        HashMap map2 = new HashMap();
        f13958c = map2;
        HashMap map3 = new HashMap();
        f13959d = map3;
        HashMap map4 = new HashMap();
        f13960e = map4;
        map.put(EnumC5119f.OFF, "off");
        map.put(EnumC5119f.ON, "on");
        map.put(EnumC5119f.AUTO, "auto");
        map.put(EnumC5119f.TORCH, "torch");
        map3.put(EnumC5118e.BACK, 0);
        map3.put(EnumC5118e.FRONT, 1);
        map2.put(EnumC5126m.AUTO, "auto");
        map2.put(EnumC5126m.INCANDESCENT, "incandescent");
        map2.put(EnumC5126m.FLUORESCENT, "fluorescent");
        map2.put(EnumC5126m.DAYLIGHT, "daylight");
        map2.put(EnumC5126m.CLOUDY, "cloudy-daylight");
        map4.put(EnumC5121h.OFF, "auto");
        map4.put(EnumC5121h.ON, "hdr");
    }

    @NonNull
    /* JADX INFO: renamed from: a */
    public static C5156a m7346a() {
        if (f13956a == null) {
            f13956a = new C5156a();
        }
        return f13956a;
    }

    @Nullable
    /* JADX INFO: renamed from: b */
    public final <C extends InterfaceC5116c, T> C m7347b(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }
}
