package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import java.util.Objects;
import p007b.p109f.p115d.p122g.InterfaceC1694a;
import p007b.p109f.p115d.p122g.InterfaceC1696c;

/* JADX INFO: renamed from: b.f.j.l.o */
/* JADX INFO: compiled from: GenericByteArrayPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1943o extends BasePool<byte[]> implements InterfaceC1694a {

    /* JADX INFO: renamed from: k */
    public final int[] f3944k;

    public C1943o(InterfaceC1696c interfaceC1696c, C1953y c1953y, InterfaceC1954z interfaceC1954z) {
        super(interfaceC1696c, c1953y, interfaceC1954z);
        SparseIntArray sparseIntArray = c1953y.f3978c;
        Objects.requireNonNull(sparseIntArray);
        this.f3944k = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.f3944k[i] = sparseIntArray.keyAt(i);
        }
        m8699m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: e */
    public byte[] mo1382e(int i) {
        return new byte[i];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: g */
    public void mo1383g(byte[] bArr) {
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: i */
    public int mo1384i(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f3944k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: j */
    public int mo1385j(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: k */
    public int mo1386k(int i) {
        return i;
    }
}
