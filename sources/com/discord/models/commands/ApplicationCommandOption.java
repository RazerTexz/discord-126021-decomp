package com.discord.models.commands;

import b.d.b.a.outline;
import com.discord.api.commands.ApplicationCommandType;
import com.discord.api.commands.CommandChoice;
import com.discord.models.domain.ModelAuditLogEntry;
import d0.t.Collections2;
import d0.z.d.Intrinsics3;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ApplicationCommandOption.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* data */ class ApplicationCommandOption {
    private final boolean autocomplete;
    private final List<Integer> channelTypes;
    private final List<CommandChoice> choices;
    private final boolean default;
    private final String description;
    private final Integer descriptionRes;
    private final Number maxValue;
    private final Number minValue;
    private final String name;
    private final List<ApplicationCommandOption> options;
    private final boolean required;
    private final ApplicationCommandType type;

    public ApplicationCommandOption(ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List<Integer> list, List<CommandChoice> list2, List<ApplicationCommandOption> list3, boolean z4, Number number, Number number2) {
        Intrinsics3.checkNotNullParameter(applicationCommandType, "type");
        Intrinsics3.checkNotNullParameter(str, ModelAuditLogEntry.CHANGE_KEY_NAME);
        this.type = applicationCommandType;
        this.name = str;
        this.description = str2;
        this.descriptionRes = num;
        this.required = z2;
        this.default = z3;
        this.channelTypes = list;
        this.choices = list2;
        this.options = list3;
        this.autocomplete = z4;
        this.minValue = number;
        this.maxValue = number2;
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final ApplicationCommandType getType() {
        return this.type;
    }

    /* JADX INFO: renamed from: component10, reason: from getter */
    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    /* JADX INFO: renamed from: component11, reason: from getter */
    public final Number getMinValue() {
        return this.minValue;
    }

    /* JADX INFO: renamed from: component12, reason: from getter */
    public final Number getMaxValue() {
        return this.maxValue;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDescription() {
        return this.description;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    /* JADX INFO: renamed from: component5, reason: from getter */
    public final boolean getRequired() {
        return this.required;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final boolean getDefault() {
        return this.default;
    }

    public final List<Integer> component7() {
        return this.channelTypes;
    }

    public final List<CommandChoice> component8() {
        return this.choices;
    }

    public final List<ApplicationCommandOption> component9() {
        return this.options;
    }

    public final ApplicationCommandOption copy(ApplicationCommandType type, String name, String description, Integer descriptionRes, boolean required, boolean z2, List<Integer> channelTypes, List<CommandChoice> choices, List<ApplicationCommandOption> options, boolean autocomplete, Number minValue, Number maxValue) {
        Intrinsics3.checkNotNullParameter(type, "type");
        Intrinsics3.checkNotNullParameter(name, ModelAuditLogEntry.CHANGE_KEY_NAME);
        return new ApplicationCommandOption(type, name, description, descriptionRes, required, z2, channelTypes, choices, options, autocomplete, minValue, maxValue);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ApplicationCommandOption)) {
            return false;
        }
        ApplicationCommandOption applicationCommandOption = (ApplicationCommandOption) other;
        return Intrinsics3.areEqual(this.type, applicationCommandOption.type) && Intrinsics3.areEqual(this.name, applicationCommandOption.name) && Intrinsics3.areEqual(this.description, applicationCommandOption.description) && Intrinsics3.areEqual(this.descriptionRes, applicationCommandOption.descriptionRes) && this.required == applicationCommandOption.required && this.default == applicationCommandOption.default && Intrinsics3.areEqual(this.channelTypes, applicationCommandOption.channelTypes) && Intrinsics3.areEqual(this.choices, applicationCommandOption.choices) && Intrinsics3.areEqual(this.options, applicationCommandOption.options) && this.autocomplete == applicationCommandOption.autocomplete && Intrinsics3.areEqual(this.minValue, applicationCommandOption.minValue) && Intrinsics3.areEqual(this.maxValue, applicationCommandOption.maxValue);
    }

    public final boolean getAutocomplete() {
        return this.autocomplete;
    }

    public final List<Integer> getChannelTypes() {
        return this.channelTypes;
    }

    public final List<CommandChoice> getChoices() {
        return this.choices;
    }

    public final boolean getDefault() {
        return this.default;
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getDescriptionRes() {
        return this.descriptionRes;
    }

    public final Number getMaxValue() {
        return this.maxValue;
    }

    public final Number getMinValue() {
        return this.minValue;
    }

    public final String getName() {
        return this.name;
    }

    public final List<ApplicationCommandOption> getOptions() {
        return this.options;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public final ApplicationCommandType getType() {
        return this.type;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12, types: [int] */
    /* JADX WARN: Type inference failed for: r2v31 */
    /* JADX WARN: Type inference failed for: r2v32 */
    /* JADX WARN: Type inference failed for: r2v36 */
    /* JADX WARN: Type inference failed for: r2v37 */
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
        Integer num = this.descriptionRes;
        int iHashCode4 = (iHashCode3 + (num != null ? num.hashCode() : 0)) * 31;
        boolean z2 = this.required;
        ?? r2 = z2;
        if (z2) {
            r2 = 1;
        }
        int i = (iHashCode4 + r2) * 31;
        boolean z3 = this.default;
        ?? r3 = z3;
        if (z3) {
            r3 = 1;
        }
        int i2 = (i + r3) * 31;
        List<Integer> list = this.channelTypes;
        int iHashCode5 = (i2 + (list != null ? list.hashCode() : 0)) * 31;
        List<CommandChoice> list2 = this.choices;
        int iHashCode6 = (iHashCode5 + (list2 != null ? list2.hashCode() : 0)) * 31;
        List<ApplicationCommandOption> list3 = this.options;
        int iHashCode7 = (iHashCode6 + (list3 != null ? list3.hashCode() : 0)) * 31;
        boolean z4 = this.autocomplete;
        int i3 = (iHashCode7 + (z4 ? 1 : z4)) * 31;
        Number number = this.minValue;
        int iHashCode8 = (i3 + (number != null ? number.hashCode() : 0)) * 31;
        Number number2 = this.maxValue;
        return iHashCode8 + (number2 != null ? number2.hashCode() : 0);
    }

    public String toString() {
        StringBuilder sbU = outline.U("ApplicationCommandOption(type=");
        sbU.append(this.type);
        sbU.append(", name=");
        sbU.append(this.name);
        sbU.append(", description=");
        sbU.append(this.description);
        sbU.append(", descriptionRes=");
        sbU.append(this.descriptionRes);
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

    public /* synthetic */ ApplicationCommandOption(ApplicationCommandType applicationCommandType, String str, String str2, Integer num, boolean z2, boolean z3, List list, List list2, List list3, boolean z4, Number number, Number number2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(applicationCommandType, str, (i & 4) != 0 ? null : str2, (i & 8) != 0 ? null : num, z2, z3, (i & 64) != 0 ? Collections2.emptyList() : list, (i & 128) != 0 ? null : list2, (i & 256) != 0 ? null : list3, (i & 512) != 0 ? false : z4, (i & 1024) != 0 ? null : number, (i & 2048) != 0 ? null : number2);
    }
}
