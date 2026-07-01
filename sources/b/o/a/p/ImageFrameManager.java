package b.o.a.p;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.p.e, reason: use source file name */
/* JADX INFO: compiled from: ImageFrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(19)
public class ImageFrameManager extends FrameManager<Image> {
    public ImageFrameManager(int i) {
        super(i, Image.class);
    }

    @Override // b.o.a.p.FrameManager
    public void c(@NonNull Image image, boolean z2) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
