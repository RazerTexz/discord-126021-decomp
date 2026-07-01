package b.i.a.c.b3.t;

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
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.q.HorizontalTextInVerticalContextSpan;
import b.i.a.c.b3.q.RubySpan;
import b.i.a.c.b3.q.TextEmphasisSpan;
import b.i.a.c.f3.Util2;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeSet;

/* JADX INFO: renamed from: b.i.a.c.b3.t.d, reason: use source file name */
/* JADX INFO: compiled from: TtmlNode.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TtmlNode {

    @Nullable
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f883b;
    public final boolean c;
    public final long d;
    public final long e;

    @Nullable
    public final TtmlStyle f;

    @Nullable
    public final String[] g;
    public final String h;

    @Nullable
    public final String i;

    @Nullable
    public final TtmlNode j;
    public final HashMap<String, Integer> k;
    public final HashMap<String, Integer> l;
    public List<TtmlNode> m;

    public TtmlNode(@Nullable String str, @Nullable String str2, long j, long j2, @Nullable TtmlStyle ttmlStyle, @Nullable String[] strArr, String str3, @Nullable String str4, @Nullable TtmlNode ttmlNode) {
        this.a = str;
        this.f883b = str2;
        this.i = str4;
        this.f = ttmlStyle;
        this.g = strArr;
        this.c = str2 != null;
        this.d = j;
        this.e = j2;
        Objects.requireNonNull(str3);
        this.h = str3;
        this.j = ttmlNode;
        this.k = new HashMap<>();
        this.l = new HashMap<>();
    }

    public static TtmlNode b(String str) {
        return new TtmlNode(null, str.replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, "", null, null);
    }

    public static SpannableStringBuilder f(String str, Map<String, Cue.b> map) {
        if (!map.containsKey(str)) {
            Cue.b bVar = new Cue.b();
            bVar.a = new SpannableStringBuilder();
            map.put(str, bVar);
        }
        CharSequence charSequence = map.get(str).a;
        Objects.requireNonNull(charSequence);
        return (SpannableStringBuilder) charSequence;
    }

    public void a(TtmlNode ttmlNode) {
        if (this.m == null) {
            this.m = new ArrayList();
        }
        this.m.add(ttmlNode);
    }

    public TtmlNode c(int i) {
        List<TtmlNode> list = this.m;
        if (list != null) {
            return list.get(i);
        }
        throw new IndexOutOfBoundsException();
    }

    public int d() {
        List<TtmlNode> list = this.m;
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
    public final void i(long j, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, String str, Map<String, Cue.b> map3) {
        TtmlNode ttmlNode;
        boolean z2;
        TtmlStyle ttmlStyleT1;
        int i;
        float f;
        Layout.Alignment alignment;
        Layout.Alignment alignment2;
        int i2;
        if (g(j)) {
            String str2 = "".equals(this.h) ? str : this.h;
            Iterator<Map.Entry<String, Integer>> it = this.l.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<String, Integer> next = it.next();
                String key = next.getKey();
                int iIntValue = this.k.containsKey(key) ? this.k.get(key).intValue() : 0;
                int iIntValue2 = next.getValue().intValue();
                if (iIntValue != iIntValue2) {
                    Cue.b bVar = map3.get(key);
                    Objects.requireNonNull(bVar);
                    TtmlRegion ttmlRegion = map2.get(str2);
                    Objects.requireNonNull(ttmlRegion);
                    int i3 = ttmlRegion.j;
                    TtmlStyle ttmlStyleT2 = AnimatableValueParser.T1(this.f, this.g, map);
                    SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) bVar.a;
                    if (spannableStringBuilder == null) {
                        spannableStringBuilder = new SpannableStringBuilder();
                        bVar.a = spannableStringBuilder;
                    }
                    if (ttmlStyleT2 != null) {
                        TtmlNode ttmlNode2 = this.j;
                        if (ttmlStyleT2.b() != -1) {
                            spannableStringBuilder.setSpan(new StyleSpan(ttmlStyleT2.b()), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleT2.f == 1) {
                            spannableStringBuilder.setSpan(new StrikethroughSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleT2.g == 1) {
                            spannableStringBuilder.setSpan(new UnderlineSpan(), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleT2.c) {
                            if (!ttmlStyleT2.c) {
                                throw new IllegalStateException("Font color has not been defined.");
                            }
                            AnimatableValueParser.c(spannableStringBuilder, new ForegroundColorSpan(ttmlStyleT2.f885b), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleT2.e) {
                            if (!ttmlStyleT2.e) {
                                throw new IllegalStateException("Background color has not been defined.");
                            }
                            AnimatableValueParser.c(spannableStringBuilder, new BackgroundColorSpan(ttmlStyleT2.d), iIntValue, iIntValue2, 33);
                        }
                        if (ttmlStyleT2.a != null) {
                            AnimatableValueParser.c(spannableStringBuilder, new TypefaceSpan(ttmlStyleT2.a), iIntValue, iIntValue2, 33);
                        }
                        TextEmphasis textEmphasis = ttmlStyleT2.r;
                        if (textEmphasis != null) {
                            int i4 = textEmphasis.f;
                            if (i4 == -1) {
                                i4 = (i3 == 2 || i3 == 1) ? 3 : 1;
                                i2 = 1;
                            } else {
                                i2 = textEmphasis.g;
                            }
                            int i5 = textEmphasis.h;
                            if (i5 == -2) {
                                i5 = 1;
                            }
                            AnimatableValueParser.c(spannableStringBuilder, new TextEmphasisSpan(i4, i2, i5), iIntValue, iIntValue2, 33);
                        }
                        int i6 = ttmlStyleT2.m;
                        if (i6 == 2) {
                            while (true) {
                                if (ttmlNode2 == null) {
                                    ttmlNode2 = null;
                                    break;
                                }
                                TtmlStyle ttmlStyleT3 = AnimatableValueParser.T1(ttmlNode2.f, ttmlNode2.g, map);
                                if (ttmlStyleT3 != null && ttmlStyleT3.m == 1) {
                                    break;
                                } else {
                                    ttmlNode2 = ttmlNode2.j;
                                }
                            }
                            if (ttmlNode2 != null) {
                                ArrayDeque arrayDeque = new ArrayDeque();
                                arrayDeque.push(ttmlNode2);
                                while (true) {
                                    if (arrayDeque.isEmpty()) {
                                        ttmlNode = null;
                                        break;
                                    }
                                    TtmlNode ttmlNode3 = (TtmlNode) arrayDeque.pop();
                                    TtmlStyle ttmlStyleT4 = AnimatableValueParser.T1(ttmlNode3.f, ttmlNode3.g, map);
                                    if (ttmlStyleT4 != null && ttmlStyleT4.m == 3) {
                                        ttmlNode = ttmlNode3;
                                        break;
                                    }
                                    for (int iD = ttmlNode3.d() - 1; iD >= 0; iD--) {
                                        arrayDeque.push(ttmlNode3.c(iD));
                                    }
                                }
                                if (ttmlNode != null) {
                                    if (ttmlNode.d() == 1) {
                                        z2 = false;
                                        if (ttmlNode.c(0).f883b != null) {
                                            String str3 = ttmlNode.c(0).f883b;
                                            int i7 = Util2.a;
                                            TtmlStyle ttmlStyleT5 = AnimatableValueParser.T1(ttmlNode.f, ttmlNode.g, map);
                                            int i8 = ttmlStyleT5 != null ? ttmlStyleT5.n : -1;
                                            if (i8 == -1 && (ttmlStyleT1 = AnimatableValueParser.T1(ttmlNode2.f, ttmlNode2.g, map)) != null) {
                                                i8 = ttmlStyleT1.n;
                                            }
                                            spannableStringBuilder.setSpan(new RubySpan(str3, i8), iIntValue, iIntValue2, 33);
                                        }
                                    } else {
                                        z2 = false;
                                    }
                                    Log.i("TtmlRenderUtil", "Skipping rubyText node without exactly one text child.");
                                }
                            }
                            if (ttmlStyleT2.q == 1) {
                                z2 = true;
                            }
                            if (z2) {
                                AnimatableValueParser.c(spannableStringBuilder, new HorizontalTextInVerticalContextSpan(), iIntValue, iIntValue2, 33);
                            }
                            i = ttmlStyleT2.j;
                            if (i != 1) {
                                AnimatableValueParser.c(spannableStringBuilder, new AbsoluteSizeSpan((int) ttmlStyleT2.k, true), iIntValue, iIntValue2, 33);
                            } else if (i != 2) {
                                AnimatableValueParser.c(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleT2.k), iIntValue, iIntValue2, 33);
                            } else if (i == 3) {
                                AnimatableValueParser.c(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleT2.k / 100.0f), iIntValue, iIntValue2, 33);
                            }
                            if ("p".equals(this.a)) {
                                f = ttmlStyleT2.f886s;
                                if (f != Float.MAX_VALUE) {
                                    bVar.q = (f * (-90.0f)) / 100.0f;
                                }
                                alignment = ttmlStyleT2.o;
                                if (alignment != null) {
                                    bVar.c = alignment;
                                }
                                alignment2 = ttmlStyleT2.p;
                                if (alignment2 != null) {
                                    bVar.d = alignment2;
                                }
                            }
                        } else if (i6 == 3 || i6 == 4) {
                            spannableStringBuilder.setSpan(new DeleteTextSpan(), iIntValue, iIntValue2, 33);
                        }
                        z2 = false;
                        if (ttmlStyleT2.q == 1) {
                            z2 = true;
                        }
                        if (z2) {
                            AnimatableValueParser.c(spannableStringBuilder, new HorizontalTextInVerticalContextSpan(), iIntValue, iIntValue2, 33);
                        }
                        i = ttmlStyleT2.j;
                        if (i != 1) {
                            AnimatableValueParser.c(spannableStringBuilder, new AbsoluteSizeSpan((int) ttmlStyleT2.k, true), iIntValue, iIntValue2, 33);
                        } else if (i != 2) {
                            AnimatableValueParser.c(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleT2.k), iIntValue, iIntValue2, 33);
                        } else if (i == 3) {
                            AnimatableValueParser.c(spannableStringBuilder, new RelativeSizeSpan(ttmlStyleT2.k / 100.0f), iIntValue, iIntValue2, 33);
                        }
                        if ("p".equals(this.a)) {
                            f = ttmlStyleT2.f886s;
                            if (f != Float.MAX_VALUE) {
                                bVar.q = (f * (-90.0f)) / 100.0f;
                            }
                            alignment = ttmlStyleT2.o;
                            if (alignment != null) {
                                bVar.c = alignment;
                            }
                            alignment2 = ttmlStyleT2.p;
                            if (alignment2 != null) {
                                bVar.d = alignment2;
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

    public final void j(long j, boolean z2, String str, Map<String, Cue.b> map) {
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
            for (Map.Entry<String, Cue.b> entry : map.entrySet()) {
                HashMap<String, Integer> map2 = this.k;
                String key = entry.getKey();
                CharSequence charSequence = entry.getValue().a;
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
            for (Map.Entry<String, Cue.b> entry2 : map.entrySet()) {
                HashMap<String, Integer> map3 = this.l;
                String key2 = entry2.getKey();
                CharSequence charSequence2 = entry2.getValue().a;
                Objects.requireNonNull(charSequence2);
                map3.put(key2, Integer.valueOf(charSequence2.length()));
            }
        }
    }
}
