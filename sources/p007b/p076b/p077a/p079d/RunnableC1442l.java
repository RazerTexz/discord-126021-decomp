package p007b.p076b.p077a.p079d;

import android.content.ContentResolver;
import android.provider.MediaStore;
import android.util.Log;
import com.lytefast.flexinput.model.Media;
import p007b.p100d.p104b.p105a.C1643a;

/* JADX INFO: renamed from: b.b.a.d.l */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class RunnableC1442l implements Runnable {

    /* JADX INFO: renamed from: j */
    public final /* synthetic */ C1443m f2170j;

    /* JADX INFO: renamed from: k */
    public final /* synthetic */ ContentResolver f2171k;

    public RunnableC1442l(C1443m c1443m, ContentResolver contentResolver) {
        this.f2170j = c1443m;
        this.f2171k = contentResolver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaStore.Images.Thumbnails.getThumbnail(this.f2171k, this.f2170j.$id, 1, null);
        } catch (Exception unused) {
            String name = Media.class.getName();
            StringBuilder sbM833U = C1643a.m833U("Error generating thumbnail for photo ");
            sbM833U.append(this.f2170j.$id);
            sbM833U.append('.');
            Log.v(name, sbM833U.toString());
        }
    }
}
