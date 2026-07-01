package com.discord.widgets.user.calls;

import android.content.Context;
import androidx.fragment.app.FragmentManager;
import com.discord.app.AppComponent;
import com.discord.app.AppPermissions2;
import com.discord.widgets.voice.call.PrivateCallLaunchUtils;
import d0.z.d.Intrinsics3;

/* JADX INFO: compiled from: PrivateCallLauncher.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PrivateCallLauncher {
    private final AppComponent appComponent;
    private final AppPermissions2 appPermissionsRequests;
    private final Context context;
    private final FragmentManager fragmentManager;

    public PrivateCallLauncher(AppPermissions2 appPermissions2, AppComponent appComponent, Context context, FragmentManager fragmentManager) {
        Intrinsics3.checkNotNullParameter(appPermissions2, "appPermissionsRequests");
        Intrinsics3.checkNotNullParameter(appComponent, "appComponent");
        Intrinsics3.checkNotNullParameter(context, "context");
        Intrinsics3.checkNotNullParameter(fragmentManager, "fragmentManager");
        this.appPermissionsRequests = appPermissions2;
        this.appComponent = appComponent;
        this.context = context;
        this.fragmentManager = fragmentManager;
    }

    public final AppComponent getAppComponent() {
        return this.appComponent;
    }

    public final AppPermissions2 getAppPermissionsRequests() {
        return this.appPermissionsRequests;
    }

    public final Context getContext() {
        return this.context;
    }

    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    public final void launchVideoCall(long channelId) {
        PrivateCallLaunchUtils.callAndLaunch(channelId, true, this.appPermissionsRequests, this.context, this.appComponent, this.fragmentManager);
    }

    public final void launchVoiceCall(long channelId) {
        PrivateCallLaunchUtils.callAndLaunch(channelId, false, this.appPermissionsRequests, this.context, this.appComponent, this.fragmentManager);
    }
}
