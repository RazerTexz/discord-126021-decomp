package b.i.a.c.a3;

import android.net.Uri;
import b.i.a.c.e3.DataSpec;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: renamed from: b.i.a.c.a3.t, reason: use source file name */
/* JADX INFO: compiled from: LoadEventInfo.java */
/* JADX INFO: loaded from: classes3.dex */
public final class LoadEventInfo {
    public static final AtomicLong a = new AtomicLong();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f833b;

    public LoadEventInfo(long j, DataSpec dataSpec, long j2) {
        Uri uri = dataSpec.a;
        this.f833b = Collections.emptyMap();
    }

    public LoadEventInfo(long j, DataSpec dataSpec, Uri uri, Map<String, List<String>> map, long j2, long j3, long j4) {
        this.f833b = map;
    }
}
