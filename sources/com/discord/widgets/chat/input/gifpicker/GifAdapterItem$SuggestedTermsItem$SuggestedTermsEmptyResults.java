package com.discord.widgets.chat.input.gifpicker;

import b.d.b.a.a;
import d0.z.d.m;
import java.util.List;

/* JADX INFO: compiled from: GifAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public final /* data */ class GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults extends GifAdapterItem$SuggestedTermsItem {
    private final List<String> terms;
    private final int titleResId;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults(List<String> list, int i) {
        super(list, GifAdapterItem$ViewType.VIEW_TYPE_GIF_SEARCH_TERMS_EMPTY_RESULTS, i, null);
        m.checkNotNullParameter(list, "terms");
        this.terms = list;
        this.titleResId = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults copy$default(GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults, List list, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            list = gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults.getTerms();
        }
        if ((i2 & 2) != 0) {
            i = gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults.getTitleResId();
        }
        return gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults.copy(list, i);
    }

    public final List<String> component1() {
        return getTerms();
    }

    public final int component2() {
        return getTitleResId();
    }

    public final GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults copy(List<String> terms, int titleResId) {
        m.checkNotNullParameter(terms, "terms");
        return new GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults(terms, titleResId);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults)) {
            return false;
        }
        GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults = (GifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults) other;
        return m.areEqual(getTerms(), gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults.getTerms()) && getTitleResId() == gifAdapterItem$SuggestedTermsItem$SuggestedTermsEmptyResults.getTitleResId();
    }

    @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem$SuggestedTermsItem
    public List<String> getTerms() {
        return this.terms;
    }

    @Override // com.discord.widgets.chat.input.gifpicker.GifAdapterItem$SuggestedTermsItem
    public int getTitleResId() {
        return this.titleResId;
    }

    public int hashCode() {
        List<String> terms = getTerms();
        return getTitleResId() + ((terms != null ? terms.hashCode() : 0) * 31);
    }

    public String toString() {
        StringBuilder sbU = a.U("SuggestedTermsEmptyResults(terms=");
        sbU.append(getTerms());
        sbU.append(", titleResId=");
        sbU.append(getTitleResId());
        sbU.append(")");
        return sbU.toString();
    }
}
