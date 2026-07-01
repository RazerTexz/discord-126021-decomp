package com.discord.widgets.channels.permissions;

import com.discord.views.TernaryCheckBox;
import d0.t.Collections2;
import d0.z.d.Lambda;
import java.util.List;
import kotlin.jvm.functions.Function0;

/* JADX INFO: renamed from: com.discord.widgets.channels.permissions.WidgetChannelSettingsEditPermissions$permissionCheckboxes$2, reason: use source file name */
/* JADX INFO: compiled from: WidgetChannelSettingsEditPermissions.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetChannelSettingsEditPermissions5 extends Lambda implements Function0<List<? extends TernaryCheckBox>> {
    public final /* synthetic */ WidgetChannelSettingsEditPermissions this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetChannelSettingsEditPermissions5(WidgetChannelSettingsEditPermissions widgetChannelSettingsEditPermissions) {
        super(0);
        this.this$0 = widgetChannelSettingsEditPermissions;
    }

    @Override // kotlin.jvm.functions.Function0
    public final List<? extends TernaryCheckBox> invoke() {
        return Collections2.listOf((Object[]) new TernaryCheckBox[]{this.this$0.getBinding().c, this.this$0.getBinding().d, this.this$0.getBinding().f, this.this$0.getBinding().e, this.this$0.getBinding().g, this.this$0.getBinding().j, this.this$0.getBinding().m, this.this$0.getBinding().n, this.this$0.getBinding().o, this.this$0.getBinding().p, this.this$0.getBinding().q, this.this$0.getBinding().r, this.this$0.getBinding().f2274s, this.this$0.getBinding().l, this.this$0.getBinding().k, this.this$0.getBinding().t, this.this$0.getBinding().w, this.this$0.getBinding().u, this.this$0.getBinding().v, this.this$0.getBinding().i, this.this$0.getBinding().f2275x, this.this$0.getBinding().f2276y, this.this$0.getBinding().f2277z, this.this$0.getBinding().A, this.this$0.getBinding().C, this.this$0.getBinding().E, this.this$0.getBinding().D, this.this$0.getBinding().B, this.this$0.getBinding().h, this.this$0.getBinding().f2273b});
    }
}
