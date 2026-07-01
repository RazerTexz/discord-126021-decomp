package b.f.g.a.a.h;

import b.f.j.k.BaseRequestListener;

/* JADX INFO: renamed from: b.f.g.a.a.h.c, reason: use source file name */
/* JADX INFO: compiled from: ImageOriginRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class ImageOriginRequestListener extends BaseRequestListener {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ImageOriginListener f483b;

    public ImageOriginRequestListener(String str, ImageOriginListener imageOriginListener) {
        this.f483b = imageOriginListener;
        this.a = str;
    }

    @Override // b.f.j.k.BaseRequestListener, b.f.j.p.ProducerListener
    public void e(String str, String str2, boolean z2) {
        ImageOriginListener imageOriginListener = this.f483b;
        if (imageOriginListener != null) {
            String str3 = this.a;
            str2.hashCode();
            int i = 1;
            switch (str2) {
                case "QualifiedResourceFetchProducer":
                case "LocalResourceFetchProducer":
                case "LocalFileFetchProducer":
                case "VideoThumbnailProducer":
                case "LocalAssetFetchProducer":
                case "DataFetchProducer":
                case "LocalContentUriThumbnailFetchProducer":
                case "LocalContentUriFetchProducer":
                    i = 7;
                    break;
                case "BitmapMemoryCacheGetProducer":
                case "BitmapMemoryCacheProducer":
                case "PostprocessedBitmapMemoryCacheProducer":
                    i = 5;
                    break;
                case "EncodedMemoryCacheProducer":
                    i = 4;
                    break;
                case "NetworkFetchProducer":
                    i = 2;
                    break;
                case "DiskCacheProducer":
                case "PartialDiskCacheProducer":
                    i = 3;
                    break;
            }
            imageOriginListener.a(str3, i, z2, str2);
        }
    }
}
