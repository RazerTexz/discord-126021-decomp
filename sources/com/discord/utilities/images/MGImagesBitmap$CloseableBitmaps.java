package com.discord.utilities.images;

import android.graphics.Bitmap;
import d0.t.h0;
import d0.z.d.g0.a;
import d0.z.d.m;
import java.io.Closeable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map$Entry;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: MGImagesBitmap.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class MGImagesBitmap$CloseableBitmaps implements Map<String, Bitmap>, Closeable, a {
    private final boolean recycleBitmaps;
    private final Map<String, Bitmap> underlyingMap;

    public MGImagesBitmap$CloseableBitmaps(Map<String, Bitmap> map, boolean z2) {
        m.checkNotNullParameter(map, "underlyingMap");
        this.underlyingMap = map;
        this.recycleBitmaps = z2;
    }

    @Override // java.util.Map
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.recycleBitmaps) {
            Iterator<Map$Entry<String, Bitmap>> it = this.underlyingMap.entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().recycle();
            }
        }
    }

    /* JADX INFO: renamed from: compute, reason: avoid collision after fix types in other method */
    public Bitmap compute2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap compute(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfAbsent, reason: avoid collision after fix types in other method */
    public Bitmap computeIfAbsent2(String str, Function<? super String, ? extends Bitmap> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap computeIfAbsent(String str, Function<? super String, ? extends Bitmap> function) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: computeIfPresent, reason: avoid collision after fix types in other method */
    public Bitmap computeIfPresent2(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap computeIfPresent(String str, BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsKey(Object obj) {
        if (obj instanceof String) {
            return containsKey((String) obj);
        }
        return false;
    }

    public boolean containsKey(String key) {
        m.checkNotNullParameter(key, "key");
        return this.underlyingMap.containsKey(key);
    }

    public boolean containsValue(Bitmap value) {
        m.checkNotNullParameter(value, "value");
        return this.underlyingMap.containsValue(value);
    }

    @Override // java.util.Map
    public final /* bridge */ boolean containsValue(Object obj) {
        if (obj instanceof Bitmap) {
            return containsValue((Bitmap) obj);
        }
        return false;
    }

    @Override // java.util.Map
    public final /* bridge */ Set<Map$Entry<String, Bitmap>> entrySet() {
        return getEntries();
    }

    public Bitmap get(String key) {
        m.checkNotNullParameter(key, "key");
        return this.underlyingMap.get(key);
    }

    @Override // java.util.Map
    public final /* bridge */ Bitmap get(Object obj) {
        if (obj instanceof String) {
            return get((String) obj);
        }
        return null;
    }

    public Set<Map$Entry<String, Bitmap>> getEntries() {
        return this.underlyingMap.entrySet();
    }

    public Set<String> getKeys() {
        return this.underlyingMap.keySet();
    }

    public int getSize() {
        return this.underlyingMap.size();
    }

    public Collection<Bitmap> getValues() {
        return this.underlyingMap.values();
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return this.underlyingMap.isEmpty();
    }

    @Override // java.util.Map
    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    /* JADX INFO: renamed from: merge, reason: avoid collision after fix types in other method */
    public Bitmap merge2(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap merge(String str, Bitmap bitmap, BiFunction<? super Bitmap, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final MGImagesBitmap$CloseableBitmaps plus(MGImagesBitmap$CloseableBitmaps other) {
        m.checkNotNullParameter(other, "other");
        return new MGImagesBitmap$CloseableBitmaps(h0.plus(this.underlyingMap, other.underlyingMap), this.recycleBitmaps && other.recycleBitmaps);
    }

    /* JADX INFO: renamed from: put, reason: avoid collision after fix types in other method */
    public Bitmap put2(String str, Bitmap bitmap) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap put(String str, Bitmap bitmap) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void putAll(Map<? extends String, ? extends Bitmap> map) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: putIfAbsent, reason: avoid collision after fix types in other method */
    public Bitmap putIfAbsent2(String str, Bitmap bitmap) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap putIfAbsent(String str, Bitmap bitmap) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public Bitmap remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public Bitmap replace2(String str, Bitmap bitmap) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ Bitmap replace(String str, Bitmap bitmap) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public /* synthetic */ boolean replace(String str, Bitmap bitmap, Bitmap bitmap2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    /* JADX INFO: renamed from: replace, reason: avoid collision after fix types in other method */
    public boolean replace2(String str, Bitmap bitmap, Bitmap bitmap2) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public void replaceAll(BiFunction<? super String, ? super Bitmap, ? extends Bitmap> biFunction) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.Map
    public final /* bridge */ int size() {
        return getSize();
    }

    @Override // java.util.Map
    public final /* bridge */ Collection<Bitmap> values() {
        return getValues();
    }

    public /* synthetic */ MGImagesBitmap$CloseableBitmaps(Map map, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(map, (i & 2) != 0 ? true : z2);
    }
}
