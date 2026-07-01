package androidx.core.graphics;

import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region$Op;
import android.graphics.RegionIterator;
import d0.z.d.m;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: Region.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RegionKt {
    public static final Region and(Region region, Rect rect) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region$Op.INTERSECT);
        return region2;
    }

    public static final boolean contains(Region region, Point point) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(point, "p");
        return region.contains(point.x, point.y);
    }

    public static final void forEach(Region region, Function1<? super Rect, Unit> function1) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(function1, "action");
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
        m.checkNotNullParameter(region, "<this>");
        return new RegionKt$iterator$1(region);
    }

    public static final Region minus(Region region, Rect rect) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region$Op.DIFFERENCE);
        return region2;
    }

    public static final Region not(Region region) {
        m.checkNotNullParameter(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region$Op.DIFFERENCE);
        return region2;
    }

    public static final Region or(Region region, Rect rect) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region plus(Region region, Rect rect) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.union(rect);
        return region2;
    }

    public static final Region unaryMinus(Region region) {
        m.checkNotNullParameter(region, "<this>");
        Region region2 = new Region(region.getBounds());
        region2.op(region, Region$Op.DIFFERENCE);
        return region2;
    }

    public static final Region xor(Region region, Rect rect) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(rect, "r");
        Region region2 = new Region(region);
        region2.op(rect, Region$Op.XOR);
        return region2;
    }

    public static final Region and(Region region, Region region2) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region$Op.INTERSECT);
        return region3;
    }

    public static final Region minus(Region region, Region region2) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region$Op.DIFFERENCE);
        return region3;
    }

    public static final Region or(Region region, Region region2) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region$Op.UNION);
        return region3;
    }

    public static final Region plus(Region region, Region region2) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region$Op.UNION);
        return region3;
    }

    public static final Region xor(Region region, Region region2) {
        m.checkNotNullParameter(region, "<this>");
        m.checkNotNullParameter(region2, "r");
        Region region3 = new Region(region);
        region3.op(region2, Region$Op.XOR);
        return region3;
    }
}
