package com.discord.widgets.servers.settings.members;

import d0.g0.t;
import d0.z.d.m;
import java.util.Comparator;

/* JADX INFO: compiled from: WidgetServerSettingsMembersModel.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1<T> implements Comparator<WidgetServerSettingsMembersModel$MemberItem> {
    public static final WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1 INSTANCE = new WidgetServerSettingsMembersModel$Companion$sortMembersComparator$1();

    @Override // java.util.Comparator
    public /* bridge */ /* synthetic */ int compare(WidgetServerSettingsMembersModel$MemberItem widgetServerSettingsMembersModel$MemberItem, WidgetServerSettingsMembersModel$MemberItem widgetServerSettingsMembersModel$MemberItem2) {
        return compare2(widgetServerSettingsMembersModel$MemberItem, widgetServerSettingsMembersModel$MemberItem2);
    }

    /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
    public final int compare2(WidgetServerSettingsMembersModel$MemberItem widgetServerSettingsMembersModel$MemberItem, WidgetServerSettingsMembersModel$MemberItem widgetServerSettingsMembersModel$MemberItem2) {
        m.checkNotNullParameter(widgetServerSettingsMembersModel$MemberItem, "member1");
        m.checkNotNullParameter(widgetServerSettingsMembersModel$MemberItem2, "member2");
        int iCompareTo = t.compareTo(widgetServerSettingsMembersModel$MemberItem.getUserDisplayName(), widgetServerSettingsMembersModel$MemberItem2.getUserDisplayName(), true);
        return iCompareTo != 0 ? iCompareTo : (widgetServerSettingsMembersModel$MemberItem.getUser().getId() > widgetServerSettingsMembersModel$MemberItem2.getUser().getId() ? 1 : (widgetServerSettingsMembersModel$MemberItem.getUser().getId() == widgetServerSettingsMembersModel$MemberItem2.getUser().getId() ? 0 : -1));
    }
}
