package p007b.p452o.p453a.p465p;

import android.media.Image;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

/* JADX INFO: renamed from: b.o.a.p.e */
/* JADX INFO: compiled from: ImageFrameManager.java */
/* JADX INFO: loaded from: classes3.dex */
@RequiresApi(19)
public class C5192e extends AbstractC5190c<Image> {
    public C5192e(int i) {
        super(i, Image.class);
    }

    @Override // p007b.p452o.p453a.p465p.AbstractC5190c
    /* JADX INFO: renamed from: c */
    public void mo7380c(@NonNull Image image, boolean z2) {
        try {
            image.close();
        } catch (Exception unused) {
        }
    }
}
