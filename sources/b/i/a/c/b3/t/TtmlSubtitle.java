package b.i.a.c.b3.t;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.SpannableStringBuilder;
import android.util.Base64;
import android.util.Pair;
import androidx.core.view.ViewCompat;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.Util2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.TreeSet;

/* JADX INFO: renamed from: b.i.a.c.b3.t.g, reason: use source file name */
/* JADX INFO: compiled from: TtmlSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TtmlSubtitle implements Subtitle {
    public final TtmlNode j;
    public final long[] k;
    public final Map<String, TtmlStyle> l;
    public final Map<String, TtmlRegion> m;
    public final Map<String, String> n;

    public TtmlSubtitle(TtmlNode ttmlNode, Map<String, TtmlStyle> map, Map<String, TtmlRegion> map2, Map<String, String> map3) {
        this.j = ttmlNode;
        this.m = map2;
        this.n = map3;
        this.l = Collections.unmodifiableMap(map);
        TreeSet<Long> treeSet = new TreeSet<>();
        int i = 0;
        ttmlNode.e(treeSet, false);
        long[] jArr = new long[treeSet.size()];
        Iterator<Long> it = treeSet.iterator();
        while (it.hasNext()) {
            jArr[i] = it.next().longValue();
            i++;
        }
        this.k = jArr;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        int iB = Util2.b(this.k, j, false, false);
        if (iB < this.k.length) {
            return iB;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        return this.k[i];
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        TtmlNode ttmlNode = this.j;
        Map<String, TtmlStyle> map = this.l;
        Map<String, TtmlRegion> map2 = this.m;
        Map<String, String> map3 = this.n;
        Objects.requireNonNull(ttmlNode);
        ArrayList<Pair> arrayList = new ArrayList();
        ttmlNode.h(j, ttmlNode.h, arrayList);
        TreeMap treeMap = new TreeMap();
        ttmlNode.j(j, false, ttmlNode.h, treeMap);
        ttmlNode.i(j, map, map2, ttmlNode.h, treeMap);
        ArrayList arrayList2 = new ArrayList();
        for (Pair pair : arrayList) {
            String str = map3.get(pair.second);
            if (str != null) {
                byte[] bArrDecode = Base64.decode(str, 0);
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
                TtmlRegion ttmlRegion = map2.get(pair.first);
                Objects.requireNonNull(ttmlRegion);
                arrayList2.add(new Cue(null, null, null, bitmapDecodeByteArray, ttmlRegion.c, 0, ttmlRegion.e, ttmlRegion.f884b, 0, Integer.MIN_VALUE, -3.4028235E38f, ttmlRegion.f, ttmlRegion.g, false, ViewCompat.MEASURED_STATE_MASK, ttmlRegion.j, 0.0f, null));
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            TtmlRegion ttmlRegion2 = map2.get(entry.getKey());
            Objects.requireNonNull(ttmlRegion2);
            Cue.b bVar = (Cue.b) entry.getValue();
            CharSequence charSequence = bVar.a;
            Objects.requireNonNull(charSequence);
            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) charSequence;
            for (DeleteTextSpan deleteTextSpan : (DeleteTextSpan[]) spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), DeleteTextSpan.class)) {
                spannableStringBuilder.replace(spannableStringBuilder.getSpanStart(deleteTextSpan), spannableStringBuilder.getSpanEnd(deleteTextSpan), (CharSequence) "");
            }
            for (int i = 0; i < spannableStringBuilder.length(); i++) {
                if (spannableStringBuilder.charAt(i) == ' ') {
                    int i2 = i + 1;
                    int i3 = i2;
                    while (i3 < spannableStringBuilder.length() && spannableStringBuilder.charAt(i3) == ' ') {
                        i3++;
                    }
                    int i4 = i3 - i2;
                    if (i4 > 0) {
                        spannableStringBuilder.delete(i, i4 + i);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(0) == ' ') {
                spannableStringBuilder.delete(0, 1);
            }
            for (int i5 = 0; i5 < spannableStringBuilder.length() - 1; i5++) {
                if (spannableStringBuilder.charAt(i5) == '\n') {
                    int i6 = i5 + 1;
                    if (spannableStringBuilder.charAt(i6) == ' ') {
                        spannableStringBuilder.delete(i6, i5 + 2);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == ' ') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            for (int i7 = 0; i7 < spannableStringBuilder.length() - 1; i7++) {
                if (spannableStringBuilder.charAt(i7) == ' ') {
                    int i8 = i7 + 1;
                    if (spannableStringBuilder.charAt(i8) == '\n') {
                        spannableStringBuilder.delete(i7, i8);
                    }
                }
            }
            if (spannableStringBuilder.length() > 0 && spannableStringBuilder.charAt(spannableStringBuilder.length() - 1) == '\n') {
                spannableStringBuilder.delete(spannableStringBuilder.length() - 1, spannableStringBuilder.length());
            }
            float f = ttmlRegion2.c;
            int i9 = ttmlRegion2.d;
            bVar.e = f;
            bVar.f = i9;
            bVar.g = ttmlRegion2.e;
            bVar.h = ttmlRegion2.f884b;
            bVar.l = ttmlRegion2.f;
            float f2 = ttmlRegion2.i;
            int i10 = ttmlRegion2.h;
            bVar.k = f2;
            bVar.j = i10;
            bVar.p = ttmlRegion2.j;
            arrayList2.add(bVar.a());
        }
        return arrayList2;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return this.k.length;
    }
}
