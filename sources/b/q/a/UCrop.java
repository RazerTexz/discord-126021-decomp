package b.q.a;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: renamed from: b.q.a.a, reason: use source file name */
/* JADX INFO: compiled from: UCrop.java */
/* JADX INFO: loaded from: classes3.dex */
public class UCrop {
    public Intent a = new Intent();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f1977b;

    public UCrop(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f1977b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.f1977b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }
}
