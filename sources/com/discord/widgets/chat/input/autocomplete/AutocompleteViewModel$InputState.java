package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.models.commands.ApplicationCommand;
import com.discord.models.commands.ApplicationCommandOption;
import d0.t.h0;
import d0.z.d.m;
import java.util.HashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewModel$InputState {
    private Map<Long, Integer> applicationsPosition;
    private final CharSequence currentInput;
    private final Map<IntRange, Autocompletable> inputAutocompleteMap;
    private final ApplicationCommand selectedCommand;
    private final ApplicationCommandOption showErrorForOption;

    public AutocompleteViewModel$InputState() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteViewModel$InputState(CharSequence charSequence, ApplicationCommand applicationCommand, Map<Long, Integer> map, ApplicationCommandOption applicationCommandOption, Map<IntRange, ? extends Autocompletable> map2) {
        m.checkNotNullParameter(charSequence, "currentInput");
        m.checkNotNullParameter(map, "applicationsPosition");
        m.checkNotNullParameter(map2, "inputAutocompleteMap");
        this.currentInput = charSequence;
        this.selectedCommand = applicationCommand;
        this.applicationsPosition = map;
        this.showErrorForOption = applicationCommandOption;
        this.inputAutocompleteMap = map2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteViewModel$InputState copy$default(AutocompleteViewModel$InputState autocompleteViewModel$InputState, CharSequence charSequence, ApplicationCommand applicationCommand, Map map, ApplicationCommandOption applicationCommandOption, Map map2, int i, Object obj) {
        if ((i & 1) != 0) {
            charSequence = autocompleteViewModel$InputState.currentInput;
        }
        if ((i & 2) != 0) {
            applicationCommand = autocompleteViewModel$InputState.selectedCommand;
        }
        ApplicationCommand applicationCommand2 = applicationCommand;
        if ((i & 4) != 0) {
            map = autocompleteViewModel$InputState.applicationsPosition;
        }
        Map map3 = map;
        if ((i & 8) != 0) {
            applicationCommandOption = autocompleteViewModel$InputState.showErrorForOption;
        }
        ApplicationCommandOption applicationCommandOption2 = applicationCommandOption;
        if ((i & 16) != 0) {
            map2 = autocompleteViewModel$InputState.inputAutocompleteMap;
        }
        return autocompleteViewModel$InputState.copy(charSequence, applicationCommand2, map3, applicationCommandOption2, map2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final CharSequence getCurrentInput() {
        return this.currentInput;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public final Map<Long, Integer> component3() {
        return this.applicationsPosition;
    }

    /* JADX INFO: renamed from: component4, reason: from getter */
    public final ApplicationCommandOption getShowErrorForOption() {
        return this.showErrorForOption;
    }

    public final Map<IntRange, Autocompletable> component5() {
        return this.inputAutocompleteMap;
    }

    public final AutocompleteViewModel$InputState copy(CharSequence currentInput, ApplicationCommand selectedCommand, Map<Long, Integer> applicationsPosition, ApplicationCommandOption showErrorForOption, Map<IntRange, ? extends Autocompletable> inputAutocompleteMap) {
        m.checkNotNullParameter(currentInput, "currentInput");
        m.checkNotNullParameter(applicationsPosition, "applicationsPosition");
        m.checkNotNullParameter(inputAutocompleteMap, "inputAutocompleteMap");
        return new AutocompleteViewModel$InputState(currentInput, selectedCommand, applicationsPosition, showErrorForOption, inputAutocompleteMap);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewModel$InputState)) {
            return false;
        }
        AutocompleteViewModel$InputState autocompleteViewModel$InputState = (AutocompleteViewModel$InputState) other;
        return m.areEqual(this.currentInput, autocompleteViewModel$InputState.currentInput) && m.areEqual(this.selectedCommand, autocompleteViewModel$InputState.selectedCommand) && m.areEqual(this.applicationsPosition, autocompleteViewModel$InputState.applicationsPosition) && m.areEqual(this.showErrorForOption, autocompleteViewModel$InputState.showErrorForOption) && m.areEqual(this.inputAutocompleteMap, autocompleteViewModel$InputState.inputAutocompleteMap);
    }

    public final Map<Long, Integer> getApplicationsPosition() {
        return this.applicationsPosition;
    }

    public final CharSequence getCurrentInput() {
        return this.currentInput;
    }

    public final Map<IntRange, Autocompletable> getInputAutocompleteMap() {
        return this.inputAutocompleteMap;
    }

    public final ApplicationCommand getSelectedCommand() {
        return this.selectedCommand;
    }

    public final ApplicationCommandOption getShowErrorForOption() {
        return this.showErrorForOption;
    }

    public int hashCode() {
        CharSequence charSequence = this.currentInput;
        int iHashCode = (charSequence != null ? charSequence.hashCode() : 0) * 31;
        ApplicationCommand applicationCommand = this.selectedCommand;
        int iHashCode2 = (iHashCode + (applicationCommand != null ? applicationCommand.hashCode() : 0)) * 31;
        Map<Long, Integer> map = this.applicationsPosition;
        int iHashCode3 = (iHashCode2 + (map != null ? map.hashCode() : 0)) * 31;
        ApplicationCommandOption applicationCommandOption = this.showErrorForOption;
        int iHashCode4 = (iHashCode3 + (applicationCommandOption != null ? applicationCommandOption.hashCode() : 0)) * 31;
        Map<IntRange, Autocompletable> map2 = this.inputAutocompleteMap;
        return iHashCode4 + (map2 != null ? map2.hashCode() : 0);
    }

    public final void setApplicationsPosition(Map<Long, Integer> map) {
        m.checkNotNullParameter(map, "<set-?>");
        this.applicationsPosition = map;
    }

    public String toString() {
        StringBuilder sbU = a.U("InputState(currentInput=");
        sbU.append(this.currentInput);
        sbU.append(", selectedCommand=");
        sbU.append(this.selectedCommand);
        sbU.append(", applicationsPosition=");
        sbU.append(this.applicationsPosition);
        sbU.append(", showErrorForOption=");
        sbU.append(this.showErrorForOption);
        sbU.append(", inputAutocompleteMap=");
        return a.M(sbU, this.inputAutocompleteMap, ")");
    }

    public /* synthetic */ AutocompleteViewModel$InputState(String str, ApplicationCommand applicationCommand, Map map, ApplicationCommandOption applicationCommandOption, Map map2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? null : applicationCommand, (i & 4) != 0 ? new HashMap() : map, (i & 8) == 0 ? applicationCommandOption : null, (i & 16) != 0 ? h0.emptyMap() : map2);
    }
}
