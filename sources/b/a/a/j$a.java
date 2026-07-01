package b.a.a;

import android.os.Bundle;
import androidx.fragment.app.FragmentManager;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: CameraCapacityDialog.kt */
/* JADX INFO: loaded from: classes.dex */
public final class j$a {
    public j$a(DefaultConstructorMarker defaultConstructorMarker) {
    }

    public final void a(FragmentManager fragmentManager, int i) {
        d0.z.d.m.checkNotNullParameter(fragmentManager, "fragmentManager");
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_MAX_VIDEO_CHANNEL_USERS", i);
        j jVar = new j();
        jVar.setArguments(bundle);
        jVar.show(fragmentManager, j.class.getSimpleName());
    }
}
