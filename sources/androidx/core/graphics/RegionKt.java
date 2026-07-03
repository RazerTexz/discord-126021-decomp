package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import p507d0.p592z.p594d.C12238m;
import p507d0.p592z.p594d.p595g0.InterfaceC12228a;

/* JADX INFO: compiled from: Region.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RegionKt {

    /* JADX INFO: renamed from: androidx.core.graphics.RegionKt$iterator$1 */
    /* JADX INFO: compiled from: Region.kt */
    public static final class C02261 implements Iterator<Rect>, InterfaceC12228a {
        public final /* synthetic */ Region $this_iterator;
        private boolean hasMore;
        private final RegionIterator iterator;
        private final Rect rect;

        public C02261(Region region) {
            this.$this_iterator = region;
            RegionIterator regionIterator = new RegionIterator(region);
            this.iterator = regionIterator;
            Rect rect = new Rect();
            this.rect = rect;
            this.hasMore = regionIterator.next(rect);
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.hasMore;
        }

        @Override // java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.Iterator
        public Rect next() {
            if (!this.hasMore) {
                throw new IndexOutOfBoundsException();
            }
            Rect rect = new Rect(this.rect);
            this.hasMore = this.iterator.next(this.rect);
            return rect;
        }
    }

    public static final Region and(Region region, Rect rect) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(Region region, Point point) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(point, "p");
        return region.contains(point.x, point.y);
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> function1) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(function1, "action");
        RegionIterator regionIterator = new RegionIterator(region);
        while (true) {
            Rect rect = new Rect();
            if (!regionIterator.next(rect)) {
                return;
            } else {
                function1.invoke(rect);
            }
        }
    }

    public static final Iterator<Rect> iterator(Region region) {
        C12238m.checkNotNullParameter(region, "<this>");
        return new C02261(region);
    }

    public static final Region minus(Region region, Rect rect) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region not(Region region) {
        C12238m.checkNotNullParameter(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    /* JADX INFO: renamed from: or */
    public static final Region m87or(Region region, Rect rect) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region plus(Region region, Rect rect) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        C12238m.checkNotNullParameter(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region.Op.DIFFERENCE);
        return region2;
    }

    public static final Region xor(Region region, Rect rect) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region.Op.XOR);
        return region2;
    }

    public static final Region and(Region region, Region region2) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.INTERSECT);
        return region3;
    }

    public static final Region minus(Region region, Region region2) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.DIFFERENCE);
        return region3;
    }

    /* JADX INFO: renamed from: or */
    public static final Region m88or(Region region, Region region2) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region plus(Region region, Region region2) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.UNION);
        return region3;
    }

    public static final Region xor(Region region, Region region2) {
        C12238m.checkNotNullParameter(region, "<this>");
        C12238m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region.Op.XOR);
        return region3;
    }
}
