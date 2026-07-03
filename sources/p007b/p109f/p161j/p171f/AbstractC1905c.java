package p007b.p109f.p161j.p171f;

import android.graphics.Bitmap;
import com.facebook.common.references.CloseableReference;
import com.facebook.datasource.DataSource;
import p007b.p109f.p129e.AbstractC1724d;
import p007b.p109f.p161j.p175j.AbstractC1916b;
import p007b.p109f.p161j.p175j.AbstractC1917c;

/* JADX INFO: renamed from: b.f.j.f.c */
/* JADX INFO: compiled from: BaseBitmapDataSubscriber.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1905c extends AbstractC1724d<CloseableReference<AbstractC1917c>> {
    public abstract void onNewResultImpl(Bitmap bitmap);

    @Override // p007b.p109f.p129e.AbstractC1724d
    public void onNewResultImpl(DataSource<CloseableReference<AbstractC1917c>> dataSource) {
        if (dataSource.mo1019c()) {
            CloseableReference<AbstractC1917c> result = dataSource.getResult();
            Bitmap bitmapMo1332f = null;
            if (result != null && (result.m8642u() instanceof AbstractC1916b)) {
                bitmapMo1332f = ((AbstractC1916b) result.m8642u()).mo1332f();
            }
            try {
                onNewResultImpl(bitmapMo1332f);
            } finally {
                Class<CloseableReference> cls = CloseableReference.f19438j;
                if (result != null) {
                    result.close();
                }
            }
        }
    }
}
