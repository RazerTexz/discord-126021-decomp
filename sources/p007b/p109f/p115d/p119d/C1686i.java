package p007b.p109f.p115d.p119d;

import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.d.d.i */
/* JADX INFO: compiled from: Objects.java */
/* JADX INFO: loaded from: classes.dex */
public final class C1686i {

    /* JADX INFO: renamed from: a */
    public final String f3094a;

    /* JADX INFO: renamed from: b */
    public final a f3095b;

    /* JADX INFO: renamed from: c */
    public a f3096c;

    /* JADX INFO: renamed from: b.f.d.d.i$a */
    /* JADX INFO: compiled from: Objects.java */
    public static final class a {

        /* JADX INFO: renamed from: a */
        public String f3097a;

        /* JADX INFO: renamed from: b */
        public Object f3098b;

        /* JADX INFO: renamed from: c */
        public a f3099c;

        public a(C1685h c1685h) {
        }
    }

    public C1686i(String str, C1685h c1685h) {
        a aVar = new a(null);
        this.f3095b = aVar;
        this.f3096c = aVar;
        this.f3094a = str;
    }

    /* JADX INFO: renamed from: a */
    public C1686i m969a(String str, int i) {
        m971c(str, String.valueOf(i));
        return this;
    }

    /* JADX INFO: renamed from: b */
    public C1686i m970b(String str, boolean z2) {
        m971c(str, String.valueOf(z2));
        return this;
    }

    /* JADX INFO: renamed from: c */
    public final C1686i m971c(String str, Object obj) {
        a aVar = new a(null);
        this.f3096c.f3099c = aVar;
        this.f3096c = aVar;
        aVar.f3098b = obj;
        Objects.requireNonNull(str);
        aVar.f3097a = str;
        return this;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f3094a);
        sb.append('{');
        a aVar = this.f3095b.f3099c;
        String str = "";
        while (aVar != null) {
            Object obj = aVar.f3098b;
            sb.append(str);
            String str2 = aVar.f3097a;
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
            aVar = aVar.f3099c;
            str = ", ";
        }
        sb.append('}');
        return sb.toString();
    }
}
