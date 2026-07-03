package p007b.p109f.p132g.p133a.p134a.p136h;

import p007b.p109f.p161j.p176k.C1924a;

/* JADX INFO: renamed from: b.f.g.a.a.h.c */
/* JADX INFO: compiled from: ImageOriginRequestListener.java */
/* JADX INFO: loaded from: classes.dex */
public class C1740c extends C1924a {

    /* JADX INFO: renamed from: a */
    public String f3200a;

    /* JADX INFO: renamed from: b */
    public final InterfaceC1739b f3201b;

    public C1740c(String str, InterfaceC1739b interfaceC1739b) {
        this.f3201b = interfaceC1739b;
        this.f3200a = str;
    }

    @Override // p007b.p109f.p161j.p176k.C1924a, p007b.p109f.p161j.p181p.InterfaceC1964a1
    /* JADX INFO: renamed from: e */
    public void mo1062e(String str, String str2, boolean z2) {
        InterfaceC1739b interfaceC1739b = this.f3201b;
        if (interfaceC1739b != null) {
            String str3 = this.f3200a;
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
            interfaceC1739b.mo1061a(str3, i, z2, str2);
        }
    }
}
