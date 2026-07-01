package h0.a.a;

/* JADX INFO: compiled from: Handler.java */
/* JADX INFO: loaded from: classes3.dex */
public final class o {
    public final p a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f3713b;
    public final p c;
    public final int d;
    public final String e;
    public o f;

    public o(p pVar, p pVar2, p pVar3, int i, String str) {
        this.a = pVar;
        this.f3713b = pVar2;
        this.c = pVar3;
        this.d = i;
        this.e = str;
    }

    public static o a(o oVar, p pVar, p pVar2) {
        if (oVar == null) {
            return null;
        }
        o oVarA = a(oVar.f, pVar, pVar2);
        oVar.f = oVarA;
        p pVar3 = oVar.a;
        int i = pVar3.e;
        p pVar4 = oVar.f3713b;
        int i2 = pVar4.e;
        int i3 = pVar.e;
        int i4 = pVar2 == null ? Integer.MAX_VALUE : pVar2.e;
        if (i3 >= i2 || i4 <= i) {
            return oVar;
        }
        if (i3 <= i) {
            return i4 >= i2 ? oVarA : new o(oVar, pVar2, pVar4);
        }
        if (i4 >= i2) {
            return new o(oVar, pVar3, pVar);
        }
        oVar.f = new o(oVar, pVar2, pVar4);
        return new o(oVar, oVar.a, pVar);
    }

    public o(o oVar, p pVar, p pVar2) {
        p pVar3 = oVar.c;
        int i = oVar.d;
        String str = oVar.e;
        this.a = pVar;
        this.f3713b = pVar2;
        this.c = pVar3;
        this.d = i;
        this.e = str;
        this.f = oVar.f;
    }
}
