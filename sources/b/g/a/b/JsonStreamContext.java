package b.g.a.b;

import b.g.a.b.p.CharTypes;
import com.discord.widgets.chat.input.autocomplete.AutocompleteViewModel;

/* JADX INFO: renamed from: b.g.a.b.g, reason: use source file name */
/* JADX INFO: compiled from: JsonStreamContext.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class JsonStreamContext {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f661b;

    public JsonStreamContext() {
    }

    public abstract String a();

    public final boolean b() {
        return this.a == 1;
    }

    public final boolean c() {
        return this.a == 2;
    }

    public abstract void d(Object obj);

    public String e() {
        int i = this.a;
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
        int i = this.a;
        if (i != 0) {
            if (i != 1) {
                sb.append('{');
                String strA = a();
                if (strA != null) {
                    sb.append('\"');
                    int[] iArr = CharTypes.f;
                    int length = iArr.length;
                    int length2 = strA.length();
                    for (int i2 = 0; i2 < length2; i2++) {
                        char cCharAt = strA.charAt(i2);
                        if (cCharAt >= length || iArr[cCharAt] == 0) {
                            sb.append(cCharAt);
                        } else {
                            sb.append('\\');
                            int i3 = iArr[cCharAt];
                            if (i3 < 0) {
                                sb.append('u');
                                sb.append('0');
                                sb.append('0');
                                char[] cArr = CharTypes.a;
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
                int i4 = this.f661b;
                sb.append(i4 >= 0 ? i4 : 0);
                sb.append(']');
            }
        } else {
            sb.append(AutocompleteViewModel.COMMAND_DISCOVER_TOKEN);
        }
        return sb.toString();
    }

    public JsonStreamContext(int i, int i2) {
        this.a = i;
        this.f661b = i2;
    }
}
