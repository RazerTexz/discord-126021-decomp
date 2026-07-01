package f0;

import com.adjust.sdk.Constants;
import com.discord.widgets.chat.input.MentionUtilsKt;
import com.discord.widgets.settings.account.WidgetSettingsAccountChangePassword;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.TypeCastException;
import kotlin.text.Regex;
import org.objectweb.asm.Opcodes;

/* JADX INFO: compiled from: HttpUrl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class w {
    public final boolean c;
    public final String d;
    public final String e;
    public final String f;
    public final String g;
    public final int h;
    public final List<String> i;
    public final List<String> j;
    public final String k;
    public final String l;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final w$b f3681b = new w$b(null);
    public static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public w(String str, String str2, String str3, String str4, int i, List<String> list, List<String> list2, String str5, String str6) {
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        d0.z.d.m.checkParameterIsNotNull(str2, "username");
        d0.z.d.m.checkParameterIsNotNull(str3, WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        d0.z.d.m.checkParameterIsNotNull(str4, "host");
        d0.z.d.m.checkParameterIsNotNull(list, "pathSegments");
        d0.z.d.m.checkParameterIsNotNull(str6, "url");
        this.d = str;
        this.e = str2;
        this.f = str3;
        this.g = str4;
        this.h = i;
        this.i = list;
        this.j = list2;
        this.k = str5;
        this.l = str6;
        this.c = d0.z.d.m.areEqual(str, Constants.SCHEME);
    }

    public final String a() {
        if (this.f.length() == 0) {
            return "";
        }
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.EMOJIS_AND_STICKERS_CHAR, this.d.length() + 3, false, 4, (Object) null) + 1;
        int iIndexOf$default2 = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.MENTIONS_CHAR, 0, false, 6, (Object) null);
        String str = this.l;
        if (str == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str.substring(iIndexOf$default, iIndexOf$default2);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String b() {
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.SLASH_CHAR, this.d.length() + 3, false, 4, (Object) null);
        String str = this.l;
        int iG = f0.e0.c.g(str, "?#", iIndexOf$default, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iG);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final List<String> c() {
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.SLASH_CHAR, this.d.length() + 3, false, 4, (Object) null);
        String str = this.l;
        int iG = f0.e0.c.g(str, "?#", iIndexOf$default, str.length());
        ArrayList arrayList = new ArrayList();
        while (iIndexOf$default < iG) {
            int i = iIndexOf$default + 1;
            int iF = f0.e0.c.f(this.l, MentionUtilsKt.SLASH_CHAR, i, iG);
            String str2 = this.l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = str2.substring(i, iF);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            arrayList.add(strSubstring);
            iIndexOf$default = iF;
        }
        return arrayList;
    }

    public final String d() {
        if (this.j == null) {
            return null;
        }
        int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, '?', 0, false, 6, (Object) null) + 1;
        String str = this.l;
        int iF = f0.e0.c.f(str, MentionUtilsKt.CHANNELS_CHAR, iIndexOf$default, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(iIndexOf$default, iF);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public final String e() {
        if (this.e.length() == 0) {
            return "";
        }
        int length = this.d.length() + 3;
        String str = this.l;
        int iG = f0.e0.c.g(str, ":@", length, str.length());
        String str2 = this.l;
        if (str2 == null) {
            throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
        String strSubstring = str2.substring(length, iG);
        d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public boolean equals(Object obj) {
        return (obj instanceof w) && d0.z.d.m.areEqual(((w) obj).l, this.l);
    }

    /* JADX WARN: Code duplicated, block: B:13:0x0050  */
    public final w$a f() {
        int i;
        String strSubstring;
        w$a w_a = new w$a();
        w_a.f3682b = this.d;
        String strE = e();
        d0.z.d.m.checkParameterIsNotNull(strE, "<set-?>");
        w_a.c = strE;
        String strA = a();
        d0.z.d.m.checkParameterIsNotNull(strA, "<set-?>");
        w_a.d = strA;
        w_a.e = this.g;
        int i2 = this.h;
        String str = this.d;
        d0.z.d.m.checkParameterIsNotNull(str, "scheme");
        int iHashCode = str.hashCode();
        if (iHashCode != 3213448) {
            if (iHashCode == 99617003 && str.equals(Constants.SCHEME)) {
                i = 443;
            } else {
                i = -1;
            }
        } else if (str.equals("http")) {
            i = 80;
        } else {
            i = -1;
        }
        w_a.f = i2 != i ? this.h : -1;
        w_a.g.clear();
        w_a.g.addAll(c());
        w_a.d(d());
        if (this.k == null) {
            strSubstring = null;
        } else {
            int iIndexOf$default = d0.g0.w.indexOf$default((CharSequence) this.l, MentionUtilsKt.CHANNELS_CHAR, 0, false, 6, (Object) null) + 1;
            String str2 = this.l;
            if (str2 == null) {
                throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
            }
            strSubstring = str2.substring(iIndexOf$default);
            d0.z.d.m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.String).substring(startIndex)");
        }
        w_a.i = strSubstring;
        return w_a;
    }

    public final w$a g(String str) {
        d0.z.d.m.checkParameterIsNotNull(str, "link");
        try {
            w$a w_a = new w$a();
            w_a.e(this, str);
            return w_a;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public final String h() {
        w$a w_aG = g("/...");
        if (w_aG == null) {
            d0.z.d.m.throwNpe();
        }
        Objects.requireNonNull(w_aG);
        d0.z.d.m.checkParameterIsNotNull("", "username");
        w$b w_b = f3681b;
        w_aG.c = w$b.a(w_b, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        d0.z.d.m.checkParameterIsNotNull("", WidgetSettingsAccountChangePassword.CURRENT_PASSWORD_FIELD);
        w_aG.d = w$b.a(w_b, "", 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, null, 251);
        return w_aG.b().l;
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    public final URI i() {
        w$a w_aF = f();
        String str = w_aF.e;
        w_aF.e = str != null ? new Regex("[\"<>^`{|}]").replace(str, "") : null;
        int size = w_aF.g.size();
        for (int i = 0; i < size; i++) {
            List<String> list = w_aF.g;
            list.set(i, w$b.a(f3681b, list.get(i), 0, 0, "[]", true, true, false, false, null, 227));
        }
        List<String> list2 = w_aF.h;
        if (list2 != null) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                String str2 = list2.get(i2);
                list2.set(i2, str2 != null ? w$b.a(f3681b, str2, 0, 0, "\\^`{|}", true, true, true, false, null, Opcodes.MONITOREXIT) : null);
            }
        }
        String str3 = w_aF.i;
        w_aF.i = str3 != null ? w$b.a(f3681b, str3, 0, 0, " \"#<>\\^`{|}", true, true, false, true, null, Opcodes.IF_ICMPGT) : null;
        String string = w_aF.toString();
        try {
            return new URI(string);
        } catch (URISyntaxException e) {
            try {
                URI uriCreate = URI.create(new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(string, ""));
                d0.z.d.m.checkExpressionValueIsNotNull(uriCreate, "URI.create(stripped)");
                return uriCreate;
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public String toString() {
        return this.l;
    }
}
