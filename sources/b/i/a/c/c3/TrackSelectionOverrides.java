package b.i.a.c.c3;

import android.os.Bundle;
import androidx.annotation.Nullable;
import b.i.a.c.Bundleable;
import b.i.a.c.Format2;
import b.i.a.c.a3.TrackGroup;
import b.i.a.c.c3.TrackSelectionOverrides;
import b.i.a.c.f3.BundleableUtil;
import b.i.b.b.AbstractIndexedListIterator;
import b.i.b.b.ImmutableCollection;
import b.i.b.b.ImmutableList2;
import b.i.b.b.ImmutableMap2;
import b.i.b.b.RegularImmutableList;
import b.i.b.b.RegularImmutableMap;
import b.i.b.c.Ints;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.c3.o, reason: use source file name */
/* JADX INFO: compiled from: TrackSelectionOverrides.java */
/* JADX INFO: loaded from: classes3.dex */
public final class TrackSelectionOverrides implements Bundleable {
    public static final TrackSelectionOverrides j = new TrackSelectionOverrides(RegularImmutableMap.m);
    public static final Bundleable.a<TrackSelectionOverrides> k = new Bundleable.a() { // from class: b.i.a.c.c3.d
        @Override // b.i.a.c.Bundleable.a
        public final Bundleable a(Bundle bundle) {
            TrackSelectionOverrides trackSelectionOverrides = TrackSelectionOverrides.j;
            int i = TrackSelectionOverrides.a.j;
            e eVar = new Bundleable.a() { // from class: b.i.a.c.c3.e
                @Override // b.i.a.c.Bundleable.a
                public final Bundleable a(Bundle bundle2) {
                    int i2 = TrackSelectionOverrides.a.j;
                    Bundle bundle3 = bundle2.getBundle(Integer.toString(0, 36));
                    Objects.requireNonNull(bundle3);
                    int i3 = TrackGroup.j;
                    Bundleable.a<Format2> aVar = Format2.k;
                    ArrayList parcelableArrayList = bundle3.getParcelableArrayList(Integer.toString(0, 36));
                    AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
                    TrackGroup trackGroup = new TrackGroup((Format2[]) BundleableUtil.b(aVar, parcelableArrayList, RegularImmutableList.l).toArray(new Format2[0]));
                    int[] intArray = bundle2.getIntArray(Integer.toString(1, 36));
                    if (intArray == null) {
                        return new TrackSelectionOverrides.a(trackGroup);
                    }
                    return new TrackSelectionOverrides.a(trackGroup, intArray.length == 0 ? Collections.emptyList() : new Ints(intArray));
                }
            };
            ArrayList parcelableArrayList = bundle.getParcelableArrayList(Integer.toString(0, 36));
            AbstractIndexedListIterator<Object> abstractIndexedListIterator = ImmutableList2.k;
            List listB = BundleableUtil.b(eVar, parcelableArrayList, RegularImmutableList.l);
            ImmutableMap2.a aVar = new ImmutableMap2.a(4);
            for (int i2 = 0; i2 < listB.size(); i2++) {
                TrackSelectionOverrides.a aVar2 = (TrackSelectionOverrides.a) listB.get(i2);
                aVar.c(aVar2.k, aVar2);
            }
            return new TrackSelectionOverrides(aVar.a());
        }
    };
    public final ImmutableMap2<TrackGroup, a> l;

    public TrackSelectionOverrides(Map<TrackGroup, a> map) {
        this.l = ImmutableMap2.a(map);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TrackSelectionOverrides.class != obj.getClass()) {
            return false;
        }
        return this.l.equals(((TrackSelectionOverrides) obj).l);
    }

    public int hashCode() {
        return this.l.hashCode();
    }

    /* JADX INFO: renamed from: b.i.a.c.c3.o$a */
    /* JADX INFO: compiled from: TrackSelectionOverrides.java */
    public static final class a implements Bundleable {
        public static final /* synthetic */ int j = 0;
        public final TrackGroup k;
        public final ImmutableList2<Integer> l;

        public a(TrackGroup trackGroup) {
            this.k = trackGroup;
            b.i.a.f.e.o.f.A(4, "initialCapacity");
            Object[] objArrCopyOf = new Object[4];
            int i = 0;
            int i2 = 0;
            while (i < trackGroup.k) {
                Integer numValueOf = Integer.valueOf(i);
                Objects.requireNonNull(numValueOf);
                int i3 = i2 + 1;
                if (objArrCopyOf.length < i3) {
                    objArrCopyOf = Arrays.copyOf(objArrCopyOf, ImmutableCollection.b.a(objArrCopyOf.length, i3));
                }
                objArrCopyOf[i2] = numValueOf;
                i++;
                i2 = i3;
            }
            this.l = ImmutableList2.l(objArrCopyOf, i2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.k.equals(aVar.k) && this.l.equals(aVar.l);
        }

        public int hashCode() {
            return (this.l.hashCode() * 31) + this.k.hashCode();
        }

        public a(TrackGroup trackGroup, List<Integer> list) {
            if (!list.isEmpty() && (((Integer) Collections.min(list)).intValue() < 0 || ((Integer) Collections.max(list)).intValue() >= trackGroup.k)) {
                throw new IndexOutOfBoundsException();
            }
            this.k = trackGroup;
            this.l = ImmutableList2.n(list);
        }
    }
}
