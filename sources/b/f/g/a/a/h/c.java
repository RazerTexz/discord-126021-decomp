package b.f.g.a.a.h;

/* JADX INFO: compiled from: ImageOriginRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class c extends b.f.j.k.a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f483b;

    public c(String str, b bVar) {
        this.f483b = bVar;
        this.a = str;
    }

    @Override // b.f.j.k.a, b.f.j.p.a1
    public void e(String str, String str2, boolean z2) {
        b bVar = this.f483b;
        if (bVar != null) {
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
            bVar.a(str3, i, z2, str2);
        }
    }
}
