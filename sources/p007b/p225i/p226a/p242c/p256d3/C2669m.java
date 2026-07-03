package p007b.p225i.p226a.p242c.p256d3;

import android.text.Html;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.d3.m */
/* JADX INFO: compiled from: SpannedToHtmlConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2669m {

    /* JADX INFO: renamed from: a */
    public static final Pattern f6357a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: renamed from: b.i.a.c.d3.m$b */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static class b {

        /* JADX INFO: renamed from: a */
        public final String f6358a;

        /* JADX INFO: renamed from: b */
        public final Map<String, String> f6359b;

        public b(String str, Map map, a aVar) {
            this.f6358a = str;
            this.f6359b = map;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.d3.m$c */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static final class c {

        /* JADX INFO: renamed from: a */
        public final int f6360a;

        /* JADX INFO: renamed from: b */
        public final int f6361b;

        /* JADX INFO: renamed from: c */
        public final String f6362c;

        /* JADX INFO: renamed from: d */
        public final String f6363d;

        public c(int i, int i2, String str, String str2, a aVar) {
            this.f6360a = i;
            this.f6361b = i2;
            this.f6362c = str;
            this.f6363d = str2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.d3.m$d */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static final class d {

        /* JADX INFO: renamed from: a */
        public final List<c> f6364a = new ArrayList();

        /* JADX INFO: renamed from: b */
        public final List<c> f6365b = new ArrayList();
    }

    /* JADX INFO: renamed from: a */
    public static String m2759a(CharSequence charSequence) {
        return f6357a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
