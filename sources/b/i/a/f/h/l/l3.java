package b.i.a.f.h.l;

import b.d.b.a.outline;
import b.i.a.f.h.l.l3;
import b.i.a.f.h.l.n3;
import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class l3<MessageType extends l3<MessageType, BuilderType>, BuilderType extends n3<MessageType, BuilderType>> implements c6 {
    public int zza = 0;

    public static <T> void c(Iterable<T> iterable, List<? super T> list) {
        Charset charset = w4.a;
        Objects.requireNonNull(iterable);
        if (iterable instanceof j5) {
            List<?> listB = ((j5) iterable).b();
            j5 j5Var = (j5) list;
            int size = list.size();
            for (Object obj : listB) {
                if (obj == null) {
                    int size2 = j5Var.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    int size3 = j5Var.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            throw new NullPointerException(string);
                        }
                        j5Var.remove(size3);
                    }
                } else if (obj instanceof t3) {
                    j5Var.t((t3) obj);
                } else {
                    j5Var.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof l6) {
            list.addAll((Collection) iterable);
            return;
        }
        if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
            ((ArrayList) list).ensureCapacity(((Collection) iterable).size() + list.size());
        }
        int size4 = list.size();
        for (T t : iterable) {
            if (t == null) {
                int size5 = list.size() - size4;
                StringBuilder sb2 = new StringBuilder(37);
                sb2.append("Element at index ");
                sb2.append(size5);
                sb2.append(" is null.");
                String string2 = sb2.toString();
                int size6 = list.size();
                while (true) {
                    size6--;
                    if (size6 < size4) {
                        throw new NullPointerException(string2);
                    }
                    list.remove(size6);
                }
            } else {
                list.add(t);
            }
        }
    }

    @Override // b.i.a.f.h.l.c6
    public final t3 b() {
        try {
            u4 u4Var = (u4) this;
            int iG = u4Var.g();
            t3 t3Var = t3.j;
            byte[] bArr = new byte[iG];
            Logger logger = zzhi.a;
            zzhi.a aVar = new zzhi.a(bArr, iG);
            u4Var.i(aVar);
            if (aVar.a() == 0) {
                return new z3(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sbS = outline.S(name.length() + 62 + 10, "Serializing ", name, " to a ", "ByteString");
            sbS.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sbS.toString(), e);
        }
    }

    public final byte[] d() {
        try {
            u4 u4Var = (u4) this;
            int iG = u4Var.g();
            byte[] bArr = new byte[iG];
            Logger logger = zzhi.a;
            zzhi.a aVar = new zzhi.a(bArr, iG);
            u4Var.i(aVar);
            if (aVar.a() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sbS = outline.S(name.length() + 62 + 10, "Serializing ", name, " to a ", "byte array");
            sbS.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sbS.toString(), e);
        }
    }

    public int e() {
        throw new UnsupportedOperationException();
    }

    public void l(int i) {
        throw new UnsupportedOperationException();
    }
}
