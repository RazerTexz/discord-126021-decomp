package b.i.e.r.d;

/* JADX INFO: compiled from: DetectionResultRowIndicatorColumn.java */
/* JADX INFO: loaded from: classes3.dex */
public final class h extends g {
    public final boolean c;

    public h(c cVar, boolean z2) {
        super(cVar);
        this.c = z2;
    }

    public a c() {
        d[] dVarArr = this.f1881b;
        b bVar = new b();
        b bVar2 = new b();
        b bVar3 = new b();
        b bVar4 = new b();
        for (d dVar : dVarArr) {
            if (dVar != null) {
                dVar.b();
                int i = dVar.d % 30;
                int i2 = dVar.e;
                if (!this.c) {
                    i2 += 2;
                }
                int i3 = i2 % 3;
                if (i3 == 0) {
                    bVar2.b((i * 3) + 1);
                } else if (i3 == 1) {
                    bVar4.b(i / 3);
                    bVar3.b(i % 3);
                } else if (i3 == 2) {
                    bVar.b(i + 1);
                }
            }
        }
        if (bVar.a().length == 0 || bVar2.a().length == 0 || bVar3.a().length == 0 || bVar4.a().length == 0 || bVar.a()[0] <= 0 || bVar2.a()[0] + bVar3.a()[0] < 3 || bVar2.a()[0] + bVar3.a()[0] > 90) {
            return null;
        }
        a aVar = new a(bVar.a()[0], bVar2.a()[0], bVar3.a()[0], bVar4.a()[0]);
        d(dVarArr, aVar);
        return aVar;
    }

    public final void d(d[] dVarArr, a aVar) {
        for (int i = 0; i < dVarArr.length; i++) {
            d dVar = dVarArr[i];
            if (dVarArr[i] != null) {
                int i2 = dVar.d % 30;
                int i3 = dVar.e;
                if (i3 > aVar.e) {
                    dVarArr[i] = null;
                } else {
                    if (!this.c) {
                        i3 += 2;
                    }
                    int i4 = i3 % 3;
                    if (i4 != 0) {
                        if (i4 != 1) {
                            if (i4 == 2 && i2 + 1 != aVar.a) {
                                dVarArr[i] = null;
                            }
                        } else if (i2 / 3 != aVar.f1876b || i2 % 3 != aVar.d) {
                            dVarArr[i] = null;
                        }
                    } else if ((i2 * 3) + 1 != aVar.c) {
                        dVarArr[i] = null;
                    }
                }
            }
        }
    }

    @Override // b.i.e.r.d.g
    public String toString() {
        return "IsLeft: " + this.c + '\n' + super.toString();
    }
}
