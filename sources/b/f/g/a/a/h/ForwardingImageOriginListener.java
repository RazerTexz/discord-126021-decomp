package b.f.g.a.a.h;

import b.f.d.e.FLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: renamed from: b.f.g.a.a.h.a, reason: use source file name */
/* JADX INFO: compiled from: ForwardingImageOriginListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ForwardingImageOriginListener implements ImageOriginListener {
    public final List<ImageOriginListener> a;

    public ForwardingImageOriginListener(ImageOriginListener... imageOriginListenerArr) {
        ArrayList arrayList = new ArrayList(imageOriginListenerArr.length);
        this.a = arrayList;
        Collections.addAll(arrayList, imageOriginListenerArr);
    }

    @Override // b.f.g.a.a.h.ImageOriginListener
    public synchronized void a(String str, int i, boolean z2, String str2) {
        int size = this.a.size();
        for (int i2 = 0; i2 < size; i2++) {
            ImageOriginListener imageOriginListener = this.a.get(i2);
            if (imageOriginListener != null) {
                try {
                    imageOriginListener.a(str, i, z2, str2);
                } catch (Exception e) {
                    FLog.f("ForwardingImageOriginListener", "InternalListener exception in onImageLoaded", e);
                }
            }
        }
    }
}
