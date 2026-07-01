package okhttp3;

import d0.z.d.m;
import f0.e0.c;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import okio.ByteString;

/* JADX INFO: compiled from: MultipartBody.kt */
/* JADX INFO: loaded from: classes3.dex */
public final class MultipartBody$a {
    public final ByteString a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public MediaType f3811b;
    public final List<MultipartBody$Part> c;

    public MultipartBody$a() {
        String string = UUID.randomUUID().toString();
        m.checkExpressionValueIsNotNull(string, "UUID.randomUUID().toString()");
        m.checkParameterIsNotNull(string, "boundary");
        this.a = ByteString.k.c(string);
        this.f3811b = MultipartBody.a;
        this.c = new ArrayList();
    }

    public final MultipartBody$a a(MultipartBody$Part multipartBody$Part) {
        m.checkParameterIsNotNull(multipartBody$Part, "part");
        this.c.add(multipartBody$Part);
        return this;
    }

    public final MultipartBody b() {
        if (!this.c.isEmpty()) {
            return new MultipartBody(this.a, this.f3811b, c.z(this.c));
        }
        throw new IllegalStateException("Multipart body must have at least one part.".toString());
    }

    public final MultipartBody$a c(MediaType mediaType) {
        m.checkParameterIsNotNull(mediaType, "type");
        if (m.areEqual(mediaType.type, "multipart")) {
            this.f3811b = mediaType;
            return this;
        }
        throw new IllegalArgumentException(("multipart != " + mediaType).toString());
    }
}
