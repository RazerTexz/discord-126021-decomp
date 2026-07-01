package h0.a.a;

/* JADX INFO: compiled from: Attribute.java */
/* JADX INFO: loaded from: classes3.dex */
public final class b$a {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b[] f3698b = new b[6];

    public void a(b bVar) {
        boolean z2;
        while (bVar != null) {
            int i = 0;
            while (true) {
                if (i >= this.a) {
                    z2 = false;
                    break;
                } else {
                    if (this.f3698b[i].a.equals(bVar.a)) {
                        z2 = true;
                        break;
                    }
                    i++;
                }
            }
            if (!z2) {
                int i2 = this.a;
                b[] bVarArr = this.f3698b;
                if (i2 >= bVarArr.length) {
                    b[] bVarArr2 = new b[bVarArr.length + 6];
                    System.arraycopy(bVarArr, 0, bVarArr2, 0, i2);
                    this.f3698b = bVarArr2;
                }
                b[] bVarArr3 = this.f3698b;
                int i3 = this.a;
                this.a = i3 + 1;
                bVarArr3[i3] = bVar;
            }
            bVar = bVar.c;
        }
    }
}
