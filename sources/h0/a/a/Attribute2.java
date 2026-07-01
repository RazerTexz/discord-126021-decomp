package h0.a.a;

import b.d.b.a.outline;

/* JADX INFO: renamed from: h0.a.a.b, reason: use source file name */
/* JADX INFO: compiled from: Attribute.java */
/* JADX INFO: loaded from: classes3.dex */
public class Attribute2 {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public byte[] f3697b;
    public Attribute2 c;

    /* JADX INFO: renamed from: h0.a.a.b$a */
    /* JADX INFO: compiled from: Attribute.java */
    public static final class a {
        public int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public Attribute2[] f3698b = new Attribute2[6];

        public void a(Attribute2 attribute2) {
            boolean z2;
            while (attribute2 != null) {
                int i = 0;
                while (true) {
                    if (i >= this.a) {
                        z2 = false;
                        break;
                    } else {
                        if (this.f3698b[i].a.equals(attribute2.a)) {
                            z2 = true;
                            break;
                        }
                        i++;
                    }
                }
                if (!z2) {
                    int i2 = this.a;
                    Attribute2[] attribute2Arr = this.f3698b;
                    if (i2 >= attribute2Arr.length) {
                        Attribute2[] attribute2Arr2 = new Attribute2[attribute2Arr.length + 6];
                        System.arraycopy(attribute2Arr, 0, attribute2Arr2, 0, i2);
                        this.f3698b = attribute2Arr2;
                    }
                    Attribute2[] attribute2Arr3 = this.f3698b;
                    int i3 = this.a;
                    this.a = i3 + 1;
                    attribute2Arr3[i3] = attribute2;
                }
                attribute2 = attribute2.c;
            }
        }
    }

    public Attribute2(String str) {
        this.a = str;
    }

    public final int a(SymbolTable2 symbolTable2) {
        return b(symbolTable2, null, 0, -1, -1);
    }

    public final int b(SymbolTable2 symbolTable2, byte[] bArr, int i, int i2, int i3) {
        ClassWriter2 classWriter2 = symbolTable2.a;
        int length = 0;
        for (Attribute2 attribute2 = this; attribute2 != null; attribute2 = attribute2.c) {
            symbolTable2.l(attribute2.a);
            length += attribute2.f3697b.length + 6;
        }
        return length;
    }

    public final int c() {
        int i = 0;
        for (Attribute2 attribute2 = this; attribute2 != null; attribute2 = attribute2.c) {
            i++;
        }
        return i;
    }

    public final void d(SymbolTable2 symbolTable2, ByteVector2 byteVector2) {
        e(symbolTable2, null, 0, -1, -1, byteVector2);
    }

    public final void e(SymbolTable2 symbolTable2, byte[] bArr, int i, int i2, int i3, ByteVector2 byteVector2) {
        ClassWriter2 classWriter2 = symbolTable2.a;
        for (Attribute2 attribute2 = this; attribute2 != null; attribute2 = attribute2.c) {
            byte[] bArr2 = attribute2.f3697b;
            int length = bArr2.length;
            outline.t0(symbolTable2, attribute2.a, byteVector2, length);
            byteVector2.h(bArr2, 0, length);
        }
    }
}
