package f0;

import d0.g0.Strings4;
import d0.g0.StringsJVM;
import d0.z.d.Intrinsics3;
import f0.e0.Util7;
import java.util.concurrent.TimeUnit;
import kotlin.TypeCastException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import okhttp3.Headers;

/* JADX INFO: renamed from: f0.d, reason: use source file name */
/* JADX INFO: compiled from: CacheControl.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class CacheControl {
    public static final a a = new a(null);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f3604b;
    public final boolean c;
    public final int d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final boolean h;
    public final int i;
    public final int j;
    public final boolean k;
    public final boolean l;
    public final boolean m;
    public String n;

    /* JADX INFO: renamed from: f0.d$a */
    /* JADX INFO: compiled from: CacheControl.kt */
    public static final class a {
        public a(DefaultConstructorMarker defaultConstructorMarker) {
        }

        public final int a(String str, String str2, int i) {
            int length = str.length();
            while (i < length) {
                if (Strings4.contains$default((CharSequence) str2, str.charAt(i), false, 2, (Object) null)) {
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
        public final CacheControl b(Headers headers) {
            int i;
            int i2;
            int iA;
            String strSubstring;
            String string;
            boolean z2;
            int i3;
            String string2;
            Headers headers2 = headers;
            Intrinsics3.checkParameterIsNotNull(headers2, "headers");
            int size = headers.size();
            boolean z3 = true;
            int i4 = 0;
            boolean z4 = true;
            String str = null;
            boolean z5 = false;
            boolean z6 = false;
            int iB = -1;
            int iB2 = -1;
            boolean z7 = false;
            boolean z8 = false;
            boolean z9 = false;
            int iB3 = -1;
            int iB4 = -1;
            boolean z10 = false;
            boolean z11 = false;
            boolean z12 = false;
            while (i4 < size) {
                String strD = headers2.d(i4);
                String strG = headers2.g(i4);
                if (StringsJVM.equals(strD, "Cache-Control", z3)) {
                    if (str == null) {
                        str = strG;
                    }
                    i2 = 0;
                    while (i2 < strG.length()) {
                        iA = a(strG, "=,;", i2);
                        strSubstring = strG.substring(i2, iA);
                        Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                        if (strSubstring != null) {
                            throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                        }
                        string = Strings4.trim(strSubstring).toString();
                        int i5 = size;
                        if (iA != strG.length()) {
                            z2 = z4;
                            if (strG.charAt(iA) == ',' && strG.charAt(iA) != ';') {
                                int length = iA + 1;
                                byte[] bArr = Util7.a;
                                Intrinsics3.checkParameterIsNotNull(strG, "$this$indexOfNonWhitespace");
                                int length2 = strG.length();
                                while (true) {
                                    if (length >= length2) {
                                        length = strG.length();
                                        break;
                                    }
                                    char cCharAt = strG.charAt(length);
                                    int i6 = length2;
                                    if (cCharAt != ' ' && cCharAt != '\t') {
                                        break;
                                    }
                                    length++;
                                    length2 = i6;
                                }
                                if (length >= strG.length() || strG.charAt(length) != '\"') {
                                    int iA2 = a(strG, ",;", length);
                                    String strSubstring2 = strG.substring(length, iA2);
                                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    if (strSubstring2 == null) {
                                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                                    }
                                    string2 = Strings4.trim(strSubstring2).toString();
                                    i3 = iA2;
                                } else {
                                    int i7 = length + 1;
                                    int iIndexOf$default = Strings4.indexOf$default((CharSequence) strG, '\"', i7, false, 4, (Object) null);
                                    string2 = strG.substring(i7, iIndexOf$default);
                                    Intrinsics3.checkExpressionValueIsNotNull(string2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                                    i3 = iIndexOf$default + 1;
                                }
                            }
                            z3 = true;
                            if (StringsJVM.equals("no-cache", string, true)) {
                                z5 = true;
                            } else if (StringsJVM.equals("no-store", string, true)) {
                                z6 = true;
                            } else if (StringsJVM.equals("max-age", string, true)) {
                                iB = Util7.B(string2, -1);
                            } else if (StringsJVM.equals("s-maxage", string, true)) {
                                iB2 = Util7.B(string2, -1);
                            } else if (StringsJVM.equals("private", string, true)) {
                                z7 = true;
                            } else if (StringsJVM.equals("public", string, true)) {
                                z8 = true;
                            } else if (StringsJVM.equals("must-revalidate", string, true)) {
                                z9 = true;
                            } else if (StringsJVM.equals("max-stale", string, true)) {
                                iB3 = Util7.B(string2, Integer.MAX_VALUE);
                            } else if (StringsJVM.equals("min-fresh", string, true)) {
                                iB4 = Util7.B(string2, -1);
                            } else if (StringsJVM.equals("only-if-cached", string, true)) {
                                z10 = true;
                            } else if (StringsJVM.equals("no-transform", string, true)) {
                                z11 = true;
                            } else if (StringsJVM.equals("immutable", string, true)) {
                                z12 = true;
                            }
                            i2 = i3;
                            size = i5;
                            z4 = z2;
                        } else {
                            z2 = z4;
                        }
                        i3 = iA + 1;
                        string2 = null;
                        z3 = true;
                        if (StringsJVM.equals("no-cache", string, true)) {
                            z5 = true;
                        } else if (StringsJVM.equals("no-store", string, true)) {
                            z6 = true;
                        } else if (StringsJVM.equals("max-age", string, true)) {
                            iB = Util7.B(string2, -1);
                        } else if (StringsJVM.equals("s-maxage", string, true)) {
                            iB2 = Util7.B(string2, -1);
                        } else if (StringsJVM.equals("private", string, true)) {
                            z7 = true;
                        } else if (StringsJVM.equals("public", string, true)) {
                            z8 = true;
                        } else if (StringsJVM.equals("must-revalidate", string, true)) {
                            z9 = true;
                        } else if (StringsJVM.equals("max-stale", string, true)) {
                            iB3 = Util7.B(string2, Integer.MAX_VALUE);
                        } else if (StringsJVM.equals("min-fresh", string, true)) {
                            iB4 = Util7.B(string2, -1);
                        } else if (StringsJVM.equals("only-if-cached", string, true)) {
                            z10 = true;
                        } else if (StringsJVM.equals("no-transform", string, true)) {
                            z11 = true;
                        } else if (StringsJVM.equals("immutable", string, true)) {
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
                    if (!StringsJVM.equals(strD, "Pragma", z3)) {
                        i = size;
                    }
                    i4++;
                    headers2 = headers;
                    size = i;
                }
                z4 = false;
                i2 = 0;
                while (i2 < strG.length()) {
                    iA = a(strG, "=,;", i2);
                    strSubstring = strG.substring(i2, iA);
                    Intrinsics3.checkExpressionValueIsNotNull(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    if (strSubstring != null) {
                        throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
                    }
                    string = Strings4.trim(strSubstring).toString();
                    int i8 = size;
                    if (iA != strG.length()) {
                        z2 = z4;
                        if (strG.charAt(iA) == ',') {
                        }
                        z3 = true;
                        if (StringsJVM.equals("no-cache", string, true)) {
                            z5 = true;
                        } else if (StringsJVM.equals("no-store", string, true)) {
                            z6 = true;
                        } else if (StringsJVM.equals("max-age", string, true)) {
                            iB = Util7.B(string2, -1);
                        } else if (StringsJVM.equals("s-maxage", string, true)) {
                            iB2 = Util7.B(string2, -1);
                        } else if (StringsJVM.equals("private", string, true)) {
                            z7 = true;
                        } else if (StringsJVM.equals("public", string, true)) {
                            z8 = true;
                        } else if (StringsJVM.equals("must-revalidate", string, true)) {
                            z9 = true;
                        } else if (StringsJVM.equals("max-stale", string, true)) {
                            iB3 = Util7.B(string2, Integer.MAX_VALUE);
                        } else if (StringsJVM.equals("min-fresh", string, true)) {
                            iB4 = Util7.B(string2, -1);
                        } else if (StringsJVM.equals("only-if-cached", string, true)) {
                            z10 = true;
                        } else if (StringsJVM.equals("no-transform", string, true)) {
                            z11 = true;
                        } else if (StringsJVM.equals("immutable", string, true)) {
                            z12 = true;
                        }
                        i2 = i3;
                        size = i8;
                        z4 = z2;
                    } else {
                        z2 = z4;
                    }
                    i3 = iA + 1;
                    string2 = null;
                    z3 = true;
                    if (StringsJVM.equals("no-cache", string, true)) {
                        z5 = true;
                    } else if (StringsJVM.equals("no-store", string, true)) {
                        z6 = true;
                    } else if (StringsJVM.equals("max-age", string, true)) {
                        iB = Util7.B(string2, -1);
                    } else if (StringsJVM.equals("s-maxage", string, true)) {
                        iB2 = Util7.B(string2, -1);
                    } else if (StringsJVM.equals("private", string, true)) {
                        z7 = true;
                    } else if (StringsJVM.equals("public", string, true)) {
                        z8 = true;
                    } else if (StringsJVM.equals("must-revalidate", string, true)) {
                        z9 = true;
                    } else if (StringsJVM.equals("max-stale", string, true)) {
                        iB3 = Util7.B(string2, Integer.MAX_VALUE);
                    } else if (StringsJVM.equals("min-fresh", string, true)) {
                        iB4 = Util7.B(string2, -1);
                    } else if (StringsJVM.equals("only-if-cached", string, true)) {
                        z10 = true;
                    } else if (StringsJVM.equals("no-transform", string, true)) {
                        z11 = true;
                    } else if (StringsJVM.equals("immutable", string, true)) {
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
            return new CacheControl(z5, z6, iB, iB2, z7, z8, z9, iB3, iB4, z10, z11, z12, !z4 ? null : str, null);
        }
    }

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        Intrinsics3.checkParameterIsNotNull(timeUnit, "timeUnit");
        timeUnit.toSeconds(Integer.MAX_VALUE);
    }

    public CacheControl(boolean z2, boolean z3, int i, int i2, boolean z4, boolean z5, boolean z6, int i3, int i4, boolean z7, boolean z8, boolean z9, String str, DefaultConstructorMarker defaultConstructorMarker) {
        this.f3604b = z2;
        this.c = z3;
        this.d = i;
        this.e = i2;
        this.f = z4;
        this.g = z5;
        this.h = z6;
        this.i = i3;
        this.j = i4;
        this.k = z7;
        this.l = z8;
        this.m = z9;
        this.n = str;
    }

    public String toString() {
        String str = this.n;
        if (str != null) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        if (this.f3604b) {
            sb.append("no-cache, ");
        }
        if (this.c) {
            sb.append("no-store, ");
        }
        if (this.d != -1) {
            sb.append("max-age=");
            sb.append(this.d);
            sb.append(", ");
        }
        if (this.e != -1) {
            sb.append("s-maxage=");
            sb.append(this.e);
            sb.append(", ");
        }
        if (this.f) {
            sb.append("private, ");
        }
        if (this.g) {
            sb.append("public, ");
        }
        if (this.h) {
            sb.append("must-revalidate, ");
        }
        if (this.i != -1) {
            sb.append("max-stale=");
            sb.append(this.i);
            sb.append(", ");
        }
        if (this.j != -1) {
            sb.append("min-fresh=");
            sb.append(this.j);
            sb.append(", ");
        }
        if (this.k) {
            sb.append("only-if-cached, ");
        }
        if (this.l) {
            sb.append("no-transform, ");
        }
        if (this.m) {
            sb.append("immutable, ");
        }
        if (sb.length() == 0) {
            return "";
        }
        sb.delete(sb.length() - 2, sb.length());
        String string = sb.toString();
        Intrinsics3.checkExpressionValueIsNotNull(string, "StringBuilder().apply(builderAction).toString()");
        this.n = string;
        return string;
    }
}
