package b.f.j.p;

import android.net.Uri;
import android.util.Base64;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: compiled from: DataFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class m extends g0 {
    public m(b.f.d.g.g gVar) {
        super(b.f.d.b.a.j, gVar);
    }

    @Override // b.f.j.p.g0
    public b.f.j.j.e d(ImageRequest imageRequest) throws IOException {
        boolean zEquals;
        byte[] bytes;
        String string = imageRequest.c.toString();
        b.c.a.a0.d.i(Boolean.valueOf(string.substring(0, 5).equals("data:")));
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
        return c(new ByteArrayInputStream(bytes), bytes.length);
    }

    @Override // b.f.j.p.g0
    public String e() {
        return "DataFetchProducer";
    }
}
