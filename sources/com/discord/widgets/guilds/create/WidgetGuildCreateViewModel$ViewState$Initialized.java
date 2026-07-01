package com.discord.widgets.guilds.create;

import android.content.Context;
import androidx.annotation.StringRes;
import b.a.k.b;
import b.d.b.a.a;
import com.discord.stores.StoreGuildTemplates$GuildTemplateState;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetGuildCreateViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetGuildCreateViewModel$ViewState$Initialized extends WidgetGuildCreateViewModel$ViewState {
    private final String customTitle;
    private final int defaultGuildNameFormatRes;
    private final String guildIconUri;
    private final String guildName;
    private final StoreGuildTemplates$GuildTemplateState guildTemplate;
    private final boolean isBusy;
    private final String username;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetGuildCreateViewModel$ViewState$Initialized(StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, @StringRes int i, String str, String str2, String str3, boolean z2, String str4) {
        super(null);
        m.checkNotNullParameter(storeGuildTemplates$GuildTemplateState, "guildTemplate");
        m.checkNotNullParameter(str, "username");
        this.guildTemplate = storeGuildTemplates$GuildTemplateState;
        this.defaultGuildNameFormatRes = i;
        this.username = str;
        this.guildName = str2;
        this.guildIconUri = str3;
        this.isBusy = z2;
        this.customTitle = str4;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    private final int getDefaultGuildNameFormatRes() {
        return this.defaultGuildNameFormatRes;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    private final String getUsername() {
        return this.username;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    private final String getGuildName() {
        return this.guildName;
    }

    public static /* synthetic */ WidgetGuildCreateViewModel$ViewState$Initialized copy$default(WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized, StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState, int i, String str, String str2, String str3, boolean z2, String str4, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            storeGuildTemplates$GuildTemplateState = widgetGuildCreateViewModel$ViewState$Initialized.guildTemplate;
        }
        if ((i2 & 2) != 0) {
            i = widgetGuildCreateViewModel$ViewState$Initialized.defaultGuildNameFormatRes;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            str = widgetGuildCreateViewModel$ViewState$Initialized.username;
        }
        String str5 = str;
        if ((i2 & 8) != 0) {
            str2 = widgetGuildCreateViewModel$ViewState$Initialized.guildName;
        }
        String str6 = str2;
        if ((i2 & 16) != 0) {
            str3 = widgetGuildCreateViewModel$ViewState$Initialized.guildIconUri;
        }
        String str7 = str3;
        if ((i2 & 32) != 0) {
            z2 = widgetGuildCreateViewModel$ViewState$Initialized.isBusy;
        }
        boolean z3 = z2;
        if ((i2 & 64) != 0) {
            str4 = widgetGuildCreateViewModel$ViewState$Initialized.customTitle;
        }
        return widgetGuildCreateViewModel$ViewState$Initialized.copy(storeGuildTemplates$GuildTemplateState, i3, str5, str6, str7, z3, str4);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final StoreGuildTemplates$GuildTemplateState getGuildTemplate() {
        return this.guildTemplate;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getGuildIconUri() {
        return this.guildIconUri;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getIsBusy() {
        return this.isBusy;
    }

    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getCustomTitle() {
        return this.customTitle;
    }

    public final WidgetGuildCreateViewModel$ViewState$Initialized copy(StoreGuildTemplates$GuildTemplateState guildTemplate, @StringRes int defaultGuildNameFormatRes, String username, String guildName, String guildIconUri, boolean isBusy, String customTitle) {
        m.checkNotNullParameter(guildTemplate, "guildTemplate");
        m.checkNotNullParameter(username, "username");
        return new WidgetGuildCreateViewModel$ViewState$Initialized(guildTemplate, defaultGuildNameFormatRes, username, guildName, guildIconUri, isBusy, customTitle);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetGuildCreateViewModel$ViewState$Initialized)) {
            return false;
        }
        WidgetGuildCreateViewModel$ViewState$Initialized widgetGuildCreateViewModel$ViewState$Initialized = (WidgetGuildCreateViewModel$ViewState$Initialized) other;
        return m.areEqual(this.guildTemplate, widgetGuildCreateViewModel$ViewState$Initialized.guildTemplate) && this.defaultGuildNameFormatRes == widgetGuildCreateViewModel$ViewState$Initialized.defaultGuildNameFormatRes && m.areEqual(this.username, widgetGuildCreateViewModel$ViewState$Initialized.username) && m.areEqual(this.guildName, widgetGuildCreateViewModel$ViewState$Initialized.guildName) && m.areEqual(this.guildIconUri, widgetGuildCreateViewModel$ViewState$Initialized.guildIconUri) && this.isBusy == widgetGuildCreateViewModel$ViewState$Initialized.isBusy && m.areEqual(this.customTitle, widgetGuildCreateViewModel$ViewState$Initialized.customTitle);
    }

    public final String getCustomTitle() {
        return this.customTitle;
    }

    public final String getGuildIconUri() {
        return this.guildIconUri;
    }

    public final String getGuildName(Context context) {
        m.checkNotNullParameter(context, "context");
        String str = this.guildName;
        return str != null ? str : b.h(context, this.defaultGuildNameFormatRes, new Object[]{this.username}, null, 4).toString();
    }

    public final StoreGuildTemplates$GuildTemplateState getGuildTemplate() {
        return this.guildTemplate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v11, types: [int] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v17 */
    public int hashCode() {
        StoreGuildTemplates$GuildTemplateState storeGuildTemplates$GuildTemplateState = this.guildTemplate;
        int iHashCode = (((storeGuildTemplates$GuildTemplateState != null ? storeGuildTemplates$GuildTemplateState.hashCode() : 0) * 31) + this.defaultGuildNameFormatRes) * 31;
        String str = this.username;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.guildName;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.guildIconUri;
        int iHashCode4 = (iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31;
        boolean z2 = this.isBusy;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        String str4 = this.customTitle;
        return i + (str4 != null ? str4.hashCode() : 0);
    }

    public final boolean isBusy() {
        return this.isBusy;
    }

    public String toString() {
        StringBuilder sbU = a.U("Initialized(guildTemplate=");
        sbU.append(this.guildTemplate);
        sbU.append(", defaultGuildNameFormatRes=");
        sbU.append(this.defaultGuildNameFormatRes);
        sbU.append(", username=");
        sbU.append(this.username);
        sbU.append(", guildName=");
        sbU.append(this.guildName);
        sbU.append(", guildIconUri=");
        sbU.append(this.guildIconUri);
        sbU.append(", isBusy=");
        sbU.append(this.isBusy);
        sbU.append(", customTitle=");
        return a.J(sbU, this.customTitle, ")");
    }
}
