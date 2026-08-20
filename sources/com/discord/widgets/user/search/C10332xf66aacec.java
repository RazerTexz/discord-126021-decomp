package com.discord.widgets.user.search;

import com.discord.api.channel.Channel;
import com.discord.api.channel.ChannelUtils;
import com.discord.models.user.User;
import java.util.HashSet;
import kotlin.jvm.functions.Function1;
import p007b.p100d.p104b.p105a.C1643a;
import p507d0.p592z.p594d.AbstractC12240o;
import p507d0.p592z.p594d.C12238m;

/* JADX INFO: renamed from: com.discord.widgets.user.search.WidgetGlobalSearchModel$Companion$create$filteredResults$channelResults$2 */
/* JADX INFO: compiled from: WidgetGlobalSearchModel.kt */
/* JADX INFO: loaded from: classes.dex */
public final class C10332xf66aacec extends AbstractC12240o implements Function1<Channel, WidgetGlobalSearchModel.ItemDataPayload> {
    public final /* synthetic */ String $sanitizedFilter;
    public final /* synthetic */ HashSet $seenUsersIds;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$4 $toItemChannel$4;
    public final /* synthetic */ WidgetGlobalSearchModel$Companion$create$2 $toItemUser$2;
    public final /* synthetic */ WidgetGlobalSearchModel.UsersContext $usersContext;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C10332xf66aacec(HashSet hashSet, WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2, WidgetGlobalSearchModel.UsersContext usersContext, String str, WidgetGlobalSearchModel$Companion$create$4 widgetGlobalSearchModel$Companion$create$4) {
        super(1);
        this.$seenUsersIds = hashSet;
        this.$toItemUser$2 = widgetGlobalSearchModel$Companion$create$2;
        this.$usersContext = usersContext;
        this.$sanitizedFilter = str;
        this.$toItemChannel$4 = widgetGlobalSearchModel$Companion$create$4;
    }

    @Override // kotlin.jvm.functions.Function1
    public final WidgetGlobalSearchModel.ItemDataPayload invoke(Channel channel) {
        C12238m.checkNotNullParameter(channel, "channel");
        User userM7677a = ChannelUtils.m7677a(channel);
        if (userM7677a != null) {
            this.$seenUsersIds.add(Long.valueOf(userM7677a.getId()));
            WidgetGlobalSearchModel$Companion$create$2 widgetGlobalSearchModel$Companion$create$2 = this.$toItemUser$2;
            User user = (User) C1643a.m849f(userM7677a, this.$usersContext.getUsers());
            if (user != null) {
                userM7677a = user;
            }
            WidgetGlobalSearchModel.ItemUser itemUserInvoke = widgetGlobalSearchModel$Companion$create$2.invoke(userM7677a, this.$sanitizedFilter, channel);
            if (itemUserInvoke != null) {
                return itemUserInvoke;
            }
        }
        return this.$toItemChannel$4.invoke(channel, this.$sanitizedFilter);
    }
}
