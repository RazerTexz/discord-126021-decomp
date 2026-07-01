package com.discord.widgets.contact_sync;


/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class WidgetContactSyncViewModel$WhenMappings {
    public static final /* synthetic */ int[] $EnumSwitchMapping$0;
    public static final /* synthetic */ int[] $EnumSwitchMapping$1;
    public static final /* synthetic */ int[] $EnumSwitchMapping$2;

    static {
        ContactSyncMode.values();
        int[] iArr = new int[2];
        $EnumSwitchMapping$0 = iArr;
        ContactSyncMode contactSyncMode = ContactSyncMode.ONBOARDING;
        iArr[contactSyncMode.ordinal()] = 1;
        ContactSyncMode contactSyncMode2 = ContactSyncMode.DEFAULT;
        iArr[contactSyncMode2.ordinal()] = 2;
        WidgetContactSyncViewModel$Views.values();
        int[] iArr2 = new int[6];
        $EnumSwitchMapping$1 = iArr2;
        iArr2[WidgetContactSyncViewModel$Views.VIEW_LANDING.ordinal()] = 1;
        iArr2[WidgetContactSyncViewModel$Views.VIEW_NAME_INPUT.ordinal()] = 2;
        iArr2[WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS.ordinal()] = 3;
        iArr2[WidgetContactSyncViewModel$Views.VIEW_SUGGESTIONS_EMPTY.ordinal()] = 4;
        iArr2[WidgetContactSyncViewModel$Views.VIEW_ADD_PHONE.ordinal()] = 5;
        iArr2[WidgetContactSyncViewModel$Views.VIEW_VERIFY_PHONE.ordinal()] = 6;
        ContactSyncMode.values();
        int[] iArr3 = new int[2];
        $EnumSwitchMapping$2 = iArr3;
        iArr3[contactSyncMode.ordinal()] = 1;
        iArr3[contactSyncMode2.ordinal()] = 2;
    }
}
