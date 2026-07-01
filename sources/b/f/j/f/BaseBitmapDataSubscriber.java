package b.f.j.f;

import android.graphics.Bitmap;
import b.f.e.BaseDataSubscriber;
import b.f.j.j.CloseableBitmap;
import b.f.j.j.CloseableImage;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;

/* JADX INFO: renamed from: b.f.j.f.c, reason: use source file name */
/* JADX INFO: compiled from: BaseBitmapDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class BaseBitmapDataSubscriber extends BaseDataSubscriber<CloseableReference<CloseableImage>> {
    public abstract void onNewResultImpl(Bitmap bitmap);

    @Override // b.f.e.BaseDataSubscriber
    public void onNewResultImpl(DataSource<CloseableReference<CloseableImage>> dataSource) {
        if (dataSource.c()) {
            CloseableReference<CloseableImage> result = dataSource.getResult();
            Bitmap bitmapF = null;
            if (result != null && (result.u() instanceof CloseableBitmap)) {
                bitmapF = ((CloseableBitmap) result.u()).f();
            }
            try {
                onNewResultImpl(bitmapF);
            } finally {
                Class<CloseableReference> cls = CloseableReference.j;
                if (result != null) {
                    result.close();
                }
            }
        }
    }
}
