package b.i.a.c.b3.v;

import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.b3.Cue;
import b.i.a.c.b3.Subtitle;
import b.i.a.c.f3.Util2;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.b3.v.k, reason: use source file name */
/* JADX INFO: compiled from: WebvttSubtitle.java */
/* JADX INFO: loaded from: classes3.dex */
public final class WebvttSubtitle implements Subtitle {
    public final List<WebvttCueInfo> j;
    public final long[] k;
    public final long[] l;

    public WebvttSubtitle(List<WebvttCueInfo> list) {
        this.j = Collections.unmodifiableList(new ArrayList(list));
        this.k = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            WebvttCueInfo webvttCueInfo = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.k;
            jArr[i2] = webvttCueInfo.f890b;
            jArr[i2 + 1] = webvttCueInfo.c;
        }
        long[] jArr2 = this.k;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.l = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    @Override // b.i.a.c.b3.Subtitle
    public int f(long j) {
        int iB = Util2.b(this.l, j, false, false);
        if (iB < this.l.length) {
            return iB;
        }
        return -1;
    }

    @Override // b.i.a.c.b3.Subtitle
    public long g(int i) {
        AnimatableValueParser.j(i >= 0);
        AnimatableValueParser.j(i < this.l.length);
        return this.l[i];
    }

    @Override // b.i.a.c.b3.Subtitle
    public List<Cue> h(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.j.size(); i++) {
            long[] jArr = this.k;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                WebvttCueInfo webvttCueInfo = this.j.get(i);
                Cue cue = webvttCueInfo.a;
                if (cue.p == -3.4028235E38f) {
                    arrayList2.add(webvttCueInfo);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: b.i.a.c.b3.v.b
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return Long.compare(((WebvttCueInfo) obj).f890b, ((WebvttCueInfo) obj2).f890b);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            Cue.b bVarA = ((WebvttCueInfo) arrayList2.get(i3)).a.a();
            bVarA.e = (-1) - i3;
            bVarA.f = 1;
            arrayList.add(bVarA.a());
        }
        return arrayList;
    }

    @Override // b.i.a.c.b3.Subtitle
    public int i() {
        return this.l.length;
    }
}
