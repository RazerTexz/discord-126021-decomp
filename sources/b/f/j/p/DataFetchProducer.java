package b.f.j.p;

import android.net.Uri;
import android.util.Base64;
import b.c.a.a0.AnimatableValueParser;
import b.f.d.b.CallerThreadExecutor;
import b.f.d.g.PooledByteBufferFactory;
import b.f.j.j.EncodedImage2;
import com.facebook.imagepipeline.request.ImageRequest;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;

/* JADX INFO: renamed from: b.f.j.p.m, reason: use source file name */
/* JADX INFO: compiled from: DataFetchProducer.java */
/* JADX INFO: loaded from: classes3.dex */
public class DataFetchProducer extends LocalFetchProducer {
    public DataFetchProducer(PooledByteBufferFactory pooledByteBufferFactory) {
        super(CallerThreadExecutor.j, pooledByteBufferFactory);
    }

    @Override // b.f.j.p.LocalFetchProducer
    public EncodedImage2 d(ImageRequest imageRequest) throws IOException {
        boolean zEquals;
        byte[] bytes;
        String string = imageRequest.c.toString();
        AnimatableValueParser.i(Boolean.valueOf(string.substring(0, 5).equals("data:")));
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

    @Override // b.f.j.p.LocalFetchProducer
    public String e() {
        return "DataFetchProducer";
    }
}
