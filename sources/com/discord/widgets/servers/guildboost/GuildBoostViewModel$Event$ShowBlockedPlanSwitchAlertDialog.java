package com.discord.widgets.servers.guildboost;

import androidx.annotation.StringRes;
import b.d.b.a.a;

/* JADX INFO: compiled from: GuildBoostViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog extends GuildBoostViewModel$Event {
    private final int bodyStringRes;
    private final int headerStringRes;

    public GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog(@StringRes int i, @StringRes int i2) {
        super(null);
        this.headerStringRes = i;
        this.bodyStringRes = i2;
    }

    public static /* synthetic */ GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog copy$default(GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.headerStringRes;
        }
        if ((i3 & 2) != 0) {
            i2 = guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.bodyStringRes;
        }
        return guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.copy(i, i2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final int getHeaderStringRes() {
        return this.headerStringRes;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final int getBodyStringRes() {
        return this.bodyStringRes;
    }

    public final GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog copy(@StringRes int headerStringRes, @StringRes int bodyStringRes) {
        return new GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog(headerStringRes, bodyStringRes);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog)) {
            return false;
        }
        GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog = (GuildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog) other;
        return this.headerStringRes == guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.headerStringRes && this.bodyStringRes == guildBoostViewModel$Event$ShowBlockedPlanSwitchAlertDialog.bodyStringRes;
    }

    public final int getBodyStringRes() {
        return this.bodyStringRes;
    }

    public final int getHeaderStringRes() {
        return this.headerStringRes;
    }

    public int hashCode() {
        return (this.headerStringRes * 31) + this.bodyStringRes;
    }

    public String toString() {
        StringBuilder sbU = a.U("ShowBlockedPlanSwitchAlertDialog(headerStringRes=");
        sbU.append(this.headerStringRes);
        sbU.append(", bodyStringRes=");
        return a.B(sbU, this.bodyStringRes, ")");
    }
}
