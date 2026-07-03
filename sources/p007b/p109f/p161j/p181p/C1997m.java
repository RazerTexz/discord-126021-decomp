package p007b.p109f.p161j.p181p;

import android.net.Uri;
import android.util.Base64;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import p007b.p085c.p086a.p087a0.C1460d;
import p007b.p109f.p115d.p117b.C1670a;
import p007b.p109f.p115d.p122g.InterfaceC1700g;
import p007b.p109f.p161j.p175j.C1919e;

/* JADX INFO: renamed from: b.f.j.p.m */
/* JADX INFO: compiled from: DataFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class C1997m extends AbstractC1981g0 {
    public C1997m(InterfaceC1700g interfaceC1700g) {
        super(C1670a.f3078j, interfaceC1700g);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: d */
    public C1919e mo1428d(ImageRequest imageRequest) throws IOException {
        boolean zEquals;
        byte[] bytes;
        String string = imageRequest.f19585c.toString();
        C1460d.m527i(Boolean.valueOf(string.substring(0, 5).equals("data:")));
        int iIndexOf = string.indexOf(44);
        String strSubstring = string.substring(iIndexOf + 1, string.length());
        String strSubstring2 = string.substring(0, iIndexOf);
        if (strSubstring2.contains(";")) {
            String[] strArrSplit = strSubstring2.split(";");
            zEquals = strArrSplit[strArrSplit.length - 1].equals("base64");
        } else {
            zEquals = false;
        }
        if (zEquals) {
            bytes = Base64.decode(strSubstring, 0);
        } else {
            String strDecode = Uri.decode(strSubstring);
            Objects.requireNonNull(strDecode);
            bytes = strDecode.getBytes();
        }
        return m1478c(new ByteArrayInputStream(bytes), bytes.length);
    }

    @Override // p007b.p109f.p161j.p181p.AbstractC1981g0
    /* JADX INFO: renamed from: e */
    public String mo1429e() {
        return "DataFetchProducer";
    }
}
