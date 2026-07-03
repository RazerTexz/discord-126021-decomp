package p007b.p225i.p226a.p242c.p245b3.p252t;

import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StrikethroughSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p225i.p226a.p242c.p245b3.C2578b;
import p007b.p225i.p226a.p242c.p245b3.p249q.C2601a;
import p007b.p225i.p226a.p242c.p245b3.p249q.C2603c;
import p007b.p225i.p226a.p242c.p245b3.p249q.C2604d;
import p007b.p225i.p226a.p242c.p259f3.C2738e0;

/* JADX INFO: renamed from: b.i.a.c.b3.t.d */
/* JADX INFO: compiled from: TtmlNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class C2614d {

    /* JADX INFO: renamed from: a */
    @Nullable
    public final String f6050a;

    /* JADX INFO: renamed from: b */
    @Nullable
    public final String f6051b;

    /* JADX INFO: renamed from: c */
    public final boolean f6052c;

    /* JADX INFO: renamed from: d */
    public final long f6053d;

    /* JADX INFO: renamed from: e */
    public final long f6054e;

    /* JADX INFO: renamed from: f */
    @Nullable
    public final C2616f f6055f;

    /* JADX INFO: renamed from: g */
    @Nullable
    public final String[] f6056g;

    /* JADX INFO: renamed from: h */
    public final String f6057h;

    /* JADX INFO: renamed from: i */
    @Nullable
    public final String f6058i;

    /* JADX INFO: renamed from: j */
    @Nullable
    public final C2614d f6059j;

    /* JADX INFO: renamed from: k */
    public final HashMap<String, Integer> f6060k;

    /* JADX INFO: renamed from: l */
    public final HashMap<String, Integer> f6061l;

    /* JADX INFO: renamed from: m */
    public List<C2614d> f6062m;

    public C2614d(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable C2616f c2616f, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable C2614d c2614d) {
        this.f6050a = str;
        this.f6051b = str2;
        this.f6058i = str4;
        this.f6055f = c2616f;
        this.f6056g = strArr;
        this.f6052c = str2 != null;
        this.f6053d = j;
        this.f6054e = j2;
        Objects.requireNonNull(str3);
        this.f6057h = str3;
        this.f6059j = c2614d;
        this.f6060k = new HashMap<>();
        this.f6061l = new HashMap<>();
    }

    /* JADX INFO: renamed from: b */
    public static C2614d m2691b(String str) {
        return new C2614d(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    /* JADX INFO: renamed from: f */
    public static SpannableStringBuilder m2692f(String str, Map<String, C2578b.b> map) {
        if (!map.containsKey(str)) {
            C2578b.b bVar = new C2578b.b();
            bVar.f5773a = new SpannableStringBuilder();
            map.put(str, bVar);
        }
        CharSequence charSequence = map.get(str).f5773a;
        Objects.requireNonNull(charSequence);
        return (SpannableStringBuilder) charSequence;
    }

    /* JADX INFO: renamed from: a */
    public void m2693a(C2614d c2614d) {
        if (this.f6062m == null) {
            this.f6062m = new ArrayList();
        }
        this.f6062m.add(c2614d);
    }

    /* JADX INFO: renamed from: c */
    public C2614d m2694c(int i) {
        List<C2614d> list = this.f6062m;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    /* JADX INFO: renamed from: d */
    public int m2695d() {
        List<C2614d> list = this.f6062m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    /* JADX INFO: renamed from: e */
    public final void m2696e(TreeSet<Long> treeSet, boolean z2) {
        boolean zEquals = "p".equals(this.f6050a);
        boolean zEquals2 = "div".equals(this.f6050a);
        if (z2 || zEquals || (zEquals2 && this.f6058i != null)) {
            long j = this.f6053d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.f6054e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.f6062m == null) {
            return;
        }
        for (int i = 0; i < this.f6062m.size(); i++) {
            this.f6062m.get(i).m2696e(treeSet, z2 || zEquals);
        }
    }

    /* JADX INFO: renamed from: g */
    public boolean m2697g(long j) {
        long j2 = this.f6053d;
        return (j2 == -9223372036854775807L && this.f6054e == -9223372036854775807L) || (j2 <= j && this.f6054e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.f6054e) || (j2 <= j && j < this.f6054e));
    }

    /* JADX INFO: renamed from: h */
    public final void m2698h(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.f6057h)) {
            str = this.f6057h;
        }
        if (m2697g(j) && "div".equals(this.f6050a) && this.f6058i != null) {
            list.add(new Pair<>(str, this.f6058i));
            return;
        }
        for (int i = 0; i < m2695d(); i++) {
            m2694c(i).m2698h(j, str, list);
        }
    }

    /* JADX WARN: Code duplicated, block: B:121:0x01eb  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:126:0x01fe A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:127:0x0200  */
    /* JADX WARN: Code duplicated, block: B:130:0x0204  */
    /* JADX WARN: Code duplicated, block: B:131:0x0212  */
    /* JADX WARN: Code duplicated, block: B:132:0x021f  */
    /* JADX WARN: Code duplicated, block: B:135:0x0237  */
    /* JADX WARN: Code duplicated, block: B:137:0x0240  */
    /* JADX WARN: Code duplicated, block: B:140:0x024b  */
    /* JADX WARN: Code duplicated, block: B:143:0x0251  */
    /* JADX WARN: Code duplicated, block: B:156:0x025a A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x025a A[SYNTHETIC] */
    /* JADX INFO: renamed from: i */
    public final void m2699i(long j, Map<String, C2616f> map, Map<String, C2615e> map2, String str, Map<String, C2578b.b> map3) {
        C2614d c2614d;
        boolean z2;
        C2616f c2616fM476T1;
        int i;
        float f;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        int i2;
        if (m2697g(j)) {
            String str2 = "".equals(this.f6057h) ? str : this.f6057h;
            Iterator<Map.Entry<String, Integer>> it = this.f6061l.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.f6060k.containsKey(key) ? this.f6060k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    C2578b.b bVar = map3.get(key);
                    Objects.requireNonNull(bVar);
                    C2615e c2615e = map2.get(str2);
                    Objects.requireNonNull(c2615e);
                    int i3 = c2615e.f6072j;
                    C2616f c2616fM476T2 = C1460d.m476T1(this.f6055f, this.f6056g, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.f5773a;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        bVar.f5773a = spannableStringBuilder;
                    }
                    if (c2616fM476T2 != null) {
                        C2614d c2614d2 = this.f6059j;
                        if (c2616fM476T2.m2702b() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(c2616fM476T2.m2702b()), iIntValue, iIntValue2, 33);
                        }
                        if (c2616fM476T2.f6078f == 1) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (c2616fM476T2.f6079g == 1) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (c2616fM476T2.f6075c) {
                            if (!c2616fM476T2.f6075c) {
                                throw new IllegalStateException("Font color has not been defined.");
                            }
                            C1460d.m503c(spannableStringBuilder, new ForegroundColorSpan(c2616fM476T2.f6074b), iIntValue, iIntValue2, 33);
                        }
                        if (c2616fM476T2.f6077e) {
                            if (!c2616fM476T2.f6077e) {
                                throw new IllegalStateException("Background color has not been defined.");
                            }
                            C1460d.m503c(spannableStringBuilder, new BackgroundColorSpan(c2616fM476T2.f6076d), iIntValue, iIntValue2, 33);
                        }
                        if (c2616fM476T2.f6073a != null) {
                            C1460d.m503c(spannableStringBuilder, new TypefaceSpan(c2616fM476T2.f6073a), iIntValue, iIntValue2, 33);
                        }
                        C2612b c2612b = c2616fM476T2.f6090r;
                        if (c2612b != null) {
                            int i4 = c2612b.f6031f;
                            if (i4 == -1) {
                                i4 = (i3 == 2 || i3 == 1) ? 3 : 1;
                                i2 = 1;
                            } else {
                                i2 = c2612b.f6032g;
                            }
                            int i5 = c2612b.f6033h;
                            if (i5 == -2) {
                                i5 = 1;
                            }
                            C1460d.m503c(spannableStringBuilder, new C2604d(i4, i2, i5), iIntValue, iIntValue2, 33);
                        }
                        int i6 = c2616fM476T2.f6085m;
                        if (i6 == 2) {
                            while (true) {
                                if (c2614d2 == null) {
                                    c2614d2 = null;
                                    break;
                                }
                                C2616f c2616fM476T3 = C1460d.m476T1(c2614d2.f6055f, c2614d2.f6056g, map);
                                if (c2616fM476T3 != null && c2616fM476T3.f6085m == 1) {
                                    break;
                                } else {
                                    c2614d2 = c2614d2.f6059j;
                                }
                            }
                            if (c2614d2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(c2614d2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        c2614d = null;
                                        break;
                                    }
                                    C2614d c2614d3 = (C2614d) arrayDeque.pop();
                                    C2616f c2616fM476T4 = C1460d.m476T1(c2614d3.f6055f, c2614d3.f6056g, map);
                                    if (c2616fM476T4 != null && c2616fM476T4.f6085m == 3) {
                                        c2614d = c2614d3;
                                        break;
                                    }
                                    for (int iM2695d = c2614d3.m2695d() - 1; iM2695d >= 0; iM2695d--) {
                                        arrayDeque.push(c2614d3.m2694c(iM2695d));
                                    }
                                }
                                if (c2614d != null) {
                                    if (c2614d.m2695d() == 1) {
                                        z2 = false;
                                        if (c2614d.m2694c(0).f6051b != null) {
                                            String str3 = c2614d.m2694c(0).f6051b;
                                            int i7 = C2738e0.f6708a;
                                            C2616f c2616fM476T5 = C1460d.m476T1(c2614d.f6055f, c2614d.f6056g, map);
                                            int i8 = c2616fM476T5 != null ? c2616fM476T5.f6086n : -1;
                                            if (i8 == -1 && (c2616fM476T1 = C1460d.m476T1(c2614d2.f6055f, c2614d2.f6056g, map)) != null) {
                                                i8 = c2616fM476T1.f6086n;
                                            }
                                            spannableStringBuilder.setSpan(new C2603c(str3, i8), iIntValue, iIntValue2, 33);
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                }
                            }
                            if (c2616fM476T2.f6089q == 1) {
                                z2 = true;
                            }
                            if (z2) {
                                C1460d.m503c(spannableStringBuilder, new C2601a(), iIntValue, iIntValue2, 33);
                            }
                            i = c2616fM476T2.f6082j;
                            if (i != 1) {
                                C1460d.m503c(spannableStringBuilder, new AbsoluteSizeSpan((int) c2616fM476T2.f6083k, true), iIntValue, iIntValue2, 33);
                            } else if (i != 2) {
                                C1460d.m503c(spannableStringBuilder, new RelativeSizeSpan(c2616fM476T2.f6083k), iIntValue, iIntValue2, 33);
                            } else if (i == 3) {
                                C1460d.m503c(spannableStringBuilder, new RelativeSizeSpan(c2616fM476T2.f6083k / 100.0f), iIntValue, iIntValue2, 33);
                            }
                            if ("p".equals(this.f6050a)) {
                                f = c2616fM476T2.f6091s;
                                if (f != Float.MAX_VALUE) {
                                    bVar.f5789q = (f * (-90.0f)) / 100.0f;
                                }
                                alignment = c2616fM476T2.f6087o;
                                if (alignment != null) {
                                    bVar.f5775c = alignment;
                                }
                                alignment2 = c2616fM476T2.f6088p;
                                if (alignment2 != null) {
                                    bVar.f5776d = alignment2;
                                }
                            }
                        } else if (i6 == 3 || i6 == 4) {
                            spannableStringBuilder.setSpan(new C2611a(), iIntValue, iIntValue2, 33);
                        }
                        z2 = false;
                        if (c2616fM476T2.f6089q == 1) {
                            z2 = true;
                        }
                        if (z2) {
                            C1460d.m503c(spannableStringBuilder, new C2601a(), iIntValue, iIntValue2, 33);
                        }
                        i = c2616fM476T2.f6082j;
                        if (i != 1) {
                            C1460d.m503c(spannableStringBuilder, new AbsoluteSizeSpan((int) c2616fM476T2.f6083k, true), iIntValue, iIntValue2, 33);
                        } else if (i != 2) {
                            C1460d.m503c(spannableStringBuilder, new RelativeSizeSpan(c2616fM476T2.f6083k), iIntValue, iIntValue2, 33);
                        } else if (i == 3) {
                            C1460d.m503c(spannableStringBuilder, new RelativeSizeSpan(c2616fM476T2.f6083k / 100.0f), iIntValue, iIntValue2, 33);
                        }
                        if ("p".equals(this.f6050a)) {
                            f = c2616fM476T2.f6091s;
                            if (f != Float.MAX_VALUE) {
                                bVar.f5789q = (f * (-90.0f)) / 100.0f;
                            }
                            alignment = c2616fM476T2.f6087o;
                            if (alignment != null) {
                                bVar.f5775c = alignment;
                            }
                            alignment2 = c2616fM476T2.f6088p;
                            if (alignment2 != null) {
                                bVar.f5776d = alignment2;
                            }
                        }
                    }
                    it = it;
                }
                it = it;
                it = it;
            }
            for (int i9 = 0; i9 < m2695d(); i9++) {
                m2694c(i9).m2699i(j, map, map2, str2, map3);
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public final void m2700j(long j, boolean z2, String str, Map<String, C2578b.b> map) {
        this.f6060k.clear();
        this.f6061l.clear();
        if ("metadata".equals(this.f6050a)) {
            return;
        }
        if (!"".equals(this.f6057h)) {
            str = this.f6057h;
        }
        if (this.f6052c && z2) {
            SpannableStringBuilder spannableStringBuilderM2692f = m2692f(str, map);
            String str2 = this.f6051b;
            Objects.requireNonNull(str2);
            spannableStringBuilderM2692f.append((CharSequence) str2);
            return;
        }
        if ("br".equals(this.f6050a) && z2) {
            m2692f(str, map).append('\n');
            return;
        }
        if (m2697g(j)) {
            for (Map.Entry<String, C2578b.b> entry : map.entrySet()) {
                HashMap<String, Integer> map2 = this.f6060k;
                String key = entry.getKey();
                CharSequence charSequence = entry.getValue().f5773a;
                Objects.requireNonNull(charSequence);
                map2.put(key, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(this.f6050a);
            for (int i = 0; i < m2695d(); i++) {
                m2694c(i).m2700j(j, z2 || zEquals, str, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderM2692f2 = m2692f(str, map);
                int length = spannableStringBuilderM2692f2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderM2692f2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderM2692f2.charAt(length) != '\n') {
                    spannableStringBuilderM2692f2.append('\n');
                }
            }
            for (Map.Entry<String, C2578b.b> entry2 : map.entrySet()) {
                HashMap<String, Integer> map3 = this.f6061l;
                String key2 = entry2.getKey();
                CharSequence charSequence2 = entry2.getValue().f5773a;
                Objects.requireNonNull(charSequence2);
                map3.put(key2, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
