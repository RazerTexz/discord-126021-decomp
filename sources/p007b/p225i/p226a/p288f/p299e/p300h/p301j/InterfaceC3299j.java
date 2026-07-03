package p007b.p225i.p226a.p288f.p299e.p300h.p301j;

import android.app.Activity;
import android.content.Intent;
import androidx.annotation.RecentlyNonNull;
import androidx.annotation.RecentlyNullable;
import com.google.android.gms.common.api.internal.LifecycleCallback;

/* JADX INFO: renamed from: b.i.a.f.e.h.j.j */
/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.6.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface InterfaceC3299j {
    /* JADX INFO: renamed from: a */
    void mo4069a(@RecentlyNonNull String str, @RecentlyNonNull LifecycleCallback lifecycleCallback);

    @RecentlyNullable
    /* JADX INFO: renamed from: d */
    <T extends LifecycleCallback> T mo4070d(@RecentlyNonNull String str, @RecentlyNonNull Class<T> cls);

    @RecentlyNonNull
    /* JADX INFO: renamed from: e */
    Activity mo4071e();

    void startActivityForResult(@RecentlyNonNull Intent intent, int i);
}
