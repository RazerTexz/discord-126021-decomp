package com.discord.widgets.user.calls;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissionsRequests;
import com.discord.widgets.voice.call.PrivateCallLaunchUtilsKt;
import d0.z.d.m;

/* JADX INFO: compiled from: PrivateCallLauncher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLauncher {
    private final AppComponent appComponent;
    private final AppPermissionsRequests appPermissionsRequests;
    private final Context context;
    private final FragmentManager fragmentManager;

    public PrivateCallLauncher(AppPermissionsRequests appPermissionsRequests, AppComponent appComponent, Context context, FragmentManager fragmentManager) {
        m.checkNotNullParameter(appPermissionsRequests, "appPermissionsRequests");
        m.checkNotNullParameter(appComponent, "appComponent");
        m.checkNotNullParameter(context, "context");
        m.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.appPermissionsRequests = appPermissionsRequests;
        this.appComponent = appComponent;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    public final AppPermissionsRequests getAppPermissionsRequests() {
        return this.appPermissionsRequests;
    }

    public final Context getContext() {
        return this.context;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void launchVideoCall(long channelId) {
        PrivateCallLaunchUtilsKt.callAndLaunch(channelId, true, this.appPermissionsRequests, this.context, this.appComponent, this.fragmentManager);
    }

    public final void launchVoiceCall(long channelId) {
        PrivateCallLaunchUtilsKt.callAndLaunch(channelId, false, this.appPermissionsRequests, this.context, this.appComponent, this.fragmentManager);
    }
}
