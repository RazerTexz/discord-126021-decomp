package j0.n;

/* JADX INFO: compiled from: SerializedObserver.java */
/* JADX INFO: loaded from: classes3.dex */
public final class c$a {
    public Object[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f3800b;

    public void a(Object obj) {
        int i = this.f3800b;
        Object[] objArr = this.a;
        if (objArr == null) {
            objArr = new Object[16];
            this.a = objArr;
        } else if (i == objArr.length) {
            Object[] objArr2 = new Object[(i >> 2) + i];
            System.arraycopy(objArr, 0, objArr2, 0, i);
            this.a = objArr2;
            objArr = objArr2;
        }
        objArr[i] = obj;
        this.f3800b = i + 1;
    }
}
