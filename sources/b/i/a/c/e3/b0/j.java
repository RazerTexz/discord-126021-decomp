package b.i.a.c.e3.b0;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.i.a.c.f3.e0;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map$Entry;
import java.util.Set;

/* JADX INFO: compiled from: CachedContentIndex.java */
/* JADX INFO: loaded from: classes3.dex */
public class j {
    public final HashMap<String, i> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SparseArray<String> f932b;
    public final SparseBooleanArray c;
    public final SparseBooleanArray d;
    public j$c e;

    @Nullable
    public j$c f;

    public j(@Nullable b.i.a.c.u2.a aVar, @Nullable File file, @Nullable byte[] bArr, boolean z2, boolean z3) {
        b.c.a.a0.d.D((aVar == null && file == null) ? false : true);
        this.a = new HashMap<>();
        this.f932b = new SparseArray<>();
        this.c = new SparseBooleanArray();
        this.d = new SparseBooleanArray();
        j$a j_a = aVar != null ? new j$a(aVar) : null;
        j$b j_b = file != null ? new j$b(new File(file, "cached_content_index.exi"), bArr, z2) : null;
        if (j_a != null && (j_b == null || !z3)) {
            this.e = j_a;
            this.f = j_b;
        } else {
            int i = e0.a;
            this.e = j_b;
            this.f = j_a;
        }
    }

    public static n a(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException(b.d.b.a.a.g(31, "Invalid value size: ", i3));
            }
            int iMin = Math.min(i3, 10485760);
            byte[] bArrCopyOf = e0.f;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, 10485760);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new n(map);
    }

    public static void b(n nVar, DataOutputStream dataOutputStream) throws IOException {
        Set<Map$Entry<String, byte[]>> setEntrySet = nVar.c.entrySet();
        dataOutputStream.writeInt(setEntrySet.size());
        for (Map$Entry<String, byte[]> map$Entry : setEntrySet) {
            dataOutputStream.writeUTF(map$Entry.getKey());
            byte[] value = map$Entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    @Nullable
    public i c(String str) {
        return this.a.get(str);
    }

    public i d(String str) {
        i iVar = this.a.get(str);
        if (iVar != null) {
            return iVar;
        }
        SparseArray<String> sparseArray = this.f932b;
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt < 0) {
            while (i < size && i == sparseArray.keyAt(i)) {
                i++;
            }
            iKeyAt = i;
        }
        i iVar2 = new i(iKeyAt, str, n.a);
        this.a.put(str, iVar2);
        this.f932b.put(iKeyAt, str);
        this.d.put(iKeyAt, true);
        this.e.c(iVar2);
        return iVar2;
    }

    @WorkerThread
    public void e(long j) throws IOException {
        j$c j_c;
        this.e.f(j);
        j$c j_c2 = this.f;
        if (j_c2 != null) {
            j_c2.f(j);
        }
        if (this.e.d() || (j_c = this.f) == null || !j_c.d()) {
            this.e.g(this.a, this.f932b);
        } else {
            this.f.g(this.a, this.f932b);
            this.e.b(this.a);
        }
        j$c j_c3 = this.f;
        if (j_c3 != null) {
            j_c3.h();
            this.f = null;
        }
    }

    public void f(String str) {
        i iVar = this.a.get(str);
        if (iVar != null && iVar.c.isEmpty() && iVar.d.isEmpty()) {
            this.a.remove(str);
            int i = iVar.a;
            boolean z2 = this.d.get(i);
            this.e.a(iVar, z2);
            if (z2) {
                this.f932b.remove(i);
                this.d.delete(i);
            } else {
                this.f932b.put(i, null);
                this.c.put(i, true);
            }
        }
    }

    @WorkerThread
    public void g() throws IOException {
        this.e.e(this.a);
        int size = this.c.size();
        for (int i = 0; i < size; i++) {
            this.f932b.remove(this.c.keyAt(i));
        }
        this.c.clear();
        this.d.clear();
    }
}
