package b.f.j.f;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;

/* JADX INFO: compiled from: BaseBitmapDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class c extends b.f.e.d<CloseableReference<b.f.j.j.c>> {
    public abstract void onNewResultImpl(Bitmap bitmap);

    @Override // b.f.e.d
    public void onNewResultImpl(DataSource<CloseableReference<b.f.j.j.c>> dataSource) {
        if (dataSource.c()) {
            CloseableReference<b.f.j.j.c> result = dataSource.getResult();
            Bitmap bitmapF = null;
            if (result != null && (result.u() instanceof b.f.j.j.b)) {
                bitmapF = ((b.f.j.j.b) result.u()).f();
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
