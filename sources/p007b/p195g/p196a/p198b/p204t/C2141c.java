package p007b.p195g.p196a.p198b.p204t;

import java.io.IOException;
import p007b.p195g.p196a.p198b.AbstractC2108d;
import p007b.p195g.p196a.p198b.p204t.C2142d;

/* JADX INFO: renamed from: b.g.a.b.t.c */
/* JADX INFO: compiled from: DefaultIndenter.java */
/* JADX INFO: loaded from: classes3.dex */
public class C2141c extends C2142d.c {

    /* JADX INFO: renamed from: j */
    public static final String f4597j;

    /* JADX INFO: renamed from: k */
    public static final C2141c f4598k;
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
        f4597j = property;
        f4598k = new C2141c("  ", property);
    }

    public C2141c() {
        this("  ", f4597j);
    }

    @Override // p007b.p195g.p196a.p198b.p204t.C2142d.b
    /* JADX INFO: renamed from: a */
    public void mo1731a(AbstractC2108d abstractC2108d, int i) throws IOException {
        abstractC2108d.mo1642T(this.eol);
        if (i <= 0) {
            return;
        }
        int length = i * this.charsPerLevel;
        while (true) {
            char[] cArr = this.indents;
            if (length <= cArr.length) {
                abstractC2108d.mo1643U(cArr, 0, length);
                return;
            } else {
                abstractC2108d.mo1643U(cArr, 0, cArr.length);
                length -= this.indents.length;
            }
        }
    }

    public C2141c(String str, String str2) {
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
