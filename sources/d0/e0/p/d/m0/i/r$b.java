package d0.e0.p.d.m0.i;

import java.util.Arrays;
import java.util.Stack;

/* JADX INFO: compiled from: RopeByteString.java */
/* JADX INFO: loaded from: classes3.dex */
public class r$b {
    public final Stack<c> a = new Stack<>();

    public r$b(r$a r_a) {
    }

    public final void a(c cVar) {
        if (!cVar.g()) {
            if (!(cVar instanceof r)) {
                String strValueOf = String.valueOf(cVar.getClass());
                throw new IllegalArgumentException(b.d.b.a.a.J(new StringBuilder(strValueOf.length() + 49), "Has a new type of ByteString been created? Found ", strValueOf));
            }
            r rVar = (r) cVar;
            a(rVar.m);
            a(rVar.n);
            return;
        }
        int size = cVar.size();
        int[] iArr = r.k;
        int iBinarySearch = Arrays.binarySearch(iArr, size);
        if (iBinarySearch < 0) {
            iBinarySearch = (-(iBinarySearch + 1)) - 1;
        }
        int i = iArr[iBinarySearch + 1];
        if (this.a.isEmpty() || this.a.peek().size() >= i) {
            this.a.push(cVar);
            return;
        }
        int i2 = iArr[iBinarySearch];
        c cVarPop = this.a.pop();
        while (!this.a.isEmpty() && this.a.peek().size() < i2) {
            cVarPop = new r(this.a.pop(), cVarPop);
        }
        r rVar2 = new r(cVarPop, cVar);
        while (!this.a.isEmpty()) {
            int size2 = rVar2.size();
            int[] iArr2 = r.k;
            int iBinarySearch2 = Arrays.binarySearch(iArr2, size2);
            if (iBinarySearch2 < 0) {
                iBinarySearch2 = (-(iBinarySearch2 + 1)) - 1;
            }
            if (this.a.peek().size() >= iArr2[iBinarySearch2 + 1]) {
                break;
            } else {
                rVar2 = new r(this.a.pop(), rVar2);
            }
        }
        this.a.push(rVar2);
    }
}
