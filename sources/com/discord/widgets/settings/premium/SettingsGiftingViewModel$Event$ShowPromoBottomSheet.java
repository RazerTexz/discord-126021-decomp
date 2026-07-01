package com.discord.widgets.settings.premium;

import b.d.b.a.a;
import d0.z.d.m;

/* JADX INFO: compiled from: SettingsGiftingViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class SettingsGiftingViewModel$Event$ShowPromoBottomSheet extends SettingsGiftingViewModel$Event {
    private final String content;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SettingsGiftingViewModel$Event$ShowPromoBottomSheet(String str) {
        super(null);
        m.checkNotNullParameter(str, "content");
        this.content = str;
    }

    public static /* synthetic */ SettingsGiftingViewModel$Event$ShowPromoBottomSheet copy$default(SettingsGiftingViewModel$Event$ShowPromoBottomSheet settingsGiftingViewModel$Event$ShowPromoBottomSheet, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = settingsGiftingViewModel$Event$ShowPromoBottomSheet.content;
        }
        return settingsGiftingViewModel$Event$ShowPromoBottomSheet.copy(str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getContent() {
        return this.content;
    }

    public final SettingsGiftingViewModel$Event$ShowPromoBottomSheet copy(String content) {
        m.checkNotNullParameter(content, "content");
        return new SettingsGiftingViewModel$Event$ShowPromoBottomSheet(content);
    }

    public boolean equals(Object other) {
        if (this != other) {
            return (other instanceof SettingsGiftingViewModel$Event$ShowPromoBottomSheet) && m.areEqual(this.content, ((SettingsGiftingViewModel$Event$ShowPromoBottomSheet) other).content);
        }
        return true;
    }

    public final String getContent() {
        return this.content;
    }

    public int hashCode() {
        String str = this.content;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public String toString() {
        return a.J(a.U("ShowPromoBottomSheet(content="), this.content, ")");
    }
}
