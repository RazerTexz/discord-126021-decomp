package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import com.discord.models.hubs.DirectoryEntryCategory$Companion;
import d0.z.d.m;
import d0.z.d.o;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$selectorArgs$1 extends o implements Function1<HubDescriptionState, List<? extends RadioSelectorItem>> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$selectorArgs$1(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ List<? extends RadioSelectorItem> invoke(HubDescriptionState hubDescriptionState) {
        return invoke2(hubDescriptionState);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<RadioSelectorItem> invoke2(HubDescriptionState hubDescriptionState) {
        m.checkNotNullParameter(hubDescriptionState, "state");
        DirectoryEntryCategory$Companion directoryEntryCategory$Companion = DirectoryEntryCategory.Companion;
        Channel channel = hubDescriptionState.getChannel();
        List<DirectoryEntryCategory> categories = directoryEntryCategory$Companion.getCategories(channel != null && ChannelUtils.x(channel));
        ArrayList arrayList = new ArrayList(d0.t.o.collectionSizeOrDefault(categories, 10));
        for (DirectoryEntryCategory directoryEntryCategory : categories) {
            int key = directoryEntryCategory.getKey();
            DirectoryEntryCategory category = this.this$0.getViewModel().getCategory();
            arrayList.add(new RadioSelectorItem(key, directoryEntryCategory.getTitle(this.this$0.requireContext()), category != null && category.getKey() == directoryEntryCategory.getKey()));
        }
        return arrayList;
    }
}
