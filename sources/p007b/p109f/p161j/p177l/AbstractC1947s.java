package p007b.p109f.p161j.p177l;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import java.util.Objects;
import p007b.p109f.p115d.p122g.InterfaceC1696c;

/* JADX INFO: renamed from: b.f.j.l.s */
/* JADX INFO: compiled from: MemoryChunkPool.java */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC1947s extends BasePool<InterfaceC1946r> {

    /* JADX INFO: renamed from: k */
    public final int[] f3952k;

    public AbstractC1947s(InterfaceC1696c interfaceC1696c, C1953y c1953y, InterfaceC1954z interfaceC1954z) {
        super(interfaceC1696c, c1953y, interfaceC1954z);
        SparseIntArray sparseIntArray = c1953y.f3978c;
        Objects.requireNonNull(sparseIntArray);
        this.f3952k = new int[sparseIntArray.size()];
        int i = 0;
        while (true) {
            int[] iArr = this.f3952k;
            if (i >= iArr.length) {
                m8699m();
                return;
            } else {
                iArr[i] = sparseIntArray.keyAt(i);
                i++;
            }
        }
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: g */
    public void mo1383g(InterfaceC1946r interfaceC1946r) {
        interfaceC1946r.close();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: i */
    public int mo1384i(int i) {
        if (i <= 0) {
            throw new BasePool.InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.f3952k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: j */
    public int mo1385j(InterfaceC1946r interfaceC1946r) {
        return interfaceC1946r.getSize();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: k */
    public int mo1386k(int i) {
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: o */
    public boolean mo1388o(InterfaceC1946r interfaceC1946r) {
        return !interfaceC1946r.isClosed();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public abstract InterfaceC1946r mo1382e(int i);
}
