package com.discord.widgets.hubs;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.hubs.DirectoryEntryCategory;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import p507d0.p580t.C12149o;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: compiled from: WidgetHubDescription.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class WidgetHubDescription$selectorArgs$1 extends AbstractC12240o implements Function1<HubDescriptionState, List<? extends RadioSelectorItem>> {
    public final /* synthetic */ WidgetHubDescription this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WidgetHubDescription$selectorArgs$1(WidgetHubDescription widgetHubDescription) {
        super(1);
        this.this$0 = widgetHubDescription;
    }

    @Override // kotlin.jvm.functions.Function1
    public final List<RadioSelectorItem> invoke(HubDescriptionState hubDescriptionState) {
        C12238m.checkNotNullParameter(hubDescriptionState, "state");
        DirectoryEntryCategory.Companion companion = DirectoryEntryCategory.INSTANCE;
        Channel channel = hubDescriptionState.getChannel();
        List<DirectoryEntryCategory> categories = companion.getCategories(channel != null && ChannelUtils.m7700x(channel));
        ArrayList arrayList = new ArrayList(C12149o.collectionSizeOrDefault(categories, 10));
        for (DirectoryEntryCategory directoryEntryCategory : categories) {
            int key = directoryEntryCategory.getKey();
            DirectoryEntryCategory category = this.this$0.getViewModel().getCategory();
            arrayList.add(new RadioSelectorItem(key, directoryEntryCategory.getTitle(this.this$0.requireContext()), category != null && category.getKey() == directoryEntryCategory.getKey()));
        }
        return arrayList;
    }
}
