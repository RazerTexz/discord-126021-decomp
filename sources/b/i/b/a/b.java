package b.i.b.a;

/* JADX INFO: compiled from: CharMatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class b implements h<Character> {
    public int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        b.i.a.f.e.o.f.C(i, length);
        while (i < length) {
            if (b(charSequence.charAt(i))) {
                return i;
            }
            i++;
        }
        return -1;
    }

    public abstract boolean b(char c);
}
