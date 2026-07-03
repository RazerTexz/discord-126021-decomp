package p007b.p195g.p196a.p198b;

import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;
import p007b.p195g.p196a.p198b.p200p.C2121a;

/* JADX INFO: renamed from: b.g.a.b.g */
/* JADX INFO: compiled from: JsonStreamContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC2111g {

    /* JADX INFO: renamed from: a */
    public int f4503a;

    /* JADX INFO: renamed from: b */
    public int f4504b;

    public AbstractC2111g() {
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo1673a();

    /* JADX INFO: renamed from: b */
    public final boolean m1674b() {
        return this.f4503a == 1;
    }

    /* JADX INFO: renamed from: c */
    public final boolean m1675c() {
        return this.f4503a == 2;
    }

    /* JADX INFO: renamed from: d */
    public abstract void mo1676d(Object obj);

    /* JADX INFO: renamed from: e */
    public String m1677e() {
        int i = this.f4503a;
        if (i == 0) {
            return "root";
        }
        if (i != 1) {
            return i != 2 ? "?" : "Object";
        }
        return "Array";
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(64);
        int i = this.f4503a;
        if (i != 0) {
            if (i != 1) {
                sb.append('{');
                String strMo1673a = mo1673a();
                if (strMo1673a != null) {
                    sb.append('\"');
                    int[] iArr = C2121a.f4541f;
                    int length = iArr.length;
                    int length2 = strMo1673a.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char cCharAt = strMo1673a.charAt(i2);
                        if (cCharAt >= length || iArr[cCharAt] == 0) {
                            sb.append(cCharAt);
                        } else {
                            sb.append('\\');
                            int i3 = iArr[cCharAt];
                            if (i3 < 0) {
                                sb.append('u');
                                sb.append('0');
                                sb.append('0');
                                char[] cArr = C2121a.f4536a;
                                sb.append(cArr[cCharAt >> 4]);
                                sb.append(cArr[cCharAt & 15]);
                            } else {
                                sb.append((char) i3);
                            }
                        }
                    }
                    sb.append('\"');
                } else {
                    sb.append('?');
                }
                sb.append('}');
            } else {
                sb.append('[');
                int i4 = this.f4504b;
                sb.append(i4 >= 0 ? i4 : 0);
                sb.append(']');
            }
        } else {
            sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        }
        return sb.toString();
    }

    public AbstractC2111g(int i, int i2) {
        this.f4503a = i;
        this.f4504b = i2;
    }
}
