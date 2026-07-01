package b.f.j.l;

import android.util.SparseIntArray;
import com.facebook.imagepipeline.memory.BasePool;
import com.facebook.imagepipeline.memory.BasePool$InvalidSizeException;
import java.util.Objects;

/* JADX INFO: compiled from: GenericByteArrayPool.java */
/* JADX INFO: loaded from: classes3.dex */
public class o extends BasePool<byte[]> implements b.f.d.g.a {
    public final int[] k;

    public o(b.f.d.g.c cVar, y yVar, z zVar) {
        super(cVar, yVar, zVar);
        SparseIntArray sparseIntArray = yVar.c;
        Objects.requireNonNull(sparseIntArray);
        this.k = new int[sparseIntArray.size()];
        for (int i = 0; i < sparseIntArray.size(); i++) {
            this.k[i] = sparseIntArray.keyAt(i);
        }
        m();
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public byte[] e(int i) {
        return new byte[i];
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public void g(byte[] bArr) {
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int i(int i) {
        if (i <= 0) {
            throw new BasePool$InvalidSizeException(Integer.valueOf(i));
        }
        for (int i2 : this.k) {
            if (i2 >= i) {
                return i2;
            }
        }
        return i;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int j(byte[] bArr) {
        return bArr.length;
    }

    @Override // com.facebook.imagepipeline.memory.BasePool
    public int k(int i) {
        return i;
    }
}
