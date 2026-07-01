package b.f.j.l;

import android.graphics.Bitmap;
import b.f.d.e.FLog;
import b.f.j.l.BucketMap;
import b.f.k.BitmapUtil;

/* JADX INFO: renamed from: b.f.j.l.e, reason: use source file name */
/* JADX INFO: compiled from: BitmapPoolBackend.java */
/* JADX INFO: loaded from: classes3.dex */
public class BitmapPoolBackend extends LruBucketsPoolBackend<Bitmap> {
    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // b.f.j.l.LruBucketsPoolBackend
    public Bitmap a(int i) {
        Object objPollFirst;
        BucketMap<T> bucketMap = this.f598b;
        synchronized (bucketMap) {
            BucketMap.b bVar = (BucketMap.b) bucketMap.a.get(i);
            if (bVar == null) {
                objPollFirst = null;
            } else {
                objPollFirst = bVar.c.pollFirst();
                bucketMap.a((BucketMap.b<T>) bVar);
            }
        }
        if (objPollFirst != null) {
            synchronized (this) {
                this.a.remove(objPollFirst);
            }
        }
        Bitmap bitmap = (Bitmap) objPollFirst;
        if (bitmap == null || !d(bitmap)) {
            return null;
        }
        bitmap.eraseColor(0);
        return bitmap;
    }

    @Override // b.f.j.l.LruBucketsPoolBackend
    public int b(Bitmap bitmap) {
        return BitmapUtil.d(bitmap);
    }

    public boolean d(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        if (bitmap.isRecycled()) {
            FLog.p("BitmapPoolBackend", "Cannot reuse a recycled bitmap: %s", bitmap);
            return false;
        }
        if (bitmap.isMutable()) {
            return true;
        }
        FLog.p("BitmapPoolBackend", "Cannot reuse an immutable bitmap: %s", bitmap);
        return false;
    }
}
