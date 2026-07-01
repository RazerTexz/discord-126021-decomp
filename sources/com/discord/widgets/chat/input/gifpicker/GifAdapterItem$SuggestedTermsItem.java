package com.discord.widgets.chat.input.gifpicker;

import androidx.annotation.StringRes;
import d0.t.u;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: GifAdapterItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class GifAdapterItem$SuggestedTermsItem extends GifAdapterItem {
    private final List<String> terms;
    private final int titleResId;
    private final GifAdapterItem$ViewType viewType;

    public /* synthetic */ GifAdapterItem$SuggestedTermsItem(List list, GifAdapterItem$ViewType gifAdapterItem$ViewType, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, gifAdapterItem$ViewType, i);
    }

    @Override // com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return String.valueOf((u.joinToString$default(getTerms(), null, null, null, 0, null, null, 63, null) + getTitleResId()).hashCode());
    }

    public List<String> getTerms() {
        return this.terms;
    }

    public int getTitleResId() {
        return this.titleResId;
    }

    public final GifAdapterItem$ViewType getViewType() {
        return this.viewType;
    }

    private GifAdapterItem$SuggestedTermsItem(List<String> list, GifAdapterItem$ViewType gifAdapterItem$ViewType, @StringRes int i) {
        super(gifAdapterItem$ViewType, null);
        this.terms = list;
        this.viewType = gifAdapterItem$ViewType;
        this.titleResId = i;
    }
}
