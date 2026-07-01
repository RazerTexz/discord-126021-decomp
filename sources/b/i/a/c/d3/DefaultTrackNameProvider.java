package b.i.a.c.d3;

import android.content.res.Resources;
import java.util.Objects;

/* JADX INFO: renamed from: b.i.a.c.d3.l, reason: use source file name */
/* JADX INFO: compiled from: DefaultTrackNameProvider.java */
/* JADX INFO: loaded from: classes3.dex */
public class DefaultTrackNameProvider implements TrackNameProvider {
    public final Resources a;

    public DefaultTrackNameProvider(Resources resources) {
        Objects.requireNonNull(resources);
        this.a = resources;
    }
}
