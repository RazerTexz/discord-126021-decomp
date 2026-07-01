package com.facebook.imagepipeline.request;

import android.net.Uri;
import b.d.b.a.outline;
import b.f.d.l.UriUtil;
import b.f.j.d.BytesRange;
import b.f.j.d.ImageDecodeOptions;
import b.f.j.d.Priority2;
import b.f.j.d.ResizeOptions;
import b.f.j.d.RotationOptions;
import b.f.j.k.RequestListener;
import b.f.j.q.Postprocessor;
import com.discord.models.domain.ModelAuditLogEntry;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Objects;

/* JADX INFO: loaded from: classes3.dex */
public class ImageRequestBuilder {
    public RequestListener n;
    public int p;
    public Uri a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public ImageRequest.c f2904b = ImageRequest.c.FULL_FETCH;
    public int c = 0;
    public ResizeOptions d = null;
    public RotationOptions e = null;
    public ImageDecodeOptions f = ImageDecodeOptions.a;
    public ImageRequest.b g = ImageRequest.b.DEFAULT;
    public boolean h = false;
    public boolean i = false;
    public boolean j = false;
    public Priority2 k = Priority2.HIGH;
    public Postprocessor l = null;
    public Boolean m = null;
    public BytesRange o = null;

    public static class BuilderException extends RuntimeException {
        public BuilderException(String str) {
            super(outline.w("Invalid request builder: ", str));
        }
    }

    public static ImageRequestBuilder b(Uri uri) {
        ImageRequestBuilder imageRequestBuilder = new ImageRequestBuilder();
        Objects.requireNonNull(uri);
        imageRequestBuilder.a = uri;
        return imageRequestBuilder;
    }

    public ImageRequest a() {
        Uri uri = this.a;
        if (uri == null) {
            throw new BuilderException("Source must be set!");
        }
        if ("res".equals(UriUtil.a(uri))) {
            if (!this.a.isAbsolute()) {
                throw new BuilderException("Resource URI path must be absolute.");
            }
            if (this.a.getPath().isEmpty()) {
                throw new BuilderException("Resource URI must not be empty");
            }
            try {
                Integer.parseInt(this.a.getPath().substring(1));
            } catch (NumberFormatException unused) {
                throw new BuilderException("Resource URI path must be a resource id.");
            }
        }
        if (!ModelAuditLogEntry.CHANGE_KEY_ASSET.equals(UriUtil.a(this.a)) || this.a.isAbsolute()) {
            return new ImageRequest(this);
        }
        throw new BuilderException("Asset URI path must be absolute.");
    }
}
