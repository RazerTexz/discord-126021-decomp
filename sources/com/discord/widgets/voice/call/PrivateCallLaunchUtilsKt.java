package com.discord.widgets.voice.call;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import b.c.a.a0.d;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissionsRequests;
import d0.z.d.m;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: PrivateCallLaunchUtils.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLaunchUtilsKt {
    public static final void callAndLaunch(long j, boolean z2, AppPermissionsRequests appPermissionsRequests, Context context, AppComponent appComponent, FragmentManager fragmentManager) {
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        PrivateCallLaunchUtilsKt$callAndLaunch$1 privateCallLaunchUtilsKt$callAndLaunch$1 = new PrivateCallLaunchUtilsKt$callAndLaunch$1(j, new WeakReference(context), appComponent, context, fragmentManager, z2);
        if (z2) {
            appPermissionsRequests.requestVideoCallPermissions(new PrivateCallLaunchUtilsKt$callAndLaunch$2(privateCallLaunchUtilsKt$callAndLaunch$1));
        } else {
            d.S1(appPermissionsRequests, null, new PrivateCallLaunchUtilsKt$callAndLaunch$3(privateCallLaunchUtilsKt$callAndLaunch$1), 1, null);
        }
    }
}
