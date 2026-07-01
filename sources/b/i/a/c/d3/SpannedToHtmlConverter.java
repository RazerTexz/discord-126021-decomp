package b.i.a.c.d3;

import android.text.Html;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: renamed from: b.i.a.c.d3.m, reason: use source file name */
/* JADX INFO: compiled from: SpannedToHtmlConverter.java */
/* JADX INFO: loaded from: classes3.dex */
public final class SpannedToHtmlConverter {
    public static final Pattern a = Pattern.compile("(&#13;)?&#10;");

    /* JADX INFO: renamed from: b.i.a.c.d3.m$b */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static class b {
        public final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Map<String, String> f915b;

        public b(String str, Map map, a aVar) {
            this.a = str;
            this.f915b = map;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.d3.m$c */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static final class c {
        public final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f916b;
        public final String c;
        public final String d;

        public c(int i, int i2, String str, String str2, a aVar) {
            this.a = i;
            this.f916b = i2;
            this.c = str;
            this.d = str2;
        }
    }

    /* JADX INFO: renamed from: b.i.a.c.d3.m$d */
    /* JADX INFO: compiled from: SpannedToHtmlConverter.java */
    public static final class d {
        public final List<c> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final List<c> f917b = new ArrayList();
    }

    public static String a(CharSequence charSequence) {
        return a.matcher(Html.escapeHtml(charSequence)).replaceAll("<br>");
    }
}
