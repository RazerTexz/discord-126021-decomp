package b.a.z.a.a;

import com.discord.api.role.GuildRole;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddRole$Model;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class u implements Function1 {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole j;
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddRole$Model k;

    public /* synthetic */ u(WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole, WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model) {
        this.j = widgetChannelSettingsPermissionsAddRole;
        this.k = widgetChannelSettingsPermissionsAddRole$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WidgetChannelSettingsPermissionsAddRole widgetChannelSettingsPermissionsAddRole = this.j;
        WidgetChannelSettingsPermissionsAddRole$Model widgetChannelSettingsPermissionsAddRole$Model = this.k;
        WidgetChannelSettingsEditPermissions.createForRole(widgetChannelSettingsPermissionsAddRole.getContext(), WidgetChannelSettingsPermissionsAddRole$Model.access$200(widgetChannelSettingsPermissionsAddRole$Model).getGuildId(), WidgetChannelSettingsPermissionsAddRole$Model.access$200(widgetChannelSettingsPermissionsAddRole$Model).getId(), ((GuildRole) obj).getId());
        return Unit.a;
    }
}
