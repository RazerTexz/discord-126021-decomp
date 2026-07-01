package com.discord.widgets.channels.threads.browser;

import com.discord.stores.ArchivedThreadsStore$ThreadListingType;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetThreadBrowserArchivedViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        WidgetThreadBrowserArchivedViewModel$VisibilityMode.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        iArr[WidgetThreadBrowserArchivedViewModel$VisibilityMode.PublicThreads.ordinal()] = 1;
        iArr[WidgetThreadBrowserArchivedViewModel$VisibilityMode.PrivateThreads.ordinal()] = 2;
        ArchivedThreadsStore$ThreadListingType.values();
        int[] iArr2 = new int[3];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[ArchivedThreadsStore$ThreadListingType.ALL_ARCHIVED_PUBLIC_THREADS.ordinal()] = 1;
        iArr2[ArchivedThreadsStore$ThreadListingType.MY_ARCHIVED_PRIVATE_THREADS.ordinal()] = 2;
        iArr2[ArchivedThreadsStore$ThreadListingType.ALL_ARCHIVED_PRIVATE_THREADS.ordinal()] = 3;
    }
}
