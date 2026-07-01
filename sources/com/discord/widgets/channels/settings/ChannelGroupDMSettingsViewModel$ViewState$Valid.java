package com.discord.widgets.channels.settings;

import b.d.b.a.a;
import com.discord.utilities.icon.IconUtils;
import d0.g;
import d0.z.d.m;
import kotlin.Lazy;

/* JADX INFO: compiled from: ChannelGroupDMSettingsViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class ChannelGroupDMSettingsViewModel$ViewState$Valid extends ChannelGroupDMSettingsViewModel$ViewState {
    private final ChannelSettings channelSettings;
    private final String editedIconUrl;
    private final boolean hasUnsavedIconChange;

    /* JADX INFO: renamed from: isDefaultPhoto$delegate, reason: from kotlin metadata */
    private final Lazy isDefaultPhoto;
    private final String originalIconUrl;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ChannelGroupDMSettingsViewModel$ViewState$Valid(ChannelSettings channelSettings, String str, String str2) {
        super(null);
        m.checkNotNullParameter(channelSettings, "channelSettings");
        this.channelSettings = channelSettings;
        this.originalIconUrl = str;
        this.editedIconUrl = str2;
        this.hasUnsavedIconChange = !m.areEqual(str, str2);
        this.isDefaultPhoto = g.lazy(new ChannelGroupDMSettingsViewModel$ViewState$Valid$isDefaultPhoto$2(this));
    }

    public static /* synthetic */ ChannelGroupDMSettingsViewModel$ViewState$Valid copy$default(ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid, ChannelSettings channelSettings, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            channelSettings = channelGroupDMSettingsViewModel$ViewState$Valid.channelSettings;
        }
        if ((i & 2) != 0) {
            str = channelGroupDMSettingsViewModel$ViewState$Valid.originalIconUrl;
        }
        if ((i & 4) != 0) {
            str2 = channelGroupDMSettingsViewModel$ViewState$Valid.editedIconUrl;
        }
        return channelGroupDMSettingsViewModel$ViewState$Valid.copy(channelSettings, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ChannelSettings getChannelSettings() {
        return this.channelSettings;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getOriginalIconUrl() {
        return this.originalIconUrl;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEditedIconUrl() {
        return this.editedIconUrl;
    }

    public final ChannelGroupDMSettingsViewModel$ViewState$Valid copy(ChannelSettings channelSettings, String originalIconUrl, String editedIconUrl) {
        m.checkNotNullParameter(channelSettings, "channelSettings");
        return new ChannelGroupDMSettingsViewModel$ViewState$Valid(channelSettings, originalIconUrl, editedIconUrl);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChannelGroupDMSettingsViewModel$ViewState$Valid)) {
            return false;
        }
        ChannelGroupDMSettingsViewModel$ViewState$Valid channelGroupDMSettingsViewModel$ViewState$Valid = (ChannelGroupDMSettingsViewModel$ViewState$Valid) other;
        return m.areEqual(this.channelSettings, channelGroupDMSettingsViewModel$ViewState$Valid.channelSettings) && m.areEqual(this.originalIconUrl, channelGroupDMSettingsViewModel$ViewState$Valid.originalIconUrl) && m.areEqual(this.editedIconUrl, channelGroupDMSettingsViewModel$ViewState$Valid.editedIconUrl);
    }

    public final ChannelSettings getChannelSettings() {
        return this.channelSettings;
    }

    public final String getCurrentIconUrl() {
        if (!this.hasUnsavedIconChange) {
            return IconUtils.getForChannel(this.channelSettings.getChannel(), null);
        }
        String str = this.editedIconUrl;
        return str != null ? str : IconUtils.INSTANCE.getDefaultForGroupDM(this.channelSettings.getChannel().getId());
    }

    public final String getEditedIconUrl() {
        return this.editedIconUrl;
    }

    public final boolean getHasUnsavedIconChange() {
        return this.hasUnsavedIconChange;
    }

    public final String getOriginalIconUrl() {
        return this.originalIconUrl;
    }

    public int hashCode() {
        ChannelSettings channelSettings = this.channelSettings;
        int iHashCode = (channelSettings != null ? channelSettings.hashCode() : 0) * 31;
        String str = this.originalIconUrl;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.editedIconUrl;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final boolean isDefaultPhoto() {
        return ((Boolean) this.isDefaultPhoto.getValue()).booleanValue();
    }

    public String toString() {
        StringBuilder sbU = a.U("Valid(channelSettings=");
        sbU.append(this.channelSettings);
        sbU.append(", originalIconUrl=");
        sbU.append(this.originalIconUrl);
        sbU.append(", editedIconUrl=");
        return a.J(sbU, this.editedIconUrl, ")");
    }
}
