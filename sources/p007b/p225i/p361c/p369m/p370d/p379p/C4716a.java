package p007b.p225i.p361c.p369m.p370d.p379p;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: b.i.c.m.d.p.a */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C4716a {

    /* JADX INFO: renamed from: a */
    public final byte[] f12684a;

    /* JADX INFO: renamed from: b */
    public volatile int f12685b = 0;

    public C4716a(byte[] bArr) {
        this.f12684a = bArr;
    }

    /* JADX INFO: renamed from: a */
    public static C4716a m6637a(String str) {
        try {
            return new C4716a(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4716a)) {
            return false;
        }
        byte[] bArr = this.f12684a;
        int length = bArr.length;
        byte[] bArr2 = ((C4716a) obj).f12684a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f12685b;
        if (i == 0) {
            byte[] bArr = this.f12684a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i = length == 0 ? 1 : length;
            this.f12685b = i;
        }
        return i;
    }
}
