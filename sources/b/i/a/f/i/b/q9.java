package b.i.a.f.i.b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import b.d.b.a.outline;
import b.i.a.f.h.l.a1;
import b.i.a.f.h.l.c1;
import b.i.a.f.h.l.e1;
import b.i.a.f.h.l.i1;
import b.i.a.f.h.l.u4;
import com.discord.models.domain.ModelAuditLogEntry;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader$ParseException;
import com.google.android.gms.internal.measurement.zzij;
import com.google.android.gms.measurement.internal.zzap;
import com.google.android.gms.measurement.internal.zzaq;
import com.google.android.gms.measurement.internal.zzn;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class q9 extends i9 {
    public q9(k9 k9Var) {
        super(k9Var);
    }

    public static String A(boolean z2, boolean z3, boolean z4) {
        StringBuilder sb = new StringBuilder();
        if (z2) {
            sb.append("Dynamic ");
        }
        if (z3) {
            sb.append("Sequence ");
        }
        if (z4) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static List<Long> B(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 >= bitSet.length()) {
                    break;
                }
                if (bitSet.get(i3)) {
                    j |= 1 << i2;
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static List<b.i.a.f.h.l.c1> D(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                c1.a aVarQ = b.i.a.f.h.l.c1.Q();
                for (String str : bundle.keySet()) {
                    c1.a aVarQ2 = b.i.a.f.h.l.c1.Q();
                    aVarQ2.s(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        aVarQ2.r(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        aVarQ2.t((String) obj);
                    } else if (obj instanceof Double) {
                        aVarQ2.q(((Double) obj).doubleValue());
                    }
                    if (aVarQ.l) {
                        aVarQ.n();
                        aVarQ.l = false;
                    }
                    b.i.a.f.h.l.c1.x((b.i.a.f.h.l.c1) aVarQ.k, (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ2.p()));
                }
                if (((b.i.a.f.h.l.c1) aVarQ.k).P() > 0) {
                    arrayList.add((b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ.p()));
                }
            }
        }
        return arrayList;
    }

    public static void E(a1.a aVar, String str, Object obj) {
        List<b.i.a.f.h.l.c1> listV = aVar.v();
        int i = 0;
        while (true) {
            if (i >= listV.size()) {
                i = -1;
                break;
            } else if (str.equals(listV.get(i).B())) {
                break;
            } else {
                i++;
            }
        }
        c1.a aVarQ = b.i.a.f.h.l.c1.Q();
        aVarQ.s(str);
        if (obj instanceof Long) {
            aVarQ.r(((Long) obj).longValue());
        } else if (obj instanceof String) {
            aVarQ.t((String) obj);
        } else if (obj instanceof Double) {
            aVarQ.q(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            List<b.i.a.f.h.l.c1> listD = D((Bundle[]) obj);
            if (aVarQ.l) {
                aVarQ.n();
                aVarQ.l = false;
            }
            b.i.a.f.h.l.c1.y((b.i.a.f.h.l.c1) aVarQ.k, listD);
        }
        if (i < 0) {
            aVar.s(aVarQ);
            return;
        }
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.a1.y((b.i.a.f.h.l.a1) aVar.k, i, (b.i.a.f.h.l.c1) ((b.i.a.f.h.l.u4) aVarQ.p()));
    }

    public static void H(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    public static void J(StringBuilder sb, int i, String str, b.i.a.f.h.l.n0 n0Var) {
        if (n0Var == null) {
            return;
        }
        H(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (n0Var.u()) {
            L(sb, i, "comparison_type", n0Var.v().name());
        }
        if (n0Var.w()) {
            L(sb, i, "match_as_float", Boolean.valueOf(n0Var.x()));
        }
        if (n0Var.y()) {
            L(sb, i, "comparison_value", n0Var.z());
        }
        if (n0Var.A()) {
            L(sb, i, "min_comparison_value", n0Var.B());
        }
        if (n0Var.C()) {
            L(sb, i, "max_comparison_value", n0Var.D());
        }
        H(sb, i);
        sb.append("}\n");
    }

    public static void K(StringBuilder sb, int i, String str, b.i.a.f.h.l.g1 g1Var) {
        if (g1Var == null) {
            return;
        }
        H(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (g1Var.G() != 0) {
            H(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : g1Var.E()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (g1Var.z() != 0) {
            H(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : g1Var.v()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (g1Var.J() != 0) {
            H(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (b.i.a.f.h.l.z0 z0Var : g1Var.I()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(z0Var.w() ? Integer.valueOf(z0Var.x()) : null);
                sb.append(":");
                sb.append(z0Var.y() ? Long.valueOf(z0Var.z()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (g1Var.L() != 0) {
            H(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (b.i.a.f.h.l.h1 h1Var : g1Var.K()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(h1Var.x() ? Integer.valueOf(h1Var.y()) : null);
                sb.append(": [");
                Iterator<Long> it = h1Var.z().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = it.next().longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        H(sb, 3);
        sb.append("}\n");
    }

    public static void L(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        H(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    @WorkerThread
    public static boolean O(zzaq zzaqVar, zzn zznVar) {
        Objects.requireNonNull(zzaqVar, "null reference");
        return (TextUtils.isEmpty(zznVar.k) && TextUtils.isEmpty(zznVar.A)) ? false : true;
    }

    public static boolean P(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static boolean Q(List<Long> list, int i) {
        if (i < (((b.i.a.f.h.l.q5) list).m << 6)) {
            return ((1 << (i % 64)) & ((Long) ((b.i.a.f.h.l.q5) list).get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static Object R(b.i.a.f.h.l.a1 a1Var, String str) {
        b.i.a.f.h.l.c1 c1VarW = w(a1Var, str);
        if (c1VarW == null) {
            return null;
        }
        if (c1VarW.F()) {
            return c1VarW.G();
        }
        if (c1VarW.I()) {
            return Long.valueOf(c1VarW.J());
        }
        if (c1VarW.M()) {
            return Double.valueOf(c1VarW.N());
        }
        if (c1VarW.P() <= 0) {
            return null;
        }
        List<b.i.a.f.h.l.c1> listO = c1VarW.O();
        ArrayList arrayList = new ArrayList();
        for (b.i.a.f.h.l.c1 c1Var : listO) {
            if (c1Var != null) {
                Bundle bundle = new Bundle();
                for (b.i.a.f.h.l.c1 c1Var2 : c1Var.O()) {
                    if (c1Var2.F()) {
                        bundle.putString(c1Var2.B(), c1Var2.G());
                    } else if (c1Var2.I()) {
                        bundle.putLong(c1Var2.B(), c1Var2.J());
                    } else if (c1Var2.M()) {
                        bundle.putDouble(c1Var2.B(), c1Var2.N());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static int s(e1.a aVar, String str) {
        for (int i = 0; i < ((b.i.a.f.h.l.e1) aVar.k).P0(); i++) {
            if (str.equals(((b.i.a.f.h.l.e1) aVar.k).h0(i).D())) {
                return i;
            }
        }
        return -1;
    }

    public static b.i.a.f.h.l.c1 w(b.i.a.f.h.l.a1 a1Var, String str) {
        for (b.i.a.f.h.l.c1 c1Var : a1Var.v()) {
            if (c1Var.B().equals(str)) {
                return c1Var;
            }
        }
        return null;
    }

    public static <Builder extends b.i.a.f.h.l.b6> Builder x(Builder builder, byte[] bArr) throws zzij {
        b.i.a.f.h.l.h4 h4VarB = b.i.a.f.h.l.h4.f1446b;
        if (h4VarB == null) {
            synchronized (b.i.a.f.h.l.h4.class) {
                h4VarB = b.i.a.f.h.l.h4.f1446b;
                if (h4VarB == null) {
                    h4VarB = b.i.a.f.h.l.s4.b(b.i.a.f.h.l.h4.class);
                    b.i.a.f.h.l.h4.f1446b = h4VarB;
                }
            }
        }
        if (h4VarB != null) {
            b.i.a.f.h.l.n3 n3Var = (b.i.a.f.h.l.n3) builder;
            Objects.requireNonNull(n3Var);
            u4.b bVar = (u4.b) n3Var;
            bVar.m(bArr, bArr.length, h4VarB);
            return bVar;
        }
        b.i.a.f.h.l.n3 n3Var2 = (b.i.a.f.h.l.n3) builder;
        Objects.requireNonNull(n3Var2);
        u4.b bVar2 = (u4.b) n3Var2;
        bVar2.m(bArr, bArr.length, b.i.a.f.h.l.h4.a());
        return bVar2;
    }

    public final List<Long> C(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                g().i.b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    g().i.c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public final void F(c1.a aVar, Object obj) {
        Objects.requireNonNull(obj, "null reference");
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.c1.u((b.i.a.f.h.l.c1) aVar.k);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.c1.C((b.i.a.f.h.l.c1) aVar.k);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.c1.E((b.i.a.f.h.l.c1) aVar.k);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.c1.H((b.i.a.f.h.l.c1) aVar.k);
        if (obj instanceof String) {
            aVar.t((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.r(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.q(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            g().f.b("Ignoring invalid (type) event param value", obj);
            return;
        }
        List<b.i.a.f.h.l.c1> listD = D((Bundle[]) obj);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.c1.y((b.i.a.f.h.l.c1) aVar.k, listD);
    }

    public final void G(i1.a aVar, Object obj) {
        Objects.requireNonNull(obj, "null reference");
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.i1.u((b.i.a.f.h.l.i1) aVar.k);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.i1.A((b.i.a.f.h.l.i1) aVar.k);
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.i1.E((b.i.a.f.h.l.i1) aVar.k);
        if (obj instanceof String) {
            String str = (String) obj;
            if (aVar.l) {
                aVar.n();
                aVar.l = false;
            }
            b.i.a.f.h.l.i1.C((b.i.a.f.h.l.i1) aVar.k, str);
            return;
        }
        if (obj instanceof Long) {
            aVar.s(((Long) obj).longValue());
            return;
        }
        if (!(obj instanceof Double)) {
            g().f.b("Ignoring invalid (type) user attribute value", obj);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (aVar.l) {
            aVar.n();
            aVar.l = false;
        }
        b.i.a.f.h.l.i1.v((b.i.a.f.h.l.i1) aVar.k, dDoubleValue);
    }

    public final void I(StringBuilder sb, int i, b.i.a.f.h.l.m0 m0Var) {
        if (m0Var == null) {
            return;
        }
        H(sb, i);
        sb.append("filter {\n");
        if (m0Var.z()) {
            L(sb, i, "complement", Boolean.valueOf(m0Var.A()));
        }
        if (m0Var.B()) {
            L(sb, i, "param_name", d().x(m0Var.C()));
        }
        if (m0Var.v()) {
            int i2 = i + 1;
            b.i.a.f.h.l.p0 p0VarW = m0Var.w();
            if (p0VarW != null) {
                H(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (p0VarW.u()) {
                    L(sb, i2, "match_type", p0VarW.v().name());
                }
                if (p0VarW.w()) {
                    L(sb, i2, "expression", p0VarW.x());
                }
                if (p0VarW.y()) {
                    L(sb, i2, "case_sensitive", Boolean.valueOf(p0VarW.z()));
                }
                if (p0VarW.B() > 0) {
                    H(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str : p0VarW.A()) {
                        H(sb, i2 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                H(sb, i2);
                sb.append("}\n");
            }
        }
        if (m0Var.x()) {
            J(sb, i + 1, "number_filter", m0Var.y());
        }
        H(sb, i);
        sb.append("}\n");
    }

    public final void M(StringBuilder sb, int i, List<b.i.a.f.h.l.c1> list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        for (b.i.a.f.h.l.c1 c1Var : list) {
            if (c1Var != null) {
                H(sb, i2);
                sb.append("param {\n");
                L(sb, i2, ModelAuditLogEntry.CHANGE_KEY_NAME, c1Var.A() ? d().x(c1Var.B()) : null);
                L(sb, i2, "string_value", c1Var.F() ? c1Var.G() : null);
                L(sb, i2, "int_value", c1Var.I() ? Long.valueOf(c1Var.J()) : null);
                L(sb, i2, "double_value", c1Var.M() ? Double.valueOf(c1Var.N()) : null);
                if (c1Var.P() > 0) {
                    M(sb, i2, c1Var.O());
                }
                H(sb, i2);
                sb.append("}\n");
            }
        }
    }

    public final boolean N(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            return true;
        }
        Objects.requireNonNull((b.i.a.f.e.o.c) this.a.o);
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    public final byte[] S(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e) {
            g().f.b("Failed to ungzip content", e);
            throw e;
        }
    }

    public final byte[] T(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            g().f.b("Failed to gzip content", e);
            throw e;
        }
    }

    @Nullable
    public final List<Integer> U() {
        Context context = this.f1538b.k.f1570b;
        List<j3<?>> list = p.a;
        b.i.a.f.h.l.y1 y1VarA = b.i.a.f.h.l.y1.a(context.getContentResolver(), b.i.a.f.h.l.i2.a("com.google.android.gms.measurement"));
        Map<String, String> mapEmptyMap = y1VarA == null ? Collections.emptyMap() : y1VarA.b();
        if (mapEmptyMap == null || mapEmptyMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = p.P.a(null).intValue();
        for (Map.Entry<String, String> entry : mapEmptyMap.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i = Integer.parseInt(entry.getValue());
                    if (i != 0) {
                        arrayList.add(Integer.valueOf(i));
                        if (arrayList.size() >= iIntValue) {
                            g().i.b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    g().i.b("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // b.i.a.f.i.b.i9
    public final boolean p() {
        return false;
    }

    @WorkerThread
    public final long t(byte[] bArr) {
        e().b();
        MessageDigest messageDigestX0 = t9.x0();
        if (messageDigestX0 != null) {
            return t9.w(messageDigestX0.digest(bArr));
        }
        g().f.a("Failed to get MD5");
        return 0L;
    }

    public final <T extends Parcelable> T u(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader$ParseException unused) {
            g().f.a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final b.i.a.f.h.l.a1 v(m mVar) {
        a1.a aVarM = b.i.a.f.h.l.a1.M();
        long j = mVar.e;
        if (aVarM.l) {
            aVarM.n();
            aVarM.l = false;
        }
        b.i.a.f.h.l.a1.E((b.i.a.f.h.l.a1) aVarM.k, j);
        zzap zzapVar = mVar.f;
        Objects.requireNonNull(zzapVar);
        for (String str : zzapVar.j.keySet()) {
            c1.a aVarQ = b.i.a.f.h.l.c1.Q();
            aVarQ.s(str);
            F(aVarQ, mVar.f.w0(str));
            aVarM.s(aVarQ);
        }
        return (b.i.a.f.h.l.a1) ((b.i.a.f.h.l.u4) aVarM.p());
    }

    public final String y(b.i.a.f.h.l.o0 o0Var) {
        StringBuilder sbU = outline.U("\nproperty_filter {\n");
        if (o0Var.v()) {
            L(sbU, 0, "filter_id", Integer.valueOf(o0Var.w()));
        }
        L(sbU, 0, "property_name", d().y(o0Var.x()));
        String strA = A(o0Var.z(), o0Var.A(), o0Var.C());
        if (!strA.isEmpty()) {
            L(sbU, 0, "filter_type", strA);
        }
        I(sbU, 1, o0Var.y());
        sbU.append("}\n");
        return sbU.toString();
    }

    public final String z(b.i.a.f.h.l.d1 d1Var) {
        StringBuilder sbU = outline.U("\nbatch {\n");
        for (b.i.a.f.h.l.e1 e1Var : d1Var.v()) {
            if (e1Var != null) {
                H(sbU, 1);
                sbU.append("bundle {\n");
                if (e1Var.E()) {
                    L(sbU, 1, "protocol_version", Integer.valueOf(e1Var.g0()));
                }
                L(sbU, 1, "platform", e1Var.y1());
                if (e1Var.I1()) {
                    L(sbU, 1, "gmp_version", Long.valueOf(e1Var.F()));
                }
                if (e1Var.H()) {
                    L(sbU, 1, "uploading_gmp_version", Long.valueOf(e1Var.I()));
                }
                if (e1Var.p0()) {
                    L(sbU, 1, "dynamite_version", Long.valueOf(e1Var.q0()));
                }
                if (e1Var.a0()) {
                    L(sbU, 1, "config_version", Long.valueOf(e1Var.b0()));
                }
                L(sbU, 1, "gmp_app_id", e1Var.S());
                L(sbU, 1, "admob_app_id", e1Var.o0());
                L(sbU, 1, "app_id", e1Var.G1());
                L(sbU, 1, "app_version", e1Var.H1());
                if (e1Var.X()) {
                    L(sbU, 1, "app_version_major", Integer.valueOf(e1Var.Y()));
                }
                L(sbU, 1, "firebase_instance_id", e1Var.W());
                if (e1Var.N()) {
                    L(sbU, 1, "dev_cert_hash", Long.valueOf(e1Var.O()));
                }
                L(sbU, 1, "app_store", e1Var.F1());
                if (e1Var.Y0()) {
                    L(sbU, 1, "upload_timestamp_millis", Long.valueOf(e1Var.Z0()));
                }
                if (e1Var.g1()) {
                    L(sbU, 1, "start_timestamp_millis", Long.valueOf(e1Var.h1()));
                }
                if (e1Var.n1()) {
                    L(sbU, 1, "end_timestamp_millis", Long.valueOf(e1Var.o1()));
                }
                if (e1Var.s1()) {
                    L(sbU, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(e1Var.t1()));
                }
                if (e1Var.v1()) {
                    L(sbU, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(e1Var.w1()));
                }
                L(sbU, 1, "app_instance_id", e1Var.M());
                L(sbU, 1, "resettable_device_id", e1Var.J());
                L(sbU, 1, "device_id", e1Var.Z());
                L(sbU, 1, "ds_id", e1Var.e0());
                if (e1Var.K()) {
                    L(sbU, 1, "limited_ad_tracking", Boolean.valueOf(e1Var.L()));
                }
                L(sbU, 1, "os_version", e1Var.A1());
                L(sbU, 1, "device_model", e1Var.B1());
                L(sbU, 1, "user_default_language", e1Var.C1());
                if (e1Var.D1()) {
                    L(sbU, 1, "time_zone_offset_minutes", Integer.valueOf(e1Var.E1()));
                }
                if (e1Var.P()) {
                    L(sbU, 1, "bundle_sequential_index", Integer.valueOf(e1Var.Q()));
                }
                if (e1Var.T()) {
                    L(sbU, 1, "service_upload", Boolean.valueOf(e1Var.U()));
                }
                L(sbU, 1, "health_monitor", e1Var.R());
                if (!this.a.h.o(p.y0) && e1Var.c0() && e1Var.d0() != 0) {
                    L(sbU, 1, "android_id", Long.valueOf(e1Var.d0()));
                }
                if (e1Var.f0()) {
                    L(sbU, 1, "retry_counter", Integer.valueOf(e1Var.n0()));
                }
                if (e1Var.s0()) {
                    L(sbU, 1, "consent_signals", e1Var.t0());
                }
                List<b.i.a.f.h.l.i1> listK0 = e1Var.K0();
                if (listK0 != null) {
                    for (b.i.a.f.h.l.i1 i1Var : listK0) {
                        if (i1Var != null) {
                            H(sbU, 2);
                            sbU.append("user_property {\n");
                            L(sbU, 2, "set_timestamp_millis", i1Var.y() ? Long.valueOf(i1Var.z()) : null);
                            L(sbU, 2, ModelAuditLogEntry.CHANGE_KEY_NAME, d().y(i1Var.D()));
                            L(sbU, 2, "string_value", i1Var.G());
                            L(sbU, 2, "int_value", i1Var.H() ? Long.valueOf(i1Var.I()) : null);
                            L(sbU, 2, "double_value", i1Var.J() ? Double.valueOf(i1Var.K()) : null);
                            H(sbU, 2);
                            sbU.append("}\n");
                        }
                    }
                }
                List<b.i.a.f.h.l.y0> listV = e1Var.V();
                if (listV != null) {
                    for (b.i.a.f.h.l.y0 y0Var : listV) {
                        if (y0Var != null) {
                            H(sbU, 2);
                            sbU.append("audience_membership {\n");
                            if (y0Var.x()) {
                                L(sbU, 2, "audience_id", Integer.valueOf(y0Var.y()));
                            }
                            if (y0Var.D()) {
                                L(sbU, 2, "new_audience", Boolean.valueOf(y0Var.E()));
                            }
                            K(sbU, 2, "current_data", y0Var.A());
                            if (y0Var.B()) {
                                K(sbU, 2, "previous_data", y0Var.C());
                            }
                            H(sbU, 2);
                            sbU.append("}\n");
                        }
                    }
                }
                List<b.i.a.f.h.l.a1> listY0 = e1Var.y0();
                if (listY0 != null) {
                    for (b.i.a.f.h.l.a1 a1Var : listY0) {
                        if (a1Var != null) {
                            H(sbU, 2);
                            sbU.append("event {\n");
                            L(sbU, 2, ModelAuditLogEntry.CHANGE_KEY_NAME, d().u(a1Var.F()));
                            if (a1Var.G()) {
                                L(sbU, 2, "timestamp_millis", Long.valueOf(a1Var.H()));
                            }
                            if (a1Var.I()) {
                                L(sbU, 2, "previous_timestamp_millis", Long.valueOf(a1Var.J()));
                            }
                            if (a1Var.K()) {
                                L(sbU, 2, "count", Integer.valueOf(a1Var.L()));
                            }
                            if (a1Var.D() != 0) {
                                M(sbU, 2, a1Var.v());
                            }
                            H(sbU, 2);
                            sbU.append("}\n");
                        }
                    }
                }
                H(sbU, 1);
                sbU.append("}\n");
            }
        }
        sbU.append("}\n");
        return sbU.toString();
    }
}
