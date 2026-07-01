package com.discord.widgets.channels.threads.browser;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class ThreadBrowserThreadView$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;

    static {
        ThreadBrowserThreadView$TimestampMode.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        ThreadBrowserThreadView$TimestampMode threadBrowserThreadView$TimestampMode = ThreadBrowserThreadView$TimestampMode.ArchivedAt;
        iArr[threadBrowserThreadView$TimestampMode.ordinal()] = 1;
        ThreadBrowserThreadView$TimestampMode threadBrowserThreadView$TimestampMode2 = ThreadBrowserThreadView$TimestampMode.CreatedAt;
        iArr[threadBrowserThreadView$TimestampMode2.ordinal()] = 2;
        ThreadBrowserThreadView$TimestampMode.values();
        int[] iArr2 = new int[2];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[threadBrowserThreadView$TimestampMode.ordinal()] = 1;
        iArr2[threadBrowserThreadView$TimestampMode2.ordinal()] = 2;
    }
}
