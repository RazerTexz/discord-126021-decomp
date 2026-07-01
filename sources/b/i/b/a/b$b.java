package b.i.b.a;

/* JADX INFO: compiled from: CharMatcher.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$b extends b$a {
    public final char a;

    public b$b(char c) {
        this.a = c;
    }

    @Override // b.i.b.a.b
    public boolean b(char c) {
        return c == this.a;
    }

    public String toString() {
        StringBuilder sbU = b.d.b.a.a.U("CharMatcher.is('");
        char c = this.a;
        char[] cArr = {'\\', 'u', 0, 0, 0, 0};
        for (int i = 0; i < 4; i++) {
            cArr[5 - i] = "0123456789ABCDEF".charAt(c & 15);
            c = (char) (c >> 4);
        }
        sbU.append(String.copyValueOf(cArr));
        sbU.append("')");
        return sbU.toString();
    }
}
