package b.i.c.m.d.p;

import com.adjust.sdk.Constants;
import java.io.UnsupportedEncodingException;

/* JADX INFO: compiled from: ByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public final class a {
    public final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public volatile int f1739b = 0;

    public a(byte[] bArr) {
        this.a = bArr;
    }

    public static a a(String str) {
        try {
            return new a(str.getBytes(Constants.ENCODING));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        byte[] bArr = this.a;
        int length = bArr.length;
        byte[] bArr2 = ((a) obj).a;
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
