package p007b.p225i.p226a.p288f.p313h.p325l;

import com.google.android.gms.internal.measurement.zzhi;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.logging.Logger;
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3733l3;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3759n3;

/* JADX INFO: renamed from: b.i.a.f.h.l.l3 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class AbstractC3733l3<MessageType extends AbstractC3733l3<MessageType, BuilderType>, BuilderType extends AbstractC3759n3<MessageType, BuilderType>> implements InterfaceC3612c6 {
    public int zza = 0;

    /* JADX INFO: renamed from: c */
    public static <T> void m5051c(Iterable<T> iterable, List<? super T> list) {
        Charset charset = C3877w4.f10379a;
        Objects.requireNonNull(iterable);
        if (iterable instanceof InterfaceC3709j5) {
            List<?> listMo4864b = ((InterfaceC3709j5) iterable).mo4864b();
            InterfaceC3709j5 interfaceC3709j5 = (InterfaceC3709j5) list;
            int size = list.size();
            for (Object obj : listMo4864b) {
                if (obj == null) {
                    int size2 = interfaceC3709j5.size() - size;
                    StringBuilder sb = new StringBuilder(37);
                    sb.append("Element at index ");
                    sb.append(size2);
                    sb.append(" is null.");
                    String string = sb.toString();
                    int size3 = interfaceC3709j5.size();
                    while (true) {
                        size3--;
                        if (size3 < size) {
                            throw new NullPointerException(string);
                        }
                        interfaceC3709j5.remove(size3);
                    }
                } else if (obj instanceof AbstractC3837t3) {
                    interfaceC3709j5.mo4866t((AbstractC3837t3) obj);
                } else {
                    interfaceC3709j5.add((String) obj);
                }
            }
            return;
        }
        if (iterable instanceof InterfaceC3736l6) {
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

    @Override // p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3612c6
    /* JADX INFO: renamed from: b */
    public final AbstractC3837t3 mo4604b() {
        try {
            AbstractC3851u4 abstractC3851u4 = (AbstractC3851u4) this;
            int iMo4606g = abstractC3851u4.mo4606g();
            AbstractC3837t3 abstractC3837t3 = AbstractC3837t3.f10322j;
            byte[] bArr = new byte[iMo4606g];
            Logger logger = zzhi.f20628a;
            zzhi.C10804a c10804a = new zzhi.C10804a(bArr, iMo4606g);
            abstractC3851u4.mo4608i(c10804a);
            if (c10804a.mo9083a() == 0) {
                return new C3915z3(bArr);
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sbM831S = C1643a.m831S(name.length() + 62 + 10, "Serializing ", name, " to a ", "ByteString");
            sbM831S.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sbM831S.toString(), e);
        }
    }

    /* JADX INFO: renamed from: d */
    public final byte[] m5052d() {
        try {
            AbstractC3851u4 abstractC3851u4 = (AbstractC3851u4) this;
            int iMo4606g = abstractC3851u4.mo4606g();
            byte[] bArr = new byte[iMo4606g];
            Logger logger = zzhi.f20628a;
            zzhi.C10804a c10804a = new zzhi.C10804a(bArr, iMo4606g);
            abstractC3851u4.mo4608i(c10804a);
            if (c10804a.mo9083a() == 0) {
                return bArr;
            }
            throw new IllegalStateException("Did not write as much data as expected.");
        } catch (IOException e) {
            String name = getClass().getName();
            StringBuilder sbM831S = C1643a.m831S(name.length() + 62 + 10, "Serializing ", name, " to a ", "byte array");
            sbM831S.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sbM831S.toString(), e);
        }
    }

    /* JADX INFO: renamed from: e */
    public int mo5053e() {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: renamed from: l */
    public void mo5054l(int i) {
        throw new UnsupportedOperationException();
    }
}
