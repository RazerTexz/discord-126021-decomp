package p007b.p225i.p355b.p356a;

import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3404f;

/* JADX INFO: renamed from: b.i.b.a.b */
/* JADX INFO: compiled from: CharMatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4482b implements InterfaceC4488h<Character> {

    /* JADX INFO: renamed from: b.i.b.a.b$a */
    /* JADX INFO: compiled from: CharMatcher.java */
    public static abstract class a extends AbstractC4482b {
        @Override // p007b.p225i.p355b.p356a.InterfaceC4488h
        @Deprecated
        public boolean apply(Character ch) {
            return mo6210b(ch.charValue());
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.b$b */
    /* JADX INFO: compiled from: CharMatcher.java */
    public static final class b extends a {

        /* JADX INFO: renamed from: a */
        public final char f11940a;

        public b(char c) {
            this.f11940a = c;
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4482b
        /* JADX INFO: renamed from: b */
        public boolean mo6210b(char c) {
            return c == this.f11940a;
        }

        public String toString() {
            StringBuilder sbM833U = C1643a.m833U("CharMatcher.is('");
            char c = this.f11940a;
            char[] cArr = {'\\', 'u', 0, 0, 0, 0};
            for (int i = 0; i < 4; i++) {
                cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
                c = (char) (c >> 4);
            }
            sbM833U.append(String.copyValueOf(cArr));
            sbM833U.append("')");
            return sbM833U.toString();
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.b$c */
    /* JADX INFO: compiled from: CharMatcher.java */
    public static abstract class c extends a {

        /* JADX INFO: renamed from: a */
        public final String f11941a;

        public c(String str) {
            this.f11941a = str;
        }

        public final String toString() {
            return this.f11941a;
        }
    }

    /* JADX INFO: renamed from: b.i.b.a.b$d */
    /* JADX INFO: compiled from: CharMatcher.java */
    public static final class d extends c {

        /* JADX INFO: renamed from: b */
        public static final d f11942b = new d();

        public d() {
            super("CharMatcher.none()");
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4482b
        /* JADX INFO: renamed from: a */
        public int mo6209a(CharSequence charSequence, int i) {
            C3404f.m4195C(i, charSequence.length());
            return -1;
        }

        @Override // p007b.p225i.p355b.p356a.AbstractC4482b
        /* JADX INFO: renamed from: b */
        public boolean mo6210b(char c) {
            return false;
        }
    }

    /* JADX INFO: renamed from: a */
    public int mo6209a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        C3404f.m4195C(i, length);
        while (i < length) {
            if (mo6210b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    /* JADX INFO: renamed from: b */
    public abstract boolean mo6210b(char c2);
}
