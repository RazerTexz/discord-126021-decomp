package b.i.a.c.b3.o;

import b.i.a.c.b3.SimpleSubtitleDecoder2;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.o.a, reason: use source file name */
/* JADX INFO: compiled from: DvbDecoder.java */
/* JADX INFO: loaded from: classes3.dex */
public final class DvbDecoder extends SimpleSubtitleDecoder2 {
    public final DvbParser n;

    public DvbDecoder(List<byte[]> list) {
        super("DvbDecoder");
        byte[] bArr = list.get(0);
        int length = bArr.length;
        int i = 0 + 1;
        int i2 = i + 1;
        int i3 = ((bArr[0] & 255) << 8) | (bArr[i] & 255);
        int i4 = i2 + 1;
        this.n = new DvbParser(i3, (bArr[i4] & 255) | ((bArr[i2] & 255) << 8));
    }

    /*  JADX ERROR: JadxRuntimeException in pass: ModVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r2v0 b.i.a.c.b3.o.c, still in use, count: 2, list:
          (r2v0 b.i.a.c.b3.o.c) from 0x027e: PHI (r2v1 b.i.a.c.b3.o.c) = (r2v0 b.i.a.c.b3.o.c), (r2v4 b.i.a.c.b3.o.c) binds: [B:84:0x0276, B:124:0x03b5] A[DONT_GENERATE, DONT_INLINE]
          (r2v0 b.i.a.c.b3.o.c) from 0x0240: MOVE (r26v6 b.i.a.c.b3.o.c) = (r2v0 b.i.a.c.b3.o.c)
        	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:164)
        	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:129)
        	at jadx.core.utils.InsnRemover.unbindInsn(InsnRemover.java:93)
        	at jadx.core.utils.InsnRemover.addAndUnbind(InsnRemover.java:59)
        	at jadx.core.dex.visitors.ModVisitor.removeStep(ModVisitor.java:463)
        	at jadx.core.dex.visitors.ModVisitor.visit(ModVisitor.java:97)
        */
    @Override // b.i.a.c.b3.SimpleSubtitleDecoder2
    public b.i.a.c.b3.Subtitle j(byte[] r48, int r49, boolean r50) {
        /*
            Method dump skipped, instruction units count: 1070
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b.i.a.c.b3.o.DvbDecoder.j(byte[], int, boolean):b.i.a.c.b3.g");
    }
}
