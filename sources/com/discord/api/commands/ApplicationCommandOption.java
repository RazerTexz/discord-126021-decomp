package com.discord.api.commands;

import b.d.b.a.outline;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.z.d.Intrinsics3;
import java.util.List;

/* JADX INFO: compiled from: ApplicationCommandOption.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandOption {
    private final boolean autocomplete;
    private final List<Integer> channelTypes;
    private final List<CommandChoice> choices;
    private final boolean default;
    private final String description;
    private final Number maxValue;
    private final Number minValue;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final boolean required;
    private final ApplicationCommandType type;

    /* JADX INFO: renamed from: a, reason: from getter */
    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    public final List<Integer> b() {
        return this.channelTypes;
    }

    public final List<CommandChoice> c() {
        return this.choices;
    }

    /* JADX INFO: renamed from: d, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    /* JADX INFO: renamed from: e, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandOption)) {
            return false;
        }
        ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) other;
        return Intrinsics3.areEqual(this.type, applicationCommandOption.type) && Intrinsics3.areEqual(this.name, applicationCommandOption.name) && Intrinsics3.areEqual(this.description, applicationCommandOption.description) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && Intrinsics3.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && Intrinsics3.areEqual(this.choices, applicationCommandOption.choices) && Intrinsics3.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && Intrinsics3.areEqual(this.minValue, applicationCommandOption.minValue) && Intrinsics3.areEqual(this.maxValue, applicationCommandOption.maxValue);
    }

    /* JADX INFO: renamed from: f, reason: from getter */
    public final Number getMaxValue() {
        return this.maxValue;
    }

    /* JADX INFO: renamed from: g, reason: from getter */
    public final Number getMinValue() {
        return this.minValue;
    }

    /* JADX INFO: renamed from: h, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v29 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9, types: [int] */
    /* JADX WARN: Type inference failed for: r3v0 */
    /* JADX WARN: Type inference failed for: r3v1, types: [int] */
    /* JADX WARN: Type inference failed for: r3v2 */
    public int hashCode() {
        ApplicationCommandType applicationCommandType = this.type;
        int iHashCode = (applicationCommandType != null ? applicationCommandType.hashCode() : 0) * 31;
        String str = this.name;
        int iHashCode2 = (iHashCode + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int iHashCode3 = (iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode3 + r2) * 31;
        boolean z3 = this.default;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        List<Integer> list = this.channelTypes;
        int iHashCode4 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        List<CommandChoice> list2 = this.choices;
        int iHashCode5 = (iHashCode4 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list3 = this.options;
        int iHashCode6 = (iHashCode5 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z4 = this.autocomplete;
        int i3 = (iHashCode6 + (z4 ? 1 : z4)) * 31;
        Number number = this.minValue;
        int iHashCode7 = (i3 + (number != null ? number.hashCode() : 0)) * 31;
        Number number2 = this.maxValue;
        return iHashCode7 + (number2 != null ? number2.hashCode() : 0);
    }

    public final List<ApplicationCommandOption> i() {
        return this.options;
    }

    /* JADX INFO: renamed from: j, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: k, reason: from getter */
    public final ApplicationCommandType getType() {
        return this.type;
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandOption(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", required=");
        sbU.append(this.required);
        sbU.append(", default=");
        sbU.append(this.default);
        sbU.append(", channelTypes=");
        sbU.append(this.channelTypes);
        sbU.append(", choices=");
        sbU.append(this.choices);
        sbU.append(", options=");
        sbU.append(this.options);
        sbU.append(", autocomplete=");
        sbU.append(this.autocomplete);
        sbU.append(", minValue=");
        sbU.append(this.minValue);
        sbU.append(", maxValue=");
        sbU.append(this.maxValue);
        sbU.append(")");
        return sbU.toString();
    }
}
