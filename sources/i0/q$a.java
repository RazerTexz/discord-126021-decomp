package i0;

import java.io.IOException;
import java.util.Optional;
import okhttp3.ResponseBody;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: OptionalConverterFactory.java */
/* JADX INFO: loaded from: classes3.dex */
@IgnoreJRERequirement
public final class q$a<T> implements h<ResponseBody, Optional<T>> {
    public final h<ResponseBody, T> a;

    public q$a(h<ResponseBody, T> hVar) {
        this.a = hVar;
    }

    @Override // i0.h
    public Object convert(ResponseBody responseBody) throws IOException {
        return Optional.ofNullable(this.a.convert(responseBody));
    }
}
