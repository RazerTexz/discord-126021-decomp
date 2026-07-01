package b.g.a.b.t;

import java.io.IOException;

/* JADX INFO: compiled from: DefaultIndenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class c extends d$c {
    public static final String j;
    public static final c k;
    private static final long serialVersionUID = 1;
    private final int charsPerLevel;
    private final String eol;
    private final char[] indents;

    static {
        String property;
        try {
            property = System.getProperty("line.separator");
        } catch (Throwable unused) {
            property = "\n";
        }
        j = property;
        k = new c("  ", property);
    }

    public c() {
        this("  ", j);
    }

    @Override // b.g.a.b.t.d$b
    public void a(b.g.a.b.d dVar, int i) throws IOException {
        dVar.T(this.eol);
        if (i <= 0) {
            return;
        }
        int length = i * this.charsPerLevel;
        while (true) {
            char[] cArr = this.indents;
            if (length <= cArr.length) {
                dVar.U(cArr, 0, length);
                return;
            } else {
                dVar.U(cArr, 0, cArr.length);
                length -= this.indents.length;
            }
        }
    }

    public c(String str, String str2) {
        this.charsPerLevel = str.length();
        this.indents = new char[str.length() * 16];
        int length = 0;
        for (int i = 0; i < 16; i++) {
            str.getChars(0, str.length(), this.indents, length);
            length += str.length();
        }
        this.eol = str2;
    }
}
