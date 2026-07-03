package p007b.p225i.p226a.p288f.p330i.p332b;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
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
import p007b.p100d.p104b.p105a.C1643a;
import p007b.p225i.p226a.p288f.p299e.p308o.C3401c;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3759n3;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3825s4;
import p007b.p225i.p226a.p288f.p313h.p325l.AbstractC3851u4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3579a1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3607c1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3621d1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3635e1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3663g1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3677h1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3680h4;
import p007b.p225i.p226a.p288f.p313h.p325l.C3691i1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3692i2;
import p007b.p225i.p226a.p288f.p313h.p325l.C3743m0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3756n0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3769o0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3782p0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3800q5;
import p007b.p225i.p226a.p288f.p313h.p325l.C3899y0;
import p007b.p225i.p226a.p288f.p313h.p325l.C3900y1;
import p007b.p225i.p226a.p288f.p313h.p325l.C3912z0;
import p007b.p225i.p226a.p288f.p313h.p325l.InterfaceC3598b6;

/* JADX INFO: renamed from: b.i.a.f.i.b.q9 */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@18.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class C4163q9 extends AbstractC4074i9 {
    public C4163q9(C4097k9 c4097k9) {
        super(c4097k9);
    }

    /* JADX INFO: renamed from: A */
    public static String m5818A(boolean z2, boolean z3, boolean z4) {
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

    /* JADX INFO: renamed from: B */
    public static List<Long> m5819B(BitSet bitSet) {
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

    /* JADX INFO: renamed from: D */
    public static List<C3607c1> m5820D(Bundle[] bundleArr) {
        ArrayList arrayList = new ArrayList();
        for (Bundle bundle : bundleArr) {
            if (bundle != null) {
                C3607c1.a aVarM4578Q = C3607c1.m4578Q();
                for (String str : bundle.keySet()) {
                    C3607c1.a aVarM4578Q2 = C3607c1.m4578Q();
                    aVarM4578Q2.m4600s(str);
                    Object obj = bundle.get(str);
                    if (obj instanceof Long) {
                        aVarM4578Q2.m4599r(((Long) obj).longValue());
                    } else if (obj instanceof String) {
                        aVarM4578Q2.m4601t((String) obj);
                    } else if (obj instanceof Double) {
                        aVarM4578Q2.m4598q(((Double) obj).doubleValue());
                    }
                    if (aVarM4578Q.f10348l) {
                        aVarM4578Q.m5318n();
                        aVarM4578Q.f10348l = false;
                    }
                    C3607c1.m4583x((C3607c1) aVarM4578Q.f10347k, (C3607c1) ((AbstractC3851u4) aVarM4578Q2.m5320p()));
                }
                if (((C3607c1) aVarM4578Q.f10347k).m4597P() > 0) {
                    arrayList.add((C3607c1) ((AbstractC3851u4) aVarM4578Q.m5320p()));
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: renamed from: E */
    public static void m5821E(C3579a1.a aVar, String str, Object obj) {
        List<C3607c1> listM4550v = aVar.m4550v();
        int i = 0;
        while (true) {
            if (i >= listM4550v.size()) {
                i = -1;
                break;
            } else if (str.equals(listM4550v.get(i).m4587B())) {
                break;
            } else {
                i++;
            }
        }
        C3607c1.a aVarM4578Q = C3607c1.m4578Q();
        aVarM4578Q.m4600s(str);
        if (obj instanceof Long) {
            aVarM4578Q.m4599r(((Long) obj).longValue());
        } else if (obj instanceof String) {
            aVarM4578Q.m4601t((String) obj);
        } else if (obj instanceof Double) {
            aVarM4578Q.m4598q(((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            List<C3607c1> listM5820D = m5820D((Bundle[]) obj);
            if (aVarM4578Q.f10348l) {
                aVarM4578Q.m5318n();
                aVarM4578Q.f10348l = false;
            }
            C3607c1.m4584y((C3607c1) aVarM4578Q.f10347k, listM5820D);
        }
        if (i < 0) {
            aVar.m4547s(aVarM4578Q);
            return;
        }
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3579a1.m4530y((C3579a1) aVar.f10347k, i, (C3607c1) ((AbstractC3851u4) aVarM4578Q.m5320p()));
    }

    /* JADX INFO: renamed from: H */
    public static void m5822H(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    /* JADX INFO: renamed from: J */
    public static void m5823J(StringBuilder sb, int i, String str, C3756n0 c3756n0) {
        if (c3756n0 == null) {
            return;
        }
        m5822H(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (c3756n0.m5116u()) {
            m5825L(sb, i, "comparison_type", c3756n0.m5117v().name());
        }
        if (c3756n0.m5118w()) {
            m5825L(sb, i, "match_as_float", Boolean.valueOf(c3756n0.m5119x()));
        }
        if (c3756n0.m5120y()) {
            m5825L(sb, i, "comparison_value", c3756n0.m5121z());
        }
        if (c3756n0.m5112A()) {
            m5825L(sb, i, "min_comparison_value", c3756n0.m5113B());
        }
        if (c3756n0.m5114C()) {
            m5825L(sb, i, "max_comparison_value", c3756n0.m5115D());
        }
        m5822H(sb, i);
        sb.append("}\n");
    }

    /* JADX INFO: renamed from: K */
    public static void m5824K(StringBuilder sb, int i, String str, C3663g1 c3663g1) {
        if (c3663g1 == null) {
            return;
        }
        m5822H(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (c3663g1.m4901G() != 0) {
            m5822H(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : c3663g1.m4900E()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (c3663g1.m4908z() != 0) {
            m5822H(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : c3663g1.m4907v()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (c3663g1.m4903J() != 0) {
            m5822H(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (C3912z0 c3912z0 : c3663g1.m4902I()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(c3912z0.m5393w() ? Integer.valueOf(c3912z0.m5394x()) : null);
                sb.append(":");
                sb.append(c3912z0.m5395y() ? Long.valueOf(c3912z0.m5396z()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (c3663g1.m4905L() != 0) {
            m5822H(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (C3677h1 c3677h1 : c3663g1.m4904K()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(c3677h1.m4930x() ? Integer.valueOf(c3677h1.m4931y()) : null);
                sb.append(": [");
                Iterator<Long> it = c3677h1.m4932z().iterator();
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
        m5822H(sb, 3);
        sb.append("}\n");
    }

    /* JADX INFO: renamed from: L */
    public static void m5825L(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        m5822H(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    @WorkerThread
    /* JADX INFO: renamed from: O */
    public static boolean m5826O(zzaq zzaqVar, zzn zznVar) {
        Objects.requireNonNull(zzaqVar, "null reference");
        return (TextUtils.isEmpty(zznVar.f20684k) && TextUtils.isEmpty(zznVar.f20677A)) ? false : true;
    }

    /* JADX INFO: renamed from: P */
    public static boolean m5827P(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    /* JADX INFO: renamed from: Q */
    public static boolean m5828Q(List<Long> list, int i) {
        if (i < (((C3800q5) list).f10273m << 6)) {
            return ((1 << (i % 64)) & ((Long) ((C3800q5) list).get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    /* JADX INFO: renamed from: R */
    public static Object m5829R(C3579a1 c3579a1, String str) {
        C3607c1 c3607c1M5831w = m5831w(c3579a1, str);
        if (c3607c1M5831w == null) {
            return null;
        }
        if (c3607c1M5831w.m4588F()) {
            return c3607c1M5831w.m4589G();
        }
        if (c3607c1M5831w.m4590I()) {
            return Long.valueOf(c3607c1M5831w.m4591J());
        }
        if (c3607c1M5831w.m4594M()) {
            return Double.valueOf(c3607c1M5831w.m4595N());
        }
        if (c3607c1M5831w.m4597P() <= 0) {
            return null;
        }
        List<C3607c1> listM4596O = c3607c1M5831w.m4596O();
        ArrayList arrayList = new ArrayList();
        for (C3607c1 c3607c1 : listM4596O) {
            if (c3607c1 != null) {
                Bundle bundle = new Bundle();
                for (C3607c1 c3607c2 : c3607c1.m4596O()) {
                    if (c3607c2.m4588F()) {
                        bundle.putString(c3607c2.m4587B(), c3607c2.m4589G());
                    } else if (c3607c2.m4590I()) {
                        bundle.putLong(c3607c2.m4587B(), c3607c2.m4591J());
                    } else if (c3607c2.m4594M()) {
                        bundle.putDouble(c3607c2.m4587B(), c3607c2.m4595N());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    /* JADX INFO: renamed from: s */
    public static int m5830s(C3635e1.a aVar, String str) {
        for (int i = 0; i < ((C3635e1) aVar.f10347k).m4723P0(); i++) {
            if (str.equals(((C3635e1) aVar.f10347k).m4744h0(i).m4949D())) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: w */
    public static C3607c1 m5831w(C3579a1 c3579a1, String str) {
        for (C3607c1 c3607c1 : c3579a1.m4543v()) {
            if (c3607c1.m4587B().equals(str)) {
                return c3607c1;
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: x */
    public static <Builder extends InterfaceC3598b6> Builder m5832x(Builder builder, byte[] bArr) throws zzij {
        C3680h4 c3680h4M5215b = C3680h4.f9985b;
        if (c3680h4M5215b == null) {
            synchronized (C3680h4.class) {
                c3680h4M5215b = C3680h4.f9985b;
                if (c3680h4M5215b == null) {
                    c3680h4M5215b = AbstractC3825s4.m5215b(C3680h4.class);
                    C3680h4.f9985b = c3680h4M5215b;
                }
            }
        }
        if (c3680h4M5215b != null) {
            AbstractC3759n3 abstractC3759n3 = (AbstractC3759n3) builder;
            Objects.requireNonNull(abstractC3759n3);
            AbstractC3851u4.b bVar = (AbstractC3851u4.b) abstractC3759n3;
            bVar.m5317m(bArr, bArr.length, c3680h4M5215b);
            return bVar;
        }
        AbstractC3759n3 abstractC3759n4 = (AbstractC3759n3) builder;
        Objects.requireNonNull(abstractC3759n4);
        AbstractC3851u4.b bVar2 = (AbstractC3851u4.b) abstractC3759n4;
        bVar2.m5317m(bArr, bArr.length, C3680h4.m4933a());
        return bVar2;
    }

    /* JADX INFO: renamed from: C */
    public final List<Long> m5833C(List<Long> list, List<Integer> list2) {
        int i;
        ArrayList arrayList = new ArrayList(list);
        for (Integer num : list2) {
            if (num.intValue() < 0) {
                mo5726g().f11144i.m5861b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    mo5726g().f11144i.m5862c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
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

    /* JADX INFO: renamed from: F */
    public final void m5834F(C3607c1.a aVar, Object obj) {
        Objects.requireNonNull(obj, "null reference");
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3607c1.m4580u((C3607c1) aVar.f10347k);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3607c1.m4574C((C3607c1) aVar.f10347k);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3607c1.m4576E((C3607c1) aVar.f10347k);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3607c1.m4577H((C3607c1) aVar.f10347k);
        if (obj instanceof String) {
            aVar.m4601t((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.m4599r(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.m4598q(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            mo5726g().f11141f.m5861b("Ignoring invalid (type) event param value", obj);
            return;
        }
        List<C3607c1> listM5820D = m5820D((Bundle[]) obj);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3607c1.m4584y((C3607c1) aVar.f10347k, listM5820D);
    }

    /* JADX INFO: renamed from: G */
    public final void m5835G(C3691i1.a aVar, Object obj) {
        Objects.requireNonNull(obj, "null reference");
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3691i1.m4945u((C3691i1) aVar.f10347k);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3691i1.m4939A((C3691i1) aVar.f10347k);
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3691i1.m4942E((C3691i1) aVar.f10347k);
        if (obj instanceof String) {
            String str = (String) obj;
            if (aVar.f10348l) {
                aVar.m5318n();
                aVar.f10348l = false;
            }
            C3691i1.m4941C((C3691i1) aVar.f10347k, str);
            return;
        }
        if (obj instanceof Long) {
            aVar.m4960s(((Long) obj).longValue());
            return;
        }
        if (!(obj instanceof Double)) {
            mo5726g().f11141f.m5861b("Ignoring invalid (type) user attribute value", obj);
            return;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        if (aVar.f10348l) {
            aVar.m5318n();
            aVar.f10348l = false;
        }
        C3691i1.m4946v((C3691i1) aVar.f10347k, dDoubleValue);
    }

    /* JADX INFO: renamed from: I */
    public final void m5836I(StringBuilder sb, int i, C3743m0 c3743m0) {
        if (c3743m0 == null) {
            return;
        }
        m5822H(sb, i);
        sb.append("filter {\n");
        if (c3743m0.m5069z()) {
            m5825L(sb, i, "complement", Boolean.valueOf(c3743m0.m5062A()));
        }
        if (c3743m0.m5063B()) {
            m5825L(sb, i, "param_name", m5865d().m5768x(c3743m0.m5064C()));
        }
        if (c3743m0.m5065v()) {
            int i2 = i + 1;
            C3782p0 c3782p0M5066w = c3743m0.m5066w();
            if (c3782p0M5066w != null) {
                m5822H(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (c3782p0M5066w.m5165u()) {
                    m5825L(sb, i2, "match_type", c3782p0M5066w.m5166v().name());
                }
                if (c3782p0M5066w.m5167w()) {
                    m5825L(sb, i2, "expression", c3782p0M5066w.m5168x());
                }
                if (c3782p0M5066w.m5169y()) {
                    m5825L(sb, i2, "case_sensitive", Boolean.valueOf(c3782p0M5066w.m5170z()));
                }
                if (c3782p0M5066w.m5164B() > 0) {
                    m5822H(sb, i2 + 1);
                    sb.append("expression_list {\n");
                    for (String str : c3782p0M5066w.m5163A()) {
                        m5822H(sb, i2 + 2);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                m5822H(sb, i2);
                sb.append("}\n");
            }
        }
        if (c3743m0.m5067x()) {
            m5823J(sb, i + 1, "number_filter", c3743m0.m5068y());
        }
        m5822H(sb, i);
        sb.append("}\n");
    }

    /* JADX INFO: renamed from: M */
    public final void m5837M(StringBuilder sb, int i, List<C3607c1> list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        for (C3607c1 c3607c1 : list) {
            if (c3607c1 != null) {
                m5822H(sb, i2);
                sb.append("param {\n");
                m5825L(sb, i2, ModelAuditLogEntry.CHANGE_KEY_NAME, c3607c1.m4586A() ? m5865d().m5768x(c3607c1.m4587B()) : null);
                m5825L(sb, i2, "string_value", c3607c1.m4588F() ? c3607c1.m4589G() : null);
                m5825L(sb, i2, "int_value", c3607c1.m4590I() ? Long.valueOf(c3607c1.m4591J()) : null);
                m5825L(sb, i2, "double_value", c3607c1.m4594M() ? Double.valueOf(c3607c1.m4595N()) : null);
                if (c3607c1.m4597P() > 0) {
                    m5837M(sb, i2, c3607c1.m4596O());
                }
                m5822H(sb, i2);
                sb.append("}\n");
            }
        }
    }

    /* JADX INFO: renamed from: N */
    public final boolean m5838N(long j, long j2) {
        if (j == 0 || j2 <= 0) {
            return true;
        }
        Objects.requireNonNull((C3401c) this.f11202a.f11267o);
        return Math.abs(System.currentTimeMillis() - j) > j2;
    }

    /* JADX INFO: renamed from: S */
    public final byte[] m5839S(byte[] bArr) throws IOException {
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
            mo5726g().f11141f.m5861b("Failed to ungzip content", e);
            throw e;
        }
    }

    /* JADX INFO: renamed from: T */
    public final byte[] m5840T(byte[] bArr) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo5726g().f11141f.m5861b("Failed to gzip content", e);
            throw e;
        }
    }

    @Nullable
    /* JADX INFO: renamed from: U */
    public final List<Integer> m5841U() {
        Context context = this.f10827b.f10906k.f11254b;
        List<C4080j3<?>> list = C4142p.f11061a;
        C3900y1 c3900y1M5376a = C3900y1.m5376a(context.getContentResolver(), C3692i2.m4961a("com.google.android.gms.measurement"));
        Map<String, String> mapEmptyMap = c3900y1M5376a == null ? Collections.emptyMap() : c3900y1M5376a.m5378b();
        if (mapEmptyMap == null || mapEmptyMap.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int iIntValue = C4142p.f11050P.m5693a(null).intValue();
        for (Map.Entry<String, String> entry : mapEmptyMap.entrySet()) {
            if (entry.getKey().startsWith("measurement.id.")) {
                try {
                    int i = Integer.parseInt(entry.getValue());
                    if (i != 0) {
                        arrayList.add(Integer.valueOf(i));
                        if (arrayList.size() >= iIntValue) {
                            mo5726g().f11144i.m5861b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    mo5726g().f11144i.m5861b("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.size() == 0) {
            return null;
        }
        return arrayList;
    }

    @Override // p007b.p225i.p226a.p288f.p330i.p332b.AbstractC4074i9
    /* JADX INFO: renamed from: p */
    public final boolean mo5515p() {
        return false;
    }

    @WorkerThread
    /* JADX INFO: renamed from: t */
    public final long m5842t(byte[] bArr) {
        m5866e().mo5848b();
        MessageDigest messageDigestM5889x0 = C4196t9.m5889x0();
        if (messageDigestM5889x0 != null) {
            return C4196t9.m5888w(messageDigestM5889x0.digest(bArr));
        }
        mo5726g().f11141f.m5860a("Failed to get MD5");
        return 0L;
    }

    /* JADX INFO: renamed from: u */
    public final <T extends Parcelable> T m5843u(byte[] bArr, Parcelable.Creator<T> creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return creator.createFromParcel(parcelObtain);
        } catch (SafeParcelReader$ParseException unused) {
            mo5726g().f11141f.m5860a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    /* JADX INFO: renamed from: v */
    public final C3579a1 m5844v(C4109m c4109m) {
        C3579a1.a aVarM4526M = C3579a1.m4526M();
        long j = c4109m.f10956e;
        if (aVarM4526M.f10348l) {
            aVarM4526M.m5318n();
            aVarM4526M.f10348l = false;
        }
        C3579a1.m4525E((C3579a1) aVarM4526M.f10347k, j);
        zzap zzapVar = c4109m.f10957f;
        Objects.requireNonNull(zzapVar);
        for (String str : zzapVar.f20665j.keySet()) {
            C3607c1.a aVarM4578Q = C3607c1.m4578Q();
            aVarM4578Q.m4600s(str);
            m5834F(aVarM4578Q, c4109m.f10957f.m9113w0(str));
            aVarM4526M.m4547s(aVarM4578Q);
        }
        return (C3579a1) ((AbstractC3851u4) aVarM4526M.m5320p());
    }

    /* JADX INFO: renamed from: y */
    public final String m5845y(C3769o0 c3769o0) {
        StringBuilder sbM833U = C1643a.m833U("\nproperty_filter {\n");
        if (c3769o0.m5147v()) {
            m5825L(sbM833U, 0, "filter_id", Integer.valueOf(c3769o0.m5148w()));
        }
        m5825L(sbM833U, 0, "property_name", m5865d().m5769y(c3769o0.m5149x()));
        String strM5818A = m5818A(c3769o0.m5151z(), c3769o0.m5144A(), c3769o0.m5146C());
        if (!strM5818A.isEmpty()) {
            m5825L(sbM833U, 0, "filter_type", strM5818A);
        }
        m5836I(sbM833U, 1, c3769o0.m5150y());
        sbM833U.append("}\n");
        return sbM833U.toString();
    }

    /* JADX INFO: renamed from: z */
    public final String m5846z(C3621d1 c3621d1) {
        StringBuilder sbM833U = C1643a.m833U("\nbatch {\n");
        for (C3635e1 c3635e1 : c3621d1.m4626v()) {
            if (c3635e1 != null) {
                m5822H(sbM833U, 1);
                sbM833U.append("bundle {\n");
                if (c3635e1.m4705E()) {
                    m5825L(sbM833U, 1, "protocol_version", Integer.valueOf(c3635e1.m4742g0()));
                }
                m5825L(sbM833U, 1, "platform", c3635e1.m4763y1());
                if (c3635e1.m4714I1()) {
                    m5825L(sbM833U, 1, "gmp_version", Long.valueOf(c3635e1.m4708F()));
                }
                if (c3635e1.m4711H()) {
                    m5825L(sbM833U, 1, "uploading_gmp_version", Long.valueOf(c3635e1.m4713I()));
                }
                if (c3635e1.m4750p0()) {
                    m5825L(sbM833U, 1, "dynamite_version", Long.valueOf(c3635e1.m4751q0()));
                }
                if (c3635e1.m4736a0()) {
                    m5825L(sbM833U, 1, "config_version", Long.valueOf(c3635e1.m4737b0()));
                }
                m5825L(sbM833U, 1, "gmp_app_id", c3635e1.m4726S());
                m5825L(sbM833U, 1, "admob_app_id", c3635e1.m4748o0());
                m5825L(sbM833U, 1, "app_id", c3635e1.m4710G1());
                m5825L(sbM833U, 1, "app_version", c3635e1.m4712H1());
                if (c3635e1.m4731X()) {
                    m5825L(sbM833U, 1, "app_version_major", Integer.valueOf(c3635e1.m4732Y()));
                }
                m5825L(sbM833U, 1, "firebase_instance_id", c3635e1.m4730W());
                if (c3635e1.m4720N()) {
                    m5825L(sbM833U, 1, "dev_cert_hash", Long.valueOf(c3635e1.m4721O()));
                }
                m5825L(sbM833U, 1, "app_store", c3635e1.m4709F1());
                if (c3635e1.m4733Y0()) {
                    m5825L(sbM833U, 1, "upload_timestamp_millis", Long.valueOf(c3635e1.m4735Z0()));
                }
                if (c3635e1.m4743g1()) {
                    m5825L(sbM833U, 1, "start_timestamp_millis", Long.valueOf(c3635e1.m4745h1()));
                }
                if (c3635e1.m4747n1()) {
                    m5825L(sbM833U, 1, "end_timestamp_millis", Long.valueOf(c3635e1.m4749o1()));
                }
                if (c3635e1.m4754s1()) {
                    m5825L(sbM833U, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(c3635e1.m4756t1()));
                }
                if (c3635e1.m4758v1()) {
                    m5825L(sbM833U, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(c3635e1.m4760w1()));
                }
                m5825L(sbM833U, 1, "app_instance_id", c3635e1.m4719M());
                m5825L(sbM833U, 1, "resettable_device_id", c3635e1.m4715J());
                m5825L(sbM833U, 1, "device_id", c3635e1.m4734Z());
                m5825L(sbM833U, 1, "ds_id", c3635e1.m4740e0());
                if (c3635e1.m4716K()) {
                    m5825L(sbM833U, 1, "limited_ad_tracking", Boolean.valueOf(c3635e1.m4718L()));
                }
                m5825L(sbM833U, 1, "os_version", c3635e1.m4701A1());
                m5825L(sbM833U, 1, "device_model", c3635e1.m4702B1());
                m5825L(sbM833U, 1, "user_default_language", c3635e1.m4703C1());
                if (c3635e1.m4704D1()) {
                    m5825L(sbM833U, 1, "time_zone_offset_minutes", Integer.valueOf(c3635e1.m4707E1()));
                }
                if (c3635e1.m4722P()) {
                    m5825L(sbM833U, 1, "bundle_sequential_index", Integer.valueOf(c3635e1.m4724Q()));
                }
                if (c3635e1.m4727T()) {
                    m5825L(sbM833U, 1, "service_upload", Boolean.valueOf(c3635e1.m4728U()));
                }
                m5825L(sbM833U, 1, "health_monitor", c3635e1.m4725R());
                if (!this.f11202a.f11260h.m5526o(C4142p.f11110y0) && c3635e1.m4738c0() && c3635e1.m4739d0() != 0) {
                    m5825L(sbM833U, 1, "android_id", Long.valueOf(c3635e1.m4739d0()));
                }
                if (c3635e1.m4741f0()) {
                    m5825L(sbM833U, 1, "retry_counter", Integer.valueOf(c3635e1.m4746n0()));
                }
                if (c3635e1.m4753s0()) {
                    m5825L(sbM833U, 1, "consent_signals", c3635e1.m4755t0());
                }
                List<C3691i1> listM4717K0 = c3635e1.m4717K0();
                if (listM4717K0 != null) {
                    for (C3691i1 c3691i1 : listM4717K0) {
                        if (c3691i1 != null) {
                            m5822H(sbM833U, 2);
                            sbM833U.append("user_property {\n");
                            m5825L(sbM833U, 2, "set_timestamp_millis", c3691i1.m4956y() ? Long.valueOf(c3691i1.m4957z()) : null);
                            m5825L(sbM833U, 2, ModelAuditLogEntry.CHANGE_KEY_NAME, m5865d().m5769y(c3691i1.m4949D()));
                            m5825L(sbM833U, 2, "string_value", c3691i1.m4951G());
                            m5825L(sbM833U, 2, "int_value", c3691i1.m4952H() ? Long.valueOf(c3691i1.m4953I()) : null);
                            m5825L(sbM833U, 2, "double_value", c3691i1.m4954J() ? Double.valueOf(c3691i1.m4955K()) : null);
                            m5822H(sbM833U, 2);
                            sbM833U.append("}\n");
                        }
                    }
                }
                List<C3899y0> listM4729V = c3635e1.m4729V();
                if (listM4729V != null) {
                    for (C3899y0 c3899y0 : listM4729V) {
                        if (c3899y0 != null) {
                            m5822H(sbM833U, 2);
                            sbM833U.append("audience_membership {\n");
                            if (c3899y0.m5374x()) {
                                m5825L(sbM833U, 2, "audience_id", Integer.valueOf(c3899y0.m5375y()));
                            }
                            if (c3899y0.m5372D()) {
                                m5825L(sbM833U, 2, "new_audience", Boolean.valueOf(c3899y0.m5373E()));
                            }
                            m5824K(sbM833U, 2, "current_data", c3899y0.m5369A());
                            if (c3899y0.m5370B()) {
                                m5824K(sbM833U, 2, "previous_data", c3899y0.m5371C());
                            }
                            m5822H(sbM833U, 2);
                            sbM833U.append("}\n");
                        }
                    }
                }
                List<C3579a1> listM4762y0 = c3635e1.m4762y0();
                if (listM4762y0 != null) {
                    for (C3579a1 c3579a1 : listM4762y0) {
                        if (c3579a1 != null) {
                            m5822H(sbM833U, 2);
                            sbM833U.append("event {\n");
                            m5825L(sbM833U, 2, ModelAuditLogEntry.CHANGE_KEY_NAME, m5865d().m5766u(c3579a1.m4533F()));
                            if (c3579a1.m4534G()) {
                                m5825L(sbM833U, 2, "timestamp_millis", Long.valueOf(c3579a1.m4535H()));
                            }
                            if (c3579a1.m4536I()) {
                                m5825L(sbM833U, 2, "previous_timestamp_millis", Long.valueOf(c3579a1.m4537J()));
                            }
                            if (c3579a1.m4538K()) {
                                m5825L(sbM833U, 2, "count", Integer.valueOf(c3579a1.m4539L()));
                            }
                            if (c3579a1.m4532D() != 0) {
                                m5837M(sbM833U, 2, c3579a1.m4543v());
                            }
                            m5822H(sbM833U, 2);
                            sbM833U.append("}\n");
                        }
                    }
                }
                m5822H(sbM833U, 1);
                sbM833U.append("}\n");
            }
        }
        sbM833U.append("}\n");
        return sbM833U.toString();
    }
}
