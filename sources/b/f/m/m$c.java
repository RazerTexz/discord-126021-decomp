package b.f.m;

import java.io.DataInput;
import java.io.IOException;

/* JADX INFO: compiled from: UnpackingSoSource.java */
/* JADX INFO: loaded from: classes3.dex */
public final class m$c {
    public final m$b[] a;

    public m$c(m$b[] m_bArr) {
        this.a = m_bArr;
    }

    public static final m$c a(DataInput dataInput) throws IOException {
        if (dataInput.readByte() != 1) {
            throw new RuntimeException("wrong dso manifest version");
        }
        int i = dataInput.readInt();
        if (i < 0) {
            throw new RuntimeException("illegal number of shared libraries");
        }
        m$b[] m_bArr = new m$b[i];
        for (int i2 = 0; i2 < i; i2++) {
            m_bArr[i2] = new m$b(dataInput.readUTF(), dataInput.readUTF());
        }
        return new m$c(m_bArr);
    }
}
