package h0.a.a;

/* JADX INFO: compiled from: Attribute.java */
/* JADX INFO: loaded from: classes3.dex */
public class b {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f3697b;
    public b c;

    public b(String str) {
        this.a = str;
    }

    public final int a(v vVar) {
        return b(vVar, null, 0, -1, -1);
    }

    public final int b(v vVar, byte[] bArr, int i, int i2, int i3) {
        f fVar = vVar.a;
        int length = 0;
        for (b bVar = this; bVar != null; bVar = bVar.c) {
            vVar.l(bVar.a);
            length += bVar.f3697b.length + 6;
        }
        return length;
    }

    public final int c() {
        int i = 0;
        for (b bVar = this; bVar != null; bVar = bVar.c) {
            i++;
        }
        return i;
    }

    public final void d(v vVar, c cVar) {
        e(vVar, null, 0, -1, -1, cVar);
    }

    public final void e(v vVar, byte[] bArr, int i, int i2, int i3, c cVar) {
        f fVar = vVar.a;
        for (b bVar = this; bVar != null; bVar = bVar.c) {
            byte[] bArr2 = bVar.f3697b;
            int length = bArr2.length;
            b.d.b.a.a.t0(vVar, bVar.a, cVar, length);
            cVar.h(bArr2, 0, length);
        }
    }
}
