package lombok.delombok;

import java.io.IOException;
import java.io.Reader;

/* JADX INFO: loaded from: app.apk:lombok/delombok/FormatPreferenceScanner$1.SCL.lombok */
class FormatPreferenceScanner$1 extends Reader {
    int pos = 0;
    int max;
    final /* synthetic */ FormatPreferenceScanner this$0;
    private final /* synthetic */ CharSequence val$source;

    FormatPreferenceScanner$1(FormatPreferenceScanner formatPreferenceScanner, CharSequence charSequence) {
        this.this$0 = formatPreferenceScanner;
        this.val$source = charSequence;
        this.max = charSequence.length();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    @Override // java.io.Reader
    public int read(char[] b2, int p, int len) throws IOException {
        int read = 0;
        if (this.pos >= this.max) {
            return -1;
        }
        for (int i = p; i < p + len; i++) {
            CharSequence charSequence = this.val$source;
            int i2 = this.pos;
            this.pos = i2 + 1;
            b2[i] = charSequence.charAt(i2);
            read++;
            if (this.pos == this.max) {
                return read;
            }
        }
        return len;
    }
}
