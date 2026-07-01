package b.i.c.j.a.c;

import androidx.annotation.NonNull;
import b.i.a.f.i.b.x5;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-api@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class c {
    public static final Set<String> a = new HashSet(Arrays.asList("_in", "_xa", "_xu", "_aq", "_aa", "_ai", "_ac", "campaign_details", "_ug", "_iapx", "_exp_set", "_exp_clear", "_exp_activate", "_exp_timeout", "_exp_expire"));

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f1658b = Arrays.asList("_e", "_f", "_iap", "_s", "_au", "_ui", "_cd");
    public static final List<String> c = Arrays.asList("auto", "app", "am");
    public static final List<String> d = Arrays.asList("_r", "_dbg");
    public static final List<String> e;
    public static final List<String> f;

    static {
        String[][] strArr = {x5.a, x5.f1578b};
        int length = 0;
        for (int i = 0; i < 2; i++) {
            length += strArr[i].length;
        }
        Object[] objArrCopyOf = Arrays.copyOf(strArr[0], length);
        int length2 = strArr[0].length;
        for (int i2 = 1; i2 < 2; i2++) {
            String[] strArr2 = strArr[i2];
            int length3 = strArr2.length;
            System.arraycopy(strArr2, 0, objArrCopyOf, length2, length3);
            length2 += length3;
        }
        e = Arrays.asList((String[]) objArrCopyOf);
        f = Arrays.asList("^_ltv_[A-Z]{3}$", "^_cc[1-5]{1}$");
    }

    public static boolean a(@NonNull String str) {
        return !c.contains(str);
    }
}
