package b.b.a.d;

import android.content.ContentResolver;
import android.provider.MediaStore$Images$Thumbnails;
import android.util.Log;
import com.lytefast.flexinput.model.Media;

/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class l implements Runnable {
    public final /* synthetic */ m j;
    public final /* synthetic */ ContentResolver k;

    public l(m mVar, ContentResolver contentResolver) {
        this.j = mVar;
        this.k = contentResolver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaStore$Images$Thumbnails.getThumbnail(this.k, this.j.$id, 1, null);
        } catch (Exception unused) {
            String name = Media.class.getName();
            StringBuilder sbU = b.d.b.a.a.U("Error generating thumbnail for photo ");
            sbU.append(this.j.$id);
            sbU.append('.');
            Log.v(name, sbU.toString());
        }
    }
}
