package f0;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import f0.e0.h.c$a;
import java.util.Date;
import java.util.regex.Pattern;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: Cookie.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class n {
    public final String f;
    public final String g;
    public final long h;
    public final String i;
    public final String j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public final boolean n;
    public static final n$a e = new n$a(null);
    public static final Pattern a = Pattern.compile("(\\d{2,4})[^\\d]*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Pattern f3676b = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    public static final Pattern c = Pattern.compile("(\\d{1,2})[^\\d]*");
    public static final Pattern d = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public n(String str, String str2, long j, String str3, String str4, boolean z2, boolean z3, boolean z4, boolean z5, DefaultConstructorMarker defaultConstructorMarker) {
        this.f = str;
        this.g = str2;
        this.h = j;
        this.i = str3;
        this.j = str4;
        this.k = z2;
        this.l = z3;
        this.m = z4;
        this.n = z5;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0048  */
    public final boolean a(w wVar) {
        boolean zAreEqual;
        d0.z.d.m.checkParameterIsNotNull(wVar, "url");
        if (this.n) {
            zAreEqual = d0.z.d.m.areEqual(wVar.g, this.i);
        } else {
            String str = wVar.g;
            String str2 = this.i;
            if (d0.z.d.m.areEqual(str, str2)) {
                zAreEqual = true;
            } else {
                if (d0.g0.t.endsWith$default(str, str2, false, 2, null) && str.charAt((str.length() - str2.length()) - 1) == '.') {
                    byte[] bArr = f0.e0.c.a;
                    d0.z.d.m.checkParameterIsNotNull(str, "$this$canParseAsIpAddress");
                    if (!f0.e0.c.f.matches(str)) {
                        zAreEqual = true;
                    }
                }
                zAreEqual = false;
            }
        }
        if (!zAreEqual) {
            return false;
        }
        String str3 = this.j;
        String strB = wVar.b();
        if (d0.z.d.m.areEqual(strB, str3) || (d0.g0.t.startsWith$default(strB, str3, false, 2, null) && (d0.g0.t.endsWith$default(str3, AutocompleteViewModel.COMMAND_DISCOVER_TOKEN, false, 2, null) || strB.charAt(str3.length()) == '/'))) {
            return !this.k || wVar.c;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj instanceof n) {
            n nVar = (n) obj;
            if (d0.z.d.m.areEqual(nVar.f, this.f) && d0.z.d.m.areEqual(nVar.g, this.g) && nVar.h == this.h && d0.z.d.m.areEqual(nVar.i, this.i) && d0.z.d.m.areEqual(nVar.j, this.j) && nVar.k == this.k && nVar.l == this.l && nVar.m == this.m && nVar.n == this.n) {
                return true;
            }
        }
        return false;
    }

    @IgnoreJRERequirement
    public int hashCode() {
        return b.a.f.c.a(this.n) + ((b.a.f.c.a(this.m) + ((b.a.f.c.a(this.l) + ((b.a.f.c.a(this.k) + b.d.b.a.a.m(this.j, b.d.b.a.a.m(this.i, (a0.a.a.b.a(this.h) + b.d.b.a.a.m(this.g, b.d.b.a.a.m(this.f, 527, 31), 31)) * 31, 31), 31)) * 31)) * 31)) * 31);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.f);
        sb.append('=');
        sb.append(this.g);
        if (this.m) {
            if (this.h == Long.MIN_VALUE) {
                sb.append("; max-age=0");
            } else {
                sb.append("; expires=");
                Date date = new Date(this.h);
                c$a c_a = f0.e0.h.c.a;
                d0.z.d.m.checkParameterIsNotNull(date, "$this$toHttpDateString");
                String str = f0.e0.h.c.a.get().format(date);
                d0.z.d.m.checkExpressionValueIsNotNull(str, "STANDARD_DATE_FORMAT.get().format(this)");
                sb.append(str);
            }
        }
        if (!this.n) {
            sb.append("; domain=");
            sb.append(this.i);
        }
        sb.append("; path=");
        sb.append(this.j);
        if (this.k) {
            sb.append("; secure");
        }
        if (this.l) {
            sb.append("; httponly");
        }
        String string = sb.toString();
        d0.z.d.m.checkExpressionValueIsNotNull(string, "toString()");
        return string;
    }
}
