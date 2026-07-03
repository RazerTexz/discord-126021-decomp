package p007b.p485q.p486a;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.q.a.a */
/* JADX INFO: compiled from: UCrop.java */
/* JADX INFO: loaded from: classes3.dex */
public class C5285a {

    /* JADX INFO: renamed from: a */
    public Intent f14387a = new Intent();

    /* JADX INFO: renamed from: b */
    public Bundle f14388b;

    public C5285a(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f14388b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.f14388b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }
}
