package b.f.d.d;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: Objects.java */
/* JADX INFO: loaded from: classes.dex */
public final class i {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final i$a f469b;
    public i$a c;

    public i(String str, h hVar) {
        i$a i_a = new i$a(null);
        this.f469b = i_a;
        this.c = i_a;
        this.a = str;
    }

    public i a(String str, int i) {
        c(str, String.valueOf(i));
        return this;
    }

    public i b(String str, boolean z2) {
        c(str, String.valueOf(z2));
        return this;
    }

    public final i c(String str, Object obj) {
        i$a i_a = new i$a(null);
        this.c.c = i_a;
        this.c = i_a;
        i_a.f470b = obj;
        Objects.requireNonNull(str);
        i_a.a = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.a);
        sb.append('{');
        i$a i_a = this.f469b.c;
        String str = "";
        while (i_a != null) {
            Object obj = i_a.f470b;
            sb.append(str);
            String str2 = i_a.a;
            if (str2 != null) {
                sb.append(str2);
                sb.append('=');
            }
            if (obj == null || !obj.getClass().isArray()) {
                sb.append(obj);
            } else {
                String strDeepToString = Arrays.deepToString(new Object[]{obj});
                sb.append((CharSequence) strDeepToString, 1, strDeepToString.length() - 1);
            }
            i_a = i_a.c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
