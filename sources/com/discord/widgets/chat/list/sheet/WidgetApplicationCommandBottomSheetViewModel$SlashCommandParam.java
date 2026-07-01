package com.discord.widgets.chat.list.sheet;

import b.d.b.a.a;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.m;

/* JADX INFO: compiled from: WidgetApplicationCommandBottomSheetViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam {
    private final String copyText;
    private final String name;
    private final String value;
    private final Integer valueColor;

    public WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(String str, String str2, Integer num, String str3) {
        a.q0(str, ModelAuditLogEntry.CHANGE_KEY_NAME, str2, "value", str3, "copyText");
        this.name = str;
        this.value = str2;
        this.valueColor = num;
        this.copyText = str3;
    }

    public static /* synthetic */ WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam copy$default(WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam widgetApplicationCommandBottomSheetViewModel$SlashCommandParam, String str, String str2, Integer num, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.name;
        }
        if ((i & 2) != 0) {
            str2 = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.value;
        }
        if ((i & 4) != 0) {
            num = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.valueColor;
        }
        if ((i & 8) != 0) {
            str3 = widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.copyText;
        }
        return widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.copy(str, str2, num, str3);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getValue() {
        return this.value;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Integer getValueColor() {
        return this.valueColor;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getCopyText() {
        return this.copyText;
    }

    public final WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam copy(String name, String value, Integer valueColor, String copyText) {
        m.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        m.checkNotNullParameter(value, "value");
        m.checkNotNullParameter(copyText, "copyText");
        return new WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam(name, value, valueColor, copyText);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam)) {
            return false;
        }
        WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam widgetApplicationCommandBottomSheetViewModel$SlashCommandParam = (WidgetApplicationCommandBottomSheetViewModel$SlashCommandParam) other;
        return m.areEqual(this.name, widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.name) && m.areEqual(this.value, widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.value) && m.areEqual(this.valueColor, widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.valueColor) && m.areEqual(this.copyText, widgetApplicationCommandBottomSheetViewModel$SlashCommandParam.copyText);
    }

    public final String getCopyText() {
        return this.copyText;
    }

    public final String getName() {
        return this.name;
    }

    public final String getValue() {
        return this.value;
    }

    public final Integer getValueColor() {
        return this.valueColor;
    }

    public int hashCode() {
        String str = this.name;
        int iHashCode = (str != null ? str.hashCode() : 0) * 31;
        String str2 = this.value;
        int iHashCode2 = (iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        Integer num = this.valueColor;
        int iHashCode3 = (iHashCode2 + (num != null ? num.hashCode() : 0)) * 31;
        String str3 = this.copyText;
        return iHashCode3 + (str3 != null ? str3.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = a.U("SlashCommandParam(name=");
        sbU.append(this.name);
        sbU.append(", value=");
        sbU.append(this.value);
        sbU.append(", valueColor=");
        sbU.append(this.valueColor);
        sbU.append(", copyText=");
        return a.J(sbU, this.copyText, ")");
    }
}
