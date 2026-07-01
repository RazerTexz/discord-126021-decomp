package b.i.a.c;

import androidx.annotation.Nullable;
import b.c.a.a0.AnimatableValueParser;
import b.i.a.c.a3.TrackGroup;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableList2;
import b.i.b.b.RegularImmutableList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: renamed from: b.i.a.c.p2, reason: use source file name */
/* JADX INFO: compiled from: TracksInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TracksInfo implements Bundleable {
    public static final TracksInfo j;
    public final ImmutableList2<a> k;

    /* JADX INFO: renamed from: b.i.a.c.p2$a */
    /* JADX INFO: compiled from: TracksInfo.java */
    public static final class a implements Bundleable {
        public final TrackGroup j;
        public final int[] k;
        public final int l;
        public final boolean[] m;

        public a(TrackGroup trackGroup, int[] iArr, int i, boolean[] zArr) {
            int i2 = trackGroup.k;
            AnimatableValueParser.j(i2 == iArr.length && i2 == zArr.length);
            this.j = trackGroup;
            this.k = (int[]) iArr.clone();
            this.l = i;
            this.m = (boolean[]) zArr.clone();
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.l == aVar.l && this.j.equals(aVar.j) && Arrays.equals(this.k, aVar.k) && Arrays.equals(this.m, aVar.m);
        }

        public int hashCode() {
            return Arrays.hashCode(this.m) + ((((Arrays.hashCode(this.k) + (this.j.hashCode() * 31)) * 31) + this.l) * 31);
        }
    }

    static {
        AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
        j = new TracksInfo(RegularImmutableList.l);
    }

    public TracksInfo(List<a> list) {
        this.k = ImmutableList2.n(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TracksInfo.class != obj.getClass()) {
            return false;
        }
        return this.k.equals(((TracksInfo) obj).k);
    }

    public int hashCode() {
        return this.k.hashCode();
    }
}
