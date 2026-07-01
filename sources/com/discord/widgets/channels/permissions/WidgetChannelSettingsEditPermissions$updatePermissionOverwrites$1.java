package com.discord.widgets.channels.permissions;

import com.discord.restapi.RestAPIParams$ChannelPermissionOverwrites;
import com.discord.views.TernaryCheckBox;
import d0.z.d.o;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$1 extends o implements Function0<RestAPIParams$ChannelPermissionOverwrites> {
    public final /* synthetic */ long $targetId;
    public final /* synthetic */ int $type;
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions$updatePermissionOverwrites$1(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions, int i, long j) {
        super(0);
        this.this$0 = widgetChannelSettingsEditPermissions;
        this.$type = i;
        this.$targetId = j;
    }

    @Override // kotlin.jvm.functions.Function0
    public /* bridge */ /* synthetic */ RestAPIParams$ChannelPermissionOverwrites invoke() {
        return invoke();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final RestAPIParams$ChannelPermissionOverwrites invoke() {
        Iterator it = WidgetChannelSettingsEditPermissions.access$getPermissionCheckboxes$p(this.this$0).iterator();
        long jAccess$getPermission = 0;
        long jAccess$getPermission2 = 0;
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            TernaryCheckBox ternaryCheckBox = (TernaryCheckBox) it.next();
            if (ternaryCheckBox.b()) {
                jAccess$getPermission |= WidgetChannelSettingsEditPermissions$Companion.access$getPermission(WidgetChannelSettingsEditPermissions.Companion, ternaryCheckBox.getId());
            } else {
                if (ternaryCheckBox.switchStatus == -1) {
                    jAccess$getPermission2 |= WidgetChannelSettingsEditPermissions$Companion.access$getPermission(WidgetChannelSettingsEditPermissions.Companion, ternaryCheckBox.getId());
                }
            }
        }
        return this.$type == 1 ? RestAPIParams$ChannelPermissionOverwrites.Companion.createForRole(this.$targetId, Long.valueOf(jAccess$getPermission), Long.valueOf(jAccess$getPermission2)) : RestAPIParams$ChannelPermissionOverwrites.Companion.createForMember(this.$targetId, Long.valueOf(jAccess$getPermission), Long.valueOf(jAccess$getPermission2));
    }
}
