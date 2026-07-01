package b.q.a;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.annotation.NonNull;

/* JADX INFO: compiled from: UCrop.java */
/* JADX INFO: loaded from: classes3.dex */
public class a {
    public Intent a = new Intent();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Bundle f1977b;

    public a(@NonNull Uri uri, @NonNull Uri uri2) {
        Bundle bundle = new Bundle();
        this.f1977b = bundle;
        bundle.putParcelable("com.yalantis.ucrop.InputUri", uri);
        this.f1977b.putParcelable("com.yalantis.ucrop.OutputUri", uri2);
    }
}
