package com.discord.widgets.chat.input.autocomplete;

import b.d.b.a.a;
import com.discord.widgets.chat.input.AutocompleteStickerItem;
import d0.z.d.m;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: AutocompleteViewModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class AutocompleteViewState$Autocomplete extends AutocompleteViewState {
    private final List<Autocompletable> autocompletables;
    private final boolean isAutocomplete;
    private final boolean isError;
    private final boolean isLoading;
    private final List<AutocompleteStickerItem> stickers;
    private final String token;

    public /* synthetic */ AutocompleteViewState$Autocomplete(boolean z2, boolean z3, boolean z4, List list, List list2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z2, (i & 2) != 0 ? false : z3, (i & 4) != 0 ? false : z4, list, list2, str);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ AutocompleteViewState$Autocomplete copy$default(AutocompleteViewState$Autocomplete autocompleteViewState$Autocomplete, boolean z2, boolean z3, boolean z4, List list, List list2, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            z2 = autocompleteViewState$Autocomplete.isLoading;
        }
        if ((i & 2) != 0) {
            z3 = autocompleteViewState$Autocomplete.isError;
        }
        boolean z5 = z3;
        if ((i & 4) != 0) {
            z4 = autocompleteViewState$Autocomplete.isAutocomplete;
        }
        boolean z6 = z4;
        if ((i & 8) != 0) {
            list = autocompleteViewState$Autocomplete.autocompletables;
        }
        List list3 = list;
        if ((i & 16) != 0) {
            list2 = autocompleteViewState$Autocomplete.stickers;
        }
        List list4 = list2;
        if ((i & 32) != 0) {
            str = autocompleteViewState$Autocomplete.token;
        }
        return autocompleteViewState$Autocomplete.copy(z2, z5, z6, list3, list4, str);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final boolean getIsError() {
        return this.isError;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final boolean getIsAutocomplete() {
        return this.isAutocomplete;
    }

    public final List<Autocompletable> component4() {
        return this.autocompletables;
    }

    public final List<AutocompleteStickerItem> component5() {
        return this.stickers;
    }

    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getToken() {
        return this.token;
    }

    public final AutocompleteViewState$Autocomplete copy(boolean isLoading, boolean isError, boolean isAutocomplete, List<? extends Autocompletable> autocompletables, List<AutocompleteStickerItem> stickers, String token) {
        m.checkNotNullParameter(autocompletables, "autocompletables");
        m.checkNotNullParameter(stickers, "stickers");
        m.checkNotNullParameter(token, "token");
        return new AutocompleteViewState$Autocomplete(isLoading, isError, isAutocomplete, autocompletables, stickers, token);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AutocompleteViewState$Autocomplete)) {
            return false;
        }
        AutocompleteViewState$Autocomplete autocompleteViewState$Autocomplete = (AutocompleteViewState$Autocomplete) other;
        return this.isLoading == autocompleteViewState$Autocomplete.isLoading && this.isError == autocompleteViewState$Autocomplete.isError && this.isAutocomplete == autocompleteViewState$Autocomplete.isAutocomplete && m.areEqual(this.autocompletables, autocompleteViewState$Autocomplete.autocompletables) && m.areEqual(this.stickers, autocompleteViewState$Autocomplete.stickers) && m.areEqual(this.token, autocompleteViewState$Autocomplete.token);
    }

    public final List<Autocompletable> getAutocompletables() {
        return this.autocompletables;
    }

    public final List<AutocompleteStickerItem> getStickers() {
        return this.stickers;
    }

    public final String getToken() {
        return this.token;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [int] */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v3, types: [int] */
    /* JADX WARN: Type inference failed for: r0v5, types: [int] */
    /* JADX WARN: Type inference failed for: r1v0 */
    /* JADX WARN: Type inference failed for: r1v1, types: [int] */
    /* JADX WARN: Type inference failed for: r1v11 */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r2v7 */
    public int hashCode() {
        boolean z2 = this.isLoading;
        ?? r0 = z2;
        if (z2) {
            r0 = 1;
        }
        int i = r0 * 31;
        boolean z3 = this.isError;
        ?? r2 = z3;
        if (z3) {
            r2 = 1;
        }
        int i2 = (i + r2) * 31;
        boolean z4 = this.isAutocomplete;
        int i3 = (i2 + (z4 ? 1 : z4)) * 31;
        List<Autocompletable> list = this.autocompletables;
        int iHashCode = (i3 + (list != null ? list.hashCode() : 0)) * 31;
        List<AutocompleteStickerItem> list2 = this.stickers;
        int iHashCode2 = (iHashCode + (list2 != null ? list2.hashCode() : 0)) * 31;
        String str = this.token;
        return iHashCode2 + (str != null ? str.hashCode() : 0);
    }

    public final boolean isAutocomplete() {
        return this.isAutocomplete;
    }

    public final boolean isError() {
        return this.isError;
    }

    public final boolean isLoading() {
        return this.isLoading;
    }

    public String toString() {
        StringBuilder sbU = a.U("Autocomplete(isLoading=");
        sbU.append(this.isLoading);
        sbU.append(", isError=");
        sbU.append(this.isError);
        sbU.append(", isAutocomplete=");
        sbU.append(this.isAutocomplete);
        sbU.append(", autocompletables=");
        sbU.append(this.autocompletables);
        sbU.append(", stickers=");
        sbU.append(this.stickers);
        sbU.append(", token=");
        return a.J(sbU, this.token, ")");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public AutocompleteViewState$Autocomplete(boolean z2, boolean z3, boolean z4, List<? extends Autocompletable> list, List<AutocompleteStickerItem> list2, String str) {
        super(null);
        m.checkNotNullParameter(list, "autocompletables");
        m.checkNotNullParameter(list2, "stickers");
        m.checkNotNullParameter(str, "token");
        this.isLoading = z2;
        this.isError = z3;
        this.isAutocomplete = z4;
        this.autocompletables = list;
        this.stickers = list2;
        this.token = str;
    }
}
