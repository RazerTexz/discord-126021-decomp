package p007b.p225i.p226a.p242c.p255c3;

import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.c3.n */
/* JADX INFO: compiled from: TrackSelectionArray.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2648n {

    /* JADX INFO: renamed from: a */
    public final InterfaceC2647m[] f6268a;

    /* JADX INFO: renamed from: b */
    public int f6269b;

    public C2648n(InterfaceC2647m... interfaceC2647mArr) {
        this.f6268a = interfaceC2647mArr;
        int length = interfaceC2647mArr.length;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C2648n.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.f6268a, ((C2648n) obj).f6268a);
    }

    public int hashCode() {
        if (this.f6269b == 0) {
            this.f6269b = 527 + Arrays.hashCode(this.f6268a);
        }
        return this.f6269b;
    }
}
