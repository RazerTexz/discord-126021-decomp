package com.discord.widgets.forums;

import com.discord.utilities.mg_recycler.MGRecyclerDataPayload;
import d0.g;
import kotlin.Lazy;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: ForumBrowserItem.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ForumBrowserItem implements MGRecyclerDataPayload {
    public static final int TYPE_HEADER = 0;
    public static final int TYPE_LOADING = 2;
    public static final int TYPE_POST = 1;
    private final String key;
    private final int type;
    public static final ForumBrowserItem$Companion Companion = new ForumBrowserItem$Companion(null);
    private static final Lazy postItemComparatorByMostRecent$delegate = g.lazy(ForumBrowserItem$Companion$postItemComparatorByMostRecent$2.INSTANCE);

    private ForumBrowserItem(String str, int i) {
        this.key = str;
        this.type = i;
    }

    public static final /* synthetic */ Lazy access$getPostItemComparatorByMostRecent$cp() {
        return postItemComparatorByMostRecent$delegate;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload, com.discord.utilities.recycler.DiffKeyProvider
    public String getKey() {
        return this.key;
    }

    @Override // com.discord.utilities.mg_recycler.MGRecyclerDataPayload
    public int getType() {
        return this.type;
    }

    public /* synthetic */ ForumBrowserItem(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i);
    }
}
