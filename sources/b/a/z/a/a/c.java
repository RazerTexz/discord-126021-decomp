package b.a.z.a.a;

import com.discord.models.user.User;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember;
import com.discord.widgets.channels.permissions.WidgetChannelSettingsPermissionsAddMember$Model;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: lambda */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class c implements Function1 {
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddMember j;
    public final /* synthetic */ WidgetChannelSettingsPermissionsAddMember$Model k;

    public /* synthetic */ c(WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember, WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model) {
        this.j = widgetChannelSettingsPermissionsAddMember;
        this.k = widgetChannelSettingsPermissionsAddMember$Model;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Object obj) {
        WidgetChannelSettingsPermissionsAddMember widgetChannelSettingsPermissionsAddMember = this.j;
        WidgetChannelSettingsPermissionsAddMember$Model widgetChannelSettingsPermissionsAddMember$Model = this.k;
        WidgetChannelSettingsEditPermissions.createForUser(widgetChannelSettingsPermissionsAddMember.getContext(), WidgetChannelSettingsPermissionsAddMember$Model.access$100(widgetChannelSettingsPermissionsAddMember$Model).getGuildId(), WidgetChannelSettingsPermissionsAddMember$Model.access$100(widgetChannelSettingsPermissionsAddMember$Model).getId(), ((User) obj).getId());
        return Unit.a;
    }
}
