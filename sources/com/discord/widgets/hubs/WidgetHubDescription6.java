package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import d0.t.Iterables2;
import d0.z.d.Intrinsics3;
import d0.z.d.Lambda;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;

/* JADX INFO: renamed from: com.discord.widgets.hubs.WidgetHubDescription$selectorArgs$1, reason: use source file name */
/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription6 extends Lambda implements Function1<WidgetHubDescriptionViewModel3, List<? extends WidgetRadioSelectorBottomSheet2>> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription6(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<WidgetRadioSelectorBottomSheet2> invoke(WidgetHubDescriptionViewModel3 widgetHubDescriptionViewModel3) {
        Intrinsics3.checkNotNullParameter(widgetHubDescriptionViewModel3, "state");
        DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
        Channel channel = widgetHubDescriptionViewModel3.getChannel();
        List<DirectoryEntryCategory> categories = companion.getCategories(channel != null && ChannelUtils.x(channel));
        ArrayList arrayList = new ArrayList(Iterables2.collectionSizeOrDefault(categories, 10));
        for (DirectoryEntryCategory directoryEntryCategory : categories) {
            int key = directoryEntryCategory.getKey();
            DirectoryEntryCategory category = this.this$0.getViewModel().getCategory();
            arrayList.add(new WidgetRadioSelectorBottomSheet2(key, directoryEntryCategory.getTitle(this.this$0.requireContext()), category != null && category.getKey() == directoryEntryCategory.getKey()));
        }
        return arrayList;
    }
}
