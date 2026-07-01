package b.i.c.m.d.p;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;

/* JADX INFO: renamed from: b.i.c.m.d.p.a, reason: use source file name */
/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public final class ByteString2 {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f1739b = 0;

    public ByteString2(byte[] bArr) {
        this.a = bArr;
    }

    public static ByteString2 a(String str) {
        try {
            return new ByteString2(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ByteString2)) {
            return false;
        }
        byte[] bArr = this.a;
        int length = bArr.length;
        byte[] bArr2 = ((ByteString2) obj).a;
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
        int i = this.f1739b;
        if (i == 0) {
            byte[] bArr = this.a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i = length == 0 ? 1 : length;
            this.f1739b = i;
        }
        return i;
    }
}
