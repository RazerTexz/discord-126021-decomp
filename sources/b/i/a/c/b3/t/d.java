package b.i.a.c.b3.t;

import android.text.Layout$Alignment;
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
import b.i.a.c.b3.b$b;
import b.i.a.c.f3.e0;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Objects;
import java.util.TreeSet;

/* JADX INFO: compiled from: TtmlNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class d {

    @Nullable
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f883b;
    public final boolean c;
    public final long d;
    public final long e;

    @Nullable
    public final f f;

    @Nullable
    public final String[] g;
    public final String h;

    @Nullable
    public final String i;

    @Nullable
    public final d j;
    public final HashMap<String, Integer> k;
    public final HashMap<String, Integer> l;
    public List<d> m;

    public d(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable f fVar, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable d dVar) {
        this.a = str;
        this.f883b = str2;
        this.i = str4;
        this.f = fVar;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        Objects.requireNonNull(str3);
        this.h = str3;
        this.j = dVar;
        this.k = new HashMap<>();
        this.l = new HashMap<>();
    }

    public static d b(String str) {
        return new d(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder f(String str, Map<String, b$b> map) {
        if (!map.containsKey(str)) {
            b$b b_b = new b$b();
            b_b.a = new SpannableStringBuilder();
            map.put(str, b_b);
        }
        CharSequence charSequence = map.get(str).a;
        Objects.requireNonNull(charSequence);
        return (SpannableStringBuilder) charSequence;
    }

    public void a(d dVar) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(dVar);
    }

    public d c(int i) {
        List<d> list = this.m;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int d() {
        List<d> list = this.m;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public final void e(TreeSet<Long> treeSet, boolean z2) {
        boolean zEquals = "p".equals(this.a);
        boolean zEquals2 = "div".equals(this.a);
        if (z2 || zEquals || (zEquals2 && this.i != null)) {
            long j = this.d;
            if (j != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j));
            }
            long j2 = this.e;
            if (j2 != -9223372036854775807L) {
                treeSet.add(Long.valueOf(j2));
            }
        }
        if (this.m == null) {
            return;
        }
        for (int i = 0; i < this.m.size(); i++) {
            this.m.get(i).e(treeSet, z2 || zEquals);
        }
    }

    public boolean g(long j) {
        long j2 = this.d;
        return (j2 == -9223372036854775807L && this.e == -9223372036854775807L) || (j2 <= j && this.e == -9223372036854775807L) || ((j2 == -9223372036854775807L && j < this.e) || (j2 <= j && j < this.e));
    }

    public final void h(long j, String str, List<Pair<String, String>> list) {
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (g(j) && "div".equals(this.a) && this.i != null) {
            list.add(new Pair<>(str, this.i));
            return;
        }
        for (int i = 0; i < d(); i++) {
            c(i).h(j, str, list);
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
    public final void i(long j, Map<String, f> map, Map<String, e> map2, String str, Map<String, b$b> map3) {
        d dVar;
        boolean z2;
        f fVarT1;
        int i;
        float f;
        Layout$Alignment layout$Alignment;
        Layout$Alignment layout$Alignment2;
        int i2;
        if (g(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator<Map$Entry<String, Integer>> it = this.l.entrySet().iterator();
            while (it.hasNext()) {
                Map$Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.k.containsKey(key) ? this.k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    b$b b_b = map3.get(key);
                    Objects.requireNonNull(b_b);
                    e eVar = map2.get(str2);
                    Objects.requireNonNull(eVar);
                    int i3 = eVar.j;
                    f fVarT2 = b.c.a.a0.d.T1(this.f, this.g, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) b_b.a;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        b_b.a = spannableStringBuilder;
                    }
                    if (fVarT2 != null) {
                        d dVar2 = this.j;
                        if (fVarT2.b() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(fVarT2.b()), iIntValue, iIntValue2, 33);
                        }
                        if (fVarT2.f == 1) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (fVarT2.g == 1) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (fVarT2.c) {
                            if (!fVarT2.c) {
                                throw new IllegalStateException("Font color has not been defined.");
                            }
                            b.c.a.a0.d.c(spannableStringBuilder, new ForegroundColorSpan(fVarT2.f885b), iIntValue, iIntValue2, 33);
                        }
                        if (fVarT2.e) {
                            if (!fVarT2.e) {
                                throw new IllegalStateException("Background color has not been defined.");
                            }
                            b.c.a.a0.d.c(spannableStringBuilder, new BackgroundColorSpan(fVarT2.d), iIntValue, iIntValue2, 33);
                        }
                        if (fVarT2.a != null) {
                            b.c.a.a0.d.c(spannableStringBuilder, new TypefaceSpan(fVarT2.a), iIntValue, iIntValue2, 33);
                        }
                        b bVar = fVarT2.r;
                        if (bVar != null) {
                            int i4 = bVar.f;
                            if (i4 == -1) {
                                i4 = (i3 == 2 || i3 == 1) ? 3 : 1;
                                i2 = 1;
                            } else {
                                i2 = bVar.g;
                            }
                            int i5 = bVar.h;
                            if (i5 == -2) {
                                i5 = 1;
                            }
                            b.c.a.a0.d.c(spannableStringBuilder, new b.i.a.c.b3.q.d(i4, i2, i5), iIntValue, iIntValue2, 33);
                        }
                        int i6 = fVarT2.m;
                        if (i6 == 2) {
                            while (true) {
                                if (dVar2 == null) {
                                    dVar2 = null;
                                    break;
                                }
                                f fVarT3 = b.c.a.a0.d.T1(dVar2.f, dVar2.g, map);
                                if (fVarT3 != null && fVarT3.m == 1) {
                                    break;
                                } else {
                                    dVar2 = dVar2.j;
                                }
                            }
                            if (dVar2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(dVar2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        dVar = null;
                                        break;
                                    }
                                    d dVar3 = (d) arrayDeque.pop();
                                    f fVarT4 = b.c.a.a0.d.T1(dVar3.f, dVar3.g, map);
                                    if (fVarT4 != null && fVarT4.m == 3) {
                                        dVar = dVar3;
                                        break;
                                    }
                                    for (int iD = dVar3.d() - 1; iD >= 0; iD--) {
                                        arrayDeque.push(dVar3.c(iD));
                                    }
                                }
                                if (dVar != null) {
                                    if (dVar.d() == 1) {
                                        z2 = false;
                                        if (dVar.c(0).f883b != null) {
                                            String str3 = dVar.c(0).f883b;
                                            int i7 = e0.a;
                                            f fVarT5 = b.c.a.a0.d.T1(dVar.f, dVar.g, map);
                                            int i8 = fVarT5 != null ? fVarT5.n : -1;
                                            if (i8 == -1 && (fVarT1 = b.c.a.a0.d.T1(dVar2.f, dVar2.g, map)) != null) {
                                                i8 = fVarT1.n;
                                            }
                                            spannableStringBuilder.setSpan(new b.i.a.c.b3.q.c(str3, i8), iIntValue, iIntValue2, 33);
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                }
                            }
                            if (fVarT2.q == 1) {
                                z2 = true;
                            }
                            if (z2) {
                                b.c.a.a0.d.c(spannableStringBuilder, new b.i.a.c.b3.q.a(), iIntValue, iIntValue2, 33);
                            }
                            i = fVarT2.j;
                            if (i != 1) {
                                b.c.a.a0.d.c(spannableStringBuilder, new AbsoluteSizeSpan((int) fVarT2.k, true), iIntValue, iIntValue2, 33);
                            } else if (i != 2) {
                                b.c.a.a0.d.c(spannableStringBuilder, new RelativeSizeSpan(fVarT2.k), iIntValue, iIntValue2, 33);
                            } else if (i == 3) {
                                b.c.a.a0.d.c(spannableStringBuilder, new RelativeSizeSpan(fVarT2.k / 100.0f), iIntValue, iIntValue2, 33);
                            }
                            if ("p".equals(this.a)) {
                                f = fVarT2.f886s;
                                if (f != Float.MAX_VALUE) {
                                    b_b.q = (f * (-90.0f)) / 100.0f;
                                }
                                layout$Alignment = fVarT2.o;
                                if (layout$Alignment != null) {
                                    b_b.c = layout$Alignment;
                                }
                                layout$Alignment2 = fVarT2.p;
                                if (layout$Alignment2 != null) {
                                    b_b.d = layout$Alignment2;
                                }
                            }
                        } else if (i6 == 3 || i6 == 4) {
                            spannableStringBuilder.setSpan(new a(), iIntValue, iIntValue2, 33);
                        }
                        z2 = false;
                        if (fVarT2.q == 1) {
                            z2 = true;
                        }
                        if (z2) {
                            b.c.a.a0.d.c(spannableStringBuilder, new b.i.a.c.b3.q.a(), iIntValue, iIntValue2, 33);
                        }
                        i = fVarT2.j;
                        if (i != 1) {
                            b.c.a.a0.d.c(spannableStringBuilder, new AbsoluteSizeSpan((int) fVarT2.k, true), iIntValue, iIntValue2, 33);
                        } else if (i != 2) {
                            b.c.a.a0.d.c(spannableStringBuilder, new RelativeSizeSpan(fVarT2.k), iIntValue, iIntValue2, 33);
                        } else if (i == 3) {
                            b.c.a.a0.d.c(spannableStringBuilder, new RelativeSizeSpan(fVarT2.k / 100.0f), iIntValue, iIntValue2, 33);
                        }
                        if ("p".equals(this.a)) {
                            f = fVarT2.f886s;
                            if (f != Float.MAX_VALUE) {
                                b_b.q = (f * (-90.0f)) / 100.0f;
                            }
                            layout$Alignment = fVarT2.o;
                            if (layout$Alignment != null) {
                                b_b.c = layout$Alignment;
                            }
                            layout$Alignment2 = fVarT2.p;
                            if (layout$Alignment2 != null) {
                                b_b.d = layout$Alignment2;
                            }
                        }
                    }
                    it = it;
                }
                it = it;
                it = it;
            }
            for (int i9 = 0; i9 < d(); i9++) {
                c(i9).i(j, map, map2, str2, map3);
            }
        }
    }

    public final void j(long j, boolean z2, String str, Map<String, b$b> map) {
        this.k.clear();
        this.l.clear();
        if ("metadata".equals(this.a)) {
            return;
        }
        if (!"".equals(this.h)) {
            str = this.h;
        }
        if (this.c && z2) {
            SpannableStringBuilder spannableStringBuilderF = f(str, map);
            String str2 = this.f883b;
            Objects.requireNonNull(str2);
            spannableStringBuilderF.append((CharSequence) str2);
            return;
        }
        if ("br".equals(this.a) && z2) {
            f(str, map).append('\n');
            return;
        }
        if (g(j)) {
            for (Map$Entry<String, b$b> map$Entry : map.entrySet()) {
                HashMap<String, Integer> map2 = this.k;
                String key = map$Entry.getKey();
                CharSequence charSequence = map$Entry.getValue().a;
                Objects.requireNonNull(charSequence);
                map2.put(key, Integer.valueOf(charSequence.length()));
            }
            boolean zEquals = "p".equals(this.a);
            for (int i = 0; i < d(); i++) {
                c(i).j(j, z2 || zEquals, str, map);
            }
            if (zEquals) {
                SpannableStringBuilder spannableStringBuilderF2 = f(str, map);
                int length = spannableStringBuilderF2.length();
                do {
                    length--;
                    if (length < 0) {
                        break;
                    }
                } while (spannableStringBuilderF2.charAt(length) == ' ');
                if (length >= 0 && spannableStringBuilderF2.charAt(length) != '\n') {
                    spannableStringBuilderF2.append('\n');
                }
            }
            for (Map$Entry<String, b$b> map$Entry2 : map.entrySet()) {
                HashMap<String, Integer> map3 = this.l;
                String key2 = map$Entry2.getKey();
                CharSequence charSequence2 = map$Entry2.getValue().a;
                Objects.requireNonNull(charSequence2);
                map3.put(key2, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
