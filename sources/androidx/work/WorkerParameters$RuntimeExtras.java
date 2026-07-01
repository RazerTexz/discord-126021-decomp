package androidx.work;

import android.net.Network;
import android.net.Uri;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP})
public class WorkerParameters$RuntimeExtras {

    @RequiresApi(28)
    public Network network;

    @NonNull
    public List<String> triggeredContentAuthorities = Collections.emptyList();

    @NonNull
    public List<Uri> triggeredContentUris = Collections.emptyList();
}
