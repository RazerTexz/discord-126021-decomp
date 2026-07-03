package p007b.p452o.p453a.p467r;

import android.util.Range;
import androidx.annotation.RequiresApi;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p007b.p452o.p453a.C5103b;

/* JADX INFO: renamed from: b.o.a.r.b */
/* JADX INFO: compiled from: FpsRangeValidator.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(21)
public class C5201b {

    /* JADX INFO: renamed from: a */
    public static final C5103b f14103a = new C5103b("FpsRangeValidator");

    /* JADX INFO: renamed from: b */
    public static final Map<String, List<Range<Integer>>> f14104b;

    static {
        HashMap map = new HashMap();
        f14104b = map;
        map.put("Google Pixel 4", Arrays.asList(new Range(15, 60)));
        map.put("Google Pixel 4a", Arrays.asList(new Range(15, 60)));
    }
}
