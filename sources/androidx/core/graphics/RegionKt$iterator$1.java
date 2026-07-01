package androidx.core.graphics;

import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import d0.z.d.g0.a;
import java.util.Iterator;

/* JADX INFO: compiled from: Region.kt */
/* JADX INFO: loaded from: classes.dex */
public final class RegionKt$iterator$1 implements Iterator<Rect>, a {
    public final /* synthetic */ Region $this_iterator;
    private boolean hasMore;
    private final RegionIterator iterator;
    private final Rect rect;

    public RegionKt$iterator$1(Region region) {
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
    public /* bridge */ /* synthetic */ Rect next() {
        return next();
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
