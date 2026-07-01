package b.i.b.b;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: ImmutableList.java */
/* JADX INFO: loaded from: classes3.dex */
public final class p$a<E> extends n$a<E> {
    public p$a() {
        super(4);
    }

    @CanIgnoreReturnValue
    public p$a<E> b(E e) {
        Objects.requireNonNull(e);
        int i = this.f1647b + 1;
        Object[] objArr = this.a;
        if (objArr.length < i) {
            this.a = Arrays.copyOf(objArr, n$b.a(objArr.length, i));
            this.c = false;
        } else if (this.c) {
            this.a = (Object[]) objArr.clone();
            this.c = false;
        }
        Object[] objArr2 = this.a;
        int i2 = this.f1647b;
        this.f1647b = i2 + 1;
        objArr2[i2] = e;
        return this;
    }

    public p<E> c() {
        this.c = true;
        return p.l(this.a, this.f1647b);
    }
}
