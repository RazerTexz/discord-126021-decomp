package b.i.a.c.a3;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.d.b.a.outline;
import b.i.a.c.Bundleable;
import b.i.a.c.Format2;
import b.i.a.c.f3.Log2;
import java.util.Arrays;

/* JADX INFO: renamed from: b.i.a.c.a3.n0, reason: use source file name */
/* JADX INFO: compiled from: TrackGroup.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackGroup implements Bundleable {
    public static final /* synthetic */ int j = 0;
    public final int k;
    public final Format2[] l;
    public int m;

    public TrackGroup(Format2... format2Arr) {
        int i = 1;
        AnimatableValueParser.j(format2Arr.length > 0);
        this.l = format2Arr;
        this.k = format2Arr.length;
        String str = format2Arr[0].n;
        str = (str == null || str.equals("und")) ? "" : str;
        int i2 = format2Arr[0].p | 16384;
        while (true) {
            Format2[] format2Arr2 = this.l;
            if (i >= format2Arr2.length) {
                return;
            }
            String str2 = format2Arr2[i].n;
            if (!str.equals((str2 == null || str2.equals("und")) ? "" : str2)) {
                Format2[] format2Arr3 = this.l;
                a("languages", format2Arr3[0].n, format2Arr3[i].n, i);
                return;
            } else {
                Format2[] format2Arr4 = this.l;
                if (i2 != (format2Arr4[i].p | 16384)) {
                    a("role flags", Integer.toBinaryString(format2Arr4[0].p), Integer.toBinaryString(this.l[i].p), i);
                    return;
                }
                i++;
            }
        }
    }

    public static void a(String str, @Nullable String str2, @Nullable String str3, int i) {
        StringBuilder sbS = outline.S(outline.b(str3, outline.b(str2, str.length() + 78)), "Different ", str, " combined in one TrackGroup: '", str2);
        sbS.append("' (track 0) and '");
        sbS.append(str3);
        sbS.append("' (track ");
        sbS.append(i);
        sbS.append(")");
        Log2.b("TrackGroup", "", new IllegalStateException(sbS.toString()));
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackGroup.class != obj.getClass()) {
            return false;
        }
        TrackGroup trackGroup = (TrackGroup) obj;
        return this.k == trackGroup.k && Arrays.equals(this.l, trackGroup.l);
    }

    public int hashCode() {
        if (this.m == 0) {
            this.m = 527 + Arrays.hashCode(this.l);
        }
        return this.m;
    }
}
