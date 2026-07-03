package p600f0;

import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;
import p507d0.p579g0.C12103t;
import p507d0.p579g0.C12106w;
import p507d0.p592z.p594d.C12238m;
import p600f0.p601e0.C12272c;

/* JADX INFO: renamed from: f0.d */
/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class C12267d {

    /* JADX INFO: renamed from: a */
    public static final a f25373a = new a(null);

    /* JADX INFO: renamed from: b */
    public final boolean f25374b;

    /* JADX INFO: renamed from: c */
    public final boolean f25375c;

    /* JADX INFO: renamed from: d */
    public final int f25376d;

    /* JADX INFO: renamed from: e */
    public final int f25377e;

    /* JADX INFO: renamed from: f */
    public final boolean f25378f;

    /* JADX INFO: renamed from: g */
    public final boolean f25379g;

    /* JADX INFO: renamed from: h */
    public final boolean f25380h;

    /* JADX INFO: renamed from: i */
    public final int f25381i;

    /* JADX INFO: renamed from: j */
    public final int f25382j;

    /* JADX INFO: renamed from: k */
    public final boolean f25383k;

    /* JADX INFO: renamed from: l */
    public final boolean f25384l;

    /* JADX INFO: renamed from: m */
    public final boolean f25385m;

    /* JADX INFO: renamed from: n */
    public String f25386n;

    /* JADX INFO: renamed from: f0.d$a */
    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        /* JADX INFO: renamed from: a */
        public final int m10107a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (C12106w.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
                    return i;
                }
                i++;
            }
            return str.length();
        }

        /* JADX WARN: Code duplicated, block: B:110:0x0193 A[SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:15:0x004a  */
        /* JADX WARN: Code duplicated, block: B:17:0x005d  */
        /* JADX WARN: Code duplicated, block: B:19:0x006d  */
        /* JADX WARN: Code duplicated, block: B:43:0x00f5  */
        /* JADX WARN: Code duplicated, block: B:47:0x0104  */
        /* JADX WARN: Code duplicated, block: B:48:0x0108  */
        /* JADX WARN: Code duplicated, block: B:50:0x0110  */
        /* JADX WARN: Code duplicated, block: B:51:0x0114  */
        /* JADX WARN: Code duplicated, block: B:53:0x011c  */
        /* JADX WARN: Code duplicated, block: B:54:0x0123  */
        /* JADX WARN: Code duplicated, block: B:56:0x012c  */
        /* JADX WARN: Code duplicated, block: B:57:0x0131  */
        /* JADX WARN: Code duplicated, block: B:59:0x0139  */
        /* JADX WARN: Code duplicated, block: B:60:0x013c  */
        /* JADX WARN: Code duplicated, block: B:62:0x0144  */
        /* JADX WARN: Code duplicated, block: B:63:0x0147  */
        /* JADX WARN: Code duplicated, block: B:65:0x014f  */
        /* JADX WARN: Code duplicated, block: B:66:0x0153  */
        /* JADX WARN: Code duplicated, block: B:68:0x015b  */
        /* JADX WARN: Code duplicated, block: B:69:0x0164  */
        /* JADX WARN: Code duplicated, block: B:71:0x016c  */
        /* JADX WARN: Code duplicated, block: B:72:0x0172  */
        /* JADX WARN: Code duplicated, block: B:74:0x017b  */
        /* JADX WARN: Code duplicated, block: B:75:0x017e  */
        /* JADX WARN: Code duplicated, block: B:77:0x0186  */
        /* JADX WARN: Code duplicated, block: B:78:0x0189  */
        /* JADX WARN: Code duplicated, block: B:80:0x0191  */
        /* JADX WARN: Code duplicated, block: B:93:0x019c A[SYNTHETIC] */
        /* JADX INFO: renamed from: b */
        public final C12267d m10108b(Headers headers) {
            int i;
            int i2;
            int iM10107a;
            String strSubstring;
            String string;
            boolean z2;
            int i3;
            String string2;
            Headers headers2 = headers;
            C12238m.checkParameterIsNotNull(headers2, "headers");
            int size = headers.size();
            boolean z3 = true;
            int i4 = 0;
            boolean z4 = true;
            String str = null;
            boolean z5 = false;
            boolean z6 = false;
            int iM10117B = -1;
            int iM10117B2 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int iM10117B3 = -1;
            int iM10117B4 = -1;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            while (i4 < size) {
                String strM10955d = headers2.m10955d(i4);
                String strM10957g = headers2.m10957g(i4);
                if (C12103t.equals(strM10955d, "Cache-Control", z3)) {
                    if (str == null) {
                        str = strM10957g;
                    }
                    i2 = 0;
                    while (i2 < strM10957g.length()) {
                        iM10107a = m10107a(strM10957g, "=,;", i2);
                        strSubstring = strM10957g.substring(i2, iM10107a);
                        C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = C12106w.trim(strSubstring).toString();
                        int i5 = size;
                        if (iM10107a != strM10957g.length()) {
                            z2 = z4;
                            if (strM10957g.charAt(iM10107a) == ',' && strM10957g.charAt(iM10107a) != ';') {
                                int length = iM10107a + 1;
                                byte[] bArr = C12272c.f25397a;
                                C12238m.checkParameterIsNotNull(strM10957g, "$this$indexOfNonWhitespace");
                                int length2 = strM10957g.length();
                                while (true) {
                                    if (length >= length2) {
                                        length = strM10957g.length();
                                        break;
                                    }
                                    char cCharAt = strM10957g.charAt(length);
                                    int i6 = length2;
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length++;
                                    length2 = i6;
                                }
                                if (length >= strM10957g.length() || strM10957g.charAt(length) != '\"') {
                                    int iM10107a2 = m10107a(strM10957g, ",;", length);
                                    String strSubstring2 = strM10957g.substring(length, iM10107a2);
                                    C12238m.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = C12106w.trim(strSubstring2).toString();
                                    i3 = iM10107a2;
                                } else {
                                    int i7 = length + 1;
                                    int iIndexOf$default = C12106w.indexOf$default((CharSequence) strM10957g, '\"', i7, false, 4, (Object) null);
                                    string2 = strM10957g.substring(i7, iIndexOf$default);
                                    C12238m.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    i3 = iIndexOf$default + 1;
                                }
                            }
                            z3 = true;
                            if (C12103t.equals("no-cache", string, true)) {
                                z5 = true;
                            } else if (C12103t.equals("no-store", string, true)) {
                                z6 = true;
                            } else if (C12103t.equals("max-age", string, true)) {
                                iM10117B = C12272c.m10117B(string2, -1);
                            } else if (C12103t.equals("s-maxage", string, true)) {
                                iM10117B2 = C12272c.m10117B(string2, -1);
                            } else if (C12103t.equals("private", string, true)) {
                                z7 = true;
                            } else if (C12103t.equals("public", string, true)) {
                                z8 = true;
                            } else if (C12103t.equals("must-revalidate", string, true)) {
                                z9 = true;
                            } else if (C12103t.equals("max-stale", string, true)) {
                                iM10117B3 = C12272c.m10117B(string2, Integer.MAX_VALUE);
                            } else if (C12103t.equals("min-fresh", string, true)) {
                                iM10117B4 = C12272c.m10117B(string2, -1);
                            } else if (C12103t.equals("only-if-cached", string, true)) {
                                z10 = true;
                            } else if (C12103t.equals("no-transform", string, true)) {
                                z11 = true;
                            } else if (C12103t.equals("immutable", string, true)) {
                                z12 = true;
                            }
                            i2 = i3;
                            size = i5;
                            z4 = z2;
                        } else {
                            z2 = z4;
                        }
                        i3 = iM10107a + 1;
                        string2 = null;
                        z3 = true;
                        if (C12103t.equals("no-cache", string, true)) {
                            z5 = true;
                        } else if (C12103t.equals("no-store", string, true)) {
                            z6 = true;
                        } else if (C12103t.equals("max-age", string, true)) {
                            iM10117B = C12272c.m10117B(string2, -1);
                        } else if (C12103t.equals("s-maxage", string, true)) {
                            iM10117B2 = C12272c.m10117B(string2, -1);
                        } else if (C12103t.equals("private", string, true)) {
                            z7 = true;
                        } else if (C12103t.equals("public", string, true)) {
                            z8 = true;
                        } else if (C12103t.equals("must-revalidate", string, true)) {
                            z9 = true;
                        } else if (C12103t.equals("max-stale", string, true)) {
                            iM10117B3 = C12272c.m10117B(string2, Integer.MAX_VALUE);
                        } else if (C12103t.equals("min-fresh", string, true)) {
                            iM10117B4 = C12272c.m10117B(string2, -1);
                        } else if (C12103t.equals("only-if-cached", string, true)) {
                            z10 = true;
                        } else if (C12103t.equals("no-transform", string, true)) {
                            z11 = true;
                        } else if (C12103t.equals("immutable", string, true)) {
                            z12 = true;
                        }
                        i2 = i3;
                        size = i5;
                        z4 = z2;
                    }
                    i = size;
                    i4++;
                    headers2 = headers;
                    size = i;
                } else {
                    if (!C12103t.equals(strM10955d, "Pragma", z3)) {
                        i = size;
                    }
                    i4++;
                    headers2 = headers;
                    size = i;
                }
                z4 = false;
                i2 = 0;
                while (i2 < strM10957g.length()) {
                    iM10107a = m10107a(strM10957g, "=,;", i2);
                    strSubstring = strM10957g.substring(i2, iM10107a);
                    C12238m.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring != null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = C12106w.trim(strSubstring).toString();
                    int i8 = size;
                    if (iM10107a != strM10957g.length()) {
                        z2 = z4;
                        if (strM10957g.charAt(iM10107a) == ',') {
                        }
                        z3 = true;
                        if (C12103t.equals("no-cache", string, true)) {
                            z5 = true;
                        } else if (C12103t.equals("no-store", string, true)) {
                            z6 = true;
                        } else if (C12103t.equals("max-age", string, true)) {
                            iM10117B = C12272c.m10117B(string2, -1);
                        } else if (C12103t.equals("s-maxage", string, true)) {
                            iM10117B2 = C12272c.m10117B(string2, -1);
                        } else if (C12103t.equals("private", string, true)) {
                            z7 = true;
                        } else if (C12103t.equals("public", string, true)) {
                            z8 = true;
                        } else if (C12103t.equals("must-revalidate", string, true)) {
                            z9 = true;
                        } else if (C12103t.equals("max-stale", string, true)) {
                            iM10117B3 = C12272c.m10117B(string2, Integer.MAX_VALUE);
                        } else if (C12103t.equals("min-fresh", string, true)) {
                            iM10117B4 = C12272c.m10117B(string2, -1);
                        } else if (C12103t.equals("only-if-cached", string, true)) {
                            z10 = true;
                        } else if (C12103t.equals("no-transform", string, true)) {
                            z11 = true;
                        } else if (C12103t.equals("immutable", string, true)) {
                            z12 = true;
                        }
                        i2 = i3;
                        size = i8;
                        z4 = z2;
                    } else {
                        z2 = z4;
                    }
                    i3 = iM10107a + 1;
                    string2 = null;
                    z3 = true;
                    if (C12103t.equals("no-cache", string, true)) {
                        z5 = true;
                    } else if (C12103t.equals("no-store", string, true)) {
                        z6 = true;
                    } else if (C12103t.equals("max-age", string, true)) {
                        iM10117B = C12272c.m10117B(string2, -1);
                    } else if (C12103t.equals("s-maxage", string, true)) {
                        iM10117B2 = C12272c.m10117B(string2, -1);
                    } else if (C12103t.equals("private", string, true)) {
                        z7 = true;
                    } else if (C12103t.equals("public", string, true)) {
                        z8 = true;
                    } else if (C12103t.equals("must-revalidate", string, true)) {
                        z9 = true;
                    } else if (C12103t.equals("max-stale", string, true)) {
                        iM10117B3 = C12272c.m10117B(string2, Integer.MAX_VALUE);
                    } else if (C12103t.equals("min-fresh", string, true)) {
                        iM10117B4 = C12272c.m10117B(string2, -1);
                    } else if (C12103t.equals("only-if-cached", string, true)) {
                        z10 = true;
                    } else if (C12103t.equals("no-transform", string, true)) {
                        z11 = true;
                    } else if (C12103t.equals("immutable", string, true)) {
                        z12 = true;
                    }
                    i2 = i3;
                    size = i8;
                    z4 = z2;
                }
                i = size;
                i4++;
                headers2 = headers;
                size = i;
            }
            return new C12267d(z5, z6, iM10117B, iM10117B2, z7, z8, z9, iM10117B3, iM10117B4, z10, z11, z12, !z4 ? null : str, null);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        C12238m.checkParameterIsNotNull(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public C12267d(boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, int i4, boolean z7, boolean z8, boolean z9, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f25374b = z2;
        this.f25375c = z3;
        this.f25376d = i;
        this.f25377e = i2;
        this.f25378f = z4;
        this.f25379g = z5;
        this.f25380h = z6;
        this.f25381i = i3;
        this.f25382j = i4;
        this.f25383k = z7;
        this.f25384l = z8;
        this.f25385m = z9;
        this.f25386n = str;
    }

    public String toString() {
        String str = this.f25386n;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f25374b) {
            sb.append("no-cache, ");
        }
        if (this.f25375c) {
            sb.append("no-store, ");
        }
        if (this.f25376d != -1) {
            sb.append("max-age=");
            sb.append(this.f25376d);
            sb.append(", ");
        }
        if (this.f25377e != -1) {
            sb.append("s-maxage=");
            sb.append(this.f25377e);
            sb.append(", ");
        }
        if (this.f25378f) {
            sb.append("private, ");
        }
        if (this.f25379g) {
            sb.append("public, ");
        }
        if (this.f25380h) {
            sb.append("must-revalidate, ");
        }
        if (this.f25381i != -1) {
            sb.append("max-stale=");
            sb.append(this.f25381i);
            sb.append(", ");
        }
        if (this.f25382j != -1) {
            sb.append("min-fresh=");
            sb.append(this.f25382j);
            sb.append(", ");
        }
        if (this.f25383k) {
            sb.append("only-if-cached, ");
        }
        if (this.f25384l) {
            sb.append("no-transform, ");
        }
        if (this.f25385m) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        C12238m.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        this.f25386n = string;
        return string;
    }
}
