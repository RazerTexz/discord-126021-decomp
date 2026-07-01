package b.f.j.c;

import b.c.a.a0.AnimatableValueParser;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.time.RealtimeSinceBootClock;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.c.b, reason: use source file name */
/* JADX INFO: compiled from: BitmapMemoryCacheKey.java */
/* JADX INFO: loaded from: classes.dex */
public class BitmapMemoryCacheKey implements CacheKey {
    public final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ResizeOptions f553b;
    public final RotationOptions c;
    public final ImageDecodeOptions d;
    public final CacheKey e;
    public final String f;
    public final int g;
    public final Object h;

    public BitmapMemoryCacheKey(String str, ResizeOptions resizeOptions, RotationOptions rotationOptions, ImageDecodeOptions imageDecodeOptions, CacheKey cacheKey, String str2, Object obj) {
        Objects.requireNonNull(str);
        this.a = str;
        this.f553b = resizeOptions;
        this.c = rotationOptions;
        this.d = imageDecodeOptions;
        this.e = cacheKey;
        this.f = str2;
        Integer numValueOf = Integer.valueOf(str.hashCode());
        Integer numValueOf2 = Integer.valueOf(resizeOptions != null ? resizeOptions.hashCode() : 0);
        Integer numValueOf3 = Integer.valueOf(rotationOptions.hashCode());
        int iHashCode = numValueOf == null ? 0 : numValueOf.hashCode();
        int iHashCode2 = numValueOf2 == null ? 0 : numValueOf2.hashCode();
        int iHashCode3 = numValueOf3 == null ? 0 : numValueOf3.hashCode();
        int iHashCode4 = imageDecodeOptions == null ? 0 : imageDecodeOptions.hashCode();
        this.g = ((((((((((iHashCode + 31) * 31) + iHashCode2) * 31) + iHashCode3) * 31) + iHashCode4) * 31) + (cacheKey == null ? 0 : cacheKey.hashCode())) * 31) + (str2 != null ? str2.hashCode() : 0);
        this.h = obj;
        RealtimeSinceBootClock.get().now();
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean a() {
        return false;
    }

    @Override // com.facebook.cache.common.CacheKey
    public String b() {
        return this.a;
    }

    @Override // com.facebook.cache.common.CacheKey
    public boolean equals(Object obj) {
        if (!(obj instanceof BitmapMemoryCacheKey)) {
            return false;
        }
        BitmapMemoryCacheKey bitmapMemoryCacheKey = (BitmapMemoryCacheKey) obj;
        return this.g == bitmapMemoryCacheKey.g && this.a.equals(bitmapMemoryCacheKey.a) && AnimatableValueParser.g0(this.f553b, bitmapMemoryCacheKey.f553b) && AnimatableValueParser.g0(this.c, bitmapMemoryCacheKey.c) && AnimatableValueParser.g0(this.d, bitmapMemoryCacheKey.d) && AnimatableValueParser.g0(this.e, bitmapMemoryCacheKey.e) && AnimatableValueParser.g0(this.f, bitmapMemoryCacheKey.f);
    }

    @Override // com.facebook.cache.common.CacheKey
    public int hashCode() {
        return this.g;
    }

    public String toString() {
        return String.format(null, "%s_%s_%s_%s_%s_%s_%d", this.a, this.f553b, this.c, this.d, this.e, this.f, Integer.valueOf(this.g));
    }
}
