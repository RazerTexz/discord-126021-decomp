package p007b.p225i.p414e;

import com.discord.widgets.chat.input.MentionUtilsKt;

/* JADX INFO: renamed from: b.i.e.f */
/* JADX INFO: compiled from: LuminanceSource.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC4951f {

    /* JADX INFO: renamed from: a */
    public final int f13186a;

    /* JADX INFO: renamed from: b */
    public final int f13187b;

    public AbstractC4951f(int i, int i2) {
        this.f13186a = i;
        this.f13187b = i2;
    }

    /* JADX INFO: renamed from: a */
    public abstract byte[] mo6915a();

    /* JADX INFO: renamed from: b */
    public abstract byte[] mo6916b(int i, byte[] bArr);

    /* JADX INFO: renamed from: c */
    public boolean mo6917c() {
        return false;
    }

    /* JADX INFO: renamed from: d */
    public AbstractC4951f mo6918d() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public final String toString() {
        char c;
        int i = this.f13186a;
        byte[] bArrMo6916b = new byte[i];
        StringBuilder sb = new StringBuilder((i + 1) * this.f13187b);
        for (int i2 = 0; i2 < this.f13187b; i2++) {
            bArrMo6916b = mo6916b(i2, bArrMo6916b);
            for (int i3 = 0; i3 < this.f13186a; i3++) {
                int i4 = bArrMo6916b[i3] & 255;
                if (i4 < 64) {
                    c = MentionUtilsKt.CHANNELS_CHAR;
                } else if (i4 < 128) {
                    c = '+';
                } else {
                    c = i4 < 192 ? '.' : ' ';
                }
                sb.append(c);
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
