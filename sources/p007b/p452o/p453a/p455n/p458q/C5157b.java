package p007b.p452o.p453a.p455n.p458q;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.util.HashMap;
import java.util.Map;
import p007b.p452o.p453a.p454m.EnumC5118e;
import p007b.p452o.p453a.p454m.EnumC5121h;
import p007b.p452o.p453a.p454m.EnumC5126m;
import p007b.p452o.p453a.p454m.InterfaceC5116c;

/* JADX INFO: renamed from: b.o.a.n.q.b */
/* JADX INFO: compiled from: Camera2Mapper.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5157b {

    /* JADX INFO: renamed from: a */
    public static C5157b f13961a;

    /* JADX INFO: renamed from: b */
    public static final Map<EnumC5118e, Integer> f13962b;

    /* JADX INFO: renamed from: c */
    public static final Map<EnumC5126m, Integer> f13963c;

    /* JADX INFO: renamed from: d */
    public static final Map<EnumC5121h, Integer> f13964d;

    static {
        HashMap map = new HashMap();
        f13962b = map;
        HashMap map2 = new HashMap();
        f13963c = map2;
        HashMap map3 = new HashMap();
        f13964d = map3;
        map.put(EnumC5118e.BACK, 1);
        map.put(EnumC5118e.FRONT, 0);
        map2.put(EnumC5126m.AUTO, 1);
        map2.put(EnumC5126m.CLOUDY, 6);
        map2.put(EnumC5126m.DAYLIGHT, 5);
        map2.put(EnumC5126m.FLUORESCENT, 3);
        map2.put(EnumC5126m.INCANDESCENT, 2);
        map3.put(EnumC5121h.OFF, 0);
        map3.put(EnumC5121h.ON, 18);
    }

    @Nullable
    /* JADX INFO: renamed from: a */
    public final <C extends InterfaceC5116c, T> C m7348a(@NonNull Map<C, T> map, @NonNull T t) {
        for (C c : map.keySet()) {
            if (t.equals(map.get(c))) {
                return c;
            }
        }
        return null;
    }
}
