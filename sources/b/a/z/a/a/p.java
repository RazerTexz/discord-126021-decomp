package b.a.z.a.a;

import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole$Model;
import rx.functions.Action1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class p implements Action1 {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole j;

    public /* synthetic */ p(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole) {
        this.j = widgetChannelSettingsPermissionsAddRole;
    }

    @Override // rx.functions.Action1
    public final void call(Object obj) {
        WidgetChannelSettingsPermissionsAddRole.g(this.j, (WidgetChannelSettingsPermissionsAddRole$Model) obj);
    }
}
