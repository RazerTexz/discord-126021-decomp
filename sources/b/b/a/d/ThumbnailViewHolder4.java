package b.b.a.d;

import android.content.ContentResolver;
import android.provider.MediaStore;
import android.util.Log;
import b.d.b.a.outline;
import com.lytefast.flexinput.model.Media;

/* JADX INFO: renamed from: b.b.a.d.l, reason: use source file name */
/* JADX INFO: compiled from: ThumbnailViewHolder.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class ThumbnailViewHolder4 implements Runnable {
    public final /* synthetic */ ThumbnailViewHolder5 j;
    public final /* synthetic */ ContentResolver k;

    public ThumbnailViewHolder4(ThumbnailViewHolder5 thumbnailViewHolder5, ContentResolver contentResolver) {
        this.j = thumbnailViewHolder5;
        this.k = contentResolver;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MediaStore.Images.Thumbnails.getThumbnail(this.k, this.j.$id, 1, null);
        } catch (Exception unused) {
            String name = Media.class.getName();
            StringBuilder sbU = outline.U("Error generating thumbnail for photo ");
            sbU.append(this.j.$id);
            sbU.append('.');
            Log.v(name, sbU.toString());
        }
    }
}
