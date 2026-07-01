package com.discord.widgets.servers;

import b.d.b.a.a;
import com.discord.api.user.User;
import com.discord.models.domain.ModelBan;
import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.z.d.m;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: WidgetServerSettingsBans.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetServerSettingsBans$Model$BanItem implements MGRecyclerDataPayload {
    private ModelBan ban;
    private final String key;
    private final int type;

    public WidgetServerSettingsBans$Model$BanItem() {
        this(null, 1, null);
    }

    public WidgetServerSettingsBans$Model$BanItem(ModelBan modelBan) {
        User user;
        this.ban = modelBan;
        this.type = 1;
        this.key = String.valueOf((modelBan == null || (user = modelBan.getUser()) == null) ? null : Long.valueOf(user.getId()));
    }

    public static /* synthetic */ WidgetServerSettingsBans$Model$BanItem copy$default(WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem, ModelBan modelBan, int i, Object obj) {
        if ((i & 1) != 0) {
            modelBan = widgetServerSettingsBans$Model$BanItem.ban;
        }
        return widgetServerSettingsBans$Model$BanItem.copy(modelBan);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ModelBan getBan() {
        return this.ban;
    }

    public final WidgetServerSettingsBans$Model$BanItem copy(ModelBan ban) {
        return new WidgetServerSettingsBans$Model$BanItem(ban);
    }

    public final WidgetServerSettingsBans$Model$BanItem create(ModelBan ban) {
        m.checkNotNullParameter(ban, "ban");
        WidgetServerSettingsBans$Model$BanItem widgetServerSettingsBans$Model$BanItem = new WidgetServerSettingsBans$Model$BanItem(null, 1, null);
        widgetServerSettingsBans$Model$BanItem.ban = ban;
        return widgetServerSettingsBans$Model$BanItem;
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof WidgetServerSettingsBans$Model$BanItem) && m.areEqual(this.ban, ((WidgetServerSettingsBans$Model$BanItem) other).ban);
        }
        return true;
    }

    public final ModelBan getBan() {
        return this.ban;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public int hashCode() {
        ModelBan modelBan = this.ban;
        if (modelBan != null) {
            return modelBan.hashCode();
        }
        return 0;
    }

    public final void setBan(ModelBan modelBan) {
        this.ban = modelBan;
    }

    public String toString() {
        StringBuilder sbU = a.U("BanItem(ban=");
        sbU.append(this.ban);
        sbU.append(")");
        return sbU.toString();
    }

    public /* synthetic */ WidgetServerSettingsBans$Model$BanItem(ModelBan modelBan, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : modelBan);
    }
}
