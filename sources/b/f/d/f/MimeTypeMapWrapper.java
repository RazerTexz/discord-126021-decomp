package b.f.d.f;

import android.webkit.MimeTypeMap;
import b.f.d.d.ImmutableMap;
import java.util.Map;

/* JADX INFO: renamed from: b.f.d.f.b, reason: use source file name */
/* JADX INFO: compiled from: MimeTypeMapWrapper.java */
/* JADX INFO: loaded from: classes.dex */
public class MimeTypeMapWrapper {
    public static final MimeTypeMap a = MimeTypeMap.getSingleton();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, String> f471b = ImmutableMap.of("image/heif", "heif", "image/heic", "heic");
    public static final Map<String, String> c = ImmutableMap.of("heif", "image/heif", "heic", "image/heic");
}
